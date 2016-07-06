package foodportal.front.sensuousmenu.service.impl;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import common.commonfacillity.log.CommonLog;
import common.commonfacillity.uia.WqBaseBean;
import common.commonfacillity.util.CommonConvertObjectToMap;
import egovframework.rte.fdl.cmmn.AbstractServiceImpl;
import foodportal.common.util.IOUtil;
import foodportal.common.util.StringUtil;
import foodportal.front.common.vo.UploadFileVO;
import foodportal.front.sensuousmenu.mapper.SensuousMapper;
import foodportal.front.sensuousmenu.service.SensuousService;
import foodportal.front.sensuousmenu.vo.NetizenRecipeVO;
import foodportal.front.sensuousmenu.vo.RecipeNtrtVO;
import foodportal.front.sensuousmenu.vo.RecipeThemaVO;
import foodportal.front.sensuousmenu.vo.RecipeVO;

/**
 * SensuousServiceImpl
 * @author 최환
 * @since 2014.10.02
 * @version 1.0
 * @see
 * 
 * <pre>
 *  Modification Information
 *  수정일      수정자   수정내용
 *  ---------- -------- ---------------------------
 *  2014.10.02 최환 최초 생성
 * </pre>
 * 
 * Copyright (C) 2014 by NDS., All right reserved.
 */

@Service("SensuousService")
public class SensuousServiceImpl extends AbstractServiceImpl implements SensuousService {

	@CommonLog Logger log;
	
	@Autowired
	SensuousMapper sensuousMapper;
	
	/**
	 * 레시피목록 조회
	 * 
	 * @param 
	 * @return 
	 * @exception Exception
	 */
	@Transactional(readOnly=true)
	public Map<String, Object> selectRecipeList(Map<String, Object> paramMap, String type) throws Exception {
		
		Map<String, Object> resultMap = new HashMap<String, Object>();
		List<RecipeVO> list = null;
		
		try{
			//임의 셋팅
			if("top".equals(type)){
				paramMap.put("show_cnt", "3");
				paramMap.put("start_idx", "1");
				paramMap.put("order", "hit");
			}else if("new".equals(type)){
				paramMap.put("show_cnt", "3");
				paramMap.put("start_idx", "1");
				paramMap.put("order", "new");
			}else if("like".equals(type)){
				paramMap.put("show_cnt", "3");
				paramMap.put("start_idx", "1");
				paramMap.put("order", "like");
			}
			
			list = sensuousMapper.selectRecipeList(paramMap);
			resultMap.put("list", list);
			
			if(type == null){
				int total_cnt = sensuousMapper.selectRecipeListTotalCnt(paramMap);
				resultMap.put("total_cnt", total_cnt);
			}
			
			return resultMap;
			
		} catch(Exception e) {
			
			throw e;
		}
	}
	
	/**
	 * 레시피 조회
	 * 
	 * @param 
	 * @return 
	 * @exception Exception
	 */
	public RecipeVO selectRecipeView(Map<String, Object> paramMap) throws Exception{
		
		try{
			RecipeVO recipeVO = sensuousMapper.selectRecipeView(paramMap);
			
			System.out.println(">>>>>>>>>>>"+recipeVO.getRcp_menu_memo());
			
			return recipeVO;
			
		} catch(Exception e) {
			
			throw e;
		}
	}
	
	/**
	 * 레시피 타이틀명 조회
	 * 
	 * @param 
	 * @return 
	 * @exception Exception
	 */
	@Transactional(readOnly=true)
	public Map<String, Object> selectRecipeListTitle(Map<String, Object> paramMap) throws Exception {
		
		Map<String, Object> resultMap = new HashMap<String, Object>();
		RecipeVO recipeVO = null;
		
		try{
			
			recipeVO = sensuousMapper.selectRecipeListTitle(paramMap);
			resultMap.put("recipeVO", recipeVO);
			
			return resultMap;
			
		} catch(Exception e) {
			
			throw e;
		}
	}
	

	/**
	 * 개발목적 목록 조회
	 * 
	 * @param 
	 * @return 
	 * @exception Exception
	 */
	public List<RecipeVO> selectPurpList(Map<String, Object> paramMap) throws Exception{
		List<RecipeVO> resultList = new ArrayList<RecipeVO>();
		
		try{
			
			resultList = sensuousMapper.selectPurpList(paramMap);
			
			return resultList;
			
		} catch(Exception e) {
			e.printStackTrace();
			
			throw e;
		}
	}
	
