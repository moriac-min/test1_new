<%@page language="java" contentType="text/html; charset=utf-8"
%><%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"
%><%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"
%><%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"
%>

<c:set var="contextPath" scope="request">${pageContext.request.contextPath}</c:set>

<script language="JavaScript">
function goSearch(idx){
	$('#rvlv_no').val(idx);
	$('#search_word').val('');
	
	$('#searchForm').attr('method', 'post');
	//$('#searchForm').attr('target', '_self');
	$('#searchForm').submit();
}

function goSearchText(){
	if (!$('#search_word').val()) {
		alert('검색어를 입력해 주세요.');
		$('#search_word').focus();
		return;
	}
	
	$('#searchForm').attr('method', 'post');
	$('#searchForm').submit();
}

function goPop(site_url) {
    window.open(site_url, 'popup_modify', 'width=1024, height=768, resizable=yes, scrollbars=yes');
}
</script>

<form id="searchForm" name="searchForm">
	<input type="hidden" id="rvlv_no" name="rvlv_no"/>
            <section>
                <div id="header">
                    <div class="board-head">
                        <div class="lnb-viewer" id="nav-open-btn" href="#left-nav">Menu</div>
                        <ol class="breadcrumb">
                            <li><a href="#">홈</a></li>
                            <li><a href="#">안전한 식생활</a></li>
                            <li><a href="#">식품</a></li>
                            <li><a href="#">식품공전</a></li>
                            <li class="active">식품공전</li>
                        </ol>
                        <h1>식품공전</h1>
                    </div>
                </div>
                <div class="page-container">
                	<!-- 페이지 내용 -->
                    <article>
                    	<p class="codex-update">최종개정고시일자 : 2014년 09월 11일</p>
						<ul class="codex-index">
                <c:if test="${fn:length(foodRvlvTopList) gt 0}">
                	<c:forEach var="foodRvlv" items="${foodRvlvTopList}" varStatus="status">
                		<c:choose>
                			<c:when test="${foodRvlv.rvlv_no eq '108'}">
                        	<li><a href="javaScript:goPop('${foodRvlv.cn}');">${foodRvlv.titl}</a></li>
                			</c:when>
                			<c:otherwise>
                        	<li><a href="javaScript:goSearch('${foodRvlv.rvlv_no}');">${foodRvlv.titl}</a></li>
                			</c:otherwise>
                		</c:choose>
                </tr>
                <tr>
                	</c:forEach>
                </c:if>
                        </ul>
                        <div class="codex-search">
                            <form id="searchForm" name="searchForm" action="#" method="post">
                                <fieldset>
                                    <legend>검색</legend>
                                    <label for="codex-keyword">검색어</label>
                                    <input type="text" id="codex-keyword" name="search_word" value="${search_word}"><a href="javaScript:goSearchText();" class="btn btn-default" role="button">검색</a>
                                </fieldset>
                            </form>
                        </div>


          <c:choose>
			<c:when test="${fn:length(foodRvlvList) le 0}">
          		<br/><br/>
          		<font size="4"><center>검색된 내용이 없습니다.</center></font>
          		<br/><br/>
			</c:when>
			<c:otherwise>
				<c:forEach var="foodRvlv" items="${foodRvlvList}" varStatus="status">
					<c:if test="${foodRvlv.hrnk_no eq '0'}">
							<h2>${foodRvlv.titl}</h2>
					</c:if>
				</c:forEach>
				
				
                        <ul class="codex-list">
				<c:forEach var="foodRvlv" items="${foodRvlvList}" varStatus="status">
					<c:choose>
						<c:when test="${foodRvlv.hrnk_no eq '0'}">
						</c:when>
						<c:when test="${foodRvlv.etc1 ne 'DEPT-LAST'}">
                        	<li>${foodRvlv.titl}
                        	</li>
						</c:when>
						<c:otherwise>
                        	<li><a class="codex fancybox.iframe" data-fancybox-group="iframe" href="foodRvlvDetail.do?rvlv_no=${foodRvlv.rvlv_no}">${foodRvlv.titl}</a></li>
						</c:otherwise>
					</c:choose>
				</c:forEach>
                        </ul>
			</c:otherwise>
          </c:choose>

