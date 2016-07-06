package foodportal.admin.systemmngt.controller;

import java.util.List;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import websquare.system.adapter.annotation.BEAN_DEF;
import common.adminfacillity.systemmngt.service.AdminfacillitySystemmngtRootVO;
import common.adminfacillity.systemmngt.service.CommonCodeVO;
import common.commonfacillity.log.CommonLog;
import common.commonfacillity.uia.WqBaseBean;
import common.commonfacillity.uia.WqResultBean;
import foodportal.admin.systemmngt.service.AdminBoardSettingService;
import foodportal.admin.systemmngt.vo.AdminSystemmngtRootVO;
import foodportal.admin.systemmngt.vo.BoardSettingVO;


/**
 * AdminBoardSettingController
 * @author 최연길
 * @since 2014.08.29
 * @version 1.0
 * @see
 *
 * <pre>
 *  Modification Information
 *  수정일      수정자   수정내용
 *  ---------- -------- ---------------------------
 *  2014.08.27 최연길 최초 생성
 * </pre>
 *
 * Copyright (C) 2014 by NDS., All right reserved.
 */

@Controller                                                                                
public class AdminBoardSettingController {

	@CommonLog Logger log;
	@Autowired
	private AdminBoardSettingService adminBoardSettingService;

	/**
	 * 게시판 목록 조회
	 * 
	 * @param 
	 * @return ModelAndView
	 * @throws Exception
	 */
	@RequestMapping(value = "/admin/systemmngt/selectBoardSettingList.do")
	@BEAN_DEF(beans={"root=foodportal.admin.systemmngt.vo.AdminSystemmngtRootVO", "boardSettingList=foodportal.admin.systemmngt.vo.BoardSettingVO"})
	public ModelAndView selectBoardSettingList(WqBaseBean ibean) throws Exception {
		ModelAndView mav = new ModelAndView("wqView");
		AdminSystemmngtRootVO adminSystemmngtRootVO = new AdminSystemmngtRootVO();
		List<BoardSettingVO> BoardSettingList = adminBoardSettingService.selectBoardSettingList(ibean);
		
		adminSystemmngtRootVO.setBoardSettingList(BoardSettingList);
		mav.addObject("result", adminSystemmngtRootVO);
		
		return mav;
	}

	/**
	 * 게시판 등록
	 * 
	 * @param 
	 * @return ModelAndView
	 * @throws Exception
	 */
	@RequestMapping(value = "/admin/systemmngt/saveBoardSetting.do")
	@BEAN_DEF(beans={"root=foodportal.admin.systemmngt.vo.AdminSystemmngtRootVO","paramBoardSettingInfo=foodportal.admin.systemmngt.vo.BoardSettingVO","paramUserList=foodportal.admin.systemmngt.vo.BoardSettingVO","boardSettingList=foodportal.admin.systemmngt.vo.BoardSettingVO"})
	public ModelAndView saveBoardSetting(WqBaseBean ibean) throws Exception {
		ModelAndView mav = new ModelAndView("wqView");
		WqResultBean rtnResult = new WqResultBean();
		
		AdminSystemmngtRootVO adminSystemmngtRootVO = new AdminSystemmngtRootVO();
		List<BoardSettingVO> boardSettingList = null;
		
		int result = adminBoardSettingService.saveBoardSetting(ibean);
		
		if(result == 1){
			rtnResult.setResult("정상적으로 저장되었습니다.");
			//boardSettingList = adminBoardSettingService.selectBoardSettingList(ibean);
		} else {
			rtnResult.setResult("저장에 문제가 발생하였습니다.");
		}
		adminSystemmngtRootVO.setWqResultBean(rtnResult);
		adminSystemmngtRootVO.setBoardSettingList(boardSettingList);
		
		mav.addObject("result", adminSystemmngtRootVO);
		
		return mav;
	}	
	
	/**
	 * 게시판 상세 조회
	 * 
	 * @param 
	 * @return ModelAndView
	 * @throws Exception
	 */
	@RequestMapping(value = "/admin/systemmngt/selectBoardSettingDetail.do")
	@BEAN_DEF(beans={"root=foodportal.admin.systemmngt.vo.AdminSystemmngtRootVO", "paramBoardSettingInfo=foodportal.admin.systemmngt.vo.BoardSettingVO", "boardSettingInfo=foodportal.admin.systemmngt.vo.BoardSettingVO", "paramUserList=foodportal.admin.systemmngt.vo.UserSearchVO"})
	public ModelAndView selectBoardSettingDetail(WqBaseBean ibean) throws Exception {
		ModelAndView mav = new ModelAndView("wqView");
		
		AdminSystemmngtRootVO adminSystemmngtRootVO = new AdminSystemmngtRootVO();
		
		BoardSettingVO boardSettingVO = adminBoardSettingService.selectBoardSettingDetail(ibean);
		List<BoardSettingVO> paramUserList = adminBoardSettingService.selectBoardSettingDetailUser(ibean);
		
		adminSystemmngtRootVO.setBoardSettingInfo(boardSettingVO);
		adminSystemmngtRootVO.setParamUserList(paramUserList);
		
		mav.addObject("result", adminSystemmngtRootVO);
		
		return mav;
	}
	
	/**
	 * 게시판코드 중복체크
	 * 
	 * @param 
	 * @return ModelAndView
	 * @throws Exception
	 */
	@RequestMapping(value = "/admin/systemmngt/selectBoardSettingCheck.do")
	@BEAN_DEF(beans={"root=foodportal.admin.systemmngt.vo.AdminSystemmngtRootVO", "paramBoardSettingInfo=foodportal.admin.systemmngt.vo.BoardSettingVO", "boardSettingCheck=foodportal.admin.systemmngt.vo.BoardSettingVO"})
	public ModelAndView selectBoardSettingCheck(WqBaseBean ibean) throws Exception {
		ModelAndView mav = new ModelAndView("wqView");
		
		AdminSystemmngtRootVO adminSystemmngtRootVO = new AdminSystemmngtRootVO();
		BoardSettingVO boardSettingVO = adminBoardSettingService.selectBoardSettingCheck(ibean);
		
		adminSystemmngtRootVO.setBoardSettingCheck(boardSettingVO);
		mav.addObject("result", adminSystemmngtRootVO);
		
		return mav;
	}
	
}