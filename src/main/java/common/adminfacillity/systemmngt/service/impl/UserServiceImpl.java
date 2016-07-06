package common.adminfacillity.systemmngt.service.impl;

import java.util.HashMap;
import java.util.List;            
import java.util.Map;         

import javax.annotation.Resource;

import egovframework.rte.fdl.cmmn.AbstractServiceImpl;
import common.adminfacillity.systemmngt.service.AdminfacillitySystemmngtRootVO;
import common.adminfacillity.systemmngt.service.ProgramVO;
import common.adminfacillity.systemmngt.service.UserService;
import common.adminfacillity.systemmngt.mapper.UserMapper;
import common.adminfacillity.systemmngt.service.UserVO;

import org.slf4j.Logger;

import common.commonfacillity.uia.WqBaseBean;
import common.commonfacillity.util.CommonConvertObjectToMap;
import common.commonfacillity.util.CommonStringUtil;
import common.commonfacillity.log.CommonLog;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * UserService
 * @author 유승엽
 * @since 2014.08.19
 * @version 1.0
 * @see
 * 
 * <pre>
 *  Modification Information
 *  수정일      수정자   수정내용
 *  ---------- -------- ---------------------------
 *  2014.08.19 유승엽 최초 생성
 * </pre>
 * 
 * Copyright (C) 2014 by NDS., All right reserved.
 */

@Service("userService")
public class UserServiceImpl extends AbstractServiceImpl implements UserService {

	@CommonLog Logger log;

	@Autowired
	UserMapper userMapper;


	/* (non-Javadoc)
	 * @see common.adminfacillity.systemmngt.service.UserService#selectUser(java.util.Map)
	 */
	@Transactional(readOnly=true)
	public List<UserVO> selectUser(WqBaseBean ibean) throws Exception {
		HashMap<String, Object> map = new HashMap<String, Object>();
		
		try{
			AdminfacillitySystemmngtRootVO sVo = (AdminfacillitySystemmngtRootVO) ibean;
			UserVO inUserVo = sVo.getUserVO();
			
			log.debug("[IN] selectUser:::" + inUserVo);
			
			map = CommonConvertObjectToMap.ConverObjectToMap(inUserVo);
			log.debug("[IN MAP] selectUser:::" + map);
			List<UserVO> list = userMapper.selectUser(map);
			
			return list;	
			
		}catch(Exception e){
			
			throw e;
		}
	}

	/* (non-Javadoc)
	 * @see common.adminfacillity.systemmngt.service.UserService#saveUser(java.util.Map)
	 */
	@Transactional
	public int saveUser(WqBaseBean ibean) throws Exception {
		HashMap<String, Object> map = new HashMap<String, Object>();
		try {
			AdminfacillitySystemmngtRootVO sVo = (AdminfacillitySystemmngtRootVO) ibean;
			List userList = sVo.getInfoList();
			UserVO userVo;
			String rowStatus;
			
			log.debug("saveUser userList SIZE " + userList.size());
			log.debug("saveUser userList.data " + userList.get(0));
			for (int idx = 0, iCnt = userList.size(); idx < iCnt; idx++) {
				userVo = (UserVO) userList.get(idx);
				map = CommonConvertObjectToMap.ConverObjectToMap(userVo);
				log.debug("[IN MAP] saveUser:::" + map);
				rowStatus = userVo.getRowStatus();
				
				if (rowStatus.equalsIgnoreCase("U")) {
					userMapper.updateUser(map);
				} else if (rowStatus.equalsIgnoreCase("I") || rowStatus.equalsIgnoreCase("C")) {
					userMapper.insertUser(map);
				}
			}
			
			return 1;
		} catch (Exception e) {	
			
			return 0;
		}
	}
	
	/* (non-Javadoc)
	 * @see common.adminfacillity.systemmngt.service.UserService#insertUser(java.util.Map)
	 */
	@Transactional
	public int insertUser(Map<String,Object> map) throws Exception {
		int resultObj = 0;
		 //TODO insertUser 메소드 구현
		
		return resultObj;
	}

	/* (non-Javadoc)
	 * @see common.adminfacillity.systemmngt.service.UserService#initPassword(java.util.Map)
	 */
	@Transactional
	public int initPassword(Map<String,Object> map) throws Exception {
		int resultObj = 0;
		 //TODO initPassword 메소드 구현
		
		return resultObj;
	}

	/* (non-Javadoc)
	 * @see common.adminfacillity.systemmngt.service.UserService#updateUser(java.util.Map)
	 */
	@Transactional
	public int updateUser(Map<String,Object> map) throws Exception {
		int resultObj = 0;
		 //TODO updateUser 메소드 구현
		
		return resultObj;
	}
}