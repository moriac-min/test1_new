package foodportal.admin.systemmngt.mapper;

import java.util.List;
import java.util.Map;

import egovframework.rte.psl.dataaccess.mapper.Mapper;
import foodportal.admin.systemmngt.vo.MetaKeyPopupVO;

/**
 * MetaKeyPopupMapper
 * @author 최연길
 * @since 2014.09.17
 * @version 1.0
 * @see
 * 
 * <pre>
 *  Modification Information
 *  수정일      수정자   수정내용
 *  ---------- -------- ---------------------------
 *  2014.09.17 최연길 최초 생성
 * </pre>
 * 
 * Copyright (C) 2014 by NDS., All right reserved.
 */

@Mapper("foodportal.admin.systemmngt.mapper.MetaKeyPopupMapper")
public interface MetaKeyPopupMapper {

	public List<MetaKeyPopupVO> selectMetaKeyPopupList(Map<String, Object> map);

}