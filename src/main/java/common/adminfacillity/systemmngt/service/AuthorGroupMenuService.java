package common.adminfacillity.systemmngt.service;

import java.util.List;
import java.util.Map;

import common.commonfacillity.uia.WqBaseBean;

/**
 * AuthorGroupMenuService
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

public interface AuthorGroupMenuService {


	/**
	 * 등록된 권한 그룹별 메뉴 정보 조회
	 * 
	 * @param 
	 * @return 
	 * @exception Exception
	 */
	public List<AuthorGroupMenuVO> selectAuthorGroupMenu(WqBaseBean ibean) throws Exception;
	
	/**
	 * 신규 권한 그룹별 메뉴 정보 저장
	 * 
	 * @param 
	 * @return 
	 * @exception Exception
	 */
	public int saveAuthorGroupMenu(WqBaseBean ibean) throws Exception;
	
	/**
	 * 신규 권한 그룹별 메뉴 정보 등록
	 * 
	 * @param 
	 * @return 
	 * @exception Exception
	 */
	public int insertAuthorGroupMenu(WqBaseBean ibean) throws Exception;

	/**
	 * 등록된 권한 그룹별 메뉴 정보 수정
	 * 
	 * @param 
	 * @return 
	 * @exception Exception
	 */
	public int updateAuthorGroupMenu(WqBaseBean ibean) throws Exception;

	/**
	 * 등록된 권한 그룹별 메뉴 정보 삭제
	 * 
	 * @param 
	 * @return 
	 * @exception Exception
	 */
	public int deleteAuthorGroupMenu(WqBaseBean ibean) throws Exception;
	
	/**
	 * 사용자가 가진 권한에 대한 메뉴리스트를 가져온다.
	 * 
	 * @param
	 * @return
	 * @exception Exception
	 */
	public List<AuthorGroupMenuVO> selectAuthorMenuList(WqBaseBean ibean) throws Exception;
}