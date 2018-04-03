package model.content.dao;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Service;

import pasing.FbulientPagingBean;

@Service
public class ContentInfoDaoImpl implements ContentInfoDao{

	@Resource
	private SqlSessionTemplate sqlSession;
	
	@Override
	public HashMap<String,Object>  createContentInfo(HashMap<String,Object> param){
		int sqlResult = sqlSession.update("ContentInfo.create", param);
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
		List<HashMap<String,String>> sqlResult = sqlSession.selectList("ContentInfo.getList", param);
		HashMap<String,Object> result = new HashMap<String,Object>();
		int count = Integer.parseInt(sqlSession.selectOne("ContentInfo.getCount").toString());
		int nowPage = Integer.parseInt(param.get("nowPage").toString());
		FbulientPagingBean pagingBean = new FbulientPagingBean(count, nowPage);
		result.put("dataList", sqlResult);
		result.put("pagingBean", pagingBean);
		return result;
	}
	
	@Override
	public HashMap<String,Object> getContent(HashMap<String,Object> param){
		HashMap<String,String> sqlResult = sqlSession.selectOne("ContentInfo.getContent", param);
		HashMap<String,Object> result = new HashMap<String,Object>();
		String fileName = "" + sqlResult.get("Filename");
		sqlResult.put("FileViewName", fileName.replace(fileName.split("_")[0] + "_", ""));
		result.put("data", sqlResult);
		return result;
	}

	@Override
	public HashMap<String, Object> editContentInfo(HashMap<String, Object> param) {
		int sqlResult = sqlSession.update("ContentInfo.edit", param);
		HashMap<String,Object> result = new HashMap<String,Object>();
		if(sqlResult >0 ){
			result.put("success", true);
			result.put("msg", "자료실정보가 정상적으로 저장되었습다.");
		}
		else{
			result.put("success", false);
			result.put("msg", "자료실정보가 정상적으로 저장되지 않았습니다.");
		}
		return result;
	}

	@Override
	public HashMap<String, Object> delete(HashMap<String, Object> param) {
		int sqlResult = sqlSession.update("ContentInfo.delete", param);
		HashMap<String,Object> result = new HashMap<String,Object>();
		if(sqlResult >0 ){
			result.put("success", true);
			result.put("msg", "자료실정보가 정상적으로 삭제되었습니다.");
		}
		else{
			result.put("success", false);
			result.put("msg", "자료실정보가 정상적으로 삭제되지 않았습니다.");
		}
		return result;
	}
}
