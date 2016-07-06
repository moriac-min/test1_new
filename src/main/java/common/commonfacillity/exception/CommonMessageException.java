package common.commonfacillity.exception;

/**
 * 사용자가 임의로 발생시키는 예외
 * 
 * @author 김민규
 * @since 2014.09.01
 * @version 1.0
 * @see
 * 
 * <pre>
 *  Modification Information
 *  수정일      수정자   수정내용
 *  ---------- -------- ---------------------------
 *  2014.09.01 김민규   최초 생성
 * </pre>
 * 
 * Copyright (C) 2014 by NDS., All right reserved.
 */
@SuppressWarnings("serial")
public class CommonMessageException extends RuntimeException{

	/**
	 * 
	 */
	public CommonMessageException(){
	}

	/**
	 * @param message
	 */
	public CommonMessageException(String message){
		super(message);
	}
	
	
	/**
	 * @param message, keyValue
	 */
	public CommonMessageException(String message, StringBuilder keyValue){
		super(message+"|"+keyValue);
	}
}
