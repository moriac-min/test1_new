package foodportal.front.safefoodlife.foodadditive.vo;

import org.apache.commons.lang.builder.ToStringBuilder;

public class FoodAdditiveRvlvSpiceVO {
	
	private int			ordno;
	private String		manage_no;
	private String		mttr_nm;
	private String		cfr_no;
	private String		jecfa_no;
	private String		fema_no;
	private String		eu_fl_no;
	private String		eu_chms_grp;
	private String		ncknm;
	
	private int			totalCount;
	
	private int			page;
	private int			startidx;
	private int			endidx;
	
	private String		page_gubun;
	private String 		procs_cl;
	
	private String		keyfield;
	private String		key;
	
	private String		startword;
	
	private long		rnum;
	
	public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

	public int getOrdno() {
		return ordno;
	}

	public void setOrdno(int ordno) {
		this.ordno = ordno;
	}

	public String getManage_no() {
		return manage_no;
	}

	public void setManage_no(String manage_no) {
		this.manage_no = manage_no;
	}

	public String getMttr_nm() {
		return mttr_nm;
	}

	public void setMttr_nm(String mttr_nm) {
		this.mttr_nm = mttr_nm;
	}

	public String getCfr_no() {
		return cfr_no;
	}

	public void setCfr_no(String cfr_no) {
		this.cfr_no = cfr_no;
	}

	public String getJecfa_no() {
		return jecfa_no;
	}

	public void setJecfa_no(String jecfa_no) {
		this.jecfa_no = jecfa_no;
	}

	public String getFema_no() {
		return fema_no;
	}

	public void setFema_no(String fema_no) {
		this.fema_no = fema_no;
	}

	public String getEu_fl_no() {
		return eu_fl_no;
	}

	public void setEu_fl_no(String eu_fl_no) {
		this.eu_fl_no = eu_fl_no;
	}

	public String getEu_chms_grp() {
		return eu_chms_grp;
	}

	public void setEu_chms_grp(String eu_chms_grp) {
		this.eu_chms_grp = eu_chms_grp;
	}

	public String getNcknm() {
		return ncknm;
	}

	public void setNcknm(String ncknm) {
		this.ncknm = ncknm;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getStartidx() {
		return startidx;
	}

	public void setStartidx(int startidx) {
		this.startidx = startidx;
	}

	public int getEndidx() {
		return endidx;
	}

	public void setEndidx(int endidx) {
		this.endidx = endidx;
	}

	public String getPage_gubun() {
		return page_gubun;
	}

	public void setPage_gubun(String page_gubun) {
		this.page_gubun = page_gubun;
	}

	public String getKeyfield() {
		return keyfield;
	}

	public void setKeyfield(String keyfield) {
		this.keyfield = keyfield;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getStartword() {
		return startword;
	}

	public void setStartword(String startword) {
		this.startword = startword;
	}

	public long getRnum() {
		return rnum;
	}

	public void setRnum(long rnum) {
		this.rnum = rnum;
	}

	public String getProcs_cl() {
		return procs_cl;
	}

	public void setProcs_cl(String procs_cl) {
		this.procs_cl = procs_cl;
	}
	
}