package foodportal.front.fooddanger.mapper;

import java.util.List;
import java.util.Map;

import egovframework.rte.psl.dataaccess.mapper.Mapper;
import foodportal.front.fooddanger.vo.AdministMeasureVO;

/**
 * AdministMeasureMapper
 * @author 박재형
 * @since 2014.10.06
 * @version 1.0
 * @see
 * 
 * <pre>
 *  Modification Information
 *  수정일      수정자   수정내용
 *  ---------- -------- ---------------------------
 *  2014.10.06 박재형 최초 생성
 * </pre>
 * 
 * Copyright (C) 2014 by NDS., All right reserved.
 */
         
@Mapper("foodportal.front.fooddanger.mapper.AdministMeasureMapper")
public interface AdministMeasureMapper {
	
	/**
	 * 행정처분 목록
	 * @param 
	 * @return
	 */
	public List<AdministMeasureVO> selectAdministMeasureList(Map<String, Object> map);
	
	/**
	 * 행정처분 총개수
	 * @param 
	 * @return
	 */
	public int selectAdministMeasureTotalCnt(Map<String, Object> map);
	
	/**
	 * 행정처분 상세
	 * @param map
	 * @return
	 */
	public AdministMeasureVO selectAdministMeasureDetail(Map<String, Object> map);
	
	
}
