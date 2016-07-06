package foodportal.common.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.servlet.http.HttpServletResponse;

public class FusionCharts
{
  public String encodeDataURL(String strDataURL, String addNoCacheStr, HttpServletResponse response)
  {
    String encodedURL = strDataURL;

    if (addNoCacheStr.equals("true"))
    {
      Calendar nowCal = Calendar.getInstance();
      Date now = nowCal.getTime();
      SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy HH_mm_ss a");

      String strNow = sdf.format(now);
      if (strDataURL.indexOf("?") > 0)
        encodedURL = strDataURL + "&FCCurrTime=" + strNow;
      else {
        strDataURL = strDataURL + "?FCCurrTime=" + strNow;
      }
      encodedURL = response.encodeURL(strDataURL);
    }

    return encodedURL;
  }

  public String createChart(String chartSWF, String strURL, String strXML, String chartId, int chartWidth, int chartHeight, boolean debugMode, boolean registerWithJS)
  {
    StringBuffer strBuf = new StringBuffer();

    strBuf.append("  <div id='" + chartId + "Div' align='center'></div>\n");

    strBuf.append("  <script type='text/javascript'>\n");

    Boolean registerWithJSBool = new Boolean(registerWithJS);
    Boolean debugModeBool = new Boolean(debugMode);
    int regWithJSInt = boolToNum(registerWithJSBool);
    int debugModeInt = boolToNum(debugModeBool);

    strBuf.append("    var chart_" + chartId + " = new FusionCharts('" + chartSWF + "', '" + chartId + "', '" + chartWidth + "', '" + chartHeight + "', '" + debugModeInt + "', '" + regWithJSInt + "');\n");

    if (strXML.equals("")) {	//dataURL
      strBuf.append("    chart_" + chartId + ".setDataURL(\"" + strURL + "\");\n");
    }
    else {			// XML data
      strBuf.append("    chart_" + chartId + ".setDataXML(\"" + strXML + "\");\n");
    }

    strBuf.append("    chart_" + chartId + ".render(\"" + chartId + "Div\");\n");
    strBuf.append("  </script>\n");
    return strBuf.substring(0);
  }

  public String createChartHTML(String chartSWF, String strURL, String strXML, String chartId, int chartWidth, int chartHeight, boolean debugMode)
  {
    String strFlashVars = "";
    Boolean debugModeBool = new Boolean(debugMode);

    if (strXML.equals(""))
    {
      strFlashVars = "chartWidth=" + chartWidth + "&chartHeight=" + chartHeight + "&debugMode=" + boolToNum(debugModeBool) + "&dataURL=" + strURL + "";
    }
    else
    {
      strFlashVars = "chartWidth=" + chartWidth + "&chartHeight=" + chartHeight + "&debugMode=" + boolToNum(debugModeBool) + "&dataXML=" + strXML + "";
    }

    StringBuffer strBuf = new StringBuffer();

    strBuf.append("\t\t<!--START Code Block for Chart-->\n");
    strBuf.append("\t\t\t\t<object classid='clsid:d27cdb6e-ae6d-11cf-96b8-444553540000' codebase='http://fpdownload.macromedia.com/pub/shockwave/cabs/flash/swflash.cab#version=8,0,0,0' width='" + chartWidth + "' height='" + chartHeight + "' id='" + chartId + "'>\n");

    strBuf.append("\t\t\t\t\t<param name='allowScriptAccess' value='always' />\n");
    strBuf.append("\t\t\t\t\t<param name='movie' value='" + chartSWF + "'/>\n");
    strBuf.append("\t\t\t\t<param name='FlashVars' value=\"" + strFlashVars + "\" />\n");

    strBuf.append("\t\t\t\t\t<param name='quality' value='high' />\n");
    strBuf.append("\t\t\t\t<embed src='" + chartSWF + "' FlashVars=\"" + strFlashVars + "\" quality='high' width='" + chartWidth + "' height='" + chartHeight + "' name='" + chartId + "' allowScriptAccess='always' type='application/x-shockwave-flash' pluginspage='http://www.macromedia.com/go/getflashplayer' />\n");

    strBuf.append("\t\t</object>\n");

    strBuf.append("\t\t<!--END Code Block for Chart-->\n");
    return strBuf.substring(0);
  }

  public int boolToNum(Boolean bool)
  {
    int num = 0;
    if (bool.booleanValue()) {
      num = 1;
    }
    return num;
  }
}