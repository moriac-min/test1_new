<%@page language="java" contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<c:set var="contextPath" scope="request">${pageContext.request.contextPath}</c:set>

<section>
	 <div id="header">
	     <div class="board-head">
	         <div class="lnb-viewer" id="nav-open-btn" href="#left-nav">Menu</div>
	         <ol class="breadcrumb">
	             <li><a href="#">홈</a></li>
	             <li><a href="#">식품위해정보</a></li>
	             <li class="active">해외회수정보</li>
	         </ol>
	         <h1>해외회수정보</h1>
	         <p class="excerpt">미국 FDA 등 해외 국가기관에서 회수 조치한 위해식품을 공개합니다.<br>
	             소비자는 인터넷 등에서 해당 제품을 구입하거나 이미 구입한 제품은 섭취하지 마시기 바랍니다.</p>
	     </div>
	 </div>
	 <div class="view-container">
	     <article>
	         <div class="article-head">
	             <h2>${overseasRecall.overseasRecallDetail.titl}</h2>
	             <div class="meta">${overseasRecall.overseasRecallDetail.occrnc_dtm}<span class="writer">${overseasRecall.overseasRecallDetail.abbr_nm}</span></div>
	         </div>
	         <div class="article-body">
	             <div class="post">
	                 <pre style="border:none;">
	                 	${overseasRecall.overseasRecallDetail.cn}
	                 </pre>
                 </div>
                 <div class="caution">해당 정보를 무단으로 복제하거나 이용하는 경우 저작권법 등에 따라 법적책임을 질 수 있습니다.</div>
                 <div class="board-footer">
                     <a href="/" class="btn btn-default btn-left" role="button">이전글</a> 
                     <a href="/" class="btn btn-default btn-left" role="button">다음글</a> 
                     <a href="${contextPath}/portal/fooddanger/overseasRecall.do" class="btn btn-default btn-right" role="button">목록</a> 
                 </div>
             </div>
         </article>
         <aside>
             <ul class="share">
                 <li><a href="javascript:print();" class="print">프린트</a></li>
                 <li><a href="#" class="email">이메일</a></li>
                 <li><a href="#" class="fb">페이스북</a></li>
                 <li><a href="#" class="tw">트위터</a></li>
                 <li><a href="#" class="url">URL보내기</a></li>
             </ul>
             <div class="widget">
                 <h2 class="latest">최신 해외 회수정보</h2>
                 <ul class="wt-list">
                    <c:if test="${fn:length(overseasRecall.overseasRecallList) > 0}">
    					<c:forEach var="list" items="${overseasRecall.overseasRecallList}">
                       	<li>
                           <a href="${contextPath}/portal/fooddanger/overseasRecallDetail.do?search_keyword=${list.injry_esntl_no}">${list.titl}</a>
                           <span>${list.occrnc_dtm}</span>
                       	</li> 
       					</c:forEach>
  					</c:if>
                 </ul>
             </div>
         </aside>
     </div>
</section>