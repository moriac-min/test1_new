package foodportal.front.common.service.impl;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import com.google.gson.Gson;

import common.commonfacillity.log.CommonLog;
import egovframework.rte.fdl.cmmn.AbstractServiceImpl;
import foodportal.common.util.DownloadUtil;
import foodportal.front.common.mapper.FrontBoardMapper;
import foodportal.front.common.mapper.FrontMenuMapper;
import foodportal.front.common.service.FrontBoardService;
import foodportal.front.common.service.FrontMenuService;
import foodportal.front.common.vo.CategoryVo;
import foodportal.front.common.vo.FrontBoardVO;
import foodportal.front.common.vo.FrontMenuVO;
import foodportal.front.common.vo.UploadFileVO;

/**
 * FrontMenuService
 * @author 박재형
 * @since 2014.09.25
 * @version 1.0
 * @see
 * 
 * <pre>
 *  Modification Information
 *  수정일      수정자   수정내용
 *  ---------- -------- ---------------------------
 *  2014.09.25 박재형 최초 생성
 * </pre>
 * 
 * Copyright (C) 2014 by NDS., All right reserved.
 */

@Service("frontMenuServiceImpl")
public class FrontMenuServiceImpl extends AbstractServiceImpl implements FrontMenuService {

	@CommonLog Logger log;

	@Autowired
	FrontMenuMapper frontMenuMapper;
	
	@Transactional
	public List<FrontMenuVO> selectMenuGrpList(Map<String, Object> paramMap) throws Exception{
		
		List<FrontMenuVO> list = null;
		
		int cnt = 0;
		
		try{
			list = frontMenuMapper.selectMenuGrpList(paramMap);
	        
	        return list;
		} catch(Exception e) {
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			
			throw e;
		}
	
	}
	
	
	@Transactional
	public FrontMenuVO selectMenuTree(Map<String, Object> paramMap) throws Exception{
		
		FrontMenuVO frontMenuVo = new FrontMenuVO();
		
		try{
			frontMenuVo = frontMenuMapper.selectMenuTree(paramMap);
	        
	        return frontMenuVo;
		} catch(Exception e) {
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			
			throw e;
		}
	}
}