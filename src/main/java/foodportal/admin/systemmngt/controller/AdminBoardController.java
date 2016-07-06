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
import foodportal.admin.systemmngt.service.AdminBoardService;
import foodportal.admin.systemmngt.vo.AdminBoardVO;
import foodportal.admin.systemmngt.vo.AdminSystemmngtRootVO;
import foodportal.admin.systemmngt.vo.BoardSettingVO;
import foodportal.admin.systemmngt.vo.CategorySettingVO;
import foodportal.admin.systemmngt.vo.CommonCodeVO;
import foodportal.admin.systemmngt.vo.UploadFileVO;


/**
 * BoardController
 * @author 박재형
 * @since 2014.09.03
 * @version 1.0
 * @see
 *
 * <pre>
 *  Modification Information
 *  수정일      수정자   수정내용
 *  ---------- -------- ---------------------------
 *  2014.09.03 박재형 최초 생성
 * </pre>
 *
 * Copyright (C) 2014 by NDS., All right reserved.
 */

@Controller                                                                                
public class AdminBoardController {

	@CommonLog Logger log;
	@Autowired
	private AdminBoardService adminBoardService;

	
	/*******************************************************************************/
	/******************************공통게시판***************************************/
	/*******************************************************************************/
	
	/**
	 * 게시판 속성 조회
	 * 
	 * @param 
	 * @return ModelAndView
	 * @throws Exception
	 */
	@RequestMapping(value = "/admin/systemmngt/comnBbsOption.do")
	@BEAN_DEF(beans={"root=foodportal.admin.systemmngt.vo.AdminSystemmngtRootVO"
					,"paramAdminBoardVo=foodportal.admin.systemmngt.vo.AdminBoardVO" 
					,"boardSettingInfo=foodportal.admin.systemmngt.vo.BoardSettingVO"
					})
	public ModelAndView selectAdminBoardOption(WqBaseBean ibean) throws Exception {
		ModelAndView mav = new ModelAndView("wqView");
		
		AdminSystemmngtRootVO adminSystemmngtRootVO = new AdminSystemmngtRootVO();
		BoardSettingVO boardSettingVo = adminBoardService.selectAdminBoardOption(ibean);
		adminSystemmngtRootVO.setBoardSettingInfo(boardSettingVo);
		mav.addObject("result", adminSystemmngtRootVO);
		
		return mav;
	}
	
	/**
	 * 게시판 목록 조회
	 * 
	 * @param 
	 * @return ModelAndView
	 * @throws Exception
	 */
	@RequestMapping(value = "/admin/systemmngt/comnBbsList.do")
	@BEAN_DEF(beans={"root=foodportal.admin.systemmngt.vo.AdminSystemmngtRootVO"
					,"paramAdminBoardVo=foodportal.admin.systemmngt.vo.AdminBoardVO"
					,"adminBoardList=foodportal.admin.systemmngt.vo.AdminBoardVO"
					})
	public ModelAndView selectAdminBoardList(WqBaseBean ibean) throws Exception {
		ModelAndView mav = new ModelAndView("wqView");
		
		AdminSystemmngtRootVO adminSystemmngtRootVO = new AdminSystemmngtRootVO();
		List<AdminBoardVO> adminBoardList = adminBoardService.selectAdminBoardList(ibean);
		adminSystemmngtRootVO.setAdminBoardList(adminBoardList);
		mav.addObject("result", adminSystemmngtRootVO);
		
		return mav;
	}
	
