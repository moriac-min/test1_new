package common.adminfacillity.systemmngt.service;
public class SystemUseLogVO {

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
	private java.sql.Date        login_dtm;
	private String               login_ip;
	private java.sql.Date        logout_dtm;

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

	public void setlogin_dtm(java.sql.Date login_dtm) {
		this.login_dtm = login_dtm;
	}
	public java.sql.Date getlogin_dtm() {
		return this.login_dtm;
	}

	public void setlogin_ip(String login_ip) {
		this.login_ip = login_ip;
	}
	public String getlogin_ip() {
		return this.login_ip;
	}

	public void setlogout_dtm(java.sql.Date logout_dtm) {
		this.logout_dtm = logout_dtm;
	}
	public java.sql.Date getlogout_dtm() {
		return this.logout_dtm;
	}

	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("\n[SystemUseLogVO Content : ");
		sb.append("\n	sys_cd                           : [").append(sys_cd).append("]");
		sb.append("\n	user_id                          : [").append(user_id).append("]");
		sb.append("\n	login_dtm                        : [").append(login_dtm).append("]");
		sb.append("\n	login_ip                         : [").append(login_ip).append("]");
		sb.append("\n	logout_dtm                       : [").append(logout_dtm).append("]");
		return sb.toString();
	}
}