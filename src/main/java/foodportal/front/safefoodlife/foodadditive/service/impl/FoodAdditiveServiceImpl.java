package foodportal.front.safefoodlife.foodadditive.service.impl;

import java.util.HashMap;
import java.util.List;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import common.commonfacillity.log.CommonLog;
import common.commonfacillity.util.CommonConvertObjectToMap;
import egovframework.rte.fdl.cmmn.AbstractServiceImpl;
import foodportal.front.safefoodlife.foodadditive.mapper.FoodAdditiveBasisInfoMapper;
import foodportal.front.safefoodlife.foodadditive.service.FoodAdditiveService;
import foodportal.front.safefoodlife.foodadditive.util.Utility;
import foodportal.front.safefoodlife.foodadditive.vo.FoodAdditiveBasisInfoVO;

/**
 * FoodAdditiveServiceImpl
 * @author 임재록
 * @since 2014.10.08
 * @version 1.0
 * @see
 * 
 * <pre>
 *  Modification Information
 *  수정일      수정자   수정내용
 *  ---------- -------- ---------------------------
 *  2014.10.08 임재록 최초 생성
 * </pre>
 * 
 * Copyright (C) 2014 by NDS., All right reserved.
 */

@Service("foodAdditiveService")
public class FoodAdditiveServiceImpl extends AbstractServiceImpl implements FoodAdditiveService {

	@CommonLog Logger log;
	
	@Autowired
	FoodAdditiveBasisInfoMapper foodAdditiveBasisInfoMapper;
	
	@Transactional(readOnly=true)
	public List<FoodAdditiveBasisInfoVO> selectFoodAdditiveBasisInfoList(FoodAdditiveBasisInfoVO foodAdditiveBasisInfoVO) throws Exception {
		HashMap<String, Object> map = new HashMap<String, Object>();
		
		try{
			map = CommonConvertObjectToMap.ConverObjectToMap(foodAdditiveBasisInfoVO);
			
			// 검색타입, 검색어 설정
			map.put(foodAdditiveBasisInfoVO.getKeyfield(), foodAdditiveBasisInfoVO.getKey());
			
			List<FoodAdditiveBasisInfoVO> list = foodAdditiveBasisInfoMapper.selectFoodAdditiveBasisInfoList(map);
			
			return list;
			
		} catch(Exception e) {
			throw e;
		}
	}
	
	@Transactional(readOnly=true)
	public FoodAdditiveBasisInfoVO selectFoodAdditiveTotalSerial(FoodAdditiveBasisInfoVO foodAdditiveBasisInfoVO) throws Exception {
		HashMap<String, Object> map = new HashMap<String, Object>();
		
		try{
			map = CommonConvertObjectToMap.ConverObjectToMap(foodAdditiveBasisInfoVO);
			
			FoodAdditiveBasisInfoVO detail = foodAdditiveBasisInfoMapper.selectFoodAdditiveTotalSerial(map);
			
			return detail;
			
		} catch(Exception e) {
			throw e;
		}
	}
	
	@Transactional(readOnly=true)
	public FoodAdditiveBasisInfoVO selectFoodAdditiveBasisInfoDetail(FoodAdditiveBasisInfoVO foodAdditiveBasisInfoVO) throws Exception {
		HashMap<String, Object> map = new HashMap<String, Object>();
		
		try{
			map = CommonConvertObjectToMap.ConverObjectToMap(foodAdditiveBasisInfoVO);
			
			FoodAdditiveBasisInfoVO detail = foodAdditiveBasisInfoMapper.selectFoodAdditiveBasisInfoDetail(map);
			detail.setDfn(Utility.imgFn(Utility.getNull(detail.getDfn()), "/files/upload/fa/standard/gongjeon_etc_img/"));
			detail.setCont(Utility.encodeChar(Utility.getNull(detail.getCont()), 2));
			detail.setDispos_1(Utility.encodeChar(Utility.getNull(detail.getDispos_1()), 2));
			detail.setPuredo_test(Utility.encodeChar(Utility.getNull(detail.getPuredo_test()), 2));
			detail.setItm_cn_a_1(Utility.encodeChar(Utility.getNull(detail.getItm_cn_a_1()), 2));
			detail.setItm_cn_b_1(Utility.encodeChar(Utility.getNull(detail.getItm_cn_b_1()), 2));
			detail.setItm_cn_c_1(Utility.encodeChar(Utility.getNull(detail.getItm_cn_c_1()), 2));
			detail.setItm_cn_d_1(Utility.encodeChar(Utility.getNull(detail.getItm_cn_d_1()), 2));
			detail.setItm_cn_k_1(Utility.encodeChar(Utility.getNull(detail.getItm_cn_k_1()), 2));
			detail.setItm_cn_l_1(Utility.encodeChar(Utility.getNull(detail.getItm_cn_l_1()), 2));
			detail.setFdqntlaw1(Utility.encodeChar(Utility.getNull(detail.getFdqntlaw1()), 2));
			detail.setUse_stdr_1(Utility.encodeChar(Utility.getNull(detail.getUse_stdr_1()), 2));
			
			return detail;
			
		} catch(Exception e) {
			throw e;
		}
	}
	
