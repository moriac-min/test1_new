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
import foodportal.common.util.StringUtil;
import foodportal.front.common.mapper.FrontBoardMapper;
import foodportal.front.common.service.FrontBoardService;
import foodportal.front.common.vo.CategoryVo;
import foodportal.front.common.vo.FrontBoardVO;
import foodportal.front.common.vo.FrontMetaKeywordVO;
import foodportal.front.common.vo.UploadFileVO;

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

@Service("frontBoardServiceImpl")
public class FrontBoardServiceImpl extends AbstractServiceImpl implements FrontBoardService {

	@CommonLog Logger log;

	@Autowired
	FrontBoardMapper frontBoardMapper;
	
	@Transactional(readOnly=true)
	public FrontBoardVO getBbsSettingInfo(Map<String, Object> map) throws Exception{
		
		FrontBoardVO frontBoardVO = null;
		
		try {
			
			if(map != null){
				frontBoardVO = frontBoardMapper.getBbsSettingInfo(map);
			}
			
			return frontBoardVO;
			
		} catch (Exception e) {
			throw e;
		}
		
	}
	
	@Transactional(readOnly=true)
	public Map<String, Object> selectBoardList(FrontBoardVO frontBoardVO) throws Exception {
		HashMap<String, Object> map = new HashMap<String, Object>();
		HashMap<String, Object> fileParamMap = null;
		List<UploadFileVO> fileList = null;
		
		try{
			
			List<FrontBoardVO> list = frontBoardMapper.selectBoardList(frontBoardVO);
			if(list != null){
				if(list.size() > 0){
					if(StringUtil.NVLToSpace(frontBoardVO.getFile_yn()).equals("Y")){
						for(int i=0; i <list.size(); i++){
							fileParamMap = new HashMap<String, Object>();
							fileParamMap.put("ntctxt_no", list.get(i).getNtctxt_no());
							fileList = frontBoardMapper.selectBoardFile(fileParamMap);
							list.get(i).setFileList(fileList);
						}
					}
					
				}
			}
			String total_cnt = frontBoardMapper.selectTotalCnt(frontBoardVO);
			
			map.put("boardList", list);
			map.put("total_cnt", total_cnt);
			
			return map;
			
		} catch(Exception e) {
			throw e;
		}
	}
	
	@Transactional(readOnly=true)
	public List<CategoryVo> selectCtgType01List(FrontBoardVO frontBoardVO) throws Exception {
		
		try{
			
			List<CategoryVo> list = frontBoardMapper.selectCtgType01List(frontBoardVO);
			
			return list;
			
		} catch(Exception e) {
			throw e;
		}
	}
	
	@Transactional(readOnly=true)
	public List<CategoryVo> selectCtgType02List(String ctgry_no) throws Exception {
		
		try{
			
			List<CategoryVo> list = frontBoardMapper.selectCtgType02List(ctgry_no);
			
			return list;
			
		} catch(Exception e) {
			throw e;
		}
	}
	
	@Transactional(readOnly=true)
	public FrontBoardVO selectBoardDetail(Map<String, Object> map) throws Exception{
		
		FrontBoardVO frontBoardVO = null;
		
		try {
			
			if(map != null){
				
				frontBoardVO = frontBoardMapper.selectBoardDetail(map);
				
				if(!"".equals(map.get("bbs_type_cd")) && !"04".equals(map.get("bbs_type_cd"))){
					String pre_ntctxt_no = frontBoardMapper.selectPreNtctxtNo(map);
					String post_ntctxt_no = frontBoardMapper.selectPostNtctxtNo(map);
					
					frontBoardVO.setPre_ntctxt_no(pre_ntctxt_no);
					frontBoardVO.setPost_ntctxt_no(post_ntctxt_no);
				}
				
			}
			
			return frontBoardVO;
			
		} catch (Exception e) {
			throw e;
		}
		
	}
	
	@Transactional(readOnly=true)
	public List<UploadFileVO> selectBoardFile(Map<String, Object> map) throws Exception {
		
		List<UploadFileVO> uploadFileList = null;
				
		try{
			uploadFileList = frontBoardMapper.selectBoardFile(map);
			
			return uploadFileList;
			
		} catch(Exception e) {
			
			throw e;
		}
	}
	
	@Transactional
	public int addReadCnt(String ntctxt_no) throws Exception{
		
		try{
			frontBoardMapper.addReadCnt(ntctxt_no);
			
			return 1;
		} catch (Exception e) {	
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			return 0;
		}
	}
	
	@Transactional
	public void downloadAttchdFile(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		try{
			
			String file_path = request.getParameter("file_path");
			String physic_file_nm = request.getParameter("physic_file_nm")+"."+request.getParameter("file_type_cd");
			
			File file = new File(file_path+"/"+physic_file_nm);
			String downloadFileName = request.getParameter("logic_file_nm");
			
			//파일다운로드
			DownloadUtil.download(request, response, file, downloadFileName);
			
		} catch(Exception e) {
			
			throw e;
		}
	}
	
	@Transactional
	public void addLike(HttpServletRequest request, HttpServletResponse response) throws Exception{
		
		int cnt = 0;
		
		try{
			
	        Map<String, Object> paramMap = new HashMap<String, Object>();
	        paramMap.put("ntctxt_no", request.getParameter("ntctxt_no"));
	        paramMap.put("ip", request.getRemoteAddr());
	        paramMap.put("cretr_id", "SYSTEM");
	        paramMap.put("last_updtr_id", "SYSTEM");
	        
	        
	        int checkDup = frontBoardMapper.checkDup(paramMap);
	        
	        if(checkDup > 0){
	        	cnt = 2;
	        }else{
	        	frontBoardMapper.addLike(paramMap);
	        	cnt = 1;
	        }
	        
		} catch(Exception e) {
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			
			cnt = 0;
		}
		
		response.setContentType("text/plain; charset=\"utf-8\"");
		response.getWriter().write(new Gson().toJson(cnt)); 
	}
	
	@Transactional(readOnly=true)
	public List<FrontMetaKeywordVO> selectKeywordList(Map<String, Object> keyMap) throws Exception {
		
		try{
			
			List<FrontMetaKeywordVO> list = frontBoardMapper.selectKeywordList(keyMap);
			
			return list;
			
		} catch(Exception e) {
			throw e;
		}
	}
	
}