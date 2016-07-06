<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=utf-8"
%><%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"
%><%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"
%><%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" 
%><%@ taglib prefix="m" uri="/WEB-INF/tlds/message.tld"
%><%@ page import="foodportal.common.util.Message"
%>

<c:set var="contextPath" scope="request">${pageContext.request.contextPath}</c:set>

<c:choose>
	<c:when test="${neti_rcp_no == null or neti_rcp_no == ''}">
		<c:set var="neti_rcp_no">-1</c:set>
	</c:when>
	<c:otherwise>
		<c:set var="neti_rcp_no">${neti_rcp_no }</c:set>
	</c:otherwise>
</c:choose>
<input type="hidden" id="neti_rcp_no" name="neti_rcp_no" value="${neti_rcp_no }">   <!-- neti_rcp_no -->
<input type="hidden" id="now_date" name=now_date value="${now_date }">      		<!-- now_date -->
<input type="hidden" id="user_id" name=user_id value="${user_id }">      			<!-- user_id -->

<input type="hidden" name="atch_file_no" id="atch_file_no" value="">				<!-- atch_file_no -->
<input type="hidden" name="file_yn" id="file_yn" value="">							<!-- 파일첨부 여부 -->
<input type="hidden" name="logic_file_nm" id="logic_file_nm" value="">				<!-- 서버에 저장된 파일 논리 이름 -->
<input type="hidden" name="physic_file_nm" id="physic_file_nm" value="">			<!-- 서버에 저장된 파일 물리 이름 -->
<input type="hidden" name="file_path" id="file_path" value="">						<!-- 파일 위치 -->
<input type="hidden" name="file_type_cd" id="file_type_cd" value="">				<!-- 파일 유형 코드  -->
<input type="hidden" name="file_mg" id="file_mg" value="">							<!-- 파일용량 -->

            <section>
                <div id="header">
                    <div class="board-head" id="head_title">
                    </div>
                </div>
                <div class="write-container" id="listFrame">
                </div>
            </section>
		
