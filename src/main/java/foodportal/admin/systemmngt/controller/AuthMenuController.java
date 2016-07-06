package foodportal.admin.systemmngt.controller;

import java.util.List;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import websquare.system.adapter.annotation.BEAN_DEF;
import common.commonfacillity.log.CommonLog;
import common.commonfacillity.uia.WqBaseBean;
import common.commonfacillity.uia.WqResultBean;
import foodportal.admin.systemmngt.service.AuthMenuService;
import foodportal.admin.systemmngt.vo.AdminSystemmngtRootVO;
import foodportal.admin.systemmngt.vo.AuthMenuVO;
import foodportal.admin.systemmngt.vo.AuthVO;
import foodportal.admin.systemmngt.vo.MenuVO;


/**
 * AuthMenuController
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

@Controller                                                                                
public class AuthMenuController {

	@CommonLog Logger log;
	
	@Autowired
	private AuthMenuService authMenuService;
	
	/**
	 * 권한 목록 조회
	 * 
	 * @param 
	 * @return ModelAndView
	 * @throws Exception
	 */
	@RequestMapping(value = "/admin/systemmngt/authMenu/selectAuthList.do")
	@BEAN_DEF(beans={"root=foodportal.admin.systemmngt.vo.AdminSystemmngtRootVO", "auth=foodportal.admin.systemmngt.vo.AuthVO", "authList=foodportal.admin.systemmngt.vo.AuthVO"})
	public ModelAndView selectAuthList(WqBaseBean ibean) throws Exception {
		ModelAndView mav = new ModelAndView("wqView");
		
		AdminSystemmngtRootVO adminSystemmngtRootVO = new AdminSystemmngtRootVO();
		List<AuthVO> authList = authMenuService.selectAuthList(ibean);
		adminSystemmngtRootVO.setAuthList(authList);
		
		mav.addObject("result", adminSystemmngtRootVO);
		
		return mav;
	}
	
	/**
	 * 메뉴 목록 조회
	 * 
	 * @param 
	 * @return ModelAndView
	 * @throws Exception
	 */
	@RequestMapping(value = "/admin/systemmngt/authMenu/selectMenuList.do")
	@BEAN_DEF(beans={"root=foodportal.admin.systemmngt.vo.AdminSystemmngtRootVO", "menu=foodportal.admin.systemmngt.vo.MenuVO", "menuList=foodportal.admin.systemmngt.vo.MenuVO"})
	public ModelAndView selectMenuList(WqBaseBean ibean) throws Exception {
		ModelAndView mav = new ModelAndView("wqView");
		
		AdminSystemmngtRootVO adminSystemmngtRootVO = new AdminSystemmngtRootVO();
		List<MenuVO> menuList = authMenuService.selectMenuList(ibean);
		adminSystemmngtRootVO.setMenuList(menuList);
		
		mav.addObject("result", adminSystemmngtRootVO);
		
		return mav;
	}

	/**
	 * 권한별 메뉴 목록 조회
	 * 
	 * @param 
	 * @return ModelAndView
	 * @throws Exception
	 */
	@RequestMapping(value = "/admin/systemmngt/authMenu/selectAuthMenuList.do")
	@BEAN_DEF(beans={"root=foodportal.admin.systemmngt.vo.AdminSystemmngtRootVO", "authMenu=foodportal.admin.systemmngt.vo.AuthMenuVO", "authMenuList=foodportal.admin.systemmngt.vo.AuthMenuVO"})
	public ModelAndView selectAuthMenuList(WqBaseBean ibean) throws Exception {
		ModelAndView mav = new ModelAndView("wqView");
		
		AdminSystemmngtRootVO adminSystemmngtRootVO = new AdminSystemmngtRootVO();
		List<AuthMenuVO> authMenuList = authMenuService.selectAuthMenuList(ibean);
		adminSystemmngtRootVO.setAuthMenuList(authMenuList);
		
		mav.addObject("result", adminSystemmngtRootVO);
		
		return mav;
	}
	
	/**
	 * 권한별 메뉴 등록
	 * 
	 * @param 
	 * @return ModelAndView
	 * @throws Exception
	 */
	@RequestMapping(value = "/admin/systemmngt/authMenu/insertAuthMenu.do")
	@BEAN_DEF(beans={"root=foodportal.admin.systemmngt.vo.AdminSystemmngtRootVO", "authMenu=foodportal.admin.systemmngt.vo.AuthMenuVO", "authMenuList=foodportal.admin.systemmngt.vo.AuthMenuVO"})
	public ModelAndView insertAuthMenu(WqBaseBean ibean) throws Exception {
		ModelAndView mav = new ModelAndView("wqView");
		WqResultBean rtnResult = new WqResultBean();
		AdminSystemmngtRootVO adminSystemmngtRootVO = new AdminSystemmngtRootVO();
		
		int result = authMenuService.insertAuthMenu(ibean);
		if(result == 1){
			rtnResult.setResult("정상적으로 등록되었습니다.");
		} else {
			rtnResult.setResult("등록에 문제가 발생하였습니다.");
		}
		adminSystemmngtRootVO.setWqResultBean(rtnResult);
		
		mav.addObject("result", adminSystemmngtRootVO);
		
		return mav;
	}
	
	/**
	 * 권한별 메뉴 수정
	 * 
	 * @param 
	 * @return ModelAndView
	 * @throws Exception
	 */
	@RequestMapping(value = "/admin/systemmngt/authMenu/updateAuthMenu.do")
	@BEAN_DEF(beans={"root=foodportal.admin.systemmngt.vo.AdminSystemmngtRootVO", "authMenu=foodportal.admin.systemmngt.vo.AuthMenuVO", "authMenuList=foodportal.admin.systemmngt.vo.AuthMenuVO"})
	public ModelAndView updateAuthMenu(WqBaseBean ibean) throws Exception {
		ModelAndView mav = new ModelAndView("wqView");
		WqResultBean rtnResult = new WqResultBean();
		AdminSystemmngtRootVO adminSystemmngtRootVO = new AdminSystemmngtRootVO();
		
		int result = authMenuService.updateAuthMenu(ibean);
		if(result == 1){
			rtnResult.setResult("정상적으로 수정되었습니다.");
		} else {
			rtnResult.setResult("수정에 문제가 발생하였습니다.");
		}
		adminSystemmngtRootVO.setWqResultBean(rtnResult);
		
		mav.addObject("result", adminSystemmngtRootVO);
		
		return mav;
	}
	
	/**
	 * 권한별 메뉴 삭제
	 * 
	 * @param 
	 * @return ModelAndView
	 * @throws Exception
	 */
	@RequestMapping(value = "/admin/systemmngt/authMenu/deleteAuthMenu.do")
	@BEAN_DEF(beans={"root=foodportal.admin.systemmngt.vo.AdminSystemmngtRootVO", "authMenu=foodportal.admin.systemmngt.vo.AuthMenuVO", "authMenuList=foodportal.admin.systemmngt.vo.AuthMenuVO"})
	public ModelAndView deleteAuthMenu(WqBaseBean ibean) throws Exception {
		ModelAndView mav = new ModelAndView("wqView");
		WqResultBean rtnResult = new WqResultBean();
		AdminSystemmngtRootVO adminSystemmngtRootVO = new AdminSystemmngtRootVO();
		
		int result = authMenuService.deleteAuthMenu(ibean);
		if(result == 1){
			rtnResult.setResult("정상적으로 삭제되었습니다.");
		} else {
			rtnResult.setResult("삭제에 문제가 발생하였습니다.");
		}
		adminSystemmngtRootVO.setWqResultBean(rtnResult);
		
		mav.addObject("result", adminSystemmngtRootVO);
		
		return mav;
	}
	
	/**
	 * 권한별 메뉴 저장
	 * 
	 * @param 
	 * @return ModelAndView
	 * @throws Exception
	 */
	@RequestMapping(value = "/admin/systemmngt/authMenu/saveAuthMenu.do")
	@BEAN_DEF(beans={"root=foodportal.admin.systemmngt.vo.AdminSystemmngtRootVO", "authMenu=foodportal.admin.systemmngt.vo.AuthMenuVO", "authMenuList=foodportal.admin.systemmngt.vo.AuthMenuVO"})
	public ModelAndView saveAuthMenu(WqBaseBean ibean) throws Exception {
		ModelAndView mav = new ModelAndView("wqView");
		WqResultBean rtnResult = new WqResultBean();
		AdminSystemmngtRootVO adminSystemmngtRootVO = new AdminSystemmngtRootVO();
		List<AuthMenuVO> authMenuList = null;
		
		int result = authMenuService.saveAuthMenu(ibean);
		log.debug("saveAuthMenu result = " + result);
		if(result == 1){
			rtnResult.setResult("정상적으로 저장되었습니다.");
			
			authMenuList = authMenuService.selectAuthMenuList(ibean);
		} else {
			rtnResult.setResult("저장에 문제가 발생하였습니다.");
		}
		
		adminSystemmngtRootVO.setWqResultBean(rtnResult);
		adminSystemmngtRootVO.setAuthMenuList(authMenuList);
		
		mav.addObject("result", adminSystemmngtRootVO);
		
		return mav;
	}
	
}