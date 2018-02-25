package model.penetrationinspect.dao;

import java.io.IOException;
import java.util.HashMap;

public interface PenetrationInspectDao {
	public HashMap<String,Object> getList(HashMap<String,Object> param);
	public HashMap<String,Object> insert(HashMap<String,Object> param);
	public HashMap<String,Object> update(HashMap<String,Object> param) throws IOException;
	public HashMap<String,Object> delete(HashMap<String,Object> param);
	public HashMap<String, Object> getDataList(HashMap<String, Object> param);
}
