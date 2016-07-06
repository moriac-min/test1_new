package foodportal.admin.systemmngt.mapper;

import java.util.List;
import java.util.Map;

import egovframework.rte.psl.dataaccess.mapper.Mapper;
import foodportal.admin.systemmngt.vo.MetaVO;
import foodportal.admin.systemmngt.vo.UseMetaVO;

/**
 * MetaInfoMapper
 * @author 박재형
 * @since 2014.09.03
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

@Mapper("foodportal.admin.systemmngt.mapper.MetaInfoMapper")
public interface MetaInfoMapper {
	
	public List<MetaVO> selectMetaList(Map<String, Object> map);
	
	public List<UseMetaVO> selectUseMetaList(Map<String, Object> map);
	
	public int insertUseMetaList(Map<String, Object> map);
	
	public int deleteUseMetaList(Map<String, Object> map);
}
