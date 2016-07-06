package foodportal.minwon.complain.mapper;

import java.util.List;
import java.util.Map;

import egovframework.rte.psl.dataaccess.mapper.Mapper;
import foodportal.front.common.vo.CommonCodeVO;
import foodportal.front.common.vo.FoodtypeVO;
import foodportal.front.common.vo.OrgnVO;
import foodportal.minwon.complain.vo.ComplainReplyVO;
import foodportal.minwon.complain.vo.ComplainVO;
import foodportal.minwon.complain.vo.MakerVO;
import foodportal.minwon.complain.vo.MinwonCodeVO;

/**
 * ComplainMapper
 * @author 장영철
 * @since 2014.10.14
 * @version 1.0
 * @see
 *
 * <pre>
 *  Modification Information
 *  수정일      수정자   수정내용
 *  ---------- -------- ---------------------------
 *  2014.10.14 장영철 최초 생성
 * </pre>
 *
 * Copyright (C) 2014 by NDS., All right reserved.
 */

@Mapper("foodportal.minwon.complain.mapper.ComplainMapper")
public interface ComplainMapper {
	
	/**
	 * 공통 코드 조회
	 * @param map
	 * @return
	 */
	public List<CommonCodeVO> selectCmmnCdFnprt(Map<String, Object> map);
	
	/**
	 * 이물종류 코드
	 * @return
	 */
	public List<MinwonCodeVO> selectAlnstCd(Map<String, Object> map);
	
	/**
	 * 신고자 insert
	 * @param map
	 * @return
	 */
	public int insertAplcnt(Map<String, Object> map);
	
	/**
	 * 신고접수 insert
	 * @param map
	 * @return
	 */
	public int insertSttemntRcpt(Map<String, Object> map);
	
	/**
	 * 증거 제품 보관 insert
	 * @param map
	 * @return
	 */
	public int insertEvdcPrdtCstdy(Map<String, Object> map);
	
	/**
	 * 조사 insert
	 * @param map
	 * @return
	 */
	public int insertExam(Map<String, Object> map);
	
	/**
	 * 첨부파일 등록
	 * @param map
	 * @return
	 */
	public int insertAtchfl(Map<String, Object> map);
	
	/**
	 * 공통 첨부파일 등록
	 * @param map
	 * @return
	 */
	public int insertCmmnAtchFile(Map<String, Object> map);
	
	/**
	 * 신고업체 등록
	 * @param map
	 * @return
	 */
	public int insertSttemntEntrps(Map<String, Object> map);
	
	/**
	 * 업체 신고자 등록
	 * @param map
	 * @return
	 */
	public int insertEntrpsAplcnt(Map<String, Object> map);
	
	/**
	 * 소비자 신고 문서번호 존재 여부 체크
	 * @param doc_no
	 * @return
	 */
	public String exisChkCustomerNotify(String doc_no);
	
	/**
	 * 소비자 신고 진행상태 조회
	 * @param strParam
	 * @return
	 */
	public ComplainVO selectCustomerNotifyResult(Map<String, Object> map);
	
	/**
	 * 소비자 신고 답변
	 * @param strParam
	 * @return
	 */
	public List<ComplainReplyVO> selectCustomerNotifyResultReply(String doc_no);
	
	/**
	 * 식품유형 코드 조회
	 * @param prdlst_cd
	 * @return
	 */
	public FoodtypeVO getFoodtypeCd(String prdlst_cd);
	
	/**
	 * 증거 제품 보관 조회
	 * @param doc_no
	 * @return
	 */
	public List<ComplainVO> selectEvdcPrdtCstdy(String doc_no);
	
	/**
	 * 첨부파일 조회
	 * @param doc_no
	 * @return
	 */
	public ComplainVO selectAtchfl(String doc_no);
	
	/**
	 * 제품 정보 조회(등록)
	 * @param bsn_lcns_ledg_no
	 * @return
	 */
	public MakerVO selectRegMakerInfo(String makr_cd);
	
	/**
	 * 제품 정보 조회(미등록)
	 * @param unreg_bssh_seq
	 * @return
	 */
	public MakerVO selectUnRegMakerInfo(String makr_cd);
	
	/**
	 * 업체이물 신고 진행 상태 조회
	 * @param strParam
	 * @return
	 */
	public ComplainVO selectBusinessNotifyResult(Map<String, Object> map);
	
	/**
	 * 업체 이물 신고 문서번호 존재 여부 체크
	 * @param doc_no
	 * @return
	 */
	public String exisChkBusinessNotify(String doc_no);
	
	/**
	 * 기관정보를 가져온다.
	 * @param instt_cd
	 * @return
	 */
	public OrgnVO selectCmmnOrgn(String instt_cd);

}
