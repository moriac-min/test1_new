package foodportal.front.main.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import common.commonfacillity.log.CommonLog;

@Controller
public class FrontMainController {
	
	@CommonLog Logger log;
	/**
	 *포탈 메인 
	 **/
	@RequestMapping("/portal/main.do")
	public String frontMain(Model model, HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		return "/portal/main";
	}
	
	/**
	 *통합민원 메인 
	 **/
	@RequestMapping("/minwon/main.do")
	public String minwonMain(Model model, HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		return "/minwon/main";
	}
	
	/**
	 *데이터활용서비스 메인 
	 **/
	@RequestMapping("/api/main.do")
	public String apiMain(Model model, HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		return "/api/main";
	}
	
	/**
	 *우리회사안전관리 메인 
	 **/
	@RequestMapping("/csm/main.do")
	public String csmMain(Model model, HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		return "/csm/main";
	}
	
}
