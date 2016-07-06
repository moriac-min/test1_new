package foodportal.front.specialinfo.controller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;

import common.commonfacillity.log.CommonLog;
import foodportal.common.util.Message;
import foodportal.common.util.StringUtil;
import foodportal.front.specialinfo.service.TermDictionaryService;
import foodportal.front.specialinfo.vo.TermDictionaryVO;

@Controller
public class TermDictionaryController {

	@CommonLog Logger log;
	@Autowired
	private TermDictionaryService termDictionaryService;
	
	/**
	 * 용어사전
	 * @param model
	 * @param request
	 * @param response
	 * @return
	 * @throws IOException
	 */
	@RequestMapping("/portal/termdictionary/termList.do")
	public String termList(Model model, HttpServletRequest request, HttpServletResponse response) throws Exception{
		try {
			return "portal/specialinfo/termDictionary";
		} catch (Exception e) {
			return StringUtil.alertRedirect(response, Message.getMessage("msg.common.system.error"));	//시스템에러가 발생하였습니다. 관리자에게 문의하십시오.
		}
	}
	
	@RequestMapping(value="/portal/termdictionary/termAjaxList.do", method=RequestMethod.POST)
	public @ResponseBody void termAjaxList(TermDictionaryVO termDictionaryVO, HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		Map<String, Object> termMap = termDictionaryService.selectTermList(termDictionaryVO);
		
		response.setContentType("text/plain;charset=utf-8");
		response.getWriter().write(new Gson().toJson(termMap));
	}
	
	@RequestMapping(value="/portal/termdictionary/termAjaxDetail.do", method=RequestMethod.POST)
	public @ResponseBody void termAjaxDetail(TermDictionaryVO termDictionaryVO, HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		Map<String, Object> termMap = termDictionaryService.selectTermDetail(termDictionaryVO);
		
		response.setContentType("text/plain;charset=utf-8");
		response.getWriter().write(new Gson().toJson(termMap));
	}
	
}
