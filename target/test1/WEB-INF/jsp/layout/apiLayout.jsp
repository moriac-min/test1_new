<%@page language="java"	contentType="text/html; charset=utf-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<c:set var="contextPath" scope="request">${pageContext.request.contextPath}</c:set>

<!DOCTYPE html>
<html> 
<head>
<meta http-equiv="Content-Type" content="text/html;charset=UTF-8" />    <!-- 차트추가 -->
<meta http-equiv="Content-Script-Type" content="text/javascript" />

<link type="text/css" href="${contextPath}/css/bootstrap.min.css" rel="stylesheet">
<link type="text/css" href="${contextPath}/css/jquery.selecter.css" rel="stylesheet">
<link type="text/css" href="${contextPath}/css/style_share.css" rel="stylesheet">
<script type="text/javascript" src="${contextPath}/js/jquery.min.js"></script>
<script type="text/javascript" src="${contextPath}/js/jquery.cookie.min.js"></script>
<script type="text/javascript" src="${contextPath}/js/jquery.navgoco.min.js"></script>
<script type="text/javascript" src="${contextPath}/js/highlight.pack.js"></script>
<script type="text/javascript" src="${contextPath}/js/jquery.selecter.min.js"></script>
<script type="text/javascript" src="${contextPath}/js/jquery.simplePagination.js"></script>
<script type="text/javascript" src="${contextPath}/js/bootstrap.min.js"></script>
<script type="text/javascript" src="${contextPath}/js/bootstrap/tab.js"></script>
<script type="text/javascript" src="${contextPath}/js/common.js"></script>

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
    <jsp:include page="/api/gnb.do"/>
   
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
    	<jsp:include page="../api/footer.jsp"/>
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
});

</script>
