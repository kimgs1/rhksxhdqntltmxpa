package common;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


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
  
	
}
