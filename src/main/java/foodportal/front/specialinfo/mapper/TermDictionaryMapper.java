package foodportal.front.specialinfo.mapper;

import java.util.List;
import java.util.Map;

import egovframework.rte.psl.dataaccess.mapper.Mapper;
import foodportal.front.specialinfo.vo.TermDictionaryVO;

/**
 * AdministMeasureMapper
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
@Mapper("foodportal.front.specialinfo.mapper.TermDictionaryMapper")
public interface TermDictionaryMapper {

	public List<TermDictionaryVO> selectTermList(Map<String, Object> map);

	public int selectTermListTotalCnt(Map<String, Object> map);

	public TermDictionaryVO selectTermDetail(Map<String, Object> map);

}
