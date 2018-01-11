package model.qna.dao;

import java.util.HashMap;
public interface QNADao {
	public HashMap<String,Object> createQNA(HashMap<String,Object> param);
	public HashMap<String,Object> getList(HashMap<String,Object> param);
	public HashMap<String,Object> getContent(HashMap<String,Object> param);
	public HashMap<String,Object> getQNAReviewList(HashMap<String,Object> param);
	public HashMap<String,Object> createQNAReview(HashMap<String,Object> param);
	public HashMap<String,Object> deleteQNAReview(HashMap<String,Object> param);
}
