package sample.beans;

public class UserBean extends BaseBean {

	private String userID;
	private String userName;
	private String address;

	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * Constructs a <code>String</code> with all attributes in name = value
	 * format.
	 * 
	 * @return a <code>String</code> representation of this object.
	 */
	public String toString() {
		final String TAB = "    ";

		String retValue = "";

		retValue = "UserBean ( " + super.toString() + TAB + "userID = "
				+ this.userID + TAB + "userName = " + this.userName + TAB
				+ "address = " + this.address + TAB + " )";

		return retValue;
	}

}