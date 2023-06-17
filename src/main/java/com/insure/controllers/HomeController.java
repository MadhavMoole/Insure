package com.insure.controllers;

import java.util.ArrayList;

//import java.net.http.HttpResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.insure.base.Insurance;
import com.insure.base.User;
import com.insure.base.UserPolicy;
import com.insure.dao.InsureDAOImpl;

@Controller
@ComponentScan("com.insure.dao")
public class HomeController {
	
	@Autowired
	private InsureDAOImpl impl;
	
	@GetMapping("/")
	public String getHomePage() {
		return "home-page";
	}
	
	@GetMapping("/test")
	public String getSignPage(@ModelAttribute("user") User user) {
		return "Register";
	}
	
	@GetMapping("/log")
	public String getLoginPage(@ModelAttribute("user") User user) {
		return "Login";
	}
	
	//we use @RequestParam annotation to obtain the user details 
	@PostMapping("/validate")
	public String validate(@RequestParam("userName") String username, @RequestParam("password") String password, Model model) {
		ArrayList<UserPolicy> PolicyList = new ArrayList<>();
		String IsLogged = impl.validate(username, password);
		if(!IsLogged.equals("user")) return "Login";
		if(IsLogged.equals("admin")) return "admin-page";
		if(IsLogged.equals("user")) {
			PolicyList = impl.getData(username, password);	
		}
		model.addAttribute("UserPolicies", PolicyList);
		return "main-page"; 
	}
	
	//@ModelAttribute 
	@GetMapping("/signup")
	public String signUp(@ModelAttribute("user") User user, @ModelAttribute("List_of_Policy") Insurance insure) {
		impl.register(user);
		return "main-page";
	}
	
	
	@PostMapping("/policy-request")
	public String SelectPolicy() {
		return null;
	}
}
