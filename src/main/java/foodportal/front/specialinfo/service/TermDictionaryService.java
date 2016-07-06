package foodportal.front.specialinfo.service;

import java.util.Map;

import foodportal.front.specialinfo.vo.TermDictionaryVO;

/**
 * TermDictionaryService
 * @author 최승희
 * @since 2014.10.10
 * @version 1.0
 * @see
 * 
 * <pre>
 *  Modification Information
 *  수정일      수정자   수정내용
 *  ---------- -------- ---------------------------
 *  2014.10.10 최승희 최초 생성
 * </pre>
 * 
 * Copyright (C) 2014 by NDS., All right reserved.
 */
public interface TermDictionaryService {

	Map<String, Object> selectTermList(TermDictionaryVO termDictionaryVO) throws Exception;

	Map<String, Object> selectTermDetail(TermDictionaryVO termDictionaryVO) throws Exception;

}
