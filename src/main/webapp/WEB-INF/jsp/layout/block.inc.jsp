<%@page language="java" contentType="text/html; charset=utf-8"
import="java.util.*"
import="abc.cms.model.ThemeLayoutBlock"
import="abc.cms.model.ThemeLayoutBlockRenderer"
%><%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"
%><%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"
%><%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"
%><%

String section = request.getParameter("SECTION");
ThemeLayoutBlock[] blocks = (ThemeLayoutBlock[]) request.getAttribute("blocks");
HashMap<String, ThemeLayoutBlockRenderer> rendererMap = (HashMap<String, ThemeLayoutBlockRenderer>) request.getAttribute("RENDERERS");
//System.out.println("====section===>>"+section);
//System.out.println("====rendererMap==>>"+rendererMap.values());
if (blocks != null)
    for (ThemeLayoutBlock block : blocks) {
        if (block.getSectionId().equals(section)) {
            ThemeLayoutBlockRenderer renderer = rendererMap.get(block.getRenderer());
            if (renderer != null) {
                String viewPath = renderer.renderBlock(request, out, block);
                //System.out.println("====viewPath===>>"+viewPath);
                if (viewPath != null) {
                    %><jsp:include page="<%= viewPath %>" /><%
                }
            }
        }
    }

%>