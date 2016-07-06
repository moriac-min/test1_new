package foodportal.admin.systemmngt.service.impl;

import java.util.HashMap;
import java.util.List;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import common.commonfacillity.log.CommonLog;
import common.commonfacillity.uia.WqBaseBean;
import common.commonfacillity.util.CommonConvertObjectToMap;

import egovframework.rte.fdl.cmmn.AbstractServiceImpl;
import foodportal.admin.systemmngt.mapper.AuthMapper;
import foodportal.admin.systemmngt.service.AuthService;
import foodportal.admin.systemmngt.vo.AdminSystemmngtRootVO;
import foodportal.admin.systemmngt.vo.AuthVO;

/**
 * AuthServiceImpl
 * @author 임재록
 * @since 2014.08.29
 * @version 1.0
 * @see
 * 
 * <pre>
 *  Modification Information
 *  수정일      수정자   수정내용
 *  ---------- -------- ---------------------------
 *  2014.08.29 임재록 최초 생성
 * </pre>
 * 
 * Copyright (C) 2014 by NDS., All right reserved.
 */

@Service("authService")
public class AuthServiceImpl extends AbstractServiceImpl implements AuthService {

	@CommonLog Logger log;

	@Autowired
	AuthMapper authMapper;
	
	@Transactional(readOnly=true)
	public List<AuthVO> selectAuthList(WqBaseBean ibean) throws Exception {
		HashMap<String, Object> map = new HashMap<String, Object>();
		
		try{
			AdminSystemmngtRootVO adminSystemmngtRootVO = (AdminSystemmngtRootVO) ibean;
			AuthVO authVO = adminSystemmngtRootVO.getAuth();
			
			map = CommonConvertObjectToMap.ConverObjectToMap(authVO);
			
			List<AuthVO> list = authMapper.selectAuthList(map);
			
			return list;
			
		} catch(Exception e) {
			
			throw e;
		}
	}

	@Transactional(readOnly=true)
	public AuthVO selectAuthDetail(WqBaseBean ibean) throws Exception {
		return null;
	}

	@Transactional
	public int insertAuth(WqBaseBean ibean) throws Exception {
		try {
			AdminSystemmngtRootVO adminSystemmngtRootVO = (AdminSystemmngtRootVO) ibean;
			AuthVO authVO = adminSystemmngtRootVO.getAuth();
			
			HashMap<String, Object> map = CommonConvertObjectToMap.ConverObjectToMap(authVO);
			
			return authMapper.insertAuth(map);
		} catch(Exception e){
			
			return 0;
		}
	}

	@Transactional
	public int updateAuth(WqBaseBean ibean) throws Exception {
		try {
			AdminSystemmngtRootVO adminSystemmngtRootVO = (AdminSystemmngtRootVO) ibean;
			AuthVO authVO = adminSystemmngtRootVO.getAuth();
			
			HashMap<String, Object> map = CommonConvertObjectToMap.ConverObjectToMap(authVO);
			
			return authMapper.updateAuth(map);
		} catch(Exception e){
			
			return 0;
		}
	}

	@Transactional
	public int deleteAuth(WqBaseBean ibean) throws Exception {
		try {
			AdminSystemmngtRootVO adminSystemmngtRootVO = (AdminSystemmngtRootVO) ibean;
			AuthVO authVO = adminSystemmngtRootVO.getAuth();
			
			HashMap<String, Object> map = CommonConvertObjectToMap.ConverObjectToMap(authVO);
			
			return authMapper.deleteAuth(map);
		} catch(Exception e){
			
			return 0;
		}
	}

	@Transactional
	public int saveAuth(WqBaseBean ibean) throws Exception {
		try {
			AdminSystemmngtRootVO adminSystemmngtRootVO = (AdminSystemmngtRootVO) ibean;
			List<AuthVO> authList = adminSystemmngtRootVO.getAuthList();
			
			log.debug("saveAuth authList SIZE " + authList.size());
			
			for (int idx = 0, iCnt = authList.size(); idx < iCnt; idx++) {
				AuthVO authVO = (AuthVO) authList.get(idx);
				
				HashMap<String, Object> map = CommonConvertObjectToMap.ConverObjectToMap(authVO);
				log.debug("[IN MAP] saveAuth:::" + map);
				String rowStatus = authVO.getRowStatus();
				
				log.debug("saveAuth rowStatus[" + idx + "]:::" + rowStatus);
				if (rowStatus.equalsIgnoreCase("U")) {
					authMapper.updateAuth(map);
				} else if (rowStatus.equalsIgnoreCase("D") || rowStatus.equalsIgnoreCase("E")) {
					authMapper.deleteAuth(map);
				} else if (rowStatus.equalsIgnoreCase("C")) {
					authMapper.insertAuth(map);
				}
			}
			
			return 1;
		} catch (Exception e) {	
			
			return 0;
		}
	}

}