<!--
                        	<li>1. 식품성분시험법
                            	<ul>
                                	<li>1.1 일반성분시험법
                                    	<ul>
                                        	<li>1.1.1 수분
                                            	<ul>
                                                	<li><a class="codex fancybox.iframe" data-fancybox-group="iframe" href="food_standards_codex.html">1.1.1.1 건조감량법</a></li>
                                                	<li><a class="codex fancybox.iframe" data-fancybox-group="iframe" href="food_standards_codex.html">1.1.1.2 증류법</a></li>
                                                	<li><a class="codex fancybox.iframe" data-fancybox-group="iframe" href="food_standards_codex.html">1.1.1.3 칼피셔법</a></li>
                                                </ul>
                                            </li>
                                        	<li><a class="codex fancybox.iframe" data-fancybox-group="iframe" href="food_standards_codex.html">1.1.2 회분</a></li>
                                        </ul>
                                    </li>
                                </ul>
                            </li>
-->
                    </article>
                    <!-- ASIDE -->
                    <aside>
                        <ul class="share">
                            <li><a href="javascript:print();" class="print">프린트</a></li>
                            <li><a href="#" class="email">이메일</a></li>
                            <li><a href="#" class="fb">페이스북</a></li>
                            <li><a href="#" class="tw">트위터</a></li>
                            <li><a href="#" class="url">URL보내기</a></li>
                        </ul>
                        <div class="widget">
                            <h2 class="latest">최신게시글</h2>
                            <ul class="wt-list">
                                <li>
                                    <a href="#">어린이건강메뉴 – 한국식 오코노미야끼</a>
                                    <span>2014.10.28</span>
                                </li> 
                                <li>
                                    <a href="#">봄나물 바로알기 – 가득 봄 내음 물씬 나는 봄
    나물 예찬</a>
                                    <span>2014.10.28</span>
                                </li> 
                                <li>
                                    <a href="#">식중독균 이런 것들이 있어요</a>
                                    <span>2014.10.28</span>
                                </li> 
                                <li>
                                    <a href="#">여름철 음식관리법과 휴가지 음식관리요령</a>
                                    <span>2014.10.28</span>
                                </li> 
                                <li>
                                    <a href="#">무리한 다이어트의 역효과, 식사장애 </a>
                                    <span>2014.10.28</span>
                                </li> 
                            </ul>
                        </div>
                        <div class="widget">
                            <h2 class="popular">인기게시글</h2>
                            <ul class="wt-list">
                                <li>
                                    <a href="#">어린이건강메뉴 – 한국식 오코노미야끼</a>
                                    <span>2014.10.28</span>
                                </li> 
                                <li>
                                    <a href="#">봄나물 바로알기 – 가득 봄 내음 물씬 나는 봄나물 예찬</a>
                                    <span>2014.10.28</span>
                                </li> 
                                <li>
                                    <a href="#">식중독균 이런 것들이 있어요</a>
                                    <span>2014.10.28</span>
                                </li> 
                                <li>
                                    <a href="#">여름철 음식관리법과 휴가지 음식관리요령</a>
                                    <span>2014.10.28</span>
                                </li> 
                                <li>
                                    <a href="#">무리한 다이어트의 역효과, 식사장애 </a>
                                    <span>2014.10.28</span>
                                </li> 
                            </ul>
                        </div>
                        <div class="widget">
                            <h2 class="reporter">공감리포터</h2>
                            <ul class="wt-thumbnail">
                                <li>
                                    <img src="${contextPath}/img/sample-77x77.png" alt="어린이건강메뉴 – 한국식 오코노미야끼"> 
                                    <a href="#">어린이건강메뉴 – 한국식 오코노미야끼</a>
                                    <span>2014.10.28</span>
                                </li> 
                                <li>
                                    <img src="${contextPath}/img/sample-77x77.png" alt="봄나물 바로알기 – 가득 봄 내음 물씬 나는 봄나물 예찬"> 
                                    <a href="#">봄나물 바로알기 – 가득 봄 내음 물씬 나는 봄나물 예찬</a>
                                    <span>2014.10.28</span>
                                </li> 
                                <li>
                                    <img src="${contextPath}/img/sample-77x77.png" alt="식중독균 이런 것들이 있어요"> 
                                    <a href="#">식중독균 이런 것들이 있어요</a>
                                    <span>2014.10.28</span>
                                </li> 
                            </ul>
                        </div>
                    </aside>
                </div>
            </section>
</form>