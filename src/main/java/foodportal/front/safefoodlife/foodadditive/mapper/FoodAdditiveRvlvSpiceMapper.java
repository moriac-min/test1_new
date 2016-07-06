package foodportal.front.safefoodlife.foodadditive.mapper;

import java.util.List;
import java.util.Map;

import egovframework.rte.psl.dataaccess.mapper.Mapper;
import foodportal.front.safefoodlife.foodadditive.vo.FoodAdditiveRvlvSpiceVO;

/**
 * FoodAdditiveRvlvSpiceMapper
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

@Mapper("foodportal.front.safefoodlife.foodadditive.mapper.FoodAdditiveRvlvSpiceMapper")
public interface FoodAdditiveRvlvSpiceMapper {
	
	public List<FoodAdditiveRvlvSpiceVO> selectFoodAdditiveRvlvSpiceList(Map<String, Object> map);
	
	public FoodAdditiveRvlvSpiceVO selectFoodAdditiveRvlvSpiceDetail(Map<String, Object> map);
	
}