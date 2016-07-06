package foodportal.admin.systemmngt.mapper;

import java.util.List;
import java.util.Map;

import egovframework.rte.psl.dataaccess.mapper.Mapper;
import foodportal.admin.systemmngt.vo.AdminBoardVO;
import foodportal.admin.systemmngt.vo.BoardSettingVO;
import foodportal.admin.systemmngt.vo.CategorySettingVO;
import foodportal.admin.systemmngt.vo.CommonCodeVO;
import foodportal.admin.systemmngt.vo.UploadFileVO;

/**
 * AdminBoardMapper
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

@Mapper("foodportal.admin.systemmngt.mapper.AdminBoardMapper")
public interface AdminBoardMapper {
	
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
	public BoardSettingVO selectAdminBoardOption(Map<String, Object> map);
	
	/**
	 * 게시글 목록 조회 
	 * 
	 * @param 
	 * @return 
	 * @exception Exception
	 */
	public List<AdminBoardVO> selectAdminBoardList(Map<String, Object> map);
	
	/**
	 * 게시글 상세(본문) 조회 
	 * 
	 * @param 
	 * @return 
	 * @exception Exception
	 */
	public AdminBoardVO selectAdminBoardDetail(Map<String, Object> map);
	
	/**
	 * 카테고리 리스트 조회
	 * 
	 * @param 
	 * @return 
	 * @exception Exception
	 */
	public List<CategorySettingVO> selectAdminBoardCategoryList(Map<String, Object> map);
	
	/**
	 * 카테고리 리스트 조회
	 * 
	 * @param 
	 * @return 
	 * @exception Exception
	 */
	public List<CommonCodeVO> selectCmmnCode(Map<String, Object> map);
	
	
	
	/**
	 * 게시글 상세(댓글) 조회 
	 * 
	 * @param 
	 * @return 
	 * @exception Exception
	 */
	public List<AdminBoardVO> selectAdminBoardRep(Map<String, Object> map);
	
	/**
	 * 게시글 상세(첨부파일) 조회 
	 * 
	 * @param 
	 * @return 
	 * @exception Exception
	 */
	public List<UploadFileVO> selectAdminBoardFile(Map<String, Object> map);
	
	/**
	 * 게시글번호 생성 
	 * 
	 * @param 
	 * @return 
	 * @exception Exception
	 */
	public String selectAdminBoardSeqNo();
	
	/**
	 * 게시글마스터 등록 
	 * 
	 * @param 
	 * @return 
	 * @exception Exception
	 */
	public int insertAdminBoardMst(Map<String, Object> map);	
	
	/**
	 * 게시글 본문 등록 
	 * 
	 * @param 
	 * @return 
	 * @exception Exception
	 */
	public int insertAdminBoardContent(Map<String, Object> map);		
	
	/**
	 * 게시글마스터 수정 
	 * 
	 * @param 
	 * @return 
	 * @exception Exception
	 */
	public int updateAdminBoardMst(Map<String, Object> map);
	
	/**
	 * 게시글 본문 수정 
	 * 
	 * @param 
	 * @return 
	 * @exception Exception
	 */
	public int updateAdminBoardContent(Map<String, Object> map);
	
	/**
	 * 게시글 삭제
	 * 
	 * @param 
	 * @return 
	 * @exception Exception
	 */
	public int deleteAdminBoard(Map<String, Object> map);
	
	/**
	 * 첨부파일번호 생성 
	 * 
	 * @param 
	 * @return 
	 * @exception Exception
	 */
	public String selectFileSeqNo();
	
	/**
	 * 첨부파일마스터 등록 
	 * 
	 * @param 
	 * @return 
	 * @exception Exception
	 */
	public int insertAtchFile(Map<String, Object> map);	
	
	/**
	 * 게시글별 첨부파일 등록 
	 * 
	 * @param 
	 * @return 
	 * @exception Exception
	 */
	public int insertNtctxtacctoAtchfl(Map<String, Object> map);
	
	/**
	 * 첨부파일마스터 삭제
	 * 
	 * @param 
	 * @return 
	 * @exception Exception
	 */
	public int deleteAtchFile(Map<String, Object> map);	
	
	/**
	 * 게시글별 첨부파일 삭제
	 * 
	 * @param 
	 * @return 
	 * @exception Exception
	 */
	public int deleteNtctxtacctoAtchfl(Map<String, Object> map);
	
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
	public AdminBoardVO selectTypeBBoardDetail(Map<String, Object> Map);
	
	
	
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
	 * 약관 삭제
	 * 
	 * @param 
	 * @return 
	 * @exception Exception
	 */
	public int updateTermsDelYn(Map<String, Object> map);
	
}
