package foodportal.admin.systemmngt.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;            

import egovframework.rte.fdl.cmmn.AbstractServiceImpl;
import foodportal.admin.systemmngt.mapper.UserSearchMapper;
import foodportal.admin.systemmngt.service.UserSearchService;
import foodportal.admin.systemmngt.vo.AdminSystemmngtRootVO;
import foodportal.admin.systemmngt.vo.UserSearchVO;
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
 * UserSearchServiceImpl
 * @author 최연길
 * @since 2014.09.05
 * @version 1.0
 * @see
 * 
 * <pre>
 *  Modification Information
 *  수정일      수정자   수정내용
 *  ---------- -------- ---------------------------
 *  2014.09.05 최연길 최초 생성
 * </pre>
 * 
 * Copyright (C) 2014 by NDS., All right reserved.
 */

@Service("userSearchService")
public class UserSearchServiceImpl extends AbstractServiceImpl implements UserSearchService {

	@CommonLog Logger log;

	@Autowired
	UserSearchMapper userSearchMapper;
	
	@Transactional
	public List<UserSearchVO> selectUserSearchList(WqBaseBean ibean) throws Exception {
		HashMap<String, Object> map = new HashMap<String, Object>();
		
		try{
			AdminSystemmngtRootVO adminSystemmngtRootVO = (AdminSystemmngtRootVO) ibean;
			UserSearchVO UserSearchVO = adminSystemmngtRootVO.getParamUserSearchInfo();
			
			map = CommonConvertObjectToMap.ConverObjectToMap(UserSearchVO);
			
			List<UserSearchVO> list = userSearchMapper.selectUserSearchList(map);
			return list;
			
		} catch(Exception e) {
			
			throw e;
		}
	}
	

	
}