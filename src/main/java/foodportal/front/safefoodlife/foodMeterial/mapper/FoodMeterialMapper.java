package foodportal.front.safefoodlife.foodMeterial.mapper;

import java.util.List;
import java.util.Map;

import egovframework.rte.psl.dataaccess.mapper.Mapper;
import foodportal.front.safefoodlife.foodMeterial.vo.FoodMeterialVO;

/**
 * FoodMeterialMapper
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

@Mapper("foodportal.front.safefoodlife.foodMeterial.mapper.FoodMeterialMapper")
public interface FoodMeterialMapper {
	
	public long selectFoodMeterialListCount(Map<String, Object> map);
	
	public long selectFoodMeterialSearchListCount(Map<String, Object> map);

	public List<FoodMeterialVO> selectFoodMeterialList(Map<String, Object> map);
	
	public List<FoodMeterialVO> selectFoodMeterialSearchList(Map<String, Object> map);
	
	public FoodMeterialVO selectFoodMeterialDetail(Map<String, Object> map);
	
}