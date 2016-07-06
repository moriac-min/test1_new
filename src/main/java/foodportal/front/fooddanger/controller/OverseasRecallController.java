package foodportal.front.fooddanger.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import com.google.gson.Gson;

import common.commonfacillity.log.CommonLog;
import foodportal.common.util.Message;
import foodportal.common.util.StringUtil;
import foodportal.front.fooddanger.service.OverseasRecallService;

/**
 * OverseasRecallController
 * @author 최승희
 * @since 2014.10.01
 * @version 1.0
 * @see
 * 
 * <pre>
 *  Modification Information
 *  수정일     수정자   수정내용
 *  ---------- -------- ---------------------------
 *  2014.10.01 최승희 	최초 생성
 * </pre>
 * 
 * Copyright (C) 2014 by NDS., All right reserved.
 */

@Controller
public class OverseasRecallController {

	@CommonLog Logger log;
	@Autowired OverseasRecallService overseasRecallService;
	
	/**
	 * 해외회수정보
	 * @param model
	 * @param request
	 * @param response
	 * @return
	 * @throws IOException
	 */
	@RequestMapping("/portal/fooddanger/overseasRecall.do")
	public String overseasRecall(Model model, HttpServletRequest request, HttpServletResponse response) throws Exception {
		try {
			return "portal/fooddanger/overseasRecall";
		} catch (Exception e) {
			return StringUtil.alertRedirect(response, Message.getMessage("msg.common.system.error"));	//시스템에러가 발생하였습니다. 관리자에게 문의하십시오.
		}
	}
	
	/**
	 * 해외회수정보 목록
	 * @param model
	 * @param request
	 * @param response
	 * @return
	 * @throws IOException
	 */
	@RequestMapping("/portal/fooddanger/searchOverseasRecallList.do")
	public void searchOverseasRecallList(Model model, HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		Map<String, Object> paramMap = new HashMap<String, Object>();
		Map<String, Object> resultMap = new HashMap<String, Object>();
		
		try {
			paramMap.put("search_type", request.getParameter("search_type"));
			paramMap.put("search_keyword", request.getParameter("search_keyword"));
			paramMap.put("show_cnt", request.getParameter("show_cnt"));
			paramMap.put("start_idx", StringUtil.nullToStr(request.getParameter("start_idx"), "1"));
			
			resultMap = overseasRecallService.selectOverseasRecallList(paramMap);

		} catch (Exception e) {
		}
		
		response.setContentType("text/plain; charset=\"utf-8\"");
		response.getWriter().write(new Gson().toJson(resultMap)); 
		
	}
	
	/**
	 * 해외회수정보 상세
	 * @param model
	 * @param request
	 * @param response
	 * @return
	 * @throws IOException
	 */
	@RequestMapping("/portal/fooddanger/overseasRecallDetail.do")
	public String overseasRecallDetail(Model model, HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		Map<String, Object> paramMap = new HashMap<String, Object>();
		Map<String, Object> resultMap = new HashMap<String, Object>();
		
		try {
			paramMap.put("injry_esntl_no", request.getParameter("search_keyword"));
			
			resultMap = overseasRecallService.selectOverseasRecallDetail(paramMap);
			model.addAttribute("overseasRecall",resultMap);
			
			return "portal/fooddanger/overseasRecallDetail";
		} catch (Exception e) {
			return StringUtil.alertRedirect(response, Message.getMessage("msg.common.system.error"));	//시스템에러가 발생하였습니다. 관리자에게 문의하십시오.
		}
	}
	
}
