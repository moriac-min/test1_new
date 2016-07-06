<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="m" uri="/WEB-INF/tlds/message.tld"%>
<%@ page import="foodportal.common.util.Message"%>
<c:set var="contextPath" scope="request">${pageContext.request.contextPath}</c:set>
<link type="text/css" href="${contextPath}/css/style_sub.css" rel="stylesheet">

<form id="detailForm" name="detailForm">
    <div class="inner-head">
        <div class="category">${administMeasureDetail.induty_cd_nm}</div>
        <h1>${administMeasureDetail.bssh_nm}</h1>
        <!-- <span class="meta">2014.101.10</span> -->
    </div>
    <div class="inner-body full">
        <div class="issue-info">
            <dl>
                <dt>업체소재지</dt>
                <dd>${administMeasureDetail.addr_dtl}</dd>
                <dt>대표자명</dt>
                <dd>${administMeasureDetail.prsdnt_nm}</dd>
                <dt>제품명</dt>
                <dd>${administMeasureDetail.prdtnm}</dd>
            </dl>
            <dl>
                <dt>위반내용</dt>
                <dd>${administMeasureDetail.viltcn}</dd>
                <dt>위반법령</dt>
                <dd>${administMeasureDetail.vilt_lawordcd_nm}</dd>
                <dt>처분명</dt>
                <dd>${administMeasureDetail.dsps_stdrcd_nm}</dd>
                <dt>처분일</dt>
                <dd>${administMeasureDetail.dsps_bgndt}</dd>
                <dt>담당부서</dt>
                <dd>${administMeasureDetail.dsps_insttcd_nm}</dd>
            </dl>
        </div>
        <div class="info-caption"><span class="info-text">이들 정보를 사용한 데 따르는 문제에 대한 모든 책임은 사용자에게 있습니다.</span><span class="charge"><%-- 담당자 <strong>${administMeasureDetail.bssh_nm}</strong>  --%></span></div>
    </div>

</form>
