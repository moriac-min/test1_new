package foodportal.admin.systemmngt.mapper;

import java.util.List;
import java.util.Map;

import egovframework.rte.psl.dataaccess.mapper.Mapper;
import foodportal.admin.systemmngt.vo.NewsLetterVO;
import foodportal.admin.systemmngt.vo.UploadFileVO;

/**
 * NewsLetterMapper
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

@Mapper("foodportal.admin.systemmngt.mapper.NewsLetterMapper")
public interface NewsLetterMapper {
	
	/**
	 * 게시글 목록 조회 
	 * 
	 * @param 
	 * @return 
	 * @exception Exception
	 */
	public List<NewsLetterVO> selectNewsLetterList(Map<String, Object> map);
	
	/**
	 * 게시글 상세(본문) 조회 
	 * 
	 * @param 
	 * @return 
	 * @exception Exception
	 */
	public NewsLetterVO selectNewsLetterDetail(Map<String, Object> map);
	
	/**
	 * 게시글 상세(첨부파일) 조회 
	 * 
	 * @param 
	 * @return 
	 * @exception Exception
	 */
	public UploadFileVO selectNewsLetterFile(Map<String, Object> map);
	
	/**
	 * 게시글번호 생성 
	 * 
	 * @param 
	 * @return 
	 * @exception Exception
	 */
	public String selectNewsLetterSeqNo();
	
	/**
	 * 게시글마스터 등록 
	 * 
	 * @param 
	 * @return 
	 * @exception Exception
	 */
	public int insertNewsLetterMst(Map<String, Object> map);	
	
	/**
	 * 게시글 본문 등록 
	 * 
	 * @param 
	 * @return 
	 * @exception Exception
	 */
	public int insertNewsLetterContent(Map<String, Object> map);		
	
	/**
	 * 게시글마스터 수정 
	 * 
	 * @param 
	 * @return 
	 * @exception Exception
	 */
	public int updateNewsLetterMst(Map<String, Object> map);
	
	/**
	 * 게시글 본문 수정 
	 * 
	 * @param 
	 * @return 
	 * @exception Exception
	 */
	public int updateNewsLetterContent(Map<String, Object> map);
	
	/**
	 * 게시글 삭제
	 * 
	 * @param 
	 * @return 
	 * @exception Exception
	 */
	public int deleteNewsLetter(Map<String, Object> map);
	
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
	
}
