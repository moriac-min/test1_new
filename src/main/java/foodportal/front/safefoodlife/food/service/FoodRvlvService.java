package foodportal.front.safefoodlife.food.service;

import java.util.List;

import foodportal.front.safefoodlife.food.vo.FoodRvlvVO;
import foodportal.front.safefoodlife.food.vo.FoodTypeChngQnaVO;
import foodportal.front.safefoodlife.food.vo.FoodTypeChngVO;

/**
 * FoodRvlvService
 * @author 임재록
 * @since 2014.09.30
 * @version 1.0
 * @see
 * 
 * <pre>
 *  Modification Information
 *  수정일      수정자   수정내용
 *  ---------- -------- ---------------------------
 *  2014.09.30 임재록 최초 생성
 * </pre>
 * 
 * Copyright (C) 2014 by NDS., All right reserved.
 */

public interface FoodRvlvService {
	
	/**
	 * 식품공전 목차 목록 조회
	 * 
	 * @param 
	 * @return 
	 * @exception Exception
	 */
	public List<FoodRvlvVO> selectFoodRvlvTopList(FoodRvlvVO foodRvlvVO) throws Exception;
	
	/**
	 * 식품공전 목록 조회
	 * 
	 * @param 
	 * @return 
	 * @exception Exception
	 */
	public List<FoodRvlvVO> selectFoodRvlvList(FoodRvlvVO foodRvlvVO) throws Exception;
	
	/**
	 * 식품공전 검색 목록 조회
	 * 
	 * @param 
	 * @return 
	 * @exception Exception
	 */
	public List<FoodRvlvVO> selectFoodRvlvSearchList(FoodRvlvVO foodRvlvVO) throws Exception;
	
	/**
	 * 식품공전 상세 조회
	 * 
	 * @param 
	 * @return 
	 * @exception Exception
	 */
	public FoodRvlvVO selectFoodRvlvDetail(FoodRvlvVO foodRvlvVO) throws Exception;
	
	/**
	 * 식품공전 경로 조회
	 * 
	 * @param 
	 * @return 
	 * @exception Exception
	 */
	public FoodRvlvVO selectFoodRvlvPath(FoodRvlvVO foodRvlvVO) throws Exception;

	/**
	 * 식품유형의 변경 목록 조회
	 * 
	 * @param 
	 * @return 
	 * @exception Exception
	 */
	public List<FoodTypeChngVO> selectFoodTypeChngList(FoodTypeChngVO foodTypeChngVO) throws Exception;
	
	/**
	 * 관련 Q&A 목록 조회
	 * 
	 * @param 
	 * @return 
	 * @exception Exception
	 */
	public List<FoodTypeChngQnaVO> selectFoodTypeChngQnaList(FoodTypeChngQnaVO foodTypeChngQnaVO) throws Exception;
	
}