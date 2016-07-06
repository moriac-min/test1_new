<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%
  /**
  * @Class Name : edusa001.jsp
  * @Description : Sample List 화면
  * @Modification Information
  * 
  *   수정일         수정자                   수정내용
  *  -------    --------    ---------------------------
  *  2014.06.13    김민규        최초 생성
  *
  * author 실행환경 개발팀
  * since 2014.06.13
  *  
  * Copyright (C) 2014 by NDS  All right reserved.
  */
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Basic Board List</title>
<link type="text/css" rel="stylesheet" href="<c:url value='/css/egovframework/sample.css'/>"/>
<script type="text/javaScript" language="javascript" defer="defer">
<!--
/* 글 수정 화면 function */
function fn_egov_select(id) {
	document.listForm.selectedId.value = id;
   	document.listForm.action = "<c:url value='/sample/updateSampleView.do'/>";
   	document.listForm.submit();		
}

/* 글 등록 화면 function */
function fn_egov_addView() {
   	document.listForm.action = "<c:url value='/sample/addSampleView.do'/>";
   	document.listForm.submit();		
}

/* 글 목록 화면 function */
function fn_egov_selectList() {
	document.listForm.action = "<c:url value='/sample/egovSampleList.do'/>";
   	document.listForm.submit();
}

/* pagination 페이지 링크 function */
function fn_egov_link_page(pageNo){
	document.listForm.pageIndex.value = pageNo;
	document.listForm.action = "<c:url value='/sample/egovSampleList.do'/>";
   	document.listForm.submit();
}
-->

	/* 글 목록 화면 function */
	function fn_egov_selectList() {
		document.listForm.action = "<c:url value='/education/sample/selectEduSawonList.do'/>";
	   	document.listForm.submit();
	}
	
	/* 글 목록 화면 function */
	function fn_egov_selectView(xxx) {
		document.listForm.action = "<c:url value='/education/sample/selectEduSawonView.do'/>";
	   	document.listForm.submit();
	}

</script>
</head>
<body style="text-align:center; margin:0 auto; display:inline; padding-top:100px;">
<form:form commandName="educationSampleVO" name="listForm" method="post">
<input type="hidden" name="selectedId" />
<div id="content_pop">
	<div id="search">
		<ul>
		<li>
			<form:select path="searchCondition" cssClass="use">
				<form:option value="1" label="사번" />
				<form:option value="0" label="성명" />
			</form:select>
		</li>
		<li><form:input path="searchKeyword" cssClass="txt"/></li>
		<li><span class="btn_blue_l"><a href="javascript:fn_egov_selectList();">검색</a><img src="<c:url value='/images/egovframework/example/btn_bg_r.gif'/>" style="margin-left:6px;"></span></li></ul>		
	</div>
	<!-- 타이틀 -->
	<div id="title">
		<ul>
			<li><img src="<c:url value='/images/egovframework/example/title_dot.gif'/>"> List Sample </li>
		</ul>
	</div>
	<!-- // 타이틀 -->
	<!-- List -->
	<div id="table">
		<table width="100%" border="0" cellpadding="0" cellspacing="0">
			<colgroup>
				<col width="80">				
				<col width="100">
				<col width="100">
				<col width="100">
				<col width="100">
				<col width="100">
				<col width="100">
				<col width="100">
				<col width="60">
			</colgroup>		  
			<tr>
				<th align="center">번호</th>
				<th align="center">사번</th>
				<th align="center">성명</th>
				<th align="center">부서명</th>
				<th align="center">입사일</th>
				<th align="center">성별</th>
				<th align="center">결혼유무</th>
				<th align="center">월급</th>
				<th align="center">비고</th>
			</tr>
			<c:forEach var="result" items="${resultList}" varStatus="status">
			<tr>
				<td align="center" class="listtd"><c:out value="${status.count}"/></td>
				<td align="center" class="listtd"><c:out value="${result.sabun}"/></td>
				<td align="center" class="listtd"><c:out value="${result.name}"/></a></td>
				<td align="left" class="listtd"><c:out value="${result.dept}"/>&nbsp;</td>
				<td align="center" class="listtd"><c:out value="${result.ipsa_date}"/>&nbsp;</td>
				<td align="center" class="listtd"><c:out value="${result.sex}"/>&nbsp;</td>
				<td align="center" class="listtd"><c:out value="${result.marry}"/>&nbsp;</td>
				<td align="center" class="listtd"><c:out value="${result.salary}"/>&nbsp;</td>
				<td align="center" class="listtd"><c:out value="${result.smemo}"/>&nbsp;</td>
			</tr>
			</c:forEach>
		</table>
	</div>
	<!-- /List -->
	<div id="sysbtn1">
		<ul>
		<div id="sysbtn"><ul>
		<li><span class="btn_blue_l"><a href="javascript:fn_egov_addView();">등록</a><img src="<c:url value='/images/egovframework/example/btn_bg_r.gif'/>" style="margin-left:6px;"></span></li></ul>
		</div>
		</ul>
	</div>
</div>
</form:form>
</body>
</html>
