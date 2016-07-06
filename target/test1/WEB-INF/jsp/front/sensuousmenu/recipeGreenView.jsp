<%@page language="java" contentType="text/html; charset=utf-8"
%><%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"
%><%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"
%><%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"
%>
<c:set var="contextPath" scope="request">${pageContext.request.contextPath}</c:set>

<input type="hidden" id="rcp_menu_no" name="rcp_menu_no" value="${recipeInfoVO.rcp_menu_no }">				<!-- rcp_menu_no -->

<section>
	<article class="recipe">
		<div class="article-head">
			<div class="lnb-viewer" id="nav-open-btn" href="#left-nav">Menu</div>
			<ol class="breadcrumb">
				<li><a href="#">홈</a></li>
				<li><a href="#">오감만족식단</a></li>
				<li><a href="#">${titleMap.recipeVO.title_fir }</a></li>
				<li class="active">${titleMap.recipeVO.title_sec }</li>
			</ol>
			<h1>
				${recipeInfoVO.rcp_menu_nm }
<!-- 				 <a href="recipe-video.html" class="btn-mov fancybox.iframe">레시피동영상</a> -->
			</h1>
			<p class="excerpt">
				<span class="label label-danger">${recipeInfoVO.rcp_menu_cate_nm }</span>
			<figure><img src="${recipeInfoVO.rcp_menu_list_atch_file_nm }" alt="${recipeInfoVO.rcp_menu_nm } 완성 컷"></figure> ${recipeInfoVO.rcp_menu_memo }</p>
			<div class="meta">${recipeInfoVO.last_updt_dtm }</div>
		</div>
		<div class="section">
			<div class="sl ingredients">
				<h2>재료소개</h2>
				<p>${recipeInfoVO.rcp_menu_mate }</p>
				<figure><img src="${recipeInfoVO.rcp_menu_mate_atch_file_nm }" alt="${recipeInfoVO.rcp_menu_nm } 재료"></figure>
			</div>
			<div class="sr season">
				<h2>제철식품</h2>
				<c:forEach items="${nutList }" var="nut">
				<a class="ingredient fancybox.iframe btn btn-sm btn-danger" data-fancybox-group="iframe" href="ingredient.html">${nut.food_ntrt_nm }/${nut.food_ntrt_no }</a>
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
					   	<caption>영양소 함량</caption>
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
			<div class="sr na-vs-k">
				<h2>나트륨과 칼륨을 비교해 볼까요</h2>
				<table>
					<caption>나트륨/칼륨 비교</caption>
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
								<c:if test="${recipeInfoVO.rcp_menu_na != null and recipeInfoVO.rcp_menu_na != '' 
								and recipeInfoVO.rcp_menu_potas != null and recipeInfoVO.rcp_menu_potas != ''}">
								1 : ${recipeInfoVO.rcp_menu_potas / recipeInfoVO.rcp_menu_na }
								</c:if>
							</td>
						</tr>
						<tr>
							<th scope="row">${recipeInfoVO.rcp_menu_legacy_foodnm}</th>
							<td>${recipeInfoVO.rcp_menu_legacy_na}</td>
							<td>${recipeInfoVO.rcp_menu_legacy_potas}</td>
							<td>
								<c:if test="${recipeInfoVO.rcp_menu_legacy_na != null and recipeInfoVO.rcp_menu_legacy_na != '' 
								and recipeInfoVO.rcp_menu_legacy_potas != null and recipeInfoVO.rcp_menu_legacy_potas != ''}">
								1 : ${recipeInfoVO.rcp_menu_legacy_potas / recipeInfoVO.rcp_menu_legacy_na }
								</c:if>
							</td>
						</tr>
					</tbody>
				</table>
			</div>
		</div>
		<div class="section">
			<div class="sf tip">
				<h2>팁앤팁</h2>
				<div class="emphasis">${recipeInfoVO.rcp_menu_tip}</div>
			</div>
		</div>
	 	<div class="like"><a href="javascript:fn_recipeLike();" class="btn btn-default btn-lg" role="button">
	 		<span class="icon-heart-empty recipe">좋아요 </span>
	 		<font id="likeCnt">${recipeInfoVO.rcp_menu_like}</font>
	 		</a></div>
	 		   
