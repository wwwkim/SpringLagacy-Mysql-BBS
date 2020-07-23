package com.spring.bbs.service;

import org.springframework.web.servlet.ModelAndView;

import com.spring.bbs.dto.UserDTO;

public interface UserService {

	public ModelAndView login(String userID, String userPassword) ;

	public ModelAndView join(UserDTO user);

}
