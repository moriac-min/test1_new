package foodportal.front.fooddanger.service;

import java.util.Map;

import foodportal.front.fooddanger.vo.CrackdownVO;
import foodportal.front.fooddanger.vo.MarienCrackdownVO;

/**
 * CrackdownService
 * @author 박재형
 * @since 2014.09.25
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

public interface CrackdownService {

	/**
	 * 농축산물원산지표시위반 목록
	 * @param paramMap
	 * @return
	 * @throws Exception
	 */
	public Map<String, Object> selectAgriCrackdownList(Map<String, Object> map) throws Exception;
	
	/**
	 * 농축산물원산지표시위반 상세
	 * @param paramMap
	 * @return
	 * @throws Exception
	 */
	public CrackdownVO selectAgriCrackdownDetail(Map<String, Object> map) throws Exception;
	
	/**
	 * 수산물원산지표시위반 목록
	 * @param paramMap
	 * @return
	 * @throws Exception
	 */
	public Map<String, Object> selectMarienCrackdownList(Map<String, Object> map) throws Exception;
	
	/**
	 * 수산물원산지표시위반 상세
	 * @param paramMap
	 * @return
	 * @throws Exception
	 */
	public MarienCrackdownVO selectMarienCrackdownDetail(Map<String, Object> map) throws Exception;
	
}