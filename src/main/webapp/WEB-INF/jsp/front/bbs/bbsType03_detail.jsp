<%@ page language="java" contentType="text/html; charset=utf-8"
%><%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"
%><%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"
%><%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" 
%><%@ taglib prefix="m" uri="/WEB-INF/tlds/message.tld"
%><%@ page import="foodportal.common.util.Message"
%>
<c:set var="contextPath" scope="request">${pageContext.request.contextPath}</c:set>
	
	<!--
     <div id="header">
        <div class="article-head">
            <div class="lnb-viewer" id="nav-open-btn" href="#left-nav">Menu</div>
            <ol class="breadcrumb">
                <li><a href="#">홈</a></li>
                <li><a href="#">건강한 식생활</a></li>
                <li><a href="#">식품과 영양</a></li>
                <li class="active">당</li>
            </ol>
            <h1>대표 성인병 ‘당뇨병’ 당(糖)테크를 시작하자</h1>
            <p class="excerpt">지난 2008년 한국건강관리협회에서 건강검진을 받은 40대 근로자 가운데 27%에서 혈당 수치가 정상이 아닌 것으로 나타났다.</p>
            <div class="meta">2014.10.28</div>
        </div>
        <figure> <img src="../../img/sample-575x383.png" width="575" height="383" alt="대표 성인병 ‘당뇨병’ 당(糖)테크를 시작하자">
            <figcaption>40대의 당뇨병 예방과 관리는 건강수명 10년을 보장하는 확실한 투자임을 기억하자. 당뇨병을 놓치면 돈도 잃고 건강수명도 잃는다.</figcaption>
        </figure>
    </div>
    <div class="figcaption">40대의 당뇨병 예방과 관리는 건강수명 10년을 보장하는 확실한 투자임을 기억하자. 당뇨병을 놓치면 돈도 잃고 건강수명도 잃는다.</div>  -->
    	<div id="contentFrame">
    		${boardDetail.bdt}
    	</div>
    	<div class="like"><a href="#" class="btn btn-default btn-lg" role="button"><span class="icon-heart-empty">좋아요</span> <span id="rtrvl_cnt">${boardDetail.rtrvl_cnt}</span></a></div>   
     	<c:if test="${boardSetting.tag_use_yn == 'Y'}">
     	<div class="tag-wrap">
     		<c:forEach var="tagList" items="${tagList}" varStatus="tagStatus">
     		<a href="#" class="tag">${tagList.tag}</a> 
     		</c:forEach>
     	</div> 
     	</c:if>
     	<c:if test="${boardSetting.bbs_type_cd != '04'}">
        <a href="javascript:moveBoardList();" class="btn btn-default btn-right" role="button">목록</a> 
     	</c:if>
        <!-- ========== 연관 게시글 ========= -->
        <c:if test="${boardSetting.bbs_type_cd != '04'}">
        <jsp:include page="relatedFrame.jsp"></jsp:include>
        </c:if>
        <!-- ========== 연관 게시글 ========= -->
