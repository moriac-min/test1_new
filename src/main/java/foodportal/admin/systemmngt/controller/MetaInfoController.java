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
import foodportal.admin.systemmngt.service.MetaInfoService;
import foodportal.admin.systemmngt.vo.AdminSystemmngtRootVO;
import foodportal.admin.systemmngt.vo.MetaVO;
import foodportal.admin.systemmngt.vo.UseMetaVO;


/**
 * MetaInfoController
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
public class MetaInfoController {

	@CommonLog Logger log;
	@Autowired
	private MetaInfoService metaInfoService;

	/**
	 * 등록된 메타정보 목록 조회
	 * 
	 * @param 
	 * @return ModelAndView
	 * @throws Exception
	 */
	@RequestMapping(value = "/admin/systemmngt/selectMetaList.do")
	@BEAN_DEF(beans={"root=foodportal.admin.systemmngt.vo.AdminSystemmngtRootVO", "paramMeta=foodportal.admin.systemmngt.vo.MetaVO", "metaList=foodportal.admin.systemmngt.vo.MetaVO"})
	public ModelAndView selectMetaList(WqBaseBean ibean) throws Exception {
		ModelAndView mav = new ModelAndView("wqView");
		
		AdminSystemmngtRootVO adminSystemmngtRootVO = new AdminSystemmngtRootVO();
		List<MetaVO> metaList = metaInfoService.selectMetaList(ibean);
		
		adminSystemmngtRootVO.setMetaList(metaList);
		mav.addObject("result", adminSystemmngtRootVO);
		
		return mav;
	}
	
	/**
	 * 사용중 메타정보 목록 조회
	 * 
	 * @param 
	 * @return ModelAndView
	 * @throws Exception
	 */
	@RequestMapping(value = "/admin/systemmngt/selectUseMetaList.do")
	@BEAN_DEF(beans={"root=foodportal.admin.systemmngt.vo.AdminSystemmngtRootVO", "paramUseMeta=foodportal.admin.systemmngt.vo.UseMetaVO", "useMetaList=foodportal.admin.systemmngt.vo.UseMetaVO"})
	public ModelAndView selectUseMetaList(WqBaseBean ibean) throws Exception {
		ModelAndView mav = new ModelAndView("wqView");
		
		AdminSystemmngtRootVO adminSystemmngtRootVO = new AdminSystemmngtRootVO();
		List<UseMetaVO> useMetaList = metaInfoService.selectUseMetaList(ibean);
		
		adminSystemmngtRootVO.setUseMetaList(useMetaList);
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
	@RequestMapping(value = "/admin/systemmngt/saveUseMetaList.do")
	@BEAN_DEF(beans={"root=foodportal.admin.systemmngt.vo.AdminSystemmngtRootVO", "paramUseMetaList=foodportal.admin.systemmngt.vo.UseMetaVO", "useMetaList=foodportal.admin.systemmngt.vo.UseMetaVO", "paramUseMeta=foodportal.admin.systemmngt.vo.UseMetaVO"})
	public ModelAndView saveUseMetaList(WqBaseBean ibean) throws Exception {
		ModelAndView mav = new ModelAndView("wqView");
		WqResultBean rtnResult = new WqResultBean();
		AdminSystemmngtRootVO adminSystemmngtRootVO = new AdminSystemmngtRootVO();
		List<UseMetaVO> useMetaList = null;
		
		int result = metaInfoService.saveUseMetaList(ibean, "save");
		if(result == 1){
			rtnResult.setResult("정상적으로 저장되었습니다.");
			useMetaList = metaInfoService.selectUseMetaList(ibean);
		} else {
			rtnResult.setResult("저장에 문제가 발생하였습니다.");
		}
		adminSystemmngtRootVO.setWqResultBean(rtnResult);
		adminSystemmngtRootVO.setUseMetaList(useMetaList);;
		
		mav.addObject("result", adminSystemmngtRootVO);
		
		return mav;
	}
	
	/**
	 * 사용중 메타정보 삭제
	 * 
	 * @param 
	 * @return ModelAndView
	 * @throws Exception
	 */
	@RequestMapping(value = "/admin/systemmngt/deleteUseMetaList.do")
	@BEAN_DEF(beans={"root=foodportal.admin.systemmngt.vo.AdminSystemmngtRootVO", "paramUseMetaList=foodportal.admin.systemmngt.vo.UseMetaVO", "useMetaList=foodportal.admin.systemmngt.vo.UseMetaVO", "paramUseMeta=foodportal.admin.systemmngt.vo.UseMetaVO"})
	public ModelAndView deleteUseMetaList(WqBaseBean ibean) throws Exception {
		ModelAndView mav = new ModelAndView("wqView");
		WqResultBean rtnResult = new WqResultBean();
		AdminSystemmngtRootVO adminSystemmngtRootVO = new AdminSystemmngtRootVO();
		List<UseMetaVO> useMetaList = null;
		
		int result = metaInfoService.saveUseMetaList(ibean, "delete");
		if(result == 1){
			rtnResult.setResult("정상적으로 저장되었습니다.");
			useMetaList = metaInfoService.selectUseMetaList(ibean);
		} else {
			rtnResult.setResult("저장에 문제가 발생하였습니다.");
		}
		adminSystemmngtRootVO.setWqResultBean(rtnResult);
		adminSystemmngtRootVO.setUseMetaList(useMetaList);
		
		mav.addObject("result", adminSystemmngtRootVO);
		
		return mav;
	}
	
	
}