	/**
	 * 개발목적 목록 조회
	 * 
	 * @param 
	 * @return 
	 * @exception Exception
	 */
	public List<RecipeVO> selectNutList(Map<String, Object> paramMap) throws Exception{
		List<RecipeVO> resultList = new ArrayList<RecipeVO>();
		
		try{
			
			resultList = sensuousMapper.selectNutList(paramMap);
			
			return resultList;
			
		} catch(Exception e) {
			e.printStackTrace();
			
			throw e;
		}
	}
	
	/**
	 * 조회수 업데이트
	 * 
	 * @param 
	 * @return 
	 * @exception Exception
	 */
	public int updateRecipeCount(Map<String, Object> paramMap) throws Exception{
		int resultObj = 0;
		try {
			resultObj = sensuousMapper.updateRecipeCount(paramMap);
			
			return resultObj;
			
		} catch(Exception e){
			e.printStackTrace();
			
			return 0;
		}
	}
	
	/**
	 * 추천수 업데이트
	 * 
	 * @param 
	 * @return 
	 * @exception Exception
	 */
	public int updateRecipeLike(Map<String, Object> paramMap) throws Exception{
		int resultObj = 0;
		int isLiked = 0;
		
		try {
			
			paramMap.put("user_id", "ch"); //임시
			String dvs_cd = (String) paramMap.get("dvs_cd");
			
			RecipeVO recipeVO = sensuousMapper.selectRecipeLike(paramMap);
			isLiked  = recipeVO.getRcp_menu_like();
			
			if(isLiked == 0){
				if("MENU".equals(dvs_cd)){
					resultObj += sensuousMapper.updateRcpMenuLike(paramMap);
				}else if("NETI".equals(dvs_cd)){
					resultObj += sensuousMapper.updateNetiRcpLike(paramMap);
				}
				resultObj += sensuousMapper.insertRecipeLike(paramMap);
			}else{
				resultObj = 0;
			}
			
			return resultObj;
			
		} catch(Exception e){
			e.printStackTrace();
			
			return -1;
		}
	}
	
	
	/**
	 *테마식단 리스트
	 * 
	 * @param 
	 * @return 
	 * @exception Exception
	 */
	public RecipeThemaVO selectThemaMenuList(Map<String, Object> paramMap) throws Exception{
		RecipeThemaVO themaVO = new RecipeThemaVO();
		
		try{
			
			themaVO = sensuousMapper.selectThemaMenuList(paramMap);
			
			return themaVO;
			
		} catch(Exception e) {
			e.printStackTrace();
			
			throw e;
		}
	}
	
	/**
	 *테마식단 레시피 리스트
	 * 
	 * @param 
	 * @return 
	 * @exception Exception
	 */
	public List<RecipeThemaVO> selectThemaRecipoeList(Map<String, Object> paramMap) throws Exception{
		List<RecipeThemaVO> resultList = new ArrayList<RecipeThemaVO>();
		
		try{
			resultList = sensuousMapper.selectThemaRecipoeList(paramMap);
			return resultList;
			
		} catch(Exception e) {
			e.printStackTrace();
			
			throw e;
		}
	}
	
	/**
	 *테마식단 레시피 정보 주(week)차 확인
	 * 
	 * @param 
	 * @return 
	 * @exception Exception
	 */
	public List<RecipeThemaVO> selectThemaWeekList(Map<String, Object> paramMap) throws Exception{
		List<RecipeThemaVO> resultList = new ArrayList<RecipeThemaVO>();
		
		try{
			resultList = sensuousMapper.selectThemaWeekList(paramMap);
			return resultList;
			
		} catch(Exception e) {
			e.printStackTrace();
			
			throw e;
		}
	}
	
	/**
	 * 제철재료 상세(팝업)
	 * 
	 * @param 
	 * @return 
	 * @exception Exception
	 */
	public RecipeNtrtVO selectRecipoeNtrtInfo(Map<String, Object> paramMap) throws Exception{
		RecipeNtrtVO resultInfo = new RecipeNtrtVO();
		
		try{
			resultInfo = sensuousMapper.selectThemaWeekInfo(paramMap);
			return resultInfo;
			
		} catch(Exception e) {
			e.printStackTrace();
			
			throw e;
		}
	}
	
	/**
	 * 제철재료 목록
	 * 
	 * @param 
	 * @return 
	 * @exception Exception
	 */
	public List<RecipeNtrtVO> selectRecipoeNtrtList(Map<String, Object> paramMap) throws Exception{
		List<RecipeNtrtVO> resultList = new ArrayList<RecipeNtrtVO>();
		
		try{
			resultList = sensuousMapper.selectRecipoeNtrtList(paramMap);
			return resultList;
			
		} catch(Exception e) {
			e.printStackTrace();
			
			throw e;
		}
	}
	
	/*************************************************** 네티즌  ****************************************************/
	
