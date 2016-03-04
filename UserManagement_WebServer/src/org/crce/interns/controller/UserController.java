package org.crce.interns.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.crce.interns.beans.UserBean;
import org.crce.interns.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {

	@Autowired
	private UserService userService;
	
	@InitBinder
	public void initBinder(WebDataBinder webDataBinder) {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
		webDataBinder.registerCustomEditor(Date.class, "userDob", new CustomDateEditor(simpleDateFormat, false));
	}
	
	@RequestMapping("/")
	public ModelAndView welcome() {
		return new ModelAndView("index");
	}
	
	@RequestMapping("/ViewUsers")
	public ModelAndView viewUsers() {
		Map<String, Object> modelMap = new HashMap<String, Object>();
		modelMap.put("users", userService.viewUsers());
		return new ModelAndView("viewUser", modelMap);
	}
	
	@RequestMapping("/CreateUser")
	public ModelAndView createUserWelcome() {
		return new ModelAndView("createUser");
	}
	
	@RequestMapping(value = "/SubmitCreateUser", method = RequestMethod.POST)
	public ModelAndView createUser(@ModelAttribute("user")UserBean userBean, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			System.out.println("Binding Errors are present...");
			return new ModelAndView("createUser");
		}
		userService.createUser(userBean);
		return new ModelAndView("redirect:/ViewUsers");
	}
	
	@RequestMapping(name = "/SubmitDeleteUser", method = RequestMethod.GET)
	//public ModelAndView deleteUser(@RequestParam("rollNo") int rollNo) {
	public ModelAndView deleteUser(@ModelAttribute("command")UserBean userBean) {
		userService.deleteUser(userBean.getUserRollno());
		return new ModelAndView("redirect:/ViewUsers");
	}
	
	@RequestMapping("/EditUser")
	public ModelAndView editUser(@ModelAttribute("command")UserBean userBean) {
		Map<String, Object> modelMap = new HashMap<String, Object>();
		modelMap.put("user", userService.getUser(userBean.getUserRollno()));
		return new ModelAndView("createUser", modelMap);
	}
}