	/**
	 * 게시판 상세조회
	 * 
	 * @param 
	 * @return ModelAndView
	 * @throws Exception
	 */
	@RequestMapping(value = "/admin/systemmngt/comnBbsDetail.do")
	@BEAN_DEF(beans={"root=foodportal.admin.systemmngt.vo.AdminSystemmngtRootVO"
					,"paramAdminBoardVo=foodportal.admin.systemmngt.vo.AdminBoardVO"
					,"paramCategory=foodportal.admin.systemmngt.vo.CategorySettingVO"
					,"commonCode=foodportal.admin.systemmngt.vo.CommonCodeVO"
					,"adminBoardDetail=foodportal.admin.systemmngt.vo.AdminBoardVO"
					,"categoryList=foodportal.admin.systemmngt.vo.CategorySettingVO"
					,"commonCodeList=foodportal.admin.systemmngt.vo.CommonCodeVO"
					,"fileList=foodportal.admin.systemmngt.vo.UploadFileVO"
					})
	public ModelAndView selectAdminBoardDetail(WqBaseBean ibean) throws Exception {
		
		ModelAndView mav = new ModelAndView("wqView");
		
		AdminSystemmngtRootVO adminSystemmngtRootVO = new AdminSystemmngtRootVO();

		AdminBoardVO adminBoardDetail = adminBoardService.selectAdminBoardDetail(ibean);
		List<CategorySettingVO> categorySettingList = adminBoardService.selectAdminBoardCategoryList(ibean);
		List<CommonCodeVO> cmmnCodeList = adminBoardService.selectCmmnCode(ibean);
		List<UploadFileVO> fileList = adminBoardService.selectAdminBoardFileList(ibean);
		
		adminSystemmngtRootVO.setAdminBoardDetail(adminBoardDetail);
		adminSystemmngtRootVO.setCategoryList(categorySettingList);
		adminSystemmngtRootVO.setCommonCodeList(cmmnCodeList);
		adminSystemmngtRootVO.setFileList(fileList);
		
		mav.addObject("result", adminSystemmngtRootVO);
		
		return mav;
	}
	
	/**
	 * 게시판 글 등록/수정
	 * 
	 * @param 
	 * @return ModelAndView
	 * @throws Exception
	 */
	@RequestMapping(value = "/admin/systemmngt/saveAdminBoardDetail.do")
	@BEAN_DEF(beans={"root=foodportal.admin.systemmngt.vo.AdminSystemmngtRootVO"
					,"paramAdminBoardVo=foodportal.admin.systemmngt.vo.AdminBoardVO"
					,"paramDeleteFileVO=foodportal.admin.systemmngt.vo.UploadFileVO"
					,"paramUploadFileVO=foodportal.admin.systemmngt.vo.UploadFileVO"})
	public ModelAndView saveAdminBoardDetail(WqBaseBean ibean) throws Exception {
		ModelAndView mav = new ModelAndView("wqView");
		WqResultBean rtnResult = new WqResultBean();
		
		AdminSystemmngtRootVO adminSystemmngtRootVO = new AdminSystemmngtRootVO();
		int result = adminBoardService.saveAdminBoard(ibean);
		
		if(result == 1){
			rtnResult.setResult("정상적으로 저장되었습니다.");
		} else {
			rtnResult.setResult("저장에 문제가 발생하였습니다.");
		}
		
		adminSystemmngtRootVO.setWqResultBean(rtnResult);
		
		mav.addObject("result", adminSystemmngtRootVO);
		
		return mav;
	}
	
	/**
	 * 계층형 카테고리 선택
	 * 
	 * @param 
	 * @return ModelAndView
	 * @throws Exception
	 */
	@RequestMapping(value = "/admin/systemmngt/selectCategoryOnchange.do")
	@BEAN_DEF(beans={"root=foodportal.admin.systemmngt.vo.AdminSystemmngtRootVO"
					,"paramCategory=foodportal.admin.systemmngt.vo.CategorySettingVO"
					,"categoryList=foodportal.admin.systemmngt.vo.CategorySettingVO"				
					})
	public ModelAndView selectCategoryOnchange(WqBaseBean ibean) throws Exception {
		
		ModelAndView mav = new ModelAndView("wqView");
		AdminSystemmngtRootVO adminSystemmngtRootVO = new AdminSystemmngtRootVO();

		List<CategorySettingVO> categorySettingList = adminBoardService.selectAdminBoardCategoryList(ibean);
		adminSystemmngtRootVO.setCategoryList(categorySettingList);
		
		mav.addObject("result", adminSystemmngtRootVO);
		
		return mav;
	}
	
	
	
	/*******************************************************************************/
	/******************************뉴스형게시판*************************************/
	/*******************************************************************************/
	
	
	
	/*******************************************************************************/
	/******************************컨텐츠A형****************************************/
	/*******************************************************************************/
	
