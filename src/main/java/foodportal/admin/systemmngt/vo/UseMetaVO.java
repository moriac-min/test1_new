package foodportal.admin.systemmngt.vo;

import java.util.List;

import common.commonfacillity.uia.WqBaseBean;

public class UseMetaVO extends WqBaseBean{

	private String				bbs_no;
	private String				meta_type_cd;
	private String				meta_type_cd_nm;
	
	private String              cretr_id;
	private java.sql.Date       cret_dtm;
	private String              last_updtr_id;
	private java.sql.Date       last_updt_dtm;
	private String				meta_dvs;
	
	public String getBbs_no() {
		return bbs_no;
	}
	public void setBbs_no(String bbs_no) {
		this.bbs_no = bbs_no;
	}
	public String getMeta_type_cd() {
		return meta_type_cd;
	}
	public void setMeta_type_cd(String meta_type_cd) {
		this.meta_type_cd = meta_type_cd;
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
	public String getMeta_type_cd_nm() {
		return meta_type_cd_nm;
	}
	public void setMeta_type_cd_nm(String meta_type_cd_nm) {
		this.meta_type_cd_nm = meta_type_cd_nm;
	}
	public String getMeta_dvs() {
		return meta_dvs;
	}
	public void setMeta_dvs(String meta_dvs) {
		this.meta_dvs = meta_dvs;
	}
	
	
}