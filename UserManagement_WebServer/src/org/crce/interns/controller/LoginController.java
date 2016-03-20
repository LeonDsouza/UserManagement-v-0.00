/*
 * @author:Khussal 
 */



package org.crce.interns.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.validation.BindingResult;
//import org.springframework.validation.ObjectError;
import org.crce.interns.form.LoginForm;
import org.crce.interns.service.*;
import org.springframework.beans.factory.annotation.Autowired;


import java.util.Map;
import javax.validation.Valid;

@Controller
//@RequestMapping("loginform.html") 
public class LoginController {

	
	@Autowired
	public LoginService loginService;

	/*
	 * Task:Displays login form
	 * Return Type: String
	 */
	@RequestMapping(value="/login" , method = RequestMethod.GET)  //Put your mapping here
  	public String showForm(Map model) {
		LoginForm loginForm = new LoginForm();
		model.put("loginForm", loginForm);
		return "loginform";
	}

	
	/*
	 * Task: Role based Authentication
	 * Return Type: String
	 */
	@RequestMapping(value="/logged" ,method = RequestMethod.POST)
	public String processForm(@Valid LoginForm loginForm, BindingResult result,
			Map model) {

		
		/*if (result.hasErrors()) {
			return "loginform";
		}*/
		
		String role=loginService.checkLogin(loginForm.getUserName(),loginForm.getPassword());
		//System.out.println("ROLE:"+role);
		if(role.equals("Student")){
			model.put("loginForm", loginForm);
			return "Student";
		}
		else if(role.equals("StudentTPC"))
		{
			model.put("loginForm", loginForm);
			return "StudentTPC";
		}
		else if(role.equals("TPO"))
		{
			model.put("loginForm", loginForm);
			return "TPO";
		}
		else{
			result.rejectValue("userName","invaliduser");
			return "loginform";
		}
	}

}
