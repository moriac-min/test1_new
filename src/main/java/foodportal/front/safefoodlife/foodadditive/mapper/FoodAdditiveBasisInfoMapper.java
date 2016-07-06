package foodportal.front.safefoodlife.foodadditive.mapper;

import java.util.List;
import java.util.Map;

import egovframework.rte.psl.dataaccess.mapper.Mapper;
import foodportal.front.safefoodlife.foodadditive.vo.FoodAdditiveBasisInfoVO;

/**
 * FoodAdditiveBasisInfoMapper
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

@Mapper("foodportal.front.safefoodlife.foodadditive.mapper.FoodAdditiveBasisInfoMapper")
public interface FoodAdditiveBasisInfoMapper {
	
	public List<FoodAdditiveBasisInfoVO> selectFoodAdditiveBasisInfoList(Map<String, Object> map);
	
	public FoodAdditiveBasisInfoVO selectFoodAdditiveTotalSerial(Map<String, Object> map);
	
	public FoodAdditiveBasisInfoVO selectFoodAdditiveBasisInfoDetail(Map<String, Object> map);
	
	public FoodAdditiveBasisInfoVO selectFoodAdditiveBasisInfoDetail2(Map<String, Object> map);
	
	public FoodAdditiveBasisInfoVO selectFoodAdditiveBasisInfoDetail3(Map<String, Object> map);
	
	public FoodAdditiveBasisInfoVO selectFoodAdditiveBasisInfoDetail4(Map<String, Object> map);
	
	public FoodAdditiveBasisInfoVO selectFoodAdditiveBasisInfoDetail5(Map<String, Object> map);
	
	public FoodAdditiveBasisInfoVO selectFoodAdditiveBasisInfoDetail6(Map<String, Object> map);
	
	public FoodAdditiveBasisInfoVO selectFoodAdditiveBasisInfoDetail7(Map<String, Object> map);
	
	public List<FoodAdditiveBasisInfoVO> selectFoodAdditiveBasisInfoReformHistoryList(Map<String, Object> map);
	
	public List<FoodAdditiveBasisInfoVO> selectFoodAdditiveBasisInfoCfrUseStandardList(Map<String, Object> map);
	
	public List<FoodAdditiveBasisInfoVO> selectFoodAdditiveBasisInfoCodexUseStandardList(Map<String, Object> map);
	
}