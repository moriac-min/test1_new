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
import foodportal.admin.systemmngt.mapper.AdminMenuMapper;
import foodportal.admin.systemmngt.service.AdminMenuService;
import foodportal.admin.systemmngt.vo.AdminSystemmngtRootVO;
import foodportal.admin.systemmngt.vo.BoardSettingVO;
import foodportal.admin.systemmngt.vo.HCategorySettingVo;
import foodportal.admin.systemmngt.vo.MenuVO;
import foodportal.common.util.StringUtil;

/**
 * AdminMenuServiceImpl
 * @author 박재형
 * @since 2014.08.27
 * @version 1.0
 * @see
 * 
 * <pre>
 *  Modification Information
 *  수정일      수정자   수정내용
 *  ---------- -------- ---------------------------
 *  2014.08.27 박재형 최초 생성
 * </pre>
 * 
 * Copyright (C) 2014 by NDS., All right reserved.
 */

@Service("adminMenuService")
public class AdminMenuServiceImpl extends AbstractServiceImpl implements AdminMenuService {

	@CommonLog Logger log;

	@Autowired
	AdminMenuMapper adminMenuMapper;
	
	@Transactional(readOnly=true)
	public List<MenuVO> selectMenuList(WqBaseBean ibean) throws Exception {
		HashMap<String, Object> map = new HashMap<String, Object>();
		
		try{
			AdminSystemmngtRootVO adminSystemmngtRootVO = (AdminSystemmngtRootVO) ibean;
			MenuVO MenuVO = adminSystemmngtRootVO.getParamMenuList();
			
			map = CommonConvertObjectToMap.ConverObjectToMap(MenuVO);
			
			List<MenuVO> list = adminMenuMapper.selectMenuList(map);
			
			return list;
			
		} catch(Exception e) {
			
			throw e;
		}
	}

	@Transactional
	public int saveMenu(WqBaseBean ibean) throws Exception {
		
		HashMap<String, Object> map = new HashMap<String, Object>();
		int resultObj = 0;
		
		try {
			
			
			AdminSystemmngtRootVO adminSystemmngtRootVO = (AdminSystemmngtRootVO) ibean;
			MenuVO paramMenuInfo = adminSystemmngtRootVO.getParamMenuInfo();
			
			map = CommonConvertObjectToMap.ConverObjectToMap(paramMenuInfo);
			
			//신규
			if("".equals(StringUtil.NVLToSpace(map.get("menu_no")))){		
				
				String newMenuNo = adminMenuMapper.selectNewMenuNo();	//새로운 메뉴번호
				/*
				if("".equals(StringUtil.NVLToSpace(map.get("hrnk_menu_no")))){	//상위메뉴번호
					map.put("hrnk_menu_no", newMenuNo);
				}
				*/
				map.put("menu_no", newMenuNo);
				//insert
				resultObj =  adminMenuMapper.insertMenu(map);

			//수정
			}else{		
				//update
				resultObj =  adminMenuMapper.updateMenu(map);
			}
					
			return resultObj;
		} catch(Exception e){
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			return resultObj;
		}
		
	}
	
	@Transactional(readOnly=true)
	public MenuVO selectMenuDetail(WqBaseBean ibean) throws Exception {
		HashMap<String, Object> map = new HashMap<String, Object>();
		
		try{
			AdminSystemmngtRootVO adminSystemmngtRootVO = (AdminSystemmngtRootVO) ibean;
			MenuVO paramMenuVO = adminSystemmngtRootVO.getParamMenuInfo();
			map = CommonConvertObjectToMap.ConverObjectToMap(paramMenuVO);
			
			MenuVO menuVO = adminMenuMapper.selectMenuDetail(map);
			
			return menuVO;
			
		} catch(Exception e) {
			
			throw e;
		}
	}
	
	@Transactional(readOnly=true)
	public List<BoardSettingVO> selectBoardSettingList(WqBaseBean ibean) throws Exception {
		HashMap<String, Object> map = new HashMap<String, Object>();
		
		try{
			AdminSystemmngtRootVO adminSystemmngtRootVO = (AdminSystemmngtRootVO) ibean;
			MenuVO paramMenuVO = adminSystemmngtRootVO.getParamMenuInfo();
			map = CommonConvertObjectToMap.ConverObjectToMap(paramMenuVO);
			
			List<BoardSettingVO> list = adminMenuMapper.selectBoardSettingList(map);
			
			return list;
			
		} catch(Exception e) {
			
			throw e;
		}
	}
	
