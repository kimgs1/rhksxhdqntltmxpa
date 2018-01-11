package common;

import java.util.HashMap;

public class SqlStrProcess {
	public static String getSearchString(HashMap<String, Object> tableHead, HashMap<String, Object> param){
		String searchCond = "";
		if(tableHead == null){
			tableHead = new HashMap<String , Object>();
		}
		for(String key : param.keySet()){
			if(param.get(key) != null && !param.get(key).equals("")){
				if(tableHead.get(key) != null && !tableHead.get(key).equals("") ){
					searchCond += " AND "+ tableHead.get(key) + key + " like '%" + param.get(key) + "%'";
				}
				else{
					searchCond += " AND "+ key + " like '%" + param.get(key) + "%'";
				}
			}
		}
		return searchCond;
	}
	
	
	public static HashMap<String, Object> strSplit(HashMap<String, Object> param){
		for(String key : param.keySet()){
			if(!key.equals("cond")){
				try{
					param.put(key, param.get(key).toString().replace("'", "\\'"));
				}
				catch(Exception e){
					
				}
			}
		}
		return param;
	}
}
   