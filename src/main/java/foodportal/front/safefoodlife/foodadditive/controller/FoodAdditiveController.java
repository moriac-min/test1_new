package foodportal.front.safefoodlife.foodadditive.controller;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import common.commonfacillity.log.CommonLog;
import foodportal.front.safefoodlife.foodadditive.service.FoodAdditiveRvlvService;
import foodportal.front.safefoodlife.foodadditive.service.FoodAdditiveRvlvSpiceService;
import foodportal.front.safefoodlife.foodadditive.service.FoodAdditiveService;
import foodportal.front.safefoodlife.foodadditive.util.Utility;
import foodportal.front.safefoodlife.foodadditive.vo.FoodAdditiveBasisInfoVO;
import foodportal.front.safefoodlife.foodadditive.vo.FoodAdditiveRvlvSpiceVO;
import foodportal.front.safefoodlife.foodadditive.vo.FoodAdditiveRvlvVO;

@Controller
public class FoodAdditiveController {
	
	@CommonLog Logger log;
	
	@Autowired
	private FoodAdditiveService foodAdditiveService;
	
	@Autowired
	private FoodAdditiveRvlvService foodAdditiveRvlvService;
	
	@Autowired
	private FoodAdditiveRvlvSpiceService foodAdditiveRvlvSpiceService;
	
	@RequestMapping("/portal/safefoodlife/foodAditive/foodAdditiveBasisInfo.do")
	public String foodAdditiveBasisInfo(FoodAdditiveBasisInfoVO foodAdditiveBasisInfoVO, Model model) throws Exception {
		if (foodAdditiveBasisInfoVO == null) {
			foodAdditiveBasisInfoVO = new FoodAdditiveBasisInfoVO();
		}
		
		if (foodAdditiveBasisInfoVO.getPage() == 0) {
			foodAdditiveBasisInfoVO.setPage(1);
		}
		
		int startIdx = 30 * (foodAdditiveBasisInfoVO.getPage() - 1) + 1;
		int endIdx = startIdx + 30 - 1;
		foodAdditiveBasisInfoVO.setStartidx(startIdx);
		foodAdditiveBasisInfoVO.setEndidx(endIdx);
		
		// 페이지 구분 : 2
		if (foodAdditiveBasisInfoVO.getPage_gubun() == null) {
			foodAdditiveBasisInfoVO.setPage_gubun("2");
		}
		
		if (foodAdditiveBasisInfoVO.getProcs_cl() == null) {
			foodAdditiveBasisInfoVO.setProcs_cl("1");
		}
		
		model.addAttribute("foodAdditiveBasisInfoVO", foodAdditiveBasisInfoVO);
		
		if (StringUtils.equals(foodAdditiveBasisInfoVO.getPage_gubun(), "1") && StringUtils.equals(foodAdditiveBasisInfoVO.getProcs_cl(), "4")) {
			FoodAdditiveRvlvSpiceVO foodAdditiveRvlvSpiceVO = new FoodAdditiveRvlvSpiceVO();
			foodAdditiveRvlvSpiceVO.setPage_gubun(foodAdditiveBasisInfoVO.getPage_gubun());
			foodAdditiveRvlvSpiceVO.setProcs_cl(foodAdditiveBasisInfoVO.getProcs_cl());
			foodAdditiveRvlvSpiceVO.setPage(foodAdditiveBasisInfoVO.getPage());
			foodAdditiveRvlvSpiceVO.setOrdno(foodAdditiveBasisInfoVO.getAdtv_cd());
			foodAdditiveRvlvSpiceVO.setManage_no(foodAdditiveBasisInfoVO.getManage_no());
			foodAdditiveRvlvSpiceVO.setMttr_nm(foodAdditiveBasisInfoVO.getMttr_nm());
			foodAdditiveRvlvSpiceVO.setCfr_no(foodAdditiveBasisInfoVO.getCfr_no());
			foodAdditiveRvlvSpiceVO.setJecfa_no(foodAdditiveBasisInfoVO.getJecfa_no());
			foodAdditiveRvlvSpiceVO.setFema_no(foodAdditiveBasisInfoVO.getFema_no());
			foodAdditiveRvlvSpiceVO.setEu_fl_no(foodAdditiveBasisInfoVO.getEu_fl_no());
			foodAdditiveRvlvSpiceVO.setEu_chms_grp(foodAdditiveBasisInfoVO.getEu_chms_grp());
			foodAdditiveRvlvSpiceVO.setNcknm(foodAdditiveBasisInfoVO.getNcknm());
			foodAdditiveRvlvSpiceVO.setStartidx(foodAdditiveBasisInfoVO.getStartidx());
			foodAdditiveRvlvSpiceVO.setEndidx(foodAdditiveBasisInfoVO.getEndidx());
			foodAdditiveRvlvSpiceVO.setStartword(foodAdditiveBasisInfoVO.getStartword());
			foodAdditiveRvlvSpiceVO.setKeyfield(foodAdditiveBasisInfoVO.getKeyfield());
			foodAdditiveRvlvSpiceVO.setKey(foodAdditiveBasisInfoVO.getKey());
			
			List<FoodAdditiveRvlvSpiceVO> foodAdditiveRvlvSpiceList = foodAdditiveRvlvSpiceService.selectFoodAdditiveRvlvSpiceList(foodAdditiveRvlvSpiceVO);
			model.addAttribute("foodAdditiveBasisInfoList", foodAdditiveRvlvSpiceList);
			
			long foodAdditiveRvlvSpiceListCount = 0;
			if (foodAdditiveRvlvSpiceList != null && foodAdditiveRvlvSpiceList.size() > 0) {
				foodAdditiveRvlvSpiceListCount = foodAdditiveRvlvSpiceList.get(0).getTotalCount();
			}
			model.addAttribute("foodAdditiveBasisInfoListCount", foodAdditiveRvlvSpiceListCount);
		}
		else {
			List<FoodAdditiveBasisInfoVO> foodAdditiveBasisInfoList = foodAdditiveService.selectFoodAdditiveBasisInfoList(foodAdditiveBasisInfoVO);
			model.addAttribute("foodAdditiveBasisInfoList", foodAdditiveBasisInfoList);
			
			long foodAdditiveBasisInfoListCount = 0;
			if (foodAdditiveBasisInfoList != null && foodAdditiveBasisInfoList.size() > 0) {
				foodAdditiveBasisInfoListCount = foodAdditiveBasisInfoList.get(0).getTotalCount();
			}
			model.addAttribute("foodAdditiveBasisInfoListCount", foodAdditiveBasisInfoListCount);
			
		}
		
		return "portal/safefoodlife/foodadditive/foodAdditiveBasisInfo";
	}
	
