package foodportal.common.util;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.AbstractView;

public class SimpleChartView  extends AbstractView{

	  protected void renderMergedOutputModel(Map map, HttpServletRequest request, HttpServletResponse response)
	    throws IOException
	  {
	    response.setContentType("text/html; charset=utf-8");
	    PrintWriter out = response.getWriter();
	    out.println(map.get("chart"));
	  }
}
