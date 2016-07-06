package foodportal.front.safefoodlife.food.mapper;

import java.util.List;
import java.util.Map;

import egovframework.rte.psl.dataaccess.mapper.Mapper;
import foodportal.front.safefoodlife.food.vo.FoodTypeChngVO;

/**
 * FoodTypeChngMapper
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

@Mapper("foodportal.front.safefoodlife.food.mapper.FoodTypeChngMapper")
public interface FoodTypeChngMapper {

	public List<FoodTypeChngVO> selectFoodTypeChngList(Map<String, Object> map);
	
}