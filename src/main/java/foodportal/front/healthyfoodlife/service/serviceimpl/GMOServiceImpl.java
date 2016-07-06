package foodportal.front.healthyfoodlife.service.serviceimpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import common.commonfacillity.log.CommonLog;

import egovframework.rte.fdl.cmmn.AbstractServiceImpl;
import foodportal.front.fooddanger.vo.FoodDangerFileVO;
import foodportal.front.healthyfoodlife.mapper.GMOMapper;
import foodportal.front.healthyfoodlife.service.GMOService;
import foodportal.front.healthyfoodlife.vo.ExamOrgnVO;
import foodportal.front.healthyfoodlife.vo.ExamStateVO;

@Service("GMOService")
public class GMOServiceImpl extends AbstractServiceImpl implements GMOService {

	@CommonLog Logger log;
	@Autowired GMOMapper gmoMapper;
	
	@Transactional(readOnly=true)
	public Map<String, Object> selectExamState(Map<String, Object> paramMap) throws Exception {
		Map<String, Object> resultMap = new HashMap<String, Object>();		
		List<ExamStateVO> list = null;
		
		try{
			
			list = gmoMapper.selectExamState(paramMap);
			int total_cnt = gmoMapper.selectExamStateCnt(paramMap);
			resultMap.put("list", list);
			resultMap.put("total_cnt", total_cnt);
			
			return resultMap;
		}catch(Exception e){		
			throw e;
		}	
	}

	@Transactional(readOnly=true)
	public Map<String, Object> selectExamStateDetail(Map<String, Object> paramMap) throws Exception {
		
		Map<String, Object> resultMap = new HashMap<String, Object>();
		ExamStateVO examStateVO = null;
		List<FoodDangerFileVO> fileList = null;
		
		try{			
			examStateVO = gmoMapper.selectExamStateDetail(paramMap);
			fileList = gmoMapper.selectAttachFileList(paramMap);
			
			resultMap.put("list", examStateVO);
			resultMap.put("fileList", fileList);
			
			return resultMap;
		}catch(Exception e){
			throw e;
		}
		
	}

	@Transactional(readOnly=true)
	public Map<String, Object> selectExamOrgn(Map<String, Object> paramMap) throws Exception{
		
		Map<String, Object> resultMap = new HashMap<String, Object>();
		List<ExamOrgnVO> list = null;
		
		try{
			
			list = gmoMapper.selectExamOrgn(paramMap);
			int total_cnt = gmoMapper.selectExamOrgnCnt(paramMap);
			
			resultMap.put("list", list);
			resultMap.put("total_cnt", total_cnt);
			
			return resultMap;			
					
		}catch(Exception e){
			throw e;
		}
	}
	@Transactional(readOnly=true)
	public Map<String, Object> selectExamOrgnDetail(Map<String, Object> paramMap) throws Exception {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		ExamOrgnVO examOrgnVO = null;
		List<FoodDangerFileVO> fileList = null;
		
		try{
			
			examOrgnVO = gmoMapper.selectExamOrgnDetail(paramMap);
			fileList = gmoMapper.selectAttachFileList(paramMap);
			
			resultMap.put("examOrgnDetail", examOrgnVO);
			resultMap.put("attachFileList", fileList);
			return resultMap;
		}catch(Exception e){
			throw e;
		}		
	}
}
