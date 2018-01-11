package controller;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import model.usermanage.dao.UserManageDao;

@Controller
public class UserManageController {

	@Autowired
	UserManageDao userManageDao;
	@RequestMapping(value="/usermanage", method=RequestMethod.GET)
	public ModelAndView baseView() throws Exception {
		return new ModelAndView("usermanage");
	}
	@RequestMapping(value="/usermanage.do", params="command=getList")
	public ModelAndView getUserInfoList(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HashMap<String, Object> param = new HashMap<String, Object>();
		HashMap<String, Object> result = userManageDao.getList(param);
		return new ModelAndView("JsonView", "result", result);
	}
	
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value="/usermanage.do", params="command=delete")
	public ModelAndView deleteUserInfoGroup(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HashMap<String, Object> param = new HashMap<String, Object>();
		param.put("UserID",request.getParameter("UserID"));
		String userid = (String)((HashMap<String, Object>)request.getSession().getAttribute("userInfo")).get("id");
		param.put("regid", userid);
		HashMap<String,Object> result = userManageDao.delete(param);
		return new ModelAndView("JsonView", "result", result);
	}
	
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value="/usermanage.do", params="command=getcontent")
	public ModelAndView getUserInfoContent(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HashMap<String, Object> param = new HashMap<String, Object>();
		String userId = request.getParameter("UserID");
		if(userId == null ||userId.equals("")){
			userId =(String)((HashMap<String, Object>)request.getSession().getAttribute("userInfo")).get("id");
		}
		param.put("UserID", request.getParameter("UserID"));
		HashMap<String,Object> result = userManageDao.getContent(param);
		return new ModelAndView("JsonView", "result", result);
	}
}
