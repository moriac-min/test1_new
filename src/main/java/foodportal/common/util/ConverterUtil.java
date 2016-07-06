package foodportal.common.util;

import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.json.simple.parser.ContainerFactory;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

/**
 * ConverterUtil
 * @author 박재형
 * @since 2014.08.27
 * @version 1.0
 * @see
 *
 * <pre>
 *  Modification Information
 *  수정일      수정자   수정내용
 *  ---------- -------- ---------------------------
 *  2014.08.27 박재형 최초 생성
 * </pre>
 *
 * Copyright (C) 2014 by NDS., All right reserved.
 */
public final class ConverterUtil {
	
    private final static JSONParser jsonParser  = new JSONParser( );
    private final static ContainerFactory containerFactory = new ContainerFactory( )
    {
        public List< Object > creatArrayContainer( )
        {
            return new LinkedList< Object >( );
        }

        public Map< String , Object > createObjectContainer( )
        {
            return new LinkedHashMap< String , Object >( );
        }
    };

    private final static JsonSerializer<Date> ser = new JsonSerializer<Date>() {
        @Override
        public JsonElement serialize(Date src, Type arg1, JsonSerializationContext arg2) {
            return src == null ? null : new JsonPrimitive(src.getTime());
        }
    };

    private final static JsonDeserializer<Date> deser = new JsonDeserializer<Date>() {
        @Override
        public Date deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
            return json == null ? null : new Date(json.getAsLong());
        }
    };
    
    /**
     * request에 있는 json형식의 데이터(리스트배열)를 추출 후 list로 반환
     * @param request
     * @return
     * @throws ParseException
     */
    public List<HashMap<Object, Object>> parseJsonToList(HttpServletRequest request, String paramMap) throws ParseException{
        List<HashMap<Object, Object>> resultList = new ArrayList();
        
        
        try {
            String[] tmp = (String[]) request.getParameterMap().get(paramMap);
            
            String tmpStr = tmp[0].toString();
            
            JSONArray jsonArray = (JSONArray) JSONValue.parse(tmpStr);//JSONarray를 이용해서 현재의 값들을 담는다.
            
            /* 체크
            if(jsonArray.size() > 0){
                for(int i=0; i<jsonArray.size(); i++){
                    JSONObject obj = (JSONObject) jsonArray.get(i);
                    System.out.println("=====>"+obj.get("col_1"));
                }
            }
            */
            
            HashMap<Object, Object> dataMap = null;
            
            for(int j=0; j<jsonArray.size(); j++){
                
                dataMap = new HashMap<Object, Object>();
                JSONObject dataObj = (JSONObject)jsonArray.get(j);
                Map jsonMap = (Map)jsonParser.parse(dataObj.toString(), containerFactory);
                Iterator iter = jsonMap.entrySet().iterator();
                
                while(iter.hasNext()){
                    Map.Entry entry = (Map.Entry)iter.next();
                    if(entry.getValue() != null){
                        dataMap.put(entry.getKey().toString(), entry.getValue().toString());
                    }
                }
                
                resultList.add(dataMap);

            }
        } catch (Exception e) {
        } 
        
        return resultList;
    }
    
    /**
     * Map 을 Vo Object 로 변환
     * @param map
     * @param obj
     * @return
     * @throws Exception
     */
    public Object bindObject(HashMap map, Object obj) throws Exception
    {
        
        try {
            if(map != null)
            {
                Set entries = map.entrySet();
                Iterator it = entries.iterator();
                Class oClass = obj.getClass();
                Method[] methods = oClass.getDeclaredMethods();
                
                while (it.hasNext())
                {
                    Map.Entry entry = (Map.Entry) it.next();
                    String sKey = (String)entry.getKey();
                    String sValue = (String)entry.getValue();
                    try
                    {   
                        sKey = sKey.substring(0, 1).toUpperCase()+sKey.substring(1, sKey.length());
                        for(int i=0; i<methods.length; i++){
                            if(methods[i].getName().toString().equals("set"+sKey)){
                                Method method = oClass.getDeclaredMethod("set"+sKey, new Class[]{new String().getClass()});
                                method.invoke(obj, new Object[]{entry.getValue()});
                            }
                        }
                    }
                    catch(Exception ex)
                    {
                       System.out.println("bindObject error : " + ex.toString());
                    }
                }
            }
        } catch (Exception e) {
        }
        
        return obj;
    }
}
    


