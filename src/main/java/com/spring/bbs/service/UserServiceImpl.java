package com.spring.bbs.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.spring.bbs.dao.UserDAO;
import com.spring.bbs.dto.UserDTO;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	UserDAO dao;

	@Override
	public ModelAndView login(String userID, String userPassword) {
		ModelAndView mv = new ModelAndView();
		int result = dao.login(userID, userPassword);
		if (result == 1) {
			mv.setViewName("redirect:/main");
			return mv;
		} else if (result == 0) {
			mv.addObject("msg", "<script>alert('Password is wrong') </script>");
		} else if (result == -1) {
			mv.addObject("msg", "<script>alert('ID does not exist') </script>");
		} else if (result == 2) {
			mv.addObject("msg", "<script>alert('DB error') </script>");
		}
		mv.setViewName("login");
		return mv;

	}

	@Override
	public ModelAndView join(UserDTO user) {
		ModelAndView mv = new ModelAndView();
		int result = dao.join(user);
		if (result == -1) {
			mv.addObject("msg", "<script>alert('The same ID already exist') </script>");
			mv.setViewName("join");

		} else {
			mv.setViewName("redirect:/main");
		}
		return mv;
	}

}