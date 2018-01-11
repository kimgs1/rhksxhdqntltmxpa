package controller;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import model.codegroup.dao.CodeGroupDao;
import model.codeinfo.dao.CodeInfoDao;

@Controller
public class CodeManageController {

	@Autowired
	CodeGroupDao codeGroupDao;
	@Autowired
	CodeInfoDao codeInfoDao;
	
	@RequestMapping(value="/codeManage", method=RequestMethod.GET)
	public ModelAndView moveLogin() throws Exception {
		return new ModelAndView("codeManage");
	}
	
	@RequestMapping(value="/codeGroup.do", params="command=getList")
	public ModelAndView getCodeGroupList(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HashMap<String, Object> param = new HashMap<String, Object>();
		HashMap<String, Object> result = codeGroupDao.getList(param);
		return new ModelAndView("JsonView", "result", result);
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value="/codeGroup.do", params="command=create")
	public ModelAndView createCodeGroup(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HashMap<String, Object> param = new HashMap<String, Object>();
		param.put("GroupID",request.getParameter("GroupID"));
		param.put("GroupName",request.getParameter("GroupName"));
		param.put("Remark",request.getParameter("Remark"));
		param.put("SortKey",request.getParameter("SortKey"));
		String userid = (String)((HashMap<String, Object>)request.getSession().getAttribute("userInfo")).get("id");
		param.put("userid", userid);
		HashMap<String,Object> result = codeGroupDao.create(param);
		return new ModelAndView("JsonView", "result", result);
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value="/codeGroup.do", params="command=delete")
	public ModelAndView deleteCodeGroup(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HashMap<String, Object> param = new HashMap<String, Object>();
		param.put("GroupID",request.getParameter("GroupID"));
		String userid = (String)((HashMap<String, Object>)request.getSession().getAttribute("userInfo")).get("id");
		param.put("userid", userid);
		HashMap<String,Object> result = codeGroupDao.delete(param);
		return new ModelAndView("JsonView", "result", result);
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value="/codeGroup.do", params="command=update")
	public ModelAndView updateCodeGroup(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HashMap<String, Object> param = new HashMap<String, Object>();
		String data = request.getParameter("data");
		ObjectMapper mapper = new ObjectMapper();
		List<HashMap<String, Object>> list = mapper.readValue(data, new TypeReference<List<HashMap<String, Object>>>() {});
		param.put("listData", list);
		param.put("userid",  ((HashMap<String, Object>)request.getSession().getAttribute("userInfo")).get("id"));
		HashMap<String,Object> result = codeGroupDao.update(param);
		return new ModelAndView("JsonView", "result", result);
	}

	
	
	
	
	@RequestMapping(value="/codeInfo.do", params="command=getList")
	public ModelAndView getCodeInfoList(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HashMap<String, Object> param = new HashMap<String, Object>();
		param.put("GroupID",request.getParameter("GroupID"));
		HashMap<String, Object> result = codeInfoDao.getList(param);
		return new ModelAndView("JsonView", "result", result);
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value="/codeInfo.do", params="command=create")
	public ModelAndView createCodeInfo(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HashMap<String, Object> param = new HashMap<String, Object>();
		param.put("GroupID",request.getParameter("GroupID"));
		param.put("CodeID",request.getParameter("CodeID"));
		param.put("CodeName",request.getParameter("CodeName"));
		param.put("Remark",request.getParameter("Remark"));
		param.put("ExtraRate",request.getParameter("ExtraRate"));
		param.put("SortKey",request.getParameter("SortKey"));
		String userid = (String)((HashMap<String, Object>)request.getSession().getAttribute("userInfo")).get("id");
		param.put("userid", userid);
		HashMap<String,Object> result = codeInfoDao.create(param);
		return new ModelAndView("JsonView", "result", result);
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value="/codeInfo.do", params="command=delete")
	public ModelAndView deleteCodeInfo(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HashMap<String, Object> param = new HashMap<String, Object>();
		param.put("CodeID",request.getParameter("CodeID"));
		param.put("GroupID",request.getParameter("GroupID"));
		String userid = (String)((HashMap<String, Object>)request.getSession().getAttribute("userInfo")).get("id");
		param.put("userid", userid);
		HashMap<String,Object> result = codeInfoDao.delete(param);
		return new ModelAndView("JsonView", "result", result);
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value="/codeInfo.do", params="command=update")
	public ModelAndView updateCodeInfo(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HashMap<String, Object> param = new HashMap<String, Object>();
		String data = request.getParameter("data");
		ObjectMapper mapper = new ObjectMapper();
		List<HashMap<String, Object>> list = mapper.readValue(data, new TypeReference<List<HashMap<String, Object>>>() {});
		param.put("listData", list);
		param.put("userid",  ((HashMap<String, Object>)request.getSession().getAttribute("userInfo")).get("id"));
		HashMap<String,Object> result = codeInfoDao.update(param);
		return new ModelAndView("JsonView", "result", result);
	}

	
}
