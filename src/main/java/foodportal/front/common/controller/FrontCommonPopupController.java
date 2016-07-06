package foodportal.front.common.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.google.gson.Gson;

import common.commonfacillity.log.CommonLog;
import foodportal.common.util.Message;
import foodportal.common.util.StringUtil;
import foodportal.front.common.service.FrontCommonPopupService;

@Controller
public class FrontCommonPopupController {
	
	@Resource(name="fileUploadproperties")
	Properties properties;
	@CommonLog Logger log;
	@Autowired
	private FrontCommonPopupService frontCommonPopupService;
	
	/**
	 * 기관목록페이지
	 * @param model
	 * @param request
	 * @param response
	 * @return
	 * @throws IOException
	 */
	@RequestMapping("/popup/commonPopup/selectOrgn.do")
	public String selectOrgn(Model model, HttpServletRequest request, HttpServletResponse response) throws IOException {
		try {
			return "commonPopup/orgnPopup";
		} catch (Exception e) {
			return StringUtil.alertRedirect(response, Message.getMessage("msg.common.system.error"));	//시스템에러가 발생하였습니다. 관리자에게 문의하십시오.
		}
	}
	
    /**
     * 기관목록
     * @param request
     * @param response
     * @throws Exception
     */
    @RequestMapping("/popup/commonPopup/searchOrgn.do")
    public void searchOrgn(HttpServletRequest request, HttpServletResponse response) throws Exception {
    	Map<String, Object> paramMap = new HashMap<String, Object>();
    	Map<String, Object> resultMap = new HashMap<String, Object>();
    	
    	paramMap.put("search_keyword", StringUtil.NVLToSpace(request.getParameter("search_keyword")));
		paramMap.put("show_cnt", StringUtil.NVLToSpace(request.getParameter("show_cnt")));
		paramMap.put("start_idx", StringUtil.nullToStr(request.getParameter("start_idx"), "1"));
		
		resultMap = frontCommonPopupService.searchOrgn(paramMap);
    	
    	response.setContentType("text/plain; charset=\"utf-8\"");
		response.getWriter().write(new Gson().toJson(resultMap)); 
    }  
    
    /**
	 * 식품유형목록페이지
	 * @param model
	 * @param request
	 * @param response
	 * @return
	 * @throws IOException
	 */
	@RequestMapping("/popup/commonPopup/selectFoodtype.do")
	public String selectFoodtype(Model model, HttpServletRequest request, HttpServletResponse response) throws IOException {
		try {
			return "commonPopup/foodtypePopup";
		} catch (Exception e) {
			return StringUtil.alertRedirect(response, Message.getMessage("msg.common.system.error"));	//시스템에러가 발생하였습니다. 관리자에게 문의하십시오.
		}
	}
	
    /**
     * 식품유형목록
     * @param request
     * @param response
     * @throws Exception
     */
    @RequestMapping("/popup/commonPopup/searchFoodtype.do")
    public void searchFoodtype(HttpServletRequest request, HttpServletResponse response) throws Exception {
    	Map<String, Object> paramMap = new HashMap<String, Object>();
    	Map<String, Object> resultMap = new HashMap<String, Object>();
    	
    	paramMap.put("search_keyword", StringUtil.NVLToSpace(request.getParameter("search_keyword")));
		paramMap.put("show_cnt", StringUtil.nullToStr(request.getParameter("show_cnt"), "10"));
		paramMap.put("start_idx", StringUtil.nullToStr(request.getParameter("start_idx"), "1"));
		
		resultMap = frontCommonPopupService.searchFoodtype(paramMap);
    	
    	response.setContentType("text/plain; charset=\"utf-8\"");
		response.getWriter().write(new Gson().toJson(resultMap)); 
    }
    
