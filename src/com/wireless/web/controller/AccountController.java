package com.wireless.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/account")
public class AccountController 
{
	@RequestMapping(value="/home")
	public String showHome(Model model, HttpServletRequest request)
	{
		String accountNumber = request.getParameter("accountNumber");
		
		model.addAttribute("accountNumber", accountNumber);
		
		return "account/home";
	}
	
	@RequestMapping(value="/dashboard")
	public String showDashboard()
	{
		System.out.println("in account/dashboard");
		return "account/dashboard";
	}
}
