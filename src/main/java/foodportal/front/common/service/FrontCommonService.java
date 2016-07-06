package foodportal.front.common.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * FrontCommonService
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

public interface FrontCommonService {
	
	/**
	 * 파일 다운로드
	 * @param request(filePath, fileName, orgFileName)
	 * @param response
	 * @throws Exception
	 */
	public void downloadAttchdFile(HttpServletRequest request, HttpServletResponse response) throws Exception;

}
