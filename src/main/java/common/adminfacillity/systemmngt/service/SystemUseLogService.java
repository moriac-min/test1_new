package common.adminfacillity.systemmngt.service;

import java.util.List;
import java.util.Map;

/**
 * SystemUseLogService
 * @author 김민규
 * @since 2014.08.19
 * @version 1.0
 * @see
 * 
 * <pre>
 *  Modification Information
 *  수정일      수정자   수정내용
 *  ---------- -------- ---------------------------
 *  2014.08.19 김민규 최초 생성
 * </pre>
 * 
 * Copyright (C) 2014 by NDS., All right reserved.
 */

public interface SystemUseLogService {


	/**
	 * 등록된 시스템사용로그 정보 조회
	 * 
	 * @param 
	 * @return 
	 * @exception Exception
	 */
	public List<SystemUseLogVO> selectSystemUseLog(Map<String,Object> map) throws Exception;
}