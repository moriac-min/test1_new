package foodportal.front.safefoodlife.food.vo;

import java.math.BigDecimal;
import java.sql.Date;

import org.apache.commons.lang.builder.ToStringBuilder;

public class FoodRvlvVO {
	
	private String		rvlv_no;
	private String		hrnk_no;
	private String		titl;
	private String		cn;
	private String		pge_no;
	private BigDecimal	sort_ord;
	private String		use_yn;
	private String		etc1;
	private String		etc2;
	private String		etc3;
	private String		etc4;
	private String		etc5;
	private String		rm;
	private String		cretr_id;
	private Date		cret_dtm;
	private String		last_updtr_id;
	private Date		last_updt_dtm;
	
	private String		search_word;
	
	public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

	public String getRvlv_no() {
		return rvlv_no;
	}

	public void setRvlv_no(String rvlv_no) {
		this.rvlv_no = rvlv_no;
	}

	public String getHrnk_no() {
		return hrnk_no;
	}

	public void setHrnk_no(String hrnk_no) {
		this.hrnk_no = hrnk_no;
	}

	public String getTitl() {
		return titl;
	}

	public void setTitl(String titl) {
		this.titl = titl;
	}

	public String getCn() {
		return cn;
	}

	public void setCn(String cn) {
		this.cn = cn;
	}

	public String getPge_no() {
		return pge_no;
	}

	public void setPge_no(String pge_no) {
		this.pge_no = pge_no;
	}

	public BigDecimal getSort_ord() {
		return sort_ord;
	}

	public void setSort_ord(BigDecimal sort_ord) {
		this.sort_ord = sort_ord;
	}

	public String getUse_yn() {
		return use_yn;
	}

	public void setUse_yn(String use_yn) {
		this.use_yn = use_yn;
	}

	public String getEtc1() {
		return etc1;
	}

	public void setEtc1(String etc1) {
		this.etc1 = etc1;
	}

	public String getEtc2() {
		return etc2;
	}

	public void setEtc2(String etc2) {
		this.etc2 = etc2;
	}

	public String getEtc3() {
		return etc3;
	}

	public void setEtc3(String etc3) {
		this.etc3 = etc3;
	}

	public String getEtc4() {
		return etc4;
	}

	public void setEtc4(String etc4) {
		this.etc4 = etc4;
	}

	public String getEtc5() {
		return etc5;
	}

	public void setEtc5(String etc5) {
		this.etc5 = etc5;
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

	public Date getCret_dtm() {
		return cret_dtm;
	}

	public void setCret_dtm(Date cret_dtm) {
		this.cret_dtm = cret_dtm;
	}

	public String getLast_updtr_id() {
		return last_updtr_id;
	}

	public void setLast_updtr_id(String last_updtr_id) {
		this.last_updtr_id = last_updtr_id;
	}

	public Date getLast_updt_dtm() {
		return last_updt_dtm;
	}

	public void setLast_updt_dtm(Date last_updt_dtm) {
		this.last_updt_dtm = last_updt_dtm;
	}

	public String getSearch_word() {
		return search_word;
	}

	public void setSearch_word(String search_word) {
		this.search_word = search_word;
	}
	
}