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
import foodportal.admin.systemmngt.mapper.AuthMenuMapper;
import foodportal.admin.systemmngt.service.AuthMenuService;
import foodportal.admin.systemmngt.vo.AdminSystemmngtRootVO;
import foodportal.admin.systemmngt.vo.AuthMenuVO;
import foodportal.admin.systemmngt.vo.AuthVO;
import foodportal.admin.systemmngt.vo.MenuVO;

/**
 * AuthMenuServiceImpl
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

@Service("authMenuService")
public class AuthMenuServiceImpl extends AbstractServiceImpl implements AuthMenuService {

	@CommonLog Logger log;

	@Autowired
	AuthMenuMapper authMenuMapper;
	
	@Transactional(readOnly=true)
	public List<AuthVO> selectAuthList(WqBaseBean ibean) throws Exception {
		HashMap<String, Object> map = new HashMap<String, Object>();
		
		try{
			AdminSystemmngtRootVO adminSystemmngtRootVO = (AdminSystemmngtRootVO) ibean;
			AuthVO authVO = adminSystemmngtRootVO.getAuth();
			
			map = CommonConvertObjectToMap.ConverObjectToMap(authVO);
			
			List<AuthVO> list = authMenuMapper.selectAuthList(map);
			
			return list;
			
		} catch(Exception e) {
			
			throw e;
		}
	}
	
	@Transactional(readOnly=true)
	public List<MenuVO> selectMenuList(WqBaseBean ibean) throws Exception {
		HashMap<String, Object> map = new HashMap<String, Object>();
		
		try{
			AdminSystemmngtRootVO adminSystemmngtRootVO = (AdminSystemmngtRootVO) ibean;
			MenuVO menuVO = adminSystemmngtRootVO.getMenu();
			
			map = CommonConvertObjectToMap.ConverObjectToMap(menuVO);
			
			List<MenuVO> list = authMenuMapper.selectMenuList(map);
			
			return list;
			
		} catch(Exception e) {
			
			throw e;
		}
	}
	
	@Transactional(readOnly=true)
	public List<AuthMenuVO> selectAuthMenuList(WqBaseBean ibean) throws Exception {
		HashMap<String, Object> map = new HashMap<String, Object>();
		
		try{
			AdminSystemmngtRootVO adminSystemmngtRootVO = (AdminSystemmngtRootVO) ibean;
			AuthMenuVO authMenuVO = adminSystemmngtRootVO.getAuthMenu();
			
			map = CommonConvertObjectToMap.ConverObjectToMap(authMenuVO);
			
			List<AuthMenuVO> list = authMenuMapper.selectAuthMenuList(map);
			
			return list;
			
		} catch(Exception e) {
			
			throw e;
		}
	}

	@Transactional
	public int insertAuthMenu(WqBaseBean ibean) throws Exception {
		try {
			AdminSystemmngtRootVO adminSystemmngtRootVO = (AdminSystemmngtRootVO) ibean;
			AuthVO authVO = adminSystemmngtRootVO.getAuth();
			
			HashMap<String, Object> map = CommonConvertObjectToMap.ConverObjectToMap(authVO);
			
			return authMenuMapper.insertAuthMenu(map);
		} catch(Exception e){
			
			return 0;
		}
	}

	@Transactional
	public int updateAuthMenu(WqBaseBean ibean) throws Exception {
		try {
			AdminSystemmngtRootVO adminSystemmngtRootVO = (AdminSystemmngtRootVO) ibean;
			AuthVO authVO = adminSystemmngtRootVO.getAuth();
			
			HashMap<String, Object> map = CommonConvertObjectToMap.ConverObjectToMap(authVO);
			
			return authMenuMapper.updateAuthMenu(map);
		} catch(Exception e){
			
			return 0;
		}
	}

	@Transactional
	public int deleteAuthMenu(WqBaseBean ibean) throws Exception {
		try {
			AdminSystemmngtRootVO adminSystemmngtRootVO = (AdminSystemmngtRootVO) ibean;
			AuthVO authVO = adminSystemmngtRootVO.getAuth();
			
			HashMap<String, Object> map = CommonConvertObjectToMap.ConverObjectToMap(authVO);
			
			return authMenuMapper.deleteAuthMenu(map);
		} catch(Exception e){
			
			return 0;
		}
	}

	@Transactional
	public int saveAuthMenu(WqBaseBean ibean) throws Exception {
		try {
			AdminSystemmngtRootVO adminSystemmngtRootVO = (AdminSystemmngtRootVO) ibean;
			List<AuthMenuVO> authMenuList = adminSystemmngtRootVO.getAuthMenuList();
			
			log.debug("saveAuthMenu authMenuList SIZE " + authMenuList.size());
			
			for (int idx = 0, iCnt = authMenuList.size(); idx < iCnt; idx++) {
				AuthMenuVO authMenuVO = (AuthMenuVO) authMenuList.get(idx);
				
				HashMap<String, Object> map = CommonConvertObjectToMap.ConverObjectToMap(authMenuVO);
				log.debug("[IN MAP] saveAuthMenu:::" + map);
				String rowStatus = authMenuVO.getRowStatus();
				
				log.debug("saveAuthMenu rowStatus[" + idx + "]:::" + rowStatus);
				if (rowStatus.equalsIgnoreCase("U")) {
					authMenuMapper.updateAuthMenu(map);
				} else if (rowStatus.equalsIgnoreCase("D") || rowStatus.equalsIgnoreCase("E")) {
					authMenuMapper.deleteAuthMenu(map);
				} else if (rowStatus.equalsIgnoreCase("C")) {
					authMenuMapper.insertAuthMenu(map);
				}
			}
			
			return 1;
		} catch (Exception e) {	
			
			return 0;
		}
	}

}