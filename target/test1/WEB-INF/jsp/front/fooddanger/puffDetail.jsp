<%@page language="java" contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="m" uri="/WEB-INF/tlds/message.tld"%>
<%@ page import="foodportal.common.util.Message"%>

<c:set var="contextPath" scope="request">${pageContext.request.contextPath}</c:set>
<link type="text/css" href="${contextPath}/css/style_sub.css" rel="stylesheet">

    <div class="inner-head">
        <h1>${puff.puffDetail.bssh_nm}</h1><span class="meta">${puff.puffDetail.cret_dtm}</span>
    </div>
    <div class="inner-body full">
        <div class="issue-info">
        	<dl>
            	<dt>업체소재지</dt>
                <dd>${puff.puffDetail.addr_dtl}</dd>
            	<dt>제품명</dt>
                <dd>${puff.puffDetail.prdt_nm}</dd>
            </dl>
        	<dl>
            	<dt>위반내용</dt>
                <dd>${puff.puffDetail.othbc_vilt_cn}</dd>
            	<dt>위반법령</dt>
                <dd>${puff.puffDetail.admst_dsps_vilt_laword_dtl}</dd>
            	<dt>처분명</dt>
                <dd>${puff.puffDetail.dsps_stdr_cd_nm}</dd>
            	<dt>처분일</dt>
                <dd>${puff.puffDetail.admst_dsps_dt}</dd>
            	<dt>조사기관</dt>
                <dd>${puff.puffDetail.instt_nm}</dd>
            </dl>
        	<dl>
            	<dt>증거파일</dt>
                <dd>
                	<c:if test="${fn:length(puff.attachFileList) > 0}">
                	<c:forEach var="fileList" items="${puff.attachFileList}">
		                <a href="${fileList.file_save_path}" target="_blank" title="파일을 다운로드 합니다.">${fileList.orgnt_file_nm}</a><br>
                	</c:forEach>
                	</c:if>
                </dd>
            </dl>
        </div>
        <div class="info-caption"><span class="info-text">이들 정보를 사용한 데 따르는 문제에 대한 모든 책임은 사용자에게 있습니다.</span><span class="charge">담당자 <strong>송광영</strong> (식품관리총괄과, 043-719-2059)</span></div>
    </div>
