package common.adminfacillity.commonmngt.service;

import java.io.Serializable;

import org.apache.commons.lang.builder.ToStringBuilder;

@SuppressWarnings("serial")
public class BoardVO implements Serializable {
	/** 공통 조건 */
	/** 쿼리정렬 */
	private String orderBy;
	
	/** 날짜검색조건1 */
    private String frdt;
    
    /** 날짜검색조건2 */
    private String todt;
	
	/** 검색조건 */
    private String searchCondition = "";
    
    /** 검색Keyword */
    private String searchKeyword = "";
    
    /** 입력자 */
    private String cretr_id = "";
    
    /** 수정자 */
    private String last_updtr_id = "";
    
    public String getCretr_id() {
		return cretr_id;
	}

	public void setCretr_id(String cretr_id) {
		this.cretr_id = cretr_id;
	}

	public String getLast_updtr_id() {
		return last_updtr_id;
	}

	public void setLast_updtr_id(String last_updtr_id) {
		this.last_updtr_id = last_updtr_id;
	}
    /** 공통 조건 종료 */
    
	/** 글번호 */
	private int number;
	
	/** 작성자 ID */
	private int userid;
	
	/** 글제목 */
	private String title;
	
	/** 글내용 */
	private String content;
	
	/** 작성시간 */
	private String time;
	
	/** 삭제여부 */
	private int det_yn;
	
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
		
	public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public int getDet_yn() {
		return det_yn;
	}

	public void setDet_yn(int det_yn) {
		this.det_yn = det_yn;
	}
}
