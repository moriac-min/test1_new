package foodportal.front.fooddanger.mapper;

import java.util.List;
import java.util.Map;

import egovframework.rte.psl.dataaccess.mapper.Mapper;
import foodportal.front.fooddanger.vo.FoodDangerFileVO;
import foodportal.front.fooddanger.vo.PuffVO;

/**
 * PuffMapper
 * @author 최승희
 * @since 2014.10.06
 * @version 1.0
 * @see
 * 
 * <pre>
 *  Modification Information
 *  수정일     수정자   수정내용
 *  ---------- -------- ---------------------------
 *  2014.10.06 최승희 	최초 생성
 * </pre>
 * 
 * Copyright (C) 2014 by NDS., All right reserved.
 */

@Mapper("foodportal.front.fooddanger.mapper.PuffMapper")
public interface PuffMapper {

	public List<PuffVO> selectPuffList(Map<String, Object> map);

	public int selectPuffTotalCnt(Map<String, Object> map);

	public PuffVO selectPuffDetail(Map<String, Object> map);

	public List<FoodDangerFileVO> selectAttachFileList(Map<String, Object> map);

}
