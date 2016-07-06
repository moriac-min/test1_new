package foodportal.front.safefoodlife.foodadditive.service.impl;

import java.util.HashMap;
import java.util.List;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import common.commonfacillity.log.CommonLog;
import common.commonfacillity.util.CommonConvertObjectToMap;

import egovframework.rte.fdl.cmmn.AbstractServiceImpl;
import foodportal.front.safefoodlife.foodadditive.mapper.FoodAdditiveRvlvSpiceMapper;
import foodportal.front.safefoodlife.foodadditive.service.FoodAdditiveRvlvSpiceService;
import foodportal.front.safefoodlife.foodadditive.vo.FoodAdditiveRvlvSpiceVO;

/**
 * FoodAdditiveRvlvSpiceServiceImpl
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

@Service("foodAdditiveRvlvSpiceService")
public class FoodAdditiveRvlvSpiceServiceImpl extends AbstractServiceImpl implements FoodAdditiveRvlvSpiceService {

	@CommonLog Logger log;
	
	@Autowired
	FoodAdditiveRvlvSpiceMapper foodAdditiveRvlvSpiceMapper;
	
	@Transactional(readOnly=true)
	public List<FoodAdditiveRvlvSpiceVO> selectFoodAdditiveRvlvSpiceList(FoodAdditiveRvlvSpiceVO foodAdditiveRvlvSpiceVO) throws Exception {
		HashMap<String, Object> map = new HashMap<String, Object>();
		
		try{
			map = CommonConvertObjectToMap.ConverObjectToMap(foodAdditiveRvlvSpiceVO);
			
			// 검색타입, 검색어 설정
			map.put(foodAdditiveRvlvSpiceVO.getKeyfield(), foodAdditiveRvlvSpiceVO.getKey());
			
			List<FoodAdditiveRvlvSpiceVO> list = foodAdditiveRvlvSpiceMapper.selectFoodAdditiveRvlvSpiceList(map);
			
			return list;
			
		} catch(Exception e) {
			throw e;
		}
	}
	
	@Transactional(readOnly=true)
	public FoodAdditiveRvlvSpiceVO selectFoodAdditiveRvlvSpiceDetail(FoodAdditiveRvlvSpiceVO foodAdditiveRvlvSpiceVO) throws Exception {
		HashMap<String, Object> map = new HashMap<String, Object>();
		
		try{
			map = CommonConvertObjectToMap.ConverObjectToMap(foodAdditiveRvlvSpiceVO);
			
			FoodAdditiveRvlvSpiceVO detail = foodAdditiveRvlvSpiceMapper.selectFoodAdditiveRvlvSpiceDetail(map);
			
			return detail;
			
		} catch(Exception e) {
			throw e;
		}
	}
}