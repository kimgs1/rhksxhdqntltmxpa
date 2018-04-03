package model.codeinfo.dao;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Service;

@Service
public class CodeInfoDaoImpl implements CodeInfoDao{

	@Resource
	private SqlSessionTemplate sqlSession;
	
	@Override
	public HashMap<String,Object>  create(HashMap<String,Object> param){
		int sqlResult = sqlSession.update("CodeInfo.create", param);
		HashMap<String,Object> result = new HashMap<String,Object>();
		if(sqlResult >0 ){
			result.put("success", true);
			result.put("msg", "코드그룹정보가 정상적으로 저장되었습다.");
		}
		else{
			result.put("success", false);
			result.put("msg", "코드그룹정보가 정상적으로 저장되지 않았습니다.");
		}
		return result;
	}
	
	@Override
	public HashMap<String,Object> getList(HashMap<String,Object> param){
		List<HashMap<String,String>> sqlResult = sqlSession.selectList("CodeInfo.getList", param);
		HashMap<String,Object> result = new HashMap<String,Object>();
		result.put("DataList", sqlResult);
		return result;
	}

	@Override
	@SuppressWarnings("unchecked")
	public HashMap<String,Object> update(HashMap<String,Object> param){
		List<HashMap<String, Object>> list = (List<HashMap<String, Object>>) param.get("listData");
		int sqlResult = 0;
		String errMsg = "";
		
		for (HashMap<String, Object> map : list) {
			sqlResult += sqlSession.update("CodeInfo.update", map);
			errMsg +=map.get("CodeID") + ",";
		}

		HashMap<String,Object> result = new HashMap<String,Object>();
		if(sqlResult >= list.size()){
			result.put("success", true);
			result.put("msg", "코드그룹 정보가 정상적으로 수정되었습다.");
		}
		else{
			result.put("success", false);
			result.put("msg", "코드그룹 정보가 정상적으로 수정되지 않았습니다. \n 수정되지 않은 코드그룹 ID:" + errMsg.substring(0,errMsg.length()-1));
		}
		
		return result;
	}
	

	@Override
	public HashMap<String, Object> delete(HashMap<String, Object> param) {
		int sqlResult = sqlSession.update("CodeInfo.delete", param);
		HashMap<String,Object> result = new HashMap<String,Object>();
		if(sqlResult >0 ){
			result.put("success", true);
			result.put("msg", "코드그룹정보가 정상적으로 삭제되었습니다.");
		}
		else{
			result.put("success", false);
			result.put("msg", "코드그룹정보가 정상적으로 삭제되지 않았습니다.");
		}
		return result;
	}
	
	
	@Override
	public HashMap<String,Object> getCodeAllInfo(HashMap<String,Object> param){

		HashMap<String,Object> result = new HashMap<String,Object>();
		
		String cond = "";
		if(param != null){
			cond = "AND " + "GroupID = '" + param.get("GroupID").toString() + "'"; 
		} 
		param = new HashMap<String,Object>();
		param.put("cond",  cond);
		List<HashMap<String,Object>> sqlGroupResult = sqlSession.selectList("CodeGroup.getList", param);
		for(int i=0 ; i<sqlGroupResult.size() ; i++){
			String groupID = sqlGroupResult.get(i).get("GroupID").toString();
			param.put("GroupID",groupID);
			List<HashMap<String,Object>> sqlResult = sqlSession.selectList("CodeInfo.getList", param);
			result.put(groupID, sqlResult);
		}
		return result;
	}
	
}
