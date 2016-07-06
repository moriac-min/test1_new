package common.adminfacillity.systemmngt.service;

import java.util.List;
import java.util.Map;

import common.commonfacillity.uia.WqBaseBean;

/**
 * CommonCodeService
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

public interface CommonCodeService {


	/**
	 * 등록된 공통코드 정보 조회
	 * 
	 * @param 
	 * @return 
	 * @exception Exception
	 */
	public List<CommonCodeVO> selectCommonCode(WqBaseBean ibean) throws Exception;
	
	/**
	 * 공통코드 정보 등록
	 * 
	 * @param 
	 * @return 
	 * @exception Exception
	 */
	public int saveCommonCode(WqBaseBean ibean) throws Exception;
	
	/**
	 * 신규 공통코드 정보 등록
	 * 
	 * @param 
	 * @return 
	 * @exception Exception
	 */
	public int insertCommonCode(WqBaseBean ibean) throws Exception;

	/**
	 * 등록된 공통코드 정보 삭제
	 * 
	 * @param 
	 * @return 
	 * @exception Exception
	 */
	public int deleteCommonCode(WqBaseBean ibean) throws Exception;

	/**
	 * 등록된 공통코드 정보 수정
	 * 
	 * @param 
	 * @return 
	 * @exception Exception
	 */
	public int updateCommonCode(WqBaseBean ibean) throws Exception;

	/**
	 * 등록된 공통코드상세 정보 조회
	 * 
	 * @param 
	 * @return 
	 * @exception Exception
	 */
	public List<CommonCodeDataVO> selectCommonCodeDetail(WqBaseBean ibean) throws Exception;

	/**
	 * 신규 공통코드상세 정보 등록
	 * 
	 * @param 
	 * @return 
	 * @exception Exception
	 */
	public int insertCommonCodeDetail(WqBaseBean ibean) throws Exception;

	/**
	 * 등록된 공통코드상세 정보 삭제
	 * 
	 * @param 
	 * @return 
	 * @exception Exception
	 */
	public int deleteCommonCodeDetail(WqBaseBean ibean) throws Exception;

	/**
	 * 등록된 공통코드상세 정보 수정
	 * 
	 * @param 
	 * @return 
	 * @exception Exception
	 */
	public int updateCommonCodeDetail(WqBaseBean ibean) throws Exception;
	
	/**
	 * 공통코드 함수 호출
	 * 
	 * @param ibean
	 * @return
	 * @throws Exception
	 */
	public List<CommonCodeDataVO> selectCommonCodeFunction(WqBaseBean ibean) throws Exception;
}