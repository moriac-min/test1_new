package foodportal.front.common.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import abc.cms.util.JSonUtil;

import com.google.gson.Gson;

import common.commonfacillity.log.CommonLog;
import foodportal.common.util.Message;
import foodportal.common.util.StringUtil;
import foodportal.front.common.service.FrontBoardService;
import foodportal.front.common.vo.CategoryVo;
import foodportal.front.common.vo.FrontBoardVO;
import foodportal.front.common.vo.FrontMetaKeywordVO;
import foodportal.front.common.vo.UploadFileVO;

@Controller
public class FrontBoardController {
	
	@CommonLog Logger log;
	@Autowired
	private FrontBoardService frontBoardService;
	
	/**
	 * 게시판 목록
	 * @param model
	 * @param request
	 * @param response
	 * @return
	 * @throws IOException
	 */
	@RequestMapping("*/board/board.do")
	public String boardFrame(Model model, HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		Map<String, Object> paramMap = null;	//조회조건 파라미터맵
		FrontBoardVO boardSettingVO = null;		//설정정보
		List<CategoryVo> ctgType01List = null;	//카테고리 목록
		List ctgType02List = null;	//하위 카테고리 목록
		List<CategoryVo> ctgType02TmpList = null;	//하위 카테고리 목록
		List<FrontMetaKeywordVO> keywordList = null;	//키워드목록
		String CheckResult = "false";
		
		/**
		 * 조회조건
		 */
		String menu_no = "";		//메뉴번호

    	String filePath = "";
    	String menu_grp = StringUtil.NVLToSpace(request.getAttribute("menu_grp"));
    	
    	if(StringUtil.NVLToSpace(request.getAttribute("sys_dvs_cd")).equals("SITE01")){
    		filePath = "/portal/";
    	}else if(StringUtil.NVLToSpace(request.getAttribute("sys_dvs_cd")).equals("SITE02")){
    		filePath = "/minwon/";
    	}else if(StringUtil.NVLToSpace(request.getAttribute("sys_dvs_cd")).equals("SITE03")){
    		filePath = "/api/";
    	}else if(StringUtil.NVLToSpace(request.getAttribute("sys_dvs_cd")).equals("SITE04")){
    		filePath = "/csm/";
    	}
    	
		
		try {
			menu_no = StringUtil.NVLToSpace(request.getParameter("menu_no"));

			if(!"".equals(menu_no)){
				
				paramMap = new HashMap<String, Object>();
				paramMap.put("menu_no", menu_no);
				
				//게시판 설정 조회
				boardSettingVO = frontBoardService.getBbsSettingInfo(paramMap);
				
				if(boardSettingVO == null || boardSettingVO.getBbs_no().equals("") || boardSettingVO.getBbs_no() == null){ 
					return StringUtil.alertRedirect(response, Message.getMessage("msg.board.notExist"),filePath+"/none.do?menu_grp="+menu_grp);	//존재하지 않는 게시판입니다.
				}
				
				boardSettingVO.setBbs_templet_nm("bbsType"+(boardSettingVO.getBbs_type_cd()+"_list.jsp")
						.replace("06","05")				//동영상게시판 == 포토게시판
						.replace("04","03")				//컨텐츠B == 컨텐츠A
						.replace("910","01"));			//뉴스레터 == 일반게시판
							
				//카테고리 조회
				if(boardSettingVO.getCtgry_type_cd() != null){
					//일반형 또는 상위카테고리
					if("CTG_TYPE01".equals(boardSettingVO.getCtgry_type_cd()) || "CTG_TYPE02".equals(boardSettingVO.getCtgry_type_cd())){
						ctgType01List = frontBoardService.selectCtgType01List(boardSettingVO);
						
						//계층형 카테고리 - 첫번째 상위카테고리로 하위카테고리 조회
						if("CTG_TYPE02".equals(boardSettingVO.getCtgry_type_cd())){
							if(ctgType01List != null){
								ctgType02List = new ArrayList();
								if(ctgType01List.size() > 0){
									for(int i=0; i<ctgType01List.size(); i++){
										ctgType02TmpList = frontBoardService.selectCtgType02List(StringUtil.NVLToSpace(ctgType01List.get(i).getCtgry_no()).toString());
										ctgType02List.add(ctgType02TmpList);
									}
								}
							}
						}
					}
				}
				
				//키워드 조회
				if("Y".equals(StringUtil.NVLToSpace(boardSettingVO.getKword_use_yn()))){
					Map<String, Object> keyMap = new HashMap<String, Object>();
					keyMap.put("bbs_no", boardSettingVO.getBbs_no());
					keywordList = frontBoardService.selectKeywordList(keyMap);
				}
				
				/**
				 * return Object 셋팅
				 */
				model.addAttribute("boardSetting", boardSettingVO);		//게시판설정
				model.addAttribute("ctgType01List", ctgType01List);		//일반형 카테고리 목록
				model.addAttribute("ctgType02List", ctgType02List);		//계층형 카테고리 목록
				model.addAttribute("keywordList", keywordList);			//키워드목록
				
				CheckResult = "true";
			}else{
				CheckResult = "false";
			}
		} catch (Exception e) {
			CheckResult = "error";
		}
		
		if(!"true".equals(CheckResult)){
			if("false".equals(CheckResult))
				return StringUtil.alertRedirect(response, Message.getMessage("msg.common.access.role2"));	//잘못된 접근입니다.
			
			if("error".equals(CheckResult))
				return StringUtil.alertRedirect(response, Message.getMessage("msg.common.system.error"));	//시스템에러가 발생하였습니다. 관리자에게 문의하십시오.
		}
		
		return "/bbs/bbsListFrame";
	}
	
