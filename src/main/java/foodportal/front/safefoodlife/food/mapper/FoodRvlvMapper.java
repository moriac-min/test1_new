package foodportal.front.safefoodlife.food.mapper;

import java.util.List;
import java.util.Map;

import egovframework.rte.psl.dataaccess.mapper.Mapper;
import foodportal.front.safefoodlife.food.vo.FoodRvlvVO;

/**
 * FoodRvlvMapper
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

@Mapper("foodportal.front.safefoodlife.food.mapper.FoodRvlvMapper")
public interface FoodRvlvMapper {

	public List<FoodRvlvVO> selectFoodRvlvTopList(Map<String, Object> map);
	
	public List<FoodRvlvVO> selectFoodRvlvList(Map<String, Object> map);
	
	public List<FoodRvlvVO> selectFoodRvlvSearchList(Map<String, Object> map);
	
	public FoodRvlvVO selectFoodRvlvDetail(Map<String, Object> map);
	
	public FoodRvlvVO selectFoodRvlvPath(Map<String, Object> map);
	
}