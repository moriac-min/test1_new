package common.commonfacillity.util;

/**
 * 문자열 유틸리티
 * 
 * @author Bangmaroo
 * @since 2012. 8. 23.
 * @version 1.0
 * @see
 * 
 * <pre>
 *  Modification Information
 *  수정일      수정자   수정내용
 *  ---------- -------- ---------------------------
 *  2012. 8. 23.   Bangmaroo   최초 생성
 * </pre>
 * 
 * Copyright (C) 2012 by NDS., All right reserved.
 */
public class CommonStringUtil {
	
	/**
	 * 좌측을 채울때 사용하는 포멧
	 */
	public static final int FORMAT_LEFT = 10;
	/**
	 * 우측을 채울때 사용하는 포멧
	 */
	public static final int FORMAT_RIGHT = 20;
	
	/**
	 * 문자열을 주어진 길이에 맞게 변환하여 리턴
	 * 
	 * @param formatType 	FORMAT_LEFT, FORMAT_RIGHT 선택
	 * @param len			리턴될 문자열 길이
	 * @param token			빈길이를 채울 문자열(1byte 문자)
	 * @param word			원래문자열			
	 * @return				지정한 길이를 채운 문자열
	 */
	public static String format(int formatType, int len, String token, String word) {
		StringBuilder buff = new StringBuilder();
		
		if (token == null || token.length() > 1) {
			throw new IllegalArgumentException("token은 한 자리 문자열이어야 합니다.");
		} else if (word == null || word.length() > len) {
			throw new IllegalArgumentException("len의 크기는 word.length()보다 커야 합니다.");
		}
		
		int wordLen = word.length();
		int roof = len - wordLen;

		if (formatType == FORMAT_LEFT) { 		// token으로 좌측을 채운다.
			for (int i = 0; i < roof; i++) {
				buff.append(token);
			}
			buff.append(word);
		} else if (formatType == FORMAT_RIGHT) { // token으로 우측을 채운다.
			buff.append(word);
			for (int i = 0; i < roof; i++) {
				buff.append(token);
			}
		} else {
			throw new IllegalArgumentException("Choose formatType only FORMAT_LEFT or FORMAT_RIGHT!!");
		}
		
		return buff.toString();
		
	}
	
	/**
	 * 문자열을 주어진 길이에 맞게 변환하여 리턴(한글은2byte로계산)
	 * len값 보다 큰 문자열이 들어올시 LEFT부터 len길이까지 자른다.
	 * @param formatType 	FORMAT_LEFT, FORMAT_RIGHT 선택
	 * @param len			리턴될 문자열 길이
	 * @param token			빈길이를 채울 문자열(1byte 문자)
	 * @param word			원래문자열			
	 * @return				지정한 길이를 채운 문자열
	 */
	@SuppressWarnings("unused")
	public static String formatbyte(int formatType, int len, String token, String word) {
		StringBuilder buff = new StringBuilder();
		
		int wordLength = 0;
		for(int i = 0; i < word.length(); i++){
			if(word.charAt(i) < 256){
				wordLength++;
			} else {
				wordLength += 2;
			}
		}
		
		if (token == null || token.length() > 1) {
			throw new IllegalArgumentException("token은 한 자리 문자열이어야 합니다.");
		} else if (word == null){
			throw new IllegalArgumentException("word값이 null이어선 안됩니다.");
		} else if (wordLength > len) {
			//throw new IllegalArgumentException("len의 크기는 word.length()보다 커야 합니다.");
			word = leftbyte(word, len-1);
			wordLength = 0;
			
			for(int i = 0; i < word.length(); i++){
				if(word.charAt(i) < 256){
					wordLength++;
				} else {
					wordLength += 2;
				}
			}
		}
		
		int wordLen = wordLength;
		int roof = len - wordLen;

		if (formatType == FORMAT_LEFT) { 		// token으로 좌측을 채운다.
			for (int i = 0; i < roof; i++) {
				buff.append(token);
			}
			buff.append(word);
		} else if (formatType == FORMAT_RIGHT) { // token으로 우측을 채운다.
			buff.append(word);
			for (int i = 0; i < roof; i++) {
				buff.append(token);
			}
		} else {
			throw new IllegalArgumentException("Choose formatType only FORMAT_LEFT or FORMAT_RIGHT!!");
		}
		
		return buff.toString();
		
	}
	
	/**
	 * 문자열을 주어진 길이에 맞게 변환하여 리턴(한글도 길이 1로계산하는 함수)
	 * len값 보다 큰 문자열이 들어올시 LEFT부터 len길이까지 자른다.
	 * @param formatType 	FORMAT_LEFT, FORMAT_RIGHT 선택
	 * @param len			리턴될 문자열 길이
	 * @param token			빈길이를 채울 문자열(1byte 문자)
	 * @param word			원래문자열			
	 * @return				지정한 길이를 채운 문자열
	 */
	@SuppressWarnings("unused")
	public static String formatNotByte(int formatType, int len, String token, String word) {
		StringBuilder buff = new StringBuilder();
		
		int wordLength = word.length();
		
		if (token == null || token.length() > 1) {
			throw new IllegalArgumentException("token은 한 자리 문자열이어야 합니다.");
		} else if (word == null){
			throw new IllegalArgumentException("word값이 null이어선 안됩니다.");
		} else if (wordLength > len) {
			word = leftbyte(word, len-1);
			wordLength = word.length();
		}
		
		int wordLen = wordLength;
		int roof = len - wordLen;

		if (formatType == FORMAT_LEFT) { 		// token으로 좌측을 채운다.
			for (int i = 0; i < roof; i++) {
				buff.append(token);
			}
			buff.append(word);
		} else if (formatType == FORMAT_RIGHT) { // token으로 우측을 채운다.
			buff.append(word);
			for (int i = 0; i < roof; i++) {
				buff.append(token);
			}
		} else {
			throw new IllegalArgumentException("Choose formatType only FORMAT_LEFT or FORMAT_RIGHT!!");
		}
		
		return buff.toString();
		
	}
	
