package common.adminfacillity.systemmngt.service.impl;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;            
import java.util.Map;         

import javax.annotation.Resource;

import egovframework.rte.fdl.cmmn.AbstractServiceImpl;
import common.adminfacillity.systemmngt.service.CommonCodeService;
import common.adminfacillity.systemmngt.mapper.CommonCodeMapper;
import common.adminfacillity.systemmngt.service.AdminfacillitySystemmngtRootVO;
import common.adminfacillity.systemmngt.service.CommonCodeVO;
import common.adminfacillity.systemmngt.service.CommonCodeDataVO;

import org.slf4j.Logger;

import common.commonfacillity.uia.WqBaseBean;
import common.commonfacillity.util.CommonConvertObjectToMap;
import common.commonfacillity.util.CommonStringUtil;
import common.commonfacillity.exception.CommonDuplicateException;
import common.commonfacillity.exception.CommonMessageException;
import common.commonfacillity.log.CommonLog;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * CommonCodeService
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

@Service("commonCodeService")
public class CommonCodeServiceImpl extends AbstractServiceImpl implements CommonCodeService {

	@CommonLog Logger log;

	@Autowired
	CommonCodeMapper commonCodeMapper;
	
	/* (non-Javadoc)
	 * @see common.adminfacillity.systemmngt.service.CommonCodeService#selectCommonCode(java.util.Map)
	 */
	@Transactional(readOnly=true)
	public List<CommonCodeVO> selectCommonCode(WqBaseBean ibean) throws Exception {
		HashMap<String, Object> map = new HashMap<String, Object>();
		
		try{
			AdminfacillitySystemmngtRootVO adminfacillitySystemmngtRootVo = (AdminfacillitySystemmngtRootVO) ibean;
			CommonCodeVO commonCodeVo = adminfacillitySystemmngtRootVo.getCommonCodeVO();
			
			map = CommonConvertObjectToMap.ConverObjectToMap(commonCodeVo);
			
//			if(map.get("cert_id") == null){
//				log.debug("Exception!!");
//				throw new CommonMessageException("exception");
//			}
			
			List<CommonCodeVO> list = commonCodeMapper.selectCommonCode(map);
			
			return list;
		} catch(Exception e) {
			
			throw e;
		}
	}
	
	/* (non-Javadoc)
	 * @see common.adminfacillity.systemmngt.service.CommonCodeService#saveCommonCode(java.util.Map)
	 */
	@Transactional
	public int saveCommonCode(WqBaseBean ibean) throws Exception {
		HashMap<String, Object> map = new HashMap<String, Object>();
		int resultObj = 1;
		int rowIndex = 0;
		String rowStatus = "";
		try {
			AdminfacillitySystemmngtRootVO adminfacillitySystemmngtRootVo = (AdminfacillitySystemmngtRootVO) ibean;
			List infoList = adminfacillitySystemmngtRootVo.getInfoList();
			List infoDataList = adminfacillitySystemmngtRootVo.getInfoDataList();
			CommonCodeVO commonCodeVO;
			CommonCodeDataVO commonCodeDataVO;
			
			/**
			 * Insert Master -> Detail
			 */
			for(int idx = 0, iCnt = infoList.size(); idx < iCnt ; idx++){
				commonCodeVO = (CommonCodeVO) infoList.get(idx);
				map = CommonConvertObjectToMap.ConverObjectToMap(commonCodeVO);
				rowStatus = commonCodeVO.getRowStatus();
				
				if (rowStatus.equalsIgnoreCase("C")) {
					commonCodeMapper.insertCommonCode(map);
					rowIndex++;
				}
			}
			rowIndex = 0;
			
			for(int idx = 0, iCnt = infoDataList.size(); idx < iCnt ; idx++){
				commonCodeDataVO = (CommonCodeDataVO) infoDataList.get(idx);
				map = CommonConvertObjectToMap.ConverObjectToMap(commonCodeDataVO);
				log.debug("saveCommonCode map[Detail] = " + map);
				rowStatus = commonCodeDataVO.getRowStatus();
				
				if (rowStatus.equalsIgnoreCase("C")) {
					commonCodeMapper.insertCommonCodeDetail(map);
					rowIndex++;
				}
			}
			rowIndex = 0;
			
			/**
			 * Update Detail -> Master
			 */
			for(int idx = 0, iCnt = infoDataList.size(); idx < iCnt ; idx++){
				commonCodeDataVO = (CommonCodeDataVO) infoDataList.get(idx);
				map = CommonConvertObjectToMap.ConverObjectToMap(commonCodeDataVO);
				rowStatus = commonCodeDataVO.getRowStatus();
				
				if (rowStatus.equalsIgnoreCase("U")) {
					commonCodeMapper.updateCommonCodeDetail(map);
					rowIndex++;
				}
			}
			rowIndex = 0;
			
			for(int idx = 0, iCnt = infoList.size(); idx < iCnt ; idx++){
				commonCodeVO = (CommonCodeVO) infoList.get(idx);
				map = CommonConvertObjectToMap.ConverObjectToMap(commonCodeVO);
				rowStatus = commonCodeVO.getRowStatus();
				
				if (rowStatus.equalsIgnoreCase("U")) {
					commonCodeMapper.updateCommonCode(map);
					rowIndex++;
				}
			}
			rowIndex = 0;
			
			/**
			 * Delete Detail -> Master
			 */
			for(int idx = 0, iCnt = infoDataList.size(); idx < iCnt ; idx++){
				commonCodeDataVO = (CommonCodeDataVO) infoDataList.get(idx);
				map = CommonConvertObjectToMap.ConverObjectToMap(commonCodeDataVO);
				rowStatus = commonCodeDataVO.getRowStatus();
				
				if (rowStatus.equalsIgnoreCase("D") || rowStatus.equalsIgnoreCase("E")) {
					commonCodeMapper.deleteCommonCodeDetail(map);
					rowIndex++;
				}
			}
			rowIndex = 0;
			
			for(int idx = 0, iCnt = infoList.size(); idx < iCnt ; idx++){
				commonCodeVO = (CommonCodeVO) infoList.get(idx);
				map = CommonConvertObjectToMap.ConverObjectToMap(commonCodeVO);
				rowStatus = commonCodeVO.getRowStatus();
				
				if (rowStatus.equalsIgnoreCase("D") || rowStatus.equalsIgnoreCase("E")) {
					commonCodeMapper.deleteCommonCode(map);
					rowIndex++;
				}
			}
			rowIndex = 0;
			
			return resultObj;
		}
		catch (Exception e)
		{
			
			throw e;
		}
	}

