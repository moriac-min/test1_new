<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
%><%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"
%><%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"
%><%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"
%>

<c:set var="contextPath" scope="request">${pageContext.request.contextPath}</c:set>

<c:choose>
	<c:when test="${foodAdditiveBasisInfoVO.page_gubun eq '1'}">
		<c:set var="actionPath" scope="request">foodAdditiveRvlv.do</c:set>
		<c:set var="detailPath" scope="request">foodAdditiveRvlv.do</c:set>
	</c:when>
	<c:otherwise>
		<c:set var="actionPath" scope="request">foodAdditiveBasisInfo.do</c:set>
		<c:set var="detailPath" scope="request">foodAdditiveBasisInfoDetail.do</c:set>
	</c:otherwise>
</c:choose>

<script type="text/javascript">
	
	/****************************************
	 * Variable
	****************************************/
	var total_cnt_onPage = 1;
	var show_cnt_onPage = 1;
	var current_page = 1;
	
	/****************************************
	 * Init
	****************************************/
	$(document).ready(function(){
		total_cnt_onPage = ${foodAdditiveBasisInfoListCount};
		show_cnt_onPage = 30;
		current_page = ${foodAdditiveBasisInfoVO.page};
		if (!current_page || current_page < 1) {
			current_page = 1;
		}
		
		$('.listPagination').pagination({
			items: total_cnt_onPage,
			itemsOnPage: show_cnt_onPage,
			currentPage: current_page,
			selectOnClick: false,
			onPageClick: function(pageNumber, event) {
				var query = 'page_gubun=${foodAdditiveBasisInfoVO.page_gubun}';
				query += '&procs_cl=${foodAdditiveBasisInfoVO.procs_cl}';
				query += '&keyfield=${foodAdditiveBasisInfoVO.keyfield}';
				//query += '&key='+encodeURI('${foodAdditiveBasisInfoVO.key}');
				query += '&key='+encodeURIComponent('${foodAdditiveBasisInfoVO.key}');
				query += '&page='+pageNumber;
				
				var startword = '${foodAdditiveBasisInfoVO.startword}';
				if (startword != '') {
					query += '&startword='+startword+'&Type=E';
				}
				
				//alert(query);
				location.href = '?' + query;
				return false;
			},
			cssStyle: 'compact-theme'
		});
		
	});
	
	function checkKey(){
		/*
		if(document.search.key.value == ''){
			alert('검색어를 입력하세요.');
			document.search.key.focus();
			return false;
		}
		*/
	}
</script>




<h3>
<c:choose>
	<c:when test="${foodAdditiveBasisInfoVO.page_gubun eq '2'}">
품목별 기본정보
	</c:when>
	<c:when test="${foodAdditiveBasisInfoVO.page_gubun eq '3'}">
JECFA
	</c:when>
	<c:when test="${foodAdditiveBasisInfoVO.page_gubun eq '4'}">
FCC 규격기준
	</c:when>
	<c:when test="${foodAdditiveBasisInfoVO.page_gubun eq '5'}">
EU
	</c:when>
	<c:when test="${foodAdditiveBasisInfoVO.page_gubun eq '6'}">
CODEX
	</c:when>
	<c:when test="${foodAdditiveBasisInfoVO.page_gubun eq '7'}">
일본공정서
	</c:when>
</c:choose>
</h3>

