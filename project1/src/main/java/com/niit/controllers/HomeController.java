package com.niit.controllers;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.niit.service.CategoryService;

@Controller
public class HomeController {
	
	@Autowired
	private CategoryService categoryService;
	
	@RequestMapping("/home")
	public String homePage1(Model model){
		model.addAttribute("categories", categoryService.getAllCategories());
	return "home";
	}
	
	@RequestMapping("/")
	public String homePage2(Model model){
		model.addAttribute("categories", categoryService.getAllCategories());
	return "home";
	}
	@RequestMapping("/aboutus")
	public String aboutUs(){
	return "aboutus";
	}
	
	
	//for login the path is /login
	// for invalid username and password -/login?error
	// for logout- /login?logout
	@RequestMapping(value="/login")
	public String login(@RequestParam(value="error",required=false)String error,
			             @RequestParam(value="logout",required=false) String logout, Model model){
		System.out.println("in login");
		if(error!=null){
			model.addAttribute("error","Invalid Username and Password... Please enter valid username and password" );
			System.out.println("in login first");
		}
		if(logout!=null){
			model.addAttribute("logout", "Logout successfully");
			System.out.println("in login second");
		}
		return "login";
	}
}
