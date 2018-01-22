package model.penetrationsearch.dao;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import pasing.PenetrationSearchPagingBean;

@Service
public class PenetrationSearchDaoImpl implements PenetrationSearchDao{
	@Resource
	private SqlSessionTemplate sqlSession;
//	@Resource
//	private SqlSessionFactoryBean sqlSessionFactory;
	@Override
	public HashMap<String, Object> getList(HashMap<String, Object> param) {
		// TODO Auto-generated method stub
		//		String cond = SqlStrProcess.getSearchString(null, param);
		//		param.put("cond", cond);


		String cond = "";
		if(param.containsKey("ManagementNo") &&param.get("ManagementNo")!= null &&  !param.get("ManagementNo").toString().equals("")){
			cond += " and pb.ManagementNo like '%"+param.get("ManagementNo")+"%' ";
		}
		if(param.containsKey("PenetrationNo") &&param.get("PenetrationNo")!= null &&  !param.get("PenetrationNo").toString().equals("")){
			cond += " and pb.PenetrationNo like '%"+param.get("PenetrationNo")+"%' ";
		}


		if(param.containsKey("ELEVATION_num_pit") &&param.get("ELEVATION_num_pit")!= null &&  !param.get("ELEVATION_num_pit").toString().equals("")){
			if(param.containsKey("ELEVATION_num_inc") &&param.get("ELEVATION_num_inc")!= null &&  !param.get("ELEVATION_num_inc").toString().equals(""))
			{
				cond += " and pb.Elevation_num_pit * 12 + pb.Elevation_num_inc "+param.get("ELEVATION_cal_flag")+" "+param.get("ELEVATION_num_pit")+" * 12 + " + param.get("ELEVATION_num_inc");
			}
		}
		if(param.containsKey("Equip") &&param.get("Equip")!= null &&  !param.get("Equip").toString().equals("")){
			cond += " and pb.EquipNo = '"+param.get("Equip")+"' ";
		}
		if(param.containsKey("Location") &&param.get("Location")!= null &&  !param.get("Location").toString().equals("")){
			cond += " and pb.LocNo like '%"+param.get("Location")+"%' ";
		}

		if(param.containsKey("WallMeterial") && param.get("WallMeterial")!= null &&  !param.get("WallMeterial").toString().equals("")){
			cond += " and pb.WallMeterial in ("+param.get("WallMeterial")+")";
		}

		if(param.containsKey("ConstructionState") && param.get("ConstructionState")!= null &&  !param.get("ConstructionState").toString().equals("")){
			String condSub = " and (";
			for(String constractionStateValue : param.get("ConstructionState").toString().split(",")){

				condSub += " or (select count(*) from penetrationmaterialcodeinfo pm "
						+ "where pm.ManagementNo = p.ManagementNo and pm.PenetrationNo = p.PenetrationNo and pm.InspectSeq = pi.InspectSeq "
						+ "and pm.codeID = "+constractionStateValue+" ) >= 1 " ;
			}
			condSub += " ) ";
			
			condSub = condSub.replace("( or", "(");
			cond += condSub;
		}
		if(param.containsKey("Area") && param.get("Area")!= null &&  !param.get("Area").toString().equals("")){
			cond += " and pb.PenetrationDept in ("+param.get("Area")+")";
		}
		if(param.containsKey("Wall_YN") && param.get("Wall_YN")!= null &&  !param.get("Wall_YN").toString().equals("")){
			cond += " and dbo.GetCodeInfoRemarkByID(pb.WallMeterial) in ("+param.get("Wall_YN")+")";
		}
		if(param.containsKey("Efficient") && param.get("Efficient")!= null &&  !param.get("Efficient").toString().equals("")){
			String condSub = " and (";
			for(String EfficientValue : param.get("Efficient").toString().split(",")){
				String colName = "";
				if(EfficientValue.equals("'A0601'")){
					colName = "VENTILATION_VALUE";
				}
				else if(EfficientValue.equals("'A0602'")){
					colName = "FIRE_VALUE";
				}
				else if(EfficientValue.equals("'A0603'")){
					colName = "RADIATION_VALUE";
				}
				else if(EfficientValue.equals("'A0604'")){
					colName = "FLOOD_VALUE";
				}
				else if(EfficientValue.equals("'A0605'")){
					colName = "PRESSURE_VALUE";
				}
				else{
					continue;
				}
				condSub += " or pb."+colName+" = '○' ";
			}
			condSub += " ) ";
			
			condSub = condSub.replace("( or", "(");
			
			if(!condSub.equals(" and ( ) ")){
				cond += condSub;
			}
		}
		if(param.containsKey("Result") && param.get("Result")!= null &&  !param.get("Result").toString().equals("")){
			String condSub = " and (";
			for(String EfficientValue : param.get("Result").toString().split(",")){
				if(EfficientValue.equals("'A0501'")){		
					condSub += " or SUBSTRING(pb.PRESSURE_REASON, 1, 1) = '○' ";
				}
				else if(EfficientValue.equals("'A0502'")){
					condSub += " or SUBSTRING(pb.PRESSURE_REASON, 1, 1) != '○' ";
				}
				else{
					continue;
				}
			}
			condSub += " ) ";
			
			condSub = condSub.replace("( or", "(");
			
			if(!condSub.equals(" and ( ) ")){
				cond += condSub;
			}
		}
		if(param.containsKey("InspectSeq") && param.get("InspectSeq")!= null &&  !param.get("InspectSeq").toString().equals("")){
			cond += " and pi.InspectSeq in ("+param.get("InspectSeq")+") ";
		}
		if(param.containsKey("InspectSeq") && param.get("InspectSeq")!= null &&  !param.get("InspectSeq").toString().equals("")){
			cond += " and pi.InspectSeq in ("+param.get("InspectSeq")+") ";
		}
		param.put("cond", cond);

		int nowPage = Integer.parseInt(param.get("nowPage").toString());
		int totalCount =  sqlSession.selectOne("penetrationsearch.getListCount", param);
		
		PenetrationSearchPagingBean pagingBean = new PenetrationSearchPagingBean(totalCount,nowPage);
		
		param.put("low", PenetrationSearchPagingBean.numberOfContentPerPage * (nowPage - 1));
		param.put("high", PenetrationSearchPagingBean.numberOfContentPerPage * nowPage);
		List<HashMap<String,String>> sqlResult =  sqlSession.selectList("penetrationsearch.getList", param);
		HashMap<String,Object> result = new HashMap<String,Object>();
		result.put("DataList",sqlResult);
		result.put("pagingBean", pagingBean);
		return result;
	}
	@Override
	public HashMap<String, Object> getLocChart(HashMap<String, Object> param) {
		// TODO Auto-generated method stub
		List<HashMap<String,String>> sqlResult =  sqlSession.selectList("penetrationsearch.LocChart", param);
		HashMap<String,Object> result = new HashMap<String,Object>();
		result.put("DataList",sqlResult);
		return result;
	}
	@Override
	public HashMap<String, Object> getWallMeterialChart(HashMap<String, Object> param) {
		// TODO Auto-generated method stub

		List<HashMap<String,String>> sqlResult =  sqlSession.selectList("penetrationsearch.WallMeterialChart", param);
		HashMap<String,Object> result = new HashMap<String,Object>();
		result.put("DataList",sqlResult);
		return result;
	}
	@Override
	public HashMap<String, Object> getConstructionStateChart(HashMap<String, Object> param) {
		// TODO Auto-generated method stub

		List<HashMap<String,String>> sqlResult =  sqlSession.selectList("penetrationsearch.ConstructionStateChart", param);
		HashMap<String,Object> result = new HashMap<String,Object>();
		result.put("DataList",sqlResult);
		return result;
	}
	@Override
	public HashMap<String, Object> getDepartmentChart(HashMap<String, Object> param) {
		// TODO Auto-generated method stub
		List<HashMap<String,String>> sqlResult =  sqlSession.selectList("penetrationsearch.DepartmentChart", param);
		HashMap<String,Object> result = new HashMap<String,Object>();
		result.put("DataList",sqlResult);
		return result;
	}
	
