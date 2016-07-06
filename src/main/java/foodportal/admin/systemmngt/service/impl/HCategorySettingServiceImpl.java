package foodportal.admin.systemmngt.service.impl;

import java.util.HashMap;
import java.util.List;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import common.commonfacillity.log.CommonLog;
import common.commonfacillity.uia.WqBaseBean;
import common.commonfacillity.util.CommonConvertObjectToMap;
import egovframework.rte.fdl.cmmn.AbstractServiceImpl;
import foodportal.admin.systemmngt.mapper.HCategorySettingMapper;
import foodportal.admin.systemmngt.service.HCategorySettingService;
import foodportal.admin.systemmngt.vo.AdminSystemmngtRootVO;
import foodportal.admin.systemmngt.vo.HCategorySettingVo;

/**
 * HCategorySettingServiceImpl
 * @author 박재형
 * @since 2014.08.27
 * @version 1.0
 * @see
 * 
 * <pre>
 *  Modification Information
 *  수정일      수정자   수정내용
 *  ---------- -------- ---------------------------
 *  2014.08.27 박재형 최초 생성
 * </pre>
 * 
 * Copyright (C) 2014 by NDS., All right reserved.
 */

@Service("hCategorySettingService")
public class HCategorySettingServiceImpl extends AbstractServiceImpl implements HCategorySettingService {

	@CommonLog Logger log;

	@Autowired
	HCategorySettingMapper hCategorySettingMapper;
	
	@Transactional(readOnly=true)
	public List<HCategorySettingVo> selectHCategorySettingList(WqBaseBean ibean) throws Exception {
		HashMap<String, Object> map = new HashMap<String, Object>();
		
		try{
			AdminSystemmngtRootVO adminSystemmngtRootVO = (AdminSystemmngtRootVO) ibean;
			HCategorySettingVo hCategorySettingVo = adminSystemmngtRootVO.getParamHCategory();
			
			map = CommonConvertObjectToMap.ConverObjectToMap(hCategorySettingVo);
			
			List<HCategorySettingVo> list = hCategorySettingMapper.selectHCategorySettingList(map);
			
			return list;
			
		} catch(Exception e) {
			
			throw e;
		}
	}
	
	@Transactional
	public int saveHCategorySettingList(WqBaseBean ibean, String flag) throws Exception {
		HashMap<String, Object> map = new HashMap<String, Object>();
		int resultObj = 1;
		String rowStatus = "";
		try {
			AdminSystemmngtRootVO adminSystemmngtRootVO = (AdminSystemmngtRootVO) ibean;
			List paramHCategorySettingList = adminSystemmngtRootVO.getParamHCategorySettingList();
			
			HCategorySettingVo hCategorySettingVo;
			
			/**
			 * 저장
			 */
			if("save".equals(flag)){
				
				for(int i=0; i<paramHCategorySettingList.size(); i++){
					hCategorySettingVo = (HCategorySettingVo) paramHCategorySettingList.get(i);
					map = CommonConvertObjectToMap.ConverObjectToMap(hCategorySettingVo);
					rowStatus = hCategorySettingVo.getRowStatus();
//					System.out.println(hCategorySettingVo.getCtgrynm()+"========rowStatus====INSERT=====>"+rowStatus);
					if ("C".equals(rowStatus.toUpperCase())) {
						hCategorySettingMapper.insertHCategorySettingList(map);
					}
				}
				
				for(int i=0; i<paramHCategorySettingList.size(); i++){
					hCategorySettingVo = (HCategorySettingVo) paramHCategorySettingList.get(i);
					map = CommonConvertObjectToMap.ConverObjectToMap(hCategorySettingVo);
					rowStatus = hCategorySettingVo.getRowStatus();
//					System.out.println(hCategorySettingVo.getCtgrynm()+"========rowStatus====UPDATE=====>"+rowStatus);
					if ("U".equals(rowStatus.toUpperCase())) {
						hCategorySettingMapper.updateHCategorySettingList(map);
					}
				}
				
			}
			
			/**
			 * 삭제
			 */
			if("delete".equals(flag)){
				
				for(int i=0; i<paramHCategorySettingList.size(); i++){
					hCategorySettingVo = (HCategorySettingVo) paramHCategorySettingList.get(i);
					map = CommonConvertObjectToMap.ConverObjectToMap(hCategorySettingVo);
					rowStatus = hCategorySettingVo.getRowStatus();
//					System.out.println(hCategorySettingVo.getCtgrynm()+"========rowStatus=========>"+rowStatus);
					if ("D".equals(rowStatus.toUpperCase())) {
						hCategorySettingMapper.deleteLCategorySettingList(map);
						hCategorySettingMapper.deleteHCategorySettingList(map);
					}
				}
				
			}
			return resultObj;
		} catch(Exception e){
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			resultObj = 0;
			return resultObj;
		}
		
	}
	
