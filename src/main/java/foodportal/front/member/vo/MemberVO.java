package foodportal.front.member.vo;

import java.util.Date;

import org.apache.commons.lang.builder.ToStringBuilder;

import abc.cms.model.Login;
import common.commonfacillity.uia.WqBaseBean;

public class MemberVO extends WqBaseBean implements Login {
	
	private static final long serialVersionUID = 1L;
	
	private String mber_no;
	private String id;
	private String password;
	private String name;
	private String addrpapr_dvs_cd;
	private String roadnm_dvs_cd;
	private String post_no;
	private String addr;
	private String lnbr;
	private String email_addr;
	private String mbtpn_no;
	private String tel_no;
	private String ltly_srchfish_save_yn;
	private String srchfish_auto_comp_yn;
	private String vrsc_entrps_dvs_cd;
	private String vrsc_entrps_nm;
	private String mber_stats_cd;
	private java.sql.Date drpot_dt;
	private String drpot_prvns;
	private String indvlidntfcno;
	private String dplctsbscrbcnfmcd;
	private String brthdy;
	private String gnd;
	private String crtfcdnno;
	private String uncnvrs_mber_yn;
	private String rm;
	private String cretr_id;
	private java.sql.Date cret_dtm;
	private String last_updtr_id;
	private java.sql.Date last_updt_dtm;
	
	private String gnd_nm;
	private String crtfcdnno_nm;
	private String mber_stats_cd_nm;
	
	private String mber_type;
	
	private String search_type;
	private String search_word;
	
	private String policy_type;
	private String bdt;

	/** 로그인한 일시 */
	private Date loginDate;

    /** 로그인한 사용자의 IP 주소 */
    private String loginIp;
    
    private String redirect;
	
	public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

	public String getMber_no() {
		return mber_no;
	}

