package common.adminfacillity.systemmngt.service;
public class CommonComboVO {

	private String               sys_cd;
	private String               cmb_cd;
	private String               cmb_nm;
	private String               work_dvs_cd;
	private String               cmb_qury;
	private String               cretr_id;
	private java.sql.Date        cret_dtm;
	private String               last_updtr_id;
	private java.sql.Date        last_updt_dtm;

	public void setsys_cd(String sys_cd) {
		this.sys_cd = sys_cd;
	}
	public String getsys_cd() {
		return this.sys_cd;
	}

	public void setcmb_cd(String cmb_cd) {
		this.cmb_cd = cmb_cd;
	}
	public String getcmb_cd() {
		return this.cmb_cd;
	}

	public void setcmb_nm(String cmb_nm) {
		this.cmb_nm = cmb_nm;
	}
	public String getcmb_nm() {
		return this.cmb_nm;
	}

	public void setwork_dvs_cd(String work_dvs_cd) {
		this.work_dvs_cd = work_dvs_cd;
	}
	public String getwork_dvs_cd() {
		return this.work_dvs_cd;
	}

	public void setcmb_qury(String cmb_qury) {
		this.cmb_qury = cmb_qury;
	}
	public String getcmb_qury() {
		return this.cmb_qury;
	}

	public void setcretr_id(String cretr_id) {
		this.cretr_id = cretr_id;
	}
	public String getcretr_id() {
		return this.cretr_id;
	}

	public void setcret_dtm(java.sql.Date cret_dtm) {
		this.cret_dtm = cret_dtm;
	}
	public java.sql.Date getcret_dtm() {
		return this.cret_dtm;
	}

	public void setlast_updtr_id(String last_updtr_id) {
		this.last_updtr_id = last_updtr_id;
	}
	public String getlast_updtr_id() {
		return this.last_updtr_id;
	}

	public void setlast_updt_dtm(java.sql.Date last_updt_dtm) {
		this.last_updt_dtm = last_updt_dtm;
	}
	public java.sql.Date getlast_updt_dtm() {
		return this.last_updt_dtm;
	}

	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("\n[CommonComboVO Content : ");
		sb.append("\n	sys_cd                           : [").append(sys_cd).append("]");
		sb.append("\n	cmb_cd                           : [").append(cmb_cd).append("]");
		sb.append("\n	cmb_nm                           : [").append(cmb_nm).append("]");
		sb.append("\n	work_dvs_cd                      : [").append(work_dvs_cd).append("]");
		sb.append("\n	cmb_qury                         : [").append(cmb_qury).append("]");
		sb.append("\n	cretr_id                         : [").append(cretr_id).append("]");
		sb.append("\n	cret_dtm                         : [").append(cret_dtm).append("]");
		sb.append("\n	last_updtr_id                    : [").append(last_updtr_id).append("]");
		sb.append("\n	last_updt_dtm                    : [").append(last_updt_dtm).append("]");
		return sb.toString();
	}
}