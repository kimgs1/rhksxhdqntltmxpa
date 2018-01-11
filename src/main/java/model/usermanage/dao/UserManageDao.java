package model.usermanage.dao;

import java.util.HashMap;
public interface UserManageDao {
	public HashMap<String,Object> create(HashMap<String,Object> param);
	public HashMap<String,Object> delete(HashMap<String,Object> param);
	public HashMap<String,Object> getList(HashMap<String,Object> param);
	public HashMap<String,Object> getContent(HashMap<String,Object> param);
	public HashMap<String,Object> update(HashMap<String,Object> param);
	public HashMap<String,Object> getAllUserInfo(HashMap<String,Object> param);
}
