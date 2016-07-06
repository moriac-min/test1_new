package foodportal.admin.systemmngt.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.commonfacillity.uia.WqBaseBean;
import foodportal.admin.systemmngt.vo.AdminBoardVO;
import foodportal.admin.systemmngt.vo.BoardSettingVO;
import foodportal.admin.systemmngt.vo.NewsLetterVO;
import foodportal.admin.systemmngt.vo.UploadFileVO;

/**
 * NewsLetterService
 * @author 박재형
 * @since 2014.09.03
 * @version 1.0
 * @see
 * 
 * <pre>
 *  Modification Information
 *  수정일      수정자   수정내용
 *  ---------- -------- ---------------------------
 *  2014.09.16 박재형 최초 생성
 * </pre>
 * 
 * Copyright (C) 2014 by NDS., All right reserved.
 */

public interface NewsLetterService {

	/**
	 * 목록 조회 
	 * 
	 * @param 
	 * @return 
	 * @exception Exception
	 */
	public List<NewsLetterVO> selectNewsLetterList(WqBaseBean ibean) throws Exception;
	
	/**
	 * 상세(본문) 조회 
	 * 
	 * @param 
	 * @return 
	 * @exception Exception
	 */
	public NewsLetterVO selectNewsLetterDetail(WqBaseBean ibean) throws Exception;
	
	/**
	 * 상세 첨부파일 조회
	 * 
	 * @param 
	 * @return 
	 * @exception Exception
	 */
	public UploadFileVO selectNewsLetterFile(WqBaseBean ibean) throws Exception;
	
	/**
	 * 게시글 저장
	 * falg : insert, update, delete
	 * @param 
	 * @return 
	 * @exception Exception
	 */
	public int saveNewsLetter(WqBaseBean ibean, String flag) throws Exception;
	
	/**
	 * 첨부파일 다운로드
	 * 
	 * @param 
	 * @return 
	 * @exception Exception
	 */
	public void downloadAttchdFile(HttpServletRequest request, HttpServletResponse response) throws Exception;
}