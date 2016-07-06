package foodportal.api.service.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import common.commonfacillity.log.CommonLog;
import egovframework.rte.fdl.cmmn.AbstractServiceImpl;
import foodportal.api.mapper.DatasetMapper;
import foodportal.api.service.DatasetService;
import foodportal.api.vo.CmmnCodeVO;
import foodportal.api.vo.DatasetItemVO;
import foodportal.api.vo.DatasetVO;
import foodportal.common.util.StringUtil;
import foodportal.api.vo.UploadFileVO;

/**
 * MetaInfoServiceImpl
 * @author 박재형
 * @since 2014.09.03
 * @version 1.0
 * @see
 * 
 * <pre>
 *  Modification Information
 *  수정일      수정자   수정내용
 *  ---------- -------- ---------------------------
 *  2014.09.03 박재형 최초 생성
 * </pre>
 * 
 * Copyright (C) 2014 by NDS., All right reserved.
 */

@Service("datasetServiceImpl")
public class DatasetServiceImpl extends AbstractServiceImpl implements DatasetService {

	@CommonLog Logger log;

	@Autowired
	DatasetMapper datasetMapper;
	
	@Transactional(readOnly=true)
	public Map<String, Object> selectCmmnCdList() throws Exception {

		Map<String, Object> resultMap = null;
		
		try{
			
			resultMap = new HashMap<String, Object>(); 
			Map<String, Object> paramMap = new HashMap<String, Object>();
			
			paramMap.put("hrnk_cd", "API_TYPE");	//API 유형 공통코드
			List<CmmnCodeVO> svcTypeCodeList = datasetMapper.selectCmmnCdList(paramMap);
			resultMap.put("svcTypeCodeList", svcTypeCodeList);
			
			paramMap.put("hrnk_cd", "API_SRT");	//API 분류 공통코드
			List<CmmnCodeVO> clCdCodeList = datasetMapper.selectCmmnCdList(paramMap);
			resultMap.put("clCdCodeList", clCdCodeList);
			
			paramMap.put("hrnk_cd", "API_ORGN");	//API 제공기관 공통코드
			List<CmmnCodeVO> provdInsttCodeList = datasetMapper.selectCmmnCdList(paramMap);
			resultMap.put("provdInsttCodeList", provdInsttCodeList);
			
		} catch(Exception e) {
			
		}
		
		return resultMap;
		
	}
	
	@Transactional(readOnly=true)
	public Map<String, Object> searchDatasetList(Map<String, Object> map) throws Exception {
		
		Map<String, Object> resultMap = new HashMap<String, Object>();
		List<DatasetVO> list = null;
				
		try{
			list = datasetMapper.searchDatasetList(map);				//목록
			int total_cnt = datasetMapper.searchDatasetTotalCnt(map);	//총개수
			
			resultMap.put("list", list);
			resultMap.put("total_cnt", total_cnt);
			
			return resultMap;
			
		} catch(Exception e) {
			throw e;
		}
	}
	
	

	@Transactional(readOnly=true)
	public Map<String, Object> searchApiData(Map<String, Object> paramMap) throws Exception {
		
		Map<String, Object> resultMap = new HashMap<String, Object>();		//결과map
			
		List<HashMap<String, Object>> dataList = null;			//쿼리실행결과
		int totalCnt = 0;									//쿼리실행결과 총개수
		List<DatasetItemVO> dataItemList = null;			//쿼리항목
		String queryStr = "";								//쿼리
				
		try{
			
			if(!"".equals(StringUtil.NVLToSpace(paramMap.get("svc_no")))){			//서비스번호
				if("API_TYPE01".equals(StringUtil.NVLToSpace(paramMap.get("svc_type_cd")))){	//Sheet형
					
					//쿼리조회
					queryStr = searchQuery(paramMap);
					if(!"".equals(queryStr)){
						paramMap.put("queryStr", queryStr);
						
						dataList = datasetMapper.runQueryStr(paramMap);			//쿼리실행	
						totalCnt = datasetMapper.runQueryStrTotalCnt(paramMap);	//총개수
						dataItemList = searchApiItem(paramMap);					//항목조회
					}
					
					HashMap<String, Object> convertMap = CreateDataToKeysetMap(dataList, dataItemList);
					
					/********************************데이터목록********************************/
					resultMap.put("dataList", (List<Map<String, Object>>) convertMap.get("dataList"));	//데이터목록
					resultMap.put("dataListTotalCnt", totalCnt);										//데이터목록 총개수
					resultMap.put("maxCol", Integer.parseInt(convertMap.get("maxCol").toString()));		//데이터목록 컬럼총개수
					/********************************데이터항목********************************/
					resultMap.put("dataItemList", dataItemList);										//데이터항목 목록
					
				}
			}
				
			
			return resultMap;
			
		} catch(Exception e) {
			log.error(e.toString());
			throw e;
		}
	}
	
