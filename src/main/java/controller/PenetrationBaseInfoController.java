package controller;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import model.penetrationbaseinfo.dao.PenetrationBaseInfoDao;

@Controller
public class PenetrationBaseInfoController {

	@Autowired
	PenetrationBaseInfoDao penetrationBaseInfoDao;
	
	@RequestMapping(value="/penetrationbaseinfo", method=RequestMethod.GET)
	public ModelAndView baseView() throws Exception {
		return new ModelAndView("penetrationbaseinfo");
	}
	@SuppressWarnings("unchecked")
	@RequestMapping(value="/penetrationbaseinfo.do", params="command=save")
	public ModelAndView createPenetrationBaseInfo(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HashMap<String, Object> param = new HashMap<String, Object>();
		param.put("EquipNo",request.getParameter("EquipNo"));
		param.put("LocNo",request.getParameter("LocNo"));
		param.put("ManagementNo",request.getParameter("ManagementNo"));
		param.put("PenetrationNo",request.getParameter("PenetrationNo"));
		param.put("ManagementAreaYN",request.getParameter("ManagementAreaYN"));
		param.put("Elevation",request.getParameter("Elevation"));
		param.put("FirePreventionAreaNo",request.getParameter("FirePreventionAreaNo"));
		param.put("InspectionRoomNo",request.getParameter("InspectionRoomNo"));
		param.put("BackRoomNo",request.getParameter("BackRoomNo"));
		param.put("PenetrationForm",request.getParameter("PenetrationForm"));
		param.put("Wall_FloorNo",request.getParameter("Wall_FloorNo"));
		param.put("FirewallYN",request.getParameter("FirewallYN"));
		param.put("WallMeterial",request.getParameter("WallMeterial"));
		param.put("WallThickness",request.getParameter("WallThickness"));
		param.put("FrontPicNo",request.getParameter("FrontPicNo"));
		param.put("BackPicNo",request.getParameter("BackPicNo"));
		param.put("ReferenceFloorPlanNo",request.getParameter("ReferenceFloorPlanNo"));
		param.put("LocationFloorPlanNo",request.getParameter("LocationFloorPlanNo"));
		param.put("SealDetailDWG",request.getParameter("SealDetailDWG"));
		param.put("EL",request.getParameter("EL"));
		param.put("Diameter",request.getParameter("Diameter"));
		param.put("Height",request.getParameter("Height"));
		param.put("Length",request.getParameter("Length"));
		param.put("PenetrationType",request.getParameter("PenetrationType"));
		param.put("MaximumFreeArea",request.getParameter("MaximumFreeArea"));
		param.put("MaximumFreeDistance",request.getParameter("MaximumFreeDistance"));
		param.put("Register",request.getParameter("Register"));
		param.put("Reviewer",request.getParameter("Reviewer"));
		param.put("Checker",request.getParameter("Checker"));
		param.put("SpecialNote",request.getParameter("SpecialNote"));
		param.put("RegID",((HashMap<String, Object>)request.getSession().getAttribute("userInfo")).get("id"));
		HashMap<String,Object> result = penetrationBaseInfoDao.save(param);
		return new ModelAndView("JsonView", "result", result);
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value="/penetrationbaseinfo.do", params="command=delete")
	public ModelAndView deletePenetrationBaseInfo(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HashMap<String, Object> param = new HashMap<String, Object>();
		param.put("Seq",request.getParameter("Seq"));
		param.put("RegID",((HashMap<String, Object>)request.getSession().getAttribute("userInfo")).get("id"));
		HashMap<String,Object> result = penetrationBaseInfoDao.delete(param);
		return new ModelAndView("JsonView", "result", result);
	}
	
	
	@RequestMapping(value="/penetrationbaseinfo.do", params="command=getList")
	public ModelAndView getPenetrationBaseInfoList(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HashMap<String, Object> param = new HashMap<String, Object>();
//		param.put("Seq",request.getParameter("Seq"));
		param.put("ManagementNo",request.getParameter("ManagementNo"));
		param.put("PenetrationNo",request.getParameter("PenetrationNo"));
		param.put("ManagementAreaYN",request.getParameter("ManagementAreaYN"));
		param.put("Elevation",request.getParameter("Elevation"));
		param.put("FirePreventionAreaNo",request.getParameter("FirePreventionAreaNo"));
		param.put("InspectionRoomNo",request.getParameter("InspectionRoomNo"));
		param.put("BackRoomNo",request.getParameter("BackRoomNo"));
		param.put("PenetrationForm",request.getParameter("PenetrationForm"));
		param.put("Wall_FloorNo",request.getParameter("Wall_FloorNo"));
		param.put("FirewallYN",request.getParameter("FirewallYN"));
		param.put("WallMeterial",request.getParameter("WallMeterial"));
		param.put("WallThickness",request.getParameter("WallThickness"));
		param.put("FrontPicNo",request.getParameter("FrontPicNo"));
		param.put("BackPicNo",request.getParameter("BackPicNo"));
		param.put("ReferenceFloorPlanNo",request.getParameter("ReferenceFloorPlanNo"));
		param.put("LocationFloorPlanNo",request.getParameter("LocationFloorPlanNo"));
		param.put("SealDetailDWG",request.getParameter("SealDetailDWG"));
		param.put("EL",request.getParameter("EL"));
		param.put("Diameter",request.getParameter("Diameter"));
		param.put("Height",request.getParameter("Height"));
		param.put("Length",request.getParameter("Length"));
		param.put("PenetrationType",request.getParameter("PenetrationType"));
		param.put("MaximumFreeArea",request.getParameter("MaximumFreeArea"));
		param.put("MaximumFreeDistance",request.getParameter("MaximumFreeDistance"));
		param.put("Register",request.getParameter("Register"));
		param.put("Reviewer",request.getParameter("Reviewer"));
		param.put("Checker",request.getParameter("Checker"));
		param.put("SpecialNote",request.getParameter("SpecialNote"));
		HashMap<String,Object> result = penetrationBaseInfoDao.getList(param);
		return new ModelAndView("JsonView", "result", result);
	}
}
