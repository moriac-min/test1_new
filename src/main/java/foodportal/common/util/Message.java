package foodportal.common.util;

import java.util.ResourceBundle;


/**
 * 
 * @author 박재형
 * 번들메세지
 */
public class Message {
	
	static ResourceBundle bundle = ResourceBundle.getBundle("message");
	
	public static String getMessage(String key) {
		return bundle.getString(key);
	}
	
	public static String getMessage(String key, String arg) {
		return getMessage(key, new String[]{arg});
	}
	
	public static String getMessage(String key, Object[] objs) {
		String msg = bundle.getString(key);
		
		for(int i=0; i<objs.length; i++) {
			msg = msg.replaceAll(String.valueOf("\\{" + i + "\\}"), objs[i].toString());
		}
		
		return msg;
	}
	
}
