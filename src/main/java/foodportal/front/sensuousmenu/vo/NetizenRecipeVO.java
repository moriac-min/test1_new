package foodportal.front.sensuousmenu.vo;

import java.sql.Date;

public class NetizenRecipeVO{

	private int neti_rcp_no;
	private String neti_rcp_atch_file_no;
	private String neti_rcp_cook_nm;
	private String neti_rcp_cook_thma;
	private String neti_rcp_cook_mate;
	private String neti_rcp_saus;
	private String neti_rcp_cn;
	private String neti_rcp_tag;
	private String neti_rcp_mber_no;
	private int neti_rcp_srcnt;
	private int neti_rcp_reccnt;
	private String neti_rcp_del_yn;
	private String neti_rcp_del_prvns;
	private String neti_rcp_filenm;
	private String rm;
	private String cretr_id;
	private String cret_dtm;
	private String last_updtr_id;
	private String last_updt_dtm;
	private String dtm;
	
	private String best_rcp_no;
	private String best_rcp_cnt;
	private String best_rcp_year;
	private String best_rcp_mm;
	private String best_rcp_atch_file_no;
	private String best_rcp_use_yn;

	//파일업로드
	private String logic_file_nm;
	private String file_type_cd;
	private String file_path;
	private String physic_file_nm;
	private String file_mg;
	private String file_yn;
	private String atch_file_no;
	private String rprsnt_img_yn;	//대표이미지여부
	
