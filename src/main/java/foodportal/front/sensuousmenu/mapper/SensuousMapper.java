package foodportal.front.sensuousmenu.mapper;

import java.util.List;
import java.util.Map;

import egovframework.rte.psl.dataaccess.mapper.Mapper;
import foodportal.front.sensuousmenu.vo.NetizenRecipeVO;
import foodportal.front.sensuousmenu.vo.RecipeNtrtVO;
import foodportal.front.sensuousmenu.vo.RecipeThemaVO;
import foodportal.front.sensuousmenu.vo.RecipeVO;

/**
 * SensuousMapper
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

@Mapper("foodportal.front.sensuousmenu.mapper.SensuousMapper")
public interface SensuousMapper {

	public List<RecipeVO> selectRecipeList(Map<String, Object> paramMap);
	
	public int selectRecipeListTotalCnt(Map<String, Object> paramMap);
	
	public RecipeVO selectRecipeListTitle(Map<String, Object> paramMap);
	
	public RecipeVO selectRecipeView(Map<String, Object> paramMap);
	
	public List<RecipeVO> selectPurpList(Map<String, Object> paramMap);
	
	public List<RecipeVO> selectNutList(Map<String, Object> paramMap);
	
	public int updateRecipeCount(Map<String, Object> paramMap);
	
	public RecipeVO selectRecipeLike(Map<String, Object> paramMap);
	
	public int insertRecipeLike(Map<String, Object> paramMap);
	
	public int updateRcpMenuLike(Map<String, Object> paramMap);
	
	public int updateNetiRcpLike(Map<String, Object> paramMap);
	
	public RecipeThemaVO selectThemaMenuList(Map<String, Object> paramMap);
	
	public List<RecipeThemaVO> selectThemaRecipoeList(Map<String, Object> paramMap);
	
	public List<RecipeThemaVO> selectThemaWeekList(Map<String, Object> paramMap);
	
	public List<RecipeNtrtVO> selectRecipoeNtrtList(Map<String, Object> paramMap);
	
	public RecipeNtrtVO selectThemaWeekInfo(Map<String, Object> paramMap);
	
	/*************************************************** 네티즌  ****************************************************/
	
	/**
	 * 네티즌 레시피 목록
	 * @param map
	 * @return
	 */
	public List<NetizenRecipeVO> selectNetizenRecipeList(Map<String, Object> paramMap);
	
	/**
	 * 네티즌 레시피 목록 총갯수
	 * @param map
	 * @return
	 */
	public int selectNetizenRecipeListTotalCnt(Map<String, Object> paramMap);
	
	/**
	 * 네티즌 베트스 레시피
	 * @param map
	 * @return
	 */
	public NetizenRecipeVO selectNetizenBestRecipeList(Map<String, Object> paramMap);
	
	/**
	 * 레시피 작성
	 * @param map
	 * @return
	 */
	public NetizenRecipeVO selectRecipeWrite(Map<String, Object> paramMap);

	/**
	 * 레시피 등록
	 * @param map
	 * @return
	 */
	public int insertNetizenRecipe(Map<String, Object> map);

	/**
	 * 레시피 수정
	 * @param map
	 * @return
	 */
	public int updateNetizenRecipe(Map<String, Object> map);	
	
	/**
	 * 네티즌 레시피 상세
	 * @param map
	 * @return
	 */
	public NetizenRecipeVO selectNetizenRecipe(Map<String, Object> paramMap);
	
	/**
	 * 조회수 증가
	 * @param map
	 * @return
	 */
	public int updateNetizenRecipeCount(Map<String, Object> paramMap);

	/**
	 * 첨부 파일 번호 가져오기
	 * @param
	 * @return
	 */
	public String selectNewAtchFileNo();
	
	/**
	 * 첨부 파일 등록
	 * @param map
	 * @return
	 */
	public int insertAtchFile(Map<String, Object> map);		
	
	/**
	 * 첨부 파일 삭제
	 * @param map
	 * @return
	 */
	public int deleteAtchFile(Map<String, Object> map);		
	
	/**
	 * 나의 레시피 목록
	 * @param map
	 * @return
	 */
	public List<NetizenRecipeVO> selectMyRecipeList(Map<String, Object> paramMap);
	
	/**
	 * 나의 레시피 목록 총갯수
	 * @param map
	 * @return
	 */
	public int selectMyRecipeListTotalCnt(Map<String, Object> paramMap);	
	
	/**
	 * 나의 레시피 삭제
	 * @param map
	 * @return
	 */
	public int deleteRecipe(Map<String, Object> paramMap);	
}