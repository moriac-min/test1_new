package foodportal.admin.systemmngt.mapper;

import java.util.List;
import java.util.Map;

import egovframework.rte.psl.dataaccess.mapper.Mapper;
import foodportal.admin.systemmngt.vo.CommonCodeVO;

/**
 * AdminCommonCodeMapper
 * @author 임재록
 * @since 2014.08.29
 * @version 1.0
 * @see
 * 
 * <pre>
 *  Modification Information
 *  수정일      수정자   수정내용
 *  ---------- -------- ---------------------------
 *  2014.08.29 임재록 최초 생성
 * </pre>
 * 
 * Copyright (C) 2014 by NDS., All right reserved.
 */

@Mapper("foodportal.admin.systemmngt.mapper.AdminCommonCodeMapper")
public interface AdminCommonCodeMapper {

	public List<CommonCodeVO> selectHeaderCodeList(Map<String, Object> map);
	
	public List<CommonCodeVO> selectDetailCodeList(Map<String, Object> map);
	
	public int insertCommonCode(Map<String, Object> map);
	
	public int updateCommonCode(Map<String, Object> map);
	
	public int deleteCommonCode(Map<String, Object> map);
	
}