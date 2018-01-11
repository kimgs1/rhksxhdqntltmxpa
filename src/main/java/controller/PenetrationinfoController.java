package controller;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import model.penetrationinfo.dao.PenetrationInfoDao;

@Controller
public class PenetrationinfoController {
	@Autowired
	PenetrationInfoDao penetrationInfoDao;
	
	@RequestMapping(value="/penetrationinfo", method=RequestMethod.GET)
	public ModelAndView baseView() throws Exception {
		return new ModelAndView("penetrationinfo");
	}
	
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value="/penetrationinfo.do", params="command=save")
	public ModelAndView createPenetrationInfo(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HashMap<String, Object> param = new HashMap<String, Object>();
//		param.put("SEQ",request.getParameter("SEQ"));
		param.put("ManagementNo",request.getParameter("ManagementNo"));
		param.put("PenetrationNo",request.getParameter("PenetrationNo"));
		param.put("matter",request.getParameter("matter"));
		param.put("Pipe",request.getParameter("Pipe"));
		param.put("Duct",request.getParameter("Duct"));
		param.put("SectionTube",request.getParameter("SectionTube"));
		param.put("Conduit",request.getParameter("Conduit"));
		param.put("Cable",request.getParameter("Cable"));
		param.put("Tray",request.getParameter("Tray"));
		param.put("CoverTray",request.getParameter("CoverTray"));
		param.put("Etc",request.getParameter("Etc"));
		param.put("RegID",((HashMap<String, Object>)request.getSession().getAttribute("userInfo")).get("id"));
		HashMap<String,Object> result = penetrationInfoDao.save(param);
		return new ModelAndView("JsonView", "result", result);
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value="/penetrationinfo.do", params="command=delete")
	public ModelAndView deletePenetrationInfo(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HashMap<String, Object> param = new HashMap<String, Object>();
		param.put("Seq",request.getParameter("Seq"));
		param.put("RegID",((HashMap<String, Object>)request.getSession().getAttribute("userInfo")).get("id"));
		HashMap<String,Object> result = penetrationInfoDao.delete(param);
		return new ModelAndView("JsonView", "result", result);
	}

	@RequestMapping(value="/penetrationinfo.do", params="command=getList")
	public ModelAndView getPenetrationInfoList(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HashMap<String, Object> param = new HashMap<String, Object>();
		param.put("ManagementNo",request.getParameter("ManagementNo"));
		param.put("PenetrationNo",request.getParameter("PenetrationNo"));
		param.put("matter",request.getParameter("matter"));
		param.put("Pipe",request.getParameter("Pipe"));
		param.put("Duct",request.getParameter("Duct"));
		param.put("SectionTube",request.getParameter("SectionTube"));
		param.put("Conduit",request.getParameter("Conduit"));
		param.put("Cable",request.getParameter("Cable"));
		param.put("Tray",request.getParameter("Tray"));
		param.put("CoverTray",request.getParameter("CoverTray"));
		param.put("Etc",request.getParameter("Etc"));
		HashMap<String,Object> result = penetrationInfoDao.getList(param);
		return new ModelAndView("JsonView", "result", result);
	}
}
