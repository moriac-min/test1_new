<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=utf-8"
%><%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"
%><%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"
%><%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" 
%><%@ taglib prefix="m" uri="/WEB-INF/tlds/message.tld"
%><%@ page import="foodportal.common.util.Message"
%>

<c:set var="contextPath" scope="request">${pageContext.request.contextPath}</c:set>

<input type="hidden" id="start_idx" name="start_idx">						<!-- start_idx -->
<input type="hidden" id="show_cnt" name="show_cnt" value="">				<!-- show_cnt -->
<input type="hidden" id="order" name="order" value="">						<!-- order -->
<input type="hidden" id="neti_rcp_no" name="neti_rcp_no" value="">      	<!-- neti_rcp_no -->
<input type="hidden" id="best_rcp_no" name="best_rcp_no" value="">      	<!-- best_rcp_no -->

<section>
	<div id="header">
	    <div class="board-head">
	        <div class="lnb-viewer" id="nav-open-btn" href="#left-nav">Menu</div>
	        <ol class="breadcrumb">
	            <li><a href="#">홈</a></li>
	            <li><a href="#">오감만족식단</a></li>
	            <li><a href="#">네티즌레시피</a></li>
	            <li class="active">도전!레시피</li>
	        </ol>
	        <h1>도전!레시피</h1>
	    </div>
	</div>
	<div class="netizen-recipe" id="bestListFrame">
	    <!-- 없는 경우 <div class="best-recipe no"> -->
	</div>
	<div class="netizen-recipe-shadow"></div>
	<div class="list-container recipe">
		<ul id="tabs" class="tab-container tab-3">
	        <li id="lat" class="active"><a href="javascript:fn_active('lat');" class="tab latest">최신레시피</a></li>
	        <li id="pop"><a href="javascript:fn_active('pop');" class="tab populars">인기레시피</a></li>
	        <li id="rec"><a href="javascript:fn_active('rec');" class="tab recommend">추천레시피</a></li>
	    </ul>
	    <div class="search-container">
	        <span class="total">Total: <strong id="total_cnt">0</strong> Articles</span>
	        <div class="search-wrap">
	                <fieldset>
	                    <legend>검색</legend>
	                    <label for="keycode">검색구분</label>
	                    <select id="search_cate" name="search_cate" class="selecter_basic">                        	
	                        <option value="all">전체</option>
	                        <option value="title">제목</option>
	                        <option value="content">내용</option>
	                        <option value="writer">작성자</option>
	                    </select>	                    
	                    <input type="text" id="search_keyword" name="search_keyword" value="">
	                    <a href="#" onclick="searchList();" class="btn btn-default" role="button">검색</a> 
	                    <label for="show_cnt">목록게시글수</label>
		                <select id="show_cnt_slt" name="show_cnt_slt" class="selecter_basic">                        	
							<option value="8" selected="selected">8개씩</option>
                            <option value="20">20개씩</option>
                            <option value="30">30개씩</option>
                            <option value="40">40개씩</option>
                            <option value="50">50개씩</option>		                    
		                </select>			                    
	                    <a href="/" class="btn btn-default" role="button">보기</a>
	                </fieldset>
	        </div>
	    </div>
	    <div class="gallery recipe col-4" id="listFrame">
	    </div>
	    <div class="board-footer">
	        <div class="pagination"></div>
	    </div>
	</div>
</section>
		
