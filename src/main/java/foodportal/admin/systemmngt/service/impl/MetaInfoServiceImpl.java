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
import foodportal.admin.systemmngt.mapper.MetaInfoMapper;
import foodportal.admin.systemmngt.service.MetaInfoService;
import foodportal.admin.systemmngt.vo.AdminSystemmngtRootVO;
import foodportal.admin.systemmngt.vo.MetaVO;
import foodportal.admin.systemmngt.vo.UseMetaVO;

/**
 * MetaInfoServiceImpl
 * @author 박재형
 * @since 2014.09.03
 * @version 1.0
 * @see
 * 
 * <pre>
 *  Modification Information
 *  수정일      수정자   수정내용
 *  ---------- -------- ---------------------------
 *  2014.09.03 박재형 최초 생성
 * </pre>
 * 
 * Copyright (C) 2014 by NDS., All right reserved.
 */

@Service("metaInfoServiceImpl")
public class MetaInfoServiceImpl extends AbstractServiceImpl implements MetaInfoService {

	@CommonLog Logger log;

	@Autowired
	MetaInfoMapper metaInfoMapper;
	
	@Transactional(readOnly=true)
	public List<MetaVO> selectMetaList(WqBaseBean ibean) throws Exception {
		HashMap<String, Object> map = new HashMap<String, Object>();
		
		try{
			AdminSystemmngtRootVO adminSystemmngtRootVO = (AdminSystemmngtRootVO) ibean;
			MetaVO metaVO = adminSystemmngtRootVO.getParamMeta();
			
			map = CommonConvertObjectToMap.ConverObjectToMap(metaVO);
			
			List<MetaVO> list = metaInfoMapper.selectMetaList(map);
			
			return list;
			
		} catch(Exception e) {
			
			throw e;
		}
	}
	
	@Transactional(readOnly=true)
	public List<UseMetaVO> selectUseMetaList(WqBaseBean ibean) throws Exception {
		HashMap<String, Object> map = new HashMap<String, Object>();
		
		try{
			AdminSystemmngtRootVO adminSystemmngtRootVO = (AdminSystemmngtRootVO) ibean;
			UseMetaVO useMetaVO = adminSystemmngtRootVO.getParamUseMeta();
			
			map = CommonConvertObjectToMap.ConverObjectToMap(useMetaVO);
			
			List<UseMetaVO> list = metaInfoMapper.selectUseMetaList(map);
			
			return list;
			
		} catch(Exception e) {
			
			throw e;
		}
	}
	
	@Transactional
	public int saveUseMetaList(WqBaseBean ibean, String flag) throws Exception {
		HashMap<String, Object> map = new HashMap<String, Object>();
		int resultObj = 1;
		String rowStatus = "";
		try {
			AdminSystemmngtRootVO adminSystemmngtRootVO = (AdminSystemmngtRootVO) ibean;
			List paramUseMetaList = adminSystemmngtRootVO.getParamUseMetaList();
			
			UseMetaVO useMetaVO;
			
			/**
			 * 저장
			 */
			if("save".equals(flag)){
				
				for(int i=0; i<paramUseMetaList.size(); i++){
					useMetaVO = (UseMetaVO) paramUseMetaList.get(i);
					map = CommonConvertObjectToMap.ConverObjectToMap(useMetaVO);
					rowStatus = useMetaVO.getRowStatus();
//					System.out.println("========rowStatus====INSERT=====>"+rowStatus);
					if ("C".equals(rowStatus.toUpperCase())) {
						metaInfoMapper.insertUseMetaList(map);
					}
				}
			}
			
			/**
			 * 삭제
			 */
			if("delete".equals(flag)){
				
				for(int i=0; i<paramUseMetaList.size(); i++){
					useMetaVO = (UseMetaVO) paramUseMetaList.get(i);
					map = CommonConvertObjectToMap.ConverObjectToMap(useMetaVO);
					rowStatus = useMetaVO.getRowStatus();
//					System.out.println("========rowStatus====INSERT=====>"+rowStatus);
					if ("D".equals(rowStatus.toUpperCase())) {
						metaInfoMapper.deleteUseMetaList(map);
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