	/**
	 * 게시판 Type03 목록 조회
	 * 
	 * @param 
	 * @return ModelAndView
	 * @throws Exception
	 */
	@RequestMapping(value = "/admin/systemmngt/selectBbsType03List.do")
	@BEAN_DEF(beans={"root=foodportal.admin.systemmngt.vo.AdminSystemmngtRootVO", "paramAdminBoardVo=foodportal.admin.systemmngt.vo.AdminBoardVO" , "adminBoardList=foodportal.admin.systemmngt.vo.AdminBoardVO"})
	public ModelAndView selectBbsType03List(WqBaseBean ibean) throws Exception {
		ModelAndView mav = new ModelAndView("wqView");
		
		AdminSystemmngtRootVO adminSystemmngtRootVO = new AdminSystemmngtRootVO();
		List<AdminBoardVO> adminBoardList = adminBoardService.selectAdminBoardList(ibean);
		adminSystemmngtRootVO.setAdminBoardList(adminBoardList);
		mav.addObject("result", adminSystemmngtRootVO);
		
		return mav;
	}
	
	/**
	 * 게시판 Type03 글 상세 조회
	 * 
	 * @param 
	 * @return ModelAndView
	 * @throws Exception
	 */
	@RequestMapping(value = "/admin/systemmngt/selectBbsType03Detail.do")
	@BEAN_DEF(beans={"root=foodportal.admin.systemmngt.vo.AdminSystemmngtRootVO", "paramAdminBoardVo=foodportal.admin.systemmngt.vo.AdminBoardVO", "adminBoardDetail=foodportal.admin.systemmngt.vo.AdminBoardVO"})
	public ModelAndView selectBbsType03Detail(WqBaseBean ibean) throws Exception {
		ModelAndView mav = new ModelAndView("wqView");
		
		AdminSystemmngtRootVO adminSystemmngtRootVO = new AdminSystemmngtRootVO();
		AdminBoardVO adminBoardDetail = adminBoardService.selectAdminBoardDetail(ibean);
		adminSystemmngtRootVO.setAdminBoardDetail(adminBoardDetail);
		mav.addObject("result", adminSystemmngtRootVO);
		
		return mav;
	}
	
	/**
	 * 게시판 Type03 글 등록/수정
	 * 
	 * @param 
	 * @return ModelAndView
	 * @throws Exception
	 */
	@RequestMapping(value = "/admin/systemmngt/saveBbsType03Detail.do")
	@BEAN_DEF(beans={"root=foodportal.admin.systemmngt.vo.AdminSystemmngtRootVO", "paramAdminBoardVo=foodportal.admin.systemmngt.vo.AdminBoardVO"})
	public ModelAndView saveBbsType03Detail(WqBaseBean ibean) throws Exception {
		ModelAndView mav = new ModelAndView("wqView");
		WqResultBean rtnResult = new WqResultBean();
		
		AdminSystemmngtRootVO PadminSystemmngtRootVO = (AdminSystemmngtRootVO)ibean;
		AdminBoardVO paramAdminBoardVo = PadminSystemmngtRootVO.getParamAdminBoardVo();
		
		AdminSystemmngtRootVO adminSystemmngtRootVO = new AdminSystemmngtRootVO();
		int result = adminBoardService.saveAdminBoard(ibean,paramAdminBoardVo.getFlag());
		
		if(result == 1){
			rtnResult.setResult("정상적으로 저장되었습니다.");
		} else {
			rtnResult.setResult("저장에 문제가 발생하였습니다.");
		}
		
		
		adminSystemmngtRootVO.setWqResultBean(rtnResult);
		
		mav.addObject("result", adminSystemmngtRootVO);
		
		return mav;
	}
	
	/**
	 * 게시판 Type03 글 삭제
	 * 
	 * @param 
	 * @return ModelAndView
	 * @throws Exception
	 */
	@RequestMapping(value = "/admin/systemmngt/delBbsType03Detail.do")
	@BEAN_DEF(beans={"root=foodportal.admin.systemmngt.vo.AdminSystemmngtRootVO", "paramAdminBoardVo=foodportal.admin.systemmngt.vo.AdminBoardVO"})
	public ModelAndView delBbsType03Detail(WqBaseBean ibean) throws Exception {
		ModelAndView mav = new ModelAndView("wqView");
		WqResultBean rtnResult = new WqResultBean();
		
		AdminSystemmngtRootVO adminSystemmngtRootVO = new AdminSystemmngtRootVO();
		int result = adminBoardService.saveAdminBoard(ibean,"delete");
		
		if(result == 1){
			rtnResult.setResult("정상적으로 삭제 되었습니다.");
		} else {
			rtnResult.setResult("삭제에 문제가 발생하였습니다.");
		}
		
		
		adminSystemmngtRootVO.setWqResultBean(rtnResult);
		
		mav.addObject("result", adminSystemmngtRootVO);
		
		return mav;
	}
	
