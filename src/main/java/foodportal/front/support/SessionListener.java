package foodportal.front.support;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import foodportal.front.member.service.impl.MemberServiceImpl;

/**
 * Application Lifecycle Listener implementation class SessionListener
 *
 */
public class SessionListener implements HttpSessionListener {

	/**
     * @see HttpSessionListener#sessionCreated(HttpSessionEvent)
     */
    public void sessionCreated(HttpSessionEvent se) {
    }

	/**
     * @see HttpSessionListener#sessionDestroyed(HttpSessionEvent)
     */
    public void sessionDestroyed(HttpSessionEvent se) {
    	new MemberServiceImpl().deleteMemberToken();
    }
	
}