    /**
	 * 원산지목록페이지
	 * @param model
	 * @param request
	 * @param response
	 * @return
	 * @throws IOException
	 */
	@RequestMapping("/popup/commonPopup/selectFoodBase.do")
	public String selectFoodBase(Model model, HttpServletRequest request, HttpServletResponse response) throws IOException {
		try {
			return "commonPopup/foodBasePopup";
		} catch (Exception e) {
			return StringUtil.alertRedirect(response, Message.getMessage("msg.common.system.error"));	//시스템에러가 발생하였습니다. 관리자에게 문의하십시오.
		}
	}
	
    /**
     * 원산지목록
     * @param request
     * @param response
     * @throws Exception
     */
    @RequestMapping("/popup/commonPopup/searchFoodBase.do")
    public void searchFoodBase(HttpServletRequest request, HttpServletResponse response) throws Exception {
    	Map<String, Object> paramMap = new HashMap<String, Object>();
    	Map<String, Object> resultMap = new HashMap<String, Object>();
    	
    	paramMap.put("search_keyword", StringUtil.NVLToSpace(request.getParameter("search_keyword")));
		paramMap.put("show_cnt", StringUtil.NVLToSpace(request.getParameter("show_cnt")));
		paramMap.put("start_idx", StringUtil.nullToStr(request.getParameter("start_idx"), "1"));
		paramMap.put("sys_cd", StringUtil.NVLToSpace(request.getParameter("sys_cd")));
		paramMap.put("cmmn_cd", StringUtil.NVLToSpace(request.getParameter("cmmn_cd")));
		
		resultMap = frontCommonPopupService.searchFoodBase(paramMap);
    	
    	response.setContentType("text/plain; charset=\"utf-8\"");
		response.getWriter().write(new Gson().toJson(resultMap)); 
    }  
    
    /**
	 * 업소목록페이지
	 * @param model
	 * @param request
	 * @param response
	 * @return
	 * @throws IOException
	 */
	@RequestMapping("/popup/commonPopup/selectShop.do")
	public String selectShop(Model model, HttpServletRequest request, HttpServletResponse response) throws IOException {
		try {
			model.addAttribute("allSearch", StringUtil.NVLToSpace(request.getParameter("allSearch")));
			return "commonPopup/shopPopup";
		} catch (Exception e) {
			return StringUtil.alertRedirect(response, Message.getMessage("msg.common.system.error"));	//시스템에러가 발생하였습니다. 관리자에게 문의하십시오.
		}
	}
	
    /**
     * 업소목록
     * @param request
     * @param response
     * @throws Exception
     */
    @RequestMapping("/popup/commonPopup/searchShop.do")
    public void searchShop(HttpServletRequest request, HttpServletResponse response) throws Exception {
    	Map<String, Object> paramMap = new HashMap<String, Object>();
    	Map<String, Object> resultMap = new HashMap<String, Object>();
    	
    	String allSearch = StringUtil.NVLToSpace(request.getParameter("allSearch"));
    	
		paramMap.put("show_cnt", StringUtil.NVLToSpace(request.getParameter("show_cnt")));
		paramMap.put("start_idx", StringUtil.nullToStr(request.getParameter("start_idx"), "1"));
		paramMap.put("sys_cd", StringUtil.NVLToSpace(request.getParameter("sys_cd")));
		paramMap.put("cmmn_cd", StringUtil.NVLToSpace(request.getParameter("cmmn_cd")));
		
		paramMap.put("search_bssh_nm", StringUtil.NVLToSpace(request.getParameter("search_bssh_nm")));
		paramMap.put("search_addr_dtl", StringUtil.NVLToSpace(request.getParameter("search_addr_dtl")));
		paramMap.put("search_induty_cd_nm", StringUtil.NVLToSpace(request.getParameter("search_induty_cd_nm")));
		
		if("Y".equals(allSearch)){
			resultMap = frontCommonPopupService.searchAllShop(paramMap);
		}else{
			resultMap = frontCommonPopupService.searchShop(paramMap);
		}
		
		
    	response.setContentType("text/plain; charset=\"utf-8\"");
		response.getWriter().write(new Gson().toJson(resultMap)); 
    }  
    
    
    /**
     * 실명인증
     * @param request
     * @param response
     * @throws Exception
     */
    @RequestMapping("/popup/commonPopup/checkRealName.do")
    public String checkRealName(HttpServletRequest request, HttpServletResponse response) throws Exception {
    	try {
			return "/commonPopup/realNamePopup";
		} catch (Exception e) {
			return StringUtil.alertRedirect(response, Message.getMessage("msg.common.system.error"));	//시스템에러가 발생하였습니다. 관리자에게 문의하십시오.
		}
    }
    
