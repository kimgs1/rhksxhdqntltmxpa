package model.penetrationinspect.dao;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import common.SqlStrProcess;
import pasing.PenetrationSearchPagingBean;

@Service
public class PenetrationInspectDaoImpl implements PenetrationInspectDao {

	@Resource
	private SqlSessionTemplate sqlSession;
	@Override
	public HashMap<String, Object> getList(HashMap<String, Object> param) {
		// TODO Auto-generated method stub
		String cond = SqlStrProcess.getSearchString(null, param);
		param.put("cond", cond);
		List<HashMap<String,String>> sqlResult =  sqlSession.selectList("penetrationinspect.getList", param);
		
		for(HashMap<String,String> foo : sqlResult){
			HashMap<String, Object> paramSub = new HashMap<String, Object>();
			paramSub.put("ManagementNo",foo.get("ManagementNo"));
			paramSub.put("PenetrationNo",foo.get("PenetrationNo"));
			paramSub.put("InspectSeq",foo.get("InspectSeq"));
			paramSub.put("RealPath",param.get("RealPath"));
			
			paramSub.put("photoName",foo.get("FrontPicNo"));
			this.getFrontImg(paramSub);
			paramSub.put("photoName",foo.get("BackPicNo"));
			this.getBackImg(paramSub);
		}
		HashMap<String,Object> result = new HashMap<String,Object>();
		result.put("DataList",sqlResult);
		return result;
	}

	@Override
	public HashMap<String, Object> getDataList(HashMap<String, Object> param) {
		// TODO Auto-generated method stub
		String cond = SqlStrProcess.getSearchString(null, param);
		param.put("cond", cond);
		
		if(param.get("Judgment")!=null && param.get("Judgment").equals("A0501")){
			cond +=  " and Judgment like '○%' ";
		}
		if(param.get("Judgment")!=null && param.get("Judgment").equals("A0502")){
			cond +=  " and Judgment like 'X%' ";
		}
		int nowPage = Integer.parseInt(param.get("nowPage").toString());
		int totalCount =  sqlSession.selectOne("penetrationinspect.getListCount", param);
		
		PenetrationSearchPagingBean pagingBean = new PenetrationSearchPagingBean(totalCount,nowPage);
		
		param.put("low", PenetrationSearchPagingBean.numberOfContentPerPage * (nowPage - 1));
		param.put("high", PenetrationSearchPagingBean.numberOfContentPerPage * nowPage);
		
		List<HashMap<String,String>> sqlResult =  sqlSession.selectList("penetrationinspect.getDataList", param);

		HashMap<String,Object> result = new HashMap<String,Object>();
		result.put("DataList",sqlResult);
		result.put("pagingBean", pagingBean);
		return result;
	}
	@Override
	public HashMap<String, Object> insert(HashMap<String, Object> param) {
		// TODO Auto-generated method stub
		param = SqlStrProcess.strSplit(param);
		sqlSession.update("penetrationinspect.deleteSealantConditionState", param);
		if(param.containsKey("SealantConditionState_name") && param.get("SealantConditionState_name")!= null &&  !param.get("SealantConditionState_name").toString().equals("")){
			for(String SealMeterialName : param.get("SealantConditionState_name").toString().split(",")){

				param.put("SealantConditionState", "'" + SealMeterialName +"'");
				sqlSession.update("penetrationinspect.insertSealantConditionState", param);
				sqlSession.update("penetrationinspect.insertSealantConditionState_his", param);
			}
		}

		String path = param.get("RealPath").toString();
		param.put("FrontPicImg", readImgFromLocal(path+"DownLoadImg\\" + param.get("FrontPicNo") + ".png"));
		param.put("BackPicImg", readImgFromLocal(path+"DownLoadImg\\" + param.get("BackPicNo") + ".png"));


		int count = sqlSession.update("penetrationinspect.insert", param);
		if(count>0){
			sqlSession.update("penetrationinspect.insert_his", param);
		}
		return null;
		
	}
	
