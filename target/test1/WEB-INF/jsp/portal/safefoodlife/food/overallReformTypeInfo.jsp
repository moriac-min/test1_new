<%@page language="java" contentType="text/html; charset=utf-8"
%><%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"
%><%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"
%><%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"
%>

<c:set var="contextPath" scope="request">${pageContext.request.contextPath}</c:set>

<script language="JavaScript">

function goSearch() {
	//alert($('#search_word').val());
	$('#infoForm').submit();
}

function goNote(i) {
	alert($('#NOTE_'+i).val());
}

</script>

<form id="infoForm" name="infoForm" method="post">
            <section>
                <div id="header">
                    <div class="board-head">
                        <div class="lnb-viewer" id="nav-open-btn" href="#left-nav">Menu</div>
                        <ol class="breadcrumb">
                            <li><a href="#">홈</a></li>
                            <li><a href="#">안전한 식생활</a></li>
                            <li><a href="#">식품</a></li>
                            <li><a href="#">식품공전</a></li>
                            <li class="active">전면개정관련유형안내</li>
                        </ol>
                        <h1>전면개정관련유형안내</h1>
                    </div>
                </div>
                <div class="page-container">
                	<!-- 페이지 내용 -->
                    <article>
                    	<div class="bs-callout bs-callout-info">
                        	<h3>안내문</h3>
                        	<p>동 안내 프로그램은 식품공전 전면개정 (식약청 고시 제2007-7호, 2007.10.30에 따른 식품유형의 이관신설, 통합변경, 신규신설 등의 변경사항에 대하여 민원인의 이해를 도모하고자 제공하는 참고자료이며, 정확한 유형분류룰 위해서는 식품의약품안전처 식품기준과(043-719-2428) 또는 가까운 시, 군, 구청으로 문의해 주시기 바랍니다.</p>
                        </div>
                        <div class="revision-search">
                            <form id="searchForm" name="searchForm" action="#" method="post">
                                <fieldset>
                                    <legend>검색</legend>
                                    <label for="revision-keyword">검색어</label>
                                    <input type="text" id="revision-keyword" name="search_word" value="${search_word}"><a href="javascript:goSearch();" class="btn btn-default" role="button">검색</a>
                                </fieldset>
                            </form>
                        </div>
                        <p class="emphasis">이번 전면개정에서 새롭게 신설된 유형으로 기타과당, 겐티오올리고당, 조미된장, 조미고추장, 기타장류,김칫속, (즉석섭취ㆍ편의식품류)이 있으며, 동유형으로 분류되어야 하는 식품들이 다른 유형으로 분류되지 않도록 주의하시기 바랍니다.</p>
                        <h2>식품유형의 변경</h2>
                        <div id="revision">
                            <table>
                                <caption>식품유형의 변경</caption>
                                <colgroup style="width:40%">
                                    <col style="width:10%;">
                                    <col style="width:10%;">
                                    <col style="width:10%;">
                                    <col style="width:10%;">
                                </colgroup>
                                <colgroup style="width:40%">
                                    <col style="width:10%;">
                                    <col style="width:10%;">
                                    <col style="width:10%;">
                                    <col style="width:10%;">
                                </colgroup>
                                <col style="width:10%;">
                                <col style="width:10%;">
                                <thead>
                                    <tr>
                                        <th colspan="4" scope="col">개정 전</th>
                                        <th colspan="4" scope="col">개정 후</th>
                                        <th rowspan="2" scope="col">다운로드</th>
                                        <th rowspan="2" scope="col">비고</th>
                                    </tr>
                                    <tr>
                                        <th scope="col">식품군</th>
                                        <th scope="col">식품종</th>
                                        <th scope="col">식품유형</th>
                                        <th scope="col">세부유형</th>	
                                        <th scope="col">식품군</th>
                                        <th scope="col">식품종</th>
                                        <th scope="col">식품유형</th>
                                        <th scope="col">세부유형</th>	
                                    </tr>
                                </thead>
                                <tbody>
                                <c:choose>
                					<c:when test="${not empty foodTypeChngList}">
										<c:forEach var="foodTypeChng" items="${foodTypeChngList}" varStatus="status">
                                    <tr>						
                                        <td scope="row">${foodTypeChng.bf_ctgry1}</td>
                                        <td>${foodTypeChng.bf_ctgry2}</td>
                                        <td>${foodTypeChng.bf_ctgry3}</td>
                                        <td>${foodTypeChng.bf_ctgry4}</td>
                                        <td>${foodTypeChng.af_ctgry1}</td>
                                        <td>${foodTypeChng.af_ctgry2}</td>
                                        <td>${foodTypeChng.af_ctgry3}</td>
                                        <td>${foodTypeChng.af_ctgry4}</td>
                                        <td><a href="#" target="_blank" title="개정내용 다운로드"><img src="${contextPath}/img/food/icon-pdf.png" width="32" height="32" alt="pdf"></a></td>
                                        <td>
                                            <a href="javascript:goNote('${status.index}');"><img src="${contextPath}/img/food/icon-text.png" width="32" height="32" alt="note"></a>
                                            <textarea name="NOTE" id="NOTE_${status.index}" style="display:none;">${foodTypeChng.dtl_desc}</textarea>
                                        </td>
                                    </tr>
										</c:forEach>
                					</c:when>
                					<c:otherwise>
                                    <tr>
					                    <td colspan="10">등록(검색)된 내용이 없습니다.</td>
                                    </tr>
                					</c:otherwise>
                				</c:choose>
                                </tbody>
                            </table>
						</div>
                        <h2>관련 질의응답</h2>
                        <div id="qna">
                            <table>
                                <caption>관련 질의응답</caption>
                                <colgroup>
                                    <col style="width:13%;">
                                    <col style="width:15%;">
                                    <col style="width:65%;">
                                    <col style="width:7%;">
                                </colgroup>
                                <thead>
                                    <tr>
                                        <th scope="col" style="width:13%;">대분류</th>
                                        <th scope="col" style="width:15%;">소분류</th>
                                        <th scope="col" style="width:65%;">질의내용</th>
                                        <th scope="col" style="width:7%;">비고</th>
                                    </tr>
                                </thead>
                                <tbody>
                                <c:choose>
				                	<c:when test="${not empty foodTypeChngQnaList}">
				                		<c:forEach var="foodTypeChngQna" items="${foodTypeChngQnaList}" varStatus="status">
                                    <tr>						
                                        <td scope="row">${foodTypeChngQna.ctgry}</td>
                                        <td>${foodTypeChngQna.sclas}</td>
                                        <td>${foodTypeChngQna.qury_cn}</td>
                                        <td><a href="javaScript:goDown('','','');" target="_blank" title="답변내용 다운로드"><img src="${contextPath}/img/food/icon-pdf.png" width="32" height="32" alt="pdf"></a></td>
                                    </tr>
					                	</c:forEach>
				                	</c:when>
				                	<c:otherwise>
						              <tr>
						                <td colspan="4">등록(검색)된 내용이 없습니다.</td>
						              </tr>
				                	</c:otherwise>
				                </c:choose>
                                </tbody>
                            </table>
						</div>
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