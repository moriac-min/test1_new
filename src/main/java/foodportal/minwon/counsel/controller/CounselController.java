package foodportal.minwon.counsel.controller;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import common.commonfacillity.log.CommonLog;
import foodportal.minwon.counsel.service.CounselService;

/**
 * CounselController
 * @author 장영철
 * @since 2014.10.16
 * @version 1.0
 * @see
 *
 * <pre>
 *  Modification Information
 *  수정일      수정자   수정내용
 *  ---------- -------- ---------------------------
 *  2014.10.16 장영철 최초 생성
 * </pre>
 *
 * Copyright (C) 2014 by NDS., All right reserved.
 */

@Controller
public class CounselController {
	
	@CommonLog Logger log;
	
	@Autowired
	private CounselService counselService;
	
	/**
	 * 국민신문고
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/minwon/counsel/ePeople.do")
	public String ePeople(Model model) throws Exception {
		
		return "minwon/counsel/ePeople";
	}
	
	/**
	 * 국민신문고 - 나의 민원
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/minwon/counsel/myePeople.do")
	public String myePeople(Model model) throws Exception {
		
		return "minwon/counsel/myePeople";
	}
	

}
