<%@page language="java" contentType="text/html; charset=utf-8"
%><%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"
%><%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"
%><%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"
%>

<script type="text/javascript">

function goClose() {
	self.close();
}

</script>

    <div id="contentArea" style="padding-left:30px;padding-top:30px;">
      <div id="pagetitle">
       <h1><img src="../../../../images/safefoodlife/food/title/02_01.gif" alt=" " /></h1>
      </div>
      <div id="content">
        <span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${foodRvlvPath.titl}</span>
        <hr/>
        <div class="bbs">
        <c:if test="${not empty foodRvlvDetail.etc2}">
          <table width="750" border="0" cellspacing="0" cellpadding="0">
            <tr>
              <td align="right">
                <a href="JavaScript:goDown('${foodRvlvDetail.etc2}','${foodRvlvDetail.etc3}','m_02_01');">
                  <img src="../../../../images/safefoodlife/food/icon/pdf.gif" align="absmiddle" border="0"> <font color="blue">공전 원문 PDF 파일</font>
                </a>
              </td>
            </tr>
          </table>
        </c:if>
<PRE STYLE='width:760px;word-wrap: break-word;white-space:pre-wrap;font-size:14px;font-family:"돋움";line-height:160%;'>

${foodRvlvDetail.cn}

</PRE>
          <center><a href="JavaScript:goClose();"><img src="../../../../images/safefoodlife/food/bbs/btn_close.gif" alt=" " /></a></center>
          <br/><br/>
        </div>
      </div>
    </div>
