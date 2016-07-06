package common.adminfacillity.systemmngt.service;

import java.util.List;
import java.util.Map;

/**
 * CommonComboService
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

public interface CommonComboService {


	/**
	 * 등록된 공통콤보 정보 조회
	 * 
	 * @param 
	 * @return 
	 * @exception Exception
	 */
	public List<CommonComboVO> selectCommonCombo(Map<String,Object> map) throws Exception;

	/**
	 * 신규 공통콤보 정보 등록
	 * 
	 * @param 
	 * @return 
	 * @exception Exception
	 */
	public int insertCommonCombo(Map<String,Object> map) throws Exception;

	/**
	 * 등록된 공통콤보 정보 삭제
	 * 
	 * @param 
	 * @return 
	 * @exception Exception
	 */
	public int deleteCommonCombo(Map<String,Object> map) throws Exception;

	/**
	 * 등록된 공통콤보 정보 수정
	 * 
	 * @param 
	 * @return 
	 * @exception Exception
	 */
	public int updateCommonCombo(Map<String,Object> map) throws Exception;
}