	@Transactional(readOnly=true)
	public List<HCategorySettingVo> selectLCategorySettingList(WqBaseBean ibean) throws Exception {
		HashMap<String, Object> map = new HashMap<String, Object>();
		
		try{
			AdminSystemmngtRootVO adminSystemmngtRootVO = (AdminSystemmngtRootVO) ibean;
			HCategorySettingVo hCategorySettingVo = adminSystemmngtRootVO.getParamLCategory();
			
			map = CommonConvertObjectToMap.ConverObjectToMap(hCategorySettingVo);
			
			List<HCategorySettingVo> list = hCategorySettingMapper.selectLCategorySettingList(map);
			
			return list;
			
		} catch(Exception e) {
			
			throw e;
		}
	}
	
	@Transactional
	public int saveLCategorySettingList(WqBaseBean ibean, String flag) throws Exception {
		HashMap<String, Object> map = new HashMap<String, Object>();
		int resultObj = 1;
		String rowStatus = "";
		try {
			AdminSystemmngtRootVO adminSystemmngtRootVO = (AdminSystemmngtRootVO) ibean;
			List paramLCategorySettingList = adminSystemmngtRootVO.getParamLCategorySettingList();
			
			HCategorySettingVo hCategorySettingVo;
			
			/**
			 * 저장
			 */
			if("save".equals(flag)){
				
				for(int i=0; i<paramLCategorySettingList.size(); i++){
					hCategorySettingVo = (HCategorySettingVo) paramLCategorySettingList.get(i);
					map = CommonConvertObjectToMap.ConverObjectToMap(hCategorySettingVo);
					rowStatus = hCategorySettingVo.getRowStatus();
//					System.out.println(hCategorySettingVo.getCtgrynm()+"========rowStatus====INSERT=====>"+rowStatus);
					if ("C".equals(rowStatus.toUpperCase())) {
						hCategorySettingMapper.insertLCategorySettingList(map);
					}
				}
				
				for(int i=0; i<paramLCategorySettingList.size(); i++){
					hCategorySettingVo = (HCategorySettingVo) paramLCategorySettingList.get(i);
					map = CommonConvertObjectToMap.ConverObjectToMap(hCategorySettingVo);
					rowStatus = hCategorySettingVo.getRowStatus();
//					System.out.println(hCategorySettingVo.getCtgrynm()+"========rowStatus====UPDATE=====>"+rowStatus);
					if ("U".equals(rowStatus.toUpperCase())) {
						hCategorySettingMapper.updateLCategorySettingList(map);
					}
				}
				
			}
			
			/**
			 * 삭제
			 */
			if("delete".equals(flag)){
				
				for(int i=0; i<paramLCategorySettingList.size(); i++){
					hCategorySettingVo = (HCategorySettingVo) paramLCategorySettingList.get(i);
					map = CommonConvertObjectToMap.ConverObjectToMap(hCategorySettingVo);
					rowStatus = hCategorySettingVo.getRowStatus();
//					System.out.println(hCategorySettingVo.getCtgrynm()+"========rowStatus=========>"+rowStatus);
					if ("D".equals(rowStatus.toUpperCase())) {
						hCategorySettingMapper.deleteSimpleLCategorySettingList(map);
					}
				}
				
			}
			return resultObj;
		} catch(Exception e){
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			resultObj = 0;
			return resultObj;
		}
		
	}
	
}