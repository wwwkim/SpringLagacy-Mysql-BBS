package com.spring.bbs.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.spring.bbs.dao.BbsDAO;
import com.spring.bbs.dto.BbsDTO;

@Service
public class BbsServiceImple implements BbsService {
	@Autowired
	BbsDAO bbsDao;

	@Override
	public ModelAndView wirte(BbsDTO bbs) {
		ModelAndView mv = new ModelAndView();

		int result = bbsDao.write(bbs);
		if (result > 0) {
			mv.setViewName("redirect:/bbs");
		} else {
			mv.addObject("msg", "<script>alert('error') </script>");
			mv.setViewName("redirect:/write");
		}
		return mv;

	}

	@Override
	public ModelAndView getList(int pageNumber) {

		ModelAndView mv = new ModelAndView();
		mv.addObject("list", bbsDao.getList(pageNumber));
		mv.addObject("pageNumber", pageNumber);
		mv.addObject("nextPage", bbsDao.nextPage(pageNumber + 1));
	
		mv.setViewName("bbs");
		return mv;
	}

	@Override
	public ModelAndView getBbs(int bbsID) {
		ModelAndView mv = new ModelAndView();
		if (bbsID == 0) {
			String msg = "<script>alert('Do not exist')</script> ";
			mv.addObject("msg", msg);
			mv.setViewName("bbs");
		} else {
			mv.addObject("bbs", bbsDao.getBbs(bbsID));
			mv.setViewName("view");
		}
		return mv;
	}

	@Override
	public ModelAndView update(int bbsID) {
		ModelAndView mv = new ModelAndView();

		mv.addObject("bbs", bbsDao.getBbs(bbsID));
		mv.setViewName("update");

		return mv;
	}

	@Override
	public ModelAndView updateAction(BbsDTO bbs) {
		ModelAndView mv = new ModelAndView();
		int result=bbsDao.update(bbs.getBbsID(), bbs.getBbsTitle(), bbs.getBbsContent());
		if (result > 0) {
			mv.addObject("bbsID", bbs.getBbsID());
			mv.setViewName("redirect:/view");
		} else {
			mv.addObject("msg", "<script>alert('error') </script>");
			mv.setViewName("redirect:/update");
		}
		return mv;
		
	}

	@Override
	public ModelAndView deleteAction(int bbsID) {
		ModelAndView mv= new ModelAndView();
		int result=	bbsDao.delete(bbsID);
		if(result==-1) {
			String msg="<script>alert('failed to delete')</script> ";
		
			mv.addObject("bbsID", bbsID);
			mv.setViewName("redirect:/view?msg="+msg);
		}else {
			String msg="<script>alert('Deleted successfully')</script> ";
			
			mv.setViewName("redirect:/bbs?msg="+msg);
		}
		return mv;
	}
}
