package common.adminfacillity.systemmngt.service.impl;

import java.util.HashMap;
import java.util.List;            
import java.util.Map;         
import javax.annotation.Resource;

import egovframework.rte.fdl.cmmn.AbstractServiceImpl;

import common.adminfacillity.systemmngt.service.SystemAccessLogService;
import common.adminfacillity.systemmngt.mapper.SystemAccessLogMapper;
import common.adminfacillity.systemmngt.service.SystemAccessLogVO;

import org.slf4j.Logger;

import common.commonfacillity.util.CommonStringUtil;
import common.commonfacillity.log.CommonLog;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * SystemAccessLogService
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

@Service("systemAccessLogService")
public class SystemAccessLogServiceImpl extends AbstractServiceImpl implements SystemAccessLogService {

	@CommonLog Logger log;

	@Autowired
	SystemAccessLogMapper systemAccessLogMapper;


	/* (non-Javadoc)
	 * @see common.adminfacillity.systemmngt.service.SystemAccessLogService#selectSystemAccessLog(java.util.Map)
	 */
	@Transactional(readOnly=true)
	public List<SystemAccessLogVO> selectSystemAccessLog(Map<String,Object> map) throws Exception {
//		List<SystemAccessLogVO>
		 //TODO selectSystemAccessLog 메소드 구현
		
//		return resultObj;
		return null;
	}
}