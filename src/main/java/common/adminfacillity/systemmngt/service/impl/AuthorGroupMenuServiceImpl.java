package common.adminfacillity.systemmngt.service.impl;

import java.util.HashMap;
import java.util.List;
import egovframework.rte.fdl.cmmn.AbstractServiceImpl;
import common.adminfacillity.systemmngt.service.AdminfacillitySystemmngtRootVO;
import common.adminfacillity.systemmngt.service.AuthorGroupMenuService;
import common.adminfacillity.systemmngt.mapper.AuthorGroupMenuMapper;
import common.adminfacillity.systemmngt.service.AuthorGroupMenuVO;

import org.slf4j.Logger;

import common.commonfacillity.uia.WqBaseBean;
import common.commonfacillity.util.CommonConvertObjectToMap;
import common.commonfacillity.util.CommonSessionUtil;
import common.commonfacillity.util.CommonStringUtil;
import common.commonfacillity.log.CommonLog;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.apache.commons.lang.StringUtils;

/**
 * AuthorGroupMenuService
 * @author 김민규
 * @since 2014.08.19
 * @version 1.0
 * @see
 * 
 * <pre>
 *  Modification Information
 *  수정일      수정자   수정내용
 *  ---------- -------- ---------------------------
 *  2014.08.19 김민규 최초 생성
 * </pre>
 * 
 * Copyright (C) 2014 by NDS., All right reserved.
 */

@Service("authorGroupMenuService")
public class AuthorGroupMenuServiceImpl extends AbstractServiceImpl implements AuthorGroupMenuService {

	@CommonLog Logger log;

	@Autowired
	AuthorGroupMenuMapper authorGroupMenuMapper;


	/* (non-Javadoc)
	 * @see common.adminfacillity.systemmngt.service.AuthorGroupMenuService#selectAuthorGroupMenu(java.util.Map)
	 */
	@Transactional(readOnly=true)
	public List<AuthorGroupMenuVO> selectAuthorGroupMenu(WqBaseBean ibean) throws Exception {
		HashMap<String, Object> map = new HashMap<String, Object>();
		try {
			AdminfacillitySystemmngtRootVO adminfacillitySystemmngtRootVo = (AdminfacillitySystemmngtRootVO) ibean;
			AuthorGroupMenuVO authorGroupMenuVO = adminfacillitySystemmngtRootVo.getAuthorGroupMenuVO();
			
			map = CommonConvertObjectToMap.ConverObjectToMap(authorGroupMenuVO);
			
			List<AuthorGroupMenuVO> list = authorGroupMenuMapper.selectAuthorGroupMenu(map);
			
			return list;
		} catch (Exception e) {
			
			throw e;
		}
	}
	
	/* (non-Javadoc)
	 * @see common.adminfacillity.systemmngt.service.AuthorGroupMenuService#saveAuthorGroupMenu(java.util.Map)
	 */
	@Transactional
	public int saveAuthorGroupMenu(WqBaseBean ibean) throws Exception {
		HashMap<String, Object> map = new HashMap<String, Object>();
		HashMap<String, Object> delMap = new HashMap<String, Object>();
		int resultObj = 1;
		
		try {
			AdminfacillitySystemmngtRootVO adminfacillitySystemmngtRootVo = (AdminfacillitySystemmngtRootVO) ibean;
			List infoList = adminfacillitySystemmngtRootVo.getInfoList();
			AuthorGroupMenuVO authorGroupMenuVO;
			
			for(int idx = 0, iCnt = infoList.size(); idx < iCnt ; idx++) {
				authorGroupMenuVO = (AuthorGroupMenuVO) infoList.get(idx);
				map = CommonConvertObjectToMap.ConverObjectToMap(authorGroupMenuVO);
				
				//해당 그룹의 권한 메뉴를 전부 삭제한다.
				if(idx == 0){
					delMap.put("athr_grp_cd", map.get("athr_grp_cd"));
					delMap.put("sys_cd", map.get("sys_cd"));
					authorGroupMenuMapper.deleteAllAuthorGroupMenu(delMap);
				}
				
				//화면권한이 있는 모든 데이터를 Insert한다.
				if("1".equals(map.get("scrn_athr_yn"))){
					authorGroupMenuMapper.insertAuthorGroupMenu(map);
				}
			}
			
			return resultObj;
		} catch (Exception e) {
			
			resultObj = 0;
			return resultObj;
		}
	}

