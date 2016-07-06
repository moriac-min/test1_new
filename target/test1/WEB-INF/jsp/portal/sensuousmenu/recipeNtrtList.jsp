<%@page language="java" contentType="text/html; charset=utf-8"
%><%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"
%><%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"
%><%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"
%>
<c:set var="contextPath" scope="request">${pageContext.request.contextPath}</c:set>

<section>
	<div id="header">
		<div class="board-head">
			<div class="lnb-viewer" id="nav-open-btn" href="#left-nav">Menu</div>
			<ol class="breadcrumb">
				<li><a href="#">홈</a></li>
				<li><a href="#">오감만족식단</a></li>
				<li><a href="#">계절별 메뉴</a></li>
				<li class="active">제철재료정보</li>
			</ol>
			<h1>제철재료정보</h1>
		</div>
	</div>
	<div class="list-container recipe">
		<h2>봄</h2>
		<div class="cat-container">
			<ul class="category">
				<c:forEach items="${recipeNtrtList }" var="recipeNtrt">
				<c:if test="${recipeNtrt.food_ntrt_seas_cd == 'RC_SEAS01'}">
					<li><a class="ingredient fancybox.iframe" data-fancybox-group="iframe" href="/popup/recipeNtrtDetail.do?food_ntrt_no=${recipeNtrt.food_ntrt_no }">${recipeNtrt.food_ntrt_nm }</a></li>
				</c:if>
				</c:forEach>
			</ul>
		</div>
		
		<h2>여름</h2>
		<div class="cat-container">
			<ul class="category">
				<c:forEach items="${recipeNtrtList }" var="recipeNtrt">
				<c:if test="${recipeNtrt.food_ntrt_seas_cd == 'RC_SEAS02'}">
					<li><a class="ingredient fancybox.iframe" data-fancybox-group="iframe" href="food_ntrt_no=${recipeNtrt.food_ntrt_no }">${recipeNtrt.food_ntrt_nm }</a></li>
				</c:if>
				</c:forEach>
			</ul>
		</div>
		<h2>가을</h2>
		<div class="cat-container">
			<ul class="category">
				<c:forEach items="${recipeNtrtList }" var="recipeNtrt">
				<c:if test="${recipeNtrt.food_ntrt_seas_cd == 'RC_SEAS03'}">
					<li><a class="ingredient fancybox.iframe" data-fancybox-group="iframe" href="food_ntrt_no=${recipeNtrt.food_ntrt_no }">${recipeNtrt.food_ntrt_nm }</a></li>
				</c:if>
				</c:forEach>
			</ul>
		</div>
		<h2>겨울</h2>
		<div class="cat-container">
			<ul class="category">
				<c:forEach items="${recipeNtrtList }" var="recipeNtrt">
				<c:if test="${recipeNtrt.food_ntrt_seas_cd == 'RC_SEAS04'}">
					<li><a class="ingredient fancybox.iframe" data-fancybox-group="iframe" href="food_ntrt_no=${recipeNtrt.food_ntrt_no }">${recipeNtrt.food_ntrt_nm }</a></li>
				</c:if>
				</c:forEach>
			</ul>
		</div>
	</div>
</section>
        
<script language="JavaScript">

	/****************************************
	 * Variable
	****************************************/
	/****************************************
	 * Init
	****************************************/
	
	$(document).ready(function(){
		
		$(".ingredient").fancybox({
			maxWidth	: 855,
			maxHeight	: 770,
			minHeight	: 770,
			fitToView	: false,
			width		: '70%',
			height		: '80%',
			autoSize	: false,
			closeClick	: false,
			openEffect	: 'fade',
			closeEffect	: 'fade',
			tpl: {next : '', prev : ''}
		});
	}); 
	
	/****************************************
	 * Button Action
	 ****************************************/
    
	/****************************************
	 * Function
	 ****************************************/
    
</script>
