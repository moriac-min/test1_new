package common.adminfacillity.systemmngt.service;

import java.util.List;
import java.util.Map;

import common.commonfacillity.uia.WqBaseBean;

/**
 * OrganizationAuthorGroupService
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

public interface OrganizationAuthorGroupService {


	/**
	 * 기관별 권한 그룹 조회
	 * 
	 * @param 
	 * @return 
	 * @exception Exception
	 */
	public List<OrganizationAuthorGroupVO> selectOrganizationAuthorGroup(WqBaseBean ibean) throws Exception;

	/**
	 * 미등록 권한 그룹 조회
	 * 
	 * @param 
	 * @return 
	 * @exception Exception
	 */
	public List<AuthorGroupVO> selectNoneRegAuthorGroup(WqBaseBean ibean) throws Exception;

	/**
	 * 기관별 권한 그룹 저장
	 * 
	 * @param 
	 * @return 
	 * @exception Exception
	 */
	public int saveOrganizationAuthorGroup(WqBaseBean ibean) throws Exception;
	
	/**
	 * 기관별 권한 그룹 등록
	 * 
	 * @param 
	 * @return 
	 * @exception Exception
	 */
	public int insertOrganizationAuthorGroup(WqBaseBean ibean) throws Exception;

	/**
	 * 기관별 권한 그룹 삭제
	 * 
	 * @param 
	 * @return 
	 * @exception Exception
	 */
	public int deleteOrganizationAuthorGroup(WqBaseBean ibean) throws Exception;
}