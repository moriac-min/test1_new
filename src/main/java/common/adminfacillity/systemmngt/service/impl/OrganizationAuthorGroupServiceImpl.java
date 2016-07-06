package common.adminfacillity.systemmngt.service.impl;

import java.util.HashMap;
import java.util.List;            
import java.util.Map;         

import javax.annotation.Resource;

import egovframework.rte.fdl.cmmn.AbstractServiceImpl;
import common.adminfacillity.systemmngt.service.OrganizationAuthorGroupService;
import common.adminfacillity.systemmngt.mapper.OrganizationAuthorGroupMapper;
import common.adminfacillity.systemmngt.service.AdminfacillitySystemmngtRootVO;
import common.adminfacillity.systemmngt.service.OrganizationAuthorGroupVO;
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
 * OrganizationAuthorGroupService
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

@Service("organizationAuthorGroupService")
public class OrganizationAuthorGroupServiceImpl extends AbstractServiceImpl implements OrganizationAuthorGroupService {

	@CommonLog Logger log;

	@Autowired
	OrganizationAuthorGroupMapper organizationAuthorGroupMapper;


	/* (non-Javadoc)
	 * @see common.adminfacillity.systemmngt.service.OrganizationAuthorGroupService#selectOrganizationAuthorGroup(java.util.Map)
	 */
	@Transactional(readOnly=true)
	public List<OrganizationAuthorGroupVO> selectOrganizationAuthorGroup(WqBaseBean ibean) throws Exception {
		HashMap<String, Object> map = new HashMap<String, Object>();
		try {
			AdminfacillitySystemmngtRootVO adminfacillitySystemmngtRootVo = (AdminfacillitySystemmngtRootVO) ibean;
			OrganizationAuthorGroupVO organizationAuthorGroupVO =  adminfacillitySystemmngtRootVo.getOrganizationAuthorGroupVO();
			
			map = CommonConvertObjectToMap.ConverObjectToMap(organizationAuthorGroupVO);
			
			List<OrganizationAuthorGroupVO> list = organizationAuthorGroupMapper.selectOrganizationAuthorGroup(map);
			
			return list;
		} catch (Exception e) {
			
			throw e;
		}
	}

	/* (non-Javadoc)
	 * @see common.adminfacillity.systemmngt.service.OrganizationAuthorGroupService#selectNoneRegAuthorGroup(java.util.Map)
	 */
	@Transactional(readOnly=true)
	public List<AuthorGroupVO> selectNoneRegAuthorGroup(WqBaseBean ibean) throws Exception {
		HashMap<String, Object> map = new HashMap<String, Object>();
		try {
			AdminfacillitySystemmngtRootVO adminfacillitySystemmngtRootVo = (AdminfacillitySystemmngtRootVO) ibean;
			AuthorGroupVO authorGroupVO = adminfacillitySystemmngtRootVo.getAuthorGroupVO();
			
			map = CommonConvertObjectToMap.ConverObjectToMap(authorGroupVO);
			
			List<AuthorGroupVO> list = organizationAuthorGroupMapper.selectNoneRegAuthorGroup(map);
			log.debug("[selectAuthorGroup]list size ::: " + list.size());
			
			return list;
		} catch (Exception e) {
			
			throw e;
		}
	}
	
	/* (non-Javadoc)
	 * @see common.adminfacillity.systemmngt.service.OrganizationAuthorGroupService#saveOrganizationAuthorGroup(java.util.Map)
	 */
	@Transactional
	public int saveOrganizationAuthorGroup(WqBaseBean ibean) throws Exception {
		HashMap<String, Object> map = new HashMap<String, Object>();
		int resultObj = 1;
		String rowStatus = "";
		
		try {
			AdminfacillitySystemmngtRootVO adminfacillitySystemmngtRootVo = (AdminfacillitySystemmngtRootVO) ibean;
			List infoList = adminfacillitySystemmngtRootVo.getInfoList();
			OrganizationAuthorGroupVO organizationAuthorGroupVO;
			
			/**
			 * Insert
			 */
			for(int idx = 0, iCnt = infoList.size(); idx < iCnt ; idx++){
				organizationAuthorGroupVO = (OrganizationAuthorGroupVO) infoList.get(idx);
				rowStatus = organizationAuthorGroupVO.getRowStatus();
				
				if(rowStatus.equalsIgnoreCase("C")){
					map = CommonConvertObjectToMap.ConverObjectToMap(organizationAuthorGroupVO);
					organizationAuthorGroupMapper.insertOrganizationAuthorGroup(map);
				}
			}
			
			/**
			 * Delete
			 */
			for(int idx = 0, iCnt = infoList.size(); idx < iCnt ; idx++){
				organizationAuthorGroupVO = (OrganizationAuthorGroupVO) infoList.get(idx);
				rowStatus = organizationAuthorGroupVO.getRowStatus();
				
				if (rowStatus.equalsIgnoreCase("D") || rowStatus.equalsIgnoreCase("E")) {
					map = CommonConvertObjectToMap.ConverObjectToMap(organizationAuthorGroupVO);
					organizationAuthorGroupMapper.deleteOrganizationAuthorGroup(map);
				}
			}
			
			return resultObj;
		} catch (Exception e) {
			
			resultObj = 0;
			return resultObj;
		}
	}
	
	/* (non-Javadoc)
	 * @see common.adminfacillity.systemmngt.service.OrganizationAuthorGroupService#insertOrganizationAuthorGroup(java.util.Map)
	 */
	@Transactional
	public int insertOrganizationAuthorGroup(WqBaseBean ibean) throws Exception {
		HashMap<String, Object> map = new HashMap<String, Object>();
		int resultObj = 1;
		
		try {
			AdminfacillitySystemmngtRootVO adminfacillitySystemmngtRootVO = (AdminfacillitySystemmngtRootVO) ibean;
			OrganizationAuthorGroupVO organizationAuthorGroupVO = adminfacillitySystemmngtRootVO.getOrganizationAuthorGroupVO();
			
			map = CommonConvertObjectToMap.ConverObjectToMap(organizationAuthorGroupVO);
			
			return organizationAuthorGroupMapper.insertOrganizationAuthorGroup(map);
		} catch (Exception e) {
			
			resultObj = 0;
			return resultObj;
		}
	}

	/* (non-Javadoc)
	 * @see common.adminfacillity.systemmngt.service.OrganizationAuthorGroupService#deleteOrganizationAuthorGroup(java.util.Map)
	 */
	@Transactional
	public int deleteOrganizationAuthorGroup(WqBaseBean ibean) throws Exception {
		HashMap<String, Object> map = new HashMap<String, Object>();
		int resultObj = 1;
		
		try {
			AdminfacillitySystemmngtRootVO adminfacillitySystemmngtRootVO = (AdminfacillitySystemmngtRootVO) ibean;
			OrganizationAuthorGroupVO organizationAuthorGroupVO = adminfacillitySystemmngtRootVO.getOrganizationAuthorGroupVO();
			
			map = CommonConvertObjectToMap.ConverObjectToMap(organizationAuthorGroupVO);
			
			return organizationAuthorGroupMapper.deleteOrganizationAuthorGroup(map);
		} catch (Exception e) {
			
			resultObj = 0;
			return resultObj;
		}
	}
}