package foodportal.api.mapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import egovframework.rte.psl.dataaccess.mapper.Mapper;
import foodportal.api.vo.CmmnCodeVO;
import foodportal.api.vo.DatasetItemVO;
import foodportal.api.vo.DatasetVO;
import foodportal.api.vo.UploadFileVO;

/**
 * DatasetMapper
 * @author 박재형
 * @since 2014.09.25
 * @version 1.0
 * @see
 * 
 * <pre>
 *  Modification Information
 *  수정일      수정자   수정내용
 *  ---------- -------- ---------------------------
 *  2014.10.15 박재형 최초 생성
 * </pre>
 * 
 * Copyright (C) 2014 by NDS., All right reserved.
 */
         
@Mapper("foodportal.api.mapper.DatasetMapper")
public interface DatasetMapper {
	
	/**
	 * 화면에서 쓰이는 공통코드목록
	 * @param paramMap
	 * @return
	 * @throws Exception
	 */
	public List<CmmnCodeVO> selectCmmnCdList(Map<String, Object> paramMap) throws Exception;
	
	/**
	 * 데이터셋목록
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public List<DatasetVO> searchDatasetList(Map<String, Object> map) throws Exception;
	
	/**
	 * 데이터셋 총개수
	 * @param 
	 * @return
	 */
	public int searchDatasetTotalCnt(Map<String, Object> map) throws Exception;
	
	/**
	 * API 쿼리 조회
	 * @param 
	 * @return 
	 * @exception Exception
	 */
	public String selectQueryStr(Map<String, Object> paramMap) throws Exception;
	
	/**
	 * API 쿼리 실행
	 * @param 
	 * @return 
	 * @exception Exception
	 */
	public List<HashMap<String, Object>> runQueryStr(Map<String, Object> paramMap) throws Exception;
	
	/**
	 * API 쿼리 실행 TOTAL CNT
	 * @param 
	 * @return 
	 * @exception Exception
	 */
	public int runQueryStrTotalCnt(Map<String, Object> paramMap) throws Exception;
	
	/**
	 * API 항목 조회
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public List<DatasetItemVO> searchApiItem(Map<String, Object> map) throws Exception;
	
	/**
	 * API 정보 조회
	 * @param 
	 * @return 
	 * @exception Exception
	 */
	public DatasetVO searchApiInfo(Map<String, Object> paramMap) throws Exception;
	
	/**
	 * 첨부파일
	 * @param map
	 * @return
	 */
	public List<UploadFileVO> selectFileInfo(Map<String, Object> map);
	
}
