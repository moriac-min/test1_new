package foodportal.front.safefoodlife.food.vo;

import java.sql.Date;

import org.apache.commons.lang.builder.ToStringBuilder;

public class FoodTypeChngQnaVO {
	
	private String		qna_no;
	private String		ctgry;
	private String		sclas;
	private String		qury_cn;
	private String		rspns_cn;
	private String		use_yn;
	private String		rm;
	private String		cretr_id;
	private Date		cret_dtm;
	private String		last_updtr_id;
	private Date		last_updt_dtm;
	
	private String		search_word;
	
	public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

	public String getQna_no() {
		return qna_no;
	}

	public void setQna_no(String qna_no) {
		this.qna_no = qna_no;
	}

	public String getCtgry() {
		return ctgry;
	}

	public void setCtgry(String ctgry) {
		this.ctgry = ctgry;
	}

	public String getSclas() {
		return sclas;
	}

	public void setSclas(String sclas) {
		this.sclas = sclas;
	}

	public String getQury_cn() {
		return qury_cn;
	}

	public void setQury_cn(String qury_cn) {
		this.qury_cn = qury_cn;
	}

	public String getRspns_cn() {
		return rspns_cn;
	}

	public void setRspns_cn(String rspns_cn) {
		this.rspns_cn = rspns_cn;
	}

	public String getUse_yn() {
		return use_yn;
	}

	public void setUse_yn(String use_yn) {
		this.use_yn = use_yn;
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

	public String getSearch_word() {
		return search_word;
	}

	public void setSearch_word(String search_word) {
		this.search_word = search_word;
	}
	
}