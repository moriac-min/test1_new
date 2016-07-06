package foodportal.minwon.complain.vo;

public class ComplainReplyVO {
	
	private String progess_num;		//순번
	private String hist_cn;				//이력 내용
	private String reg_dtm;			//등록 일시
	private String dept_cd;			//부서코드
	
	public String getHist_cn() {
		return hist_cn;
	}
	public void setHist_cn(String hist_cn) {
		this.hist_cn = hist_cn;
	}
	public String getReg_dtm() {
		return reg_dtm;
	}
	public void setReg_dtm(String reg_dtm) {
		this.reg_dtm = reg_dtm;
	}
	public String getDept_cd() {
		return dept_cd;
	}
	public void setDept_cd(String dept_cd) {
		this.dept_cd = dept_cd;
	}
	public String getProgess_num() {
		return progess_num;
	}
	public void setProgess_num(String progess_num) {
		this.progess_num = progess_num;
	}

}