	@Transactional(readOnly=true)
	public FoodAdditiveBasisInfoVO selectFoodAdditiveBasisInfoDetail2(FoodAdditiveBasisInfoVO foodAdditiveBasisInfoVO) throws Exception {
		HashMap<String, Object> map = new HashMap<String, Object>();
		
		try{
			map = CommonConvertObjectToMap.ConverObjectToMap(foodAdditiveBasisInfoVO);
			
			FoodAdditiveBasisInfoVO detail = foodAdditiveBasisInfoMapper.selectFoodAdditiveBasisInfoDetail2(map);
			detail.setOrigin(Utility.encodeChar(Utility.getNull(detail.getOrigin()), 2));
			detail.setPhysic_chmcl_chartr(Utility.encodeChar(Utility.getNull(detail.getPhysic_chmcl_chartr()), 2));
			detail.setMnf_mthd(Utility.encodeChar(Utility.getNull(detail.getMnf_mthd()), 2));
			detail.setMain_prpos(Utility.encodeChar(Utility.getNull(detail.getMain_prpos()), 2));
			detail.setJecfa_evl(Utility.encodeChar(Utility.getNull(detail.getJecfa_evl()), 2));
			
			return detail;
			
		} catch(Exception e) {
			throw e;
		}
	}
	
	@Transactional(readOnly=true)
	public FoodAdditiveBasisInfoVO selectFoodAdditiveBasisInfoDetail3(FoodAdditiveBasisInfoVO foodAdditiveBasisInfoVO) throws Exception {
		HashMap<String, Object> map = new HashMap<String, Object>();
		
		try{
			map = CommonConvertObjectToMap.ConverObjectToMap(foodAdditiveBasisInfoVO);
			
			FoodAdditiveBasisInfoVO detail = foodAdditiveBasisInfoMapper.selectFoodAdditiveBasisInfoDetail3(map);
			detail.setDispos_1(Utility.encodeChar(Utility.getNull(detail.getDispos_1()), 2));
			detail.setPuredo_test(Utility.encodeChar(Utility.getNull(detail.getPuredo_test()), 2));
			detail.setNcknm(Utility.encodeChar(Utility.getNull(detail.getNcknm()), 2));
			detail.setDfn(Utility.encodeChar(Utility.getNull(detail.getDfn()), 2));
			detail.setCont(Utility.encodeChar(Utility.getNull(detail.getCont()), 2));
			detail.setPrpos(Utility.encodeChar(Utility.getNull(detail.getPrpos()), 2));
			detail.setCnfm_test(Utility.encodeChar(Utility.getNull(detail.getCnfm_test()), 2));
			detail.setFdqntlaw_1(Utility.encodeChar(Utility.getNull(detail.getFdqntlaw_1()), 2));
			detail.setNcknm(Utility.encodeChar(Utility.getNull(detail.getNcknm()), 2));
			
			return detail;
			
		} catch(Exception e) {
			throw e;
		}
	}
	
