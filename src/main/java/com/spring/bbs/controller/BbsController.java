package com.spring.bbs.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.spring.bbs.dao.BbsDAO;
import com.spring.bbs.dto.BbsDTO;
import com.spring.bbs.service.BbsService;

@Controller
public class BbsController {
	@Autowired
	BbsService bbsService;
	

	@RequestMapping("/bbs")
	public ModelAndView bbs(HttpSession session, HttpServletRequest request) {
		String user = null;
		if (session.getAttribute("userID") != null) {
			user = (String) session.getAttribute("userID");
		}
		int pageNumber=1;
	if(request.getParameter("pageNumber") !=null) {
		pageNumber=Integer.parseInt(request.getParameter("pageNumber"));
		
	}
		ModelAndView mv = new ModelAndView();
		mv = bbsService.getList(pageNumber);

		return mv;
	}
	
	
	@RequestMapping("/view")
	public ModelAndView view(HttpSession session, HttpServletRequest request) {
		String user = null;
		if (session.getAttribute("userID") != null) {
			user = (String) session.getAttribute("userID");
		}
		int bbsID=0;
	if(request.getParameter("bbsID") !=null) {
		bbsID=Integer.parseInt(request.getParameter("bbsID"));
		
	}
		ModelAndView mv = new ModelAndView();
	
		mv = bbsService.getBbs(bbsID);

		return mv;
	}

	@RequestMapping("/write")

	public String write(HttpSession session) {
		String user = null;

		if (session.getAttribute("userID") != null) {
			user = (String) session.getAttribute("userID");
			return "write";
		}
		if (user == null) {

		}
		return "login";
	}

	@RequestMapping("/writeAction")
	public ModelAndView writeAction(HttpSession session, BbsDTO bbs) {
		ModelAndView mv = new ModelAndView();
		String user = null;
		if (session.getAttribute("userID") != null) {
			user = (String) session.getAttribute("userID");
			bbs.setUserID(user);
		}
		if (user == null) {
			String msg = "<script>alert('Please log in') </script>";
			mv.addObject("msg", msg);
			mv.setViewName("login");
		} else if (bbs.getBbsTitle().isEmpty() || bbs.getBbsContent().isEmpty()) {
			String msg = "<script>alert('All the fields are required') </script>";
			mv.addObject("msg", msg);
			mv.setViewName("write");
		} else {
			mv = bbsService.wirte(bbs);
		}
		return mv;
	}
	@RequestMapping("/update")
	public ModelAndView update(HttpSession session, HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();
		String user = null;
		if (session.getAttribute("userID") != null) {
			user = (String) session.getAttribute("userID");
			
		}
		if (user == null) {
			String msg = "<script>alert('Please log in') </script>";
			mv.addObject("msg", msg);
			mv.setViewName("login");
		} 
		int bbsID=Integer.parseInt(request.getParameter("bbsID"));
	
			mv=bbsService.update(bbsID);
	
		
		return mv;
	}
	@RequestMapping("/updateAction")
	public ModelAndView updateAction(HttpSession session, BbsDTO bbs) {
		ModelAndView mv = new ModelAndView();
		String user = null;
		if (session.getAttribute("userID") != null) {
			user = (String) session.getAttribute("userID");
			bbs.setUserID(user);
		}
		if (user == null) {
			String msg = "<script>alert('Please log in') </script>";
			mv.addObject("msg", msg);
			mv.setViewName("login");
		} else if (bbs.getBbsTitle().isEmpty() || bbs.getBbsContent().isEmpty()) {
			String msg = "<script>alert('All the fields are required') </script>";
			mv.addObject("msg", msg);
			mv.setViewName("write");
		} else {
			mv = bbsService.updateAction(bbs);
		}
		return mv;
	}
}
