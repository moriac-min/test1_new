package common.adminfacillity.systemmngt.service;

import java.util.List;
import java.util.Map;

import common.commonfacillity.uia.WqBaseBean;

/**
 * UserService
 * @author 유승엽
 * @since 2014.08.19
 * @version 1.0
 * @see
 * 
 * <pre>
 *  Modification Information
 *  수정일      수정자   수정내용
 *  ---------- -------- ---------------------------
 *  2014.08.19 유승엽 최초 생성
 * </pre>
 * 
 * Copyright (C) 2014 by NDS., All right reserved.
 */

public interface UserService {


	/**
	 * 사용자 조회
	 * 
	 * @param 
	 * @return 
	 * @exception Exception
	 */
	public List<UserVO> selectUser(WqBaseBean ibean) throws Exception;

	/**
	 * 사용자 저장
	 * 
	 * @param 
	 * @return 
	 * @exception Exception
	 */
	public int saveUser(WqBaseBean ibean) throws Exception;
	
	/**
	 * 사용자 등록
	 * 
	 * @param 
	 * @return 
	 * @exception Exception
	 */
	public int insertUser(Map<String,Object> map) throws Exception;

	/**
	 * 사용자 암호 초기화
	 * 
	 * @param 
	 * @return 
	 * @exception Exception
	 */
	public int initPassword(Map<String,Object> map) throws Exception;

	/**
	 * 사용자 수정
	 * 
	 * @param 
	 * @return 
	 * @exception Exception
	 */
	public int updateUser(Map<String,Object> map) throws Exception;
}