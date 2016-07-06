package foodportal.admin.systemmngt.mapper;

import java.util.List;
import java.util.Map;

import egovframework.rte.psl.dataaccess.mapper.Mapper;
import foodportal.admin.systemmngt.vo.AuthVO;
import foodportal.admin.systemmngt.vo.UserAuthMenuVO;
import foodportal.admin.systemmngt.vo.UserAuthVO;
import foodportal.admin.systemmngt.vo.UserVO;

/**
 * UserAuthMapper
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

@Mapper("foodportal.admin.systemmngt.mapper.UserAuthMapper")
public interface UserAuthMapper {

	public List<UserVO> selectUserList(Map<String, Object> map);
	
	public List<AuthVO> selectAuthList(Map<String, Object> map);
	
	public List<UserAuthVO> selectUserAuthList(Map<String, Object> map);
	
	public List<UserAuthMenuVO> selectUserAuthMenuList(Map<String, Object> map);
	
	public int insertUserAuth(Map<String, Object> map);
	
	public int updateUserAuth(Map<String, Object> map);
	
	public int deleteUserAuth(Map<String, Object> map);
	
}