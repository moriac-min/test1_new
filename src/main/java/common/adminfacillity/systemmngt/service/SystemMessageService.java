package common.adminfacillity.systemmngt.service;

import java.util.List;
import java.util.Map;

import common.commonfacillity.uia.WqBaseBean;

/**
 * SystemMessageService
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

public interface SystemMessageService {


	/**
	 * 등록된 시스템 메시지 정보 조회
	 * 
	 * @param 
	 * @return 
	 * @exception Exception
	 */
	public List<SystemMessageVO> selectSystemMessage(WqBaseBean ibean) throws Exception;

	/**
	 * 신규 시스템 메시지 정보 저장
	 * 
	 * @param 
	 * @return 
	 * @exception Exception
	 */
	public int saveSystemMessage(WqBaseBean ibean) throws Exception;
	
	/**
	 * 신규 시스템 메시지 정보 등록
	 * 
	 * @param 
	 * @return 
	 * @exception Exception
	 */
	public int insertSystemMessage(WqBaseBean ibean) throws Exception;

	/**
	 * 등록된 시스템 메시지 정보 삭제
	 * 
	 * @param 
	 * @return 
	 * @exception Exception
	 */
	public int deleteSystemMessage(WqBaseBean ibean) throws Exception;

	/**
	 * 등록된 시스템 메시지 정보 수정
	 * 
	 * @param 
	 * @return 
	 * @exception Exception
	 */
	public int updateSystemMessage(WqBaseBean ibean) throws Exception;
}