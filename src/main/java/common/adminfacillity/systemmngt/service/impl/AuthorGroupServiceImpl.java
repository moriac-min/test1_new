package common.adminfacillity.systemmngt.service.impl;

import java.util.HashMap;
import java.util.List;            
import java.util.Map;         

import javax.annotation.Resource;

import egovframework.rte.fdl.cmmn.AbstractServiceImpl;
import common.adminfacillity.systemmngt.service.AdminfacillitySystemmngtRootVO;
import common.adminfacillity.systemmngt.service.AuthorGroupService;
import common.adminfacillity.systemmngt.mapper.AuthorGroupMapper;
import common.adminfacillity.systemmngt.service.AuthorGroupVO;

import org.slf4j.Logger;

import common.commonfacillity.uia.WqBaseBean;
import common.commonfacillity.util.CommonConvertObjectToMap;
import common.commonfacillity.util.CommonStringUtil;
import common.commonfacillity.log.CommonLog;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * AuthorGroupService
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

@Service("authorGroupService")
public class AuthorGroupServiceImpl extends AbstractServiceImpl implements AuthorGroupService {

	@CommonLog Logger log;

	@Autowired
	AuthorGroupMapper authorGroupMapper;

	/* (non-Javadoc)
	 * @see common.adminfacillity.systemmngt.service.AuthorGroupService#selectAuthorGroup(WqBaseBean)
	 */
	@Transactional(readOnly=true)
	public List<AuthorGroupVO> selectAuthorGroup(WqBaseBean ibean) throws Exception {
		HashMap<String, Object> map = new HashMap<String, Object>();
		try {
			AdminfacillitySystemmngtRootVO adminfacillitySystemmngtRootVo = (AdminfacillitySystemmngtRootVO) ibean;
			AuthorGroupVO authorGroupVO = adminfacillitySystemmngtRootVo.getAuthorGroupVO();
			
			map = CommonConvertObjectToMap.ConverObjectToMap(authorGroupVO);
			
			List<AuthorGroupVO> list = authorGroupMapper.selectAuthorGroup(map);
			log.debug("[selectAuthorGroup]list size ::: " + list.size());
			
			return list;
		} catch (Exception e) {
			
			throw e;
		}
	}
	
	/* (non-Javadoc)
	 * @see common.adminfacillity.systemmngt.service.AuthorGroupService#saveAuthorGroup(WqBaseBean)
	 */
	@Transactional
	public int saveAuthorGroup(WqBaseBean ibean) throws Exception {
		HashMap<String, Object> map = new HashMap<String, Object>();
		int resultObj = 1;
		String rowStatus = "";
		
		try {
			AdminfacillitySystemmngtRootVO adminfacillitySystemmngtRootVo = (AdminfacillitySystemmngtRootVO) ibean;
			List infoList = adminfacillitySystemmngtRootVo.getInfoList();
			AuthorGroupVO authorGroupVO;
			
			/**
			 * Insert
			 */
			for(int idx = 0, iCnt = infoList.size(); idx < iCnt ; idx++){
				authorGroupVO = (AuthorGroupVO) infoList.get(idx);
				map = CommonConvertObjectToMap.ConverObjectToMap(authorGroupVO);
				rowStatus = authorGroupVO.getRowStatus();
				
				if(rowStatus.equalsIgnoreCase("C")){
					authorGroupMapper.insertAuthorGroup(map);
				}
			}
			
			/**
			 * Update
			 */
			for(int idx = 0, iCnt = infoList.size(); idx < iCnt ; idx++){
				authorGroupVO = (AuthorGroupVO) infoList.get(idx);
				map = CommonConvertObjectToMap.ConverObjectToMap(authorGroupVO);
				rowStatus = authorGroupVO.getRowStatus();
				
				if(rowStatus.equalsIgnoreCase("U")){
					authorGroupMapper.updateAuthorGroup(map);
				}
			}
			
			/**
			 * Delete
			 */
			for(int idx = 0, iCnt = infoList.size(); idx < iCnt ; idx++){
				authorGroupVO = (AuthorGroupVO) infoList.get(idx);
				map = CommonConvertObjectToMap.ConverObjectToMap(authorGroupVO);
				rowStatus = authorGroupVO.getRowStatus();
				
				if (rowStatus.equalsIgnoreCase("D") || rowStatus.equalsIgnoreCase("E")) {
					authorGroupMapper.deleteAuthorGroup(map);
				}
				//TODO
				//추후 권한 그룹데이터와 연동된 데이터의 삭제처리 로직이 들어가야함(20140827)
				
			}
			
			return resultObj;
		} catch (Exception e) {
			
			resultObj = 0;
			return resultObj;
		}
	}

	/* (non-Javadoc)
	 * @see common.adminfacillity.systemmngt.service.AuthorGroupService#updateAuthorGroup(WqBaseBean)
	 */
	@Transactional
	public int updateAuthorGroup(WqBaseBean ibean) throws Exception {
		HashMap<String, Object> map = new HashMap<String, Object>();
		int resultObj = 1;
		
		try {
			AdminfacillitySystemmngtRootVO adminfacillitySystemmngtRootVO = (AdminfacillitySystemmngtRootVO) ibean;
			AuthorGroupVO authorGroupVO = adminfacillitySystemmngtRootVO.getAuthorGroupVO();
			
			map = CommonConvertObjectToMap.ConverObjectToMap(authorGroupVO);
			
			return authorGroupMapper.updateAuthorGroup(map);
		} catch (Exception e) {
			
			resultObj = 0;
			return resultObj;
		}
	}	

	/* (non-Javadoc)
	 * @see common.adminfacillity.systemmngt.service.AuthorGroupService#insertAuthorGroup(WqBaseBean)
	 */
	@Transactional
	public int insertAuthorGroup(WqBaseBean ibean) throws Exception {
		HashMap<String, Object> map = new HashMap<String, Object>();
		int resultObj = 1;
		try{
			AdminfacillitySystemmngtRootVO adminfacillitySystemmngtRootVO = (AdminfacillitySystemmngtRootVO) ibean;
			AuthorGroupVO authorGroupVO = adminfacillitySystemmngtRootVO.getAuthorGroupVO();
			
			map = CommonConvertObjectToMap.ConverObjectToMap(authorGroupVO);
			
			return authorGroupMapper.insertAuthorGroup(map);
		} catch (Exception e) {
			
			resultObj = 0;
			return resultObj;
		}
	}

	/* (non-Javadoc)
	 * @see common.adminfacillity.systemmngt.service.AuthorGroupService#deleteAuthorGroup(WqBaseBean)
	 */
	@Transactional
	public int deleteAuthorGroup(WqBaseBean ibean) throws Exception {
		HashMap<String, Object> map = new HashMap<String, Object>();
		int resultObj = 1;
		
		try {
			AdminfacillitySystemmngtRootVO adminfacillitySystemmngtRootVO = (AdminfacillitySystemmngtRootVO) ibean;
			AuthorGroupVO authorGroupVO = adminfacillitySystemmngtRootVO.getAuthorGroupVO();
			
			map = CommonConvertObjectToMap.ConverObjectToMap(authorGroupVO);
			
			return authorGroupMapper.deleteAuthorGroup(map);
		} catch (Exception e) {
			
			resultObj = 0;
			return resultObj;
		}
	}
}