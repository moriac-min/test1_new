package common.adminfacillity.systemmngt.mapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import egovframework.rte.psl.dataaccess.mapper.Mapper;
import common.adminfacillity.systemmngt.service.UserVO;
/**
 * UserMapper
 * @author 유승엽
 * @since 2014.08.19
 * @version 1.0
 * @see
 * 
 * <pre>
 *  Modification Information
 *  수정일      수정자   수정내용
 *  ---------- -------- ---------------------------
 *  2014.08.19 유승엽 최초 생성
 * </pre>
 * 
 * Copyright (C) 2014 by NDS., All right reserved.
 */

@Mapper("common.adminfacillity.systemmngt.mapper.UserMapper")
public interface UserMapper {

	public List<UserVO> selectUser(HashMap<String, Object> map);
	
	public int insertUser(Map<String, Object> map);
	
	public int updateUser(Map<String, Object> map);
	
	public int initPassword(Map<String, Object> map);
	
}