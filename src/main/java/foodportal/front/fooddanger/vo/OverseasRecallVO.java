package foodportal.front.fooddanger.vo;

/**
 * OverseasRecallVO
 * @author 최승희
 * @since 2014.10.01
 * @version 1.0
 * @see
 * 
 * <pre>
 *  Modification Information
 *  수정일     수정자   수정내용
 *  ---------- -------- ---------------------------
 *  2014.10.01 최승희 	최초 생성
 * </pre>
 * 
 * Copyright (C) 2014 by NDS., All right reserved.
 */
public class OverseasRecallVO {
	
	private String injry_esntl_no;
	private String no;
	private String titl;
	private String cn;
	private String cret_dtm;
	private String occrnc_dtm;
	private String abbr_nm;
	
	public String getTitl() {
		return titl;
	}
	public void setTitl(String titl) {
		this.titl = titl;
	}
	public String getCret_dtm() {
		return cret_dtm;
	}
	public void setCret_dtm(String cret_dtm) {
		this.cret_dtm = cret_dtm;
	}
	public String getInjry_esntl_no() {
		return injry_esntl_no;
	}
	public void setInjry_esntl_no(String injry_esntl_no) {
		this.injry_esntl_no = injry_esntl_no;
	}
	public String getNo() {
		return no;
	}
	public void setNo(String no) {
		this.no = no;
	}
	public String getCn() {
		return cn;
	}
	public void setCn(String cn) {
		this.cn = cn;
	}
	public String getOccrnc_dtm() {
		return occrnc_dtm;
	}
	public void setOccrnc_dtm(String occrnc_dtm) {
		this.occrnc_dtm = occrnc_dtm;
	}
	public String getAbbr_nm() {
		return abbr_nm;
	}
	public void setAbbr_nm(String abbr_nm) {
		this.abbr_nm = abbr_nm;
	}

}
