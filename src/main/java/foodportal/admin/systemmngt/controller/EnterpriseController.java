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

import foodportal.admin.systemmngt.service.EnterpriseService;
import foodportal.admin.systemmngt.vo.AdminSystemmngtRootVO;
import foodportal.admin.systemmngt.vo.EnterpriseMemberVO;
import foodportal.admin.systemmngt.vo.EnterpriseVO;


/**
 * EnterpriseController
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
public class EnterpriseController {

	@CommonLog Logger log;
	
	@Autowired
	private EnterpriseService enterpriseService;
	
	/**
	 * 업체 목록 조회
	 * 
	 * @param 
	 * @return ModelAndView
	 * @throws Exception
	 */
	@RequestMapping(value = "/admin/systemmngt/enterprise/selectEnterpriseList.do")
	@BEAN_DEF(beans={"root=foodportal.admin.systemmngt.vo.AdminSystemmngtRootVO", "enterprise=foodportal.admin.systemmngt.vo.EnterpriseVO", "enterpriseList=foodportal.admin.systemmngt.vo.EnterpriseVO"})
	public ModelAndView selectUserList(WqBaseBean ibean) throws Exception {
		ModelAndView mav = new ModelAndView("wqView");
		
		AdminSystemmngtRootVO adminSystemmngtRootVO = new AdminSystemmngtRootVO();
		List<EnterpriseVO> enterpriseList = enterpriseService.selectEnterpriseList(ibean);
		adminSystemmngtRootVO.setEnterpriseList(enterpriseList);
		
		mav.addObject("result", adminSystemmngtRootVO);
		
		return mav;
	}
	
	/**
	 * 업체별 회원 목록 조회
	 * 
	 * @param 
	 * @return ModelAndView
	 * @throws Exception
	 */
	@RequestMapping(value = "/admin/systemmngt/enterprise/selectEnterpriseMemberList.do")
	@BEAN_DEF(beans={"root=foodportal.admin.systemmngt.vo.AdminSystemmngtRootVO", "enterpriseMember=foodportal.admin.systemmngt.vo.EnterpriseMemberVO", "enterpriseMemberList=foodportal.admin.systemmngt.vo.EnterpriseMemberVO"})
	public ModelAndView selectUserAuthList(WqBaseBean ibean) throws Exception {
		ModelAndView mav = new ModelAndView("wqView");
		
		AdminSystemmngtRootVO adminSystemmngtRootVO = new AdminSystemmngtRootVO();
		List<EnterpriseMemberVO> enterpriseMemberList = enterpriseService.selectEnterpriseMemberList(ibean);
		adminSystemmngtRootVO.setEnterpriseMemberList(enterpriseMemberList);
		
		mav.addObject("result", adminSystemmngtRootVO);
		
		return mav;
	}
	
}