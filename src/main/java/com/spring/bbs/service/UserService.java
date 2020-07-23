package com.spring.bbs.service;

import org.springframework.web.servlet.ModelAndView;

public interface UserService {

	public ModelAndView login(String userID, String userPassword) ;

}
