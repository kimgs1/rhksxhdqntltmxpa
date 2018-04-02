package model.penetrationbaseinfo.dao;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Service;

import common.SqlStrProcess;

@Service
public class PenetrationBaseInfoDaoImpl implements PenetrationBaseInfoDao{

	@Resource
	private SqlSessionTemplate sqlSession;
	@Override
	public HashMap<String, Object> getList(HashMap<String, Object> param) {
		// TODO Auto-generated method stub
		String cond = SqlStrProcess.getSearchString(null, param);
		if(param.containsKey("ELEVATION_num_pit") &&param.get("ELEVATION_num_pit")!= null &&  !param.get("ELEVATION_num_pit").toString().equals("")){
			if(param.containsKey("ELEVATION_num_inc") &&param.get("ELEVATION_num_inc")!= null &&  !param.get("ELEVATION_num_inc").toString().equals(""))
			{
				cond += " and Elevation_num_pit * 12 + Elevation_num_inc "+param.get("ELEVATION_cal_flag")+" "+param.get("ELEVATION_num_pit")+" * 12 + " + param.get("ELEVATION_num_inc");
			}
		}
		param.put("cond", cond);
		List<HashMap<String,String>> sqlResult =  sqlSession.selectList("penetrationbaseinfo.getList", param);
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
		result.put("msg", "관통부기본정보가 정상적으로 저장되지 않았습니다.관리자에게 문의 바랍니다.");

		int count = sqlSession.update("penetrationbaseinfo.insert", param);
		if(count>0){
			sqlSession.update("penetrationbaseinfo.insert_his", param);
			result.put("success", true);
			result.put("msg", "관통부기본정보가 정상적으로 저장되었습다.");
		}

		return result;
	}

	@Override
	public HashMap<String, Object> delete(HashMap<String, Object> param) {
		// TODO Auto-generated method stub
		HashMap<String,Object> result = new HashMap<String,Object>();
		result.put("success", false);
		result.put("msg", "관통부기본정보가 정상적으로 삭제되지 않았습니다.관리자에게 문의 바랍니다.");

		int count = sqlSession.selectOne("penetrationbaseinfo.getCountBySeq", param);
		if(count>0){
			if(sqlSession.update("penetrationbaseinfo.delete", param) > 0){
				result.put("success", true);
				result.put("msg", "관통부기본정보가 정상적으로 삭제되었습니다.");
			}
		}
		return result;
	}
}