	@Override
	public HashMap<String, Object> getEffectChart(HashMap<String, Object> param) {
		// TODO Auto-generated method stub
		HashMap<String,String> sqlResult =  sqlSession.selectOne("penetrationsearch.EffectChart", param);
		List<HashMap<String,Object>> convertedResult = new ArrayList<HashMap<String,Object>>();
		
		
		HashMap<String,Object> value1 = new HashMap<String,Object>();
		HashMap<String,Object> value2 = new HashMap<String,Object>();
		HashMap<String,Object> value3 = new HashMap<String,Object>();
		HashMap<String,Object> value4 = new HashMap<String,Object>();
		HashMap<String,Object> value5 = new HashMap<String,Object>();

		value1.put("value", sqlResult.get("value1"));
		value2.put("value", sqlResult.get("value2"));
		value3.put("value", sqlResult.get("value3"));
		value4.put("value", sqlResult.get("value4"));
		value5.put("value", sqlResult.get("value5"));
		
		value1.put("name","환기");
		value2.put("name","내화");
		value3.put("name","방사선 차폐");
		value4.put("name","수밀");
		value5.put("name","내압");

		convertedResult.add(value1);
		convertedResult.add(value2);
		convertedResult.add(value3);
		convertedResult.add(value4);
		convertedResult.add(value5);
		
		HashMap<String,Object> result = new HashMap<String,Object>();
		result.put("DataList",convertedResult);
		return result;
	}
	@Override
	public HashMap<String, Object> getsealantMaterialChart(HashMap<String, Object> param) {
		// TODO Auto-generated method stub
		List<HashMap<String,String>> sqlResult =  sqlSession.selectList("penetrationsearch.sealantMaterialChart", param);
		HashMap<String,Object> result = new HashMap<String,Object>();
		result.put("DataList",sqlResult);
		return result;
	}
	@Override
	public HashMap<String, Object> getEquipNoLocNoData(HashMap<String, Object> param) {
		// TODO Auto-generated method stub

		List<HashMap<String,String>> sqlResult =  sqlSession.selectList("penetrationsearch.EquipNoLocNoData", param);
		HashMap<String,Object> result = new HashMap<String,Object>();
		result.put("DataList",sqlResult);
		return result;
	}
	@Override
	public HashMap<String, Object> getTotalCount(HashMap<String, Object> param) {
		// TODO Auto-generated method stub
		List<HashMap<String,String>> sqlResult =  sqlSession.selectList("penetrationsearch.TotalCount", param);
		HashMap<String,Object> result = new HashMap<String,Object>();
		result.put("DataList",sqlResult);
		return result;
	}
	@Override
	public HashMap<String, Object> getMergeData(HashMap<String, Object> param) {
		// TODO Auto-generated method stub
		List<HashMap<String,String>> sqlResult =  sqlSession.selectList("penetrationsearch.MergeData", param);
		HashMap<String,Object> result = new HashMap<String,Object>();
		result.put("DataList",sqlResult);
		return result;
	}
	@Override
	public HashMap<String, Object> getFrontImg(HashMap<String, Object> param) {
		// TODO Auto-generated method stub
		HashMap<String,Object> result = new HashMap<String,Object>();

		byte[] sqlResult =  sqlSession.selectOne("penetrationsearch.getFrontPicImg", param);
		try{
			OutputStream out = new FileOutputStream(new File(param.get("RealPath") + "/DownLoadImg/" + param.get("photoName") + ".png"));

			out.write(sqlResult);
			out.flush();
			System.out.println("download success");
			out.close();

			result.put("result", "success");
			result.put("photoName", param.get("photoName")+ ".png");

		}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			result.put("result", "error");
			result.put("photoName", "");
		}

