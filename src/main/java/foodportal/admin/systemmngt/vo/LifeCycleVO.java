package foodportal.admin.systemmngt.vo;

import common.commonfacillity.uia.WqBaseBean;

public class LifeCycleVO extends WqBaseBean{
	
	private String bbs_no;				//게시판_번호
	private String ntctxt_no;			//게시글_번호
	private String titl;					//게시글_제목
	private String clmn01;				//유아동
	private String clmn02;				//어린이
	private String clmn03;				//청소년
	private String clmn04;				//임산부
	private String clmn05;				//성인
	private String clmn06;				//노인
	private String cretr_id;				//등록자
	private java.sql.Date cret_dtm;			//등록일
	private String last_updtr_id;				//등록자
	private java.sql.Date last_updt_dtm;			//등록일

	public String getBbs_no() {
		return bbs_no;
	}
	public void setBbs_no(String bbs_no) {
		this.bbs_no = bbs_no;
	}
	public String getNtctxt_no() {
		return ntctxt_no;
	}
	public void setNtctxt_no(String ntctxt_no) {
		this.ntctxt_no = ntctxt_no;
	}
	public String getClmn01() {
		return clmn01;
	}
	public void setClmn01(String clmn01) {
		this.clmn01 = clmn01;
	}
	public String getClmn02() {
		return clmn02;
	}
	public void setClmn02(String clmn02) {
		this.clmn02 = clmn02;
	}
	public String getClmn03() {
		return clmn03;
	}
	public void setClmn03(String clmn03) {
		this.clmn03 = clmn03;
	}
	public String getClmn04() {
		return clmn04;
	}
	public void setClmn04(String clmn04) {
		this.clmn04 = clmn04;
	}
	public String getClmn05() {
		return clmn05;
	}
	public void setClmn05(String clmn05) {
		this.clmn05 = clmn05;
	}
	public String getClmn06() {
		return clmn06;
	}
	public void setClmn06(String clmn06) {
		this.clmn06 = clmn06;
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
	public String getTitl() {
		return titl;
	}
	public void setTitl(String titl) {
		this.titl = titl;
	}
	
}



