<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="m" uri="/WEB-INF/tlds/message.tld"%>
<%@ page import="foodportal.common.util.Message"%>

<c:set var="contextPath" scope="request">${pageContext.request.contextPath}</c:set>

<link type="text/css" href="${contextPath}/css/style_sub.css" rel="stylesheet">

	<div class="inner-head">
        <div class="category">${result.ctgrynm}</div>
        <h1>${result.titl}</h1>
        <a href="javascrip:return false;" onClick="window.print();" class="print">프린트</a>
    </div>
    <div class="inner-body">
    	<c:if test="${result.img_link_url != 'NONE'}">					<!-- 대표이미지가 없을시 -->
    	<div class="street-img img-400x205" style="background-image:url('${contextPath}${result.img_link_url}')"></div>
    	</c:if>
    	<c:if test="${result.img_link_url eq 'NONE'}">					<!-- 대표이미지가 없을시 -->
    	<div class="street-img img-400x205 no"></div>
    	</c:if>
        <article class="street-info">
        	${result.bdt}
        </article>
        <div class="info-caption"><span class="info-text">이들 정보를 사용한 데 따르는 문제에 대한 모든 책임은 사용자에게 있습니다.</span></div>
    </div>
 