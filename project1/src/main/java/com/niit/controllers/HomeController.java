package com.niit.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.niit.service.CategoryService;

@Controller
public class HomeController {
	@Autowired
	private CategoryService categoryService;
	@RequestMapping("/home")
	public String homePage(HttpSession session){
		session.setAttribute("categories", categoryService.getAllCategories());
	return "home";
	}
	
	@RequestMapping("/aboutus")
	public String aboutUs(){
	return "aboutus";
	}
	
	
	//for login the path is /login
	// for invalid username and password -/login?error
	// for logout- /login?logout
	@RequestMapping(value="/login",method = RequestMethod.POST)
	public String login(@RequestParam(value="error",required=false)String error,
			             @RequestParam(value="logout",required=false) String logout, Model model){
		if(error!=null)
			model.addAttribute("error","Invalid Username and Password... Please enter valid username and password" );
		if(logout!=null)
			model.addAttribute("logout", "Logout successfully");
		return "login";
	}
}
