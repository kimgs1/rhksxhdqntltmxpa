package model.performanceEvaluation.dao;

import java.util.HashMap;

public interface PerformanceEvaluationDao {
	public HashMap<String,Object> getList(HashMap<String,Object> param);
	public HashMap<String,Object> save(HashMap<String,Object> param);
	public HashMap<String,Object> delete(HashMap<String,Object> param);
}
