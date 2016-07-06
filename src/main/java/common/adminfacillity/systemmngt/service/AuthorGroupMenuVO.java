package common.adminfacillity.systemmngt.service;

import org.apache.commons.lang.builder.ToStringBuilder;

import common.commonfacillity.uia.WqBaseBean;

public class AuthorGroupMenuVO extends WqBaseBean {
	private String athr_grp_cd;
	private String sys_cd;
	private String menu_cd;
	private String menu_nm;
	private String hrnk_menu_cd;
	private String sort_ord;
	private String scrn_athr_yn;
	private String inqry_athr_yn;
	private String insrt_athr_yn;
	private String save_athr_yn;
	private String del_athr_yn;
	private String outpt_athr_yn;
	private String excl_athr_yn;
	private java.math.BigDecimal athr_lv;
	private String cretr_id;
	private java.sql.Date cret_dtm;
	private String last_updtr_id;
	private java.sql.Date last_updt_dtm;
	private java.math.BigDecimal lvl;
	private String prgr_cd;
	private String url;
	private String state;
	
	public String getAthr_grp_cd() {
		return athr_grp_cd;
	}
	public void setAthr_grp_cd(String athr_grp_cd) {
		this.athr_grp_cd = athr_grp_cd;
	}
	public String getSys_cd() {
		return sys_cd;
	}
	public void setSys_cd(String sys_cd) {
		this.sys_cd = sys_cd;
	}
	public String getMenu_cd() {
		return menu_cd;
	}
	public void setMenu_cd(String menu_cd) {
		this.menu_cd = menu_cd;
	}
	public String getMenu_nm() {
		return menu_nm;
	}
	public void setMenu_nm(String menu_nm) {
		this.menu_nm = menu_nm;
	}
	public String getHrnk_menu_cd() {
		return hrnk_menu_cd;
	}
	public void setHrnk_menu_cd(String hrnk_menu_cd) {
		this.hrnk_menu_cd = hrnk_menu_cd;
	}
	public String getSort_ord() {
		return sort_ord;
	}
	public void setSort_ord(String sort_ord) {
		this.sort_ord = sort_ord;
	}
	public String getScrn_athr_yn() {
		return scrn_athr_yn;
	}
	public void setScrn_athr_yn(String scrn_athr_yn) {
		this.scrn_athr_yn = scrn_athr_yn;
	}
	public String getInqry_athr_yn() {
		return inqry_athr_yn;
	}
	public void setInqry_athr_yn(String inqry_athr_yn) {
		this.inqry_athr_yn = inqry_athr_yn;
	}
	public String getInsrt_athr_yn() {
		return insrt_athr_yn;
	}
	public void setInsrt_athr_yn(String insrt_athr_yn) {
		this.insrt_athr_yn = insrt_athr_yn;
	}
	public String getSave_athr_yn() {
		return save_athr_yn;
	}
	public void setSave_athr_yn(String save_athr_yn) {
		this.save_athr_yn = save_athr_yn;
	}
	public String getDel_athr_yn() {
		return del_athr_yn;
	}
	public void setDel_athr_yn(String del_athr_yn) {
		this.del_athr_yn = del_athr_yn;
	}
	public String getOutpt_athr_yn() {
		return outpt_athr_yn;
	}
	public void setOutpt_athr_yn(String outpt_athr_yn) {
		this.outpt_athr_yn = outpt_athr_yn;
	}
	public String getExcl_athr_yn() {
		return excl_athr_yn;
	}
	public void setExcl_athr_yn(String excl_athr_yn) {
		this.excl_athr_yn = excl_athr_yn;
	}
	public java.math.BigDecimal getAthr_lv() {
		return athr_lv;
	}
	public void setAthr_lv(java.math.BigDecimal athr_lv) {
		this.athr_lv = athr_lv;
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
	public java.math.BigDecimal getLvl() {
		return lvl;
	}
	public void setLvl(java.math.BigDecimal lvl) {
		this.lvl = lvl;
	}
	public String getPrgr_cd() {
		return prgr_cd;
	}
	public void setPrgr_cd(String prgr_cd) {
		this.prgr_cd = prgr_cd;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}

	public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
	
}