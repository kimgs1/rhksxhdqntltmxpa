package model.qna.dao;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Service;

import pasing.QNAPagingBean;
import pasing.QNAReviewPagingBean;

@Service
public class QNADaoImpl implements QNADao{

	@Resource
	private SqlSessionTemplate sqlSession;
	
	@Override
	public HashMap<String,Object>  createQNA(HashMap<String,Object> param){
		int sqlResult = sqlSession.update("QNA.create", param);
		HashMap<String,Object> result = new HashMap<String,Object>();
		if(sqlResult >0 ){
			result.put("success", true);
			result.put("msg", "자주하는 질문이정상적으로 저장되었습다.");
		}
		else{
			result.put("success", false);
			result.put("msg", "자주하는 질문이 정상적으로 저장되지 않았습니다.");
		}
		return result;
	}
	
	@Override
	public HashMap<String,Object> getList(HashMap<String,Object> param){
		List<HashMap<String,String>> sqlResult = sqlSession.selectList("QNA.getList", param);
		HashMap<String,Object> result = new HashMap<String,Object>();
		int count = Integer.parseInt(sqlSession.selectOne("QNA.getCount").toString());
		int nowPage = Integer.parseInt(param.get("nowPage").toString());
		QNAPagingBean pagingBean = new QNAPagingBean(count, nowPage);
		result.put("DataList", sqlResult);
		result.put("pagingBean", pagingBean);
		return result;
	}
	
	@Override
	public HashMap<String,Object> getContent(HashMap<String,Object> param){
		HashMap<String,String> sqlResult = sqlSession.selectOne("QNA.getContent", param);
		HashMap<String,Object> result = new HashMap<String,Object>();
		result.put("QNAObject", sqlResult);
		return result;
	}
	

	@Override
	public HashMap<String,Object> getQNAReviewList(HashMap<String,Object> param){
		List<HashMap<String,String>> sqlResult = sqlSession.selectList("QNA.getReviewList", param);
		HashMap<String,Object> result = new HashMap<String,Object>();
		int count = Integer.parseInt(sqlSession.selectOne("QNA.getReviewCount",param).toString());
		int nowPage = Integer.parseInt(param.get("nowPage").toString());
		QNAReviewPagingBean pagingBean = new QNAReviewPagingBean(count, nowPage);
		result.put("pagingBean", pagingBean);
		result.put("dataList", sqlResult);
		return result;
	}
	@Override
	public HashMap<String,Object>  createQNAReview(HashMap<String,Object> param){
		int sqlResult = sqlSession.update("QNA.createReview", param);
		HashMap<String,Object> result = new HashMap<String,Object>();
		if(sqlResult >0 ){
			result.put("success", true);
			result.put("msg", "댓글이 정상적으로 저장되었습다.");
		}
		else{
			result.put("success", false);
			result.put("msg", "댓글이 정상적으로 저장되지 않았습니다.");
		}
		return result;
	}

	@Override
	public HashMap<String,Object> deleteQNAReview(HashMap<String,Object> param){
		int sqlResult = sqlSession.update("QNA.deleteReview", param);
		HashMap<String,Object> result = new HashMap<String,Object>();
		if(sqlResult >0 ){
			result.put("success", true);
			result.put("msg", "댓글이 정상적으로 삭제되었습다.");
		}
		else{
			result.put("success", false);
			result.put("msg", "댓글이 정상적으로 삭제되지 않았습니다.");
		}
		return result;
	}

	@Override
	public HashMap<String, Object> deleteQNA(HashMap<String, Object> param) {
		int sqlResult = sqlSession.update("QNA.delete", param);
		HashMap<String,Object> result = new HashMap<String,Object>();
		if(sqlResult >0 ){
			result.put("success", true);
			result.put("msg", "자주하는 질문이 정상적으로 삭제되었습다.");
		}
		else{
			result.put("success", false);
			result.put("msg", "자주하는 질문이 정상적으로 삭제되지 않았습니다.");
		}
		return result;
	}

	@Override
	public HashMap<String, Object> editQNA(HashMap<String, Object> param) {
		int sqlResult = sqlSession.update("QNA.edit", param);
		HashMap<String,Object> result = new HashMap<String,Object>();
		if(sqlResult >0 ){
			result.put("success", true);
			result.put("msg", "자주하는 질문이 정상적으로 저장되었습다.");
		}
		else{
			result.put("success", false);
			result.put("msg", "자주하는 질문이 정상적으로 저장되지 않았습니다.");
		}
		return result;
	}
}
