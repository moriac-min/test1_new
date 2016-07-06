package common.adminfacillity.systemmngt.service;

import org.apache.commons.lang.builder.ToStringBuilder;

import common.commonfacillity.uia.WqBaseBean;

public class OrganizationAuthorGroupVO extends WqBaseBean {

	private String				 chk;
	private String               instt_cd;
	private String               athr_grp_cd;
	private String               athr_grp_nm;
	private String               cretr_id;
	private java.sql.Date        cret_dtm;
	private String               last_updtr_id;
	private java.sql.Date        last_updt_dtm;
	private String               sys_cd;
	
	public String getChk() {
		return chk;
	}
	public void setChk(String chk) {
		this.chk = chk;
	}
	public String getInstt_cd() {
		return instt_cd;
	}
	public void setInstt_cd(String instt_cd) {
		this.instt_cd = instt_cd;
	}
	public String getAthr_grp_cd() {
		return athr_grp_cd;
	}
	public void setAthr_grp_cd(String athr_grp_cd) {
		this.athr_grp_cd = athr_grp_cd;
	}
	public String getCretr_id() {
		return cretr_id;
	}
	public String getAthr_grp_nm() {
		return athr_grp_nm;
	}
	public void setAthr_grp_nm(String athr_grp_nm) {
		this.athr_grp_nm = athr_grp_nm;
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
	public String getSys_cd() {
		return sys_cd;
	}
	public void setSys_cd(String sys_cd) {
		this.sys_cd = sys_cd;
	}

	public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
	
	
}