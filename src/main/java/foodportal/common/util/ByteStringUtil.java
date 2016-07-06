package foodportal.common.util;

import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * ByteStringUtil
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

public class ByteStringUtil {
	
	/**
	 * Byte -> String 변환
	 * @param bytes
	 * @param startIdx
	 * @param len
	 * 
	 * @return
	 * @throws UnsupportedEncodingException 
	 */
	public String byteToString(byte[] bytes, int startIdx, int len) throws UnsupportedEncodingException
	{
		byte[] data = new byte[len];
		System.arraycopy(bytes, startIdx, data, 0, len);
		
		String str = new String(data, "UTF-8");

		return str;
	}
	
	/**
	 * String padding 후 Byte로 변환하여 return
	 * @param plainText
	 * @param padString
	 * @param fullSize
	 * @return
	 */
	public byte[] padStrToBytes(String plainText, String padString, int fullSize){
		
		int dataSize = plainText.length();
		int fillSize = fullSize - dataSize;
		
		String[] padArray = new String[fillSize];
		Arrays.fill(padArray, padString);
		
		for(int i=0; i<padArray.length; i++){
			padString += padArray[i].toString();
		}
		
		plainText = padString+plainText;
		
		byte[] returnData = plainText.getBytes();
		
		return returnData;
	}
	
	/**
	 * String left padding 후 String return
	 * @param plainText
	 * @param padString
	 * @param fullSize
	 * @return
	 */
	public String lpadStr(String plainText, String padString, int fullSize){
		
		String fillString = "";
		
		if(plainText == null){
			plainText = "";
		}
		
		int dataSize = plainText.length();
		
		if(dataSize == fullSize){
			return plainText;
		}
		int fillSize = fullSize - dataSize;
		
		String[] padArray = new String[fillSize];
		Arrays.fill(padArray, padString);
		
		for(int i=0; i<padArray.length; i++){
			fillString += padArray[i].toString();
		}
		
		plainText = fillString+plainText;
		
		
		return plainText;
	}
	
	
	/**
	 * Integer left padding 후 String return
	 * @param plainText
	 * @param padString
	 * @param fullSize
	 * @return
	 */
	public String lpadStr(String plainText, int padIntVal, int fullSize){
		
		String fillString = "";
		
		if(plainText == null){
			plainText = "";
		}
		
		int dataSize = plainText.length();
		
		if(dataSize == fullSize){
			return plainText;
		}
		
		int fillSize = fullSize - dataSize;
		
		int[] padArray = new int[fillSize];
		Arrays.fill(padArray, padIntVal);
		
		for(int i=0; i<padArray.length; i++){
			fillString += Integer.toString(padArray[i]);
		}
		
		plainText = fillString+plainText;
		
		
		return plainText;
	}
	
	/**
	 * String right padding 후 String return
	 * @param plainText
	 * @param padString
	 * @param fullSize
	 * @return
	 */
	public String rpadStr(String plainText, int fullSize){
		
		String padString = " ";
		String fillString = "";
		
		if(plainText == null || plainText.trim().equals("")){
			plainText = " ";
		}
		
		int dataSize = plainText.length();
		
		if(dataSize == fullSize){
			return plainText;
		}
		int fillSize = fullSize - dataSize;
		
		String[] padArray = new String[fillSize];
		Arrays.fill(padArray, padString);
		
		for(int i=0; i<padArray.length; i++){
			fillString += padArray[i].toString();
		}
		
		plainText = plainText+fillString;
		
		
		return plainText;
	}
	
	
	/**
	 * Integer right padding 후 String return
	 * @param plainText
	 * @param padString
	 * @param fullSize
	 * @return
	 */
	public String rpadStr(String plainText, int padIntVal, int fullSize){
		
		String fillString = "";
		
		if(plainText == null){
			plainText = "";
		}
		
		int dataSize = plainText.length();
		
		if(dataSize == fullSize){
			return plainText;
		}
		
		int fillSize = fullSize - dataSize;
		
		int[] padArray = new int[fillSize];
		Arrays.fill(padArray, padIntVal);
		
		for(int i=0; i<padArray.length; i++){
			fillString += Integer.toString(padArray[i]);
		}
		
		plainText = plainText+fillString;
		
		
		return plainText;
	}
	