	@Override
	@Transactional(propagation=Propagation.REQUIRED, rollbackFor=Exception.class)  
	public HashMap<String, Object> update(HashMap<String, Object> param) throws IOException {
		// TODO Auto-generated method stub
		param = SqlStrProcess.strSplit(param);
		sqlSession.update("penetrationinspect.deleteSealantConditionState", param);
		if(param.containsKey("SealantConditionState_name") && param.get("SealantConditionState_name")!= null &&  !param.get("SealantConditionState_name").toString().equals("")){
			for(String SealMeterialName : param.get("SealantConditionState_name").toString().split(",")){

				param.put("SealantConditionState", "'" + SealMeterialName +"'");
				sqlSession.update("penetrationinspect.insertSealantConditionState", param);
				sqlSession.update("penetrationinspect.insertSealantConditionState_his", param);
			}
		}
		
		String path = param.get("RealPath").toString();
		param.put("FrontPicImg", readImgFromLocal(path+"DownLoadImg\\" + param.get("FrontPicNo") + ".png"));
		param.put("BackPicImg", readImgFromLocal(path+"DownLoadImg\\" + param.get("BackPicNo") + ".png"));


		int count = sqlSession.update("penetrationinspect.update", param);
		if(count>0){
			sqlSession.update("penetrationinspect.update_his", param);
		}
		return null;
		
	}
	
	
	@Override
	public HashMap<String, Object> delete(HashMap<String, Object> param) {
		HashMap<String,Object> result = new HashMap<String,Object>();
		result.put("success", false);
		result.put("msg", "점검정보가 정상적으로 삭제되지 않았습니다.관리자에게 문의하시길바랍니다.");

		int count = sqlSession.selectOne("penetrationinspect.getCountBySeq", param);
		if(count>0){
			if(sqlSession.update("penetrationinspect.delete", param) > 0){
				result.put("success", true);
				result.put("msg", "점검정보가 정상적으로 삭제되었습다.");
			}
		}
		return result;
	}
	
	
	private byte[] readImgFromLocal(String path){
		try{
			BufferedInputStream in = new BufferedInputStream(new FileInputStream(path));
	        ByteArrayOutputStream out = new ByteArrayOutputStream(1024);    
	       
	        byte[] temp = new byte[1024];        
	        int size = 0;        
	        while ((size = in.read(temp)) != -1) {        
	            out.write(temp, 0, size);        
	        }        
	        in.close();  
	        byte[] content = out.toByteArray();  
			return content;
		}
		catch(IOException e){
			return null;
		}
		
	}
	
	private HashMap<String, Object> getFrontImg(HashMap<String, Object> param) {
		// TODO Auto-generated method stub
		HashMap<String,Object> result = new HashMap<String,Object>();

		byte[] sqlResult =  sqlSession.selectOne("penetrationsearch.getFrontPicImg", param);
		if(sqlResult != null && sqlResult.length > 0){
			try{
				OutputStream out = new FileOutputStream(new File(param.get("RealPath") + "DownLoadImg\\" + param.get("photoName") + ".png"));

				out.write(sqlResult);
				out.flush();
				System.out.println("download success");
				System.out.println(param.get("RealPath") + "DownLoadImg\\" + param.get("photoName") + ".png");
				
				out.close();

				result.put("result", "success");
				result.put("photoName", param.get("photoName")+ ".png");

			}catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				result.put("result", "error");
				result.put("photoName", "");
			}
		}
		

		result.put("DataList",sqlResult);
		return result;
	}
	
	private HashMap<String, Object> getBackImg(HashMap<String, Object> param) {
		// TODO Auto-generated method stub
		
		HashMap<String,Object> result = new HashMap<String,Object>();

		byte[] sqlResult =  sqlSession.selectOne("penetrationsearch.getBackPicImg", param);
		if(sqlResult != null && (sqlResult.length > 0)){
			try{
				OutputStream out = new FileOutputStream(new File(param.get("RealPath") + "DownLoadImg\\" + param.get("photoName") + ".png"));

				out.write(sqlResult);
				out.flush();
				System.out.println("download success");
				System.out.println(param.get("RealPath") + "DownLoadImg\\" + param.get("photoName") + ".png");
				out.close();

				result.put("result", "success");
				result.put("photoName", param.get("photoName")+ ".png");

			}catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				result.put("result", "error");
				result.put("photoName", "");
			}
		}
		

		result.put("DataList",sqlResult);
		return result;
	}

	
}
