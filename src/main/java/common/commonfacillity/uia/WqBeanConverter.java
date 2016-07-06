package common.commonfacillity.uia;

import org.slf4j.Logger;
import common.commonfacillity.log.CommonLog;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import websquare.WebSquareConfig;
import websquare.system.adapter.AdapterUtil;

public class WqBeanConverter {
	
	@CommonLog Logger log;
	
	private WebSquareConfig wqConfig;
	private String requestDateFormat;
	private String responseDateFormat;
	
	private boolean outListBeanTypeCheck = true;
	
	private Map denied = new HashMap() {
		{
			put("hashCode", "hashCode");
			put("getClass", "getClass");
			put("wait", "wait");
			put("equals", "equals");
			put("toString", "toString");
			put("notify", "notify");
			put("notifyAll", "notifyAll");
			put("getServlet", "getServlet");
			put("getServletWrapper", "getServletWrapper");
		}
	};
	
	public WqBeanConverter() {
		wqConfig = WebSquareConfig.getInstance();
		requestDateFormat = wqConfig.getStringValue("//adapter" + AdapterUtil.getID() + "/bean/dateFormat/@request", "yyyyMMdd");
		responseDateFormat = wqConfig.getStringValue("//adapter" + AdapterUtil.getID() + "/bean/dateFormat/@response", "yyyyMMdd");
		
		String flagStr = wqConfig.getStringValue("//adapter" + AdapterUtil.getID() + "/bean/outListBeanTypeCheck/@value", "true");
		if(flagStr != null && flagStr.trim().equals("false")) outListBeanTypeCheck = false;
	}

	public Object getComplexMAPtoVO(Map map) throws Exception {
		return getComplexMAPtoVO(map, null);
	}

	public Object getComplexMAPtoVO(Map map, Map beanDef) throws Exception {
		
		Object obj = prcComplexMAPtoVO(beanDef, map, null);
		return obj;
	}
	
