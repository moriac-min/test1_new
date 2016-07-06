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
<link type="text/css" href="${contextPath}/css/webfont.css" rel="stylesheet">
<link type="text/css" href="${contextPath}/css/jquery.mCustomScrollbar.css" rel="stylesheet">
<link type="text/css" href="${contextPath}/css/jquery.selecter.css" rel="stylesheet">
<link type="text/css" href="${contextPath}/css/style_${page_type}.css" rel="stylesheet">
<link type="text/css" href="${contextPath}/css/nivo-slider.css"  rel="stylesheet">
<link type="text/css" href="${contextPath}/css/jquery.fancybox.css" rel="stylesheet">

<script type="text/javascript" src="${contextPath}/js/jquery.js"></script>
<script type="text/javascript" src="${contextPath}/js/jquery.min.js"></script>
<script type="text/javascript" src="${contextPath}/js/jquery.sidr.min.js"></script>
<script type="text/javascript" src="${contextPath}/js/jquery.selecter.min.js"></script>
<script type="text/javascript" src="${contextPath}/js/jquery.simplePagination.js"></script>
<script type="text/javascript" src="${contextPath}/js/bootstrap/tab.js"></script>
<script type="text/javascript" src="${contextPath}/js/jquery.cookie.min.js"></script>
<script type="text/javascript" src="${contextPath}/js/jquery.navgoco.min.js"></script>
<script type="text/javascript" src="${contextPath}/js/highlight.pack.js"></script>
<script type="text/javascript" src="${contextPath}/js/demo.js"></script>
<script type="text/javascript" src="${contextPath}/js/jquery.mCustomScrollbar.concat.min.js"></script>
<script type="text/javascript" src="${contextPath}/js/bootstrap/collapse.js"></script>
<script type="text/javascript" src="${contextPath}/js/jquery.fancybox.js"></script>
<script type="text/javascript" src="${contextPath}/js/jquery.mousewheel.min.js"></script>
<script type="text/javascript" src="${contextPath}/js/jquery.nivo.slider.min.js"></script> 
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
    <jsp:include page="/portal/gnb.do"/>
    <!-- <a href="/portal/popup/sample.do" onclick="return openMembershipLink(this, 600, 500)">회원 전용 창 열기</a> 이동련이사님  SSO 작업하신 부분  -->			
    
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
    	<jsp:include page="../portal/footer.jsp"/>
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

    $(document).ready(function() {
        
        
    });

    $(function(){
        $(window).load(function(){
            $("#left-nav.left-nav").mCustomScrollbar({
                theme:"minimal-dark"
            });
            
            // Tab
            $('#tabs a:first').tab('show');
            
          	//Accordion
            $('#accordion').collapse();
          	
          	//pagination
            $('.pagination').pagination({
                items: 100,
                itemsOnPage: 10,
                cssStyle: 'compact-theme'
            });
          	
          	//menuTree
            if('${page_type}' == 'sub'){
            	$('#menuTree').html(menuTree);
            }
          	
         	// selectbox
            $(document).ready(function() {
                $("select").selecter();
                
                $('#nav-open-btn').sidr({
                    name: 'left-nav',
                    side: 'left' // By default
                });
            });
        });    
    });
    
    </script>
