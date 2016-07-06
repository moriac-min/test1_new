package foodportal.admin.systemmngt.service;

import java.util.List;

import common.commonfacillity.uia.WqBaseBean;

import foodportal.admin.systemmngt.vo.MetaVO;
import foodportal.admin.systemmngt.vo.UseMetaVO;

/**
 * MetaInfoService
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

public interface MetaInfoService {


	/**
	 * 등록된 메타 정보 조회
	 * 
	 * @param 
	 * @return 
	 * @exception Exception
	 */
	public List<MetaVO> selectMetaList(WqBaseBean ibean) throws Exception;
	
	/**
	 * 사용 메타 정보 조회
	 * 
	 * @param 
	 * @return 
	 * @exception Exception
	 */
	public List<UseMetaVO> selectUseMetaList(WqBaseBean ibean) throws Exception;
	
	/**
	 * 사용 메타 정보 저장
	 * 
	 * @param 
	 * @return 
	 * @exception Exception
	 */
	public int saveUseMetaList(WqBaseBean ibean, String flag) throws Exception;
	
	
	
	
}