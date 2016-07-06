package common.adminfacillity.systemmngt.service.impl;

import java.util.HashMap;
import java.util.List;            
import java.util.Map;         

import javax.annotation.Resource;

import egovframework.rte.fdl.cmmn.AbstractServiceImpl;
import common.adminfacillity.systemmngt.service.AdminfacillitySystemmngtRootVO;
import common.adminfacillity.systemmngt.service.MenuService;
import common.adminfacillity.systemmngt.service.ProgramVO;
import common.adminfacillity.systemmngt.mapper.MenuMapper;
import common.adminfacillity.systemmngt.service.MenuVO;

import org.slf4j.Logger;

import common.commonfacillity.uia.WqBaseBean;
import common.commonfacillity.util.CommonConvertObjectToMap;
import common.commonfacillity.util.CommonStringUtil;
import common.commonfacillity.log.CommonLog;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * MenuService
 * @author 유승엽
 * @since 2014.08.19
 * @version 1.0
 * @see
 * 
 * <pre>
 *  Modification Information
 *  수정일      수정자   수정내용
 *  ---------- -------- ---------------------------
 *  2014.08.19 유승엽 최초 생성
 * </pre>
 * 
 * Copyright (C) 2014 by NDS., All right reserved.
 */

@Service("menuService")
public class MenuServiceImpl extends AbstractServiceImpl implements MenuService {

	@CommonLog Logger log;

	@Autowired
	MenuMapper menuMapper;


	/* (non-Javadoc)
	 * @see common.adminfacillity.systemmngt.service.MenuService#selectMenu(java.util.Map)
	 */
	@Transactional(readOnly=true)
	public List<MenuVO> selectMenu(WqBaseBean ibean) throws Exception {
		HashMap<String, Object> map = new HashMap<String, Object>();
		
		try{
			AdminfacillitySystemmngtRootVO sVo = (AdminfacillitySystemmngtRootVO) ibean;
			MenuVO inMenuVo = sVo.getMenuVO();
			
			log.debug("[IN] selectMenu:::" + inMenuVo);
			
			map = CommonConvertObjectToMap.ConverObjectToMap(inMenuVo);
			log.debug("[IN MAP] selectMenu:::" + map);
			List<MenuVO> list = menuMapper.selectMenu(map);
			
			return list;	
			
		}catch(Exception e){
			
			throw e;
		}
	}

	/* (non-Javadoc)
	 * @see common.adminfacillity.systemmngt.service.MenuService#saveMenu(java.util.Map)
	 */
	@Transactional
	public int saveMenu(WqBaseBean ibean) throws Exception {
		HashMap<String, Object> map = new HashMap<String, Object>();
		try {
			AdminfacillitySystemmngtRootVO sVo = (AdminfacillitySystemmngtRootVO) ibean;
			List<MenuVO> menuList = sVo.getInfoList();
			MenuVO menuVo;
			String rowStatus;
			
			log.debug("saveMenu menuList SIZE " + menuList.size());
			log.debug("saveMenu menuList.data " + menuList.get(0));
			for (int idx = 0, iCnt = menuList.size(); idx < iCnt; idx++) {
				menuVo = (MenuVO) menuList.get(idx);
				map = CommonConvertObjectToMap.ConverObjectToMap(menuVo);
				log.debug("[IN MAP] saveMenu:::" + map);
				rowStatus = menuVo.getRowStatus();
				
				if (rowStatus.equalsIgnoreCase("U")) {
					menuMapper.updateMenu(map);
				} else if (rowStatus.equalsIgnoreCase("D") || rowStatus.equalsIgnoreCase("E")) {
					menuMapper.deleteMenu(map);
				} else if (rowStatus.equalsIgnoreCase("I") || rowStatus.equalsIgnoreCase("C")) {
					menuMapper.insertMenu(map);
				}
			}
			
			return 1;
		} catch (Exception e) {	
			
			return 0;
		}
	}
}	
