package foodportal.minwon.complain.vo;

public class MakerVO {

	private String seq_no;						//영업 인허가 대장 번호
	private String bssh_nm;					//업소 명
	private String telno;						//전화번호
	private String zipno;						//우편번호
	private String addr;							//주소
	private String addr_dtl;					//주소 상세
	
	public String getSeq_no() {
		return seq_no;
	}
	public void setSeq_no(String seq_no) {
		this.seq_no = seq_no;
	}
	public String getBssh_nm() {
		return bssh_nm;
	}
	public void setBssh_nm(String bssh_nm) {
		this.bssh_nm = bssh_nm;
	}
	public String getTelno() {
		return telno;
	}
	public void setTelno(String telno) {
		this.telno = telno;
	}
	public String getZipno() {
		return zipno;
	}
	public void setZipno(String zipno) {
		this.zipno = zipno;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public String getAddr_dtl() {
		return addr_dtl;
	}
	public void setAddr_dtl(String addr_dtl) {
		this.addr_dtl = addr_dtl;
	}
	
}