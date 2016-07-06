package common.commonfacillity.util;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * User Login Session Attribute
 * 
 * @author 김민규
 * @since 2014. 6. 12.
 * @version 1.0
 * @see
 * 
 * <pre>
 *  Modification Information
 *  수정일      수정자   수정내용
 *  ---------- -------- ---------------------------
 *  2014. 6. 12.   김민규   최초 생성
 * </pre>
 * 
 * Copyright (C) 2014 by NDS., All right reserved.
 */
public class CommonUserVO {
	String empno = null;
	String orgid = null;
	String usernm = null;
	
	boolean isValid = true;
	
	Map<String, Object> userMap = new HashMap();
	
	
	
	/**
	 * @return the userMap
	 */
	public Map<String, Object> getUserMap() {
		return userMap;
	}

	/**
	 * @param userMap the userMap to set
	 */
	public void setUserMap(Map<String, Object> userMap) {
		this.userMap = userMap;
	}

	/**
	 * @return the isValid
	 */
	public boolean isValid() {
		return isValid;
	}

	/**
	 * @param isValid the isValid to set
	 */
	public void setValid(boolean isValid) {
		this.isValid = isValid;
	}
	
	/**
	 * @return the empno
	 */
	public String getEmpno() {
		return empno;
	}
	/**
	 * @param empno the empno to set
	 */
	public void setEmpno(String empno) {
		this.empno = empno;
	}
	/**
	 * @return the orgid
	 */
	public String getOrgid() {
		return orgid;
	}
	/**
	 * @param orgid the orgid to set
	 */
	public void setOrgid(String orgid) {
		this.orgid = orgid;
	}
	/**
	 * @return the usernm
	 */
	public String getUsernm() {
		return usernm;
	}
	/**
	 * @param usernm the usernm to set
	 */
	public void setUsernm(String usernm) {
		this.usernm = usernm;
	}
}
