<%@page language="java" contentType="text/html; charset=utf-8"
%><%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"
%><%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"
%><%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"
%><%@ taglib prefix="m" uri="/WEB-INF/tlds/message.tld"
%><%@ page import="foodportal.common.util.Message"
%>



<c:set var="contextPath" scope="request">${pageContext.request.contextPath}</c:set>
<input type="hidden" id="show_cnt" name="show_cnt"/>



<table summary="">
  <caption></caption>
  <colgroup>
      <col style="width:60px;">
      
      <col>
      <col style="width:90px;">
      <col style="width:90px;">
      <col style="width:60px;">
  </colgroup>
  <thead>
      <tr>
          <th scope="col">번호</th>
      
          <th scope="col">제목</th>
          <th scope="col">작성자</th>
          <th scope="col">등록일</th>
          <th scope="col">조회수</th>
      </tr>
  </thead>
  <tbody id="listFrame">
      
  </tbody>
</table>
   
<script>
/* 
function fn_drawList(list){
	var listLangth = list.length;
	var content = "";
	
	for(var i=0; i<listLangth; i++){
		content += "<tr>";
		content += "<td scope='row' class='num'>"+list[i].no+"</td>";
		if(list[i].ctgrynm != ''){
			content += "<td>"+list[i].ctgrynm+"</td>";	
		}
		content += "<td class='subject'><a href='javascript:viewDetail("+list[i].ntctxt_no+");'>"+list[i].titl+"</a></td>";
		content += "<td>"+list[i].last_updtr_id+"</td>";
		content += "<td class='num'>"+list[i].cret_dtm+"</td>";
		content += "<td class='num'>"+list[i].inqry_cnt+"</td>";
	}
	
	document.getElementById("listFrame").innerHTML = content;
}
 */
</script>