	@Transactional(readOnly=true)
	public FoodAdditiveBasisInfoVO selectFoodAdditiveBasisInfoDetail4(FoodAdditiveBasisInfoVO foodAdditiveBasisInfoVO) throws Exception {
		HashMap<String, Object> map = new HashMap<String, Object>();
		
		try{
			map = CommonConvertObjectToMap.ConverObjectToMap(foodAdditiveBasisInfoVO);
			
			FoodAdditiveBasisInfoVO detail = foodAdditiveBasisInfoMapper.selectFoodAdditiveBasisInfoDetail4(map);
			detail.setDispos_1(Utility.encodeChar(Utility.getNull(detail.getDispos_1()), 2));
			detail.setPuredo_test(Utility.encodeChar(Utility.getNull(detail.getPuredo_test()), 2));
			detail.setCont(Utility.encodeChar(Utility.getNull(detail.getCont()), 2));
			detail.setPrpos(Utility.encodeChar(Utility.getNull(detail.getPrpos()), 2));
			detail.setCnfm_test(Utility.encodeChar(Utility.getNull(detail.getCnfm_test()), 2));
			detail.setFdqntlaw_1(Utility.encodeChar(Utility.getNull(detail.getFdqntlaw_1()), 2));
			detail.setFrmlc_and_save_1(Utility.encodeChar(Utility.getNull(detail.getFrmlc_and_save_1()), 2));
			
			return detail;
			
		} catch(Exception e) {
			throw e;
		}
	}
	
	@Transactional(readOnly=true)
	public FoodAdditiveBasisInfoVO selectFoodAdditiveBasisInfoDetail5(FoodAdditiveBasisInfoVO foodAdditiveBasisInfoVO) throws Exception {
		HashMap<String, Object> map = new HashMap<String, Object>();
		
		try{
			map = CommonConvertObjectToMap.ConverObjectToMap(foodAdditiveBasisInfoVO);
			
			FoodAdditiveBasisInfoVO detail = foodAdditiveBasisInfoMapper.selectFoodAdditiveBasisInfoDetail5(map);
			detail.setPuredo_test(Utility.encodeChar(Utility.getNull(detail.getPuredo_test()), 2));
			detail.setCont(Utility.encodeChar(Utility.getNull(detail.getCont()), 2));
			detail.setCnfm_test(Utility.encodeChar(Utility.getNull(detail.getCnfm_test()), 2));
			detail.setNcknm(Utility.encodeChar(Utility.getNull(detail.getNcknm()), 2));
			detail.setChmsnm(Utility.encodeChar(Utility.getNull(detail.getChmsnm()), 2));
			detail.setEu_legacy_list(Utility.encodeChar(Utility.getNull(detail.getEu_legacy_list()), 2));
			detail.setDispos(Utility.encodeChar(Utility.getNull(detail.getDispos()), 2));
			detail.setUse_stdr(Utility.encodeChar(Utility.getNull(detail.getUse_stdr()), 2));
			
			return detail;
			
		} catch(Exception e) {
			throw e;
		}
	}
	
	@Transactional(readOnly=true)
	public FoodAdditiveBasisInfoVO selectFoodAdditiveBasisInfoDetail6(FoodAdditiveBasisInfoVO foodAdditiveBasisInfoVO) throws Exception {
		HashMap<String, Object> map = new HashMap<String, Object>();
		
		try{
			map = CommonConvertObjectToMap.ConverObjectToMap(foodAdditiveBasisInfoVO);
			
			FoodAdditiveBasisInfoVO detail = foodAdditiveBasisInfoMapper.selectFoodAdditiveBasisInfoDetail6(map);
			detail.setPuredo_test(Utility.encodeChar(Utility.getNull(detail.getPuredo_test()), 2));
			
			return detail;
			
		} catch(Exception e) {
			throw e;
		}
	}
	
