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
import foodportal.admin.systemmngt.service.CalMngtService;
import foodportal.admin.systemmngt.vo.AdminSystemmngtRootVO;
import foodportal.admin.systemmngt.vo.CalMngtVO;



/**
 * CalMngtController
 * @author 최연길
 * @since 2014.09.15
 * @version 1.0
 * @see
 *
 * <pre>
 *  Modification Information
 *  수정일      수정자   수정내용
 *  ---------- -------- ---------------------------
 *  2014.09.15 최연길 최초 생성
 * </pre>
 *
 * Copyright (C) 2014 by NDS., All right reserved.
 */

@Controller                                                                                
public class CalMngtController {

	@CommonLog Logger log;
	
	@Autowired
	private CalMngtService calMngtService;

	/**
	 * 캘린더 목록 조회
	 * 
	 * @param 
	 * @return ModelAndView
	 * @throws Exception
	 */
	@RequestMapping(value = "/admin/systemmngt/selectCalMngtList.do")
	@BEAN_DEF(beans={"root=foodportal.admin.systemmngt.vo.AdminSystemmngtRootVO", "paramDateNo=foodportal.admin.systemmngt.vo.CalMngtVO", "calMngtList=foodportal.admin.systemmngt.vo.CalMngtVO"})
	public ModelAndView selectCalMngtList(WqBaseBean ibean) throws Exception {
		ModelAndView mav = new ModelAndView("wqView");
		
		AdminSystemmngtRootVO adminSystemmngtRootVO = new AdminSystemmngtRootVO();
		List<CalMngtVO> calMngtList = calMngtService.selectCalMngtList(ibean);
		adminSystemmngtRootVO.setCalMngtList(calMngtList);

		mav.addObject("result", adminSystemmngtRootVO);
		
		return mav;
	}
	
	/**
	 * 캘린더 상세 조회
	 * 
	 * @param 
	 * @return ModelAndView
	 * @throws Exception
	 */
	@RequestMapping(value = "/admin/systemmngt/selectCalMngtDetail.do")
	@BEAN_DEF(beans={"root=foodportal.admin.systemmngt.vo.AdminSystemmngtRootVO", "paramCalMngt=foodportal.admin.systemmngt.vo.CalMngtVO", "calMngt=foodportal.admin.systemmngt.vo.CalMngtVO"})
	public ModelAndView selectCalMngtDetail(WqBaseBean ibean) throws Exception {
		ModelAndView mav = new ModelAndView("wqView");
		
		AdminSystemmngtRootVO adminSystemmngtRootVO = new AdminSystemmngtRootVO();
		CalMngtVO calMngtVO = calMngtService.selectCalMngtDetail(ibean);
		adminSystemmngtRootVO.setCalMngt(calMngtVO);
		
		mav.addObject("result", adminSystemmngtRootVO);
		
		return mav;
	}
	
	/**
	 * 캘린더 등록
	 * 
	 * @param 
	 * @return ModelAndView
	 * @throws Exception
	 */
	@RequestMapping(value = "/admin/systemmngt/insertCalMngt.do")
	@BEAN_DEF(beans={"root=foodportal.admin.systemmngt.vo.AdminSystemmngtRootVO", "calMngt=foodportal.admin.systemmngt.vo.CalMngtVO", "calMngtList=foodportal.admin.systemmngt.vo.CalMngtVO"})
	public ModelAndView insertCalMngt(WqBaseBean ibean) throws Exception {
		ModelAndView mav = new ModelAndView("wqView");
		WqResultBean rtnResult = new WqResultBean();
		AdminSystemmngtRootVO adminSystemmngtRootVO = new AdminSystemmngtRootVO();
		
		int result = calMngtService.insertCalMngt(ibean);
		if(result == 1){
			rtnResult.setResult("정상적으로 등록되었습니다.");
		} else {
			rtnResult.setResult("등록에 문제가 발생하였습니다.");
		}
		adminSystemmngtRootVO.setWqResultBean(rtnResult);
		
		mav.addObject("result", adminSystemmngtRootVO);
		
		return mav;
	}
	
	/**
	 * 캘린더 수정
	 * 
	 * @param 
	 * @return ModelAndView
	 * @throws Exception
	 */
	@RequestMapping(value = "/admin/systemmngt/updateCalMngt.do")
	@BEAN_DEF(beans={"root=foodportal.admin.systemmngt.vo.AdminSystemmngtRootVO", "calMngt=foodportal.admin.systemmngt.vo.CalMngtVO", "calMngtList=foodportal.admin.systemmngt.vo.CalMngtVO"})
	public ModelAndView updateCalMngt(WqBaseBean ibean) throws Exception {
		ModelAndView mav = new ModelAndView("wqView");
		WqResultBean rtnResult = new WqResultBean();
		AdminSystemmngtRootVO adminSystemmngtRootVO = new AdminSystemmngtRootVO();
		
		int result = calMngtService.updateCalMngt(ibean);
		if(result == 1){
			rtnResult.setResult("정상적으로 수정되었습니다.");
		} else {
			rtnResult.setResult("수정에 문제가 발생하였습니다.");
		}
		
		adminSystemmngtRootVO.setWqResultBean(rtnResult);
		
		mav.addObject("result", adminSystemmngtRootVO);
		
		return mav;
	}
	
	/**
	 * 캘린더 삭제
	 * 
	 * @param 
	 * @return ModelAndView
	 * @throws Exception
	 */
	@RequestMapping(value = "/admin/systemmngt/deleteCalMngt.do")
	@BEAN_DEF(beans={"root=foodportal.admin.systemmngt.vo.AdminSystemmngtRootVO", "calMngtList=foodportal.admin.systemmngt.vo.CalMngtVO"})
	public ModelAndView deleteCalMngt(WqBaseBean ibean) throws Exception {
		ModelAndView mav = new ModelAndView("wqView");
		WqResultBean rtnResult = new WqResultBean();
		AdminSystemmngtRootVO adminSystemmngtRootVO = new AdminSystemmngtRootVO();
		
		int result = calMngtService.deleteCalMngt(ibean);
		if(result == 1){
			rtnResult.setResult("정상적으로 삭제되었습니다.");
		} else {
			rtnResult.setResult("삭제에 문제가 발생하였습니다.");
		}
		adminSystemmngtRootVO.setWqResultBean(rtnResult);
		
		mav.addObject("result", adminSystemmngtRootVO);
		
		return mav;
	}
	
}