	/* (non-Javadoc)
	 * @see common.adminfacillity.systemmngt.service.CommonCodeService#insertCommonCode(java.util.Map)
	 */
	@Transactional
	public int insertCommonCode(WqBaseBean ibean) throws Exception {
		HashMap<String, Object> map = new HashMap<String, Object>();
		int resultObj = 1;
		
		try {
			AdminfacillitySystemmngtRootVO adminfacillitySystemmngtRootVO = (AdminfacillitySystemmngtRootVO) ibean;
			CommonCodeVO commonCodeVO = adminfacillitySystemmngtRootVO.getCommonCodeVO();
			
			map = CommonConvertObjectToMap.ConverObjectToMap(commonCodeVO);
			
			return commonCodeMapper.insertCommonCode(map);
		} catch(Exception e){
			
			resultObj = 0;
			return resultObj;
		}
	}

	/* (non-Javadoc)
	 * @see common.adminfacillity.systemmngt.service.CommonCodeService#deleteCommonCode(java.util.Map)
	 */
	@Transactional
	public int deleteCommonCode(WqBaseBean ibean) throws Exception {
		HashMap<String, Object> map = new HashMap<String, Object>();
		int resultObj = 1;
		
		try {
			AdminfacillitySystemmngtRootVO adminfacillitySystemmngtRootVO = (AdminfacillitySystemmngtRootVO) ibean;
			CommonCodeVO commonCodeVO = adminfacillitySystemmngtRootVO.getCommonCodeVO();
			
			map = CommonConvertObjectToMap.ConverObjectToMap(commonCodeVO);
			
			return commonCodeMapper.deleteCommonCode(map);
		} catch(Exception e){
			
			resultObj = 0;
			return resultObj;
		}
	}

	/* (non-Javadoc)
	 * @see common.adminfacillity.systemmngt.service.CommonCodeService#updateCommonCode(java.util.Map)
	 */
	@Transactional
	public int updateCommonCode(WqBaseBean ibean) throws Exception {
		HashMap<String, Object> map = new HashMap<String, Object>();
		int resultObj = 1;
		
		try {
			AdminfacillitySystemmngtRootVO adminfacillitySystemmngtRootVO = (AdminfacillitySystemmngtRootVO) ibean;
			CommonCodeVO commonCodeVO = adminfacillitySystemmngtRootVO.getCommonCodeVO();
			
			map = CommonConvertObjectToMap.ConverObjectToMap(commonCodeVO);
			
			return commonCodeMapper.updateCommonCode(map);
		} catch(Exception e){
			
			resultObj = 0;
			return resultObj;
		}
	}

