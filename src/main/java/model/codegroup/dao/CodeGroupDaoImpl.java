package model.codegroup.dao;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Service;

@Service
public class CodeGroupDaoImpl implements CodeGroupDao{

	@Resource
	private SqlSessionTemplate sqlSession;
	
	@Override
	public HashMap<String,Object>  create(HashMap<String,Object> param){
		int sqlResult = sqlSession.update("CodeGroup.create", param);
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
		List<HashMap<String,String>> sqlResult = sqlSession.selectList("CodeGroup.getList", param);
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
			sqlResult += sqlSession.update("CodeGroup.update", map);
			errMsg +=map.get("GroupID") + ",";
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
		int sqlResult = sqlSession.update("CodeGroup.delete", param);
		HashMap<String,Object> result = new HashMap<String,Object>();
		if(sqlResult >0 ){
			result.put("success", true);
			result.put("msg", "코드그룹정보가 정상적으로 삭제되었습다.");
		}
		else{
			result.put("success", false);
			result.put("msg", "코드그룹정보가 정상적으로 삭제되지 않았습니다.");
		}
		return result;
	}
}
