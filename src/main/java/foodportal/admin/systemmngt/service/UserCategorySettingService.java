package foodportal.admin.systemmngt.service;

import java.util.List;

import common.commonfacillity.uia.WqBaseBean;
import foodportal.admin.systemmngt.vo.HCategorySettingVo;
import foodportal.admin.systemmngt.vo.MetaVO;
import foodportal.admin.systemmngt.vo.UseMetaVO;
import foodportal.admin.systemmngt.vo.UserCategorySettingVO;

/**
 * UserCategorySettingService
 * @author 박재형
 * @since 2014.09.03
 * @version 1.0
 * @see
 * 
 * <pre>
 *  Modification Information
 *  수정일      수정자   수정내용
 *  ---------- -------- ---------------------------
 *  2014.09.03 박재형 최초 생성
 * </pre>
 * 
 * Copyright (C) 2014 by NDS., All right reserved.
 */

public interface UserCategorySettingService {


	/**
	 * 사용자정보조회
	 * 
	 * @param 
	 * @return 
	 * @exception Exception
	 */
	public List<UserCategorySettingVO> selectUserList(WqBaseBean ibean) throws Exception;
	
	/**
	 * 카테고리 정보 조회
	 * 
	 * @param 
	 * @return 
	 * @exception Exception
	 */
	public List<HCategorySettingVo> selectUCategoryList(WqBaseBean ibean) throws Exception;
	
	/**
	 * 사용자별 카테고리 맵핑저장
	 * 
	 * @param 
	 * @return 
	 * @exception Exception
	 */
	public int updateUserCategorySetting(WqBaseBean ibean, String flag) throws Exception;
	
	
	
}