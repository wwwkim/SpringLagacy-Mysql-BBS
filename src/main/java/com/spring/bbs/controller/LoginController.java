package com.spring.bbs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.spring.bbs.dto.UserDTO;
import com.spring.bbs.service.UserService;

@Controller
public class LoginController {
	@Autowired
	UserService service;

	@RequestMapping("/login")
	public String login() {
		return "login";
	}

	@RequestMapping("/loginAction")

	public ModelAndView loginAction(String userID, String userPassword) {
		ModelAndView mv = new ModelAndView();
		mv = service.login(userID, userPassword);
		return mv;
	}

	@RequestMapping("/join")
	public String join() {
		return "join";
	}

	@RequestMapping("/joinAction")
	public ModelAndView joinAction(UserDTO user) {
		ModelAndView mv = new ModelAndView();
		if (user.getUserID().isEmpty() || user.getUserPassword().isEmpty() || user.getUserName().isEmpty()
				|| user.getUserGender().isEmpty() || user.getUserEmail().isEmpty()) {
			mv.addObject("msg", "<script>alert('All the fields are required') </script>");
			mv.setViewName("join");
		} else {
			mv = service.join(user);

		}
		return mv;
	}
}
