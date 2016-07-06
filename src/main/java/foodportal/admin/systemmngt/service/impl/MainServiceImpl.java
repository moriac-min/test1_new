package foodportal.admin.systemmngt.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import common.commonfacillity.log.CommonLog;
import common.commonfacillity.uia.WqBaseBean;
import common.commonfacillity.util.CommonConvertObjectToMap;

import foodportal.admin.systemmngt.mapper.MainMapper;
import foodportal.admin.systemmngt.service.MainService;
import foodportal.admin.systemmngt.vo.AdminSystemmngtRootVO;
import foodportal.admin.systemmngt.vo.BannerVO;
import foodportal.admin.systemmngt.vo.FoodLifeVO;
import foodportal.admin.systemmngt.vo.IssueVO;
import foodportal.admin.systemmngt.vo.LifeCycleVO;
import foodportal.admin.systemmngt.vo.UploadFileVO;
import foodportal.common.util.IOUtil;
import foodportal.common.util.StringUtil;


/**
 * CategorySettingServiceImpl
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

@Service("mainService")
public class MainServiceImpl implements MainService{
	
	@CommonLog Logger log;
	
	@Autowired
	MainMapper mainMapper;
	
	/**
	 * 이슈발생시 설정 정보 조회
	 * 
	 * @param 
	 * @return 
	 * @exception Exception
	 */
	@Transactional(readOnly=true)
	public IssueVO selectIssue(WqBaseBean ibean) throws Exception {
		
		try{
			AdminSystemmngtRootVO adminSystemmngtRootVO = (AdminSystemmngtRootVO) ibean;
			IssueVO issueVO = adminSystemmngtRootVO.getParamIssueVO();
			
			issueVO = mainMapper.selectIssue(issueVO.getIssue_cd());
			
			return issueVO;
			
		}catch(Exception e){
			
			throw e;
		}
	}
	
	/**
	 * 이슈발생 정보 저장
	 * 
	 * @param 
	 * @return 
	 * @exception Exception
	 */
	@Transactional
	public int saveIssue(WqBaseBean ibean) throws Exception {
		HashMap<String, Object> map = new HashMap<String, Object>();
		String bbsNo;
		String ntctxtNo;
		String atchFileNo;
		String outptTypeCd = "";
		String fileYn = "";
		
		
		try {
			AdminSystemmngtRootVO adminSystemmngtRootVO = (AdminSystemmngtRootVO) ibean;
			IssueVO issueVO =  adminSystemmngtRootVO.getIssueVO();
			IssueVO tempVO = adminSystemmngtRootVO.getParamIssueVO();
			bbsNo = tempVO.getIssue_cd();
			fileYn = issueVO.getFile_yn();
			
			//Type 설정 - F(프레임), N(새창), S(현재창), P(팝업)
			if("F".equals(issueVO.getClmn01())){	//이슈 타입 - F(FRAME), B(BANNER)
				outptTypeCd = "F";
			}else if("B".equals(issueVO.getClmn01())){		//새창에서 열기(Y/N)
				if("Y".equals(issueVO.getClmn03())){
					outptTypeCd = "N";
				}else if("N".equals(issueVO.getClmn03())){
					if("Y".equals(issueVO.getClmn04())){		//팝업으로 열기(Y/N)
						outptTypeCd = "P";
					}else if("N".equals(issueVO.getClmn04())){
						outptTypeCd = "S";
					}
				}
			}
			
			//공통부분 셋팅
			issueVO.setEnvrn_setup_no(bbsNo);		//환경설정 게시판 번호 설정
			issueVO.setBbs_no(bbsNo);		//게시판 코드 설정(이슈코드)
			issueVO.setBbs_type_cd(bbsNo);		//게시판 코드 설정(이슈코드)
			issueVO.setBbs_nm(tempVO.getIssue_nm());		//게시판_명
			issueVO.setDel_yn("N");							//삭제여부(이슈관리는 삭제가 존재하지 않는다.)
			issueVO.setCretr_id("SYSTEM");				//작성자 ID -  임시
			issueVO.setLast_updtr_id("SYSTEM");		//수정자 ID -  임시
			issueVO.setOutpt_type_cd(outptTypeCd);	//노출 방식 - F(프레임), N(새창), S(현재창), P(팝업)
			
			map = CommonConvertObjectToMap.ConverObjectToMap(issueVO);
			
			mainMapper.updateEnvrnSetupIssue(map);	//환경설정 테이블 업데이트
			
			if("Y".equals(issueVO.getIssue_occrnc_yn())){
				
				//NTCTXT(게시글 테이블에 이슈발생시 정보가 존재하는지 체크)
				ntctxtNo = mainMapper.selectNtctxtExisChek(bbsNo);
				if(ntctxtNo == null || "".equals(ntctxtNo)){		//존재하지 않는다면 Insert
					ntctxtNo = mainMapper.selectNewntctxtNo();
					map.put("ntctxt_no", ntctxtNo);
					mainMapper.insertNtctxt(map);
				}else{		//존재하면 Update
					map.put("ntctxt_no", ntctxtNo);
					mainMapper.updateNtctxt(map);
				}
				
				//NTCTXTACCTO_EXT_CLMN(게시글별 확장 컬럼 테이블에 이슈발생시 정보가 존재하는지 체크)
				ntctxtNo = mainMapper.selectNtctxtacctoExtClmnExisChek(ntctxtNo);
				if(ntctxtNo == null || "".equals(ntctxtNo)){		//존재하지 않는다면 Insert
					mainMapper.insertNtctxtacctoExtClmn(map);
				}else{		//존재하면 Update
					mainMapper.updateNtctxtacctoExtClmn(map);
				}
				
				//NTCTXTACCTO_ATTRB(게시글별 속성 테이블에 이슈발생시 정보가 존재하는지 체크)
				ntctxtNo = mainMapper.selectNtctxtacctoAttrbExisChek(ntctxtNo);
				if(ntctxtNo == null || "".equals(ntctxtNo)){		//존재하지 않는다면 Insert
					mainMapper.insertNtctxtacctoAttrb(map);
				}else{		//존재하면 Update
					mainMapper.updateNtctxtacctoAttrb(map);
				}
				
				//파일첨부 상태값이 변경되었다면
				if("Y".equals(fileYn)){
					//연결파일 삭제
					mainMapper.deleteNtctxtacctoAtchfl(map);
					mainMapper.deleteAtchFile(map);
					
					//연결 파일 등록
					if( !"SUCCEED".equals(fileUpLoad(map)) ){
						throw new Exception();
					}
					
					atchFileNo = mainMapper.selectNewAtchFileNo();
					map.put("atch_file_no", atchFileNo);
					
					mainMapper.insertAtchFile(map);
					mainMapper.insertNtctxtacctoAtchfl(map);
					
				}else if("N".equals(fileYn)){
					mainMapper.deleteNtctxtacctoAtchfl(map);
					mainMapper.deleteAtchFile(map);
				}
			}
			
			return 1;
			
		} catch (Exception e) {
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			return 0;
		}
	}
	
	/**
	 * 생애주기별 정보 조회
	 * 
	 * @param 
	 * @return 
	 * @exception Exception
	 */
	@Transactional(readOnly=true)
	public LifeCycleVO selectLifeCycleInfo(WqBaseBean ibean) throws Exception{
		
		try {
			AdminSystemmngtRootVO adminSystemmngtRootVO = (AdminSystemmngtRootVO) ibean;
			LifeCycleVO lifeCycleVO = adminSystemmngtRootVO.getParamLifeCycleVO();
			
			lifeCycleVO = mainMapper.selectLifeCycleInfo(lifeCycleVO.getBbs_no());
			
			return lifeCycleVO;
			
		} catch (Exception e) {
			
			throw e;
		}
	}
	
	/**
	 * 생애주기별 정보 저장
	 * 
	 * @param 
	 * @return 
	 * @exception Exception
	 */
	@Transactional
	public int saveLifeCycle(WqBaseBean ibean) throws Exception {
		HashMap<String, Object> map = new HashMap<String, Object>();
		LifeCycleVO lifeCycleVO;
		
		String bbsNo;
		String ntctxtNo;
		String cretrId;
		String lastUpdtrId;
		
		try {
			AdminSystemmngtRootVO adminSystemmngtRootVO = (AdminSystemmngtRootVO) ibean;
			lifeCycleVO = adminSystemmngtRootVO.getParamLifeCycleVO();
			
			bbsNo = lifeCycleVO.getBbs_no();
			cretrId = "SYSTEM";
			lastUpdtrId = "SYSTEM";
			
			lifeCycleVO.setBbs_no(bbsNo);
			lifeCycleVO.setCretr_id(cretrId);
			lifeCycleVO.setLast_updtr_id(lastUpdtrId);
			
			map = CommonConvertObjectToMap.ConverObjectToMap(lifeCycleVO);
			
			//NTCTXT(게시글 테이블에 생애주기별 정보가 존재하는지 체크)
			ntctxtNo = mainMapper.selectNtctxtExisChek(bbsNo);
			if(ntctxtNo == null || "".equals(ntctxtNo)){		//존재하지 않는다면 insert
				ntctxtNo = mainMapper.selectNewntctxtNo();
				map.put("ntctxt_no", ntctxtNo);
				mainMapper.insertNtctxt(map);
			}else{		//존재하면 ntctxtNo를 map에 넣어준다.
				map.put("ntctxt_no", ntctxtNo);
			}
			
			//NTCTXTACCTO_EXT_CLMN(게시글별 확장 컬럼 테이블에 생애주기별 정보가 존재하는지 체크)
			ntctxtNo = mainMapper.selectNtctxtacctoExtClmnExisChek(ntctxtNo);
			if(ntctxtNo == null || "".equals(ntctxtNo)){		//존재하지 않는다면 Insert
				mainMapper.insertNtctxtacctoExtClmn(map);
			}else{		//존재하면 Update
				mainMapper.updateNtctxtacctoExtClmn(map);
			}
			
			return 1;
			
		} catch (Exception e) {
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			return 0;
		}
	}
	
	/**
	 * 식생활 메뉴 목록 조회
	 * 
	 * @param 
	 * @return 
	 * @exception Exception
	 */
	@Transactional(readOnly=true)
	public List<FoodLifeVO> selectFoodLifeMenuList(WqBaseBean ibean) throws Exception {
		HashMap<String, Object> map = new HashMap<String, Object>();
		
		try {
			AdminSystemmngtRootVO adminSystemmngtRootVO = (AdminSystemmngtRootVO) ibean;
			FoodLifeVO foodLifeVO = adminSystemmngtRootVO.getParamFoodLifeVO();
			
			map = CommonConvertObjectToMap.ConverObjectToMap(foodLifeVO);
			
			List<FoodLifeVO> list = mainMapper.selectFoodLifeMenuList(map);
			
			return list;
			
		} catch (Exception e) {
			
			throw e;
		}
	}
	
	/**
	 * 식생활 메뉴 목록별 게시글 연결 정보 조회
	 * @param ibean
	 * @return
	 * @throws Exception
	 */
	@Transactional(readOnly=true)
	public FoodLifeVO selectFoodLifeLinkInfo(WqBaseBean ibean) throws Exception {
		HashMap<String, Object> map = new HashMap<String, Object>();
		
		try {
			AdminSystemmngtRootVO adminSystemmngtRootVO = (AdminSystemmngtRootVO) ibean;
			FoodLifeVO foodLifeVO = adminSystemmngtRootVO.getParamFoodLifeVO();
			
			map = CommonConvertObjectToMap.ConverObjectToMap(foodLifeVO);
			
			foodLifeVO = mainMapper.selectFoodLifeLinkInfo(map);
			
			return foodLifeVO;
			
		} catch (Exception e) {
			
			throw e;
		}
	}
	
	/**
	 * 식생활 메뉴 목록별 게시글 조회
	 * @param ibean
	 * @return
	 * @throws Exception
	 */
	@Transactional(readOnly=true)
	public List<FoodLifeVO> selectFoodLifeBbsList(WqBaseBean ibean) throws Exception {
		
		try {
			AdminSystemmngtRootVO adminSystemmngtRootVO = (AdminSystemmngtRootVO) ibean;
			FoodLifeVO foodLifeVO = adminSystemmngtRootVO.getParamFoodLifeVO();
			
			List<FoodLifeVO> list = mainMapper.selectFoodLifeBbsList(foodLifeVO.getBbs_no());
			
			return list;
			
		} catch (Exception e) {
			
			throw e;
		}
		
	}
	
	/**
	 * 식생활 메뉴 연결 게시글 조회
	 * @param ibean
	 * @return
	 * @throws Exception
	 */
	@Transactional(readOnly=true)
	public FoodLifeVO selectFoodLifeLinkBbsInfo(WqBaseBean ibean) throws Exception {
		
		try {
			AdminSystemmngtRootVO adminSystemmngtRootVO = (AdminSystemmngtRootVO) ibean;
			FoodLifeVO foodLifeVO = adminSystemmngtRootVO.getParamFoodLifeVO();
			
			foodLifeVO = mainMapper.selectFoodLifeLinkBbsInfo(foodLifeVO.getNtctxt_no());
			
			return foodLifeVO;
			
		} catch (Exception e) {
			
			throw e;
		}
		
	}
	
	/**
	 * 식생활 게시글 연결 저장
	 * @param ibean
	 * @return
	 * @throws Exception
	 */
	@Transactional
	public int saveFoodLife(WqBaseBean ibean) throws Exception {
		HashMap<String, Object> map = new HashMap<String, Object>();
		FoodLifeVO foodLifeVO;
		
		String bbsNo = "";
		String ntctxtNo = "";
		String fileYn = "";
		String cretrId = "";
		String lastUpdtrId = "";
		String atchFileNo = "";
		String paramStatus = "";
		
		try {
			AdminSystemmngtRootVO adminSystemmngtRootVO = (AdminSystemmngtRootVO) ibean;
			foodLifeVO = adminSystemmngtRootVO.getParamFoodLifeVO();
			
			bbsNo = foodLifeVO.getFood_life_cd();
			fileYn = foodLifeVO.getFile_yn();
			atchFileNo = foodLifeVO.getAtch_file_no();
			paramStatus = foodLifeVO.getParam_status();
			cretrId = "SYSTEM";
			lastUpdtrId = "SYSTEM";
			
			//게시글 연결 정보 셋팅
			foodLifeVO.setClmn01(foodLifeVO.getMenu_no());		//연결된 메뉴번호
			foodLifeVO.setClmn02(foodLifeVO.getBbs_no());			//연결된 게시판번호
			foodLifeVO.setClmn03(foodLifeVO.getNtctxt_no());		//연결된 게시글번호
			
			//관리글 등록정보 셋팅
			foodLifeVO.setBbs_no(bbsNo);
			foodLifeVO.setCretr_id(cretrId);
			foodLifeVO.setLast_updtr_id(lastUpdtrId);
			
			map = CommonConvertObjectToMap.ConverObjectToMap(foodLifeVO);
			
			//NTCTXT(게시글 테이블에 식생활 게시글 연결 정보가 존재하는지 체크)
			ntctxtNo = mainMapper.selectFoodLifeNtctxtExisChek(map);
			if(ntctxtNo == null || "".equals(ntctxtNo)){		//존재하지 않는다면 insert
				ntctxtNo = mainMapper.selectNewntctxtNo();
				map.put("ntctxt_no", ntctxtNo);
				mainMapper.insertNtctxt(map);
			}else{		//존재하면 ntctxtNo를 map에 넣어준다.
				map.put("ntctxt_no", ntctxtNo);
				mainMapper.updateNtctxt(map);
			}

			//NTCTXTACCTO_EXT_CLMN(게시글별 확장 컬럼 테이블에 식생활 게시글 연결 정보가 존재하는지 체크)
			ntctxtNo = mainMapper.selectNtctxtacctoExtClmnExisChek(ntctxtNo);
			if(ntctxtNo == null || "".equals(ntctxtNo)){		//존재하지 않는다면 Insert
				mainMapper.insertNtctxtacctoExtClmn(map);
			}else{		//존재하면 Update
				mainMapper.updateNtctxtacctoExtClmn(map);
			}
			
			//NTCTXTACCTO_BDT(게시글별 본문 테이블에 해당 배너 정보가 존재하는지 체크)
			ntctxtNo = mainMapper.selectNtctxtacctoBdtExisChek(ntctxtNo);
			if(ntctxtNo == null || "".equals(ntctxtNo)){		//존재하지 않는다면 Insert
				mainMapper.insertNtctxtacctoBdt(map);
			}else{		//존재하면 Update
				mainMapper.updateNtctxtacctoBdt(map);
			}
			
			//파일첨부
			if("Y".equals(fileYn)){	//파일이 첨부 되었다면
				//연결파일 삭제
				mainMapper.deleteNtctxtacctoAtchfl(map);
				mainMapper.deleteAtchFile(map);
				
				//연결 파일 등록
				if( !"SUCCEED".equals(fileUpLoad(map)) ){
					throw new Exception();
				}
				
				atchFileNo = mainMapper.selectNewAtchFileNo();
				map.put("atch_file_no", atchFileNo);
				
				mainMapper.insertAtchFile(map);
				mainMapper.insertNtctxtacctoAtchfl(map);
				
			}else if("N".equals(fileYn)){		//파일이 삭제되었다면
				mainMapper.deleteNtctxtacctoAtchfl(map);
				mainMapper.deleteAtchFile(map);
				
			}else if( "change".equals(paramStatus) && "".equals(fileYn) && !"".equals(atchFileNo) ){			//원본 그대로의 파일을 사용한다면
				mainMapper.insertNtctxtacctoAtchfl(map);
			}
			
			return 1;
			
		} catch (Exception e) {
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			return 0;
		}
	}
	
	/**
	 * 식생활 게시글 연결 삭제
	 * @param ibean
	 * @return
	 * @throws Exception
	 */
	@Transactional
	public int deleteFoodLife(WqBaseBean ibean) throws Exception {
		HashMap<String, Object> map = new HashMap<String, Object>();
		
		try {
			AdminSystemmngtRootVO adminSystemmngtRootVO = (AdminSystemmngtRootVO) ibean;
			FoodLifeVO foodLifeVO = adminSystemmngtRootVO.getParamFoodLifeVO();
			
			String lastUpdtrId = "SYSTEM";
			
			foodLifeVO.setLast_updtr_id(lastUpdtrId);
			
			map = CommonConvertObjectToMap.ConverObjectToMap(foodLifeVO);
			
			mainMapper.deleteNtctxt(map);
			
			return 1;
			
		} catch (Exception e) {
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			return 0;
		}
	}
	
	/*******************************************************************************/
	/******************************배너관리*******************************************/
	/*******************************************************************************/
	
	/**
	 * 서비스 배너 정보 조회
	 * 
	 * @param 
	 * @return 
	 * @exception Exception
	 */
	@Transactional(readOnly=true)
	public List<BannerVO> selectServiceBannerList(WqBaseBean ibean) throws Exception {
		
		try {
			AdminSystemmngtRootVO adminSystemmngtRootVO = (AdminSystemmngtRootVO) ibean;
			BannerVO bannerVO = adminSystemmngtRootVO.getParamBannerVO();
			
			List<BannerVO> list = mainMapper.selectServiceBannerList(bannerVO.getBbs_no());
			
			return list;
			
		} catch (Exception e) {
			
			throw e;
		}
	}
	
	/**
	 * 서비스 배너 정보 저장
	 * 
	 * @param 
	 * @return 
	 * @exception Exception
	 */
	@Transactional
	public int saveServiceBanner(WqBaseBean ibean) throws Exception {
		HashMap<String, Object> map = new HashMap<String, Object>();
		BannerVO bannerVO;
		BannerVO tempBannerVO;
		
		String rowStatus;
		String bbsNo;
		String ntctxtNo;
		String atchFileNo;
		String cretrId;
		String lastUpdtrId;
		
		try {
			AdminSystemmngtRootVO adminSystemmngtRootVO = (AdminSystemmngtRootVO) ibean;
			List bannerList = adminSystemmngtRootVO.getParamBannerList();
			List rmBannerList = adminSystemmngtRootVO.getParamRmBannerList();
			tempBannerVO = adminSystemmngtRootVO.getParamBannerVO();

			bbsNo = tempBannerVO.getBbs_no();
			cretrId = "SYSTEM";		//임시
			lastUpdtrId = "SYSTEM";		//임시
			
			for(int idx = 0; idx < bannerList.size(); idx++){
				bannerVO = (BannerVO) bannerList.get(idx);
				rowStatus = bannerVO.getRowStatus();
				
				bannerVO.setBbs_no(bbsNo);
				bannerVO.setCretr_id(cretrId);
				bannerVO.setLast_updtr_id(lastUpdtrId);
				
				//Type 설정 - N(새창), S(현재창), P(팝업)
				if("Y".equals(bannerVO.getClmn03())){		//새창(Y/N)
					if("Y".equals(bannerVO.getClmn04())){		//팝업(Y/N)
						bannerVO.setOutpt_type_cd("P");
					}else{
						bannerVO.setOutpt_type_cd("N");
					}
				}else{
					bannerVO.setOutpt_type_cd("S");
				}
				
				map = CommonConvertObjectToMap.ConverObjectToMap(bannerVO);
				
				if (rowStatus.equalsIgnoreCase("C")) {			//insert
					ntctxtNo = mainMapper.selectNewntctxtNo();
					map.put("ntctxt_no", ntctxtNo);
					
					mainMapper.insertNtctxt(map);		//게시글 등록
					mainMapper.insertNtctxtacctoExtClmn(map);		//게시글별 확장 컬럼 등록
					mainMapper.insertNtctxtacctoAttrb(map);		//게시글별_속성 등록
					mainMapper.insertNtctxtacctoBdt(map);		//게시글별_본문 등록
					
					//연결 파일 등록
					if("Y".equals(bannerVO.getFile_yn())){
						if( !"SUCCEED".equals(fileUpLoad(map)) ){
							throw new Exception();
						}
						
						atchFileNo = mainMapper.selectNewAtchFileNo();
						map.put("atch_file_no", atchFileNo);
						
						mainMapper.insertAtchFile(map);		// 첨부파일 등록
						mainMapper.insertNtctxtacctoAtchfl(map);		//게시글별 첨부파일 등록
						
					}
					
				}else if(rowStatus.equalsIgnoreCase("U")) {		//update
					mainMapper.updateNtctxt(map);		//게시글 수정
					mainMapper.updateNtctxtacctoExtClmn(map);		//게시글별 확장 컬럼 수정
					mainMapper.updateNtctxtacctoAttrb(map);		//게시글별_속성 수정
					mainMapper.updateNtctxtacctoBdt(map);		//게시글별_본문 수정
										
					if("Y".equals(bannerVO.getFile_yn())){
						//연결파일 삭제
						mainMapper.deleteNtctxtacctoAtchfl(map);
						mainMapper.deleteAtchFile(map);
						
						//연결 파일 등록
						if( !"SUCCEED".equals(fileUpLoad(map)) ){
							throw new Exception();
						}
						
						atchFileNo = mainMapper.selectNewAtchFileNo();
						map.put("atch_file_no", atchFileNo);
						
						mainMapper.insertAtchFile(map);
						mainMapper.insertNtctxtacctoAtchfl(map);
						
					}else if("N".equals(bannerVO.getFile_yn())){		//연결파일 삭제
						mainMapper.deleteNtctxtacctoAtchfl(map);
						mainMapper.deleteAtchFile(map);
					}
				}
				
			}
			
			//delete
			for(int idx = 0; idx < rmBannerList.size(); idx++){
				bannerVO = (BannerVO) rmBannerList.get(idx);
				bannerVO.setLast_updtr_id(lastUpdtrId);
				
				map = CommonConvertObjectToMap.ConverObjectToMap(bannerVO);
				
				mainMapper.deleteNtctxt(map);
			}
			
			return 1;
			
		} catch (Exception e) {
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			return 0;
		}
	}
	
	/**
	 * 공통 배너 정보 조회
	 * 
	 * @param 
	 * @return 
	 * @exception Exception
	 */
	@Transactional(readOnly=true)
	public BannerVO selectCommonBannerInfo(WqBaseBean ibean) throws Exception {
		
		try {
			AdminSystemmngtRootVO adminSystemmngtRootVO = (AdminSystemmngtRootVO) ibean;
			BannerVO paramBannerVO = adminSystemmngtRootVO.getParamBannerVO();
			
			BannerVO bannerVO = mainMapper.selectCommonBannerInfo(paramBannerVO.getBbs_no());
			
			return bannerVO;
			
		} catch (Exception e) {
			
			throw e;
		}
	}
	
	/**
	 * 공통 배너 리스트 조회
	 * 
	 * @param 
	 * @return 
	 * @exception Exception
	 */
	@Transactional(readOnly=true)
	public List<BannerVO> selectCommonBannerList(WqBaseBean ibean) throws Exception {
		
		try {
			AdminSystemmngtRootVO adminSystemmngtRootVO = (AdminSystemmngtRootVO) ibean;
			BannerVO paramBannerVO = adminSystemmngtRootVO.getParamBannerVO();
			
			List<BannerVO> list = mainMapper.selectCommonBannerList(paramBannerVO.getBbs_no());
			
			return list;
			
		} catch (Exception e) {
			
			throw e;
		}
	}
	
	/**
	 * 공통 배너 리스트 저장
	 * 
	 * @param 
	 * @return 
	 * @exception Exception
	 */
	@Transactional
	public int saveCommonBanner(WqBaseBean ibean) throws Exception {
		HashMap<String, Object> map = new HashMap<String, Object>();
		BannerVO bannerVO;
		BannerVO paramBannerVO;
		
		String rowStatus;
		String bbsNo;
		String ntctxtNo;
		String atchFileNo;
		String cretrId;
		String lastUpdtrId;
		
		try {
			AdminSystemmngtRootVO adminSystemmngtRootVO = (AdminSystemmngtRootVO) ibean;
			List bannerList = adminSystemmngtRootVO.getParamBannerList();
			List rmBannerList = adminSystemmngtRootVO.getParamRmBannerList();
			paramBannerVO = adminSystemmngtRootVO.getParamBannerVO();

			bbsNo = paramBannerVO.getBbs_no();
			cretrId = "SYSTEM";				//임시
			lastUpdtrId = "SYSTEM";		//임시
			
			for(int idx = 0; idx < bannerList.size(); idx++){
				bannerVO = (BannerVO) bannerList.get(idx);
				rowStatus = bannerVO.getRowStatus();
				
				bannerVO.setBbs_no(bbsNo);
				bannerVO.setCretr_id(cretrId);
				bannerVO.setLast_updtr_id(lastUpdtrId);
				
				map = CommonConvertObjectToMap.ConverObjectToMap(bannerVO);
				
				if (rowStatus.equalsIgnoreCase("C")) {			//insert
					ntctxtNo = mainMapper.selectNewntctxtNo();
					map.put("ntctxt_no", ntctxtNo);
					
					mainMapper.insertNtctxt(map);		//게시글 등록
					mainMapper.insertNtctxtacctoExtClmn(map);		//게시글별 확장 컬럼 등록
					mainMapper.insertNtctxtacctoBdt(map);		//게시글별_본문 등록
					
					//연결 파일 등록
					if("Y".equals(bannerVO.getFile_yn())){
						
						if( !"SUCCEED".equals(fileUpLoad(map)) ){
							throw new Exception();
						}
						
						atchFileNo = mainMapper.selectNewAtchFileNo();
						map.put("atch_file_no", atchFileNo);
						
						mainMapper.insertAtchFile(map);		// 첨부파일 등록
						mainMapper.insertNtctxtacctoAtchfl(map);		//게시글별 첨부파일 등록
					}
					
				}else if(rowStatus.equalsIgnoreCase("U")) {		//update
					mainMapper.updateNtctxt(map);		//게시글 수정
					mainMapper.updateNtctxtacctoExtClmn(map);		//게시글별 확장 컬럼 수정
					mainMapper.updateNtctxtacctoBdt(map);		//게시글별_본문 수정
										
					if("Y".equals(bannerVO.getFile_yn())){
						//연결파일 삭제
						mainMapper.deleteNtctxtacctoAtchfl(map);
						mainMapper.deleteAtchFile(map);
						
						//연결 파일 등록
						if( !"SUCCEED".equals(fileUpLoad(map)) ){
							throw new Exception();
						}
						
						atchFileNo = mainMapper.selectNewAtchFileNo();
						map.put("atch_file_no", atchFileNo);
						
						mainMapper.insertAtchFile(map);
						mainMapper.insertNtctxtacctoAtchfl(map);
						
					}else if("N".equals(bannerVO.getFile_yn())){		//연결파일 삭제
						mainMapper.deleteNtctxtacctoAtchfl(map);
						mainMapper.deleteAtchFile(map);
					}
				}
				
			}
			
			//delete
			for(int idx = 0; idx < rmBannerList.size(); idx++){
				bannerVO = (BannerVO) rmBannerList.get(idx);
				bannerVO.setLast_updtr_id(lastUpdtrId);
				
				map = CommonConvertObjectToMap.ConverObjectToMap(bannerVO);
				
				mainMapper.deleteNtctxt(map);
			}
			
			return 1;
			
		} catch (Exception e) {
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			return 0;
		}
	}
	
	/**
	 * 공통 배너 정보 저장
	 * 
	 * @param 
	 * @return 
	 * @exception Exception
	 */
	@Transactional
	public int saveCommonBannerInfo(WqBaseBean ibean) throws Exception {
		HashMap<String, Object> map = new HashMap<String, Object>();
		
		try {
			AdminSystemmngtRootVO adminSystemmngtRootVO = (AdminSystemmngtRootVO) ibean;
			BannerVO bannerVO = adminSystemmngtRootVO.getParamBannerVO();

			String bbsNo = bannerVO.getBbs_no();
			String fileYn = bannerVO.getFile_yn();
			String cretrId = "SYSTEM";				//임시
			String lastUpdtrId = "SYSTEM";		//임시
			
			bannerVO.setCretr_id(cretrId);
			bannerVO.setLast_updtr_id(lastUpdtrId);
			
			map = CommonConvertObjectToMap.ConverObjectToMap(bannerVO);
			
			//NTCTXT(게시글 테이블에 해당 배너 정보가 존재하는지 체크)
			String ntctxtNo = mainMapper.selectNtctxtExisChek(bbsNo);
			if(ntctxtNo == null || "".equals(ntctxtNo)){		//존재하지 않는다면 insert
				ntctxtNo = mainMapper.selectNewntctxtNo();
				map.put("ntctxt_no", ntctxtNo);
				mainMapper.insertNtctxt(map);
			}else{		//존재하면 ntctxtNo를 map에 넣어준다.
				map.put("ntctxt_no", ntctxtNo);
				mainMapper.updateNtctxt(map);
			}
			
			//NTCTXTACCTO_EXT_CLMN(게시글별 확장 컬럼 테이블에 해당 배너 정보가 존재하는지 체크)
			ntctxtNo = mainMapper.selectNtctxtacctoExtClmnExisChek(ntctxtNo);
			if(ntctxtNo == null || "".equals(ntctxtNo)){		//존재하지 않는다면 Insert
				mainMapper.insertNtctxtacctoExtClmn(map);
			}else{		//존재하면 Update
				mainMapper.updateNtctxtacctoExtClmn(map);
			}
			
			//NTCTXTACCTO_BDT(게시글별 본문 테이블에 해당 배너 정보가 존재하는지 체크)
			ntctxtNo = mainMapper.selectNtctxtacctoBdtExisChek(ntctxtNo);
			if(ntctxtNo == null || "".equals(ntctxtNo)){		//존재하지 않는다면 Insert
				mainMapper.insertNtctxtacctoBdt(map);
			}else{		//존재하면 Update
				mainMapper.updateNtctxtacctoBdt(map);
			}
			
			//파일첨부 상태값이 변경되었다면
			if("Y".equals(fileYn)){
				//연결파일 삭제
				mainMapper.deleteNtctxtacctoAtchfl(map);
				mainMapper.deleteAtchFile(map);
				
				//연결 파일 등록
				if( !"SUCCEED".equals(fileUpLoad(map)) ){
					throw new Exception();
				}
				
				String atchFileNo = mainMapper.selectNewAtchFileNo();
				map.put("atch_file_no", atchFileNo);
				
				mainMapper.insertAtchFile(map);
				mainMapper.insertNtctxtacctoAtchfl(map);
				
			}else if("N".equals(fileYn)){
				mainMapper.deleteNtctxtacctoAtchfl(map);
				mainMapper.deleteAtchFile(map);
			}
			
			return 1;
			
		} catch (Exception e) {
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			return 0;
		}
	}
	
	
	/*******************************************************************************/
	/******************************파일업로드******************************************/
	/*******************************************************************************/
	
	/**
	 * 파일 업로드
	 * @param paramMap
	 * @return
	 * @throws Exception
	 */
	public String fileUpLoad(HashMap<String, Object> paramMap){
		Map<String, Object> fileMap = new HashMap<String, Object>();
		UploadFileVO uploadFileVO = new UploadFileVO();
		IOUtil ioUtil = null;
		
		try {
			ioUtil = new IOUtil();
			
			uploadFileVO.setFile_path((String) paramMap.get("file_path"));
			uploadFileVO.setPhysic_file_nm((String) paramMap.get("physic_file_nm"));
			uploadFileVO.setFile_type_cd((String) paramMap.get("file_type_cd"));
			
			//fileMap = ioUtil.startUploadSingleFile(uploadFileVO);
			
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
	
}