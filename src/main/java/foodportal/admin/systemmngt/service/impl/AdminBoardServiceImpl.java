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
import foodportal.admin.systemmngt.mapper.AdminBoardMapper;
import foodportal.admin.systemmngt.mapper.CategorySettingMapper;
import foodportal.admin.systemmngt.service.AdminBoardService;
import foodportal.admin.systemmngt.service.CategorySettingService;
import foodportal.admin.systemmngt.vo.AdminBoardVO;
import foodportal.admin.systemmngt.vo.AdminSystemmngtRootVO;
import foodportal.admin.systemmngt.vo.BoardSettingVO;
import foodportal.admin.systemmngt.vo.CategorySettingVO;
import foodportal.admin.systemmngt.vo.CommonCodeVO;
import foodportal.admin.systemmngt.vo.UploadFileVO;
import foodportal.common.util.DownloadUtil;
import foodportal.common.util.IOUtil;
import foodportal.common.util.StringUtil;

/**
 * AdminBoardServiceImpl
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

@Service("adminBoardServiceImpl")
public class AdminBoardServiceImpl extends AbstractServiceImpl implements AdminBoardService {

	@CommonLog Logger log;

	@Autowired
	AdminBoardMapper adminBoardMapper;
	
	/*******************************************************************************/
	/******************************공통영역*****************************************/
	/*******************************************************************************/
	
	/**
	 * 게시판 속성 조회 
	 * 
	 * @param 
	 * @return 
	 * @exception Exception
	 */
	@Transactional(readOnly=true)
	public BoardSettingVO selectAdminBoardOption(WqBaseBean ibean) throws Exception {
		HashMap<String, Object> paramMap = new HashMap<String, Object>();
		BoardSettingVO result = new BoardSettingVO();
		
		try{
			AdminSystemmngtRootVO adminSystemmngtRootVO = (AdminSystemmngtRootVO)ibean;
			AdminBoardVO paramAdminBoardVo = adminSystemmngtRootVO.getParamAdminBoardVo();
			paramMap = CommonConvertObjectToMap.ConverObjectToMap(paramAdminBoardVo);
			System.out.println(paramMap);
			result = adminBoardMapper.selectAdminBoardOption(paramMap);
			
			return result;
			
		} catch(Exception e) {
			
			throw e;
		}
	}
	
	/**
	 * 게시글 목록 조회 
	 * 
	 * @param 
	 * @return 
	 * @exception Exception
	 */
	@Transactional(readOnly=true)
	public List<AdminBoardVO> selectAdminBoardList(WqBaseBean ibean) throws Exception {
		HashMap<String, Object> map = new HashMap<String, Object>();
		
		try{
			AdminSystemmngtRootVO adminSystemmngtRootVO = (AdminSystemmngtRootVO)ibean;
			AdminBoardVO paramAdminBoardVo = adminSystemmngtRootVO.getParamAdminBoardVo();
			
			map = CommonConvertObjectToMap.ConverObjectToMap(paramAdminBoardVo);
			
			List<AdminBoardVO> list = adminBoardMapper.selectAdminBoardList(map);
			
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
	public AdminBoardVO selectAdminBoardDetail(WqBaseBean ibean) throws Exception {
		HashMap<String, Object> paramMap = new HashMap<String, Object>();
		AdminBoardVO result = new AdminBoardVO();
		
		try{
			AdminSystemmngtRootVO adminSystemmngtRootVO = (AdminSystemmngtRootVO)ibean;
			AdminBoardVO paramAdminBoardVo = adminSystemmngtRootVO.getParamAdminBoardVo();
			paramMap = CommonConvertObjectToMap.ConverObjectToMap(paramAdminBoardVo);
			
			System.out.println("================================zzzz================111============");
			result = adminBoardMapper.selectAdminBoardDetail(paramMap);
			
			return result;
			
		} catch(Exception e) {
			
			throw e;
		}
	}
	
	/**
	 * 카테고리목록 조회
	 * 
	 * @param 
	 * @return 
	 * @exception Exception
	 */
	
	@Transactional
	public List<CategorySettingVO> selectAdminBoardCategoryList(WqBaseBean ibean){
		HashMap<String, Object> map = new HashMap<String, Object>();
		List<CategorySettingVO> list = new ArrayList<CategorySettingVO>();
		try {
			AdminSystemmngtRootVO adminSystemmngtRootVO = (AdminSystemmngtRootVO) ibean;
			CategorySettingVO paramCategory = adminSystemmngtRootVO.getParamCategory();
			
			map = CommonConvertObjectToMap.ConverObjectToMap(paramCategory);
			
			list = adminBoardMapper.selectAdminBoardCategoryList(map);
			
		} catch (Exception e) {
		}
		return list;
	}
	
	/**
	 * 공통코드 조회
	 * 
	 * @param 
	 * @return 
	 * @exception Exception
	 */
	
	@Transactional
	public List<CommonCodeVO> selectCmmnCode(WqBaseBean ibean){
		HashMap<String, Object> map = new HashMap<String, Object>();
		List<CommonCodeVO> list = new ArrayList<CommonCodeVO>();
		try {
			AdminSystemmngtRootVO adminSystemmngtRootVO = (AdminSystemmngtRootVO) ibean;
			CommonCodeVO commonCodeVo = adminSystemmngtRootVO.getCommonCode();
			
			map = CommonConvertObjectToMap.ConverObjectToMap(commonCodeVo);
			
			list = adminBoardMapper.selectCmmnCode(map);
			
		} catch (Exception e) {
		}
		return list;
	}
	
	
	/**
	 * 게시글 상세(댓글) 조회 
	 * 
	 * @param 
	 * @return 
	 * @exception Exception
	 */
	@Transactional(readOnly=true)
	public List<AdminBoardVO> selectAdminBoardRep(WqBaseBean ibean) throws Exception {
		HashMap<String, Object> paramMap = new HashMap<String, Object>();
		List<AdminBoardVO> list = new ArrayList<AdminBoardVO>();
		
		try{
			AdminSystemmngtRootVO adminSystemmngtRootVO = (AdminSystemmngtRootVO)ibean;
			AdminBoardVO paramAdminBoardVo = adminSystemmngtRootVO.getParamAdminBoardVo();
			paramMap = CommonConvertObjectToMap.ConverObjectToMap(paramAdminBoardVo);
			list = adminBoardMapper.selectAdminBoardRep(paramMap);
			
			return list;
			
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
	public List<UploadFileVO> selectAdminBoardFileList(WqBaseBean ibean) throws Exception {
		HashMap<String, Object> paramMap = new HashMap<String, Object>();
		List<UploadFileVO> list = new ArrayList<UploadFileVO>();
		
		try{
			AdminSystemmngtRootVO adminSystemmngtRootVO = (AdminSystemmngtRootVO)ibean;
			AdminBoardVO paramAdminBoardVo = adminSystemmngtRootVO.getParamAdminBoardVo();
			paramMap = CommonConvertObjectToMap.ConverObjectToMap(paramAdminBoardVo);
			list = adminBoardMapper.selectAdminBoardFile(paramMap);
			
			return list;
			
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
	public int saveAdminBoard(WqBaseBean ibean) throws Exception {
		HashMap<String, Object> paramMap = new HashMap<String, Object>();
		HashMap<String, Object> paramFileMap = new HashMap<String, Object>();
		String flag="";
		try {
			IOUtil ioUtil = null;
			AdminSystemmngtRootVO adminSystemmngtRootVO = (AdminSystemmngtRootVO)ibean;
			AdminBoardVO paramAdminBoardVo = adminSystemmngtRootVO.getParamAdminBoardVo();	
			paramMap = CommonConvertObjectToMap.ConverObjectToMap(paramAdminBoardVo);
			UploadFileVO fileVo = adminSystemmngtRootVO.getParamUploadFileVO();				//새로 업로드한 파일vo
			UploadFileVO deleteFileVo = adminSystemmngtRootVO.getParamDeleteFileVO();		//원래 있던 파일 또는 삭제한 파일vo
			flag = StringUtil.NVLToSpace(paramMap.get("flag"));
			
			/*****************************등록/수정**************************/
			if(flag.equals("save")){
				
				String fileYn = StringUtil.NVLToSpace(paramAdminBoardVo.getFile_yn());
				
				if(!"".equals(fileYn) && "Y".equals(fileYn)){
					
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
			    	System.out.println("==========111========>"+fileMap.get("realPath"));
			    	System.out.println("==========222========>"+fileMap.get("realName"));
				}
				
				paramMap = CommonConvertObjectToMap.ConverObjectToMap(paramAdminBoardVo);
				
				if("".equals(StringUtil.NVLToSpace(paramAdminBoardVo.getNtctxt_no()))){
					
					String ntctxt_no = adminBoardMapper.selectAdminBoardSeqNo();	//게시글 번호 채번
					
					if(ntctxt_no == null || "".equals(ntctxt_no.trim())){
						throw new Exception();
					}
					
					paramMap.put("ntctxt_no", ntctxt_no);
					
					adminBoardMapper.insertAdminBoardMst(paramMap);			//게시글 저장
					adminBoardMapper.insertAdminBoardContent(paramMap);		//게시글 본문저장
					
					//파일저장
					if("Y".equals(fileYn)){
						//첨부파일번호 순번 채번
						String atch_file_no = adminBoardMapper.selectFileSeqNo();
						fileVo.setAtch_file_no(atch_file_no);
						fileVo.setNtctxt_no(ntctxt_no);
						
						paramFileMap = CommonConvertObjectToMap.ConverObjectToMap(fileVo);
						
						adminBoardMapper.insertAtchFile(paramFileMap);
						adminBoardMapper.insertNtctxtacctoAtchfl(paramFileMap);
						
					}
					
				}else{
					
					adminBoardMapper.updateAdminBoardMst(paramMap);			//게시글 저장
					adminBoardMapper.updateAdminBoardContent(paramMap);		//게시글 본문저장
					
					//파일저장
					if("Y".equals(fileYn) || "D".equals(fileYn)){
						
						paramFileMap = CommonConvertObjectToMap.ConverObjectToMap(deleteFileVo);
						
						adminBoardMapper.deleteNtctxtacctoAtchfl(paramFileMap);	//게시글별파일삭제
						adminBoardMapper.deleteAtchFile(paramFileMap);			//파일첨부삭제
						
						//새로 파일첨부한 경우
						if("Y".equals(fileYn)){		
							//첨부파일번호 순번 채번
							String atch_file_no = adminBoardMapper.selectFileSeqNo();
							fileVo.setAtch_file_no(atch_file_no);
							
							paramFileMap = CommonConvertObjectToMap.ConverObjectToMap(fileVo);
							
							adminBoardMapper.insertAtchFile(paramFileMap);
							adminBoardMapper.insertNtctxtacctoAtchfl(paramFileMap);
						}
					}
					
				}
				
			/*****************************삭제**************************/	
			}else if(flag.equals("delete")){						
				adminBoardMapper.deleteAdminBoard(paramMap);			
			}
			
			// 첨부파일 저장추가예정

			return 1;
		} catch (Exception e) {	
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			
			return 0;
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
	public int saveAdminBoard(WqBaseBean ibean, String flag) throws Exception {
		HashMap<String, Object> paramMap = new HashMap<String, Object>();
		try {
			AdminSystemmngtRootVO adminSystemmngtRootVO = (AdminSystemmngtRootVO)ibean;
			AdminBoardVO paramAdminBoardVo = adminSystemmngtRootVO.getParamAdminBoardVo();	
			paramMap = CommonConvertObjectToMap.ConverObjectToMap(paramAdminBoardVo);	
			
			/*****************************등록/수정**************************/
			if(flag.equals("insert") || flag.equals("update")){
				
				if("".equals(StringUtil.NVLToSpace(paramAdminBoardVo.getNtctxt_no()))){
					
					String ntctxt_no = adminBoardMapper.selectAdminBoardSeqNo();	//게시글 번호 채번
					
					if(ntctxt_no == null || "".equals(ntctxt_no.trim())){
						throw new Exception();
					}
					
					paramMap.put("ntctxt_no", ntctxt_no);
					
					adminBoardMapper.insertAdminBoardMst(paramMap);			//게시글 저장
					adminBoardMapper.insertAdminBoardContent(paramMap);		//게시글 본문저장
					
					paramAdminBoardVo.setNtctxt_no(ntctxt_no);
					
				}else{
					
					if("".equals(StringUtil.NVLToSpace(paramAdminBoardVo.getNtctxt_no()))){
						throw new Exception();
					}
					
					adminBoardMapper.updateAdminBoardMst(paramMap);			//게시글 저장
					adminBoardMapper.updateAdminBoardContent(paramMap);		//게시글 본문저장
					
				}
				
			/*****************************삭제**************************/	
			}else if(flag.equals("delete")){						
				adminBoardMapper.deleteAdminBoard(paramMap);			
			}
			
			// 첨부파일 저장추가예정

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
	
	/*******************************************************************************/
	/******************************일반게시판***************************************/
	/*******************************************************************************/	
	
	
	/*******************************************************************************/
	/******************************뉴스형게시판*************************************/
	/*******************************************************************************/
	
	
	
	/*******************************************************************************/
	/******************************컨텐츠A형****************************************/
	/*******************************************************************************/
	
	
	
	/*******************************************************************************/
	/******************************컨텐츠B형****************************************/
	/*******************************************************************************/
	/**
	 * Type B 게시판 상세 조회
	 * 
	 * @param 
	 * @return 
	 * @exception Exception
	 */
	@Transactional(readOnly=true)
	public AdminBoardVO selectTypeBBoardDetail(WqBaseBean ibean) throws Exception {
		HashMap<String, Object> paramMap = new HashMap<String, Object>();
		AdminBoardVO result = new AdminBoardVO();
		
		try{
			AdminSystemmngtRootVO adminSystemmngtRootVO = (AdminSystemmngtRootVO)ibean;
			AdminBoardVO paramAdminBoardVo = adminSystemmngtRootVO.getParamAdminBoardVo();
			paramMap = CommonConvertObjectToMap.ConverObjectToMap(paramAdminBoardVo);
			result = adminBoardMapper.selectTypeBBoardDetail(paramMap);
			
			
			return result;
			
		} catch(Exception e) {
			
			throw e;
		}
	}
	
	/*******************************************************************************/
	/******************************관련사이트******************************************/
	/*******************************************************************************/
	/**
	 * 관련 사이트 관리 등록/수정
	 * 
	 * @param 
	 * @return ModelAndView
	 * @throws Exception
	 */
	@Transactional
	public int saveRelateSite(WqBaseBean ibean) {
		try {
			AdminSystemmngtRootVO adminSystemmngtRootVO = (AdminSystemmngtRootVO) ibean;
			List<AdminBoardVO> relateSiteList = adminSystemmngtRootVO.getRelateSiteList();
			
			for (int idx = 0, iCnt = relateSiteList.size(); idx < iCnt; idx++) {
				AdminBoardVO adminBoardVO = (AdminBoardVO) relateSiteList.get(idx);
				String rowStatus = adminBoardVO.getRowStatus();
				HashMap<String, Object> map = CommonConvertObjectToMap.ConverObjectToMap(adminBoardVO);
				
				if (rowStatus.equals("U")) {
					adminBoardMapper.updateAdminBoardMst(map);						//관련사이트 수정
					
				} else if (rowStatus.equals("C")) {
					String ntctxt_no = adminBoardMapper.selectAdminBoardSeqNo();	//게시글 번호 채번
					
					if(ntctxt_no == null || "".equals(ntctxt_no.trim())){
						throw new Exception();
					}
					
					map.put("ntctxt_no", ntctxt_no);
					adminBoardMapper.insertAdminBoardMst(map);						//관련사이트 등록
					
				} else if (rowStatus.equals("D")) {
					adminBoardMapper.deleteAdminBoard(map);							//관련사이트 삭제
				}
			}
			
			return 1;
		} catch (Exception e) {	
			
			return 0;
		}
	}	
	
	
	/*******************************************************************************/
	/******************************포토게시판***************************************/
	/*******************************************************************************/
	
	
	/*******************************************************************************/
	/******************************동영상게시판*************************************/
	/*******************************************************************************/
	
	
	/*******************************************************************************/
	/******************************FAQ**********************************************/
	/*******************************************************************************/
	
	
	
	/*******************************************************************************/
	/******************************약관*********************************************/
	/*******************************************************************************/
	
	
	/**
	 * 약관 저장
	 * 
	 * @param 
	 * @return 
	 * @exception Exception
	 */
	@Transactional
	public int saveTerms(WqBaseBean ibean) throws Exception {
		HashMap<String, Object> paramMap = new HashMap<String, Object>();
		int result = 0;
		
		try {
			AdminSystemmngtRootVO adminSystemmngtRootVO = (AdminSystemmngtRootVO)ibean;
			AdminBoardVO paramAdminBoardVo = adminSystemmngtRootVO.getParamAdminBoardVo();	
			paramMap = CommonConvertObjectToMap.ConverObjectToMap(paramAdminBoardVo);	
			
			String localFlag = "";
			String flag = "";
			
			if("".equals(StringUtil.NVLToSpace(paramAdminBoardVo.getNtctxt_no()))){
				flag = "insert";
				localFlag = "insert";
			}else if(!"".equals(StringUtil.NVLToSpace(paramAdminBoardVo.getNtctxt_no()))){
				if("N".equals(StringUtil.NVLToSpace(paramAdminBoardVo.getDel_yn()))){
					flag = "update";
					localFlag = "update";
				}else{
					flag = "update";
					localFlag = "delete";
				}
				
			}
			
			//저장
			result = saveAdminBoard(ibean, flag);
			
			
			//사용여부 전체업데이트
			if(!"delete".equals(localFlag)){
				if(result != 1 || "".equals(StringUtil.NVLToSpace(paramAdminBoardVo.getNtctxt_no()))){
					throw new Exception();
				}else{
					adminBoardMapper.updateTermsDelYn(paramMap);
				}
			}	

			return 1;
		} catch (Exception e) {	
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			
			return 0;
		}
	}
	
	
}