	//구분코드
	private String type_cd;
	
	
	public int getNeti_rcp_no() {
		return neti_rcp_no;
	}
	public void setNeti_rcp_no(int neti_rcp_no) {
		this.neti_rcp_no = neti_rcp_no;
	}
	public String getNeti_rcp_atch_file_no() {
		return neti_rcp_atch_file_no;
	}
	public void setNeti_rcp_atch_file_no(String neti_rcp_atch_file_no) {
		this.neti_rcp_atch_file_no = neti_rcp_atch_file_no;
	}
	public String getNeti_rcp_cook_nm() {
		return neti_rcp_cook_nm;
	}
	public void setNeti_rcp_cook_nm(String neti_rcp_cook_nm) {
		this.neti_rcp_cook_nm = neti_rcp_cook_nm;
	}
	public String getNeti_rcp_cook_thma() {
		return neti_rcp_cook_thma;
	}
	public void setNeti_rcp_cook_thma(String neti_rcp_cook_thma) {
		this.neti_rcp_cook_thma = neti_rcp_cook_thma;
	}
	public String getNeti_rcp_cook_mate() {
		return neti_rcp_cook_mate;
	}
	public void setNeti_rcp_cook_mate(String neti_rcp_cook_mate) {
		this.neti_rcp_cook_mate = neti_rcp_cook_mate;
	}
	public String getNeti_rcp_saus() {
		return neti_rcp_saus;
	}
	public void setNeti_rcp_saus(String neti_rcp_saus) {
		this.neti_rcp_saus = neti_rcp_saus;
	}
	public String getNeti_rcp_cn() {
		return neti_rcp_cn;
	}
	public void setNeti_rcp_cn(String neti_rcp_cn) {
		this.neti_rcp_cn = neti_rcp_cn;
	}
	public String getNeti_rcp_tag() {
		return neti_rcp_tag;
	}
	public void setNeti_rcp_tag(String neti_rcp_tag) {
		this.neti_rcp_tag = neti_rcp_tag;
	}
	public String getNeti_rcp_mber_no() {
		return neti_rcp_mber_no;
	}
	public void setNeti_rcp_mber_no(String neti_rcp_mber_no) {
		this.neti_rcp_mber_no = neti_rcp_mber_no;
	}
	public int getNeti_rcp_srcnt() {
		return neti_rcp_srcnt;
	}
	public void setNeti_rcp_srcnt(int neti_rcp_srcnt) {
		this.neti_rcp_srcnt = neti_rcp_srcnt;
	}
	public int getNeti_rcp_reccnt() {
		return neti_rcp_reccnt;
	}
	public void setNeti_rcp_reccnt(int neti_rcp_reccnt) {
		this.neti_rcp_reccnt = neti_rcp_reccnt;
	}
	public String getNeti_rcp_del_yn() {
		return neti_rcp_del_yn;
	}
	public void setNeti_rcp_del_yn(String neti_rcp_del_yn) {
		this.neti_rcp_del_yn = neti_rcp_del_yn;
	}
	public String getNeti_rcp_del_prvns() {
		return neti_rcp_del_prvns;
	}
	public void setNeti_rcp_del_prvns(String neti_rcp_del_prvns) {
		this.neti_rcp_del_prvns = neti_rcp_del_prvns;
	}
	public String getNeti_rcp_filenm() {
		return neti_rcp_filenm;
	}
	public void setNeti_rcp_filenm(String neti_rcp_filenm) {
		this.neti_rcp_filenm = neti_rcp_filenm;
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
	public String getCret_dtm() {
		return cret_dtm;
	}
	public void setCret_dtm(String cret_dtm) {
		this.cret_dtm = cret_dtm;
	}
	public String getLast_updtr_id() {
		return last_updtr_id;
	}
	public void setLast_updtr_id(String last_updtr_id) {
		this.last_updtr_id = last_updtr_id;
	}
	public String getLast_updt_dtm() {
		return last_updt_dtm;
	}
	public void setLast_updt_dtm(String last_updt_dtm) {
		this.last_updt_dtm = last_updt_dtm;
	}
	public String getDtm() {
		return dtm;
	}
	public void setDtm(String dtm) {
		this.dtm = dtm;
	}
	public String getBest_rcp_no() {
		return best_rcp_no;
	}
	public void setBest_rcp_no(String best_rcp_no) {
		this.best_rcp_no = best_rcp_no;
	}
	public String getBest_rcp_cnt() {
		return best_rcp_cnt;
	}
	public void setBest_rcp_cnt(String best_rcp_cnt) {
		this.best_rcp_cnt = best_rcp_cnt;
	}
	public String getBest_rcp_year() {
		return best_rcp_year;
	}
	public void setBest_rcp_year(String best_rcp_year) {
		this.best_rcp_year = best_rcp_year;
	}
	public String getBest_rcp_mm() {
		return best_rcp_mm;
	}
	public void setBest_rcp_mm(String best_rcp_mm) {
		this.best_rcp_mm = best_rcp_mm;
	}
	public String getBest_rcp_atch_file_no() {
		return best_rcp_atch_file_no;
	}
	public void setBest_rcp_atch_file_no(String best_rcp_atch_file_no) {
		this.best_rcp_atch_file_no = best_rcp_atch_file_no;
	}
	public String getBest_rcp_use_yn() {
		return best_rcp_use_yn;
	}
	public void setBest_rcp_use_yn(String best_rcp_use_yn) {
		this.best_rcp_use_yn = best_rcp_use_yn;
	}
	public String getLogic_file_nm() {
		return logic_file_nm;
	}
	public void setLogic_file_nm(String logic_file_nm) {
		this.logic_file_nm = logic_file_nm;
	}
	public String getFile_type_cd() {
		return file_type_cd;
	}
	public void setFile_type_cd(String file_type_cd) {
		this.file_type_cd = file_type_cd;
	}
	public String getFile_path() {
		return file_path;
	}
	public void setFile_path(String file_path) {
		this.file_path = file_path;
	}
	public String getPhysic_file_nm() {
		return physic_file_nm;
	}
	public void setPhysic_file_nm(String physic_file_nm) {
		this.physic_file_nm = physic_file_nm;
	}
	public String getFile_mg() {
		return file_mg;
	}
	public void setFile_mg(String file_mg) {
		this.file_mg = file_mg;
	}
	public String getFile_yn() {
		return file_yn;
	}
	public void setFile_yn(String file_yn) {
		this.file_yn = file_yn;
	}
	public String getAtch_file_no() {
		return atch_file_no;
	}
	public void setAtch_file_no(String atch_file_no) {
		this.atch_file_no = atch_file_no;
	}
	public String getRprsnt_img_yn() {
		return rprsnt_img_yn;
	}
	public void setRprsnt_img_yn(String rprsnt_img_yn) {
		this.rprsnt_img_yn = rprsnt_img_yn;
	}
	public String getType_cd() {
		return type_cd;
	}
	public void setType_cd(String type_cd) {
		this.type_cd = type_cd;
	}


}