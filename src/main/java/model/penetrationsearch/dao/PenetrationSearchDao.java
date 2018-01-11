package model.penetrationsearch.dao;

import java.util.HashMap;

public interface PenetrationSearchDao {

	public HashMap<String,Object> getList(HashMap<String,Object> param);
	public HashMap<String, Object> getLocChart(HashMap<String, Object> param);
	public HashMap<String, Object> getWallMeterialChart(HashMap<String, Object> param);
	public HashMap<String, Object> getConstructionStateChart(HashMap<String, Object> param);
	public HashMap<String, Object> getEquipNoLocNoData(HashMap<String, Object> param);
	public HashMap<String, Object> getTotalCount(HashMap<String, Object> param);
	public HashMap<String, Object> getMergeData(HashMap<String, Object> param);
	public HashMap<String, Object> getFrontImg(HashMap<String, Object> param);
	public HashMap<String, Object> getBackImg(HashMap<String, Object> param);
}
