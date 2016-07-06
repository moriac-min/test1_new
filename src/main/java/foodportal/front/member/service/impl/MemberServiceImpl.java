package foodportal.front.member.service.impl;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.codec.binary.Base64;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import common.commonfacillity.log.CommonLog;
import common.commonfacillity.util.CommonConvertObjectToMap;

import egovframework.rte.fdl.cmmn.AbstractServiceImpl;
import egovframework.rte.fdl.cryptography.EgovCryptoService;
import egovframework.rte.fdl.property.EgovPropertyService;
import foodportal.front.member.mapper.MemberMapper;
import foodportal.front.member.service.MemberService;
import foodportal.front.member.vo.MemberVO;

/**
 * MemberServiceImpl
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

@Service("memberService")
public class MemberServiceImpl extends AbstractServiceImpl implements MemberService {

	@CommonLog Logger log;

	@Autowired
	MemberMapper memberMapper;
	
	@Autowired
	EgovPropertyService propertiesService;
	
	@Resource(name = "ARIACryptoService")
	EgovCryptoService crytoService;
	
	@Transactional(readOnly=true)
	public List<MemberVO> selectMemberList(MemberVO memberVO) throws Exception {
		HashMap<String, Object> map = new HashMap<String, Object>();
		
		try{
			map = CommonConvertObjectToMap.ConverObjectToMap(memberVO);
			
			List<MemberVO> list = memberMapper.selectMemberList(map);
			
			return list;
			
		} catch(Exception e) {
			throw e;
		}
	}
	
	@Transactional(readOnly=true)
	public MemberVO selectPolicy(MemberVO memberVO) throws Exception {
		HashMap<String, Object> map = new HashMap<String, Object>();
		
		try{
			map = CommonConvertObjectToMap.ConverObjectToMap(memberVO);
			
			MemberVO mv = memberMapper.selectPolicy(map);
			
			return mv;
			
		} catch(Exception e) {
			throw e;
		}
	}
	
	private SecureRandom secureRandom = new SecureRandom();
	public final static File TokenFolder = new File(System.getProperty("java.io.tmpdir"), "mfdsTokens");

	@Override
	public String generateMemberToken(String memberId) {
		String token = new BigInteger(130, secureRandom).toString(32);

		if (memberId != null && !memberId.contains("..") && !memberId.contains("/") && !memberId.contains("\\")) {
			if (!TokenFolder.exists())
				TokenFolder.mkdir();
			
			try {
				FileWriter writer = new FileWriter(new File(TokenFolder, memberId));
				writer.write(memberId + token);
				writer.close();
			} catch (IOException e) {
			}
		}
		
		return token;
	}

	@Override
	public boolean memberTokenMatches(String memberId, String token) {
		if (memberId == null)
			return false;
		
		File file = new File(TokenFolder, memberId);
		if (memberId.contains("..") || memberId.contains("/") || memberId.contains("\\") || !file.canRead()) {
			log.debug("토큰 파일을 찾을 수 없음");
			return false;
		}
		
		if (file.length() != memberId.length() + token.length())
			return false;
		
		char[] buf = new char[memberId.length() + token.length()];
		try {
			FileReader reader = new FileReader(file);
			reader.read(buf);
			reader.close();
		} catch (IOException e) {
		}
		
		return (memberId + token).equals(new String(buf));
	}

	public void deleteMemberToken() {
		// TODO 하드코딩된 ID를 프로그램적으로 가져오기
		String memberId = "testUser";
		if (!memberId.contains("..") && !memberId.contains("/") && !memberId.contains("\\")) {
	    	File tokenFile = new File(MemberServiceImpl.TokenFolder, memberId);
	    	tokenFile.delete();
		}
	}

	@Transactional(readOnly=true)
	public MemberVO selectEnterpriseMember(MemberVO memberVO) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		
		try{
			map = CommonConvertObjectToMap.ConverObjectToMap(memberVO);
			
			MemberVO mv = memberMapper.selectEnterpriseMember(map);
			
			return mv;
			
		} catch(Exception e) {
			throw e;
		}
	}

	@Transactional(readOnly=true)
	public MemberVO selectMember(MemberVO memberVO) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		
		try{
			map = CommonConvertObjectToMap.ConverObjectToMap(memberVO);
			
			String vPropPassword = propertiesService.getString("com.aria.password");
			byte[] encrypt = crytoService.encrypt(memberVO.getPassword().getBytes("UTF-8"),vPropPassword);
			//byte[] decrypt = crytoService.decrypt(encrypt,vPropPassword);
			//String dePw = new String(decrypt, "UTF-8");
			String ecoding = Base64.encodeBase64String(encrypt);
			//map.put("password", ecoding);
			
			MemberVO mv = memberMapper.selectMember(map);
			
			return mv;
			
		} catch(Exception e) {
			throw e;
		}
	}

	@Transactional(readOnly=true)
	public List<MemberVO> selectPolicyList(MemberVO memberVO) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		
		try{
			map = CommonConvertObjectToMap.ConverObjectToMap(memberVO);
			
			List<MemberVO> list = memberMapper.selectPolicyList(map);
			
			return list;
			
		} catch(Exception e) {
			throw e;
		}
	}

	@Transactional(readOnly=true)
	public MemberVO selectIdDuplication(MemberVO memberVO) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		
		try{
			map = CommonConvertObjectToMap.ConverObjectToMap(memberVO);
			
			MemberVO mv = memberMapper.selectIdDuplication(map);
			
			return mv;
			
		} catch(Exception e) {
			throw e;
		}
	}

	@Transactional
	public int insertMember(MemberVO memberVO) {
		Map<String, Object> map = new HashMap<String, Object>();
		try{
			map = CommonConvertObjectToMap.ConverObjectToMap(memberVO);
			
			String vPropPassword = propertiesService.getString("com.aria.password");
			byte[] encrypt = crytoService.encrypt(memberVO.getPassword().getBytes("UTF-8"),vPropPassword);
			String ecoding = Base64.encodeBase64String(encrypt);
			map.put("password", ecoding);
			
			memberMapper.insertMember(map);
			
			return 1;
		} catch (Exception e) {	
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			return 0;
		}
	}

	@Transactional
	public int updateMember(MemberVO memberVO) {
		Map<String, Object> map = new HashMap<String, Object>();
		try{
			map = CommonConvertObjectToMap.ConverObjectToMap(memberVO);
			
			String vPropPassword = propertiesService.getString("com.aria.password");
			byte[] encrypt = crytoService.encrypt(memberVO.getPassword().getBytes("UTF-8"),vPropPassword);
			String ecoding = Base64.encodeBase64String(encrypt);
			map.put("password", ecoding);
			
			memberMapper.updateMember(map);
			
			return 1;
		} catch (Exception e) {	
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			return 0;
		}
	}

}