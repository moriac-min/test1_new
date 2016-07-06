package common.adminfacillity.systemmngt.service.impl;

import java.util.HashMap;
import java.util.List;            
import java.util.Map;         

import javax.annotation.Resource;

import egovframework.rte.fdl.cmmn.AbstractServiceImpl;
import common.adminfacillity.systemmngt.service.CommonPopupService;
import common.adminfacillity.systemmngt.mapper.CommonPopupMapper;
import common.adminfacillity.systemmngt.service.CommonPopupItemVO;
import common.adminfacillity.systemmngt.service.CommonPopupVO;
import common.adminfacillity.systemmngt.service.AdminfacillitySystemmngtRootVO;

import org.slf4j.Logger;

import common.commonfacillity.util.CommonConvertObjectToMap;
import common.commonfacillity.util.CommonStringUtil;
import common.commonfacillity.log.CommonLog;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import common.commonfacillity.uia.WqBaseBean;

/**
 * ProgramService
 * @author 유승엽
 * @since 2014.08.18
 * @version 1.0
 * @see
 * 
 * <pre>
 *  Modification Information
 *  수정일      수정자   수정내용
 *  ---------- -------- ---------------------------
 *  2014.08.18 유승엽 최초 생성
 * </pre>
 * 
 * Copyright (C) 2014 by NDS., All right reserved.
 */

@Service("commonPopupService")
public class CommonPopupServiceImpl extends AbstractServiceImpl implements CommonPopupService {

	@CommonLog Logger log;

	@Autowired
	CommonPopupMapper commonPopupMapper;


	/* (non-Javadoc)
	 * @see common.adminfacillity.systemmngt.service.CommonPopupService#selectCommonPopup(java.util.Map)
	 */
	@Transactional(readOnly=true)
	public List<CommonPopupVO> selectCommonPopup(WqBaseBean ibean) throws Exception {
		HashMap<String, Object> map = new HashMap<String, Object>();
		
		try{
			AdminfacillitySystemmngtRootVO sVo = (AdminfacillitySystemmngtRootVO) ibean;
			CommonPopupVO inUserVo = sVo.getCommonPopupVO();
			
			log.debug("[IN] selectCommonPopup:::" + inUserVo);
			
			map = CommonConvertObjectToMap.ConverObjectToMap(inUserVo);
			log.debug("[IN MAP] selectCommonPopup:::" + map);
			List<CommonPopupVO> list = commonPopupMapper.selectCommonPopup(map);
			
			return list;	
			
		}catch(Exception e){
			
			throw e;
		}
	}

	/* (non-Javadoc)
	 * @see common.adminfacillity.systemmngt.service.CommonPopupService#saveCommonPopup(java.util.Map)
	 */
	@Transactional
	public int saveCommonPopup(WqBaseBean ibean) throws Exception {
		HashMap<String, Object> map = new HashMap<String, Object>();
		try {
			AdminfacillitySystemmngtRootVO sVo = (AdminfacillitySystemmngtRootVO) ibean;
			List<CommonPopupVO> commonPopupList = sVo.getInfoList();
			List<CommonPopupItemVO> commonPopupItemList = sVo.getInfoDataList();
			CommonPopupVO commonPopupVo;
			CommonPopupItemVO commonPopupItemVo;
			String rowStatus;
			
//			log.debug("saveCommonPopup commonPopupList SIZE " + commonPopupList.size());
//			log.debug("saveCommonPopup commonPopupList.data " + commonPopupList.get(0));
			for (int idx = 0, iCnt = commonPopupList.size(); idx < iCnt; idx++) {
				commonPopupVo = (CommonPopupVO) commonPopupList.get(idx);
				map = CommonConvertObjectToMap.ConverObjectToMap(commonPopupVo);
				log.debug("[IN MAP] saveCommonPopup:::" + map);
				rowStatus = commonPopupVo.getRowStatus();
				
				if (rowStatus.equalsIgnoreCase("C")) {
					commonPopupMapper.insertCommonPopup(map);
				} 
			}
			
			for (int idx = 0, iCnt = commonPopupItemList.size(); idx < iCnt; idx++) {
				commonPopupItemVo = (CommonPopupItemVO) commonPopupItemList.get(idx);
				map = CommonConvertObjectToMap.ConverObjectToMap(commonPopupItemVo);
				log.debug("[IN MAP] saveCommonPopupItem:::" + map);
				rowStatus = commonPopupItemVo.getRowStatus();
				
				if (rowStatus.equalsIgnoreCase("C")) {
					commonPopupMapper.insertCommonPopupItem(map);
				} 
			}
			
			for (int idx = 0, iCnt = commonPopupItemList.size(); idx < iCnt; idx++) {
				commonPopupItemVo = (CommonPopupItemVO) commonPopupItemList.get(idx);
				map = CommonConvertObjectToMap.ConverObjectToMap(commonPopupItemVo);
				log.debug("[IN MAP] saveCommonPopupItem:::" + map);
				rowStatus = commonPopupItemVo.getRowStatus();
				
				if (rowStatus.equalsIgnoreCase("U")) {
					commonPopupMapper.updateCommonPopupItem(map);
				} else if (rowStatus.equalsIgnoreCase("D") || rowStatus.equalsIgnoreCase("E")) {
					commonPopupMapper.deleteCommonPopupItem(map);
				}
			}
			
			for (int idx = 0, iCnt = commonPopupList.size(); idx < iCnt; idx++) {
				commonPopupVo = (CommonPopupVO) commonPopupList.get(idx);
				map = CommonConvertObjectToMap.ConverObjectToMap(commonPopupVo);
				log.debug("[IN MAP] saveCommonPopup:::" + map);
				rowStatus = commonPopupVo.getRowStatus();
				
				if (rowStatus.equalsIgnoreCase("U")) {
					commonPopupMapper.updateCommonPopup(map);
				} else if (rowStatus.equalsIgnoreCase("D") || rowStatus.equalsIgnoreCase("E")) {
					commonPopupMapper.deleteCommonPopup(map);
				}
			}
			
			return 1;
		} catch (Exception e) {	
			return 0;
		}
	}

	@Override
	public List<CommonPopupItemVO> selectCommonPopupItem(WqBaseBean ibean) throws Exception{
		HashMap<String, Object> map = new HashMap<String, Object>();
		
		try{
			AdminfacillitySystemmngtRootVO sVo = (AdminfacillitySystemmngtRootVO) ibean;
			CommonPopupItemVO inUserVo = sVo.getCommonPopupItemVO();
			
			map = CommonConvertObjectToMap.ConverObjectToMap(inUserVo);
			
			List<CommonPopupItemVO> list = commonPopupMapper.selectCommonPopupItem(map);
			
			return list;	
			
		}catch(Exception e){
			
			throw e;
		}
	}

	@Override
	public int saveCommonPopupItem(WqBaseBean ibean) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

}