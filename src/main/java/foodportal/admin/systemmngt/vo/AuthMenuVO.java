package foodportal.admin.systemmngt.vo;

import java.math.BigDecimal;
import java.sql.Date;

import org.apache.commons.lang.builder.ToStringBuilder;

import common.commonfacillity.uia.WqBaseBean;

public class AuthMenuVO extends WqBaseBean{
	
	private String		athr_no;
	private String		menu_no;
	private String		reg_yn;
	private String		updt_yn;
	private String		del_yn;
	private String		rm;
	private String		cretr_id;
	private Date		cret_dtm;
	private String		last_updtr_id;
	private Date		last_updt_dtm;
	
	private String		athr_nm;
	
	private String		hrnk_menu_no;
	private String		menu_nm;
	private String		sys_dvs_cd;
	private String		menu_type_cd;
	private String		url;
	private String		bbs_no;
	private BigDecimal	sort_ord;
	private BigDecimal	lv;
	
	public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

	public String getAthr_no() {
		return athr_no;
	}

	public void setAthr_no(String athr_no) {
		this.athr_no = athr_no;
	}

	public String getMenu_no() {
		return menu_no;
	}

	public void setMenu_no(String menu_no) {
		this.menu_no = menu_no;
	}

	public String getReg_yn() {
		return reg_yn;
	}

	public void setReg_yn(String reg_yn) {
		this.reg_yn = reg_yn;
	}

	public String getUpdt_yn() {
		return updt_yn;
	}

	public void setUpdt_yn(String updt_yn) {
		this.updt_yn = updt_yn;
	}

	public String getDel_yn() {
		return del_yn;
	}

	public void setDel_yn(String del_yn) {
		this.del_yn = del_yn;
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

	public String getAthr_nm() {
		return athr_nm;
	}

	public void setAthr_nm(String athr_nm) {
		this.athr_nm = athr_nm;
	}

	public String getHrnk_menu_no() {
		return hrnk_menu_no;
	}

	public void setHrnk_menu_no(String hrnk_menu_no) {
		this.hrnk_menu_no = hrnk_menu_no;
	}

	public String getMenu_nm() {
		return menu_nm;
	}

	public void setMenu_nm(String menu_nm) {
		this.menu_nm = menu_nm;
	}

	public String getSys_dvs_cd() {
		return sys_dvs_cd;
	}

	public void setSys_dvs_cd(String sys_dvs_cd) {
		this.sys_dvs_cd = sys_dvs_cd;
	}

	public String getMenu_type_cd() {
		return menu_type_cd;
	}

	public void setMenu_type_cd(String menu_type_cd) {
		this.menu_type_cd = menu_type_cd;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getBbs_no() {
		return bbs_no;
	}

	public void setBbs_no(String bbs_no) {
		this.bbs_no = bbs_no;
	}

	public BigDecimal getSort_ord() {
		return sort_ord;
	}

	public void setSort_ord(BigDecimal sort_ord) {
		this.sort_ord = sort_ord;
	}

	public BigDecimal getLv() {
		return lv;
	}

	public void setLv(BigDecimal lv) {
		this.lv = lv;
	}
	
}