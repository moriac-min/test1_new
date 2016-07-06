package foodportal.admin.systemmngt.vo;

import common.commonfacillity.uia.WqBaseBean;

public class BannerVO extends WqBaseBean{

	private String bbs_no;				//게시판_번호
	private String ntctxt_no;			//게시글_번호
	private String titl;					//제목
	private java.sql.Date cret_dtm;	//등록일
	private String bdt;					//설명
	private String clmn01;				//순서
	private String clmn02;				//URL
	private String clmn03;				//새창(Y/N)
	private String clmn04;				//팝업(Y/N)
	private String outpt_type_cd;	//N(새창), S(현재창), P(팝업)
	private String outpt_wdt;			//너비
	private String outpt_hg;			//높이
	private String del_yn;				//삭제여부
	private String cretr_id;				//작성자
	private String last_updtr_id;		//수정자
	private String atch_file_no;		//첨부_파일_번호
	private String file_type_cd;		//파일_유형_코드
	private String file_path;			//파일_경로
	private String logic_file_nm;		//논리_파일_명
	private String physic_file_nm;	//물리_파일_명
	private String file_mg;				//파일_크기
	private String file_yn;				//파일첨부 여부
	
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
	public String getTitl() {
		return titl;
	}
	public void setTitl(String titl) {
		this.titl = titl;
	}
	public java.sql.Date getCret_dtm() {
		return cret_dtm;
	}
	public void setCret_dtm(java.sql.Date cret_dtm) {
		this.cret_dtm = cret_dtm;
	}
	public String getBdt() {
		return bdt;
	}
	public void setBdt(String bdt) {
		this.bdt = bdt;
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
	public String getOutpt_type_cd() {
		return outpt_type_cd;
	}
	public void setOutpt_type_cd(String outpt_type_cd) {
		this.outpt_type_cd = outpt_type_cd;
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
	public String getDel_yn() {
		return del_yn;
	}
	public void setDel_yn(String del_yn) {
		this.del_yn = del_yn;
	}
	public String getCretr_id() {
		return cretr_id;
	}
	public void setCretr_id(String cretr_id) {
		this.cretr_id = cretr_id;
	}
	public String getLast_updtr_id() {
		return last_updtr_id;
	}
	public void setLast_updtr_id(String last_updtr_id) {
		this.last_updtr_id = last_updtr_id;
	}
	public String getAtch_file_no() {
		return atch_file_no;
	}
	public void setAtch_file_no(String atch_file_no) {
		this.atch_file_no = atch_file_no;
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
	public String getFile_yn() {
		return file_yn;
	}
	public void setFile_yn(String file_yn) {
		this.file_yn = file_yn;
	}
	
}

