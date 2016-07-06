package foodportal.front.fooddanger.mapper;

import java.util.List;
import java.util.Map;

import egovframework.rte.psl.dataaccess.mapper.Mapper;
import foodportal.front.fooddanger.vo.FoodDangerFileVO;
import foodportal.front.fooddanger.vo.TestUnfitVO;

/**
 * TestUnfitMapper
 * @author 최승희
 * @since 2014.10.02
 * @version 1.0
 * @see
 * 
 * <pre>
 *  Modification Information
 *  수정일     수정자   수정내용
 *  ---------- -------- ---------------------------
 *  2014.10.02 최승희 	최초 생성
 * </pre>
 * 
 * Copyright (C) 2014 by NDS., All right reserved.
 */

@Mapper("foodportal.front.fooddanger.mapper.TestUnfitMapper")
public interface TestUnfitMapper {

	public List<TestUnfitVO> selectTestUnfitList(Map<String, Object> map);

	public int selectTestUnfitTotalCnt(Map<String, Object> map);

	public TestUnfitVO selectTestUnfitDetail(Map<String, Object> map);

	public List<FoodDangerFileVO> selectAttachFileList(Map<String, Object> map);

	public List<TestUnfitVO> selectTestUnfitAbrdList(Map<String, Object> map);

	public int selectTestUnfitAbrdTotalCnt(Map<String, Object> map);

}
