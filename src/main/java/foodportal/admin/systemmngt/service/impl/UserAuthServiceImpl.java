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
import foodportal.admin.systemmngt.mapper.UserAuthMapper;
import foodportal.admin.systemmngt.service.UserAuthService;
import foodportal.admin.systemmngt.vo.AdminSystemmngtRootVO;
import foodportal.admin.systemmngt.vo.AuthVO;
import foodportal.admin.systemmngt.vo.MenuVO;
import foodportal.admin.systemmngt.vo.UserAuthMenuVO;
import foodportal.admin.systemmngt.vo.UserAuthVO;
import foodportal.admin.systemmngt.vo.UserVO;

/**
 * UserAuthServiceImpl
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

@Service("userAuthService")
public class UserAuthServiceImpl extends AbstractServiceImpl implements UserAuthService {

	@CommonLog Logger log;

	@Autowired
	UserAuthMapper userAuthMapper;
	
	@Transactional(readOnly=true)
	public List<UserVO> selectUserList(WqBaseBean ibean) throws Exception {
		HashMap<String, Object> map = new HashMap<String, Object>();
		
		try{
			AdminSystemmngtRootVO adminSystemmngtRootVO = (AdminSystemmngtRootVO) ibean;
			MenuVO menuVO = adminSystemmngtRootVO.getMenu();
			
			map = CommonConvertObjectToMap.ConverObjectToMap(menuVO);
			
			List<UserVO> list = userAuthMapper.selectUserList(map);
			
			return list;
			
		} catch(Exception e) {
			
			throw e;
		}
	}
	
	@Transactional(readOnly=true)
	public List<AuthVO> selectAuthList(WqBaseBean ibean) throws Exception {
		HashMap<String, Object> map = new HashMap<String, Object>();
		
		try{
			AdminSystemmngtRootVO adminSystemmngtRootVO = (AdminSystemmngtRootVO) ibean;
			AuthVO authVO = adminSystemmngtRootVO.getAuth();
			
			map = CommonConvertObjectToMap.ConverObjectToMap(authVO);
			
			List<AuthVO> list = userAuthMapper.selectAuthList(map);
			
			return list;
			
		} catch(Exception e) {
			
			throw e;
		}
	}
	
	@Transactional(readOnly=true)
	public List<UserAuthVO> selectUserAuthList(WqBaseBean ibean) throws Exception {
		HashMap<String, Object> map = new HashMap<String, Object>();
		
		try{
			AdminSystemmngtRootVO adminSystemmngtRootVO = (AdminSystemmngtRootVO) ibean;
			UserAuthVO userAuthVO = adminSystemmngtRootVO.getUserAuth();
			
			map = CommonConvertObjectToMap.ConverObjectToMap(userAuthVO);
			
			List<UserAuthVO> list = userAuthMapper.selectUserAuthList(map);
			
			return list;
			
		} catch(Exception e) {
			
			throw e;
		}
	}
	
	@Transactional(readOnly=true)
	public List<UserAuthMenuVO> selectUserAuthMenuList(WqBaseBean ibean) throws Exception {
		HashMap<String, Object> map = new HashMap<String, Object>();
		
		try{
			AdminSystemmngtRootVO adminSystemmngtRootVO = (AdminSystemmngtRootVO) ibean;
			UserAuthMenuVO userAuthMenuVO = adminSystemmngtRootVO.getUserAuthMenu();
			
			map = CommonConvertObjectToMap.ConverObjectToMap(userAuthMenuVO);
			
			List<UserAuthMenuVO> list = userAuthMapper.selectUserAuthMenuList(map);
			
			return list;
			
		} catch(Exception e) {
			
			throw e;
		}
	}

	@Transactional
	public int insertUserAuth(WqBaseBean ibean) throws Exception {
		try {
			AdminSystemmngtRootVO adminSystemmngtRootVO = (AdminSystemmngtRootVO) ibean;
			AuthVO authVO = adminSystemmngtRootVO.getAuth();
			
			HashMap<String, Object> map = CommonConvertObjectToMap.ConverObjectToMap(authVO);
			
			return userAuthMapper.insertUserAuth(map);
		} catch(Exception e){
			
			return 0;
		}
	}

	@Transactional
	public int updateUserAuth(WqBaseBean ibean) throws Exception {
		try {
			AdminSystemmngtRootVO adminSystemmngtRootVO = (AdminSystemmngtRootVO) ibean;
			AuthVO authVO = adminSystemmngtRootVO.getAuth();
			
			HashMap<String, Object> map = CommonConvertObjectToMap.ConverObjectToMap(authVO);
			
			return userAuthMapper.updateUserAuth(map);
		} catch(Exception e){
			
			return 0;
		}
	}

	@Transactional
	public int deleteUserAuth(WqBaseBean ibean) throws Exception {
		try {
			AdminSystemmngtRootVO adminSystemmngtRootVO = (AdminSystemmngtRootVO) ibean;
			AuthVO authVO = adminSystemmngtRootVO.getAuth();
			
			HashMap<String, Object> map = CommonConvertObjectToMap.ConverObjectToMap(authVO);
			
			return userAuthMapper.deleteUserAuth(map);
		} catch(Exception e){
			
			return 0;
		}
	}

	@Transactional
	public int saveUserAuth(WqBaseBean ibean) throws Exception {
		try {
			AdminSystemmngtRootVO adminSystemmngtRootVO = (AdminSystemmngtRootVO) ibean;
			List<UserAuthVO> userAuthList = adminSystemmngtRootVO.getUserAuthList();
			
			log.debug("saveUserAuth userAuthList SIZE " + userAuthList.size());
			
			for (int idx = 0, iCnt = userAuthList.size(); idx < iCnt; idx++) {
				UserAuthVO userAuthVO = (UserAuthVO) userAuthList.get(idx);
				
				HashMap<String, Object> map = CommonConvertObjectToMap.ConverObjectToMap(userAuthVO);
				log.debug("[IN MAP] saveUserAuth:::" + map);
				String rowStatus = userAuthVO.getRowStatus();
				
				log.debug("saveUserAuth rowStatus[" + idx + "]:::" + rowStatus);
				if (rowStatus.equalsIgnoreCase("U")) {
					userAuthMapper.updateUserAuth(map);
				} else if (rowStatus.equalsIgnoreCase("D") || rowStatus.equalsIgnoreCase("E")) {
					userAuthMapper.deleteUserAuth(map);
				} else if (rowStatus.equalsIgnoreCase("C")) {
					userAuthMapper.insertUserAuth(map);
				}
			}
			
			return 1;
		} catch (Exception e) {	
			
			return 0;
		}
	}

}