package sample.beans;

import java.util.List;

public class SelectBean extends BaseBean {

	private UserBean userInfo;
	private List infoList;
	private List codeList;
	
	public UserBean getUserInfo() {
		return userInfo;
	}
	public void setUserInfo(UserBean userInfo) {
		this.userInfo = userInfo;
	}
	public List getInfoList() {
		return infoList;
	}
	public void setInfoList(List infoList) {
		this.infoList = infoList;
	}
	public List getCodeList() {
		return codeList;
	}
	public void setCodeList(List codeList) {
		this.codeList = codeList;
	}
	
	
}
