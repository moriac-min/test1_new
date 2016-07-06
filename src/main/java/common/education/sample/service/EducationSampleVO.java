package common.education.sample.service;

import java.io.Serializable;

import org.apache.commons.lang.builder.ToStringBuilder;

import common.commonfacillity.uia.WqBaseBean;

public class EducationSampleVO extends WqBaseBean {
	/** 공통 조건 */
	/** 쿼리정렬 */
	private String orderBy;
	
	/** 날짜검색조건1 */
    private String frdt;
    
    /** 날짜검색조건2 */
    private String todt;
    
    /** 삭제여부 */
	private int delyn;
	
	/** 검색조건 */
    private String searchCondition = "";
    
    /** 검색Keyword */
    private String searchKeyword = "";
    /** 공통 조건 종료 */
    
	/** 사번 */
	private String sabun;
	
	/** 성명 */
	private String name;
	
	/** 부서 */
	private String dept;
	
	/** 입사일 */
	private String ipsa_date;
	
	/** 성별 */
	private String sex;
	
	/** 결혼유무 */
	private String marry;
	
	/** 월급 */
	private long salary;
	
	/** 비고 */
	private String smemo;
	
	/** 첨부파일ID */
	private String atchfileid;

	/** 임시첨부파일ID */
	private String tempatchfileid;
	
	/** 삭제첨부파일정보 */
	private String delfileinfo;
    
    /** 등록 수정 여부 */
    private String registerKey;

	public String getOrderBy() {
		return orderBy;
	}

	public void setOrderBy(String orderBy) {
		this.orderBy = orderBy;
	}
	
	public String getFrdt() {
		return frdt;
	}

	public void setFrdt(String frdt) {
		this.frdt = frdt;
	}

	public String getTodt() {
		return todt;
	}

	public void setTodt(String todt) {
		this.todt = todt;
	}
	
	public String getSabun() {
		return sabun;
	}

	public void setSabun(String sabun) {
		this.sabun = sabun;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	public String getIpsa_date() {
		return ipsa_date;
	}

	public void setIpsa_date(String ipsa_date) {
		this.ipsa_date = ipsa_date;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getMarry() {
		return marry;
	}

	public void setMarry(String marry) {
		this.marry = marry;
	}

	public long getSalary() {
		return salary;
	}

	public void setSalary(long salary) {
		this.salary = salary;
	}

	public String getSmemo() {
		return smemo;
	}

	public void setSmemo(String smemo) {
		this.smemo = smemo;
	}

	public String getAtchfileid() {
		return atchfileid;
	}

	public void setAtchfileid(String atchfileid) {
		this.atchfileid = atchfileid;
	}

	public String getTempatchfileid() {
		return tempatchfileid;
	}

	public void setTempatchfileid(String tempatchfileid) {
		this.tempatchfileid = tempatchfileid;
	}

	public String getDelfileinfo() {
		return delfileinfo;
	}

	public void setDelfileinfo(String delfileinfo) {
		this.delfileinfo = delfileinfo;
	}

	public int getDelyn() {
		return delyn;
	}

	public void setDelyn(int delyn) {
		this.delyn = delyn;
	}
	
	public String getSearchCondition() {
		return searchCondition;
	}

	public void setSearchCondition(String searchCondition) {
		this.searchCondition = searchCondition;
	}

	public String getSearchKeyword() {
		return searchKeyword;
	}

	public void setSearchKeyword(String searchKeyword) {
		this.searchKeyword = searchKeyword;
	}
	
	public String getRegisterKey() {
		return registerKey;
	}

	public void setRegisterKey(String registerKey) {
		this.registerKey = registerKey;
	}
	
	public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