    /**
     * 제조원목록페이지
     * @param request
     * @param response
     * @throws Exception
     */
    @RequestMapping("/popup/commonPopup/selectMaker.do")
    public String selectMaker(HttpServletRequest request, HttpServletResponse response) throws Exception {
    	try {
			return "commonPopup/makerPopup";
		} catch (Exception e) {
			return StringUtil.alertRedirect(response, Message.getMessage("msg.common.system.error"));	//시스템에러가 발생하였습니다. 관리자에게 문의하십시오.
		}
    }
    
    /**
     * 판매원목록페이지
     * @param request
     * @param response
     * @throws Exception
     */
    @RequestMapping("/popup/commonPopup/selectVendor.do")
    public String selectVendor(Model model, HttpServletRequest request, HttpServletResponse response) throws Exception {
    	try {
			model.addAttribute("allSearch", StringUtil.NVLToSpace(request.getParameter("allSearch")));
			return "commonPopup/vendorPopup";
		} catch (Exception e) {
			return StringUtil.alertRedirect(response, Message.getMessage("msg.common.system.error"));	//시스템에러가 발생하였습니다. 관리자에게 문의하십시오.
		}
    }
    
    
	/**
	 * 파일업로드 팝업
	 * @param model
	 * @param request
	 * @param response
	 * @return
	 * @throws IOException
	 */
	@RequestMapping("/popup/commonPopup/fileUpload.do")
	public String fileUpload(Model model, HttpServletRequest request, HttpServletResponse response) throws Exception {
		try {
			boolean tf;
			String uploadSource = StringUtil.nullToStr(request.getParameter("uploadSource"), "default");
			String fileExt = properties.getProperty(uploadSource+".ext");
			String fileMaxSize = properties.getProperty(uploadSource+".maxSize");
			String filePath = properties.getProperty(uploadSource+".path");
			
			tf = (fileExt != null && !"".equals(fileExt));
			model.addAttribute("fileExt", (tf ? fileExt : properties.getProperty("default.ext")));
			
			tf = (fileMaxSize != null && !"".equals(fileMaxSize));
			model.addAttribute("fileMaxSize", (tf ? fileMaxSize : properties.getProperty("default.maxSize")));
			
			tf = (filePath != null && !"".equals(filePath));
			model.addAttribute("filePath", (tf ? filePath : properties.getProperty("default.path")));
			
			model.addAttribute("uploadSource", uploadSource);
			
			return "commonPopup/fileUploadPopup";
		} catch (Exception e) {
			return StringUtil.alertRedirect(response, Message.getMessage("msg.common.system.error"));	//시스템에러가 발생하였습니다. 관리자에게 문의하십시오.
		}
	}
	
	/**
	 * 파일업로드 프로세스
	 * @param request
	 * @param file
	 * @throws Exception
	 */
	@RequestMapping("/popup/commonPopup/processFileUpload.do")
	public void processFileUpload(@RequestParam("uploadFile")MultipartFile file, HttpServletRequest request, HttpServletResponse response) throws Exception {
		Map<String, Object> rtnMap = new HashMap<String, Object>();
		
		rtnMap = frontCommonPopupService.processFileUpload(request, file, properties);
		
		response.setContentType("text/html; charset=\"utf-8\"");
		response.getWriter().write(new Gson().toJson(rtnMap));
	}
	
}
