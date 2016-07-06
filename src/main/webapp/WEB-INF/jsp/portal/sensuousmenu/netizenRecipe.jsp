<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=utf-8"
%><%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"
%><%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"
%><%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" 
%><%@ taglib prefix="m" uri="/WEB-INF/tlds/message.tld"
%><%@ page import="foodportal.common.util.Message"
%>

<c:set var="contextPath" scope="request">${pageContext.request.contextPath}</c:set>

<input type="hidden" id="neti_rcp_no" name="neti_rcp_no" value="${netizenRecipeVO.neti_rcp_no }">      	<!-- neti_rcp_no -->
<input type="hidden" id="type_cd" name="type_cd" value="">      			<!-- type_cd -->

<input type="hidden" id="date" name="date" value="">      			<!-- date -->
<input type="hidden" id="type" name="type" value="">      			<!-- type -->

            <section>
                <div id="header">
                    <div class="recipe-head">
                        <div class="lnb-viewer" id="nav-open-btn" href="#left-nav">Menu</div>
                        <ol class="breadcrumb">
                            <li><a href="#">홈</a></li>
                            <li><a href="#">오감만족식단</a></li>
                            <li><a href="#">네티즌레시피</a></li>
		                    <c:choose>
								<c:when test="${netizenRecipeVO.type_cd == 'my'}">
									<li class="active">나의 레시피</li>
								</c:when>
								<c:otherwise>
									<li class="active">도전!레시피</li>
								</c:otherwise>
							</c:choose>                            	
                        </ol>
                        <h1><div class="theme">손님초대용 한 그릇 한식</div>
                            ${netizenRecipeVO.neti_rcp_cook_nm }</h1>
                        <p class="excerpt">${netizenRecipeVO.neti_rcp_cook_thma }</p>
                        <div class="meta"><span class="chef">${netizenRecipeVO.neti_rcp_mber_no }</span>${netizenRecipeVO.cret_dtm }</div>
                    </div>
                    <figure>
                    	<c:if test="${netizenRecipeVO.best_rcp_use_yn == 'Y' }">
                        <div class="tag">
                            BEST<br>RECIPE
                            <div class="month">${netizenRecipeVO.best_rcp_mm }</div>
                            <div class="year">${netizenRecipeVO.best_rcp_year }</div>
                        </div>
                        </c:if>
                       	<img src="${netizenRecipeVO.file_path }" alt="">
                    </figure>
                </div>
                <article class="recipe">
                	<h2>재료소개</h2>
                    <p>${netizenRecipeVO.neti_rcp_cook_mate }</p>
                	<h2>소스/양념장</h2>
                    <p>${netizenRecipeVO.neti_rcp_saus }</p>
                	<h2>만들어볼까요</h2>
                    <pre>${netizenRecipeVO.neti_rcp_cn }</pre>
                 	<div class="like">
                 		<a href="javascript:fn_recipeLike();" class="btn btn-default btn-lg" role="button">
	                 	<span class="icon-heart-empty recipe">좋아요</span>
	                 	<font id="likeCnt">${netizenRecipeVO.neti_rcp_reccnt }</font></a>
                 	</div>
                 	<div class="tag-wrap" id='tagArea'>
                 	</div>
                    <c:choose>
						<c:when test="${netizenRecipeVO.type_cd == 'my'}">
							<div class="board-footer">
		                        <a href="javascript:goMyList();" class="btn btn-default btn-left" role="button">목록</a>
		                        <a href="javascript:fn_check('${netizenRecipeVO.neti_rcp_no }', '${netizenRecipeVO.dtm }', 'DEL');" class="btn btn-default btn-right" role="button">삭제</a> 
		                        <a href="javascript:fn_check('${netizenRecipeVO.neti_rcp_no }', '${netizenRecipeVO.dtm }','SAVE');" class="btn btn-default btn-right" role="button">수정</a> 
		                    </div>
						</c:when>
						<c:otherwise>
							<a href="javascript:goList();" class="btn btn-default btn-right" role="button">목록</a>
						</c:otherwise>
					</c:choose>
                </article>
                <aside class="recipe">
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
							<c:forEach items="${netizenRecipeLatList }" var="netizenRecipeLat">
					   		<li>
								<img src="${netizenRecipeLat.file_path }" alt="${netizenRecipeLat.neti_rcp_cook_nm }"> 
								<a href="#">${netizenRecipeLat.neti_rcp_cook_nm }</a>
								<p>${netizenRecipeLat.neti_rcp_cook_thma }</p>
								<span>${netizenRecipeLat.last_updt_dtm }</span>
							</li> 
							</c:forEach>
						</ul>
					</div>                    
					<div class="widget">
						<h2 class="popular recipe">인기레시피</h2>
						<ul class="wt-thumbnail recipe">
							<c:forEach items="${netizenRecipePopList }" var="netizenRecipePop">
					   		<li>
								<img src="${netizenRecipePop.file_path }" alt="${netizenRecipePop.neti_rcp_cook_nm }"> 
								<a href="#">${netizenRecipePop.neti_rcp_cook_nm }</a>
								<p>${netizenRecipePop.neti_rcp_cook_thma }</p>
								<span>${netizenRecipePop.last_updt_dtm }</span>
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
	var likeCnt = ${netizenRecipeVO.neti_rcp_reccnt };
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
	 
    function goRecipe(neti_rcp_no){
    	
    	$('#neti_rcp_no').val(neti_rcp_no);
        document.baseForm.action="${contextPath}/portal/sensuousmenu/recipeWrite.do";
        document.baseForm.target="_self";
        document.baseForm.method="post";
        document.baseForm.submit();
    }	
	
	function fn_recipeLike(){ 
		$.ajax({ 
			dataType:'json', 
			type:'POST',
			url:"${contextPath}/front/sensuousmenu/updateRecipeLike.do?no=${netizenRecipeVO.neti_rcp_no }&dvs_cd=NETI", 
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
    
    function goList(){

    	document.baseForm.action="${contextPath}/portal/sensuousmenu/netizenRecipeList.do";
        document.baseForm.target="_self";
        document.baseForm.method="post";
        document.baseForm.submit();
    }
    
    function goMyList(){

    	document.baseForm.action="${contextPath}/portal/sensuousmenu/myRecipeList.do";
        document.baseForm.target="_self";
        document.baseForm.method="post";
        document.baseForm.submit();
    }
    
	function fn_check(neti_rcp_no, date, type){ 
		
		$('#date').val(date);
		$('#type').val(type);
        $.ajax({ 
            data: $('#baseForm').serialize(),
            dataType:'json', 
            type:'POST',
            url:"${contextPath}/portal/sensuousmenu/selectCheck.do", 
			success:function(arg){
				if(arg.resultCd == 1){
					if(type == "DEL"){
						fn_recipeDel(neti_rcp_no);
					}else if(type == "SAVE"){
						goRecipe(neti_rcp_no);
					}
				}else{
					alert(arg.resultStr);
					return;
				}
				
			},
            error:function(request,status,error){
                alert("실패코드 : " + request.status+"\n메세지 : " + request.error);
            }
        });
		
		
	} 	
	
    function fn_recipeDel(neti_rcp_no){
    	
    	$('#neti_rcp_no').val(neti_rcp_no);
        $.ajax({ 
            data: $('#baseForm').serialize(),
            dataType:'json', 
            type:'POST',
            url:"${contextPath}/portal/sensuousmenu/deleteRecipe.do", 
			success:function(arg){

				if(arg.result == 1){
					
		  			var form = $('<form/>', {method: 'post', action: '${contextPath}/portal/sensuousmenu/myRecipeList.do'});
		  			$(document.body).append(form);
		  			
		  			form.submit();
				}else{
					alert(arg.resultStr);
					return;
				}
				
			},
            error:function(request,status,error){
                alert("실패코드 : " + request.status+"\n메세지 : " + request.error);
            }
        });
    }	

    document.getElementById('tagArea').innerHTML=fn_tagSplit('${netizenRecipeVO.neti_rcp_tag}');
    
</script>		