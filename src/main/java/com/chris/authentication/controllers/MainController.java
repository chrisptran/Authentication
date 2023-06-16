package com.chris.authentication.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.chris.authentication.services.UserService;

import jakarta.servlet.http.HttpSession;

@Controller
public class MainController {
	
	private final UserService userServ;
	
	public MainController(UserService userServ) {
		this.userServ = userServ;
	}
	
	@RequestMapping("/welcome")
	public String main(HttpSession session, Model model) {
		if(session.getAttribute("user_id") == null) {
			return "redirect:/";
		}
		model.addAttribute("loggedInUser", userServ.getOne((Long) session.getAttribute("user_id")));
		return "main/dashboard.jsp";
	}
	

}
