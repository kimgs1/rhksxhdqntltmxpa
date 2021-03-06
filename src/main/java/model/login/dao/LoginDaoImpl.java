package model.login.dao;

import java.util.HashMap;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Service;

@Service
public class LoginDaoImpl implements LoginDao {

	@Resource
	private SqlSessionTemplate sqlSession;
	
	@Override
	public HashMap<String,Object> checkLogin(HashMap<String,String> param){
		
		HashMap<String, Object> result = new HashMap<String, Object>();
		
		if (checkSP(param.get("userpw"))) {
			result.put("login", false);
			result.put("id", param.get("userid"));
			result.put("msg", "요청하신 특수문자는 사용하실 수 없습니다");
		} else {
			if(!checkIP(param)){
				result.put("login", false);
				result.put("id", param.get("userid"));
				result.put("msg", "해당사용자는 해당 IP주소에서 등록할수 없습니다.");
			}
			else{
				HashMap<String, Object> re = sqlSession.selectOne("Login.checkLogin", param);
				if (re == null) {
					result.put("login", false);
					result.put("id", param.get("userid"));
					result.put("msg", "아이디 혹은 비밀번호가 일치하지 않거나 비활성 아이디입니다.");
				} else {
					result.put("login", true);
					result.put("id", param.get("userid"));
					result.put("username", re.get("username"));
					result.put("userlevel", re.get("userlevel"));
				}
			}
		}
		return result;
	}
	
	@Override
	public int newMemberUpload(HashMap<String,String> param){
		return sqlSession.update("Login.newMemberUpload", param);
	}
	@Override
	public int editMemberUpload(HashMap<String,String> param){
		if(param.get("password") == null){
			return sqlSession.update("Login.editMemberUpload_XPW", param);
			
		}else{
			return sqlSession.update("Login.editMemberUpload", param);
		}
	}
	
	private boolean checkSP(String userpwd) {
//		String regex = "((.*)[',%,^,&,~,=]|[',%,^,&,~,=](.*))";
//		boolean regexCheck = Pattern.matches(regex, userpwd);
		if (userpwd.indexOf("\'") > -1 || userpwd.indexOf("=") > -1) return true;
		else return false;
	}
	
	private boolean checkIP(HashMap<String,String> param){
		if(param.get("ip").toString().equals("0:0:0:0:0:0:0:1"))
			return true;
		HashMap<String, Object> result = sqlSession.selectOne("Login.checkIP", param);
		if(!result.get("count").toString().equals("0"))
			return true;
		return false;
	}

}
