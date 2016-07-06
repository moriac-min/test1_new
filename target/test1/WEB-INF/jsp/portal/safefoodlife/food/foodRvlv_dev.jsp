<%@page language="java" contentType="text/html; charset=utf-8"
%><%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"
%><%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"
%><%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"
%>

<script language="JavaScript">
function goSearch(idx){
	$('#rvlv_no').val(idx);
	$('#search_word').val('');
	
	$('#searchForm').attr('method', 'post');
	//$('#searchForm').attr('target', '_self');
	$('#searchForm').submit();
}

function goSearchText(){
	if (!$('#search_word').val()) {
		alert('검색어를 입력해 주세요.');
		$('#search_word').focus();
		return;
	}
	
	$('#searchForm').attr('method', 'post');
	$('#searchForm').submit();
}

function goPop(site_url) {
    window.open(site_url, 'popup_modify', 'width=1024, height=768, resizable=yes, scrollbars=yes');
}
</script>

<form id="searchForm" name="searchForm">
<input type="hidden" id="rvlv_no" name="rvlv_no"/>

      <div id="contentArea">
        <div id="pagetitle">
         <h1><img src="../../../../images/safefoodlife/food/title/02_01.gif" alt=" " /></h1>
        </div>
        <div id="content">
          <p style="text-align:left;">
            ※ 최종개정고시일자 : 2014년 09월 11일
          </p>
          <p style="text-align:right;">
            <input id="search_word" name="search_word" type="text" value="${search_word}" style="height:16px; border-color:#26468b;" /> <a href="JavaScript:goSearchText();"><img src="../../../../images/safefoodlife/food/bbs/btn_search2.gif" alt=" " /></a>
          </p>
          <div class="RboxB" style="margin-top:0;">
            <table class="rbblist">
              <tbody>
                <tr>
                <c:if test="${fn:length(foodRvlvTopList) gt 0}">
                	<c:forEach var="foodRvlv" items="${foodRvlvTopList}" varStatus="status">
                		<c:choose>
                			<c:when test="${foodRvlv.rvlv_no eq '108'}">
                  <td><a href="JavaScript:goPop('${foodRvlv.cn}');">${foodRvlv.titl}</a></td>
                			</c:when>
                			<c:otherwise>
                  <td><a href="JavaScript:goSearch('${foodRvlv.rvlv_no}');">${foodRvlv.titl}</a></td>
                			</c:otherwise>
                		</c:choose>
                		<c:if test="${status.index%2 == 1 && status.index eq fn:length(foodRvlvTopList)-1}">
                </tr>
                <tr>
                		</c:if>
                	</c:forEach>
                </c:if>
                </tr>
              </tbody>
            </table>
          </div>
          
          <c:choose>
			<c:when test="${fn:length(foodRvlvList) le 0}">
          <br><br>
          <font size="4"><center>검색된 내용이 없습니다.</center></font>
          <br><br>
			</c:when>
			<c:otherwise>
<PRE STYLE='width:760px;word-wrap: break-word;white-space:pre-wrap;font-size:16px;font-family:"굴림";line-height:160%;'>
<c:forEach var="foodRvlv" items="${foodRvlvList}" varStatus="status">
	<c:choose>
		<c:when test="${foodRvlv.hrnk_no eq '0'}">
<b><font size="4">${foodRvlv.titl}</font></b>
		</c:when>
		<c:when test="${foodRvlv.etc1 ne 'DEPT-LAST'}">
<font size="3">${foodRvlv.titl}</font>
		</c:when>
		<c:otherwise>
<a href="foodRvlvDetail.do?rvlv_no=${foodRvlv.rvlv_no}" target="_blank"><font size="3" color="blue">${foodRvlv.titl}</font></a>
		</c:otherwise>
	</c:choose>
</c:forEach>
</PRE>
			</c:otherwise>
          </c:choose>

        </div>
      </div>
</form>