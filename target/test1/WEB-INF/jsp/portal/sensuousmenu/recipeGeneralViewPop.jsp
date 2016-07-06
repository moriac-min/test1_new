<%@page language="java" contentType="text/html; charset=utf-8"
%><%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"
%><%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"
%><%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"
%>
<c:set var="contextPath" scope="request">${pageContext.request.contextPath}</c:set>

<link type="text/css" href="${contextPath}/css/bootstrap.min.css" rel="stylesheet">
<link type="text/css" href="${contextPath}/css/webfont.css" rel="stylesheet">
<link type="text/css" href="${contextPath}/css/style_sub.css" rel="stylesheet">

<input type="hidden" id="rcp_menu_no" name="rcp_menu_no" value="${recipeInfoVO.rcp_menu_no }">				<!-- rcp_menu_no -->

<body class="market">
<div id="inner-view">
	<div class="inner-head">
		<h1>${recipeInfoVO.rcp_menu_nm }</h1>
		<a href="javascrip:;" onClick="window.print();" class="print">프린트</a>
	</div>
	<div class="inner-body recipe">
			<div class="section">
				<div class="ingredients">
					<h2>재료소개</h2>
					<p>${recipeInfoVO.rcp_menu_mate }</p>
				</div>
			</div>
			<div class="section">
				<div class="direction">
					<h2>만들어볼까요</h2>
					<pre>${recipeInfoVO.rcp_menu_proces }</pre>
				</div>
			</div>
	</div>
</div>
</body>

<script language="JavaScript">

	/****************************************
	 * Variable
	****************************************/
	/****************************************
	 * Init
	****************************************/
	$(document).ready(function(){
		
	}); 
	
	/****************************************
	 * Button Action
	 ****************************************/

	 /****************************************
	 * Function
	 ****************************************/
	 
</script>
