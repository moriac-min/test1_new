package foodportal.admin.systemmngt.controller;

import java.util.List;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import websquare.system.adapter.annotation.BEAN_DEF;
import common.adminfacillity.systemmngt.service.AdminfacillitySystemmngtRootVO;
import common.adminfacillity.systemmngt.service.CommonCodeVO;
import common.commonfacillity.log.CommonLog;
import common.commonfacillity.uia.WqBaseBean;
import common.commonfacillity.uia.WqResultBean;
import foodportal.admin.systemmngt.service.MetaKeyPopupService;
import foodportal.admin.systemmngt.vo.AdminSystemmngtRootVO;
import foodportal.admin.systemmngt.vo.MetaKeyPopupVO;


/**
 * MetaKeyPopupController
 * @author 최연길
 * @since 2014.09.17
 * @version 1.0
 * @see
 *
 * <pre>
 *  Modification Information
 *  수정일      수정자   수정내용
 *  ---------- -------- ---------------------------
 *  2014.09.17 최연길 최초 생성
 * </pre>
 *
 * Copyright (C) 2014 by NDS., All right reserved.
 */

@Controller                                                                                
public class MetaKeyPopupController {

	@CommonLog Logger log;
	@Autowired
	private MetaKeyPopupService metaKeyPopupService;

	/**
	 * 메타 코드 조회
	 * 
	 * @param 
	 * @return ModelAndView
	 * @throws Exception
	 */
	@RequestMapping(value = "/admin/systemmngt/selectMetaKeyPopupList.do")
	@BEAN_DEF(beans={"root=foodportal.admin.systemmngt.vo.AdminSystemmngtRootVO","paramMetaKeyPopupInfo=foodportal.admin.systemmngt.vo.MetaKeyPopupVO","metaKeyPopupList=foodportal.admin.systemmngt.vo.MetaKeyPopupVO"})
	public ModelAndView selectMetaKeyPopupList(WqBaseBean ibean) throws Exception {
		ModelAndView mav = new ModelAndView("wqView");
		AdminSystemmngtRootVO adminSystemmngtRootVO = new AdminSystemmngtRootVO();
		List<MetaKeyPopupVO> MetaKeyPopupList = metaKeyPopupService.selectMetaKeyPopupList(ibean);
		
		adminSystemmngtRootVO.setMetaKeyPopupList(MetaKeyPopupList);
		mav.addObject("result", adminSystemmngtRootVO);
		
		return mav;
	}


	
}