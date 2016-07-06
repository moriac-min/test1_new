package foodportal.front.fooddanger.mapper;

import java.util.List;
import java.util.Map;

import egovframework.rte.psl.dataaccess.mapper.Mapper;
import foodportal.front.fooddanger.vo.CrackdownVO;
import foodportal.front.fooddanger.vo.MarienCrackdownVO;

/**
 * CrackdownMapper
 * @author 박재형
 * @since 2014.09.25
 * @version 1.0
 * @see
 * 
 * <pre>
 *  Modification Information
 *  수정일      수정자   수정내용
 *  ---------- -------- ---------------------------
 *  2014.09.25 박재형 최초 생성
 * </pre>
 * 
 * Copyright (C) 2014 by NDS., All right reserved.
 */
         
@Mapper("foodportal.front.fooddanger.mapper.CrackdownMapper")
public interface CrackdownMapper {
	
	/**
	 * 농축산물원산지표시위반 목록
	 * @param 
	 * @return
	 */
	public List<CrackdownVO> selectAgriCrackdownList(Map<String, Object> map);
	
	/**
	 * 농축산물원산지표시위반 총개수
	 * @param 
	 * @return
	 */
	public int selectAgriCrackdownTotalCnt(Map<String, Object> map);
	
	/**
	 * 농축산물원산지표시위반 상세
	 * @param map
	 * @return
	 */
	public CrackdownVO selectAgriCrackdownDetail(Map<String, Object> map);
	
	
	/**
	 * 수산물원산지표시위반 목록
	 * @param 
	 * @return
	 */
	public List<MarienCrackdownVO> selectMarienCrackdownList(Map<String, Object> map);
	
	/**
	 * 수산물원산지표시위반 총개수
	 * @param 
	 * @return
	 */
	public int selectMarienCrackdownTotalCnt(Map<String, Object> map);
	
	/**
	 * 수산물원산지표시위반 상세
	 * @param map
	 * @return
	 */
	public MarienCrackdownVO selectMarienCrackdownDetail(Map<String, Object> map);
	
}
