package com.spring.bbs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.spring.bbs.service.UserService;

@Controller
public class LoginController {
	@Autowired
	UserService service;

	@RequestMapping("/loginAction")

	public ModelAndView loginAction(String userID,String userPassword) {
		ModelAndView mv=new ModelAndView();
		mv= service.login(userID,userPassword);
		return mv;
	}
	
	@RequestMapping("/join")
	public String join() {
		return "join";
	}
}
