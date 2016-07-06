package foodportal.front.fooddanger.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import common.commonfacillity.log.CommonLog;
import egovframework.rte.fdl.cmmn.AbstractServiceImpl;
import foodportal.front.fooddanger.mapper.AdministMeasureMapper;
import foodportal.front.fooddanger.service.AdministMeasureService;
import foodportal.front.fooddanger.vo.AdministMeasureVO;

/**
 * AdministMeasureServiceImpl
 * @author 박재형
 * @since 2014.10.06
 * @version 1.0
 * @see
 * 
 * <pre>
 *  Modification Information
 *  수정일      수정자   수정내용
 *  ---------- -------- ---------------------------
 *  2014.10.06 박재형 최초 생성
 * </pre>
 * 
 * Copyright (C) 2014 by NDS., All right reserved.
 */

@Service("administMeasureServiceImpl")
public class AdministMeasureServiceImpl extends AbstractServiceImpl implements AdministMeasureService {

	@CommonLog Logger log;

	@Autowired
	AdministMeasureMapper administMeasureMapper;
	
	@Transactional(readOnly=true)
	public Map<String, Object> selectAdministMeasureList(Map<String, Object> map) throws Exception {
		
		Map<String, Object> resultMap = new HashMap<String, Object>();
		List<AdministMeasureVO> list = null;
				
		try{
			list = administMeasureMapper.selectAdministMeasureList(map);
			int total_cnt = administMeasureMapper.selectAdministMeasureTotalCnt(map);
			resultMap.put("list", list);
			resultMap.put("total_cnt", total_cnt);
			
			return resultMap;
			
		} catch(Exception e) {
			throw e;
		}
	}
	
	@Transactional(readOnly=true)
	public AdministMeasureVO selectAdministMeasureDetail(Map<String, Object> map) throws Exception {
		AdministMeasureVO administMeasureVO = null;
		
		try{
			administMeasureVO = administMeasureMapper.selectAdministMeasureDetail(map);
			return administMeasureVO;
			
		} catch(Exception e) {
			throw e;
		}
		
	}
	
	
}