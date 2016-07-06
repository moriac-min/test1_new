package foodportal.admin.systemmngt.service;

import java.util.List;

import common.commonfacillity.uia.WqBaseBean;
import foodportal.admin.systemmngt.vo.BoardSettingVO;
import foodportal.admin.systemmngt.vo.MenuVO;

/**
 * AdminMenuService
 * @author 박재형
 * @since 2014.08.27
 * @version 1.0
 * @see
 * 
 * <pre>
 *  Modification Information
 *  수정일      수정자   수정내용
 *  ---------- -------- ---------------------------
 *  2014.08.27 박재형 최초 생성
 * </pre>
 * 
 * Copyright (C) 2014 by NDS., All right reserved.
 */

public interface AdminMenuService {


	/**
	 * 등록된 메뉴 정보 조회
	 * 
	 * @param 
	 * @return 
	 * @exception Exception
	 */
	public List<MenuVO> selectMenuList(WqBaseBean ibean) throws Exception;
	
	/**
	 * 메뉴 정보 저장
	 * 
	 * @param 
	 * @return 
	 * @exception Exception
	 */
	public int saveMenu(WqBaseBean ibean) throws Exception;
	
	/**
	 * 등록된 메뉴 상세 정보 조회
	 * 
	 * @param 
	 * @return 
	 * @exception Exception
	 */
	public MenuVO selectMenuDetail(WqBaseBean ibean) throws Exception;
	
	/**
	 * 등록된 게시판 목록 조회
	 * 
	 * @param 
	 * @return 
	 * @exception Exception
	 */
	public List<BoardSettingVO> selectBoardSettingList(WqBaseBean ibean) throws Exception;
	
	/**
	 * 메인 메뉴 정보 조회
	 * 
	 * @param 
	 * @return 
	 * @exception Exception
	 */
	public List<MenuVO> selectMainMenuList(WqBaseBean ibean) throws Exception;
	
	/**
	 * 게시판이동 게시판목록조회
	 * 
	 * @param 
	 * @return 
	 * @exception Exception
	 */
	public List<MenuVO> selectBbsMoveList(WqBaseBean ibean) throws Exception;
	
	/**
	 * 게시판영역컨텐츠 목록
	 * 
	 * @param 
	 * @return 
	 * @exception Exception
	 */
	public List<MenuVO> selectBbsRelmCntntsList(WqBaseBean ibean) throws Exception;
	
	/**
	 * 게시판영역컨텐츠 사용 목록
	 * 
	 * @param 
	 * @return 
	 * @exception Exception
	 */
	public List<MenuVO> selectBbsRelmMenuList(WqBaseBean ibean) throws Exception;
	
	/**
	 * 사용 게시판영역컨텐츠 등록
	 * 
	 * @param 
	 * @return 
	 * @exception Exception
	 */
	public int saveUseBbsRelmCntntsList(WqBaseBean ibean) throws Exception;
	
}