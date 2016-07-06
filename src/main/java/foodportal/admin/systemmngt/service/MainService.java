package foodportal.admin.systemmngt.service;

import java.util.HashMap;
import java.util.List;

import common.commonfacillity.uia.WqBaseBean;
import foodportal.admin.systemmngt.vo.BannerVO;
import foodportal.admin.systemmngt.vo.FoodLifeVO;
import foodportal.admin.systemmngt.vo.IssueVO;
import foodportal.admin.systemmngt.vo.LifeCycleVO;

/**
 * MainService
 * @author 장영철
 * @since 2014.09.03
 * @version 1.0
 * @see
 * 
 * <pre>
 *  Modification Information
 *  수정일      수정자   수정내용
 *  ---------- -------- ---------------------------
 *  2014.09.03 장영철 최초 생성
 * </pre>
 * 
 * Copyright (C) 2014 by NDS., All right reserved.
 */

public interface MainService {
	
	/**
	 * 이슈발생시 설정 정보 조회
	 * 
	 * @param 
	 * @return 
	 * @exception Exception
	 */
	public IssueVO selectIssue(WqBaseBean ibean) throws Exception;
	
	/**
	 * 이슈발생 정보 저장
	 * 
	 * @param 
	 * @return 
	 * @exception Exception
	 */
	public int saveIssue(WqBaseBean ibean) throws Exception;
	
	/**
	 * 서비스 배너 정보 조회
	 * 
	 * @param 
	 * @return 
	 * @exception Exception
	 */
	public List<BannerVO> selectServiceBannerList(WqBaseBean ibean) throws Exception;
	
	/**
	 * 서비스 배너 정보 저장
	 * 
	 * @param 
	 * @return 
	 * @exception Exception
	 */
	public int saveServiceBanner(WqBaseBean ibean) throws Exception;

	/**
	 * 생애주기별 정보 조회
	 * 
	 * @param 
	 * @return 
	 * @exception Exception
	 */
	public LifeCycleVO selectLifeCycleInfo(WqBaseBean ibean) throws Exception;
	
	/**
	 *  생애주기별 정보 저장
	 * 
	 * @param 
	 * @return 
	 * @exception Exception
	 */
	public int saveLifeCycle(WqBaseBean ibean) throws Exception;
	
	/**
	 * 식생활 메뉴 목록 조회
	 * @param ibean
	 * @return
	 * @throws Exception
	 */
	public List<FoodLifeVO> selectFoodLifeMenuList(WqBaseBean ibean) throws Exception;
	
	/**
	 * 식생활 메뉴 목록별 게시글 연결 정보 조회
	 * @param ibean
	 * @return
	 * @throws Exception
	 */
	public FoodLifeVO selectFoodLifeLinkInfo(WqBaseBean ibean) throws Exception;
	
	
	/**
	 * 식생활 메뉴 목록별 게시글 조회
	 * @param ibean
	 * @return
	 * @throws Exception
	 */
	public List<FoodLifeVO> selectFoodLifeBbsList(WqBaseBean ibean) throws Exception;
	
	/**
	 * 식생활 메뉴 연결 게시글 조회
	 * @param ibean
	 * @return
	 * @throws Exception
	 */
	public FoodLifeVO selectFoodLifeLinkBbsInfo(WqBaseBean ibean) throws Exception;
	
	/**
	 * 식생활 게시글 연결 저장
	 * @param ibean
	 * @return
	 * @throws Exception
	 */
	public int saveFoodLife(WqBaseBean ibean) throws Exception;
	
	/**
	 * 식생활 게시글 연결 삭제
	 * @param ibean
	 * @return
	 * @throws Exception
	 */
	public int deleteFoodLife(WqBaseBean ibean) throws Exception;
	
	/**
	 * 공통 배너 정보 조회
	 * 
	 * @param 
	 * @return 
	 * @exception Exception
	 */
	public BannerVO selectCommonBannerInfo(WqBaseBean ibean) throws Exception;
	
	/**
	 * 공통 배너 리스트 조회
	 * 
	 * @param 
	 * @return 
	 * @exception Exception
	 */
	public List<BannerVO> selectCommonBannerList(WqBaseBean ibean) throws Exception;
	
	/**
	 * 공통 배너 정보 저장
	 * 
	 * @param 
	 * @return 
	 * @exception Exception
	 */
	public int saveCommonBannerInfo(WqBaseBean ibean) throws Exception;
	
	/**
	 * 공통 배너 리스트 저장
	 * 
	 * @param 
	 * @return 
	 * @exception Exception
	 */
	public int saveCommonBanner(WqBaseBean ibean) throws Exception;
	
	/**
	 * 파일 업로드
	 * @param paramMap
	 * @return
	 * @throws Exception
	 */
	public String fileUpLoad(HashMap<String, Object> paramMap) throws Exception;
	
	
}
