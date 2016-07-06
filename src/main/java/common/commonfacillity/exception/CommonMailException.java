package common.commonfacillity.exception;

import org.springframework.mail.MailException;

/**
 * 메일 보낼때 발생되는 예외 처리
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
public class CommonMailException extends MailException{
	
	/**
	 * @param message
	 */
	public CommonMailException(String msg) {
		super(msg);
	}

	/**
	 * @param message, keyValue
	 */
	public CommonMailException(String message, MailException e){
		super(message+"|"+e);
	}
}
