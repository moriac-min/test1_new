package foodportal.front.fooddanger.mapper;

import java.util.List;
import java.util.Map;

import egovframework.rte.psl.dataaccess.mapper.Mapper;
import foodportal.front.fooddanger.vo.FoodDangerFileVO;
import foodportal.front.fooddanger.vo.SuspensionVO;

/**
 * SuspensionMapper
 * @author 최승희
 * @since 2014.10.08
 * @version 1.0
 * @see
 * 
 * <pre>
 *  Modification Information
 *  수정일     수정자   수정내용
 *  ---------- -------- ---------------------------
 *  2014.10.08 최승희 	최초 생성
 * </pre>
 * 
 * Copyright (C) 2014 by NDS., All right reserved.
 */

@Mapper("foodportal.front.suspension.mapper.SuspensionMapper")
public interface SuspensionMapper {

	public List<SuspensionVO> selectSuspensionList(Map<String, Object> map);

	public int selectSuspensionTotalCnt(Map<String, Object> map);

	public SuspensionVO selectSuspensionDetail(Map<String, Object> map);

	public List<FoodDangerFileVO> selectAttachFileList(Map<String, Object> map);

}
