package foodportal.admin.systemmngt.service.impl;

import java.util.HashMap;
import java.util.List;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import common.commonfacillity.log.CommonLog;
import common.commonfacillity.uia.WqBaseBean;
import common.commonfacillity.util.CommonConvertObjectToMap;
import egovframework.rte.fdl.cmmn.AbstractServiceImpl;
import foodportal.admin.systemmngt.mapper.UserCategorySettingMapper;
import foodportal.admin.systemmngt.service.UserCategorySettingService;
import foodportal.admin.systemmngt.vo.AdminSystemmngtRootVO;
import foodportal.admin.systemmngt.vo.HCategorySettingVo;
import foodportal.admin.systemmngt.vo.UserCategorySettingVO;
import foodportal.common.util.StringUtil;

/**
 * UserCategorySettingServiceImpl
 * @author 박재형
 * @since 2014.09.03
 * @version 1.0
 * @see
 * 
 * <pre>
 *  Modification Information
 *  수정일      수정자   수정내용
 *  ---------- -------- ---------------------------
 *  2014.09.03 박재형 최초 생성
 * </pre>
 * 
 * Copyright (C) 2014 by NDS., All right reserved.
 */

@Service("userCategorySettingServiceImpl")
public class UserCategorySettingServiceImpl extends AbstractServiceImpl implements UserCategorySettingService {

	@CommonLog Logger log;

	@Autowired
	UserCategorySettingMapper userCategorySettingMapper;
	
	@Transactional(readOnly=true)
	public List<UserCategorySettingVO> selectUserList(WqBaseBean ibean) throws Exception {
		HashMap<String, Object> map = new HashMap<String, Object>();
		
		try{
			AdminSystemmngtRootVO adminSystemmngtRootVO = (AdminSystemmngtRootVO) ibean;
			UserCategorySettingVO paramVo = adminSystemmngtRootVO.getParamUserCategorySetting();
			
			map = CommonConvertObjectToMap.ConverObjectToMap(paramVo);
			
			List<UserCategorySettingVO> list = userCategorySettingMapper.selectUserList(map);
			
			return list;
			
		} catch(Exception e) {
			
			throw e;
		}
	}
	
	@Transactional(readOnly=true)
	public List<HCategorySettingVo> selectUCategoryList(WqBaseBean ibean) throws Exception {
		HashMap<String, Object> map = new HashMap<String, Object>();
		
		try{
			AdminSystemmngtRootVO adminSystemmngtRootVO = (AdminSystemmngtRootVO) ibean;
			HCategorySettingVo paramVo = adminSystemmngtRootVO.getParamUCategorySetting();
			
			map = CommonConvertObjectToMap.ConverObjectToMap(paramVo);
			
			List<HCategorySettingVo> list = userCategorySettingMapper.selectUCategoryList(map);
			
			return list;
			
		} catch(Exception e) {
			
			throw e;
		}
	}
	
	@Transactional
	public int updateUserCategorySetting(WqBaseBean ibean, String flag) throws Exception {
		HashMap<String, Object> map = new HashMap<String, Object>();
		int resultObj = 1;
//		String rowStatus = "";
		try {
			AdminSystemmngtRootVO adminSystemmngtRootVO = (AdminSystemmngtRootVO) ibean;
			List paramUCategorySettingList = adminSystemmngtRootVO.getParamUCategorySettingList();
			
			HCategorySettingVo uCategorySettingVo;
			
			/**
			 * 저장
			 */
			if("save".equals(flag)){
				
				HCategorySettingVo paramVo = adminSystemmngtRootVO.getParamUCategorySetting();
				map = CommonConvertObjectToMap.ConverObjectToMap(paramVo);
				
				userCategorySettingMapper.deleteUserCategorySetting(map);
				
				for(int i=0; i<paramUCategorySettingList.size(); i++){
					uCategorySettingVo = (HCategorySettingVo) paramUCategorySettingList.get(i);
					map = CommonConvertObjectToMap.ConverObjectToMap(uCategorySettingVo);
//					rowStatus = userCategorySettingVO.getRowStatus();
					if ("1".equals(StringUtil.NVLToSpace(map.get("chk")))) {
						userCategorySettingMapper.insertUserCategorySetting(map);
					}
				}
			}
			
			return resultObj;
		} catch(Exception e){
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			resultObj = 0;
			return resultObj;
		}
		
	}
	
}