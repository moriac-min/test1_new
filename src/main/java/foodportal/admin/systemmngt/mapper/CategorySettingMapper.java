package foodportal.admin.systemmngt.mapper;

import java.util.List;
import java.util.Map;

import egovframework.rte.psl.dataaccess.mapper.Mapper;
import foodportal.admin.systemmngt.vo.CategorySettingVO;

/**
 * CategorySettingMapper
 * @author 장영철
 * @since 2014.09.01
 * @version 1.0
 * @see
 * 
 * <pre>
 *  Modification Information
 *  수정일      수정자   수정내용
 *  ---------- -------- ---------------------------
 *  2014.09.01 장영철 최초 생성
 * </pre>
 * 
 * Copyright (C) 2014 by NDS., All right reserved.
 */

@Mapper("foodportal.admin.systemmngt.mapper.CategorySettingMapper")
public interface CategorySettingMapper {
	
	public List<CategorySettingVO> selectCategorySettingList(Map<String, Object> map);
	
	public String selectNewCtgryNo();
	
	public int insertCategorySetting(Map<String, Object> map);
	
	public int updateCategorySetting(Map<String, Object> map);
	
}
