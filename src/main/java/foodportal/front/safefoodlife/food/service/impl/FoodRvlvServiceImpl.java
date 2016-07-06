package foodportal.front.safefoodlife.food.service.impl;

import java.util.HashMap;
import java.util.List;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import common.commonfacillity.log.CommonLog;
import common.commonfacillity.util.CommonConvertObjectToMap;
import egovframework.rte.fdl.cmmn.AbstractServiceImpl;
import foodportal.front.safefoodlife.food.mapper.FoodRvlvMapper;
import foodportal.front.safefoodlife.food.mapper.FoodTypeChngMapper;
import foodportal.front.safefoodlife.food.mapper.FoodTypeChngQnaMapper;
import foodportal.front.safefoodlife.food.service.FoodRvlvService;
import foodportal.front.safefoodlife.food.vo.FoodRvlvVO;
import foodportal.front.safefoodlife.food.vo.FoodTypeChngQnaVO;
import foodportal.front.safefoodlife.food.vo.FoodTypeChngVO;

/**
 * FoodRvlvServiceImpl
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

@Service("foodRvlvService")
public class FoodRvlvServiceImpl extends AbstractServiceImpl implements FoodRvlvService {

	@CommonLog Logger log;
	
	@Autowired
	FoodRvlvMapper foodRvlvMapper;

	@Autowired
	FoodTypeChngMapper foodTypeChngMapper;
	
	@Autowired
	FoodTypeChngQnaMapper foodTypeChngQnaMapper;
	
	@Transactional(readOnly=true)
	public List<FoodRvlvVO> selectFoodRvlvTopList(FoodRvlvVO foodRvlvVO) throws Exception {
		HashMap<String, Object> map = new HashMap<String, Object>();
		
		try{
			map = CommonConvertObjectToMap.ConverObjectToMap(foodRvlvVO);
			
			List<FoodRvlvVO> list = foodRvlvMapper.selectFoodRvlvTopList(map);
			
			return list;
			
		} catch(Exception e) {
			throw e;
		}
	}
	
	@Transactional(readOnly=true)
	public List<FoodRvlvVO> selectFoodRvlvList(FoodRvlvVO foodRvlvVO) throws Exception {
		HashMap<String, Object> map = new HashMap<String, Object>();
		
		try{
			map = CommonConvertObjectToMap.ConverObjectToMap(foodRvlvVO);
			
			List<FoodRvlvVO> list = foodRvlvMapper.selectFoodRvlvList(map);
			
			return list;
			
		} catch(Exception e) {
			throw e;
		}
	}
	
	@Transactional(readOnly=true)
	public List<FoodRvlvVO> selectFoodRvlvSearchList(FoodRvlvVO foodRvlvVO) throws Exception {
		HashMap<String, Object> map = new HashMap<String, Object>();
		
		try{
			map = CommonConvertObjectToMap.ConverObjectToMap(foodRvlvVO);
			
			List<FoodRvlvVO> list = foodRvlvMapper.selectFoodRvlvSearchList(map);
			
			return list;
			
		} catch(Exception e) {
			throw e;
		}
	}
	
	@Transactional(readOnly=true)
	public FoodRvlvVO selectFoodRvlvDetail(FoodRvlvVO foodRvlvVO) throws Exception {
		HashMap<String, Object> map = new HashMap<String, Object>();
		
		try{
			map = CommonConvertObjectToMap.ConverObjectToMap(foodRvlvVO);
			
			FoodRvlvVO foodRvlvDetail = foodRvlvMapper.selectFoodRvlvDetail(map);
			
			return foodRvlvDetail;
			
		} catch(Exception e) {
			throw e;
		}
	}
	
	@Transactional(readOnly=true)
	public FoodRvlvVO selectFoodRvlvPath(FoodRvlvVO foodRvlvVO) throws Exception {
		HashMap<String, Object> map = new HashMap<String, Object>();
		
		try{
			map = CommonConvertObjectToMap.ConverObjectToMap(foodRvlvVO);
			
			FoodRvlvVO foodRvlvPath = foodRvlvMapper.selectFoodRvlvPath(map);
			
			return foodRvlvPath;
			
		} catch(Exception e) {
			throw e;
		}
	}
	
	@Transactional(readOnly=true)
	public List<FoodTypeChngVO> selectFoodTypeChngList(FoodTypeChngVO foodTypeChngVO) throws Exception {
		HashMap<String, Object> map = new HashMap<String, Object>();
		
		try{
			map = CommonConvertObjectToMap.ConverObjectToMap(foodTypeChngVO);
			
			List<FoodTypeChngVO> list = foodTypeChngMapper.selectFoodTypeChngList(map);
			
			return list;
			
		} catch(Exception e) {
			throw e;
		}
	}
	
	@Transactional(readOnly=true)
	public List<FoodTypeChngQnaVO> selectFoodTypeChngQnaList(FoodTypeChngQnaVO foodTypeChngQnaVO) throws Exception {
		HashMap<String, Object> map = new HashMap<String, Object>();
		
		try{
			map = CommonConvertObjectToMap.ConverObjectToMap(foodTypeChngQnaVO);
			
			List<FoodTypeChngQnaVO> list = foodTypeChngQnaMapper.selectFoodTypeChngQnaList(map);
			
			return list;
			
		} catch(Exception e) {
			throw e;
		}
	}
	
}