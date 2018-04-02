package model.fbulletine.dao;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Service;

import pasing.FbulientPagingBean;

@Service
public class FBulletineDaoImpl implements FBulletineDao{

	@Resource
	private SqlSessionTemplate sqlSession;
	
	@Override
	public HashMap<String,Object>  createBulletine(HashMap<String,Object> param){
		int sqlResult = sqlSession.update("Fbulletine.create", param);
		HashMap<String,Object> result = new HashMap<String,Object>();
		if(sqlResult >0 ){
			result.put("success", true);
			result.put("msg", "공지사항이 정상적으로 저장되었습다.");
		}
		else{
			result.put("success", false);
			result.put("msg", "공지사항이 정상적으로 저장되지 않았습니다.");
		}
		return result;
	}
	

	@Override
	public HashMap<String,Object>  editBulletine(HashMap<String,Object> param){
		int sqlResult = sqlSession.update("Fbulletine.edit", param);
		HashMap<String,Object> result = new HashMap<String,Object>();
		if(sqlResult >0 ){
			result.put("success", true);
			result.put("msg", "공지사항이 정상적으로 저장되었습다.");
		}
		else{
			result.put("success", false);
			result.put("msg", "공지사항이 정상적으로 저장되지 않았습니다.");
		}
		return result;
	}
	
	@Override
	public HashMap<String,Object> getList(HashMap<String,Object> param){
		List<HashMap<String,String>> sqlResult = sqlSession.selectList("Fbulletine.getList", param);
		HashMap<String,Object> result = new HashMap<String,Object>();
		int count = Integer.parseInt(sqlSession.selectOne("Fbulletine.getCount").toString());
		int nowPage = Integer.parseInt(param.get("nowPage").toString());
		FbulientPagingBean pagingBean = new FbulientPagingBean(count, nowPage);
		result.put("FBList", sqlResult);
		result.put("pagingBean", pagingBean);
		return result;
	}
	
	@Override
	public HashMap<String,Object> getContent(HashMap<String,Object> param){
		HashMap<String,String> sqlResult = sqlSession.selectOne("Fbulletine.getContent", param);
		HashMap<String,Object> result = new HashMap<String,Object>();
		result.put("FB", sqlResult);
		return result;
	}

	@Override
	public HashMap<String, Object> deleteBulletine(HashMap<String, Object> param) {
		// TODO Auto-generated method stub
		int sqlResult = sqlSession.update("Fbulletine.delete", param);
		HashMap<String,Object> result = new HashMap<String,Object>();
		if(sqlResult >0 ){
			result.put("success", true);
			result.put("msg", "공지사항이 정상적으로 삭제되었습니다.");
		}
		else{
			result.put("success", false);
			result.put("msg", "공지사항이 정상적으로 삭제되지 않았습니다.");
		}
		return result;
	}
}
