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
import foodportal.front.fooddanger.mapper.CrackdownMapper;
import foodportal.front.fooddanger.service.CrackdownService;
import foodportal.front.fooddanger.vo.CrackdownVO;
import foodportal.front.fooddanger.vo.MarienCrackdownVO;

/**
 * CrackdownServiceImpl
 * @author 박재형
 * @since 2014.10.02
 * @version 1.0
 * @see
 * 
 * <pre>
 *  Modification Information
 *  수정일      수정자   수정내용
 *  ---------- -------- ---------------------------
 *  2014.10.02 박재형 최초 생성
 * </pre>
 * 
 * Copyright (C) 2014 by NDS., All right reserved.
 */

@Service("CrackdownServiceImpl")
public class CrackdownServiceImpl extends AbstractServiceImpl implements CrackdownService {

	@CommonLog Logger log;

	@Autowired
	CrackdownMapper crackdownMapper;
	
	@Transactional(readOnly=true)
	public Map<String, Object> selectAgriCrackdownList(Map<String, Object> map) throws Exception {
		
		Map<String, Object> resultMap = new HashMap<String, Object>();
		List<CrackdownVO> list = null;
				
		try{
			list = crackdownMapper.selectAgriCrackdownList(map);
			int total_cnt = crackdownMapper.selectAgriCrackdownTotalCnt(map);
			resultMap.put("list", list);
			resultMap.put("total_cnt", total_cnt);
			
			return resultMap;
			
		} catch(Exception e) {
			throw e;
		}
	}
	
	@Transactional(readOnly=true)
	public CrackdownVO selectAgriCrackdownDetail(Map<String, Object> map) throws Exception {
		CrackdownVO crackdownVO = null;
		
		try{
			crackdownVO = crackdownMapper.selectAgriCrackdownDetail(map);
			return crackdownVO;
			
		} catch(Exception e) {
			throw e;
		}
		
	}
	
	@Transactional(readOnly=true)
	public Map<String, Object> selectMarienCrackdownList(Map<String, Object> map) throws Exception {
		
		Map<String, Object> resultMap = new HashMap<String, Object>();
		List<MarienCrackdownVO> list = null;
				
		try{
			list = crackdownMapper.selectMarienCrackdownList(map);
			int total_cnt = crackdownMapper.selectMarienCrackdownTotalCnt(map);
			resultMap.put("list", list);
			resultMap.put("total_cnt", total_cnt);
			
			return resultMap;
			
		} catch(Exception e) {
			throw e;
		}
	}
	
	@Transactional(readOnly=true)
	public MarienCrackdownVO selectMarienCrackdownDetail(Map<String, Object> map) throws Exception {
		MarienCrackdownVO marienCrackdownVO = null;
		
		try{
			marienCrackdownVO = crackdownMapper.selectMarienCrackdownDetail(map);
			return marienCrackdownVO;
			
		} catch(Exception e) {
			throw e;
		}
		
	}
	
}