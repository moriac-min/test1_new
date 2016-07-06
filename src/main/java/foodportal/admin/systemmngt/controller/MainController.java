package foodportal.admin.systemmngt.controller;

import java.util.List;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import websquare.system.adapter.annotation.BEAN_DEF;

import common.commonfacillity.log.CommonLog;
import common.commonfacillity.uia.WqBaseBean;
import common.commonfacillity.uia.WqResultBean;

import foodportal.admin.systemmngt.service.MainService;
import foodportal.admin.systemmngt.vo.AdminSystemmngtRootVO;
import foodportal.admin.systemmngt.vo.BannerVO;
import foodportal.admin.systemmngt.vo.FoodLifeVO;
import foodportal.admin.systemmngt.vo.IssueVO;
import foodportal.admin.systemmngt.vo.LifeCycleVO;

/**
 * MainController
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

@Controller 
public class MainController {

	@CommonLog Logger log;
	@Autowired
	private MainService mainService;
	
	/**
	 * 이슈발생시 관리 조회
	 * 
	 * @param
	 * @return ModelAndView
	 * @throws Exception
	 */
	@RequestMapping(value = "/admin/systemmngt/selectIssue.do")
	@BEAN_DEF(beans={"root=foodportal.admin.systemmngt.vo.AdminSystemmngtRootVO", "paramIssueVO=foodportal.admin.systemmngt.vo.IssueVO", "issueVO=foodportal.admin.systemmngt.vo.IssueVO"})
	public ModelAndView selectIssue(WqBaseBean ibean) throws Exception {
		ModelAndView mav = new ModelAndView("wqView");
		
		AdminSystemmngtRootVO adminSystemmngtRootVO = new AdminSystemmngtRootVO();
		IssueVO issueVO = mainService.selectIssue(ibean);
		
		adminSystemmngtRootVO.setIssueVO(issueVO);
		mav.addObject("result", adminSystemmngtRootVO);
		
		return mav;
	}
	
	/**
	 * 이슈발생시 관리 저장
	 * 
	 * @param
	 * @return ModelAndView
	 * @throws Exception
	 */
	@RequestMapping(value = "/admin/systemmngt/saveIssue.do")
	@BEAN_DEF(beans={"root=foodportal.admin.systemmngt.vo.AdminSystemmngtRootVO"
			, "paramIssueVO=foodportal.admin.systemmngt.vo.IssueVO"
			, "issueVO=foodportal.admin.systemmngt.vo.IssueVO"
			, "resultIssueVO=foodportal.admin.systemmngt.vo.IssueVO"})
	public ModelAndView saveIssue(WqBaseBean ibean) throws Exception {
		ModelAndView mav = new ModelAndView("wqView");
		WqResultBean rtnResult = new WqResultBean();
		
		AdminSystemmngtRootVO adminSystemmngtRootVO = new AdminSystemmngtRootVO();
		IssueVO issueVO = null;
		
		int result = mainService.saveIssue(ibean);
		
		if(result == 1){
			rtnResult.setResult("정상적으로 저장되었습니다.");
			issueVO = mainService.selectIssue(ibean);
		} else {
			rtnResult.setResult("저장에 문제가 발생하였습니다.");
		}

		adminSystemmngtRootVO.setWqResultBean(rtnResult);
		adminSystemmngtRootVO.setIssueVO(issueVO);

		mav.addObject("result", adminSystemmngtRootVO);
		
		return mav;
	}
	
	/**
	 * 서비스 배너 정보 조회
	 * 
	 * @param
	 * @return ModelAndView
	 * @throws Exception
	 */
	@RequestMapping(value = "/admin/systemmngt/selectServiceBannerList.do")
	@BEAN_DEF(beans={"root=foodportal.admin.systemmngt.vo.AdminSystemmngtRootVO", "paramBannerVO=foodportal.admin.systemmngt.vo.BannerVO", "bannerList=foodportal.admin.systemmngt.vo.BannerVO"})
	public ModelAndView selectServiceBannerList(WqBaseBean ibean) throws Exception {
		ModelAndView mav = new ModelAndView("wqView");
		
		AdminSystemmngtRootVO adminSystemmngtRootVO = new AdminSystemmngtRootVO();
		List<BannerVO> serviceBannerList = mainService.selectServiceBannerList(ibean);
		
		adminSystemmngtRootVO.setBannerList(serviceBannerList);
		mav.addObject("result", adminSystemmngtRootVO);
		
		return mav;
	}
	
	/**
	 * 서비스 배너 정보 저장
	 * 
	 * @param
	 * @return ModelAndView
	 * @throws Exception
	 */
	@RequestMapping(value = "/admin/systemmngt/saveServiceBanner.do")
	@BEAN_DEF(beans={"root=foodportal.admin.systemmngt.vo.AdminSystemmngtRootVO"
			, "paramBannerList=foodportal.admin.systemmngt.vo.BannerVO"
			, "paramRmBannerList=foodportal.admin.systemmngt.vo.BannerVO"
			, "paramBannerVO=foodportal.admin.systemmngt.vo.BannerVO"
			, "bannerList=foodportal.admin.systemmngt.vo.BannerVO"})
	public ModelAndView saveServiceBanner(WqBaseBean ibean) throws Exception {
		ModelAndView mav = new ModelAndView("wqView");
		WqResultBean rtnResult = new WqResultBean();
		
		AdminSystemmngtRootVO adminSystemmngtRootVO = new AdminSystemmngtRootVO();
		List<BannerVO> bannerList = null;
		
		int result = mainService.saveServiceBanner(ibean);
		
		if(result == 1){
			rtnResult.setResult("정상적으로 저장되었습니다.");
			bannerList = mainService.selectServiceBannerList(ibean);
		} else {
			rtnResult.setResult("저장에 문제가 발생하였습니다.");
		}
		
		adminSystemmngtRootVO.setWqResultBean(rtnResult);
		adminSystemmngtRootVO.setBannerList(bannerList);
		
		mav.addObject("result", adminSystemmngtRootVO);
		
		return mav;
	}
	
	/**
	 * 링크 배너 정보 조회
	 * 
	 * @param
	 * @return ModelAndView
	 * @throws Exception
	 */
	@RequestMapping(value = "/admin/systemmngt/selectLinkBannerList.do")
	@BEAN_DEF(beans={"root=foodportal.admin.systemmngt.vo.AdminSystemmngtRootVO", "paramBannerVO=foodportal.admin.systemmngt.vo.BannerVO", "bannerList=foodportal.admin.systemmngt.vo.BannerVO"})
	public ModelAndView selectLinkBannerList(WqBaseBean ibean) throws Exception {
		ModelAndView mav = new ModelAndView("wqView");
		
		AdminSystemmngtRootVO adminSystemmngtRootVO = new AdminSystemmngtRootVO();
		List<BannerVO> bannerList = mainService.selectCommonBannerList(ibean);
		
		adminSystemmngtRootVO.setBannerList(bannerList);
		mav.addObject("result", adminSystemmngtRootVO);
		
		return mav;
	}
	
	/**
	 * 링크 배너 정보 저장
	 * 
	 * @param
	 * @return ModelAndView
	 * @throws Exception
	 */
	@RequestMapping(value = "/admin/systemmngt/saveLinkBanner.do")
	@BEAN_DEF(beans={"root=foodportal.admin.systemmngt.vo.AdminSystemmngtRootVO"
			, "paramBannerList=foodportal.admin.systemmngt.vo.BannerVO"
			, "paramRmBannerList=foodportal.admin.systemmngt.vo.BannerVO"
			, "paramBannerVO=foodportal.admin.systemmngt.vo.BannerVO"
			, "bannerList=foodportal.admin.systemmngt.vo.BannerVO"})
	public ModelAndView saveLinkBanner(WqBaseBean ibean) throws Exception {
		ModelAndView mav = new ModelAndView("wqView");
		WqResultBean rtnResult = new WqResultBean();
		
		AdminSystemmngtRootVO adminSystemmngtRootVO = new AdminSystemmngtRootVO();
		List<BannerVO> bannerList = null;
		
		int result = mainService.saveCommonBanner(ibean);
		
		if(result == 1){
			rtnResult.setResult("정상적으로 저장되었습니다.");
			bannerList = mainService.selectCommonBannerList(ibean);
		} else {
			rtnResult.setResult("저장에 문제가 발생하였습니다.");
		}
		
		adminSystemmngtRootVO.setWqResultBean(rtnResult);
		adminSystemmngtRootVO.setBannerList(bannerList);
		
		mav.addObject("result", adminSystemmngtRootVO);
		
		return mav;
		
	}
	
	/**
	 * 이슈발생시 관리 조회
	 * 
	 * @param
	 * @return ModelAndView
	 * @throws Exception
	 */
	@RequestMapping(value = "/admin/systemmngt/selectLifeCycleInfo.do")
	@BEAN_DEF(beans={"root=foodportal.admin.systemmngt.vo.AdminSystemmngtRootVO", "paramLifeCycleVO=foodportal.admin.systemmngt.vo.LifeCycleVO", "lifeCycleVO=foodportal.admin.systemmngt.vo.LifeCycleVO"})
	public ModelAndView selectLifeCycleInfo(WqBaseBean ibean) throws Exception {
		ModelAndView mav = new ModelAndView("wqView");
		
		AdminSystemmngtRootVO adminSystemmngtRootVO = new AdminSystemmngtRootVO();
		LifeCycleVO lifeCycleVO = mainService.selectLifeCycleInfo(ibean);
		
		adminSystemmngtRootVO.setLifeCycleVO(lifeCycleVO);
		mav.addObject("result", adminSystemmngtRootVO);
		
		return mav;
	}
	
	/**
	 * 생애주기별 정보 관리 저장
	 * 
	 * @param
	 * @return ModelAndView
	 * @throws Exception
	 */
	@RequestMapping(value = "/admin/systemmngt/saveLifeCycle.do")
	@BEAN_DEF(beans={"root=foodportal.admin.systemmngt.vo.AdminSystemmngtRootVO", "paramLifeCycleVO=foodportal.admin.systemmngt.vo.LifeCycleVO", "lifeCycleVO=foodportal.admin.systemmngt.vo.LifeCycleVO"})
	public ModelAndView saveLifeCycle(WqBaseBean ibean) throws Exception {
		ModelAndView mav = new ModelAndView("wqView");
		WqResultBean rtnResult = new WqResultBean();
		
		AdminSystemmngtRootVO adminSystemmngtRootVO = new AdminSystemmngtRootVO();
		LifeCycleVO lifeCycleVO = null;
		
		int result = mainService.saveLifeCycle(ibean);
		
		if(result == 1){
			rtnResult.setResult("정상적으로 저장되었습니다.");
			lifeCycleVO = mainService.selectLifeCycleInfo(ibean);
		}else{
			rtnResult.setResult("저장에 문제가 발생하였습니다.");
		}
		
		adminSystemmngtRootVO.setWqResultBean(rtnResult);
		adminSystemmngtRootVO.setLifeCycleVO(lifeCycleVO);
		
		mav.addObject("result", adminSystemmngtRootVO);
		
		return mav;
		
	}
	
	/**
	 * 식생활 메뉴 목록 조회
	 * 
	 * @param
	 * @return ModelAndView
	 * @throws Exception
	 */
	@RequestMapping(value = "/admin/systemmngt/selectFoodLifeMenuList.do")
	@BEAN_DEF(beans={"root=foodportal.admin.systemmngt.vo.AdminSystemmngtRootVO", "paramFoodLifeVO=foodportal.admin.systemmngt.vo.FoodLifeVO", "foodLifeList=foodportal.admin.systemmngt.vo.FoodLifeVO"})
	public ModelAndView selectFoodLifeMenuList(WqBaseBean ibean) throws Exception {
		ModelAndView mav = new ModelAndView("wqView");
		
		AdminSystemmngtRootVO adminSystemmngtRootVO = new AdminSystemmngtRootVO();
		List<FoodLifeVO> foodLifeList = mainService.selectFoodLifeMenuList(ibean);
		
		adminSystemmngtRootVO.setFoodLifeList(foodLifeList);
		mav.addObject("result", adminSystemmngtRootVO);
		
		return mav;
		
	}
	
	/**
	 * 식생활 메뉴 정보 조회
	 * 
	 * @param
	 * @return ModelAndView
	 * @throws Exception
	 */
	@RequestMapping(value = "/admin/systemmngt/selectFoodLifeLinkInfo.do")
	@BEAN_DEF(beans={"root=foodportal.admin.systemmngt.vo.AdminSystemmngtRootVO", "paramFoodLifeVO=foodportal.admin.systemmngt.vo.FoodLifeVO", "foodLifeVO=foodportal.admin.systemmngt.vo.FoodLifeVO"})
	public ModelAndView selectFoodLifeLinkInfo(WqBaseBean ibean) throws Exception {
		ModelAndView mav = new ModelAndView("wqView");
		
		AdminSystemmngtRootVO adminSystemmngtRootVO = new AdminSystemmngtRootVO();
		FoodLifeVO foodLifeVO = mainService.selectFoodLifeLinkInfo(ibean);
		
		adminSystemmngtRootVO.setFoodLifeVO(foodLifeVO);
		mav.addObject("result", adminSystemmngtRootVO);
		
		return mav;
		
	}
	
	/**
	 * 식생활 메뉴 목록별 게시글 조회
	 * @param ibean
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/admin/systemmngt/selectFoodLifeBbsList.do")
	@BEAN_DEF(beans={"root=foodportal.admin.systemmngt.vo.AdminSystemmngtRootVO", "paramFoodLifeVO=foodportal.admin.systemmngt.vo.FoodLifeVO", "foodLifeList=foodportal.admin.systemmngt.vo.FoodLifeVO"})
	public ModelAndView selectFoodLifeBbsList(WqBaseBean ibean) throws Exception {
		ModelAndView mav = new ModelAndView("wqView");
		
		AdminSystemmngtRootVO adminSystemmngtRootVO = new AdminSystemmngtRootVO();
		List<FoodLifeVO> foodLifeList = mainService.selectFoodLifeBbsList(ibean);
		
		adminSystemmngtRootVO.setFoodLifeList(foodLifeList);
		mav.addObject("result", adminSystemmngtRootVO);
		
		return mav;
	}
	
	/**
	 * 식생활 메뉴 연결 게시글 조회
	 * @param ibean
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/admin/systemmngt/selectFoodLifeLinkBbsInfo.do")
	@BEAN_DEF(beans={"root=foodportal.admin.systemmngt.vo.AdminSystemmngtRootVO", "paramFoodLifeVO=foodportal.admin.systemmngt.vo.FoodLifeVO", "foodLifeVO=foodportal.admin.systemmngt.vo.FoodLifeVO"})
	public ModelAndView selectFoodLifeLinkBbsInfo(WqBaseBean ibean) throws Exception {
		ModelAndView mav = new ModelAndView("wqView");
		
		AdminSystemmngtRootVO adminSystemmngtRootVO = new AdminSystemmngtRootVO();
		FoodLifeVO foodLifeVO = mainService.selectFoodLifeLinkBbsInfo(ibean);
		
		adminSystemmngtRootVO.setFoodLifeVO(foodLifeVO);
		mav.addObject("result", adminSystemmngtRootVO);
		
		return mav;
	}
	
	/**
	 * 식생활 게시글 연결 저장
	 * @param ibean
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/admin/systemmngt/saveFoodLife.do")
	@BEAN_DEF(beans={"root=foodportal.admin.systemmngt.vo.AdminSystemmngtRootVO", "paramFoodLifeVO=foodportal.admin.systemmngt.vo.FoodLifeVO"})
	public ModelAndView saveFoodLife(WqBaseBean ibean) throws Exception {
		ModelAndView mav = new ModelAndView("wqView");
		WqResultBean rtnResult = new WqResultBean();
		
		AdminSystemmngtRootVO adminSystemmngtRootVO = new AdminSystemmngtRootVO();
		
		int result = mainService.saveFoodLife(ibean);
		
		if(result == 1){
			rtnResult.setResult("정상적으로 저장되었습니다.");
		}else{
			rtnResult.setResult("저장에 문제가 발생하였습니다.");
		}
		
		adminSystemmngtRootVO.setWqResultBean(rtnResult);
		
		mav.addObject("result", adminSystemmngtRootVO);
		
		return mav;
	}
	
	/**
	 * 식생활 게시글 삭제
	 * @param ibean
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/admin/systemmngt/deleteNtctxt.do")
	@BEAN_DEF(beans={"root=foodportal.admin.systemmngt.vo.AdminSystemmngtRootVO", "paramFoodLifeVO=foodportal.admin.systemmngt.vo.FoodLifeVO", "foodLifeVO=foodportal.admin.systemmngt.vo.FoodLifeVO"})
	public ModelAndView deleteNtctxt(WqBaseBean ibean) throws Exception {
		ModelAndView mav = new ModelAndView("wqView");
		WqResultBean rtnResult = new WqResultBean();
		
		AdminSystemmngtRootVO adminSystemmngtRootVO = new AdminSystemmngtRootVO();
		FoodLifeVO foodLifeVO = null;
		
		int result = mainService.deleteFoodLife(ibean);
		
		if(result == 1){
			rtnResult.setResult("정상적으로 삭제되었습니다.");
			foodLifeVO = mainService.selectFoodLifeLinkInfo(ibean);
		}else{
			rtnResult.setResult("삭제하는중 문제가 발생하였습니다.");
		}
		
		adminSystemmngtRootVO.setWqResultBean(rtnResult);
		adminSystemmngtRootVO.setFoodLifeVO(foodLifeVO);
		
		mav.addObject("result", adminSystemmngtRootVO);
		
		return mav;
	}
	
	/**
	 * 게시판 컨텐츠 영역 리스트 조회
	 * 
	 * @param
	 * @return ModelAndView
	 * @throws Exception
	 */
	@RequestMapping(value = "/admin/systemmngt/selectBbsRelmList.do")
	@BEAN_DEF(beans={"root=foodportal.admin.systemmngt.vo.AdminSystemmngtRootVO", "paramBannerVO=foodportal.admin.systemmngt.vo.BannerVO", "bannerList=foodportal.admin.systemmngt.vo.BannerVO"})
	public ModelAndView selectBbsRelmList(WqBaseBean ibean) throws Exception {
		ModelAndView mav = new ModelAndView("wqView");
		
		AdminSystemmngtRootVO adminSystemmngtRootVO = new AdminSystemmngtRootVO();
		List<BannerVO> bannerList = mainService.selectCommonBannerList(ibean);
		
		adminSystemmngtRootVO.setBannerList(bannerList);
		mav.addObject("result", adminSystemmngtRootVO);
		
		return mav;
	}
	
	/**
	 * 게시판 컨텐츠 영역 정보 저장
	 * 
	 * @param
	 * @return ModelAndView
	 * @throws Exception
	 */
	@RequestMapping(value = "/admin/systemmngt/saveBbsRelm.do")
	@BEAN_DEF(beans={"root=foodportal.admin.systemmngt.vo.AdminSystemmngtRootVO"
			, "paramBannerList=foodportal.admin.systemmngt.vo.BannerVO"
			, "paramRmBannerList=foodportal.admin.systemmngt.vo.BannerVO"
			, "paramBannerVO=foodportal.admin.systemmngt.vo.BannerVO"
			, "bannerList=foodportal.admin.systemmngt.vo.BannerVO"})
	public ModelAndView saveBbsRelm(WqBaseBean ibean) throws Exception {
		ModelAndView mav = new ModelAndView("wqView");
		WqResultBean rtnResult = new WqResultBean();
		
		AdminSystemmngtRootVO adminSystemmngtRootVO = new AdminSystemmngtRootVO();
		List<BannerVO> bannerList = null;
		
		int result = mainService.saveCommonBanner(ibean);
		
		if(result == 1){
			rtnResult.setResult("정상적으로 저장되었습니다.");
			bannerList = mainService.selectCommonBannerList(ibean);
		} else {
			rtnResult.setResult("저장에 문제가 발생하였습니다.");
		}
		
		adminSystemmngtRootVO.setWqResultBean(rtnResult);
		adminSystemmngtRootVO.setBannerList(bannerList);
		
		mav.addObject("result", adminSystemmngtRootVO);
		
		return mav;
		
	}
	
	/**
	 * 네티즌 레시피 배너 리스트 조회
	 * 
	 * @param
	 * @return ModelAndView
	 * @throws Exception
	 */
	@RequestMapping(value = "/admin/systemmngt/selectRecipeBannerList.do")
	@BEAN_DEF(beans={"root=foodportal.admin.systemmngt.vo.AdminSystemmngtRootVO", "paramBannerVO=foodportal.admin.systemmngt.vo.BannerVO", "bannerList=foodportal.admin.systemmngt.vo.BannerVO"})
	public ModelAndView selectRecipeBannerList(WqBaseBean ibean) throws Exception {
		ModelAndView mav = new ModelAndView("wqView");
		
		AdminSystemmngtRootVO adminSystemmngtRootVO = new AdminSystemmngtRootVO();
		List<BannerVO> bannerList = mainService.selectCommonBannerList(ibean);
		
		adminSystemmngtRootVO.setBannerList(bannerList);
		mav.addObject("result", adminSystemmngtRootVO);
		
		return mav;
	}
	
	/**
	 * 네티즌 레시피 배너 정보 저장
	 * 
	 * @param
	 * @return ModelAndView
	 * @throws Exception
	 */
	@RequestMapping(value = "/admin/systemmngt/saveRecipeBanner.do")
	@BEAN_DEF(beans={"root=foodportal.admin.systemmngt.vo.AdminSystemmngtRootVO"
			, "paramBannerList=foodportal.admin.systemmngt.vo.BannerVO"
			, "paramRmBannerList=foodportal.admin.systemmngt.vo.BannerVO"
			, "paramBannerVO=foodportal.admin.systemmngt.vo.BannerVO"
			, "bannerList=foodportal.admin.systemmngt.vo.BannerVO"})
	public ModelAndView saveRecipeBanner(WqBaseBean ibean) throws Exception {
		ModelAndView mav = new ModelAndView("wqView");
		WqResultBean rtnResult = new WqResultBean();
		
		AdminSystemmngtRootVO adminSystemmngtRootVO = new AdminSystemmngtRootVO();
		List<BannerVO> bannerList = null;
		
		int result = mainService.saveCommonBanner(ibean);
		
		if(result == 1){
			rtnResult.setResult("정상적으로 저장되었습니다.");
			bannerList = mainService.selectCommonBannerList(ibean);
		} else {
			rtnResult.setResult("저장에 문제가 발생하였습니다.");
		}
		
		adminSystemmngtRootVO.setWqResultBean(rtnResult);
		adminSystemmngtRootVO.setBannerList(bannerList);
		
		mav.addObject("result", adminSystemmngtRootVO);
		
		return mav;
		
	}
	
	/**
	 * 열린마루 배너 정보 조회
	 * 
	 * @param
	 * @return ModelAndView
	 * @throws Exception
	 */
	@RequestMapping(value = "/admin/systemmngt/selectEbookInfo.do")
	@BEAN_DEF(beans={"root=foodportal.admin.systemmngt.vo.AdminSystemmngtRootVO", "paramBannerVO=foodportal.admin.systemmngt.vo.BannerVO", "bannerVO=foodportal.admin.systemmngt.vo.BannerVO"})
	public ModelAndView selectEbookInfo(WqBaseBean ibean) throws Exception {
		ModelAndView mav = new ModelAndView("wqView");
		
		AdminSystemmngtRootVO adminSystemmngtRootVO = new AdminSystemmngtRootVO();
		BannerVO bannerVO = mainService.selectCommonBannerInfo(ibean);
		
		adminSystemmngtRootVO.setBannerVO(bannerVO);;
		mav.addObject("result", adminSystemmngtRootVO);
		
		return mav;
	}
	
	/**
	 * 열린마루 배너 정보 저장
	 * 
	 * @param
	 * @return ModelAndView
	 * @throws Exception
	 */
	@RequestMapping(value = "/admin/systemmngt/saveEbookBanner.do")
	@BEAN_DEF(beans={"root=foodportal.admin.systemmngt.vo.AdminSystemmngtRootVO", "paramBannerVO=foodportal.admin.systemmngt.vo.BannerVO", "bannerVO=foodportal.admin.systemmngt.vo.BannerVO"})
	public ModelAndView saveEbookBanner(WqBaseBean ibean) throws Exception {
		ModelAndView mav = new ModelAndView("wqView");
		WqResultBean rtnResult = new WqResultBean();
		
		AdminSystemmngtRootVO adminSystemmngtRootVO = new AdminSystemmngtRootVO();
		BannerVO bannerVO = null;
		
		int result = mainService.saveCommonBannerInfo(ibean);
		
		if(result == 1){
			rtnResult.setResult("정상적으로 저장되었습니다.");
			bannerVO = mainService.selectCommonBannerInfo(ibean);
		} else {
			rtnResult.setResult("저장에 문제가 발생하였습니다.");
		}
		
		adminSystemmngtRootVO.setWqResultBean(rtnResult);
		adminSystemmngtRootVO.setBannerVO(bannerVO);
		
		mav.addObject("result", adminSystemmngtRootVO);
		
		return mav;
		
	}
	
	/**
	 * 비디오 배너 정보 조회
	 * 
	 * @param
	 * @return ModelAndView
	 * @throws Exception
	 */
	@RequestMapping(value = "/admin/systemmngt/selectVideoBannerInfo.do")
	@BEAN_DEF(beans={"root=foodportal.admin.systemmngt.vo.AdminSystemmngtRootVO", "paramBannerVO=foodportal.admin.systemmngt.vo.BannerVO", "bannerVO=foodportal.admin.systemmngt.vo.BannerVO"})
	public ModelAndView selectVideoBannerInfo(WqBaseBean ibean) throws Exception {
		ModelAndView mav = new ModelAndView("wqView");
		
		AdminSystemmngtRootVO adminSystemmngtRootVO = new AdminSystemmngtRootVO();
		BannerVO bannerVO = mainService.selectCommonBannerInfo(ibean);
		
		adminSystemmngtRootVO.setBannerVO(bannerVO);;
		mav.addObject("result", adminSystemmngtRootVO);
		
		return mav;
	}
	
	/**
	 * 비디오 배너 정보 저장
	 * 
	 * @param
	 * @return ModelAndView
	 * @throws Exception
	 */
	@RequestMapping(value = "/admin/systemmngt/saveVideoBanner.do")
	@BEAN_DEF(beans={"root=foodportal.admin.systemmngt.vo.AdminSystemmngtRootVO", "paramBannerVO=foodportal.admin.systemmngt.vo.BannerVO", "bannerVO=foodportal.admin.systemmngt.vo.BannerVO"})
	public ModelAndView saveVideoBanner(WqBaseBean ibean) throws Exception {
		ModelAndView mav = new ModelAndView("wqView");
		WqResultBean rtnResult = new WqResultBean();
		
		AdminSystemmngtRootVO adminSystemmngtRootVO = new AdminSystemmngtRootVO();
		BannerVO bannerVO = null;
		
		int result = mainService.saveCommonBannerInfo(ibean);
		
		if(result == 1){
			rtnResult.setResult("정상적으로 저장되었습니다.");
			bannerVO = mainService.selectCommonBannerInfo(ibean);
		} else {
			rtnResult.setResult("저장에 문제가 발생하였습니다.");
		}
		
		adminSystemmngtRootVO.setWqResultBean(rtnResult);
		adminSystemmngtRootVO.setBannerVO(bannerVO);
		
		mav.addObject("result", adminSystemmngtRootVO);
		
		return mav;
		
	}
	
}

