package common.adminfacillity.systemmngt.service;
public class SystemAccessLogVO {

	/** 공통변수 선언 */
	/** 최초입력자 */
	private String cretr_id  = "";
	
	/** 최종수정자 */
	private String last_updtr_id = "";
	
	public String getCretr_id() {
		return cretr_id;
	}
	
	public void setCretr_id(String cretr_id) {
		this.cretr_id = cretr_id;
	}
	
	public String getLast_updtr_id() {
		return last_updtr_id;
	}
	
	public void setLast_updtr_id(String last_updtr_id) {
		this.last_updtr_id = last_updtr_id;
	}
	
	private String               sys_cd;
	private String               user_id;
	private java.sql.Date        use_dtm;
	private String               user_ip;
	private String               svc_nm;
	private String               fnct_nm;
	private String               rqst_prmtr;
	private java.math.BigDecimal prcs_tm;
	private String               rm_500;

	public void setsys_cd(String sys_cd) {
		this.sys_cd = sys_cd;
	}
	public String getsys_cd() {
		return this.sys_cd;
	}

	public void setuser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getuser_id() {
		return this.user_id;
	}

	public void setuse_dtm(java.sql.Date use_dtm) {
		this.use_dtm = use_dtm;
	}
	public java.sql.Date getuse_dtm() {
		return this.use_dtm;
	}

	public void setuser_ip(String user_ip) {
		this.user_ip = user_ip;
	}
	public String getuser_ip() {
		return this.user_ip;
	}

	public void setsvc_nm(String svc_nm) {
		this.svc_nm = svc_nm;
	}
	public String getsvc_nm() {
		return this.svc_nm;
	}

	public void setfnct_nm(String fnct_nm) {
		this.fnct_nm = fnct_nm;
	}
	public String getfnct_nm() {
		return this.fnct_nm;
	}

	public void setrqst_prmtr(String rqst_prmtr) {
		this.rqst_prmtr = rqst_prmtr;
	}
	public String getrqst_prmtr() {
		return this.rqst_prmtr;
	}

	public void setprcs_tm(java.math.BigDecimal prcs_tm) {
		this.prcs_tm = prcs_tm;
	}
	public java.math.BigDecimal getprcs_tm() {
		return this.prcs_tm;
	}

	public void setrm_500(String rm_500) {
		this.rm_500 = rm_500;
	}
	public String getrm_500() {
		return this.rm_500;
	}

	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("\n[SystemAccessLogVO Content : ");
		sb.append("\n	sys_cd                           : [").append(sys_cd).append("]");
		sb.append("\n	user_id                          : [").append(user_id).append("]");
		sb.append("\n	use_dtm                          : [").append(use_dtm).append("]");
		sb.append("\n	user_ip                          : [").append(user_ip).append("]");
		sb.append("\n	svc_nm                           : [").append(svc_nm).append("]");
		sb.append("\n	fnct_nm                          : [").append(fnct_nm).append("]");
		sb.append("\n	rqst_prmtr                       : [").append(rqst_prmtr).append("]");
		sb.append("\n	prcs_tm                          : [").append(prcs_tm).append("]");
		sb.append("\n	rm_500                           : [").append(rm_500).append("]");
		return sb.toString();
	}
}