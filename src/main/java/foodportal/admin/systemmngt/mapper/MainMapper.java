package foodportal.admin.systemmngt.mapper;

import java.util.List;
import java.util.Map;

import egovframework.rte.psl.dataaccess.mapper.Mapper;
import foodportal.admin.systemmngt.vo.BannerVO;
import foodportal.admin.systemmngt.vo.FoodLifeVO;
import foodportal.admin.systemmngt.vo.IssueVO;
import foodportal.admin.systemmngt.vo.LifeCycleVO;

/**
 * MainMapper
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

@Mapper("foodportal.admin.systemmngt.mapper.MainMapper")
public interface MainMapper {

	/*******************************************************************************/
	/******************************공통영역*******************************************/
	/*******************************************************************************/
	
	/**
	 * 게시글 시퀀스 조회
	 * @return
	 */
	public String selectNewntctxtNo();
	
	/**
	 * 게시글에 해당 정보 존재 여부(NTCTXT_NO)
	 * @param map
	 * @return
	 */
	public String selectNtctxtExisChek(String paramStr);
	
	/**
	 * 게시글 등록
	 * @param map
	 * @return
	 */
	public int insertNtctxt(Map<String, Object> map);
	
	/**
	 * 게시글별_확장_컬럼 테이블 등록
	 * @param map
	 * @return
	 */
	public int insertNtctxtacctoExtClmn(Map<String, Object> map);
	
	/**
	 * 게시글별_속성 등록
	 * @param map
	 * @return
	 */
	public int insertNtctxtacctoAttrb(Map<String, Object> map);
	
	/**
	 * 게시글별 본문 등록
	 * @param map
	 * @return
	 */
	public int insertNtctxtacctoBdt(Map<String, Object> map);
	
	/**
	 * 게시글 수정
	 * @param map
	 * @return
	 */
	public int updateNtctxt(Map<String, Object> map);
	
	/**
	 * 게시글별_확장_컬럼에 해당 정보 존재 여부(NTCTXT_NO)
	 * @param paramStr
	 * @return
	 */
	public String selectNtctxtacctoExtClmnExisChek(String paramStr);
	
	/**
	 * 게시글별_확장_컬럼 테이블 수정
	 * @param map
	 * @return
	 */
	public int updateNtctxtacctoExtClmn(Map<String, Object> map);
	
	/**
	 * 게시글별_속성에 해당 정보 존재 여부(NTCTXT_NO)
	 * @param map
	 * @return
	 */
	public String selectNtctxtacctoAttrbExisChek(String paramStr);
	
	/**
	 * 게시글별_속성 수정
	 * @param map
	 * @return
	 */
	public int updateNtctxtacctoAttrb(Map<String, Object> map);
	
	/**
	 * 게시글별 본문 존재 여부 체크
	 * @param paramStr
	 * @return
	 */
	public String selectNtctxtacctoBdtExisChek(String paramStr);
	
	/**
	 * 게시글별_본문 수정
	 * @param map
	 * @return
	 */
	public int updateNtctxtacctoBdt(Map<String, Object> map);
	
	/**
	 * 게시글 삭제
	 * @param map
	 * @return
	 */
	public int deleteNtctxt(Map<String, Object> map);
	
	/**
	 * 첨부파일 테이블 시퀀스
	 * @return
	 */
	public String selectNewAtchFileNo();
	
	/**
	 * 첨부파일 등록
	 * @param map
	 * @return
	 */
	public int insertAtchFile(Map<String, Object> map);
	
	/**
	 * 첨부파일 수정
	 * @param map
	 * @return
	 */
	public int updateAtchFile(Map<String, Object> map);
	
	/**
	 * 첨부파일 삭제
	 * @param map
	 * @return
	 */
	public int deleteAtchFile(Map<String, Object> map);
	
	/**
	 * 게시글별 첨부파일 등록
	 * @param map
	 * @return
	 */
	public int insertNtctxtacctoAtchfl(Map<String, Object> map);
	
	/**
	 * 게시글별 첨부파일 등록
	 * @param map
	 * @return
	 */
	public int deleteNtctxtacctoAtchfl(Map<String, Object> map);
	
	
	/*******************************************************************************/
	/******************************이슈관리*******************************************/
	/*******************************************************************************/
	
	/**
	 * 이슈정보 조회
	 * @param paramStr
	 * @return
	 */
	public IssueVO selectIssue(String paramStr);
	
	/**
	 * 이슈발생 여부 조회
	 * @param paramStr
	 * @return
	 */
	public IssueVO selectIssueOccrncYn(String paramStr);
	
	/**
	 * 환경설정 수정
	 * @param map
	 * @return
	 */
	public int updateEnvrnSetupIssue(Map<String, Object> map);
	
	
	/*******************************************************************************/
	/******************************배너관리*******************************************/
	/*******************************************************************************/
	
	/**
	 * 공통 배너 정보 조회
	 * @param paramStr
	 * @return
	 */
	public BannerVO selectCommonBannerInfo(String paramStr);
	
	/**
	 * 공통 배너 리스트 조회
	 * @param paramStr
	 * @return
	 */
	public List<BannerVO> selectCommonBannerList(String paramStr);
	
	/**
	 * 서비스배너 정보 조회
	 * @param paramStr
	 * @return
	 */
	public List<BannerVO> selectServiceBannerList(String paramStr);
	
	
	/*******************************************************************************/
	/******************************생애주기별 정보 관리***********************************/
	/*******************************************************************************/
	
	/**
	 * 생애주기별 정보  조회
	 * @param paramStr
	 * @return
	 */
	public LifeCycleVO selectLifeCycleInfo(String paramStr);
	
	
	/*******************************************************************************/
	/******************************식생활 게시글 연결 관리*********************************/
	/*******************************************************************************/
	
	/**
	 * 식생활 메뉴 목록 조회
	 * @param map
	 * @return
	 */
	public List<FoodLifeVO> selectFoodLifeMenuList(Map<String, Object> map);
	
	/**
	 * 식생활 메뉴 목록별 게시글 연결 정보 조회
	 * @param map
	 * @return
	 */
	public FoodLifeVO selectFoodLifeLinkInfo(Map<String, Object> map);
	
	/**
	 * 식생활 메뉴 연결 게시글 조회
	 * @param paramStr
	 * @return
	 */
	public FoodLifeVO selectFoodLifeLinkBbsInfo(String paramStr);
	
	/**
	 * 식생활 메뉴 목록별 게시글 조회
	 * @param paramStr
	 * @return
	 */
	public List<FoodLifeVO> selectFoodLifeBbsList(String paramStr);
	
	/**
	 * 식생활 게시글 연결 관리 존재여부 체크
	 * @param paramStr
	 * @return
	 */
	public String selectFoodLifeNtctxtExisChek(Map<String, Object> map);
}
