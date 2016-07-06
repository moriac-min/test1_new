package foodportal.front.fooddanger.vo;

/**
 * FoodDangerFileVO
 * @author 최승희
 * @since 2014.10.01
 * @version 1.0
 * @see
 * 
 * <pre>
 *  Modification Information
 *  수정일     수정자   수정내용
 *  ---------- -------- ---------------------------
 *  2014.10.01 최승희 	최초 생성
 * </pre>
 * 
 * Copyright (C) 2014 by NDS., All right reserved.
 */
public class FoodDangerFileVO {
	
	private String atch_seq;
	private String atch_file_no;			//검사부적합,허위과대광고
	private String file_seq;				//해외회수정보
	private String injry_esntl_no;			//해외회수정보
	private String report_no;				//검사부적합
	private String report_esntl_idntfc_no;	//허위과대광고
	private String filereg_seq;				//회수.판매중지(국내)
	private String sys_dvs_cd;
	private String file_mg;
	private String dir_path;
	private String logicl_file_nm ;
	private String physicl_file_nm;
	private String cretr_id;
	private String cret_dtm;
	private String last_updtr_id;
	private String last_updt_dtm;
	
	/*공통 첨부 파일*/
	private String atch_file_seq;			/*첨부 파일 일련번호*/
	private String file_save_path;			/*파일 저장 경로*/
	private String file_extns;				/*파일 확장자*/
	private String file_mg_lengt;			/*파일 크기 길이*/
	private String orgnt_file_nm;			/*원본 파일 명*/
    private String physic_file_nm;			/*물리 파일 명*/
    private String dwld_tmno; 				/*다운로드 횟수*/
    private String xml_yn;					/*xml여부*/
	
	public String getAtch_seq() {
		return atch_seq;
	}
	public void setAtch_seq(String atch_seq) {
		this.atch_seq = atch_seq;
	}
	public String getInjry_esntl_no() {
		return injry_esntl_no;
	}
	public void setInjry_esntl_no(String injry_esntl_no) {
		this.injry_esntl_no = injry_esntl_no;
	}
	public String getSys_dvs_cd() {
		return sys_dvs_cd;
	}
	public void setSys_dvs_cd(String sys_dvs_cd) {
		this.sys_dvs_cd = sys_dvs_cd;
	}
	public String getFile_seq() {
		return file_seq;
	}
	public void setFile_seq(String file_seq) {
		this.file_seq = file_seq;
	}
	public String getFile_mg() {
		return file_mg;
	}
	public void setFile_mg(String file_mg) {
		this.file_mg = file_mg;
	}
	public String getDir_path() {
		return dir_path;
	}
	public void setDir_path(String dir_path) {
		this.dir_path = dir_path;
	}
	public String getLogicl_file_nm() {
		return logicl_file_nm;
	}
	public void setLogicl_file_nm(String logicl_file_nm) {
		this.logicl_file_nm = logicl_file_nm;
	}
	public String getPhysicl_file_nm() {
		return physicl_file_nm;
	}
	public void setPhysicl_file_nm(String physicl_file_nm) {
		this.physicl_file_nm = physicl_file_nm;
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
	public String getReport_no() {
		return report_no;
	}
	public void setReport_no(String report_no) {
		this.report_no = report_no;
	}
	public String getReport_esntl_idntfc_no() {
		return report_esntl_idntfc_no;
	}
	public void setReport_esntl_idntfc_no(String report_esntl_idntfc_no) {
		this.report_esntl_idntfc_no = report_esntl_idntfc_no;
	}
	public String getAtch_file_no() {
		return atch_file_no;
	}
	public void setAtch_file_no(String atch_file_no) {
		this.atch_file_no = atch_file_no;
	}
	public String getAtch_file_seq() {
		return atch_file_seq;
	}
	public void setAtch_file_seq(String atch_file_seq) {
		this.atch_file_seq = atch_file_seq;
	}
	public String getFile_save_path() {
		return file_save_path;
	}
	public void setFile_save_path(String file_save_path) {
		this.file_save_path = file_save_path;
	}
	public String getFile_extns() {
		return file_extns;
	}
	public void setFile_extns(String file_extns) {
		this.file_extns = file_extns;
	}
	public String getFile_mg_lengt() {
		return file_mg_lengt;
	}
	public void setFile_mg_lengt(String file_mg_lengt) {
		this.file_mg_lengt = file_mg_lengt;
	}
	public String getOrgnt_file_nm() {
		return orgnt_file_nm;
	}
	public void setOrgnt_file_nm(String orgnt_file_nm) {
		this.orgnt_file_nm = orgnt_file_nm;
	}
	public String getPhysic_file_nm() {
		return physic_file_nm;
	}
	public void setPhysic_file_nm(String physic_file_nm) {
		this.physic_file_nm = physic_file_nm;
	}
	public String getDwld_tmno() {
		return dwld_tmno;
	}
	public void setDwld_tmno(String dwld_tmno) {
		this.dwld_tmno = dwld_tmno;
	}
	public String getXml_yn() {
		return xml_yn;
	}
	public void setXml_yn(String xml_yn) {
		this.xml_yn = xml_yn;
	}
	public String getFilereg_seq() {
		return filereg_seq;
	}
	public void setFilereg_seq(String filereg_seq) {
		this.filereg_seq = filereg_seq;
	}
	
}
