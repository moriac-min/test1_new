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

import common.adminfacillity.systemmngt.service.OrganizationService;
import common.adminfacillity.systemmngt.service.OrganizationVO;
import common.adminfacillity.systemmngt.service.AdminfacillitySystemmngtRootVO;
/**
 * OrganizationController
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
public class OrganizationController {

	@CommonLog Logger log;
	@Autowired
	private OrganizationService organizationService;

	/**
	 * 기관 조회
	 * 
	 * @param 
	 * @return ModelAndView
	 * @throws Exception
	 */
	@RequestMapping(value = "/adminfacillity/systemmngt/selectOrganization.do")
	@BEAN_DEF(beans={"root=common.adminfacillity.systemmngt.service.AdminfacillitySystemmngtRootVO", "organizationVO=common.adminfacillity.systemmngt.service.OrganizationVO", "infoList=common.adminfacillity.systemmngt.service.OrganizationVO"})
	public ModelAndView selectOrganization(WqBaseBean ibean) throws Exception {
		ModelAndView mav = new ModelAndView("wqView");
		AdminfacillitySystemmngtRootVO adminfacillitySystemmngtRootVO = new AdminfacillitySystemmngtRootVO();
		List<OrganizationVO> list = organizationService.selectOrganization(ibean);
		adminfacillitySystemmngtRootVO.setInfoList(list);
		
		mav.addObject("result", adminfacillitySystemmngtRootVO);
		
		return mav;
	}

	/**
	 * 기관 등록
	 * 
	 * @param 
	 * @return ModelAndView
	 * @throws Exception
	 */
	@RequestMapping(value = "/adminfacillity/systemmngt/insertOrganization.do")
	@BEAN_DEF(beans={"root=common.adminfacillity.systemmngt.service.AdminfacillitySystemmngtRootVO", "organizationVO=common.adminfacillity.systemmngt.service.OrganizationVO", "infoList=common.adminfacillity.systemmngt.service.OrganizationVO"})
	public ModelAndView insertOrganization(WqBaseBean ibean) throws Exception {
		ModelAndView mav = new ModelAndView("wqView");
		WqResultBean rtnResult = new WqResultBean();
		AdminfacillitySystemmngtRootVO outVo = new AdminfacillitySystemmngtRootVO();
		List<OrganizationVO> list = null;
		
		int result = organizationService.insertOrganization(ibean);
		if(result == 1){
			rtnResult.setResult("정상적으로 입력되었습니다.");
			list = organizationService.selectOrganization(ibean);
		} else {
			rtnResult.setResult("입력에 문제가 발생하였습니다.");
		}
		outVo.setWqResultBean(rtnResult);
		outVo.setInfoList(list);
		
		mav.addObject("result", outVo);
		
		return mav;
	}

	/**
	 * 기관 수정
	 * 
	 * @param 
	 * @return ModelAndView
	 * @throws Exception
	 */
	@RequestMapping(value = "/adminfacillity/systemmngt/updateOrganization.do")
	@BEAN_DEF(beans={"root=common.adminfacillity.systemmngt.service.AdminfacillitySystemmngtRootVO", "organizationVO=common.adminfacillity.systemmngt.service.OrganizationVO", "infoList=common.adminfacillity.systemmngt.service.OrganizationVO"})
	public ModelAndView updateOrganization(WqBaseBean ibean) throws Exception {
		ModelAndView mav = new ModelAndView("wqView");
		WqResultBean rtnResult = new WqResultBean();
		AdminfacillitySystemmngtRootVO outVo = new AdminfacillitySystemmngtRootVO();
		List<OrganizationVO> list = null;
		
		int result = organizationService.updateOrganization(ibean);
		if(result == 1){
			rtnResult.setResult("정상적으로 수정되었습니다.");
			list = organizationService.selectOrganization(ibean);
		} else {
			rtnResult.setResult("수정에 문제가 발생하였습니다.");
		}
		outVo.setWqResultBean(rtnResult);
		outVo.setInfoList(list);
		
		mav.addObject("result", outVo);
		
		return mav;
	}

	/**
	 * 기관 삭제
	 * 
	 * @param 
	 * @return ModelAndView
	 * @throws Exception
	 */
	@RequestMapping(value = "/adminfacillity/systemmngt/deleteOrganization.do")
	@BEAN_DEF(beans={"root=common.adminfacillity.systemmngt.service.AdminfacillitySystemmngtRootVO", "organizationVO=common.adminfacillity.systemmngt.service.OrganizationVO", "infoList=common.adminfacillity.systemmngt.service.OrganizationVO"})
	public ModelAndView deleteOrganization(WqBaseBean ibean) throws Exception {
		ModelAndView mav = new ModelAndView("wqView");
		WqResultBean rtnResult = new WqResultBean();
		AdminfacillitySystemmngtRootVO outVo = new AdminfacillitySystemmngtRootVO();
		List<OrganizationVO> list = null;
		
		int result = organizationService.deleteOrganization(ibean);
		if(result == 1){
			rtnResult.setResult("정상적으로 삭제되었습니다.");
			list = organizationService.selectOrganization(ibean);
		} else {
			rtnResult.setResult("삭제에 문제가 발생하였습니다.");
		}
		outVo.setWqResultBean(rtnResult);
		outVo.setInfoList(list);
		
		mav.addObject("result", outVo);
		
		return mav;
	}
}