	@RequestMapping("/portal/safefoodlife/foodAditive/foodAdditiveBasisInfoDetail.do")
	public String foodAdditiveBasisInfoDetail(FoodAdditiveBasisInfoVO foodAdditiveBasisInfoVO, Model model) throws Exception {
		if (foodAdditiveBasisInfoVO == null) {
			foodAdditiveBasisInfoVO = new FoodAdditiveBasisInfoVO();
		}
		model.addAttribute("foodAdditiveBasisInfoVO", foodAdditiveBasisInfoVO);
		
		// 전체 첨가물 코드 조회
		FoodAdditiveBasisInfoVO foodAdditiveTotalSerial = null;
		if (!(StringUtils.equals(foodAdditiveBasisInfoVO.getPage_gubun(), "1") && StringUtils.equals(foodAdditiveBasisInfoVO.getProcs_cl(), "4"))) {
			foodAdditiveTotalSerial = foodAdditiveService.selectFoodAdditiveTotalSerial(foodAdditiveBasisInfoVO);
		}
		model.addAttribute("foodAdditiveTotalSerial", foodAdditiveTotalSerial);
		
		// 식품첨가물공전
		if (StringUtils.equals(foodAdditiveBasisInfoVO.getPage_gubun(), "1")) {
			if (StringUtils.equals(foodAdditiveBasisInfoVO.getProcs_cl(), "4")) {
				FoodAdditiveRvlvSpiceVO foodAdditiveRvlvSpiceVO = new FoodAdditiveRvlvSpiceVO();
				foodAdditiveRvlvSpiceVO.setOrdno(foodAdditiveBasisInfoVO.getAdtv_cd());
				FoodAdditiveRvlvSpiceVO foodAdditiveBasisInfoDetail = foodAdditiveRvlvSpiceService.selectFoodAdditiveRvlvSpiceDetail(foodAdditiveRvlvSpiceVO);
				model.addAttribute("foodAdditiveBasisInfoDetail", foodAdditiveBasisInfoDetail);
			}
			else {
				FoodAdditiveBasisInfoVO foodAdditiveBasisInfoDetail = foodAdditiveService.selectFoodAdditiveBasisInfoDetail(foodAdditiveBasisInfoVO);
				model.addAttribute("foodAdditiveBasisInfoDetail", foodAdditiveBasisInfoDetail);
			}
		}
		// 품목별 기본정보
		else if (StringUtils.equals(foodAdditiveBasisInfoVO.getPage_gubun(), "2")) {
			FoodAdditiveBasisInfoVO foodAdditiveBasisInfoDetail = foodAdditiveService.selectFoodAdditiveBasisInfoDetail2(foodAdditiveBasisInfoVO);
			model.addAttribute("foodAdditiveBasisInfoDetail", foodAdditiveBasisInfoDetail);
			
			List<FoodAdditiveBasisInfoVO> foodAdditiveBasisInfoReformHistoryList = foodAdditiveService.selectFoodAdditiveBasisInfoReformHistoryList(foodAdditiveBasisInfoVO);
			model.addAttribute("foodAdditiveBasisInfoReformHistoryList", foodAdditiveBasisInfoReformHistoryList);
		}
		// JECFA
		else if (StringUtils.equals(foodAdditiveBasisInfoVO.getPage_gubun(), "3")) {
			FoodAdditiveBasisInfoVO foodAdditiveBasisInfoDetail = foodAdditiveService.selectFoodAdditiveBasisInfoDetail3(foodAdditiveBasisInfoVO);
			model.addAttribute("foodAdditiveBasisInfoDetail", foodAdditiveBasisInfoDetail);
		}
		// 미국
		else if (StringUtils.equals(foodAdditiveBasisInfoVO.getPage_gubun(), "4")) {
			FoodAdditiveBasisInfoVO foodAdditiveBasisInfoDetail = foodAdditiveService.selectFoodAdditiveBasisInfoDetail4(foodAdditiveBasisInfoVO);
			model.addAttribute("foodAdditiveBasisInfoDetail", foodAdditiveBasisInfoDetail);
			
			List<FoodAdditiveBasisInfoVO> cfrUseStandardList = foodAdditiveService.selectFoodAdditiveBasisInfoCfrUseStandardList(foodAdditiveBasisInfoVO);
			model.addAttribute("cfrUseStandardList", cfrUseStandardList);
		}
		// EU
		else if (StringUtils.equals(foodAdditiveBasisInfoVO.getPage_gubun(), "5")) {
			FoodAdditiveBasisInfoVO foodAdditiveBasisInfoDetail = foodAdditiveService.selectFoodAdditiveBasisInfoDetail5(foodAdditiveBasisInfoVO);
			model.addAttribute("foodAdditiveBasisInfoDetail", foodAdditiveBasisInfoDetail);
		}
		// CODEX
		else if (StringUtils.equals(foodAdditiveBasisInfoVO.getPage_gubun(), "6")) {
			FoodAdditiveBasisInfoVO foodAdditiveBasisInfoDetail = foodAdditiveService.selectFoodAdditiveBasisInfoDetail6(foodAdditiveBasisInfoVO);
			model.addAttribute("foodAdditiveBasisInfoDetail", foodAdditiveBasisInfoDetail);
			
			List<FoodAdditiveBasisInfoVO> codexUseStandardList = foodAdditiveService.selectFoodAdditiveBasisInfoCodexUseStandardList(foodAdditiveBasisInfoVO);
			model.addAttribute("codexUseStandardList", codexUseStandardList);
		}
		// 일본공정서
		else if (StringUtils.equals(foodAdditiveBasisInfoVO.getPage_gubun(), "7")) {
			FoodAdditiveBasisInfoVO foodAdditiveBasisInfoDetail = foodAdditiveService.selectFoodAdditiveBasisInfoDetail7(foodAdditiveBasisInfoVO);
			model.addAttribute("foodAdditiveBasisInfoDetail", foodAdditiveBasisInfoDetail);
		}
		
		return "portal/safefoodlife/foodadditive/foodAdditiveBasisInfoDetail";
	}
	
