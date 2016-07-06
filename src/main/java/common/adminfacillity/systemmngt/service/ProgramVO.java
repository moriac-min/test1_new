package common.adminfacillity.systemmngt.service;

import common.commonfacillity.uia.WqBaseBean;

public class ProgramVO extends WqBaseBean{
	
	private String chk;
	private String sys_cd;
	private String prgr_cd;
	private String prgr_nm;
	private String file_nm;
	private String file_path;
	private String use_yn;
	private String cretr_id;
	private java.sql.Date cret_dtm;
	private String last_updt_id;
	private java.sql.Date last_updt_dtm;
	
	public String getSys_cd() {
		return sys_cd;
	}


	public void setSys_cd(String sys_cd) {
		this.sys_cd = sys_cd;
	}


	public String getPrgr_cd() {
		return prgr_cd;
	}


	public void setPrgr_cd(String prgr_cd) {
		this.prgr_cd = prgr_cd;
	}


	public String getPrgr_nm() {
		return prgr_nm;
	}


	public void setPrgr_nm(String prgr_nm) {
		this.prgr_nm = prgr_nm;
	}


	public String getFile_nm() {
		return file_nm;
	}


	public void setFile_nm(String file_nm) {
		this.file_nm = file_nm;
	}


	public String getFile_path() {
		return file_path;
	}


	public void setFile_path(String file_path) {
		this.file_path = file_path;
	}


	public String getUse_yn() {
		return use_yn;
	}


	public void setUse_yn(String use_yn) {
		this.use_yn = use_yn;
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


	public String getLast_updt_id() {
		return last_updt_id;
	}


	public void setLast_updt_id(String last_updt_id) {
		this.last_updt_id = last_updt_id;
	}


	public java.sql.Date getLast_updt_dtm() {
		return last_updt_dtm;
	}


	public void setLast_updt_dtm(java.sql.Date last_updt_dtm) {
		this.last_updt_dtm = last_updt_dtm;
	}


	public String getChk() {
		return chk;
	}


	public void setChk(String chk) {
		this.chk = chk;
	}

}