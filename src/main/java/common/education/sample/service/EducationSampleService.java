package common.education.sample.service;

import java.util.List;
import java.util.Map;

import common.commonfacillity.uia.WqBaseBean;

/**
 * EdusaService
 * @author 김민규
 * @since 2014.06.12
 * @version 1.0
 * @see
 *
 * <pre>
 *  Modification Information
 *  수정일      수정자   수정내용
 *  ---------- -------- ---------------------------
 *  2014.06.12 김민규   최초 생성
 * </pre>
 *
 * Copyright (C) 2014 by NDS., All right reserved.
 */

public interface EducationSampleService {
	
	/**
	 * 교육용사원목록 조회
	 *
	 * @param EdusbVO
	 * @return List
	 * @exception Exception	 
	 */
	public List<EducationSampleVO> selectEduSawonList(WqBaseBean ibean) throws Exception;
	
	/**
	 * 교육용자료 저장
	 * 
	 * @param list
	 * @exception Exception	 
	 */
	public int saveEduSawon(WqBaseBean ibean) throws Exception;
	
	/**
	 * 교육용자료 입력
	 * 
	 * @param list
	 * @exception Exception	 
	 */
	public int insertEduSawon(WqBaseBean ibean) throws Exception;
	
	/**
	 * 교육용자료 수정
	 * 
	 * @param list
	 * @exception Exception	 
	 */
	public int updateEduSawon(WqBaseBean ibean) throws Exception;
	
	/**
	 * 교육용자료 삭제
	 * 
	 * @param list
	 * @exception Exception	 
	 */
	public int deleteEduSawon(WqBaseBean ibean) throws Exception;
}