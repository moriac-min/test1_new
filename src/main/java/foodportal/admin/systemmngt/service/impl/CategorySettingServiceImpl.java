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
import foodportal.admin.systemmngt.mapper.AdminMenuMapper;
import foodportal.admin.systemmngt.mapper.CategorySettingMapper;
import foodportal.admin.systemmngt.service.CategorySettingService;
import foodportal.admin.systemmngt.vo.AdminSystemmngtRootVO;
import foodportal.admin.systemmngt.vo.CategorySettingVO;

/**
 * CategorySettingServiceImpl
 * @author 장영철
 * @since 2014.09.01
 * @version 1.0
 * @see
 * 
 * <pre>
 *  Modification Information
 *  수정일      수정자   수정내용
 *  ---------- -------- ---------------------------
 *  2014.09.01 장영철 최초 생성
 * </pre>
 * 
 * Copyright (C) 2014 by NDS., All right reserved.
 */

@Service("categorySettingService")
public class CategorySettingServiceImpl implements CategorySettingService{
	
	@CommonLog Logger log;

	@Autowired
	CategorySettingMapper categorySettingMapper;

	@Transactional(readOnly=true)
	public List<CategorySettingVO> selectCategorySettingList(WqBaseBean ibean) throws Exception {
		HashMap<String, Object> map = new HashMap<String, Object>();
		
		try {
			AdminSystemmngtRootVO adminSystemmngtRootVO = (AdminSystemmngtRootVO) ibean;
			CategorySettingVO categoryVo = adminSystemmngtRootVO.getParamCategory();
			
			map = CommonConvertObjectToMap.ConverObjectToMap(categoryVo);
			
			List<CategorySettingVO> list = categorySettingMapper.selectCategorySettingList(map);
			
			return list;
			
		} catch (Exception e) {
			
			throw e;
		}
	}
	
	@Transactional
	public int saveCategorySetting(WqBaseBean ibean) throws Exception {
		HashMap<String, Object> map = new HashMap<String, Object>();
		CategorySettingVO categorySettingVo;
		String rowStatus;
		String ctgryNo;
		
		try {
			
			AdminSystemmngtRootVO adminSystemmngtRootVO = (AdminSystemmngtRootVO) ibean;
			List categoryList = adminSystemmngtRootVO.getParamCategoryList();		//insert/update 데이터
			List RmCtgryList = adminSystemmngtRootVO.getParamRmCtgryList();		//delte 데이터
			
			for(int idx = 0; idx < categoryList.size(); idx++){
				categorySettingVo = (CategorySettingVO) categoryList.get(idx);
				rowStatus = categorySettingVo.getRowStatus();
				
				categorySettingVo.setCretr_id("cretr_id");		//작성자 ID -  임시
				categorySettingVo.setLast_updtr_id("updtr_id");		//수정자 ID -  임시
				
				if (rowStatus.equalsIgnoreCase("C")) {			//insert
					ctgryNo = categorySettingMapper.selectNewCtgryNo();
					categorySettingVo.setCtgry_no(ctgryNo);

					map = CommonConvertObjectToMap.ConverObjectToMap(categorySettingVo);
					categorySettingMapper.insertCategorySetting(map);
					
				}else if (rowStatus.equalsIgnoreCase("U")) {		//update
					map = CommonConvertObjectToMap.ConverObjectToMap(categorySettingVo);
					categorySettingMapper.updateCategorySetting(map);
				}
			}
			
			//delete
			for(int idx = 0; idx < RmCtgryList.size(); idx++){
				categorySettingVo = (CategorySettingVO) RmCtgryList.get(idx);
				categorySettingVo.setDel_yn("Y");
				map = CommonConvertObjectToMap.ConverObjectToMap(categorySettingVo);
				categorySettingMapper.updateCategorySetting(map);
			}
			
			return 1;
			
		} catch (Exception e) {
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			return 0;
		}
		
	}

}
