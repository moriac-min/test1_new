package foodportal.admin.systemmngt.vo;

import java.sql.Date;

import org.apache.commons.lang.builder.ToStringBuilder;

import common.commonfacillity.uia.WqBaseBean;

public class UserAuthVO extends WqBaseBean{
	private String		user_id;
	private String		athr_no;
	private String		cretr_id;
	private Date		cret_dtm;
	private String		last_updtr_id;
	private Date		last_updt_dtm;
	
	private String		athr_kor_nm;
	private String		athr_eng_nm;
	
	public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getAthr_no() {
		return athr_no;
	}

	public void setAthr_no(String athr_no) {
		this.athr_no = athr_no;
	}

	public String getCretr_id() {
		return cretr_id;
	}

	public void setCretr_id(String cretr_id) {
		this.cretr_id = cretr_id;
	}

	public Date getCret_dtm() {
		return cret_dtm;
	}

	public void setCret_dtm(Date cret_dtm) {
		this.cret_dtm = cret_dtm;
	}

	public String getLast_updtr_id() {
		return last_updtr_id;
	}

	public void setLast_updtr_id(String last_updtr_id) {
		this.last_updtr_id = last_updtr_id;
	}

	public Date getLast_updt_dtm() {
		return last_updt_dtm;
	}

	public void setLast_updt_dtm(Date last_updt_dtm) {
		this.last_updt_dtm = last_updt_dtm;
	}

	public String getAthr_kor_nm() {
		return athr_kor_nm;
	}

	public void setAthr_kor_nm(String athr_kor_nm) {
		this.athr_kor_nm = athr_kor_nm;
	}

	public String getAthr_eng_nm() {
		return athr_eng_nm;
	}

	public void setAthr_eng_nm(String athr_eng_nm) {
		this.athr_eng_nm = athr_eng_nm;
	}
	
}