	/**
	 * 네티즌 레시피 조회
	 * 
	 * @param 
	 * @return 
	 * @exception Exception
	 */
	@Transactional(readOnly=true)
	public Map<String, Object> selectNetizenRecipeList(Map<String, Object> paramMap, String type) throws Exception{
		
	Map<String, Object> resultMap = new HashMap<String, Object>();
	List<NetizenRecipeVO> list = null;
	
		try{
			System.out.println("type>>"+type);
			if("lat".equals(type)){
				paramMap.put("show_cnt", "3");
				paramMap.put("start_idx", "1");
				paramMap.put("order", "lat");
			}else if("pop".equals(type)){
				paramMap.put("show_cnt", "3");
				paramMap.put("start_idx", "1");
				paramMap.put("order", "pop");
			}else if("rec".equals(type)){
				paramMap.put("show_cnt", "3");
				paramMap.put("start_idx", "1");
				paramMap.put("order", "rec");
			}
			
			list = sensuousMapper.selectNetizenRecipeList(paramMap);
			int total_cnt = sensuousMapper.selectNetizenRecipeListTotalCnt(paramMap);
			
			resultMap.put("list", list);
			resultMap.put("total_cnt", total_cnt);
			
			return resultMap;
			
		} catch(Exception e) {
			e.printStackTrace();
			
			throw e;
		}

	}	
	
	/**
	 * 네티즌 베스트 레시피 조회
	 * 
	 * @param 
	 * @return 
	 * @exception Exception
	 */
	@Transactional(readOnly=true)
	public Map<String, Object> selectNetizenBestRecipeList(Map<String, Object> paramMap) throws Exception {
		
		Map<String, Object> resultMap = new HashMap<String, Object>();
		NetizenRecipeVO netizenRecipeVO = null;
		
		try{
			
			netizenRecipeVO = sensuousMapper.selectNetizenBestRecipeList(paramMap);
			resultMap.put("netizenRecipeVO", netizenRecipeVO);
			
			return resultMap;
			
		} catch(Exception e) {
			e.printStackTrace();
			
			throw e;
		}
	}	
	
	/**
	 * 네티즌 레시피 작성
	 * 
	 * @param 
	 * @return 
	 * @exception Exception
	 */
	@Transactional(readOnly=true)
	public Map<String, Object> selectRecipeWrite(Map<String, Object> paramMap) throws Exception {
		
		Map<String, Object> resultMap = new HashMap<String, Object>();
		NetizenRecipeVO netizenRecipeVO = null;
		
		try{
			
			netizenRecipeVO = sensuousMapper.selectRecipeWrite(paramMap);
			resultMap.put("netizenRecipeVO", netizenRecipeVO);
			
			return resultMap;
			
		} catch(Exception e) {
			e.printStackTrace();
			
			throw e;
		}
	}		
	
	/**
	 * 네티즌 레시피 저장
	 * @param complainVO
	 * @return
	 */
	@Transactional
	public Map<String, Object> saveNetizenRecipe(NetizenRecipeVO netizenRecipeVO) throws Exception {
		
		Map<String, Object> rtnMap = new HashMap<String, Object>();
		Map<String, Object> map = new HashMap<String, Object>();
		
		
		try {
			netizenRecipeVO.setCretr_id("cyk");		//작성자 ID -  임시
			netizenRecipeVO.setLast_updtr_id("cyk");	//수정자 ID -  임시
			netizenRecipeVO.setRprsnt_img_yn("Y");
			
			map = CommonConvertObjectToMap.ConverObjectToMap(netizenRecipeVO);
			
			String fileYn = netizenRecipeVO.getFile_yn();
			System.out.println("fileYn>"+fileYn);
			
			String atchFileNo;
			//파일첨부 상태값이 변경되었다면
			if("Y".equals(fileYn)){
				
				sensuousMapper.deleteAtchFile(map);
				//연결 파일 등록
				if( !"SUCCEED".equals(fileUpLoad(map))){
					throw new Exception();
				}
				
				atchFileNo = sensuousMapper.selectNewAtchFileNo();
				map.put("atch_file_no", atchFileNo);
				
				sensuousMapper.insertAtchFile(map);
				
			}
			
			System.out.println("map>>"+map);
			if((Integer) map.get("neti_rcp_no") == -1){
				sensuousMapper.insertNetizenRecipe(map);
				rtnMap.put("typeCd", "neti");
			}else{
				sensuousMapper.updateNetizenRecipe(map);
				rtnMap.put("typeCd", "my");
			}
			
			rtnMap.put("rtnCd", 1);
		} catch (Exception e) {
			e.printStackTrace();
			
			rtnMap.put("rtnCd", 0);
		}
		
		return rtnMap;
	}		
	