<script language="JavaScript">

	/****************************************
	 * Variable
	****************************************/

	/****************************************
	 * Init
	****************************************/
	
	$(document).ready(function(){
		searchList();
	}); 
	
	/****************************************
	 * Button Action
	 ****************************************/
	
	/****************************************
	 * Function
	 ****************************************/
	 
	 function searchList(){
	        
	        $.ajax({ 
	            data: $('#baseForm').serialize(),
	            dataType:'json', 
	            type:'POST',
	            url:"${contextPath}/portal/sensuousmenu/selectRecipeWrite.do", 
	            success:function(Data){
	            	if(Data != null && Data.netizenRecipeVO != null){
	            		var content="";
	            		content +="<div class=\"lnb-viewer\" id=\"nav-open-btn\" href=\"#left-nav\">Menu</div>"
            			content +="<ol class=\"breadcrumb\">"
           				content +="		<li><a href=\"#\">홈</a></li>"
      					content +="		<li><a href=\"#\">오감만족식단</a></li>"
  						content +="		<li><a href=\"#\">네티즌레시피</a></li>"
  						content +="		<li class=\"active\">나의 레시피</li>"
  						content +="</ol>"
  						content +="<h1>나의 레시피</h1>"
  						
  						$('#head_title').html(content);
	            						
	            	}else{
	            		var content="";
	            		content +="<div class=\"lnb-viewer\" id=\"nav-open-btn\" href=\"#left-nav\">Menu</div>"
            			content +="<ol class=\"breadcrumb\">"
           				content +="		<li><a href=\"#\">홈</a></li>"
      					content +="		<li><a href=\"#\">오감만족식단</a></li>"
  						content +="		<li><a href=\"#\">네티즌레시피</a></li>"
  						content +="		<li class=\"active\">도전! 레시피</li>"
  						content +="</ol>"
  						content +="<h1>도전! 레시피</h1>"
  						
  						$('#head_title').html(content);
	            	}
	            	
	            	fn_drawList(Data);
	            	
	            },
	            error:function(request,status,error){
	                alert("실패코드 : " + request.status+"\n메세지 : " + request.error);
	            }
	        });
	    }

		//목록 그리기
	 function fn_drawList(Data){
		var nowDate = $('#now_date').val();
		var userId = $('#user_id').val();
		var content = "";
	     
	     if(Data != null && Data.netizenRecipeVO != null){
	    	 
	    	content += "<article>";
			content += "	<form method=\"post\" action=\"/\">";
	        content += "	<fieldset>";
	        content += "		<legend>도전!레시피 등록폼</legend>";
	        content += "		<dl>";
	        content += "			<dt class=\"theme\">도전주제</dt>";
	        content += "			<dd class=\"theme\">손님초대용 한 그릇 한식</dd>";			
	        content += "		</dl>";				            		
	        content += "		<div class=\"fl\">";
	        content += "			<dl class=\"field\">";
	     	content += "				<dt><label for=\"title\">요리명</label></dt>";
	    	content += "				<dd><input type=\"text\" id=\"title\" name=\"title\" class=\"required\" value="+Data.netizenRecipeVO.neti_rcp_cook_nm+"></dd>";
	     	content += "				<dt><label for=\"dscr\">요리설명</label></dt>";        		           	
	     	content += "				<dd><textarea id=\"dscr\" name=\"dscr\" cols=\"30\" rows=\"5\" class=\"required\">"+Data.netizenRecipeVO.neti_rcp_cook_thma+"</textarea></dd>";	        			           	
	     	content += "				<dt><label for=\"ingredients\">요리재료</label></dt>";
	     	content += "				<dd><textarea id=\"ingredients\" name=\"ingredients\" cols=\"30\" rows=\"5\" style=\"height:80px;\"";
	     	content += "				class=\"required\">"+Data.netizenRecipeVO.neti_rcp_cook_mate+"</textarea></dd>";
	     	content += "				<dt><label for=\"source\">소스/양념장</label></dt>";
	     	content += "				<dd><textarea id=\"source\" name=\"source\" cols=\"30\" rows=\"5\" style=\"height:60px;\">"+Data.netizenRecipeVO.neti_rcp_saus+"</textarea></dd>";
	     	content += "			</dl>";
	     	content += "			<div class=\"meta\"><span class=\"chef\">"+Data.netizenRecipeVO.cretr_id+"</span>"+Data.netizenRecipeVO.cret_dtm+"</div>";
	     	content += "		</div>";
	     	content += "		<div class=\"imgupload\">";
	     	content += "			<figure style=\"background-image:url("+Data.netizenRecipeVO.file_path+")\"></figure>";
	     	content += "			<div class=\"upload-size\">이미지 업로드 사이즈: 최소 600X600, 최대 1,000X1,000 (단위:픽셀)</div>";
	     	content += "			<a href=\"javascript:fn_pop('${contextPath}/popup/commonPopup/fileUpload.do?uploadSource=recipe');\" class=\"btn btn-default\" role=\"button\">완성요리 올리기</a>";
	     	content += "		</div>";
	     	content += "		<label for=\"recipe-content\" class=\"hidden\">레시피 내용</label>";
	     	content += "		<textarea id=\"recipe-content\" name=\"recipe-content\" cols=\"100\" rows=\"20\">"+Data.netizenRecipeVO.neti_rcp_cn+"</textarea>";
	     	content += "		<dl class=\"tags\">";
	     	content += "			<dt><label for=\"tag\">태그</label></dt>";
	     	content += "			<dd><input type=\"text\" id=\"tag\" name=\"tag\" value="+Data.netizenRecipeVO.neti_rcp_tag+">";
	     	content += "				<p>작성한 글의 주요 정보를 키워드로 표현해 보세요. 태그를 등록하면 같은 태그가 등록된 게시글을 한번에 모아서 볼 때 쉽고 편리합니다.<br>";
	     	content += "				최대 10개까지 등록하실 수 있으며, 키워드 구분은 쉼표(,)로 하면 됩니다. (예) 떡볶이, 떡, 볶음, 간장, 고추장, 매콤해, 즉석 등</p>";
	     	content += "			</dd>";
	     	content += "		</dl>";
	     	content += "		<div class=\"board-footer\">";
	     	content += "			<a href=\"javascript:goList();\" class=\"btn btn-default btn-left\" role=\"button\">목록</a> ";
	     	content += "			<a href=\"javascript:goList();\" class=\"btn btn-default btn-right\" role=\"button\">취소</a> ";
	     	content += "			<a href=\"javascript:fn_saveData("+Data.netizenRecipeVO.neti_rcp_atch_file_no+");\" class=\"btn btn-default btn-right\" role=\"button\">등록</a> ";
	     	content += "		</div>";
	     	content += "	</form>";
	     	content += "</article>";
	     	
	     }else{
	    	 
	    	content += "<article>";
			content += "	<form method=\"post\" action=\"/\">";
	        content += "	<fieldset>";
	        content += "		<legend>도전!레시피 등록폼</legend>";
	        content += "		<dl>";
	        content += "			<dt class=\"theme\">도전주제</dt>";
	        content += "			<dd class=\"theme\">손님초대용 한 그릇 한식</dd>";			
	        content += "		</dl>";				            		
	        content += "		<div class=\"fl\">";
	        content += "			<dl class=\"field\">";
	     	content += "				<dt><label for=\"title\">요리명</label></dt>";
	    	content += "				<dd><input type=\"text\" id=\"title\" name=\"title\" class=\"required\" onfocus=\"if(this.value !='')this.value='';\" onblur=\"if(this.value.length==0){this.value='요리명을 입력하세요.';}\" value=\"요리명을 입력하세요.\"></dd>";
	     	content += "				<dt><label for=\"dscr\">요리설명</label></dt>";        		           	
	     	content += "				<dd><textarea id=\"dscr\" name=\"dscr\" cols=\"30\" rows=\"5\" class=\"required\"></textarea></dd>";	        			           	
	     	content += "				<dt><label for=\"ingredients\">요리재료</label></dt>";
	     	content += "				<dd><textarea id=\"ingredients\" name=\"ingredients\" cols=\"30\" rows=\"5\" style=\"height:80px;\"";
	     	content += "				class=\"required\"></textarea></dd>";
	     	content += "				<dt><label for=\"source\">소스/양념장</label></dt>";
	     	content += "				<dd><textarea id=\"source\" name=\"source\" cols=\"30\" rows=\"5\" style=\"height:60px;\"></textarea></dd>";
	     	content += "			</dl>";
	     	content += "			<div class=\"meta\"><span class=\"chef\">"+userId+"</span>"+nowDate+"</div>";
	     	content += "		</div>";
	     	content += "		<div class=\"imgupload\">";
	     	content += "			<figure id=\"imgname\"></figure>";
	     	content += "			<div class=\"upload-size\">이미지 업로드 사이즈: 최소 600X600, 최대 1,000X1,000 (단위:픽셀)</div>";
	     	content += "			<a href=\"javascript:fn_pop('${contextPath}/popup/commonPopup/fileUpload.do?uploadSource=recipe');\" class=\"btn btn-default\" role=\"button\">완성요리 올리기</a>";
	     	content += "		</div>";
	     	content += "		<label for=\"recipe-content\" class=\"hidden\">레시피 내용</label>";
	     	content += "		<textarea id=\"recipe-content\" name=\"recipe-content\" cols=\"100\" rows=\"20\"></textarea>";
	     	content += "		<dl class=\"tags\">";
	     	content += "			<dt><label for=\"tag\">태그</label></dt>";
	     	content += "			<dd><input type=\"text\" id=\"tag\" name=\"tag\">";
	     	content += "				<p>작성한 글의 주요 정보를 키워드로 표현해 보세요. 태그를 등록하면 같은 태그가 등록된 게시글을 한번에 모아서 볼 때 쉽고 편리합니다.<br>";
	     	content += "				최대 10개까지 등록하실 수 있으며, 키워드 구분은 쉼표(,)로 하면 됩니다. (예) 떡볶이, 떡, 볶음, 간장, 고추장, 매콤해, 즉석 등</p>";
	     	content += "			</dd>";
	     	content += "		</dl>";
	     	content += "		<div class=\"board-footer\">";
	     	content += "			<a href=\"javascript:goList();\" class=\"btn btn-default btn-left\" role=\"button\">목록</a> ";
	     	content += "			<a href=\"javascript:goList();\" class=\"btn btn-default btn-right\" role=\"button\">취소</a> ";
	     	content += "			<a href=\"javascript:fn_saveData();\" class=\"btn btn-default btn-right\" role=\"button\">등록</a> ";
	     	content += "		</div>";
	     	content += "	</form>";
	     	content += "</article>";
	    
	     }
     
     	$('#listFrame').html(content);
     	
 	}
		
	//목록리스트로
    function goList(){
    	
        document.baseForm.action="${contextPath}/front/sensuousmenu/netizenRecipeList.do";
        document.baseForm.target="_self";
        document.baseForm.method="post";
        document.baseForm.submit();
    }	 
    
  	//저장
	function fn_saveData(param){

		if(!fn_validate()){
			return;
		}
		
		if(confirm('${m:getMessage("msg.common.save.confirm")}')){
			saveDataList(param);
		}
		
	}

	//유효성 체크
	function fn_validate(){
		
		//요리명
		if(fn_empty('#title','${m:getMessageIn("msg.common.valid.required", "요리명") }') == false){	
			return false;	
		}
		
		//요리설명
		if(fn_empty('#dscr','${m:getMessageIn("msg.common.valid.required", "요리설명") }') == false){	
			return false;	
		}
		//요리재료
		if(fn_empty('#ingredients','${m:getMessageIn("msg.common.valid.required", "요리재료") }') == false){	
			return false;	
		}
			
		return true;
	}
	
	//레시피 저장
	  function saveDataList(param){

		$('#atch_file_no').val(param);
		
	   //특수문자제거
	   fn_replaceSpecialChar('#title');
	   fn_replaceSpecialChar('#dscr');
	   fn_replaceSpecialChar('#ingredients');
	   fn_replaceSpecialChar('#source');
	   fn_replaceSpecialChar('#recipe-content');
	   fn_replaceSpecialChar('#tag');
	   
	  	$.ajax({
	  		data: $('#baseForm').serialize(),
	  		dataType: 'json',
	  		type: 'POST',
	  		url:"${contextPath}/portal/sensuousmenu/saveNetizenRecipe.do", 
	  	}).done(function(rstData){
	  		if(rstData.rtnCd == '1'){
	  			if(rstData.typeCd == 'my'){
		  			var form = $('<form/>', {method: 'post', action: '${contextPath}/portal/sensuousmenu/myRecipeList.do'});
		  			$(document.body).append(form);
		  			
		  			form.submit();
	  			}else{
	  				var form = $('<form/>', {method: 'post', action: '${contextPath}/portal/sensuousmenu/netizenRecipeList.do'});
		  			$(document.body).append(form);
		  			
		  			form.submit();
	  				
	  			}
	  			
	  		}else{
	  			alert('${m:getMessage("msg.common.system.error")}');
	  		}
	  		
	  	}).fail(function(request ,status, error){
	  		alert('${m:getMessage("msg.common.system.error")}');
	  	});
	  }
	 
	//유효성 체크
	function fn_pop(url){
		
		var popUp_var = window.open(url, '', 'width=510,height=500,scrollbars=no,resizable=no').fn_callbackfileUpload = function(fileInfo){

			var fileNm = fileInfo.physic_file_nm+"."+fileInfo.file_type_cd;
			$('#file_yn').val('Y');
			$('#logic_file_nm').val(fileInfo.logic_file_nm);
			$('#physic_file_nm').val(fileInfo.physic_file_nm);
			$('#file_path').val(fileInfo.file_path);
			$('#file_mg').val(fileInfo.file_mg);
			$('#file_type_cd').val(fileInfo.file_type_cd);
					
			this.close();
			
				document.getElementById("imgname").style.backgroundImage = "url(/img/tmpimg/"+fileNm+")";
				
		};
	}
		
</script>		