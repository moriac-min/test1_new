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
import foodportal.admin.systemmngt.service.HCategorySettingService;
import foodportal.admin.systemmngt.vo.AdminSystemmngtRootVO;
import foodportal.admin.systemmngt.vo.HCategorySettingVo;


/**
 * HCategorySettingController
 * @author 박재형
 * @since 2014.09.01
 * @version 1.0
 * @see
 *
 * <pre>
 *  Modification Information
 *  수정일      수정자   수정내용
 *  ---------- -------- ---------------------------
 *  2014.09.01 박재형 최초 생성
 * </pre>
 *
 * Copyright (C) 2014 by NDS., All right reserved.
 */

@Controller                                                                                
public class HCategorySettingController {

	@CommonLog Logger log;
	@Autowired
	private HCategorySettingService hCategorySettingService;

	/**
	 * 상위카테고리 목록 조회
	 * 
	 * @param 
	 * @return ModelAndView
	 * @throws Exception
	 */
	@RequestMapping(value = "/admin/systemmngt/selectHCategorySettingList.do")
	@BEAN_DEF(beans={"root=foodportal.admin.systemmngt.vo.AdminSystemmngtRootVO", "paramHCategory=foodportal.admin.systemmngt.vo.HCategorySettingVo", "hCategorySettingList=foodportal.admin.systemmngt.vo.HCategorySettingVo"})
	public ModelAndView selectHCategorySettingList(WqBaseBean ibean) throws Exception {
		ModelAndView mav = new ModelAndView("wqView");
		
		AdminSystemmngtRootVO adminSystemmngtRootVO = new AdminSystemmngtRootVO();
		List<HCategorySettingVo> hCategorySettingList = hCategorySettingService.selectHCategorySettingList(ibean);
		
		adminSystemmngtRootVO.sethCategorySettingList(hCategorySettingList);
		mav.addObject("result", adminSystemmngtRootVO);
		
		return mav;
	}
	
	/**
	 * 상위카테고리 저장
	 * 
	 * @param 
	 * @return ModelAndView
	 * @throws Exception
	 */
	@RequestMapping(value = "/admin/systemmngt/saveHCategorySettingList.do")
	@BEAN_DEF(beans={"root=foodportal.admin.systemmngt.vo.AdminSystemmngtRootVO", "paramHCategorySettingList=foodportal.admin.systemmngt.vo.HCategorySettingVo", "hCategorySettingList=foodportal.admin.systemmngt.vo.HCategorySettingVo", "paramHCategory=foodportal.admin.systemmngt.vo.HCategorySettingVo"})
	public ModelAndView saveHCategorySettingList(WqBaseBean ibean) throws Exception {
		ModelAndView mav = new ModelAndView("wqView");
		WqResultBean rtnResult = new WqResultBean();
		AdminSystemmngtRootVO adminSystemmngtRootVO = new AdminSystemmngtRootVO();
		List<HCategorySettingVo> hCategorySettingList = null;
		
		int result = hCategorySettingService.saveHCategorySettingList(ibean, "save");
		if(result == 1){
			rtnResult.setResult("정상적으로 저장되었습니다.");
			hCategorySettingList = hCategorySettingService.selectHCategorySettingList(ibean);
		} else {
			rtnResult.setResult("저장에 문제가 발생하였습니다.");
		}
		adminSystemmngtRootVO.setWqResultBean(rtnResult);
		adminSystemmngtRootVO.sethCategorySettingList(hCategorySettingList);
		
		mav.addObject("result", adminSystemmngtRootVO);
		
		return mav;
	}
	
	/**
	 * 상위카테고리 삭제
	 * 
	 * @param 
	 * @return ModelAndView
	 * @throws Exception
	 */
	@RequestMapping(value = "/admin/systemmngt/deleteHCategorySettingList.do")
	@BEAN_DEF(beans={"root=foodportal.admin.systemmngt.vo.AdminSystemmngtRootVO", "paramHCategorySettingList=foodportal.admin.systemmngt.vo.HCategorySettingVo", "hCategorySettingList=foodportal.admin.systemmngt.vo.HCategorySettingVo", "paramHCategory=foodportal.admin.systemmngt.vo.HCategorySettingVo"})
	public ModelAndView deleteHCategorySettingList(WqBaseBean ibean) throws Exception {
		ModelAndView mav = new ModelAndView("wqView");
		WqResultBean rtnResult = new WqResultBean();
		AdminSystemmngtRootVO adminSystemmngtRootVO = new AdminSystemmngtRootVO();
		List<HCategorySettingVo> hCategorySettingList = null;
		
		int result = hCategorySettingService.saveHCategorySettingList(ibean, "delete");
		if(result == 1){
			rtnResult.setResult("정상적으로 삭제되었습니다.");
			hCategorySettingList = hCategorySettingService.selectHCategorySettingList(ibean);
		} else {
			rtnResult.setResult("삭제에 문제가 발생하였습니다.");
		}
		adminSystemmngtRootVO.setWqResultBean(rtnResult);
		adminSystemmngtRootVO.sethCategorySettingList(hCategorySettingList);
		
		mav.addObject("result", adminSystemmngtRootVO);
		
		return mav;
	}
	
