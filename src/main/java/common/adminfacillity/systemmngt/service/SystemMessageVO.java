package common.adminfacillity.systemmngt.service;

import org.apache.commons.lang.builder.ToStringBuilder;

import common.commonfacillity.uia.WqBaseBean;

public class SystemMessageVO extends WqBaseBean {

	private String chk;
	private String sys_cd;
	private String mssg_cd;
	private String mssg_cn;
	private String cretr_id;
	private java.sql.Date cret_dtm;
	private String last_updtr_id;
	private java.sql.Date last_updt_dtm;
	public String getSys_cd() {
		return sys_cd;
	}
	public void setSys_cd(String sys_cd) {
		this.sys_cd = sys_cd;
	}
	public String getMssg_cd() {
		return mssg_cd;
	}
	public void setMssg_cd(String mssg_cd) {
		this.mssg_cd = mssg_cd;
	}
	public String getMssg_cn() {
		return mssg_cn;
	}
	public void setMssg_cn(String mssg_cn) {
		this.mssg_cn = mssg_cn;
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
	public String getChk() {
		return chk;
	}
	public void setChk(String chk) {
		this.chk = chk;
	}
}