package foodportal.minwon.complain.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.google.gson.Gson;
import common.commonfacillity.log.CommonLog;

import foodportal.common.util.StringUtil;
import foodportal.front.common.vo.CommonCodeVO;
import foodportal.minwon.complain.service.ComplainService;
import foodportal.minwon.complain.vo.ComplainVO;
import foodportal.minwon.complain.vo.MinwonCodeVO;

/**
 * ComplainController
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

@Controller
public class ComplainController {
	
	@CommonLog Logger log;
	
	@Autowired
	private ComplainService complainService;
	
	@Resource(name="fileUploadproperties")
	Properties properties;
	
	/**
	 * 1399 소비자신고센터 소개
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/minwon/complain/complainIntro.do")
	public String complainIntro(Model model) throws Exception {
		
		return "minwon/complain/complainIntro";
	}
	
	/**
	 * 공통 코드를 가져온다.
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping("/minwon/complain/selectCommonCode.do")
	public void selectCommonCode(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		
		String cmmn_cd = StringUtil.nullToStr(request.getParameter("cmmn_cd"));
		String selectCd = StringUtil.nullToStr(request.getParameter("selectCd"));
		
		map.put("cmmn_cd", cmmn_cd);
		map.put("selectCd", selectCd);
		
		List<CommonCodeVO> commonCodeVO = complainService.selectCmmnCdFnprt(map);

		response.setContentType("text/plain; charset=\"utf-8\"");
		response.getWriter().write(new Gson().toJson(commonCodeVO));
	}
	
	/**
	 * 이물종류 코드를 가져온다.
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping("/minwon/complain/selectAlnstCd.do")
	public void selectAlnstCd(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("lclas_cd", StringUtil.nullToStr(request.getParameter("lclas_cd")));
		
		List<MinwonCodeVO> minwonCodeVO = complainService.selectAlnstCd(map);
		
		response.setContentType("text/plain; charset=\"utf-8\"");
		response.getWriter().write(new Gson().toJson(minwonCodeVO));
	}
	
	/**
	 * 1399 소비자신고센터 - 신고 등록 완료
	 * @param model
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/minwon/complain/complainFinished.do")
	public String businessNotifyFinished(Model model, HttpServletRequest request, HttpServletResponse response) throws Exception {
		model.addAttribute("doc_no", StringUtil.nullToStr(request.getParameter("doc_no")));
		model.addAttribute("pswd", StringUtil.nullToStr(request.getParameter("pswd")));
		model.addAttribute("complainType", StringUtil.nullToStr(request.getParameter("complainType")));
		
		return "minwon/complain/complainFinished";
	}
	
	/**
	 * 1399 소비자신고센터 - 소비자 신고
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/minwon/complain/customerNotify.do")
	public String customerNotify(Model model) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("dvs_cd", "1");
		
		model.addAttribute("alnstCd", complainService.selectAlnstCd(map));						//이물종류 코드
		model.addAttribute("dspthWayCd", complainService.selectCmmnCdFnprt("CP07"));	//조사종결방식 코드
		model.addAttribute("rcptDvsCd", complainService.selectCmmnCdFnprt("CP08"));		//신고접수분류 코드
		model.addAttribute("viltClCd", complainService.selectCmmnCdFnprt("CP04"));			//신고접수분류 코드
		model.addAttribute("viltClDtlCd", complainService.selectCmmnCdFnprt("CP12"));		//신고접수분류 코드
		model.addAttribute("keepFlagCd", complainService.selectCmmnCdFnprt("CP11"));		//증거제품보관 코드
		model.addAttribute("dICd", complainService.selectCmmnCdFnprt("CP10"));				//국산/수입산 코드
		model.addAttribute("productPurchasePlaceCd", complainService.selectCmmnCdFnprt("CP09"));	//제품 구입 장소 구분 코드
		
		return "minwon/complain/customerNotify";
	}

	/**
	 * 1399 소비자신고센터 - 소비자 신고 등록
	 * @param complainVO
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping("/minwon/complain/saveCustomerNotify.do")
	public void saveCustomerNotify(ComplainVO complainVO, HttpServletRequest request, HttpServletResponse response) throws Exception {
		Map<String, Object> rtnMap = new HashMap<String, Object>();
		String complainExt = properties.getProperty("complain.ext");
		rtnMap = complainService.saveCustomerNotify(complainVO, complainExt);
		
		response.setContentType("text/plain; charset=\"utf-8\"");
		response.getWriter().write(new Gson().toJson(rtnMap));
	}
	
	/**
	 * 1399 소비자신고센터 - 로그인
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/minwon/complain/customerNotifyLogin.do")
	public String customerNotifyLogin() throws Exception {
		
		return "minwon/complain/customerNotifyLogin";
	}
	
	/**
	 * 1399 소비자신고센터 - 소비자 신고 진행 상태 확인
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/minwon/complain/customerNotifyView.do")
	public String customerNotifyView(Model model, HttpServletRequest request, HttpServletResponse response) throws Exception {
		ComplainVO complainVO = new ComplainVO();
		
		String docNoPrefix = complainVO.CUSTOMER_DOC_NO_PREFIX;
		String doc_no = StringUtil.nullToStr(request.getParameter("doc_no"));
		String pswd = StringUtil.nullToStr(request.getParameter("pswd"));	
		
		//문서 종류다 다르면
		if( docNoPrefix.length() > doc_no.length() || !docNoPrefix.equals(doc_no.substring(0, docNoPrefix.length())) ){
			model.addAttribute("status", "noData");
			return "minwon/complain/customerNotifyLogin";
		}
		
		String chkPswd = complainService.exisChkCustomerNotify(doc_no);
		
		//문서번호가 존재 하지 않으면
		if(chkPswd == null || "".equals(chkPswd)){
			model.addAttribute("status", "noData");
			return "minwon/complain/customerNotifyLogin";
		}
		
		//입력한 패스워드가 틀리면
		if(!chkPswd.equals(pswd)){
			model.addAttribute("status", "fail");
			return "minwon/complain/customerNotifyLogin";
			
		}else{
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("doc_no", doc_no);
			map.put("pswd", pswd);
			
			complainVO = complainService.selectCustomerNotifyResult(map);
			if( complainVO != null ){
				if(!"".equals(complainVO.getFood_type_cd())){
					model.addAttribute("foodTypeCd", complainService.getFoodtypeCd(complainVO.getFood_type_cd()));	//식품유형 코드
				}
				
				//제조원 정보
				if("1".equals(complainVO.getMakr_reg_unreg_bssh_dvs_cd())){
					model.addAttribute("makerInfo", complainService.selectRegMakerInfo(complainVO.getMakr_cd()));//등록
				}else{
					model.addAttribute("makerInfo", complainService.selectUnRegMakerInfo(complainVO.getMakr_cd()));//미등록
				}
				
				//판맨원 정보
				if(!"".equals(complainVO.getSalpr_reg_unreg_dvs_cd()) && "1".equals(complainVO.getSalpr_reg_unreg_dvs_cd())){
					model.addAttribute("salprInfo", complainService.selectRegMakerInfo(complainVO.getSalpr_cd()));//등록
				}else if((!"".equals(complainVO.getSalpr_reg_unreg_dvs_cd()) && "2".equals(complainVO.getSalpr_reg_unreg_dvs_cd()))){
					model.addAttribute("salprInfo", complainService.selectUnRegMakerInfo(complainVO.getSalpr_cd()));//미등록
				}
			}
			
			model.addAttribute("complainVO", complainVO);																			//소비자 신고 진행 상태 조회
			model.addAttribute("statusReplyList", complainService.selectCustomerNotifyResultReply(doc_no));		//소비자 신고 답변
			model.addAttribute("evdcPrdtCstdyList", complainService.selectEvdcPrdtCstdy(doc_no));					//증거 제품 보관 조회
			model.addAttribute("alnstCd", complainService.selectAlnstCd(map));												//이물코드
			model.addAttribute("atchfl", complainService.selectAtchfl(doc_no));												//첨부파일
			
			return "minwon/complain/customerNotifyView";
		}
	}
	
	
	/**
	 * 1399 소비자신고센터 - 업체이물 신고
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/minwon/complain/businessNotify.do")
	public String businessNotify(Model model) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("dvs_cd", "1");
		
		model.addAttribute("alnstCd", complainService.selectAlnstCd(map));						//이물종류 코드
		model.addAttribute("indutyDvsCd", complainService.selectCmmnCdFnprt("CP13"));	//업종
		model.addAttribute("dspthWayCd", complainService.selectCmmnCdFnprt("CP07"));	//조사종결방식 코드
		model.addAttribute("dICd", complainService.selectCmmnCdFnprt("CP10"));				//국산/수입산 코드
		model.addAttribute("keepFlagCd", complainService.selectCmmnCdFnprt("CP11"));		//증거제품보관 코드
		
		return "minwon/complain/businessNotify";
	}
	
	/**
	 * 업체 이물 신고 저장
	 * @param complainVO
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping("/minwon/complain/saveBusinessNotify.do")
	public void saveBusinessNotify(ComplainVO complainVO, HttpServletRequest request, HttpServletResponse response) throws Exception {
		Map<String, Object> rtnMap = new HashMap<String, Object>();
		String complainExt = properties.getProperty("complain.ext");
		rtnMap = complainService.saveBusinessNotify(complainVO, complainExt);
		
		response.setContentType("text/plain; charset=\"utf-8\"");
		response.getWriter().write(new Gson().toJson(rtnMap));
	}
	
	/**
	 * 업체 이물 신고 - 로그인
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/minwon/complain/businessNotifyLogin.do")
	public String businessNotifyLogin() throws Exception {
		
		return "minwon/complain/businessNotifyLogin";
	}
	
	/**
	 * 1399 소비자신고센터 - 이물신고 진행 상태 확인
	 * @param model
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/minwon/complain/businessNotifyView.do")
	public String businessNotifyView(Model model, HttpServletRequest request, HttpServletResponse response) throws Exception {
		ComplainVO complainVO = new ComplainVO();
		
		String docNoPrefix = complainVO.BUSINESS_DOC_NO_PREFIX;
		String doc_no = StringUtil.nullToStr(request.getParameter("doc_no"));
		String pswd = StringUtil.nullToStr(request.getParameter("pswd"));	
		
		//문서 종류다 다르면
		if( docNoPrefix.length() > doc_no.length() || !docNoPrefix.equals(doc_no.substring(0, docNoPrefix.length())) ){
			model.addAttribute("status", "noData");
			return "minwon/complain/businessNotifyLogin";
		}
		
		String chkPswd = complainService.exisChkBusinessNotify(doc_no);
		
		//문서번호가 존재 하지 않으면
		if(chkPswd == null || "".equals(chkPswd)){
			model.addAttribute("status", "noData");
			return "minwon/complain/businessNotifyLogin";
		}
		
		//입력한 패스워드가 틀리면
		if(!chkPswd.equals(pswd)){
			model.addAttribute("status", "fail");
			return "minwon/complain/businessNotifyLogin";
			
		}else{
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("doc_no", doc_no);
			map.put("pswd", pswd);
			
			complainVO = complainService.selectBusinessNotifyResult(map);
			
			if( complainVO != null ){
				//식품유형코드
				if(!"".equals(complainVO.getFood_type_cd())){
					model.addAttribute("foodTypeCd", complainService.getFoodtypeCd(complainVO.getFood_type_cd()));
				}
				
				//기관정보
				if(!"".equals(complainVO.getChrg_instt_cd())){
					model.addAttribute("chrgInsttCd", complainService.searchCmmnOrgn(complainVO.getChrg_instt_cd()));
				}
				
				//제조원 정보
				if("1".equals(complainVO.getMakr_reg_unreg_bssh_dvs_cd())){
					model.addAttribute("makerInfo", complainService.selectRegMakerInfo(complainVO.getMakr_cd()));//등록
				}else{
					model.addAttribute("makerInfo", complainService.selectUnRegMakerInfo(complainVO.getMakr_cd()));//미등록
				}
				
				//판맨원 정보
				if(!"".equals(complainVO.getSalpr_reg_unreg_dvs_cd()) && "1".equals(complainVO.getSalpr_reg_unreg_dvs_cd())){
					model.addAttribute("salprInfo", complainService.selectRegMakerInfo(complainVO.getSalpr_cd()));//등록
				}else if((!"".equals(complainVO.getSalpr_reg_unreg_dvs_cd()) && "2".equals(complainVO.getSalpr_reg_unreg_dvs_cd()))){
					model.addAttribute("salprInfo", complainService.selectUnRegMakerInfo(complainVO.getSalpr_cd()));//미등록
				}
			}
			
			model.addAttribute("complainVO", complainVO);																			//업체 이물 신고 진행 상태 조회
			model.addAttribute("statusReplyList", complainService.selectCustomerNotifyResultReply(doc_no));		//소비자 신고 답변
			model.addAttribute("evdcPrdtCstdyList", complainService.selectEvdcPrdtCstdy(doc_no));					//증거 제품 보관 조회
			model.addAttribute("alnstCd", complainService.selectAlnstCd(map));												//이물코드
			model.addAttribute("atchfl", complainService.selectAtchfl(doc_no));												//첨부파일
		}
		
		return "minwon/complain/businessNotifyView";
	}
	
}