<script language="JavaScript">

	/****************************************
	 * Variable
	****************************************/
	var total_cnt_onPage = 0;
	var show_cnt_onPage = 0;
	/****************************************
	 * Init
	****************************************/
	
	$(document).ready(function(){
		
		$('#start_idx').val("1");
		
		$('#show_cnt').val($('#show_cnt_slt').val());
		searchBestList();
		searchList();
	}); 
	
	/****************************************
	 * Button Action
	 ****************************************/
	//조회조건 selectbox 
	$('#search_type').change(function (){
	    if($('#search_type').val() == ""){
	    	$('#search_keyword').val("");
	    }	  
	});
	
	//리스트개수
	$('#show_cnt_slt').change(function (){
		$('#show_cnt').val($('#show_cnt_slt').val());
		searchList();
    });
	
	//페이징 변수셋팅
    function setPaginationVars(){
         show_cnt_onPage = $('#show_cnt').val();
         
         $('.pagination').pagination("updateItems", total_cnt_onPage);
         $('.pagination').pagination("updateItemsOnPage", show_cnt_onPage);
         var pageNum = $('#start_idx').val();
         if(pageNum == null || pageNum == ''){
             pageNum = 1;
         }
         
         $('.pagination').pagination('drawPage', pageNum);
     }
     
    //페이징
    $(function() {
        $('.pagination').pagination({
            items: total_cnt_onPage,
            itemsOnPage: show_cnt_onPage,
            cssStyle: 'compact-theme'
        });
    });
    
    $('.pagination').click(function(){
        var page = $('.pagination').pagination('getCurrentPage');
        if($('#start_idx').val() != page){
            $('#start_idx').val(page);
            searchList();
        }
        return false;
    });
    
	/****************************************
	 * Function
	 ****************************************/
	 function searchList(){
		
	        //특수문자제거
	        fn_replaceSpecialChar('#search_keyword');
	        
	        $.ajax({ 
	            data: $('#baseForm').serialize(),
	            dataType:'json', 
	            type:'POST',
	            url:"${contextPath}/portal/sensuousmenu/selectNetizenRecipeList.do", 
	            success:function(arg){
	                
	                //total 개수
	                total_cnt_onPage = arg.total_cnt;
	                $('#total_cnt').text(total_cnt_onPage);
	                
	                //페이징 셋팅
	                setPaginationVars();
	                
	                var list = new Array();
	                list = arg.list;
	                
	                fn_drawList(list);
	            },
	            error:function(request,status,error){
	                alert("실패코드 : " + request.status+"\n메세지 : " + request.error);
	            }
	        });
	    }
	 
	//목록 그리기
	 function fn_drawList(list){
	 
        var listLangth = list.length;
        var content = "";
        var order = $('#order').val();
        
        if(listLangth>0){
	        for(var i=0; i<listLangth; i++){
	        	
	            content += "<ul>";
	            
	            if(order == 'pop'){
	            	content += "	<li class=\"chef\">"+list[i].neti_rcp_mber_no+"<span class=\"hit\">"+list[i].neti_rcp_srcnt+"</span></li>";
	            }else if(order == 'rec'){
	            	content += "	<li class=\"chef\">"+list[i].neti_rcp_mber_no+"<span class=\"like\">"+list[i].neti_rcp_reccnt+"</span></li>";
	            }else{
	            	content += "	<li class=\"chef\">"+list[i].neti_rcp_mber_no+"</li>";
	            }
	            
	            content += "	<a href='javascript:goRecipe("+list[i].neti_rcp_no+");'>";
	            content += "		<li class=\"img-222x222\" style=\"background-image:url("+list[i].file_path+");\"></li>";
	            content += "		<li class=\"title\">"+list[i].neti_rcp_cook_nm+"</li>";
	            content += "	</a>";
	            content += "	<li class=\"date\">"+list[i].cret_dtm+"</li>";
	            content += "</ul>";
	        }
        }else{
//         	content = "결과가 없습니다.";
        }
        
        
        $('#listFrame').html(content);
    }
    
	 function searchBestList(state, cnt, no){
			
	    	var bestPrev;
	    	var bestNext;
	    	if(state == 'prev'){
	    		bestPrev = no-1;
	    		$('#best_rcp_no').val(bestPrev);
	    	}else if(state == 'next'){
	    		bestNext = no+1;
	    		$('#best_rcp_no').val(bestNext);
	    	}

	    	if(bestPrev == 0){
	    		return;
	    	}
	    	if(cnt < bestNext){
	    		return;
	    	}
	        $.ajax({ 
	            data: $('#baseForm').serialize(),
	            dataType:'json', 
	            type:'POST',
	            url:"${contextPath}/portal/sensuousmenu/selectNetizenBestRecipeList.do", 
	            success:function(Data){
	            	
	            		fn_drawBestList(Data);
	            },
	            error:function(request,status,error){
	                alert("실패코드 : " + request.status+"\n메세지 : " + request.error);
	            }
	        });
	    }
	 
	//목록 그리기
	 function fn_drawBestList(Data){
		console.dir(Data);
     var content = "";
     
     if(Data != null && Data.netizenRecipeVO != null){
    	 
    	content += "<div class=\"netizen-recipe\">";
		content += "	<div class=\"best-recipe\" style=\"background-image:url("+Data.netizenRecipeVO.file_path+")\">";
        content += "		<div class=\"tag\">BEST<br>RECIPE";
        content += "				<div class=\"month\">"+Data.netizenRecipeVO.best_rcp_mm+"";
        content += "				<a href=\"javascript:searchBestList('prev', "+Data.netizenRecipeVO.best_rcp_cnt+", "+Data.netizenRecipeVO.best_rcp_no+");\" class=\"prev\">이전달</a>";
        content += "				<a href=\"javascript:searchBestList('next', "+Data.netizenRecipeVO.best_rcp_cnt+", "+Data.netizenRecipeVO.best_rcp_no+");\" class=\"next\">다음달</a>";
        content += "			</div>";			
        content += "			<div class=\"year\">"+Data.netizenRecipeVO.best_rcp_year+"</div>";				            		
        content += "		</div>";
        content += "		<div class=\"caption\">";
     	content += "			<div class=\"recipe-title\">"+Data.netizenRecipeVO.neti_rcp_cook_nm+"</div>";
    	content += "			<div class=\"recipe-dscr\">"+Data.netizenRecipeVO.neti_rcp_cook_thma+"</div>";
     	content += "		</div>";
     	content += "		<div class=\"shading\"></div>";        		           	
     	content += "	</div>";
     	content += "	<div class=\"event-recipe\" title=\"네티즌 레시피에 도전하세요. 당신이 바로 요리고수! 월간베스트 레시피에 선정되시면 소정의 상품을 드립니다.\">";	        			           	
     	content += "		<dl class=\"theme\">";
     	content += "			<dt>12월의 주제</dt>";
     	content += "			<dd>손님초대용 한 그릇 한식</dd>";
     	content += "		</dl>";
     	content += "		<dl class=\"event\">";
     	content += "			<dt>응모자격</dt>";
     	content += "			<dd>요리에 관심있는 대한민국 국민 누구나</dd>";
     	content += "			<dt>일정</dt>";
     	content += "			<dd>2014년 12월1일부터 31일까지</dd>";
     	content += "			<dt>작성요령</dt>";
     	content += "			<dd>요리명, 창작배경 및 특징, 재료 및 용량, 조리법, 요리과정과 완성된 사진은 반드시 포함되어야 합니다.</dd>";
     	content += "			<dt>심사기준</dt>";
     	content += "			<dd>등록된 레시피의 인기도와 추천수를 기반 네티즌 점수와 전문가 심사를 통하여 선정됩니다.</dd>";
     	content += "			<dt>시상계획</dt>";
     	content += "			<dd>월간베스트 레시피에 선정되시면 20만원 상당의 선물을 드립니다.</dd>";
     	content += "			<dt>응모방법</dt>";
     	content += "			<dd>도전!레시피를 통하여 온라인으로 레시피를 등록하시면 끝!</dd>";
     	content += "			<dt>발표</dt>";
     	content += "			<dd>2015년 1월 9일(금)</dd>";
     	content += "			<dt>기타</dt>";
     	content += "			<dd>선정된 레시피는 저작권과 소유권은 식품의약품안전처와 공동 권리를 갖습니다.</dd>";
     	content += "			<dt>문의</dt>";
     	content += "			<dd>식품의약품안전처 네티즌레시피 담당자 043-719-0987</dd>";
     	content += "		</dl>";
     	content += "		<div class=\"event-btn\">";
     	content += "			<a href=\"javascript:goRecipeWrite();\" class=\"btn btn-default\">도전! 레시피</a>";
     	content += "		</div>";
     	content += "	</div>";
     	content += "</div>";
     	
     }else{
    	 
    	content += "<div class=\"best-recipe no\"></div>";
		content += "	<div class=\"event-recipe\" title=\"네티즌 레시피에 도전하세요. 당신이 바로 요리고수! 월간베스트 레시피에 선정되시면 소정의 상품을 드립니다.\">";	        			           	
      	content += "		<dl class=\"theme\">";
      	content += "			<dt>12월의 주제</dt>";
      	content += "			<dd>손님초대용 한 그릇 한식</dd>";
      	content += "		</dl>";
      	content += "		<dl class=\"event\">";
      	content += "			<dt>응모자격</dt>";
      	content += "			<dd>요리에 관심있는 대한민국 국민 누구나</dd>";
      	content += "			<dt>일정</dt>";
      	content += "			<dd>2014년 12월1일부터 31일까지</dd>";
      	content += "			<dt>작성요령</dt>";
      	content += "			<dd>요리명, 창작배경 및 특징, 재료 및 용량, 조리법, 요리과정과 완성된 사진은 반드시 포함되어야 합니다.</dd>";
      	content += "			<dt>심사기준</dt>";
      	content += "			<dd>등록된 레시피의 인기도와 추천수를 기반 네티즌 점수와 전문가 심사를 통하여 선정됩니다.</dd>";
      	content += "			<dt>시상계획</dt>";
      	content += "			<dd>월간베스트 레시피에 선정되시면 20만원 상당의 선물을 드립니다.</dd>";
      	content += "			<dt>응모방법</dt>";
      	content += "			<dd>도전!레시피를 통하여 온라인으로 레시피를 등록하시면 끝!</dd>";
      	content += "			<dt>발표</dt>";
      	content += "			<dd>2015년 1월 9일(금)</dd>";
      	content += "			<dt>기타</dt>";
      	content += "			<dd>선정된 레시피는 저작권과 소유권은 식품의약품안전처와 공동 권리를 갖습니다.</dd>";
      	content += "			<dt>문의</dt>";
      	content += "			<dd>식품의약품안전처 네티즌레시피 담당자 043-719-0987</dd>";
      	content += "		</dl>";
      	content += "		<div class=\"event-btn\">";
      	content += "			<a href=\"javascript:goRecipeWrite();\" class=\"btn btn-default\">도전! 레시피</a>";
      	content += "		</div>";
      	content += "	</div>";
      	content += "</div>";
    
     }
     
     	$('#bestListFrame').html(content);
     	
 	}
	
	 function fn_active(id){
		$("#lat").removeClass();
		$("#pop").removeClass();
		$("#rec").removeClass();
		
		if(id == "lat"){
			$("#lat").addClass("active");
			$('#order').val('lat');
		 }else if(id == "pop"){
			 $("#pop").addClass("active");
			 $('#order').val('pop');
		 }else if(id == "rec"){
			 $("#rec").addClass("active");
			 $('#order').val('rec');
		 }
		searchList();
	 }
	 
    function goRecipe(neti_rcp_no){
    	
    	$('#neti_rcp_no').val(neti_rcp_no);
        document.baseForm.action="${contextPath}/portal/sensuousmenu/netizenRecipe.do";
        document.baseForm.target="_self";
        document.baseForm.method="post";
        document.baseForm.submit();
    }
    
    function goRecipeWrite(neti_rcp_no){
    	
    	$('#neti_rcp_no').val(neti_rcp_no);
        document.baseForm.action="${contextPath}/portal/sensuousmenu/recipeWrite.do";
        document.baseForm.target="_self";
        document.baseForm.method="post";
        document.baseForm.submit();
    }	
    
    
    
    
</script>		