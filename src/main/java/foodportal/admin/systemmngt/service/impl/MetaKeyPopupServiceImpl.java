package foodportal.admin.systemmngt.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;            

import egovframework.rte.fdl.cmmn.AbstractServiceImpl;
import foodportal.admin.systemmngt.mapper.MetaKeyPopupMapper;
import foodportal.admin.systemmngt.service.MetaKeyPopupService;
import foodportal.admin.systemmngt.vo.AdminSystemmngtRootVO;
import foodportal.admin.systemmngt.vo.MetaKeyPopupVO;
import foodportal.common.util.StringUtil;

import org.slf4j.Logger;

import common.adminfacillity.systemmngt.service.AdminfacillitySystemmngtRootVO;
import common.adminfacillity.systemmngt.service.CommonCodeDataVO;
import common.adminfacillity.systemmngt.service.CommonCodeVO;
import common.commonfacillity.uia.WqBaseBean;
import common.commonfacillity.util.CommonConvertObjectToMap;
import common.commonfacillity.log.CommonLog;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

/**
 * MetaKeyPopupServiceImpl
 * @author 최연길
 * @since 2014.09.17
 * @version 1.0
 * @see
 * 
 * <pre>
 *  Modification Information
 *  수정일      수정자   수정내용
 *  ---------- -------- ---------------------------
 *  2014.09.17 최연길 최초 생성
 * </pre>
 * 
 * Copyright (C) 2014 by NDS., All right reserved.
 */

@Service("metaKeyPopupService")
public class MetaKeyPopupServiceImpl extends AbstractServiceImpl implements MetaKeyPopupService {

	@CommonLog Logger log;

	@Autowired
	MetaKeyPopupMapper metaKeyPopupMapper;
	
	@Transactional
	public List<MetaKeyPopupVO> selectMetaKeyPopupList(WqBaseBean ibean) throws Exception {
		HashMap<String, Object> map = new HashMap<String, Object>();
		
		try{
			AdminSystemmngtRootVO adminSystemmngtRootVO = (AdminSystemmngtRootVO) ibean;
			MetaKeyPopupVO paramMetaKeyPopupInfo = adminSystemmngtRootVO.getParamMetaKeyPopupInfo();
			
			map = CommonConvertObjectToMap.ConverObjectToMap(paramMetaKeyPopupInfo);
			
			List<MetaKeyPopupVO> list = metaKeyPopupMapper.selectMetaKeyPopupList(map);
			return list;
			
		} catch(Exception e) {
			
			throw e;
		}
	}
	

	
}