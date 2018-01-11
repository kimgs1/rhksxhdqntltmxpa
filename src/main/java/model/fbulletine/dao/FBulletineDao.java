package model.fbulletine.dao;

import java.util.HashMap;
public interface FBulletineDao {
	public HashMap<String,Object> createBulletine(HashMap<String,Object> param);
	public HashMap<String,Object> getList(HashMap<String,Object> param);
	public HashMap<String,Object> getContent(HashMap<String,Object> param);

}
