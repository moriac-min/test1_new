package foodportal.admin.systemmngt.controller;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import websquare.system.adapter.annotation.BEAN_DEF;
import common.commonfacillity.log.CommonLog;
import common.commonfacillity.uia.WqBaseBean;
import common.commonfacillity.uia.WqResultBean;
import foodportal.admin.systemmngt.service.AdminCommonCodeService;
import foodportal.admin.systemmngt.vo.AdminSystemmngtRootVO;
import foodportal.admin.systemmngt.vo.CommonCodeVO;


/**
 * AdminCommonCodeController
 * @author 임재록
 * @since 2014.08.29
 * @version 1.0
 * @see
 *
 * <pre>
 *  Modification Information
 *  수정일      수정자   수정내용
 *  ---------- -------- ---------------------------
 *  2014.08.29 임재록 최초 생성
 * </pre>
 *
 * Copyright (C) 2014 by NDS., All right reserved.
 */

@Controller                                                                                
public class AdminCommonCodeController {

	@CommonLog Logger log;
	
	@Autowired
	private AdminCommonCodeService adminCommonCodeService;

	/**
	 * 헤더코드 목록 조회
	 * 
	 * @param 
	 * @return ModelAndView
	 * @throws Exception
	 */
	@RequestMapping(value = "/admin/systemmngt/selectHeaderCodeList.do")
	@BEAN_DEF(beans={"root=foodportal.admin.systemmngt.vo.AdminSystemmngtRootVO", "commonCode=foodportal.admin.systemmngt.vo.CommonCodeVO", "commonCodeList=foodportal.admin.systemmngt.vo.CommonCodeVO"})
	public ModelAndView selectHeaderCodeList(WqBaseBean ibean) throws Exception {
		ModelAndView mav = new ModelAndView("wqView");
		
		AdminSystemmngtRootVO adminSystemmngtRootVO = new AdminSystemmngtRootVO();
		List<CommonCodeVO> commonCodeList = adminCommonCodeService.selectHeaderCodeList(ibean);
		adminSystemmngtRootVO.setCommonCodeList(commonCodeList);
		
		mav.addObject("result", adminSystemmngtRootVO);
		
		return mav;
	}
	
	/**
	 * 세부코드 목록 조회
	 * 
	 * @param 
	 * @return ModelAndView
	 * @throws Exception
	 */
	@RequestMapping(value = "/admin/systemmngt/selectDetailCodeList.do")
	@BEAN_DEF(beans={"root=foodportal.admin.systemmngt.vo.AdminSystemmngtRootVO", "commonCode=foodportal.admin.systemmngt.vo.CommonCodeVO", "commonCodeList=foodportal.admin.systemmngt.vo.CommonCodeVO"})
	public ModelAndView selectDetailCodeList(WqBaseBean ibean) throws Exception {
		ModelAndView mav = new ModelAndView("wqView");
		
		AdminSystemmngtRootVO adminSystemmngtRootVO = new AdminSystemmngtRootVO();
		List<CommonCodeVO> commonCodeList = adminCommonCodeService.selectDetailCodeList(ibean);
		adminSystemmngtRootVO.setCommonCodeList(commonCodeList);
		
		mav.addObject("result", adminSystemmngtRootVO);
		
		return mav;
	}
	
	/**
	 * 공통코드 저장
	 * 
	 * @param 
	 * @return ModelAndView
	 * @throws Exception
	 */
	@RequestMapping(value = "/admin/systemmngt/saveCommonCode.do")
	@BEAN_DEF(beans={"root=foodportal.admin.systemmngt.vo.AdminSystemmngtRootVO", "commonCode=foodportal.admin.systemmngt.vo.CommonCodeVO", "commonCodeList=foodportal.admin.systemmngt.vo.CommonCodeVO"})
	public ModelAndView saveCommonCode(WqBaseBean ibean) throws Exception {
		ModelAndView mav = new ModelAndView("wqView");
		WqResultBean rtnResult = new WqResultBean();
		AdminSystemmngtRootVO adminSystemmngtRootVO = new AdminSystemmngtRootVO();
		List<CommonCodeVO> commonCodeList = null;
		
		int result = adminCommonCodeService.saveCommonCode(ibean);
		log.debug("saveCommonCode result = " + result);
		if(result == 1){
			rtnResult.setResult("정상적으로 저장되었습니다.");
			
			String hrnk_cd = ((AdminSystemmngtRootVO) ibean).getCommonCode().getHrnk_cd();
			if (StringUtils.isEmpty(hrnk_cd)) {
				commonCodeList = adminCommonCodeService.selectHeaderCodeList(ibean);
			}
			else {
				commonCodeList = adminCommonCodeService.selectDetailCodeList(ibean);
			}
			
		} else {
			rtnResult.setResult("저장에 문제가 발생하였습니다.");
		}
		
		adminSystemmngtRootVO.setWqResultBean(rtnResult);
		adminSystemmngtRootVO.setCommonCodeList(commonCodeList);
		
		mav.addObject("result", adminSystemmngtRootVO);
		
		return mav;
	}
	
}