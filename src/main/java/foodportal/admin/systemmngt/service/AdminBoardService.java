package foodportal.admin.systemmngt.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.commonfacillity.uia.WqBaseBean;
import foodportal.admin.systemmngt.vo.AdminBoardVO;
import foodportal.admin.systemmngt.vo.BoardSettingVO;
import foodportal.admin.systemmngt.vo.CategorySettingVO;
import foodportal.admin.systemmngt.vo.CommonCodeVO;
import foodportal.admin.systemmngt.vo.UploadFileVO;

/**
 * AdminBoardService
 * @author 박재형
 * @since 2014.09.03
 * @version 1.0
 * @see
 * 
 * <pre>
 *  Modification Information
 *  수정일      수정자   수정내용
 *  ---------- -------- ---------------------------
 *  2014.09.03 박재형 최초 생성
 * </pre>
 * 
 * Copyright (C) 2014 by NDS., All right reserved.
 */

public interface AdminBoardService {

	/*******************************************************************************/
	/******************************공통영역*****************************************/
	/*******************************************************************************/
	
	/**
	 * 게시판 속성 조회 
	 * 
	 * @param 
	 * @return 
	 * @exception Exception
	 */
	public BoardSettingVO selectAdminBoardOption(WqBaseBean ibean) throws Exception;
	
	/**
	 * 게시글 목록 조회 
	 * 
	 * @param 
	 * @return 
	 * @exception Exception
	 */
	public List<AdminBoardVO> selectAdminBoardList(WqBaseBean ibean) throws Exception;
	
	/**
	 * 게시글 상세(본문) 조회 
	 * 
	 * @param 
	 * @return 
	 * @exception Exception
	 */
	public AdminBoardVO selectAdminBoardDetail(WqBaseBean ibean) throws Exception;
	
	/**
	 * 게시글 상세(본문) 조회 
	 * 
	 * @param 
	 * @return 
	 * @exception Exception
	 */
	public List<UploadFileVO> selectAdminBoardFileList(WqBaseBean ibean) throws Exception;
	
	/**
	 * 카테고리목록 조회
	 * 
	 * @param 
	 * @return 
	 * @exception Exception
	 */
	public List<CategorySettingVO> selectAdminBoardCategoryList(WqBaseBean ibean) throws Exception;
	
	/**
	 * 공통코드 조회
	 * 
	 * @param 
	 * @return 
	 * @exception Exception
	 */
	public List<CommonCodeVO> selectCmmnCode(WqBaseBean ibean) throws Exception;
	
	/**
	 * 게시글 상세(댓글) 조회 
	 * 
	 * @param 
	 * @return 
	 * @exception Exception
	 */
	public List<AdminBoardVO> selectAdminBoardRep(WqBaseBean ibean) throws Exception;
	
	/**
	 * 게시글 저장
	 * falg : insert, update, delete
	 * @param 
	 * @return 
	 * @exception Exception
	 */
	public int saveAdminBoard(WqBaseBean ibean) throws Exception;
	
	/**
	 * 게시글 저장
	 * falg : insert, update, delete
	 * @param 
	 * @return 
	 * @exception Exception
	 */
	public int saveAdminBoard(WqBaseBean ibean, String flag) throws Exception;
	
	/**
	 * 첨부파일 다운로드
	 * 
	 * @param 
	 * @return 
	 * @exception Exception
	 */
	public void downloadAttchdFile(HttpServletRequest request, HttpServletResponse response) throws Exception;
	
	
	/*******************************************************************************/
	/******************************일반게시판***************************************/
	/*******************************************************************************/
	
	
	
	
	/*******************************************************************************/
	/******************************뉴스형게시판*************************************/
	/*******************************************************************************/
	
	
	
	/*******************************************************************************/
	/******************************컨텐츠A형****************************************/
	/*******************************************************************************/
	
	
	
	/*******************************************************************************/
	/******************************컨텐츠B형****************************************/
	/*******************************************************************************/
	/**
	 * Type B 게시판 상세 조회
	 * 
	 * @param 
	 * @return 
	 * @exception Exception
	 */
	public AdminBoardVO selectTypeBBoardDetail(WqBaseBean ibean) throws Exception;
	
	/*******************************************************************************/
	/******************************관련사이트******************************************/
	/*******************************************************************************/
	/**
	 * 관련 사이트 관리 등록/수정
	 * 
	 * @param 
	 * @return ModelAndView
	 * @throws Exception
	 */
	public int saveRelateSite(WqBaseBean ibean);
	
	
	/*******************************************************************************/
	/******************************포토게시판***************************************/
	/*******************************************************************************/
	
	
	/*******************************************************************************/
	/******************************동영상게시판*************************************/
	/*******************************************************************************/
	
	
	/*******************************************************************************/
	/******************************FAQ**********************************************/
	/*******************************************************************************/
	
	
	
	/*******************************************************************************/
	/******************************약관*********************************************/
	/*******************************************************************************/
	
	
	/**
	 * 약관저장
	 * 
	 * @param 
	 * @return 
	 * @exception Exception
	 */
	public int saveTerms(WqBaseBean ibean) throws Exception;
	
	
}