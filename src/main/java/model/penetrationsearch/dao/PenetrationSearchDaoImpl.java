package model.penetrationsearch.dao;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.SQLException;
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
