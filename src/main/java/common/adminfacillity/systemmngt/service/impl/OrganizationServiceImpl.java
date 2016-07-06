package common.adminfacillity.systemmngt.service.impl;

import java.util.HashMap;
import java.util.List;            
import java.util.Map;         

import javax.annotation.Resource;

import egovframework.rte.fdl.cmmn.AbstractServiceImpl;
import common.adminfacillity.systemmngt.service.AdminfacillitySystemmngtRootVO;
import common.adminfacillity.systemmngt.service.OrganizationService;
import common.adminfacillity.systemmngt.mapper.OrganizationMapper;
import common.adminfacillity.systemmngt.service.OrganizationVO;

import org.slf4j.Logger;

import common.commonfacillity.uia.WqBaseBean;
import common.commonfacillity.util.CommonConvertObjectToMap;
import common.commonfacillity.util.CommonStringUtil;
import common.commonfacillity.log.CommonLog;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * OrganizationService
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

@Service("organizationService")
public class OrganizationServiceImpl extends AbstractServiceImpl implements OrganizationService {

	@CommonLog Logger log;

	@Autowired
	OrganizationMapper organizationMapper;


	/* (non-Javadoc)
	 * @see common.adminfacillity.systemmngt.service.OrganizationService#selectOrganization(java.util.Map)
	 */
	@Transactional(readOnly=true)
	public List<OrganizationVO> selectOrganization(WqBaseBean ibean) throws Exception {
		HashMap<String, Object> map = new HashMap<String, Object>();
		try {
			AdminfacillitySystemmngtRootVO adminfacillitySystemmngtRootVo = (AdminfacillitySystemmngtRootVO) ibean;
			OrganizationVO organizationVO = adminfacillitySystemmngtRootVo.getOrganizationVO();
			
			map = CommonConvertObjectToMap.ConverObjectToMap(organizationVO);
			
			List<OrganizationVO> list = organizationMapper.selectOrganization(map);
			
			return list;
		} catch (Exception e) {
			
			throw e;
		}
	}

	/* (non-Javadoc)
	 * @see common.adminfacillity.systemmngt.service.OrganizationService#insertOrganization(java.util.Map)
	 */
	@Transactional
	public int insertOrganization(WqBaseBean ibean) throws Exception {
		HashMap<String, Object> map = new HashMap<String, Object>();
		int resultObj = 1;
		
		try {
			AdminfacillitySystemmngtRootVO adminfacillitySystemmngtRootVO = (AdminfacillitySystemmngtRootVO) ibean;
			OrganizationVO organizationVO = adminfacillitySystemmngtRootVO.getOrganizationVO();
			
			map = CommonConvertObjectToMap.ConverObjectToMap(organizationVO);
			
			return organizationMapper.insertOrganization(map);
		} catch (Exception e) {
			
			resultObj = 0;
			return resultObj;
		}
	}

	/* (non-Javadoc)
	 * @see common.adminfacillity.systemmngt.service.OrganizationService#updateOrganization(java.util.Map)
	 */
	@Transactional
	public int updateOrganization(WqBaseBean ibean) throws Exception {
		HashMap<String, Object> map = new HashMap<String, Object>();
		int resultObj = 1;
		
		try {
			AdminfacillitySystemmngtRootVO adminfacillitySystemmngtRootVO = (AdminfacillitySystemmngtRootVO) ibean;
			OrganizationVO organizationVO = adminfacillitySystemmngtRootVO.getOrganizationVO();
			
			map = CommonConvertObjectToMap.ConverObjectToMap(organizationVO);
			
			return organizationMapper.updateOrganization(map);
		} catch (Exception e) {
			
			resultObj = 0;
			return resultObj;
		}
	}

	/* (non-Javadoc)
	 * @see common.adminfacillity.systemmngt.service.OrganizationService#deleteOrganization(java.util.Map)
	 */
	@Transactional
	public int deleteOrganization(WqBaseBean ibean) throws Exception {
		HashMap<String, Object> map = new HashMap<String, Object>();
		int resultObj = 1;
		
		try {
			AdminfacillitySystemmngtRootVO adminfacillitySystemmngtRootVO = (AdminfacillitySystemmngtRootVO) ibean;
			OrganizationVO organizationVO = adminfacillitySystemmngtRootVO.getOrganizationVO();
			
			map = CommonConvertObjectToMap.ConverObjectToMap(organizationVO);
			
			return organizationMapper.deleteOrganization(map);
		} catch (Exception e) {
			
			resultObj = 0;
			return resultObj;
		}
	}
}