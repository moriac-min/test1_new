package sample.beans;

public class InfoBean extends BaseBean {

	private int number;
	private String title;
	private String telno;
	private String zip;
	private String address;
	private String rowStatus;

	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getTelno() {
		return telno;
	}
	public void setTelno(String telno) {
		this.telno = telno;
	}
	public String getZip() {
		return zip;
	}
	public void setZip(String zip) {
		this.zip = zip;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	public String getRowStatus() {
		return rowStatus;
	}
	public void setRowStatus(String rowStatus) {
		this.rowStatus = rowStatus;
	}
	/**
	 * Constructs a <code>String</code> with all attributes
	 * in name = value format.
	 *
	 * @return a <code>String</code> representation
	 * of this object.
	 */
	public String toString()
	{
	    final String TAB = "    ";

	    String retValue = "";

	    retValue = "InfoBean ( "
	        + super.toString() + TAB
	        + "number = " + this.number + TAB
	        + "title = " + this.title + TAB
	        + "telno = " + this.telno + TAB
	        + "zip = " + this.zip + TAB
	        + "address = " + this.address + TAB
	        + " )";

	    return retValue;
	}


}
