<%@page language="java" contentType="text/html; charset=utf-8"
%><%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"
%><%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"
%><%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"
%>
<c:set var="contextPath" scope="request">${pageContext.request.contextPath}</c:set>

<input type="hidden" id="start_idx" name="start_idx">                <!-- start_idx -->
<input type="hidden" id="hrnk_cd" name="hrnk_cd" value="${hrnk_cd }">                <!-- hrnk_cd -->
<input type="hidden" id="cmmn_cd" name="cmmn_cd" value="${cmmn_cd }">                <!-- cmmn_cd -->
 <section>
     <div id="header">
         <div class="board-head">
             <div class="lnb-viewer" id="nav-open-btn" href="#left-nav">Menu</div>
             <ol class="breadcrumb">
                 <li><a href="#">홈</a></li>
                 <li><a href="#">오감만족식단</a></li>
                 <li><a href="#">${titleMap.recipeVO.title_fir }</a></li>
                 <li class="active">${titleMap.recipeVO.title_sec }</li>
             </ol>
             <h1>${titleMap.recipeVO.title_sec } <a href="#" class="btn btn-danger btn-sm">녹색메뉴개발원칙</a></h1>
         </div>
     </div>
     <div class="highlight-wrapper col-3" id="topListFrame" style="border: 0px solid #fff; height: 100%; margin: 0px 0 0px; width: 100%;">
     </div>
     <div class="list-container">
         <div class="search-container">
             <span class="total">Total: <strong id="total_cnt">0</strong> Articles</span>
             <div class="search-wrap">
	              <fieldset>
	                  <legend>검색</legend>
	                  <label for="keycode">검색구분</label>
	                  <select id="search_cate" name="search_cate" class="selecter_basic">                        	
	                      <option value="all">전체</option>
	                      <option value="RC_CATE01">주식</option>
	                      <option value="RC_CATE02">부식</option>
	                      <option value="RC_CATE03">후식</option>
	                      <option value="RC_CATE04">간식</option>
	                  </select>
	                  <input type="text" id="search_keyword" name="search_keyword" value="">
	                  <a href="#" onclick="searchList();" class="btn btn-default" role="button">검색</a> 
	                  <label for="show_cnt">목록게시글수</label>
	                  <select id="show_cnt" name="show_cnt" class="selecter_basic">                        	
	                      <option value="8">8개씩</option>
	                      <option value="16">16개씩</option>
	                      <option value="24">24개씩</option>
	                      <option value="32">32개씩</option>
	                      <option value="40">40개씩</option>
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
				
		searchList();
		searchTopList();
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
	$('#show_cnt').change(function (){
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
	            url:"${contextPath}/portal/sensuousmenu/selectRecipeList.do", 
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
        
        if(listLangth>0){
	        for(var i=0; i<listLangth; i++){
	        	
	            content += "<ul>";
	            content += "	<li class=\"class\">"+list[i].rcp_menu_cate_nm+"</li>";
// 	            content += "	<li class=\"class\"><span class=\"new\"></span>"+list[i].vilt_cn+"</li>";
	            content += "	<a href=\"/front/sensuousmenu/sensuousmenuView.do?rcp_menu_no="+list[i].rcp_menu_no+"&hrnk_cd=${hrnk_cd }&cmmn_cd=${cmmn_cd }\">";
	            content += "		<li class=\"img-222x222\" style=\"background-image:url("+list[i].rcp_menu_list_atch_file_nm+");\"></li>";
	            content += "		<li class=\"title\">"+list[i].rcp_menu_nm+"</li>";
	            content += "	</a>";
	            content += "	<li class=\"date\">"+list[i].menu_use_yn+"</li>";
	            content += "</ul>";
	        }
        }else{
//         	content = "결과가 없습니다.";
        }
        
        $('#listFrame').html(content);
	}
	
	function searchTopList(){
			
	        //특수문자제거
	        fn_replaceSpecialChar('#search_keyword');
	        
	        $.ajax({ 
	            data: $('#baseForm').serialize(),
	            dataType:'json', 
	            type:'POST',
	            url:"${contextPath}/portal/sensuousmenu/selectRecipeTopList.do", 
	            success:function(arg){
	                
	                var list = new Array();
	                list = arg.list;
	                
	                fn_drawTopList(list);
	            },
	            error:function(request,status,error){
	                alert("실패코드 : " + request.status+"\n메세지 : " + request.error);
	            }
	        });
	    }
	 
	//목록 그리기
	 function fn_drawTopList(list){
	 
        var listLangth = list.length;
        var content = "";
        
        for(var i=0; i<listLangth; i++){
        	
        	content += "<ul>";
        	content += "	<a href=\"#\">";
        	content += "		<li class=\"tag\">"+list[i].rcp_menu_cate_nm+"</li>";
        	content += "		<li class=\"img\" style=\"background-image:url("+list[i].rcp_menu_list_atch_file_nm+")\"></li>";
        	content += "		<li class=\"caption\">";
        	content += "			<div class=\"recipe-title\">"+list[i].rcp_menu_nm+"</div>";
        	content += "			<div class=\"recipe-dscr\">"+list[i].rcp_menu_memo+"</div>";
        	content += "		</li>";
        	content += "	</a>";
        	content += "</ul>";
        }
        
        $('#topListFrame').html(content);
    }
    
</script>
