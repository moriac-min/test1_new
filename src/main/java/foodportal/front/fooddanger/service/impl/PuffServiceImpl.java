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
import foodportal.front.fooddanger.mapper.PuffMapper;
import foodportal.front.fooddanger.service.PuffService;
import foodportal.front.fooddanger.vo.FoodDangerFileVO;
import foodportal.front.fooddanger.vo.PuffVO;

/**
 * PuffServiceImpl
 * @author 최승희
 * @since 2014.10.06
 * @version 1.0
 * @see
 * 
 * <pre>
 *  Modification Information
 *  수정일     수정자   수정내용
 *  ---------- -------- ---------------------------
 *  2014.10.06 최승희 	최초 생성
 * </pre>
 * 
 * Copyright (C) 2014 by NDS., All right reserved.
 */
@Service("puffService")
public class PuffServiceImpl extends AbstractServiceImpl implements PuffService {

	@CommonLog Logger log;
	@Autowired PuffMapper puffMapper;
	
	@Transactional(readOnly=true)
	public Map<String, Object> selectPuffList(Map<String, Object> map) throws Exception {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		List<PuffVO> list = null;
				
		try{
			list = puffMapper.selectPuffList(map);
			int total_cnt = puffMapper.selectPuffTotalCnt(map);
			resultMap.put("list", list);
			resultMap.put("total_cnt", total_cnt);
			
			return resultMap;
			
		} catch(Exception e) {
			throw e;
		}
	}

	@Transactional(readOnly=true)
	public Map<String, Object> selectPuffDetail(Map<String, Object> map) throws Exception {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		PuffVO puffVO = null;
		List<FoodDangerFileVO> fileList = null;
		
		try{
			
			puffVO = puffMapper.selectPuffDetail(map);
			fileList = puffMapper.selectAttachFileList(map);
			
			resultMap.put("puffDetail", puffVO);
			resultMap.put("attachFileList", fileList);
			
			return resultMap;
			
		} catch(Exception e) {
			throw e;
		}
	}
	

}
