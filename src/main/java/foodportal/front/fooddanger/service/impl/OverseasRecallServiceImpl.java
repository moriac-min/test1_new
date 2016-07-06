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
import foodportal.front.fooddanger.mapper.OverseasRecallMapper;
import foodportal.front.fooddanger.service.OverseasRecallService;
import foodportal.front.fooddanger.vo.FoodDangerFileVO;
import foodportal.front.fooddanger.vo.OverseasRecallVO;

/**
 * OverseasRecallServiceImpl
 * @author 최승희
 * @since 2014.10.01
 * @version 1.0
 * @see
 * 
 * <pre>
 *  Modification Information
 *  수정일     수정자   수정내용
 *  ---------- -------- ---------------------------
 *  2014.10.01 최승희 	최초 생성
 * </pre>
 * 
 * Copyright (C) 2014 by NDS., All right reserved.
 */
@Service("overseasRecallService")
public class OverseasRecallServiceImpl extends AbstractServiceImpl implements OverseasRecallService {

	@CommonLog Logger log;
	@Autowired OverseasRecallMapper overseasRecallMapper;
	
	@Transactional(readOnly=true)
	public Map<String, Object> selectOverseasRecallList(Map<String, Object> map) throws Exception {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		List<OverseasRecallVO> list = null;
				
		try{
			list = overseasRecallMapper.selectOverseasRecallList(map);
			int total_cnt = overseasRecallMapper.selectOverseasRecallTotalCnt(map);
			resultMap.put("list", list);
			resultMap.put("total_cnt", total_cnt);
			
			return resultMap;
			
		} catch(Exception e) {
			throw e;
		}
	}

	@Transactional(readOnly=true)
	public Map<String, Object> selectOverseasRecallDetail(Map<String, Object> map) throws Exception {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		OverseasRecallVO overseasRecallVO = null;
		List<FoodDangerFileVO> fileList = null;
		List<OverseasRecallVO> list = null;
		
		try{
			map.put("start_idx", "1");
			map.put("show_cnt", "5");
			overseasRecallVO = overseasRecallMapper.selectOverseasRecallDetail(map);
			list = overseasRecallMapper.selectOverseasRecallList(map);
			
			resultMap.put("overseasRecallDetail", overseasRecallVO);
			resultMap.put("overseasRecallList", list);
			
			return resultMap;
			
		} catch(Exception e) {
			throw e;
		}
	}
	
	

}
