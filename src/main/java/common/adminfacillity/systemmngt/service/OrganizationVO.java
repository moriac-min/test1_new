package common.adminfacillity.systemmngt.service;

import org.apache.commons.lang.builder.ToStringBuilder;

import common.commonfacillity.uia.WqBaseBean;

public class OrganizationVO extends WqBaseBean {

	private String               instt_cd;
	private String               instt_nm;
	private String               all_nm;
	private String               abbr_nm;
	private String               hrnk_instt_cd;
	private String               htrk_instt_cd;
	private java.math.BigDecimal opno;
	private java.math.BigDecimal rank;
	private String               use_yn;
	private String               instt_dvs_cd;
	private String               blnt_lcar_offc_instt_cd;
	private String               list_yn;
	private String               tel_no;
	private String               fax_no;
	private String               email;
	private String               instt_rdcn_nm;
	private String               onnr_instt_cd;
	private String               onnr_hrnk_instt_cd;
	private String               onnr_htrk_instt_cd;
	private String               rm_3000;
	private String               cretr_id;
	private java.sql.Date        cret_dtm;
	private String               last_updtr_id;
	private java.sql.Date        last_updt_dtm;
	
	public String getInstt_cd() {
		return instt_cd;
	}
	public void setInstt_cd(String instt_cd) {
		this.instt_cd = instt_cd;
	}
	public String getInstt_nm() {
		return instt_nm;
	}
	public void setInstt_nm(String instt_nm) {
		this.instt_nm = instt_nm;
	}
	public String getAll_nm() {
		return all_nm;
	}
	public void setAll_nm(String all_nm) {
		this.all_nm = all_nm;
	}
	public String getAbbr_nm() {
		return abbr_nm;
	}
	public void setAbbr_nm(String abbr_nm) {
		this.abbr_nm = abbr_nm;
	}
	public String getHrnk_instt_cd() {
		return hrnk_instt_cd;
	}
	public void setHrnk_instt_cd(String hrnk_instt_cd) {
		this.hrnk_instt_cd = hrnk_instt_cd;
	}
	public String getHtrk_instt_cd() {
		return htrk_instt_cd;
	}
	public void setHtrk_instt_cd(String htrk_instt_cd) {
		this.htrk_instt_cd = htrk_instt_cd;
	}
	public java.math.BigDecimal getOpno() {
		return opno;
	}
	public void setOpno(java.math.BigDecimal opno) {
		this.opno = opno;
	}
	public java.math.BigDecimal getRank() {
		return rank;
	}
	public void setRank(java.math.BigDecimal rank) {
		this.rank = rank;
	}
	public String getUse_yn() {
		return use_yn;
	}
	public void setUse_yn(String use_yn) {
		this.use_yn = use_yn;
	}
	public String getInstt_dvs_cd() {
		return instt_dvs_cd;
	}
	public void setInstt_dvs_cd(String instt_dvs_cd) {
		this.instt_dvs_cd = instt_dvs_cd;
	}
	public String getBlnt_lcar_offc_instt_cd() {
		return blnt_lcar_offc_instt_cd;
	}
	public void setBlnt_lcar_offc_instt_cd(String blnt_lcar_offc_instt_cd) {
		this.blnt_lcar_offc_instt_cd = blnt_lcar_offc_instt_cd;
	}
	public String getList_yn() {
		return list_yn;
	}
	public void setList_yn(String list_yn) {
		this.list_yn = list_yn;
	}
	public String getTel_no() {
		return tel_no;
	}
	public void setTel_no(String tel_no) {
		this.tel_no = tel_no;
	}
	public String getFax_no() {
		return fax_no;
	}
	public void setFax_no(String fax_no) {
		this.fax_no = fax_no;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getInstt_rdcn_nm() {
		return instt_rdcn_nm;
	}
	public void setInstt_rdcn_nm(String instt_rdcn_nm) {
		this.instt_rdcn_nm = instt_rdcn_nm;
	}
	public String getOnnr_instt_cd() {
		return onnr_instt_cd;
	}
	public void setOnnr_instt_cd(String onnr_instt_cd) {
		this.onnr_instt_cd = onnr_instt_cd;
	}
	public String getOnnr_hrnk_instt_cd() {
		return onnr_hrnk_instt_cd;
	}
	public void setOnnr_hrnk_instt_cd(String onnr_hrnk_instt_cd) {
		this.onnr_hrnk_instt_cd = onnr_hrnk_instt_cd;
	}
	public String getOnnr_htrk_instt_cd() {
		return onnr_htrk_instt_cd;
	}
	public void setOnnr_htrk_instt_cd(String onnr_htrk_instt_cd) {
		this.onnr_htrk_instt_cd = onnr_htrk_instt_cd;
	}
	public String getRm_3000() {
		return rm_3000;
	}
	public void setRm_3000(String rm_3000) {
		this.rm_3000 = rm_3000;
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

	public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}