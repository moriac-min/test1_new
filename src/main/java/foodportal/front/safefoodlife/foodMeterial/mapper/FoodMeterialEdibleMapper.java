package foodportal.front.safefoodlife.foodMeterial.mapper;

import java.util.List;
import java.util.Map;

import egovframework.rte.psl.dataaccess.mapper.Mapper;
import foodportal.front.safefoodlife.foodMeterial.vo.FoodMeterialEdibleVO;

/**
 * FoodMeterialEdibleMapper
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

@Mapper("foodportal.front.safefoodlife.foodMeterial.mapper.FoodMeterialEdibleMapper")
public interface FoodMeterialEdibleMapper {
	
	public List<FoodMeterialEdibleVO> selectFoodMeterialEdibleList(Map<String, Object> map);
	
}