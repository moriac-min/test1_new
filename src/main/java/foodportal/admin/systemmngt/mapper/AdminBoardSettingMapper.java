package foodportal.admin.systemmngt.mapper;

import java.util.List;
import java.util.Map;

import egovframework.rte.psl.dataaccess.mapper.Mapper;
import foodportal.admin.systemmngt.vo.BoardSettingVO;
import foodportal.admin.systemmngt.vo.HCategorySettingVo;
import foodportal.admin.systemmngt.vo.UserSearchVO;

/**
 * AdminBoardSettingMapper
 * @author 최연길
 * @since 2014.08.29
 * @version 1.0
 * @see
 * 
 * <pre>
 *  Modification Information
 *  수정일      수정자   수정내용
 *  ---------- -------- ---------------------------
 *  2014.08.27 최연길 최초 생성
 * </pre>
 * 
 * Copyright (C) 2014 by NDS., All right reserved.
 */

@Mapper("foodportal.admin.systemmngt.mapper.AdminBoardSettingMapper")
public interface AdminBoardSettingMapper {

	public List<BoardSettingVO> selectBoardSettingList(Map<String, Object> map);
	
	//public String selectNewBoardSettingNo();
	
	public int insertBoardSettingBbs(Map<String, Object> map);
	
	public int insertBoardSettingCtgry(Map<String, Object> map);
	
	public int insertBoardSettingUser(Map<String, Object> map);
	
	public int updateBoardSettingBbs(Map<String, Object> map);
	
	public int updateBoardSettingCtgry(Map<String, Object> map);
	
	public int deleteBoardSettingUser(Map<String, Object> map);
	
	public BoardSettingVO selectBoardSettingDetail(Map<String, Object> map);
	
	public List<BoardSettingVO> selectBoardSettingDetailUser(Map<String, Object> map);
	
	public BoardSettingVO selectBoardSettingCheck(Map<String, Object> map);

}