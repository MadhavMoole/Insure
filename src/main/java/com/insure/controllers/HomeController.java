package com.insure.controllers;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

//import java.net.http.HttpResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.insure.base.Customer;
import com.insure.base.CustomerPolicy;
import com.insure.service.InsureServiceImpl;

@Controller
@ComponentScan("com.insure.service")
public class HomeController {
	
	@Autowired
	private InsureServiceImpl service;
	
	@GetMapping("/")
	public String getHomePage() {
		return "home-page";
	}
	
	@GetMapping("/SignIn")
	public String getSignUpPage(@ModelAttribute("Customer") Customer customer) {
		return "Register";
	}
	
	@GetMapping("/logOn")
	public String getLoginPage() {
		return "Login";
	}
	
	//we use @RequestParam annotation to obtain the user details 
	@PostMapping("/validate")
	public String login(@RequestParam("name") String name, @RequestParam("password") String password, HttpSession session) {
		session.setAttribute("name", name);
		session.setAttribute("password", password);
		if(name.equals("admin") && password.equals("adm123")) {
			return "admin-page";
		}
		return service.login(name, password);
	}
	
	//@ModelAttribute 
	@GetMapping("/signUp")
	public String signUp(@ModelAttribute("Customer") Customer customer, HttpSession session) {
		session.setAttribute("name", customer.getName());
		session.setAttribute("password", customer.getPassword());
		return service.register(customer);
	}
	
	
	@GetMapping("/policyRequest")
	public String SelectPolicy() {
		return "policy-apply";
	}
	
	@GetMapping("/addPolicy")
	public String addPolicy(@ModelAttribute("CustomerPol") CustomerPolicy customerPol, HttpSession session) {
		String name = (String) session.getAttribute("name");
		String password = (String) session.getAttribute("password");
		service.addData(customerPol, name, password);
		return "redirect:/main-page";
	}
	
	@GetMapping("/main-page")
	public String mainPage(HttpSession session, Model model) {
		String name = (String) session.getAttribute("name");
		String password = (String) session.getAttribute("password");
		ArrayList<CustomerPolicy> cp = service.getData(name, password);
		model.addAttribute("PolicyList", cp);
	    return "main-page";
	}
}
