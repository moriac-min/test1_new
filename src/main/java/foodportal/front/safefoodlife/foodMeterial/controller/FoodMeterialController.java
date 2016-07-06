package foodportal.front.safefoodlife.foodMeterial.controller;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import common.commonfacillity.log.CommonLog;

import foodportal.front.safefoodlife.foodMeterial.service.FoodMeterialService;
import foodportal.front.safefoodlife.foodMeterial.vo.FoodMeterialVO;

@Controller
public class FoodMeterialController {
	
	@CommonLog Logger log;
	
	@Autowired
	private FoodMeterialService foodMeterialService;
	
	@RequestMapping("/portal/safefoodlife/foodMeterial/foodMeterialDB.do")
	public String foodMeterialDB(FoodMeterialVO foodMeterialVO, Model model) throws Exception {
		if (foodMeterialVO == null) {
			foodMeterialVO = new FoodMeterialVO();
		}
		
		if (StringUtils.isEmpty(foodMeterialVO.getSearch_type()) && StringUtils.isEmpty(foodMeterialVO.getAnimal())) {
			foodMeterialVO.setSearch_type("1");
		}
		
		model.addAttribute("foodMeterialVO", foodMeterialVO);
		
		long foodMeterialListCount = 0;
		List<FoodMeterialVO> foodMeterialList = null;
		
		if (StringUtils.equals(foodMeterialVO.getSearch_type(), "2")) {
			foodMeterialListCount = foodMeterialService.selectFoodMeterialSearchListCount(foodMeterialVO);
			foodMeterialList = foodMeterialService.selectFoodMeterialSearchList(foodMeterialVO);
		}
		else {
			foodMeterialListCount = foodMeterialService.selectFoodMeterialListCount(foodMeterialVO);
			foodMeterialList = foodMeterialService.selectFoodMeterialList(foodMeterialVO);
		}
		
		model.addAttribute("foodMeterialListCount", foodMeterialListCount);
		model.addAttribute("foodMeterialList", foodMeterialList);
		return "portal/safefoodlife/foodMeterial/foodMeterialDB";
	}
	
	@RequestMapping("/portal/safefoodlife/foodMeterial/foodMeterialDBDetail.do")
	public String foodMeterialDBDetail(FoodMeterialVO foodMeterialVO, Model model) throws Exception {
		FoodMeterialVO foodMeterial = foodMeterialService.selectFoodMeterialDetail(foodMeterialVO);
		model.addAttribute("foodMeterial", foodMeterial);
		
		return "portal/safefoodlife/foodMeterial/foodMeterialDBDetail";
	}
	
}
