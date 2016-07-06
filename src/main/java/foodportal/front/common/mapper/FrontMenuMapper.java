package foodportal.front.common.mapper;

import java.util.List;
import java.util.Map;

import egovframework.rte.psl.dataaccess.mapper.Mapper;
import foodportal.front.common.vo.FrontMenuVO;
import foodportal.front.common.vo.UploadFileVO;
import foodportal.front.common.vo.CategoryVo;
import foodportal.front.common.vo.FrontBoardVO;

/**
 * FrontMenuMapper
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
         
@Mapper("foodportal.front.common.mapper.FrontMenuMapper")
public interface FrontMenuMapper {
	
	/**
	 * 그룹별 메뉴정보
	 * @param paramMap
	 * @return
	 * @throws Exception
	 */
	public List<FrontMenuVO> selectMenuGrpList(Map<String, Object> paramMap) throws Exception;
	
	/**
	 * 그룹별 메뉴정보
	 * @param paramMap
	 * @return
	 * @throws Exception
	 */
	public FrontMenuVO selectMenuTree(Map<String, Object> paramMap) throws Exception;
	
	
}