	@RequestMapping("/portal/safefoodlife/foodAditive/foodAdditiveRvlv.do")
	public String foodAdditiveRvlv(FoodAdditiveRvlvVO foodAdditiveRvlvVO, Model model) throws Exception {
		if (foodAdditiveRvlvVO == null) {
			foodAdditiveRvlvVO = new FoodAdditiveRvlvVO();
		}
		
		if (foodAdditiveRvlvVO.getCom_serial() > 0 && foodAdditiveRvlvVO.getOrdno() < 1) {
			foodAdditiveRvlvVO.setOrdno(foodAdditiveRvlvVO.getCom_serial());
		}
		model.addAttribute("foodAdditiveRvlvVO", foodAdditiveRvlvVO);
		
		if (Utility.isNull(foodAdditiveRvlvVO.getProcs_cl()) && foodAdditiveRvlvVO.getOrdno() > 0) {
			FoodAdditiveRvlvVO foodAdditiveRvlvDetail = foodAdditiveRvlvService.selectFoodAdditiveRvlvDetail(foodAdditiveRvlvVO);
			model.addAttribute("foodAdditiveRvlvDetail", foodAdditiveRvlvDetail);
		}
		else if (!Utility.isNull(foodAdditiveRvlvVO.getProcs_cl()) && foodAdditiveRvlvVO.getAdtv_cd() > 0) {
			model.addAttribute("mode", "view");
			
			FoodAdditiveBasisInfoVO foodAdditiveBasisInfoVO = new FoodAdditiveBasisInfoVO();
			foodAdditiveBasisInfoVO.setPage_gubun(foodAdditiveRvlvVO.getPage_gubun());
			foodAdditiveBasisInfoVO.setProcs_cl(foodAdditiveRvlvVO.getProcs_cl());
			foodAdditiveBasisInfoVO.setPage(foodAdditiveRvlvVO.getPage());
			foodAdditiveBasisInfoVO.setKeyfield(foodAdditiveRvlvVO.getKeyfield());
			foodAdditiveBasisInfoVO.setKey(foodAdditiveRvlvVO.getKey());
			foodAdditiveBasisInfoVO.setAdtv_cd(foodAdditiveRvlvVO.getAdtv_cd());
			
			foodAdditiveBasisInfoDetail(foodAdditiveBasisInfoVO, model);
		}
		else {
			FoodAdditiveBasisInfoVO foodAdditiveBasisInfoVO = new FoodAdditiveBasisInfoVO();
			foodAdditiveBasisInfoVO.setPage_gubun(foodAdditiveRvlvVO.getPage_gubun());
			foodAdditiveBasisInfoVO.setProcs_cl(foodAdditiveRvlvVO.getProcs_cl());
			foodAdditiveBasisInfoVO.setPage(foodAdditiveRvlvVO.getPage());
			foodAdditiveBasisInfoVO.setKeyfield(foodAdditiveRvlvVO.getKeyfield());
			foodAdditiveBasisInfoVO.setKey(foodAdditiveRvlvVO.getKey());
			foodAdditiveBasisInfoVO.setAdtv_cd(foodAdditiveRvlvVO.getAdtv_cd());
			foodAdditiveBasisInfoVO.setManage_no(foodAdditiveRvlvVO.getManage_no());
			foodAdditiveBasisInfoVO.setMttr_nm(foodAdditiveRvlvVO.getMttr_nm());
			foodAdditiveBasisInfoVO.setCfr_no(foodAdditiveRvlvVO.getCfr_no());
			foodAdditiveBasisInfoVO.setJecfa_no(foodAdditiveRvlvVO.getJecfa_no());
			foodAdditiveBasisInfoVO.setFema_no(foodAdditiveRvlvVO.getFema_no());
			foodAdditiveBasisInfoVO.setEu_fl_no(foodAdditiveRvlvVO.getEu_fl_no());
			foodAdditiveBasisInfoVO.setEu_chms_grp(foodAdditiveRvlvVO.getEu_chms_grp());
			foodAdditiveBasisInfoVO.setNcknm(foodAdditiveRvlvVO.getNcknm());
			foodAdditiveBasisInfoVO.setStartidx(foodAdditiveRvlvVO.getStartidx());
			foodAdditiveBasisInfoVO.setEndidx(foodAdditiveRvlvVO.getEndidx());
			foodAdditiveBasisInfoVO.setStartword(foodAdditiveRvlvVO.getStartword());
			
			foodAdditiveBasisInfo(foodAdditiveBasisInfoVO, model);
		}
		
		return "portal/safefoodlife/foodadditive/foodAdditiveRvlv";
	}
	
}
