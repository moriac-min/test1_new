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

import common.adminfacillity.systemmngt.service.AuthorGroupService;
import common.adminfacillity.systemmngt.service.AuthorGroupVO;
import common.adminfacillity.systemmngt.service.AdminfacillitySystemmngtRootVO;

/**
 * AuthorGroupController
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
public class AuthorGroupController {

	@CommonLog Logger log;
	@Autowired
	private AuthorGroupService authorGroupService;

	/**
	 * 등록된 권한 그룹 정보 조회
	 * 
	 * @param 
	 * @return ModelAndView
	 * @throws Exception
	 */
	@RequestMapping(value = "/adminfacillity/systemmngt/selectAuthorGroup.do")
	@BEAN_DEF(beans={"root=common.adminfacillity.systemmngt.service.AdminfacillitySystemmngtRootVO", "authorGroupVO=common.adminfacillity.systemmngt.service.AuthorGroupVO", "infoList=common.adminfacillity.systemmngt.service.AuthorGroupVO"})
	public ModelAndView selectAuthorGroup(WqBaseBean ibean) throws Exception {
		ModelAndView mav = new ModelAndView("wqView");
		AdminfacillitySystemmngtRootVO adminfacillitySystemmngtRootVO = new AdminfacillitySystemmngtRootVO();
		List<AuthorGroupVO> list = authorGroupService.selectAuthorGroup(ibean);
		adminfacillitySystemmngtRootVO.setInfoList(list);
		
		mav.addObject("result", adminfacillitySystemmngtRootVO);
		
		return mav;
	}
	
	/**
	 * 신규 권한 그룹 정보 등록
	 * 
	 * @param 
	 * @return ModelAndView
	 * @throws Exception
	 */
	@RequestMapping(value = "/adminfacillity/systemmngt/saveAuthorGroup.do")
	@BEAN_DEF(beans={"root=common.adminfacillity.systemmngt.service.AdminfacillitySystemmngtRootVO", "authorGroupVO=common.adminfacillity.systemmngt.service.AuthorGroupVO", "infoList=common.adminfacillity.systemmngt.service.AuthorGroupVO"})
	public ModelAndView saveAuthorGroup(WqBaseBean ibean) throws Exception {
		ModelAndView mav = new ModelAndView("wqView");
		WqResultBean rtnResult = new WqResultBean();
		AdminfacillitySystemmngtRootVO outVo = new AdminfacillitySystemmngtRootVO();
		List<AuthorGroupVO> list = null;
		
		int result = authorGroupService.saveAuthorGroup(ibean);
		if(result == 1){
			rtnResult.setResult("정상적으로 저장되었습니다.");
			list = authorGroupService.selectAuthorGroup(ibean);
		} else {
			rtnResult.setResult("저장에 문제가 발생하였습니다.");
		}
		outVo.setWqResultBean(rtnResult);
		outVo.setInfoList(list);
		
		mav.addObject("result", outVo);
		
		return mav;
	}

	/**
	 * 신규 권한 그룹 정보 등록
	 * 
	 * @param 
	 * @return ModelAndView
	 * @throws Exception
	 */
	@RequestMapping(value = "/adminfacillity/systemmngt/insertAuthorGroup.do")
	@BEAN_DEF(beans={"root=common.adminfacillity.systemmngt.service.AdminfacillitySystemmngtRootVO", "authorGroupVO=common.adminfacillity.systemmngt.service.AuthorGroupVO", "infoList=common.adminfacillity.systemmngt.service.AuthorGroupVO"})
	public ModelAndView insertAuthorGroup(WqBaseBean ibean) throws Exception {
		ModelAndView mav = new ModelAndView("wqView");
		WqResultBean rtnResult = new WqResultBean();
		AdminfacillitySystemmngtRootVO outVo = new AdminfacillitySystemmngtRootVO();
		List<AuthorGroupVO> list = null;
		
		int result = authorGroupService.insertAuthorGroup(ibean);
		if(result == 1){
			rtnResult.setResult("정상적으로 입력되었습니다.");
			list = authorGroupService.selectAuthorGroup(ibean);
		} else {
			rtnResult.setResult("입력에 문제가 발생하였습니다.");
		}
		outVo.setWqResultBean(rtnResult);
		outVo.setInfoList(list);
		
		mav.addObject("result", outVo);
		
		return mav;
	}

	/**
	 * 등록된 권한 그룹 정보 삭제
	 * 
	 * @param 
	 * @return ModelAndView
	 * @throws Exception
	 */
	@RequestMapping(value = "/adminfacillity/systemmngt/deleteAuthorGroup.do")
	@BEAN_DEF(beans={"root=common.adminfacillity.systemmngt.service.AdminfacillitySystemmngtRootVO", "authorGroupVO=common.adminfacillity.systemmngt.service.AuthorGroupVO", "infoList=common.adminfacillity.systemmngt.service.AuthorGroupVO"})
	public ModelAndView deleteAuthorGroup(WqBaseBean ibean) throws Exception {
		ModelAndView mav = new ModelAndView("wqView");
		WqResultBean rtnResult = new WqResultBean();
		AdminfacillitySystemmngtRootVO outVo = new AdminfacillitySystemmngtRootVO();
		List<AuthorGroupVO> list = null;
		
		int result = authorGroupService.deleteAuthorGroup(ibean);
		if(result == 1){
			rtnResult.setResult("정상적으로 삭제되었습니다.");
			list = authorGroupService.selectAuthorGroup(ibean);
		} else {
			rtnResult.setResult("삭제에 문제가 발생하였습니다.");
		}
		outVo.setWqResultBean(rtnResult);
		outVo.setInfoList(list);
		
		mav.addObject("result", outVo);
		
		return mav;
	}

	/**
	 * 등록된 권한 그룹 정보 수정
	 * 
	 * @param 
	 * @return ModelAndView
	 * @throws Exception
	 */
	@RequestMapping(value = "/adminfacillity/systemmngt/updateAuthorGroup.do")
	@BEAN_DEF(beans={"root=common.adminfacillity.systemmngt.service.AdminfacillitySystemmngtRootVO", "authorGroupVO=common.adminfacillity.systemmngt.service.AuthorGroupVO", "infoList=common.adminfacillity.systemmngt.service.AuthorGroupVO"})
	public ModelAndView updateAuthorGroup(WqBaseBean ibean) throws Exception {
		ModelAndView mav = new ModelAndView("wqView");
		WqResultBean rtnResult = new WqResultBean();
		AdminfacillitySystemmngtRootVO outVo = new AdminfacillitySystemmngtRootVO();
		List<AuthorGroupVO> list = null;
		
		int result = authorGroupService.updateAuthorGroup(ibean);
		if(result == 1){
			rtnResult.setResult("정상적으로 수정되었습니다.");
			list = authorGroupService.selectAuthorGroup(ibean);
		} else {
			rtnResult.setResult("수정에 문제가 발생하였습니다.");
		}
		outVo.setWqResultBean(rtnResult);
		outVo.setInfoList(list);
		
		mav.addObject("result", outVo);
		
		return mav;
	}
}