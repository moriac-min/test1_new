package common.adminfacillity.systemmngt.controller;

import java.util.Map;
import java.util.List;

import org.slf4j.Logger;

import common.commonfacillity.log.CommonLog;
import common.commonfacillity.uia.WqBaseBean;
import common.commonfacillity.uia.WqResultBean;
import common.education.sample.service.EducationSampleRootVO;
import common.education.sample.service.EducationSampleVO;
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

import common.adminfacillity.systemmngt.service.ProgramService;
import common.adminfacillity.systemmngt.service.ProgramVO;
import common.adminfacillity.systemmngt.service.AdminfacillitySystemmngtRootVO;


/**
 * ProgramController
 * @author 유승엽
 * @since 2014.08.18
 * @version 1.0
 * @see
 *
 * <pre>
 *  Modification Information
 *  수정일      수정자   수정내용
 *  ---------- -------- ---------------------------
 *  2014.08.18 유승엽 최초 생성
 * </pre>
 *
 * Copyright (C) 2014 by NDS., All right reserved.
 */

@Controller                                                                                
public class ProgramController {

	@CommonLog Logger log;
	@Autowired
	private ProgramService programService;

	/**
	 * 프로그램 조회
	 * 
	 * @param 
	 * @return ModelAndView
	 * @throws Exception
	 */
	@RequestMapping(value = "/adminfacillity/systemmngt/selectProgram.do")
	@BEAN_DEF(beans={"root=common.adminfacillity.systemmngt.service.AdminfacillitySystemmngtRootVO", "programVO=common.adminfacillity.systemmngt.service.ProgramVO", "infoList=common.adminfacillity.systemmngt.service.ProgramVO"})
	public ModelAndView selectProgram(WqBaseBean ibean) throws Exception {
		ModelAndView mav = new ModelAndView("wqView");
		
		AdminfacillitySystemmngtRootVO adminfacillitySystemmngtRootVO = new AdminfacillitySystemmngtRootVO();
		List<ProgramVO> list = programService.selectProgram(ibean);
		adminfacillitySystemmngtRootVO.setInfoList(list);
		mav.addObject("result", adminfacillitySystemmngtRootVO);
		
		return mav;
	}

	/**
	 * 프로그램 저장
	 * 
	 * @param 
	 * @return ModelAndView
	 * @throws Exception
	 */
	@RequestMapping(value = "/adminfacillity/systemmngt/saveProgram.do")
	@BEAN_DEF(beans={"root=common.adminfacillity.systemmngt.service.AdminfacillitySystemmngtRootVO", "infoList=common.adminfacillity.systemmngt.service.ProgramVO"})
	public ModelAndView saveProgram(WqBaseBean ibean) throws Exception {
		ModelAndView mav = new ModelAndView("wqView");
		
		WqResultBean rtnResult = new WqResultBean();
		AdminfacillitySystemmngtRootVO outVo = new AdminfacillitySystemmngtRootVO();
		List<ProgramVO> list = null;
		
		int result = programService.saveProgram(ibean);
		log.debug("saveProgramList result = " + result);
		if(result == 1){
			rtnResult.setResult("정상적으로 저장되었습니다.");
		} else {
			rtnResult.setResult("저장에 문제가 발생하였습니다.");
		}
		
		outVo.setWqResultBean(rtnResult);
		outVo.setInfoList(list);
		
		mav.addObject("result", outVo);
		
		return mav;
	}
	
	/**
	 * 프로그램 등록
	 * 
	 * @param 
	 * @return ModelAndView
	 * @throws Exception
	 */
	@RequestMapping(value = "/adminfacillity/systemmngt/insertProgram.do")
	@BEAN_DEF(beans={"root=common.adminfacillity.systemmngt.service.ProgramRootVO", "programVO=common.adminfacillity.systemmngt.service.ProgramVO", "infoList=common.adminfacillity.systemmngt.service.ProgramVO"})
	public ModelAndView insertProgram(WqBaseBean ibean) throws Exception {
		ModelAndView mav = new ModelAndView("wqView");
		//TODO insertProgram 메소드 구현
		//mav.addObject("result", [Object]);
		
		return mav;
	}

	/**
	 * 프로그램 수정
	 * 
	 * @param 
	 * @return ModelAndView
	 * @throws Exception
	 */
	@RequestMapping(value = "/adminfacillity/systemmngt/updateProgram.do")
	@BEAN_DEF(beans={"root=common.adminfacillity.systemmngt.service.ProgramRootVO", "programVO=common.adminfacillity.systemmngt.service.ProgramVO", "infoList=common.adminfacillity.systemmngt.service.ProgramVO"})
	public ModelAndView updateProgram(WqBaseBean ibean) throws Exception {
		ModelAndView mav = new ModelAndView("wqView");
		//TODO updateProgram 메소드 구현
		//mav.addObject("result", [Object]);
		
		return mav;
	}

	/**
	 * 프로그램 삭제
	 * 
	 * @param 
	 * @return ModelAndView
	 * @throws Exception
	 */
	@RequestMapping(value = "/adminfacillity/systemmngt/deleteProgram.do")
	@BEAN_DEF(beans={"root=common.adminfacillity.systemmngt.service.ProgramRootVO", "programVO=common.adminfacillity.systemmngt.service.ProgramVO", "infoList=common.adminfacillity.systemmngt.service.ProgramVO"})
	public ModelAndView deleteProgram(WqBaseBean ibean) throws Exception {
		ModelAndView mav = new ModelAndView("wqView");
		//TODO deleteProgram 메소드 구현
		//mav.addObject("result", [Object]);
		
		return mav;
	}
}