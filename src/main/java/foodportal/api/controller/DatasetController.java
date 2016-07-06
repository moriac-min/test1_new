package foodportal.api.controller;

import java.io.IOException;
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
import foodportal.api.service.DatasetService;
import foodportal.api.vo.CmmnCodeVO;
import foodportal.api.vo.DatasetItemVO;
import foodportal.api.vo.DatasetVO;
import foodportal.common.util.FusionCharts;
import foodportal.common.util.Message;
import foodportal.common.util.StringUtil;
import foodportal.api.vo.UploadFileVO;


@Controller
public class DatasetController {
	
	@CommonLog Logger log;
	
	@Autowired
	private DatasetService datasetservice;

	/**
	 * 데이터셋목록
	 * @param model
	 * @param request
	 * @param response
	 * @return
	 * @throws IOException
	 */ 
	@RequestMapping("/api/datasetList.do")
	public String datasetList(Model model, HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		String svc_type_cd = "";
		String cl_cd = "";
		String provd_instt = "";
		
		try {
			
			svc_type_cd = StringUtil.NVLToSpace(request.getParameter("svc_type_cd"));
			cl_cd = StringUtil.NVLToSpace(request.getParameter("cl_cd"));
			provd_instt = StringUtil.NVLToSpace(request.getParameter("provd_instt"));
			
			Map<String, Object> codeMap = datasetservice.selectCmmnCdList();
			
			List<CmmnCodeVO> svcTypeCodeList =  (List<CmmnCodeVO>) codeMap.get("svcTypeCodeList");
			List<CmmnCodeVO> clCdCodeList =  (List<CmmnCodeVO>) codeMap.get("clCdCodeList");
			List<CmmnCodeVO> provdInsttCodeList =  (List<CmmnCodeVO>) codeMap.get("provdInsttCodeList");
			
			System.out.println("==========3333==========>"+request.getParameter("svc_type_cd"));
			
			model.addAttribute("svc_type_cd", svc_type_cd);
			model.addAttribute("cl_cd", cl_cd);
			model.addAttribute("provd_instt", provd_instt);
			
			model.addAttribute("svcTypeCodeList", svcTypeCodeList);
			model.addAttribute("clCdCodeList", clCdCodeList);
			model.addAttribute("provdInsttCodeList", provdInsttCodeList);
			
		} catch (Exception e) {
			return StringUtil.alertRedirect(response, Message.getMessage("msg.common.system.error"));	//시스템에러가 발생하였습니다. 관리자에게 문의하십시오.
		}
		
		return "api/dataset/datasetList";
	}
    
	
	/**
	 * 데이터셋상세
	 * @param model
	 * @param request
	 * @param response
	 * @return
	 * @throws IOException
	 */
	@RequestMapping("/api/searchDatasetList.do")
	public void searchDatasetList(Model model, HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		Map<String, Object> paramMap = new HashMap<String, Object>();
		Map<String, Object> resultMap = new HashMap<String, Object>();
		
		try {
			paramMap.put("search_svcTypeCode", request.getParameter("search_svcTypeCode"));
			paramMap.put("search_clCdCode", request.getParameter("search_clCdCode"));
			paramMap.put("search_provdInsttCode", request.getParameter("search_provdInsttCode"));
			paramMap.put("search_keyword", request.getParameter("search_keyword"));
			paramMap.put("show_cnt", request.getParameter("show_cnt"));
			paramMap.put("start_idx", StringUtil.nullToStr(request.getParameter("start_idx"), "1"));
			
			resultMap = datasetservice.searchDatasetList(paramMap);
			
			if(resultMap != null){
				model.addAttribute("list", (List<DatasetVO>)resultMap.get("list"));
				model.addAttribute("total_cnt", resultMap.get("total_cnt"));
			}
			
		} catch (Exception e) {
		}
		
		response.setContentType("text/plain; charset=\"utf-8\"");
		response.getWriter().write(new Gson().toJson(resultMap)); 
		
	}
	
