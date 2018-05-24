package controller;

import java.io.File;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import model.penetrationinspect.dao.PenetrationInspectDao;
import model.penetrationsearch.dao.PenetrationSearchDao;
import util.XlsxWrite;

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
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value="/penetrationsearch", params="command=getSearchView", method=RequestMethod.GET)
	public ModelAndView getSearchView(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HashMap<String, Object> param = new HashMap<String, Object>();
		param.put("ManagementNo",request.getParameter("ManagementNo"));
		param.put("PenetrationNo",request.getParameter("PenetrationNo"));
//		param.put("InspectSeq",request.getParameter("InspectSeq"));
		param.put("nowPage","1");
		List<HashMap<String,Object>> result = (List<HashMap<String,Object>>)(penetrationSearchDao.getList(param).get("DataList"));
		ModelAndView mdv = new ModelAndView("penetrationsearchview");
		mdv.getModel().putAll(result.get(0));
		
		param.clear();
		param.put("ManagementNo",request.getParameter("ManagementNo"));
		param.put("PenetrationNo",request.getParameter("PenetrationNo"));
		param.put("RealPath",request.getSession().getServletContext().getRealPath(""));
		result = (List<HashMap<String,Object>>)(penetrationInspectDao.getList(param).get("DataList"));
		mdv.getModel().put("InspectList",result);
		
		return mdv;
	}
	
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value="/penetrationsearch", params="command=getSearchEditView", method=RequestMethod.GET)
	public ModelAndView getSearchEditView(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HashMap<String, Object> param = new HashMap<String, Object>();
		param.put("ManagementNo",request.getParameter("ManagementNo"));
		param.put("PenetrationNo",request.getParameter("PenetrationNo"));
//		param.put("InspectSeq",request.getParameter("InspectSeq"));
		param.put("nowPage","1");
		List<HashMap<String,Object>> result = (List<HashMap<String,Object>>)(penetrationSearchDao.getList(param).get("DataList"));
		ModelAndView mdv = new ModelAndView("penetrationsearcheditview");
		mdv.getModel().putAll(result.get(0));
		
		param.clear();
		param.put("ManagementNo",request.getParameter("ManagementNo"));
		param.put("PenetrationNo",request.getParameter("PenetrationNo"));

		param.put("RealPath",request.getSession().getServletContext().getRealPath(""));
		result = (List<HashMap<String,Object>>)(penetrationInspectDao.getList(param).get("DataList"));
		mdv.getModel().put("InspectList",result);
		
		return mdv;
	}
	@RequestMapping(value="/penetrationsearch", params="command=getSearchCreateView", method=RequestMethod.GET)
	public ModelAndView getSearchCreateView(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mdv = new ModelAndView("penetrationsearchcreateview");
		mdv.getModel().put("InspectList",null);
		return mdv;
	}
	@RequestMapping(value="/penetrationsearch.do", params="command=getList")
	public ModelAndView getPenetrationBaseInfoList(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		int nowPage=1;  
		if(request.getParameter("nowPage")!=null && !request.getParameter("nowPage").toString().equals("")){
			nowPage=Integer.parseInt(request.getParameter("nowPage"));   
		}
		HashMap<String, Object> param = new HashMap<String, Object>();
		param.put("ManagementNo",request.getParameter("ManagementNo"));
		param.put("PenetrationNo",request.getParameter("PenetrationNo"));
		param.put("Equip",request.getParameter("Equip"));
		param.put("ELEVATION_cal_flag",request.getParameter("ELEVATION_cal_flag"));
		param.put("ELEVATION_num_pit",request.getParameter("ELEVATION_num_pit"));
		param.put("ELEVATION_num_inc",request.getParameter("ELEVATION_num_inc"));
		param.put("ELEVATION_cal_flag_2",request.getParameter("ELEVATION_cal_flag_2"));
		param.put("ELEVATION_num_pit_2",request.getParameter("ELEVATION_num_pit_2"));
		param.put("ELEVATION_num_inc_2",request.getParameter("ELEVATION_num_inc_2"));

		param.put("Diameter_cal_flag",request.getParameter("Diameter_cal_flag"));
		param.put("Diameter_num_pit",request.getParameter("Diameter_num_pit"));
		param.put("Diameter_num_inc",request.getParameter("Diameter_num_inc"));

		param.put("Height_cal_flag",request.getParameter("Height_cal_flag"));
		param.put("Height_num_pit",request.getParameter("Height_num_pit"));
		param.put("Height_num_inc",request.getParameter("Height_num_inc"));

		param.put("Length_cal_flag",request.getParameter("Length_cal_flag"));
		param.put("Length_num_pit",request.getParameter("Length_num_pit"));
		param.put("Length_num_inc",request.getParameter("Length_num_inc"));
		
		param.put("Location",request.getParameter("Location"));
		param.put("WallMeterial",request.getParameter("WallMeterial"));
		param.put("ConstructionState",request.getParameter("ConstructionState"));
		param.put("Area",request.getParameter("Area"));
		param.put("Wall_YN",request.getParameter("Wall_YN"));
		param.put("Efficient",request.getParameter("Efficient"));
		param.put("Result",request.getParameter("Result"));
		param.put("InspectionInterval",request.getParameter("InspectionInterval"));
		param.put("ManagementObjYN",request.getParameter("ManagementObjYN"));
		param.put("nowPage",nowPage);
	
		HashMap<String,Object> result = penetrationSearchDao.getList(param);
		return new ModelAndView("JsonView", "result", result);
	}
	
	
	@RequestMapping(value="/penetrationsearch.do", params="command=getExcelData")
	public ModelAndView getExcelData(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		int nowPage=1;  
		if(request.getParameter("nowPage")!=null && !request.getParameter("nowPage").toString().equals("")){
			nowPage=Integer.parseInt(request.getParameter("nowPage"));   
		}
		HashMap<String, Object> param = new HashMap<String, Object>();
		param.put("ManagementNo",request.getParameter("ManagementNo"));
		param.put("PenetrationNo",request.getParameter("PenetrationNo"));
		param.put("Equip",request.getParameter("Equip"));
		param.put("ELEVATION_cal_flag",request.getParameter("ELEVATION_cal_flag"));
		param.put("ELEVATION_num_pit",request.getParameter("ELEVATION_num_pit"));
		param.put("ELEVATION_num_inc",request.getParameter("ELEVATION_num_inc"));
		param.put("ELEVATION_cal_flag_2",request.getParameter("ELEVATION_cal_flag_2"));
		param.put("ELEVATION_num_pit_2",request.getParameter("ELEVATION_num_pit_2"));
		param.put("ELEVATION_num_inc_2",request.getParameter("ELEVATION_num_inc_2"));

		param.put("Diameter_cal_flag",request.getParameter("Diameter_cal_flag"));
		param.put("Diameter_num_pit",request.getParameter("Diameter_num_pit"));
		param.put("Diameter_num_inc",request.getParameter("Diameter_num_inc"));

		param.put("Height_cal_flag",request.getParameter("Height_cal_flag"));
		param.put("Height_num_pit",request.getParameter("Height_num_pit"));
		param.put("Height_num_inc",request.getParameter("Height_num_inc"));

		param.put("Length_cal_flag",request.getParameter("Length_cal_flag"));
		param.put("Length_num_pit",request.getParameter("Length_num_pit"));
		param.put("Length_num_inc",request.getParameter("Length_num_inc"));
		
		param.put("Location",request.getParameter("Location"));
		param.put("WallMeterial",request.getParameter("WallMeterial"));
		param.put("ConstructionState",request.getParameter("ConstructionState"));
		param.put("Area",request.getParameter("Area"));
		param.put("Wall_YN",request.getParameter("Wall_YN"));
		param.put("Efficient",request.getParameter("Efficient"));
		param.put("Result",request.getParameter("Result"));
		param.put("InspectionInterval",request.getParameter("InspectionInterval"));
		param.put("ManagementObjYN",request.getParameter("ManagementObjYN"));
		param.put("nowPage",nowPage);
	
		List<HashMap<String,String>> list = penetrationSearchDao.getExcelData(param);
		XlsxWrite xlsw = new XlsxWrite();
		String path = request.getSession().getServletContext().getRealPath("") + "ExcelData\\";
		String fileName = xlsw.chartExcel(list, path);
		
		HashMap<String,String> result = new HashMap<String,String>();
		result.put("FileName", fileName);
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
		param.put("InspectSeq",request.getParameter("InspectSeq"));
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
		param.put("InspectSeq",request.getParameter("InspectSeq"));
		param.put("photoName",request.getParameter("photoName"));
		param.put("RealPath",request.getSession().getServletContext().getRealPath(""));
		HashMap<String,Object> result = penetrationSearchDao.getBackImg(param);
		return new ModelAndView("JsonView", "result", result);
	}
	
	
	@RequestMapping(value="/penetrationsearch.do", params="command=checkSealMeterial")
	public ModelAndView checkSealMeterial(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HashMap<String, Object> param = new HashMap<String, Object>();
		param.put("SealMeterial_name",request.getParameter("SealMeterial_name"));
		HashMap<String,Object> result = penetrationSearchDao.checkSealMeterial(param);
		return new ModelAndView("JsonView", "result", result);
	}
	@RequestMapping(value="/penetrationsearch.do", params="command=checkSealantConditionState")
	public ModelAndView checkSealantConditionState(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HashMap<String, Object> param = new HashMap<String, Object>();
		param.put("SealMeterial_name",request.getParameter("SealantConditionState_name"));
		HashMap<String,Object> result = penetrationSearchDao.checkSealantConditionState(param);
		return new ModelAndView("JsonView", "result", result);
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value="/penetrationsearch.do", params="command=updatePenetrationAllInfo")
	public ModelAndView updatePenetrationAllInfo(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HashMap<String, Object> param = new HashMap<String, Object>();
		param.put("EquipNo",request.getParameter("EquipNo").replace("'","''"));
		param.put("LocNo",request.getParameter("LocNo").replace("'","''"));
		param.put("ManagementNo",request.getParameter("ManagementNo").replace("'","''"));
		param.put("PenetrationNo",request.getParameter("PenetrationNo").replace("'","''"));
		param.put("ManagementAreaYN",request.getParameter("ManagementAreaYN").replace("'","''"));
		param.put("Elevation_num_pit",request.getParameter("Elevation_num_pit").replace("'","''"));
		param.put("Elevation_num_inc",request.getParameter("Elevation_num_inc").replace("'","''"));
		param.put("FirePreventionAreaNo",request.getParameter("FirePreventionAreaNo").replace("'","''"));
		param.put("InspectionRoomNo",request.getParameter("InspectionRoomNo").replace("'","''"));
		param.put("BackRoomNo",request.getParameter("BackRoomNo").replace("'","''"));
		param.put("PenetrationForm",request.getParameter("PenetrationForm").replace("'","''"));
		param.put("Wall_FloorNo",request.getParameter("Wall_FloorNo").replace("'","''"));
		param.put("FirewallYN",request.getParameter("FirewallYN").replace("'","''"));
		param.put("WallMeterial",request.getParameter("WallMeterial").replace("'","''"));
		param.put("WallThickness",request.getParameter("WallThickness").replace("'","''"));
		param.put("FrontPicNo",request.getParameter("FrontPicNo").replace("'","''"));
		param.put("BackPicNo",request.getParameter("BackPicNo").replace("'","''"));
		param.put("ReferenceFloorPlanNo",request.getParameter("ReferenceFloorPlanNo").replace("'","''"));
		param.put("LocationFloorPlanNo",request.getParameter("LocationFloorPlanNo").replace("'","''"));
		param.put("SealDetailDWG",request.getParameter("SealDetailDWG").replace("'","''"));
		param.put("EL",request.getParameter("EL").replace("'","''"));
		param.put("Diameter_num_pit",request.getParameter("Diameter_num_pit"));
		param.put("Diameter_num_inc",request.getParameter("Diameter_num_inc"));
		param.put("Height_num_pit",request.getParameter("Height_num_pit"));
		param.put("Height_num_inc",request.getParameter("Height_num_inc"));
		param.put("Length_num_pit",request.getParameter("Length_num_pit"));
		param.put("Length_num_inc",request.getParameter("Length_num_inc"));
		param.put("PenetrationType",request.getParameter("PenetrationType").replace("'","''"));
		param.put("MaximumFreeArea",request.getParameter("MaximumFreeArea").replace("'","''"));
		param.put("MaximumFreeDistance",request.getParameter("MaximumFreeDistance").replace("'","''"));
		param.put("Register",request.getParameter("Register").replace("'","''"));
		param.put("Reviewer",request.getParameter("Reviewer").replace("'","''"));
		param.put("Checker",request.getParameter("Checker").replace("'","''"));
		param.put("SpecialNote",request.getParameter("SpecialNote").replace("'","''"));
		param.put("SAFETY_CATEGORY",request.getParameter("SAFETY_CATEGORY").replace("'","''"));
		param.put("ANCHORTYPE",request.getParameter("ANCHORTYPE").replace("'","''"));
		param.put("LATERALMOVEMENT",request.getParameter("LATERALMOVEMENT").replace("'","''"));
		param.put("LINETEMPERATURE",request.getParameter("LINETEMPERATURE").replace("'","''"));
		param.put("VENTILATION_VALUE",request.getParameter("VENTILATION_VALUE").replace("'","''"));
		param.put("VENTILATION_VALUE_RANGE",request.getParameter("VENTILATION_VALUE_RANGE").replace("'","''"));
		param.put("VENTILATION_VAL_NO",request.getParameter("VENTILATION_VAL_NO").replace("'","''"));
		param.put("VENTILATION_JUDGMENT",request.getParameter("VENTILATION_JUDGMENT").replace("'","''"));
		param.put("VENTILATION_REASON",request.getParameter("VENTILATION_REASON").replace("'","''"));
		param.put("FIRE_VALUE",request.getParameter("FIRE_VALUE").replace("'","''"));
		param.put("FIRE_VALUE_RANGE",request.getParameter("FIRE_VALUE_RANGE").replace("'","''"));
		param.put("FIRE_VAL_NO",request.getParameter("FIRE_VAL_NO").replace("'","''"));
		param.put("FIRE_JUDGMENT",request.getParameter("FIRE_JUDGMENT").replace("'","''"));
		param.put("FIRE_REASON",request.getParameter("FIRE_REASON").replace("'","''"));
		param.put("RADIATION_VALUE",request.getParameter("RADIATION_VALUE").replace("'","''"));
		param.put("RADIATION_VALUE_RANGE",request.getParameter("RADIATION_VALUE_RANGE").replace("'","''"));
		param.put("RADIATION_VAL_NO",request.getParameter("RADIATION_VAL_NO").replace("'","''"));
		param.put("RADIATION_JUDGMENT",request.getParameter("RADIATION_JUDGMENT").replace("'","''"));
		param.put("RADIATION_REASON",request.getParameter("RADIATION_REASON").replace("'","''"));
		param.put("FLOOD_VALUE",request.getParameter("FLOOD_VALUE").replace("'","''"));
		param.put("FLOOD_VALUE_RANGE",request.getParameter("FLOOD_VALUE_RANGE").replace("'","''"));
		param.put("FLOOD_VAL_NO",request.getParameter("FLOOD_VAL_NO").replace("'","''"));
		param.put("FLOOD_JUDGMENT",request.getParameter("FLOOD_JUDGMENT").replace("'","''"));
		param.put("FLOOD_REASON",request.getParameter("FLOOD_REASON").replace("'","''"));
		param.put("PRESSURE_VALUE",request.getParameter("PRESSURE_VALUE").replace("'","''"));
		param.put("PRESSURE_VALUE_RANGE",request.getParameter("PRESSURE_VALUE_RANGE").replace("'","''"));
		param.put("PRESSURE_VAL_NO",request.getParameter("PRESSURE_VAL_NO").replace("'","''"));
		param.put("PRESSURE_JUDGMENT",request.getParameter("PRESSURE_JUDGMENT").replace("'","''"));
		param.put("PRESSURE_REASON",request.getParameter("PRESSURE_REASON").replace("'","''"));
		param.put("Pipe",request.getParameter("Pipe").replace("'","''"));
		param.put("Duct",request.getParameter("Duct").replace("'","''"));
		param.put("SectionTube",request.getParameter("SectionTube").replace("'","''"));
		param.put("Conduit",request.getParameter("Conduit").replace("'","''"));
		param.put("Cable",request.getParameter("Cable").replace("'","''"));
		param.put("Tray",request.getParameter("Tray").replace("'","''"));
		param.put("CoverTray",request.getParameter("CoverTray").replace("'","''"));
		param.put("Etc",request.getParameter("Etc").replace("'","''"));
		param.put("SealSealDetailDWG",request.getParameter("SealSealDetailDWG").replace("'","''"));
		param.put("SealQualityClass",request.getParameter("SealQualityClass").replace("'","''"));
		param.put("SealMeterial_name",request.getParameter("SealMeterial_name").replace("'","''"));
		param.put("SealThickness",request.getParameter("SealThickness").replace("'","''"));
		param.put("PressingBoardMeterial",request.getParameter("PressingBoardMeterial").replace("'","''"));
		param.put("PressingBoardThickness",request.getParameter("PressingBoardThickness").replace("'","''"));
		param.put("RegID",((HashMap<String, Object>)request.getSession().getAttribute("userInfo")).get("id"));
		HashMap<String,Object> result = new HashMap<String,Object>();

		try
		{			
			penetrationSearchDao.updatePenetrationAllInfo(param);
			result.put("result", true);
		}
		catch(Exception ex){
			result.put("result", false);
			result.put("msg", ex.getMessage());
		}
		return new ModelAndView("JsonView", "result", result);
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value="/penetrationsearch.do", params="command=insertPenetrationAllInfo")
	public ModelAndView insertPenetrationAllInfo(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HashMap<String, Object> param = new HashMap<String, Object>();
		param.put("EquipNo",request.getParameter("EquipNo").replace("'","''"));
		param.put("LocNo",request.getParameter("LocNo").replace("'","''"));
		param.put("ManagementNo",request.getParameter("ManagementNo").replace("'","''"));
		param.put("PenetrationNo",request.getParameter("PenetrationNo").replace("'","''"));
		param.put("ManagementAreaYN",request.getParameter("ManagementAreaYN").replace("'","''"));
		param.put("Elevation_num_pit",request.getParameter("Elevation_num_pit").replace("'","''"));
		param.put("Elevation_num_inc",request.getParameter("Elevation_num_inc").replace("'","''"));
		param.put("FirePreventionAreaNo",request.getParameter("FirePreventionAreaNo").replace("'","''"));
		param.put("InspectionRoomNo",request.getParameter("InspectionRoomNo").replace("'","''"));
		param.put("BackRoomNo",request.getParameter("BackRoomNo").replace("'","''"));
		param.put("PenetrationForm",request.getParameter("PenetrationForm").replace("'","''"));
		param.put("Wall_FloorNo",request.getParameter("Wall_FloorNo").replace("'","''"));
		param.put("FirewallYN",request.getParameter("FirewallYN").replace("'","''"));
		param.put("WallMeterial",request.getParameter("WallMeterial").replace("'","''"));
		param.put("WallThickness",request.getParameter("WallThickness").replace("'","''"));
		param.put("FrontPicNo",request.getParameter("FrontPicNo").replace("'","''"));
		param.put("BackPicNo",request.getParameter("BackPicNo").replace("'","''"));
		param.put("ReferenceFloorPlanNo",request.getParameter("ReferenceFloorPlanNo").replace("'","''"));
		param.put("LocationFloorPlanNo",request.getParameter("LocationFloorPlanNo").replace("'","''"));
		param.put("SealDetailDWG",request.getParameter("SealDetailDWG").replace("'","''"));
		param.put("EL",request.getParameter("EL").replace("'","''"));
		param.put("Diameter_num_pit",request.getParameter("Diameter_num_pit"));
		param.put("Diameter_num_inc",request.getParameter("Diameter_num_inc"));
		param.put("Height_num_pit",request.getParameter("Height_num_pit"));
		param.put("Height_num_inc",request.getParameter("Height_num_inc"));
		param.put("Length_num_pit",request.getParameter("Length_num_pit"));
		param.put("Length_num_inc",request.getParameter("Length_num_inc"));
		param.put("PenetrationType",request.getParameter("PenetrationType").replace("'","''"));
		param.put("MaximumFreeArea",request.getParameter("MaximumFreeArea").replace("'","''"));
		param.put("MaximumFreeDistance",request.getParameter("MaximumFreeDistance").replace("'","''"));
		param.put("Register",request.getParameter("Register").replace("'","''"));
		param.put("Reviewer",request.getParameter("Reviewer").replace("'","''"));
		param.put("Checker",request.getParameter("Checker").replace("'","''"));
		param.put("SpecialNote",request.getParameter("SpecialNote").replace("'","''"));
		param.put("SAFETY_CATEGORY",request.getParameter("SAFETY_CATEGORY").replace("'","''"));
		param.put("ANCHORTYPE",request.getParameter("ANCHORTYPE").replace("'","''"));
		param.put("LATERALMOVEMENT",request.getParameter("LATERALMOVEMENT").replace("'","''"));
		param.put("LINETEMPERATURE",request.getParameter("LINETEMPERATURE").replace("'","''"));
		param.put("VENTILATION_VALUE",request.getParameter("VENTILATION_VALUE").replace("'","''"));
		param.put("VENTILATION_VALUE_RANGE",request.getParameter("VENTILATION_VALUE_RANGE").replace("'","''"));
		param.put("VENTILATION_VAL_NO",request.getParameter("VENTILATION_VAL_NO").replace("'","''"));
		param.put("VENTILATION_JUDGMENT",request.getParameter("VENTILATION_JUDGMENT").replace("'","''"));
		param.put("VENTILATION_REASON",request.getParameter("VENTILATION_REASON").replace("'","''"));
		param.put("FIRE_VALUE",request.getParameter("FIRE_VALUE").replace("'","''"));
		param.put("FIRE_VALUE_RANGE",request.getParameter("FIRE_VALUE_RANGE").replace("'","''"));
		param.put("FIRE_VAL_NO",request.getParameter("FIRE_VAL_NO").replace("'","''"));
		param.put("FIRE_JUDGMENT",request.getParameter("FIRE_JUDGMENT").replace("'","''"));
		param.put("FIRE_REASON",request.getParameter("FIRE_REASON").replace("'","''"));
		param.put("RADIATION_VALUE",request.getParameter("RADIATION_VALUE").replace("'","''"));
		param.put("RADIATION_VALUE_RANGE",request.getParameter("RADIATION_VALUE_RANGE").replace("'","''"));
		param.put("RADIATION_VAL_NO",request.getParameter("RADIATION_VAL_NO").replace("'","''"));
		param.put("RADIATION_JUDGMENT",request.getParameter("RADIATION_JUDGMENT").replace("'","''"));
		param.put("RADIATION_REASON",request.getParameter("RADIATION_REASON").replace("'","''"));
		param.put("FLOOD_VALUE",request.getParameter("FLOOD_VALUE").replace("'","''"));
		param.put("FLOOD_VALUE_RANGE",request.getParameter("FLOOD_VALUE_RANGE").replace("'","''"));
		param.put("FLOOD_VAL_NO",request.getParameter("FLOOD_VAL_NO").replace("'","''"));
		param.put("FLOOD_JUDGMENT",request.getParameter("FLOOD_JUDGMENT").replace("'","''"));
		param.put("FLOOD_REASON",request.getParameter("FLOOD_REASON").replace("'","''"));
		param.put("PRESSURE_VALUE",request.getParameter("PRESSURE_VALUE").replace("'","''"));
		param.put("PRESSURE_VALUE_RANGE",request.getParameter("PRESSURE_VALUE_RANGE").replace("'","''"));
		param.put("PRESSURE_VAL_NO",request.getParameter("PRESSURE_VAL_NO").replace("'","''"));
		param.put("PRESSURE_JUDGMENT",request.getParameter("PRESSURE_JUDGMENT").replace("'","''"));
		param.put("PRESSURE_REASON",request.getParameter("PRESSURE_REASON").replace("'","''"));
		param.put("Pipe",request.getParameter("Pipe").replace("'","''"));
		param.put("Duct",request.getParameter("Duct").replace("'","''"));
		param.put("SectionTube",request.getParameter("SectionTube").replace("'","''"));
		param.put("Conduit",request.getParameter("Conduit").replace("'","''"));
		param.put("Cable",request.getParameter("Cable").replace("'","''"));
		param.put("Tray",request.getParameter("Tray").replace("'","''"));
		param.put("CoverTray",request.getParameter("CoverTray").replace("'","''"));
		param.put("Etc",request.getParameter("Etc").replace("'","''"));
		param.put("SealSealDetailDWG",request.getParameter("SealSealDetailDWG").replace("'","''"));
		param.put("SealQualityClass",request.getParameter("SealQualityClass").replace("'","''"));
		param.put("SealMeterial_name",request.getParameter("SealMeterial_name").replace("'","''"));
		param.put("SealThickness",request.getParameter("SealThickness").replace("'","''"));
		param.put("PressingBoardMeterial",request.getParameter("PressingBoardMeterial").replace("'","''"));
		param.put("PressingBoardThickness",request.getParameter("PressingBoardThickness").replace("'","''"));
		param.put("RegID",((HashMap<String, Object>)request.getSession().getAttribute("userInfo")).get("id"));
		HashMap<String,Object> result = new HashMap<String,Object>();

		try
		{			
			penetrationSearchDao.insertPenetrationAllInfo(param);
			result.put("result", true);
		}
		catch(Exception ex){
			result.put("result", false);
			result.put("msg", ex.getMessage());
		}
		return new ModelAndView("JsonView", "result", result);
	}

	@SuppressWarnings("unchecked")
	@RequestMapping(value="/penetrationsearch.do", params="command=delete")
	public ModelAndView deletePenetrationAllInfo(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HashMap<String, Object> param = new HashMap<String, Object>();
		param.put("ManagementNo",request.getParameter("ManagementNo").replace("'","''"));
		param.put("PenetrationNo",request.getParameter("PenetrationNo").replace("'","''"));
		param.put("RegID",((HashMap<String, Object>)request.getSession().getAttribute("userInfo")).get("id"));
		HashMap<String,Object> result = new HashMap<String,Object>();

		try
		{			
			penetrationSearchDao.deleteAllInfo(param);
			result.put("result", true);
		}
		catch(Exception ex){
			result.put("result", false);
			result.put("msg", ex.getMessage());
		}
		return new ModelAndView("JsonView", "result", result);
	}
	
	@RequestMapping(value="/uploadPic",produces="application/text;charset=utf8")  
	@ResponseBody  
	public String uploadPic(@RequestParam("uploadFile") CommonsMultipartFile file, HttpServletRequest request, HttpServletResponse response) throws Exception {  
	    String path = request.getSession().getServletContext().getRealPath("DownLoadImg");
	    String FileName = request.getParameter("ImgName");
	    String resMsg = "";
	    try {

	        long  startTime=System.currentTimeMillis();

	        System.out.println("fileName："+file.getOriginalFilename());
	        path += "\\"+FileName + ".png";
	        System.out.println("path:" + path);
	        
	        File newFile=new File(path);
	        newFile.deleteOnExit();
	        //通过CommonsMultipartFile的方法直接写文件
	       
	        file.transferTo(new File(path));
	        long  endTime=System.currentTimeMillis();
	        System.out.println("근무시간："+String.valueOf(endTime-startTime)+"ms");
	        resMsg = "DownLoadImg/"+FileName;
	    } catch (IllegalStateException e) {
	        // TODO Auto-generated catch block
	        e.printStackTrace();
	        resMsg = "0";
	    }
	    return resMsg; 
	} 

}
