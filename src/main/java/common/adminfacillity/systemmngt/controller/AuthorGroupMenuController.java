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

import common.adminfacillity.systemmngt.service.AuthorGroupMenuService;
import common.adminfacillity.systemmngt.service.AuthorGroupMenuVO;
import common.adminfacillity.systemmngt.service.AdminfacillitySystemmngtRootVO;

/**
 * AuthorGroupMenuController
 * @author 김민규
 * @since 2014.08.19
 * @version 1.0
 * @see
 *
 * <pre>
 *  Modification Information
 *  수정일      수정자   수정내용
 *  ---------- -------- ---------------------------
 *  2014.08.19 김민규 최초 생성
 * </pre>
 *
 * Copyright (C) 2014 by NDS., All right reserved.
 */

@Controller                                                                                
public class AuthorGroupMenuController {

	@CommonLog Logger log;
	@Autowired
	private AuthorGroupMenuService authorGroupMenuService;

	/**
	 * 등록된 권한 그룹별 메뉴 정보 조회
	 * 
	 * @param 
	 * @return ModelAndView
	 * @throws Exception
	 */
	@RequestMapping(value = "/adminfacillity/systemmngt/selectAuthorGroupMenu.do")
	@BEAN_DEF(beans={"root=common.adminfacillity.systemmngt.service.AdminfacillitySystemmngtRootVO", "authorGroupMenuVO=common.adminfacillity.systemmngt.service.AuthorGroupMenuVO", "infoList=common.adminfacillity.systemmngt.service.AuthorGroupMenuVO"})
	public ModelAndView selectAuthorGroupMenu(WqBaseBean ibean) throws Exception {
		ModelAndView mav = new ModelAndView("wqView");
		AdminfacillitySystemmngtRootVO adminfacillitySystemmngtRootVO = new AdminfacillitySystemmngtRootVO();
		List<AuthorGroupMenuVO> list = authorGroupMenuService.selectAuthorGroupMenu(ibean);
		log.debug("[Controller]selectAuthorGroupMenu infoList Size = " + list.size());
		log.debug("[Controller]selectAuthorGroupMenu infoList = " + list);
		adminfacillitySystemmngtRootVO.setInfoList(list);
		
		mav.addObject("result", adminfacillitySystemmngtRootVO);
		
		return mav;
	}
	
	/**
	 * 신규 권한 그룹별 메뉴 정보 등록
	 * 
	 * @param 
	 * @return ModelAndView
	 * @throws Exception
	 */
	@RequestMapping(value = "/adminfacillity/systemmngt/saveAuthorGroupMenu.do")
	@BEAN_DEF(beans={"root=common.adminfacillity.systemmngt.service.AdminfacillitySystemmngtRootVO", "authorGroupMenuVO=common.adminfacillity.systemmngt.service.AuthorGroupMenuVO", "infoList=common.adminfacillity.systemmngt.service.AuthorGroupMenuVO"})
	public ModelAndView saveAuthorGroupMenu(WqBaseBean ibean) throws Exception {
		ModelAndView mav = new ModelAndView("wqView");
		WqResultBean rtnResult = new WqResultBean();
		AdminfacillitySystemmngtRootVO outVo = new AdminfacillitySystemmngtRootVO();
		List<AuthorGroupMenuVO> list = null;
		
		int result = authorGroupMenuService.saveAuthorGroupMenu(ibean);
		if(result == 1) {
			rtnResult.setResult("정상적으로 저장되었습니다.");
			list = authorGroupMenuService.selectAuthorGroupMenu(ibean);
		} else {
			rtnResult.setResult("저장에 문제가 발생하였습니다.");
		}
		outVo.setWqResultBean(rtnResult);
		outVo.setInfoList(list);
		
		mav.addObject("result", outVo);
		
		return mav;
	}
	
	/**
	 * 신규 권한 그룹별 메뉴 정보 등록
	 * 
	 * @param 
	 * @return ModelAndView
	 * @throws Exception
	 */
	@RequestMapping(value = "/adminfacillity/systemmngt/insertAuthorGroupMenu.do")
	@BEAN_DEF(beans={"root=common.adminfacillity.systemmngt.service.AdminfacillitySystemmngtRootVO", "authorGroupMenuVO=common.adminfacillity.systemmngt.service.AuthorGroupMenuVO", "infoList=common.adminfacillity.systemmngt.service.AuthorGroupMenuVO"})
	public ModelAndView insertAuthorGroupMenu(WqBaseBean ibean) throws Exception {
		ModelAndView mav = new ModelAndView("wqView");
		WqResultBean rtnResult = new WqResultBean();
		AdminfacillitySystemmngtRootVO outVo = new AdminfacillitySystemmngtRootVO();
		List<AuthorGroupMenuVO> list = null;
		
		int result = authorGroupMenuService.insertAuthorGroupMenu(ibean);
		if(result == 1) {
			rtnResult.setResult("정상적으로 입력되었습니다.");
			list = authorGroupMenuService.selectAuthorGroupMenu(ibean);
		} else {
			rtnResult.setResult("입력에 문제가 발생하였습니다.");
		}
		outVo.setWqResultBean(rtnResult);
		outVo.setInfoList(list);
		
		mav.addObject("result", outVo);
		
		return mav;
	}