	/**
	 * Sheet 페이지
	 * @param model
	 * @param request
	 * @param response
	 * @return
	 * @throws IOException
	 */ 
	@RequestMapping("/api/sheetInfo.do")
	public String sheetInfo(Model model, HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		Map<String, Object> paramMap = new HashMap<String, Object>();
		DatasetVO datasetVO = null;
		
		try {
			
			paramMap.put("svc_no", request.getParameter("svc_no"));
			paramMap.put("svc_type_cd", request.getParameter("svc_type_cd"));

			datasetVO = datasetservice.searchApiInfo(paramMap);
			
			model.addAttribute("svc_no", StringUtil.NVLToSpace(request.getParameter("svc_no")));
			model.addAttribute("svc_type_cd", StringUtil.NVLToSpace(request.getParameter("svc_type_cd")));
			model.addAttribute("datasetVO", datasetVO);
			
		} catch (Exception e) {
			return StringUtil.alertRedirect(response, Message.getMessage("msg.common.system.error"));	//시스템에러가 발생하였습니다. 관리자에게 문의하십시오.
		}
		
		return "api/dataset/datasetDetailSheet";
	}
	
	/**
	 * Sheet 데이터목록
	 * @param model
	 * @param request
	 * @param response
	 * @return
	 * @throws IOException
	 */
	@RequestMapping("/api/searchSheetInfo.do")
	public void searchSheetInfo(Model model, HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		Map<String, Object> paramMap = new HashMap<String, Object>();
		Map<String, Object> resultMap = new HashMap<String, Object>();
		
		try {
			paramMap.put("svc_no", request.getParameter("svc_no"));
			paramMap.put("svc_type_cd", request.getParameter("svc_type_cd"));
			paramMap.put("show_cnt", request.getParameter("show_cnt"));
			paramMap.put("start_idx", StringUtil.nullToStr(request.getParameter("start_idx"), "1"));
			
			resultMap = datasetservice.searchApiData(paramMap);
			
		} catch (Exception e) {
		}
		
		response.setContentType("text/plain; charset=\"utf-8\"");
		response.getWriter().write(new Gson().toJson(resultMap)); 
		
	}
	
	
	/**
	 * Link 페이지
	 * @param model
	 * @param request
	 * @param response
	 * @return
	 * @throws IOException
	 */ 
	@RequestMapping("/api/linkInfo.do")
	public String linkInfo(Model model, HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		Map<String, Object> paramMap = new HashMap<String, Object>();
		DatasetVO datasetVO = null;
		
		try {
			
			paramMap.put("svc_no", request.getParameter("svc_no"));
			paramMap.put("svc_type_cd", request.getParameter("svc_type_cd"));
			
			datasetVO = datasetservice.searchApiInfo(paramMap);
			
			model.addAttribute("svc_no", StringUtil.NVLToSpace(request.getParameter("svc_no")));
			model.addAttribute("svc_type_cd", StringUtil.NVLToSpace(request.getParameter("svc_type_cd")));
			model.addAttribute("datasetVO", datasetVO);
					
		} catch (Exception e) {
			return StringUtil.alertRedirect(response, Message.getMessage("msg.common.system.error"));	//시스템에러가 발생하였습니다. 관리자에게 문의하십시오.
		}
		
		return "api/dataset/datasetDetailLink";
	}
	
