package common.commonfacillity.exception;

import java.sql.SQLException;

import org.springframework.dao.DataAccessException;

/**
 * 시퀀스 채번시 발생하는 예외
 * 
 * @author 김민규
 * @since 2014.09.01
 * @version 1.0
 * @see
 * 
 * <pre>
 *  Modification Information
 *  수정일      수정자   수정내용
 *  ---------- -------- ---------------------------
 *  2014.09.01 김민규   최초 생성
 * </pre>
 * 
 * Copyright (C) 2014 by NDS., All right reserved.
 */
@SuppressWarnings("serial")
public class CommonSequenceException extends DataAccessException {

    String name = null;

    public CommonSequenceException(String name) {
	super(name);
	this.name = name;
    }

    /**
     * table 명을 입력
     * 
     * @param gridName
     */
    public void seTableName(String name) {
	this.name = name;
    }

    /**
     * 채번중 에러가 발생한 테이블명
     */
    public String getMessage() {
	return name;
    }

}
