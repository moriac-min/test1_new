package common.adminfacillity.systemmngt.mapper;

import java.util.List;
import java.util.Map;

import egovframework.rte.psl.dataaccess.mapper.Mapper;
import common.adminfacillity.systemmngt.service.CommonComboVO;
/**
 * CommonComboMapper
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

@Mapper("common.adminfacillity.systemmngt.mapper.CommonComboMapper")
public interface CommonComboMapper {

	public List<CommonComboVO> selectCommonCombo(Map<String, String> map);
	
	public int insertCommonCombo(Map<String, Object> map);
	
	public int deleteCommonCombo(Map<String, Object> map);
	
	public int updateCommonCombo(Map<String, Object> map);
	
}