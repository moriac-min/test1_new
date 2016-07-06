package foodportal.front.safefoodlife.foodadditive.service;

import java.util.List;

import foodportal.front.safefoodlife.foodadditive.vo.FoodAdditiveRvlvSpiceVO;

/**
 * FoodAdditiveRvlvSpiceService
 * @author 임재록
 * @since 2014.10.08
 * @version 1.0
 * @see
 * 
 * <pre>
 *  Modification Information
 *  수정일      수정자   수정내용
 *  ---------- -------- ---------------------------
 *  2014.10.08 임재록 최초 생성
 * </pre>
 * 
 * Copyright (C) 2014 by NDS., All right reserved.
 */

public interface FoodAdditiveRvlvSpiceService {
	
	/**
	 * 착향료 목록 조회
	 * 
	 * @param 
	 * @return 
	 * @exception Exception
	 */
	public List<FoodAdditiveRvlvSpiceVO> selectFoodAdditiveRvlvSpiceList(FoodAdditiveRvlvSpiceVO foodAdditiveRvlvSpiceVO) throws Exception;
	
	/**
	 * 착향료 상세 조회
	 * 
	 * @param 
	 * @return 
	 * @exception Exception
	 */
	public FoodAdditiveRvlvSpiceVO selectFoodAdditiveRvlvSpiceDetail(FoodAdditiveRvlvSpiceVO foodAdditiveRvlvSpiceVO) throws Exception;
	
}