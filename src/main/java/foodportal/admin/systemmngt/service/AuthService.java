package foodportal.admin.systemmngt.service;

import java.util.List;

import common.commonfacillity.uia.WqBaseBean;

import foodportal.admin.systemmngt.vo.AuthVO;

/**
 * AuthService
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

public interface AuthService {


	/**
	 * 권한 목록 조회
	 * 
	 * @param 
	 * @return 
	 * @exception Exception
	 */
	public List<AuthVO> selectAuthList(WqBaseBean ibean) throws Exception;
	
	/**
	 * 권한 상세 조회
	 * 
	 * @param 
	 * @return 
	 * @exception Exception
	 */
	public AuthVO selectAuthDetail(WqBaseBean ibean) throws Exception;
	
	/**
	 * 권한 등록
	 * 
	 * @param 
	 * @return 
	 * @exception Exception
	 */
	public int insertAuth(WqBaseBean ibean) throws Exception;
	
	/**
	 * 권한 수정
	 * 
	 * @param 
	 * @return 
	 * @exception Exception
	 */
	public int updateAuth(WqBaseBean ibean) throws Exception;
	
	/**
	 * 권한 삭제
	 * 
	 * @param 
	 * @return 
	 * @exception Exception
	 */
	public int deleteAuth(WqBaseBean ibean) throws Exception;
	
	/**
	 * 권한 저장
	 * 
	 * @param 
	 * @return 
	 * @exception Exception
	 */
	public int saveAuth(WqBaseBean ibean) throws Exception;
	
}