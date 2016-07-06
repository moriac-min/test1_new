package foodportal.admin.systemmngt.vo;

import common.commonfacillity.uia.WqBaseBean;

public class AdminBoardVO extends WqBaseBean{
	
	/*******************************************************************************/
	/*********************************공통 부분*************************************/
	/*******************************************************************************/
	private String bbs_no;				//게시판번호
	private String ntctxt_no;			//게시글번호
	private String outpt_type_cd;		//출력_유형_코드
	
	private String del_yn;				//삭제여부
	private String rm;					//비고
	private String cretr_id;			//생성자 아이디
	private String cret_dtm;			//생성일시
	private String last_updtr_id;		//수정자 아이디
	private String last_updt_dtm;		//수정일시
	
	//게시판(TABLE - BBS)
	private String bbs_type_cd;		//게시판_유형_코드
	private String bbs_nm;		//게시판_명
	private String bbs_templet_url;		//게시판_템플릿_URL
	private String ctgry_type_cd;		//카테고리_유형_코드
	private String list_img_use_yn;		//목록_이미지_사용_여부
	private String list_img_link_yn;		//목록_이미지_링크_여부
	private String atch_file_posbl_yn;		//첨부_파일_가능_여부
	private String perm_extnm;		//허용_확장명
	private String mxmm_file_size;		//최대_파일_사이즈
	private String nticmatr_yn;		//공지사항_여부
	private String ans_yn;		//답글_여부
	private String cmt_yn;		//댓글_여부
	private String user_txt_write_yn;		//사용자_글_쓰기_여부
	private String user_txt_del_yn;		//사용자_글_삭제_여부
	private String user_txt_lock_yn;		//사용자_글_잠금_여부
	private String orgnl_view_use_yn;		//원문_보기_사용_여부
	private String inqry_cnd_use_yn;		//조회_조건_사용_여부
	private String kword_use_yn;		//키워드_사용_여부
	private String natn_cd_use_yn;		//국가_코드_사용_여부
	private String tab_use_yn;		//TAB_사용_여부
	private String tab_pdcnt;		//TAB_갯수
	private String tag_use_yn;

	//게시글 마스터
	private String hrnk_ntctxt_no;		//상위게시글번호
	private String hrnk_ctgryno;		//상위카테고리번호
	private String ctgry_no;			//카테고리번호
	private String ctgrynm;				//카테고리경로/명
	private String orgnl_url;			//원문URL
	private String ordtm_ntic_yn;		//상시공지여부
	private String titl;				//제목
	private String inqry_cnt;			//조회건수
	private String tag_info;			//태그정보
	private String file_yn;				//첨부파일여부
	
	//게시글본문
	private String bdt;					//게시글 본문
	
	//게시글별 확장 컬럼(TABLE - NTCTXTACCTO_EXT_CLMN)
	private String natn_cd;		//국가_코드
	private String natn_nm;		//국가명
	private String clmn01;		//컬럼01
	private String clmn02;		//컬럼02
	private String clmn03;		//컬럼03
	private String clmn04;		//컬럼04
	private String clmn05;		//컬럼05
	private String clmn06;		//컬럼06
	private String clmn07;		//컬럼07
	private String clmn08;		//컬럼08
	
	//게시글별 속성(TABLE - NTCTXTACCTO_ATTRB)
	private String front_exps_yn;		//전면_노출_여부 
	private String outpt_wdt;		//출력_너비
	private String outpt_hg;		//출력_높이 
	
	//게시글별 댓글
	private String cmt_no;			//댓글번호
	private String cn;				//내용
	
	//게시글별 첨부파일
	private String atch_file_no;	//첨부파일번호
	private String rprsnt_img_yn;	//대표이미지여부
	private String img_link_url;	//이미지링크URL
	private String file_type_cd;	//파일유형코드
	private String file_path;		//파일경로
	private String logic_file_nm;	//논리파일명
	private String physic_file_nm;	//물리파일명
	private String file_mg;			//파일크기
	
	//검색조건
	private String search_type;				//검색타입       제목|글쓴이
	private String search_keyword;			//검색키워드
	private String cret_start_dtm;			//등록시작일
	private String cret_end_dtm;			//등록종료일
	
	//등록, 수정, 삭제 flag
	private String flag;
	
	/*******************************************************************************/
	/******************************일반형게시판*************************************/
	/*******************************************************************************/
	
	
	
	/*******************************************************************************/
	/******************************뉴스형게시판*************************************/
	/*******************************************************************************/
	
	
	
