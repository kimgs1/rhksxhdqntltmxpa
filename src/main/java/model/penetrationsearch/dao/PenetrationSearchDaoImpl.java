package model.penetrationsearch.dao;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Service;

import com.mysql.jdbc.Blob;

import common.ImageUtil;

@Service
public class PenetrationSearchDaoImpl implements PenetrationSearchDao{
	@Resource
	private SqlSessionTemplate sqlSession;
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
		if(param.containsKey("ELEVATION") &&param.get("ELEVATION")!= null &&  !param.get("ELEVATION").toString().equals("")){
			cond += " and pb.ELEVATION like '%"+param.get("ELEVATION")+"%' ";
		}
		if(param.containsKey("Location") &&param.get("Location")!= null &&  !param.get("Location").toString().equals("")){
			cond += " and pb.LocNo like '%"+param.get("Location")+"%' ";
		}

		if(param.containsKey("WallMeterial") && param.get("WallMeterial")!= null &&  !param.get("WallMeterial").toString().equals("")){
			cond += " and pb.WallMeterial in ("+param.get("WallMeterial")+")";
		}

		if(param.containsKey("ConstructionState") && param.get("ConstructionState")!= null &&  !param.get("ConstructionState").toString().equals("")){
			cond += " and s.ConstructionState in ("+param.get("ConstructionState")+") ";
		}
		if(param.containsKey("InspectSeq") && param.get("InspectSeq")!= null &&  !param.get("InspectSeq").toString().equals("")){
			cond += " and pi.InspectSeq in ("+param.get("InspectSeq")+") ";
		}
		param.put("cond", cond);
		List<HashMap<String,String>> sqlResult =  sqlSession.selectList("penetrationsearch.getList", param);
		HashMap<String,Object> result = new HashMap<String,Object>();
		result.put("DataList",sqlResult);
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
	
	
}
