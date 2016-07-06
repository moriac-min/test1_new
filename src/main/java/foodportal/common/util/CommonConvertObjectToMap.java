package foodportal.common.util;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

public class CommonConvertObjectToMap {
	public static HashMap<String,Object> ConverObjectToMap(Object obj) throws IllegalAccessException {
		try{
			if(obj != null){
				Field[] fields = obj.getClass().getDeclaredFields();
				HashMap<String,Object> resultMap = new HashMap<String,Object>();
				
				for(int i = 0; i < fields.length; i++){
					fields[i].setAccessible(true);
					resultMap.put(fields[i].getName(), fields[i].get(obj));
				}
				return resultMap;
			} else {
				return null;
			}
		}catch(IllegalArgumentException e){
		}
		return null;
	}
}
