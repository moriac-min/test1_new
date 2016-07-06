package foodportal.front.safefoodlife.food.vo;

import java.sql.Date;

import org.apache.commons.lang.builder.ToStringBuilder;

public class FoodTypeChngVO {
	
	private String		chng_no;
	private String		bf_ctgry1;
	private String		bf_ctgry2;
	private String		bf_ctgry3;
	private String		bf_ctgry4;
	private String		af_ctgry1;
	private String		af_ctgry2;
	private String		af_ctgry3;
	private String		af_ctgry4;
	private String		dtl_desc;
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
	
	public String getChng_no() {
		return chng_no;
	}

	public void setChng_no(String chng_no) {
		this.chng_no = chng_no;
	}

	public String getBf_ctgry1() {
		return bf_ctgry1;
	}

	public void setBf_ctgry1(String bf_ctgry1) {
		this.bf_ctgry1 = bf_ctgry1;
	}

	public String getBf_ctgry2() {
		return bf_ctgry2;
	}

	public void setBf_ctgry2(String bf_ctgry2) {
		this.bf_ctgry2 = bf_ctgry2;
	}

	public String getBf_ctgry3() {
		return bf_ctgry3;
	}

	public void setBf_ctgry3(String bf_ctgry3) {
		this.bf_ctgry3 = bf_ctgry3;
	}

	public String getBf_ctgry4() {
		return bf_ctgry4;
	}

	public void setBf_ctgry4(String bf_ctgry4) {
		this.bf_ctgry4 = bf_ctgry4;
	}

	public String getAf_ctgry1() {
		return af_ctgry1;
	}

	public void setAf_ctgry1(String af_ctgry1) {
		this.af_ctgry1 = af_ctgry1;
	}

	public String getAf_ctgry2() {
		return af_ctgry2;
	}

	public void setAf_ctgry2(String af_ctgry2) {
		this.af_ctgry2 = af_ctgry2;
	}

	public String getAf_ctgry3() {
		return af_ctgry3;
	}

	public void setAf_ctgry3(String af_ctgry3) {
		this.af_ctgry3 = af_ctgry3;
	}

	public String getAf_ctgry4() {
		return af_ctgry4;
	}

	public void setAf_ctgry4(String af_ctgry4) {
		this.af_ctgry4 = af_ctgry4;
	}

	public String getDtl_desc() {
		return dtl_desc;
	}

	public void setDtl_desc(String dtl_desc) {
		this.dtl_desc = dtl_desc;
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