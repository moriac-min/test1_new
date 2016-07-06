package foodportal.front.sympathyplus.controller;

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

import abc.cms.util.JSonUtil;

import com.google.gson.Gson;

import common.commonfacillity.log.CommonLog;
import foodportal.common.util.Message;
import foodportal.common.util.StringUtil;
import foodportal.front.common.service.FrontBoardService;
import foodportal.front.common.vo.CategoryVo;
import foodportal.front.common.vo.FrontBoardVO;
import foodportal.front.common.vo.FrontMetaKeywordVO;
import foodportal.front.common.vo.UploadFileVO;
import foodportal.front.sympathyplus.service.SympathyPlusService;
import foodportal.front.sympathyplus.vo.CalendarVo;
import foodportal.front.sympathyplus.vo.FoodStreetVO;

@Controller
public class SympathyPlusController {
	
	@CommonLog Logger log;
	
	@Autowired
	private SympathyPlusService sympathyPlusService;
	
	@Autowired
	private FrontBoardService frontBoardService;

	/**
	 * 지역별 특화거리화면
	 * @param model
	 * @param request
	 * @param response
	 * @return
	 * @throws IOException
	 */ 
	
	@RequestMapping("/portal/sympathyplus/foodStreet.do")
	public String selectFoodStreet(Model model, HttpServletRequest request, HttpServletResponse response) throws IOException {
		List<CategoryVo> ctgType01List = new ArrayList<CategoryVo>();
		FrontBoardVO paramVo = new FrontBoardVO();
		paramVo.setBbs_no("AFS01");
		try {
			
			ctgType01List = frontBoardService.selectCtgType01List(paramVo);
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
		}

		model.addAttribute("ctgType01List",ctgType01List);
		
		return "portal/sympathyplus/foodStreet";
	}
	
	/**
	 * 지역별 특화거리 목록조회
	 * @param model
	 * @param request
	 * @param response
	 * @return
	 * @throws IOException
	 */
	
	/*	@RequestMapping("/portal/sympathyplus/foodStreetList.do")
	public void selectFoodStreetList(Model model, HttpServletRequest request, HttpServletResponse response) throws IOException {

		*//**
		 * 조회조건
		 *//*
		String bbs_no = "AFS01";		//지역특화거리 게시판번호 고정
		String ctgry_no = "";	//카테고리


		Map<String, Object> resultMap = new HashMap<String, Object>();
		
		try {
			ctgry_no = StringUtil.NVLToSpace(request.getParameter("ctgry_no"));
	
			FoodStreetVO paramVo = new FoodStreetVO();
			
			//조회조건셋팅
			paramVo.setBbs_no(bbs_no);
			paramVo.setCtgry_no(ctgry_no);
			
			//글목록 + total cnt 을 map에 셋팅
			resultMap = sympathyPlusService.selectFoodStreetList(paramVo);
			
		} catch (Exception e) {
		}
		
		response.setContentType("text/plain; charset=\"utf-8\"");
		response.getWriter().write(new Gson().toJson(resultMap)); 
	}*/
	
	/**
	 * 지역별 특화거리 상세 팝업
	 * @param model
	 * @param request
	 * @param response
	 * @return
	 * @throws IOException
	 */ 
	
	@RequestMapping("/popup/sympathyplus/foodStreetDetailPopup.do")
	public String selectFoodStreetDetail(Model model, HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		FrontBoardVO paramVo = new FrontBoardVO();
		FrontBoardVO resultVo = new FrontBoardVO();
		
		paramVo.setBbs_no(StringUtil.NVLToSpace(request.getParameter("bbs_no")));
		paramVo.setNtctxt_no(StringUtil.NVLToSpace(request.getParameter("ntctxt_no")));
		System.out.println("==================>>>>>"+paramVo);
		try {
			resultVo = sympathyPlusService.selectFoodStreetDetail(paramVo);
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
		}
		model.addAttribute("result",resultVo);
		
		return "portal/sympathyplus/foodStreetDetailPopup";
	}
	
	/**
	 * 캘린더 화면
	 * @param model
	 * @param request
	 * @param response
	 * @return
	 * @throws IOException
	 */ 
	
	@RequestMapping("/portal/sympathyplus/foodSafetyCalendar.do")
	public String selectFoodSafetyCalendar(Model model, HttpServletRequest request, HttpServletResponse response) throws IOException {
		return "portal/sympathyplus/foodSafetyCalendar";
	}
	
	/**
	 * 캘린더 목록조회
	 * @param model
	 * @param request
	 * @param response
	 * @return
	 * @throws IOException
	 */ 
	
	@RequestMapping("/portal/sympathyplus/foodSafetyCalendarList.do")
	public void selectFoodSafetyCalendarList(Model model, HttpServletRequest request, HttpServletResponse response) throws IOException {
		List<CalendarVo> schList = new ArrayList<CalendarVo>();
		CalendarVo calInfo = new CalendarVo();
		CalendarVo paramVo = new CalendarVo();
		Map<String, Object> resultMap = new HashMap<String, Object>();
		paramVo.setDate_no(request.getParameter("date_no"));
		System.out.println("==================>>>>>"+paramVo.getDate_no());
		try {
			calInfo = sympathyPlusService.selectMonthCalInfo(paramVo);
			schList = sympathyPlusService.selectMonthSchList(paramVo);
			
			resultMap.put("calInfo", calInfo);
			resultMap.put("schList", schList);
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
		}
		
		response.setContentType("text/plain; charset=\"utf-8\"");
		response.getWriter().write(new Gson().toJson(resultMap));
	}
	
	/**
	 * 캘린더 팝업
	 * @param model
	 * @param request
	 * @param response
	 * @return
	 * @throws IOException
	 */ 
	
	@RequestMapping("/popup/sympathyplus/foodSafetyCalendarDetail.do")
	public String selectFoodSafetyCalendarDetail(Model model, HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		CalendarVo paramVo = new CalendarVo();
		CalendarVo resultVo = new CalendarVo();
		
		paramVo.setDate_no(StringUtil.NVLToSpace(request.getParameter("date_no")));
		paramVo.setDate_seq(StringUtil.NVLToSpace(request.getParameter("date_seq")));
		System.out.println("==================>>>>>"+paramVo.getDate_no());
		try {
			resultVo = sympathyPlusService.selectMonthSchDetail(paramVo);
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
		}
		model.addAttribute("result",resultVo);
		
		return "portal/sympathyplus/foodSafetyCalandarDetailPopup";
	}
	
	
	
    
//    /**
//     * 좋아요클릭 증가
//     * @param request
//     * @param response
//     * @throws Exception
//     */
//    @RequestMapping("/portal/board/addLike.do")
//    public void addLike(HttpServletRequest request, HttpServletResponse response) throws Exception {
//    	frontBoardService.addLike(request, response);
//    }
    
}
