package foodportal.admin.systemmngt.vo;

import java.util.List;

import common.commonfacillity.uia.WqBaseBean;

public class UserCategorySettingVO extends WqBaseBean{

	private String user_id;			
	private String user_nm;			
	private String instt_cd;		//기관
	private String onnr_dept_cd;	//부서
	private String ptcs_nm;			//직급
	private String pstofc_nm;		//직책
	private String bbs_no;
	
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getUser_nm() {
		return user_nm;
	}
	public void setUser_nm(String user_nm) {
		this.user_nm = user_nm;
	}
	public String getInstt_cd() {
		return instt_cd;
	}
	public void setInstt_cd(String instt_cd) {
		this.instt_cd = instt_cd;
	}
	public String getOnnr_dept_cd() {
		return onnr_dept_cd;
	}
	public void setOnnr_dept_cd(String onnr_dept_cd) {
		this.onnr_dept_cd = onnr_dept_cd;
	}
	public String getPtcs_nm() {
		return ptcs_nm;
	}
	public void setPtcs_nm(String ptcs_nm) {
		this.ptcs_nm = ptcs_nm;
	}
	public String getPstofc_nm() {
		return pstofc_nm;
	}
	public void setPstofc_nm(String pstofc_nm) {
		this.pstofc_nm = pstofc_nm;
	}
	public String getBbs_no() {
		return bbs_no;
	}
	public void setBbs_no(String bbs_no) {
		this.bbs_no = bbs_no;
	}
	
	
	
}