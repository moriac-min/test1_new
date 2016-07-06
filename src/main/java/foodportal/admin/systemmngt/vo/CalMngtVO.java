package foodportal.admin.systemmngt.vo;

import java.math.BigDecimal;
import java.sql.Date;

import common.commonfacillity.uia.WqBaseBean;

public class CalMngtVO extends WqBaseBean{
	
	private String		date_no;
	private String		date_seq;
	private String		title;
	private String		plc;
	private String		begin_dt;
	private String		end_dt;
	private String		bdt;
	private String		del_yn;
	private String		rnum;
	private String		cretr_id;
	private Date		cret_dtm;
	private String		last_updtr_id;
	private Date		last_updt_dtm;
	
	public String getDate_no() {
		return date_no;
	}
	public void setDate_no(String date_no) {
		this.date_no = date_no;
	}
	public String getDate_seq() {
		return date_seq;
	}
	public void setDate_seq(String date_seq) {
		this.date_seq = date_seq;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getPlc() {
		return plc;
	}
	public void setPlc(String plc) {
		this.plc = plc;
	}
	public String getBegin_dt() {
		return begin_dt;
	}
	public void setBegin_dt(String begin_dt) {
		this.begin_dt = begin_dt;
	}
	public String getEnd_dt() {
		return end_dt;
	}
	public void setEnd_dt(String end_dt) {
		this.end_dt = end_dt;
	}
	public String getBdt() {
		return bdt;
	}
	public void setBdt(String bdt) {
		this.bdt = bdt;
	}
	public String getDel_yn() {
		return del_yn;
	}
	public void setDel_yn(String del_yn) {
		this.del_yn = del_yn;
	}
	public String getRnum() {
		return rnum;
	}
	public void setRnum(String rnum) {
		this.rnum = rnum;
	}
	public String getCretr_id() {
		return cretr_id;
	}
	public void setCretr_id(String cretr_id) {
		this.cretr_id = cretr_id;
	}
	public Date getCret_dtm() {
		return cret_dtm;
	}
	public void setCret_dtm(Date cret_dtm) {
		this.cret_dtm = cret_dtm;
	}
	public String getLast_updtr_id() {
		return last_updtr_id;
	}
	public void setLast_updtr_id(String last_updtr_id) {
		this.last_updtr_id = last_updtr_id;
	}
	public Date getLast_updt_dtm() {
		return last_updt_dtm;
	}
	public void setLast_updt_dtm(Date last_updt_dtm) {
		this.last_updt_dtm = last_updt_dtm;
	}

	
	
}