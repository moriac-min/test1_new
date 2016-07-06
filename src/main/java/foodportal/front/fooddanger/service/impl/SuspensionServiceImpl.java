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
import foodportal.front.fooddanger.mapper.SuspensionMapper;
import foodportal.front.fooddanger.service.SuspensionService;
import foodportal.front.fooddanger.vo.FoodDangerFileVO;
import foodportal.front.fooddanger.vo.SuspensionVO;

/**
 * SuspensionServiceImpl
 * @author 최승희
 * @since 2014.10.08
 * @version 1.0
 * @see
 * 
 * <pre>
 *  Modification Information
 *  수정일     수정자   수정내용
 *  ---------- -------- ---------------------------
 *  2014.10.08 최승희 	최초 생성
 * </pre>
 * 
 * Copyright (C) 2014 by NDS., All right reserved.
 */
@Service("suspensionService")
public class SuspensionServiceImpl extends AbstractServiceImpl implements SuspensionService {

	@CommonLog Logger log;
	@Autowired SuspensionMapper suspensionMapper;
	
	@Transactional(readOnly=true)
	public Map<String, Object> selectSuspensionList(Map<String, Object> map) throws Exception {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		List<SuspensionVO> list = null;
				
		try{
			list = suspensionMapper.selectSuspensionList(map);
			int total_cnt = suspensionMapper.selectSuspensionTotalCnt(map);
			resultMap.put("list", list);
			resultMap.put("total_cnt", total_cnt);
			
			return resultMap;
			
		} catch(Exception e) {
			throw e;
		}
	}

	@Transactional(readOnly=true)
	public Map<String, Object> selectSuspensionDetail(Map<String, Object> map) throws Exception {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		SuspensionVO suspensionVO = null;
		List<FoodDangerFileVO> fileList = null;
		
		try{
			
			suspensionVO = suspensionMapper.selectSuspensionDetail(map);
			fileList = suspensionMapper.selectAttachFileList(map);
			
			resultMap.put("puffDetail", suspensionVO);
			resultMap.put("attachFileList", fileList);
			
			return resultMap;
			
		} catch(Exception e) {
			throw e;
		}
	}

}
