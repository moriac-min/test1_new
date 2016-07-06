package common.commonfacillity.uia;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.springframework.web.servlet.view.AbstractView;

import common.commonfacillity.log.CommonLog;

import websquare.system.adapter.ResponseAdapter;


public class WqAdapterView extends AbstractView {

	@CommonLog Logger log;

    @Override
    protected void renderMergedOutputModel(Map model, HttpServletRequest request, HttpServletResponse response) throws Exception {

    	Object obj = model.get("result");
    	
    	ResponseAdapter resAdapter = new ResponseAdapter();
    	resAdapter.convertAndSend(request, response, obj);

    }
}
