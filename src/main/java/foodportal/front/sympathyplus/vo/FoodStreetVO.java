package foodportal.front.sympathyplus.vo;

public class FoodStreetVO{
	
	private String sys_dvs_cd;			//사이트구분
	private String menu_no;				//메뉴번호
	private String menu_nm;				//메뉴명
	
	private String bbs_no;				//게시판번호
	private String ntctxt_no;			//게시글번호
	private String pre_ntctxt_no;		//이전게시글번호
	private String post_ntctxt_no;		//다음게시글번호
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
	private String bbs_templet_nm;		//게시판 템플릿유형
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
	private String ctgrynm;				//카테고리명
	private String orgnl_url;			//원문URL
	private String ordtm_ntic_yn;		//상시공지여부
	private String titl;				//제목
	private String inqry_cnt;			//조회건수
	private String tag_info;			//태그정보
	private String file_yn;				//첨부파일여부
	private String no;
	private String total_cnt;			//총개시글개수
	private String start_idx;			//페이징 시작번호
	private String show_cnt;			//보여줄 개수
	
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
	
	//검색조건
	private String search_type;				//검색타입       제목|글쓴이
	private String search_keyword;			//검색키워드
	private String cret_start_dtm;			//등록시작일
	private String cret_end_dtm;			//등록종료일
	
	//추천수
	private String rtrvl_cnt;
	
	//등록, 수정, 삭제 flag
	private String flag;

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

	public String getHrnk_ctgryno() {
		return hrnk_ctgryno;
	}

	public void setHrnk_ctgryno(String hrnk_ctgryno) {
		this.hrnk_ctgryno = hrnk_ctgryno;
	}

	public String getCtgry_no() {
		return ctgry_no;
	}

	public void setCtgry_no(String ctgry_no) {
		this.ctgry_no = ctgry_no;
	}

	public String getCtgrynm() {
		return ctgrynm;
	}

	public void setCtgrynm(String ctgrynm) {
		this.ctgrynm = ctgrynm;
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

	public String getNatn_nm() {
		return natn_nm;
	}

	public void setNatn_nm(String natn_nm) {
		this.natn_nm = natn_nm;
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

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	public String getSys_dvs_cd() {
		return sys_dvs_cd;
	}

	public void setSys_dvs_cd(String sys_dvs_cd) {
		this.sys_dvs_cd = sys_dvs_cd;
	}

	public String getMenu_no() {
		return menu_no;
	}

	public void setMenu_no(String menu_no) {
		this.menu_no = menu_no;
	}

	public String getTotal_cnt() {
		return total_cnt;
	}

	public void setTotal_cnt(String total_cnt) {
		this.total_cnt = total_cnt;
	}

	public String getStart_idx() {
		return start_idx;
	}

	public void setStart_idx(String start_idx) {
		this.start_idx = start_idx;
	}

	public String getShow_cnt() {
		return show_cnt;
	}

	public void setShow_cnt(String show_cnt) {
		this.show_cnt = show_cnt;
	}

	public String getMenu_nm() {
		return menu_nm;
	}

	public void setMenu_nm(String menu_nm) {
		this.menu_nm = menu_nm;
	}

	public String getNo() {
		return no;
	}

	public void setNo(String no) {
		this.no = no;
	}

	public String getPre_ntctxt_no() {
		return pre_ntctxt_no;
	}

	public void setPre_ntctxt_no(String pre_ntctxt_no) {
		this.pre_ntctxt_no = pre_ntctxt_no;
	}

	public String getPost_ntctxt_no() {
		return post_ntctxt_no;
	}

	public void setPost_ntctxt_no(String post_ntctxt_no) {
		this.post_ntctxt_no = post_ntctxt_no;
	}

	public String getRtrvl_cnt() {
		return rtrvl_cnt;
	}

	public void setRtrvl_cnt(String rtrvl_cnt) {
		this.rtrvl_cnt = rtrvl_cnt;
	}

	public String getBbs_templet_nm() {
		return bbs_templet_nm;
	}

	public void setBbs_templet_nm(String bbs_templet_nm) {
		this.bbs_templet_nm = bbs_templet_nm;
	}
	
}