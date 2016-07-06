package foodportal.admin.systemmngt.vo;

import org.apache.commons.lang.builder.ToStringBuilder;

import common.commonfacillity.uia.WqBaseBean;

public class CommonCodeVO extends WqBaseBean{
	
	private String cmmn_cd;
	private String hrnk_cd;
	private String cd_nm;
	private String ext_cd;
	private String accs_posbl_yn;
	private java.math.BigDecimal sort_ord;
	private String use_yn;
	private String rm;
	private String cretr_id;
	private java.sql.Date cret_dtm;
	private String last_updtr_id;
	private java.sql.Date last_updt_dtm;

	private String search_type;
	private String search_word;
	
	public String toString() {
        return ToStringBuilder.reflectionToString(this);
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

	public String getCmmn_cd() {
		return cmmn_cd;
	}

	public void setCmmn_cd(String cmmn_cd) {
		this.cmmn_cd = cmmn_cd;
	}

	public String getHrnk_cd() {
		return hrnk_cd;
	}

	public void setHrnk_cd(String hrnk_cd) {
		this.hrnk_cd = hrnk_cd;
	}

	public String getCd_nm() {
		return cd_nm;
	}

	public void setCd_nm(String cd_nm) {
		this.cd_nm = cd_nm;
	}

	public String getExt_cd() {
		return ext_cd;
	}

	public void setExt_cd(String ext_cd) {
		this.ext_cd = ext_cd;
	}

	public String getAccs_posbl_yn() {
		return accs_posbl_yn;
	}

	public void setAccs_posbl_yn(String accs_posbl_yn) {
		this.accs_posbl_yn = accs_posbl_yn;
	}

	public java.math.BigDecimal getSort_ord() {
		return sort_ord;
	}

	public void setSort_ord(java.math.BigDecimal sort_ord) {
		this.sort_ord = sort_ord;
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

}