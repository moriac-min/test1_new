package sample.beans;

import java.util.List;

public class ModifiedBean extends BaseBean {
	private ResultBean rtnResult;
	private List infoList;

	public List getInfoList() {
		return infoList;
	}

	public void setInfoList(List infoList) {
		this.infoList = infoList;
	}

	public ResultBean getRtnResult() {
		return rtnResult;
	}

	public void setRtnResult(ResultBean rtnResult) {
		this.rtnResult = rtnResult;
	}
	
}
