package sample.beans;

public class CodeBean extends BaseBean {

	private String code;
	private String value;

	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
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

	    retValue = "CodeBean ( "
	        + super.toString() + TAB
	        + "code = " + this.code + TAB
	        + "value = " + this.value + TAB
	        + " )";

	    return retValue;
	}
}
