package foodportal.front.healthyfoodlife.service;

import java.io.IOException;
import java.util.Map;

import org.springframework.stereotype.Service;

import foodportal.front.healthyfoodlife.vo.ExamOrgnVO;
import foodportal.front.healthyfoodlife.vo.ExamStateVO;

public interface GMOService {
	/**
	 * 심사현황 목록 
	 * @param model
	 * @param request
	 * @param response
	 * @return
	 * @throws IOException
	 */
	public Map<String, Object> selectExamState(Map<String, Object> paramMap) throws Exception;
	
	/**
	 * 심사현황 상세
	 * @param model
	 * @param request
	 * @param response
	 * @return
	 * @throws IOException
	 */
	public Map<String, Object> selectExamStateDetail(Map<String, Object> paramMap) throws Exception;
	
	/**
	 * 검사기관 목록 
	 * @param model
	 * @param request
	 * @param response
	 * @return
	 * @throws IOException
	 */
	public Map<String, Object> selectExamOrgn(Map<String, Object> paramMap) throws Exception;
	
	/**
	 * 검사기관 상세
	 * @param model
	 * @param request
	 * @param response
	 * @return
	 * @throws IOException
	 */
	public Map<String, Object> selectExamOrgnDetail(Map<String, Object> paramMap) throws Exception;
	
}