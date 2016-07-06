package common.adminfacillity.systemmngt.controller;

import java.util.Map;
import java.util.List;

import org.slf4j.Logger;
import common.commonfacillity.log.CommonLog;
import common.commonfacillity.uia.WqBaseBean;
import common.commonfacillity.uia.WqResultBean;
import websquare.system.adapter.annotation.BEAN_DEF;
import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import common.adminfacillity.systemmngt.service.CommonCodeService;
import common.adminfacillity.systemmngt.service.AdminfacillitySystemmngtRootVO;
import common.adminfacillity.systemmngt.service.CommonCodeVO;
import common.adminfacillity.systemmngt.service.CommonCodeDataVO;

/**
 * CommonCodeController
 * @author 김민규
 * @since 2014.08.19
 * @version 1.0
 * @see
 *
 * <pre>
 *  Modification Information
 *  수정일      수정자   수정내용
 *  ---------- -------- ---------------------------
 *  2014.08.19 김민규 최초 생성
 * </pre>
 *
 * Copyright (C) 2014 by NDS., All right reserved.
 */

@Controller                                                                                
public class CommonCodeController {

	@CommonLog Logger log;
	@Autowired
	private CommonCodeService commonCodeService;

	/**
	 * 등록된 공통코드 정보 조회
	 * 
	 * @param 
	 * @return ModelAndView
	 * @throws Exception
	 */
	@RequestMapping(value = "/adminfacillity/systemmngt/selectCommonCode.do")
	@BEAN_DEF(beans={"root=common.adminfacillity.systemmngt.service.AdminfacillitySystemmngtRootVO", "commonCodeVO=common.adminfacillity.systemmngt.service.CommonCodeVO", "infoList=common.adminfacillity.systemmngt.service.CommonCodeVO"})
	public ModelAndView selectCommonCode(WqBaseBean ibean) throws Exception {
		ModelAndView mav = new ModelAndView("wqView");
		
		AdminfacillitySystemmngtRootVO adminfacillitySystemmngtRootVO = new AdminfacillitySystemmngtRootVO();
		List<CommonCodeVO> list = commonCodeService.selectCommonCode(ibean);
		adminfacillitySystemmngtRootVO.setInfoList(list);
		
		mav.addObject("result", adminfacillitySystemmngtRootVO);
		
		return mav;
	}
	
	/**
	 * 신규 공통코드 정보 등록
	 * 
	 * @param 
	 * @return ModelAndView
	 * @throws Exception
	 */
	@RequestMapping(value = "/adminfacillity/systemmngt/saveCommonCode.do")
	@BEAN_DEF(beans={"root=common.adminfacillity.systemmngt.service.AdminfacillitySystemmngtRootVO","commonCodeVO=common.adminfacillity.systemmngt.service.CommonCodeVO","infoList=common.adminfacillity.systemmngt.service.CommonCodeVO","infoDataList=common.adminfacillity.systemmngt.service.CommonCodeDataVO","rtnResult=common.commonfacillity.uia.WqResultBean"})
	public ModelAndView saveCommonCode(WqBaseBean ibean) throws Exception {
		ModelAndView mav = new ModelAndView("wqView");
		WqResultBean rtnResult = new WqResultBean();
		AdminfacillitySystemmngtRootVO outVo = new AdminfacillitySystemmngtRootVO();
		List<CommonCodeVO> list = null;
		
		int result = commonCodeService.saveCommonCode(ibean);
		if(result == 1){
			rtnResult.setResult("정상적으로 저장되었습니다.");
			list = commonCodeService.selectCommonCode(ibean);
		} else {
			rtnResult.setResult("저장에 문제가 발생하였습니다.");
		}
		outVo.setWqResultBean(rtnResult);
		outVo.setInfoList(list);
		
		mav.addObject("result", outVo);
		
		return mav;
	}

	/**
	 * 신규 공통코드 정보 등록
	 * 
	 * @param 
	 * @return ModelAndView
	 * @throws Exception
	 */
	@RequestMapping(value = "/adminfacillity/systemmngt/insertCommonCode.do")
	@BEAN_DEF(beans={"root=common.adminfacillity.systemmngt.service.AdminfacillitySystemmngtRootVO", "commonCodeVO=common.adminfacillity.systemmngt.service.CommonCodeVO", "infoList=common.adminfacillity.systemmngt.service.CommonCodeVO"})
	public ModelAndView insertCommonCode(WqBaseBean ibean) throws Exception {
		ModelAndView mav = new ModelAndView("wqView");
		WqResultBean rtnResult = new WqResultBean();
		AdminfacillitySystemmngtRootVO outVo = new AdminfacillitySystemmngtRootVO();
		List<CommonCodeVO> list = null;
		
		int result = commonCodeService.insertCommonCode(ibean);
		if(result == 1){
			rtnResult.setResult("정상적으로 입력되었습니다.");
			list = commonCodeService.selectCommonCode(ibean);
		} else {
			rtnResult.setResult("입력에 문제가 발생하였습니다.");
		}
		outVo.setWqResultBean(rtnResult);
		outVo.setInfoList(list);
		
		mav.addObject("result", outVo);
		
		return mav;
	}

