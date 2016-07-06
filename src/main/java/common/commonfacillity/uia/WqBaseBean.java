package common.commonfacillity.uia;

public abstract class WqBaseBean {
	private WqResultBean wqResultBean;
	private String rowStatus;
	private String WQResultCode;
	private String WQResultMsg;
	private String WQResultMsgDetail;
	
	public WqResultBean getWqResultBean() {
		return wqResultBean;
	}

	public void setWqResultBean(WqResultBean wqResultBean) {
		this.wqResultBean = wqResultBean;
	}
	
	public String getRowStatus() {
		return rowStatus;
	}
	
	public void setRowStatus(String rowStatus) {
		this.rowStatus = rowStatus;
	}
	
	public String toString() {
		final String TAB = "    ";

		String retValue = "";

		return retValue;
	}

	public String getWQResultCode() {
		return WQResultCode;
	}

	public void setWQResultCode(String wQResultCode) {
		WQResultCode = wQResultCode;
	}

	public String getWQResultMsg() {
		return WQResultMsg;
	}

	public void setWQResultMsg(String wQResultMsg) {
		WQResultMsg = wQResultMsg;
	}

	public String getWQResultMsgDetail() {
		return WQResultMsgDetail;
	}

	public void setWQResultMsgDetail(String wQResultMsgDetail) {
		WQResultMsgDetail = wQResultMsgDetail;
	}

}
