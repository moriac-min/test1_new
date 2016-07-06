package foodportal.admin.systemmngt.service;

import java.util.List;

import common.commonfacillity.uia.WqBaseBean;
import foodportal.admin.systemmngt.vo.AuthVO;
import foodportal.admin.systemmngt.vo.UserAuthMenuVO;
import foodportal.admin.systemmngt.vo.UserAuthVO;
import foodportal.admin.systemmngt.vo.UserVO;

/**
 * UserAuthService
 * @author 임재록
 * @since 2014.08.29
 * @version 1.0
 * @see
 * 
 * <pre>
 *  Modification Information
 *  수정일      수정자   수정내용
 *  ---------- -------- ---------------------------
 *  2014.08.29 임재록 최초 생성
 * </pre>
 * 
 * Copyright (C) 2014 by NDS., All right reserved.
 */

public interface UserAuthService {

	/**
	 * 사용자 목록 조회
	 * 
	 * @param 
	 * @return 
	 * @exception Exception
	 */
	public List<UserVO> selectUserList(WqBaseBean ibean) throws Exception;

	/**
	 * 권한 목록 조회
	 * 
	 * @param 
	 * @return 
	 * @exception Exception
	 */
	public List<AuthVO> selectAuthList(WqBaseBean ibean) throws Exception;
	
	/**
	 * 사용자별 권한 목록 조회
	 * 
	 * @param 
	 * @return 
	 * @exception Exception
	 */
	public List<UserAuthVO> selectUserAuthList(WqBaseBean ibean) throws Exception;
	
	/**
	 * 사용자별 권한 메뉴 조회
	 * 
	 * @param 
	 * @return 
	 * @exception Exception
	 */
	public List<UserAuthMenuVO> selectUserAuthMenuList(WqBaseBean ibean) throws Exception;
	
	/**
	 * 사용자별 권한 등록
	 * 
	 * @param 
	 * @return 
	 * @exception Exception
	 */
	public int insertUserAuth(WqBaseBean ibean) throws Exception;
	
	/**
	 * 사용자별 권한 수정
	 * 
	 * @param 
	 * @return 
	 * @exception Exception
	 */
	public int updateUserAuth(WqBaseBean ibean) throws Exception;
	
	/**
	 * 사용자별 권한 삭제
	 * 
	 * @param 
	 * @return 
	 * @exception Exception
	 */
	public int deleteUserAuth(WqBaseBean ibean) throws Exception;
	
	/**
	 * 사용자별 권한 저장
	 * 
	 * @param 
	 * @return 
	 * @exception Exception
	 */
	public int saveUserAuth(WqBaseBean ibean) throws Exception;
	
}