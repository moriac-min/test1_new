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

import common.adminfacillity.systemmngt.service.SystemMessageService;
import common.adminfacillity.systemmngt.service.SystemMessageVO;
import common.adminfacillity.systemmngt.service.AdminfacillitySystemmngtRootVO;

/**
 * SystemMessageController
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
public class SystemMessageController {

	@CommonLog Logger log;
	@Autowired
	private SystemMessageService systemMessageService;
	
	/**
	 * 등록된 시스템 메시지 정보 조회
	 * 
	 * @param 
	 * @return ModelAndView
	 * @throws Exception
	 */
	@RequestMapping(value = "/adminfacillity/systemmngt/selectSystemMessage.do")
	@BEAN_DEF(beans={"root=common.adminfacillity.systemmngt.service.AdminfacillitySystemmngtRootVO", "systemMessageVO=common.adminfacillity.systemmngt.service.SystemMessageVO", "infoList=common.adminfacillity.systemmngt.service.SystemMessageVO"})
	public ModelAndView selectSystemMessage(WqBaseBean ibean) throws Exception {
		ModelAndView mav = new ModelAndView("wqView");
		AdminfacillitySystemmngtRootVO adminfacillitySystemmngtRootVO = new AdminfacillitySystemmngtRootVO();
		List<SystemMessageVO> list = systemMessageService.selectSystemMessage(ibean);
		adminfacillitySystemmngtRootVO.setInfoList(list);
		
		mav.addObject("result", adminfacillitySystemmngtRootVO);
		
		return mav;
	}
	
	/**
	 * 신규 시스템 메시지 정보 저장
	 * 
	 * @param 
	 * @return ModelAndView
	 * @throws Exception
	 */
	@RequestMapping(value = "/adminfacillity/systemmngt/saveSystemMessage.do")
	@BEAN_DEF(beans={"root=common.adminfacillity.systemmngt.service.AdminfacillitySystemmngtRootVO", "infoList=common.adminfacillity.systemmngt.service.SystemMessageVO"})
	public ModelAndView saveSystemMessage(WqBaseBean ibean) throws Exception {
		ModelAndView mav = new ModelAndView("wqView");
		WqResultBean rtnResult = new WqResultBean();
		AdminfacillitySystemmngtRootVO outVo = new AdminfacillitySystemmngtRootVO();
		List<SystemMessageVO> list = null;
		
		int result = systemMessageService.saveSystemMessage(ibean);
		if(result == 1){
			rtnResult.setResult("정상적으로 저장되었습니다.");
			list = systemMessageService.selectSystemMessage(ibean);
		} else {
			rtnResult.setResult("저장에 문제가 발생하였습니다.");
		}
		outVo.setWqResultBean(rtnResult);
		outVo.setInfoList(list);
		
		mav.addObject("result", outVo);
		
		return mav;
	}
	
	/**
	 * 신규 시스템 메시지 정보 등록
	 * 
	 * @param 
	 * @return ModelAndView
	 * @throws Exception
	 */
	@RequestMapping(value = "/adminfacillity/systemmngt/insertSystemMessage.do")
	@BEAN_DEF(beans={"root=common.adminfacillity.systemmngt.service.AdminfacillitySystemmngtRootVO", "systemMessageVO=common.adminfacillity.systemmngt.service.SystemMessageVO", "infoList=common.adminfacillity.systemmngt.service.SystemMessageVO"})
	public ModelAndView insertSystemMessage(WqBaseBean ibean) throws Exception {
		ModelAndView mav = new ModelAndView("wqView");
		WqResultBean rtnResult = new WqResultBean();
		AdminfacillitySystemmngtRootVO outVo = new AdminfacillitySystemmngtRootVO();
		List<SystemMessageVO> list = null;
		
		int result = systemMessageService.insertSystemMessage(ibean);
		if(result == 1){
			rtnResult.setResult("정상적으로 입력되었습니다.");
			list = systemMessageService.selectSystemMessage(ibean);
		} else {
			rtnResult.setResult("입력에 문제가 발생하였습니다.");
		}
		outVo.setWqResultBean(rtnResult);
		outVo.setInfoList(list);
		
		mav.addObject("result", outVo);
		
		return mav;
	}
	
	/**
	 * 등록된 시스템 메시지 정보 수정
	 * 
	 * @param 
	 * @return ModelAndView
	 * @throws Exception
	 */
	@RequestMapping(value = "/adminfacillity/systemmngt/updateSystemMessage.do")
	@BEAN_DEF(beans={"root=common.adminfacillity.systemmngt.service.AdminfacillitySystemmngtRootVO", "systemMessageVO=common.adminfacillity.systemmngt.service.SystemMessageVO", "infoList=common.adminfacillity.systemmngt.service.SystemMessageVO"})
	public ModelAndView updateSystemMessage(WqBaseBean ibean) throws Exception {
		ModelAndView mav = new ModelAndView("wqView");
		WqResultBean rtnResult = new WqResultBean();
		AdminfacillitySystemmngtRootVO outVo = new AdminfacillitySystemmngtRootVO();
		List<SystemMessageVO> list = null;
		
		int result = systemMessageService.updateSystemMessage(ibean);
		if(result == 1){
			rtnResult.setResult("정상적으로 수정되었습니다.");
			list = systemMessageService.selectSystemMessage(ibean);
		} else {
			rtnResult.setResult("수정에 문제가 발생하였습니다.");
		}
		outVo.setWqResultBean(rtnResult);
		outVo.setInfoList(list);
		
		mav.addObject("result", outVo);
		
		return mav;
	}
	

	/**
	 * 등록된 시스템 메시지 정보 삭제
	 * 
	 * @param 
	 * @return ModelAndView
	 * @throws Exception
	 */
	@RequestMapping(value = "/adminfacillity/systemmngt/deleteSystemMessage.do")
	@BEAN_DEF(beans={"root=common.adminfacillity.systemmngt.service.AdminfacillitySystemmngtRootVO", "systemMessageVO=common.adminfacillity.systemmngt.service.SystemMessageVO", "infoList=common.adminfacillity.systemmngt.service.SystemMessageVO"})
	public ModelAndView deleteSystemMessage(WqBaseBean ibean) throws Exception {
		ModelAndView mav = new ModelAndView("wqView");
		WqResultBean rtnResult = new WqResultBean();
		AdminfacillitySystemmngtRootVO outVo = new AdminfacillitySystemmngtRootVO();
		List<SystemMessageVO> list = null;
		
		int result = systemMessageService.deleteSystemMessage(ibean);
		if(result == 1){
			rtnResult.setResult("정상적으로 삭제되었습니다.");
			list = systemMessageService.selectSystemMessage(ibean);
		} else {
			rtnResult.setResult("삭제에 문제가 발생하였습니다.");
		}
		outVo.setWqResultBean(rtnResult);
		outVo.setInfoList(list);
		
		mav.addObject("result", outVo);
		
		return mav;
	}
}