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

import common.adminfacillity.systemmngt.service.SystemUseLogService;
import common.adminfacillity.systemmngt.service.SystemUseLogVO;
import common.adminfacillity.systemmngt.service.AdminfacillitySystemmngtRootVO;

/**
 * SystemUseLogController
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
public class SystemUseLogController {

	@CommonLog Logger log;
	@Autowired
	private SystemUseLogService systemUseLogService;

	/**
	 * 등록된 시스템사용로그 정보 조회
	 * 
	 * @param 
	 * @return ModelAndView
	 * @throws Exception
	 */
	@RequestMapping(value = "/adminfacillity/systemmngt/selectSystemUseLog.do")
	@BEAN_DEF(beans={"root=common.adminfacillity.systemmngt.service.AdminfacillitySystemmngtRootVO", "[DataCollectionName]=common.adminfacillity.systemmngt.service.SystemUseLogVO"})
	public ModelAndView selectSystemUseLog(WqBaseBean ibean) throws Exception {
		ModelAndView mav = new ModelAndView("wqView");
		//TODO selectSystemUseLog 메소드 구현
		//mav.addObject("result", [Object]);
		
		return mav;
	}
}