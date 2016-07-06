package common.adminfacillity.systemmngt.mapper;

import java.util.List;
import java.util.Map;

import egovframework.rte.psl.dataaccess.mapper.Mapper;
import common.adminfacillity.systemmngt.service.CommonPopupVO;
import common.adminfacillity.systemmngt.service.CommonPopupItemVO;
/**
 * CommonPopupMapper
 * @author 유승엽
 * @since 2014.08.19
 * @version 1.0
 * @see
 * 
 * <pre>
 *  Modification Information
 *  수정일      수정자   수정내용
 *  ---------- -------- ---------------------------
 *  2014.08.19 유승엽 최초 생성
 * </pre>
 * 
 * Copyright (C) 2014 by NDS., All right reserved.
 */

@Mapper("common.adminfacillity.systemmngt.mapper.CommonPopupMapper")
public interface CommonPopupMapper {

	public List<CommonPopupVO> selectCommonPopup(Map<String, Object> map);
	
	public int insertCommonPopup(Map<String, Object> map);
	
	public int updateCommonPopup(Map<String, Object> map);
	
	public int deleteCommonPopup(Map<String, Object> map);

	public List<CommonPopupItemVO> selectCommonPopupItem(Map<String, Object> map);
	
	public int insertCommonPopupItem(Map<String, Object> map);
	
	public int updateCommonPopupItem(Map<String, Object> map);
	
	public int deleteCommonPopupItem(Map<String, Object> map);
}