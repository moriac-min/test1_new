package foodportal.front.member.service;

import java.util.List;

import foodportal.front.member.vo.MemberVO;

/**
 * MemberService
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

public interface MemberService {

	/**
	 * 회원 목록 조회
	 * 
	 * @param 
	 * @return 
	 * @exception Exception
	 */
	public List<MemberVO> selectMemberList(MemberVO memberVO) throws Exception;
	
	/**
	 * 회원 조회
	 * 
	 * @param 
	 * @return 
	 * @exception Exception
	 */
	public MemberVO selectMember(MemberVO memberVO) throws Exception;
	
	/**
	 * 기업 회원 조회
	 * 
	 * @param 
	 * @return 
	 * @exception Exception
	 */
	public MemberVO selectEnterpriseMember(MemberVO memberVO) throws Exception;

	/**
	 * 정책 조회
	 * 
	 * @param 
	 * @return 
	 * @exception Exception
	 */
	public MemberVO selectPolicy(MemberVO memberVO) throws Exception;

	/**
	 * 정책 조회 목록
	 * 
	 * @param 
	 * @return 
	 * @exception Exception
	 */
	public List<MemberVO> selectPolicyList(MemberVO memberVO) throws Exception;

	/**
	 * ID 중복 조회
	 * 
	 * @param 
	 * @return 
	 * @exception Exception
	 */
	public MemberVO selectIdDuplication(MemberVO memberVO) throws Exception;

	/**
	 * 회원 등록
	 * 
	 * @param 
	 * @return 
	 * @exception Exception
	 */
	public int insertMember(MemberVO memberVO);

	/**
	 * 회원 정보 수정
	 * 
	 * @param 
	 * @return 
	 * @exception Exception
	 */
	public int updateMember(MemberVO memberVO);
	
	
	/**
	 * 특정 사용자에 대해 1회용 비밀 토큰을 생성한다
	 * @param memberId
	 * @return
	 */
	public String generateMemberToken(String memberId);

	/**
	 * 특정 사용자의 비밀 토큰이 일치하는지 확인한다
	 * @param memberId
	 * @param token
	 * @return
	 */
	public boolean memberTokenMatches(String memberId, String token);

}