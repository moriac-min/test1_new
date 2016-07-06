package common.adminfacillity.systemmngt.mapper;

import java.util.List;
import java.util.Map;

import egovframework.rte.psl.dataaccess.mapper.Mapper;
import common.adminfacillity.systemmngt.service.AuthorGroupVO;
import common.adminfacillity.systemmngt.service.OrganizationAuthorGroupVO;
/**
 * OrganizationAuthorGroupMapper
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

@Mapper("common.adminfacillity.systemmngt.mapper.OrganizationAuthorGroupMapper")
public interface OrganizationAuthorGroupMapper {

	public List<AuthorGroupVO> selectNoneRegAuthorGroup(Map<String, Object> map);
	
	public int insertOrganizationAuthorGroup(Map<String, Object> map);
	
	public int deleteOrganizationAuthorGroup(Map<String, Object> map);
	
	public List<OrganizationAuthorGroupVO> selectOrganizationAuthorGroup(Map<String, Object> map);
	
}