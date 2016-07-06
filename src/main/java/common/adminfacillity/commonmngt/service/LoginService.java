package common.adminfacillity.commonmngt.service;

import java.util.List;
import java.util.Map;

import common.adminfacillity.commonmngt.service.LoginVO;

/**
 * ComcmService
 * @author 김민규
 * @since 2014.06.12
 * @version 1.0
 * @see
 *
 * <pre>
 *  Modification Information
 *  수정일      수정자   수정내용
 *  ---------- -------- ---------------------------
 *  2014.06.12 김민규   최초 생성
 * </pre>
 *
 * Copyright (C) 2014 by NDS., All right reserved.
 */

public interface LoginService {
	
	/**
	 * 로그인
	 * 
	 * @param LoginVO
	 * @return int
	 * @exception Exception	 
	 */
	public int selectLogin(LoginVO vo) throws Exception;
}
