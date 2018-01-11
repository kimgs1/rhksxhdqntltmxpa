package controller;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import model.performanceEvaluation.dao.PerformanceEvaluationDao;


@Controller
public class PerformanceEvaluationController {
	@Autowired
	PerformanceEvaluationDao performanceEvaluationDao;
	
	@RequestMapping(value="/performanceEvaluation", method=RequestMethod.GET)
	public ModelAndView baseView() throws Exception {
		return new ModelAndView("performanceEvaluation");
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value="/performanceEvaluation.do", params="command=save")
	public ModelAndView savePerformanceEvaluation(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HashMap<String, Object> param = new HashMap<String, Object>();
//		param.put("SEQ",request.getParameter("SEQ"));
		param.put("ManagementNo",request.getParameter("ManagementNo"));
		param.put("PenetrationNo",request.getParameter("PenetrationNo"));
		param.put("RequirePerformance",request.getParameter("RequirePerformance"));
		param.put("EvaluationResult",request.getParameter("EvaluationResult"));
		param.put("FireResistanceRating",request.getParameter("FireResistanceRating"));
		param.put("PSI",request.getParameter("PSI"));
		param.put("WaterSeal",request.getParameter("WaterSeal"));
		param.put("RadiationShield",request.getParameter("RadiationShield"));
		param.put("RegID",((HashMap<String, Object>)request.getSession().getAttribute("userInfo")).get("id"));
		HashMap<String,Object> result = performanceEvaluationDao.save(param);
		return new ModelAndView("JsonView", "result", result);
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value="/performanceEvaluation.do", params="command=delete")
	public ModelAndView deletePerformanceEvaluation(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HashMap<String, Object> param = new HashMap<String, Object>();
		param.put("Seq",request.getParameter("Seq"));
		param.put("RegID",((HashMap<String, Object>)request.getSession().getAttribute("userInfo")).get("id"));
		HashMap<String,Object> result = performanceEvaluationDao.delete(param);
		return new ModelAndView("JsonView", "result", result);
	}

	@SuppressWarnings("unchecked")
	@RequestMapping(value="/performanceEvaluation.do", params="command=getList")
	public ModelAndView getPerformanceEvaluationList(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HashMap<String, Object> param = new HashMap<String, Object>();
//		param.put("SEQ",request.getParameter("SEQ"));
		param.put("ManagementNo",request.getParameter("ManagementNo"));
		param.put("PenetrationNo",request.getParameter("PenetrationNo"));
		param.put("RequirePerformance",request.getParameter("RequirePerformance"));
		param.put("EvaluationResult",request.getParameter("EvaluationResult"));
		param.put("FireResistanceRating",request.getParameter("FireResistanceRating"));
		param.put("PSI",request.getParameter("PSI"));
		param.put("WaterSeal",request.getParameter("WaterSeal"));
		param.put("RadiationShield",request.getParameter("RadiationShield"));
		HashMap<String,Object> result = performanceEvaluationDao.getList(param);
		return new ModelAndView("JsonView", "result", result);
	}
	
}