	private Object prcComplexMAPtoVO(Map beanDef, Map map, String beanId) throws Exception {
		
		String key = null;
		Object valueObj = null;

		Object subObj = null;

		Method getMethod = null;
		Method setMethod = null;
		Class selfType = null;

		if(beanId == null || beanId.trim().equals("")) beanId = "root";
		Object obj = getBean(beanDef, beanId);

		if(obj == null) {	// Bean 객체가 아닌 Map 객체 그대로 처리...

			for (Iterator iterator = map.keySet().iterator(); iterator.hasNext();) {

				key = (String)iterator.next();
				if(key.equals("BEAN_DEF")) continue;

				valueObj = map.get(key);

				if(valueObj instanceof Map) {

					subObj = prcComplexMAPtoVO(beanDef, (Map)valueObj, key);

					map.put(key, subObj);

				} else if(valueObj instanceof List) {

					List valueList = (List)valueObj;
					List outList = new ArrayList();

					Map tmpMap = null;
					for (int i = 0; i < valueList.size() ; i++) {
						tmpMap = (Map)valueList.get(i);

						subObj = prcComplexMAPtoVO(beanDef, tmpMap, key);
						outList.add(subObj);
					}

					map.put(key, outList);

				} else {
					// do nothing...
				}
				
				obj = map;
			}

		} else {

			
			selfType = obj.getClass();
			
			Class returnType = null;
			
			
			for(Iterator iterator = map.keySet().iterator(); iterator.hasNext();) {
				
				try {
				
					key = (String)iterator.next();
					if(key.equals("BEAN_DEF")) continue;
					
					valueObj = map.get(key);
					
					if(key.startsWith("is")) {
						
						try {
							getMethod = selfType.getMethod(key, null);
						} catch(NoSuchMethodException e1) {
							try {
								getMethod = selfType.getMethod("get"+getFirstUpper(key), null);
							} catch(NoSuchMethodException e2) {
								continue;
							}
						}
						
					} else {
						try {
							getMethod = selfType.getMethod("get"+getFirstUpper(key), null);
						} catch(NoSuchMethodException e1) {
							try {
								getMethod = selfType.getMethod("is"+getFirstUpper(key), null);
							} catch(NoSuchMethodException e2) {
								continue;
							}
						}
					}
					
					returnType = getMethod.getReturnType();
					
					if(valueObj instanceof Map) {
						
						subObj = prcComplexMAPtoVO(beanDef, (Map)valueObj, key);
	
						setMethod = selfType.getMethod("set"+getFirstUpper(key), new Class[]{returnType});
						
						Class beanType = getBeanType(beanDef, key);
						if(beanType == null) {
							throw new Exception("You must define the Bean Class Definition for list '" + key + "'. prcComplexMAPtoVO ");
						}
						
						setMethod.invoke(obj, new Object[]{ subObj });
	
					} else if(valueObj instanceof List) {
	
						List valueList = (List)valueObj;
						List outList = new ArrayList();
	
						Map tmpMap = null;
						for (int i = 0; i < valueList.size() ; i++) {
							tmpMap = (Map)valueList.get(i);
	
							subObj = prcComplexMAPtoVO(beanDef, tmpMap, key);
							outList.add(subObj);
						}
	
						setMethod = selfType.getMethod("set"+getFirstUpper(key), new Class[]{returnType});
						setMethod.invoke(obj, new Object[]{ outList });
					
					} else {
						if(returnType == int.class || returnType == Integer.class) {
							setMethod = selfType.getMethod("set"+getFirstUpper(key), new Class[]{returnType});
							setMethod.invoke(obj, new Object[]{new Integer((String)valueObj)});
						} else if(returnType == boolean.class || returnType == Boolean.class) {
							
							if(key.startsWith("is")) {
								
								try {
									setMethod = selfType.getMethod("set"+getFirstUpper(key.substring(2)), new Class[]{returnType});
								} catch(NoSuchMethodException e1) {
									setMethod = selfType.getMethod("set"+getFirstUpper(key), new Class[]{returnType});
								}
								
							} else {
								setMethod = selfType.getMethod("set"+getFirstUpper(key), new Class[]{returnType});
							}
							
							setMethod.invoke(obj, new Object[]{new Boolean((String)valueObj)});
						} else if(returnType == String.class) {
							setMethod = selfType.getMethod("set"+getFirstUpper(key), new Class[]{returnType});
							setMethod.invoke(obj, new Object[]{(String)valueObj});
						} else if(returnType == float.class || returnType == Float.class){
							setMethod = selfType.getMethod("set"+getFirstUpper(key), new Class[]{returnType});
							setMethod.invoke(obj, new Object[]{new Float((String)valueObj)});
						} else if(returnType == double.class || returnType == Double.class){
							setMethod = selfType.getMethod("set"+getFirstUpper(key), new Class[]{returnType});
							setMethod.invoke(obj, new Object[]{new Double((String)valueObj)});
						} else if(returnType == BigDecimal.class){
							setMethod = selfType.getMethod("set"+getFirstUpper(key), new Class[]{returnType});
							setMethod.invoke(obj, new Object[]{new BigDecimal((String)valueObj)});
						} else if(returnType == long.class || returnType == Long.class){
							setMethod = selfType.getMethod("set"+getFirstUpper(key), new Class[]{returnType});
							setMethod.invoke(obj, new Object[]{new Long((String)valueObj)});
						} else if(returnType == Date.class){
							setMethod = selfType.getMethod("set"+getFirstUpper(key), new Class[]{returnType});
							SimpleDateFormat sdf = new SimpleDateFormat(requestDateFormat);
							setMethod.invoke(obj, new Object[]{sdf.parse((String)valueObj)});
						} else {
							setMethod = selfType.getMethod("set"+getFirstUpper(key), new Class[]{returnType});
							setMethod.invoke(obj, new Object[]{(String)valueObj});
						} 
					}
			
			
				} catch (SecurityException e) {
					//log.info(e);
					//throw(e);
				} catch (NoSuchMethodException e) {
					//log.info(e);
					//throw(e);
				} catch (IllegalArgumentException e) {
					//log.info(e);
					//throw(e);
				} catch (IllegalAccessException e) {
					//log.info(e);
					//throw(e);
				} catch (InvocationTargetException e) {
					//log.info(e);
					//throw(e);
				}
				
			}
			
		}

		return obj;
	}
	

