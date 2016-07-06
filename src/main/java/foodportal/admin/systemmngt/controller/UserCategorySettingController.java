package foodportal.admin.systemmngt.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import websquare.system.adapter.annotation.BEAN_DEF;
import common.commonfacillity.log.CommonLog;
import common.commonfacillity.uia.WqBaseBean;
import common.commonfacillity.uia.WqResultBean;
import foodportal.admin.systemmngt.service.UserCategorySettingService;
import foodportal.admin.systemmngt.vo.AdminSystemmngtRootVO;
import foodportal.admin.systemmngt.vo.HCategorySettingVo;
import foodportal.admin.systemmngt.vo.UserCategorySettingVO;


/**
 * UserCategorySettingController
 * @author 박재형
 * @since 2014.09.03
 * @version 1.0
 * @see
 *
 * <pre>
 *  Modification Information
 *  수정일      수정자   수정내용
 *  ---------- -------- ---------------------------
 *  2014.09.03 박재형 최초 생성
 * </pre>
 *
 * Copyright (C) 2014 by NDS., All right reserved.
 */

@Controller                                                                                
public class UserCategorySettingController {

	@CommonLog Logger log;
	@Autowired
	private UserCategorySettingService userCategorySettingService;

	/**
	 * 사용자목록
	 * 
	 * @param 
	 * @return ModelAndView
	 * @throws Exception
	 */
	@RequestMapping(value = "/admin/systemmngt/selectUserList.do")
	@BEAN_DEF(beans={"root=foodportal.admin.systemmngt.vo.AdminSystemmngtRootVO", "paramUserCategorySetting=foodportal.admin.systemmngt.vo.UserCategorySettingVO", "userCategorySettingList=foodportal.admin.systemmngt.vo.UserCategorySettingVO"})
	public ModelAndView selectUserList(WqBaseBean ibean) throws Exception {
		
		ModelAndView mav = new ModelAndView("wqView");
		
		AdminSystemmngtRootVO adminSystemmngtRootVO = new AdminSystemmngtRootVO();
		List<UserCategorySettingVO> userCategorySettingList = userCategorySettingService.selectUserList(ibean);
		
		adminSystemmngtRootVO.setUserCategorySettingList(userCategorySettingList);
		mav.addObject("result", adminSystemmngtRootVO);
		
		return mav;
	}
	
	/**
	 * 사용자별 카테고리목록
	 * 
	 * @param 
	 * @return ModelAndView
	 * @throws Exception
	 */
	@RequestMapping(value = "/admin/systemmngt/selectCategoryList.do")
	@BEAN_DEF(beans={"root=foodportal.admin.systemmngt.vo.AdminSystemmngtRootVO", "paramUCategorySetting=foodportal.admin.systemmngt.vo.HCategorySettingVo", "uCategorySettingList=foodportal.admin.systemmngt.vo.HCategorySettingVo"})
	public ModelAndView selectCategoryList(WqBaseBean ibean) throws Exception {
		ModelAndView mav = new ModelAndView("wqView");
		
		AdminSystemmngtRootVO adminSystemmngtRootVO = new AdminSystemmngtRootVO();
		List<HCategorySettingVo> uCategorySettingList = userCategorySettingService.selectUCategoryList(ibean);
		
		adminSystemmngtRootVO.setuCategorySettingList(uCategorySettingList);
		mav.addObject("result", adminSystemmngtRootVO);
		
		return mav;
	}
	
	/**
	 * 사용중 메타정보 저장
	 * 
	 * @param 
	 * @return ModelAndView
	 * @throws Exception
	 */
	@RequestMapping(value = "/admin/systemmngt/updateUserCategorySetting.do")
	@BEAN_DEF(beans={"root=foodportal.admin.systemmngt.vo.AdminSystemmngtRootVO", "paramUCategorySettingList=foodportal.admin.systemmngt.vo.HCategorySettingVo", "uCategorySettingList=foodportal.admin.systemmngt.vo.HCategorySettingVo", "paramUCategorySetting=foodportal.admin.systemmngt.vo.HCategorySettingVo"})
	public ModelAndView updateUserCategorySetting(WqBaseBean ibean) throws Exception {
		ModelAndView mav = new ModelAndView("wqView");
		WqResultBean rtnResult = new WqResultBean();
		AdminSystemmngtRootVO adminSystemmngtRootVO = new AdminSystemmngtRootVO();
		List<HCategorySettingVo> uCategorySettingList = null;
		
		int result = userCategorySettingService.updateUserCategorySetting(ibean, "save");
		if(result == 1){
			rtnResult.setResult("정상적으로 저장되었습니다.");
			uCategorySettingList = userCategorySettingService.selectUCategoryList(ibean);
		} else {
			rtnResult.setResult("저장에 문제가 발생하였습니다.");
		}
		adminSystemmngtRootVO.setWqResultBean(rtnResult);
		adminSystemmngtRootVO.setuCategorySettingList(uCategorySettingList);
		
		mav.addObject("result", adminSystemmngtRootVO);
		
		return mav;
	}
	
	
}