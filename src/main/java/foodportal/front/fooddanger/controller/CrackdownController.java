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
import foodportal.front.fooddanger.service.CrackdownService;
import foodportal.front.fooddanger.vo.CrackdownVO;
import foodportal.front.fooddanger.vo.MarienCrackdownVO;

@Controller
public class CrackdownController {
	
	@CommonLog Logger log;
	@Autowired
	private CrackdownService crackdownService;
	
	/**
	 * 농축산물원산지표시위반 페이지이동
	 * @param model
	 * @param request
	 * @param response
	 * @return
	 * @throws IOException
	 */
	@RequestMapping("/portal/fooddanger/agriCrackdownList.do")
	public String agriCrackdownList(Model model, HttpServletRequest request, HttpServletResponse response) throws IOException {
		try {
			return "portal/fooddanger/Crackdown";
		} catch (Exception e) {
			return StringUtil.alertRedirect(response, Message.getMessage("msg.common.system.error"));	//시스템에러가 발생하였습니다. 관리자에게 문의하십시오.
		}
	}
	
	/**
	 * 농축산물원산지표시위반 목록
	 * @param model
	 * @param request
	 * @param response
	 * @return
	 * @throws IOException
	 */
	@RequestMapping("/portal/fooddanger/searchAgriCrackdownList.do")
	public void searchAgriCrackdownList(Model model, HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		Map<String, Object> paramMap = new HashMap<String, Object>();
		Map<String, Object> resultMap = new HashMap<String, Object>();
		
		try {
			paramMap.put("search_type", request.getParameter("search_type"));
			paramMap.put("search_keyword", request.getParameter("search_keyword"));
			paramMap.put("show_cnt", request.getParameter("show_cnt"));
			paramMap.put("start_idx", StringUtil.nullToStr(request.getParameter("start_idx"), "1"));
			
			resultMap = crackdownService.selectAgriCrackdownList(paramMap);
			/*
			if(resultMap != null){
				model.addAttribute("list", resultMap.get("list"));
				model.addAttribute("total_cnt", resultMap.get("total_cnt"));
			}
			*/
		} catch (Exception e) {
		}
		
		response.setContentType("text/plain; charset=\"utf-8\"");
		response.getWriter().write(new Gson().toJson(resultMap)); 
		
	}
	
	/**
	 * 농축산물원산지표시위반 페이지상세
	 * @param model
	 * @param request
	 * @param response
	 * @return
	 * @throws IOException
	 */
	@RequestMapping("/popup/agriCrackdownDetail.do")
	public String AgriCrackdownDetail(Model model, HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		CrackdownVO crackdownVO = null;
		
		try {
			Map<String, Object> paramMap = new HashMap<String, Object>();
			paramMap.put("aplc_seq", request.getParameter("aplc_seq"));
			paramMap.put("prdlst_ordno", request.getParameter("prdlst_ordno"));
			
			crackdownVO = crackdownService.selectAgriCrackdownDetail(paramMap);
			
			model.addAttribute("crackdownDetail", crackdownVO);
			
			return "portal/fooddanger/CrackdownDetail";
		} catch (Exception e) {
			return StringUtil.alertRedirect(response, Message.getMessage("msg.common.system.error"));	//시스템에러가 발생하였습니다. 관리자에게 문의하십시오.
		}
	}
    
	/*******************************************수산물*************************************************/
	
	/**
	 * 수산물원산지표시위반 페이지이동
	 * @param model
	 * @param request
	 * @param response
	 * @return
	 * @throws IOException
	 */
	@RequestMapping("/portal/fooddanger/marienCrackdownList.do")
	public String marienCrackdownList(Model model, HttpServletRequest request, HttpServletResponse response) throws IOException {
		try {
			return "portal/fooddanger/MarienCrackdown";
		} catch (Exception e) {
			return StringUtil.alertRedirect(response, Message.getMessage("msg.common.system.error"));	//시스템에러가 발생하였습니다. 관리자에게 문의하십시오.
		}
	}
	
	/**
	 * 수산물원산지표시위반 목록
	 * @param model
	 * @param request
	 * @param response
	 * @return
	 * @throws IOException
	 */
	@RequestMapping("/portal/fooddanger/searchMarienCrackdownList.do")
	public void searchMarienCrackdownList(Model model, HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		Map<String, Object> paramMap = new HashMap<String, Object>();
		Map<String, Object> resultMap = new HashMap<String, Object>();
		
		try {
			paramMap.put("search_type", request.getParameter("search_type"));
			paramMap.put("search_keyword", request.getParameter("search_keyword"));
			paramMap.put("show_cnt", request.getParameter("show_cnt"));
			paramMap.put("start_idx", StringUtil.nullToStr(request.getParameter("start_idx"), "1"));
			
			resultMap = crackdownService.selectMarienCrackdownList(paramMap);
			
		} catch (Exception e) {
		}
		
		response.setContentType("text/plain; charset=\"utf-8\"");
		response.getWriter().write(new Gson().toJson(resultMap)); 
		
	}
	
	/**
	 * 수산물원산지표시위반 페이지상세
	 * @param model
	 * @param request
	 * @param response
	 * @return
	 * @throws IOException
	 */
	@RequestMapping("/popup/marienCrackdownDetail.do")
	public String marienCrackdownDetail(Model model, HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		MarienCrackdownVO marienCrackdownVO = null;
		
		try {
			Map<String, Object> paramMap = new HashMap<String, Object>();
			paramMap.put("entrps_cd", request.getParameter("entrps_cd"));
			paramMap.put("instt_cd", request.getParameter("instt_cd"));
			paramMap.put("dayrec_no", request.getParameter("dayrec_no"));
			
			marienCrackdownVO = crackdownService.selectMarienCrackdownDetail(paramMap);
			
			model.addAttribute("crackdownDetail", marienCrackdownVO);
			
			return "portal/fooddanger/CrackdownDetail";
		} catch (Exception e) {
			return StringUtil.alertRedirect(response, Message.getMessage("msg.common.system.error"));	//시스템에러가 발생하였습니다. 관리자에게 문의하십시오.
		}
	}
	
}
