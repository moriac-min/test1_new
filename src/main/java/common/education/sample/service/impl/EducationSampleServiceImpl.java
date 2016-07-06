package common.education.sample.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import common.commonfacillity.log.CommonLog;
import common.commonfacillity.uia.WqBaseBean;
import common.commonfacillity.util.CommonConvertObjectToMap;
import common.education.sample.mapper.EducationSampleMapper;
import common.education.sample.service.EducationSampleRootVO;
import common.education.sample.service.EducationSampleService;
import common.education.sample.service.EducationSampleVO;
import egovframework.rte.fdl.cmmn.AbstractServiceImpl;

/**
 * EdusaServiceImpl
 * @author 김지현
 * @since 2012.12.05
 * @version 1.0
 * @see
 *
 * <pre>
 *  Modification Information
 *  수정일      수정자   수정내용
 *  ---------- -------- ---------------------------
 *  2012.12.05 김지현   최초 생성
 * </pre>
 *
 * Copyright (C) 2012 by NDS., All right reserved.
 */

@Service("educationSampleService")
public class EducationSampleServiceImpl extends AbstractServiceImpl implements EducationSampleService {
	
	@CommonLog Logger log;
	
	@Autowired
	EducationSampleMapper educationSampleMapper;
	
	/* (non-Javadoc)
	 * @see common.education.sample.service.EdusaService#selectEduSawonList(common.commonfacillity.uia.WqBaseBean)
	 */
	@Transactional(readOnly=true)
	public List<EducationSampleVO> selectEduSawonList(WqBaseBean ibean) throws Exception {
		HashMap<String, Object> map = new HashMap<String, Object>();
		
		try{
			EducationSampleRootVO sVo = (EducationSampleRootVO) ibean;
			EducationSampleVO inUserVo = sVo.getEducationSampleVO();
			
			log.debug("[IN] selectEduSawonList:::" + inUserVo);
			
			map = CommonConvertObjectToMap.ConverObjectToMap(inUserVo);
			log.debug("[IN MAP] selectEduSawonList:::" + map);
			List<EducationSampleVO> list = educationSampleMapper.selectEduSawonList(map);
			
			return list;
		}catch(Exception e){
			
			throw e;
		}
	}
	
	/* (non-Javadoc)
	 * @see common.education.sample.service.EdusaService#saveEduSawon(common.commonfacillity.uia.WqBaseBean)
	 */
	@Transactional
	public int saveEduSawon(WqBaseBean ibean) throws Exception {
		HashMap<String, Object> map = new HashMap<String, Object>();
		try {
			EducationSampleRootVO sVo = (EducationSampleRootVO) ibean;
			List<EducationSampleVO> educationSampleList = sVo.getEducationSampleList();
			EducationSampleVO educationSampleVo;
			String rowStatus;
			
			log.debug("saveEduSawon educationSampleList SIZE " + educationSampleList.size());
			
			for (int idx = 0, iCnt = educationSampleList.size(); idx < iCnt; idx++) {
				educationSampleVo = (EducationSampleVO) educationSampleList.get(idx);
				map = CommonConvertObjectToMap.ConverObjectToMap(educationSampleVo);
				log.debug("[IN MAP] saveEduSawon:::" + map);
				rowStatus = educationSampleVo.getRowStatus();
				
				log.debug("saveEduSawon rowStatus[" + idx + "]:::" + rowStatus);
				if (rowStatus.equalsIgnoreCase("U")) {
					educationSampleMapper.updateEduSawon(map);
				} else if (rowStatus.equalsIgnoreCase("D") || rowStatus.equalsIgnoreCase("E")) {
					educationSampleMapper.deleteEduSawon(map);
				} else if (rowStatus.equalsIgnoreCase("C")) {
					educationSampleMapper.insertEduSawon(map);
				}
			}
			
			return 1;
		} catch (Exception e) {	
			
			return 0;
		}
	}
	
	/* (non-Javadoc)
	 * @see common.education.sample.service.EdusaService#insertEduSawon(common.commonfacillity.uia.WqBaseBean)
	 */
	@Transactional
	public int insertEduSawon(WqBaseBean ibean) throws Exception {
		HashMap<String, Object> map = new HashMap<String, Object>();
		try {
			EducationSampleRootVO sVo = (EducationSampleRootVO) ibean;
			EducationSampleVO educationSampleVo = sVo.getEducationSampleVO();
			
			map = CommonConvertObjectToMap.ConverObjectToMap(educationSampleVo);
			log.debug("[IN MAP] insertEduSawon:::" + map);
			
			return educationSampleMapper.insertEduSawon(map);
		} catch (Exception e) {	
			
			return 0;
		}
	}
	
	/* (non-Javadoc)
	 * @see common.education.sample.service.EdusaService#updateEduSawon(common.commonfacillity.uia.WqBaseBean)
	 */
	@Transactional
	public int updateEduSawon(WqBaseBean ibean) throws Exception {
		HashMap<String, Object> map = new HashMap<String, Object>();
		
		try {
			EducationSampleRootVO sVo = (EducationSampleRootVO) ibean;
			EducationSampleVO educationSampleVo = sVo.getEducationSampleVO();
			
			map = CommonConvertObjectToMap.ConverObjectToMap(educationSampleVo);
			log.debug("[IN MAP] updateEduSawon:::" + map);
			return educationSampleMapper.updateEduSawon(map);
		} catch (Exception e) {	
			
			return 0;
		}
	}
	
	/* (non-Javadoc)
	 * @see common.education.sample.service.EdusaService#deleteEduSawon(common.commonfacillity.uia.WqBaseBean)
	 */
	@Transactional
	public int deleteEduSawon(WqBaseBean ibean) throws Exception {
		HashMap<String, Object> map = new HashMap<String, Object>();
		
		try {
			EducationSampleRootVO sVo = (EducationSampleRootVO) ibean;
			EducationSampleVO educationSampleVo = sVo.getEducationSampleVO();
			
			map = CommonConvertObjectToMap.ConverObjectToMap(educationSampleVo);
			log.debug("[IN MAP] deleteEduSawon:::" + map);
			return educationSampleMapper.deleteEduSawon(map);
		} catch (Exception e) {	
			
			return 0;
		}
	}
}