	/*******************************************************************************/
	/******************************컨텐츠A형****************************************/
	/*******************************************************************************/
	
	
	
	/*******************************************************************************/
	/******************************컨텐츠B형****************************************/
	/*******************************************************************************/
	
	
	
	/*******************************************************************************/
	/******************************포토게시판***************************************/
	/*******************************************************************************/
	
	
	/*******************************************************************************/
	/******************************동영상게시판*************************************/
	/*******************************************************************************/
	
	
	/*******************************************************************************/
	/******************************FAQ**********************************************/
	/*******************************************************************************/
	
	
	
	/*******************************************************************************/
	/******************************약관*********************************************/
	/*******************************************************************************/
	private String use_yn;	//사용여부
	
	
	public String getBbs_no() {
		return bbs_no;
	}
	public void setBbs_no(String bbs_no) {
		this.bbs_no = bbs_no;
	}
	public String getNtctxt_no() {
		return ntctxt_no;
	}
	public void setNtctxt_no(String ntctxt_no) {
		this.ntctxt_no = ntctxt_no;
	}
	public String getOutpt_type_cd() {
		return outpt_type_cd;
	}
	public void setOutpt_type_cd(String outpt_type_cd) {
		this.outpt_type_cd = outpt_type_cd;
	}
	public String getDel_yn() {
		return del_yn;
	}
	public void setDel_yn(String del_yn) {
		this.del_yn = del_yn;
	}
	public String getRm() {
		return rm;
	}
	public void setRm(String rm) {
		this.rm = rm;
	}
	public String getCretr_id() {
		return cretr_id;
	}
	public void setCretr_id(String cretr_id) {
		this.cretr_id = cretr_id;
	}
	public String getCret_dtm() {
		return cret_dtm;
	}
	public void setCret_dtm(String cret_dtm) {
		this.cret_dtm = cret_dtm;
	}
	public String getLast_updtr_id() {
		return last_updtr_id;
	}
	public void setLast_updtr_id(String last_updtr_id) {
		this.last_updtr_id = last_updtr_id;
	}
	public String getLast_updt_dtm() {
		return last_updt_dtm;
	}
	public void setLast_updt_dtm(String last_updt_dtm) {
		this.last_updt_dtm = last_updt_dtm;
	}
	public String getBbs_type_cd() {
		return bbs_type_cd;
	}
	public void setBbs_type_cd(String bbs_type_cd) {
		this.bbs_type_cd = bbs_type_cd;
	}
	public String getBbs_nm() {
		return bbs_nm;
	}
	public void setBbs_nm(String bbs_nm) {
		this.bbs_nm = bbs_nm;
	}
	public String getBbs_templet_url() {
		return bbs_templet_url;
	}
	public void setBbs_templet_url(String bbs_templet_url) {
		this.bbs_templet_url = bbs_templet_url;
	}
	public String getCtgry_type_cd() {
		return ctgry_type_cd;
	}
	public void setCtgry_type_cd(String ctgry_type_cd) {
		this.ctgry_type_cd = ctgry_type_cd;
	}
	public String getList_img_use_yn() {
		return list_img_use_yn;
	}
	public void setList_img_use_yn(String list_img_use_yn) {
		this.list_img_use_yn = list_img_use_yn;
	}
	public String getList_img_link_yn() {
		return list_img_link_yn;
	}
	public void setList_img_link_yn(String list_img_link_yn) {
		this.list_img_link_yn = list_img_link_yn;
	}
	public String getAtch_file_posbl_yn() {
		return atch_file_posbl_yn;
	}
	public void setAtch_file_posbl_yn(String atch_file_posbl_yn) {
		this.atch_file_posbl_yn = atch_file_posbl_yn;
	}
	public String getPerm_extnm() {
		return perm_extnm;
	}
	public void setPerm_extnm(String perm_extnm) {
		this.perm_extnm = perm_extnm;
	}
	public String getMxmm_file_size() {
		return mxmm_file_size;
	}
	public void setMxmm_file_size(String mxmm_file_size) {
		this.mxmm_file_size = mxmm_file_size;
	}
	public String getNticmatr_yn() {
		return nticmatr_yn;
	}
	public void setNticmatr_yn(String nticmatr_yn) {
		this.nticmatr_yn = nticmatr_yn;
	}
	public String getAns_yn() {
		return ans_yn;
	}
	public void setAns_yn(String ans_yn) {
		this.ans_yn = ans_yn;
	}
	public String getCmt_yn() {
		return cmt_yn;
	}
	public void setCmt_yn(String cmt_yn) {
		this.cmt_yn = cmt_yn;
	}
	public String getUser_txt_write_yn() {
		return user_txt_write_yn;
	}
	public void setUser_txt_write_yn(String user_txt_write_yn) {
		this.user_txt_write_yn = user_txt_write_yn;
	}
	public String getUser_txt_del_yn() {
		return user_txt_del_yn;
	}
	public void setUser_txt_del_yn(String user_txt_del_yn) {
		this.user_txt_del_yn = user_txt_del_yn;
	}
	public String getUser_txt_lock_yn() {
		return user_txt_lock_yn;
	}
	public void setUser_txt_lock_yn(String user_txt_lock_yn) {
		this.user_txt_lock_yn = user_txt_lock_yn;
	}
	public String getOrgnl_view_use_yn() {
		return orgnl_view_use_yn;
	}
	public void setOrgnl_view_use_yn(String orgnl_view_use_yn) {
		this.orgnl_view_use_yn = orgnl_view_use_yn;
	}
	public String getInqry_cnd_use_yn() {
		return inqry_cnd_use_yn;
	}
	public void setInqry_cnd_use_yn(String inqry_cnd_use_yn) {
		this.inqry_cnd_use_yn = inqry_cnd_use_yn;
	}
	public String getKword_use_yn() {
		return kword_use_yn;
	}
	public void setKword_use_yn(String kword_use_yn) {
		this.kword_use_yn = kword_use_yn;
	}
	public String getNatn_cd_use_yn() {
		return natn_cd_use_yn;
	}
	public void setNatn_cd_use_yn(String natn_cd_use_yn) {
		this.natn_cd_use_yn = natn_cd_use_yn;
	}
	public String getTab_use_yn() {
		return tab_use_yn;
	}
	public void setTab_use_yn(String tab_use_yn) {
		this.tab_use_yn = tab_use_yn;
	}
	public String getTab_pdcnt() {
		return tab_pdcnt;
	}
	public void setTab_pdcnt(String tab_pdcnt) {
		this.tab_pdcnt = tab_pdcnt;
	}
	public String getTag_use_yn() {
		return tag_use_yn;
	}
	public void setTag_use_yn(String tag_use_yn) {
		this.tag_use_yn = tag_use_yn;
	}
	public String getHrnk_ntctxt_no() {
		return hrnk_ntctxt_no;
	}
	public void setHrnk_ntctxt_no(String hrnk_ntctxt_no) {
		this.hrnk_ntctxt_no = hrnk_ntctxt_no;
	}
	public String getCtgry_no() {
		return ctgry_no;
	}
	public void setCtgry_no(String ctgry_no) {
		this.ctgry_no = ctgry_no;
	}
	public String getOrgnl_url() {
		return orgnl_url;
	}
	public void setOrgnl_url(String orgnl_url) {
		this.orgnl_url = orgnl_url;
	}
	public String getOrdtm_ntic_yn() {
		return ordtm_ntic_yn;
	}
	public void setOrdtm_ntic_yn(String ordtm_ntic_yn) {
		this.ordtm_ntic_yn = ordtm_ntic_yn;
	}
	public String getTitl() {
		return titl;
	}
	public void setTitl(String titl) {
		this.titl = titl;
	}
	public String getInqry_cnt() {
		return inqry_cnt;
	}
	public void setInqry_cnt(String inqry_cnt) {
		this.inqry_cnt = inqry_cnt;
	}
	public String getTag_info() {
		return tag_info;
	}
	public void setTag_info(String tag_info) {
		this.tag_info = tag_info;
	}
	public String getFile_yn() {
		return file_yn;
	}
	public void setFile_yn(String file_yn) {
		this.file_yn = file_yn;
	}
	public String getBdt() {
		return bdt;
	}
	public void setBdt(String bdt) {
		this.bdt = bdt;
	}
	public String getNatn_cd() {
		return natn_cd;
	}
	public void setNatn_cd(String natn_cd) {
		this.natn_cd = natn_cd;
	}
	public String getClmn01() {
		return clmn01;
	}
	public void setClmn01(String clmn01) {
		this.clmn01 = clmn01;
	}
	public String getClmn02() {
		return clmn02;
	}
	public void setClmn02(String clmn02) {
		this.clmn02 = clmn02;
	}
	public String getClmn03() {
		return clmn03;
	}
	public void setClmn03(String clmn03) {
		this.clmn03 = clmn03;
	}
	public String getClmn04() {
		return clmn04;
	}
	public void setClmn04(String clmn04) {
		this.clmn04 = clmn04;
	}
	public String getClmn05() {
		return clmn05;
	}
	public void setClmn05(String clmn05) {
		this.clmn05 = clmn05;
	}
	public String getClmn06() {
		return clmn06;
	}
	public void setClmn06(String clmn06) {
		this.clmn06 = clmn06;
	}
	public String getClmn07() {
		return clmn07;
	}
	public void setClmn07(String clmn07) {
		this.clmn07 = clmn07;
	}
	public String getClmn08() {
		return clmn08;
	}
	public void setClmn08(String clmn08) {
		this.clmn08 = clmn08;
	}
	public String getFront_exps_yn() {
		return front_exps_yn;
	}
	public void setFront_exps_yn(String front_exps_yn) {
		this.front_exps_yn = front_exps_yn;
	}
	public String getOutpt_wdt() {
		return outpt_wdt;
	}
	public void setOutpt_wdt(String outpt_wdt) {
		this.outpt_wdt = outpt_wdt;
	}
	public String getOutpt_hg() {
		return outpt_hg;
	}
	public void setOutpt_hg(String outpt_hg) {
		this.outpt_hg = outpt_hg;
	}
	public String getCret_start_dtm() {
		return cret_start_dtm;
	}
	public void setCret_start_dtm(String cret_start_dtm) {
		this.cret_start_dtm = cret_start_dtm;
	}
	public String getCret_end_dtm() {
		return cret_end_dtm;
	}
	public void setCret_end_dtm(String cret_end_dtm) {
		this.cret_end_dtm = cret_end_dtm;
	}
	public String getSearch_type() {
		return search_type;
	}
	public void setSearch_type(String search_type) {
		this.search_type = search_type;
	}
	public String getSearch_keyword() {
		return search_keyword;
	}
	public void setSearch_keyword(String search_keyword) {
		this.search_keyword = search_keyword;
	}
	public String getUse_yn() {
		return use_yn;
	}
	public void setUse_yn(String use_yn) {
		this.use_yn = use_yn;
	}
	public String getCmt_no() {
		return cmt_no;
	}
	public void setCmt_no(String cmt_no) {
		this.cmt_no = cmt_no;
	}
	public String getCn() {
		return cn;
	}
	public void setCn(String cn) {
		this.cn = cn;
	}
	public String getAtch_file_no() {
		return atch_file_no;
	}
	public void setAtch_file_no(String atch_file_no) {
		this.atch_file_no = atch_file_no;
	}
	public String getRprsnt_img_yn() {
		return rprsnt_img_yn;
	}
	public void setRprsnt_img_yn(String rprsnt_img_yn) {
		this.rprsnt_img_yn = rprsnt_img_yn;
	}
	public String getImg_link_url() {
		return img_link_url;
	}
	public void setImg_link_url(String img_link_url) {
		this.img_link_url = img_link_url;
	}
	public String getFile_type_cd() {
		return file_type_cd;
	}
	public void setFile_type_cd(String file_type_cd) {
		this.file_type_cd = file_type_cd;
	}
	public String getFile_path() {
		return file_path;
	}
	public void setFile_path(String file_path) {
		this.file_path = file_path;
	}
	public String getLogic_file_nm() {
		return logic_file_nm;
	}
	public void setLogic_file_nm(String logic_file_nm) {
		this.logic_file_nm = logic_file_nm;
	}
	public String getPhysic_file_nm() {
		return physic_file_nm;
	}
	public void setPhysic_file_nm(String physic_file_nm) {
		this.physic_file_nm = physic_file_nm;
	}
	public String getFile_mg() {
		return file_mg;
	}
	public void setFile_mg(String file_mg) {
		this.file_mg = file_mg;
	}
	public String getFlag() {
		return flag;
	}
	public void setFlag(String flag) {
		this.flag = flag;
	}
	public String getCtgrynm() {
		return ctgrynm;
	}
	public void setCtgrynm(String ctgrynm) {
		this.ctgrynm = ctgrynm;
	}
	public String getHrnk_ctgryno() {
		return hrnk_ctgryno;
	}
	public void setHrnk_ctgryno(String hrnk_ctgryno) {
		this.hrnk_ctgryno = hrnk_ctgryno;
	}
	public String getNatn_nm() {
		return natn_nm;
	}
	public void setNatn_nm(String natn_nm) {
		this.natn_nm = natn_nm;
	}
	
}