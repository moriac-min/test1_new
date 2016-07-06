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
<input type="hidden" id="type_cd" name="type_cd" value="">      			<!-- type_cd -->

            <section>
                <div id="header">
                    <div class="board-head">
                        <div class="lnb-viewer" id="nav-open-btn" href="#left-nav">Menu</div>
                        <ol class="breadcrumb">
                            <li><a href="#">홈</a></li>
                            <li><a href="#">오감만족식단</a></li>
                            <li><a href="#">네티즌레시피</a></li>
                            <li class="active">나의 레시피</li>
                        </ol>
                        <h1>나의 레시피</h1>
                    </div>
                </div>
                <div class="list-container recipe">
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
	            url:"${contextPath}/portal/sensuousmenu/selectMyRecipeList.do", 
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
            	content += "	<li class=\"chef\">"+list[i].neti_rcp_mber_no+"<span class=\"like\">"+list[i].neti_rcp_reccnt+"</span></li>";
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
    
    function goRecipe(neti_rcp_no){
    	
    	$('#neti_rcp_no').val(neti_rcp_no);
    	$('#type_cd').val("my");

    	document.baseForm.action="${contextPath}/portal/sensuousmenu/netizenRecipe.do";
        document.baseForm.target="_self";
        document.baseForm.method="post";
        document.baseForm.submit();
    }
    
</script>		