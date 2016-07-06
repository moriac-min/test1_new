package foodportal.front.fooddanger.vo;

public class CrackdownVO{
	
	private String aplc_seq;           // 신청번호
	private String entrps_bass_addr;   // 업체기본주소
	private String entrps_dtl_addr;    // 업체상세주소
	private String bsn_knd_nm;		   // 업종명
	private String entrps_nm;          // 업체명 
	private String prsdnt_nm;          // 대표자명 
	private String reglt_instt;        // 단속기관 
	private String reglt_instt_nm;     // 단속기관명 
	private String reglt_dt;           // 단속일 
	private String vilt_dtls;          // 위반내역 
	private String confm_instt_cd;     // 승인기관코드 
	private String confm_instt_nm;      // 승인기관명 
	private String confm_setle_dtm;     // 승인결제일시 
	private String publc_bgn_dt;       // 공표시작일자 
	private String publc_end_dt;       // 공표종료일자 
	private String lrscl_stor_nm;       // 대규모점표명 
	private String lrscl_stor_bass_addr;    // 대규모점포기본주소 
	private String lrscl_stor_dtl_addr;     // 대규모점포상세주소 
	private String lrscl_stor_yn;       // 대규모점포여부 
	private String real_dspsman_nm;    // 실제처분자명 
	private String pnish_dtls;         // 처벌내역 
	private String pnish_dtls_nm;      // 처벌내역명 
	private String vilt_cn;            // 위반내용 
	private String prdlst_ordno;		//품목순번
	private String prdlst_cd;          // 품목코드 
	private String prdlst_nm;          // 품목명 
	private String new_yn;			//new 여부
	
	private String cretr_id;			//생성자 아이디
	private String cret_dtm;			//생성일시
	private String last_updtr_id;		//수정자 아이디
	private String last_updt_dtm;		//수정일시
	public String getAplc_seq() {
		return aplc_seq;
	}
	public void setAplc_seq(String aplc_seq) {
		this.aplc_seq = aplc_seq;
	}
	public String getEntrps_bass_addr() {
		return entrps_bass_addr;
	}
	public void setEntrps_bass_addr(String entrps_bass_addr) {
		this.entrps_bass_addr = entrps_bass_addr;
	}
	public String getEntrps_dtl_addr() {
		return entrps_dtl_addr;
	}
	public void setEntrps_dtl_addr(String entrps_dtl_addr) {
		this.entrps_dtl_addr = entrps_dtl_addr;
	}
	public String getEntrps_nm() {
		return entrps_nm;
	}
	public void setEntrps_nm(String entrps_nm) {
		this.entrps_nm = entrps_nm;
	}
	public String getPrsdnt_nm() {
		return prsdnt_nm;
	}
	public void setPrsdnt_nm(String prsdnt_nm) {
		this.prsdnt_nm = prsdnt_nm;
	}
	public String getReglt_instt() {
		return reglt_instt;
	}
	public void setReglt_instt(String reglt_instt) {
		this.reglt_instt = reglt_instt;
	}
	public String getReglt_instt_nm() {
		return reglt_instt_nm;
	}
	public void setReglt_instt_nm(String reglt_instt_nm) {
		this.reglt_instt_nm = reglt_instt_nm;
	}
	public String getReglt_dt() {
		return reglt_dt;
	}
	public void setReglt_dt(String reglt_dt) {
		this.reglt_dt = reglt_dt;
	}
	public String getVilt_dtls() {
		return vilt_dtls;
	}
	public void setVilt_dtls(String vilt_dtls) {
		this.vilt_dtls = vilt_dtls;
	}
	public String getConfm_instt_cd() {
		return confm_instt_cd;
	}
	public void setConfm_instt_cd(String confm_instt_cd) {
		this.confm_instt_cd = confm_instt_cd;
	}
	public String getConfm_instt_nm() {
		return confm_instt_nm;
	}
	public void setConfm_instt_nm(String confm_instt_nm) {
		this.confm_instt_nm = confm_instt_nm;
	}
	public String getConfm_setle_dtm() {
		return confm_setle_dtm;
	}
	public void setConfm_setle_dtm(String confm_setle_dtm) {
		this.confm_setle_dtm = confm_setle_dtm;
	}
	public String getPublc_bgn_dt() {
		return publc_bgn_dt;
	}
	public void setPublc_bgn_dt(String publc_bgn_dt) {
		this.publc_bgn_dt = publc_bgn_dt;
	}
	public String getPublc_end_dt() {
		return publc_end_dt;
	}
	public void setPublc_end_dt(String publc_end_dt) {
		this.publc_end_dt = publc_end_dt;
	}
	public String getLrscl_stor_nm() {
		return lrscl_stor_nm;
	}
	public void setLrscl_stor_nm(String lrscl_stor_nm) {
		this.lrscl_stor_nm = lrscl_stor_nm;
	}
	public String getLrscl_stor_bass_addr() {
		return lrscl_stor_bass_addr;
	}
	public void setLrscl_stor_bass_addr(String lrscl_stor_bass_addr) {
		this.lrscl_stor_bass_addr = lrscl_stor_bass_addr;
	}
	public String getLrscl_stor_dtl_addr() {
		return lrscl_stor_dtl_addr;
	}
	public void setLrscl_stor_dtl_addr(String lrscl_stor_dtl_addr) {
		this.lrscl_stor_dtl_addr = lrscl_stor_dtl_addr;
	}
	public String getLrscl_stor_yn() {
		return lrscl_stor_yn;
	}
	public void setLrscl_stor_yn(String lrscl_stor_yn) {
		this.lrscl_stor_yn = lrscl_stor_yn;
	}
	public String getReal_dspsman_nm() {
		return real_dspsman_nm;
	}
	public void setReal_dspsman_nm(String real_dspsman_nm) {
		this.real_dspsman_nm = real_dspsman_nm;
	}
	public String getPnish_dtls() {
		return pnish_dtls;
	}
	public void setPnish_dtls(String pnish_dtls) {
		this.pnish_dtls = pnish_dtls;
	}
	public String getPnish_dtls_nm() {
		return pnish_dtls_nm;
	}
	public void setPnish_dtls_nm(String pnish_dtls_nm) {
		this.pnish_dtls_nm = pnish_dtls_nm;
	}
	public String getVilt_cn() {
		return vilt_cn;
	}
	public void setVilt_cn(String vilt_cn) {
		this.vilt_cn = vilt_cn;
	}
	public String getPrdlst_cd() {
		return prdlst_cd;
	}
	public void setPrdlst_cd(String prdlst_cd) {
		this.prdlst_cd = prdlst_cd;
	}
	public String getPrdlst_nm() {
		return prdlst_nm;
	}
	public void setPrdlst_nm(String prdlst_nm) {
		this.prdlst_nm = prdlst_nm;
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
	public String getBsn_knd_nm() {
		return bsn_knd_nm;
	}
	public void setBsn_knd_nm(String bsn_knd_nm) {
		this.bsn_knd_nm = bsn_knd_nm;
	}
	public String getPrdlst_ordno() {
		return prdlst_ordno;
	}
	public void setPrdlst_ordno(String prdlst_ordno) {
		this.prdlst_ordno = prdlst_ordno;
	}
	public String getNew_yn() {
		return new_yn;
	}
	public void setNew_yn(String new_yn) {
		this.new_yn = new_yn;
	}
	
	

	
}