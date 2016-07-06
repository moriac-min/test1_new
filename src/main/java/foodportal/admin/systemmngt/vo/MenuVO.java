package foodportal.admin.systemmngt.vo;

import java.util.List;

import common.commonfacillity.uia.WqBaseBean;

public class MenuVO extends WqBaseBean{

	/*******************메뉴관리용**********************/
	private String				menu_no;
	private String				hrnk_menu_no;
	private String              lv;
	private String				menu_nm;
	private String				sys_dvs_cd;
	private String				menu_type_cd;
	private String				url;
	private String				bbs_no;
	private String				sort_ord;
	private String				hide_yn;
	private String				use_yn;
	private String				rm;
	
	private String              cretr_id;
	private java.sql.Date       cret_dtm;
	private String              last_updtr_id;
	private java.sql.Date       last_updt_dtm;
	
	/*******************관리자메인용**********************/
	private String 				menu_cd;
	private String 				hrnk_menu_cd;
	private String 				lvl;
	private String 				prgr_cd;
	private String 				state;
	private String 				scrn_athr_yn;
	private String 				inqry_athr_yn;
	private String 				insrt_athr_yn;
	private String 				save_athr_yn;
	private String 				del_athr_yn;
	private String 				outpt_athr_yn;
	private String 				excl_athr_yn;
	private String 				athr_lv;
	
	/*******************게시판이동용**********************/
	private String 				sys_dvs_nm;
	private String 				bbs_type_cd;
	private String 				mapping_yn;
	private String 				mapping_nm;
	
	/*******************게시판영역컨텐츠용**********************/
	private String 				titl;
	private String 				bdt;
	private String 				logic_file_nm;
	private String 				chk;
	private String 				ntctxt_no;
	
	/*
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("\n[CommonCodeVO Content : ");
		sb.append("\n	sys_cd                           : [").append(sys_cd).append("]");
		sb.append("\n	cmmn_cd                          : [").append(cmmn_cd).append("]");
		sb.append("\n	cretr_id                         : [").append(cretr_id).append("]");
		sb.append("\n	cret_dtm                         : [").append(cret_dtm).append("]");
		sb.append("\n	last_updtr_id                    : [").append(last_updtr_id).append("]");
		sb.append("\n	last_updt_dtm                    : [").append(last_updt_dtm).append("]");
		return sb.toString();
	}
	*/
	
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
	public String getMenu_no() {
		return menu_no;
	}
	public void setMenu_no(String menu_no) {
		this.menu_no = menu_no;
	}
	public String getLv() {
		return lv;
	}
	public void setLv(String lv) {
		this.lv = lv;
	}
	
	public String getHrnk_menu_no() {
		return hrnk_menu_no;
	}
	public void setHrnk_menu_no(String hrnk_menu_no) {
		this.hrnk_menu_no = hrnk_menu_no;
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
	public String getSort_ord() {
		return sort_ord;
	}
	public void setSort_ord(String sort_ord) {
		this.sort_ord = sort_ord;
	}
	public String getHide_yn() {
		return hide_yn;
	}
	public void setHide_yn(String hide_yn) {
		this.hide_yn = hide_yn;
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
	public String getMenu_nm() {
		return menu_nm;
	}
	public void setMenu_nm(String menu_nm) {
		this.menu_nm = menu_nm;
	}
	public String getMenu_cd() {
		return menu_cd;
	}
	public void setMenu_cd(String menu_cd) {
		this.menu_cd = menu_cd;
	}
	public String getHrnk_menu_cd() {
		return hrnk_menu_cd;
	}
	public void setHrnk_menu_cd(String hrnk_menu_cd) {
		this.hrnk_menu_cd = hrnk_menu_cd;
	}
	public String getLvl() {
		return lvl;
	}
	public void setLvl(String lvl) {
		this.lvl = lvl;
	}
	public String getPrgr_cd() {
		return prgr_cd;
	}
	public void setPrgr_cd(String prgr_cd) {
		this.prgr_cd = prgr_cd;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
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
	public String getAthr_lv() {
		return athr_lv;
	}
	public void setAthr_lv(String athr_lv) {
		this.athr_lv = athr_lv;
	}
	public String getSys_dvs_nm() {
		return sys_dvs_nm;
	}
	public void setSys_dvs_nm(String sys_dvs_nm) {
		this.sys_dvs_nm = sys_dvs_nm;
	}
	public String getBbs_type_cd() {
		return bbs_type_cd;
	}
	public void setBbs_type_cd(String bbs_type_cd) {
		this.bbs_type_cd = bbs_type_cd;
	}
	public String getMapping_yn() {
		return mapping_yn;
	}
	public void setMapping_yn(String mapping_yn) {
		this.mapping_yn = mapping_yn;
	}
	public String getMapping_nm() {
		return mapping_nm;
	}
	public void setMapping_nm(String mapping_nm) {
		this.mapping_nm = mapping_nm;
	}
	public String getTitl() {
		return titl;
	}
	public void setTitl(String titl) {
		this.titl = titl;
	}
	public String getBdt() {
		return bdt;
	}
	public void setBdt(String bdt) {
		this.bdt = bdt;
	}
	public String getLogic_file_nm() {
		return logic_file_nm;
	}
	public void setLogic_file_nm(String logic_file_nm) {
		this.logic_file_nm = logic_file_nm;
	}
	public String getChk() {
		return chk;
	}
	public void setChk(String chk) {
		this.chk = chk;
	}
	public String getNtctxt_no() {
		return ntctxt_no;
	}
	public void setNtctxt_no(String ntctxt_no) {
		this.ntctxt_no = ntctxt_no;
	}
	
	
}