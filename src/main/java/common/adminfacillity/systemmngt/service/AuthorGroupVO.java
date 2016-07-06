package common.adminfacillity.systemmngt.service;

import org.apache.commons.lang.builder.ToStringBuilder;

import common.commonfacillity.uia.WqBaseBean;

public class AuthorGroupVO extends WqBaseBean {

	private String chk;
	private String athr_grp_cd;
	private String athr_grp_nm;
	private String rm_100;
	private String use_yn;
	private java.math.BigDecimal sort_ord;
	private String cretr_id;
	private java.sql.Date cret_dtm;
	private String last_updtr_id;
	private java.sql.Date last_updt_dtm;
	
	public String getChk() {
		return chk;
	}
	public void setChk(String chk) {
		this.chk = chk;
	}
	public String getAthr_grp_cd() {
		return athr_grp_cd;
	}
	public void setAthr_grp_cd(String athr_grp_cd) {
		this.athr_grp_cd = athr_grp_cd;
	}
	public String getAthr_grp_nm() {
		return athr_grp_nm;
	}
	public void setAthr_grp_nm(String athr_grp_nm) {
		this.athr_grp_nm = athr_grp_nm;
	}
	public String getRm_100() {
		return rm_100;
	}
	public void setRm_100(String rm_100) {
		this.rm_100 = rm_100;
	}
	public String getUse_yn() {
		return use_yn;
	}
	public void setUse_yn(String use_yn) {
		this.use_yn = use_yn;
	}
	public java.math.BigDecimal getSort_ord() {
		return sort_ord;
	}
	public void setSort_ord(java.math.BigDecimal sort_ord) {
		this.sort_ord = sort_ord;
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
	
	public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
	
}