package common;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;


public class Common {
	public enum MenuLvNmEnum {
		dept,      //부서
		eqg,       //장비그룹
		building,  //장비-동
		eq,        //장비
		s;         //데이타 
		private final static Map<String, MenuLvNmEnum> ENUM_MAP = new HashMap<String, MenuLvNmEnum>(64);
		static {
			for (MenuLvNmEnum v : values()) {
				ENUM_MAP.put(v.name(), v);
			}
		}
		public static MenuLvNmEnum getEnumByIdx(String v) {
			return ENUM_MAP.get(v);
		}
	}
	
	public static String getDataTypeValueInDB(String flag){
		if(flag == null || flag.equals("")){
			return "0";
		}
		else if(flag.equals("all")){
			return "";
		}
		else{
			return "1";
		}
	}
	
	public static String getDataTypeCond(String flag, String vpFlag){
		String cond = "";
		cond += Common.getDataTypeCond(vpFlag);
		cond += " AND to_char(datatype,'9999') like '%"+ getDataTypeValueInDB(flag)+"%' ";
		return cond;
	}
	
	public static String getDataTypeCond(String vpFlag){
		String cond = "";
		if(vpFlag == null || vpFlag.equals("") || vpFlag.equals("false")){
			cond += " AND param_flag = 0 ";
		}
		else if (vpFlag.equals("all")) {
		}
		else{
			cond += " AND param_flag = 1 ";
		}
		return cond;
	}
	
	public static String getDataTypeTableNameInDB(String flag){
		if(flag == null || flag.equals("") || flag.equals("0")){
			return "cadis_vardata";
		}
		else{
			return "cadis_mesdata";
		}
	}
	
	public static boolean checkVPByMid(String mid){
		if(mid.contains("ZVP_")){
			return true;
		}
		else{
			return false;
		}
	}

	public static String getIpAddr(HttpServletRequest request) throws Exception{
		String ip = request.getHeader("X-Real-IP");
		if (!StringUtils.isBlank(ip) && !"unknown".equalsIgnoreCase(ip)) {
			return ip;
		}
		ip = request.getHeader("X-Forwarded-For");
		if (!StringUtils.isBlank(ip) && !"unknown".equalsIgnoreCase(ip)) {
			// 여러개의 IP주소가 생기게 되는데 그중 첫번째것이 실제 IP주소가 된다
			int index = ip.indexOf(',');
			if (index != -1) {
				return ip.substring(0, index);
			} else {
				return ip;
			}
		} else {
			return request.getRemoteAddr();
		}
	}
}
