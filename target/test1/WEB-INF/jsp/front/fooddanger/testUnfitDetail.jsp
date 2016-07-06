<%@page language="java" contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="m" uri="/WEB-INF/tlds/message.tld"%>
<%@ page import="foodportal.common.util.Message"%>

<c:set var="contextPath" scope="request">${pageContext.request.contextPath}</c:set>
<link type="text/css" href="${contextPath}/css/style_sub.css" rel="stylesheet">

    <div class="inner-head">
        <div class="category">${testUnfit.testUnfitDetail.rtrvl_prvns}</div>
        <h1>${testUnfit.testUnfitDetail.prdt_nm}</h1><span class="meta">${testUnfit.testUnfitDetail.cret_dtm}</span>
    </div>
    <div class="inner-body">
    	<div class="product-img-wrap">
            <ul class="product-img">
             <c:if test="${fn:length(testUnfit.attachFileList) > 0}">
	         	<c:forEach var="fileList" items="${testUnfit.attachFileList}" varStatus="cnt">
                     <li><a href="${fileList.orgnt_file_nm}" target="_blank"><img src="${fileList.file_save_path}" title="${cnt.count}번 이미지"></a></li>
             	</c:forEach>
	         </c:if>
            </ul>
            <div id="thumbnail">
            <c:if test="${fn:length(testUnfit.attachFileList) > 0}">
	         	<c:forEach var="fileList" items="${testUnfit.attachFileList}" varStatus="cnt">
                     <a data-slide-index="${cnt.count}" href=""><img src="${fileList.file_save_path}" width="50px" height="50px" alt="${cnt.count}번 이미지 보기"></a>
             	</c:forEach>
	         </c:if>
            </div>
        </div>
        <div class="issue-info">
        	<dl class="set">
            	<dt>부적합항목</dt>
                <dd>${testUnfit.testUnfitDetail.impropt_test_itm}</dd>
            	<dt>기준규격</dt>
                <dd>${testUnfit.testUnfitDetail.impropt_test_itm_stnd}</dd>
            	<dt>검사결과</dt>
                <dd>${testUnfit.testUnfitDetail.impropt_test_itm_rslt}</dd>
            </dl>
        	<dl class="set">
            	<dt>식품유형</dt>
                <dd>${testUnfit.testUnfitDetail.prdt_type_nm}</dd>
            	<dt>업체명</dt>
                <dd>${testUnfit.testUnfitDetail.bssh_nm}</dd>
            	<dt>업체소재지</dt>
                <dd>${testUnfit.testUnfitDetail.addr_dtl}</dd>
            	<dt>제조일자</dt>
                <dd>${testUnfit.testUnfitDetail.mnf_dt}</dd>
            	<dt>바코드번호</dt>
                <dd>${testUnfit.testUnfitDetail.prdt_brcd}</dd>
            	<dt>포장단위</dt>
                <dd>${testUnfit.testUnfitDetail.frmlc_unit}</dd>
            </dl>
        	<dl class="set">
            	<dt>검사기관</dt>
                <dd>${testUnfit.testUnfitDetail.prsec_insttnm}</dd>
            	<dt>전화번호</dt>
                <dd>${testUnfit.testUnfitDetail.prsec_instt_telno}</dd>
            </dl>
        </div>
        <div class="info-caption"><span class="info-text">이들 정보를 사용한 데 따르는 문제에 대한 모든 책임은 사용자에게 있습니다.</span><span class="charge">담당자 <strong>${testUnfit.testUnfitDetail.cmmnd_charger_nm}</strong> (${testUnfit.testUnfitDetail.dsps_insttcd_nm}, ${testUnfit.testUnfitDetail.cmmnd_charger_telno})</span></div>
    </div>