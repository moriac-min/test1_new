package foodportal.front.member.mapper;

import java.util.List;
import java.util.Map;

import egovframework.rte.psl.dataaccess.mapper.Mapper;
import foodportal.front.member.vo.MemberVO;

/**
 * MemberMapper
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

@Mapper("foodportal.front.member.mapper.MemberMapper")
public interface MemberMapper {

	public List<MemberVO> selectMemberList(Map<String, Object> map);
	
	public MemberVO selectPolicy(Map<String, Object> map);

	public List<MemberVO> selectPolicyList(Map<String, Object> map);
	
	public MemberVO selectEnterpriseMember(Map<String, Object> map);

	public MemberVO selectMember(Map<String, Object> map);

	public MemberVO selectIdDuplication(Map<String, Object> map);

	public void insertMember(Map<String, Object> map);

	public void updateMember(Map<String, Object> map);

	
}