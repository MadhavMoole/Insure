package com.insure.controllers;

import java.net.http.HttpResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.insure.base.User;
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
	
	//we use @RequestParam annotation to obtain the user details 
	@PostMapping("/validate")
	public String validate(@RequestParam("username") String username, @RequestParam("password") String password) {
		boolean IsLogged = impl.validate(username, password);
		return IsLogged ? "success" : "tryAgain";
	}
	
	//@ModelAttribute 
	@GetMapping("/signup")
	public String signUp(HttpRequest request , HttpResponse<User> response, @ModelAttribute("user") User user) {
		impl.register(user);
		return "main-page";
	}
}