	public Map getComplexVOtoMAP(Object obj, Map beanDef) throws Exception {
		return prcComplexVOtoMAP(obj, beanDef);
	}
	

	public Map prcComplexVOtoMAP(Object obj, Map beanDef) throws Exception {
		
		Map map = new HashMap();
		Object o = null;
		String key = null;
		Map objMap = null;

		if(obj != null){

			if(obj instanceof Map) {

				objMap = (Map)obj;

				for (Iterator iterator = objMap.keySet().iterator(); iterator.hasNext();) {
					key = (String)iterator.next();
					o = objMap.get(key);

					if(o instanceof Map) {
						Map tmpMap = prcComplexVOtoMAP(o, beanDef);
						map.put(key, tmpMap);
					} else if(o instanceof List) {
						List tmpList = getListVOtoList((List)o, beanDef, key);
						map.put(key, tmpList);
					} else if(o instanceof Object[]) {
						//List tmpList = getListVOtoList((Object[])o, beanDef, key);
						//map.put(key, tmpList);
					} else {
						map.put(key, o.toString());
					}
				}

			} else {
				
				Class c = obj.getClass();
				//String fieldName = null;
				//Class valueType = null;
				//String value = null;
				String methodName = null;
				Method method = null;
					
				Method[] m = c.getMethods();
				Field tmpField = null;
				
				for(int i = 0; i < m.length; i++){
					
					methodName = m[i].getName();//메소스 이름을 반환 받음
					
					if(!isDeniedMethodName(methodName)){
						
						if(!methodName.startsWith("get") && !methodName.startsWith("is")) {
							continue;
						}
						
						try{
							try {
								method = c.getMethod(methodName, null);
							} catch (NoSuchMethodException e) {
								continue;
							}

							o = method.invoke(obj, null);

							if(o == null) {
								continue;
							}
							
							//valueType = o.getClass();
							
							String fieldNameForGet = getFirstLower(methodName.substring(3));
							String fieldNameForIs = getFirstLower(methodName.substring(2));

							if(o instanceof Map) {
								Map tmpMap = prcComplexVOtoMAP(o, beanDef);
								map.put(fieldNameForGet, tmpMap);		// get...
							} else if(o instanceof List) {
								List tmpList = getListVOtoList((List)o, beanDef, fieldNameForGet);
								map.put(fieldNameForGet, tmpList);		// get...
							} else if(o instanceof Object[]) {
								//List tmpList = getListVOtoList((Object[])o, beanDef, fieldNameForGet);
								//map.put(fieldNameForGet, tmpList);		// get...
							} else if(o instanceof Date) {
								SimpleDateFormat formatter = new SimpleDateFormat(responseDateFormat);
								map.put(fieldNameForGet, formatter.format((Date)o));	// get...
							} else if(o instanceof Boolean) {
								if(methodName.startsWith("is")) {
									try {
										tmpField = c.getDeclaredField(fieldNameForIs);
										map.put(tmpField.getName(), o.toString());	// is...
									} catch(NoSuchFieldException nsfe1) {
										try {
											tmpField = c.getDeclaredField(methodName);
											map.put(methodName, o.toString());	// is...
										} catch(NoSuchFieldException nsfe2) {
											map.put(fieldNameForIs, o.toString());	// is...
										}
									}
								} else {
									map.put(fieldNameForGet, o.toString());	// get...
								}
							} else {
								
								Class beanType = getBeanType(beanDef, fieldNameForGet);
								
								if(beanType == null) {
									map.put(fieldNameForGet, o.toString());	// get...
								} else {
									Map tmpMap = prcComplexVOtoMAP(o, beanDef);
									map.put(fieldNameForGet, tmpMap);		// get...
								}
							}

						}catch(Exception e){
							//log.debug("getMethod error 111 : " + e.toString());
						}

					}
				}
			}
		}

		return map;
	}
	
