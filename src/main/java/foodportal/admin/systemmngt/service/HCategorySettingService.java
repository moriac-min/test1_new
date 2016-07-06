package foodportal.admin.systemmngt.service;

import java.util.List;

import common.commonfacillity.uia.WqBaseBean;
import foodportal.admin.systemmngt.vo.HCategorySettingVo;

/**
 * HCategorySettingService
 * @author 박재형
 * @since 2014.09.01
 * @version 1.0
 * @see
 * 
 * <pre>
 *  Modification Information
 *  수정일      수정자   수정내용
 *  ---------- -------- ---------------------------
 *  2014.09.01 박재형 최초 생성
 * </pre>
 * 
 * Copyright (C) 2014 by NDS., All right reserved.
 */

public interface HCategorySettingService {


	/**
	 * 등록된 상위카테고리 정보 조회
	 * 
	 * @param 
	 * @return 
	 * @exception Exception
	 */
	public List<HCategorySettingVo> selectHCategorySettingList(WqBaseBean ibean) throws Exception;
	
	/**
	 * 상위카테고리 저장
	 * 
	 * @param 
	 * @return 
	 * @exception Exception
	 */
	public int saveHCategorySettingList(WqBaseBean ibean, String flag) throws Exception;
	
	/**
	 * 등록된 하위카테고리 정보 조회
	 * 
	 * @param 
	 * @return 
	 * @exception Exception
	 */
	public List<HCategorySettingVo> selectLCategorySettingList(WqBaseBean ibean) throws Exception;
	
	/**
	 * 하위카테고리 저장
	 * 
	 * @param 
	 * @return 
	 * @exception Exception
	 */
	public int saveLCategorySettingList(WqBaseBean ibean, String flag) throws Exception;
	
	
}