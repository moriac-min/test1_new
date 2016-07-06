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

<body>
<div id="inner-view">
    <div class="inner-head">
        <h1>어린이건강메뉴</h1>
    </div>
    <div class="inner-body">
        <img src="${contextPath}/img/recipe/green_menu_03.png" style="margin:50px 0 0 30px;">
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
