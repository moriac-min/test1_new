package foodportal.front.common.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import foodportal.front.common.vo.CategoryVo;
import foodportal.front.common.vo.FrontBoardVO;
import foodportal.front.common.vo.FrontMetaKeywordVO;
import foodportal.front.common.vo.UploadFileVO;


/**
 * FrontBoardService
 * @author 박재형
 * @since 2014.09.25
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

public interface FrontBoardService {

	/**
	 * 게시판설정정보 조회
	 * @param paramMap
	 * @return
	 * @throws Exception
	 */
	public FrontBoardVO getBbsSettingInfo(Map<String, Object> map) throws Exception;
	
	/**
	 * 목록 조회
	 * @param frontBoardVO
	 * @return
	 * @throws Exception
	 */
	public Map<String, Object> selectBoardList(FrontBoardVO frontBoardVO) throws Exception;
	
	/**	
	 * 일반형 카테고리 목록 조회
	 * @param frontBoardVO
	 * @return
	 * @throws Exception
	 */
	public List<CategoryVo> selectCtgType01List(FrontBoardVO frontBoardVO) throws Exception;
	
	/**	
	 * 하위 카테고리 목록 조회
	 * @param frontBoardVO
	 * @return
	 * @throws Exception
	 */
	public List<CategoryVo> selectCtgType02List(String ctgry_no) throws Exception;
			
	/**
	 * 글 상세
	 * @param ibean
	 * @return
	 * @throws Exception
	 */
	public FrontBoardVO selectBoardDetail(Map<String, Object> map) throws Exception;
	
	/**
	 * 글 파일첨부
	 * @param ibean
	 * @return
	 * @throws Exception
	 */
	public List<UploadFileVO> selectBoardFile(Map<String, Object> map) throws Exception;
	
	/**
	 * 글 조회수 증가
	 * @param ntctxt_no
	 * @return
	 * @throws Exception
	 */
	public int addReadCnt(String ntctxt_no) throws Exception;
	
	/**
	 * 첨부파일 다운로드
	 * 
	 * @param 
	 * @return 
	 * @exception Exception
	 */
	public void downloadAttchdFile(HttpServletRequest request, HttpServletResponse response) throws Exception;
	
	/**
	 * 추천
	 * 
	 * @param 
	 * @return 
	 * @exception Exception
	 */
	public void addLike(HttpServletRequest request, HttpServletResponse response) throws Exception;
	
	/**	
	 * 키워드목록조회
	 * @param frontBoardVO
	 * @return
	 * @throws Exception
	 */
	public List<FrontMetaKeywordVO> selectKeywordList(Map<String, Object> keyMap) throws Exception;
	
	
}