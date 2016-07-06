package foodportal.front.common.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import common.commonfacillity.log.CommonLog;

import foodportal.front.common.service.FrontCommonService;

/**
 * FrontCommonController
 * @author 장영철
 * @since 2014.10.13
 * @version 1.0
 * @see
 *
 * <pre>
 *  Modification Information
 *  수정일      수정자   수정내용
 *  ---------- -------- ---------------------------
 *  2014.10.13 장영철 최초 생성
 * </pre>
 *
 * Copyright (C) 2014 by NDS., All right reserved.
 */

@Controller
public class FrontCommonController {
	@CommonLog Logger log;
	
	@Autowired
	private FrontCommonService frontCommonService;
	
	/**
	 * 파일 다운 로드
	 * @param request(filePath - 저장된 파일 경로, fileName - 저장된 파일명, orgFileName-다운받을 파일명)
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping("/common/downloadAttchdFile.do")
	public void downloadAttchdFile(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		frontCommonService.downloadAttchdFile(request, response);
		
	}

}