	/**
	 * OpenApi 페이지
	 * @param model
	 * @param request
	 * @param response
	 * @return
	 * @throws IOException
	 */ 
	@RequestMapping("/api/openApiInfo.do")
	public String openApiInfo(Model model, HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		Map<String, Object> paramMap = new HashMap<String, Object>();
		DatasetVO datasetVO = null;
		List<DatasetItemVO> dataItemList = null;
		
		try {
			
			paramMap.put("svc_no", request.getParameter("svc_no"));
			paramMap.put("svc_type_cd", request.getParameter("svc_type_cd"));
			
			datasetVO = datasetservice.searchApiInfo(paramMap);
			dataItemList = datasetservice.searchApiItem(paramMap);
			
			model.addAttribute("svc_no", StringUtil.NVLToSpace(request.getParameter("svc_no")));
			model.addAttribute("svc_type_cd", StringUtil.NVLToSpace(request.getParameter("svc_type_cd")));
			model.addAttribute("datasetVO", datasetVO);
			model.addAttribute("dataItemList", dataItemList);
					
		} catch (Exception e) {
			log.error(e.toString());
			return StringUtil.alertRedirect(response, Message.getMessage("msg.common.system.error"));	//시스템에러가 발생하였습니다. 관리자에게 문의하십시오.
		}
		
		return "api/dataset/datasetDetailOpenApi";
	}
	
	/**
	 * Chart 페이지
	 * @param model
	 * @param request
	 * @param response
	 * @return
	 * @throws IOException
	 */ 
	@RequestMapping("/api/chartInfo.do")
	public String chartInfo(Model model, HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		Map<String, Object> paramMap = new HashMap<String, Object>();
		DatasetVO datasetVO = null;
		
		try {
			
			paramMap.put("svc_no", request.getParameter("svc_no"));
			paramMap.put("svc_type_cd", request.getParameter("svc_type_cd"));
			
			datasetVO = datasetservice.searchApiInfo(paramMap);
			
			FusionCharts fc = new FusionCharts();
			Map params = new HashMap();

			StringBuffer strXML = new StringBuffer();

			strXML.append("<chart caption='test' xAxisName='시간' yAxisName='건수' showBorder='0' showValues='0' formatNumberScale='0' showBorder='1'>");
			strXML.append("<set label='09H' value='11' />");
			strXML.append("<set label='10H' value='22' />");
			strXML.append("<set label='11H' value='33' />");
			strXML.append("<set label='12H' value='44' />");
			strXML.append("</chart>");
			
			//String chartCode = fc.createChartHTML("/ext/charts/Column2D.swf", "", strXML.toString(), "myTest", 716, 400, false);
			
			//String chartCode = fc.createChart("/js/charts/Column3D.swf", "", strXML.toString(), "chart", 900, 650, false, false);;
		
			
			//ModelAndView mav = new ModelAndView("simpleChartView");
			//mav.addObject("chart", chartCode);
			
			model.addAttribute("datasetVO", datasetVO);
			model.addAttribute("chart", strXML.substring(0));
			
		} catch (Exception e) {
			return StringUtil.alertRedirect(response, Message.getMessage("msg.common.system.error"));	//시스템에러가 발생하였습니다. 관리자에게 문의하십시오.
		}
		
		return "api/dataset/datasetDetailChart";
	}
	
	/**
	 * File 페이지
	 * @param model
	 * @param request
	 * @param response
	 * @return
	 * @throws IOException
	 */ 
	@RequestMapping("/api/fileInfo.do")
	public String fileInfo(Model model, HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		Map<String, Object> paramMap = new HashMap<String, Object>();
		DatasetVO datasetVO = null;
		List<UploadFileVO> fileUploadList = null;		//파일첨부
		
		try {
			
			paramMap.put("svc_no", request.getParameter("svc_no"));
			paramMap.put("svc_type_cd", request.getParameter("svc_type_cd"));
			
			datasetVO = datasetservice.searchApiInfo(paramMap);
			fileUploadList = datasetservice.selectFileInfo(paramMap);
			
			model.addAttribute("svc_no", StringUtil.NVLToSpace(request.getParameter("svc_no")));
			model.addAttribute("svc_type_cd", StringUtil.NVLToSpace(request.getParameter("svc_type_cd")));
			model.addAttribute("datasetVO", datasetVO);
			model.addAttribute("fileUploadList", fileUploadList);
					
		} catch (Exception e) {
			return StringUtil.alertRedirect(response, Message.getMessage("msg.common.system.error"));	//시스템에러가 발생하였습니다. 관리자에게 문의하십시오.
		}
		
		return "api/dataset/datasetDetailFile";
	}
	
}
