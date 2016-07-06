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

import foodportal.admin.systemmngt.service.AuthService;
import foodportal.admin.systemmngt.vo.AdminSystemmngtRootVO;
import foodportal.admin.systemmngt.vo.AuthVO;


/**
 * AuthController
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
public class AuthController {

	@CommonLog Logger log;
	
	@Autowired
	private AuthService authService;

	/**
	 * 권한 목록 조회
	 * 
	 * @param 
	 * @return ModelAndView
	 * @throws Exception
	 */
	@RequestMapping(value = "/admin/systemmngt/selectAuthList.do")
	@BEAN_DEF(beans={"root=foodportal.admin.systemmngt.vo.AdminSystemmngtRootVO", "auth=foodportal.admin.systemmngt.vo.AuthVO", "authList=foodportal.admin.systemmngt.vo.AuthVO"})
	public ModelAndView selectAuthList(WqBaseBean ibean) throws Exception {
		ModelAndView mav = new ModelAndView("wqView");
		
		AdminSystemmngtRootVO adminSystemmngtRootVO = new AdminSystemmngtRootVO();
		List<AuthVO> authList = authService.selectAuthList(ibean);
		adminSystemmngtRootVO.setAuthList(authList);
		
		mav.addObject("result", adminSystemmngtRootVO);
		
		return mav;
	}
	
	/**
	 * 권한 상세 조회
	 * 
	 * @param 
	 * @return ModelAndView
	 * @throws Exception
	 */
	@RequestMapping(value = "/admin/systemmngt/selectAuthDetail.do")
	@BEAN_DEF(beans={"root=foodportal.admin.systemmngt.vo.AdminSystemmngtRootVO", "auth=foodportal.admin.systemmngt.vo.AuthVO", "authList=foodportal.admin.systemmngt.vo.AuthVO"})
	public ModelAndView selectAuthDetail(WqBaseBean ibean) throws Exception {
		ModelAndView mav = new ModelAndView("wqView");
		
		AdminSystemmngtRootVO adminSystemmngtRootVO = new AdminSystemmngtRootVO();
		AuthVO authVO = authService.selectAuthDetail(ibean);
		adminSystemmngtRootVO.setAuth(authVO);
		
		mav.addObject("result", adminSystemmngtRootVO);
		
		return mav;
	}
	
	/**
	 * 권한 등록
	 * 
	 * @param 
	 * @return ModelAndView
	 * @throws Exception
	 */
	@RequestMapping(value = "/admin/systemmngt/insertAuth.do")
	@BEAN_DEF(beans={"root=foodportal.admin.systemmngt.vo.AdminSystemmngtRootVO", "auth=foodportal.admin.systemmngt.vo.AuthVO", "authList=foodportal.admin.systemmngt.vo.AuthVO"})
	public ModelAndView insertAuth(WqBaseBean ibean) throws Exception {
		ModelAndView mav = new ModelAndView("wqView");
		WqResultBean rtnResult = new WqResultBean();
		AdminSystemmngtRootVO adminSystemmngtRootVO = new AdminSystemmngtRootVO();
		
		int result = authService.insertAuth(ibean);
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
	 * 권한 수정
	 * 
	 * @param 
	 * @return ModelAndView
	 * @throws Exception
	 */
	@RequestMapping(value = "/admin/systemmngt/updateAuth.do")
	@BEAN_DEF(beans={"root=foodportal.admin.systemmngt.vo.AdminSystemmngtRootVO", "auth=foodportal.admin.systemmngt.vo.AuthVO", "authList=foodportal.admin.systemmngt.vo.AuthVO"})
	public ModelAndView updateAuth(WqBaseBean ibean) throws Exception {
		ModelAndView mav = new ModelAndView("wqView");
		WqResultBean rtnResult = new WqResultBean();
		AdminSystemmngtRootVO adminSystemmngtRootVO = new AdminSystemmngtRootVO();
		
		int result = authService.updateAuth(ibean);
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
	 * 권한 삭제
	 * 
	 * @param 
	 * @return ModelAndView
	 * @throws Exception
	 */
	@RequestMapping(value = "/admin/systemmngt/deleteAuth.do")
	@BEAN_DEF(beans={"root=foodportal.admin.systemmngt.vo.AdminSystemmngtRootVO", "auth=foodportal.admin.systemmngt.vo.AuthVO", "authList=foodportal.admin.systemmngt.vo.AuthVO"})
	public ModelAndView deleteAuth(WqBaseBean ibean) throws Exception {
		ModelAndView mav = new ModelAndView("wqView");
		WqResultBean rtnResult = new WqResultBean();
		AdminSystemmngtRootVO adminSystemmngtRootVO = new AdminSystemmngtRootVO();
		
		int result = authService.deleteAuth(ibean);
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
	 * 권한 저장
	 * 
	 * @param 
	 * @return ModelAndView
	 * @throws Exception
	 */
	@RequestMapping(value = "/admin/systemmngt/saveAuth.do")
	@BEAN_DEF(beans={"root=foodportal.admin.systemmngt.vo.AdminSystemmngtRootVO", "auth=foodportal.admin.systemmngt.vo.AuthVO", "authList=foodportal.admin.systemmngt.vo.AuthVO"})
	public ModelAndView saveAuth(WqBaseBean ibean) throws Exception {
		ModelAndView mav = new ModelAndView("wqView");
		WqResultBean rtnResult = new WqResultBean();
		AdminSystemmngtRootVO adminSystemmngtRootVO = new AdminSystemmngtRootVO();
		List<AuthVO> authList = null;
		
		int result = authService.saveAuth(ibean);
		log.debug("saveAuth result = " + result);
		if(result == 1){
			rtnResult.setResult("정상적으로 저장되었습니다.");
			
			authList = authService.selectAuthList(ibean);
		} else {
			rtnResult.setResult("저장에 문제가 발생하였습니다.");
		}
		
		adminSystemmngtRootVO.setWqResultBean(rtnResult);
		adminSystemmngtRootVO.setAuthList(authList);
		
		mav.addObject("result", adminSystemmngtRootVO);
		
		return mav;
	}
	
}