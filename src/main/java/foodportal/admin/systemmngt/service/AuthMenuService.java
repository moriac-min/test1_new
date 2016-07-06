package foodportal.admin.systemmngt.service;

import java.util.List;

import common.commonfacillity.uia.WqBaseBean;
import foodportal.admin.systemmngt.vo.AuthMenuVO;
import foodportal.admin.systemmngt.vo.AuthVO;
import foodportal.admin.systemmngt.vo.MenuVO;

/**
 * AuthMenuService
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

public interface AuthMenuService {


	/**
	 * 권한 목록 조회
	 * 
	 * @param 
	 * @return 
	 * @exception Exception
	 */
	public List<AuthVO> selectAuthList(WqBaseBean ibean) throws Exception;
	
	/**
	 * 메뉴 목록 조회
	 * 
	 * @param 
	 * @return 
	 * @exception Exception
	 */
	public List<MenuVO> selectMenuList(WqBaseBean ibean) throws Exception;
	
	/**
	 * 권한별 메뉴 목록 조회
	 * 
	 * @param 
	 * @return 
	 * @exception Exception
	 */
	public List<AuthMenuVO> selectAuthMenuList(WqBaseBean ibean) throws Exception;
	
	/**
	 * 권한별 메뉴 등록
	 * 
	 * @param 
	 * @return 
	 * @exception Exception
	 */
	public int insertAuthMenu(WqBaseBean ibean) throws Exception;
	
	/**
	 * 권한별 메뉴 수정
	 * 
	 * @param 
	 * @return 
	 * @exception Exception
	 */
	public int updateAuthMenu(WqBaseBean ibean) throws Exception;
	
	/**
	 * 권한별 메뉴 삭제
	 * 
	 * @param 
	 * @return 
	 * @exception Exception
	 */
	public int deleteAuthMenu(WqBaseBean ibean) throws Exception;
	
	/**
	 * 권한별 메뉴 저장
	 * 
	 * @param 
	 * @return 
	 * @exception Exception
	 */
	public int saveAuthMenu(WqBaseBean ibean) throws Exception;
	
}