package model.content.dao;

import java.util.HashMap;

public interface ContentInfoDao {
	public HashMap<String,Object> createContentInfo(HashMap<String,Object> param);
	public HashMap<String,Object> getList(HashMap<String,Object> param);
	public HashMap<String,Object> getContent(HashMap<String,Object> param);
	public HashMap<String, Object> editContentInfo(HashMap<String, Object> param);
	public HashMap<String, Object> delete(HashMap<String, Object> param);

}
