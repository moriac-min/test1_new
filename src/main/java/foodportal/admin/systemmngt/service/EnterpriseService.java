package foodportal.admin.systemmngt.service;

import java.util.List;

import common.commonfacillity.uia.WqBaseBean;

import foodportal.admin.systemmngt.vo.EnterpriseMemberVO;
import foodportal.admin.systemmngt.vo.EnterpriseVO;

/**
 * EnterpriseService
 * @author 임재록
 * @since 2014.08.29
 * @version 1.0
 * @see
 * 
 * <pre>
 *  Modification Information
 *  수정일      수정자   수정내용
 *  ---------- -------- ---------------------------
 *  2014.08.29 임재록 최초 생성
 * </pre>
 * 
 * Copyright (C) 2014 by NDS., All right reserved.
 */

public interface EnterpriseService {

	/**
	 * 업체 목록 조회
	 * 
	 * @param 
	 * @return 
	 * @exception Exception
	 */
	public List<EnterpriseVO> selectEnterpriseList(WqBaseBean ibean) throws Exception;

	/**
	 * 업체별 회원 목록 조회
	 * 
	 * @param 
	 * @return 
	 * @exception Exception
	 */
	public List<EnterpriseMemberVO> selectEnterpriseMemberList(WqBaseBean ibean) throws Exception;
	
}