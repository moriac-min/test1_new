<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="m" uri="/WEB-INF/tlds/message.tld"%>
<%@ page import="foodportal.common.util.Message"%>

<c:set var="contextPath" scope="request">${pageContext.request.contextPath}</c:set>
<link type="text/css" href="${contextPath}/css/style_sub.css" rel="stylesheet">

	<div class="inner-head">
        <div class="category">식품안전캘린더</div>
        <h1>${result.title}</h1>
        <a href="javascrip:;" onClick="window.print();" class="print">프린트</a>
    </div>
    <div class="inner-body events">
        <div class="issue-info">
        	<dl>
            	<dt>장소</dt>
                <dd>${result.plc}</dd>
            	<dt>기간</dt>
                <dd>${result.begin_dt}
                 <c:if test="${end_dt eq ''}">
                 ~ 
                 ${result.end_dt}
                 </c:if>
                 </dd>
            </dl>
            <div class="emphasis">
                <p>${result.bdt}</p>
            </div>
        	<!-- <dl>
            	<dt>홈페이지</dt>
                <dd><a href="http://www.naver.com" target="_blank" title="[새창] 보령굴축제">http://www.naver.com</a></dd>
            </dl> -->
        </div>
        <div class="info-caption"><span class="info-text">이들 정보를 사용한 데 따르는 문제에 대한 모든 책임은 사용자에게 있습니다.</span></div>
    </div>
    <script>
    
  
  
    </script>