package common.adminfacillity.systemmngt.service;

import common.commonfacillity.uia.WqBaseBean;

public class MenuVO extends WqBaseBean{
	private String				 depth;
	private String               sys_cd;
	private String               menu_cd;
	private String               menu_nm;
	private java.math.BigDecimal sort_ord;
	private String               hrnk_menu_cd;
	private String               lwrk_menu_exst_yn;
	private String               work_dvs_cd;
	private String               prgr_cd;
	private String               use_yn;
	private String               cretr_id;
	private java.sql.Date        cret_dtm;
	private String               last_updtr_id;
	private java.sql.Date        last_updt_dtm;

	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("\n[MenuVO Content : ");
		sb.append("\n	sys_cd                           : [").append(sys_cd).append("]");
		sb.append("\n	menu_cd                          : [").append(menu_cd).append("]");
		sb.append("\n	menu_nm                          : [").append(menu_nm).append("]");
		sb.append("\n	sort_ord                         : [").append(sort_ord).append("]");
		sb.append("\n	hrnk_menu_cd                     : [").append(hrnk_menu_cd).append("]");
		sb.append("\n	lwrk_menu_exst_yn                : [").append(lwrk_menu_exst_yn).append("]");
		sb.append("\n	work_dvs_cd                      : [").append(work_dvs_cd).append("]");
		sb.append("\n	prgr_cd                          : [").append(prgr_cd).append("]");
		sb.append("\n	use_yn                           : [").append(use_yn).append("]");
		sb.append("\n	cretr_id                         : [").append(cretr_id).append("]");
		sb.append("\n	cret_dtm                         : [").append(cret_dtm).append("]");
		sb.append("\n	last_updtr_id                    : [").append(last_updtr_id).append("]");
		sb.append("\n	last_updt_dtm                    : [").append(last_updt_dtm).append("]");
		return sb.toString();
	}

	public String getDepth() {
		return depth;
	}

	public void setDepth(String depth) {
		this.depth = depth;
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

	public java.math.BigDecimal getSort_ord() {
		return sort_ord;
	}

	public void setSort_ord(java.math.BigDecimal sort_ord) {
		this.sort_ord = sort_ord;
	}

	public String getHrnk_menu_cd() {
		return hrnk_menu_cd;
	}

	public void setHrnk_menu_cd(String hrnk_menu_cd) {
		this.hrnk_menu_cd = hrnk_menu_cd;
	}

	public String getLwrk_menu_exst_yn() {
		return lwrk_menu_exst_yn;
	}

	public void setLwrk_menu_exst_yn(String lwrk_menu_exst_yn) {
		this.lwrk_menu_exst_yn = lwrk_menu_exst_yn;
	}

	public String getWork_dvs_cd() {
		return work_dvs_cd;
	}

	public void setWork_dvs_cd(String work_dvs_cd) {
		this.work_dvs_cd = work_dvs_cd;
	}

	public String getPrgr_cd() {
		return prgr_cd;
	}

	public void setPrgr_cd(String prgr_cd) {
		this.prgr_cd = prgr_cd;
	}

	public String getUse_yn() {
		return use_yn;
	}

	public void setUse_yn(String use_yn) {
		this.use_yn = use_yn;
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