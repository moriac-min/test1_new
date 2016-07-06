package common.commonfacillity.logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class LoggerInterceptor extends HandlerInterceptorAdapter {
//    protected Log log = LogFactory.getLog(LoggerInterceptor.class);
    protected final Logger log = LoggerFactory.getLogger(LoggerInterceptor.class);
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
	// String reqURL = request.getRequestURI();
	// LOG.debug("==============================================================");
	if (log.isDebugEnabled()) {
	    log.debug("::", modelAndView.getModel());
	    // LOG.debug("==============================================================");
	    log.debug("===================           END          ===================");
	    log.debug("==============================================================\n");
	}
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//	Boolean isAuthenticated = KaeriUserDetailsHelper.isAuthenticated();
//	try {
	    /* 일반 로그인, 로그아웃 , 재로그인은 세션이 없어도 정상적으로 동작해야 함 */
	    /*
	     * if(!"/co/au/actionLogin.do".equals(request.getRequestURI()) &&
	     * !"/co/au/actionLogout.do".equals(request.getRequestURI()) &&
	     * !"/co/au/actionReLogin.do".equals(request.getRequestURI()) &&
	     * !"/install.do".equals(request.getRequestURI())){
	     * if(!isAuthenticated){ XPLATFORMViewByMapError
	     * xPLATFORMViewByMapError = new XPLATFORMViewByMapError();
	     * xPLATFORMViewByMapError
	     * .renderMergedOutputModelByNoSession(request, response); return
	     * false; } }
	     */
	/*} catch (Exception ex) {
	    ex.printStackTrace();
	}*/

	if (log.isDebugEnabled()) {
	    log.debug("==============================================================");
	    log.debug("===================          START         ===================");
	    // LOG.debug("==============================================================");
	    log.debug(" Request URI \t:  " + request.getRequestURI());
	}
	return super.preHandle(request, response, handler);
    }

}
