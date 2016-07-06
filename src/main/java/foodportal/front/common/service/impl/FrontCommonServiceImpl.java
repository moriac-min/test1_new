package foodportal.front.common.service.impl;

import java.io.File;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.springframework.stereotype.Service;

import common.commonfacillity.log.CommonLog;
import foodportal.common.util.DownloadUtil;
import foodportal.common.util.StringUtil;
import foodportal.front.common.service.FrontCommonService;

/**
 * FrontCommonServiceImpl
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

@Service("FrontCommonService")
public class FrontCommonServiceImpl implements FrontCommonService {
	
	@CommonLog Logger log;
	
	/**
	 * 파일 다운로드
	 * @param request(filePath, fileName, orgFileName)
	 * @param response
	 * @throws Exception
	 */
	public void downloadAttchdFile(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String filePath = StringUtil.nullToStr(request.getParameter("filePath"));			//파일경로
		String fileName = StringUtil.nullToStr(request.getParameter("fileName"));		//저장된 파일명
		String downloadFileName = StringUtil.nullToStr(request.getParameter("orgFileName"));		//다운받을 파일명
		
		
		try{
			
			File file = new File(filePath+"/"+fileName);
			
			//파일다운로드
			DownloadUtil.download(request, response, file, downloadFileName);
			
		} catch(Exception e) {
			e.printStackTrace();
			
			throw e;
		}
	}

}
