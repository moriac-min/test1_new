package foodportal.front.common.vo;

public class FoodBaseVO{

	private String				cmmn_cd;		//대표코드
	private String				fnprt_cd;		//코드
	private String				fnprt_cd_nm;	//코드명
	private String				no;
	
	private String              cretr_id;
	private java.sql.Date       cret_dtm;
	private String              last_updtr_id;
	private java.sql.Date       last_updt_dtm;
	
	public String getCmmn_cd() {
		return cmmn_cd;
	}
	public void setCmmn_cd(String cmmn_cd) {
		this.cmmn_cd = cmmn_cd;
	}
	public String getFnprt_cd() {
		return fnprt_cd;
	}
	public void setFnprt_cd(String fnprt_cd) {
		this.fnprt_cd = fnprt_cd;
	}
	public String getFnprt_cd_nm() {
		return fnprt_cd_nm;
	}
	public void setFnprt_cd_nm(String fnprt_cd_nm) {
		this.fnprt_cd_nm = fnprt_cd_nm;
	}
	public String getNo() {
		return no;
	}
	public void setNo(String no) {
		this.no = no;
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