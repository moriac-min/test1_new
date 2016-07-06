package common.adminfacillity.systemmngt.controller;

import java.util.Map;
import java.util.List;

import org.slf4j.Logger;

import common.commonfacillity.log.CommonLog;
import common.commonfacillity.uia.WqBaseBean;
import common.commonfacillity.uia.WqResultBean;
import websquare.system.adapter.annotation.BEAN_DEF;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import common.adminfacillity.systemmngt.service.MenuService;
import common.adminfacillity.systemmngt.service.MenuVO;
import common.adminfacillity.systemmngt.service.AdminfacillitySystemmngtRootVO;
import common.adminfacillity.systemmngt.service.ProgramVO;

/**
 * MenuController
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

@Controller                                                                                
public class MenuController {

	@CommonLog Logger log;
	@Autowired
	private MenuService menuService;

	
	/**
	 * 등록된 메뉴 정보 조회
	 * 
	 * @param 
	 * @return ModelAndView
	 * @throws Exception
	 */
	@RequestMapping(value = "/adminfacillity/systemmngt/selectMenu.do")
	@BEAN_DEF(beans={"root=common.adminfacillity.systemmngt.service.AdminfacillitySystemmngtRootVO", "MenuVO=common.adminfacillity.systemmngt.service.MenuVO", "infoList=common.adminfacillity.systemmngt.service.MenuVO"})
	public ModelAndView selectMenu(WqBaseBean ibean) throws Exception {
		ModelAndView mav = new ModelAndView("wqView");
		
		AdminfacillitySystemmngtRootVO adminfacillitySystemmngtRootVO = new AdminfacillitySystemmngtRootVO();
		List<MenuVO> list = menuService.selectMenu(ibean);
		adminfacillitySystemmngtRootVO.setInfoList(list);
		mav.addObject("result", adminfacillitySystemmngtRootVO);
		
		return mav;
	}

	/**
	 * 신규 메뉴 정보 저장
	 * 
	 * @param 
	 * @return ModelAndView
	 * @throws Exception
	 */
	@RequestMapping(value = "/adminfacillity/systemmngt/saveMenu.do")
	@BEAN_DEF(beans={"root=common.adminfacillity.systemmngt.service.AdminfacillitySystemmngtRootVO"})
	public ModelAndView saveMenu(WqBaseBean ibean) throws Exception {
		ModelAndView mav = new ModelAndView("wqView");
		WqResultBean rtnResult = new WqResultBean();
		AdminfacillitySystemmngtRootVO outVo = new AdminfacillitySystemmngtRootVO();
		List<MenuVO> list = null;
		
		int result = menuService.saveMenu(ibean);
		log.debug("saveMenuList result = " + result);
		if(result == 1){
			rtnResult.setResult("정상적으로 저장되었습니다.");
		} else {
			rtnResult.setResult("저장에 문제가 발생하였습니다.");
		}
		
		outVo.setWqResultBean(rtnResult);
		outVo.setInfoList(list);
		
		mav.addObject("result", outVo);
		
		return mav;
	}
}