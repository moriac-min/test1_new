package common.adminfacillity.commonmngt.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import common.adminfacillity.commonmngt.service.BoardService;
import common.adminfacillity.commonmngt.service.BoardVO;

/**
 * ComcmController
 * @author 유승엽
 * @since 2014.07.08
 * @version 1.0
 * @see
 *
 * <pre>
 *  Modification Information
 *  수정일      수정자   수정내용
 *  ---------- -------- ---------------------------
 *  2014.07.08  유승엽   최초 생성
 * </pre>
 *
 * Copyright (C) 2014 by NDS., All right reserved.
 */

@Controller
//@SessionAttributes(types=BoardVO.class)
public class BoardController {
	protected final Logger log = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private BoardService boardService;
	
	
	/**
	 * 게시판 목록 조회
	 * 
	 * @param BoardVO
	 * @return ModelAndView
	 * @throws Exception
	 */
	@RequestMapping(value = "/adminfacillity/commonmngt/selectBoard.do")
	public ModelAndView selectBoard(@ModelAttribute("boardVO") BoardVO boardVO, ModelMap model) throws Exception {
		ModelAndView mav = new ModelAndView("adminfacillity/commonmngt/board-list");
		List<Map<String, Object>> list = boardService.selectBoard(boardVO);
		model.addAttribute("resultList", list);
		return mav;
	}
	
	/**
	 * 게시판 글 작성 화면
	 * 
	 * @param BoardVO
	 * @return ModelAndView
	 * @throws Exception
	 */
	@RequestMapping(value = "/adminfacillity/commonmngt/boardWrite.do")
	public ModelAndView boardWrite(@ModelAttribute("boardVO") BoardVO boardVO, ModelMap model) throws Exception {
		ModelAndView mav = new ModelAndView("adminfacillity/commonmngt/board-write");
		return mav;
	}
	
	/**
	 * 게시판 글 보기
	 * 
	 * @param BoardVO
	 * @return ModelAndView
	 * @throws Exception
	 */
	@RequestMapping(value = "/adminfacillity/commonmngt/boardView.do")
	public ModelAndView boardView(@ModelAttribute("boardVO") BoardVO boardVO, ModelMap model) throws Exception {
		ModelAndView mav = new ModelAndView("adminfacillity/commonmngt/board-view");
		List<Map<String, Object>> list = boardService.boardView(boardVO);
		model.addAttribute("resultList", list);
		return mav;
	}
	
	/**
	 * 게시판 글 작성
	 * 
	 * @param BoardVO
	 * @return ModelAndView
	 * @throws Exception
	 */
	@RequestMapping(value = "/adminfacillity/commonmngt/insertBoard.do")
	public ModelAndView insertBoard(@ModelAttribute("boardVO") BoardVO boardVO, ModelMap model) throws Exception {
		ModelAndView mav = new ModelAndView("adminfacillity/commonmngt/board-list");
		boardService.insertBoard(boardVO);
		BoardVO newBoardVO = new BoardVO();
		List<Map<String, Object>> list = boardService.selectBoard(newBoardVO);
		model.addAttribute("resultList", list);
		return mav;
	}
	
	/**
	 * 게시판 글 수정
	 * 
	 * @param BoardVO
	 * @return ModelAndView
	 * @throws Exception
	 */
	@RequestMapping(value = "/adminfacillity/commonmngt/updateBoard.do")
	public ModelAndView updateBoard(@ModelAttribute("boardVO") BoardVO boardVO, ModelMap model) throws Exception {
		ModelAndView mav = new ModelAndView("adminfacillity/commonmngt/board-list");
		boardService.updateBoard(boardVO);
		BoardVO newBoardVO = new BoardVO();
		List<Map<String, Object>> list = boardService.selectBoard(newBoardVO);
		model.addAttribute("resultList", list);
		return mav;
	}
	
	/**
	 * 게시판 글 삭제
	 * 
	 * @param BoardVO
	 * @return ModelAndView
	 * @throws Exception
	 */
	@RequestMapping(value = "/adminfacillity/commonmngt/deleteBoard.do")
	public ModelAndView deleteBoard(@ModelAttribute("boardVO") BoardVO boardVO, ModelMap model) throws Exception {
		ModelAndView mav = new ModelAndView("adminfacillity/commonmngt/board-list");
		boardService.deleteBoard(boardVO);
		BoardVO newBoardVO = new BoardVO();
		List<Map<String, Object>> list = boardService.selectBoard(newBoardVO);
		model.addAttribute("resultList", list);
		return mav;
	}
}
