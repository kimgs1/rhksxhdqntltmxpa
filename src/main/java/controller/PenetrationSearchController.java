package controller;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import model.penetrationinspect.dao.PenetrationInspectDao;
import model.penetrationsearch.dao.PenetrationSearchDao;

@Controller
public class PenetrationSearchController {

	@Autowired
	PenetrationSearchDao penetrationSearchDao;
	@Autowired
	PenetrationInspectDao penetrationInspectDao;
	
	@RequestMapping(value="/penetrationsearch", method=RequestMethod.GET)
	public ModelAndView baseView() throws Exception {
		return new ModelAndView("penetrationsearch");
	}
	@RequestMapping(value="/penetrationsearch.do", params="command=getList")
	public ModelAndView getPenetrationBaseInfoList(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HashMap<String, Object> param = new HashMap<String, Object>();
		param.put("ManagementNo",request.getParameter("ManagementNo"));
		param.put("PenetrationNo",request.getParameter("PenetrationNo"));
		param.put("ELEVATION",request.getParameter("ELEVATION"));
		param.put("Location",request.getParameter("Location"));
		param.put("WallMeterial",request.getParameter("WallMeterial"));
		param.put("ConstructionState",request.getParameter("ConstructionState"));
	
		HashMap<String,Object> result = penetrationSearchDao.getList(param);
		return new ModelAndView("JsonView", "result", result);
	}
	
	
	@RequestMapping(value="/penetrationsearch.do", params="command=LocChart")
	public ModelAndView getLocChart(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HashMap<String, Object> param = new HashMap<String, Object>();
		HashMap<String,Object> result = penetrationSearchDao.getLocChart(param);
		return new ModelAndView("JsonView", "result", result);
	}
	@RequestMapping(value="/penetrationsearch.do", params="command=WallMeterialChart")
	public ModelAndView getWallMeterialChart(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HashMap<String, Object> param = new HashMap<String, Object>();
		HashMap<String,Object> result = penetrationSearchDao.getWallMeterialChart(param);
		return new ModelAndView("JsonView", "result", result);
	}
	@RequestMapping(value="/penetrationsearch.do", params="command=ConstructionStateChart")
	public ModelAndView getConstructionStateChart(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HashMap<String, Object> param = new HashMap<String, Object>();
		HashMap<String,Object> result = penetrationSearchDao.getConstructionStateChart(param);
		return new ModelAndView("JsonView", "result", result);
	}
	

	@RequestMapping(value="/penetrationsearch.do", params="command=DepartmentChart")
	public ModelAndView getDepartmentChart(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HashMap<String, Object> param = new HashMap<String, Object>();
		HashMap<String,Object> result = penetrationSearchDao.getDepartmentChart(param);
		return new ModelAndView("JsonView", "result", result);
	}
	@RequestMapping(value="/penetrationsearch.do", params="command=EffectChart")
	public ModelAndView getEffectChart(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HashMap<String, Object> param = new HashMap<String, Object>();
		HashMap<String,Object> result = penetrationSearchDao.getEffectChart(param);
		return new ModelAndView("JsonView", "result", result);
	}
	@RequestMapping(value="/penetrationsearch.do", params="command=sealantMaterialChart")
	public ModelAndView getsealantMaterialChart(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HashMap<String, Object> param = new HashMap<String, Object>();
		HashMap<String,Object> result = penetrationSearchDao.getsealantMaterialChart(param);
		return new ModelAndView("JsonView", "result", result);
	}
	@RequestMapping(value="/penetrationsearch.do", params="command=EquipNoLocNoData")
	public ModelAndView getEquipNoLocNoData(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HashMap<String, Object> param = new HashMap<String, Object>();
		HashMap<String,Object> result = penetrationSearchDao.getEquipNoLocNoData(param);
		return new ModelAndView("JsonView", "result", result);
	}
	
	
	@RequestMapping(value="/penetrationsearch.do", params="command=TotalCount")
	public ModelAndView getTotalCount(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HashMap<String, Object> param = new HashMap<String, Object>();
		HashMap<String,Object> result = penetrationSearchDao.getTotalCount(param);
		return new ModelAndView("JsonView", "result", result);
	}
	
	@RequestMapping(value="/penetrationsearch.do", params="command=MergeData")
	public ModelAndView getMergeData(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HashMap<String, Object> param = new HashMap<String, Object>();
		HashMap<String,Object> result = penetrationSearchDao.getMergeData(param);
		return new ModelAndView("JsonView", "result", result);
	}
	