	/**
	 * 게시판 목록
	 * @param model
	 * @param request
	 * @param response
	 * @return
	 * @throws IOException
	 */
	@RequestMapping("*/board/boardList.do")
	public void boardList(Model model, HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		List<FrontBoardVO> list = null;
		Map<String, Object> paramMap = null;	//조회조건 파라미터맵
		FrontBoardVO boardSettingVO = null;		//설정정보
		List<UploadFileVO> fileUploadList = null;		//파일첨부

		/**
		 * 조회조건
		 */
		String bbs_no = "";			//메뉴번호
		String start_idx = "";		//페이징 시작번호
		String show_cnt = "";		//보여줄 개수
		String search_type = "";	//조회조건타입
		String search_keyword = "";	//조회조건텍스트
		String ctgry_no = "";		//카테고리
		String hrnk_ctgryno = "";	//상위카테고리
		String keyword = "";		//키워드
		String nticmatr_yn = "";	//공지사항
		String bbs_type_cd = "";	//게시판타입
		
		HashMap<String, Object> returnMap = null;
		
		try {
			bbs_no = StringUtil.NVLToSpace(request.getParameter("bbs_no"));
			search_type = StringUtil.NVLToSpace(request.getParameter("search_type"));
			search_keyword = StringUtil.NVLToSpace(request.getParameter("search_keyword"));
			ctgry_no = StringUtil.NVLToSpace(request.getParameter("ctgry_no"));
			hrnk_ctgryno = StringUtil.NVLToSpace(request.getParameter("hrnk_ctgryno"));
			start_idx = StringUtil.nullToStr(request.getParameter("start_idx"), "1");		
			show_cnt = StringUtil.nullToStr(request.getParameter("show_cnt"), "10");
			keyword = StringUtil.NVLToSpace(request.getParameter("keywrd"));
			nticmatr_yn = StringUtil.NVLToSpace(request.getParameter("nticmatr_yn"));
			bbs_type_cd = StringUtil.NVLToSpace(request.getParameter("bbs_type_cd"));

			if(!"".equals(bbs_no)){
				
				paramMap = new HashMap<String, Object>();
				paramMap.put("bbs_no", bbs_no);
				
				//게시판 설정 조회
				boardSettingVO = new FrontBoardVO(); 
				
				//조회조건셋팅
				boardSettingVO.setBbs_no(bbs_no);
				boardSettingVO.setSearch_type(search_type);
				boardSettingVO.setSearch_keyword(search_keyword);
				boardSettingVO.setStart_idx(start_idx);
				boardSettingVO.setShow_cnt(show_cnt);
				boardSettingVO.setCtgry_no(ctgry_no);
				boardSettingVO.setHrnk_ctgryno(hrnk_ctgryno);
				boardSettingVO.setKeyword(keyword);
				boardSettingVO.setNticmatr_yn(nticmatr_yn);
				
				//글목록 + total cnt 을 map에 셋팅
				Map<String, Object>  listMap = frontBoardService.selectBoardList(boardSettingVO);
				
				list = (List<FrontBoardVO>) listMap.get("boardList");
				
				//07 FAQ형일 경우 첨부파일을 가져온다.
				if("07".equals(bbs_type_cd)){
					if(list != null){
						if(list.size() > 0){
							for(int i=0; i<list.size(); i++){
								paramMap.put("ntctxt_no", list.get(i).getNtctxt_no());
								fileUploadList = new ArrayList<UploadFileVO>();
								fileUploadList = frontBoardService.selectBoardFile(paramMap);
								if(fileUploadList != null){
									if(fileUploadList.size() > 0){
										for(int j=0; j<fileUploadList.size(); j++){
											fileUploadList.get(j).setFile_path(fileUploadList.get(j).getFile_path().replaceAll("\\\\", "/"));
											System.out.println("=======fileUploadList====>"+fileUploadList.get(j).getFile_path());
										}
									}
								}
								list.get(i).setFileList(fileUploadList);
							}
						}
					}
				}
				
				returnMap = new HashMap<String, Object>();
				returnMap.put("list", list);
				returnMap.put("total_cnt", listMap.get("total_cnt").toString());

			}
		} catch (Exception e) {
		}
		
		response.setContentType("text/plain; charset=\"utf-8\"");
		response.getWriter().write(new Gson().toJson(returnMap)); 
	}
	
	
	
