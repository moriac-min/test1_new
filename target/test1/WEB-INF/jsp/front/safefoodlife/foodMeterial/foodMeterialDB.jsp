<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
%><%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"
%><%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"
%><%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"
%>


<script type="text/javascript">
	fnSubmit = function () {
		$("#saveFlag").val("Y");
		
		$("#postFrm").submit();
	}
	
	function fnKeyPress() {
		var key = event.keyCode;
		if(key==13) fnSubmit();
		else if(key==40 || key==41 || key==60 || key==61 || key==62 || key==34 || key==39) {
			event.keyCode = 0;
			alert("허용되지 않는 문자입니다.");
		}
	}	
	
	function fnKeyUp() {
		var key = event.keyCode;
		if(event.ctrlKey && key==86)
		{
			$("#search_value_all").val(XSSfilter($("#search_value_all").val()));
		}		
	}
	
	function XSSfilter(search_text) {
		search_text = search_text.replace("(", "");
		search_text = search_text.replace(")", "");
		search_text = search_text.replace("<", "");
		search_text = search_text.replace(">", "");
		search_text = search_text.replace("=", "");
	    return search_text;
	};
	
	function toggleLayer(whichLayer) {
		var elem, vis;
		
		if(document.getElementById) // this is the way the standards work
			elem = document.getElementById(whichLayer);
		else if(document.all) // this is the way old msie versions work
			elem = document.all[whichLayer];
		else if(document.layers) // this is the way nn4 works
			elem = document.layers[whichLayer];
		
		vis = elem.style;
		
  		// if the style.display value is blank we try to figure it out here
		if(vis.display==''&&elem.offsetWidth!=undefined&&elem.offsetHeight!=undefined)
			vis.display = (elem.offsetWidth!=0&&elem.offsetHeight!=0)?'block':'none';
  
		vis.display = (vis.display==''||vis.display=='block')?'none':'block';
	}
	
	function moveTab(animal) {
		//animalForm
		$('#animalValue').val(animal);
		$('#animalForm').submit();
		
		//animal = encodeURI(animal);
		//location.href = "?animal=" + animal;
	}
	
</script>

<form id="animalForm" name="animalForm" method="post" action="foodMeterialDB.do">
	<input type="hidden" id="animalValue" name="animal" />
</form>

