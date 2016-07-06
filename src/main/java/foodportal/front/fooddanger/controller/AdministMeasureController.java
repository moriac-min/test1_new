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
import foodportal.front.fooddanger.service.AdministMeasureService;
import foodportal.front.fooddanger.vo.AdministMeasureVO;

@Controller
public class AdministMeasureController {
	
	@CommonLog Logger log;
	@Autowired
	private AdministMeasureService administMeasureService;
	
	/**
	 * 행정처분 페이지이동
	 * @param model
	 * @param request
	 * @param response
	 * @return
	 * @throws IOException
	 */
	@RequestMapping("/portal/fooddanger/administMeasureList.do")
	public String administMeasureList(Model model, HttpServletRequest request, HttpServletResponse response) throws IOException {
		try {
			return "portal/fooddanger/AdministMeasure";
		} catch (Exception e) {
			return StringUtil.alertRedirect(response, Message.getMessage("msg.common.system.error"));	//시스템에러가 발생하였습니다. 관리자에게 문의하십시오.
		}
	}
	
	/**
	 * 행정처분 목록
	 * @param model
	 * @param request
	 * @param response
	 * @return
	 * @throws IOException
	 */
	@RequestMapping("/portal/fooddanger/searchAdministMeasureList.do")
	public void searchAdministMeasureList(Model model, HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		Map<String, Object> paramMap = new HashMap<String, Object>();
		Map<String, Object> resultMap = new HashMap<String, Object>();
		
		try {
			paramMap.put("search_type", request.getParameter("search_type"));
			paramMap.put("search_keyword", request.getParameter("search_keyword"));
			paramMap.put("show_cnt", request.getParameter("show_cnt"));
			paramMap.put("start_idx", StringUtil.nullToStr(request.getParameter("start_idx"), "1"));
			
			resultMap = administMeasureService.selectAdministMeasureList(paramMap);
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
	 * 행정처분 페이지상세
	 * @param model
	 * @param request
	 * @param response
	 * @return
	 * @throws IOException
	 */
	@RequestMapping("/popup/administMeasureDetail.do")
	public String administMeasureDetail(Model model, HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		AdministMeasureVO administMeasureVO = null;
		
		try {
			Map<String, Object> paramMap = new HashMap<String, Object>();
			paramMap.put("aplc_seq", request.getParameter("aplc_seq"));
			paramMap.put("prdlst_ordno", request.getParameter("prdlst_ordno"));
			
			administMeasureVO = administMeasureService.selectAdministMeasureDetail(paramMap);
			
			model.addAttribute("administMeasureDetail", administMeasureVO);
			
			return "portal/fooddanger/administMeasureDetail";
		} catch (Exception e) {
			return StringUtil.alertRedirect(response, Message.getMessage("msg.common.system.error"));	//시스템에러가 발생하였습니다. 관리자에게 문의하십시오.
		}
	}
   
	
}
