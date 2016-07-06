package common.commonfacillity.uia;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import websquare.system.adapter.RequestAdapter;


public class WqAdapter implements WqUiAdaptor {

	protected Log log = LogFactory.getLog(this.getClass());

	private Object obj;
	
	public Object convert(HttpServletRequest request) throws Exception {
		return convert(request, null);
	}

	public Object convert(HttpServletRequest request, Object beanDef) throws Exception {
		
		RequestAdapter reqAdapter = new RequestAdapter();
		obj = reqAdapter.convert(request, beanDef);

		return obj;
	}
	
	public Class getModelName() {
		return Map.class;	// map, bean 모두 처리하기 위해 사용하지 않음...
	}

}

