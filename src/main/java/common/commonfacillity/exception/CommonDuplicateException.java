package common.commonfacillity.exception;

import org.springframework.dao.DataAccessException;

/**
 * DB에서 Unique 제약조건에 위배될때 발생
 * 
 * @author 김민규
 * @since 2014.09.01
 * @version 1.0
 * @see
 * 
 *      <pre>
 *  Modification Information
 *  수정일      수정자   수정내용
 *  ---------- -------- ---------------------------
 *  2014.09.01 김민규   최초 생성
 * </pre>
 * 
 * Copyright (C) 2014 by NDS., All right reserved.
 */
@SuppressWarnings("serial")
public class CommonDuplicateException extends DataAccessException {

    String name = null;
    String title = null;
    String keyval = null;
    String keyname = null;
    String beanName = null;
    int rowIndex = -1;

    public CommonDuplicateException(String sqle) {
	super(sqle);
    }

    /**
     * grid 명을 입력
     * 
     * @param gridName
     */
    public void setDatasetName(String name) {
	this.name = name;
    }

    /**
     * 예외가 발생한 rownum
     * 
     * @param i
     */
    public void setRowIndex(int i) {
	this.rowIndex = i;
    }

    /**
     * @param 예외가
     *            발생한 데이타셋의 한글명
     */
    public void setDatasetTitle(String title) {
	this.title = title;
    }
    
    /**
     * @param 예외 발생한 키명
     * 
     */
    public void setKeyName(String keyname) {
    this.keyname = keyname;	
    }
    
    /**
     * @param 예외발생한 키의 값
     * 
     */
    public void setKeyValue(String keyval){
    this.keyval = keyval;
    }
    
    /**
     * @param beanDef명칭
     *  
     */
    public void setBeanName(String beanName){
    	this.beanName = beanName;
    }
    
    /**
     * UI로 전달되는 메시지 구분자 '|'
     */
//    public String getMessage() {
//    	return new StringBuilder().append(name == null ? "NOT_DEFINED" : name).append("|").append(rowIndex).append("|").append(title == null ? "자료" : title).append("|").append(keyname == null ? "Not Define Key Name" : keyname).append("|").append(keyval == null ? "Not Define Key Value" : keyval).toString();
//    }
    /**
     * UI로 전달되는 메시지 구분자
     * {"keyName":[{"column":"value"}]}
     */
    public String getMessage() {
    	StringBuilder sbtr = new StringBuilder();
    	sbtr.append(name == null ? "NOT_DEFINED" : name);
    	sbtr.append("|").append(rowIndex).append("|").append(title == null ? "자료" : title).append("|").append(keyname == null ? "Not Define Key Name" : keyname).append("|").append(keyval == null ? "Not Define Key Value" : keyval);
    	return sbtr.toString();
    }
}
