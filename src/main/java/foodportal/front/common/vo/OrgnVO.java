package foodportal.front.common.vo;

public class OrgnVO{

	private String				instt_cd;		//기관코드
	private String				instt_nm;		//기관명
	private String              all_nm;			//전체명
	private String				abbr_nm;		//축약명
	private String				hrnk_instt_cd;	//상위기관코드
	private String				htrk_instt_cd;	//최상위기관코드
	private String				opno;			//차수
	private String				tel_no;			//전화번호
	private String				fax_no;			//팩스번호
	private String				email;			//이메일주소
	private String				instt_rdcn_nm;	//기관줄임명
	private String 				no;				//순번
	
	private String              cretr_id;
	private java.sql.Date       cret_dtm;
	private String              last_updtr_id;
	private java.sql.Date       last_updt_dtm;
	
	public String getInstt_cd() {
		return instt_cd;
	}
	public void setInstt_cd(String instt_cd) {
		this.instt_cd = instt_cd;
	}
	public String getInstt_nm() {
		return instt_nm;
	}
	public void setInstt_nm(String instt_nm) {
		this.instt_nm = instt_nm;
	}
	public String getAll_nm() {
		return all_nm;
	}
	public void setAll_nm(String all_nm) {
		this.all_nm = all_nm;
	}
	public String getAbbr_nm() {
		return abbr_nm;
	}
	public void setAbbr_nm(String abbr_nm) {
		this.abbr_nm = abbr_nm;
	}
	public String getHrnk_instt_cd() {
		return hrnk_instt_cd;
	}
	public void setHrnk_instt_cd(String hrnk_instt_cd) {
		this.hrnk_instt_cd = hrnk_instt_cd;
	}
	public String getHtrk_instt_cd() {
		return htrk_instt_cd;
	}
	public void setHtrk_instt_cd(String htrk_instt_cd) {
		this.htrk_instt_cd = htrk_instt_cd;
	}
	public String getOpno() {
		return opno;
	}
	public void setOpno(String opno) {
		this.opno = opno;
	}
	public String getTel_no() {
		return tel_no;
	}
	public void setTel_no(String tel_no) {
		this.tel_no = tel_no;
	}
	public String getFax_no() {
		return fax_no;
	}
	public void setFax_no(String fax_no) {
		this.fax_no = fax_no;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getInstt_rdcn_nm() {
		return instt_rdcn_nm;
	}
	public void setInstt_rdcn_nm(String instt_rdcn_nm) {
		this.instt_rdcn_nm = instt_rdcn_nm;
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
	public String getNo() {
		return no;
	}
	public void setNo(String no) {
		this.no = no;
	}
	
	
	
	
}