package common.adminfacillity.systemmngt.service;

import common.commonfacillity.uia.WqBaseBean;

public class UserVO extends WqBaseBean{

	private String               user_id;
	private String               user_nm;
	private String               pswd;
	private String               user_dvs_cd;
	private String               eltrdcdn_id;
	private String               eltrdcdn_dept_cd;
	private String               instt_cd;
	private String               onnr_dept_cd;
	private String               ptcs_nm;
	private String               pstofc_nm;
	private java.math.BigDecimal dept_inner_lv;
	private java.math.BigDecimal pstofc_inner_lv;
	private String               rsrno;
	private String               brthdy;
	private String               tel_no;
	private String               mbtpn_no;
	private String               email;
	private String               mssg_recv_yn;
	private String               gpki_reg_info;
	private String               all_athr_yn;
	private String               athr_yn;
	private java.sql.Date        pswd_last_chng_dtm;
	private String               use_end_dt;
	private String               rm_3000;
	private String               cretr_id;
	private java.sql.Date        cret_dtm;
	private String               last_updtr_id;
	private java.sql.Date        last_updt_dtm;
	private java.sql.Date        last_login_dtm;
	private String               last_login_ip;
	private java.sql.Date        last_logout_dtm;
	private java.math.BigDecimal login_failr_tmno;
	private String               login_failr_lock_yn;
	private java.sql.Date        last_login_failr_dtm;

	

	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("\n[UserVO Content : ");
		sb.append("\n	user_id                          : [").append(user_id).append("]");
		sb.append("\n	user_nm                          : [").append(user_nm).append("]");
		sb.append("\n	pswd                             : [").append(pswd).append("]");
		sb.append("\n	user_dvs_cd                      : [").append(user_dvs_cd).append("]");
		sb.append("\n	eltrdcdn_id                      : [").append(eltrdcdn_id).append("]");
		sb.append("\n	eltrdcdn_dept_cd                 : [").append(eltrdcdn_dept_cd).append("]");
		sb.append("\n	instt_cd                         : [").append(instt_cd).append("]");
		sb.append("\n	onnr_dept_cd                     : [").append(onnr_dept_cd).append("]");
		sb.append("\n	ptcs_nm                          : [").append(ptcs_nm).append("]");
		sb.append("\n	pstofc_nm                        : [").append(pstofc_nm).append("]");
		sb.append("\n	dept_inner_lv                    : [").append(dept_inner_lv).append("]");
		sb.append("\n	pstofc_inner_lv                  : [").append(pstofc_inner_lv).append("]");
		sb.append("\n	rsrno                            : [").append(rsrno).append("]");
		sb.append("\n	brthdy                           : [").append(brthdy).append("]");
		sb.append("\n	tel_no                           : [").append(tel_no).append("]");
		sb.append("\n	mbtpn_no                         : [").append(mbtpn_no).append("]");
		sb.append("\n	email                            : [").append(email).append("]");
		sb.append("\n	mssg_recv_yn                     : [").append(mssg_recv_yn).append("]");
		sb.append("\n	gpki_reg_info                    : [").append(gpki_reg_info).append("]");
		sb.append("\n	all_athr_yn                      : [").append(all_athr_yn).append("]");
		sb.append("\n	athr_yn                          : [").append(athr_yn).append("]");
		sb.append("\n	pswd_last_chng_dtm               : [").append(pswd_last_chng_dtm).append("]");
		sb.append("\n	use_end_dt                       : [").append(use_end_dt).append("]");
		sb.append("\n	rm_3000                          : [").append(rm_3000).append("]");
		sb.append("\n	cretr_id                         : [").append(cretr_id).append("]");
		sb.append("\n	cret_dtm                         : [").append(cret_dtm).append("]");
		sb.append("\n	last_updtr_id                    : [").append(last_updtr_id).append("]");
		sb.append("\n	last_updt_dtm                    : [").append(last_updt_dtm).append("]");
		sb.append("\n	last_login_dtm                   : [").append(last_login_dtm).append("]");
		sb.append("\n	last_login_ip                    : [").append(last_login_ip).append("]");
		sb.append("\n	last_logout_dtm                  : [").append(last_logout_dtm).append("]");
		sb.append("\n	login_failr_tmno                 : [").append(login_failr_tmno).append("]");
		sb.append("\n	login_failr_lock_yn              : [").append(login_failr_lock_yn).append("]");
		sb.append("\n	last_login_failr_dtm             : [").append(last_login_failr_dtm).append("]");
		return sb.toString();
	}



	public String getUser_id() {
		return user_id;
	}



	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}



	public String getUser_nm() {
		return user_nm;
	}



	public void setUser_nm(String user_nm) {
		this.user_nm = user_nm;
	}



	public String getPswd() {
		return pswd;
	}



	public void setPswd(String pswd) {
		this.pswd = pswd;
	}



	public String getUser_dvs_cd() {
		return user_dvs_cd;
	}



	public void setUser_dvs_cd(String user_dvs_cd) {
		this.user_dvs_cd = user_dvs_cd;
	}



	public String getEltrdcdn_id() {
		return eltrdcdn_id;
	}



	public void setEltrdcdn_id(String eltrdcdn_id) {
		this.eltrdcdn_id = eltrdcdn_id;
	}



	public String getEltrdcdn_dept_cd() {
		return eltrdcdn_dept_cd;
	}



	public void setEltrdcdn_dept_cd(String eltrdcdn_dept_cd) {
		this.eltrdcdn_dept_cd = eltrdcdn_dept_cd;
	}



	public String getInstt_cd() {
		return instt_cd;
	}



	public void setInstt_cd(String instt_cd) {
		this.instt_cd = instt_cd;
	}



	public String getOnnr_dept_cd() {
		return onnr_dept_cd;
	}



	public void setOnnr_dept_cd(String onnr_dept_cd) {
		this.onnr_dept_cd = onnr_dept_cd;
	}



	public String getPtcs_nm() {
		return ptcs_nm;
	}



	public void setPtcs_nm(String ptcs_nm) {
		this.ptcs_nm = ptcs_nm;
	}



	public String getPstofc_nm() {
		return pstofc_nm;
	}



	public void setPstofc_nm(String pstofc_nm) {
		this.pstofc_nm = pstofc_nm;
	}



	public java.math.BigDecimal getDept_inner_lv() {
		return dept_inner_lv;
	}



	public void setDept_inner_lv(java.math.BigDecimal dept_inner_lv) {
		this.dept_inner_lv = dept_inner_lv;
	}



	public java.math.BigDecimal getPstofc_inner_lv() {
		return pstofc_inner_lv;
	}



	public void setPstofc_inner_lv(java.math.BigDecimal pstofc_inner_lv) {
		this.pstofc_inner_lv = pstofc_inner_lv;
	}



	public String getRsrno() {
		return rsrno;
	}



	public void setRsrno(String rsrno) {
		this.rsrno = rsrno;
	}



	public String getBrthdy() {
		return brthdy;
	}



	public void setBrthdy(String brthdy) {
		this.brthdy = brthdy;
	}



	public String getTel_no() {
		return tel_no;
	}



	public void setTel_no(String tel_no) {
		this.tel_no = tel_no;
	}



	public String getMbtpn_no() {
		return mbtpn_no;
	}



	public void setMbtpn_no(String mbtpn_no) {
		this.mbtpn_no = mbtpn_no;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public String getMssg_recv_yn() {
		return mssg_recv_yn;
	}



	public void setMssg_recv_yn(String mssg_recv_yn) {
		this.mssg_recv_yn = mssg_recv_yn;
	}



	public String getGpki_reg_info() {
		return gpki_reg_info;
	}



	public void setGpki_reg_info(String gpki_reg_info) {
		this.gpki_reg_info = gpki_reg_info;
	}



	public String getAll_athr_yn() {
		return all_athr_yn;
	}



	public void setAll_athr_yn(String all_athr_yn) {
		this.all_athr_yn = all_athr_yn;
	}



	public String getAthr_yn() {
		return athr_yn;
	}



	public void setAthr_yn(String athr_yn) {
		this.athr_yn = athr_yn;
	}



	public java.sql.Date getPswd_last_chng_dtm() {
		return pswd_last_chng_dtm;
	}



	public void setPswd_last_chng_dtm(java.sql.Date pswd_last_chng_dtm) {
		this.pswd_last_chng_dtm = pswd_last_chng_dtm;
	}



	public String getUse_end_dt() {
		return use_end_dt;
	}



	public void setUse_end_dt(String use_end_dt) {
		this.use_end_dt = use_end_dt;
	}



	public String getRm_3000() {
		return rm_3000;
	}



	public void setRm_3000(String rm_3000) {
		this.rm_3000 = rm_3000;
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



	public java.sql.Date getLast_login_dtm() {
		return last_login_dtm;
	}



	public void setLast_login_dtm(java.sql.Date last_login_dtm) {
		this.last_login_dtm = last_login_dtm;
	}



	public String getLast_login_ip() {
		return last_login_ip;
	}



	public void setLast_login_ip(String last_login_ip) {
		this.last_login_ip = last_login_ip;
	}



	public java.sql.Date getLast_logout_dtm() {
		return last_logout_dtm;
	}



	public void setLast_logout_dtm(java.sql.Date last_logout_dtm) {
		this.last_logout_dtm = last_logout_dtm;
	}



	public java.math.BigDecimal getLogin_failr_tmno() {
		return login_failr_tmno;
	}



	public void setLogin_failr_tmno(java.math.BigDecimal login_failr_tmno) {
		this.login_failr_tmno = login_failr_tmno;
	}



	public String getLogin_failr_lock_yn() {
		return login_failr_lock_yn;
	}



	public void setLogin_failr_lock_yn(String login_failr_lock_yn) {
		this.login_failr_lock_yn = login_failr_lock_yn;
	}



	public java.sql.Date getLast_login_failr_dtm() {
		return last_login_failr_dtm;
	}



	public void setLast_login_failr_dtm(java.sql.Date last_login_failr_dtm) {
		this.last_login_failr_dtm = last_login_failr_dtm;
	}
}