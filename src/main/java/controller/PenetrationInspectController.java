package controller;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import model.penetrationinspect.dao.PenetrationInspectDao;


@Controller
public class PenetrationInspectController {
	@Autowired
	PenetrationInspectDao penetrationInspectDao;
	
	@RequestMapping(value="/penetrationinspect", method=RequestMethod.GET)
	public ModelAndView baseView() throws Exception {
		return new ModelAndView("penetrationinspect");
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value="/penetrationinspect.do", params="command=save")
	public ModelAndView savePenetrationInfo(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HashMap<String, Object> param = new HashMap<String, Object>();
//		param.put("SEQ",request.getParameter("SEQ"));
		param.put("ManagementNo",request.getParameter("ManagementNo"));
		param.put("PenetrationNo",request.getParameter("PenetrationNo"));
		param.put("InspectDate",request.getParameter("InspectDate"));
		param.put("InspectSeq",request.getParameter("InspectSeq"));
		param.put("ImproveDate",request.getParameter("ImproveDate"));
		param.put("InspectionInterval",request.getParameter("InspectionInterval"));
		param.put("SealantConditionState",request.getParameter("SealantConditionState"));
		param.put("JudgementReason",request.getParameter("JudgementReason"));
		param.put("Judgment",request.getParameter("Judgment"));
		param.put("ImproveNote",request.getParameter("ImproveNote"));
		param.put("RegID",((HashMap<String, Object>)request.getSession().getAttribute("userInfo")).get("id"));
		HashMap<String,Object> result = penetrationInspectDao.save(param);
		return new ModelAndView("JsonView", "result", result);
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value="/penetrationinspect.do", params="command=delete")
	public ModelAndView deletePerformanceEvaluation(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HashMap<String, Object> param = new HashMap<String, Object>();
		param.put("Seq",request.getParameter("Seq"));
		param.put("RegID",((HashMap<String, Object>)request.getSession().getAttribute("userInfo")).get("id"));
		HashMap<String,Object> result = penetrationInspectDao.delete(param);
		return new ModelAndView("JsonView", "result", result);
	}

	@RequestMapping(value="/penetrationinspect.do", params="command=getList")
	public ModelAndView getPenetrationInfoList(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HashMap<String, Object> param = new HashMap<String, Object>();
//		param.put("SEQ",request.getParameter("SEQ"));
		param.put("ManagementNo",request.getParameter("ManagementNo"));
		param.put("PenetrationNo",request.getParameter("PenetrationNo"));
		param.put("InspectDate",request.getParameter("InspectDate"));
		param.put("InspectSeq",request.getParameter("InspectSeq"));
		param.put("ImproveDate",request.getParameter("ImproveDate"));
		param.put("InspectionInterval",request.getParameter("InspectionInterval"));
		param.put("SealantConditionState",request.getParameter("SealantConditionState"));
		param.put("JudgementReason",request.getParameter("JudgementReason"));
		param.put("Judgment",request.getParameter("Judgment"));
		param.put("ImproveNote",request.getParameter("ImproveNote"));
		HashMap<String,Object> result = penetrationInspectDao.getList(param);
		return new ModelAndView("JsonView", "result", result);
	}
}