	@RequestMapping(value="/penetrationsearch.do", params="command=getFrontImg")
	public ModelAndView getFrontImg(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HashMap<String, Object> param = new HashMap<String, Object>();
		param.put("ManagementNo",request.getParameter("ManagementNo"));
		param.put("PenetrationNo",request.getParameter("PenetrationNo"));
		param.put("photoName",request.getParameter("photoName"));
		param.put("RealPath",request.getSession().getServletContext().getRealPath(""));
		HashMap<String,Object> result = penetrationSearchDao.getFrontImg(param);
		return new ModelAndView("JsonView", "result", result);
	}
	@RequestMapping(value="/penetrationsearch.do", params="command=getBackImg")
	public ModelAndView getBackImg(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HashMap<String, Object> param = new HashMap<String, Object>();
		param.put("ManagementNo",request.getParameter("ManagementNo"));
		param.put("PenetrationNo",request.getParameter("PenetrationNo"));
		param.put("photoName",request.getParameter("photoName"));
		param.put("RealPath",request.getSession().getServletContext().getRealPath(""));
		HashMap<String,Object> result = penetrationSearchDao.getBackImg(param);
		return new ModelAndView("JsonView", "result", result);
	}
	
	
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value="/penetrationsearch", params="command=getSearchView", method=RequestMethod.GET)
	public ModelAndView getSearchView(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HashMap<String, Object> param = new HashMap<String, Object>();
		param.put("ManagementNo",request.getParameter("ManagementNo"));
		param.put("PenetrationNo",request.getParameter("PenetrationNo"));
		param.put("InspectSeq",request.getParameter("InspectSeq"));
		List<HashMap<String,Object>> result = (List<HashMap<String,Object>>)(penetrationSearchDao.getList(param).get("DataList"));
		ModelAndView mdv = new ModelAndView("penetrationsearchview");
		mdv.getModel().put("EquipNo",result.get(0).get("EquipNo"));
		mdv.getModel().put("EquipNo_name",result.get(0).get("EquipNo_name"));
		mdv.getModel().put("LocNo",result.get(0).get("LocNo"));
		mdv.getModel().put("LocNo_name",result.get(0).get("LocNo_name"));
		mdv.getModel().put("ManagementNo",result.get(0).get("ManagementNo"));
		mdv.getModel().put("PenetrationNo",result.get(0).get("PenetrationNo"));
		mdv.getModel().put("ManagementAreaYN",result.get(0).get("ManagementAreaYN"));
		mdv.getModel().put("Elevation",result.get(0).get("Elevation"));
		mdv.getModel().put("FirePreventionAreaNo",result.get(0).get("FirePreventionAreaNo"));
		mdv.getModel().put("InspectionRoomNo",result.get(0).get("InspectionRoomNo"));
		mdv.getModel().put("BackRoomNo",result.get(0).get("BackRoomNo"));
		mdv.getModel().put("PenetrationForm",result.get(0).get("PenetrationForm"));
		mdv.getModel().put("PenetrationForm_name",result.get(0).get("PenetrationForm_name"));
		mdv.getModel().put("Wall_FloorNo",result.get(0).get("Wall_FloorNo"));
		mdv.getModel().put("FirewallYN",result.get(0).get("FirewallYN"));
		mdv.getModel().put("FirewallYN_name",result.get(0).get("FirewallYN_name"));
		mdv.getModel().put("WallMeterial",result.get(0).get("WallMeterial"));
		mdv.getModel().put("WallMeterial_name",result.get(0).get("WallMeterial_name"));
		mdv.getModel().put("WallThickness",result.get(0).get("WallThickness"));
		mdv.getModel().put("FrontPicNo",result.get(0).get("FrontPicNo"));
		mdv.getModel().put("BackPicNo",result.get(0).get("BackPicNo"));
		mdv.getModel().put("ReferenceFloorPlanNo",result.get(0).get("ReferenceFloorPlanNo"));
		mdv.getModel().put("LocationFloorPlanNo",result.get(0).get("LocationFloorPlanNo"));
		mdv.getModel().put("SealDetailDWG",result.get(0).get("SealDetailDWG"));
		mdv.getModel().put("EL",result.get(0).get("EL"));
		mdv.getModel().put("Diameter",result.get(0).get("Diameter"));
		mdv.getModel().put("Height",result.get(0).get("Height"));
		mdv.getModel().put("Length",result.get(0).get("Length"));
		mdv.getModel().put("PenetrationType",result.get(0).get("PenetrationType"));
		mdv.getModel().put("MaximumFreeArea",result.get(0).get("MaximumFreeArea"));
		mdv.getModel().put("MaximumFreeDistance",result.get(0).get("MaximumFreeDistance"));
		mdv.getModel().put("SAFETY_CATEGORY",result.get(0).get("SAFETY_CATEGORY"));
		mdv.getModel().put("ANCHORTYPE",result.get(0).get("ANCHORTYPE"));
		mdv.getModel().put("LATERALMOVEMENT",result.get(0).get("LATERALMOVEMENT"));
		mdv.getModel().put("LINETEMPERATURE",result.get(0).get("LINETEMPERATURE"));
		mdv.getModel().put("VENTILATION_VALUE",result.get(0).get("VENTILATION_VALUE"));
		mdv.getModel().put("VENTILATION_VALUE_RANGE",result.get(0).get("VENTILATION_VALUE_RANGE"));
		mdv.getModel().put("VENTILATION_VAL_NO",result.get(0).get("VENTILATION_VAL_NO"));
		mdv.getModel().put("VENTILATION_JUDGMENT",result.get(0).get("VENTILATION_JUDGMENT"));
		mdv.getModel().put("VENTILATION_REASON",result.get(0).get("VENTILATION_REASON"));
		mdv.getModel().put("FIRE_VALUE",result.get(0).get("FIRE_VALUE"));
		mdv.getModel().put("FIRE_VALUE_RANGE",result.get(0).get("FIRE_VALUE_RANGE"));
		mdv.getModel().put("FIRE_VAL_NO",result.get(0).get("FIRE_VAL_NO"));
		mdv.getModel().put("FIRE_JUDGMENT",result.get(0).get("FIRE_JUDGMENT"));
		mdv.getModel().put("FIRE_REASON",result.get(0).get("FIRE_REASON"));
		mdv.getModel().put("RADIATION_VALUE",result.get(0).get("RADIATION_VALUE"));
		mdv.getModel().put("RADIATION_VALUE_RANGE",result.get(0).get("RADIATION_VALUE_RANGE"));
		mdv.getModel().put("RADIATION_VAL_NO",result.get(0).get("RADIATION_VAL_NO"));
		mdv.getModel().put("RADIATION_JUDGMENT",result.get(0).get("RADIATION_JUDGMENT"));
		mdv.getModel().put("RADIATION_REASON",result.get(0).get("RADIATION_REASON"));
		mdv.getModel().put("FLOOD_VALUE",result.get(0).get("FLOOD_VALUE"));
		mdv.getModel().put("FLOOD_VALUE_RANGE",result.get(0).get("FLOOD_VALUE_RANGE"));
		mdv.getModel().put("FLOOD_VAL_NO",result.get(0).get("FLOOD_VAL_NO"));
		mdv.getModel().put("FLOOD_JUDGMENT",result.get(0).get("FLOOD_JUDGMENT"));
		mdv.getModel().put("FLOOD_REASON",result.get(0).get("FLOOD_REASON"));
		mdv.getModel().put("PRESSURE_VALUE",result.get(0).get("PRESSURE_VALUE"));
		mdv.getModel().put("PRESSURE_VALUE_RANGE",result.get(0).get("PRESSURE_VALUE_RANGE"));
		mdv.getModel().put("PRESSURE_VAL_NO",result.get(0).get("PRESSURE_VAL_NO"));
		mdv.getModel().put("PRESSURE_JUDGMENT",result.get(0).get("PRESSURE_JUDGMENT"));
		mdv.getModel().put("PRESSURE_REASON",result.get(0).get("PRESSURE_REASON"));
		mdv.getModel().put("Register",result.get(0).get("Register"));
		mdv.getModel().put("Register_date",result.get(0).get("Register_date"));
		mdv.getModel().put("Reviewer",result.get(0).get("Reviewer"));
		mdv.getModel().put("Reviewer_date",result.get(0).get("Reviewer_date"));
		mdv.getModel().put("Supporter",result.get(0).get("Supporter"));
		mdv.getModel().put("Supporter_date",result.get(0).get("Supporter_date"));
		mdv.getModel().put("Technicker",result.get(0).get("Technicker"));
		mdv.getModel().put("Technicker_date",result.get(0).get("Technicker_date"));
		mdv.getModel().put("Checker",result.get(0).get("Checker"));
		mdv.getModel().put("Checker_date",result.get(0).get("Checker_date"));
		mdv.getModel().put("CertificationYN",result.get(0).get("CertificationYN"));
		mdv.getModel().put("Com_name",result.get(0).get("Com_name"));
		mdv.getModel().put("ManagementObjYN",result.get(0).get("ManagementObjYN"));
		mdv.getModel().put("NewYN",result.get(0).get("NewYN"));
		mdv.getModel().put("Wall_Fire_time",result.get(0).get("Wall_Fire_time"));
		mdv.getModel().put("SpecialNote",result.get(0).get("SpecialNote"));
		mdv.getModel().put("matter",result.get(0).get("matter"));
		mdv.getModel().put("matter_name",result.get(0).get("matter_name"));
		mdv.getModel().put("Pipe",result.get(0).get("Pipe"));
		mdv.getModel().put("Duct",result.get(0).get("Duct"));
		mdv.getModel().put("SectionTube",result.get(0).get("SectionTube"));
		mdv.getModel().put("Conduit",result.get(0).get("Conduit"));
		mdv.getModel().put("Cable",result.get(0).get("Cable"));
		mdv.getModel().put("Tray",result.get(0).get("Tray"));
		mdv.getModel().put("CoverTray",result.get(0).get("CoverTray"));
		mdv.getModel().put("Etc",result.get(0).get("Etc"));
		mdv.getModel().put("CAP_Not_Num",result.get(0).get("CAP_Not_Num"));
		mdv.getModel().put("InspectDate",result.get(0).get("InspectDate"));
		mdv.getModel().put("InspectSeq",result.get(0).get("InspectSeq"));
		mdv.getModel().put("ImproveDate",result.get(0).get("ImproveDate"));
		mdv.getModel().put("InspectionInterval",result.get(0).get("InspectionInterval"));
		mdv.getModel().put("SealantConditionState",result.get(0).get("SealantConditionState"));
		mdv.getModel().put("JudgementReason",result.get(0).get("JudgementReason"));
		mdv.getModel().put("Judgment",result.get(0).get("Judgment"));
		mdv.getModel().put("Judgment_name",result.get(0).get("Judgment_name"));
		mdv.getModel().put("ImproveNote",result.get(0).get("ImproveNote"));
		mdv.getModel().put("ConstructionState",result.get(0).get("ConstructionState"));
		mdv.getModel().put("ConstructionState_name",result.get(0).get("ConstructionState_name"));
		mdv.getModel().put("SealSealDetailDWG",result.get(0).get("SealSealDetailDWG"));
		mdv.getModel().put("SealQualityClass",result.get(0).get("SealQualityClass"));
		mdv.getModel().put("SealMeterial",result.get(0).get("SealMeterial"));
		mdv.getModel().put("SealThickness",result.get(0).get("SealThickness"));
		mdv.getModel().put("PressingBoardMeterial",result.get(0).get("PressingBoardMeterial"));
		mdv.getModel().put("PressingBoardThickness",result.get(0).get("PressingBoardThickness"));
		mdv.getModel().put("RepairQuantity",result.get(0).get("RepairQuantity"));
		mdv.getModel().put("Register",result.get(0).get("Register"));
		mdv.getModel().put("Reviewer",result.get(0).get("Reviewer"));
		mdv.getModel().put("Checker",result.get(0).get("Checker"));
		mdv.getModel().put("SealantSpecialNote",result.get(0).get("SealantSpecialNote"));
		mdv.getModel().put("RequirePerformance",result.get(0).get("RequirePerformance"));
		mdv.getModel().put("RequirePerformance_name",result.get(0).get("RequirePerformance_name"));
		mdv.getModel().put("EvaluationResult",result.get(0).get("EvaluationResult"));
		mdv.getModel().put("EvaluationResult_name",result.get(0).get("EvaluationResult_name"));
		mdv.getModel().put("FireResistanceRating",result.get(0).get("FireResistanceRating"));
		mdv.getModel().put("PSI",result.get(0).get("PSI"));
		mdv.getModel().put("WaterSeal",result.get(0).get("WaterSeal"));
		mdv.getModel().put("RadiationShield",result.get(0).get("RadiationShield"));
		
		param.clear();
		param.put("ManagementNo",request.getParameter("ManagementNo"));
		param.put("PenetrationNo",request.getParameter("PenetrationNo"));
		result = (List<HashMap<String,Object>>)(penetrationInspectDao.getList(param).get("DataList"));
		mdv.getModel().put("InspectList",result);
		
		return mdv;
	}
}
