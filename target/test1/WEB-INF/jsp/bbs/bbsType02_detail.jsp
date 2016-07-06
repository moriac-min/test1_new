<%@ page language="java" contentType="text/html; charset=utf-8"
%><%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"
%><%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"
%><%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" 
%><%@ taglib prefix="m" uri="/WEB-INF/tlds/message.tld"
%><%@ page import="foodportal.common.util.Message"
%>
<c:set var="contextPath" scope="request">${pageContext.request.contextPath}</c:set>

  <div class="article-body">
      <div class="post">
          ${boardDetail.bdt}
      </div>
      <div class="caution">해당 정보를 무단으로 복제하거나 이용하는 경우 저작권법 등에 따라 법적책임을 질 수 있습니다.</div>
      <div class="like"><a href="#" class="btn btn-default btn-lg" role="button"><span class="icon-heart-empty">좋아요</span> <span id="rtrvl_cnt">${boardDetail.rtrvl_cnt}</span></a></div>   
      <div class="tag-wrap"><a href="#" class="tag">당뇨</a>, <a href="#" class="tag">당테크</a>, <a href="#" class="tag">당뇨병</a>, <a href="#" class="tag">성인병</a>, <a href="#" class="tag">혈당</a>, <a href="#" class="tag">40대</a></div> 
      <div class="board-footer">
         <a href="javascript:viewDetail('${boardDetail.pre_ntctxt_no}');" class="btn btn-default btn-left" role="button">이전글</a> 
         <a href="javascript:viewDetail('${boardDetail.post_ntctxt_no}');" class="btn btn-default btn-left" role="button">다음글</a> 
         <a href="javascript:moveBoardList();" class="btn btn-default btn-right" role="button">목록</a> 
      </div>
    <!-- ========== 연관 게시글 ========= -->

	<jsp:include page="relatedFrame.jsp"></jsp:include>

  	<!-- ========== 연관 게시글 ========= -->
  </div>