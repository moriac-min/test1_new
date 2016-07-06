package foodportal.front.healthyfoodlife.controller;

import java.io.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;

import common.commonfacillity.log.CommonLog;
import foodportal.common.util.Message;
import foodportal.common.util.StringUtil;
import foodportal.front.healthyfoodlife.service.GMOService;
import foodportal.front.healthyfoodlife.vo.ExamOrgnVO;
import foodportal.front.healthyfoodlife.vo.ExamStateVO;

@Controller
public class GMOController {

	@CommonLog Logger log;
	@Autowired GMOService gmoService;
		
	/**
	 * 심사현황 목록 페이지이동
	 * @param model
	 * @param request
	 * @param response
	 * @return
	 * @throws IOException
	 */
	@RequestMapping("/portal/healthyfoodlife/examState.do")
	public String ExamState(Model model, HttpServletRequest request, HttpServletResponse response) throws Exception{
		
		try{
			return "portal/healthyfoodlife/examState";
		}catch(Exception e){	
			return StringUtil.alertRedirect(response, Message.getMessage("msg.common.system.error"));	//시스템에러가 발생하였습니다. 관리자에게 문의하십시오.
		}	
	}
	
	/**
	 * 심사현황 목록 조회
	 * @param model
	 * @param request
	 * @param response
	 * @return
	 * @throws IOException
	 */
	@RequestMapping("/portal/healthyfoodlife/searchExamStateList.do")
	public void searchExamStateList(Model model, HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		Map<String, Object> paramMap = new HashMap<String, Object>();
		Map<String, Object> resultMap = new HashMap<String, Object>();
			
		try{
			
			resultMap = gmoService.selectExamState(paramMap);
			
		}catch(Exception e){		
		}
		
		response.setContentType("text/plain; charset=\"utf-8\"");
		response.getWriter().write(new Gson().toJson(resultMap));
	}
	
	/**
	 * 심사현황 페이지상세
	 * @param model
	 * @param request
	 * @param response
	 * @return
	 * @throws IOException
	 */
	@RequestMapping("/portal/healthyfoodlife/examStateDetail.do")
	public String selectExamStateDetail(Model model, HttpServletRequest request, HttpServletResponse response) throws Exception{
		
		Map<String, Object> paramMap = new HashMap<String, Object>();
		Map<String, Object> resultMap = new HashMap<String, Object>();
		
		try{
			
			resultMap = gmoService.selectExamStateDetail(paramMap);
			
			return "portal/healthyfoodlife/examOrgnDetail";
			
		}catch(Exception e){
			return StringUtil.alertRedirect(response, Message.getMessage("msg.common.system.error"));	//시스템에러가 발생하였습니다. 관리자에게 문의하십시오.
		}
	}
	
	/**
	 * 검사기관 목록 페이지이동
	 * @param model
	 * @param request
	 * @param response
	 * @return
	 * @throws IOException
	 */
	@RequestMapping("/portal/healthyfoodlife/examOrgn.do")
	public String selectExamOrgn(Model model, HttpServletRequest request, HttpServletResponse response) throws Exception{
	
		try{
			return "portal/healthyfoodlife/examOrgn";
		}catch(Exception e){
			return StringUtil.alertRedirect(response, Message.getMessage("msg.common.system.error"));	//시스템에러가 발생하였습니다. 관리자에게 문의하십시오.
		}
	}
	
	/**
	 * 검사기관 목록
	 * @param model
	 * @param request
	 * @param response
	 * @return
	 * @throws IOException
	 */
	@RequestMapping("/portal/healthyfoodlife/searchExamOrgn.do")
	public void searchExamOrgn(Model model, HttpServletRequest request, HttpServletResponse response) throws Exception{
		
		Map<String, Object> paramMap = new HashMap<String, Object>();
		Map<String, Object> resultMap = new HashMap<String, Object>();
		
		try{
		
			resultMap = gmoService.selectExamOrgn(paramMap);
		}catch(Exception e){
		}
		
		response.setContentType("text/plain; charset=\"utf-8\"");
		response.getWriter().write(new Gson().toJson(resultMap));
	}
	
	/**
	 * 검사기관 페이지상세
	 * @param model
	 * @param request
	 * @param response
	 * @return
	 * @throws IOException
	 */
	@RequestMapping("/portal/healthyfoodlife/examOrgnDetail.do")
	public String examOrgnDetail(Model model, HttpServletRequest request, HttpServletResponse response)throws Exception{
		
		Map<String, Object> resultMap = new HashMap<String, Object>();
		Map<String, Object> paramMap = new HashMap<String, Object>();	
		
		try{			
			
			resultMap = gmoService.selectExamOrgnDetail(paramMap);
			
			
			return "portal/healthyfoodlife/examOrgnDetail";
		}catch(Exception e){
			return StringUtil.alertRedirect(response, Message.getMessage("msg.common.system.error"));	//시스템에러가 발생하였습니다. 관리자에게 문의하십시오.
		}	
	}
}
