<%@page language="java"	contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<c:set var="contextPath" scope="request">${pageContext.request.contextPath}</c:set>

<!DOCTYPE html>
<html> 
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" id="document_mode" content="IE=edge">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">

<title>${title}</title>

<!-- =========================== css import =========================== -->
<link type="text/css" href="${contextPath}/css/jquery.bxslider.css" rel="stylesheet">
<link type="text/css" href="${contextPath}/css/bootstrap.min.css" rel="stylesheet">
<link type="text/css" href="${contextPath}/css/webfont.css" rel="stylesheet">
<%--<link type="text/css" href="${contextPath}/css/style_sub.css" rel="stylesheet">--%>
<%--<link type="text/css" href="${contextPath}/css/style_minwon.css" rel="stylesheet">--%>
<!-- =========================== css import끝 =========================== -->

<!-- =========================== js import =========================== -->
<script type="text/javascript" src="${contextPath}/js/jquery.js"></script>
<script type="text/javascript" src="${contextPath}/js/jquery.min.js"></script>
<script type="text/javascript" src="${contextPath}/js/jquery.bxslider.min.js"></script>
<script type="text/javascript" src="${contextPath}/js/common.js"></script>
<script type="text/javascript" src="${contextPath}/js/jquery.simplePagination.js"></script>
<!-- =========================== js import끝 ========================== --> 

</script>
</head>

<body>
	<div id="inner-view">
		<!-- 실제 들어갈 페이지 -->
		<jsp:include page="${MAIN_INCLUDE}"/>
	</div>
</body>
</html>

<script>
$(document).ready(function(){
	$('.product-img').bxSlider({
		mode: 'fade',
		captions: true,
		pagerCustom: '#thumbnail'
	});
});

$(function(){
	//pagination
    $('.pagination').pagination({
        items: 100,
        itemsOnPage: 10,
        cssStyle: 'compact-theme'
    });
});
</script>