	/**
	 * API에 등록된 쿼리조회
	 * @param paramMap
	 * @return
	 * @throws Exception
	 */
	@Transactional(readOnly=true)
	public String searchQuery(Map<String, Object> paramMap) throws Exception {
		
		String queryStr = "";
		
		try {
			//쿼리조회
			queryStr = StringUtil.NVLToSpace(datasetMapper.selectQueryStr(paramMap));	
			
		} catch (Exception e) {
			queryStr = "";
		}
		return queryStr;
	}
	
	/** 데이터가공 헤더를 keyset 으로 순번채번셋팅
	 * @param paramMap
	 * @return
	 */
	public HashMap<String, Object> CreateDataToKeysetMap(List<HashMap<String, Object>> list, List<DatasetItemVO> dataItemList) throws IOException {
		
		/**************************************** 메소드변수영역 **************************************/
		HashMap<String, Object> resutMap = new HashMap<String, Object>();
		
		List<HashMap<String, Object>> dataList = new ArrayList<HashMap<String, Object>>(); //row data list
		HashMap<String, Object> listMap = null;
		int maxCol = 0;
		
		try {
		//row data
			if(list != null && dataItemList != null){
				if(list.size() > 0 && dataItemList.size() > 0){
					
					for(int i=0; i<list.size(); i++){				//데이터목록
						
						listMap = new HashMap<String, Object>();
						
						int k = 0;
						
						
						for(int j=0; j<dataItemList.size(); j++){	//항목목록
							Iterator iter = list.get(i).entrySet().iterator();
				            while(iter.hasNext()){
				                Map.Entry entry = (Map.Entry)iter.next();
				                //일치되는것만 순서대로 체크하여 PUT
				                if(entry.getValue() != null && dataItemList.get(j).getItm_nm().equals(StringUtil.NVLToSpace(entry.getKey()))){
				                	listMap.put("col_"+k, entry.getValue().toString());
				                	k++;
				                	maxCol = k;
				                }
				            }
						}
				            
			            
			            dataList.add(listMap);
			            
					}
				}
			}
		} catch (Exception e) {
			log.error(e.toString());
		}	
		resutMap.put("dataList", dataList);
		resutMap.put("maxCol", maxCol);
		
		return resutMap;
	}
	
	
	@Transactional(readOnly=true)
	public List<DatasetItemVO> searchApiItem(Map<String, Object> paramMap) throws Exception {
		
		List<DatasetItemVO> dataItemList = null;			//쿼리항목
		
		try {
			if(!"".equals(StringUtil.NVLToSpace(paramMap.get("svc_no")))){			//서비스번호
				dataItemList = datasetMapper.searchApiItem(paramMap);
			}
		} catch (Exception e) {
			log.error(e.toString());
		}
		
		return dataItemList;
	}
	
	@Transactional(readOnly=true)
	public DatasetVO searchApiInfo(Map<String, Object> paramMap) throws Exception {
		
		DatasetVO datasetVO = null;
		
		try {
			datasetVO = datasetMapper.searchApiInfo(paramMap);
		} catch (Exception e) {
			log.error(e.toString());
		}	
		
		return datasetVO;
	}
	
	@Transactional(readOnly=true)
	public List<UploadFileVO> selectFileInfo(Map<String, Object> map) throws Exception {
		
		List<UploadFileVO> uploadFileList = null;
				
		try{
			uploadFileList = datasetMapper.selectFileInfo(map);
			
			return uploadFileList;
			
		} catch(Exception e) {
			
			throw e;
		}
	}
	
}