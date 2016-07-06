package common.commonfacillity.uia;

public class WqResultBean extends WqBaseBean {

	private String result;

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}
	/**
	 * Constructs a <code>String</code> with all attributes in name = value
	 * format.
	 * 
	 * @return a <code>String</code> representation of this object.
	 */
	public String toString()
	{
	    final String TAB = "    ";

	    String retValue = "";

	    retValue = "ResultBean ( "
	        + super.toString() + TAB
	        + "result = " + this.result + TAB
	        + " )";

	    return retValue;
	}
}