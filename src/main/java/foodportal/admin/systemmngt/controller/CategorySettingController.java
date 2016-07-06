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

import foodportal.admin.systemmngt.service.CategorySettingService;
import foodportal.admin.systemmngt.vo.AdminSystemmngtRootVO;
import foodportal.admin.systemmngt.vo.CategorySettingVO;

/**
 * CategorySettingController
 * @author 장영철
 * @since 2014.09.01
 * @version 1.0
 * @see
 *
 * <pre>
 *  Modification Information
 *  수정일      수정자   수정내용
 *  ---------- -------- ---------------------------
 *  2014.09.01 장영철 최초 생성
 * </pre>
 *
 * Copyright (C) 2014 by NDS., All right reserved.
 */


@Controller 
public class CategorySettingController {
	
	@CommonLog Logger log;
	@Autowired
	private CategorySettingService categorySettingService;
	
	/**
	 * 카테고리 목록 조회
	 * 
	 * @param
	 * @return ModelAndView
	 * @throws Exception
	 */
	@RequestMapping(value = "/admin/systemmngt/selectCategorySettingList.do")
	@BEAN_DEF(beans={"root=foodportal.admin.systemmngt.vo.AdminSystemmngtRootVO", "paramCategory=foodportal.admin.systemmngt.vo.CategorySettingVo", "categoryList=foodportal.admin.systemmngt.vo.CategorySettingVo"})
	public ModelAndView selectCategorySettingList(WqBaseBean ibean) throws Exception{
		ModelAndView mav = new ModelAndView("wqView");
		
		AdminSystemmngtRootVO adminSystemmngtRootVO = new AdminSystemmngtRootVO();
		List<CategorySettingVO> categoryList = categorySettingService.selectCategorySettingList(ibean);
		
		adminSystemmngtRootVO.setCategoryList(categoryList);
		mav.addObject("result", adminSystemmngtRootVO);
		
		return mav;
	}

	/**
	 * 카테고리 저장
	 * 
	 * @param
	 * @return ModelAndView
	 * @throws Exception
	 */
	@RequestMapping(value = "/admin/systemmngt/saveCategorySetting.do")
	@BEAN_DEF(beans={"root=foodportal.admin.systemmngt.vo.AdminSystemmngtRootVO"
			, "paramCategory=foodportal.admin.systemmngt.vo.CategorySettingVo"
			, "paramRmCtgryList=foodportal.admin.systemmngt.vo.CategorySettingVo"
			, "paramCategoryList=foodportal.admin.systemmngt.vo.CategorySettingVo"
			, "categoryList=foodportal.admin.systemmngt.vo.CategorySettingVo"})
	public ModelAndView saveCategorySetting(WqBaseBean ibean) throws Exception{
		ModelAndView mav = new ModelAndView("wqView");
		WqResultBean rtnResult = new WqResultBean();
		
		AdminSystemmngtRootVO adminSystemmngtRootVO = new AdminSystemmngtRootVO();
		List<CategorySettingVO> categoryList = null;
		
		int result = categorySettingService.saveCategorySetting(ibean);
		
		if(result == 1){
			rtnResult.setResult("정상적으로 저장되었습니다.");
			categoryList = categorySettingService.selectCategorySettingList(ibean);
		} else {
			rtnResult.setResult("저장에 문제가 발생하였습니다.");
		}
		
		adminSystemmngtRootVO.setWqResultBean(rtnResult);
		adminSystemmngtRootVO.setCategoryList(categoryList);
		
		mav.addObject("result", adminSystemmngtRootVO);
		
		return mav;
	}
}
