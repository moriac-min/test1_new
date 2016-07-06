package common.adminfacillity.systemmngt.service.impl;

import java.util.HashMap;
import java.util.List;            
import java.util.Map;         
import javax.annotation.Resource;

import egovframework.rte.fdl.cmmn.AbstractServiceImpl;

import common.adminfacillity.systemmngt.service.CommonComboService;
import common.adminfacillity.systemmngt.mapper.CommonComboMapper;
import common.adminfacillity.systemmngt.service.CommonComboVO;

import org.slf4j.Logger;

import common.commonfacillity.util.CommonStringUtil;
import common.commonfacillity.log.CommonLog;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * CommonComboService
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

@Service("commonComboService")
public class CommonComboServiceImpl extends AbstractServiceImpl implements CommonComboService {

	@CommonLog Logger log;

	@Autowired
	CommonComboMapper commonComboMapper;


	/* (non-Javadoc)
	 * @see common.adminfacillity.systemmngt.service.CommonComboService#selectCommonCombo(java.util.Map)
	 */
	@Transactional(readOnly=true)
	public List<CommonComboVO> selectCommonCombo(Map<String,Object> map) throws Exception {
//		List<CommonComboVO>
		 //TODO selectCommonCombo 메소드 구현
		
//		return resultObj;
		return null;
	}

	/* (non-Javadoc)
	 * @see common.adminfacillity.systemmngt.service.CommonComboService#insertCommonCombo(java.util.Map)
	 */
	@Transactional
	public int insertCommonCombo(Map<String,Object> map) throws Exception {
		int resultObj = 0;
		 //TODO insertCommonCombo 메소드 구현
		
		return resultObj;
	}

	/* (non-Javadoc)
	 * @see common.adminfacillity.systemmngt.service.CommonComboService#deleteCommonCombo(java.util.Map)
	 */
	@Transactional
	public int deleteCommonCombo(Map<String,Object> map) throws Exception {
		int resultObj = 0;
		 //TODO deleteCommonCombo 메소드 구현
		
		return resultObj;
	}

	/* (non-Javadoc)
	 * @see common.adminfacillity.systemmngt.service.CommonComboService#updateCommonCombo(java.util.Map)
	 */
	@Transactional
	public int updateCommonCombo(Map<String,Object> map) throws Exception {
		int resultObj = 0;
		 //TODO updateCommonCombo 메소드 구현
		
		return resultObj;
	}
}