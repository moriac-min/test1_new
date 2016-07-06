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
        <h1>장보기 : ${themaVO.gren_sche_nm }</h1>
        <a href="javascrip:;" onClick="window.print();" class="print">프린트</a>
    </div>
    <div class="inner-body">
        <ul class="cart-list" type="disc">
	        <pre>${themaVO.gren_sche_market }</pre>
        </ul>
    </div>
    <div class="util-container">
<!--     	<div class="fr"><a href="http://www.kamis.or.kr/customer/price/retail/item.do" target="_blank"><img src="../../../img/recipe/bt-at.png" width="150" height="50" alt="농수산물가격정보"></a></div> -->
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