	/*******************************************************************************/
	/******************************컨텐츠B형****************************************/
	/*******************************************************************************/

	/**
	 * 게시판 Type04 글 상세 조회
	 * 
	 * @param 
	 * @return ModelAndView
	 * @throws Exception
	 */
	@RequestMapping(value = "/admin/systemmngt/selectBbsType04Detail.do")
	@BEAN_DEF(beans={"root=foodportal.admin.systemmngt.vo.AdminSystemmngtRootVO", "paramAdminBoardVo=foodportal.admin.systemmngt.vo.AdminBoardVO", "adminBoardDetail=foodportal.admin.systemmngt.vo.AdminBoardVO"})
	public ModelAndView selectBbsType04Detail(WqBaseBean ibean) throws Exception {
		ModelAndView mav = new ModelAndView("wqView");
		
		AdminSystemmngtRootVO adminSystemmngtRootVO = new AdminSystemmngtRootVO();
		AdminBoardVO adminBoardDetail = adminBoardService.selectTypeBBoardDetail(ibean);
		adminSystemmngtRootVO.setAdminBoardDetail(adminBoardDetail);
		mav.addObject("result", adminSystemmngtRootVO);
		
		return mav;
	}
	
	/**
	 * 게시판 Type04 글 등록/수정
	 * 
	 * @param 
	 * @return ModelAndView
	 * @throws Exception
	 */
	@RequestMapping(value = "/admin/systemmngt/saveBbsType04Detail.do")
	@BEAN_DEF(beans={"root=foodportal.admin.systemmngt.vo.AdminSystemmngtRootVO", "paramAdminBoardVo=foodportal.admin.systemmngt.vo.AdminBoardVO"})
	public ModelAndView saveBbsType04Detail(WqBaseBean ibean) throws Exception {
		ModelAndView mav = new ModelAndView("wqView");
		WqResultBean rtnResult = new WqResultBean();
		
		AdminSystemmngtRootVO PadminSystemmngtRootVO = (AdminSystemmngtRootVO)ibean;
		AdminBoardVO paramAdminBoardVo = PadminSystemmngtRootVO.getParamAdminBoardVo();
		
		AdminSystemmngtRootVO adminSystemmngtRootVO = new AdminSystemmngtRootVO();
		int result = adminBoardService.saveAdminBoard(ibean,paramAdminBoardVo.getFlag());
		
		if(result == 1){
			rtnResult.setResult("정상적으로 저장되었습니다.");
		} else {
			rtnResult.setResult("저장에 문제가 발생하였습니다.");
		}
		
		
		adminSystemmngtRootVO.setWqResultBean(rtnResult);
		
		mav.addObject("result", adminSystemmngtRootVO);
		
		return mav;
	}
	
	/**
	 * 게시판 Type04 글 삭제
	 * 
	 * @param 
	 * @return ModelAndView
	 * @throws Exception
	 */
	@RequestMapping(value = "/admin/systemmngt/delBbsType04Detail.do")
	@BEAN_DEF(beans={"root=foodportal.admin.systemmngt.vo.AdminSystemmngtRootVO", "paramAdminBoardVo=foodportal.admin.systemmngt.vo.AdminBoardVO"})
	public ModelAndView delBbsType04Detail(WqBaseBean ibean) throws Exception {
		ModelAndView mav = new ModelAndView("wqView");
		WqResultBean rtnResult = new WqResultBean();
		
		AdminSystemmngtRootVO adminSystemmngtRootVO = new AdminSystemmngtRootVO();
		int result = adminBoardService.saveAdminBoard(ibean,"delete");
		
		if(result == 1){
			rtnResult.setResult("정상적으로 삭제 되었습니다.");
		} else {
			rtnResult.setResult("삭제에 문제가 발생하였습니다.");
		}
		
		
		adminSystemmngtRootVO.setWqResultBean(rtnResult);
		
		mav.addObject("result", adminSystemmngtRootVO);
		
		return mav;
	}
	
	
	/*******************************************************************************/
	/******************************관련사이트******************************************/
	/*******************************************************************************/
	
