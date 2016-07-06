package foodportal.front.common.service;

import java.util.Map;
import java.util.Properties;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;


/**
 * FrontCommonPopupService
 * @author 박재형
 * @since 2014.10.07
 * @version 1.0
 * @see
 * 
 * <pre>
 *  Modification Information
 *  수정일      수정자   수정내용
 *  ---------- -------- ---------------------------
 *  2014.10.07 박재형 최초 생성
 * </pre>
 * 
 * Copyright (C) 2014 by NDS., All right reserved.
 */

public interface FrontCommonPopupService {

	/**
	 * 기관목록
	 * @param 
	 * @return 
	 * @exception Exception
	 */
	public Map<String, Object> searchOrgn(Map<String, Object> paramMap) throws Exception;
	
	/**
	 * 식품유형목록
	 * @param 
	 * @return 
	 * @exception Exception
	 */
	public Map<String, Object> searchFoodtype(Map<String, Object> paramMap) throws Exception;
	
	/**
	 * 원산지목록
	 * @param 
	 * @return 
	 * @exception Exception
	 */
	public Map<String, Object> searchFoodBase(Map<String, Object> paramMap) throws Exception;
	
	/**
	 * 업소목록(등록)
	 * @param 
	 * @return 
	 * @exception Exception
	 */
	public Map<String, Object> searchShop(Map<String, Object> paramMap) throws Exception;
	
	/**
	 * 업소목록(등록&미등록)
	 * @param paramMap
	 * @return
	 * @throws Exception
	 */
	public Map<String, Object> searchAllShop(Map<String, Object> paramMap) throws Exception;
	
	/**
	 * 파일업로드 프로세스
	 * @param request
	 * @param file
	 * @param properties
	 * @return
	 * @throws Exception
	 */
	public Map<String, Object> processFileUpload(HttpServletRequest request, MultipartFile file, Properties properties) throws Exception;
	
}