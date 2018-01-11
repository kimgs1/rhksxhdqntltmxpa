package model.login.dao;

import java.util.HashMap;

public interface LoginDao {
	public HashMap<String,Object> checkLogin(HashMap<String,String> param);
	public int newMemberUpload(HashMap<String,String> param);
}
