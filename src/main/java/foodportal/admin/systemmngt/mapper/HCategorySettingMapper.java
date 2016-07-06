package foodportal.admin.systemmngt.mapper;

import java.util.List;
import java.util.Map;

import egovframework.rte.psl.dataaccess.mapper.Mapper;
import foodportal.admin.systemmngt.vo.HCategorySettingVo;

/**
 * HCategorySettingMapper
 * @author 박재형
 * @since 2014.09.01
 * @version 1.0
 * @see
 * 
 * <pre>
 *  Modification Information
 *  수정일      수정자   수정내용
 *  ---------- -------- ---------------------------
 *  2014.08.27 박재형 최초 생성
 * </pre>
 * 
 * Copyright (C) 2014 by NDS., All right reserved.
 */

@Mapper("foodportal.admin.systemmngt.mapper.HCategorySettingMapper")
public interface HCategorySettingMapper {
	
	public List<HCategorySettingVo> selectHCategorySettingList(Map<String, Object> map);
	
	public int insertHCategorySettingList(Map<String, Object> map);
	
	public int updateHCategorySettingList(Map<String, Object> map);
	
	public int deleteHCategorySettingList(Map<String, Object> map);
	
	public List<HCategorySettingVo> selectLCategorySettingList(Map<String, Object> map);
	
	public int insertLCategorySettingList(Map<String, Object> map);
	
	public int updateLCategorySettingList(Map<String, Object> map);
	
	public int deleteLCategorySettingList(Map<String, Object> map);
	
	public int deleteSimpleLCategorySettingList(Map<String, Object> map);
	
}
