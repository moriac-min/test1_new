package common.adminfacillity.systemmngt.service.impl;

import java.util.HashMap;
import java.util.List;            
import java.util.Map;         

import javax.annotation.Resource;

import egovframework.rte.fdl.cmmn.AbstractServiceImpl;
import common.adminfacillity.systemmngt.service.AdminfacillitySystemmngtRootVO;
import common.adminfacillity.systemmngt.service.SystemMessageService;
import common.adminfacillity.systemmngt.mapper.SystemMessageMapper;
import common.adminfacillity.systemmngt.service.SystemMessageVO;

import org.slf4j.Logger;

import common.commonfacillity.uia.WqBaseBean;
import common.commonfacillity.util.CommonConvertObjectToMap;
import common.commonfacillity.util.CommonStringUtil;
import common.commonfacillity.log.CommonLog;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * SystemMessageService
 * @author 김민규
 * @since 2014.08.19
 * @version 1.0
 * @see
 * 
 * <pre>
 *  Modification Information
 *  수정일      수정자   수정내용
 *  ---------- -------- ---------------------------
 *  2014.08.19 김민규 최초 생성
 * </pre>
 * 
 * Copyright (C) 2014 by NDS., All right reserved.
 */

@Service("systemMessageService")
public class SystemMessageServiceImpl extends AbstractServiceImpl implements SystemMessageService {

	@CommonLog Logger log;

	@Autowired
	SystemMessageMapper systemMessageMapper;


	/* (non-Javadoc)
	 * @see common.adminfacillity.systemmngt.service.SystemMessageService#selectSystemMessage(java.util.Map)
	 */
	@Transactional(readOnly=true)
	public List<SystemMessageVO> selectSystemMessage(WqBaseBean ibean) throws Exception {
		HashMap<String, Object> map = new HashMap<String, Object>();
		
		try{
			AdminfacillitySystemmngtRootVO adminfacillitySystemmngtRootVO = (AdminfacillitySystemmngtRootVO) ibean;
			SystemMessageVO systemMessageVO = adminfacillitySystemmngtRootVO.getSystemMessageVO();
			
			map = CommonConvertObjectToMap.ConverObjectToMap(systemMessageVO);
			
			List<SystemMessageVO> list = systemMessageMapper.selectSystemMessage(map);
			
			return list;
		} catch (Exception e){
			
			throw e;
		}
	}
	
	/* (non-Javadoc)
	 * @see common.adminfacillity.systemmngt.service.SystemMessageService#saveSystemMessage(java.util.Map)
	 */
	@Transactional
	public int saveSystemMessage(WqBaseBean ibean) throws Exception {
		HashMap<String, Object> map = new HashMap<String, Object>();
		int resultObj = 1;
		String rowStatus = "";
		
		try{
			AdminfacillitySystemmngtRootVO adminfacillitySystemmngtRootVO = (AdminfacillitySystemmngtRootVO) ibean;
			List infoList = adminfacillitySystemmngtRootVO.getInfoList();
			SystemMessageVO systemMessageVO;
			
			/**
			 * Insert
			 */
			for(int idx = 0, iCnt = infoList.size(); idx < iCnt ; idx++){
				systemMessageVO = (SystemMessageVO) infoList.get(idx);
				map = CommonConvertObjectToMap.ConverObjectToMap(systemMessageVO);
				rowStatus = systemMessageVO.getRowStatus();
				
				if(rowStatus.equalsIgnoreCase("C")){
					systemMessageMapper.insertSystemMessage(map);
				}
			}
			
			/**
			 * Update
			 */
			for(int idx = 0, iCnt = infoList.size(); idx < iCnt ; idx++){
				systemMessageVO = (SystemMessageVO) infoList.get(idx);
				map = CommonConvertObjectToMap.ConverObjectToMap(systemMessageVO);
				rowStatus = systemMessageVO.getRowStatus();
				
				if(rowStatus.equalsIgnoreCase("U")){
					systemMessageMapper.updateSystemMessage(map);
				}
			}
			
			/**
			 * Delete
			 */
			for(int idx = 0, iCnt = infoList.size(); idx < iCnt ; idx++){
				systemMessageVO = (SystemMessageVO) infoList.get(idx);
				map = CommonConvertObjectToMap.ConverObjectToMap(systemMessageVO);
				rowStatus = systemMessageVO.getRowStatus();
				
				if (rowStatus.equalsIgnoreCase("D") || rowStatus.equalsIgnoreCase("E")) {
					systemMessageMapper.deleteSystemMessage(map);
				}
			}
			
			return resultObj;
		} catch (Exception e){
			
			resultObj = 0;
			return resultObj;
		}
	}

	/* (non-Javadoc)
	 * @see common.adminfacillity.systemmngt.service.SystemMessageService#insertSystemMessage(java.util.Map)
	 */
	@Transactional
	public int insertSystemMessage(WqBaseBean ibean) throws Exception {
		HashMap<String, Object> map = new HashMap<String, Object>();
		int resultObj = 1;
		
		try {
			AdminfacillitySystemmngtRootVO adminfacillitySystemmngtRootVO = (AdminfacillitySystemmngtRootVO) ibean;
			SystemMessageVO systemMessageVO = adminfacillitySystemmngtRootVO.getSystemMessageVO();
			
			map = CommonConvertObjectToMap.ConverObjectToMap(systemMessageVO);
			
			return systemMessageMapper.insertSystemMessage(map);
		} catch (Exception e) {
			
			resultObj = 0;
			return resultObj;
		}
	}
	
	/* (non-Javadoc)
	 * @see common.adminfacillity.systemmngt.service.SystemMessageService#updateSystemMessage(java.util.Map)
	 */
	@Transactional
	public int updateSystemMessage(WqBaseBean ibean) throws Exception {
		HashMap<String, Object> map = new HashMap<String, Object>();
		int resultObj = 1;
		
		try {
			AdminfacillitySystemmngtRootVO adminfacillitySystemmngtRootVO = (AdminfacillitySystemmngtRootVO) ibean;
			SystemMessageVO systemMessageVO = adminfacillitySystemmngtRootVO.getSystemMessageVO();
			
			map = CommonConvertObjectToMap.ConverObjectToMap(systemMessageVO);
			
			return systemMessageMapper.updateSystemMessage(map);
		} catch (Exception e) {
			
			resultObj = 0;
			return resultObj;
		}
	}

	/* (non-Javadoc)
	 * @see common.adminfacillity.systemmngt.service.SystemMessageService#deleteSystemMessage(java.util.Map)
	 */
	@Transactional
	public int deleteSystemMessage(WqBaseBean ibean) throws Exception {
		HashMap<String, Object> map = new HashMap<String, Object>();
		int resultObj = 1;
		
		try {
			AdminfacillitySystemmngtRootVO adminfacillitySystemmngtRootVO = (AdminfacillitySystemmngtRootVO) ibean;
			SystemMessageVO systemMessageVO = adminfacillitySystemmngtRootVO.getSystemMessageVO();
			
			map = CommonConvertObjectToMap.ConverObjectToMap(systemMessageVO);
			
			return systemMessageMapper.deleteSystemMessage(map);
		} catch (Exception e) {
			
			resultObj = 0;
			return resultObj;
		}
	}

	
}