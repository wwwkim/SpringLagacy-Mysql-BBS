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
		ModelAndView mv = new ModelAndView();
		String user = user(session);
		int pageNumber = pageNumber(request);

		mv = bbsService.getList(pageNumber);
		mv.addObject("msg",request.getParameter("msg"));
		return mv;
	}

	@RequestMapping("/view")
	public ModelAndView view(HttpSession session, HttpServletRequest request) {
		String user = user(session);
		int bbsID = bbsID(request);
		ModelAndView mv = new ModelAndView();

		mv = bbsService.getBbs(bbsID);

		return mv;
	}

	@RequestMapping("/write")
	public String write(HttpSession session) {
		String user = user(session);
		if (user == null) {
			return "login";
		}
		return "write";
	}

	@RequestMapping("/writeAction")
	public ModelAndView writeAction(HttpSession session, BbsDTO bbs) {
		ModelAndView mv = new ModelAndView();
		String user = user(session);
		
			bbs.setUserID(user);
		
		if (user == null) {
			mv.addObject("msg", "<script>alert('Please log in') </script>");
			mv.setViewName("login");
		} else if (bbs.getBbsTitle().isEmpty() || bbs.getBbsContent().isEmpty()) {
			mv.addObject("msg", "<script>alert('All the fields are required') </script>");
			mv.setViewName("write");
		} else {
			mv = bbsService.wirte(bbs);
		}
		return mv;
	}

	@RequestMapping("/update")
	public ModelAndView update(HttpSession session, HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();
		String user = user(session);
		if (user == null) {
			String msg = "<script>alert('Please log in') </script>";
			mv.addObject("msg", msg);
			mv.setViewName("login");
		}
		int bbsID = bbsID(request);

		mv = bbsService.update(bbsID);

		return mv;
	}

	@RequestMapping("/updateAction")
	public ModelAndView updateAction(HttpSession session, BbsDTO bbs) {
		ModelAndView mv = new ModelAndView();
		String user = user(session);
			bbs.setUserID(user);
		
		if (user == null) {
			mv.addObject("msg","<script>alert('Please log in') </script>");
			mv.setViewName("login");
		} else if (bbs.getBbsTitle().isEmpty() || bbs.getBbsContent().isEmpty()) {
			mv.addObject("msg","<script>alert('All the fields are required') </script>");
			mv.setViewName("write");
		} else {
			mv = bbsService.updateAction(bbs);
		}
		return mv;
	}

	@RequestMapping("/deleteAction")
	public ModelAndView deleteAction(HttpSession session, HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();
		String user = user(session);
		if (user == null) {
			mv.addObject("msg", "<script>alert('Please log in') </script>");
			mv.setViewName("login");
		}
		int bbsID = bbsID(request);
	
			mv = bbsService.deleteAction(bbsID);

		return mv;
	}

	
	public String user(HttpSession session) {
		String user = null;
		if (session.getAttribute("userID") != null) {
			user = (String) session.getAttribute("userID");
		}
		return user;
	}

	public int pageNumber(HttpServletRequest request) {
		int pageNumber = 1;
		if (request.getParameter("pageNumber") != null) {
			pageNumber = Integer.parseInt(request.getParameter("pageNumber"));
		}
		return pageNumber;
	}

	public int bbsID(HttpServletRequest request) {
		int bbsID = 0;
		if (request.getParameter("bbsID") != null) {
			bbsID = Integer.parseInt(request.getParameter("bbsID"));
		}
		return bbsID;
	}
}
