package common.education.sample.controller;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import websquare.system.adapter.annotation.BEAN_DEF;
import common.commonfacillity.log.CommonLog;
import common.commonfacillity.uia.WqBaseBean;
import common.commonfacillity.uia.WqResultBean;
import common.education.sample.service.EducationSampleRootVO;
import common.education.sample.service.EducationSampleService;
import common.education.sample.service.EducationSampleVO;

/**
 * EdusaController
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
//@SessionAttributes(types=EdusaVO.class)
public class EducationSampleController {
	
	@CommonLog Logger log;
	
	@Autowired
	private EducationSampleService educationSampleService;
	
	/**
	 * 교육용자료 목록 조회
	 * 
	 * @param EducationSampleVO
	 * @return ModelAndView
	 * @throws Exception
	 */
	@RequestMapping(value = "/education/sample/selectEduSawonList.do")
	@BEAN_DEF(beans={"root=common.education.sample.service.EducationSampleRootVO", "educationSampleVO=common.education.sample.service.EducationSampleVO", "educationSampleList=common.education.sample.service.EducationSampleVO"})
	public ModelAndView selectEduSawonList(WqBaseBean ibean) throws Exception {
		ModelAndView mav = new ModelAndView("wqView");
		
		EducationSampleRootVO educationSampleVo = new EducationSampleRootVO();
		List<EducationSampleVO> list = educationSampleService.selectEduSawonList(ibean);
		educationSampleVo.setEducationSampleList(list);
		mav.addObject("result", educationSampleVo);
		
		//여러개의 데이터리스트를 내려보내야할 경우 주석처리된 곳과 흡사하게 개발한다.
/*		List<EducationSampleVO> list2 = educationSampleService.selectEduSawonList(ibean);
		List<EducationSampleVO> list3 = educationSampleService.selectEduSawonList(ibean);
		EducationSampleRootVO educationSampleVo = new EducationSampleRootVO();
		
		educationSampleVo.setEducationSampleList(list);
		educationSampleVo.setEducationSampleList2(list2);
		educationSampleVo.setEducationSampleList3(list3);
		
		mav.addObject("result", educationSampleVo);
*/		
		return mav;
	}
	
	/**
	 * 교육용자료 저장
	 * 
	 * @param EducationSampleVO
	 * @return ModelAndView
	 * @throws Exception
	 */
	@RequestMapping(value = "/education/sample/saveEduSawonList.do")
	@BEAN_DEF(beans={"root=common.education.sample.service.EducationSampleRootVO", "educationSampleVO=common.education.sample.service.EducationSampleVO", "educationSampleList=common.education.sample.service.EducationSampleVO", "rtnResult=common.commonfacillity.uia.WqResultBean"})
	public ModelAndView saveEduSawonList(WqBaseBean ibean) throws Exception {
		ModelAndView mav = new ModelAndView("wqView");
		WqResultBean rtnResult = new WqResultBean();
		EducationSampleRootVO outVo = new EducationSampleRootVO();
		List<EducationSampleVO> list = null;
		
		int result = educationSampleService.saveEduSawon(ibean);
		log.debug("saveEduSawonList result = " + result);
		if(result == 1){
			rtnResult.setResult("정상적으로 저장되었습니다.");
			list = educationSampleService.selectEduSawonList(outVo);
		} else {
			rtnResult.setResult("저장에 문제가 발생하였습니다.");
		}
		
		outVo.setWqResultBean(rtnResult);
		outVo.setEducationSampleList(list);
		
		mav.addObject("result", outVo);
		
		return mav;
	}
	
	/**
	 * 교육용자료 입력
	 * 
	 * @param EducationSampleVO
	 * @return ModelAndView
	 * @throws Exception
	 */
	@RequestMapping(value = "/education/sample/insertEduSawonList.do")
	@BEAN_DEF(beans={"root=common.education.sample.service.EducationSampleRootVO", "educationSampleVO=common.education.sample.service.EducationSampleVO", "educationSampleList=common.education.sample.service.EducationSampleVO", "rtnResult=common.commonfacillity.uia.WqResultBean"})
	public ModelAndView insertEduSawonList(WqBaseBean ibean) throws Exception {
		ModelAndView mav = new ModelAndView("wqView");
		WqResultBean rtnResult = new WqResultBean();
		EducationSampleRootVO outVo = new EducationSampleRootVO();
		List<EducationSampleVO> list = null;
		
		int result = educationSampleService.insertEduSawon(ibean);
		if(result == 1){
			rtnResult.setResult("정상적으로 저장되었습니다.");
			list = educationSampleService.selectEduSawonList(outVo);
		} else {
			rtnResult.setResult("저장에 문제가 발생하였습니다.");
		}
		
		outVo.setWqResultBean(rtnResult);
		outVo.setEducationSampleList(list);
		
		mav.addObject("result", outVo);
		
		return mav;
	}
	
	/**
	 * 교육용자료 수정
	 * 
	 * @param EducationSampleVO
	 * @return ModelAndView
	 * @throws Exception
	 */
	@RequestMapping(value = "/education/sample/updateEduSawonList.do")
	@BEAN_DEF(beans={"root=common.education.sample.service.EducationSampleRootVO", "educationSampleVO=common.education.sample.service.EducationSampleVO", "educationSampleList=common.education.sample.service.EducationSampleVO", "rtnResult=common.commonfacillity.uia.WqResultBean"})
	public ModelAndView updateEduSawonList(WqBaseBean ibean) throws Exception {
		ModelAndView mav = new ModelAndView("wqView");
		WqResultBean rtnResult = new WqResultBean();
		EducationSampleRootVO outVo = new EducationSampleRootVO();
		List<EducationSampleVO> list = null;
		
		int result = educationSampleService.updateEduSawon(ibean);
		if(result == 1){
			rtnResult.setResult("정상적으로 수정되었습니다.");
			list = educationSampleService.selectEduSawonList(outVo);
		} else {
			rtnResult.setResult("저장에 문제가 발생하였습니다.");
		}
		
		outVo.setWqResultBean(rtnResult);
		outVo.setEducationSampleList(list);
		
		mav.addObject("result", outVo);
		
		return mav;
	}
	
	/**
	 * 교육용자료 삭제
	 * 
	 * @param EducationSampleVO
	 * @return ModelAndView
	 * @throws Exception
	 */
	@RequestMapping(value = "/education/sample/deleteEduSawonList.do")
	@BEAN_DEF(beans={"root=common.education.sample.service.EducationSampleRootVO", "educationSampleVO=common.education.sample.service.EducationSampleVO", "educationSampleList=common.education.sample.service.EducationSampleVO", "rtnResult=common.commonfacillity.uia.WqResultBean"})
	public ModelAndView deleteEduSawonList(WqBaseBean ibean) throws Exception {
		ModelAndView mav = new ModelAndView("wqView");
		WqResultBean rtnResult = new WqResultBean();
		EducationSampleRootVO outVo = new EducationSampleRootVO();
		List<EducationSampleVO> list = null;
		
		int result = educationSampleService.deleteEduSawon(ibean);
		if(result == 1){
			rtnResult.setResult("정상적으로 삭제되었습니다.");
			list = educationSampleService.selectEduSawonList(outVo);
		} else {
			rtnResult.setResult("저장에 문제가 발생하였습니다.");
		}
		
		outVo.setWqResultBean(rtnResult);
		outVo.setEducationSampleList(list);
		
		mav.addObject("result", outVo);
		
		return mav;
	}
}
