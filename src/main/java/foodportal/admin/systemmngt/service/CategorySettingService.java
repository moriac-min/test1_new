package foodportal.admin.systemmngt.service;

import java.util.List;

import common.commonfacillity.uia.WqBaseBean;

import foodportal.admin.systemmngt.vo.CategorySettingVO;

/**
 * CategorySettingService
 * @author 장영철
 * @since 2014.09.01
 * @version 1.0
 * @see
 * 
 * <pre>
 *  Modification Information
 *  수정일      수정자   수정내용
 *  ---------- -------- ---------------------------
 *  2014.09.01 장영철 최초 생성
 * </pre>
 * 
 * Copyright (C) 2014 by NDS., All right reserved.
 */

public interface CategorySettingService {
	
	/**
	 * 카테고리 목록 조회
	 * 
	 * @param 
	 * @return 
	 * @exception Exception
	 */
	public List<CategorySettingVO> selectCategorySettingList(WqBaseBean ibean) throws Exception;
	
	/**
	 * 카테고리 정보 저장
	 * 
	 * @param 
	 * @return 
	 * @exception Exception
	 */
	public int saveCategorySetting(WqBaseBean ibean) throws Exception;

}
