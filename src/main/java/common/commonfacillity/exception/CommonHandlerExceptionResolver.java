package common.commonfacillity.exception;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.commonfacillity.exception.CommonDuplicateException;
import common.commonfacillity.exception.CommonMailException;
import common.commonfacillity.exception.CommonMessageException;
import common.commonfacillity.exception.CommonMissingParameterException;
import common.commonfacillity.exception.CommonSequenceException;
import common.commonfacillity.uia.WqBaseBean;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

/**
 * 어플리케이션 예외 Resolver
 * 
 * @author 김민규
 * @since 2014.09.01
 * @version 1.0
 * @see
 * 
 * <pre>
 *  Modification Information
 *  수정일      수정자   수정내용
 *  ---------- -------- ---------------------------
 *  2014.09.01 김민규   최초 생성
 * </pre>
 * 
 * Copyright (C) 2012 by NDS., All right reserved.
 */
public class CommonHandlerExceptionResolver implements HandlerExceptionResolver {

    protected Log log = LogFactory.getLog(this.getClass());

    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {

	ModelAndView mav = new ModelAndView("wqView");
	WqBaseBean wqBaseBean = null;
	
	/**
	 * {"keyName":[{"column":"value"}]}
	 */
	
	if (ex instanceof CommonDuplicateException) {			// 키 중복 예외
		
		wqBaseBean.setWQResultCode("-1001");
		wqBaseBean.setWQResultMsg(ex.getMessage());
		wqBaseBean.setWQResultMsgDetail(ex.toString());
		
//	    mav.addObject("WQResultCode", "-1001");
//	    mav.addObject("WQResultMsg", ex.getMessage());
//	    mav.addObject("WQResultMsgDetail", ex.toString());
		mav.addObject(wqBaseBean);
		
	    if (log.isErrorEnabled()) {
		log.error("키중복예외:" + ex.getMessage());
	    }
	} else if (ex instanceof CommonSequenceException) {		// 채번 예외
	    mav.addObject("WQResultCode", "-1000");
	    mav.addObject("WQResultMsg", ex.getMessage());
	    mav.addObject("WQResultMsgDetail", ex.toString());
	    if (log.isErrorEnabled()) {
		log.error("시퀀스채번예외:" + ex.getMessage());
	    }
	} else  if (ex instanceof CommonMissingParameterException){	// 필수 파라미터 누락
	    mav.addObject("WQResultCode", "-9000");
	    mav.addObject("WQResultMsg", ex.getMessage());
	    mav.addObject("WQResultMsgDetail", ex.toString());
	    if (log.isErrorEnabled()) {
		log.error("조회필수값누락예외:" + ex.getMessage());
	    }
	} else  if (ex instanceof CommonMessageException){	// 사용자 정의 메시지
		mav.addObject("WQResultCode", "-8888");
		mav.addObject("WQResultMsg", ex.getMessage());
		mav.addObject("WQResultMsgDetail", ex.toString());
		if (log.isErrorEnabled()) {
			log.error("사용자 정의예외:" + ex.getMessage());
		}
	} else  if (ex instanceof CommonMailException){	// 메일보내기 에러
		mav.addObject("WQResultCode", "-1002");
		mav.addObject("WQResultMsg", ex.getMessage());
		mav.addObject("WQResultMsgDetail", ex.toString());
		if (log.isErrorEnabled()) {
			log.error("메일보내기 예외:" + ex.getMessage());
		}
	} else {
	    ex.printStackTrace();
	    mav.addObject("WQResultCode", "-9999");
	    mav.addObject("WQResultMsg", ex.getMessage());
	    mav.addObject("WQResultMsgDetail", ex.toString());
	}
	
	
	return mav;

    }

}
