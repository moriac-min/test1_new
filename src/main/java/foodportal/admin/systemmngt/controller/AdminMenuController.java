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

import foodportal.admin.systemmngt.service.AdminMenuService;
import foodportal.admin.systemmngt.vo.AdminSystemmngtRootVO;
import foodportal.admin.systemmngt.vo.BoardSettingVO;
import foodportal.admin.systemmngt.vo.MenuVO;


/**
 * AdminMenuController
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

@Controller                                                                                
public class AdminMenuController {

	@CommonLog Logger log;
	@Autowired
	private AdminMenuService adminMenuService;

	/**
	 * 메뉴 조회
	 * 
	 * @param 
	 * @return ModelAndView
	 * @throws Exception
	 */
	@RequestMapping(value = "/admin/systemmngt/selectMenuList.do")
	@BEAN_DEF(beans={"root=foodportal.admin.systemmngt.vo.AdminSystemmngtRootVO", "paramMenuList=foodportal.admin.systemmngt.vo.MenuVO", "menuList=foodportal.admin.systemmngt.vo.MenuVO"})
	public ModelAndView selectMenuList(WqBaseBean ibean) throws Exception {
		ModelAndView mav = new ModelAndView("wqView");
		
		AdminSystemmngtRootVO adminSystemmngtRootVO = new AdminSystemmngtRootVO();
		List<MenuVO> menuList = adminMenuService.selectMenuList(ibean);
		
		adminSystemmngtRootVO.setMenuList(menuList);
		mav.addObject("result", adminSystemmngtRootVO);
		
		return mav;
	}
	
	/**
	 * 메뉴 등록
	 * 
	 * @param 
	 * @return ModelAndView
	 * @throws Exception
	 */
	@RequestMapping(value = "/admin/systemmngt/saveMenu.do")
	@BEAN_DEF(beans={"root=foodportal.admin.systemmngt.vo.AdminSystemmngtRootVO","paramMenuInfo=foodportal.admin.systemmngt.vo.MenuVO","menuList=foodportal.admin.systemmngt.vo.MenuVO"})
	public ModelAndView saveMenu(WqBaseBean ibean) throws Exception {
		ModelAndView mav = new ModelAndView("wqView");
		WqResultBean rtnResult = new WqResultBean();
		
		AdminSystemmngtRootVO adminSystemmngtRootVO = new AdminSystemmngtRootVO();
		List<MenuVO> menuList = null;
		
		int result = adminMenuService.saveMenu(ibean);
		
		if(result == 1){
			rtnResult.setResult("정상적으로 저장되었습니다.");
			menuList = adminMenuService.selectMenuList(ibean);
		} else {
			rtnResult.setResult("저장에 문제가 발생하였습니다.");
		}
		adminSystemmngtRootVO.setWqResultBean(rtnResult);
		adminSystemmngtRootVO.setMenuList(menuList);
		
		mav.addObject("result", adminSystemmngtRootVO);
		
		return mav;
	}
	
	/**
	 * 메뉴 상세 조회
	 * 
	 * @param 
	 * @return ModelAndView
	 * @throws Exception
	 */
	@RequestMapping(value = "/admin/systemmngt/selectMenuDetail.do")
	@BEAN_DEF(beans={"root=foodportal.admin.systemmngt.vo.AdminSystemmngtRootVO", "paramMenuInfo=foodportal.admin.systemmngt.vo.MenuVO", "menuInfo=foodportal.admin.systemmngt.vo.MenuVO"})
	public ModelAndView selectMenuDetail(WqBaseBean ibean) throws Exception {
		ModelAndView mav = new ModelAndView("wqView");
		
		AdminSystemmngtRootVO adminSystemmngtRootVO = new AdminSystemmngtRootVO();
		MenuVO menuVO = adminMenuService.selectMenuDetail(ibean);
		
		adminSystemmngtRootVO.setMenuInfo(menuVO);
		mav.addObject("result", adminSystemmngtRootVO);
		
		return mav;
	}
	
	/**
	 * 메뉴 - 게시판목록조회
	 * 
	 * @param 
	 * @return ModelAndView
	 * @throws Exception
	 */
	@RequestMapping(value = "/admin/systemmngt/selectMenuBbsList.do")
	@BEAN_DEF(beans={"root=foodportal.admin.systemmngt.vo.AdminSystemmngtRootVO", "paramMenuInfo=foodportal.admin.systemmngt.vo.MenuVO", "boardSettingList=foodportal.admin.systemmngt.vo.BoardSettingVO"})
	public ModelAndView selectMenuBbsList(WqBaseBean ibean) throws Exception {
		ModelAndView mav = new ModelAndView("wqView");
		
		AdminSystemmngtRootVO adminSystemmngtRootVO = new AdminSystemmngtRootVO();
		List<BoardSettingVO> boardSettingList = adminMenuService.selectBoardSettingList(ibean);
		adminSystemmngtRootVO.setBoardSettingList(boardSettingList);

		mav.addObject("result", adminSystemmngtRootVO);
		
		return mav;
	}
	
	/**
	 * 메인 메뉴 조회
	 * 
	 * @param 
	 * @return ModelAndView
	 * @throws Exception
	 */
	@RequestMapping(value = "/admin/systemmngt/selectMainMenuList.do")
	@BEAN_DEF(beans={"root=foodportal.admin.systemmngt.vo.AdminSystemmngtRootVO", "paramMenuList=foodportal.admin.systemmngt.vo.MenuVO", "menuList=foodportal.admin.systemmngt.vo.MenuVO"})
	public ModelAndView selectMainMenuList(WqBaseBean ibean) throws Exception {
		ModelAndView mav = new ModelAndView("wqView");
		
		AdminSystemmngtRootVO adminSystemmngtRootVO = new AdminSystemmngtRootVO();
		List<MenuVO> menuList = adminMenuService.selectMainMenuList(ibean);
		
		adminSystemmngtRootVO.setMenuList(menuList);
		mav.addObject("result", adminSystemmngtRootVO);
		
		return mav;
	}
	
	/**
	 * 게시판이동 게시판목록조회
	 * 
	 * @param 
	 * @return ModelAndView
	 * @throws Exception
	 */
	@RequestMapping(value = "/admin/systemmngt/selectBbsMoveList.do")
	@BEAN_DEF(beans={"root=foodportal.admin.systemmngt.vo.AdminSystemmngtRootVO", "paramBbsMoveList=foodportal.admin.systemmngt.vo.MenuVO", "bbsMoveList=foodportal.admin.systemmngt.vo.MenuVO"})
	public ModelAndView selectBbsMoveList(WqBaseBean ibean) throws Exception {
		ModelAndView mav = new ModelAndView("wqView");
		
		AdminSystemmngtRootVO adminSystemmngtRootVO = new AdminSystemmngtRootVO();
		List<MenuVO> bbsMoveList = adminMenuService.selectBbsMoveList(ibean);
		
		adminSystemmngtRootVO.setBbsMoveList(bbsMoveList);
		mav.addObject("result", adminSystemmngtRootVO);
		
		return mav;
	}
	
	/**
	 * 게시판영역컨텐츠 목록
	 * 
	 * @param 
	 * @return ModelAndView
	 * @throws Exception
	 */
	@RequestMapping(value = "/admin/systemmngt/selectBbsRelmCntntsList.do")
	@BEAN_DEF(beans={"root=foodportal.admin.systemmngt.vo.AdminSystemmngtRootVO", "paramBbsRelmCntntsList=foodportal.admin.systemmngt.vo.MenuVO", "bbsRelmCntntsList=foodportal.admin.systemmngt.vo.MenuVO"})
	public ModelAndView selectBbsRelmCntntsList(WqBaseBean ibean) throws Exception {
		ModelAndView mav = new ModelAndView("wqView");
		
		AdminSystemmngtRootVO adminSystemmngtRootVO = new AdminSystemmngtRootVO();
		List<MenuVO> bbsRelmCntntsList = adminMenuService.selectBbsRelmCntntsList(ibean);
		
		adminSystemmngtRootVO.setBbsRelmCntntsList(bbsRelmCntntsList);
		mav.addObject("result", adminSystemmngtRootVO);
		
		return mav;
	}
	
	/**
	 * 게시판영역컨텐츠 메뉴 목록
	 * 
	 * @param 
	 * @return ModelAndView
	 * @throws Exception
	 */
	@RequestMapping(value = "/admin/systemmngt/selectBbsRelmMenuList.do")
	@BEAN_DEF(beans={"root=foodportal.admin.systemmngt.vo.AdminSystemmngtRootVO", "paramBbsRelmMenuList=foodportal.admin.systemmngt.vo.MenuVO", "bbsRelmMenuList=foodportal.admin.systemmngt.vo.MenuVO"})
	public ModelAndView selectBbsRelmMenuList(WqBaseBean ibean) throws Exception {
		ModelAndView mav = new ModelAndView("wqView");
		
		AdminSystemmngtRootVO adminSystemmngtRootVO = new AdminSystemmngtRootVO();
		List<MenuVO> bbsRelmMenuList = adminMenuService.selectBbsRelmMenuList(ibean);
		
		adminSystemmngtRootVO.setBbsRelmMenuList(bbsRelmMenuList);
		mav.addObject("result", adminSystemmngtRootVO);
		
		return mav;
	}
	
	
	/**
	 * 사용 게시판영역컨텐츠 등록
	 * 
	 * @param 
	 * @return ModelAndView
	 * @throws Exception
	 */
	@RequestMapping(value = "/admin/systemmngt/saveBbsRelmMenuList.do")
	@BEAN_DEF(beans={"root=foodportal.admin.systemmngt.vo.AdminSystemmngtRootVO", "paramSaveBbsRelmMenuList=foodportal.admin.systemmngt.vo.MenuVO", "paramBbsRelmMenuList=foodportal.admin.systemmngt.vo.MenuVO", "bbsRelmMenuList=foodportal.admin.systemmngt.vo.MenuVO"})
	public ModelAndView saveBbsRelmMenuList(WqBaseBean ibean) throws Exception {
		ModelAndView mav = new ModelAndView("wqView");
		WqResultBean rtnResult = new WqResultBean();
		
		AdminSystemmngtRootVO adminSystemmngtRootVO = new AdminSystemmngtRootVO();
		List<MenuVO> bbsRelmMenuList = null;
		
		int result = adminMenuService.saveUseBbsRelmCntntsList(ibean);
		
		if(result == 1){
			rtnResult.setResult("정상적으로 저장되었습니다.");
			bbsRelmMenuList = adminMenuService.selectBbsRelmMenuList(ibean);
		} else {
			rtnResult.setResult("저장에 문제가 발생하였습니다.");
		}
		adminSystemmngtRootVO.setWqResultBean(rtnResult);
		adminSystemmngtRootVO.setBbsRelmMenuList(bbsRelmMenuList);
		
		mav.addObject("result", adminSystemmngtRootVO);
		
		return mav;
	}
	
}