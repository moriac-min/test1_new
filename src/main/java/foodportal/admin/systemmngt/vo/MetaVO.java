package foodportal.admin.systemmngt.vo;

import java.util.List;

import common.commonfacillity.uia.WqBaseBean;

public class MetaVO extends WqBaseBean{

	private String				cmmn_cd;
	private String				cd_nm;
	private String				use_yn;
	private String				use_yn_data;
	private String				meta_dvs;
	
	private String              cretr_id;
	private java.sql.Date       cret_dtm;
	private String              last_updtr_id;
	private java.sql.Date       last_updt_dtm;
	public String getCmmn_cd() {
		return cmmn_cd;
	}
	public void setCmmn_cd(String cmmn_cd) {
		this.cmmn_cd = cmmn_cd;
	}
	public String getCd_nm() {
		return cd_nm;
	}
	public void setCd_nm(String cd_nm) {
		this.cd_nm = cd_nm;
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
	public String getUse_yn() {
		return use_yn;
	}
	public void setUse_yn(String use_yn) {
		this.use_yn = use_yn;
	}
	public String getUse_yn_data() {
		return use_yn_data;
	}
	public void setUse_yn_data(String use_yn_data) {
		this.use_yn_data = use_yn_data;
	}
	public String getMeta_dvs() {
		return meta_dvs;
	}
	public void setMeta_dvs(String meta_dvs) {
		this.meta_dvs = meta_dvs;
	}
	
	
	
}