package com.test.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ShowPageController {

	@RequestMapping(value="/{pathName}")
	public String showPage(@PathVariable String pathName,HttpSession session) {
		session.removeAttribute("login_msg");
		return pathName;		
	}
	
	@RequestMapping(value="/")
	public String login(HttpSession session) {
		session.removeAttribute("login_msg");
		return "login";
	}
}
