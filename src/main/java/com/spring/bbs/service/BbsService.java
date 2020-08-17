package com.spring.bbs.service;

import org.springframework.web.servlet.ModelAndView;

import com.spring.bbs.dto.BbsDTO;

public interface BbsService {

	ModelAndView wirte(BbsDTO bbs);

	ModelAndView getList(int pageNumber);

	ModelAndView getBbs(int bbsID);

	ModelAndView update(int bbsID);

	ModelAndView updateAction(BbsDTO bbs);

	

}
