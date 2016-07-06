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

import common.adminfacillity.systemmngt.service.ProgramVO;
import common.adminfacillity.systemmngt.service.UserService;
import common.adminfacillity.systemmngt.service.UserVO;
import common.adminfacillity.systemmngt.service.AdminfacillitySystemmngtRootVO;

/**
 * UserController
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
public class UserController {

	@CommonLog Logger log;
	@Autowired
	private UserService userService;

	/**
	 * 사용자 조회
	 * 
	 * @param 
	 * @return ModelAndView
	 * @throws Exception
	 */
	@RequestMapping(value = "/adminfacillity/systemmngt/selectUser.do")
	@BEAN_DEF(beans={"root=common.adminfacillity.systemmngt.service.AdminfacillitySystemmngtRootVO", "UserVO=common.adminfacillity.systemmngt.service.UserVO", "infoList=common.adminfacillity.systemmngt.service.UserVO"})
	public ModelAndView selectUser(WqBaseBean ibean) throws Exception {
		ModelAndView mav = new ModelAndView("wqView");
		
		AdminfacillitySystemmngtRootVO adminfacillitySystemmngtRootVO = new AdminfacillitySystemmngtRootVO();
		List<UserVO> list = userService.selectUser(ibean);
		adminfacillitySystemmngtRootVO.setInfoList(list);
		mav.addObject("result", adminfacillitySystemmngtRootVO);
		
		return mav;
	}

	/**
	 * 사용자 저장
	 * 
	 * @param 
	 * @return ModelAndView
	 * @throws Exception
	 */
	@RequestMapping(value = "/adminfacillity/systemmngt/saveUser.do")
	@BEAN_DEF(beans={"root=common.adminfacillity.systemmngt.service.AdminfacillitySystemmngtRootVO", "infoList=common.adminfacillity.systemmngt.service.UserVO"})
	public ModelAndView saveUser(WqBaseBean ibean) throws Exception {
		ModelAndView mav = new ModelAndView("wqView");
		
		WqResultBean rtnResult = new WqResultBean();
		AdminfacillitySystemmngtRootVO outVo = new AdminfacillitySystemmngtRootVO();
		List<UserVO> list = null;
		
		int result = userService.saveUser(ibean);
		log.debug("saveUserList result = " + result);
		if(result == 1){
			rtnResult.setResult("정상적으로 저장되었습니다.");
			//list = programService.selectProgram(outVo);
		} else {
			rtnResult.setResult("저장에 문제가 발생하였습니다.");
		}
		
		outVo.setWqResultBean(rtnResult);
		outVo.setInfoList(list);
		
		mav.addObject("result", outVo);
		
		return mav;
	}
	
	/**
	 * 사용자 등록
	 * 
	 * @param 
	 * @return ModelAndView
	 * @throws Exception
	 */
	@RequestMapping(value = "/adminfacillity/systemmngt/insertUser.do")
	@BEAN_DEF(beans={"root=common.adminfacillity.systemmngt.service.AdminfacillitySystemmngtRootVO", "[DataCollectionName]=common.adminfacillity.systemmngt.service.UserVO"})
	public ModelAndView insertUser(WqBaseBean ibean) throws Exception {
		ModelAndView mav = new ModelAndView("wqView");
		//TODO insertUser 메소드 구현
		//mav.addObject("result", [Object]);
		
		return mav;
	}

	/**
	 * 사용자 수정
	 * 
	 * @param 
	 * @return ModelAndView
	 * @throws Exception
	 */
	@RequestMapping(value = "/adminfacillity/systemmngt/updateUser.do")
	@BEAN_DEF(beans={"root=common.adminfacillity.systemmngt.service.AdminfacillitySystemmngtRootVO", "[DataCollectionName]=common.adminfacillity.systemmngt.service.UserVO"})
	public ModelAndView updateUser(WqBaseBean ibean) throws Exception {
		ModelAndView mav = new ModelAndView("wqView");
		//TODO updateUser 메소드 구현
		//mav.addObject("result", [Object]);
		
		return mav;
	}

	/**
	 * 사용자 암호 초기화
	 * 
	 * @param 
	 * @return ModelAndView
	 * @throws Exception
	 */
	@RequestMapping(value = "/adminfacillity/systemmngt/initPassword.do")
	@BEAN_DEF(beans={"root=common.adminfacillity.systemmngt.service.AdminfacillitySystemmngtRootVO", "[DataCollectionName]=common.adminfacillity.systemmngt.service.UserVO"})
	public ModelAndView initPassword(WqBaseBean ibean) throws Exception {
		ModelAndView mav = new ModelAndView("wqView");
		//TODO initPassword 메소드 구현
		//mav.addObject("result", [Object]);
		
		return mav;
	}
}