	/* (non-Javadoc)
	 * @see common.adminfacillity.systemmngt.service.AuthorGroupMenuService#insertAuthorGroupMenu(java.util.Map)
	 */
	@Transactional
	public int insertAuthorGroupMenu(WqBaseBean ibean) throws Exception {
		HashMap<String, Object> map = new HashMap<String, Object>();
		int resultObj = 1;
		try {
			AdminfacillitySystemmngtRootVO adminfacillitySystemmngtRootVO = (AdminfacillitySystemmngtRootVO) ibean;
			AuthorGroupMenuVO authorGroupMenuVO = adminfacillitySystemmngtRootVO.getAuthorGroupMenuVO();
			
			map = CommonConvertObjectToMap.ConverObjectToMap(authorGroupMenuVO);
			
			return authorGroupMenuMapper.insertAuthorGroupMenu(map);
		} catch (Exception e) {
			
			resultObj = 0;
			return resultObj;
		}
	}

	/* (non-Javadoc)
	 * @see common.adminfacillity.systemmngt.service.AuthorGroupMenuService#updateAuthorGroupMenu(java.util.Map)
	 */
	@Transactional
	public int updateAuthorGroupMenu(WqBaseBean ibean) throws Exception {
		HashMap<String, Object> map = new HashMap<String, Object>();
		int resultObj = 1;
		try {
			AdminfacillitySystemmngtRootVO adminfacillitySystemmngtRootVO = (AdminfacillitySystemmngtRootVO) ibean;
			AuthorGroupMenuVO authorGroupMenuVO = adminfacillitySystemmngtRootVO.getAuthorGroupMenuVO();
			
			map = CommonConvertObjectToMap.ConverObjectToMap(authorGroupMenuVO);
			
			return authorGroupMenuMapper.updateAuthorGroupMenu(map);
		} catch (Exception e) {
			
			resultObj = 0;
			return resultObj;
		}
	}

	/* (non-Javadoc)
	 * @see common.adminfacillity.systemmngt.service.AuthorGroupMenuService#deleteAuthorGroupMenu(java.util.Map)
	 */
	@Transactional
	public int deleteAuthorGroupMenu(WqBaseBean ibean) throws Exception {
		HashMap<String, Object> map = new HashMap<String, Object>();
		int resultObj = 1;
		try {
			AdminfacillitySystemmngtRootVO adminfacillitySystemmngtRootVO = (AdminfacillitySystemmngtRootVO) ibean;
			AuthorGroupMenuVO authorGroupMenuVO = adminfacillitySystemmngtRootVO.getAuthorGroupMenuVO();
			
			map = CommonConvertObjectToMap.ConverObjectToMap(authorGroupMenuVO);
			
			return authorGroupMenuMapper.deleteAuthorGroupMenu(map);
		} catch (Exception e) {
			
			resultObj = 0;
			return resultObj;
		}
	}
	
	/* (non-Javadoc)
	 * @see common.adminfacillity.systemmngt.service.AuthorGroupMenuService#selectAuthorMenuList(java.util.Map)
	 */
	@Transactional(readOnly=true)
	public List<AuthorGroupMenuVO> selectAuthorMenuList(WqBaseBean ibean) throws Exception {
		HashMap<String, Object> map = new HashMap<String, Object>();
		try {
			AdminfacillitySystemmngtRootVO adminfacillitySystemmngtRootVo = (AdminfacillitySystemmngtRootVO) ibean;
			AuthorGroupMenuVO authorGroupMenuVO = adminfacillitySystemmngtRootVo.getAuthorGroupMenuVO();
			
			map = CommonConvertObjectToMap.ConverObjectToMap(authorGroupMenuVO);
			
			if(StringUtils.isEmpty(map.get("cretr_id").toString())){
				//TODO
				//로그인 개발 되면 로그인시 저장된 session정보를 가져온다.
				CommonSessionUtil.setAttribute("cretr_id", "30005060");
			}
			
			map.put("cretr_id", CommonSessionUtil.getAttribute("cretr_id"));
			
			List<AuthorGroupMenuVO> list = authorGroupMenuMapper.selectAuthorMenuList(map);
			
			return list;
		} catch (Exception e) {
			
			throw e;
		}
	}
}