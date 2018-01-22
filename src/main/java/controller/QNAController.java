package controller;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import model.qna.dao.QNADao;
import pasing.QNAPagingBean;
import pasing.QNAReviewPagingBean;;

@Controller
public class QNAController {

	@Autowired
	QNADao qnaDao;
	
	@RequestMapping(value="/qna", method=RequestMethod.GET)
	public ModelAndView moveLogin() throws Exception {
		return new ModelAndView("qna_list");
	}

	@RequestMapping(value="/qna_content", method=RequestMethod.GET)
	public ModelAndView getQNAContenByURL(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HashMap<String, Object> param = new HashMap<String, Object>();
		param.put("id", request.getParameter("id"));
		HashMap<String,Object> result = qnaDao.getContent(param);
		return new ModelAndView("qna_view", "qna", result);
	}
	@RequestMapping(value="/qna_create", method=RequestMethod.GET)
	public ModelAndView QNACreateView() throws Exception {
		return new ModelAndView("qna_create");
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value="/qna.do", params="command=create")
	public ModelAndView createQNA(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HashMap<String, Object> param = new HashMap<String, Object>();
		param.put("subject", request.getParameter("subject"));
		param.put("Content", request.getParameter("Content"));
		String userid = (String)((HashMap<String, Object>)request.getSession().getAttribute("userInfo")).get("id");
		param.put("userid", userid);
		HashMap<String,Object> result = qnaDao.createQNA(param);
		return new ModelAndView("JsonView", "result", result);
	}

	@RequestMapping(value="/qna.do", params="command=getList")
	public ModelAndView getQNAList(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HashMap<String, Object> param = new HashMap<String, Object>();
		param.put("low",0);
		param.put("high",5);
		param.put("nowPage", "1");
		HashMap<String,Object> result = qnaDao.getList(param);
		return new ModelAndView("JsonView", "result", result);
	}
	
	@RequestMapping(value="/qna.do", params="command=getListPaging")
	public ModelAndView getQNAListPaging(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HashMap<String, Object> param = new HashMap<String, Object>();
		String nowPageStr = request.getParameter("nowPage");
		if(nowPageStr== null || nowPageStr.toString().equals("")){
			nowPageStr = "1";
		}
		int nowPage = Integer.parseInt(nowPageStr);
		param.put("nowPage", nowPage);
		param.put("low",(QNAPagingBean.numberOfContentPerPage * (nowPage - 1)));
		param.put("high",(QNAPagingBean.numberOfContentPerPage * nowPage));
		HashMap<String,Object> result = qnaDao.getList(param);
		return new ModelAndView("JsonView", "result", result);
	}
	


	
	@RequestMapping(value="/qna.do", params="command=getContent")
	public ModelAndView getQNAContent(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HashMap<String, Object> param = new HashMap<String, Object>();
		param.put("id", request.getParameter("id"));
		HashMap<String,Object> result = qnaDao.getContent(param);
		return new ModelAndView("JsonView", "result", result);
	}
	
	@RequestMapping(value="/qna.do", params="command=getQNAReviewList")
	public ModelAndView getQNAReviewList(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HashMap<String, Object> param = new HashMap<String, Object>();
		param.put("qnaid", request.getParameter("qnaid"));
		String nowPageStr = request.getParameter("nowPage");
		if(nowPageStr== null || nowPageStr.toString().equals("")){
			nowPageStr = "1";
		}
		int nowPage = Integer.parseInt(nowPageStr);
		param.put("nowPage", nowPage);
		param.put("limit",(QNAReviewPagingBean.numberOfContentPerPage * (nowPage - 1)) + "," + QNAReviewPagingBean.numberOfContentPerPage );
		HashMap<String,Object> result = qnaDao.getQNAReviewList(param);
		return new ModelAndView("JsonView", "result", result);
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value="/qna.do", params="command=createReview")
	public ModelAndView createQNAReview(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HashMap<String, Object> param = new HashMap<String, Object>();
		param.put("qnaid", request.getParameter("qnaid"));
		param.put("content", request.getParameter("content"));
		String userid = (String)((HashMap<String, Object>)request.getSession().getAttribute("userInfo")).get("id");
		param.put("userid", userid);
		HashMap<String,Object> result = qnaDao.createQNAReview(param);
		return new ModelAndView("JsonView", "result", result);
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value="/qna.do", params="command=deleteQNAReview")
	public ModelAndView deleteQNAReview(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HashMap<String, Object> param = new HashMap<String, Object>();
		param.put("id", request.getParameter("id"));
		String userid = (String)((HashMap<String, Object>)request.getSession().getAttribute("userInfo")).get("id");
		param.put("userid", userid);
		HashMap<String,Object> result = qnaDao.deleteQNAReview(param);
		return new ModelAndView("JsonView", "result", result);
	}
	
}
