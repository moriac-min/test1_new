package foodportal.api.vo;

public class UploadFileVO{
	
	private String svc_no;		//게시글번호
	private String atch_file_no;	//첨부파일번호
	private String file_dvs;	//대표이미지여부
	private String file_type_cd;	//파일유형코드
	private String file_path;		//파일경로
	private String logic_file_nm;	//논리파일명
	private String physic_file_nm;	//물리파일명
	private String file_mg;			//파일크기
	
	private String cretr_id;			//생성자 아이디
	private String cret_dtm;			//생성일시
	private String last_updtr_id;		//수정자 아이디
	private String last_updt_dtm;		//수정일시
	

	public String getAtch_file_no() {
		return atch_file_no;
	}

	public void setAtch_file_no(String atch_file_no) {
		this.atch_file_no = atch_file_no;
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

	public String getLogic_file_nm() {
		return logic_file_nm;
	}

	public void setLogic_file_nm(String logic_file_nm) {
		this.logic_file_nm = logic_file_nm;
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

	public String getSvc_no() {
		return svc_no;
	}

	public void setSvc_no(String svc_no) {
		this.svc_no = svc_no;
	}

	public String getFile_dvs() {
		return file_dvs;
	}

	public void setFile_dvs(String file_dvs) {
		this.file_dvs = file_dvs;
	}

	
}