	@Transactional(readOnly=true)
	public List<MenuVO> selectMainMenuList(WqBaseBean ibean) throws Exception {
		HashMap<String, Object> map = new HashMap<String, Object>();
		
		try{
			AdminSystemmngtRootVO adminSystemmngtRootVO = (AdminSystemmngtRootVO) ibean;
			MenuVO MenuVO = adminSystemmngtRootVO.getParamMenuList();
			
			map = CommonConvertObjectToMap.ConverObjectToMap(MenuVO);
			
			List<MenuVO> list = adminMenuMapper.selectMainMenuList(map);
			
			return list;
			
		} catch(Exception e) {
			
			throw e;
		}
	}
	
	@Transactional(readOnly=true)
	public List<MenuVO> selectBbsMoveList(WqBaseBean ibean) throws Exception {
		HashMap<String, Object> map = new HashMap<String, Object>();
		
		try{
			AdminSystemmngtRootVO adminSystemmngtRootVO = (AdminSystemmngtRootVO) ibean;
			MenuVO MenuVO = adminSystemmngtRootVO.getParamBbsMoveList();
			
			map = CommonConvertObjectToMap.ConverObjectToMap(MenuVO);
			
			List<MenuVO> list = adminMenuMapper.selectBbsMoveList(map);
			
			return list;
			
		} catch(Exception e) {
			
			throw e;
		}
	}
	
	@Transactional(readOnly=true)
	public List<MenuVO> selectBbsRelmCntntsList(WqBaseBean ibean) throws Exception {
		HashMap<String, Object> map = new HashMap<String, Object>();
		
		try{
			AdminSystemmngtRootVO adminSystemmngtRootVO = (AdminSystemmngtRootVO) ibean;
			MenuVO MenuVO = adminSystemmngtRootVO.getParamBbsRelmCntntsList();
			
			map = CommonConvertObjectToMap.ConverObjectToMap(MenuVO);
			
			List<MenuVO> list = adminMenuMapper.selectBbsRelmCntntsList(map);
			
			return list;
			
		} catch(Exception e) {
			
			throw e;
		}
	}
	
	@Transactional(readOnly=true)
	public List<MenuVO> selectBbsRelmMenuList(WqBaseBean ibean) throws Exception {
		HashMap<String, Object> map = new HashMap<String, Object>();
		
		try{
			AdminSystemmngtRootVO adminSystemmngtRootVO = (AdminSystemmngtRootVO) ibean;
			MenuVO MenuVO = adminSystemmngtRootVO.getParamBbsRelmMenuList();
			
			map = CommonConvertObjectToMap.ConverObjectToMap(MenuVO);
			
			List<MenuVO> list = adminMenuMapper.selectBbsRelmMenuList(map);
			
			return list;
			
		} catch(Exception e) {
			
			throw e;
		}
	}
	
	
	@Transactional
	public int saveUseBbsRelmCntntsList(WqBaseBean ibean) throws Exception {
		
		HashMap<String, Object> map = new HashMap<String, Object>();
		int resultObj = 0;
		
		try {
			
			AdminSystemmngtRootVO adminSystemmngtRootVO = (AdminSystemmngtRootVO) ibean;
			List<MenuVO> paramList = adminSystemmngtRootVO.getParamSaveBbsRelmMenuList();
			MenuVO paramMenuVo = adminSystemmngtRootVO.getParamBbsRelmMenuList();
			
			String ntctxt_no = "";
			String menu_no = "";
			/*
			for(int i=0; i<paramList.size(); i++){
//				menuNos[i] = StringUtil.NVLToSpace(paramList.get(i).getMenu_no().toString());
				ntctxt_no = StringUtil.NVLToSpace(paramList.get(i).getNtctxt_no()).toString();
				if(!"".equals(ntctxt_no)){
					break;
				}
			}
			*/
			ntctxt_no = paramMenuVo.getNtctxt_no();
//			map.put("menuNos", menuNos);
			System.out.println("=============ntctxt_no=============>"+ntctxt_no);
			//해당글번호 모두 삭제
			map.put("ntctxt_no", ntctxt_no);
			
			adminMenuMapper.deleteUseBbsRelmCntntsList(map);
			
			//모두 다시 insert
			
			MenuVO getParamVo;
			
			for(int i=0; i<paramList.size(); i++){
				getParamVo = (MenuVO) paramList.get(i);
				
				ntctxt_no = StringUtil.NVLToSpace(getParamVo.getNtctxt_no());
				menu_no = StringUtil.NVLToSpace(getParamVo.getMenu_no());
				
				if(!"".equals(ntctxt_no) && !"".equals(menu_no)){
					
					map = CommonConvertObjectToMap.ConverObjectToMap(getParamVo);
					adminMenuMapper.insertUseBbsRelmCntntsList(map);
				}
				//map = CommonConvertObjectToMap.ConverObjectToMap(paramVo);
				//adminMenuMapper.insertUseBbsRelmCntntsList(map);
			}
			
			
					
			return resultObj;
		} catch(Exception e){
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			return resultObj;
		}
		
	}
	
	
}