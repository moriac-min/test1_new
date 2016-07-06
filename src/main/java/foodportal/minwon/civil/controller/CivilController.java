package foodportal.minwon.civil.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import common.commonfacillity.log.CommonLog;
import foodportal.common.util.StringUtil;
import foodportal.minwon.civil.service.CivilService;


@Controller
public class CivilController {
	
	@CommonLog Logger log;
	
	@Autowired
	private CivilService civilservice;

	/**
	 * 전자민원창구 화면
	 * @param model
	 * @param request
	 * @param response
	 * @return
	 * @throws IOException
	 */ 
	
	@RequestMapping("/minwon/civil.do")
	public String selectCivilMain(Model model, HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		return "minwon/civil/civilList";
	}
	
	@RequestMapping("/minwon/civilTest.do")
	public String selectCivilTest(Model model, HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		return "minwon/civil/civilTest";
	}
    
}
