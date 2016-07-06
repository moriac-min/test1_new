package common.adminfacillity.systemmngt.service;

import common.commonfacillity.uia.WqBaseBean;

public class CommonPopupVO extends WqBaseBean{

	private String               sys_cd;
	private String               popup_cd;
	private String               popup_nm;
	private String               work_dvs_cd;
	private String               auto_inqry_yn;
	private String               popup_qury;
	private String               cretr_id;
	private java.sql.Date        cret_dtm;
	private String               last_updtr_id;
	private java.sql.Date        last_updt_dtm;

	

	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("\n[CommonPopupVO Content : ");
		sb.append("\n	sys_cd                           : [").append(sys_cd).append("]");
		sb.append("\n	popup_cd                         : [").append(popup_cd).append("]");
		sb.append("\n	popup_nm                         : [").append(popup_nm).append("]");
		sb.append("\n	work_dvs_cd                      : [").append(work_dvs_cd).append("]");
		sb.append("\n	auto_inqry_yn                    : [").append(auto_inqry_yn).append("]");
		sb.append("\n	popup_qury                       : [").append(popup_qury).append("]");
		sb.append("\n	cretr_id                         : [").append(cretr_id).append("]");
		sb.append("\n	cret_dtm                         : [").append(cret_dtm).append("]");
		sb.append("\n	last_updtr_id                    : [").append(last_updtr_id).append("]");
		sb.append("\n	last_updt_dtm                    : [").append(last_updt_dtm).append("]");
		return sb.toString();
	}



	public String getSys_cd() {
		return sys_cd;
	}



	public void setSys_cd(String sys_cd) {
		this.sys_cd = sys_cd;
	}



	public String getPopup_cd() {
		return popup_cd;
	}



	public void setPopup_cd(String popup_cd) {
		this.popup_cd = popup_cd;
	}



	public String getPopup_nm() {
		return popup_nm;
	}



	public void setPopup_nm(String popup_nm) {
		this.popup_nm = popup_nm;
	}



	public String getWork_dvs_cd() {
		return work_dvs_cd;
	}



	public void setWork_dvs_cd(String work_dvs_cd) {
		this.work_dvs_cd = work_dvs_cd;
	}



	public String getAuto_inqry_yn() {
		return auto_inqry_yn;
	}



	public void setAuto_inqry_yn(String auto_inqry_yn) {
		this.auto_inqry_yn = auto_inqry_yn;
	}



	public String getPopup_qury() {
		return popup_qury;
	}



	public void setPopup_qury(String popup_qury) {
		this.popup_qury = popup_qury;
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
}