<%@page language="java" contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<c:set var="contextPath" scope="request">${pageContext.request.contextPath}</c:set>

<meta charset="UTF-8">
<title>
   <c:if test="${sys_dvs_cd == 'SITE01'}">:::: 식품안전정보포털 ::::</c:if>
   <c:if test="${sys_dvs_cd == 'SITE02'}">:::: 통합민원신고센터 ::::</c:if>
   <c:if test="${sys_dvs_cd == 'SITE03'}">:::: 데이터활용서비스 ::::</c:if>
   <c:if test="${sys_dvs_cd == 'SITE04'}">:::: 우리회사안전관리서비스 ::::</c:if>
</title>
<meta http-equiv="X-UA-Compatible" id="document_mode" content="IE=edge"/>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <header class="top">
        <div id="globals">
            <div class="global-wrap-left">
            <c:if test="${sys_dvs_cd != 'SITE01'}"><a href='/portal/main.do'><span class="icon-01">식품안전정보포털</span></a></c:if>
            <c:if test="${sys_dvs_cd != 'SITE02'}"><a href='/minwon/main.do'><span class="icon-01">통합민원신고센터</span></a></c:if>
            <c:if test="${sys_dvs_cd != 'SITE03'}"><a href='/api/main.do'><span class="icon-02">데이터활용서비스</span></a></c:if>
            <c:if test="${sys_dvs_cd != 'SITE04'}"><a href='/csm/main.do'><span class="icon-03">우리회사 안전관리서비스</span></a></c:if>
            </div>
            <div class="global-wrap-right"> <a href='#'><span class="icon-04">회원가입</span></a> <a href='#'><span class="icon-05">로그인</span></a> 
              <!--a href='#'><span class="icon-08">food(홍길동)</span></a>
              <a href='#'><span class="icon-07">로그아웃</span></a--> 
              <a href='#'><span class="icon-06">사이트맵</span></a> 
            </div>
        </div>
        <c:if test="${sys_dvs_cd eq 'SITE01'}"><a href="/portal/main.do" id="identity">식품의약품안전처 식품안전정보포털</a></c:if>
        <c:if test="${sys_dvs_cd eq 'SITE02'}"><a href="/minwon/main.do" id="identity">식품의약품안전처 통합민원상담센터</a></c:if>
        <c:if test="${sys_dvs_cd eq 'SITE03'}"><a href="/api/main.do" id="identity">식품의약품안전처 데이터활용서비스</a></c:if>
        <c:if test="${sys_dvs_cd eq 'SITE04'}"><a href="/csm/main.do" id="identity">식품의약품안전처 우리회사안전관리</a></c:if>
        <div id="search">
                <legend></legend>
                <fieldset>
                    <input type="text" id="keyword" title="검색어를 입력하세요.">
                    <a href='#' class="search"><span>검색</span></a>
                </fieldset>
            <div class="keyword"> 인기검색어 
            	<a href='/'>방사능</a>
            	<a href='/'>벤조피렌</a>
            	<a href='/'>식중독</a>
            	<a href='/'>MSG</a>
            	<a href='/'>산나물</a>
            	<a href='http://localhost/minwon/civilTest.do?menu_grp=MENU_GRP21'>전자민원테스트</a>
            </div>
        </div>
    </header>
    