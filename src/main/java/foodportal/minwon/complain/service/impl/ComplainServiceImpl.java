package foodportal.minwon.complain.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import common.commonfacillity.log.CommonLog;
import foodportal.common.util.CommonConvertObjectToMap;
import foodportal.common.util.IOUtil;
import foodportal.common.util.StringUtil;
import foodportal.front.common.vo.CommonCodeVO;
import foodportal.front.common.vo.FoodtypeVO;
import foodportal.front.common.vo.OrgnVO;
import foodportal.front.common.vo.UploadFileVO;
import foodportal.minwon.complain.mapper.ComplainMapper;
import foodportal.minwon.complain.service.ComplainService;
import foodportal.minwon.complain.vo.ComplainReplyVO;
import foodportal.minwon.complain.vo.ComplainVO;
import foodportal.minwon.complain.vo.MakerVO;
import foodportal.minwon.complain.vo.MinwonCodeVO;


/**
 * CompainServiceImpl
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

@Service("ComplainService")
public class ComplainServiceImpl implements ComplainService {
	
	@CommonLog Logger log;

	@Autowired
	ComplainMapper complainMapper;
	
	/**
	 * 업체 이물 신고 저장
	 * @param complainVO
	 * @param complainExt
	 * @return
	 * @throws Exception
	 */
	@Transactional
	public Map<String, Object> saveBusinessNotify(ComplainVO complainVO, String complainExt) throws Exception {
		Map<String, Object> rtnMap = new HashMap<String, Object>();
		Map<String, Object> map = new HashMap<String, Object>();
		
		String userId = "";
		
		try {
			
			//등록자/수정자 셋팅
			if(userId != null && !"".equals(userId)){
				complainVO.setCretr_id(userId);
				complainVO.setLast_updtr_id(userId);
			}else{
				complainVO.setCretr_id(complainVO.getAplcnt_name());
				complainVO.setLast_updtr_id(complainVO.getAplcnt_name());
			}
			
			map = CommonConvertObjectToMap.ConverObjectToMap(complainVO);
			
			//신고자 등록
			complainMapper.insertAplcnt(map);
			//신고업체등록
			complainMapper.insertSttemntEntrps(map);
			//업체 신고자 등록
			complainMapper.insertEntrpsAplcnt(map);
			//신고 접수 등록
			map.put("rcpt_instt_dvs_cd", complainVO.BUSINESS_DOC_NO_PREFIX);
			complainMapper.insertSttemntRcpt(map);
			
			//증거 제품 보관 등록
			String keepFlag = StringUtil.NVLToSpace(map.get("keep_flag_list"));
			if(keepFlag != null && !"".equals(keepFlag)){
				
				String keepFlagArray[] = keepFlag.split(",");
				for (String flag : keepFlagArray) {
					map.put("evdc_prdt_cstdy_dvs_cd", flag);
					complainMapper.insertEvdcPrdtCstdy(map);
				}
			}
			
			//조사등록
			complainMapper.insertExam(map);
			
			//파일등록
			if("Y".equals(StringUtil.NVLToSpace(map.get("file_yn")))){
				//연결 파일 등록
				if( !"SUCCEED".equals(fileUpLoad(map)) ){
					throw new Exception();
				}
				
				if(complainExt != null && !"".equals(complainExt)){
					String[] complainExtArr = complainExt.split("&");
					
					if(complainExtArr != null && complainExtArr.length > 0){
						if(Pattern.matches(complainExtArr[0], complainVO.getFile_extns())){
							map.put("file_knd_dvs_cd", "I");		//이미지형
						}else{
							map.put("file_knd_dvs_cd", "M");		//동영상형
						}
					}
				}
				
				complainMapper.insertCmmnAtchFile(map);		//공통 첨부파일 등록
				map.put("atchfl_seq", map.get("atch_file_seq"));
				complainMapper.insertAtchfl(map);					//첨부파일 등록
				
			}
			
			rtnMap.put("rtnCd", 1);
			rtnMap.put("doc_no", map.get("doc_no"));
			rtnMap.put("pswd", map.get("pswd"));
			
		} catch (Exception e) {
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			
			rtnMap.put("rtnCd", 0);
		}
		
		return rtnMap;
	}

	/**
	 *  공통 코드 조회
	 * @return
	 */
	@Transactional(readOnly=true)
	public List<CommonCodeVO> selectCmmnCdFnprt(String cmmn_cd) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("cmmn_cd", cmmn_cd);
		
		return complainMapper.selectCmmnCdFnprt(map);
	}
	
	/**
	 *  공통 코드 조회(조건)
	 * @return
	 */
	@Transactional(readOnly=true)
	public List<CommonCodeVO> selectCmmnCdFnprt(Map<String, Object> map) throws Exception {
		
		return complainMapper.selectCmmnCdFnprt(map);
	}
	
	/**
	 * 이물종류 코드
	 * @return
	 */
	@Transactional(readOnly=true)
	public List<MinwonCodeVO> selectAlnstCd(Map<String, Object> map) throws Exception {

		return complainMapper.selectAlnstCd(map);
	}
	
	/**
	 * 소비자 신고 저장
	 * @param complainVO
	 * @return
	 */
	@Transactional
	public Map<String, Object> saveCustomerNotify(ComplainVO complainVO, String complainExt) throws Exception {
		Map<String, Object> rtnMap = new HashMap<String, Object>();
		Map<String, Object> map = new HashMap<String, Object>();
		String userId = "";
		
		try {
			
			//등록자/수정자 셋팅
			if(userId != null && !"".equals(userId)){
				complainVO.setCretr_id(userId);
				complainVO.setLast_updtr_id(userId);
			}else{
				complainVO.setCretr_id(complainVO.getAplcnt_name());
				complainVO.setLast_updtr_id(complainVO.getAplcnt_name());
			}
			
			map = CommonConvertObjectToMap.ConverObjectToMap(complainVO);
			
			//신고자 등록
			complainMapper.insertAplcnt(map);
			//신고 접수 등록
			map.put("rcpt_instt_dvs_cd", complainVO.CUSTOMER_DOC_NO_PREFIX);
			complainMapper.insertSttemntRcpt(map);
			
			//증거 제품 보관 등록
			String keepFlag = StringUtil.NVLToSpace(map.get("keep_flag_list"));
			if(keepFlag != null && !"".equals(keepFlag)){
				
				String keepFlagArray[] = keepFlag.split(",");
				for (String flag : keepFlagArray) {
					map.put("evdc_prdt_cstdy_dvs_cd", flag);
					complainMapper.insertEvdcPrdtCstdy(map);
				}
			}
			
			//조사등록
			complainMapper.insertExam(map);
			
			//파일등록
			if("Y".equals(StringUtil.NVLToSpace(map.get("file_yn")))){
				//연결 파일 등록
				if( !"SUCCEED".equals(fileUpLoad(map)) ){
					throw new Exception();
				}
				
				if(complainExt != null && !"".equals(complainExt)){
					String[] complainExtArr = complainExt.split("&");
					
					if(complainExtArr != null && complainExtArr.length > 0){
						if(Pattern.matches(complainExtArr[0], complainVO.getFile_extns())){
							map.put("file_knd_dvs_cd", "I");		//이미지형
						}else{
							map.put("file_knd_dvs_cd", "M");		//동영상형
						}
					}
				}
				
				complainMapper.insertCmmnAtchFile(map);		//공통 첨부파일 등록
				map.put("atchfl_seq", map.get("atch_file_seq"));
				complainMapper.insertAtchfl(map);					//첨부파일 등록
				
			}
			
			rtnMap.put("rtnCd", 1);
			rtnMap.put("doc_no", map.get("doc_no"));
			rtnMap.put("pswd", map.get("pswd"));
			
		} catch (Exception e) {
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			
			rtnMap.put("rtnCd", 0);
		}
		
		return rtnMap;
	}
	
	/**
	 * 소비자 신고 문서번호 존재 여부 체크
	 * @param doc_no
	 * @return
	 * @throws Exception
	 */
	public String exisChkCustomerNotify(String doc_no) throws Exception{
		return complainMapper.exisChkCustomerNotify(doc_no);
	}
	
	/**
	 * 소비자 신고 진행 상태 조회
	 * @param doc_no
	 * @return
	 */
	@Transactional(readOnly=true)
	public ComplainVO selectCustomerNotifyResult(Map<String, Object> map) throws Exception {
		ComplainVO complainVO = complainMapper.selectCustomerNotifyResult(map);

		//코드 매핑
		if(complainVO != null){
			//진행상태코드
			complainVO.setNow_stats_cd_nm( commonCodeMapper("CP14", complainVO.getNow_stats_cd()) );
			
			//신고내용상세코드
			complainVO.setVilt_cn_cd_nm( commonCodeMapper("CP05", complainVO.getVilt_cn_cd()) );
			
			//국산/수입산 코드
			if("E".equals(complainVO.getOrgnp_dvs_cd())){
				complainVO.setIncm_natn_cd_nm( commonCodeMapper("A02", complainVO.getIncm_natn_cd()) );
			}
			
		}

		return complainVO;
	}
	
	/**
	 * 소비자 신고 답변
	 * @param doc_no
	 * @return
	 */
	@Transactional(readOnly=true)
	public List<ComplainReplyVO> selectCustomerNotifyResultReply(String doc_no) throws Exception {
		return complainMapper.selectCustomerNotifyResultReply(doc_no);
	}
	
	/**
	 * 식품유형 코드 조회
	 * @param prdlst_cd
	 * @return
	 * @throws Exception
	 */
	@Transactional(readOnly=true)
	public FoodtypeVO getFoodtypeCd(String prdlst_cd) throws Exception {
		return complainMapper.getFoodtypeCd(prdlst_cd);
	}
	
	/**
	 * 증거 제품 보관 조회
	 * @param doc_no
	 * @return
	 * @throws Exception
	 */
	@Transactional(readOnly=true)
	public List<ComplainVO> selectEvdcPrdtCstdy(String doc_no) throws Exception {
		return complainMapper.selectEvdcPrdtCstdy(doc_no);
	}
	
	/**
	 * 공통코드 코드명 매핑
	 * @param searchCd
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public String commonCodeMapper(String hCode, String code)  throws Exception {
		List<CommonCodeVO> list = null;
		Map<String, Object> map = new HashMap<String, Object>();
		
		if( code != null && !"".equals(code) ){
			map.put("cmmn_cd", hCode);
			map.put("fnprt_cd", code);
			
			list = complainMapper.selectCmmnCdFnprt(map);
			if(list != null && list.size() > 0){
				return list.get(0).getFnprt_cd_nm();
			}
		}
		
		return null;
	}
	
	/**
	 * 첨부파일 조회
	 * @param doc_no
	 * @return
	 * @throws Exception
	 */
	public ComplainVO selectAtchfl(String doc_no) throws Exception {
		return complainMapper.selectAtchfl(doc_no);
	}
	
	/**
	 * 제품 정보 조회(등록)
	 * @param bsn_lcns_ledg_no
	 * @return
	 * @throws Exception
	 */
	public MakerVO selectRegMakerInfo(String makr_cd) throws Exception {
		return complainMapper.selectRegMakerInfo(makr_cd);
	}
	
	/**
	 * 제품 정보 조회(미등록)
	 * @param unreg_bssh_seq
	 * @return
	 * @throws Exception
	 */
	public MakerVO selectUnRegMakerInfo(String makr_cd) throws Exception {
		return complainMapper.selectUnRegMakerInfo(makr_cd);
	}
	
	/**
	 * 소비자 신고 진행 상태 조회
	 * @param doc_no
	 * @return
	 */
	@Transactional(readOnly=true)
	public ComplainVO selectBusinessNotifyResult(Map<String, Object> map) throws Exception {
		ComplainVO complainVO = complainMapper.selectBusinessNotifyResult(map);
		
		//코드 매핑
		if(complainVO != null){
			//진행상태코드
			complainVO.setNow_stats_cd_nm( commonCodeMapper("CP14", complainVO.getNow_stats_cd()) );
			//업종 코드
			complainVO.setInduty_dvs_cd_nm( commonCodeMapper("CP13", complainVO.getInduty_dvs_cd()) );
			//조사종결 통보방식 코드
			complainVO.setDspth_way_cd_nm( commonCodeMapper("CP07", complainVO.getDspth_way_cd()) );
			//국산/수입산 코드
			if("E".equals(complainVO.getOrgnp_dvs_cd())){
				complainVO.setIncm_natn_cd_nm( commonCodeMapper("A02", complainVO.getIncm_natn_cd()) );
			}
		}

		return complainVO;
	}
	
	/**
	 * 업체 이물 신고 문서번호 존재 여부 체크
	 * @param doc_no
	 * @return
	 * @throws Exception
	 */
	public String exisChkBusinessNotify(String doc_no) throws Exception{
		return complainMapper.exisChkBusinessNotify(doc_no);
	}
	
	/**
	 * 기관 정보를 가져온다.
	 * @param instt_cd
	 * @return
	 * @throws Exception
	 */
	public OrgnVO searchCmmnOrgn(String instt_cd) throws Exception{
		return complainMapper.selectCmmnOrgn(instt_cd);
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
			
			uploadFileVO.setFile_path((String) paramMap.get("file_save_path"));
			uploadFileVO.setPhysic_file_nm((String) paramMap.get("physic_file_nm"));
			uploadFileVO.setFile_type_cd((String) paramMap.get("file_extns"));
			
			fileMap = ioUtil.startUploadSingleFile(uploadFileVO);
			
		} catch (Exception e) {
			fileMap.put("result", "FILED");
		} finally {
			if(ioUtil != null){
				ioUtil = null;
			}
		}
    	
		if("succeed".equals(fileMap.get("result"))){
			paramMap.put("file_save_path", StringUtil.NVLToSpace(fileMap.get("realPath")));
			paramMap.put("physic_file_nm", StringUtil.NVLToSpace(fileMap.get("realName")));
			
			return "SUCCEED";
		}else{
			return "FILED";
		}
	}
	
}