<!-- 	 	<div class="tag-wrap"><a href="#" class="tag">당뇨</a>, <a href="#" class="tag">당테크</a>, <a href="#" class="tag">당뇨병</a>, <a href="#" class="tag">성인병</a>, <a href="#" class="tag">혈당</a>, <a href="#" class="tag">40대</a></div>  -->
		<a href="/" class="btn btn-default btn-right" role="button">목록</a> 
<!-- 		<div class="related recipe"> -->
<!-- 			<h2>아래 레시피도 확인해 보세요!</h2> -->
<!-- 			<ul class="items"> -->
<!-- 				<li> -->
<!-- 					<a href="#"><img src="../../../img/sample-112x112.png" alt=""> -->
<!-- 					<span>감자를 곁들인 야채스튜</span> -->
<!-- 					</a> -->
<!-- 				</li> -->
<!-- 				<li> -->
<!-- 					<a href="#"><img src="../../../img/sample-112x112.png" alt=""> -->
<!-- 					<span>고기완자를 곁들인 스웨덴식 국수</span> -->
<!-- 					</a> -->
<!-- 				</li> -->
<!-- 				<li> -->
<!-- 					<a href="#"><img src="../../../img/sample-112x112.png" alt=""> -->
<!-- 					<span>단호박 스프</span> -->
<!-- 					</a> -->
<!-- 				</li> -->
<!-- 				<li> -->
<!-- 					<a href="#"><img src="../../../img/sample-112x112.png" alt=""> -->
<!-- 					<span>김치 고구마밥</span> -->
<!-- 					</a> -->
<!-- 				</li> -->
<!-- 				<li> -->
<!-- 					<a href="#"><img src="../../../img/sample-112x112.png" alt=""> -->
<!-- 					<span>고구마 경단</span> -->
<!-- 					</a> -->
<!-- 				</li> -->
<!-- 			</ul> -->
<!-- 		</div> -->
		
	</article>
	<aside class="recipe-2">
		<ul class="share">
			<li><a href="javascript:print();" class="print">프린트</a></li>
			<li><a href="#" class="email">이메일</a></li>
			<li><a href="#" class="fb">페이스북</a></li>
			<li><a href="#" class="tw">트위터</a></li>
			<li><a href="#" class="url">URL보내기</a></li>
		</ul>
		<div class="widget">
			<h2 class="latest recipe">최신레시피</h2>
			<ul class="wt-thumbnail recipe">
				<c:forEach items="${recipeNewList }" var="recipeNew">
		   		<li>
					<img src="${recipeNew.rcp_menu_list_atch_file_nm }" alt="${recipeNew.rcp_menu_nm }"> 
					<a href="#">${recipeNew.rcp_menu_nm }</a>
					<p>${recipeNew.rcp_menu_memo }</p>
					<span>${recipeNew.last_updt_dtm }</span>
				</li> 
				</c:forEach>
			</ul>
		</div>
		<div class="widget">
			<h2 class="popular recipe">인기레시피</h2>
			<ul class="wt-thumbnail recipe">
				<c:forEach items="${recipeLikeList }" var="recipeLike">
		   		<li>
					<img src="${recipeLike.rcp_menu_list_atch_file_nm }" alt="${recipeLike.rcp_menu_nm }"> 
					<a href="#">${recipeLike.rcp_menu_nm }</a>
					<p>${recipeLike.rcp_menu_memo }</p>
					<span>${recipeLike.last_updt_dtm }</span>
				</li> 
				</c:forEach>
			</ul>
		</div>
	</aside>
</section>
			
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
			data: $('#baseForm').serialize(),
			dataType:'json', 
			type:'POST',
			url:"${contextPath}/front/sensuousmenu/updateRecipeLike.do", 
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
