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
import foodportal.admin.systemmngt.mapper.CalMngtMapper;
import foodportal.admin.systemmngt.service.CalMngtService;
import foodportal.admin.systemmngt.vo.AdminSystemmngtRootVO;
import foodportal.admin.systemmngt.vo.CalMngtVO;

/**
 * CalMngtServiceImpl
 * @author 최연길
 * @since 2014.09.15
 * @version 1.0
 * @see
 * 
 * <pre>
 *  Modification Information
 *  수정일      수정자   수정내용
 *  ---------- -------- ---------------------------
 *  2014.09.15 최연길 최초 생성
 * </pre>
 * 
 * Copyright (C) 2014 by NDS., All right reserved.
 */

@Service("calMngtService")
public class CalMngtServiceImpl extends AbstractServiceImpl implements CalMngtService {

	@CommonLog Logger log;

	@Autowired
	CalMngtMapper calMngtMapper;
	
	@Transactional(readOnly=true)
	public List<CalMngtVO> selectCalMngtList(WqBaseBean ibean) throws Exception {
		HashMap<String, Object> map = new HashMap<String, Object>();
		
		try{
			AdminSystemmngtRootVO adminSystemmngtRootVO = (AdminSystemmngtRootVO) ibean;
			CalMngtVO calMngtVO = adminSystemmngtRootVO.getParamDateNo();
			
			map = CommonConvertObjectToMap.ConverObjectToMap(calMngtVO);
			
			List<CalMngtVO> list = calMngtMapper.selectCalMngtList(map);

			return list;
			
		} catch(Exception e) {
			
			throw e;
		}
	}

	@Transactional(readOnly=true)
	public CalMngtVO selectCalMngtDetail(WqBaseBean ibean) throws Exception {
		HashMap<String, Object> map = new HashMap<String, Object>();
		
		try{
			AdminSystemmngtRootVO adminSystemmngtRootVO = (AdminSystemmngtRootVO) ibean;
			CalMngtVO paramcalMngtVO = adminSystemmngtRootVO.getParamCalMngt();
			map = CommonConvertObjectToMap.ConverObjectToMap(paramcalMngtVO);
			
			CalMngtVO calMngtVO = calMngtMapper.selectCalMngtDetail(map);
			
			return calMngtVO;
			
		} catch(Exception e) {
			
			throw e;
		}
	}

	@Transactional
	public int insertCalMngt(WqBaseBean ibean) throws Exception {
		try {
			AdminSystemmngtRootVO adminSystemmngtRootVO = (AdminSystemmngtRootVO) ibean;
			CalMngtVO calMngtVO = adminSystemmngtRootVO.getCalMngt();
			
			HashMap<String, Object> map = CommonConvertObjectToMap.ConverObjectToMap(calMngtVO);
			
			return calMngtMapper.insertCalMngt(map);
		} catch(Exception e){
			
			return 0;
		}
	}

	@Transactional
	public int updateCalMngt(WqBaseBean ibean) throws Exception {
		try {
			AdminSystemmngtRootVO adminSystemmngtRootVO = (AdminSystemmngtRootVO) ibean;
			CalMngtVO calMngtVO = adminSystemmngtRootVO.getCalMngt();
			
			HashMap<String, Object> map = CommonConvertObjectToMap.ConverObjectToMap(calMngtVO);

			return calMngtMapper.updateCalMngt(map);
		} catch(Exception e){
			
			return 0;
		}
	}

	@Transactional
	public int deleteCalMngt(WqBaseBean ibean) throws Exception {
		HashMap<String, Object> map = new HashMap<String, Object>();
		int resultObj = 1;
		String rowStatus = "";
		try {
			AdminSystemmngtRootVO adminSystemmngtRootVO = (AdminSystemmngtRootVO) ibean;
			List<CalMngtVO> calMngtList = adminSystemmngtRootVO.getCalMngtList();
			
			map = CommonConvertObjectToMap.ConverObjectToMap(calMngtList);
			
			CalMngtVO calMngtVO;
			
			for(int i=0; i<calMngtList.size(); i++){
				calMngtVO = (CalMngtVO) calMngtList.get(i);
				map = CommonConvertObjectToMap.ConverObjectToMap(calMngtVO);
				rowStatus = calMngtVO.getRowStatus();		
				if ("U".equals(rowStatus.toUpperCase())) {
					resultObj = calMngtMapper.deleteCalMngt(map);
				}
			}
			return resultObj;
		} catch(Exception e){
			
			return 0;
		}
	}

}