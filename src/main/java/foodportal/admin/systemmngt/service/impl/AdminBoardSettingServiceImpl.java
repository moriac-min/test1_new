package foodportal.admin.systemmngt.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;            

import egovframework.rte.fdl.cmmn.AbstractServiceImpl;
import foodportal.admin.systemmngt.mapper.AdminBoardSettingMapper;
import foodportal.admin.systemmngt.service.AdminBoardSettingService;
import foodportal.admin.systemmngt.vo.AdminSystemmngtRootVO;
import foodportal.admin.systemmngt.vo.BoardSettingVO;
import foodportal.admin.systemmngt.vo.HCategorySettingVo;
import foodportal.common.util.StringUtil;

import org.slf4j.Logger;

import common.adminfacillity.systemmngt.service.AdminfacillitySystemmngtRootVO;
import common.adminfacillity.systemmngt.service.CommonCodeDataVO;
import common.adminfacillity.systemmngt.service.CommonCodeVO;
import common.commonfacillity.uia.WqBaseBean;
import common.commonfacillity.util.CommonConvertObjectToMap;
import common.commonfacillity.log.CommonLog;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

/**
 * AdminBoardSettingServiceImpl
 * @author 최연길
 * @since 2014.08.29
 * @version 1.0
 * @see
 * 
 * <pre>
 *  Modification Information
 *  수정일      수정자   수정내용
 *  ---------- -------- ---------------------------
 *  2014.08.27 최연길 최초 생성
 * </pre>
 * 
 * Copyright (C) 2014 by NDS., All right reserved.
 */

@Service("adminBoardSettingService")
public class AdminBoardSettingServiceImpl extends AbstractServiceImpl implements AdminBoardSettingService {

	@CommonLog Logger log;

	@Autowired
	AdminBoardSettingMapper adminBoardSettingMapper;
	
	@Transactional(readOnly=true)
	public List<BoardSettingVO> selectBoardSettingList(WqBaseBean ibean) throws Exception {
		HashMap<String, Object> map = new HashMap<String, Object>();
		
		try{
			AdminSystemmngtRootVO adminSystemmngtRootVO = (AdminSystemmngtRootVO) ibean;
			//BoardSettingVO BoardSettingVO = adminSystemmngtRootVO.getParamBoardSettingList();
			
			map = CommonConvertObjectToMap.ConverObjectToMap(adminSystemmngtRootVO);
			
			List<BoardSettingVO> list = adminBoardSettingMapper.selectBoardSettingList(map);
			return list;
			
		} catch(Exception e) {
			
			throw e;
		}
	}
	
