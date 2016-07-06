package foodportal.api.vo;

import common.commonfacillity.uia.WqBaseBean;

public class ApiAplcinfoVO extends WqBaseBean{
	
	private String aplc_no;				//신청번호
	private String mber_no;				//회원번호
	private String name;				//회원명
	private String use_prpos;			//사용용도
	private String use_desc;			//사용설명
	private String crtfchght_no;		//인증키번호
	private String crtfcman;			//인증자
	private String aplc_dt;				//신청일자
	private String new_crtfc_dt;		//신규인증일자
	private String reissu_crtfc_dt;		//재발급인증일자
	private String crtfc_stats_cd;		//인증상태코드
	private String crtfc_stats_cd_nm;	//인증상태명
	
	private String rm;					//비고
	private String cretr_id;			//생성자 아이디
	private String cret_dtm;			//생성일시
	private String last_updtr_id;		//수정자 아이디
	private String last_updt_dtm;		//수정일시
	public String getAplc_no() {
		return aplc_no;
	}
	public void setAplc_no(String aplc_no) {
		this.aplc_no = aplc_no;
	}
	public String getMber_no() {
		return mber_no;
	}
	public void setMber_no(String mber_no) {
		this.mber_no = mber_no;
	}
	
	public String getUse_prpos() {
		return use_prpos;
	}
	public void setUse_prpos(String use_prpos) {
		this.use_prpos = use_prpos;
	}
	public String getUse_desc() {
		return use_desc;
	}
	public void setUse_desc(String use_desc) {
		this.use_desc = use_desc;
	}
	public String getCrtfchght_no() {
		return crtfchght_no;
	}
	public void setCrtfchght_no(String crtfchght_no) {
		this.crtfchght_no = crtfchght_no;
	}
	public String getCrtfcman() {
		return crtfcman;
	}
	public void setCrtfcman(String crtfcman) {
		this.crtfcman = crtfcman;
	}
	public String getAplc_dt() {
		return aplc_dt;
	}
	public void setAplc_dt(String aplc_dt) {
		this.aplc_dt = aplc_dt;
	}
	public String getNew_crtfc_dt() {
		return new_crtfc_dt;
	}
	public void setNew_crtfc_dt(String new_crtfc_dt) {
		this.new_crtfc_dt = new_crtfc_dt;
	}
	public String getReissu_crtfc_dt() {
		return reissu_crtfc_dt;
	}
	public void setReissu_crtfc_dt(String reissu_crtfc_dt) {
		this.reissu_crtfc_dt = reissu_crtfc_dt;
	}
	public String getCrtfc_stats_cd() {
		return crtfc_stats_cd;
	}
	public void setCrtfc_stats_cd(String crtfc_stats_cd) {
		this.crtfc_stats_cd = crtfc_stats_cd;
	}
	public String getCrtfc_stats_cd_nm() {
		return crtfc_stats_cd_nm;
	}
	public void setCrtfc_stats_cd_nm(String crtfc_stats_cd_nm) {
		this.crtfc_stats_cd_nm = crtfc_stats_cd_nm;
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	

	
}