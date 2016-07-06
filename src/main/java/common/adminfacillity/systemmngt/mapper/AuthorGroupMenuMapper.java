package common.adminfacillity.systemmngt.mapper;

import java.util.List;
import java.util.Map;

import egovframework.rte.psl.dataaccess.mapper.Mapper;
import common.adminfacillity.systemmngt.service.AuthorGroupMenuVO;
/**
 * AuthorGroupMenuMapper
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

@Mapper("common.adminfacillity.systemmngt.mapper.AuthorGroupMenuMapper")
public interface AuthorGroupMenuMapper {

	public List<AuthorGroupMenuVO> selectAuthorGroupMenu(Map<String, Object> map);
	
	public int insertAuthorGroupMenu(Map<String, Object> map);
	
	public int updateAuthorGroupMenu(Map<String, Object> map);
	
	public int deleteAuthorGroupMenu(Map<String, Object> map);
	
	public int deleteAllAuthorGroupMenu(Map<String, Object> map);
	
	public List<AuthorGroupMenuVO> selectAuthorMenuList(Map<String, Object> map);
}