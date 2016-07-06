package common.adminfacillity.systemmngt.mapper;

import java.util.List;
import java.util.Map;

import egovframework.rte.psl.dataaccess.mapper.Mapper;
import common.adminfacillity.systemmngt.service.CommonCodeVO;
import common.adminfacillity.systemmngt.service.CommonCodeDataVO;
/**
 * CommonCodeMapper
 * @author 김민규
 * @since 2014.08.19
 * @version 1.0
 * @see
 * 
 * <pre>
 *  Modification Information
 *  수정일      수정자   수정내용
 *  ---------- -------- ---------------------------
 *  2014.08.19 김민규 최초 생성
 * </pre>
 * 
 * Copyright (C) 2014 by NDS., All right reserved.
 */

@Mapper("common.adminfacillity.systemmngt.mapper.CommonCodeMapper")
public interface CommonCodeMapper {

	public List<CommonCodeVO> selectCommonCode(Map<String, Object> map);
	
	public int insertCommonCode(Map<String, Object> map);
	
	public int deleteCommonCode(Map<String, Object> map);
	
	public int updateCommonCode(Map<String, Object> map);
	
	public List<CommonCodeDataVO> selectCommonCodeDetail(Map<String, Object> map);
	
	public int insertCommonCodeDetail(Map<String, Object> map);
	
	public int deleteCommonCodeDetail(Map<String, Object> map);
	
	public int updateCommonCodeDetail(Map<String, Object> map);
	
	public List<CommonCodeDataVO> selectCommonCodeFunction(Map<String, Object> map);
	
}