	@Transactional(readOnly=true)
	public FoodAdditiveBasisInfoVO selectFoodAdditiveBasisInfoDetail7(FoodAdditiveBasisInfoVO foodAdditiveBasisInfoVO) throws Exception {
		HashMap<String, Object> map = new HashMap<String, Object>();
		
		try{
			map = CommonConvertObjectToMap.ConverObjectToMap(foodAdditiveBasisInfoVO);
			
			FoodAdditiveBasisInfoVO detail = foodAdditiveBasisInfoMapper.selectFoodAdditiveBasisInfoDetail7(map);
			detail.setPuredo_test(Utility.encodeChar(Utility.getNull(detail.getPuredo_test()), 2));
			detail.setCont(Utility.encodeChar(Utility.getNull(detail.getCont()), 2));
			detail.setCnfm_test(Utility.encodeChar(Utility.getNull(detail.getCnfm_test()), 2));
			detail.setDispos(Utility.encodeChar(Utility.getNull(detail.getDispos()), 2));
			detail.setDry_reductn(Utility.encodeChar(Utility.getNull(detail.getDry_reductn()), 2));
			detail.setIgnit_remn_rate(Utility.encodeChar(Utility.getNull(detail.getIgnit_remn_rate()), 2));
			detail.setFdqntlaw(Utility.encodeChar(Utility.getNull(detail.getFdqntlaw()), 2));
			detail.setItm_cn_a(Utility.encodeChar(Utility.getNull(detail.getItm_cn_a()), 2));
			detail.setItm_cn_b(Utility.encodeChar(Utility.getNull(detail.getItm_cn_b()), 2));
			detail.setItm_cn_c(Utility.encodeChar(Utility.getNull(detail.getItm_cn_c()), 2));
			detail.setItm_cn_d(Utility.encodeChar(Utility.getNull(detail.getItm_cn_d()), 2));
			detail.setItm_cn_e(Utility.encodeChar(Utility.getNull(detail.getItm_cn_e()), 2));
			detail.setItm_cn_f(Utility.encodeChar(Utility.getNull(detail.getItm_cn_f()), 2));
			detail.setItm_cn_g(Utility.encodeChar(Utility.getNull(detail.getItm_cn_g()), 2));
			detail.setItm_cn_h(Utility.encodeChar(Utility.getNull(detail.getItm_cn_h()), 2));
			detail.setItm_cn_i(Utility.encodeChar(Utility.getNull(detail.getItm_cn_i()), 2));
			detail.setItm_cn_j(Utility.encodeChar(Utility.getNull(detail.getItm_cn_j()), 2));
			detail.setUse_stdr(Utility.encodeChar(Utility.getNull(detail.getUse_stdr()), 2));
			
			return detail;
			
		} catch(Exception e) {
			throw e;
		}
	}
	
	@Transactional(readOnly=true)
	public List<FoodAdditiveBasisInfoVO> selectFoodAdditiveBasisInfoReformHistoryList(FoodAdditiveBasisInfoVO foodAdditiveBasisInfoVO) throws Exception {
		HashMap<String, Object> map = new HashMap<String, Object>();
		
		try{
			map = CommonConvertObjectToMap.ConverObjectToMap(foodAdditiveBasisInfoVO);
			
			List<FoodAdditiveBasisInfoVO> list = foodAdditiveBasisInfoMapper.selectFoodAdditiveBasisInfoReformHistoryList(map);
			
			return list;
			
		} catch(Exception e) {
			throw e;
		}
	}
	
	@Transactional(readOnly=true)
	public List<FoodAdditiveBasisInfoVO> selectFoodAdditiveBasisInfoCfrUseStandardList(FoodAdditiveBasisInfoVO foodAdditiveBasisInfoVO) throws Exception {
		HashMap<String, Object> map = new HashMap<String, Object>();
		
		try{
			map = CommonConvertObjectToMap.ConverObjectToMap(foodAdditiveBasisInfoVO);
			
			List<FoodAdditiveBasisInfoVO> list = foodAdditiveBasisInfoMapper.selectFoodAdditiveBasisInfoCfrUseStandardList(map);
			
			return list;
			
		} catch(Exception e) {
			throw e;
		}
	}
	
	@Transactional(readOnly=true)
	public List<FoodAdditiveBasisInfoVO> selectFoodAdditiveBasisInfoCodexUseStandardList(FoodAdditiveBasisInfoVO foodAdditiveBasisInfoVO) throws Exception {
		HashMap<String, Object> map = new HashMap<String, Object>();
		
		try{
			map = CommonConvertObjectToMap.ConverObjectToMap(foodAdditiveBasisInfoVO);
			
			List<FoodAdditiveBasisInfoVO> list = foodAdditiveBasisInfoMapper.selectFoodAdditiveBasisInfoCodexUseStandardList(map);
			
			return list;
			
		} catch(Exception e) {
			throw e;
		}
	}
	
}