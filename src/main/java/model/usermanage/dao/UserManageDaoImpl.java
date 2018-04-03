package model.usermanage.dao;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Service;

@Service
public class UserManageDaoImpl implements UserManageDao{

	@Resource
	private SqlSessionTemplate sqlSession;
	@Override
	public HashMap<String, Object> create(HashMap<String, Object> param) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public HashMap<String, Object> delete(HashMap<String, Object> param) {
		int sqlResult = sqlSession.update("usermanage.delete", param);
		HashMap<String,Object> result = new HashMap<String,Object>();
		if(sqlResult >0 ){
			result.put("success", true);
			result.put("msg", "사용자정보가 정상적으로 삭제되었습니다.");
		}
		else{
			result.put("success", false);
			result.put("msg", "사용자정보가 정상적으로 삭제되지 않았습니다.");
		}
		return result;
	}

	@Override
	public HashMap<String, Object> getList(HashMap<String, Object> param) {
		// TODO Auto-generated method stub
		List<HashMap<String,String>> sqlResult = sqlSession.selectList("usermanage.getList", param);
		HashMap<String,Object> result = new HashMap<String,Object>();
		result.put("DataList", sqlResult);
		return result;
	}

	@Override
	public HashMap<String, Object> update(HashMap<String, Object> param) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public HashMap<String, Object> getAllUserInfo(HashMap<String, Object> param) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public HashMap<String,Object> getContent(HashMap<String,Object> param){
		HashMap<String,String> sqlResult = sqlSession.selectOne("usermanage.getcontent", param);
		HashMap<String,Object> result = new HashMap<String,Object>();
		result.put("DataList", sqlResult);
		return result;
	}
}
