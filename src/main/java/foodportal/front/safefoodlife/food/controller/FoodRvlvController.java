package foodportal.front.safefoodlife.food.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import common.commonfacillity.log.CommonLog;
import foodportal.common.util.StringUtil;
import foodportal.front.safefoodlife.food.service.FoodRvlvService;
import foodportal.front.safefoodlife.food.vo.FoodRvlvVO;
import foodportal.front.safefoodlife.food.vo.FoodTypeChngQnaVO;
import foodportal.front.safefoodlife.food.vo.FoodTypeChngVO;

@Controller
public class FoodRvlvController {
	
	@CommonLog Logger log;
	
	@Autowired
	private FoodRvlvService foodRvlvService;
	
	@RequestMapping("/portal/safefoodlife/food/foodRvlv/foodRvlv.do")
	public String foodRvlv(Model model, HttpServletRequest request, HttpServletResponse response) throws Exception {
		String search_word = StringUtil.NVLToSpace(request.getParameter("search_word"));
		model.addAttribute("search_word", search_word);
		
		FoodRvlvVO foodRvlvVO = new FoodRvlvVO();
		List<FoodRvlvVO> foodRvlvTopList = foodRvlvService.selectFoodRvlvTopList(foodRvlvVO);
		model.addAttribute("foodRvlvTopList", foodRvlvTopList);
		
		String rvlv_no = StringUtil.NVLToSpace(request.getParameter("rvlv_no"));
		foodRvlvVO.setRvlv_no(rvlv_no);
		
		List<FoodRvlvVO> foodRvlvList = null;
		if (StringUtils.isEmpty(search_word)) {
			foodRvlvList = foodRvlvService.selectFoodRvlvList(foodRvlvVO);
		}
		else {
			foodRvlvVO.setSearch_word(search_word);
			foodRvlvList = foodRvlvService.selectFoodRvlvSearchList(foodRvlvVO);
		}
		model.addAttribute("foodRvlvList", foodRvlvList);
		
		return "portal/safefoodlife/food/foodRvlv";
	}
	
	@RequestMapping("/portal/safefoodlife/food/foodRvlv/foodRvlvDetail.do")
	public String foodRvlvDetail(Model model, HttpServletRequest request, HttpServletResponse response) throws Exception {
		FoodRvlvVO foodRvlvVO = new FoodRvlvVO();
		
		String rvlv_no = StringUtil.NVLToSpace(request.getParameter("rvlv_no"));
		foodRvlvVO.setRvlv_no(rvlv_no);
		
		FoodRvlvVO foodRvlvDetail = foodRvlvService.selectFoodRvlvDetail(foodRvlvVO);
		model.addAttribute("foodRvlvDetail", foodRvlvDetail);
		
		FoodRvlvVO foodRvlvPath = foodRvlvService.selectFoodRvlvPath(foodRvlvVO);
		model.addAttribute("foodRvlvPath", foodRvlvPath);
		
		return "portal/safefoodlife/food/foodRvlvDetail";
	}

	@RequestMapping("/portal/safefoodlife/food/foodRvlv/overallReformTypeInfo.do")
	public String overallReformTypeInfo(Model model, HttpServletRequest request, HttpServletResponse response) throws Exception {
		String search_word = StringUtil.NVLToSpace(request.getParameter("search_word"));
		model.addAttribute("search_word", search_word);
		
		FoodTypeChngVO foodTypeChngVO = new FoodTypeChngVO();
		foodTypeChngVO.setSearch_word(search_word);
		List<FoodTypeChngVO> foodTypeChngList = foodRvlvService.selectFoodTypeChngList(foodTypeChngVO);
		model.addAttribute("foodTypeChngList", foodTypeChngList);
		
		FoodTypeChngQnaVO foodTypeChngQnaVO = new FoodTypeChngQnaVO();
		foodTypeChngQnaVO.setSearch_word(search_word);
		List<FoodTypeChngQnaVO> foodTypeChngQnaList = foodRvlvService.selectFoodTypeChngQnaList(foodTypeChngQnaVO);
		model.addAttribute("foodTypeChngQnaList", foodTypeChngQnaList);
		
		return "portal/safefoodlife/food/overallReformTypeInfo";
	}
}