	/**
	 * 등록된 공통코드 정보 삭제
	 * 
	 * @param 
	 * @return ModelAndView
	 * @throws Exception
	 */
	@RequestMapping(value = "/adminfacillity/systemmngt/deleteCommonCode.do")
	@BEAN_DEF(beans={"root=common.adminfacillity.systemmngt.service.AdminfacillitySystemmngtRootVO", "commonCodeVO=common.adminfacillity.systemmngt.service.CommonCodeVO", "infoList=common.adminfacillity.systemmngt.service.CommonCodeVO"})
	public ModelAndView deleteCommonCode(WqBaseBean ibean) throws Exception {
		ModelAndView mav = new ModelAndView("wqView");
		WqResultBean rtnResult = new WqResultBean();
		AdminfacillitySystemmngtRootVO outVo = new AdminfacillitySystemmngtRootVO();
		List<CommonCodeVO> list = null;
		
		int result = commonCodeService.deleteCommonCode(ibean);
		if(result == 1){
			rtnResult.setResult("정상적으로 삭제되었습니다.");
			list = commonCodeService.selectCommonCode(ibean);
		} else {
			rtnResult.setResult("삭제에 문제가 발생하였습니다.");
		}
		outVo.setWqResultBean(rtnResult);
		outVo.setInfoList(list);
		
		mav.addObject("result", outVo);
		
		return mav;
	}

	/**
	 * 등록된 공통코드 정보 수정
	 * 
	 * @param 
	 * @return ModelAndView
	 * @throws Exception
	 */
	@RequestMapping(value = "/adminfacillity/systemmngt/updateCommonCode.do")
	@BEAN_DEF(beans={"root=common.adminfacillity.systemmngt.service.AdminfacillitySystemmngtRootVO", "commonCodeVO=common.adminfacillity.systemmngt.service.CommonCodeVO", "infoList=common.adminfacillity.systemmngt.service.CommonCodeVO"})
	public ModelAndView updateCommonCode(WqBaseBean ibean) throws Exception {
		ModelAndView mav = new ModelAndView("wqView");
		WqResultBean rtnResult = new WqResultBean();
		AdminfacillitySystemmngtRootVO outVo = new AdminfacillitySystemmngtRootVO();
		List<CommonCodeVO> list = null;
		
		int result = commonCodeService.updateCommonCode(ibean);
		if(result == 1){
			rtnResult.setResult("정상적으로 수정되었습니다.");
			list = commonCodeService.selectCommonCode(ibean);
		} else {
			rtnResult.setResult("수정에 문제가 발생하였습니다.");
		}
		outVo.setWqResultBean(rtnResult);
		outVo.setInfoList(list);
		
		mav.addObject("result", outVo);
		
		return mav;
	}

	/**
	 * 등록된 공통코드상세 정보 조회
	 * 
	 * @param 
	 * @return ModelAndView
	 * @throws Exception
	 */
	@RequestMapping(value = "/adminfacillity/systemmngt/selectCommonCodeDetail.do")
	@BEAN_DEF(beans={"root=common.adminfacillity.systemmngt.service.AdminfacillitySystemmngtRootVO", "commonCodeDataVO=common.adminfacillity.systemmngt.service.CommonCodeDataVO", "infoDataList=common.adminfacillity.systemmngt.service.CommonCodeDataVO"})
	public ModelAndView selectCommonCodeDetail(WqBaseBean ibean) throws Exception {
		ModelAndView mav = new ModelAndView("wqView");
		
		AdminfacillitySystemmngtRootVO adminfacillitySystemmngtRootVO = new AdminfacillitySystemmngtRootVO();
		List<CommonCodeDataVO> list = commonCodeService.selectCommonCodeDetail(ibean);
		adminfacillitySystemmngtRootVO.setInfoDataList(list);
		
		mav.addObject("result", adminfacillitySystemmngtRootVO);
		
		return mav;
	}

