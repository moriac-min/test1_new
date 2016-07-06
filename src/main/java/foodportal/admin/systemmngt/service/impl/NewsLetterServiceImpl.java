package foodportal.admin.systemmngt.service.impl;

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

import common.commonfacillity.log.CommonLog;
import common.commonfacillity.uia.WqBaseBean;
import common.commonfacillity.util.CommonConvertObjectToMap;
import egovframework.rte.fdl.cmmn.AbstractServiceImpl;
import foodportal.admin.systemmngt.mapper.NewsLetterMapper;
import foodportal.admin.systemmngt.service.NewsLetterService;
import foodportal.admin.systemmngt.vo.AdminSystemmngtRootVO;
import foodportal.admin.systemmngt.vo.NewsLetterVO;
import foodportal.admin.systemmngt.vo.UploadFileVO;
import foodportal.common.util.DownloadUtil;
import foodportal.common.util.IOUtil;
import foodportal.common.util.StringUtil;

/**
 * NewsLetterServiceImpl
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
 *  2014.09.05 김석원 함수 추가
 * </pre>
 * 
 * Copyright (C) 2014 by NDS., All right reserved.
 */

@Service("newsLetterService")
public class NewsLetterServiceImpl extends AbstractServiceImpl implements NewsLetterService {

	@CommonLog Logger log;

	@Autowired
	NewsLetterMapper newsLetterMapper;
	
	
	/**
	 * 게시글 목록 조회 
	 * 
	 * @param 
	 * @return 
	 * @exception Exception
	 */
	@Transactional(readOnly=true)
	public List<NewsLetterVO> selectNewsLetterList(WqBaseBean ibean) throws Exception {
		HashMap<String, Object> map = new HashMap<String, Object>();
		
		try{
			AdminSystemmngtRootVO adminSystemmngtRootVO = (AdminSystemmngtRootVO)ibean;
			NewsLetterVO paramNewsLetterVO = adminSystemmngtRootVO.getParamNewsLetterVO();
			
			map = CommonConvertObjectToMap.ConverObjectToMap(paramNewsLetterVO);
			
			List<NewsLetterVO> list = newsLetterMapper.selectNewsLetterList(map);
			
			return list;
			
		} catch(Exception e) {
			
			throw e;
		}
	}
	
	
	/**
	 * 게시글 상세(본문) 조회 
	 * 
	 * @param 
	 * @return 
	 * @exception Exception
	 */
	@Transactional(readOnly=true)
	public NewsLetterVO selectNewsLetterDetail(WqBaseBean ibean) throws Exception {
		HashMap<String, Object> paramMap = new HashMap<String, Object>();
		NewsLetterVO result = new NewsLetterVO();
		
		try{
			AdminSystemmngtRootVO adminSystemmngtRootVO = (AdminSystemmngtRootVO)ibean;
			NewsLetterVO paramNewsLetterVO = adminSystemmngtRootVO.getParamNewsLetterVO();
			paramMap = CommonConvertObjectToMap.ConverObjectToMap(paramNewsLetterVO);
			result = newsLetterMapper.selectNewsLetterDetail(paramMap);
			
			return result;
			
		} catch(Exception e) {
			
			throw e;
		}
	}
	
	/**
	 * 게시글 상세(첨부파일) 조회 
	 * 
	 * @param 
	 * @return 
	 * @exception Exception
	 */
	@Transactional(readOnly=true)
	public UploadFileVO selectNewsLetterFile(WqBaseBean ibean) throws Exception {
		HashMap<String, Object> paramMap = new HashMap<String, Object>();
		
		try{
			AdminSystemmngtRootVO adminSystemmngtRootVO = (AdminSystemmngtRootVO)ibean;
			NewsLetterVO paramNewsLetterVO = adminSystemmngtRootVO.getParamNewsLetterVO();
			paramMap = CommonConvertObjectToMap.ConverObjectToMap(paramNewsLetterVO);
			UploadFileVO uploadFileVO = newsLetterMapper.selectNewsLetterFile(paramMap);
			
			return uploadFileVO;
			
		} catch(Exception e) {
			
			throw e;
		}
	}
	
