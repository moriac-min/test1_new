package foodportal.front.safefoodlife.foodMeterial.vo;

import java.sql.Date;

import org.apache.commons.lang.builder.ToStringBuilder;

public class FoodMeterialEdibleVO {
	
	private int			indx;
	private String		regn_cd;
	private int			sort_ord;
	private String		edible;
	private String		cdx;
	private String		basis;
	private String		cretr_id;
	private Date		cret_dtm;
	private String		last_updtr_id;
	private Date		last_updt_dtm;
	
	private String		regn_nm;
	
	public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

	public int getIndx() {
		return indx;
	}

	public void setIndx(int indx) {
		this.indx = indx;
	}

	public String getRegn_cd() {
		return regn_cd;
	}

	public void setRegn_cd(String regn_cd) {
		this.regn_cd = regn_cd;
	}

	public int getSort_ord() {
		return sort_ord;
	}

	public void setSort_ord(int sort_ord) {
		this.sort_ord = sort_ord;
	}

	public String getEdible() {
		return edible;
	}

	public void setEdible(String edible) {
		this.edible = edible;
	}

	public String getCdx() {
		return cdx;
	}

	public void setCdx(String cdx) {
		this.cdx = cdx;
	}

	public String getBasis() {
		return basis;
	}

	public void setBasis(String basis) {
		this.basis = basis;
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

	public String getRegn_nm() {
		return regn_nm;
	}

	public void setRegn_nm(String regn_nm) {
		this.regn_nm = regn_nm;
	}
	
}