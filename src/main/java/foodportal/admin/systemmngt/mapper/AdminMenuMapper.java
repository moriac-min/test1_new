package foodportal.admin.systemmngt.mapper;

import java.util.List;
import java.util.Map;

import egovframework.rte.psl.dataaccess.mapper.Mapper;
import foodportal.admin.systemmngt.vo.BoardSettingVO;
import foodportal.admin.systemmngt.vo.MenuVO;

/**
 * AdminMenuMapper
 * @author 박재형
 * @since 2014.08.27
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

@Mapper("foodportal.admin.systemmngt.mapper.AdminMenuMapper")
public interface AdminMenuMapper {

	public List<MenuVO> selectMenuList(Map<String, Object> map);
	
	public String selectNewMenuNo();
	
	public int updateMenu(Map<String, Object> map);
	
	public int insertMenu(Map<String, Object> map);
	
	public MenuVO selectMenuDetail(Map<String, Object> map);
	
	public List<BoardSettingVO> selectBoardSettingList(Map<String, Object> map);
	
	public List<MenuVO> selectMainMenuList(Map<String, Object> map);
	
	public List<MenuVO> selectBbsMoveList(Map<String, Object> map);
	
	public List<MenuVO> selectBbsRelmCntntsList(Map<String, Object> map);
	
	public List<MenuVO> selectBbsRelmMenuList(Map<String, Object> map);
	
	public int deleteUseBbsRelmCntntsList(Map<String, Object> map);
	
	public int insertUseBbsRelmCntntsList(Map<String, Object> map);
	
	
}