package foodportal.front.sensuousmenu.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.formula.functions.Replace;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

//import sun.org.mozilla.javascript.internal.regexp.SubString;

import com.google.gson.Gson;

import foodportal.common.util.Message;
import foodportal.common.util.StringUtil;
import foodportal.front.sensuousmenu.service.SensuousService;
import foodportal.front.sensuousmenu.vo.NetizenRecipeVO;
import foodportal.front.sensuousmenu.vo.RecipeNtrtVO;
import foodportal.front.sensuousmenu.vo.RecipeThemaVO;
import foodportal.front.sensuousmenu.vo.RecipeVO;

/**
 * SensuousController
 * @author 최환
 * @since 2014.10.02
 * @version 1.0
 * @see
 * 
 * <pre>
 *  Modification Information
 *  수정일      수정자   수정내용
 *  ---------- -------- ---------------------------
 *  2014.10.02 최환 최초 생성
 * </pre>
 * 
 * Copyright (C) 2014 by NDS., All right reserved.
 */

	@Controller
	public class SensuousController {
		
	@Autowired
	private SensuousService sensuousService;

	@RequestMapping("/portal/sensuousmenu/main.do")
	public String main() {
		return "portal/sensuousmenu/main";
	}
	
	//레시피 목록 화면
	@RequestMapping("/portal/sensuousmenu/sensuousmenuList.do")
	public String sensuousmenuList(Model model, HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String hrnk_cd = request.getParameter("hrnk_cd");
		String cmmn_cd = request.getParameter("cmmn_cd");
		
		Map<String, Object> paramMap = new HashMap<String, Object>();
		Map<String, Object> titleMap = new HashMap<String, Object>();
		
		try {
			if(hrnk_cd == null || "".equals(hrnk_cd) || cmmn_cd == null || "".equals(cmmn_cd)){
				return StringUtil.alertRedirect(response, Message.getMessage("msg.common.access.role2")); 	//잘못된 접근입니다.
			}else{
				paramMap.put("cmmn_cd", request.getParameter("cmmn_cd"));
				paramMap.put("hrnk_cd", request.getParameter("hrnk_cd"));
				
				titleMap = sensuousService.selectRecipeListTitle(paramMap);
			}
		} catch (IOException e) {
		}
		
		model.addAttribute("titleMap", titleMap);
		model.addAttribute("hrnk_cd", hrnk_cd);
		model.addAttribute("cmmn_cd", cmmn_cd);
		
		return "portal/sensuousmenu/recipeList";
	}
	
	//레시피 목록 데이터 ajax
	@RequestMapping(value="/portal/sensuousmenu/selectRecipeList.do")
	public void selectRecipeList( Model model, HttpServletRequest request, HttpServletResponse response) throws Exception {

		Map<String, Object> paramMap = new HashMap<String, Object>();
		Map<String, Object> resultMap = new HashMap<String, Object>();
		
		try {
			paramMap.put("hrnk_cd", request.getParameter("hrnk_cd"));
			paramMap.put("cmmn_cd", request.getParameter("cmmn_cd"));
			paramMap.put("search_cate", request.getParameter("search_cate"));
			paramMap.put("search_keyword", request.getParameter("search_keyword"));
			paramMap.put("search_life", request.getParameter("search_life"));
			paramMap.put("show_cnt", request.getParameter("show_cnt"));
			paramMap.put("start_idx", StringUtil.nullToStr(request.getParameter("start_idx"), "1"));
			paramMap.put("order", "defalt");
			
			resultMap = sensuousService.selectRecipeList(paramMap, null);
			
		} catch (Exception e) {
		}
		
		response.setContentType("text/plain; charset=\"utf-8\"");
		response.getWriter().write(new Gson().toJson(resultMap)); 
	}
	
	//레시피 목록 데이터 - 상단 목록 ajax
	@RequestMapping(value="/portal/sensuousmenu/selectRecipeTopList.do")
	public void selectRecipeTopList( Model model, HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		Map<String, Object> paramMap = new HashMap<String, Object>();
		Map<String, Object> resultMap = new HashMap<String, Object>();
		
		try {
			paramMap.put("hrnk_cd", request.getParameter("hrnk_cd"));
			paramMap.put("cmmn_cd", request.getParameter("cmmn_cd"));
			paramMap.put("search_cate", request.getParameter("search_cate"));
			paramMap.put("search_keyword", request.getParameter("search_keyword"));
			
			resultMap = sensuousService.selectRecipeList(paramMap, "top");
			
		} catch (Exception e) {
		}
		
		response.setContentType("text/plain; charset=\"utf-8\"");
		response.getWriter().write(new Gson().toJson(resultMap)); 
	}
	
	//레시피 상세 화면
	@RequestMapping("/portal/sensuousmenu/sensuousmenuView.do")
	public String sensuousmenuView(Model model, HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String hrnk_cd = request.getParameter("hrnk_cd");
		String cmmn_cd = request.getParameter("cmmn_cd");
		String rcp_menu_no = request.getParameter("rcp_menu_no");
		
		Map<String, Object> paramMap = new HashMap<String, Object>();
		Map<String, Object> titleMap = new HashMap<String, Object>();
		List<Map<String, Object>> recipeNewList = new ArrayList<Map<String, Object>>();
		List<Map<String, Object>> recipeLikeList = new ArrayList<Map<String, Object>>();
		List<RecipeVO> purpList = new ArrayList<RecipeVO>();
		List<RecipeVO> nutList = new ArrayList<RecipeVO>();
		
		//jsp 페이지
		String returnPage = "portal/sensuousmenu/recipeChildView";

		try {
			if(hrnk_cd == null || "".equals(hrnk_cd) 
					|| cmmn_cd == null || "".equals(cmmn_cd)
					|| rcp_menu_no == null || "".equals(rcp_menu_no)){
				return StringUtil.alertRedirect(response, Message.getMessage("msg.common.access.role2")); 	//잘못된 접근입니다.
			}else{
				paramMap.put("cmmn_cd", request.getParameter("cmmn_cd"));
				paramMap.put("hrnk_cd", request.getParameter("hrnk_cd"));
				paramMap.put("rcp_menu_no", request.getParameter("rcp_menu_no"));
				
				//타이틀
				titleMap = sensuousService.selectRecipeListTitle(paramMap);
				
				//레시피정보
				RecipeVO recipeInfoVO = sensuousService.selectRecipeView(paramMap);
				
				//신규 레시피
				recipeNewList = (List<Map<String, Object>>) sensuousService.selectRecipeList(paramMap, "new").get("list");
				
				//인기 레시피
				recipeLikeList = (List<Map<String, Object>>) sensuousService.selectRecipeList(paramMap, "like").get("list");
				
				//조회수 업데이트
				sensuousService.updateRecipeCount(paramMap);
				
				model.addAttribute("hrnk_cd", hrnk_cd);
				model.addAttribute("cmmn_cd", cmmn_cd);
				model.addAttribute("titleMap", titleMap);
				model.addAttribute("recipeInfoVO", recipeInfoVO);
				model.addAttribute("recipeNewList", recipeNewList);
				model.addAttribute("recipeLikeList", recipeLikeList);
				
				String them_cd = recipeInfoVO.getRcp_menu_them_cd();
				//녹색식단의 경우
				if("RC_THEM01".equals(them_cd)){
					//개발목적
					purpList = sensuousService.selectPurpList(paramMap);
					//제철재료
					nutList = sensuousService.selectNutList(paramMap);
					
					model.addAttribute("purpList", purpList);
					model.addAttribute("nutList", nutList);
					
					returnPage = "portal/sensuousmenu/recipeGreenView";
				}
			}
		} catch (IOException e) {
		}
		
		return returnPage;
	}
	
	//레시피 상세 화면 - 팝업
	@RequestMapping("/popup/sensuousmenuView.do")
	public String sensuousmenuViewPop(Model model, HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String rcp_menu_no = request.getParameter("rcp_menu_no");
		
		Map<String, Object> paramMap = new HashMap<String, Object>();
		List<RecipeVO> purpList = new ArrayList<RecipeVO>();
		List<RecipeVO> nutList = new ArrayList<RecipeVO>();
		
		//jsp 페이지
		String returnPage = "";
		
		try {
			if(rcp_menu_no == null || "".equals(rcp_menu_no)){
				return StringUtil.alertRedirect(response, Message.getMessage("msg.common.access.role2")); 	//잘못된 접근입니다.
			}else{
				paramMap.put("cmmn_cd", request.getParameter("cmmn_cd"));
				paramMap.put("hrnk_cd", request.getParameter("hrnk_cd"));
				paramMap.put("rcp_menu_no", request.getParameter("rcp_menu_no"));
				
				//레시피정보
				RecipeVO recipeInfoVO = sensuousService.selectRecipeView(paramMap);
				
				//조회수 업데이트
				sensuousService.updateRecipeCount(paramMap);
				
				model.addAttribute("recipeInfoVO", recipeInfoVO);
				
				String knd = recipeInfoVO.getRcp_menu_knd();
				//녹색식단의 경우
				if("1".equals(knd)){
					//개발목적
					purpList = sensuousService.selectPurpList(paramMap);
					//제철재료
					nutList = sensuousService.selectNutList(paramMap);
					
					model.addAttribute("purpList", purpList);
					model.addAttribute("nutList", nutList);
					
					returnPage = "portal/sensuousmenu/recipeGreenViewPop";
				}else if("2".equals(knd)){
					returnPage = "portal/sensuousmenu/recipeGeneralViewPop";
				}
			}
		} catch (IOException e) {
		}
		
		return returnPage;
	}
	
	//단순 html - 팝업
	@RequestMapping("/popup/aboutPopup.do")
	public String aboutPopup( Model model, HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String returnPage = "";
		String type = request.getParameter("type");
		
		if("greenDiet".equals(type)){
			returnPage = "portal/sensuousmenu/aboutGreenDiet";
		}
		else if("greenMenu".equals(type)){
			returnPage = "portal/sensuousmenu/aboutGreenMenu";
		}
		else if("kidsMenu".equals(type)){
			returnPage = "portal/sensuousmenu/aboutKidsMenu";
		}
		else if("lowna".equals(type)){
			returnPage = "portal/sensuousmenu/aboutLowna";
		}
		else if("market".equals(type)){
			Map<String, Object> paramMap = new HashMap<String, Object>();
			paramMap.put("gren_sche_seas_cd", request.getParameter("gren_sche_seas_cd"));
			paramMap.put("gren_sche_lifecyc_cd", request.getParameter("gren_sche_lifecyc_cd"));
			paramMap.put("gren_sche_week", request.getParameter("gren_sche_week"));
			
			RecipeThemaVO themaVO = sensuousService.selectThemaMenuList(paramMap);
			
			model.addAttribute("themaVO", themaVO);
			
			returnPage = "portal/sensuousmenu/market";
		}
		
		return returnPage;
	}
	
	//레시피 추천 ajax
	@RequestMapping(value="/front/sensuousmenu/updateRecipeLike.do")
	public void updateRecipeLike( Model model, HttpServletRequest request, HttpServletResponse response) throws Exception {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		Map<String, Object> resultMap = new HashMap<String, Object>();
		int result = 0;
		String resultStr = "";
		
		try {
			String user_ip = request.getHeader("HTTP_X_FORWARDED_FOR");
			if(user_ip == null || user_ip.length() == 0 || user_ip.toLowerCase().equals("unknown")){
				user_ip = request.getHeader("REMOTE_ADDR");
			}
			if(user_ip == null || user_ip.length() == 0 || user_ip.toLowerCase().equals("unknown")){
				user_ip = request.getRemoteAddr();
			}
			
			paramMap.put("no", request.getParameter("no"));
			paramMap.put("dvs_cd", request.getParameter("dvs_cd"));
			paramMap.put("user_ip", user_ip);
			
			result = sensuousService.updateRecipeLike(paramMap);
			
			if(result == 2){
				resultStr = "메뉴를 추천하였습니다.";
			} else if(result == 0){
				resultStr = "이미 추천한 메뉴입니다.";
			} else {
				resultStr = "추천에 문제가 발생하였습니다.";
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		resultMap.put("resultStr", resultStr);
		resultMap.put("result", result);
		
		response.setContentType("text/plain; charset=\"utf-8\"");
		response.getWriter().write(new Gson().toJson(resultMap));
	}
	
	//테마식단
	@RequestMapping("/portal/sensuousmenu/themaMenu.do")
	public String themaMenu(Model model, HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		// 계절 및 연령대 값
		String gren_sche_seas_cd = request.getParameter("gren_sche_seas_cd");
		if(gren_sche_seas_cd == null || "".equals(gren_sche_seas_cd)){
			gren_sche_seas_cd = "RC_SEAS01";
		}
		String gren_sche_lifecyc_cd = request.getParameter("gren_sche_lifecyc_cd");
		if(gren_sche_lifecyc_cd == null || "".equals(gren_sche_lifecyc_cd)){
			gren_sche_lifecyc_cd = "RC_LIFE02";
		}
		int gren_sche_week = request.getParameter("gren_sche_week")==null?1:Integer.parseInt(request.getParameter("gren_sche_week"));
		
		Map<String, Object> paramMap = new HashMap<String, Object>();
		RecipeThemaVO themaVO = new RecipeThemaVO();
		List<RecipeThemaVO> themaRecipeList = new ArrayList<RecipeThemaVO>();
		List<RecipeThemaVO> themaWeekList = new ArrayList<RecipeThemaVO>();
		
		try {
			paramMap.put("gren_sche_seas_cd", gren_sche_seas_cd);
			paramMap.put("gren_sche_lifecyc_cd", gren_sche_lifecyc_cd);
			paramMap.put("gren_sche_week", gren_sche_week);
			
			//태마식단 리스트
			themaVO = sensuousService.selectThemaMenuList(paramMap);
			themaRecipeList = sensuousService.selectThemaRecipoeList(paramMap);
			
			//테마식단 주차 유무 확인
			themaWeekList = sensuousService.selectThemaWeekList(paramMap);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		model.addAttribute("gren_sche_seas_cd", gren_sche_seas_cd);
		model.addAttribute("gren_sche_lifecyc_cd", gren_sche_lifecyc_cd);
		model.addAttribute("gren_sche_week", gren_sche_week);
		model.addAttribute("themaVO", themaVO);
		model.addAttribute("themaRecipeList", themaRecipeList);
		model.addAttribute("themaWeekList", themaWeekList);
		
		return "portal/sensuousmenu/recipeThemaMenu";
	}
	
	//제철재료
	@RequestMapping("/portal/sensuousmenu/recipeNtrtList.do")
	public String recipeNtrtList(Model model, HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		Map<String, Object> paramMap = new HashMap<String, Object>();
		List<RecipeNtrtVO> recipeNtrtList = new ArrayList<RecipeNtrtVO>();
		
		try {
			recipeNtrtList = sensuousService.selectRecipoeNtrtList(paramMap);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		model.addAttribute("recipeNtrtList", recipeNtrtList);
		
		return "portal/sensuousmenu/recipeNtrtList";
	}
	
	//제철재료 상세(팝업)
	@RequestMapping("/popup/recipeNtrtDetail.do")
	public String recipeNtrtDetail(Model model, HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		Map<String, Object> paramMap = new HashMap<String, Object>();
		RecipeNtrtVO recipeNtrtInfo = new RecipeNtrtVO();
		
		try {
			paramMap.put("food_ntrt_no", request.getParameter("food_ntrt_no"));
			
			recipeNtrtInfo = sensuousService.selectRecipoeNtrtInfo(paramMap);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		model.addAttribute("recipeNtrtInfo", recipeNtrtInfo);
		
		return "portal/sensuousmenu/recipeNtrtInfoPop";
	}
	
	/*************************************************** 네티즌  ****************************************************/
	
	/**
	 * 네티즌 레시피 목록
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping("/portal/sensuousmenu/netizenRecipeList.do")
	public String netizenRecipeList(Model model, HttpServletRequest request, HttpServletResponse response) throws Exception {
		try {

			return "portal/sensuousmenu/netizenRecipeList";
			
		} catch (Exception e) {
			return StringUtil.alertRedirect(response, Message.getMessage("msg.common.system.error"));	//시스템에러가 발생하였습니다. 관리자에게 문의하십시오.
		}
	}
	
	/**
	 * 네티즌 레시피 목록 AJAX
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(value="/portal/sensuousmenu/selectNetizenRecipeList.do")
	public void selectNetizenRecipeList(Model model, HttpServletRequest request, HttpServletResponse response) throws Exception {

    	Map<String, Object> paramMap = new HashMap<String, Object>();
    	Map<String, Object> resultMap = new HashMap<String, Object>();

		try {
			paramMap.put("search_cate", request.getParameter("search_cate"));
			paramMap.put("search_keyword", request.getParameter("search_keyword"));
			paramMap.put("show_cnt", StringUtil.NVLToSpace(request.getParameter("show_cnt")));
			paramMap.put("start_idx", StringUtil.nullToStr(request.getParameter("start_idx"), "1"));
			paramMap.put("order", StringUtil.nullToStr(request.getParameter("order"), "lat"));
			
			resultMap = sensuousService.selectNetizenRecipeList(paramMap, null);
		
		} catch (IOException e) {
		}
		
    	response.setContentType("text/plain; charset=\"utf-8\"");
		response.getWriter().write(new Gson().toJson(resultMap));
	}	
	
	/**
	 * 네티즌 베스트 레시피 목록 AJAX
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(value="/portal/sensuousmenu/selectNetizenBestRecipeList.do")
	public void selectNetizenBestRecipeList(Model model, HttpServletRequest request, HttpServletResponse response) throws Exception {

    	Map<String, Object> paramMap = new HashMap<String, Object>();
    	Map<String, Object> resultMap = new HashMap<String, Object>();

		try {
			paramMap.put("best_rcp_no", request.getParameter("best_rcp_no"));
			resultMap = sensuousService.selectNetizenBestRecipeList(paramMap);
		} catch (IOException e) {
			
		}
		
    	response.setContentType("text/plain; charset=\"utf-8\"");
		response.getWriter().write(new Gson().toJson(resultMap));
	}
	
	/**
	 * 레시피 작성
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping("/portal/sensuousmenu/recipeWrite.do")
	public String recipeWrite(Model model, HttpServletRequest request, HttpServletResponse response) throws Exception {

		try {
			String user_id;
			user_id = "cyk";
			Calendar calendar = Calendar.getInstance();
			SimpleDateFormat dateFormat = new SimpleDateFormat("YYYY.MM.dd");

			model.addAttribute("neti_rcp_no", request.getParameter("neti_rcp_no"));
			model.addAttribute("now_date", dateFormat.format(calendar.getTime()));
			model.addAttribute("user_id", user_id);
			return "portal/sensuousmenu/recipeWrite";
			
		} catch (Exception e) {
			return StringUtil.alertRedirect(response, Message.getMessage("msg.common.system.error"));	//시스템에러가 발생하였습니다. 관리자에게 문의하십시오.
		}
	}
	
	@RequestMapping(value="/portal/sensuousmenu/selectRecipeWrite.do")
	public void selectRecipeWrite(Model model, HttpServletRequest request, HttpServletResponse response) throws Exception {

    	Map<String, Object> paramMap = new HashMap<String, Object>();
    	Map<String, Object> resultMap = new HashMap<String, Object>();

		try {
			paramMap.put("neti_rcp_no", request.getParameter("neti_rcp_no"));
			resultMap = sensuousService.selectRecipeWrite(paramMap);
		} catch (IOException e) {
		}
		
    	response.setContentType("text/plain; charset=\"utf-8\"");
		response.getWriter().write(new Gson().toJson(resultMap));
	}
	
	/**
	 * 레시피 저장
	 * @param complainVO
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping("/portal/sensuousmenu/saveNetizenRecipe.do")
	public void saveNetizenRecipe(NetizenRecipeVO netizenRecipeVO, HttpServletRequest request, HttpServletResponse response) throws Exception {
		Map<String, Object> rtnMap = new HashMap<String, Object>();
		   
		netizenRecipeVO.setNeti_rcp_cook_nm(request.getParameter("title"));
		netizenRecipeVO.setNeti_rcp_cook_thma(request.getParameter("dscr"));
		netizenRecipeVO.setNeti_rcp_cook_mate(request.getParameter("ingredients"));
		netizenRecipeVO.setNeti_rcp_saus(request.getParameter("source"));
		netizenRecipeVO.setNeti_rcp_cn(request.getParameter("recipe-content"));
		netizenRecipeVO.setNeti_rcp_tag(request.getParameter("tag"));
		netizenRecipeVO.setAtch_file_no(request.getParameter("atch_file_no"));
		
		netizenRecipeVO.setNeti_rcp_filenm(request.getParameter("logic_file_nm"));
		
		netizenRecipeVO.setCretr_id("cyk");		//임시
		netizenRecipeVO.setLast_updtr_id("cyk");//임시

		rtnMap = sensuousService.saveNetizenRecipe(netizenRecipeVO);
		
		response.setContentType("text/plain; charset=\"utf-8\"");
		response.getWriter().write(new Gson().toJson(rtnMap));
	}		
	
	/**
	 * 네티즌 레시피 상세
	 * @param complainVO
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping("/portal/sensuousmenu/netizenRecipe.do")
	public String netizenRecipe(Model model, HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String neti_rcp_no = request.getParameter("neti_rcp_no");
		
		Map<String, Object> paramMap = new HashMap<String, Object>();
		List<Map<String, Object>> netizenRecipeLatList = new ArrayList<Map<String, Object>>();
		List<Map<String, Object>> netizenRecipePopList = new ArrayList<Map<String, Object>>();
		
		//jsp 페이지
		String returnPage = "portal/sensuousmenu/netizenRecipe";

		try {
			paramMap.put("neti_rcp_no", request.getParameter("neti_rcp_no"));
			
			//네티즌 레시피정보
			NetizenRecipeVO netizenRecipeVO = sensuousService.selectNetizenRecipe(paramMap);
			
			netizenRecipeVO.setType_cd(request.getParameter("type_cd"));
			//신규 레시피
			netizenRecipeLatList = (List<Map<String, Object>>) sensuousService.selectNetizenRecipeList(paramMap, "lat").get("list");
			
			//인기 레시피
			netizenRecipePopList = (List<Map<String, Object>>) sensuousService.selectNetizenRecipeList(paramMap, "pop").get("list");
			
			//조회수 업데이트
			sensuousService.updateNetizenRecipeCount(paramMap);
			model.addAttribute("netizenRecipeVO", netizenRecipeVO);
			model.addAttribute("netizenRecipeLatList", netizenRecipeLatList);
			model.addAttribute("netizenRecipePopList", netizenRecipePopList);
			
		} catch (IOException e) {
		}
		
		return returnPage;
	}	
	
	/**
	 * 나의 레시피 목록
	 * @param complainVO
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping("/portal/sensuousmenu/myRecipeList.do")
	public String myRecipeList(Model model, HttpServletRequest request, HttpServletResponse response) throws Exception {
		try {

			return "portal/sensuousmenu/myRecipeList";
			
		} catch (Exception e) {
			return StringUtil.alertRedirect(response, Message.getMessage("msg.common.system.error"));	//시스템에러가 발생하였습니다. 관리자에게 문의하십시오.
		}
	}
	
	/**
	 * 나의 레시피 목록 AJAX
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(value="/portal/sensuousmenu/selectMyRecipeList.do")
	public void selectMyRecipeList(Model model, HttpServletRequest request, HttpServletResponse response) throws Exception {

    	Map<String, Object> paramMap = new HashMap<String, Object>();
    	Map<String, Object> resultMap = new HashMap<String, Object>();

		try {
			paramMap.put("search_cate", request.getParameter("search_cate"));
			paramMap.put("search_keyword", request.getParameter("search_keyword"));
			paramMap.put("show_cnt", StringUtil.NVLToSpace(request.getParameter("show_cnt")));
			paramMap.put("start_idx", StringUtil.nullToStr(request.getParameter("start_idx"), "1"));
			
			resultMap = sensuousService.selectMyRecipeList(paramMap);
		
		} catch (IOException e) {
		}
		
    	response.setContentType("text/plain; charset=\"utf-8\"");
		response.getWriter().write(new Gson().toJson(resultMap));
	}	
	
	/**
	 * 나의 레시피 목록 AJAX
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(value="/portal/sensuousmenu/selectCheck.do")
	public void selectCheck(Model model, HttpServletRequest request, HttpServletResponse response) throws Exception {

    	Map<String, Object> resultMap = new HashMap<String, Object>();

    	int resultCd = 0;
    	String resultStr = "";
		String paramDate = request.getParameter("date");
		String type = request.getParameter("type");
		
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat dateFormat = new SimpleDateFormat("YYYYMM");
		String nowDate = dateFormat.format(calendar.getTime());
		
		if(paramDate.equals(nowDate)){
			resultCd = 1;
		}else{
			resultCd = 2;
			resultStr = "수정/삭제 기간이 지났습니다.";
		}
		
		resultMap.put("resultCd", resultCd);
		resultMap.put("resultStr", resultStr);
		
    	response.setContentType("text/plain; charset=\"utf-8\"");
		response.getWriter().write(new Gson().toJson(resultMap));
	}
	
	/**
	 * 네티즌 레시피 삭제 AJAX
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(value="/portal/sensuousmenu/deleteRecipe.do")
	public void deleteRecipe(Model model, HttpServletRequest request, HttpServletResponse response) throws Exception {

		String resultStr = "";
    	Map<String, Object> paramMap = new HashMap<String, Object>();
    	Map<String, Object> resultMap = new HashMap<String, Object>();
    	paramMap.put("neti_rcp_no", request.getParameter("neti_rcp_no"));
		try {
			resultMap = sensuousService.deleteRecipe(paramMap);
		} catch (IOException e) {
		}
		
		resultStr = "삭제를 실패했습니다.";
		resultMap.put("resultStr", resultStr);
    	response.setContentType("text/plain; charset=\"utf-8\"");
		response.getWriter().write(new Gson().toJson(resultMap));
	}
}
