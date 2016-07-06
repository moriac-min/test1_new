package common.adminfacillity.commonmngt.service;

import java.util.List;
import java.util.Map;

import common.adminfacillity.commonmngt.service.BoardVO;

/**
 * ComcmService
 * @author 유승엽
 * @since 2014.07.08
 * @version 1.0
 * @see
 *
 * <pre>
 *  Modification Information
 *  수정일      수정자   수정내용
 *  ---------- -------- ---------------------------
 *  2014.07.08 유승엽   최초 생성
 * </pre>
 *
 * Copyright (C) 2014 by NDS., All right reserved.
 */

public interface BoardService {
	
	/**
	 * 게시판 리스트 조회
	 * 
	 * @param BoardVO
	 * @return List<Map<String, Object>>
	 * @exception Exception	 
	 */
	public List<Map<String, Object>> selectBoard(BoardVO vo) throws Exception;
	
	/**
	 * 게시판 글 상세 보기
	 * 
	 * @param BoardVO
	 * @return List<Map<String, Object>>
	 * @exception Exception	 
	 */
	public List<Map<String, Object>> boardView(BoardVO vo) throws Exception;

	/**
	 * 게시판 글 작성
	 * 
	 * @param BoardVO
	 * @return List<Map<String, Object>>
	 * @exception Exception	 
	 */
	public void insertBoard(BoardVO vo) throws Exception;
	
	/**
	 * 게시판 글 수정
	 * 
	 * @param BoardVO
	 * @return List<Map<String, Object>>
	 * @exception Exception	 
	 */
	public void updateBoard(BoardVO vo) throws Exception;
	
	/**
	 * 게시판 글 삭제
	 * 
	 * @param BoardVO
	 * @return List<Map<String, Object>>
	 * @exception Exception	 
	 */
	public void deleteBoard(BoardVO vo) throws Exception;
}

	
	