	/**
	 * 게시글 등록, 수정, 삭제
	 * 
	 * @param 
	 * @return 
	 * @exception Exception
	 */
	@Transactional
	public int saveNewsLetter(WqBaseBean ibean, String flag) throws Exception {
		HashMap<String, Object> paramMap = new HashMap<String, Object>();
		HashMap<String, Object> paramFileMap = new HashMap<String, Object>();
		
		try {
		
			IOUtil ioUtil = null;
			AdminSystemmngtRootVO adminSystemmngtRootVO = (AdminSystemmngtRootVO)ibean;
			NewsLetterVO paramNewsLetterVo = adminSystemmngtRootVO.getParamNewsLetterVO();	//상세페이지 vo
			UploadFileVO fileVo = adminSystemmngtRootVO.getParamUploadFileVO();				//새로 업로드한 파일vo
			UploadFileVO deleteFileVo = adminSystemmngtRootVO.getParamDeleteFileVO();		//원래 있던 파일 또는 삭제한 파일vo
			
			/*****************************등록/수정**************************/
			if(flag.equals("save")){
				
				/**
				 * 파일첨부유무가 Y 일 경우
				 * 파일 디렉토리에 저장
				 */
				String fileYn = StringUtil.NVLToSpace(paramNewsLetterVo.getFile_yn());
				if("Y".equals(fileYn)){
					
					Map<String, Object> fileMap = new HashMap<String, Object>();
					
					try {
						ioUtil = new IOUtil();
						//fileMap = ioUtil.startUploadSingleFile(fileVo);
					} catch (Exception e) {
					} finally {
						if(ioUtil != null){
							ioUtil = null;
						}
					}
			    	
					if("succeed".equals(fileMap.get("result"))){
						fileVo.setFile_path(StringUtil.NVLToSpace(fileMap.get("realPath")));
						fileVo.setPhysic_file_nm(StringUtil.NVLToSpace(fileMap.get("realName")));
					}else{
						throw new Exception();
					}
//			    	System.out.println("==========111========>"+fileMap.get("realPath"));
//			    	System.out.println("==========222========>"+fileMap.get("realName"));
				}
				
				/**
				 * paramMap 셋팅
				 */
				paramMap = CommonConvertObjectToMap.ConverObjectToMap(paramNewsLetterVo);

				/*************************신규 insert*************************/
				if("".equals(StringUtil.NVLToSpace(paramNewsLetterVo.getNtctxt_no()))){
					
					String ntctxt_no = newsLetterMapper.selectNewsLetterSeqNo();	//게시글 번호 채번
					
					if(ntctxt_no == null || "".equals(ntctxt_no.trim())){
						throw new Exception();
					}
					
					paramMap.put("ntctxt_no", ntctxt_no);
					
					newsLetterMapper.insertNewsLetterMst(paramMap);			//게시글 저장
					newsLetterMapper.insertNewsLetterContent(paramMap);		//게시글 본문저장
					
					//파일저장
					if("Y".equals(fileYn)){
						//첨부파일번호 순번 채번
						String atch_file_no = newsLetterMapper.selectFileSeqNo();
						fileVo.setAtch_file_no(atch_file_no);
						fileVo.setNtctxt_no(ntctxt_no);
						
						paramFileMap = CommonConvertObjectToMap.ConverObjectToMap(fileVo);
						
						newsLetterMapper.insertAtchFile(paramFileMap);
						newsLetterMapper.insertNtctxtacctoAtchfl(paramFileMap);
						
					}
					
				/*************************수정 update**********************/	
				}else{
					
					newsLetterMapper.updateNewsLetterMst(paramMap);			//게시글 저장
					newsLetterMapper.updateNewsLetterContent(paramMap);		//게시글 본문저장
					
					//파일저장
					if("Y".equals(fileYn) || "D".equals(fileYn)){
						
						paramFileMap = CommonConvertObjectToMap.ConverObjectToMap(deleteFileVo);
						
						newsLetterMapper.deleteNtctxtacctoAtchfl(paramFileMap);	//게시글별파일삭제
						newsLetterMapper.deleteAtchFile(paramFileMap);			//파일첨부삭제
						
						//새로 파일첨부한 경우
						if("Y".equals(fileYn)){		
							//첨부파일번호 순번 채번
							String atch_file_no = newsLetterMapper.selectFileSeqNo();
							fileVo.setAtch_file_no(atch_file_no);
							
							paramFileMap = CommonConvertObjectToMap.ConverObjectToMap(fileVo);
							
							newsLetterMapper.insertAtchFile(paramFileMap);
							newsLetterMapper.insertNtctxtacctoAtchfl(paramFileMap);
						}
					}
					
				}
				
			/*****************************삭제**************************/	
			}else if(flag.equals("delete")){		
				/**
				 * paramMap 셋팅
				 */
				paramMap = CommonConvertObjectToMap.ConverObjectToMap(paramNewsLetterVo);
				paramFileMap = CommonConvertObjectToMap.ConverObjectToMap(deleteFileVo);
				newsLetterMapper.deleteNtctxtacctoAtchfl(paramFileMap);	//게시글별파일삭제
				newsLetterMapper.deleteNewsLetter(paramMap);			//게시글삭제
				newsLetterMapper.deleteAtchFile(paramFileMap);			//파일첨부삭제
			}

			return 1;
			
		} catch (Exception e) {	
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			
			return 0;
		}
	}
	
	/**
	 * 첨부파일 다운로드
	 * 
	 * @param request
	 * @param response
	 * @return 
	 * @exception Exception
	 */
	@Transactional
	public void downloadAttchdFile(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		try{
			File file = new File(request.getParameter("filePath")+"/"+request.getParameter("fileName"));
			
			String downloadFileName = request.getParameter("orgFileName");
			
			//파일다운로드
			DownloadUtil.download(request, response, file, downloadFileName);
			
		} catch(Exception e) {
			
			throw e;
		}
	}
	
}