	/**
	 * 관련 사이트 관리 목록 조회
	 * 
	 * @param 
	 * @return ModelAndView
	 * @throws Exception
	 */
	@RequestMapping(value = "/admin/systemmngt/selectRelateSiteList.do")
	@BEAN_DEF(beans={"root=foodportal.admin.systemmngt.vo.AdminSystemmngtRootVO", "paramAdminBoardVo=foodportal.admin.systemmngt.vo.AdminBoardVO" , "adminBoardList=foodportal.admin.systemmngt.vo.AdminBoardVO"})
	public ModelAndView selectRelateSiteList(WqBaseBean ibean) throws Exception {
		ModelAndView mav = new ModelAndView("wqView");
		
		AdminSystemmngtRootVO adminSystemmngtRootVO = new AdminSystemmngtRootVO();
		List<AdminBoardVO> adminBoardList = adminBoardService.selectAdminBoardList(ibean);
		adminSystemmngtRootVO.setAdminBoardList(adminBoardList);
		mav.addObject("result", adminSystemmngtRootVO);
		
		return mav;
	}
	
	/**
	 * 관련 사이트 관리 등록/수정
	 * 
	 * @param 
	 * @return ModelAndView
	 * @throws Exception
	 */
	@RequestMapping(value = "/admin/systemmngt/saveRelateSite.do")
	@BEAN_DEF(beans={"root=foodportal.admin.systemmngt.vo.AdminSystemmngtRootVO", "adminBoardVo=foodportal.admin.systemmngt.vo.AdminBoardVO", "relateSiteList=foodportal.admin.systemmngt.vo.AdminBoardVO"})
	public ModelAndView saveRelateSite(WqBaseBean ibean) throws Exception {
		ModelAndView mav = new ModelAndView("wqView");
		WqResultBean rtnResult = new WqResultBean();
		
		AdminSystemmngtRootVO adminSystemmngtRootVO = new AdminSystemmngtRootVO();
		int result = adminBoardService.saveRelateSite(ibean);
		
		if(result == 1){
			rtnResult.setResult("정상적으로 저장되었습니다.");
		} else {
			rtnResult.setResult("저장에 문제가 발생하였습니다.");
		}
		
		
		adminSystemmngtRootVO.setWqResultBean(rtnResult);
		
		mav.addObject("result", adminSystemmngtRootVO);
		
		return mav;
	}
	
	/**
	 * 관련 사이트 관리 삭제
	 * 
	 * @param 
	 * @return ModelAndView
	 * @throws Exception
	 */
	@RequestMapping(value = "/admin/systemmngt/delRelateSite.do")
	@BEAN_DEF(beans={"root=foodportal.admin.systemmngt.vo.AdminSystemmngtRootVO", "adminBoardVo=foodportal.admin.systemmngt.vo.AdminBoardVO", "relateSiteList=foodportal.admin.systemmngt.vo.AdminBoardVO"})
	public ModelAndView delRelateSite(WqBaseBean ibean) throws Exception {
		ModelAndView mav = new ModelAndView("wqView");
		WqResultBean rtnResult = new WqResultBean();
		
		AdminSystemmngtRootVO adminSystemmngtRootVO = new AdminSystemmngtRootVO();
		int result = adminBoardService.saveRelateSite(ibean);
		
		if(result == 1){
			rtnResult.setResult("정상적으로 삭제 되었습니다.");
		} else {
			rtnResult.setResult("삭제에 문제가 발생하였습니다.");
		}
		
		
		adminSystemmngtRootVO.setWqResultBean(rtnResult);
		
		mav.addObject("result", adminSystemmngtRootVO);
		
		return mav;
	}
	
	
	/*******************************************************************************/
	/******************************포토게시판***************************************/
	/*******************************************************************************/
	
	
	/*******************************************************************************/
	/******************************동영상게시판*************************************/
	/*******************************************************************************/
	
	
	/*******************************************************************************/
	/******************************FAQ**********************************************/
	/*******************************************************************************/
	
	
	
