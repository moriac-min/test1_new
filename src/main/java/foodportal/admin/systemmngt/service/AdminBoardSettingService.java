package foodportal.admin.systemmngt.service;

import java.util.List;
import java.util.Map;

import common.commonfacillity.uia.WqBaseBean;
import foodportal.admin.systemmngt.vo.BoardSettingVO;
import foodportal.admin.systemmngt.vo.UserSearchVO;

/**
 * AdminBoardSettingService
 * @author 최연길
 * @since 2014.08.29
 * @version 1.0
 * @see
 * 
 * <pre>
 *  Modification Information
 *  수정일      수정자   수정내용
 *  ---------- -------- ---------------------------
 *  2014.08.27 최연길 최초 생성
 * </pre>
 * 
 * Copyright (C) 2014 by NDS., All right reserved.
 */

public interface AdminBoardSettingService {


	/**
	 * 게시판 목록 조회
	 * 
	 * @param 
	 * @return 
	 * @exception Exception
	 */
	public List<BoardSettingVO> selectBoardSettingList(WqBaseBean ibean) throws Exception;
	
	/**
	 * 게시판 정보 저장
	 * 
	 * @param 
	 * @return 
	 * @exception Exception
	 */
	public int saveBoardSetting(WqBaseBean ibean) throws Exception;	

	/**
	 * 게시판 상세 정보 조회
	 * 
	 * @param 
	 * @return 
	 * @exception Exception
	 */
	public BoardSettingVO selectBoardSettingDetail(WqBaseBean ibean) throws Exception;	
	
	/**
	 * 게시판 유저 상세 정보 조회
	 * 
	 * @param 
	 * @return 
	 * @exception Exception
	 */
	
	public List<BoardSettingVO> selectBoardSettingDetailUser(WqBaseBean ibean) throws Exception;
	
	/**
	 * 게시판 중복체크
	 * 
	 * @param 
	 * @return 
	 * @exception Exception
	 */
	public BoardSettingVO selectBoardSettingCheck(WqBaseBean ibean) throws Exception;		
}