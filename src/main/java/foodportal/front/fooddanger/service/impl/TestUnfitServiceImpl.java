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
import foodportal.front.fooddanger.mapper.TestUnfitMapper;
import foodportal.front.fooddanger.service.TestUnfitService;
import foodportal.front.fooddanger.vo.FoodDangerFileVO;
import foodportal.front.fooddanger.vo.TestUnfitVO;

/**
 * TestUnfitServiceImpl
 * @author 최승희
 * @since 2014.10.02
 * @version 1.0
 * @see
 * 
 * <pre>
 *  Modification Information
 *  수정일     수정자   수정내용
 *  ---------- -------- ---------------------------
 *  2014.10.02 최승희 	최초 생성
 * </pre>
 * 
 * Copyright (C) 2014 by NDS., All right reserved.
 */
@Service("testUnfitService")
public class TestUnfitServiceImpl extends AbstractServiceImpl implements TestUnfitService {

	@CommonLog Logger log;
	@Autowired TestUnfitMapper testUnfitMapper;
	
	@Transactional(readOnly=true)
	public Map<String, Object> selectTestUnfitList(Map<String, Object> map) throws Exception {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		List<TestUnfitVO> list = null;
				
		try{
			list = testUnfitMapper.selectTestUnfitList(map);
			int total_cnt = testUnfitMapper.selectTestUnfitTotalCnt(map);
			resultMap.put("list", list);
			resultMap.put("total_cnt", total_cnt);
			
			return resultMap;
			
		} catch(Exception e) {
			throw e;
		}
	}

	@Transactional(readOnly=true)
	public Map<String, Object> selectTestUnfitDetail(Map<String, Object> map) throws Exception {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		TestUnfitVO testUnfitVO = null;
		List<FoodDangerFileVO> fileList = null;
		
		try{
			
			testUnfitVO = testUnfitMapper.selectTestUnfitDetail(map);
			fileList = testUnfitMapper.selectAttachFileList(map);
			
			resultMap.put("testUnfitDetail", testUnfitVO);
			resultMap.put("attachFileList", fileList);
			
			return resultMap;
			
		} catch(Exception e) {
			throw e;
		}
	}

	@Transactional(readOnly=true)
	public Map<String, Object> selectTestUnfitAbrdList(Map<String, Object> map) throws Exception {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		List<TestUnfitVO> list = null;
				
		try{
			list = testUnfitMapper.selectTestUnfitAbrdList(map);
			int total_cnt = testUnfitMapper.selectTestUnfitAbrdTotalCnt(map);
			resultMap.put("list", list);
			resultMap.put("total_cnt", total_cnt);
			
			return resultMap;
			
		} catch(Exception e) {
			throw e;
		}
	}
	
	

}
