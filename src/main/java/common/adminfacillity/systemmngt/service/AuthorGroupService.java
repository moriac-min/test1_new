package common.adminfacillity.systemmngt.service;

import java.util.List;
import java.util.Map;

import common.commonfacillity.uia.WqBaseBean;

/**
 * AuthorGroupService
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

public interface AuthorGroupService {

	/**
	 * 등록된 권한 그룹 정보 조회
	 * 
	 * @param 
	 * @return 
	 * @exception Exception
	 */
	public List<AuthorGroupVO> selectAuthorGroup(WqBaseBean ibean) throws Exception;
	
	/**
	 * 권한 그룹 정보 저장
	 * 
	 * @param ibean
	 * @return
	 * @throws Exception
	 */
	public int saveAuthorGroup(WqBaseBean ibean) throws Exception;
	
	/**
	 * 등록된 권한 그룹 정보 수정
	 * 
	 * @param 
	 * @return 
	 * @exception Exception
	 */
	public int updateAuthorGroup(WqBaseBean ibean) throws Exception;	

	/**
	 * 신규 권한 그룹 정보 등록
	 * 
	 * @param 
	 * @return 
	 * @exception Exception
	 */
	public int insertAuthorGroup(WqBaseBean ibean) throws Exception;

	/**
	 * 등록된 권한 그룹 정보 삭제
	 * 
	 * @param 
	 * @return 
	 * @exception Exception
	 */
	public int deleteAuthorGroup(WqBaseBean ibean) throws Exception;
}