	/**
	 * 문자열을 주어진 길이에 맞게 변환하여 리턴(한글도 길이 3로계산하는 함수)
	 * len값 보다 큰 문자열이 들어올시 LEFT부터 len길이까지 자른다.
	 * @param formatType 	FORMAT_LEFT, FORMAT_RIGHT 선택
	 * @param len			리턴될 문자열 길이
	 * @param token			빈길이를 채울 문자열(1byte 문자)
	 * @param word			원래문자열			
	 * @return				지정한 길이를 채운 문자열
	 */
	@SuppressWarnings("unused")
	public static String formatThirdByte(int formatType, int len, String token, String word) {
		StringBuilder buff = new StringBuilder();
		
		int wordLength = 0;
		for(int i = 0; i < word.length(); i++){
			if(word.charAt(i) < 256){
				wordLength++;
			} else {
				wordLength += 3;
			}
		}
		
		if (token == null || token.length() > 1) {
			throw new IllegalArgumentException("token은 한 자리 문자열이어야 합니다.");
		} else if (word == null){
			throw new IllegalArgumentException("word값이 null이어선 안됩니다.");
		} else if (wordLength > len) {
			//throw new IllegalArgumentException("len의 크기는 word.length()보다 커야 합니다.");
			word = leftbyte(word, len-1);
			wordLength = 0;
			
			for(int i = 0; i < word.length(); i++){
				if(word.charAt(i) < 256){
					wordLength++;
				} else {
					wordLength += 3;
				}
			}
		}
		
		int wordLen = wordLength;
		int roof = len - wordLen;

		if (formatType == FORMAT_LEFT) { 		// token으로 좌측을 채운다.
			for (int i = 0; i < roof; i++) {
				buff.append(token);
			}
			buff.append(word);
		} else if (formatType == FORMAT_RIGHT) { // token으로 우측을 채운다.
			buff.append(word);
			for (int i = 0; i < roof; i++) {
				buff.append(token);
			}
		} else {
			throw new IllegalArgumentException("Choose formatType only FORMAT_LEFT or FORMAT_RIGHT!!");
		}
		
		return buff.toString();
	}
	
	/**
	 * 원본 문자열을 주어진 문자열로 감싼다.
	 * @param word
	 * @param denim
	 * @return
	 */
	public static String wrapWord(String word, String denim) {
		StringBuilder buff = new StringBuilder();
		
		return buff.append(denim).append(word).append(denim).toString();
		
	}
	
	public static String cutBytes(String word, int byteLength) {
		
		if (word == null) {
			return new String();
		}
		byte[] b = word.getBytes();
		
		int l = b.length;
		
		l = l < byteLength ? l : byteLength;	// 문자열의 길이가 주어진인자길이보다 짧으면, 문자열 길이만큼만
		
		return new String (b, 0, l);
	}
	
	public static String leftbyte(String word, int len){
//		System.out.println("Left word = " + word);
//		System.out.println("Left len = " + len);
		int wordLength = 0;
		String returnWord = "";
		for(int i = 0; i < word.length(); i++){
			if(word.charAt(i) < 256){
				wordLength++;
			} else {
				wordLength += 2;
			}
			
			if(!(wordLength > len)){
				//System.out.println("Left wordLength = " + wordLength + ", len = " + len);
				returnWord = returnWord + word.charAt(i);
				//System.out.println("Left returnWord = " + returnWord);
			}
		}
		
		return returnWord;
	}
	
	public static String rightbyte(String word, int len){
		int wordLength = 0;
		String returnWord = "";
		for(int i = word.length(); i > -1; i--){
			if(word.charAt(i) < 256){
				wordLength++;
			} else {
				wordLength += 2;
			}
			
			if(!(wordLength > len)){
				returnWord = word.charAt(i) + returnWord;
			}
		}
		
		return returnWord;
	}
	
	/**
	 * 원본문자열에 맨마지막에 나타난 token문자열로 자른 문자열을 반환한다. 
	 * @param word
	 * @param token
	 * @return
	 */
	public static String lastIndexStr(String word, String token){
		
		if(word == null){
			System.out.println("lastIndexStr lastIndex is null");
			return word;
		} else {
			int lastIndex = word.lastIndexOf(token);
			if(lastIndex == -1){
				System.out.println("lastIndexStr lastIndex is -1");
				return word;
			} else {
				System.out.println("lastIndexStr word = " + word.substring(0, lastIndex+1));
				return word.substring(0, lastIndex+1);
			}
		}
	}
	
	/**
     * 공백문자열에 '0'로 채우기 
     * '1' --> '000001'
     * @param size
     * @param shiftstr
     * @return 공백문자열에 '0'로 채운 값
     */
    public static String toZeroShift( int size, String shiftstr ) {
        int idx = shiftstr.length();
        String  res = "";
        for(int i=0; i<size-idx; i++) {
            res +="0";
        }
        return res+shiftstr;
    }
    
    /**
     * Null 및 공백문자열 체크
     * 
     * @param str
     * @return boolean
     */
    public static boolean isStrEmpty(String str) {
    	
    	if(str == null){
    		return true;
    	}
    	
    	if(str != null){
    		str = str.trim();
    		if(str.length() == 0){
    			return true;
    		}
    	}
    	
    	return false;
    }
}
