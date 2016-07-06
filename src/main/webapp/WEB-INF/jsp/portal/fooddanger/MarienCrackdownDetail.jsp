<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="m" uri="/WEB-INF/tlds/message.tld"%>
<%@ page import="foodportal.common.util.Message"%>

<c:set var="contextPath" scope="request">${pageContext.request.contextPath}</c:set>
<link type="text/css" href="${contextPath}/css/style_sub.css" rel="stylesheet">

<form id="detailForm" name="detailForm">
    <div class="inner-head">
        <div class="category">${crackdownDetail.bizcnd_dvs_nm}</div>
        <h1>
        ${crackdownDetail.entrps_nm}    <!-- 점포명 -->
        </h1><span class="meta">${crackdownDetail.dspth_dtm}</span>  <!-- 통보일시 처분일 -->
    </div>
    <div class="inner-body full">
        <div class="issue-info">
            <dl>
                <dt>업체소재지</dt>
                <dd>${crackdownDetail.entrps_bass_addr}  ${crackdownDetail.entrps_dtl_addr}</dd>
                <dt>제품명</dt>
                <dd>${crackdownDetail.prdlst_nm}</dd>
            </dl>
            <dl>
                <dt>위반구분</dt>
                <dd>${crackdownDetail.vilt_matr_dvs}</dd>
                <dt>위반내용</dt>
                <dd>${crackdownDetail.vilt_matr_dvs_nm}</dd>
                <dt>처분내용</dt>
                <dd>${crackdownDetail.dsps_dtls_dvs_nm}</dd>
                <dt>처분일</dt>
                <dd>${crackdownDetail.dspth_dtm}</dd>
                <dt>처분권자</dt>
                <dd>${crackdownDetail.prcs_instt_nm}</dd>
            </dl>
        </div>
        <div class="info-caption"><span class="info-text">이들 정보를 사용한 데 따르는 문제에 대한 모든 책임은 사용자에게 있습니다.</span></div>
    </div>
</form>
