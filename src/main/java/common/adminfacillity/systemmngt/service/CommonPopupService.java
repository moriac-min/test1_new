package common.adminfacillity.systemmngt.service;

import java.util.List;
import java.util.Map;

import common.commonfacillity.uia.WqBaseBean;
/**
 * ProgramService
 * @author 유승엽
 * @since 2014.08.18
 * @version 1.0
 * @see
 * 
 * <pre>
 *  Modification Information
 *  수정일      수정자   수정내용
 *  ---------- -------- ---------------------------
 *  2014.08.18 유승엽 최초 생성
 * </pre>
 * 
 * Copyright (C) 2014 by NDS., All right reserved.
 */

public interface CommonPopupService {


	/**
	 * 공통팝업 조회
	 * 
	 * @param 
	 * @return 
	 * @exception Exception
	 */
	public List<CommonPopupVO> selectCommonPopup(WqBaseBean ibean) throws Exception;

	/**
	 * 공통팝업 저장
	 * 
	 * @param 
	 * @return 
	 * @exception Exception
	 */
	public int saveCommonPopup(WqBaseBean ibean) throws Exception;
	
	/**
	 * 공통팝업항목 조회
	 * 
	 * @param 
	 * @return 
	 * @exception Exception
	 */
	public List<CommonPopupItemVO> selectCommonPopupItem(WqBaseBean ibean) throws Exception;

	/**
	 * 공통팝업항목 저장
	 * 
	 * @param 
	 * @return 
	 * @exception Exception
	 */
	public int saveCommonPopupItem(WqBaseBean ibean) throws Exception;
}