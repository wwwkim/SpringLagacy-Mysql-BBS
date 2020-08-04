package com.spring.bbs.controller;

import javax.servlet.http.HttpSession;

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

	public ModelAndView loginAction(String userID, String userPassword, HttpSession session) {
		
		ModelAndView mv = new ModelAndView();
		mv = service.login(userID, userPassword);
		if(mv.getViewName().equals("redirect:/main")) {
			session.setAttribute("userID", userID);
		}

		return mv;
	}

	@RequestMapping("/join")
	public String join() {
		return "join";
	}

	@RequestMapping("/joinAction")
	public ModelAndView joinAction(UserDTO user,HttpSession session) {
		ModelAndView mv = new ModelAndView();
		if (user.getUserID().isEmpty() || user.getUserPassword().isEmpty() || user.getUserName().isEmpty()
				|| user.getUserGender().isEmpty() || user.getUserEmail().isEmpty()) {
			mv.addObject("msg", "<script>alert('All the fields are required') </script>");
			mv.setViewName("join");
		} else {
			mv = service.join(user);
			if(mv.getViewName().equals("redirect:/main")) {
				session.setAttribute("userID", user.getUserID());
			}
		}
		
		return mv;
	}
	
	@RequestMapping("/main")
	public ModelAndView main(HttpSession session) {
		String user=null;
		if(session.getAttribute("userID")!=null) {
			user=(String) session.getAttribute("userID");
		}
		
		ModelAndView mv=new ModelAndView();
		mv.addObject("user",user);
		mv.setViewName("main");
		return mv;
	}
	
	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "main";
	}
	
	
}
