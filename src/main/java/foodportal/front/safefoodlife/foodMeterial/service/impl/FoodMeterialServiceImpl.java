package foodportal.front.safefoodlife.foodMeterial.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import common.commonfacillity.log.CommonLog;
import common.commonfacillity.util.CommonConvertObjectToMap;

import egovframework.rte.fdl.cmmn.AbstractServiceImpl;
import foodportal.front.safefoodlife.foodMeterial.mapper.FoodMeterialEdibleMapper;
import foodportal.front.safefoodlife.foodMeterial.mapper.FoodMeterialMapper;
import foodportal.front.safefoodlife.foodMeterial.service.FoodMeterialService;
import foodportal.front.safefoodlife.foodMeterial.vo.FoodMeterialEdibleVO;
import foodportal.front.safefoodlife.foodMeterial.vo.FoodMeterialVO;

/**
 * FoodMeterialServiceImpl
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

@Service("foodMeterialService")
public class FoodMeterialServiceImpl extends AbstractServiceImpl implements FoodMeterialService {

	@CommonLog Logger log;
	
	@Autowired
	FoodMeterialMapper foodMeterialMapper;
	
	@Autowired
	FoodMeterialEdibleMapper foodMeterialEdibleMapper;

	@Transactional(readOnly=true)
	public long selectFoodMeterialListCount(FoodMeterialVO foodMeterialVO) throws Exception {
		HashMap<String, Object> map = new HashMap<String, Object>();
		
		try{
			map = CommonConvertObjectToMap.ConverObjectToMap(foodMeterialVO);
			
			long listCount = foodMeterialMapper.selectFoodMeterialListCount(map);
			
			return listCount;
			
		} catch(Exception e) {
			throw e;
		}
	}
	
	@Transactional(readOnly=true)
	public long selectFoodMeterialSearchListCount(FoodMeterialVO foodMeterialVO) throws Exception {
		HashMap<String, Object> map = new HashMap<String, Object>();
		
		try{
			map = CommonConvertObjectToMap.ConverObjectToMap(foodMeterialVO);
			
			long listCount = foodMeterialMapper.selectFoodMeterialSearchListCount(map);
			
			return listCount;
			
		} catch(Exception e) {
			throw e;
		}
	}
	
	@Transactional(readOnly=true)
	public List<FoodMeterialVO> selectFoodMeterialList(FoodMeterialVO foodMeterialVO) throws Exception {
		HashMap<String, Object> map = new HashMap<String, Object>();
		
		try{
			map = CommonConvertObjectToMap.ConverObjectToMap(foodMeterialVO);
			
			List<FoodMeterialVO> list = foodMeterialMapper.selectFoodMeterialList(map);
			
			list = _addEdibleList(list);
			
			return list;
			
		} catch(Exception e) {
			throw e;
		}
	}
	
	@Transactional(readOnly=true)
	public List<FoodMeterialVO> selectFoodMeterialSearchList(FoodMeterialVO foodMeterialVO) throws Exception {
		HashMap<String, Object> map = new HashMap<String, Object>();
		
		try{
			map = CommonConvertObjectToMap.ConverObjectToMap(foodMeterialVO);
			
			List<FoodMeterialVO> list = foodMeterialMapper.selectFoodMeterialSearchList(map);
			
			list = _addEdibleList(list);
			
			return list;
			
		} catch(Exception e) {
			throw e;
		}
	}
	
	@Transactional(readOnly=true)
	public FoodMeterialVO selectFoodMeterialDetail(FoodMeterialVO foodMeterialVO) throws Exception {
		HashMap<String, Object> map = new HashMap<String, Object>();
		
		try{
			map = CommonConvertObjectToMap.ConverObjectToMap(foodMeterialVO);
			
			FoodMeterialVO detailVO = foodMeterialMapper.selectFoodMeterialDetail(map);
			
			detailVO = _addEdibleList(detailVO);
			
			return detailVO;
			
		} catch(Exception e) {
			throw e;
		}
	}
	
	/**
	 * 식품원료 목록에 식용 가능 여부에 대한 정보를 추가
	 * @param foodMeterialList
	 * @return
	 */
	private List<FoodMeterialVO> _addEdibleList(List<FoodMeterialVO> foodMeterialList) {
		for (FoodMeterialVO foodMeterial : foodMeterialList) {
			foodMeterial = _addEdibleList(foodMeterial);
		}
		
		return foodMeterialList;
	}
	
	/**
	 * 식용 가능 여부에 대한 정보를 추가
	 * @param foodMeterialVO
	 * @return
	 */
	private FoodMeterialVO _addEdibleList(FoodMeterialVO foodMeterialVO) {
		// 식용 가능, 제한적, 불가능 리스트 초기화
		//foodMeterialVO.setPossibleList(new ArrayList<FoodMeterialEdibleVO>());
		//foodMeterialVO.setImpossibleList(new ArrayList<FoodMeterialEdibleVO>());
		//foodMeterialVO.setLimitList(new ArrayList<FoodMeterialEdibleVO>());
		
		int indx = foodMeterialVO.getIndx();
		Map<String, Object> edibleMap = new HashMap<String, Object>();
		edibleMap.put("indx", indx);
		
		List<FoodMeterialEdibleVO> edibleList = foodMeterialEdibleMapper.selectFoodMeterialEdibleList(edibleMap);
		
		for (FoodMeterialEdibleVO foodMeterialEdible : edibleList) {
			try {
				if(!StringUtils.equals(foodMeterialEdible.getRegn_cd(), "199999999") 
						&& !StringUtils.equals(foodMeterialEdible.getRegn_cd(), "299999999") 
						&& !StringUtils.equals(foodMeterialEdible.getRegn_cd(), "399999999")) {
					if (StringUtils.equals(foodMeterialEdible.getEdible(), "가능")) {
						//foodMeterialVO.getPossibleList().add(foodMeterialEdible);
						foodMeterialVO.addToPossibleList(foodMeterialEdible);
					}
					else if (StringUtils.equals(foodMeterialEdible.getEdible(), "불가능")) {
						//foodMeterialVO.getImpossibleList().add(foodMeterialEdible);
						foodMeterialVO.addToImpossibleList(foodMeterialEdible);
					}
					else if (StringUtils.equals(foodMeterialEdible.getEdible(), "제한적")) {
						//foodMeterialVO.getLimitList().add(foodMeterialEdible);
						foodMeterialVO.addToLimitList(foodMeterialEdible);
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return foodMeterialVO;
	}
	
}