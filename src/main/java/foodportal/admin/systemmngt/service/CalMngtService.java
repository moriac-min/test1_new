package foodportal.admin.systemmngt.service;

import java.util.List;

import common.commonfacillity.uia.WqBaseBean;
import foodportal.admin.systemmngt.vo.CalMngtVO;


/**
 * CalMngtService
 * @author 최연길
 * @since 2014.09.15
 * @version 1.0
 * @see
 * 
 * <pre>
 *  Modification Information
 *  수정일      수정자   수정내용
 *  ---------- -------- ---------------------------
 *  2014.09.15 최연길 최초 생성
 * </pre>
 * 
 * Copyright (C) 2014 by NDS., All right reserved.
 */

public interface CalMngtService {


	/**
	 * 캘린더 목록 조회
	 * 
	 * @param 
	 * @return 
	 * @exception Exception
	 */
	public List<CalMngtVO> selectCalMngtList(WqBaseBean ibean) throws Exception;
	
	/**
	 * 캘린더 상세 조회
	 * 
	 * @param 
	 * @return 
	 * @exception Exception
	 */
	public CalMngtVO selectCalMngtDetail(WqBaseBean ibean) throws Exception;
	
	/**
	 * 캘린더 등록
	 * 
	 * @param 
	 * @return 
	 * @exception Exception
	 */
	public int insertCalMngt(WqBaseBean ibean) throws Exception;
	
	/**
	 * 캘린더 수정
	 * 
	 * @param 
	 * @return 
	 * @exception Exception
	 */
	public int updateCalMngt(WqBaseBean ibean) throws Exception;
	
	/**
	 * 캘린더 삭제
	 * 
	 * @param 
	 * @return 
	 * @exception Exception
	 */
	public int deleteCalMngt(WqBaseBean ibean) throws Exception;
	
}