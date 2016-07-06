package common.commonfacillity.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;

/**
 * SessionUtil
 * 
 * @author Bangmaroo
 * @since 2012. 8. 29.
 * @version 1.0
 * @see
 * 
 *      <pre>
 *  Modification Information
 *  수정일      수정자   수정내용
 *  ---------- -------- ---------------------------
 *  2012. 8. 29.   Bangmaroo   최초 생성
 * </pre>
 * 
 *      Copyright (C) 2012 by NDS., All right reserved.
 */
public class CommonSessionUtil {
	
	protected final static Logger log = LoggerFactory.getLogger(CommonSessionUtil.class);
	/**
	 * attribute 값을 가져 오기 위한 method
	 * 
	 * @param String
	 *            attribute key name
	 * @return Object attribute obj
	 */
	public static Object getAttribute(String name) throws Exception {
		Object obj = null;
		try {
			obj =  (Object) RequestContextHolder.getRequestAttributes().getAttribute(name, RequestAttributes.SCOPE_SESSION);
		} catch (Exception e) {
			log.error("Session is Null!!!");
		}
		return obj;
	}

	/**
	 * attribute 설정 method
	 * 
	 * @param String
	 *            attribute key name
	 * @param Object
	 *            attribute obj
	 * @return void
	 */
	public static void setAttribute(String name, Object object) throws Exception {
		try {
		RequestContextHolder.getRequestAttributes().setAttribute(name, object, RequestAttributes.SCOPE_SESSION);
		} catch (Exception e) {
			log.error("Session is Null!!!");
		}
	}

	/**
	 * 설정한 attribute 삭제
	 * 
	 * @param String
	 *            attribute key name
	 * @return void
	 */
	public static void removeAttribute(String name) throws Exception {
		RequestContextHolder.getRequestAttributes().removeAttribute(name, RequestAttributes.SCOPE_SESSION);
	}

	/**
	 * session id
	 * 
	 * @param void
	 * @return String SessionId 값
	 */
	public static String getSessionId() throws Exception {
		return RequestContextHolder.getRequestAttributes().getSessionId();
	}
}
