package foodportal.front.safefoodlife.foodadditive.service.impl;

import java.util.HashMap;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import common.commonfacillity.log.CommonLog;
import common.commonfacillity.util.CommonConvertObjectToMap;

import egovframework.rte.fdl.cmmn.AbstractServiceImpl;
import foodportal.front.safefoodlife.foodadditive.mapper.FoodAdditiveRvlvMapper;
import foodportal.front.safefoodlife.foodadditive.service.FoodAdditiveRvlvService;
import foodportal.front.safefoodlife.foodadditive.vo.FoodAdditiveRvlvVO;

/**
 * FoodAdditiveRvlvServiceImpl
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

@Service("foodAdditiveRvlvService")
public class FoodAdditiveRvlvServiceImpl extends AbstractServiceImpl implements FoodAdditiveRvlvService {

	@CommonLog Logger log;
	
	@Autowired
	FoodAdditiveRvlvMapper foodAdditiveRvlvMapper;
	
	@Transactional(readOnly=true)
	public FoodAdditiveRvlvVO selectFoodAdditiveRvlvDetail(FoodAdditiveRvlvVO foodAdditiveRvlvVO) throws Exception {
		HashMap<String, Object> map = new HashMap<String, Object>();
		
		try{
			map = CommonConvertObjectToMap.ConverObjectToMap(foodAdditiveRvlvVO);
			
			FoodAdditiveRvlvVO detail = foodAdditiveRvlvMapper.selectFoodAdditiveRvlvDetail(map);
			
			return detail;
			
		} catch(Exception e) {
			throw e;
		}
	}
	
}