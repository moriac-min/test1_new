<%@page language="java" contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<c:set var="contextPath" scope="request">${pageContext.request.contextPath}</c:set>
<link type="text/css" href="${contextPath}/css/style_sub.css" rel="stylesheet">


<div class="inner-head">
    <div class="category">${suspension.suspensionDetail.rtrvlprvns}</div>
    <h1>${suspension.suspensionDetail.prdtnm}</h1><span class="meta">${suspension.suspensionDetail.rtrvlconsd_dcsndtm}</span>
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
    	<dl>
        	<dt>제조일자 또는 유통기한</dt>
            <dd>${suspension.suspensionDetail.mnfdt}</dd>
        	<dt>회수방법</dt>
            <dd>${suspension.suspensionDetail.rtrvlplandoc_rtrvlmthd}</dd>
        	<dt>회수영업자<br>(제조 및 수입.판매업체)</dt>
            <dd>${suspension.suspensionDetail.mnfrgcownm}/${suspension.suspensionDetail.incmbsshnm}/${suspension.suspensionDetail.salbizcownm}</dd>
        	<dt>영업자주소</dt>
            <dd>${suspension.suspensionDetail.mnfrgcow_aracd_dtladdr}</dd>
        	<dt>전화번호</dt>
            <dd>${suspension.suspensionDetail.telno1}</dd>
        	<dt>바코드번호</dt>
            <dd>${suspension.suspensionDetail.brcdno}</dd>
        	<dt>포장단위</dt>
            <dd>${suspension.suspensionDetail.frmlc_unit}</dd>
        </dl>
        <ul>
        	<li>* 당해 회수 대상 식품 등을 보관하고 있는 판매자는 판매를 중지하고 회수영업자에게 반품하여 주시기 바랍니다.</li>
            <li>* 동제품을 구입한 소비자께서는 구입한 업소에 되돌려 주시는 등 부적합 식품 회수에 적극 협조하여 주시기 바랍니다.</li> 
        </ul>
    </div>
    <div class="info-caption"><span class="info-text">이들 정보를 사용한 데 따르는 문제에 대한 모든 책임은 사용자에게 있습니다.</span><span class="charge">담당자 <strong>${suspension.suspensionDetail.rtrvlrsltreprt_regstr_id}</strong> (${suspension.suspensionDetail.rtrvlrsltreprt_regstr_deptnm}, ${suspension.suspensionDetail.regstr_telno})</span></div>
</div>
