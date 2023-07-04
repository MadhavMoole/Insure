package com.insure.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.insure.base.CustomerPolicy;
import com.insure.service.InsureServiceImpl;

@Controller
@ComponentScan("com.insure.service")
public class AdminController {

	@Autowired
	private InsureServiceImpl service;
	
	@GetMapping("/viewCustomers")
	public String getCustomerList(HttpSession session) {
		session.setAttribute("customers", service.getCustomerList());
		return "customer-list";
	}
	
	@GetMapping("/view-policy")
	public String intermediate(@RequestParam("customerID") Integer id, HttpSession session) {
		session.setAttribute("id", id);
		return "redirect:/view";
	}
	
	@GetMapping("/view")
	public String getPolicies(HttpSession session, @ModelAttribute("Policy") CustomerPolicy policy) {
		Integer id = (Integer) session.getAttribute("id");
		session.setAttribute("PolicyList", service.getPolicyList(id));
		return "view-policy";
	}
	
	@PostMapping("/upPol")
	public String updatePolicy(@ModelAttribute("Policy") CustomerPolicy policy) {
		return "update-policy";
	}
	
	@GetMapping("/updatePolicy")
	public String update(@ModelAttribute("Policy") CustomerPolicy Policy, HttpSession session) {
		Integer id = (Integer) session.getAttribute("id");
		service.updateCustomerPolicy(Policy, id);
		return "redirect:/view";
	}
	
	@GetMapping("/delPol")
	public String deletePolicy(@ModelAttribute("Policy") CustomerPolicy Policy, HttpSession session) {
		Integer id = (Integer) session.getAttribute("id");
		service.deleteCustomerPolicy(Policy, id);
		return "redirect:/view";
	}
}
