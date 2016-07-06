package foodportal.minwon.complain.service;

import java.util.List;
import java.util.Map;

import foodportal.front.common.vo.CommonCodeVO;
import foodportal.front.common.vo.FoodtypeVO;
import foodportal.front.common.vo.OrgnVO;
import foodportal.minwon.complain.vo.ComplainReplyVO;
import foodportal.minwon.complain.vo.ComplainVO;
import foodportal.minwon.complain.vo.MakerVO;
import foodportal.minwon.complain.vo.MinwonCodeVO;

/**
 * ComplainService
 * @author 장영철
 * @since 2014.10.06
 * @version 1.0
 * @see
 *
 * <pre>
 *  Modification Information
 *  수정일      수정자   수정내용
 *  ---------- -------- ---------------------------
 *  2014.10.06 장영철 최초 생성
 * </pre>
 *
 * Copyright (C) 2014 by NDS., All right reserved.
 */

public interface ComplainService {
	
	/**
	 * 공통 코드 조회
	 * @param cmmn_cd
	 * @return
	 * @throws Exception
	 */
	public List<CommonCodeVO> selectCmmnCdFnprt(String cmmn_cd) throws Exception;
	
	/**
	 * 공통 코드 조회(조건)
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public List<CommonCodeVO> selectCmmnCdFnprt(Map<String, Object> map) throws Exception;
	
	/**
	 * 이물종류 코드
	 * @return
	 */
	public List<MinwonCodeVO> selectAlnstCd(Map<String, Object> map) throws Exception;
	
	/**
	 * 업체 이물 신고 저장
	 * @param complainVO
	 * @param complainExt
	 * @return
	 * @throws Exception
	 */
	public Map<String, Object> saveBusinessNotify(ComplainVO complainVO, String complainExt) throws Exception;
	
	/**
	 * 소비자 신고 저장
	 * @param complainVO
	 * @return
	 */
	public Map<String, Object> saveCustomerNotify(ComplainVO complainVO, String complainExt) throws Exception;
	
	/**
	 * 소비자 신고 문서번호 존재 여부 체크
	 * @param doc_no
	 * @return
	 * @throws Exception
	 */
	public String exisChkCustomerNotify(String doc_no) throws Exception;

	/**
	 * 소비자 신고 진행 상태 조회
	 * @param doc_no
	 * @return
	 */
	public ComplainVO selectCustomerNotifyResult(Map<String, Object> map) throws Exception;
	
	/**
	 * 소비자 신고 답변
	 * @param doc_no
	 * @return
	 */
	public List<ComplainReplyVO> selectCustomerNotifyResultReply(String doc_no) throws Exception;
	
	/**
	 * 식품유형 코드 조회
	 * @param prdlst_cd
	 * @return
	 * @throws Exception
	 */
	public FoodtypeVO getFoodtypeCd(String prdlst_cd) throws Exception;
	
	/**
	 * 증거 제품 보관 조회
	 * @param doc_no
	 * @return
	 * @throws Exception
	 */
	public List<ComplainVO> selectEvdcPrdtCstdy(String doc_no) throws Exception;
	
	/**
	 * 제품 정보 조회(등록)
	 * @param bsn_lcns_ledg_no
	 * @return
	 * @throws Exception
	 */
	public MakerVO selectRegMakerInfo(String makr_cd) throws Exception;
	
	/**
	 * 제품 정보 조회(미등록)
	 * @param unreg_bssh_seq
	 * @return
	 * @throws Exception
	 */
	public MakerVO selectUnRegMakerInfo(String makr_cd) throws Exception;
	
	/**
	 * 첨부파일 조회
	 * @param doc_no
	 * @return
	 * @throws Exception
	 */
	public ComplainVO selectAtchfl(String doc_no) throws Exception;
	
	/**
	 * 업체 이물 신고 진행 상태 조회
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public ComplainVO selectBusinessNotifyResult(Map<String, Object> map) throws Exception;
	
	/**
	 * 업체 이물 신고 문서번호 존재 여부 체크
	 * @param doc_no
	 * @return
	 * @throws Exception
	 */
	public String exisChkBusinessNotify(String doc_no) throws Exception;
	
	/**
	 * 기관정보를 가져온다.
	 * @param instt_cd
	 * @return
	 * @throws Exception
	 */
	public OrgnVO searchCmmnOrgn(String instt_cd) throws Exception;
	
}
