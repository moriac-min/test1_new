<%@page language="java"	contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<c:set var="contextPath" scope="request">${pageContext.request.contextPath}</c:set>

<!DOCTYPE html>
<html> 
<head>
	<!-- <jsp:include page="head.inc.jsp"/> -->
<meta http-equiv="Content-Script-Type" content="text/javascript" />

<link type="text/css" href="${contextPath}/css/bootstrap.min.css" rel="stylesheet">
<link type="text/css" href="${contextPath}/css/jquery.mCustomScrollbar.css" rel="stylesheet">
<link type="text/css" href="${contextPath}/css/jquery.selecter.css" rel="stylesheet">
<link type="text/css" href="${contextPath}/css/style_minwon.css" rel="stylesheet">
<link type="text/css" href="${contextPath}/css/jquery.fancybox.css" rel="stylesheet">
<link type="text/css" href="${contextPath}/css/datepicker.css" rel="stylesheet">

<script type="text/javascript" src="${contextPath}/js/jquery.js"></script>
<script type="text/javascript" src="${contextPath}/js/jquery.min.js"></script> 
<script type="text/javascript" src="${contextPath}/js/jquery.cookie.min.js"></script>
<script type="text/javascript" src="${contextPath}/js/jquery.navgoco.min.js"></script>
<script type="text/javascript" src="${contextPath}/js/highlight.pack.js"></script>
<script type="text/javascript" src="${contextPath}/js/jquery.selecter.min.js"></script>
<script type="text/javascript" src="${contextPath}/js/jquery.fancybox.js"></script>
<script type="text/javascript" src="${contextPath}/js/jquery.mousewheel.min.js"></script>
<script type="text/javascript" src="${contextPath}/js/common.js"></script>
<script type="text/javascript" src="${contextPath}/js/bootstrap/datepicker.js"></script>

<script>
//lightbox-iframe
$(document).ready(function() {
	$(".zipcode,.maker,.vendor").fancybox({
		maxWidth	: 800,
		maxHeight	: 760,
		minHeight	: 760,
		fitToView	: false,
		width		: '70%',
		height		: '80%',
		autoSize	: false,
		closeClick	: false,
		openEffect	: 'fade',
		closeEffect	: 'fade',
		tpl: {next : '', prev : ''},
		padding : 0,
		helpers : {overlay : {locked : false}}
	});
	$(".foodtype,.origin,.organization").fancybox({
		maxWidth	: 650,
		maxHeight	: 600,
		minHeight	: 600,
		fitToView	: false,
		width		: '70%',
		height		: '80%',
		autoSize	: false,
		closeClick	: false,
		openEffect	: 'fade',
		closeEffect	: 'fade',
		padding : 0,
		tpl: {next : '', prev : ''},
		helpers : {overlay : {locked : false}}
	});
	$(".realname").fancybox({
		maxWidth	: 650,
		maxHeight	: 500,
		minHeight	: 500,
		fitToView	: false,
		width		: '70%',
		height		: '80%',
		autoSize	: false,
		closeClick	: false,
		openEffect	: 'fade',
		closeEffect	: 'fade',
		padding : 0,
		tpl: {next : '', prev : ''},
		helpers : {overlay : {locked : false}}
	});
	$(".fileUpload").fancybox({
		maxWidth	: 530,
		maxHeight	: 350,
		minHeight	: 100,
		fitToView	: false,
		width		: '70%',
		height		: '80%',
		autoSize	: false,
		closeClick	: false,
		openEffect	: 'fade',
		closeEffect	: 'fade',
		tpl: {next : '', prev : ''},
		padding : 0,
		helpers : {overlay : {locked : false}}
	});
});
</script>
</head>
<body>
<form id="baseForm" name="baseForm">
<!-- 공통영역 -->
<input type="hidden" id="menu_no" name="menu_no" value="${menu_no}">
<input type="hidden" id="menu_grp" name="menu_grp" value="${menu_grp}">
<!-- 공통영역 -->

<div id="site">
<!-- <jsp:include page="${TEMPLATE.header}"/> -->
    <jsp:include page="header.jsp"/>
    <jsp:include page="/minwon/gnb.do"/>
    
     <!-- <a href="../portal/popup/sample.do" onclick="return openMembershipLink(this, 600, 500)">회원 전용 창 열기</a> -->
   
    <main>
    	<c:if test="${page_type eq 'sub'}">					<!-- 서브페이지로 진입시 -->
      	<jsp:include page="left.jsp"/>
      	<div id="content-wrap">
      		<!-- 실제 들어갈 페이지 -->
      		<jsp:include page="${MAIN_INCLUDE}"/>
        </div>
        </c:if>
        <c:if test="${page_type eq 'main'}">				<!-- 각 메인화면 진입시 -->
        	<jsp:include page="${MAIN_INCLUDE}"/>
        </c:if>
    </main>
   
    <footer>
    	<jsp:include page="../minwon/footer.jsp"/>
        <!-- <jsp:include page="${TEMPLATE.footer}"/> -->
    </footer>
  	</div>
  	<div id="back-top-wrapper">
	    <p id="back-top" style="display:block;"><a href="#top"><span>Back to Top</span></a></p>
	</div>
</form>
</body>
</html>

<script type="text/javascript">
// fade in #back-top
$(function () {
	$(window).scroll(function () {
		if ($(this).scrollTop() > 100) {
			$('#back-top').fadeIn();
		} else {
			$('#back-top').fadeOut();
		}
	});
	// scroll body to 0px on click
	$('#back-top a').click(function () {
		$('body,html').stop(false, false).animate({
			scrollTop: 0
		}, 800);
		return false;
	});
});

$(function(){
	$(window).load(function(){
      //menuTree
      if('${page_type}' == 'sub'){
      	$('#menuTree').html(menuTree);
      }	
    }); 

	// selectbox
	$(document).ready(function() {
		$("select").selecter();
	});
	$('.input-group.date').datepicker();
});

$(function(){
     
});



</script>
