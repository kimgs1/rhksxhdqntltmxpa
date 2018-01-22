package controller;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import model.fbulletine.dao.FBulletineDao;
import pasing.FbulientPagingBean;

@Controller
public class FBulletineController {
	////sdfsidjfoisjidfojsidfjsfdoij
	@Autowired
	FBulletineDao fbulletineDao;
	
	@RequestMapping(value="/fbulletine", method=RequestMethod.GET)
	public ModelAndView baseView() throws Exception {
		return new ModelAndView("fbulletine_List");
	}
	@RequestMapping(value="/fbulletine_content", method=RequestMethod.GET)
	public ModelAndView getFBulletineContentByUrl(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HashMap<String, Object> param = new HashMap<String, Object>();
		param.put("id", request.getParameter("id"));
		HashMap<String,Object> result = fbulletineDao.getContent(param);
		return new ModelAndView("fbulletine_view", "result", result);
	}
	@RequestMapping(value="/fbulletine_create", method=RequestMethod.GET)
	public ModelAndView FBullentineCreateView() throws Exception {
		return new ModelAndView("fbulletine_create");
	}

//	@RequestMapping(value="/fbulletine", method=RequestMethod.GET)
//	public ModelAndView moveLogin() throws Exception {
//		return new ModelAndView("fbulletine_List");
//	}
	@SuppressWarnings("unchecked")
	@RequestMapping(value="/fbulletine.do", params="command=create")
	public ModelAndView createFBulletine(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HashMap<String, Object> param = new HashMap<String, Object>();
		param.put("title", request.getParameter("title"));
		param.put("contents", request.getParameter("contents"));
		String userid = (String)((HashMap<String, Object>)request.getSession().getAttribute("userInfo")).get("id");
		param.put("userid", userid);
		HashMap<String,Object> result = fbulletineDao.createBulletine(param);
		return new ModelAndView("JsonView", "result", result);
	}

	@RequestMapping(value="/fbulletine.do", params="command=getList")
	public ModelAndView getFBulletineList(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HashMap<String, Object> param = new HashMap<String, Object>();

		param.put("low",0);
		param.put("high",5);
		param.put("nowPage", "1");
		HashMap<String,Object> result = fbulletineDao.getList(param);
		return new ModelAndView("JsonView", "result", result);
	}
	
	@RequestMapping(value="/fbulletine.do", params="command=getListPaging")
	public ModelAndView getFBulletineListPaging(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HashMap<String, Object> param = new HashMap<String, Object>();
		String nowPageStr = request.getParameter("nowPage");
		if(nowPageStr== null || nowPageStr.toString().equals("")){
			nowPageStr = "1";
		}
		int nowPage = Integer.parseInt(nowPageStr);
		param.put("nowPage", nowPage);
		param.put("low",(FbulientPagingBean.numberOfContentPerPage * (nowPage - 1)));
		param.put("high",(FbulientPagingBean.numberOfContentPerPage * nowPage));
		HashMap<String,Object> result = fbulletineDao.getList(param);
		return new ModelAndView("JsonView", "result", result);
	}
	
	@RequestMapping(value="/fbulletine.do", params="command=getContent")
	public ModelAndView getFBulletineContent(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HashMap<String, Object> param = new HashMap<String, Object>();
		param.put("id", request.getParameter("id"));
		HashMap<String,Object> result = fbulletineDao.getContent(param);
		return new ModelAndView("JsonView", "result", result);
	}
}