<form name="search" id="search" method="post" action="${actionPath}" onsubmit="return checkKey();">
	<input type="hidden" id="page_gubun" name="page_gubun" value="${foodAdditiveBasisInfoVO.page_gubun}" />
	<input type="hidden" id="procs_cl" name="procs_cl" value="${foodAdditiveBasisInfoVO.procs_cl}" />
	<fieldset>
	<legend>품목별 규격 및 기준 검색</legend>
		<div class="boardSearch">
			<div class="searchCn">
				<ul>
					<li>
						<select name="keyfield" class="select">
						<c:choose>
							<c:when test="${foodAdditiveBasisInfoVO.page_gubun eq '1' and foodAdditiveBasisInfoVO.procs_cl eq '4'}">
							<option value="mttr_nm" ${foodAdditiveBasisInfoVO.keyfield eq 'mttr_nm' ? 'selected' : ''}>물질명으로 찾기</option>
							<option value="cfr_no" ${foodAdditiveBasisInfoVO.keyfield eq 'cfrno' ? 'cfr_no' : ''}>CFR번호로 찾기</option>
							<option value="jecfa_no" ${foodAdditiveBasisInfoVO.keyfield eq 'jecfa_no' ? 'selected' : ''}>JECFA번호로 찾기</option>
							<option value="fema_no" ${foodAdditiveBasisInfoVO.keyfield eq 'fema_no' ? 'selected' : ''}>FEMA번호로 찾기</option>
							<option value="nicknm" ${foodAdditiveBasisInfoVO.keyfield eq 'nicknm' ? 'selected' : ''}>이명으로 찾기</option>
							</c:when>
							<c:otherwise>
							<option value="adtv_nm" ${foodAdditiveBasisInfoVO.keyfield eq 'adtv_nm' ? 'selected' : ''}>식품첨가물명으로 찾기</option>
							<option value="adtv_eng_nm" ${foodAdditiveBasisInfoVO.keyfield eq 'adtv_nm' ? 'adtv_eng_nm' : ''}>식품첨가물 영문명으로 찾기</option>
							<option value="ncknm" ${foodAdditiveBasisInfoVO.keyfield eq 'adtv_nm' ? 'ncknm' : ''}>식품첨가물 이명으로 찾기</option>
							<option value="chmsfod" ${foodAdditiveBasisInfoVO.keyfield eq 'chmsfod' ? 'selected' : ''}>화학식으로 찾기</option>
							<option value="mcwgh" ${foodAdditiveBasisInfoVO.keyfield eq 'mcwgh' ? 'selected' : ''}>분자량으로 찾기</option>
							<option value="cas_no" ${foodAdditiveBasisInfoVO.keyfield eq 'cas_no' ? 'selected' : ''}>CAS번호로 찾기</option>
							<option value="ins_no" ${foodAdditiveBasisInfoVO.keyfield eq 'ins_no' ? 'selected' : ''}>INS번호로 찾기</option>
								<c:if test="${foodAdditiveBasisInfoVO.page_gubun eq '2'}">
							<option value="use" ${foodAdditiveBasisInfoVO.keyfield eq 'use' ? 'selected' : ''}>주요용도로 찾기</option>
								</c:if>
							</c:otherwise>
						</c:choose>
						</select>
						<input name="key" type="text" size="15" class="input" value="${foodAdditiveBasisInfoVO.key}"/>
						<span class="button">
							<input type="submit" alt="검색" id="submitBtn" value="검색" />
						</span>
					</li>
				</ul>
			</div>
		</div>
	</fieldset>
</form>

	<!-- 총 글수 및 페이지 정보 시작 -->
	<div class="boardListInfo mgtop20">
		<span class="total">총 <em>${foodAdditiveBasisInfoListCount}</em> 건</span>
		<span class="page">현재페이지 : ${foodAdditiveBasisInfoVO.page}/<fmt:formatNumber value="${foodAdditiveBasisInfoListCount/30+0.5}" type="number" pattern="#"/></span>
	</div>
