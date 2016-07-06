package foodportal.admin.systemmngt.vo;


public class IssueVO {
	//이슈코드
	private String issue_cd;
	private String issue_nm;
	
	//이슈발생시 정보
	private String envrn_setup_no;		//환경설정 게시판 번호
	private String issue_occrnc_yn;		//이슈 발생 여부
	private String bbs_no;					//게시판_번호
	private String bbs_type_cd;			//게시판코드
	private String bbs_nm;					//게시판_명(이슈발생시_관리)
	private String ntctxt_no;				//게시판_유형_코드
	private String titl;						//게시판_명
	private String clmn01;					//이슈 타입 - F(FRAME), B(BANNER)
	private String clmn02;					//url
	private String clmn03;					//새창에서 열기(banner에서만 사용)
	private String clmn04;					//팝업으로 열기(banner에서만 사용)
	private String outpt_type_cd;		//F(프레임), N(새창), S(현재창), P(팝업)
	private String outpt_wdt;				//너비
	private String outpt_hg;				//높이
	private String outpt_f_hg;			//높이(프레임용)
	private String outpt_b_hg;			//높이(배너용)
	private String atch_file_no;			//첨부파일 번호
	private String file_type_cd;			//첨부파일 타입
	private String file_path;				//첨부파일 경로
	private String logic_file_nm;			//논리파일명
	private String physic_file_nm;		//물리파일명
	private String file_mg;					//파일크기
	private String del_yn;					//삭제여부
	private String file_yn;					//파일첨부 여부
	private String rm;						//비고
	private String cretr_id;					//등록자
	private String cret_dtm;				//등록일
	private String last_updtr_id;			//수정자
	private String last_updt_dtm;		//수정일
	
	public String getIssue_cd() {
		return issue_cd;
	}
	public void setIssue_cd(String issue_cd) {
		this.issue_cd = issue_cd;
	}
	public String getIssue_nm() {
		return issue_nm;
	}
	public void setIssue_nm(String issue_nm) {
		this.issue_nm = issue_nm;
	}
	public String getBbs_no() {
		return bbs_no;
	}
	public void setBbs_no(String bbs_no) {
		this.bbs_no = bbs_no;
	}
	public String getBbs_type_cd() {
		return bbs_type_cd;
	}
	public void setBbs_type_cd(String bbs_type_cd) {
		this.bbs_type_cd = bbs_type_cd;
	}
	public String getBbs_nm() {
		return bbs_nm;
	}
	public void setBbs_nm(String bbs_nm) {
		this.bbs_nm = bbs_nm;
	}
	public String getNtctxt_no() {
		return ntctxt_no;
	}
	public void setNtctxt_no(String ntctxt_no) {
		this.ntctxt_no = ntctxt_no;
	}
	public String getTitl() {
		return titl;
	}
	public void setTitl(String titl) {
		this.titl = titl;
	}
	public String getClmn01() {
		return clmn01;
	}
	public void setClmn01(String clmn01) {
		this.clmn01 = clmn01;
	}
	public String getClmn02() {
		return clmn02;
	}
	public void setClmn02(String clmn02) {
		this.clmn02 = clmn02;
	}
	public String getClmn03() {
		return clmn03;
	}
	public void setClmn03(String clmn03) {
		this.clmn03 = clmn03;
	}
	public String getClmn04() {
		return clmn04;
	}
	public void setClmn04(String clmn04) {
		this.clmn04 = clmn04;
	}
	public String getOutpt_type_cd() {
		return outpt_type_cd;
	}
	public void setOutpt_type_cd(String outpt_type_cd) {
		this.outpt_type_cd = outpt_type_cd;
	}
	public String getOutpt_wdt() {
		return outpt_wdt;
	}
	public void setOutpt_wdt(String outpt_wdt) {
		this.outpt_wdt = outpt_wdt;
	}
	public String getOutpt_hg() {
		return outpt_hg;
	}
	public void setOutpt_hg(String outpt_hg) {
		this.outpt_hg = outpt_hg;
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
	public String getEnvrn_setup_no() {
		return envrn_setup_no;
	}
	public void setEnvrn_setup_no(String envrn_setup_no) {
		this.envrn_setup_no = envrn_setup_no;
	}
	public String getIssue_occrnc_yn() {
		return issue_occrnc_yn;
	}
	public void setIssue_occrnc_yn(String issue_occrnc_yn) {
		this.issue_occrnc_yn = issue_occrnc_yn;
	}
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
	public String getFile_path() {
		return file_path;
	}
	public void setFile_path(String file_path) {
		this.file_path = file_path;
	}
	public String getFile_yn() {
		return file_yn;
	}
	public void setFile_yn(String file_yn) {
		this.file_yn = file_yn;
	}
	public String getOutpt_f_hg() {
		return outpt_f_hg;
	}
	public void setOutpt_f_hg(String outpt_f_hg) {
		this.outpt_f_hg = outpt_f_hg;
	}
	public String getOutpt_b_hg() {
		return outpt_b_hg;
	}
	public void setOutpt_b_hg(String outpt_b_hg) {
		this.outpt_b_hg = outpt_b_hg;
	}

}