	private Class getBeanType(Map beanDef, String id) throws Exception {
		String className = null;
		Class ctrClass = null;
		Object beanDefObj = null;
		
		beanDefObj = (Object)beanDef.get(id);
		
		if(beanDefObj == null) {
			return null;
		} else if(beanDefObj instanceof String) {
			className = (String)beanDefObj;
			
			try {
				ctrClass = Class.forName(className);
			} catch (ClassNotFoundException e) {
				throw new Exception("Class not found : " + className);
			}
			
		} else {
			ctrClass = (Class)beanDefObj;
		}
		
		return ctrClass;
	}
	
	private Object getBean(Map beanDef, String id) throws Exception {
		
		Object obj = null;
		Class ctrClass = getBeanType(beanDef, id);
		if(ctrClass == null) return null;
		
		try {
			//Constructor constructor = ctrClass.getConstructor(null);
			//Object obj = constructor.newInstance(null);
			obj = ctrClass.newInstance();
		} catch (InstantiationException e) {
			throw new Exception("메모리에 오브젝트를 올릴수 없습니다.");
		} catch (IllegalAccessException e) {
			throw new Exception("클래스파일 접근 오류입니다.");
		} catch(Exception e) {
			throw e;
		}
		
		return obj;
	}

	/**
	 * 여러건(list) VO (배열 형태)정보를  map 클래스로 변환한다.
	 * @throws Exception 
	 */
	public List getListVOtoList(Object[] obj, Map beanDef, String id) throws Exception {
		
		if(outListBeanTypeCheck) {
			Class beanType = getBeanType(beanDef, id);
			if(beanType == null) {
				throw new Exception("You must define the Bean Class Definition for list '" + id + "'. getListVOtoList 1 ");
			}
		}
		
		Class beanType = getBeanType(beanDef, id);
		ArrayList arrList = new ArrayList();
		for(int i = 0; i < obj.length; i++){
			arrList.add(prcComplexVOtoMAP(obj[i], beanDef));
		}
		return arrList;
	}

	/**
	 * 여러건(list) VO (List 클래스 형태) 정보를  map 클래스로 변환한다.
	 * @throws Exception 
	 */
	public List getListVOtoList(List list, Map beanDef, String id) throws Exception {
		
		if(outListBeanTypeCheck) {
			Class beanType = getBeanType(beanDef, id);
			if(beanType == null) {
				throw new Exception("You must define the Bean Class Definition for list '" + id + "'. getListVOtoList 2");
			}
		}
		
		ArrayList arrList = new ArrayList();
		for(int i = 0; i < list.size(); i++){
			arrList.add(prcComplexVOtoMAP(list.get(i), beanDef));
		}
		return arrList;
	}

	private boolean isDeniedMethodName(String methodName){
		if(denied.containsKey(methodName)) return true;
		else return false;
	}

	/**
	 * Map 데이터에서 타입을 리턴
	 * @param map
	 * @return
	 */
	/*
	private String getType(Map map){
		Iterator init = map.keySet().iterator();
		// 헤더 정보
		String type = "";

		while(init.hasNext()){
			String key = (String)init.next();
			Object obj = map.get(key);

			if("header".equals(key)){
				type = ((Map)obj).get("type").toString();
			}
		}

		return type;
	}
	*/

	/**
	 * VO 객체에 VO객체를 바인딩함
	 * @param returnObj
	 * @param value
	 * @param className
	 * @param innerType
	 */
	/*
	private void bindObject(Object returnObj, Object value, String className, String innerType){
		Class oClass = returnObj.getClass();

		String[] tempstr = className.split("\\.");
		String sKey = tempstr[tempstr.length-1];

		try{
			Method method = null;
			if("single".equals(innerType)){
				method = oClass.getMethod("set"+getFirstUpper(sKey), new Class[]{new Object().getClass()});
			}else if("list".equals(innerType)){
				method = oClass.getMethod("set"+getFirstUpper(sKey), new Class[]{new Object[0].getClass()});
			}
			method.invoke(returnObj, new Object[]{value});
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	*/

	private String getFirstUpper(String arg){
		String temp = arg.substring(1);
		arg = arg.substring(0, 1).toUpperCase();
		return arg + temp;
	}

	private String getFirstLower(String arg){
		String temp = arg.substring(1);
		arg = arg.substring(0, 1).toLowerCase();
		return arg + temp;
	}
}