	/**
	 * 등록된 권한 그룹별 메뉴 정보 수정
	 * 
	 * @param 
	 * @return ModelAndView
	 * @throws Exception
	 */
	@RequestMapping(value = "/adminfacillity/systemmngt/updateAuthorGroupMenu.do")
	@BEAN_DEF(beans={"root=common.adminfacillity.systemmngt.service.AdminfacillitySystemmngtRootVO", "authorGroupMenuVO=common.adminfacillity.systemmngt.service.AuthorGroupMenuVO", "infoList=common.adminfacillity.systemmngt.service.AuthorGroupMenuVO"})
	public ModelAndView updateAuthorGroupMenu(WqBaseBean ibean) throws Exception {
		ModelAndView mav = new ModelAndView("wqView");
		WqResultBean rtnResult = new WqResultBean();
		AdminfacillitySystemmngtRootVO outVo = new AdminfacillitySystemmngtRootVO();
		List<AuthorGroupMenuVO> list = null;
		
		int result = authorGroupMenuService.updateAuthorGroupMenu(ibean);
		if(result == 1) {
			rtnResult.setResult("정상적으로 수정되었습니다.");
			list = authorGroupMenuService.selectAuthorGroupMenu(ibean);
		} else {
			rtnResult.setResult("수정에 문제가 발생하였습니다.");
		}
		outVo.setWqResultBean(rtnResult);
		outVo.setInfoList(list);
		
		mav.addObject("result", outVo);
		
		return mav;
	}

	/**
	 * 등록된 권한 그룹별 메뉴 정보 삭제
	 * 
	 * @param 
	 * @return ModelAndView
	 * @throws Exception
	 */
	@RequestMapping(value = "/adminfacillity/systemmngt/deleteAuthorGroupMenu.do")
	@BEAN_DEF(beans={"root=common.adminfacillity.systemmngt.service.AdminfacillitySystemmngtRootVO", "authorGroupMenuVO=common.adminfacillity.systemmngt.service.AuthorGroupMenuVO", "infoList=common.adminfacillity.systemmngt.service.AuthorGroupMenuVO"})
	public ModelAndView deleteAuthorGroupMenu(WqBaseBean ibean) throws Exception {
		ModelAndView mav = new ModelAndView("wqView");
		WqResultBean rtnResult = new WqResultBean();
		AdminfacillitySystemmngtRootVO outVo = new AdminfacillitySystemmngtRootVO();
		List<AuthorGroupMenuVO> list = null;
		
		int result = authorGroupMenuService.deleteAuthorGroupMenu(ibean);
		if(result == 1) {
			rtnResult.setResult("정상적으로 삭제되었습니다.");
			list = authorGroupMenuService.selectAuthorGroupMenu(ibean);
		} else {
			rtnResult.setResult("수정에 문제가 삭제하였습니다.");
		}
		outVo.setWqResultBean(rtnResult);
		outVo.setInfoList(list);
		
		mav.addObject("result", outVo);
		
		return mav;
	}
	//
	/**
	 * 등록된 권한 그룹별 메뉴 정보 조회
	 * 
	 * @param 
	 * @return ModelAndView
	 * @throws Exception
	 */
	@RequestMapping(value = "/adminfacillity/systemmngt/selectAuthorMenuList.do")
	@BEAN_DEF(beans={"root=common.adminfacillity.systemmngt.service.AdminfacillitySystemmngtRootVO", "authorGroupMenuVO=common.adminfacillity.systemmngt.service.AuthorGroupMenuVO", "authorMenuList=common.adminfacillity.systemmngt.service.AuthorGroupMenuVO"})
	public ModelAndView selectAuthorMenuList(WqBaseBean ibean) throws Exception {
		ModelAndView mav = new ModelAndView("wqView");
		AdminfacillitySystemmngtRootVO adminfacillitySystemmngtRootVO = new AdminfacillitySystemmngtRootVO();
		List<AuthorGroupMenuVO> list = authorGroupMenuService.selectAuthorMenuList(ibean);
		adminfacillitySystemmngtRootVO.setAuthorMenuList(list);
		
		mav.addObject("result", adminfacillitySystemmngtRootVO);
		
		return mav;
	}
}