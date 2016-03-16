package org.crce.interns.controller;

import java.io.File;
import java.io.IOException;

import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.sun.xml.internal.messaging.saaj.packaging.mime.MessagingException;

@Controller
public class SendEmailController {

	@Autowired
	private JavaMailSender javaMailSender;

	
	public boolean checkFile(String name) {
		String path = "C:\\Users\\Leon\\Desktop\\Email_Temp";
		File folder = new File(path);
		File[] listOfFiles = folder.listFiles();
		for (int i=0;i<listOfFiles.length;i++) {
			System.out.println(listOfFiles[i].getName());
			if (listOfFiles[i].getName().equals(name))
				return true;
		}
		return false;
	}
	
	public void deleteFiles() {
		String path = "C:\\Users\\Leon\\Desktop\\Email_Temp";
		File folder = new File(path);
		File[] files = folder.listFiles();
		for (File f:files)
			f.delete();
	}
	
	@RequestMapping(value = "/SubmitEmail.html", method = RequestMethod.POST)
	public ModelAndView sendEmail(HttpServletRequest request,
			@RequestParam(value = "fileUpload") CommonsMultipartFile[] file) throws IllegalStateException, IOException {
		System.out.println(request.getParameter("message"));
		System.out.println(request.getParameter("subject"));
		System.out.println(request.getParameter("receiver"));

		String path = "C:\\Users\\Leon\\Desktop\\Email_Temp\\";
		if (file.length > 0 && file != null) {
			System.out.println("Inside If");
			for (CommonsMultipartFile f : file) {
				if (!f.getOriginalFilename().equals("")) {
					System.out.println(path + f.getOriginalFilename());
					f.transferTo(new File(path + f.getOriginalFilename()));
				}
			}
		}
		
		String input = request.getParameter("receiver");
		String[] emailIds = input.split(" ");
		
		javaMailSender.send(new MimeMessagePreparator() {
			public void prepare(MimeMessage mimeMessage)
					throws javax.mail.MessagingException, IllegalStateException, IOException {
				System.out.println("Throws Exception");
				MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true, "UTF-8");

				//mimeMessageHelper.setTo(request.getParameter("receiver"));

				mimeMessageHelper.setTo(emailIds);
				
				mimeMessageHelper.setSubject(request.getParameter("subject"));

				mimeMessageHelper.setText(request.getParameter("message"));

				for (CommonsMultipartFile f:file) {
					if (checkFile(f.getOriginalFilename()))
					mimeMessageHelper.addAttachment(f.getOriginalFilename(), new File(path+f.getOriginalFilename()));
				}
			}
		});
		
		
		deleteFiles();
		ModelAndView model = new ModelAndView("Result");
		return model;
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/sendMail.html")
	public ModelAndView email_welcome() {
		return new ModelAndView("EmailForm");
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/")
	public ModelAndView welcome() {
		return new ModelAndView("index");
	}
}
