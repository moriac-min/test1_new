<%@page language="java" contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="m" uri="/WEB-INF/tlds/message.tld"%>
<%@ page import="foodportal.common.util.Message"%>

<c:set var="contextPath" scope="request">${pageContext.request.contextPath}</c:set>
<link type="text/css" href="${contextPath}/css/style_sub.css" rel="stylesheet">

    <div class="inner-head">
        <div class="category">${testUnfit.testUnfitDetail.test_itmnm}</div>
        <h1>${testUnfit.testUnfitDetail.prdtnm}</h1><span class="meta">${testUnfit.testUnfitDetail.hmpgpblict_prcsdtm}</span>
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
                <dd>${testUnfit.testUnfitDetail.test_itmnm}</dd>
            	<dt>기준규격</dt>
                <dd>${testUnfit.testUnfitDetail.stdr_stnd}</dd>
            	<dt>검사결과</dt>
                <dd>${testUnfit.testUnfitDetail.testanals_rsltnm}</dd>
            </dl>
        	<dl class="set">
            	<dt>식품유형</dt>
                <dd>${testUnfit.testUnfitDetail.prdlst_cd_nm}</dd>
            	<dt>업체명</dt>
                <dd>${testUnfit.testUnfitDetail.bsshnm}</dd>
            	<dt>업체소재지</dt>
                <dd>${testUnfit.testUnfitDetail.addr_dtl}</dd>
            	<dt>제조일자</dt>
                <dd>${testUnfit.testUnfitDetail.mnfdt}</dd>
            	<dt>바코드번호</dt>
                <dd>${testUnfit.testUnfitDetail.brcdno}</dd>
            	<dt>포장단위</dt>
                <dd>${testUnfit.testUnfitDetail.frmlc_unit}</dd>
            </dl>
        	<dl class="set">
            	<dt>검사기관</dt>
                <dd>${testUnfit.testUnfitDetail.prsec_insttcd_nm}</dd>
            	<dt>전화번호</dt>
                <dd>${testUnfit.testUnfitDetail.prsec_insttcd_telno}</dd>
            </dl>
        </div>
        <div class="info-caption"><span class="info-text">이들 정보를 사용한 데 따르는 문제에 대한 모든 책임은 사용자에게 있습니다.</span><span class="charge">담당자 <strong>${testUnfit.testUnfitDetail.hmpgpblict_opetr_nm}</strong> (${testUnfit.testUnfitDetail.hmpgpblict_opetr_deptnm}, ${testUnfit.testUnfitDetail.hmpgpblict_opetr_telno})</span></div>
    </div>