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
import foodportal.admin.systemmngt.service.UserAuthService;
import foodportal.admin.systemmngt.vo.AdminSystemmngtRootVO;
import foodportal.admin.systemmngt.vo.AuthVO;
import foodportal.admin.systemmngt.vo.UserAuthMenuVO;
import foodportal.admin.systemmngt.vo.UserAuthVO;
import foodportal.admin.systemmngt.vo.UserVO;


/**
 * UserAuthController
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
public class UserAuthController {

	@CommonLog Logger log;
	
	@Autowired
	private UserAuthService userAuthService;
	
	/**
	 * 사용자 목록 조회
	 * 
	 * @param 
	 * @return ModelAndView
	 * @throws Exception
	 */
	@RequestMapping(value = "/admin/systemmngt/userAuth/selectUserList.do")
	@BEAN_DEF(beans={"root=foodportal.admin.systemmngt.vo.AdminSystemmngtRootVO", "user=foodportal.admin.systemmngt.vo.UserVO", "userList=foodportal.admin.systemmngt.vo.UserVO"})
	public ModelAndView selectUserList(WqBaseBean ibean) throws Exception {
		ModelAndView mav = new ModelAndView("wqView");
		
		AdminSystemmngtRootVO adminSystemmngtRootVO = new AdminSystemmngtRootVO();
		List<UserVO> userList = userAuthService.selectUserList(ibean);
		adminSystemmngtRootVO.setUserList(userList);
		
		mav.addObject("result", adminSystemmngtRootVO);
		
		return mav;
	}
	
	/**
	 * 권한 목록 조회
	 * 
	 * @param 
	 * @return ModelAndView
	 * @throws Exception
	 */
	@RequestMapping(value = "/admin/systemmngt/userAuth/selectAuthList.do")
	@BEAN_DEF(beans={"root=foodportal.admin.systemmngt.vo.AdminSystemmngtRootVO", "auth=foodportal.admin.systemmngt.vo.AuthVO", "authList=foodportal.admin.systemmngt.vo.AuthVO"})
	public ModelAndView selectAuthList(WqBaseBean ibean) throws Exception {
		ModelAndView mav = new ModelAndView("wqView");
		
		AdminSystemmngtRootVO adminSystemmngtRootVO = new AdminSystemmngtRootVO();
		List<AuthVO> authList = userAuthService.selectAuthList(ibean);
		adminSystemmngtRootVO.setAuthList(authList);
		
		mav.addObject("result", adminSystemmngtRootVO);
		
		return mav;
	}

	/**
	 * 사용자별 권한 목록 조회
	 * 
	 * @param 
	 * @return ModelAndView
	 * @throws Exception
	 */
	@RequestMapping(value = "/admin/systemmngt/userAuth/selectUserAuthList.do")
	@BEAN_DEF(beans={"root=foodportal.admin.systemmngt.vo.AdminSystemmngtRootVO", "userAuth=foodportal.admin.systemmngt.vo.UserAuthVO", "userAuthList=foodportal.admin.systemmngt.vo.UserAuthVO"})
	public ModelAndView selectUserAuthList(WqBaseBean ibean) throws Exception {
		ModelAndView mav = new ModelAndView("wqView");
		
		AdminSystemmngtRootVO adminSystemmngtRootVO = new AdminSystemmngtRootVO();
		List<UserAuthVO> userAuthList = userAuthService.selectUserAuthList(ibean);
		adminSystemmngtRootVO.setUserAuthList(userAuthList);
		
		mav.addObject("result", adminSystemmngtRootVO);
		
		return mav;
	}
	
	/**
	 * 사용자별 권한 메뉴 목록 조회
	 * 
	 * @param 
	 * @return ModelAndView
	 * @throws Exception
	 */
	@RequestMapping(value = "/admin/systemmngt/userAuth/selectUserAuthMenuList.do")
	@BEAN_DEF(beans={"root=foodportal.admin.systemmngt.vo.AdminSystemmngtRootVO", "userAuthMenu=foodportal.admin.systemmngt.vo.UserAuthMenuVO", "userAuthMenuList=foodportal.admin.systemmngt.vo.UserAuthMenuVO"})
	public ModelAndView selectUserAuthMenuList(WqBaseBean ibean) throws Exception {
		ModelAndView mav = new ModelAndView("wqView");
		
		AdminSystemmngtRootVO adminSystemmngtRootVO = new AdminSystemmngtRootVO();
		List<UserAuthMenuVO> userAuthMenuList = userAuthService.selectUserAuthMenuList(ibean);
		adminSystemmngtRootVO.setUserAuthMenuList(userAuthMenuList);
		
		mav.addObject("result", adminSystemmngtRootVO);
		
		return mav;
	}
	
	/**
	 * 사용자별 권한 등록
	 * 
	 * @param 
	 * @return ModelAndView
	 * @throws Exception
	 */
	@RequestMapping(value = "/admin/systemmngt/userAuth/insertUserAuth.do")
	@BEAN_DEF(beans={"root=foodportal.admin.systemmngt.vo.AdminSystemmngtRootVO", "userAuth=foodportal.admin.systemmngt.vo.UserAuthVO", "userAuthList=foodportal.admin.systemmngt.vo.UserAuthVO"})
	public ModelAndView insertUserAuth(WqBaseBean ibean) throws Exception {
		ModelAndView mav = new ModelAndView("wqView");
		WqResultBean rtnResult = new WqResultBean();
		AdminSystemmngtRootVO adminSystemmngtRootVO = new AdminSystemmngtRootVO();
		
		int result = userAuthService.insertUserAuth(ibean);
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
	 * 사용자별 권한 수정
	 * 
	 * @param 
	 * @return ModelAndView
	 * @throws Exception
	 */
	@RequestMapping(value = "/admin/systemmngt/userAuth/updateUserAuth.do")
	@BEAN_DEF(beans={"root=foodportal.admin.systemmngt.vo.AdminSystemmngtRootVO", "userAuth=foodportal.admin.systemmngt.vo.UserAuthVO", "userAuthList=foodportal.admin.systemmngt.vo.UserAuthVO"})
	public ModelAndView updateUserAuth(WqBaseBean ibean) throws Exception {
		ModelAndView mav = new ModelAndView("wqView");
		WqResultBean rtnResult = new WqResultBean();
		AdminSystemmngtRootVO adminSystemmngtRootVO = new AdminSystemmngtRootVO();
		
		int result = userAuthService.updateUserAuth(ibean);
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
	 * 사용자별 권한 삭제
	 * 
	 * @param 
	 * @return ModelAndView
	 * @throws Exception
	 */
	@RequestMapping(value = "/admin/systemmngt/userAuth/deleteUserAuth.do")
	@BEAN_DEF(beans={"root=foodportal.admin.systemmngt.vo.AdminSystemmngtRootVO", "userAuth=foodportal.admin.systemmngt.vo.UserAuthVO", "userAuthList=foodportal.admin.systemmngt.vo.UserAuthVO"})
	public ModelAndView deleteUserAuth(WqBaseBean ibean) throws Exception {
		ModelAndView mav = new ModelAndView("wqView");
		WqResultBean rtnResult = new WqResultBean();
		AdminSystemmngtRootVO adminSystemmngtRootVO = new AdminSystemmngtRootVO();
		
		int result = userAuthService.deleteUserAuth(ibean);
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
	 * 사용자별 권한 저장
	 * 
	 * @param 
	 * @return ModelAndView
	 * @throws Exception
	 */
	@RequestMapping(value = "/admin/systemmngt/userAuth/saveUserAuth.do")
	@BEAN_DEF(beans={"root=foodportal.admin.systemmngt.vo.AdminSystemmngtRootVO", "userAuth=foodportal.admin.systemmngt.vo.UserAuthVO", "userAuthList=foodportal.admin.systemmngt.vo.UserAuthVO"})
	public ModelAndView saveUserAuth(WqBaseBean ibean) throws Exception {
		ModelAndView mav = new ModelAndView("wqView");
		WqResultBean rtnResult = new WqResultBean();
		AdminSystemmngtRootVO adminSystemmngtRootVO = new AdminSystemmngtRootVO();
		List<UserAuthVO> userAuthList = null;
		
		int result = userAuthService.saveUserAuth(ibean);
		log.debug("saveUserAuth result = " + result);
		if(result == 1){
			rtnResult.setResult("정상적으로 저장되었습니다.");
			
			userAuthList = userAuthService.selectUserAuthList(ibean);
		} else {
			rtnResult.setResult("저장에 문제가 발생하였습니다.");
		}
		
		adminSystemmngtRootVO.setWqResultBean(rtnResult);
		adminSystemmngtRootVO.setUserAuthList(userAuthList);
		
		mav.addObject("result", adminSystemmngtRootVO);
		
		return mav;
	}
	
}