	/*******************************************************************************/
	/******************************약관*********************************************/
	/*******************************************************************************/
	/**
	 * 약관 목록 조회
	 * 
	 * @param 
	 * @return ModelAndView
	 * @throws Exception
	 */
	@RequestMapping(value = "/admin/systemmngt/selectBbsType99List.do")
	@BEAN_DEF(beans={"root=foodportal.admin.systemmngt.vo.AdminSystemmngtRootVO", "paramAdminBoardVo=foodportal.admin.systemmngt.vo.AdminBoardVO", "adminBoardList=foodportal.admin.systemmngt.vo.AdminBoardVO"})
	public ModelAndView selectBbsType99List(WqBaseBean ibean) throws Exception {
		ModelAndView mav = new ModelAndView("wqView");
		
		AdminSystemmngtRootVO adminSystemmngtRootVO = new AdminSystemmngtRootVO();
		List<AdminBoardVO> adminBoardList = adminBoardService.selectAdminBoardList(ibean);
		adminSystemmngtRootVO.setAdminBoardList(adminBoardList);
		mav.addObject("result", adminSystemmngtRootVO);
		
		return mav;
	}
	
	/**
	 * 약관 상세 조회
	 * 
	 * @param 
	 * @return ModelAndView
	 * @throws Exception
	 */
	@RequestMapping(value = "/admin/systemmngt/selectBbsType99Detail.do")
	@BEAN_DEF(beans={"root=foodportal.admin.systemmngt.vo.AdminSystemmngtRootVO", "paramAdminBoardVo=foodportal.admin.systemmngt.vo.AdminBoardVO", "adminBoardDetail=foodportal.admin.systemmngt.vo.AdminBoardVO"})
	public ModelAndView selectBbsType99Detail(WqBaseBean ibean) throws Exception {
		ModelAndView mav = new ModelAndView("wqView");
		
		AdminSystemmngtRootVO adminSystemmngtRootVO = new AdminSystemmngtRootVO();
		AdminBoardVO adminBoardDetail = adminBoardService.selectAdminBoardDetail(ibean);
		adminSystemmngtRootVO.setAdminBoardDetail(adminBoardDetail);
		mav.addObject("result", adminSystemmngtRootVO);
		
		return mav;
	}
	
	/**
	 * 약관 등록/수정
	 * 
	 * @param 
	 * @return ModelAndView
	 * @throws Exception
	 */
	@RequestMapping(value = "/admin/systemmngt/saveBbsType99Detail.do")
	@BEAN_DEF(beans={"root=foodportal.admin.systemmngt.vo.AdminSystemmngtRootVO", "paramAdminBoardVo=foodportal.admin.systemmngt.vo.AdminBoardVO"})
	public ModelAndView saveBbsType99Detail(WqBaseBean ibean) throws Exception {
		ModelAndView mav = new ModelAndView("wqView");
		WqResultBean rtnResult = new WqResultBean();
		
		AdminSystemmngtRootVO adminSystemmngtRootVO = new AdminSystemmngtRootVO();
		int result = adminBoardService.saveTerms(ibean);
		
		if(result == 1){
			rtnResult.setResult("정상적으로 저장되었습니다.");
		} else {
			rtnResult.setResult("저장에 문제가 발생하였습니다.");
		}
		
		
		adminSystemmngtRootVO.setWqResultBean(rtnResult);
		
		mav.addObject("result", adminSystemmngtRootVO);
		
		return mav;
	}
	
	/*******************************************************************************/
	/******************************카테고리 목록 조회*************************************/
	/*******************************************************************************/
	/**
	 * 카테고리 목록 조회
	 * 
	 * @param 
	 * @return ModelAndView
	 * @throws Exception
	 */
	@RequestMapping(value = "/admin/systemmngt/selectAdminBoardCategoryList.do")
	@BEAN_DEF(beans={"root=foodportal.admin.systemmngt.vo.AdminSystemmngtRootVO", "paramCategory=foodportal.admin.systemmngt.vo.CategorySettingVO", "categoryList=foodportal.admin.systemmngt.vo.CategorySettingVO"})
	public ModelAndView selectAdminBoardCategoryList(WqBaseBean ibean) throws Exception {
		ModelAndView mav = new ModelAndView("wqView");
		
		AdminSystemmngtRootVO adminSystemmngtRootVO = new AdminSystemmngtRootVO();
		List<CategorySettingVO> categoryList = adminBoardService.selectAdminBoardCategoryList(ibean);
		adminSystemmngtRootVO.setCategoryList(categoryList);
		mav.addObject("result", adminSystemmngtRootVO);
		
		return mav;
	}
	
	
}