package foodportal.admin.systemmngt.mapper;

import java.util.List;
import java.util.Map;

import egovframework.rte.psl.dataaccess.mapper.Mapper;
import foodportal.admin.systemmngt.vo.CalMngtVO;

/**
 * CalMngtMapper
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

@Mapper("foodportal.admin.systemmngt.mapper.CalMngtMapper")
public interface CalMngtMapper {

	public List<CalMngtVO> selectCalMngtList(Map<String, Object> map);
	
	public CalMngtVO selectCalMngtDetail(Map<String, Object> map);
	
	public int insertCalMngt(Map<String, Object> map);
	
	public int updateCalMngt(Map<String, Object> map);
	
	public int deleteCalMngt(Map<String, Object> map);
	
}