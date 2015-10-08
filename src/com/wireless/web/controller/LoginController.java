package com.wireless.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.wireless.domain.UserBean;
import com.wireless.services.UserService;

@Controller
@SessionAttributes({"user"})
public class LoginController 
{
	@Autowired
	private UserService userService;
	
	@RequestMapping("/login")
	public String showLogin(Model model, HttpServletRequest request, HttpSession session, Authentication authentication)
	{
		System.out.println("in /login");
		String username = "";
		String password = "";
		String principal = "";
		
		if(request.getParameter("error") != null)
		{
			System.out.println("login error");
			//username = request.getUserPrincipal().getName();
			//System.out.println(username);
			//request.setAttribute("error", "error in validating: " + request.getParameter("j_username"));
			
			Authentication auth = SecurityContextHolder.getContext().getAuthentication();
			
			username = auth.getName();
			password = auth.getCredentials().toString();
			principal = auth.getPrincipal().toString();
			
			
			//UserBean user = (UserBean) authentication.getPrincipal();
			//System.out.println("user=" + user.toString());
			System.out.println("username=|"+username+"|credential=|"+password+"|principal=|"+principal+"|details=|"+auth.getDetails().toString()+"|");
			
		}
		
		model.addAttribute("error", "error in validating: " + username);
		return "login";
	}
	
	@RequestMapping("/authenticate")
	public String authenticate(Model model, HttpServletRequest request)
	{
		System.out.println("username: " + request.getParameter("j_username"));
		
		return "login";
	}
	
	@RequestMapping(value="/search")
	public String showSearch(Model model, HttpSession session, HttpServletRequest request)
	{
		System.out.println("username: " + request.getParameter("j_username"));
		
		UserBean user = userService.initializeUser();
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		
		String username = auth.getName();
		//String password = auth.getCredentials().toString();
		//String principal = auth.getPrincipal().toString();
		
		System.out.println("username: " + username);
		
		//UserBean user = (UserBean) authentication.getPrincipal();
		//System.out.println("user=" + user.toString());
		//System.out.println("username=|"+username+"|credential=|"+password+"|principal=|"+principal+"|details=|"+auth.getDetails().toString()+"|");
		
		model.addAttribute("user", user);
		
		return "account/search";
	}
}
