<%@page language="java" contentType="text/html; charset=utf-8"
%><%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"
%><%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"
%><%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"
%>

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
      <div id="contentArea">
        <div id="pagetitle">
          <h1><img src="../../../../images/safefoodlife/food/title/02_02.gif" alt="전면개정관련유형안내" /></h1>
        </div>
        <div id="content">
          <div class="bbs">
            <div class="search">
              <div class="pos">
                <strong>유형명 검색</strong>
                <input id="search_word" name="search_word" value="${search_word}" type="text" class="keyword" />
                <a href="JavaScript:goSearch();"><img src="../../../../images/safefoodlife/food/bbs/btn_search.gif" alt=" " /></a>
              </div>
            </div>
            <div class="bbs" style="padding-top:20px;">
              <div class="RboxB">
                <div class="inDes">
                  <!--p>
                    전면개정 고시내용, 전면개정된 식품공전 전문, 전면개정관련 Q&A 전문은 좌측의 아이콘을 클릭하시면<br />한글화일을 다운받으실 수 있습니다.
                  </p-->
                  <p>
                    이번 전면개정에서 새롭게 신설된 유형으로 기타과당, 겐티오올리고당, 조미된장, 조미고추장, 기타장류,김칫속, (즉석섭취ㆍ편의식품류)이 있으며, 동유형으로 분류되어야 하는 식품들이 다른 유형으로 분류되지 않도록 주의하시기 바랍니다.
                  </p>
                </div>
              </div>
            </div>
            <h2><img src="../../../../images/safefoodlife/food/title/h2_03.gif" alt=" " /></h2>
            <div id="div1" style="width:800px;height:280px;overflow-y:scroll">
              <table class="list hasVline listsbg">
                <thead>
                  <tr>
                    <th style="position: relative;" scope="col" colspan="4" class="first">개정 전</th>
                    <th style="position: relative;" scope="col" colspan="4">개정 후</th>
                    <th style="position: relative;" scope="col" rowspan="2" width="10%">PDF<br />파일</th>
                    <th style="position: relative;" scope="col" rowspan="2" class="last" width="10%">Note</th>
                  </tr>
                  <tr>
                    <th style="position: relative;" scope="col" class="first">식품군</th>
                    <th style="position: relative;" scope="col">식품종</th>
                    <th style="position: relative;" scope="col">식품유형</th>
                    <th style="position: relative;" scope="col">세부유형</th>
                    <th style="position: relative;" scope="col">식품군</th>
                    <th style="position: relative;" scope="col">식품종</th>
                    <th style="position: relative;" scope="col">식품유형</th>
                    <th style="position: relative;" scope="col">세부유형</th>
                  </tr>
                </thead>
                <tbody>
                <c:choose>
                	<c:when test="${not empty foodTypeChngList}">
						<c:forEach var="foodTypeChng" items="${foodTypeChngList}" varStatus="status">
				  <tr>
                    <td align="left">${foodTypeChng.bf_ctgry1}</td>
                    <td align="left">${foodTypeChng.bf_ctgry2}</td>
                    <td align="left">${foodTypeChng.bf_ctgry3}</td>
                    <td align="left">${foodTypeChng.bf_ctgry4}</td>
                    <td align="left">${foodTypeChng.af_ctgry1}</td>
                    <td align="left">${foodTypeChng.af_ctgry2}</td>
                    <td align="left">${foodTypeChng.af_ctgry3}</td>
                    <td align="left">${foodTypeChng.af_ctgry4}</td>
                    <td>
                      <a href="JavaScript:;"><img src="../../../../images/safefoodlife/food/icon/pdf.gif" alt=" " /></a>
                    </td>
                    <td>
                      <a href="JavaScript:goNote('${status.index}');"><img src="../../../../images/safefoodlife/food/icon/zoom.gif" alt=" " /></a>
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
            <h2><img src="../../../../images/safefoodlife/food/title/h2_04.gif" alt=" " /></h2>
            <div id="div2" style="width:800px;height:280px;overflow-y:scroll">
              <table class="df">
                <thead>
                  <tr>
                    <th style="position: relative;" class="first">개정 전</th>
                    <th style="position: relative;">소분류</th>
                    <th style="position: relative;">질의내용</th>
                    <th style="position: relative;" class="last">Note</th>
                  </tr>
                </thead>
                <tbody>
                <c:choose>
                	<c:when test="${not empty foodTypeChngQnaList}">
                		<c:forEach var="foodTypeChngQna" items="${foodTypeChngQnaList}" varStatus="status">
	                  <tr>
	                    <td>${foodTypeChngQna.ctgry}</td>
	                    <td align="left">${foodTypeChngQna.sclas}</td>
	                    <td align="left">${foodTypeChngQna.qury_cn}</td>
	                    <td>
	                      <a href="JavaScript:goDown('','','');"><img src="../../../../images/safefoodlife/food/icon/pdf.gif" alt=" " /></a>
	                    </td>
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
          </div>
        </div>
      </div>
	</form>