	/**
	 * 신규 공통코드상세 정보 등록
	 * 
	 * @param 
	 * @return ModelAndView
	 * @throws Exception
	 */
	@RequestMapping(value = "/adminfacillity/systemmngt/insertCommonCodeDetail.do")
	@BEAN_DEF(beans={"root=common.adminfacillity.systemmngt.service.AdminfacillitySystemmngtRootVO", "commonCodeDataVO=common.adminfacillity.systemmngt.service.CommonCodeDataVO", "infoDataList=common.adminfacillity.systemmngt.service.CommonCodeDataVO"})
	public ModelAndView insertCommonCodeDetail(WqBaseBean ibean) throws Exception {
		ModelAndView mav = new ModelAndView("wqView");
		WqResultBean rtnResult = new WqResultBean();
		AdminfacillitySystemmngtRootVO outVo = new AdminfacillitySystemmngtRootVO();
		List<CommonCodeDataVO> list = null;
		
		int result = commonCodeService.insertCommonCodeDetail(ibean);
		if(result == 1){
			rtnResult.setResult("정상적으로 입력되었습니다.");
			list = commonCodeService.selectCommonCodeDetail(ibean);
		} else {
			rtnResult.setResult("입력에 문제가 발생하였습니다.");
		}
		outVo.setWqResultBean(rtnResult);
		outVo.setInfoDataList(list);
		
		mav.addObject("result", outVo);
		
		return mav;
	}

	/**
	 * 등록된 공통코드상세 정보 수정
	 * 
	 * @param 
	 * @return ModelAndView
	 * @throws Exception
	 */
	@RequestMapping(value = "/adminfacillity/systemmngt/updateCommonCodeDetail.do")
	@BEAN_DEF(beans={"root=common.adminfacillity.systemmngt.service.AdminfacillitySystemmngtRootVO", "commonCodeDataVO=common.adminfacillity.systemmngt.service.CommonCodeDataVO", "infoDataList=common.adminfacillity.systemmngt.service.CommonCodeDataVO"})
	public ModelAndView updateCommonCodeDetail(WqBaseBean ibean) throws Exception {
		ModelAndView mav = new ModelAndView("wqView");
		WqResultBean rtnResult = new WqResultBean();
		AdminfacillitySystemmngtRootVO outVo = new AdminfacillitySystemmngtRootVO();
		List<CommonCodeDataVO> list = null;
		
		int result = commonCodeService.updateCommonCodeDetail(ibean);
		if(result == 1){
			rtnResult.setResult("정상적으로 수정되었습니다.");
			list = commonCodeService.selectCommonCodeDetail(ibean);
		} else {
			rtnResult.setResult("수정에 문제가 발생하였습니다.");
		}
		outVo.setWqResultBean(rtnResult);
		outVo.setInfoDataList(list);
		
		mav.addObject("result", outVo);
		
		return mav;
	}

	/**
	 * 등록된 공통코드상세 정보 삭제
	 * 
	 * @param 
	 * @return ModelAndView
	 * @throws Exception
	 */
	@RequestMapping(value = "/adminfacillity/systemmngt/deleteCommonCodeDetail.do")
	@BEAN_DEF(beans={"root=common.adminfacillity.systemmngt.service.AdminfacillitySystemmngtRootVO", "commonCodeDataVO=common.adminfacillity.systemmngt.service.CommonCodeDataVO", "infoDataList=common.adminfacillity.systemmngt.service.CommonCodeDataVO"})
	public ModelAndView deleteCommonCodeDetail(WqBaseBean ibean) throws Exception {
		ModelAndView mav = new ModelAndView("wqView");
		WqResultBean rtnResult = new WqResultBean();
		AdminfacillitySystemmngtRootVO outVo = new AdminfacillitySystemmngtRootVO();
		List<CommonCodeDataVO> list = null;
		
		int result = commonCodeService.deleteCommonCodeDetail(ibean);
		if(result == 1){
			rtnResult.setResult("정상적으로 삭제되었습니다.");
			list = commonCodeService.selectCommonCodeDetail(ibean);
		} else {
			rtnResult.setResult("삭제에 문제가 발생하였습니다.");
		}
		outVo.setWqResultBean(rtnResult);
		outVo.setInfoDataList(list);
		
		mav.addObject("result", outVo);
		
		return mav;
	}
	
	/**
	 * 공통코드 호출 함수
	 * 
	 * @param 
	 * @return ModelAndView
	 * @throws Exception
	 */
	@RequestMapping(value = "/adminfacillity/systemmngt/selectCommonCodeFunction.do")
	@BEAN_DEF(beans={"root=common.adminfacillity.systemmngt.service.AdminfacillitySystemmngtRootVO", "commonCodeVO=common.adminfacillity.systemmngt.service.CommonCodeVO", "commonCodeDataList=common.adminfacillity.systemmngt.service.CommonCodeDataVO"})
	public ModelAndView selectCommonCodeFunction(WqBaseBean ibean) throws Exception {
		ModelAndView mav = new ModelAndView("wqView");
		
		AdminfacillitySystemmngtRootVO adminfacillitySystemmngtRootVO = new AdminfacillitySystemmngtRootVO();
		List<CommonCodeDataVO> list = commonCodeService.selectCommonCodeFunction(ibean);
		adminfacillitySystemmngtRootVO.setCommonCodeDataList(list);
		
		mav.addObject("result", adminfacillitySystemmngtRootVO);
		
		return mav;
	}
}