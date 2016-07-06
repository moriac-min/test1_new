<%@page language="java" contentType="text/html; charset=utf-8"
%><%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"
%><%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"
%><%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"
%>
<c:set var="contextPath" scope="request">${pageContext.request.contextPath}</c:set>

<link type="text/css" href="${contextPath}/css/bootstrap.min.css" rel="stylesheet">
<link type="text/css" href="${contextPath}/css/webfont.css" rel="stylesheet">
<link type="text/css" href="${contextPath}/css/style_sub.css" rel="stylesheet">

<input type="hidden" id="rcp_menu_no" name="rcp_menu_no" value="${recipeInfoVO.rcp_menu_no }">				<!-- rcp_menu_no -->

<body class="market">
<div id="inner-view">
	<article class="recipe">
		<figure><img src="${recipeInfoVO.rcp_menu_list_atch_file_nm }" alt="${recipeInfoVO.rcp_menu_nm } 완성 컷"></figure>
		<div class="article-head">
			<h1>${recipeInfoVO.rcp_menu_nm } <a href="javascrip:;" onClick="window.print();" class="print">프린트</a></h1>
			<p class="excerpt"><span class="label label-danger">${recipeInfoVO.rcp_menu_cate_nm }</span> ${recipeInfoVO.rcp_menu_memo }</p>
		</div>
		<div class="section" style="clear:both;border-top:2px solid #424252;margin-top:20px !important;">
			<div class="sl ingredients">
				<h2>재료소개</h2>
				<p>${recipeInfoVO.rcp_menu_mate }</p>
				<figure><img src="${recipeInfoVO.rcp_menu_mate_atch_file_nm }" alt="${recipeInfoVO.rcp_menu_nm } 재료"></figure>
			</div>
			<div class="sr season">
				<h2>제철식품</h2>
				<c:forEach items="${nutList }" var="nut">
				<div class="label label-danger" style="padding:.5em 1em;font-size:13px;">${nut.food_ntrt_nm }</div>
				</c:forEach>
			</div>
			<div class="sr purpose">
				<h2>개발목적</h2>
				<p>
				<c:forEach items="${purpList }" var="purp">
					${purp.cd_nm }
				</c:forEach>
				<br>
