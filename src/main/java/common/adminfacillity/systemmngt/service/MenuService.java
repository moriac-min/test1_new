package common.adminfacillity.systemmngt.service;

import java.util.List;
import java.util.Map;

import common.commonfacillity.uia.WqBaseBean;

/**
 * MenuService
 * @author 유승엽
 * @since 2014.08.19
 * @version 1.0
 * @see
 * 
 * <pre>
 *  Modification Information
 *  수정일      수정자   수정내용
 *  ---------- -------- ---------------------------
 *  2014.08.19 유승엽 최초 생성
 * </pre>
 * 
 * Copyright (C) 2014 by NDS., All right reserved.
 */

public interface MenuService {


	/**
	 * 등록된 메뉴 정보 조회
	 * 
	 * @param 
	 * @return 
	 * @exception Exception
	 */
	public List<MenuVO> selectMenu(WqBaseBean ibean) throws Exception;

	/**
	 * 신규 메뉴 정보 저장
	 * 
	 * @param 
	 * @return 
	 * @exception Exception
	 */
	public int saveMenu(WqBaseBean ibean) throws Exception;

	
}