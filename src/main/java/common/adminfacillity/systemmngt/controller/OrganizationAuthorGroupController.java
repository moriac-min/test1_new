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

import common.adminfacillity.systemmngt.service.OrganizationAuthorGroupService;
import common.adminfacillity.systemmngt.service.OrganizationAuthorGroupVO;
import common.adminfacillity.systemmngt.service.AuthorGroupVO;
import common.adminfacillity.systemmngt.service.AdminfacillitySystemmngtRootVO;

/**
 * OrganizationAuthorGroupController
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
public class OrganizationAuthorGroupController {

	@CommonLog Logger log;
	@Autowired
	private OrganizationAuthorGroupService organizationAuthorGroupService;

	/**
	 * 기관별 권한 그룹 조회
	 * 
	 * @param 
	 * @return ModelAndView
	 * @throws Exception
	 */
	@RequestMapping(value = "/adminfacillity/systemmngt/selectOrganizationAuthorGroup.do")
	@BEAN_DEF(beans={"root=common.adminfacillity.systemmngt.service.AdminfacillitySystemmngtRootVO", "organizationAuthorGroupVO=common.adminfacillity.systemmngt.service.OrganizationAuthorGroupVO", "infoList=common.adminfacillity.systemmngt.service.OrganizationAuthorGroupVO"})
	public ModelAndView selectOrganizationAuthorGroup(WqBaseBean ibean) throws Exception {
		ModelAndView mav = new ModelAndView("wqView");
		AdminfacillitySystemmngtRootVO adminfacillitySystemmngtRootVO = new AdminfacillitySystemmngtRootVO();
		List <OrganizationAuthorGroupVO> list = organizationAuthorGroupService.selectOrganizationAuthorGroup(ibean);
		adminfacillitySystemmngtRootVO.setInfoList(list);
		
		mav.addObject("result", adminfacillitySystemmngtRootVO);
		
		return mav;
	}

	/**
	 * 미등록 권한 그룹 조회
	 * 
	 * @param 
	 * @return ModelAndView
	 * @throws Exception
	 */
	@RequestMapping(value = "/adminfacillity/systemmngt/selectNoneRegAuthorGroup.do")
	@BEAN_DEF(beans={"root=common.adminfacillity.systemmngt.service.AdminfacillitySystemmngtRootVO", "authorGroupVO=common.adminfacillity.systemmngt.service.AuthorGroupVO", "infoList=common.adminfacillity.systemmngt.service.AuthorGroupVO"})
	public ModelAndView selectNoneRegAuthorGroup(WqBaseBean ibean) throws Exception {
		ModelAndView mav = new ModelAndView("wqView");
		AdminfacillitySystemmngtRootVO adminfacillitySystemmngtRootVO = new AdminfacillitySystemmngtRootVO();
		List<AuthorGroupVO> list = organizationAuthorGroupService.selectNoneRegAuthorGroup(ibean);
		adminfacillitySystemmngtRootVO.setInfoList(list);
		
		mav.addObject("result", adminfacillitySystemmngtRootVO);
		
		return mav;
	}
	
	/**
	 * 기관별 권한 그룹 저장
	 * 
	 * @param 
	 * @return ModelAndView
	 * @throws Exception
	 */
	@RequestMapping(value = "/adminfacillity/systemmngt/saveOrganizationAuthorGroup.do")
	@BEAN_DEF(beans={"root=common.adminfacillity.systemmngt.service.AdminfacillitySystemmngtRootVO", "organizationAuthorGroupVO=common.adminfacillity.systemmngt.service.OrganizationAuthorGroupVO", "authorGroupVO=common.adminfacillity.systemmngt.service.AuthorGroupVO", "infoList=common.adminfacillity.systemmngt.service.OrganizationAuthorGroupVO", "infoDataList=common.adminfacillity.systemmngt.service.AuthorGroupVO"})
	public ModelAndView saveOrganizationAuthorGroup(WqBaseBean ibean) throws Exception {
		ModelAndView mav = new ModelAndView("wqView");
		WqResultBean rtnResult = new WqResultBean();
		AdminfacillitySystemmngtRootVO outVo = new AdminfacillitySystemmngtRootVO();
		List<OrganizationAuthorGroupVO> list = null;
		List<AuthorGroupVO> listDtl = null;
		
		int result = organizationAuthorGroupService.saveOrganizationAuthorGroup(ibean);
		if(result == 1){
			rtnResult.setResult("정상적으로 반영되었습니다.");
			list = organizationAuthorGroupService.selectOrganizationAuthorGroup(ibean);
			listDtl = organizationAuthorGroupService.selectNoneRegAuthorGroup(ibean);
		} else {
			rtnResult.setResult("반영에 문제가 발생하였습니다.");
		}
		outVo.setWqResultBean(rtnResult);
		outVo.setInfoList(list);
		outVo.setInfoDataList(listDtl);
		
		mav.addObject("result", outVo);
		
		return mav;
	}

	/**
	 * 기관별 권한 그룹 등록
	 * 
	 * @param 
	 * @return ModelAndView
	 * @throws Exception
	 */
	@RequestMapping(value = "/adminfacillity/systemmngt/insertOrganizationAuthorGroup.do")
	@BEAN_DEF(beans={"root=common.adminfacillity.systemmngt.service.AdminfacillitySystemmngtRootVO", "organizationAuthorGroupVO=common.adminfacillity.systemmngt.service.AuthorGroupVO", "infoList=common.adminfacillity.systemmngt.service.OrganizationAuthorGroupVO"})
	public ModelAndView insertOrganizationAuthorGroup(WqBaseBean ibean) throws Exception {
		ModelAndView mav = new ModelAndView("wqView");
		WqResultBean rtnResult = new WqResultBean();
		AdminfacillitySystemmngtRootVO outVo = new AdminfacillitySystemmngtRootVO();
		List<OrganizationAuthorGroupVO> list = null;
		
		int result = organizationAuthorGroupService.insertOrganizationAuthorGroup(ibean);
		if(result == 1){
			rtnResult.setResult("정상적으로 저장되었습니다.");
			list = organizationAuthorGroupService.selectOrganizationAuthorGroup(ibean);
		} else {
			rtnResult.setResult("저장에 문제가 발생하였습니다.");
		}
		outVo.setWqResultBean(rtnResult);
		outVo.setInfoList(list);
		
		mav.addObject("result", outVo);
		
		return mav;
	}

	/**
	 * 기관별 권한 그룹 삭제
	 * 
	 * @param 
	 * @return ModelAndView
	 * @throws Exception
	 */
	@RequestMapping(value = "/adminfacillity/systemmngt/deleteOrganizationAuthorGroup.do")
	@BEAN_DEF(beans={"root=common.adminfacillity.systemmngt.service.AdminfacillitySystemmngtRootVO", "organizationAuthorGroupVO=common.adminfacillity.systemmngt.service.AuthorGroupVO", "infoList=common.adminfacillity.systemmngt.service.OrganizationAuthorGroupVO"})
	public ModelAndView deleteOrganizationAuthorGroup(WqBaseBean ibean) throws Exception {
		ModelAndView mav = new ModelAndView("wqView");
		WqResultBean rtnResult = new WqResultBean();
		AdminfacillitySystemmngtRootVO outVo = new AdminfacillitySystemmngtRootVO();
		List<OrganizationAuthorGroupVO> list = null;
		
		int result = organizationAuthorGroupService.deleteOrganizationAuthorGroup(ibean);
		if(result == 1){
			rtnResult.setResult("정상적으로 삭제되었습니다.");
			list = organizationAuthorGroupService.selectOrganizationAuthorGroup(ibean);
		} else {
			rtnResult.setResult("삭제에 문제가 발생하였습니다.");
		}
		outVo.setWqResultBean(rtnResult);
		outVo.setInfoList(list);
		
		mav.addObject("result", outVo);
		
		return mav;
	}
}