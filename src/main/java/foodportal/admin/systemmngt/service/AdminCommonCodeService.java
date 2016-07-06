package foodportal.admin.systemmngt.service;

import java.util.List;

import common.commonfacillity.uia.WqBaseBean;
import foodportal.admin.systemmngt.vo.CommonCodeVO;

/**
 * AdminCommonCodeService
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

public interface AdminCommonCodeService {


	/**
	 * 헤더코드 목록 조회
	 * 
	 * @param 
	 * @return 
	 * @exception Exception
	 */
	public List<CommonCodeVO> selectHeaderCodeList(WqBaseBean ibean) throws Exception;
	
	/**
	 * 세부코드 목록 조회
	 * 
	 * @param 
	 * @return 
	 * @exception Exception
	 */
	public List<CommonCodeVO> selectDetailCodeList(WqBaseBean ibean) throws Exception;
	
	/**
	 * 공통코드 저장
	 * 
	 * @param 
	 * @return 
	 * @exception Exception
	 */
	public int saveCommonCode(WqBaseBean ibean) throws Exception;
	
}