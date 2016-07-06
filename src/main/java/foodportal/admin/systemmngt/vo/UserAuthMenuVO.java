package foodportal.admin.systemmngt.vo;

import java.math.BigDecimal;

import org.apache.commons.lang.builder.ToStringBuilder;

import common.commonfacillity.uia.WqBaseBean;

public class UserAuthMenuVO extends WqBaseBean{
	
	private String		menu_no;
	private String		reg_yn;
	private String		updt_yn;
	private String		del_yn;
	private String		hrnk_menu_no;
	private String		menu_nm;
	private String		sys_dvs_cd;
	private String		menu_type_cd;
	private String		url;
	private String		bbs_no;
	private BigDecimal	sort_ord;
	private BigDecimal	lv;
	
	private String		menu_cd;
	private String		prgr_cd;
	private BigDecimal	lvl;
	
	private String		user_id;
	private String		use_yn;
	
	public String toString() {
        return ToStringBuilder.reflectionToString(this);
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

	public String getMenu_cd() {
		return menu_cd;
	}

	public void setMenu_cd(String menu_cd) {
		this.menu_cd = menu_cd;
	}

	public String getPrgr_cd() {
		return prgr_cd;
	}

	public void setPrgr_cd(String prgr_cd) {
		this.prgr_cd = prgr_cd;
	}

	public BigDecimal getLvl() {
		return lvl;
	}

	public void setLvl(BigDecimal lvl) {
		this.lvl = lvl;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getUse_yn() {
		return use_yn;
	}

	public void setUse_yn(String use_yn) {
		this.use_yn = use_yn;
	}
	
}