	/**
	 * Byte right padding 후 return
	 * @param plainText
	 * @param padString
	 * @param fullSize
	 * @return
	 * @throws UnsupportedEncodingException 
	 */
	/*
	public String rpadByte(String plainText, int fullSize) throws UnsupportedEncodingException{
		
		String tmpPadStr = "";
		
		if(plainText == null){
			plainText = " ";
		}
		
		if(plainText.getBytes("MS949").length == fullSize){
			tmpPadStr = plainText;
		}else{
			
			
			byte[] data = new byte[fullSize];
			
			byte[] temp = plainText.getBytes("MS949");
			
			byte[] paddingData = {(byte)' '};
		   
			System.arraycopy(temp, 0, data, 0, temp.length);
			System.arraycopy(paddingData, 0, data, temp.length, paddingData.length);
			
			tmpPadStr = byteToString(data, 0, data.length);
		}
		
		return tmpPadStr;
	}
	*/
	
	public String rpadByte(String plainText, int fullSize) throws UnsupportedEncodingException{
		
		String tmpPadStr = "";
		
		
		if(plainText == null){
			plainText = " ";
		}
		
		int byteLen = plainText.getBytes("MS949").length;
		
		if(byteLen == fullSize){
			tmpPadStr = plainText;
		}else{
			
			int setSize = fullSize - byteLen;
			
			if(setSize > 0){
				for(int i=0; i<setSize; i++){
					tmpPadStr += " ";
				}
			}
			
			String finalTxt = plainText+tmpPadStr;
			//byte[] data = new byte[fullSize];
			
			byte[] temp = finalTxt.getBytes("MS949");
			
			//System.arraycopy(temp, 0, data, 0, temp.length);
			tmpPadStr = new String(temp, "MS949");
			
			//tmpPadStr = byteToString(data, 0, data.length);
		}
		
		return tmpPadStr;
	}

	/**
     * Byte Substring
     * @param strData
     * @param iStartPos
     * @param iByteLength
     * @return
     */
	public String byteSubString_bak(String strData, int iStartPos, int iByteLength) {
    	 
		byte[] bytTemp = null;
		int iRealStart = 0;
		int iRealEnd = 0;
		int iLength = 0;
		int iChar = 0;

		try {
 
			// UTF-8로 변환하는경우 한글 2Byte, 기타 1Byte로 떨어짐
			bytTemp = strData.getBytes("MS949");
			//bytTemp = strData.getBytes("UTF-8");
			iLength = bytTemp.length;

			for(int iIndex = 0; iIndex < iLength; iIndex++) {
 
				if(iStartPos <= iIndex) {
					break;
				}
 
				iChar = (int)bytTemp[iIndex];
				
				if((iChar > 127)|| (iChar < 0)) {
 
					// 한글의 경우(2byte 통과처리)
					// 한글은 2Byte이기 때문에 다음 글자는 볼것도 없이 스킵한다
					iRealStart++;
					iIndex++;
 
				} else {
					// 기타 글씨(1Byte 통과처리)
					iRealStart++;
				}
			}
 
			iRealEnd = iRealStart;
			int iEndLength = iRealStart + iByteLength;
			for(int iIndex = iRealStart; iIndex < iEndLength; iIndex++)
			{
				iChar = (int)bytTemp[iIndex];
				if((iChar > 127)|| (iChar < 0)) {
					// 한글의 경우(2byte 통과처리)
					// 한글은 2Byte이기 때문에 다음 글자는 볼것도 없이 스킵한다
					iRealEnd++;
					iIndex++;
				} else {
					// 기타 글씨(1Byte 통과처리)
					iRealEnd++;
				}
			}
		} catch(Exception e) {
 
		}

		return strData.substring(iRealStart, iRealEnd);
	}
	