	/* (non-Javadoc)
	 * @see common.adminfacillity.systemmngt.service.CommonCodeService#selectCommonCodeDetail(java.util.Map)
	 */
	@Transactional(readOnly=true)
	public List<CommonCodeDataVO> selectCommonCodeDetail(WqBaseBean ibean) throws Exception {
		HashMap<String, Object> map = new HashMap<String, Object>();
		
		try{
			AdminfacillitySystemmngtRootVO adminfacillitySystemmngtRootVo = (AdminfacillitySystemmngtRootVO) ibean;
			CommonCodeDataVO commonCodeDataVO = adminfacillitySystemmngtRootVo.getCommonCodeDataVO();
			
			map = CommonConvertObjectToMap.ConverObjectToMap(commonCodeDataVO);
			log.debug("[selectCommonCodeDetail] map :: " + map);
			List<CommonCodeDataVO> list = commonCodeMapper.selectCommonCodeDetail(map);
			
			return list;
		} catch(Exception e) {
			
			throw e;
		}
	}

	/* (non-Javadoc)
	 * @see common.adminfacillity.systemmngt.service.CommonCodeService#insertCommonCodeDetail(java.util.Map)
	 */
	@Transactional
	public int insertCommonCodeDetail(WqBaseBean ibean) throws Exception {
		HashMap<String, Object> map = new HashMap<String, Object>();
		int resultObj = 1;
		
		try {
			AdminfacillitySystemmngtRootVO adminfacillitySystemmngtRootVO = (AdminfacillitySystemmngtRootVO) ibean;
			CommonCodeDataVO commonCodeDataVO = adminfacillitySystemmngtRootVO.getCommonCodeDataVO();
			
			map = CommonConvertObjectToMap.ConverObjectToMap(commonCodeDataVO);
			
			return commonCodeMapper.insertCommonCodeDetail(map);
		} catch(Exception e){
			
			resultObj = 0;
			return resultObj;
		}
	}

	/* (non-Javadoc)
	 * @see common.adminfacillity.systemmngt.service.CommonCodeService#deleteCommonCodeDetail(java.util.Map)
	 */
	@Transactional
	public int deleteCommonCodeDetail(WqBaseBean ibean) throws Exception {
		HashMap<String, Object> map = new HashMap<String, Object>();
		int resultObj = 1;
		
		try {
			AdminfacillitySystemmngtRootVO adminfacillitySystemmngtRootVO = (AdminfacillitySystemmngtRootVO) ibean;
			CommonCodeDataVO commonCodeDataVO = adminfacillitySystemmngtRootVO.getCommonCodeDataVO();
			
			map = CommonConvertObjectToMap.ConverObjectToMap(commonCodeDataVO);
			
			return commonCodeMapper.deleteCommonCodeDetail(map);
		} catch(Exception e){
			
			resultObj = 0;
			return resultObj;
		}
	}

	/* (non-Javadoc)
	 * @see common.adminfacillity.systemmngt.service.CommonCodeService#updateCommonCodeDetail(java.util.Map)
	 */
	@Transactional
	public int updateCommonCodeDetail(WqBaseBean ibean) throws Exception {
		HashMap<String, Object> map = new HashMap<String, Object>();
		int resultObj = 1;
		
		try {
			AdminfacillitySystemmngtRootVO adminfacillitySystemmngtRootVO = (AdminfacillitySystemmngtRootVO) ibean;
			CommonCodeDataVO commonCodeDataVO = adminfacillitySystemmngtRootVO.getCommonCodeDataVO();
			
			map = CommonConvertObjectToMap.ConverObjectToMap(commonCodeDataVO);
			
			return commonCodeMapper.updateCommonCodeDetail(map);
		} catch(Exception e){
			
			resultObj = 0;
			return resultObj;
		}
	}
	
	/* (non-Javadoc)
	 * @see common.adminfacillity.systemmngt.service.CommonCodeService#selectCommonCodeFunction(java.util.Map)
	 */
	public List<CommonCodeDataVO> selectCommonCodeFunction(WqBaseBean ibean) throws Exception {
		HashMap<String, Object> map = new HashMap<String, Object>();
		
		try{
			AdminfacillitySystemmngtRootVO adminfacillitySystemmngtRootVo = (AdminfacillitySystemmngtRootVO) ibean;
			CommonCodeVO commonDataVO = adminfacillitySystemmngtRootVo.getCommonCodeVO();
			
			map = CommonConvertObjectToMap.ConverObjectToMap(commonDataVO);
			log.debug("[selectCommonCodeFunction] map:::" + map);
			List<CommonCodeDataVO> list = commonCodeMapper.selectCommonCodeFunction(map);
			
			return list;
		} catch(Exception e) {
			
			throw e;
		}
	}
}