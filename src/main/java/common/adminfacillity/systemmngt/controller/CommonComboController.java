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

import common.adminfacillity.systemmngt.service.CommonComboService;
import common.adminfacillity.systemmngt.service.CommonComboVO;
import common.adminfacillity.systemmngt.service.AdminfacillitySystemmngtRootVO;

/**
 * CommonComboController
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
public class CommonComboController {

	@CommonLog Logger log;
	@Autowired
	private CommonComboService commonComboService;

	/**
	 * 등록된 공통콤보 정보 조회
	 * 
	 * @param 
	 * @return ModelAndView
	 * @throws Exception
	 */
	@RequestMapping(value = "/adminfacillity/systemmngt/selectCommonCombo.do")
	@BEAN_DEF(beans={"root=common.adminfacillity.systemmngt.service.AdminfacillitySystemmngtRootVO", "[DataCollectionName]=common.adminfacillity.systemmngt.service.CommonComboVO"})
	public ModelAndView selectCommonCombo(WqBaseBean ibean) throws Exception {
		ModelAndView mav = new ModelAndView("wqView");
		//TODO selectCommonCombo 메소드 구현
		//mav.addObject("result", [Object]);
		
		return mav;
	}

	/**
	 * 신규 공통콤보 정보 등록
	 * 
	 * @param 
	 * @return ModelAndView
	 * @throws Exception
	 */
	@RequestMapping(value = "/adminfacillity/systemmngt/insertCommonCombo.do")
	@BEAN_DEF(beans={"root=common.adminfacillity.systemmngt.service.AdminfacillitySystemmngtRootVO", "[DataCollectionName]=common.adminfacillity.systemmngt.service.CommonComboVO"})
	public ModelAndView insertCommonCombo(WqBaseBean ibean) throws Exception {
		ModelAndView mav = new ModelAndView("wqView");
		//TODO insertCommonCombo 메소드 구현
		//mav.addObject("result", [Object]);
		
		return mav;
	}

	/**
	 * 등록된 공통콤보 정보 삭제
	 * 
	 * @param 
	 * @return ModelAndView
	 * @throws Exception
	 */
	@RequestMapping(value = "/adminfacillity/systemmngt/deleteCommonCombo.do")
	@BEAN_DEF(beans={"root=common.adminfacillity.systemmngt.service.AdminfacillitySystemmngtRootVO", "[DataCollectionName]=common.adminfacillity.systemmngt.service.CommonComboVO"})
	public ModelAndView deleteCommonCombo(WqBaseBean ibean) throws Exception {
		ModelAndView mav = new ModelAndView("wqView");
		//TODO deleteCommonCombo 메소드 구현
		//mav.addObject("result", [Object]);
		
		return mav;
	}

	/**
	 * 등록된 공통콤보 정보 수정
	 * 
	 * @param 
	 * @return ModelAndView
	 * @throws Exception
	 */
	@RequestMapping(value = "/adminfacillity/systemmngt/updateCommonCombo.do")
	@BEAN_DEF(beans={"root=common.adminfacillity.systemmngt.service.AdminfacillitySystemmngtRootVO", "[DataCollectionName]=common.adminfacillity.systemmngt.service.CommonComboVO"})
	public ModelAndView updateCommonCombo(WqBaseBean ibean) throws Exception {
		ModelAndView mav = new ModelAndView("wqView");
		//TODO updateCommonCombo 메소드 구현
		//mav.addObject("result", [Object]);
		
		return mav;
	}
}