package foodportal.front.common.vo;

public class ShopVO{

	private String				bsn_lcns_ledg_no;		//영업_인허가_대장_번호
	private String				lcns_no;				//허가번호
	private String				induty_cd_nm;			//업종
	private String				bssh_nm;				//업소명
	private String				addr_dtl;				//상세주소
	private String				prsdnt_nm;				//대표자명
	private String				addr;					//주소
	private String				zipno;					//우편번호
	private String 				telno;					//전화번호
	private String				no;
	private String				makr_reg_unreg_bssh_dvs_cd;	//등록, 미등록 업소 구분 코드
	private String				seq_no;					//업소 코드
	
	private String              cretr_id;
	private java.sql.Date       cret_dtm;
	private String              last_updtr_id;
	private java.sql.Date       last_updt_dtm;
	
	
	public String getBsn_lcns_ledg_no() {
		return bsn_lcns_ledg_no;
	}
	public void setBsn_lcns_ledg_no(String bsn_lcns_ledg_no) {
		this.bsn_lcns_ledg_no = bsn_lcns_ledg_no;
	}
	public String getLcns_no() {
		return lcns_no;
	}
	public void setLcns_no(String lcns_no) {
		this.lcns_no = lcns_no;
	}
	public String getInduty_cd_nm() {
		return induty_cd_nm;
	}
	public void setInduty_cd_nm(String induty_cd_nm) {
		this.induty_cd_nm = induty_cd_nm;
	}
	public String getBssh_nm() {
		return bssh_nm;
	}
	public void setBssh_nm(String bssh_nm) {
		this.bssh_nm = bssh_nm;
	}
	public String getAddr_dtl() {
		return addr_dtl;
	}
	public void setAddr_dtl(String addr_dtl) {
		this.addr_dtl = addr_dtl;
	}
	public String getPrsdnt_nm() {
		return prsdnt_nm;
	}
	public void setPrsdnt_nm(String prsdnt_nm) {
		this.prsdnt_nm = prsdnt_nm;
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
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public String getZipno() {
		return zipno;
	}
	public void setZipno(String zipno) {
		this.zipno = zipno;
	}
	public String getTelno() {
		return telno;
	}
	public void setTelno(String telno) {
		this.telno = telno;
	}
	public String getMakr_reg_unreg_bssh_dvs_cd() {
		return makr_reg_unreg_bssh_dvs_cd;
	}
	public void setMakr_reg_unreg_bssh_dvs_cd(String makr_reg_unreg_bssh_dvs_cd) {
		this.makr_reg_unreg_bssh_dvs_cd = makr_reg_unreg_bssh_dvs_cd;
	}
	public String getSeq_no() {
		return seq_no;
	}
	public void setSeq_no(String seq_no) {
		this.seq_no = seq_no;
	}
	
	
	
}