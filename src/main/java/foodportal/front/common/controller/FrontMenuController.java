package foodportal.front.common.controller;

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

import com.google.gson.Gson;

import common.commonfacillity.log.CommonLog;
import foodportal.common.util.StringUtil;
import foodportal.front.common.service.FrontMenuService;
import foodportal.front.common.vo.FrontMenuVO;

@Controller
public class FrontMenuController {
	
	@CommonLog Logger log;
	@Autowired
	private FrontMenuService frontMenuService;
	
    /**
     * PORTAL GNB 리스트
     * @param request
     * @param response
     * @throws Exception
     */
	
	@RequestMapping("*/gnb.do")
    public String selectPortalGnbList(Model model, HttpServletRequest request, HttpServletResponse response) throws Exception {
    	Map<String, Object> paramMap = new HashMap<String, Object>();
    	List<FrontMenuVO> list = null;
    	Map<String, String> gnbMap = new HashMap<String, String>();
    	String returnGnb = "";
    	String filePath = "";
    	String token = "?";
    	
    	if(StringUtil.NVLToSpace(request.getAttribute("sys_dvs_cd")).equals("SITE01")){
    		returnGnb = "/portal/gnb";
    		filePath = "/portal/";
    	}else if(StringUtil.NVLToSpace(request.getAttribute("sys_dvs_cd")).equals("SITE02")){
    		returnGnb = "/minwon/gnb";
    		filePath = "/minwon/";
    	}else if(StringUtil.NVLToSpace(request.getAttribute("sys_dvs_cd")).equals("SITE03")){
    		returnGnb = "/api/gnb";
    		filePath = "/api/";
    	}else if(StringUtil.NVLToSpace(request.getAttribute("sys_dvs_cd")).equals("SITE04")){
    		returnGnb = "/csm/gnb";
    		filePath = "/csm/";
    	}
    	paramMap.put("sys_dvs_cd", StringUtil.NVLToSpace(request.getAttribute("sys_dvs_cd")));
    	
    	list = frontMenuService.selectMenuGrpList(paramMap);

    	for(int i=0; i<list.size(); i++){
			if(list.get(i).getMenu_type_cd().equals("MENU02") || list.get(i).getMenu_type_cd().equals("MENU04")){
				token="?";
				if(list.get(i).getMenu_type_cd().equals("MENU02")){
					if("".equals(StringUtil.NVLToSpace(gnbMap.get(list.get(i).getMenu_grp())))){
						if(!StringUtil.NVLToSpace(list.get(i).getUrl()).equals("")){
							if(list.get(i).getUrl().contains("?")){
								token = "&";
							}
							gnbMap.put(list.get(i).getMenu_grp(), list.get(i).getUrl()+token+"menu_grp="+list.get(i).getMenu_grp()+"&menu_no="+list.get(i).getMenu_no());
						}else{
							gnbMap.put(list.get(i).getMenu_grp(), filePath+"none.do?menu_grp="+list.get(i).getMenu_grp()+"&menu_no="+list.get(i).getMenu_no());
						}
					}	
				}else{
					if("".equals(StringUtil.NVLToSpace(gnbMap.get(list.get(i).getMenu_grp())))){
						if(!StringUtil.NVLToSpace(list.get(i).getBbs_no()).equals("")){
							gnbMap.put(list.get(i).getMenu_grp(), filePath+"board/board.do?menu_grp="+list.get(i).getMenu_grp()+"&menu_no="+list.get(i).getMenu_no());
						}else{
							gnbMap.put(list.get(i).getMenu_grp(), filePath+"none.do?menu_grp="+list.get(i).getMenu_grp()+"&menu_no="+list.get(i).getMenu_no());
						}
					}
				}
			}
    	}
    	
    	if(!StringUtil.NVLToSpace(request.getAttribute("menu_no")).equals("")){								//서브페이지 상단 메뉴트리(식품위해정보 > 식품안전지식> 뭐시기)
    		paramMap.put("menu_no", StringUtil.NVLToSpace(request.getAttribute("menu_no")));
    		FrontMenuVO menuVo = frontMenuService.selectMenuTree(paramMap);
    		gnbMap.put("menuTree", menuVo.getMenu_tree());
    	}
    	
    	model.addAttribute("gnbMap", gnbMap);

		return returnGnb;
    } 
	
	
	
    @RequestMapping("*/left.do")
    public void selectLeftMenuList(HttpServletRequest request, HttpServletResponse response) throws Exception {
    	Map<String, Object> paramMap = new HashMap<String, Object>();
    	List<FrontMenuVO> leftList = null;
    	
    	paramMap.put("menu_grp", StringUtil.NVLToSpace(request.getAttribute("menu_grp")));
    	paramMap.put("sys_dvs_cd", StringUtil.NVLToSpace(request.getAttribute("sys_dvs_cd")));
    	
    	
    	
    	leftList = frontMenuService.selectMenuGrpList(paramMap);
    	System.out.println("==========>>paramMap == "+paramMap);
    	response.setContentType("text/plain; charset=\"utf-8\"");
		response.getWriter().write(new Gson().toJson(leftList)); 
    }
    
    @RequestMapping("*/none.do")
    public String selectNone(Model model, HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		return "/layout/none";
    }
    
}
