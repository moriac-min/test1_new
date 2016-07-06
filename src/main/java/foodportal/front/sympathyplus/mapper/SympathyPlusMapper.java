package foodportal.front.sympathyplus.mapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import egovframework.rte.psl.dataaccess.mapper.Mapper;
import foodportal.front.common.vo.CategoryVo;
import foodportal.front.common.vo.FrontBoardVO;
import foodportal.front.common.vo.FrontMetaKeywordVO;
import foodportal.front.common.vo.UploadFileVO;
import foodportal.front.sympathyplus.vo.CalendarVo;
import foodportal.front.sympathyplus.vo.FoodStreetVO;

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
         
@Mapper("foodportal.front.sympathyplus.mapper.SympathyPlusMapper")
public interface SympathyPlusMapper {
	
	/**
	 * 일반카테고리목록
	 * @param frontBoardVO
	 * @return
	 */
	public List<CategoryVo> selectCtgType01List(FoodStreetVO paramVo);
	
	/**
	 * 지역별특화거리 상세
	 * @param paramMap
	 * @return
	 * @throws Exception
	 */
	public FrontBoardVO selectFoodStreetDetail(FrontBoardVO paramVo) throws Exception;

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
	 * 식품안전캘린더 달력조회
	 * @param paramMap
	 * @return
	 * @throws Exception
	 */
	public CalendarVo selectMonthInfo(CalendarVo paramVo) throws Exception;
	
	/**
	 * 식품안전캘린더 월별일정조회
	 * @param paramMap
	 * @return
	 * @throws Exception
	 */
	public List<CalendarVo> selectMonthSchList(CalendarVo paramVo) throws Exception;
	
	/**
	 * 식품안전캘린더 일정상세
	 * @param paramMap
	 * @return
	 * @throws Exception
	 */
	public CalendarVo selectMonthSchDetail(CalendarVo paramVo) throws Exception;
	
}