	/**
	  * bytesubstring 한글+공백의 경우 버그수정버전~~ 아 개짜증
	  * @param str
	  * @param startIndex
	  * @param length
	  * @return
	  */
	 public static String byteSubString(String str, int startIndex, int length) 
	 { 
	  byte[] b1 = null; 
	  byte[] b2 = null; 
	 
	  try 
	  { 
	   if (str == null){ 
	    return ""; 
	   } 
	 
	   b1 = str.getBytes(); 
	   b2 = new byte[length]; 
	  
	   if (length > (b1.length - startIndex)){ 
	    length = b1.length - startIndex; 
	   } 
	  
	   System.arraycopy(b1, startIndex, b2, 0, length); 
	   
	  }catch (Exception e){ 
	  } 
	 
	  return new String(b2); 
	 } 
	 
	 /**
	  * 총개발기간 -> 단계차수 분할
	  * @param begin
	  * @param end
	  * @return
	  */
	 public List<Map<String, String>> getCalSteps(String begin, String end){
	        
//       System.out.println("begin : " + begin + "      end : " + end);
       
       int startYear = Integer.parseInt(begin.substring(0, 4));
       int endYear = Integer.parseInt(end.substring(0, 4));
       
       int size = endYear - startYear;
//       System.out.println("===size===>"+size);
       
       List<Map<String, String>> list = new ArrayList<Map<String, String>>();
       Map<String, String> map = null;
       
       String startDate = "";
       String endDate = end.substring(4, 8);
       
       if(size > 0){
           String tmp_yyyyMMdd = "";
           
           for(int i = 0; i < size; i++){
               map = new HashMap<String, String>();    
               if(i == 0){     //첫해
                   
                   tmp_yyyyMMdd = Integer.toString(startYear+1)+endDate;
                   map.put("start", begin);
                   map.put("end", tmp_yyyyMMdd);
                   tmp_yyyyMMdd = getCalEndYear(tmp_yyyyMMdd, 1);
                   startDate = tmp_yyyyMMdd.substring(4, 8);
                   startYear++;
                   list.add(map);
                   
//                   System.out.println(i+"====111=====date======>"+yearArray[i].toString());
                   
               }else if(i == size - 1){  //마지막해
                   map.put("start", tmp_yyyyMMdd);
                   map.put("end", endYear+endDate);
                   list.add(map);
//                   System.out.println(i+"====333=====date======>"+yearArray[i].toString());
              
               }else{  //중간해
                   int day = 0;
                   if("1231".equals(endDate)){
                       day = 0;
                   }else{
                       day = 365;
                   }
                   map.put("start", tmp_yyyyMMdd);
                   map.put("end", getCalEndYear(tmp_yyyyMMdd, day).substring(0,4)+endDate);
                   list.add(map);
                   tmp_yyyyMMdd = getCalEndYear(getCalEndYear(tmp_yyyyMMdd, day).substring(0,4)+endDate, 1);
               }
               
//               startYear++;
               
           }
       }else{
           map = new HashMap<String, String>();    
           map.put("start", begin);
           map.put("end", end);
           list.add(map);
       }
       
       return list;
   }
   
   
   public String getCalEndYear(String yyyyMMdd, int day){
       
       int beginYear = Integer.parseInt(yyyyMMdd.substring(0, 4));
       int beginMonth = Integer.parseInt(yyyyMMdd.substring(4, 6));
       int beginDay = Integer.parseInt(yyyyMMdd.substring(6, 8));

       SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
       
       String currentTime = sdf.format(new java.util.Date());
       
       Calendar cal = Calendar.getInstance();
       cal.set(beginYear, beginMonth-1, beginDay);
       
       /*
       String fromDate = sdf.format(cal.getTime()); 
       System.out.println("Calendar 이용 (연산 전) : " + fromDate);
       */
//       System.out.println("====getActualMaximum===>"+cal.getActualMaximum(Calendar.DAY_OF_YEAR));
//       System.out.println("======DAY_OF_MONTH=======>"+cal.getActualMaximum(Calendar.DAY_OF_MONTH));
       if(day == 365){
           if(cal.getActualMaximum(Calendar.DAY_OF_YEAR) == 365){
//               day =+ 1;
           }else{
               day = cal.getActualMaximum(Calendar.DAY_OF_YEAR);
           }
       }
//       System.out.println("====v===>"+day);
       cal.add(Calendar.DATE, day);    // 날짜증가
       String toDate = sdf.format(cal.getTime());
//       System.out.println("Calendar 이용 (연산 후) : " + toDate);
       
       return toDate;
   }
   
}
