package foodportal.front.common.service.impl;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.web.multipart.MultipartFile;

import common.commonfacillity.log.CommonLog;
import egovframework.rte.fdl.cmmn.AbstractServiceImpl;
import foodportal.common.util.StringUtil;
import foodportal.front.common.mapper.FrontCommonPopupMapper;
import foodportal.front.common.service.FrontCommonPopupService;
import foodportal.front.common.vo.FoodBaseVO;
import foodportal.front.common.vo.FoodtypeVO;
import foodportal.front.common.vo.OrgnVO;
import foodportal.front.common.vo.ShopVO;

/**
 * FrontCommonPopupServiceImpl
 * @author 박재형
 * @since 2014.10.07
 * @version 1.0
 * @see
 * 
 * <pre>
 *  Modification Information
 *  수정일      수정자   수정내용
 *  ---------- -------- ---------------------------
 *  2014.10.07 박재형 최초 생성
 * </pre>
 * 
 * Copyright (C) 2014 by NDS., All right reserved.
 */

@Service("frontCommonPopupServiceImpl")
public class FrontCommonPopupServiceImpl extends AbstractServiceImpl implements FrontCommonPopupService {

	@CommonLog Logger log;

	@Autowired
	FrontCommonPopupMapper frontCommonPopupMapper;
	
	@Transactional
	public Map<String, Object> searchOrgn(Map<String, Object> paramMap) throws Exception{
		
		Map<String, Object> resultMap = new HashMap<String, Object>();
		List<OrgnVO> list = null;
		
		try{
			list = frontCommonPopupMapper.searchOrgn(paramMap);
			int total_cnt = frontCommonPopupMapper.searchOrgnTotalCnt(paramMap);
			
			resultMap.put("list", list);
			resultMap.put("total_cnt", total_cnt);
			
			return resultMap;
			
		} catch(Exception e) {
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			
			throw e;
		}
	
	}
	
	@Transactional
	public Map<String, Object> searchFoodtype(Map<String, Object> paramMap) throws Exception{
		
		Map<String, Object> resultMap = new HashMap<String, Object>();
		List<FoodtypeVO> list = null;
		
		try{
			list = frontCommonPopupMapper.searchFoodtype(paramMap);
			int total_cnt = frontCommonPopupMapper.searchFoodtypeTotalCnt(paramMap);
			
			resultMap.put("list", list);
			resultMap.put("total_cnt", total_cnt);
			
			return resultMap;
			
		} catch(Exception e) {
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			
			throw e;
		}
	
	}
	
	@Transactional
	public Map<String, Object> searchFoodBase(Map<String, Object> paramMap) throws Exception{
		
		Map<String, Object> resultMap = new HashMap<String, Object>();
		List<FoodBaseVO> list = null;
		
		try{
			list = frontCommonPopupMapper.searchFoodBase(paramMap);
			int total_cnt = frontCommonPopupMapper.searchFoodBaseTotalCnt(paramMap);
			
			resultMap.put("list", list);
			resultMap.put("total_cnt", total_cnt);
			
			return resultMap;
			
		} catch(Exception e) {
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			
			throw e;
		}
	
	}
	
	
	@Transactional
	public Map<String, Object> searchShop(Map<String, Object> paramMap) throws Exception{
		
		Map<String, Object> resultMap = new HashMap<String, Object>();
		List<ShopVO> list = null;
		
		try{
			list = frontCommonPopupMapper.searchShop(paramMap);
			int total_cnt = frontCommonPopupMapper.searchShopTotalCnt(paramMap);
			
			resultMap.put("list", list);
			resultMap.put("total_cnt", total_cnt);
			
			return resultMap;
			
		} catch(Exception e) {
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			
			throw e;
		}
	
	}
	
	@Transactional
	public Map<String, Object> searchAllShop(Map<String, Object> paramMap) throws Exception{
		
		Map<String, Object> resultMap = new HashMap<String, Object>();
		List<ShopVO> list = null;
		
		try{
			list = frontCommonPopupMapper.searchAllShop(paramMap);
			int total_cnt = frontCommonPopupMapper.searchAllShopTotalCnt(paramMap);
			
			resultMap.put("list", list);
			resultMap.put("total_cnt", total_cnt);
			
			return resultMap;
			
		} catch(Exception e) {
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			
			throw e;
		}
	
	}
	
	/**
	 * 파일업로드 프로세스
	 * @param request
	 * @param file
	 * @param properties
	 * @return
	 * @throws Exception
	 */
	public Map<String, Object> processFileUpload(HttpServletRequest request, MultipartFile file, Properties properties) throws Exception {
		Map<String, Object> rtnMap = new HashMap<String, Object>();
		
		try {
			String uploadSource = StringUtil.nullToStr(request.getParameter("uploadSource"), "default");
			String fileOrgnName = file.getOriginalFilename();
			
			long fileMaxSize = Long.parseLong(StringUtil.nullToStr(request.getParameter("fileMaxSize"), "0"));
			long fileSize = file.getSize();
			
			if(fileSize > fileMaxSize){
				String[] sizeUnit = {"", "K", "M", "G", "T"};
				int idx = 0;
				
				for(int i=0; i<fileMaxSize; i*=1000){
					fileMaxSize/=1000;
					idx++;
				}
				
				rtnMap.put("rtnCd", "0");
				rtnMap.put("rtnMessage", "업로드 용량은 "+fileMaxSize+sizeUnit[idx]+"byte까지 가능합니다.");
				return rtnMap;
			}
			
			String fileName = "";
			String filePath = properties.getProperty(uploadSource+".path");
			String fileExt = fileOrgnName.substring(fileOrgnName.lastIndexOf(".")+1, fileOrgnName.length());
			
			boolean tf = (filePath != null && !"".equals(filePath));
			filePath = (tf ? filePath : properties.getProperty("default.path"));
			
			new File(filePath).mkdirs();
			File f = new File(filePath+"\\"+fileOrgnName);
			
			if(f.isFile()){
				Date date = new Date();
				SimpleDateFormat dayTime = new SimpleDateFormat("yyyyMMddhhmmss");
				
				fileName = fileOrgnName.substring(0, fileOrgnName.indexOf(".")) + "_" + dayTime.format(date).toString() + "." + fileExt;
			}else{
				fileName = fileOrgnName;
			}
			
			byte fileData[] = file.getBytes();
			FileOutputStream fos = new FileOutputStream(filePath+"\\"+fileName);
			
			try {
				fos.write(fileData);
				
				String physicFileNm = fileName.substring(0, fileName.lastIndexOf("."));
				
				rtnMap.put("logic_file_nm", fileOrgnName);
				rtnMap.put("physic_file_nm", physicFileNm);
				rtnMap.put("file_path", filePath);
				rtnMap.put("file_mg", fileSize);
				rtnMap.put("file_type_cd", fileExt);
				rtnMap.put("rtnMessage", "파일 업로드를 완료하였습니다.");
				rtnMap.put("rtnCd", "1");
				
				return rtnMap;
				
			} catch (IOException e) {
				
				rtnMap.put("rtnMessage", "파일 업로드 중 오류가 발생하였습니다. \n\n관리자에게 문의하십시오.");
				rtnMap.put("rtnCd", "0");
				return rtnMap;
			}
			finally{
				if(fos != null) fos.close();
			}
			
		} catch (Exception e) {
			
			rtnMap.put("rtnMessage", "파일 업로드 중 오류가 발생하였습니다. \n\n관리자에게 문의하십시오.");
			rtnMap.put("rtnCd", "0");
			return rtnMap;
		}
	}
	
}