<!-- 					어린이들이 싫어하는 쑥을 기호도가 높은 달걀 속에 넣어 먹게 함 -->
				</p>
			</div>
		</div>
		<div class="section">
			<div class="sf direction">
				<h2>만들어볼까요</h2>
				<figure><img src="${recipeInfoVO.rcp_menu_proces_atch_file_nm }" alt="${recipeInfoVO.rcp_menu_nm } 요리과정 컷"></figure>
				<pre>${recipeInfoVO.rcp_menu_proces }</pre>
			</div>
		</div>
		<div class="section">
			<div class="sl nutrition">
				<h2>영양소 함량을 살펴볼까요</h2>
				<table>
					<caption>
					영양소 함량
					</caption>
					<colgroup>
					<col>
					<col>
					<col>
					<col>
					</colgroup>
					<tbody>
						<tr>
							<th colspan="2" scope="row">열량</th>
							<td colspan="2">${recipeInfoVO.rcp_menu_calm } <span>kcal</span></td>
						</tr>
						<tr>
							<th scope="row">탄수화물</th>
							<td>${recipeInfoVO.rcp_menu_sug}g</td>
							<th scope="row">단백질</th>
							<td>${recipeInfoVO.rcp_menu_protein}g</td>
						</tr>
						<tr>
							<th scope="row">지방</th>
							<td>${recipeInfoVO.rcp_menu_ntrfs}g</td>
							<th scope="row">나트륨</th>
							<td>${recipeInfoVO.rcp_menu_na}mg</td>
						</tr>
						<tr>
							<th scope="row">비타민A</th>
							<td>${recipeInfoVO.rcp_menu_vitaa}mg</td>
							<th scope="row">콜레스테롤</th>
							<td>${recipeInfoVO.rcp_menu_chol}mg</td>
						</tr>
						<tr>
							<th scope="row">비타민B1</th>
							<td>${recipeInfoVO.rcp_menu_vitab1}mg</td>
							<th scope="row">칼륨</th>
							<td>${recipeInfoVO.rcp_menu_potas}mg</td>
						</tr>
						<tr>
							<th scope="row">비타민B2</th>
							<td>${recipeInfoVO.rcp_menu_vitab2}mg</td>
							<th scope="row">식이섬유</th>
							<td>${recipeInfoVO.rcp_menu_foodfiber}g</td>
						</tr>
						<tr>
							<th scope="row">비타민C</th>
							<td>${recipeInfoVO.rcp_menu_vitac}mg</td>
							<th scope="row">칼슘</th>
							<td>${recipeInfoVO.rcp_menu_ca}mg</td>
						</tr>
						<tr>
							<th scope="row">철</th>
							<td>${recipeInfoVO.rcp_menu_iron}mg</td>
							<th scope="row"></th>
							<td></td>
						</tr>
					</tbody>
				</table>
			</div>
			<c:if test="${recipeInfoVO.rcp_menu_na != null and recipeInfoVO.rcp_menu_na != '' 
								and recipeInfoVO.rcp_menu_potas != null and recipeInfoVO.rcp_menu_potas != ''
								and recipeInfoVO.rcp_menu_nm != null and recipeInfoVO.rcp_menu_nm != ''}">
			<div class="sr na-vs-k">
				<h2>나트륨과 칼륨을 비교해 볼까요</h2>
				<table>
					<caption>
					나트륨/칼륨 비교
					</caption>
					<colgroup>
					<col>
					<col>
					<col>
					<col>
					</colgroup>
					<thead>
						<tr>
							<th scope="col">음식</th>
							<th scope="col">Na(mg)</th>
							<th scope="col">K(mg)</th>
							<th scope="col">Na:K</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<th scope="row">${recipeInfoVO.rcp_menu_nm}</th>
							<td>${recipeInfoVO.rcp_menu_na}</td>
							<td>${recipeInfoVO.rcp_menu_potas}</td>
							<td>
								1 : <fmt:formatNumber value="${recipeInfoVO.rcp_menu_potas / recipeInfoVO.rcp_menu_na }" maxFractionDigits="2"/>
								</td>
						</tr>
						<tr>
							<th scope="row">${recipeInfoVO.rcp_menu_legacy_foodnm}</th>
							<td>${recipeInfoVO.rcp_menu_legacy_na}</td>
							<td>${recipeInfoVO.rcp_menu_legacy_potas}</td>
							<td>
								1 : <fmt:formatNumber value="${recipeInfoVO.rcp_menu_legacy_potas / recipeInfoVO.rcp_menu_legacy_na }" maxFractionDigits="2"/>
							</td>
						</tr>
					</tbody>
				</table>
			</div>
			</c:if>
		</div>
		<div class="section" style="border-bottom:none;">
			<div class="sf tip">
				<h2>팁앤팁</h2>
				<div class="emphasis">${recipeInfoVO.rcp_menu_tip}</div>
			</div>
		</div>
		<div class="like">
				<a href="javascript:fn_recipeLike();" class="btn btn-default btn-lg" role="button">
		 		<span class="icon-heart-empty recipe">좋아요 </span>
		 		<font id="likeCnt">${recipeInfoVO.rcp_menu_like}</font>
	 		</a>
	 	</div>
	</article>
</div>
</body>

<script language="JavaScript">

	/****************************************
	 * Variable
	****************************************/
	var likeCnt = ${recipeInfoVO.rcp_menu_like};
	/****************************************
	 * Init
	****************************************/
	$(document).ready(function(){
		
	}); 
	
	/****************************************
	 * Button Action
	 ****************************************/

	 /****************************************
	 * Function
	 ****************************************/
	 function fn_recipeLike(){
		
		$.ajax({ 
			dataType:'json', 
			type:'POST',
			url:"${contextPath}/front/sensuousmenu/updateRecipeLike.do?no=${recipeInfoVO.rcp_menu_no }&dvs_cd=MENU", 
			success:function(arg){
				if(arg.result == 2){
					$("#likeCnt").html(likeCnt + 1);
				}
				alert(arg.resultStr);
			},
			error:function(request,status,error){
				alert("실패코드 : " + request.status+"\n메세지 : " + request.error);
			}
		});
	}
	 
</script>
