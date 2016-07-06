package common.adminfacillity.systemmngt.service;

import java.util.List;
import java.util.Map;

import common.commonfacillity.uia.WqBaseBean;

/**
 * OrganizationService
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

public interface OrganizationService {


	/**
	 * 기관 조회
	 * 
	 * @param 
	 * @return 
	 * @exception Exception
	 */
	public List<OrganizationVO> selectOrganization(WqBaseBean ibean) throws Exception;

	/**
	 * 기관 등록
	 * 
	 * @param 
	 * @return 
	 * @exception Exception
	 */
	public int insertOrganization(WqBaseBean ibean) throws Exception;

	/**
	 * 기관 수정
	 * 
	 * @param 
	 * @return 
	 * @exception Exception
	 */
	public int updateOrganization(WqBaseBean ibean) throws Exception;

	/**
	 * 기관 삭제
	 * 
	 * @param 
	 * @return 
	 * @exception Exception
	 */
	public int deleteOrganization(WqBaseBean ibean) throws Exception;
}