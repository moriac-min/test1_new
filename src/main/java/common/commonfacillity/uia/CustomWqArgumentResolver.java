package common.commonfacillity.uia;

import java.lang.annotation.Annotation;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebArgumentResolver;
import org.springframework.web.context.request.NativeWebRequest;

import sample.beans.BaseBean;
import websquare.system.adapter.annotation.BEAN_DEF;
import common.commonfacillity.log.CommonLog;

public class CustomWqArgumentResolver implements WebArgumentResolver {

	@CommonLog Logger log;

    private WqUiAdaptor uiA;

	public void setUiAdaptor(WqUiAdaptor uiA) {
		this.uiA = uiA;
	}

	public Object resolveArgument(MethodParameter param, NativeWebRequest request) throws Exception {
    	
		Class parameterType = param.getParameterType();
		String name = param.getParameterName();
		
		/*
		if(parameterType.equals(Map.class) && name.equalsIgnoreCase("dto")) {					// map
			return (Map)uiA.convert((HttpServletRequest)request.getNativeRequest());
		} else if(parameterType.equals(BaseBean.class) && name.equalsIgnoreCase("ibean")) {	//bean

			// 1. Server에서 Map 형태의 bean definition을 설정하는 방식
			Map beanDef = new HashMap() {
				{
					//put("root", "sample.beans.SelectBean");
					//put("infoList", "sample.beans.InfoBean");
					//put("codeList", "sample.beans.InfoBean");
				}
			};

			// 2. Controller method의 Annotation으로 처리하는 방식 (JDK1.5 이상 지원)
			Annotation annotation = param.getMethodAnnotation(BEAN_DEF.class);

			if(annotation != null) {
				return (BaseBean)uiA.convert((HttpServletRequest)request.getNativeRequest(), (BEAN_DEF)annotation);		// server에서 BEAN_DEF를 설정하는 형태 (Annotation)
			} else if(beanDef == null || beanDef.isEmpty()) {
				return (BaseBean)uiA.convert((HttpServletRequest)request.getNativeRequest());	// client에서 BEAN_DEF를 전달하는 경우
			} else {
				return (BaseBean)uiA.convert((HttpServletRequest)request.getNativeRequest(), beanDef);	// server에서 BEAN_DEF를 설정하는 형태 (Map type)
			}
		}
		*/
		if(parameterType.equals(WqBaseBean.class) && name.equalsIgnoreCase("ibean")) {
			Annotation annotation = param.getMethodAnnotation(BEAN_DEF.class);
			return (WqBaseBean)uiA.convert((HttpServletRequest)request.getNativeRequest(), (BEAN_DEF)annotation);		// server에서 BEAN_DEF를 설정하는 형태 (Annotation)
		} else if(parameterType.equals(BaseBean.class) && name.equalsIgnoreCase("ibean")) {
			Annotation annotation = param.getMethodAnnotation(BEAN_DEF.class);
			return (BaseBean)uiA.convert((HttpServletRequest)request.getNativeRequest(), (BEAN_DEF)annotation);		// server에서 BEAN_DEF를 설정하는 형태 (Annotation)
		}
		return UNRESOLVED;
    }
}
