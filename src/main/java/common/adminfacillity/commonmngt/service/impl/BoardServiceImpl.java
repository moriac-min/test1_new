package common.adminfacillity.commonmngt.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.lang.Integer;

import javax.annotation.Resource;

import egovframework.rte.fdl.cmmn.AbstractServiceImpl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import common.adminfacillity.commonmngt.mapper.BoardMapper;
import common.adminfacillity.commonmngt.service.BoardService;
import common.adminfacillity.commonmngt.service.BoardVO;

/**
 * EdusaServiceImpl
 * @author 유승엽
 * @since 2014.07.08
 * @version 1.0
 * @see
 *
 * <pre>
 *  Modification Information
 *  수정일      수정자   수정내용
 *  ---------- -------- ---------------------------
 *  2014.07.08 유승엽   최초 생성
 * </pre>
 *
 * Copyright (C) 2014 by NDS., All right reserved.
 */

@Service("BoardService")
public class BoardServiceImpl extends AbstractServiceImpl implements BoardService {

	protected final Logger log = LoggerFactory.getLogger(this.getClass());

	@Autowired
	BoardMapper boardMapper;
	
	/* (non-Javadoc)
	 * @see common.education.sample.service.EdusaService#selectEduSawonList(java.util.Map)
	 */
	@Transactional(readOnly=true)
	public List<Map<String, Object>> selectBoard(BoardVO vo) throws Exception {
		String vSearchCondition = vo.getSearchCondition();
		String vSearchKeyword = vo.getSearchKeyword();
		if(vSearchKeyword == "" || vSearchKeyword == null){
			return boardMapper.selectBoard(vo);
		}else{
			if("2".equals(vSearchCondition)){	//2: 사번
				vo.setUserid(Integer.parseInt(vSearchKeyword));
			} else if("1".equals(vSearchCondition)){	//1: 제목
				vo.setTitle(vSearchKeyword);
			} else if("0".equals(vSearchCondition)){    //0: 내용
				vo.setContent(vSearchKeyword);
			}
			return boardMapper.searchBoard(vo);
		}
	}
	
	@Transactional(readOnly=true)
	public List<Map<String, Object>> boardView(BoardVO vo) throws Exception {
		vo.setNumber(Integer.parseInt(vo.getSearchKeyword()));
		return boardMapper.searchBoard(vo);
	}
	
	@Transactional
	public void insertBoard(BoardVO vo) throws Exception {
		boardMapper.insertBoard(vo);
	}
	
	@Transactional
	public void updateBoard(BoardVO vo) throws Exception {
		boardMapper.updateBoard(vo);
	}
	
	@Transactional
	public void deleteBoard(BoardVO vo) throws Exception {
		boardMapper.deleteBoard(vo);
	}
}