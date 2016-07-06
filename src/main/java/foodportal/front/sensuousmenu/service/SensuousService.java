package foodportal.front.sensuousmenu.service;

import java.util.List;
import java.util.Map;

import foodportal.front.sensuousmenu.vo.NetizenRecipeVO;
import foodportal.front.sensuousmenu.vo.RecipeNtrtVO;
import foodportal.front.sensuousmenu.vo.RecipeThemaVO;
import foodportal.front.sensuousmenu.vo.RecipeVO;

/**
 * SensuousService
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
public interface SensuousService {
	
	/**
	 * 레시피목록 조회
	 * 
	 * @param 
	 * @return 
	 * @exception Exception
	 */
	public Map<String, Object> selectRecipeList(Map<String, Object> paramMap, String type) throws Exception;
	
	/**
	 * 레시피 조회
	 * 
	 * @param 
	 * @return 
	 * @exception Exception
	 */
	public RecipeVO selectRecipeView(Map<String, Object> paramMap) throws Exception;
	
	/**
	 * 레시피 타이틀명 조회
	 * 
	 * @param 
	 * @return 
	 * @exception Exception
	 */
	public Map<String, Object> selectRecipeListTitle(Map<String, Object> paramMap) throws Exception;
	
	/**
	 * 개발목적 목록 조회
	 * 
	 * @param 
	 * @return 
	 * @exception Exception
	 */
	public List<RecipeVO> selectPurpList(Map<String, Object> paramMap) throws Exception;
	
	/**
	 * 개발목적 목록 조회
	 * 
	 * @param 
	 * @return 
	 * @exception Exception
	 */
	public List<RecipeVO> selectNutList(Map<String, Object> paramMap) throws Exception;
	
	/**
	 * 조회수 업데이트
	 * 
	 * @param 
	 * @return 
	 * @exception Exception
	 */
	public int updateRecipeCount(Map<String, Object> paramMap) throws Exception;
	
	/**
	 * 추천수 업데이트
	 * 
	 * @param 
	 * @return 
	 * @exception Exception
	 */
	public int updateRecipeLike(Map<String, Object> paramMap) throws Exception;
	
	/**
	 *테마식단 리스트
	 * 
	 * @param 
	 * @return 
	 * @exception Exception
	 */
	public RecipeThemaVO selectThemaMenuList(Map<String, Object> paramMap) throws Exception;
	
	/**
	 *테마식단 레시피 리스트
	 * 
	 * @param 
	 * @return 
	 * @exception Exception
	 */
	public List<RecipeThemaVO> selectThemaRecipoeList(Map<String, Object> paramMap) throws Exception;
	
	/**
	 *테마식단 레시피 정보 주(week)차 확인
	 * 
	 * @param 
	 * @return 
	 * @exception Exception
	 */
	public List<RecipeThemaVO> selectThemaWeekList(Map<String, Object> paramMap) throws Exception;
	
	/**
	 * 제철재료 목록
	 * 
	 * @param 
	 * @return 
	 * @exception Exception
	 */
	public List<RecipeNtrtVO> selectRecipoeNtrtList(Map<String, Object> paramMap) throws Exception;
	
	/**
	 * 제철재료 상세(팝업)
	 * 
	 * @param 
	 * @return 
	 * @exception Exception
	 */
	public RecipeNtrtVO selectRecipoeNtrtInfo(Map<String, Object> paramMap) throws Exception;

	/*************************************************** 네티즌  ****************************************************/
	
	/**
	 * 네티즌 레시피 조회
	 * 
	 * @param 
	 * @return 
	 * @exception Exception
	 */
	public Map<String, Object> selectNetizenRecipeList(Map<String, Object> paramMap, String type) throws Exception;
	
	/**
	 * 네티즌 베스트 레시피 조회
	 * 
	 * @param 
	 * @return 
	 * @exception Exception
	 */
	public Map<String, Object> selectNetizenBestRecipeList(Map<String, Object> paramMap) throws Exception;	
	
	/**
	 * 네티즌 레피시 작성
	 * 
	 * @param 
	 * @return 
	 * @exception Exception
	 */
	public Map<String, Object> selectRecipeWrite(Map<String, Object> paramMap) throws Exception;	
	
	/**
	 * 네티즌 레피시 저장
	 * 
	 * @param 
	 * @return 
	 * @exception Exception
	 */
	public Map<String, Object> saveNetizenRecipe(NetizenRecipeVO netizenRecipeVo) throws Exception;
	
	/**
	 * 네티즌 레피시 상세 조회
	 * 
	 * @param 
	 * @return 
	 * @exception Exception
	 */
	public NetizenRecipeVO selectNetizenRecipe(Map<String, Object> paramMap) throws Exception;
		
	/**
	 * 네티즌 레시피 조회수 업데이트
	 * 
	 * @param 
	 * @return 
	 * @exception Exception
	 */
	public int updateNetizenRecipeCount(Map<String, Object> paramMap) throws Exception;
	
	/**
	 * 임시파일 삭제
	 * 
	 * @param 
	 * @return 
	 * @exception Exception
	 */
//	public int deleteTempFile(String tempFile) throws Exception;	
	
	/**
	 * 나의 레시피 조회
	 * 
	 * @param 
	 * @return 
	 * @exception Exception
	 */
	public Map<String, Object> selectMyRecipeList(Map<String, Object> paramMap) throws Exception;
	
	/**
	 * 네티즌 레시피 삭제
	 * 
	 * @param 
	 * @return 
	 * @exception Exception
	 */
	public Map<String, Object> deleteRecipe(Map<String, Object> paramMap) throws Exception;	
	
}