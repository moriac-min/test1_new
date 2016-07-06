package common.adminfacillity.systemmngt.service.impl;

import java.util.HashMap;
import java.util.List;            
import java.util.Map;         

import javax.annotation.Resource;

import egovframework.rte.fdl.cmmn.AbstractServiceImpl;
import common.adminfacillity.systemmngt.service.ProgramService;
import common.adminfacillity.systemmngt.mapper.ProgramMapper;
import common.adminfacillity.systemmngt.service.ProgramVO;
import common.adminfacillity.systemmngt.service.AdminfacillitySystemmngtRootVO;

import org.slf4j.Logger;

import common.commonfacillity.util.CommonConvertObjectToMap;
import common.commonfacillity.util.CommonStringUtil;
import common.commonfacillity.log.CommonLog;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import common.commonfacillity.uia.WqBaseBean;

/**
 * ProgramService
 * @author 유승엽
 * @since 2014.08.18
 * @version 1.0
 * @see
 * 
 * <pre>
 *  Modification Information
 *  수정일      수정자   수정내용
 *  ---------- -------- ---------------------------
 *  2014.08.18 유승엽 최초 생성
 * </pre>
 * 
 * Copyright (C) 2014 by NDS., All right reserved.
 */

@Service("programService")
public class ProgramServiceImpl extends AbstractServiceImpl implements ProgramService {

	@CommonLog Logger log;

	@Autowired
	ProgramMapper programMapper;


	/* (non-Javadoc)
	 * @see common.adminfacillity.systemmngt.service.ProgramService#selectProgram(java.util.Map)
	 */
	@Transactional(readOnly=true)
	public List<ProgramVO> selectProgram(WqBaseBean ibean) throws Exception {
		HashMap<String, Object> map = new HashMap<String, Object>();
		
		try{
			AdminfacillitySystemmngtRootVO sVo = (AdminfacillitySystemmngtRootVO) ibean;
			ProgramVO inUserVo = sVo.getProgramVO();
			
			log.debug("[IN] selectProgram:::" + inUserVo);
			
			map = CommonConvertObjectToMap.ConverObjectToMap(inUserVo);
			log.debug("[IN MAP] selectProgram:::" + map);
			List<ProgramVO> list = programMapper.selectProgram(map);
			
			return list;	
			
		}catch(Exception e){
			
			throw e;
		}
	}

	/* (non-Javadoc)
	 * @see common.adminfacillity.systemmngt.service.ProgramService#saveProgram(java.util.Map)
	 */
	@Transactional
	public int saveProgram(WqBaseBean ibean) throws Exception {
		HashMap<String, Object> map = new HashMap<String, Object>();
		try {
			AdminfacillitySystemmngtRootVO sVo = (AdminfacillitySystemmngtRootVO) ibean;
			List<ProgramVO> programList = sVo.getInfoList();
			ProgramVO programVo;
			String rowStatus;
			
			log.debug("saveProgram programList SIZE " + programList.size());
			log.debug("saveProgram programList.data " + programList.get(0));
			for (int idx = 0, iCnt = programList.size(); idx < iCnt; idx++) {
				programVo = (ProgramVO) programList.get(idx);
				map = CommonConvertObjectToMap.ConverObjectToMap(programVo);
				log.debug("[IN MAP] saveProgram:::" + map);
				rowStatus = programVo.getRowStatus();
				
				if (rowStatus.equalsIgnoreCase("U")) {
					programMapper.updateProgram(map);
				} else if (rowStatus.equalsIgnoreCase("D") || rowStatus.equalsIgnoreCase("E")) {
					programMapper.deleteProgram(map);
				} else if (rowStatus.equalsIgnoreCase("I") || rowStatus.equalsIgnoreCase("C")) {
					programMapper.insertProgram(map);
				}
			}
			
			return 1;
		} catch (Exception e) {	
			
			return 0;
		}
	}
	
	/* (non-Javadoc)
	 * @see common.adminfacillity.systemmngt.service.ProgramService#insertProgram(java.util.Map)
	 */
	@Transactional
	public int insertProgram(Map<String,Object> map) throws Exception {
		int resultObj = 0;
		 //TODO insertProgram 메소드 구현
		
		return resultObj;
	}

	/* (non-Javadoc)
	 * @see common.adminfacillity.systemmngt.service.ProgramService#updateProgram(java.util.Map)
	 */
	@Transactional
	public int updateProgram(Map<String,Object> map) throws Exception {
		int resultObj = 0;
		 //TODO updateProgram 메소드 구현
		
		return resultObj;
	}

	/* (non-Javadoc)
	 * @see common.adminfacillity.systemmngt.service.ProgramService#deleteProgram(java.util.Map)
	 */
	@Transactional
	public int deleteProgram(Map<String,Object> map) throws Exception {
		int resultObj = 0;
		 //TODO deleteProgram 메소드 구현
		
		return resultObj;
	}
}