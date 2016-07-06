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

<body class="ingredient">
<div id="inner-view">
	<div class="inner-head">
		<h1>${recipeNtrtInfo.food_ntrt_nm }</h1>
		<a href="javascrip:;" onClick="window.print();" class="print">프린트</a> 
	</div>
	<div class="inner-body">
		<div class="inner-info"> 
			<img src="${recipeNtrtInfo.atch_file_nm }" alt="${recipeNtrtInfo.food_ntrt_nm }">
			<table>
				<caption>${recipeNtrtInfo.food_ntrt_nm }의 영양성분표</caption>
				<colgroup>
				<col style="width:10%;">
				<col style="width:10%;">
				<col style="width:10%;">
				<col style="width:10%;">
				<col style="width:10%;">
				<col style="width:10%;">
				<col style="width:10%;">
				<col style="width:10%;">
				<col style="width:10%;">
				<col style="width:10%;">
				</colgroup>
				<thead>
					<tr>
						<th scope="col">에너지<br>(kcal)</th>
						<th scope="col">단백질<br>(g)</th>
						<th scope="col">지방<br>(g)</th>
						<th scope="col">콜레스테롤<br>(mg)</th>
						<th scope="col">탄수화물<br>(g)</th>
						<th scope="col">식이섬유<br>(g)</th>
						<th scope="col">칼슘<br>(mg)</th>
						<th scope="col">인<br>(mg)</th>
						<th scope="col">철<br>(mg)</th>
						<th scope="col">나트륨<br>(mg)</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td scope="row">${recipeNtrtInfo.food_ntrt_calm }</td>
						<td>${recipeNtrtInfo.food_ntrt_protein }</td>
						<td>${recipeNtrtInfo.food_ntrt_lcar }</td>
						<td>${recipeNtrtInfo.food_ntrt_chol }</td>
						<td>${recipeNtrtInfo.food_ntrt_cahyfrght }</td>
						<td>${recipeNtrtInfo.food_ntrt_foodfiber }</td>
						<td>${recipeNtrtInfo.food_ntrt_ca }</td>
						<td>${recipeNtrtInfo.food_ntrt_ph }</td>
						<td>${recipeNtrtInfo.food_ntrt_seasn }</td>
						<td>${recipeNtrtInfo.food_ntrt_na }</td>
					</tr>
				</tbody>
				<thead>
					<tr>
						<th scope="col">칼륨<br>(mg)</th>
						<th scope="col">아연<br>(mg)</th>
						<th scope="col">VitA<br>(Re)</th>
						<th scope="col">VitB1<br>(mg)</th>
						<th scope="col">VitB2<br>(mg)</th>
						<th scope="col">VitB6<br>(mg)</th>
						<th scope="col">VitC<br>(mg)</th>
						<th scope="col">VitE<br>(mg)</th>
						<th scope="col">엽산<br>(kcal)</th>
						<th scope="col">니아신<br>(mg)</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td scope="row">${recipeNtrtInfo.food_ntrt_potas }</td>
						<td>${recipeNtrtInfo.food_ntrt_zinc }</td>
						<td>${recipeNtrtInfo.food_ntrt_vitaa }</td>
						<td>${recipeNtrtInfo.food_ntrt_vitab1 }</td>
						<td>${recipeNtrtInfo.food_ntrt_vitab2 }</td>
						<td>${recipeNtrtInfo.food_ntrt_vitab6 }</td>
						<td>${recipeNtrtInfo.food_ntrt_vitac }</td>
						<td>${recipeNtrtInfo.food_ntrt_vitae }</td>
						<td>${recipeNtrtInfo.food_ntrt_foli }</td>
						<td>${recipeNtrtInfo.food_ntrt_niac }</td>
					</tr>
				</tbody>
			</table>
		</div>
		<h2>식품영양정보</h2>
		<p class="emphasis">
			<pre>${recipeNtrtInfo.food_ntrt_ntrt }</pre>
		</p>
		<div class="sl">
			<h2>생산시기</h2>
			<p>${recipeNtrtInfo.food_ntrt_ntrt }</p>
			<h2>구매요령</h2>
			<p>${recipeNtrtInfo.food_ntrt_purch }</p>
		</div>
		<div class="sr">
			<h2>1일 영양섭취기준 대비 함량(%)</h2>
			<img src="../../../img/sample-300x200.png" width="300" alt="쑥 1인 1회 분량(50g) 기준">
		</div>
	</div>
</div>
</body>

<script language="JavaScript">

	/****************************************
	 * Variable
	****************************************/
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
	 
</script>