		result.put("DataList",sqlResult);
		return result;
	}
	@Override
	public HashMap<String, Object> getBackImg(HashMap<String, Object> param) {
		// TODO Auto-generated method stub
		
		HashMap<String,Object> result = new HashMap<String,Object>();

		byte[] sqlResult =  sqlSession.selectOne("penetrationsearch.getBackPicImg", param);
		try{
			OutputStream out = new FileOutputStream(new File(param.get("RealPath") + "/DownLoadImg/" + param.get("photoName") + ".png"));

			out.write(sqlResult);
			out.flush();
			System.out.println("download success");
			out.close();

			result.put("result", "success");
			result.put("photoName", param.get("photoName")+ ".png");

		}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			result.put("result", "error");
			result.put("photoName", "");
		}

		result.put("DataList",sqlResult);
		return result;
	}
	
	@Override
	@Transactional(propagation=Propagation.REQUIRED, rollbackFor=Exception.class)  
	public HashMap<String, Object> updatePenetrationAllData(HashMap<String, Object> param) {
		// TODO Auto-generated method stub
		
		sqlSession.update("penetrationsearch.testTran");
		return null;
	}
	@Override
	public HashMap<String, Object> checkSealMeterial(HashMap<String, Object> param) {
		// TODO Auto-generated method stub
		String resultFlag = "true";
		String cond = "";
		if(param.containsKey("SealMeterial_name") && param.get("SealMeterial_name")!= null &&  !param.get("SealMeterial_name").toString().equals("")){
			for(String SealMeterialName : param.get("SealMeterial_name").toString().split(",")){
				cond = "and  Remark = '" + SealMeterialName +"'";
				param.put("cond", cond);
				int sqlResult =  sqlSession.selectOne("penetrationsearch.checkSealMeterial", param);
				if(sqlResult == 0){
					resultFlag = "false";
				}
			}
		}
		HashMap<String,Object> result = new HashMap<String,Object>();
		result.put("resultFlag",resultFlag);
		return result;
	}
	@Override
	@Transactional(propagation=Propagation.REQUIRED, rollbackFor=Exception.class)  
	public HashMap<String, Object> updatePenetrationAllInfo(HashMap<String, Object> param) {
		// TODO Auto-generated method stub
		sqlSession.update("penetrationsearch.deleteSealMeterial", param);
		if(param.containsKey("SealMeterial_name") && param.get("SealMeterial_name")!= null &&  !param.get("SealMeterial_name").toString().equals("")){
			for(String SealMeterialName : param.get("SealMeterial_name").toString().split(",")){

				param.put("SealMeterial", "'" + SealMeterialName.replace(" ", "") +"'");
				sqlSession.update("penetrationsearch.insertSealMeterial", param);
				sqlSession.update("penetrationsearch.insertSealMeterial_his", param);
			}
		}
		sqlSession.update("penetrationbaseinfo.update", param);
		sqlSession.update("penetrationbaseinfo.update_his", param);
		

		sqlSession.update("penetrationinfo.update", param);
		sqlSession.update("penetrationinfo.update_his", param);
		
		
		sqlSession.update("sealantinfo.update", param);
		sqlSession.update("sealantinfo.update_his", param);
		
		return null;
	}
}
