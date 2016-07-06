package foodportal.admin.systemmngt.vo;

import java.sql.Date;

import org.apache.commons.lang.builder.ToStringBuilder;

import common.commonfacillity.uia.WqBaseBean;

public class EnterpriseVO extends WqBaseBean{
	
	private String		entrps_esntl_no;
	private String		entrps_nm;
	private String		entrps_hmpgadres;
	private String		entrps_emailaddr;
	private String		entrps_tel_no;
	private String		entrps_fax_no;
	private String		entrps_locplc;
	private String		entrps_img_file_no;
	private String		rm;
	private String		cretr_id;
	private Date		cret_dtm;
	private String		last_updtr_id;
	private Date		last_updt_dtm;
	
	private String		representative_nm;		// 대표자명
	
	private String		search_type;
	private String		search_word;
	
	public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

	public String getEntrps_esntl_no() {
		return entrps_esntl_no;
	}

	public void setEntrps_esntl_no(String entrps_esntl_no) {
		this.entrps_esntl_no = entrps_esntl_no;
	}

	public String getEntrps_nm() {
		return entrps_nm;
	}

	public void setEntrps_nm(String entrps_nm) {
		this.entrps_nm = entrps_nm;
	}

	public String getEntrps_hmpgadres() {
		return entrps_hmpgadres;
	}

	public void setEntrps_hmpgadres(String entrps_hmpgadres) {
		this.entrps_hmpgadres = entrps_hmpgadres;
	}

	public String getEntrps_emailaddr() {
		return entrps_emailaddr;
	}

	public void setEntrps_emailaddr(String entrps_emailaddr) {
		this.entrps_emailaddr = entrps_emailaddr;
	}

	public String getEntrps_tel_no() {
		return entrps_tel_no;
	}

	public void setEntrps_tel_no(String entrps_tel_no) {
		this.entrps_tel_no = entrps_tel_no;
	}

	public String getEntrps_fax_no() {
		return entrps_fax_no;
	}

	public void setEntrps_fax_no(String entrps_fax_no) {
		this.entrps_fax_no = entrps_fax_no;
	}

	public String getEntrps_locplc() {
		return entrps_locplc;
	}

	public void setEntrps_locplc(String entrps_locplc) {
		this.entrps_locplc = entrps_locplc;
	}

	public String getEntrps_img_file_no() {
		return entrps_img_file_no;
	}

	public void setEntrps_img_file_no(String entrps_img_file_no) {
		this.entrps_img_file_no = entrps_img_file_no;
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

	public String getRepresentative_nm() {
		return representative_nm;
	}

	public void setRepresentative_nm(String representative_nm) {
		this.representative_nm = representative_nm;
	}

	public String getSearch_type() {
		return search_type;
	}

	public void setSearch_type(String search_type) {
		this.search_type = search_type;
	}

	public String getSearch_word() {
		return search_word;
	}

	public void setSearch_word(String search_word) {
		this.search_word = search_word;
	}
	
}