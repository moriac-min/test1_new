package foodportal.admin.systemmngt.vo;

import java.sql.Date;

import org.apache.commons.lang.builder.ToStringBuilder;

import common.commonfacillity.uia.WqBaseBean;

public class EnterpriseMemberVO extends WqBaseBean{
	
	private String		entrps_esntl_no;
	private String		mber_no;
	private String		ofcps_cd;
	private String		emplye_stats_cd;
	private String		rm;
	private String		cretr_id;
	private Date		cret_dtm;
	private String		last_updtr_id;
	private Date		last_updt_dtm;
	
	private String		id;
	private String		name;
	private String		mbtpn_no;
	private String		tel_no;
	
	private String		ofcps_cd_nm;
	private String		emplye_stats_cd_nm;
	
	public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

	public String getEntrps_esntl_no() {
		return entrps_esntl_no;
	}

	public void setEntrps_esntl_no(String entrps_esntl_no) {
		this.entrps_esntl_no = entrps_esntl_no;
	}

	public String getMber_no() {
		return mber_no;
	}

	public void setMber_no(String mber_no) {
		this.mber_no = mber_no;
	}

	public String getOfcps_cd() {
		return ofcps_cd;
	}

	public void setOfcps_cd(String ofcps_cd) {
		this.ofcps_cd = ofcps_cd;
	}

	public String getEmplye_stats_cd() {
		return emplye_stats_cd;
	}

	public void setEmplye_stats_cd(String emplye_stats_cd) {
		this.emplye_stats_cd = emplye_stats_cd;
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

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMbtpn_no() {
		return mbtpn_no;
	}

	public void setMbtpn_no(String mbtpn_no) {
		this.mbtpn_no = mbtpn_no;
	}

	public String getTel_no() {
		return tel_no;
	}

	public void setTel_no(String tel_no) {
		this.tel_no = tel_no;
	}

	public String getOfcps_cd_nm() {
		return ofcps_cd_nm;
	}

	public void setOfcps_cd_nm(String ofcps_cd_nm) {
		this.ofcps_cd_nm = ofcps_cd_nm;
	}

	public String getEmplye_stats_cd_nm() {
		return emplye_stats_cd_nm;
	}

	public void setEmplye_stats_cd_nm(String emplye_stats_cd_nm) {
		this.emplye_stats_cd_nm = emplye_stats_cd_nm;
	}

}