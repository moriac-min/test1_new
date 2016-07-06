package common.adminfacillity.systemmngt.service;

import java.util.List;
import java.util.Map;

import common.commonfacillity.uia.WqBaseBean;
/**
 * ProgramService
 * @author 김민규
 * @since 2014.08.18
 * @version 1.0
 * @see
 * 
 * <pre>
 *  Modification Information
 *  수정일      수정자   수정내용
 *  ---------- -------- ---------------------------
 *  2014.08.18 김민규 최초 생성
 * </pre>
 * 
 * Copyright (C) 2014 by NDS., All right reserved.
 */

public interface ProgramService {


	/**
	 * 프로그램 조회
	 * 
	 * @param 
	 * @return 
	 * @exception Exception
	 */
	public List<ProgramVO> selectProgram(WqBaseBean ibean) throws Exception;

	/**
	 * 프로그램 저장
	 * 
	 * @param 
	 * @return 
	 * @exception Exception
	 */
	public int saveProgram(WqBaseBean ibean) throws Exception;
	
	/**
	 * 프로그램 등록
	 * 
	 * @param 
	 * @return 
	 * @exception Exception
	 */
	public int insertProgram(Map<String,Object> map) throws Exception;

	/**
	 * 프로그램 수정
	 * 
	 * @param 
	 * @return 
	 * @exception Exception
	 */
	public int updateProgram(Map<String,Object> map) throws Exception;

	/**
	 * 프로그램 삭제
	 * 
	 * @param 
	 * @return 
	 * @exception Exception
	 */
	public int deleteProgram(Map<String,Object> map) throws Exception;
}