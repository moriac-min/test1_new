package foodportal.front.fooddanger.service;

import java.util.Map;

import foodportal.front.fooddanger.vo.AdministMeasureVO;

/**
 * AdministMeasureService
 * @author 박재형
 * @since 2014.10.06
 * @version 1.0
 * @see
 * 
 * <pre>
 *  Modification Information
 *  수정일      수정자   수정내용
 *  ---------- -------- ---------------------------
 *  2014.10.06 박재형 최초 생성
 * </pre>
 * 
 * Copyright (C) 2014 by NDS., All right reserved.
 */

public interface AdministMeasureService {

	/**
	 * 행정처분 목록
	 * @param paramMap
	 * @return
	 * @throws Exception
	 */
	public Map<String, Object> selectAdministMeasureList(Map<String, Object> map) throws Exception;
	
	/**
	 * 행정처분 상세
	 * @param paramMap
	 * @return
	 * @throws Exception
	 */
	public AdministMeasureVO selectAdministMeasureDetail(Map<String, Object> map) throws Exception;
	
	
	
}