<div id="wrapperAll">

     <!-- tab -->
     <a name="skip_cnt" class="comment">본문 시작</a>
     <div class="box">
           <ul class="tab_box1">
                <li ${((foodMeterialVO.search_type ne '2') and (empty foodMeterialVO.animal or foodMeterialVO.animal eq '기타')) ? 'class="on"' : ''}><a href="?search_type=1">통합검색</a></li><!-- 선택되어지는 탭에 class="on" 추가됨 -->
                <li ${foodMeterialVO.search_type eq '2' ? 'class="on"' : ''}><a href="?search_type=2">상세검색</a></li>
                <li ${empty foodMeterialVO.search_type and foodMeterialVO.animal eq '동물' ? 'class="on"' : ''}><a href="javascript:moveTab('동물');">동물</a></li>
				<li ${empty foodMeterialVO.search_type and foodMeterialVO.animal eq '식물' ? 'class="on"' : ''}><a href="javascript:moveTab('식물');">식물</a></li>
				<li ${empty foodMeterialVO.search_type and foodMeterialVO.animal eq '수산물' ? 'class="on"' : ''}><a href="javascript:moveTab('수산물');">수산물</a></li>
				<li ${empty foodMeterialVO.search_type and foodMeterialVO.animal eq '미생물' ? 'class="on"' : ''}><a href="javascript:moveTab('미생물');">미생물</a></li> 
           </ul> 


     </div>
     <c:choose>
     	<c:when test="${empty foodMeterialVO.search_type and (foodMeterialVO.animal eq '동물' or foodMeterialVO.animal eq '식물' or foodMeterialVO.animal eq '수산물' or foodMeterialVO.animal eq '미생물')}">
           <div class="search_line4_small">
                <form method="post" id="postFrm" action="foodMeterialDB.do">
                <input type="hidden" id="saveFlag" name="saveFlag" />
                <div class="form">
                     <div class="name_small">
                       <label>이름구분 :</label>
                           <select name="srch_name" class="search_name_small">
                           		<option value="" >전체</option>
                                <option value="원재료명" ${foodMeterialVO.srch_name eq '원재료명' ? 'selected' : ''}>원재료명</option>
                                <option value="이명" ${foodMeterialVO.srch_name eq '이명' ? 'selected' : ''}>이명</option>
                                <option value="학명" ${foodMeterialVO.srch_name eq '학명' ? 'selected' : ''}>학명</option>
                                <option value="생약명" ${foodMeterialVO.srch_name eq '생약명' ? 'selected' : ''}>생약명</option>
                           </select>
                     </div>
                     <div class="edible_small">
                       <label>식용여부 :</label>
                           <select name="edible" class="search_edible_small">
                                <option value="" >전체</option>
                                <option value="가능" ${foodMeterialVO.edible eq '가능' ? 'selected' : ''}>가능</option>
                                <option value="불가능" ${foodMeterialVO.edible eq '불가능' ? 'selected' : ''}>불가능</option>
                                <option value="제한적" ${foodMeterialVO.edible eq '제한적' ? 'selected' : ''}>제한적</option>
                           </select>
                     </div>
                     <div class="codex_small">
                       <label>공전등재여부 :</label>
                          <select name="codex" class="search_codex_small">
                                <option value="" >전체</option>
                                <option value="1" ${foodMeterialVO.codex eq '1' ? 'selected' : ''}>예</option>
                                <option value="2" ${foodMeterialVO.codex eq '2' ? 'selected' : ''}>아니오</option>
                           </select>
                           &nbsp;
                           <input type="hidden" name="animal" value="${foodMeterialVO.animal}"/>
                           <input type="text" name="query" id="search_value_all" value="${foodMeterialVO.query}" class="search_use_small" onkeypress="fnKeyPress();" onkeyup="fnKeyUp();"/>
                           <input type="button" value="검색" alt="검색" class="btn_search" onclick="fnSubmit()"/>
                     </div>
                </div>
                </form>
           </div>
     	</c:when>
     	<c:when test="${foodMeterialVO.search_type eq 2}">
           <div class="search_line3">
           		<form method="post" id="postFrm" action="foodMeterialDB.do">
           		<input type="hidden" id="saveFlag" name="saveFlag" />
                <input type="hidden" name="search_type" value="${foodMeterialVO.search_type}" />
                <div class="form">
                     <div class="edible">
                           <label>식용여부 :</label>
                           <select name="edible" class="search_feasible">
                                <option value="" >전체</option>
                                <option value="가능" ${foodMeterialVO.edible eq '가능' ? 'selected' : ''}>가능</option>
                                <option value="불가능" ${foodMeterialVO.edible eq '불가능' ? 'selected' : ''}>불가능</option>
                                <option value="제한적" ${foodMeterialVO.edible eq '제한적' ? 'selected' : ''}>제한적</option>
                           </select>
                     </div>
                     <div class="animal">
                           <label>원재료 분류 :</label>
                           <select name="animal" class="search_feasible">
                                <option value="">전체</option>
                                <option value="동물" ${foodMeterialVO.animal eq '동물' ? 'selected' : ''}>동물</option>
                                <option value="식물" ${foodMeterialVO.animal eq '식물' ? 'selected' : ''}>식물</option>
                                <option value="미생물" ${foodMeterialVO.animal eq '미생물' ? 'selected' : ''}>미생물</option>
                                <option value="수산물" ${foodMeterialVO.animal eq '수산물' ? 'selected' : ''}>수산물</option>
                                <option value="기타" ${foodMeterialVO.animal eq '기타' ? 'selected' : ''}>기타</option>
                           </select>
                     </div>
                     <div class="element">
                           <label>원재료명 :</label>
                           <input type="text" name="mtral_nm" value="${foodMeterialVO.mtral_nm}" size="20" class="search_stuff" onkeypress="fnKeyPress();"/>
                           <select name="m_name_option" class="search_and">
                                <option value="AND" >AND</option>
                                <option value="OR" ${foodMeterialVO.m_name_option eq 'OR' ? 'selected' : ''}>OR</option>
                           </select>
                     </div>
                     <div class="codex">
                           <label>공전등재여부 :</label>
                           <select name="codex" class="search_stuff2">
                                <option value="" >전체</option>
                                <option value="1" ${foodMeterialVO.codex eq '1' ? 'selected' : ''}>예</option>
                                <option value="2" ${foodMeterialVO.codex eq '2' ? 'selected' : ''}>아니오</option>
                           </select>
                           <select name="codex_option" class="search_and">
                                <option value="AND" >AND</option>
                                <option value="OR" ${foodMeterialVO.codex_option eq 'OR' ? 'selected' : ''}>OR</option>
                           </select>
                     </div>
                     <div class="scientific">
                           <label>학명 :</label>
                           <input type="text" name="scnm_nm" value="${foodMeterialVO.scnm_nm}" size="20" class="search_stuff" onkeypress="fnKeyPress();"/>
                           <select name="s_name_option" class="search_and">
                                <option value="AND" >AND</option>
                                <option value="OR" ${foodMeterialVO.s_name_option eq 'OR' ? 'selected' : ''}>OR</option>
                           </select>
                     </div>
                     <div class="ingredients">
                           <label>주요성분 :</label>
                           <input type="text" name="cmpn" value="${foodMeterialVO.cmpn}" size="40" class="search_stuff" onkeypress="fnKeyPress();"/>
                           <select name="component_option" class="search_and">
                                <option value="AND" >AND</option>
                                <option value="OR" ${foodMeterialVO.component_option eq 'OR' ? 'selected' : ''}>OR</option>
                           </select>
                     </div>
                     <div class="another">
                           <label>이명 :</label>
                           <input type="text" name="ncknm_nm" value="${foodMeterialVO.ncknm_nm}" size="20" class="search_stuff" onkeypress="fnKeyPress();"/>
                           <select name="n_name_option" class="search_and">
                                <option value="AND" >AND</option>
                                <option value="OR" ${foodMeterialVO.n_name_option eq 'OR' ? 'selected' : ''}> >OR</option>
                           </select>
                     </div>
                     <div class="toxicity ">
                           <label>안전성/독성 :</label>
                           <input type="text" name="toxcty" value="${foodMeterialVO.toxcty}" size="40" class="search_stuff" onkeypress="fnKeyPress();"/>
                           <select name="poison_option" class="search_and">
                                <option value="AND" >AND</option>
                                <option value="OR" ${foodMeterialVO.poison_option eq 'OR' ? 'selected' : ''}>OR</option>
                           </select>
                     </div>
                     <div class="pharmacognosy">
                           <label>생약명 :</label>
                           <input type="text" name="medi_nm" value="${foodMeterialVO.medi_nm}" size="20" class="search_stuff" onkeypress="fnKeyPress();"/>
                           <select name="h_name_option" class="search_and">
                                <option value="AND" >AND</option>
                                <option value="OR" ${foodMeterialVO.h_name_option eq 'OR' ? 'selected' : ''}>OR</option>
                           </select>
                     </div>
                     <div class="chartr">
                           <label>특성/분포 :</label>
                           <input type="text" name="chartr" value="${foodMeterialVO.chartr}" size="20" class="search_stuff" onkeypress="fnKeyPress();"/>
                           <select name="character_option" class="search_and">
                                <option value="AND" >AND</option>
                                <option value="OR" ${foodMeterialVO.character_option eq 'OR' ? 'selected' : ''}>OR</option>
                           </select>
                     </div>                     
                     <div class="bar">
                     	<input type="submit" value="검색" alt="검색" class="btn_search" />
                     </div>
                </div>
                </form>
           </div>
     	</c:when>
     	<c:otherwise>
           <div class="search_line4">
                <form method="post" id="postFrm" action="foodMeterialDB.do">
                <input type="hidden" id="saveFlag" name="saveFlag" />
                <input type="hidden" name="search_type" value="${foodMeterialVO.search_type}" />
                <div class="form">
                     <div class="name">
                       <label>이름구분 :</label>
                           <select name="srch_name" class="search_name">
                           		<option value="" >전체</option>
                                <option value="원재료명" ${foodMeterialVO.srch_name eq '원재료명' ? 'selected' : ''}>원재료명</option>
                                <option value="이명" ${foodMeterialVO.srch_name eq '이명' ? 'selected' : ''}>이명</option>
                                <option value="학명" ${foodMeterialVO.srch_name eq '학명' ? 'selected' : ''}>학명</option>
                                <option value="생약명" ${foodMeterialVO.srch_name eq '생약명' ? 'selected' : ''}>생약명</option>
                           </select>
                     </div>
                     <div class="edible">
                       <label>식용여부 :</label>
                           <select name="edible" class="search_edible">
                                <option value="" >전체</option>
                                <option value="가능" ${foodMeterialVO.edible eq '가능' ? 'selected' : ''}>가능</option>
                                <option value="불가능" ${foodMeterialVO.edible eq '불가능' ? 'selected' : ''}>불가능</option>
                                <option value="제한적" ${foodMeterialVO.edible eq '제한적' ? 'selected' : ''}>제한적</option>
                           </select>
                     </div>
                     <div class="animal">
                       <label>원재료 분류 :</label>
                           <select name="animal" class="search_animal">
                                <option value="" >전체</option>
                                <option value="동물" ${foodMeterialVO.animal eq '동물' ? 'selected' : ''}>동물</option>
                                <option value="식물" ${foodMeterialVO.animal eq '식물' ? 'selected' : ''}>식물</option>
                                <option value="수산물" ${foodMeterialVO.animal eq '수산물' ? 'selected' : ''}>수산물</option>
                                <option value="미생물" ${foodMeterialVO.animal eq '미생물' ? 'selected' : ''}>미생물</option>
                                <option value="기타" ${foodMeterialVO.animal eq '기타' ? 'selected' : ''}>기타</option>
                           </select>
                     </div>
                     <div class="codex">
                       <label>공전등재여부 :</label>
                          <select name="codex" class="search_codex">
                                <option value="" >전체</option>
                                <option value="1" ${foodMeterialVO.codex eq '1' ? 'selected' : ''}>예</option>
                                <option value="2" ${foodMeterialVO.codex eq '2' ? 'selected' : ''}>아니오</option>
                           </select>
                           <input type="text" name="query" id="search_value_all" value="${foodMeterialVO.query}" class="search_use" onkeypress="fnKeyPress();" onkeyup="fnKeyUp();"/>
                           <input type="button" value="검색" alt="검색" class="btn_search" onclick="fnSubmit()"/>
                     </div>
                </div>
                </form>
           </div>
     	</c:otherwise>
     </c:choose>
     
     <c:if test="${foodMeterialVO.search_type eq 2}">
     <!-- 안내 시작 -->
     <div class="search_info">
           <p><a href="javascript:toggleLayer('commentForm');" class="commentLink"><img src="image/search/toggle_open.gif" title="검색 안내" alt="검색 안내"/></a></p>
           <div id="commentForm" ${not empty foodMeterialVO.mtral_nm or not empty foodMeterialVO.scnm_nm or not empty foodMeterialVO.ncknm_nm or not empty foodMeterialVO.medi_nm or not empty foodMeterialVO.cmpn or not empty foodMeterialVO.toxcty or not empty foodMeterialVO.chartr  ? 'style="display:none;"' : ''}>
                <div class="search_toggle_line_detail">
                     <div class="img"><img src="image/search/detail_img.gif" title="" alt="" /></div>
                     <ul>
                           <li class="first">질의어 목록의 모든 필드를 통합해서 검색할 수 있는 검색입니다.</li>
                           <li class="first">각 부분의 질의어와 검색조건을 효과적으로 사용하시면 더욱 자세한 검색결과를 얻으실 수 있습니다.</li>
                     </ul>
                </div>
                <p><a class="commentLink" href="javascript:toggleLayer('commentForm');"><img src="image/search/toggle_close.gif" title="닫기" alt="닫기" /></a></p>
           </div>
     </div>
     <!-- 안내 끝 -->
     </c:if>
     
     &nbsp;&nbsp;&nbsp;&nbsp;
     
     <div class="boa_list">
           <table summary="게시물 원재료, 학명, 이명, 생약명, 식용여부, 공전등재여부, 동*식물분류, 모노그래프등의 간략정보를 제공하고 원재료를 클릭하면 상세내용화면으로 이동됩니다.">
           <caption>원재료목록</caption>
           <colgroup>
                <col width="140" />
                <col width="140" />
                <col width="160" />
                <col width="90" />
                <col width="50" />
                <col width="50" />
                <col width="50" />
           </colgroup>
           <thead>
                <tr>
                     <th scope="col" rowspan="2">원재료</th>
                     <th scope="col" rowspan="2">이명</th>
                     <th scope="col" rowspan="2">학명</th>
                     <th scope="col" rowspan="2">생약명</th>
                     <th scope="col" colspan="3">식용가능여부</th>
                </tr>
                <tr>
                     <th scope="col">가능</th>
                     <th scope="col">제한적</th>
                     <th scope="col">불가능</th>
                </tr>
           </thead>

           <tbody>
           <c:choose>
           	<c:when test="${foodMeterialListCount > 0}">
           		<c:forEach var="foodMeterial" items="${foodMeterialList}" varStatus="status">
                <tr>
                     <td><a href="foodMeterialDBDetail.do?indx=${foodMeterial.indx}&query=${param.query}">${foodMeterial.mtral_nm}</a></td>
                     <td>${foodMeterial.ncknm_nm}</td>
                     <td>${foodMeterial.scnm_nm}</td>
                     <td>${foodMeterial.medi_nm}</td>
                     <td class="cen">
                     <c:if test="${fn:length(foodMeterial.possibleList) > 0}">
                     	<c:forEach var="edible" items="${foodMeterial.possibleList}" varStatus="status">
                     		${edible.regn_nm}
                     		<c:if test="${status.count < fn:length(foodMeterial.possibleList)}">&nbsp;/&nbsp;</c:if>
                     	</c:forEach>
                     </c:if>
                     </td>
                     <td class="cen">
                     <c:if test="${fn:length(foodMeterial.limitList) > 0}">
                     	<c:forEach var="edible" items="${foodMeterial.limitList}" varStatus="status">
                     		${edible.regn_nm}
                     		<c:if test="${status.count < fn:length(foodMeterial.limitList)}">&nbsp;/&nbsp;</c:if>
                     	</c:forEach>
                     </c:if>
                     </td>
                     <td class="cen">
                     <c:if test="${fn:length(foodMeterial.impossibleList) > 0}">
                     	<c:forEach var="edible" items="${foodMeterial.impossibleList}" varStatus="status">
                     		${edible.regn_nm}
                     		<c:if test="${status.count < fn:length(foodMeterial.impossibleList)}">&nbsp;/&nbsp;</c:if>
                     	</c:forEach>
                     </c:if>
                     </td>
                </tr>
           		</c:forEach>
           	</c:when>
           	<c:otherwise>
                <tr>
                     <td colspan="7" style="text-align:center;">검색된 내용이 존재하지 않습니다</td>
                </tr>
           	</c:otherwise>
           </c:choose>
           </tbody>
           </table>
           
			<c:choose>
     			<c:when test="${foodMeterialVO.animal eq '미생물'}">
     			&nbsp;
     			</c:when>
     			<c:otherwise>
			<div class="bottom_notice">
				<ul>
				
				      <li class="first">※ 식용여부가 공란인 원료(부위)를 식용으로 사용하기 위해서는 사전 검토가 필요함을 알려드립니다.</li>
                      <li>※ 원재료명을 클릭하면 상세정보를 보실 수 있습니다.</li>
				</ul>
			</div>
     			</c:otherwise>
     		</c:choose>
			
			<div class="paging">

			</div>
	</div>
</div>
