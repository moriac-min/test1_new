package foodportal.front.safefoodlife.foodadditive.service;

import java.util.List;

import foodportal.front.safefoodlife.foodadditive.vo.FoodAdditiveBasisInfoVO;

/**
 * FoodAdditiveService
 * @author 임재록
 * @since 2014.10.08
 * @version 1.0
 * @see
 * 
 * <pre>
 *  Modification Information
 *  수정일      수정자   수정내용
 *  ---------- -------- ---------------------------
 *  2014.10.08 임재록 최초 생성
 * </pre>
 * 
 * Copyright (C) 2014 by NDS., All right reserved.
 */

public interface FoodAdditiveService {
	
	/**
	 * 품목별 기본정보 목록 조회
	 * 
	 * @param 
	 * @return 
	 * @exception Exception
	 */
	public List<FoodAdditiveBasisInfoVO> selectFoodAdditiveBasisInfoList(FoodAdditiveBasisInfoVO foodAdditiveBasisInfoVO) throws Exception;
	
	/**
	 * 전체 첨가물 코드 조회
	 * 
	 * @param 
	 * @return 
	 * @exception Exception
	 */
	public FoodAdditiveBasisInfoVO selectFoodAdditiveTotalSerial(FoodAdditiveBasisInfoVO foodAdditiveBasisInfoVO) throws Exception;
	
	/**
	 * 품목별 기본정보 상세 조회
	 * 
	 * @param 
	 * @return 
	 * @exception Exception
	 */
	public FoodAdditiveBasisInfoVO selectFoodAdditiveBasisInfoDetail(FoodAdditiveBasisInfoVO foodAdditiveBasisInfoVO) throws Exception;
	
	/**
	 * 품목별 기본정보 상세 조회 2
	 * 
	 * @param 
	 * @return 
	 * @exception Exception
	 */
	public FoodAdditiveBasisInfoVO selectFoodAdditiveBasisInfoDetail2(FoodAdditiveBasisInfoVO foodAdditiveBasisInfoVO) throws Exception;
	
	/**
	 * 품목별 기본정보 상세 조회 3
	 * 
	 * @param 
	 * @return 
	 * @exception Exception
	 */
	public FoodAdditiveBasisInfoVO selectFoodAdditiveBasisInfoDetail3(FoodAdditiveBasisInfoVO foodAdditiveBasisInfoVO) throws Exception;
	
	/**
	 * 품목별 기본정보 상세 조회 4
	 * 
	 * @param 
	 * @return 
	 * @exception Exception
	 */
	public FoodAdditiveBasisInfoVO selectFoodAdditiveBasisInfoDetail4(FoodAdditiveBasisInfoVO foodAdditiveBasisInfoVO) throws Exception;
	
	/**
	 * 품목별 기본정보 상세 조회 5
	 * 
	 * @param 
	 * @return 
	 * @exception Exception
	 */
	public FoodAdditiveBasisInfoVO selectFoodAdditiveBasisInfoDetail5(FoodAdditiveBasisInfoVO foodAdditiveBasisInfoVO) throws Exception;
	
	/**
	 * 품목별 기본정보 상세 조회 6
	 * 
	 * @param 
	 * @return 
	 * @exception Exception
	 */
	public FoodAdditiveBasisInfoVO selectFoodAdditiveBasisInfoDetail6(FoodAdditiveBasisInfoVO foodAdditiveBasisInfoVO) throws Exception;
	
	/**
	 * 품목별 기본정보 상세 조회 7
	 * 
	 * @param 
	 * @return 
	 * @exception Exception
	 */
	public FoodAdditiveBasisInfoVO selectFoodAdditiveBasisInfoDetail7(FoodAdditiveBasisInfoVO foodAdditiveBasisInfoVO) throws Exception;
	
	/**
	 * 지정년월일 및 개정진행사항 목록 조회
	 * 
	 * @param 
	 * @return 
	 * @exception Exception
	 */
	public List<FoodAdditiveBasisInfoVO> selectFoodAdditiveBasisInfoReformHistoryList(FoodAdditiveBasisInfoVO foodAdditiveBasisInfoVO) throws Exception;
	
	/**
	 * CFR 사용기준 목록 조회
	 * 
	 * @param 
	 * @return 
	 * @exception Exception
	 */
	public List<FoodAdditiveBasisInfoVO> selectFoodAdditiveBasisInfoCfrUseStandardList(FoodAdditiveBasisInfoVO foodAdditiveBasisInfoVO) throws Exception;
	
	/**
	 * CFR 사용기준 목록 조회
	 * 
	 * @param 
	 * @return 
	 * @exception Exception
	 */
	public List<FoodAdditiveBasisInfoVO> selectFoodAdditiveBasisInfoCodexUseStandardList(FoodAdditiveBasisInfoVO foodAdditiveBasisInfoVO) throws Exception;
	
}