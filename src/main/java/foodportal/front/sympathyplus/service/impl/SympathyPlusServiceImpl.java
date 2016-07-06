package foodportal.front.sympathyplus.service.impl;

import java.io.File;
import java.util.ArrayList;
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
import foodportal.common.util.StringUtil;
import foodportal.front.common.mapper.FrontBoardMapper;
import foodportal.front.common.service.FrontBoardService;
import foodportal.front.common.vo.CategoryVo;
import foodportal.front.common.vo.FrontBoardVO;
import foodportal.front.common.vo.FrontMetaKeywordVO;
import foodportal.front.common.vo.UploadFileVO;
import foodportal.front.sympathyplus.mapper.SympathyPlusMapper;
import foodportal.front.sympathyplus.service.SympathyPlusService;
import foodportal.front.sympathyplus.vo.CalendarVo;
import foodportal.front.sympathyplus.vo.FoodStreetVO;

/**
 * MetaInfoServiceImpl
 * @author 박재형
 * @since 2014.09.03
 * @version 1.0
 * @see
 * 
 * <pre>
 *  Modification Information
 *  수정일      수정자   수정내용
 *  ---------- -------- ---------------------------
 *  2014.09.03 박재형 최초 생성
 * </pre>
 * 
 * Copyright (C) 2014 by NDS., All right reserved.
 */

@Service("sympathyPlusServiceImpl")
public class SympathyPlusServiceImpl extends AbstractServiceImpl implements SympathyPlusService {

	@CommonLog Logger log;

	@Autowired
	SympathyPlusMapper sympathyPlusMapper;
	
	
	@Transactional(readOnly=true)
	public List<CategoryVo> selectCtgType01List(FoodStreetVO paramVo) throws Exception {
		
		try{
			
			List<CategoryVo> list = sympathyPlusMapper.selectCtgType01List(paramVo);
			
			return list;
			
		} catch(Exception e) {
			throw e;
		}
	}
	
	@Transactional(readOnly=true)
	public FrontBoardVO selectFoodStreetDetail(FrontBoardVO paramVo) throws Exception {
		
		try{
			FrontBoardVO returnVo = sympathyPlusMapper.selectFoodStreetDetail(paramVo);
			
			return returnVo;
			
		} catch(Exception e) {
			throw e;
		}
	}
	
	@Transactional
	public int addReadCnt(String ntctxt_no) throws Exception{
		
		try{
			sympathyPlusMapper.addReadCnt(ntctxt_no);
			
			return 1;
		} catch (Exception e) {	
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			return 0;
		}
	}
	
	@Transactional(readOnly=true)
	public CalendarVo selectMonthCalInfo(CalendarVo paramVo) throws Exception {
		
		try{
			System.out.println("====================>"+paramVo.getDate_no());
			CalendarVo calInfoVo = sympathyPlusMapper.selectMonthInfo(paramVo);
			
			return calInfoVo;
			
		} catch(Exception e) {
			throw e;
		}
	}
	
	@Transactional(readOnly=true)
	public List<CalendarVo> selectMonthSchList(CalendarVo paramVo) throws Exception {
		
		try{
			
			List<CalendarVo> list = sympathyPlusMapper.selectMonthSchList(paramVo);
			
			return list;
			
		} catch(Exception e) {
			throw e;
		}
	}
	
	@Transactional(readOnly=true)
	public CalendarVo selectMonthSchDetail(CalendarVo paramVo) throws Exception {
		
		try{
			
			CalendarVo returnVo = sympathyPlusMapper.selectMonthSchDetail(paramVo);
			
			return returnVo;
			
		} catch(Exception e) {
			throw e;
		}
	}
	
}