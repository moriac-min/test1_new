package foodportal.admin.systemmngt.vo;

import java.util.List;

import common.commonfacillity.uia.WqBaseBean;

public class MetaKeyPopupVO extends WqBaseBean{

	private String				chk;
	private String				bbs_no;
	private String				ntctxt_no;
	private String				type_cd;
	private String				cd;
	private String				cd_nm;
	private String				meta_dvs;
	
	private String              cretr_id;
	private java.sql.Date       cret_dtm;
	private String              last_updtr_id;
	private java.sql.Date       last_updt_dtm;
	
	//검색조건		
	private String search_keyword;

	public String getChk() {
		return chk;
	}

	public void setChk(String chk) {
		this.chk = chk;
	}

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
	
	public String getType_cd() {
		return type_cd;
	}

	public void setType_cd(String type_cd) {
		this.type_cd = type_cd;
	}

	public String getCd() {
		return cd;
	}

	public void setCd(String cd) {
		this.cd = cd;
	}

	public String getCd_nm() {
		return cd_nm;
	}

	public void setCd_nm(String cd_nm) {
		this.cd_nm = cd_nm;
	}

	public String getMeta_dvs() {
		return meta_dvs;
	}

	public void setMeta_dvs(String meta_dvs) {
		this.meta_dvs = meta_dvs;
	}

	public String getCretr_id() {
		return cretr_id;
	}

	public void setCretr_id(String cretr_id) {
		this.cretr_id = cretr_id;
	}

	public java.sql.Date getCret_dtm() {
		return cret_dtm;
	}

	public void setCret_dtm(java.sql.Date cret_dtm) {
		this.cret_dtm = cret_dtm;
	}

	public String getLast_updtr_id() {
		return last_updtr_id;
	}

	public void setLast_updtr_id(String last_updtr_id) {
		this.last_updtr_id = last_updtr_id;
	}

	public java.sql.Date getLast_updt_dtm() {
		return last_updt_dtm;
	}

	public void setLast_updt_dtm(java.sql.Date last_updt_dtm) {
		this.last_updt_dtm = last_updt_dtm;
	}

	public String getSearch_keyword() {
		return search_keyword;
	}

	public void setSearch_keyword(String search_keyword) {
		this.search_keyword = search_keyword;
	}		
	

	
}