<!-- 총 글수 및 페이지 정보 끝 -->

	<div class="buttonwrapper boardList1Tab">
		<ul>
			<li><a class="squarebutton${foodAdditiveBasisInfoVO.procs_cl eq '1' ? ' active' : ''}" href="?page_gubun=${foodAdditiveBasisInfoVO.page_gubun}&procs_cl=1&key=${foodAdditiveBasisInfoVO.key}&keyfield=${foodAdditiveBasisInfoVO.keyfield}"><span>가. 화학적합성품</span></a></li>
			<li><a class="squarebutton${foodAdditiveBasisInfoVO.procs_cl eq '2' ? ' active' : ''}" href="?page_gubun=${foodAdditiveBasisInfoVO.page_gubun}&procs_cl=2&key=${foodAdditiveBasisInfoVO.key}&keyfield=${foodAdditiveBasisInfoVO.keyfield}"><span>나. 천연첨가물</span></a></li>
			<li><a class="squarebutton${foodAdditiveBasisInfoVO.procs_cl eq '3' ? ' active' : ''}" href="?page_gubun=${foodAdditiveBasisInfoVO.page_gubun}&procs_cl=3&key=${foodAdditiveBasisInfoVO.key}&keyfield=${foodAdditiveBasisInfoVO.keyfield}"><span>다. 혼합제제류</span></a></li>
			<c:if test="${foodAdditiveBasisInfoVO.page_gubun eq '1'}">
			<li><a class="squarebutton${foodAdditiveBasisInfoVO.procs_cl eq '4' ? ' active' : ''}" href="?page_gubun=${foodAdditiveBasisInfoVO.page_gubun}&procs_cl=4&key=${foodAdditiveBasisInfoVO.key}&keyfield=${foodAdditiveBasisInfoVO.keyfield}"><span>※. 착향료</span></a></li>
			</c:if>
		</ul>
	</div>
	
	<c:if test="${foodAdditiveBasisInfoVO.page_gubun eq '1' and foodAdditiveBasisInfoVO.procs_cl eq '4'}">
	<div class="searchTop1">
		<ul class="han">
			<li><a href="foodAdditiveRvlv.do?page_gubun=1&procs_cl=4&startword=1&Type=E" class="spellBtn"><span>ㄱ</span></a></li>
			<li><a href="foodAdditiveRvlv.do?page_gubun=1&procs_cl=4&startword=2&Type=E" class="spellBtn"><span>ㄴ</span></a></li>
			<li><a href="foodAdditiveRvlv.do?page_gubun=1&procs_cl=4&startword=3&Type=E" class="spellBtn"><span>ㄷ</span></a></li>
			<li><a href="foodAdditiveRvlv.do?page_gubun=1&procs_cl=4&startword=4&Type=E" class="spellBtn"><span>ㄹ</span></a></li>
			<li><a href="foodAdditiveRvlv.do?page_gubun=1&procs_cl=4&startword=5&Type=E" class="spellBtn"><span>ㅁ</span></a></li>
			<li><a href="foodAdditiveRvlv.do?page_gubun=1&procs_cl=4&startword=6&Type=E<span>ㅂ</span></a></li>
			<li><a href="foodAdditiveRvlv.do?page_gubun=1&procs_cl=4&startword=1&Type=E" class="spellBtn"><span>ㅅ</span></a></li>
			<li><a href="foodAdditiveRvlv.do?page_gubun=1&procs_cl=4&startword=7&Type=E" class="spellBtn"><span>ㅇ</span></a></li>
			<li><a href="foodAdditiveRvlv.do?page_gubun=1&procs_cl=4&startword=8&Type=E<span>ㅈ</span></a></li>
			<li><a href="foodAdditiveRvlv.do?page_gubun=1&procs_cl=4&startword=9&Type=E" class="spellBtn"><span>ㅊ</span></a></li>
			<li><a href="foodAdditiveRvlv.do?page_gubun=1&procs_cl=4&startword=0&Type=E" class="spellBtn"><span>ㅎ</span></a></li>
		</ul>
		<ul class="eng">
			<li><a href="foodAdditiveRvlv.do?page_gubun=1&procs_cl=4&startword=A&Type=E" class="spellBtn"><span>A</span></a></li>
			<li><a href="foodAdditiveRvlv.do?page_gubun=1&procs_cl=4&startword=B&Type=E" class="spellBtn"><span>B</span></a></li>
			<li><a href="foodAdditiveRvlv.do?page_gubun=1&procs_cl=4&startword=C&Type=E" class="spellBtn"><span>C</span></a></li>
			<li><a href="foodAdditiveRvlv.do?page_gubun=1&procs_cl=4&startword=D&Type=E" class="spellBtn"><span>D</span></a></li>
			<li><a href="foodAdditiveRvlv.do?page_gubun=1&procs_cl=4&startword=E&Type=E" class="spellBtn"><span>E</span></a></li>
			<li><a href="foodAdditiveRvlv.do?page_gubun=1&procs_cl=4&startword=F&Type=E" class="spellBtn"><span>F</span></a></li>
			<li><a href="foodAdditiveRvlv.do?page_gubun=1&procs_cl=4&startword=G&Type=E" class="spellBtn"><span>G</span></a></li>
			<li><a href="foodAdditiveRvlv.do?page_gubun=1&procs_cl=4&startword=H&Type=E" class="spellBtn"><span>H</span></a></li>
			<li><a href="foodAdditiveRvlv.do?page_gubun=1&procs_cl=4&startword=I&Type=E" class="spellBtn"><span>I</span></a></li>
			<li><a href="foodAdditiveRvlv.do?page_gubun=1&procs_cl=4&startword=J&Type=E" class="spellBtn"><span>J</span></a></li>
			<li><a href="foodAdditiveRvlv.do?page_gubun=1&procs_cl=4&startword=K&Type=E" class="spellBtn"><span>K</span></a></li>
			<li><a href="foodAdditiveRvlv.do?page_gubun=1&procs_cl=4&startword=L&Type=E" class="spellBtn"><span>L</span></a></li>
			<li><a href="foodAdditiveRvlv.do?page_gubun=1&procs_cl=4&startword=M&Type=E" class="spellBtn"><span>M</span></a></li>
			<li><a href="foodAdditiveRvlv.do?page_gubun=1&procs_cl=4&startword=N&Type=E" class="spellBtn"><span>N</span></a></li>
			<li><a href="foodAdditiveRvlv.do?page_gubun=1&procs_cl=4&startword=O&Type=E" class="spellBtn"><span>O</span></a></li>
			<li><a href="foodAdditiveRvlv.do?page_gubun=1&procs_cl=4&startword=P&Type=E" class="spellBtn"><span>P</span></a></li>
			<li><a href="foodAdditiveRvlv.do?page_gubun=1&procs_cl=4&startword=Q&Type=E" class="spellBtn"><span>Q</span></a></li>
			<li><a href="foodAdditiveRvlv.do?page_gubun=1&procs_cl=4&startword=R&Type=E" class="spellBtn"><span>R</span></a></li>
			<li><a href="foodAdditiveRvlv.do?page_gubun=1&procs_cl=4&startword=S&Type=E" class="spellBtn"><span>S</span></a></li>
			<li><a href="foodAdditiveRvlv.do?page_gubun=1&procs_cl=4&startword=T&Type=E" class="spellBtn"><span>T</span></a></li>
			<li><a href="foodAdditiveRvlv.do?page_gubun=1&procs_cl=4&startword=U&Type=E" class="spellBtn"><span>U</span></a></li>
			<li><a href="foodAdditiveRvlv.do?page_gubun=1&procs_cl=4&startword=V&Type=E" class="spellBtn"><span>V</span></a></li>
			<li><a href="foodAdditiveRvlv.do?page_gubun=1&procs_cl=4&startword=W&Type=E" class="spellBtn"><span>W</span></a></li>
			<li><a href="foodAdditiveRvlv.do?page_gubun=1&procs_cl=4&startword=X&Type=E" class="spellBtn"><span>X</span></a></li>
			<li><a href="foodAdditiveRvlv.do?page_gubun=1&procs_cl=4&startword=Y&Type=E" class="spellBtn"><span>Y</span></a></li>
			<li><a href="foodAdditiveRvlv.do?page_gubun=1&procs_cl=4&startword=Z&Type=E" class="spellBtn"><span>Z</span></a></li>
		</ul>
	</div>
	</c:if>

	<!-- <div class="boardListInfo">  -->
	<!-- 게시물정보 시작 -->
		<table class="boardList1" summary="공전 첨가물">
	        <tbody>
	        <c:forEach var="foodAdditiveBasisInfo" items="${foodAdditiveBasisInfoList}" varStatus="status">
	        	<c:if test="${status.index%3 == 0}">
	        	<tr>
	        	</c:if>
					<td class="alignL">
					<c:choose>
						<c:when test="${foodAdditiveBasisInfoVO.procs_cl eq '4'}">
							<a href="${detailPath}?page_gubun=${foodAdditiveBasisInfoVO.page_gubun}&procs_cl=${foodAdditiveBasisInfoVO.procs_cl}&adtv_cd=${foodAdditiveBasisInfo.ordno}&keyfield=${foodAdditiveBasisInfoVO.keyfield}&key=${foodAdditiveBasisInfoVO.key}&page=${foodAdditiveBasisInfoVO.page}">${foodAdditiveBasisInfo.rnum}.&nbsp;${foodAdditiveBasisInfo.mttr_nm}</a>
						</c:when>
						<c:otherwise>
							<a href="${detailPath}?page_gubun=${foodAdditiveBasisInfoVO.page_gubun}&procs_cl=${foodAdditiveBasisInfoVO.procs_cl}&adtv_cd=${foodAdditiveBasisInfo.adtv_cd}&keyfield=${foodAdditiveBasisInfoVO.keyfield}&key=${foodAdditiveBasisInfoVO.key}&page=${foodAdditiveBasisInfoVO.page}">${foodAdditiveBasisInfo.procs_ordno}.&nbsp;${foodAdditiveBasisInfo.adtv_nm}</a>
						</c:otherwise>
					</c:choose>
					</td>
	        	<c:if test="${status.index%3 == 2 || status.count == fn:length(foodAdditiveBasisInfoList)}">
	        	</tr>
	        	</c:if>
	        </c:forEach>
	        </tbody>
		</table>
	<!-- </div> -->

	<div class="board-footer">
    	<div class="listPagination"></div>
    </div>
