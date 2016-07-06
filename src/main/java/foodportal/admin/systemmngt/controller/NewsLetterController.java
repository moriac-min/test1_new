package foodportal.admin.systemmngt.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import websquare.system.adapter.annotation.BEAN_DEF;
import common.commonfacillity.log.CommonLog;
import common.commonfacillity.uia.WqBaseBean;
import common.commonfacillity.uia.WqResultBean;
import foodportal.admin.systemmngt.service.NewsLetterService;
import foodportal.admin.systemmngt.vo.AdminSystemmngtRootVO;
import foodportal.admin.systemmngt.vo.NewsLetterVO;
import foodportal.admin.systemmngt.vo.UploadFileVO;


/**
 * NewsLetterController
 * @author 박재형
 * @since 2014.09.16
 * @version 1.0
 * @see
 *
 * <pre>
 *  Modification Information
 *  수정일      수정자   수정내용
 *  ---------- -------- ---------------------------
 *  2014.09.16 박재형 최초 생성
 * </pre>
 *
 * Copyright (C) 2014 by NDS., All right reserved.
 */

@Controller                                                                                
public class NewsLetterController {

	@CommonLog Logger log;
	@Autowired
	private NewsLetterService newsLetterService;

	/**
	 * 뉴스레터 목록 조회
	 * 
	 * @param 
	 * @return ModelAndView
	 * @throws Exception
	 */
	@RequestMapping(value = "/admin/systemmngt/selectNewsLetterList.do")
	@BEAN_DEF(beans={"root=foodportal.admin.systemmngt.vo.AdminSystemmngtRootVO", "paramNewsLetterVO=foodportal.admin.systemmngt.vo.NewsLetterVO", "newsLetterList=foodportal.admin.systemmngt.vo.NewsLetterVO"})
	public ModelAndView selectNewsLetterList(WqBaseBean ibean) throws Exception {
		ModelAndView mav = new ModelAndView("wqView");
		
		AdminSystemmngtRootVO adminSystemmngtRootVO = new AdminSystemmngtRootVO();
		List<NewsLetterVO> newsLetterList = newsLetterService.selectNewsLetterList(ibean);
		adminSystemmngtRootVO.setNewsLetterList(newsLetterList);
		mav.addObject("result", adminSystemmngtRootVO);
		
		return mav;
	}
	
	/**
	 * 뉴스레터 상세 조회
	 * 
	 * @param 
	 * @return ModelAndView
	 * @throws Exception
	 */
	@RequestMapping(value = "/admin/systemmngt/selectNewsLetterDetail.do")
	@BEAN_DEF(beans={"root=foodportal.admin.systemmngt.vo.AdminSystemmngtRootVO", "paramNewsLetterVO=foodportal.admin.systemmngt.vo.NewsLetterVO", "newsLetterDetail=foodportal.admin.systemmngt.vo.NewsLetterVO", "fileUpload=foodportal.admin.systemmngt.vo.UploadFileVO"})
	public ModelAndView selectNewsLetterDetail(WqBaseBean ibean) throws Exception {
		ModelAndView mav = new ModelAndView("wqView");
		
		AdminSystemmngtRootVO adminSystemmngtRootVO = new AdminSystemmngtRootVO();
		//글상세
		NewsLetterVO newsLetterDetail = newsLetterService.selectNewsLetterDetail(ibean);
		//첨부파일
		UploadFileVO fileUpload = newsLetterService.selectNewsLetterFile(ibean);
		
		adminSystemmngtRootVO.setNewsLetterDetail(newsLetterDetail);
		adminSystemmngtRootVO.setFileUpload(fileUpload);
		
		mav.addObject("result", adminSystemmngtRootVO);
		
		return mav;
	}
	
	/**
	 * 뉴스레터 등록/수정
	 * 
	 * @param 
	 * @return ModelAndView
	 * @throws Exception
	 */
	@RequestMapping(value = "/admin/systemmngt/saveNewsLetter.do")
	@BEAN_DEF(beans={"root=foodportal.admin.systemmngt.vo.AdminSystemmngtRootVO", "paramNewsLetterVO=foodportal.admin.systemmngt.vo.NewsLetterVO", "paramDeleteFileVO=foodportal.admin.systemmngt.vo.UploadFileVO", "paramUploadFileVO=foodportal.admin.systemmngt.vo.UploadFileVO"})
	public ModelAndView saveNewsLetter(WqBaseBean ibean) throws Exception {
		ModelAndView mav = new ModelAndView("wqView");
		WqResultBean rtnResult = new WqResultBean();
		
		AdminSystemmngtRootVO adminSystemmngtRootVO = new AdminSystemmngtRootVO();
		int result = newsLetterService.saveNewsLetter(ibean, "save");
		
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
	 * 뉴스레터 삭제
	 * 
	 * @param 
	 * @return ModelAndView
	 * @throws Exception
	 */
	@RequestMapping(value = "/admin/systemmngt/deleteNewsLetter.do")
	@BEAN_DEF(beans={"root=foodportal.admin.systemmngt.vo.AdminSystemmngtRootVO", "paramNewsLetterVO=foodportal.admin.systemmngt.vo.NewsLetterVO", "paramDeleteFileVO=foodportal.admin.systemmngt.vo.UploadFileVO"})
	public ModelAndView deleteNewsLetter(WqBaseBean ibean) throws Exception {
		ModelAndView mav = new ModelAndView("wqView");
		WqResultBean rtnResult = new WqResultBean();
		
		AdminSystemmngtRootVO adminSystemmngtRootVO = new AdminSystemmngtRootVO();
		int result = newsLetterService.saveNewsLetter(ibean, "delete");
		
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
	 * 파일다운로드
	 * 
	 * @param 
	 * @return ModelAndView
	 * @throws Exception
	 */
	@RequestMapping(value = "/admin/systemmngt/downloadAttchdFile.do")
	public void downloadAttchdFile(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//첨부파일 다운로드
		newsLetterService.downloadAttchdFile(request, response);
		
	}
	
}