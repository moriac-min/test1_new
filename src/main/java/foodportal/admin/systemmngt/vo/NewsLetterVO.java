package foodportal.admin.systemmngt.vo;

import common.commonfacillity.uia.WqBaseBean;

public class NewsLetterVO extends WqBaseBean{
	
	/*******************************************************************************/
	/*********************************공통 부분*************************************/
	/*******************************************************************************/
	private String bbs_no;				//게시판번호
	private String ntctxt_no;			//게시글번호
	
	private String del_yn;				//삭제여부
	private String rm;					//비고
	private String cretr_id;			//생성자 아이디
	private String cret_dtm;			//생성일시
	private String last_updtr_id;		//수정자 아이디
	private String last_updt_dtm;		//수정일시
	

	//게시글 마스터
	private String hrnk_ntctxt_no;		//상위게시글번호
	private String ctgry_no;			//카테고리번호
	private String orgnl_url;			//원문URL
	private String ordtm_ntic_yn;		//상시공지여부
	private String titl;				//제목
	private String inqry_cnt;			//조회건수
	private String tag_info;			//태그정보
	private String file_yn;				//첨부파일여부
	
	//게시글본문
	private String bdt;					//게시글 본문
	
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
	
	
}