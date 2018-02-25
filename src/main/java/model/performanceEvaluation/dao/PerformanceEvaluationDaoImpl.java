package model.performanceEvaluation.dao;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Service;

import common.SqlStrProcess;

@Service
public class PerformanceEvaluationDaoImpl implements PerformanceEvaluationDao {

	@Resource
	private SqlSessionTemplate sqlSession;
	
	@Override
	public HashMap<String, Object> getList(HashMap<String, Object> param) {
		// TODO Auto-generated method stub
		String cond = SqlStrProcess.getSearchString(null, param);
		if(param.get("EvaluationResult")!=null && param.get("EvaluationResult").equals("A0501")){
			cond +=  " and PRESSURE_REASON like '○%' ";
		}
		if(param.get("EvaluationResult")!=null && param.get("EvaluationResult").equals("A0502")){
			cond +=  " and PRESSURE_REASON like 'X%' ";
		}

		param.put("cond", cond);
		List<HashMap<String,String>> sqlResult =  sqlSession.selectList("performanceEvaluation.getList", param);
		HashMap<String,Object> result = new HashMap<String,Object>();
		result.put("DataList",sqlResult);
		return result;
	}

	@Override
	public HashMap<String, Object> save(HashMap<String, Object> param) {
		// TODO Auto-generated method stub
		param = SqlStrProcess.strSplit(param);
		HashMap<String,Object> result = new HashMap<String,Object>();
		result.put("success", false);
		result.put("msg", "성능평가정보가 정상적으로 저장되지 않았습니다.관리자에게 문의하시길바랍니다.");

		int count = sqlSession.update("performanceEvaluation.insert", param);
		if(count>0){
			sqlSession.update("performanceEvaluation.insert_his", param);
			result.put("success", true);
			result.put("msg", "성능평가정보가 정상적으로 저장되었습다.");
		}
		return result;
	}

	@Override
	public HashMap<String, Object> delete(HashMap<String, Object> param) {
		HashMap<String,Object> result = new HashMap<String,Object>();
		result.put("success", false);
		result.put("msg", "성능평가정보가 정상적으로 삭제되지 않았습니다.관리자에게 문의하시길바랍니다.");

		int count = sqlSession.selectOne("performanceEvaluation.getCountBySeq", param);
		if(count>0){
			if(sqlSession.update("performanceEvaluation.delete", param) > 0){
				result.put("success", true);
				result.put("msg", "성능평가정보가 정상적으로 삭제되었습다.");
			}
		}
		return result;
	}
	

}
