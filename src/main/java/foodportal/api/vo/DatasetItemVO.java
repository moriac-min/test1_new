package foodportal.api.vo;

public class DatasetItemVO{
	
	private String svc_no;				//서비스번호
	
	private String itm_cd;				//항목코드
	private String ordno;				//순번
	private String itm_nm;				//항목명
	private String itm_desc;			//항목설명
	
	private String rm;					//비고
	private String cretr_id;			//생성자 아이디
	private String cret_dtm;			//생성일시
	private String last_updtr_id;		//수정자 아이디
	private String last_updt_dtm;		//수정일시
	
	
	public String getSvc_no() {
		return svc_no;
	}
	public void setSvc_no(String svc_no) {
		this.svc_no = svc_no;
	}
	public String getItm_cd() {
		return itm_cd;
	}
	public void setItm_cd(String itm_cd) {
		this.itm_cd = itm_cd;
	}
	public String getOrdno() {
		return ordno;
	}
	public void setOrdno(String ordno) {
		this.ordno = ordno;
	}
	public String getItm_nm() {
		return itm_nm;
	}
	public void setItm_nm(String itm_nm) {
		this.itm_nm = itm_nm;
	}
	public String getItm_desc() {
		return itm_desc;
	}
	public void setItm_desc(String itm_desc) {
		this.itm_desc = itm_desc;
	}
	public String getRm() {
		return rm;
	}
	public void setRm(String rm) {
		this.rm = rm;
	}
	public String getCretr_id() {
		return cretr_id;
	}
	public void setCretr_id(String cretr_id) {
		this.cretr_id = cretr_id;
	}
	public String getCret_dtm() {
		return cret_dtm;
	}
	public void setCret_dtm(String cret_dtm) {
		this.cret_dtm = cret_dtm;
	}
	public String getLast_updtr_id() {
		return last_updtr_id;
	}
	public void setLast_updtr_id(String last_updtr_id) {
		this.last_updtr_id = last_updtr_id;
	}
	public String getLast_updt_dtm() {
		return last_updt_dtm;
	}
	public void setLast_updt_dtm(String last_updt_dtm) {
		this.last_updt_dtm = last_updt_dtm;
	}
	

	
}