	/**
	 * 하위카테고리 목록 조회
	 * 
	 * @param 
	 * @return ModelAndView
	 * @throws Exception
	 */
	@RequestMapping(value = "/admin/systemmngt/selectLCategorySettingList.do")
	@BEAN_DEF(beans={"root=foodportal.admin.systemmngt.vo.AdminSystemmngtRootVO", "paramLCategory=foodportal.admin.systemmngt.vo.HCategorySettingVo", "lCategorySettingList=foodportal.admin.systemmngt.vo.HCategorySettingVo"})
	public ModelAndView selectLCategorySettingList(WqBaseBean ibean) throws Exception {
		ModelAndView mav = new ModelAndView("wqView");
		
		AdminSystemmngtRootVO adminSystemmngtRootVO = new AdminSystemmngtRootVO();
		List<HCategorySettingVo> lCategorySettingList = hCategorySettingService.selectLCategorySettingList(ibean);
		
		adminSystemmngtRootVO.setlCategorySettingList(lCategorySettingList);
		mav.addObject("result", adminSystemmngtRootVO);
		
		return mav;
	}
	
	/**
	 * 하위카테고리 저장
	 * 
	 * @param 
	 * @return ModelAndView
	 * @throws Exception
	 */
	@RequestMapping(value = "/admin/systemmngt/saveLCategorySettingList.do")
	@BEAN_DEF(beans={"root=foodportal.admin.systemmngt.vo.AdminSystemmngtRootVO", "paramLCategorySettingList=foodportal.admin.systemmngt.vo.HCategorySettingVo", "lCategorySettingList=foodportal.admin.systemmngt.vo.HCategorySettingVo", "paramLCategory=foodportal.admin.systemmngt.vo.HCategorySettingVo"})
	public ModelAndView saveLCategorySettingList(WqBaseBean ibean) throws Exception {
		ModelAndView mav = new ModelAndView("wqView");
		WqResultBean rtnResult = new WqResultBean();
		AdminSystemmngtRootVO adminSystemmngtRootVO = new AdminSystemmngtRootVO();
		List<HCategorySettingVo> lCategorySettingList = null;
		
		int result = hCategorySettingService.saveLCategorySettingList(ibean, "save");
		if(result == 1){
			rtnResult.setResult("정상적으로 저장되었습니다.");
			lCategorySettingList = hCategorySettingService.selectLCategorySettingList(ibean);
		} else {
			rtnResult.setResult("저장에 문제가 발생하였습니다.");
		}
		adminSystemmngtRootVO.setWqResultBean(rtnResult);
		adminSystemmngtRootVO.setlCategorySettingList(lCategorySettingList);
		
		mav.addObject("result", adminSystemmngtRootVO);
		
		return mav;
	}
	
	/**
	 * 하위카테고리 삭제
	 * 
	 * @param 
	 * @return ModelAndView
	 * @throws Exception
	 */
	@RequestMapping(value = "/admin/systemmngt/deleteLCategorySettingList.do")
	@BEAN_DEF(beans={"root=foodportal.admin.systemmngt.vo.AdminSystemmngtRootVO", "paramLCategorySettingList=foodportal.admin.systemmngt.vo.HCategorySettingVo", "lCategorySettingList=foodportal.admin.systemmngt.vo.HCategorySettingVo", "paramLCategory=foodportal.admin.systemmngt.vo.HCategorySettingVo"})
	public ModelAndView deleteLCategorySettingList(WqBaseBean ibean) throws Exception {
		ModelAndView mav = new ModelAndView("wqView");
		WqResultBean rtnResult = new WqResultBean();
		AdminSystemmngtRootVO adminSystemmngtRootVO = new AdminSystemmngtRootVO();
		List<HCategorySettingVo> lCategorySettingList = null;
		
		int result = hCategorySettingService.saveLCategorySettingList(ibean, "delete");
		if(result == 1){
			rtnResult.setResult("정상적으로 삭제되었습니다.");
			lCategorySettingList = hCategorySettingService.selectLCategorySettingList(ibean);
		} else {
			rtnResult.setResult("삭제에 문제가 발생하였습니다.");
		}
		adminSystemmngtRootVO.setWqResultBean(rtnResult);
		adminSystemmngtRootVO.setlCategorySettingList(lCategorySettingList);
		
		mav.addObject("result", adminSystemmngtRootVO);
		
		return mav;
	}
	
}