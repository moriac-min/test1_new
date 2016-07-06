package foodportal.front.fooddanger.mapper;

import java.util.List;
import java.util.Map;

import egovframework.rte.psl.dataaccess.mapper.Mapper;
import foodportal.front.fooddanger.vo.FoodDangerFileVO;
import foodportal.front.fooddanger.vo.OverseasRecallVO;

/**
 * OverseasRecallMapper
 * @author 최승희
 * @since 2014.10.01
 * @version 1.0
 * @see
 * 
 * <pre>
 *  Modification Information
 *  수정일     수정자   수정내용
 *  ---------- -------- ---------------------------
 *  2014.10.01 최승희 	최초 생성
 * </pre>
 * 
 * Copyright (C) 2014 by NDS., All right reserved.
 */

@Mapper("foodportal.front.fooddanger.mapper.OverseasRecallMapper")
public interface OverseasRecallMapper {

	public List<OverseasRecallVO> selectOverseasRecallList(Map<String, Object> map);

	public int selectOverseasRecallTotalCnt(Map<String, Object> map);

	public OverseasRecallVO selectOverseasRecallDetail(Map<String, Object> map);

}
