package common.commonfacillity.uia;

import javax.servlet.http.HttpServletRequest;

public interface WqUiAdaptor {

	public Object convert(HttpServletRequest request) throws Exception;
	public Object convert(HttpServletRequest request, Object beanDef) throws Exception;

	public Class getModelName();
}

