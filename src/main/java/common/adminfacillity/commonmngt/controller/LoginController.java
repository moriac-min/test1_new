package common.adminfacillity.commonmngt.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import common.adminfacillity.commonmngt.service.LoginService;
import common.adminfacillity.commonmngt.service.LoginVO;

/**
 * ComcmController
 * @author 김민규
 * @since 2014.06.13
 * @version 1.0
 * @see
 *
 * <pre>
 *  Modification Information
 *  수정일      수정자   수정내용
 *  ---------- -------- ---------------------------
 *  2014.06.13 김민규   최초 생성
 * </pre>
 *
 * Copyright (C) 2014 by NDS., All right reserved.
 */

@Controller
//@SessionAttributes(types=ComcmVO.class)
public class LoginController {
	protected final Logger log = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private LoginService loginService;
	
	/**
	 * 로그인
	 * 
	 * @param LoginVO
	 * @return ModelAndView
	 * @throws Exception
	 */
	@RequestMapping(value = "/adminfacillity/commonmngt/login.do")
	public ModelAndView selectLoginStart(@ModelAttribute("comcmVO") LoginVO loginVO, ModelMap model) throws Exception {
		ModelAndView mav = new ModelAndView("adminfacillity/commonmngt/login");
		
		return mav;
	}
	
	/**
	 * 로그인
	 * 
	 * @param LoginVO
	 * @return ModelAndView
	 * @throws Exception
	 */
	@RequestMapping(value = "/adminfacillity/commonmngt/selectLogin.do")
	public ModelAndView selectLogin(@ModelAttribute("comcmVO") LoginVO loginVO, ModelMap model) throws Exception {
		ModelAndView mav = new ModelAndView("adminfacillity/commonmngt/COMCMA001");
		
		int vResult = loginService.selectLogin(loginVO);
		log.debug("selectLogin vResult ::: " + vResult);
		if(vResult > 1){
			inputUserDetail(loginVO.getSabun());
		}
		
		model.addAttribute("result", vResult);
		
		return mav;
	}
	
	public void inputUserDetail(String sabun){
		
	}
}
