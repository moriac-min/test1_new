package foodportal.admin.systemmngt.service;

import java.util.List;

import common.commonfacillity.uia.WqBaseBean;
import foodportal.admin.systemmngt.vo.MetaKeyPopupVO;

/**
 * MetaKeyPopupService
 * @author 최연길
 * @since 2014.09.17
 * @version 1.0
 * @see
 * 
 * <pre>
 *  Modification Information
 *  수정일      수정자   수정내용
 *  ---------- -------- ---------------------------
 *  2014.09.17 최연길 최초 생성
 * </pre>
 * 
 * Copyright (C) 2014 by NDS., All right reserved.
 */

public interface MetaKeyPopupService {


	/**
	 * 사용자 조회
	 * 
	 * @param 
	 * @return 
	 * @exception Exception
	 */
	public List<MetaKeyPopupVO> selectMetaKeyPopupList(WqBaseBean ibean) throws Exception;
	
}