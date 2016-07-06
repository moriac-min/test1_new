package foodportal.admin.systemmngt.mapper;

import java.util.List;
import java.util.Map;

import egovframework.rte.psl.dataaccess.mapper.Mapper;
import foodportal.admin.systemmngt.vo.HCategorySettingVo;
import foodportal.admin.systemmngt.vo.UserCategorySettingVO;

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

@Mapper("foodportal.admin.systemmngt.mapper.UserCategorySettingMapper")
public interface UserCategorySettingMapper {
	
	public List<UserCategorySettingVO> selectUserList(Map<String, Object> map);
	
	public List<HCategorySettingVo> selectUCategoryList(Map<String, Object> map);
	
	public int deleteUserCategorySetting(Map<String, Object> map);
	
	public int insertUserCategorySetting(Map<String, Object> map);
	
}
