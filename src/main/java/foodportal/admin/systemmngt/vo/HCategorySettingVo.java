package foodportal.admin.systemmngt.vo;

import org.apache.commons.lang.builder.ToStringBuilder;
import common.commonfacillity.uia.WqBaseBean;

public class HCategorySettingVo extends WqBaseBean{
	
	private String ctgry_no;		//카테고리_번호
	private String hrnk_ctgryno;	//상위_카테고리번호
	private String bbs_no;			//게시판_번호
	private String ctgrynm;			//카테고리명
	private String sort_ord;		//정렬_순서
	private String del_yn;			//삭제_여부
	private String rm;				//비고
	private String cretr_id;
	private java.sql.Date cret_dtm;
	private String last_updtr_id;
	private java.sql.Date last_updt_dtm;
	
	/***************************담당자별 카테고리 맵핑 화면용*************************/
	private String hrnk_ctgrynm;			//상위카테고리명
	private String chk;				//체크박스
	private String user_id;
	
	public String getCtgry_no() {
		return ctgry_no;
	}

	public void setCtgry_no(String ctgry_no) {
		this.ctgry_no = ctgry_no;
	}

	public String getHrnk_ctgryno() {
		return hrnk_ctgryno;
	}

	public void setHrnk_ctgryno(String hrnk_ctgryno) {
		this.hrnk_ctgryno = hrnk_ctgryno;
	}

	public String getBbs_no() {
		return bbs_no;
	}

	public void setBbs_no(String bbs_no) {
		this.bbs_no = bbs_no;
	}

	public String getCtgrynm() {
		return ctgrynm;
	}

	public void setCtgrynm(String ctgrynm) {
		this.ctgrynm = ctgrynm;
	}

	public String getSort_ord() {
		return sort_ord;
	}

	public void setSort_ord(String sort_ord) {
		this.sort_ord = sort_ord;
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
	
	public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

	public String getHrnk_ctgrynm() {
		return hrnk_ctgrynm;
	}

	public void setHrnk_ctgrynm(String hrnk_ctgrynm) {
		this.hrnk_ctgrynm = hrnk_ctgrynm;
	}

	public String getChk() {
		return chk;
	}

	public void setChk(String chk) {
		this.chk = chk;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	
	
}
