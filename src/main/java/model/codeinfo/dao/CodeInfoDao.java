package model.codeinfo.dao;

import java.util.HashMap;
public interface CodeInfoDao {
	public HashMap<String,Object> create(HashMap<String,Object> param);
	public HashMap<String,Object> delete(HashMap<String,Object> param);
	public HashMap<String,Object> getList(HashMap<String,Object> param);
	public HashMap<String,Object> update(HashMap<String,Object> param);
	public HashMap<String,Object> getCodeAllInfo(HashMap<String,Object> param);
}
