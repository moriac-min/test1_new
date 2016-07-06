package foodportal.front.common.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.transaction.annotation.Transactional;

import common.commonfacillity.uia.WqBaseBean;
import foodportal.front.common.vo.CategoryVo;
import foodportal.front.common.vo.FrontBoardVO;
import foodportal.front.common.vo.FrontMenuVO;
import foodportal.front.common.vo.UploadFileVO;


/**
 * FrontMenuService
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

public interface FrontMenuService {

	/**
	 * 그룹별 메뉴정보
	 * @param 
	 * @return 
	 * @exception Exception
	 */
	public List<FrontMenuVO> selectMenuGrpList(Map<String, Object> paramMap) throws Exception;
	
	/**
	 * 메뉴트리순서
	 * @param 
	 * @return 
	 * @exception Exception
	 */
	public FrontMenuVO selectMenuTree(Map<String, Object> paramMap) throws Exception;
	
	
}