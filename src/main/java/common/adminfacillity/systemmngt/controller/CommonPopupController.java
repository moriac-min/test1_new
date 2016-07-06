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

import common.adminfacillity.systemmngt.service.CommonPopupService;
import common.adminfacillity.systemmngt.service.AdminfacillitySystemmngtRootVO;
import common.adminfacillity.systemmngt.service.CommonPopupVO;
import common.adminfacillity.systemmngt.service.CommonPopupItemVO;

/**
 * CommonPopupController
 * @author 유승엽
 * @since 2014.08.19
 * @version 1.0
 * @see
 *
 * <pre>
 *  Modification Information
 *  수정일      수정자   수정내용
 *  ---------- -------- ---------------------------
 *  2014.08.19 유승엽 최초 생성
 * </pre>
 *
 * Copyright (C) 2014 by NDS., All right reserved.
 */

@Controller                                                                                
public class CommonPopupController {

	@CommonLog Logger log;
	@Autowired
	private CommonPopupService commonPopupService;

	/**
	 * 등록된 공통팝업 정보 조회
	 * 
	 * @param 
	 * @return ModelAndView
	 * @throws Exception
	 */
	@RequestMapping(value = "/adminfacillity/systemmngt/selectCommonPopup.do")
	@BEAN_DEF(beans={"root=common.adminfacillity.systemmngt.service.AdminfacillitySystemmngtRootVO", "CommonPopupVO=common.adminfacillity.systemmngt.service.CommonPopupVO", "infoList=common.adminfacillity.systemmngt.service.CommonPopupVO"})
	public ModelAndView selectCommonPopup(WqBaseBean ibean) throws Exception {
		ModelAndView mav = new ModelAndView("wqView");
		AdminfacillitySystemmngtRootVO adminfacillitySystemmngtRootVO = new AdminfacillitySystemmngtRootVO();
		List<CommonPopupVO> list = commonPopupService.selectCommonPopup(ibean);
		adminfacillitySystemmngtRootVO.setInfoList(list);
		mav.addObject("result", adminfacillitySystemmngtRootVO);
		
		return mav;
	}

	/**
	 * 신규 공통팝업 정보 저장
	 * 
	 * @param 
	 * @return ModelAndView
	 * @throws Exception
	 */
	@RequestMapping(value = "/adminfacillity/systemmngt/saveCommonPopup.do")
	@BEAN_DEF(beans={"root=common.adminfacillity.systemmngt.service.AdminfacillitySystemmngtRootVO", "infoList=common.adminfacillity.systemmngt.service.CommonPopupVO", "infoDataList=common.adminfacillity.systemmngt.service.CommonPopupItemVO"})
	public ModelAndView saveCommonPopup(WqBaseBean ibean) throws Exception {
		ModelAndView mav = new ModelAndView("wqView");
		WqResultBean rtnResult = new WqResultBean();
		AdminfacillitySystemmngtRootVO outVo = new AdminfacillitySystemmngtRootVO();
		
		int result = commonPopupService.saveCommonPopup(ibean);
		log.debug("saveCommonPopupList result = " + result);
		if(result == 1){
			rtnResult.setResult("정상적으로 저장되었습니다.");
		} else {
			rtnResult.setResult("저장에 문제가 발생하였습니다.");
		}
		
		outVo.setWqResultBean(rtnResult);
		
		mav.addObject("result", outVo);
		
		return mav;
	}

	/**
	 * 등록된 공통팝업항목 정보 조회
	 * 
	 * @param 
	 * @return ModelAndView
	 * @throws Exception
	 */
	@RequestMapping(value = "/adminfacillity/systemmngt/selectCommonPopupItem.do")
	@BEAN_DEF(beans={"root=common.adminfacillity.systemmngt.service.AdminfacillitySystemmngtRootVO", "CommonPopupItemVO=common.adminfacillity.systemmngt.service.CommonPopupItemVO", "infoList=common.adminfacillity.systemmngt.service.CommonPopupItemVO"})
	public ModelAndView selectCommonPopupItem(WqBaseBean ibean) throws Exception {
		ModelAndView mav = new ModelAndView("wqView");
		AdminfacillitySystemmngtRootVO adminfacillitySystemmngtRootVO = new AdminfacillitySystemmngtRootVO();
		List<CommonPopupItemVO> list = commonPopupService.selectCommonPopupItem(ibean);
		adminfacillitySystemmngtRootVO.setInfoList(list);
		mav.addObject("result", adminfacillitySystemmngtRootVO);
		
		return mav;
	}

	/**
	 * 신규 공통팝업항목 정보 등록
	 * 
	 * @param 
	 * @return ModelAndView
	 * @throws Exception
	 */
	@RequestMapping(value = "/adminfacillity/systemmngt/insertCommonPopupItem.do")
	@BEAN_DEF(beans={"root=common.adminfacillity.systemmngt.controller.AdminfacillitySystemmngtRootVO", "[DataCollectionName]=common.adminfacillity.systemmngt.service.CommonPopupItemVO"})
	public ModelAndView insertCommonPopupItem(WqBaseBean ibean) throws Exception {
		ModelAndView mav = new ModelAndView("wqView");
		//TODO insertCommonPopupItem 메소드 구현
		//mav.addObject("result", [Object]);
		
		return mav;
	}

	
}