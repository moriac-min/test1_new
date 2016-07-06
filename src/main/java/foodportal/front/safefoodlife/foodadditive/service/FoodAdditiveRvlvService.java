package foodportal.front.safefoodlife.foodadditive.service;

import foodportal.front.safefoodlife.foodadditive.vo.FoodAdditiveRvlvVO;

/**
 * FoodAdditiveRvlvMainService
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

public interface FoodAdditiveRvlvService {
	
	/**
	 * 식품첨가물공전 상세 조회
	 * 
	 * @param 
	 * @return 
	 * @exception Exception
	 */
	public FoodAdditiveRvlvVO selectFoodAdditiveRvlvDetail(FoodAdditiveRvlvVO foodAdditiveRvlvVO) throws Exception;
	
}