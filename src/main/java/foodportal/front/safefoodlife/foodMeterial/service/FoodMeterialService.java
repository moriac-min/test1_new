package foodportal.front.safefoodlife.foodMeterial.service;

import java.util.List;

import foodportal.front.safefoodlife.foodMeterial.vo.FoodMeterialVO;

/**
 * FoodMeterialService
 * @author 임재록
 * @since 2014.10.02
 * @version 1.0
 * @see
 * 
 * <pre>
 *  Modification Information
 *  수정일      수정자   수정내용
 *  ---------- -------- ---------------------------
 *  2014.10.02 임재록 최초 생성
 * </pre>
 * 
 * Copyright (C) 2014 by NDS., All right reserved.
 */

public interface FoodMeterialService {
	
	/**
	 * 식품원료 목록 개수 조회
	 * 
	 * @param 
	 * @return 
	 * @exception Exception
	 */
	public long selectFoodMeterialListCount(FoodMeterialVO foodMeterialVO) throws Exception;
	
	/**
	 * 식품원료 상세 목록 개수 조회
	 * 
	 * @param 
	 * @return 
	 * @exception Exception
	 */
	public long selectFoodMeterialSearchListCount(FoodMeterialVO foodMeterialVO) throws Exception;
	
	/**
	 * 식품원료 목록 조회
	 * 
	 * @param 
	 * @return 
	 * @exception Exception
	 */
	public List<FoodMeterialVO> selectFoodMeterialList(FoodMeterialVO foodMeterialVO) throws Exception;
	
	/**
	 * 식품원료 상세 목록 조회
	 * 
	 * @param 
	 * @return 
	 * @exception Exception
	 */
	public List<FoodMeterialVO> selectFoodMeterialSearchList(FoodMeterialVO foodMeterialVO) throws Exception;
	
	/**
	 * 식품원료 상세 조회
	 * 
	 * @param 
	 * @return 
	 * @exception Exception
	 */
	public FoodMeterialVO selectFoodMeterialDetail(FoodMeterialVO foodMeterialVO) throws Exception;
	
}