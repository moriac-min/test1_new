package foodportal.api.service;

import java.util.List;
import java.util.Map;

import foodportal.api.vo.DatasetItemVO;
import foodportal.api.vo.DatasetVO;
import foodportal.api.vo.UploadFileVO;

/**
 * DatasetService
 * @author 박재형
 * @since 2014.10.14
 * @version 1.0
 * @see
 * 
 * <pre>
 *  Modification Information
 *  수정일      수정자   수정내용
 *  ---------- -------- ---------------------------
 *  2014.10.14 박재형 최초 생성
 * </pre>
 * 
 * Copyright (C) 2014 by NDS., All right reserved.
 */

public interface DatasetService {

	/**
	 * 화면에서 쓰이는 공통코드목록
	 * @param paramMap
	 * @return
	 * @throws Exception
	 */
	public Map<String, Object> selectCmmnCdList() throws Exception;
	
	/**
	 * 데이터셋 목록조회
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public Map<String, Object> searchDatasetList(Map<String, Object> map) throws Exception;
	
	/**
	 * API 데이터조회
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public Map<String, Object> searchApiData(Map<String, Object> map) throws Exception;
	
	/**
	 * API 항목조회
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public List<DatasetItemVO> searchApiItem(Map<String, Object> map) throws Exception;
	
	/**
	 * API 정보 조회
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public DatasetVO searchApiInfo(Map<String, Object> map) throws Exception;
	
	/**
	 * 파일첨부
	 * @param ibean
	 * @return
	 * @throws Exception
	 */
	public List<UploadFileVO> selectFileInfo(Map<String, Object> map) throws Exception;
	
	
}