	/**
	 * 파일 업로드
	 * @param paramMap
	 * @return
	 * @throws Exception
	 */
	public String fileUpLoad(Map<String, Object> paramMap){
		Map<String, Object> fileMap = new HashMap<String, Object>();
		UploadFileVO uploadFileVO = new UploadFileVO();
		IOUtil ioUtil = null;
		
		try {
			ioUtil = new IOUtil();
			
			uploadFileVO.setFile_path((String) paramMap.get("file_path"));
			uploadFileVO.setLogic_file_nm((String) paramMap.get("logic_file_nm"));
			uploadFileVO.setPhysic_file_nm((String) paramMap.get("physic_file_nm"));
			uploadFileVO.setFile_type_cd((String) paramMap.get("file_type_cd"));
			uploadFileVO.setRprsnt_img_yn((String) paramMap.get("rprsnt_img_yn"));
			
			fileMap = ioUtil.startUploadSingleFile(uploadFileVO);
			
		} catch (Exception e) {
			fileMap.put("result", "FILED");
		} finally {
			if(ioUtil != null){
				ioUtil = null;
			}
		}
    	
		if("succeed".equals(fileMap.get("result"))){
			paramMap.put("file_path", StringUtil.NVLToSpace(fileMap.get("realPath")));
			paramMap.put("physic_file_nm", StringUtil.NVLToSpace(fileMap.get("realName")));
			
			return "SUCCEED";
		}else{
			return "FILED";
		}
	}
	
	/**
	 * 네티즌 레시피 상세 조회
	 * 
	 * @param 
	 * @return 
	 * @exception Exception
	 */
	public NetizenRecipeVO selectNetizenRecipe(Map<String, Object> paramMap) throws Exception{
		
		try{
			NetizenRecipeVO netizenRecipeVO = sensuousMapper.selectNetizenRecipe(paramMap);
			
			System.out.println(">>>>>>>>>>>"+netizenRecipeVO.getNeti_rcp_no());
			
			return netizenRecipeVO;
			
		} catch(Exception e) {
			
			throw e;
		}
	}
	
	/**
	 * 네티즌 레시피 조회수 업데이트
	 * 
	 * @param 
	 * @return 
	 * @exception Exception
	 */
	public int updateNetizenRecipeCount(Map<String, Object> paramMap) throws Exception{
		int resultObj = 0;
		try {
			resultObj = sensuousMapper.updateNetizenRecipeCount(paramMap);
			
			return resultObj;
			
		} catch(Exception e){
			e.printStackTrace();
			
			return 0;
		}
	}
	
	/**
	 * 임시파일 삭제
	 * 
	 * @param 
	 * @return 
	 * @exception Exception
	 */
//	public int deleteTempFile(String tempFile) throws Exception{
//		int isDel = 0;
//		
//		String path = "C:\\mfds\\workspace\\foodportal-front\\src\\main\\webapp\\img\\tmpimg";
//		
//		File deleteFile = new File(path, tempFile);
//		
//		if(deleteFile.exists()){
//			deleteFile.delete();
//		}
//		
//		if(!deleteFile.exists()){
//			isDel = 1;
//		}
//		
//		return isDel;
//	}
	
	/**
	 * 나의 레시피 조회
	 * 
	 * @param 
	 * @return 
	 * @exception Exception
	 */
	@Transactional(readOnly=true)
	public Map<String, Object> selectMyRecipeList(Map<String, Object> paramMap) throws Exception{
		
		Map<String, Object> resultMap = new HashMap<String, Object>();
		List<NetizenRecipeVO> list = null;
		String user_id = "cyk";		//임시
		paramMap.put("user_id", user_id);
		try{
			
			list = sensuousMapper.selectMyRecipeList(paramMap);
			int total_cnt = sensuousMapper.selectMyRecipeListTotalCnt(paramMap);
			
			resultMap.put("list", list);
			resultMap.put("total_cnt", total_cnt);
			
			return resultMap;
			
		} catch(Exception e) {
			
			throw e;
		}

	}	
	
	/**
	 * 네티즌 레시피 삭제
	 * 
	 * @param 
	 * @return 
	 * @exception Exception
	 */
	@Transactional(readOnly=true)
	public Map<String, Object> deleteRecipe(Map<String, Object> paramMap) throws Exception{
		
		Map<String, Object> resultMap = new HashMap<String, Object>();
		try{
			
			int resultCd = sensuousMapper.deleteRecipe(paramMap);
			System.out.println("servieceimpl resultCd"+resultCd);
			resultMap.put("result", resultCd);
			return resultMap;
			
		} catch(Exception e) {
			e.printStackTrace();
			
			throw e;
		}
	}
		
		
}