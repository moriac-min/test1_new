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
import foodportal.admin.systemmngt.mapper.EnterpriseMapper;
import foodportal.admin.systemmngt.service.EnterpriseService;
import foodportal.admin.systemmngt.vo.AdminSystemmngtRootVO;
import foodportal.admin.systemmngt.vo.EnterpriseMemberVO;
import foodportal.admin.systemmngt.vo.EnterpriseVO;

/**
 * EnterpriseServiceImpl
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

@Service("enterpriseService")
public class EnterpriseServiceImpl extends AbstractServiceImpl implements EnterpriseService {

	@CommonLog Logger log;

	@Autowired
	EnterpriseMapper enterpriseMapper;
	
	@Transactional(readOnly=true)
	public List<EnterpriseVO> selectEnterpriseList(WqBaseBean ibean) throws Exception {
		HashMap<String, Object> map = new HashMap<String, Object>();
		
		try{
			AdminSystemmngtRootVO adminSystemmngtRootVO = (AdminSystemmngtRootVO) ibean;
			EnterpriseVO enterpriseVO = adminSystemmngtRootVO.getEnterprise();
			
			map = CommonConvertObjectToMap.ConverObjectToMap(enterpriseVO);
			
			List<EnterpriseVO> list = enterpriseMapper.selectEnterpriseList(map);
			
			return list;
			
		} catch(Exception e) {
			
			throw e;
		}
	}
	
	@Transactional(readOnly=true)
	public List<EnterpriseMemberVO> selectEnterpriseMemberList(WqBaseBean ibean) throws Exception {
		HashMap<String, Object> map = new HashMap<String, Object>();
		
		try{
			AdminSystemmngtRootVO adminSystemmngtRootVO = (AdminSystemmngtRootVO) ibean;
			EnterpriseMemberVO enterpriseMemberVO = adminSystemmngtRootVO.getEnterpriseMember();
			
			map = CommonConvertObjectToMap.ConverObjectToMap(enterpriseMemberVO);
			
			List<EnterpriseMemberVO> list = enterpriseMapper.selectEnterpriseMemberList(map);
			
			return list;
			
		} catch(Exception e) {
			
			throw e;
		}
	}

}