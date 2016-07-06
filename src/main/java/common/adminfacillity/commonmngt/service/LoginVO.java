package common.adminfacillity.commonmngt.service;

import java.io.Serializable;

import org.apache.commons.lang.builder.ToStringBuilder;

@SuppressWarnings("serial")
public class LoginVO implements Serializable {
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
	
	/** 비밀번호 */
	private String password;
	
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
	
	public String getSabun() {
		return sabun;
	}

	public void setSabun(String sabun) {
		this.sabun = sabun;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }	
}
