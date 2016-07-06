package foodportal.front.sympathyplus.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import foodportal.front.common.vo.CategoryVo;
import foodportal.front.common.vo.FrontBoardVO;
import foodportal.front.common.vo.FrontMetaKeywordVO;
import foodportal.front.common.vo.UploadFileVO;
import foodportal.front.sympathyplus.vo.CalendarVo;
import foodportal.front.sympathyplus.vo.FoodStreetVO;


/**
 * FrontBoardService
 * @author 김석원
 * @since 2014.09.25
 * @version 1.0
 * @see
 * 
 * <pre>
 *  Modification Information
 *  수정일      수정자   수정내용
 *  ---------- -------- ---------------------------
 *  2014.09.03 김석원 최초 생성
 * </pre>
 * 
 * Copyright (C) 2014 by NDS., All right reserved.
 */

public interface SympathyPlusService {

	
	/**	
	 * 카테고리 목록 조회
	 * @param frontBoardVO
	 * @return
	 * @throws Exception
	 */
	public List<CategoryVo> selectCtgType01List(FoodStreetVO foodStreetVo) throws Exception;
	
	/**
	 * 지역별특화거리 상세조회
	 * @param ntctxt_no
	 * @return
	 * @throws Exception
	 */
	public FrontBoardVO selectFoodStreetDetail(FrontBoardVO paramVo) throws Exception;
	
	/**
	 * 글 조회수 증가
	 * @param ntctxt_no
	 * @return
	 * @throws Exception
	 */
	public int addReadCnt(String ntctxt_no) throws Exception;
	
	
	/**
	 * 달력조회
	 * @param ntctxt_no
	 * @return
	 * @throws Exception
	 */
	public CalendarVo selectMonthCalInfo(CalendarVo paramVo) throws Exception;
	
	/**
	 * 월별 일정 조회
	 * @param ntctxt_no
	 * @return
	 * @throws Exception
	 */
	public List<CalendarVo> selectMonthSchList(CalendarVo paramVo) throws Exception;
	
	/**
	 * 월별 일정 상세조회
	 * @param ntctxt_no
	 * @return
	 * @throws Exception
	 */
	public CalendarVo selectMonthSchDetail(CalendarVo paramVo) throws Exception;
	

}