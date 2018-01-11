package controller;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import model.sealantinfo.dao.SealantinfoDao;

@Controller
public class SealantinfoController {

	@Autowired
	SealantinfoDao sealantinfoDao;
	
	@RequestMapping(value="/sealantinfo", method=RequestMethod.GET)
	public ModelAndView baseView() throws Exception {
		return new ModelAndView("sealantinfo");
	}
	@SuppressWarnings("unchecked")
	@RequestMapping(value="/sealantinfo.do", params="command=save")
	public ModelAndView createSealantinfo(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HashMap<String, Object> param = new HashMap<String, Object>();
		param.put("Seq",request.getParameter("Seq"));
		param.put("ManagementNo",request.getParameter("ManagementNo"));
		param.put("PenetrationNo",request.getParameter("PenetrationNo"));
		param.put("ConstructionState",request.getParameter("ConstructionState"));
		param.put("SealQualityClass",request.getParameter("SealQualityClass"));
		param.put("SealMeterial",request.getParameter("SealMeterial"));
		param.put("SealThickness",request.getParameter("SealThickness"));
		param.put("PressingBoardMeterial",request.getParameter("PressingBoardMeterial"));
		param.put("PressingBoardThickness",request.getParameter("PressingBoardThickness"));
		param.put("RepairQuantity",request.getParameter("RepairQuantity"));
		param.put("Register",request.getParameter("Register"));
		param.put("Reviewer",request.getParameter("Reviewer"));
		param.put("Checker",request.getParameter("Checker"));
		param.put("SpecialNote",request.getParameter("SpecialNote"));
		param.put("RegID",((HashMap<String, Object>)request.getSession().getAttribute("userInfo")).get("id"));
		HashMap<String,Object> result = sealantinfoDao.save(param);
		return new ModelAndView("JsonView", "result", result);
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value="/sealantinfo.do", params="command=delete")
	public ModelAndView deleteSealantinfo(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HashMap<String, Object> param = new HashMap<String, Object>();
		param.put("Seq",request.getParameter("Seq"));
		param.put("RegID",((HashMap<String, Object>)request.getSession().getAttribute("userInfo")).get("id"));
		HashMap<String,Object> result = sealantinfoDao.delete(param);
		return new ModelAndView("JsonView", "result", result);
	}
	
	
	@RequestMapping(value="/sealantinfo.do", params="command=getList")
	public ModelAndView getSealantinfoList(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HashMap<String, Object> param = new HashMap<String, Object>();
//		param.put("Seq",request.getParameter("Seq"));
		param.put("ManagementNo",request.getParameter("ManagementNo"));
		param.put("PenetrationNo",request.getParameter("PenetrationNo"));
		param.put("ConstructionState",request.getParameter("ConstructionState"));
		param.put("SealQualityClass",request.getParameter("SealQualityClass"));
		param.put("SealMeterial",request.getParameter("SealMeterial"));
		param.put("SealThickness",request.getParameter("SealThickness"));
		param.put("PressingBoardMeterial",request.getParameter("PressingBoardMeterial"));
		param.put("PressingBoardThickness",request.getParameter("PressingBoardThickness"));
		param.put("RepairQuantity",request.getParameter("RepairQuantity"));
		param.put("Register",request.getParameter("Register"));
		param.put("Reviewer",request.getParameter("Reviewer"));
		param.put("Checker",request.getParameter("Checker"));
		param.put("SpecialNote",request.getParameter("SpecialNote"));
		HashMap<String,Object> result = sealantinfoDao.getList(param);
		return new ModelAndView("JsonView", "result", result);
	}
}
