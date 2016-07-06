package common.commonfacillity.exception;

/**
 * 필수 파라미터가 누락됐을때 발생하는 예외
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
public class CommonMissingParameterException extends Exception {
    
    public CommonMissingParameterException() {
	super();
    }
    
    public CommonMissingParameterException(String message) {
	super(message);
    }

    /* (non-Javadoc)
     * @see java.lang.Throwable#getMessage()
     */
    @Override
    public String getMessage() {
	return super.getMessage();
    }
    
}
