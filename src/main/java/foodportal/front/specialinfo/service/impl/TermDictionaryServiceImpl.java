package foodportal.front.specialinfo.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import common.commonfacillity.log.CommonLog;
import common.commonfacillity.util.CommonConvertObjectToMap;
import egovframework.rte.fdl.cmmn.AbstractServiceImpl;
import foodportal.front.specialinfo.mapper.TermDictionaryMapper;
import foodportal.front.specialinfo.service.TermDictionaryService;
import foodportal.front.specialinfo.vo.TermDictionaryVO;


/**
 * TermDictionaryServiceImpl
 * @author 최승희
 * @since 2014.10.10
 * @version 1.0
 * @see
 * 
 * <pre>
 *  Modification Information
 *  수정일      수정자   수정내용
 *  ---------- -------- ---------------------------
 *  2014.10.10 최승희	 최초 생성
 * </pre>
 * 
 * Copyright (C) 2014 by NDS., All right reserved.
 */
@Service("termDictionaryServiceImpl")
public class TermDictionaryServiceImpl extends AbstractServiceImpl implements TermDictionaryService {

	@CommonLog Logger log;
	@Autowired TermDictionaryMapper termDictionaryMapper;
	
	@Transactional(readOnly=true)
	public Map<String, Object> selectTermList(TermDictionaryVO termDictionaryVO) throws Exception {
		
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> resultMap = new HashMap<String, Object>();
		
		try{
			map = CommonConvertObjectToMap.ConverObjectToMap(termDictionaryVO);
			List<TermDictionaryVO> list = termDictionaryMapper.selectTermList(map);
			int total_cnt = termDictionaryMapper.selectTermListTotalCnt(map);
			
			resultMap.put("list", list);
			resultMap.put("total_cnt", total_cnt);
			
			return resultMap;
			
		} catch(Exception e) {
			throw e;
		}
	}

	@Transactional(readOnly=true)
	public Map<String, Object> selectTermDetail(TermDictionaryVO termDictionaryVO) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> resultMap = new HashMap<String, Object>();
		
		try{
			map = CommonConvertObjectToMap.ConverObjectToMap(termDictionaryVO);
			TermDictionaryVO termDictionaryVo = termDictionaryMapper.selectTermDetail(map);
			
			resultMap.put("termDetail", termDictionaryVo);
			
			return resultMap;
			
		} catch(Exception e) {
			throw e;
		}
	}
	
	
	
}
