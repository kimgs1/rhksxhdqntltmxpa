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
	@RequestMapping(value="/performanceEvaluation.do", params="command=delete")
	public ModelAndView deletePerformanceEvaluation(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HashMap<String, Object> param = new HashMap<String, Object>();
		param.put("Seq",request.getParameter("Seq"));
		param.put("RegID",((HashMap<String, Object>)request.getSession().getAttribute("userInfo")).get("id"));
		HashMap<String,Object> result = performanceEvaluationDao.delete(param);
		return new ModelAndView("JsonView", "result", result);
	}

	@RequestMapping(value="/performanceEvaluation.do", params="command=getList")
	public ModelAndView getPerformanceEvaluationList(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HashMap<String, Object> param = new HashMap<String, Object>();
//		
		param.put("ManagementNo",request.getParameter("ManagementNo"));
		param.put("PenetrationNo",request.getParameter("PenetrationNo"));
		param.put("EvaluationResult",request.getParameter("EvaluationResult"));
		param.put("FIRE_VALUE_RANGE",request.getParameter("FIRE_VALUE_RANGE"));
		param.put("PRESSURE_VALUE_RANGE",request.getParameter("PRESSURE_VALUE_RANGE"));
		param.put("FLOOD_VALUE_RANGE",request.getParameter("FLOOD_VALUE_RANGE"));
		param.put("RADIATION_VALUE_RANGE",request.getParameter("RADIATION_VALUE_RANGE"));
		HashMap<String,Object> result = performanceEvaluationDao.getList(param);
		return new ModelAndView("JsonView", "result", result);
	}
	
}
