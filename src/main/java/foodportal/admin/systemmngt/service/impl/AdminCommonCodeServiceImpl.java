package foodportal.admin.systemmngt.service.impl;

import java.util.HashMap;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import common.commonfacillity.log.CommonLog;
import common.commonfacillity.uia.WqBaseBean;
import common.commonfacillity.util.CommonConvertObjectToMap;
import egovframework.rte.fdl.cmmn.AbstractServiceImpl;
import foodportal.admin.systemmngt.mapper.AdminCommonCodeMapper;
import foodportal.admin.systemmngt.service.AdminCommonCodeService;
import foodportal.admin.systemmngt.vo.AdminSystemmngtRootVO;
import foodportal.admin.systemmngt.vo.CommonCodeVO;

/**
 * AdminCommonCodeServiceImpl
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

@Service("adminCommonCodeService")
public class AdminCommonCodeServiceImpl extends AbstractServiceImpl implements AdminCommonCodeService {

	@CommonLog Logger log;

	@Autowired
	AdminCommonCodeMapper adminCommonCodeMapper;
	
	@Transactional(readOnly=true)
	public List<CommonCodeVO> selectHeaderCodeList(WqBaseBean ibean) throws Exception {
		HashMap<String, Object> map = new HashMap<String, Object>();
		
		try{
			AdminSystemmngtRootVO adminSystemmngtRootVO = (AdminSystemmngtRootVO) ibean;
			CommonCodeVO commonCodeVO = adminSystemmngtRootVO.getCommonCode();
			
			map = CommonConvertObjectToMap.ConverObjectToMap(commonCodeVO);
			
			List<CommonCodeVO> list = adminCommonCodeMapper.selectHeaderCodeList(map);
			
			return list;
			
		} catch(Exception e) {
			
			throw e;
		}
	}
	
	@Transactional(readOnly=true)
	public List<CommonCodeVO> selectDetailCodeList(WqBaseBean ibean) throws Exception {
		HashMap<String, Object> map = new HashMap<String, Object>();
		
		try{
			AdminSystemmngtRootVO adminSystemmngtRootVO = (AdminSystemmngtRootVO) ibean;
			CommonCodeVO commonCodeVO = adminSystemmngtRootVO.getCommonCode();
			
			map = CommonConvertObjectToMap.ConverObjectToMap(commonCodeVO);
			
			List<CommonCodeVO> list = adminCommonCodeMapper.selectDetailCodeList(map);
			
			return list;
			
		} catch(Exception e) {
			
			throw e;
		}
	}

	@Transactional
	public int saveCommonCode(WqBaseBean ibean) throws Exception {
		try {
			AdminSystemmngtRootVO adminSystemmngtRootVO = (AdminSystemmngtRootVO) ibean;
			List<CommonCodeVO> commonCodeList = adminSystemmngtRootVO.getCommonCodeList();
			
			log.debug("saveCommonCode commonCodeList SIZE " + commonCodeList.size());
			
			for (int idx = 0, iCnt = commonCodeList.size(); idx < iCnt; idx++) {
				CommonCodeVO commonCodeVO = (CommonCodeVO) commonCodeList.get(idx);
				
				//////////////////////////////////////////////
				// 차후에 로그인 아이디로 변경
				commonCodeVO.setCretr_id("test");
				commonCodeVO.setLast_updtr_id("test");
				//////////////////////////////////////////////
				
				HashMap<String, Object> map = CommonConvertObjectToMap.ConverObjectToMap(commonCodeVO);
				log.debug("[IN MAP] saveCommonCode:::" + map);
				String rowStatus = commonCodeVO.getRowStatus();
				
				log.debug("saveEduSawon rowStatus[" + idx + "]:::" + rowStatus);
				if (rowStatus.equalsIgnoreCase("U")) {
					adminCommonCodeMapper.updateCommonCode(map);
				} else if (rowStatus.equalsIgnoreCase("D") || rowStatus.equalsIgnoreCase("E")) {
					// 헤더코드일 경우
					if (StringUtils.isEmpty(commonCodeVO.getHrnk_cd())) {
						// 세부코드 먼저 삭제
						HashMap<String, Object> hrnkMap = new HashMap<String, Object>();
						hrnkMap.put("cmmn_cd", null);
						hrnkMap.put("hrnk_cd", map.get("cmmn_cd"));
						adminCommonCodeMapper.deleteCommonCode(hrnkMap);
					}
					
					adminCommonCodeMapper.deleteCommonCode(map);
				} else if (rowStatus.equalsIgnoreCase("C")) {
					adminCommonCodeMapper.insertCommonCode(map);
				}
			}
			
			return 1;
		} catch (Exception e) {	
			
			return 0;
		}
	}

}