package common.adminfacillity.systemmngt.mapper;

import java.util.List;
import java.util.Map;

import egovframework.rte.psl.dataaccess.mapper.Mapper;
import common.adminfacillity.systemmngt.service.ProgramVO;
/**
 * ProgramMapper
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

@Mapper("common.adminfacillity.systemmngt.mapper.ProgramMapper")
public interface ProgramMapper {

	public List<ProgramVO> selectProgram(Map<String, Object> map);
	
	public int insertProgram(Map<String, Object> map);
	
	public int updateProgram(Map<String, Object> map);
	
	public int deleteProgram(Map<String, Object> map);
	
}