	public void setMber_no(String mber_no) {
		this.mber_no = mber_no;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddrpapr_dvs_cd() {
		return addrpapr_dvs_cd;
	}

	public void setAddrpapr_dvs_cd(String addrpapr_dvs_cd) {
		this.addrpapr_dvs_cd = addrpapr_dvs_cd;
	}

	public String getRoadnm_dvs_cd() {
		return roadnm_dvs_cd;
	}

	public void setRoadnm_dvs_cd(String roadnm_dvs_cd) {
		this.roadnm_dvs_cd = roadnm_dvs_cd;
	}

	public String getPost_no() {
		return post_no;
	}

	public void setPost_no(String post_no) {
		this.post_no = post_no;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public String getLnbr() {
		return lnbr;
	}

	public void setLnbr(String lnbr) {
		this.lnbr = lnbr;
	}

	public String getEmail_addr() {
		return email_addr;
	}

	public void setEmail_addr(String email_addr) {
		this.email_addr = email_addr;
	}

	public String getMbtpn_no() {
		return mbtpn_no;
	}

	public void setMbtpn_no(String mbtpn_no) {
		this.mbtpn_no = mbtpn_no;
	}

	public String getTel_no() {
		return tel_no;
	}

	public void setTel_no(String tel_no) {
		this.tel_no = tel_no;
	}

	public String getLtly_srchfish_save_yn() {
		return ltly_srchfish_save_yn;
	}

	public void setLtly_srchfish_save_yn(String ltly_srchfish_save_yn) {
		this.ltly_srchfish_save_yn = ltly_srchfish_save_yn;
	}

	public String getSrchfish_auto_comp_yn() {
		return srchfish_auto_comp_yn;
	}

	public void setSrchfish_auto_comp_yn(String srchfish_auto_comp_yn) {
		this.srchfish_auto_comp_yn = srchfish_auto_comp_yn;
	}

	public String getVrsc_entrps_dvs_cd() {
		return vrsc_entrps_dvs_cd;
	}

	public void setVrsc_entrps_dvs_cd(String vrsc_entrps_dvs_cd) {
		this.vrsc_entrps_dvs_cd = vrsc_entrps_dvs_cd;
	}

	public String getVrsc_entrps_nm() {
		return vrsc_entrps_nm;
	}

	public void setVrsc_entrps_nm(String vrsc_entrps_nm) {
		this.vrsc_entrps_nm = vrsc_entrps_nm;
	}

	public String getMber_stats_cd() {
		return mber_stats_cd;
	}

	public void setMber_stats_cd(String mber_stats_cd) {
		this.mber_stats_cd = mber_stats_cd;
	}

	public java.sql.Date getDrpot_dt() {
		return drpot_dt;
	}

	public void setDrpot_dt(java.sql.Date drpot_dt) {
		this.drpot_dt = drpot_dt;
	}

	public String getDrpot_prvns() {
		return drpot_prvns;
	}

	public void setDrpot_prvns(String drpot_prvns) {
		this.drpot_prvns = drpot_prvns;
	}

	public String getIndvlidntfcno() {
		return indvlidntfcno;
	}

	public void setIndvlidntfcno(String indvlidntfcno) {
		this.indvlidntfcno = indvlidntfcno;
	}

	public String getDplctsbscrbcnfmcd() {
		return dplctsbscrbcnfmcd;
	}

	public void setDplctsbscrbcnfmcd(String dplctsbscrbcnfmcd) {
		this.dplctsbscrbcnfmcd = dplctsbscrbcnfmcd;
	}

	public String getBrthdy() {
		return brthdy;
	}

	public void setBrthdy(String brthdy) {
		this.brthdy = brthdy;
	}

	public String getGnd() {
		return gnd;
	}

	public void setGnd(String gnd) {
		this.gnd = gnd;
	}

	public String getCrtfcdnno() {
		return crtfcdnno;
	}

	public void setCrtfcdnno(String crtfcdnno) {
		this.crtfcdnno = crtfcdnno;
	}

	public String getUncnvrs_mber_yn() {
		return uncnvrs_mber_yn;
	}

	public void setUncnvrs_mber_yn(String uncnvrs_mber_yn) {
		this.uncnvrs_mber_yn = uncnvrs_mber_yn;
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

	public String getMber_type() {
		return mber_type;
	}

	public void setMber_type(String mber_type) {
		this.mber_type = mber_type;
	}

	public String getGnd_nm() {
		return gnd_nm;
	}

	public void setGnd_nm(String gnd_nm) {
		this.gnd_nm = gnd_nm;
	}

	public String getCrtfcdnno_nm() {
		return crtfcdnno_nm;
	}

	public void setCrtfcdnno_nm(String crtfcdnno_nm) {
		this.crtfcdnno_nm = crtfcdnno_nm;
	}

	public String getMber_stats_cd_nm() {
		return mber_stats_cd_nm;
	}

	public void setMber_stats_cd_nm(String mber_stats_cd_nm) {
		this.mber_stats_cd_nm = mber_stats_cd_nm;
	}

	public String getSearch_type() {
		return search_type;
	}

	public void setSearch_type(String search_type) {
		this.search_type = search_type;
	}

	public String getSearch_word() {
		return search_word;
	}

	public void setSearch_word(String search_word) {
		this.search_word = search_word;
	}

	public String getPolicy_type() {
		return policy_type;
	}

	public void setPolicy_type(String policy_type) {
		this.policy_type = policy_type;
	}

	public String getBdt() {
		return bdt;
	}

	public void setBdt(String bdt) {
		this.bdt = bdt;
	}

	public Date getLoginDate() {
		return loginDate;
	}

	public void setLoginDate(Date loginDate) {
		this.loginDate = loginDate;
	}

	public String getLoginIp() {
		return loginIp;
	}

	public void setLoginIp(String loginIp) {
		this.loginIp = loginIp;
	}

	public String getRedirect() {
		return redirect;
	}

	public void setRedirect(String redirect) {
		this.redirect = redirect;
	}
	
}