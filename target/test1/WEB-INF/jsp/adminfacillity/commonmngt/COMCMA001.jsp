<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%
  /**
  * @Class Name : login.jsp
  * @Description : Sample Login 화면
  * @Modification Information
  * 
  *   수정일         수정자                   수정내용
  *  -------    --------    ---------------------------
  *  2014.06.13 김민규           최초 생성
  *
  * author 
  * since 2014.06.13
  *  
  * Copyright (C) 2014 by NDS  All right reserved.
  */
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Basic Login</title>
<link type="text/css" rel="stylesheet" href="<c:url value='/css/egovframework/sample.css'/>"/>
<script type="text/javaScript" language="javascript" defer="defer">
	function fn_login(){
		document.loginForm.action = "<c:url value='/com/cm/selectLogin.do'/>";
	   	document.loginForm.submit();
	}
	
	function fn_redirect(){
		
	}
</script>
</head>
<body style="text-align:center; margin:0 auto; display:inline; padding-top:100px;">
<form:form commandName="comcmVO" name="loginForm" method="post">
<input type="hidden" name="selectedId" />
<div id="content_pop">
	<!-- 타이틀 -->
	<div id="title">
		<ul>
			<c:if test="${result > 0}">
				<li><img src="<c:url value='/images/egovframework/example/title_dot.gif'/>"> Login 되었습니다. </li>
			</c:if>
			<c:if test="${result < 1}">
				<li><img src="<c:url value='/images/egovframework/example/title_dot.gif'/>"> Login에 실패하였습니다. </li>
			</c:if>
		</ul>
	</div>
	<!-- // 타이틀 -->
	<!-- List -->
	<div id="table">
		<table width="100%" border="0" cellpadding="0" cellspacing="0">
			<colgroup>
				<col width="30%">
				<col width="70%">
			</colgroup>		  
			<tr>
				<th colspan="2" align="center">통합식품정보안전망</th>
			</tr>
			<tr>
				<td align="center" class="listtd">사번</td>
				<td align="center" class="listtd"><form:input path="sabun" cssClass="txt"/></td>
			</tr>
			<tr>
				<td align="center" class="listtd">비밀번호</td>
				<td align="center" class="listtd"><form:password path="password" cssClass="txt"/></td>
			</tr>
		</table>
	</div>
	<!-- /List -->
	<div id="sysbtn1">
		<ul>
		<div id="sysbtn"><ul>
		<li><span class="btn_blue_l"><a href="javascript:fn_login();">로그인</a><img src="<c:url value='/images/egovframework/example/btn_bg_r.gif'/>" style="margin-left:6px;"></span></li></ul>
		</div>
		</ul>
	</div>
</div>
</form:form>
</body>
</html>