	@Transactional
	public int saveBoardSetting(WqBaseBean ibean) throws Exception {
		
		HashMap<String, Object> map = new HashMap<String, Object>();
		HashMap<String, Object> userMap = new HashMap<String, Object>();
		int resultObj = 1;
		String rowStatus = "";
		try {
			
			
			AdminSystemmngtRootVO adminSystemmngtRootVO = (AdminSystemmngtRootVO) ibean;
			BoardSettingVO paramBoardSettingInfo = adminSystemmngtRootVO.getParamBoardSettingInfo();
			
			map = CommonConvertObjectToMap.ConverObjectToMap(paramBoardSettingInfo);
			
			List paramUserList = adminSystemmngtRootVO.getParamUserList();
			
			BoardSettingVO boardSettingVO;
			
			//신규
			if("I".equals(StringUtil.NVLToSpace(map.get("bbs_type")))){		
				
				//String newBoardSettingNo = adminBoardSettingMapper.selectNewBoardSettingNo();	//새로운 메뉴번호

				//map.put("bbs_no", newBoardSettingNo);
				//insert
				resultObj =  adminBoardSettingMapper.insertBoardSettingBbs(map);
				resultObj =  adminBoardSettingMapper.insertBoardSettingCtgry(map);
				for(int i=0; i<paramUserList.size(); i++){
					boardSettingVO = (BoardSettingVO) paramUserList.get(i);
					userMap = CommonConvertObjectToMap.ConverObjectToMap(boardSettingVO);
					userMap.put("bbs_no", map.get("bbs_no"));
					userMap.put("cretr_id", map.get("cretr_id"));
					userMap.put("last_updtr_id", map.get("last_updtr_id"));
					rowStatus = boardSettingVO.getRowStatus();					
					if ("C".equals(rowStatus.toUpperCase())) {
						adminBoardSettingMapper.insertBoardSettingUser(userMap);
					}
				}
				
			//수정
			}else if("U".equals(StringUtil.NVLToSpace(map.get("bbs_type")))){	
				//update
				resultObj =  adminBoardSettingMapper.updateBoardSettingBbs(map);
				resultObj =  adminBoardSettingMapper.updateBoardSettingCtgry(map);
				for(int i=0; i<paramUserList.size(); i++){
					boardSettingVO = (BoardSettingVO) paramUserList.get(i);
					userMap = CommonConvertObjectToMap.ConverObjectToMap(boardSettingVO);
					userMap.put("bbs_no", map.get("bbs_no"));
					userMap.put("cretr_id", map.get("cretr_id"));
					userMap.put("last_updtr_id", map.get("last_updtr_id"));
					rowStatus = boardSettingVO.getRowStatus();
					if ("C".equals(rowStatus.toUpperCase())) {
						adminBoardSettingMapper.insertBoardSettingUser(userMap);
					}
				}
			}else{	
				//delete
				for(int i=0; i<paramUserList.size(); i++){
					boardSettingVO = (BoardSettingVO) paramUserList.get(i);
					userMap = CommonConvertObjectToMap.ConverObjectToMap(boardSettingVO);
					userMap.put("bbs_no", map.get("bbs_no"));
					rowStatus = boardSettingVO.getRowStatus();
					if ("D".equals(rowStatus.toUpperCase())) {
						adminBoardSettingMapper.deleteBoardSettingUser(userMap);
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

	
	@Transactional(readOnly=true)
	public BoardSettingVO selectBoardSettingDetail(WqBaseBean ibean) throws Exception {
		HashMap<String, Object> map = new HashMap<String, Object>();
		
		try{
			AdminSystemmngtRootVO adminSystemmngtRootVO = (AdminSystemmngtRootVO) ibean;
			BoardSettingVO paramBoardSettingVO = adminSystemmngtRootVO.getParamBoardSettingInfo();
			map = CommonConvertObjectToMap.ConverObjectToMap(paramBoardSettingVO);
			
			BoardSettingVO boardSettingVO = adminBoardSettingMapper.selectBoardSettingDetail(map);
			
			return boardSettingVO;
			
		} catch(Exception e) {
			
			throw e;
		}
	}

	@Transactional(readOnly=true)
	public List<BoardSettingVO> selectBoardSettingDetailUser(WqBaseBean ibean) throws Exception {
		HashMap<String, Object> map = new HashMap<String, Object>();
		
		try{
			AdminSystemmngtRootVO adminSystemmngtRootVO = (AdminSystemmngtRootVO) ibean;
			BoardSettingVO paramBoardSettingVO = adminSystemmngtRootVO.getParamBoardSettingInfo();
			map = CommonConvertObjectToMap.ConverObjectToMap(paramBoardSettingVO);
			
			List<BoardSettingVO> list = adminBoardSettingMapper.selectBoardSettingDetailUser(map);
			
			return list;
			
		} catch(Exception e) {
			
			throw e;
		}
	}
	
	
	@Transactional(readOnly=true)
	public BoardSettingVO selectBoardSettingCheck(WqBaseBean ibean) throws Exception {
		HashMap<String, Object> map = new HashMap<String, Object>();
		
		try{
			AdminSystemmngtRootVO adminSystemmngtRootVO = (AdminSystemmngtRootVO) ibean;
			BoardSettingVO paramBoardSettingVO = adminSystemmngtRootVO.getParamBoardSettingInfo();
			map = CommonConvertObjectToMap.ConverObjectToMap(paramBoardSettingVO);
			
			BoardSettingVO boardSettingVO = adminBoardSettingMapper.selectBoardSettingCheck(map);
			return boardSettingVO;
			
		} catch(Exception e) {
			
			throw e;
		}
	}
	
}