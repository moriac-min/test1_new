package foodportal.front.common.mapper;

import java.util.List;
import java.util.Map;

import egovframework.rte.psl.dataaccess.mapper.Mapper;
import foodportal.front.common.vo.CategoryVo;
import foodportal.front.common.vo.FrontBoardVO;
import foodportal.front.common.vo.FrontMetaKeywordVO;
import foodportal.front.common.vo.UploadFileVO;

/**
 * FrontBoardMapper
 * @author 박재형
 * @since 2014.09.25
 * @version 1.0
 * @see
 * 
 * <pre>
 *  Modification Information
 *  수정일      수정자   수정내용
 *  ---------- -------- ---------------------------
 *  2014.09.25 박재형 최초 생성
 * </pre>
 * 
 * Copyright (C) 2014 by NDS., All right reserved.
 */
         
@Mapper("foodportal.front.common.mapper.FrontBoardMapper")
public interface FrontBoardMapper {
	
	/**
	 * 게시판 설정정보
	 * @param map
	 * @return
	 */
	public FrontBoardVO getBbsSettingInfo(Map<String, Object> map);
	
	/**
	 * 게시글목록
	 * @param frontBoardVO
	 * @return
	 */
	public List<FrontBoardVO> selectBoardList(FrontBoardVO frontBoardVO);
	
	/**
	 * 총 게시글수
	 * @param frontBoardVO
	 * @return
	 */
	public String selectTotalCnt(FrontBoardVO frontBoardVO);
	
	/**
	 * 일반카테고리목록
	 * @param frontBoardVO
	 * @return
	 */
	public List<CategoryVo> selectCtgType01List(FrontBoardVO frontBoardVO);
	
	/**
	 * 계층카테고리목록
	 * @param ctgry_no
	 * @return
	 */
	public List<CategoryVo> selectCtgType02List(String ctgry_no);
	
	/**
	 * 게시글 상세
	 * @param map
	 * @return
	 */
	public FrontBoardVO selectBoardDetail(Map<String, Object> map);
	
	/**
	 * 이전글번호
	 * @param map
	 * @return
	 */
	public String selectPreNtctxtNo(Map<String, Object> map);
	
	/**
	 * 다음글번호
	 * @param map
	 * @return
	 */
	public String selectPostNtctxtNo(Map<String, Object> map);
	
	
	/**
	 * 첨부파일
	 * @param map
	 * @return
	 */
	public List<UploadFileVO> selectBoardFile(Map<String, Object> map);
	
	/**
	 * 조회수증가
	 * @param ntctxt_no
	 * @return
	 * @throws Exception
	 */
	public int addReadCnt(String ntctxt_no) throws Exception;
	
	/**
	 * 추천 중복 체크
	 * @param paramMap
	 * @return
	 * @throws Exception
	 */
	public int checkDup(Map<String, Object> paramMap) throws Exception;
	
	/**
	 * 추천 증가
	 * @param paramMap
	 * @return
	 * @throws Exception
	 */
	public int addLike(Map<String, Object> paramMap) throws Exception;
	
	/**
	 * 키워드목록
	 * @param keyMap
	 * @return
	 */
	public List<FrontMetaKeywordVO> selectKeywordList(Map<String, Object> keyMap);
}