	/**
	 * 게시판 글 상세
	 * @param model
	 * @param request
	 * @param response
	 * @return
	 * @throws IOException
	 */
	@RequestMapping("*/board/boardDetail.do")
	public String boardDetail(Model model, HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		FrontBoardVO frontBoardVO = null;				//글상세
		FrontBoardVO boardSettingVO = null;				//설정정보
		List<UploadFileVO> fileUploadList = null;		//파일첨부
		List<HashMap<String, Object>> tagList = null;					//태그정보

		Map<String, Object> paramMap = null;			//조건 파라미터맵
		
		String menu_no = "";		//메뉴번호
		String bbs_no = "";			//게시판번호
		String ntctxt_no = "";		//글번호
		
		try {
			paramMap = new HashMap<String, Object>();
			
			menu_no = StringUtil.NVLToSpace(request.getParameter("menu_no"));
			ntctxt_no = StringUtil.NVLToSpace(request.getParameter("ntctxt_no"));
			bbs_no = StringUtil.NVLToSpace(request.getParameter("bbs_no"));
			
			if("".equals(ntctxt_no) && "".equals(bbs_no)){
				throw new Exception();
			}
			
			paramMap = new HashMap<String, Object>();
			paramMap.put("menu_no", menu_no);
			paramMap.put("ntctxt_no", ntctxt_no);
			paramMap.put("bbs_no", bbs_no);
			
			//게시판 설정 조회
			boardSettingVO = new FrontBoardVO(); 
			boardSettingVO = frontBoardService.getBbsSettingInfo(paramMap);
			
			boardSettingVO.setBbs_templet_nm(("bbsType"+boardSettingVO.getBbs_type_cd()+"_detail.jsp")
					.replace("04", "03")		//컨텐츠B == 컨텐츠A
					.replace("910", "01"));		//뉴스레터 == 일반
			
			paramMap.put("bbs_type_cd", StringUtil.NVLToSpace(boardSettingVO.getBbs_type_cd()));
			
			//글상세
			frontBoardVO = frontBoardService.selectBoardDetail(paramMap);
			
			//첨부파일
			if("Y".equals(StringUtil.NVLToSpace(boardSettingVO.getAtch_file_posbl_yn()))){
				fileUploadList = frontBoardService.selectBoardFile(paramMap);
			}
			
			//태그정보
			if("Y".equals(StringUtil.NVLToSpace(boardSettingVO.getTag_use_yn()))){
				if(!"".equals(StringUtil.NVLToSpace(frontBoardVO.getTag_info()))){
					
					tagList = new ArrayList<HashMap<String, Object>>();
					
					String[] tags = StringUtil.NVLToSpace(frontBoardVO.getTag_info()).split(",");
					
					if(tags != null){
						if(tags.length > 0){
							HashMap<String, Object> tagMap = new HashMap<String, Object>();
							for(int i=0; i<tags.length; i++){
								tagMap = new HashMap<String, Object>();
								if(i == tags.length-1){
									tagMap.put("tag", tags[i].toString().trim());
								}else{
									tagMap.put("tag", tags[i].toString().trim()+", ");
								}
								
								tagList.add(tagMap);
								System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>"+tagList.size());
								System.out.println(tagList.get(i).get("tag"));
							}
						}
					}
				}
			}
			
			/**
			 * return Object 셋팅
			 */
			model.addAttribute("boardSetting", boardSettingVO);	//게시판설정
			model.addAttribute("boardDetail", frontBoardVO);	//글상세
			model.addAttribute("fileUploadList", fileUploadList);		//첨부파일
			model.addAttribute("tagList", tagList);	//태그정보 
			
			//글 조회 증가
			frontBoardService.addReadCnt(ntctxt_no);
			
		} catch (Exception e) {
			return StringUtil.alertRedirect(response, Message.getMessage("msg.common.system.error"));	//시스템에러가 발생하였습니다. 관리자에게 문의하십시오.
		}
		
		
		return	"/bbs/bbsDetailFrame";
	}
	
	
	/**
     * 첨부파일 다운로드(직접입력화면에서 다운로드)
     * @param request
     * @param response
     * @throws Exception
     */
    @RequestMapping("*/board/downloadAttchdFile.do")
    public void downloadAttchdFile(HttpServletRequest request, HttpServletResponse response) throws Exception {
    	frontBoardService.downloadAttchdFile(request, response);
    }
    
    /**
     * 좋아요클릭 증가
     * @param request
     * @param response
     * @throws Exception
     */
    @RequestMapping("*/board/addLike.do")
    public void addLike(HttpServletRequest request, HttpServletResponse response) throws Exception {
        frontBoardService.addLike(request, response);
    }
    
    
}
