
<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="m" uri="/WEB-INF/tlds/message.tld"%>
<%@ page import="foodportal.common.util.Message"%>

<c:set var="contextPath" scope="request">${pageContext.request.contextPath}</c:set>

<input type="hidden" id="bbs_no"		name="bbs_no" value="AFS01">                   <!-- 게시판번호 -->
<input type="hidden" id="ctgry_no"		name="ctgry_no" value="${boardSetting.ctgry_no}">                <!-- 카테고리번호 -->
<input type="hidden" id="start_idx"     name="start_idx" value="${boardSetting.start_idx}">                <!-- start_idx -->

	<section>
      <div id="header">
          <div class="board-head">
              <div class="lnb-viewer" id="nav-open-btn" href="#left-nav">Menu</div>
              <ol class="breadcrumb">
              	  <li id="menuTree"></li>
              </ol>
              <h1>지역별 특화 거리</h1> 
          </div>
      </div>
      
      <div class="list-container">
       	<fieldset>
            <legend>검색</legend>
               <div class="search-container">
                   <span class="total">Total: <strong id="total_cnt">${boardSetting.total_cnt}</strong> Articles</span>
                   <div class="search-wrap">
                    <label for="keycode">검색구분</label>
                    <select id="search_type" name="search_type" class="selecter_basic" style="width:70px;">                        	
                        <option value="">전체        </option>
                        <option value="title">제목</option>
                        <option value="content">내용</option>
                    </select>
                    <input type="text" id="search_keyword" name="search_keyword" value="" onkeyup="if(event.keyCode==13){javascript:resetValue(); searchList(); }">
                    <a href="javascript:resetValue(); searchList();" class="btn btn-default" role="button">검색</a> 
                    <label for="pageview">목록게시글수</label>
                    <select id="show_cnt" name="show_cnt" class="selecter_basic">                        	
                        <option value="10">10개씩</option>
                        <option value="20">20개씩</option>
                        <option value="30">30개씩</option>
                        <option value="40">40개씩</option>
                        <option value="50">50개씩</option>
                    </select>
                   </div>
               </div>
         	</fieldset>  
          	<div class="cat-container">
	            <ul class="category">
	                <c:forEach var="ctgType01List" items="${ctgType01List}" varStatus="ctgType01Status">
	                   <li><a id="div_ctgType01_${ctgType01Status.index}" href="javascript:showHCategory('${ctgType01Status.index}','','CTG_TYPE01','${ctgType01List.ctgry_no}','')">${ctgType01List.ctgrynm}</a></li>
	                </c:forEach>
	             </ul>     
	        </div>
			<div class="gallery col-2" id="listFrame">
              
            </div>              
         	<div class="board-footer">   
              <div class="pagination"></div>
          	</div>
      	</div>
  	</section>
<!-- </form> -->
  
<script type="text/javascript">

//상세페이지팝업    
function fn_OpenDetailPop(bbs_no, ntctxt_no){
	var action  = '${contextPath}/popup/sympathyplus/foodStreetDetailPopup.do?bbs_no='+bbs_no+'&ntctxt_no='+ntctxt_no;
    $(".openinfo").fancybox({
    	maxWidth    : 850,
        maxHeight   : 600,
        minHeight   : 600,
        fitToView   : false,
        width       : '80%',
        height      : '70%',
        hMargin		: 100,
        autoSize    : false,
        scrollBar	: false,
        closeClick  : false,
        openEffect  : 'fade',
        closeEffect : 'fade',
        tpl: {next : '', prev : ''},
        href        : action
    });
}

function fn_drawList(list){
	var listLangth = list.length;
	var content = "";

	for(var i=0; i<listLangth; i++){
		
		content += "<ul>";
		content +="<a class='openinfo fancybox.iframe' data-fancybox-group='iframe' href='javascript:return false;' onclick=fn_OpenDetailPop('"+list[i].bbs_no+"','"+list[i].ntctxt_no+"');>";
		content +="<li class='street-name'><span class='"+list[i].new_flag+"'></span>"+list[i].titl+"</li>";
		if(list[i].img_link_url != 'NONE'){
			content +="<li class='street-img img-480x205' style='background-image:url(${contextPath}"+list[i].img_link_url+");'></li>";
		}else{
			content +="<li class='street-img img-480x205 no'></li>";
		}
		content +="<li class='street-addr' style='height:40px; display:inline-block; text-overflow:ellipsis; overflow:hidden; white-space:nowrap;'>"+list[i].bdt+"</li>";
		content +="</a>";
		content += "</ul>";
	}
	
	document.getElementById("listFrame").innerHTML = content;
}

	/****************************************
	 * Variable
	****************************************/
	var total_cnt_onPage = 0;
	var show_cnt_onPage = 0;
	/****************************************
	 * Init
	****************************************/
	
	$(document).ready(function(){
			
		if('${boardSetting.search_type}' != ""){
	   		$('#search_type').val('${boardSetting.search_type}');
	    }
		if('${boardSetting.show_cnt}' != ""){
	        $('#show_cnt').val('${boardSetting.show_cnt}');
	    }
		
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
	$('#show_cnt').change(function (){
		searchList();   
    });
	
	/****************************************
	 * Function
	 ****************************************/
	//카테고리 클릭
	function showHCategory(idx_1,idx_2,ctgType, ctgryno, hrnk_ctgryno){
		$(".active").removeClass();
		$("#div_ctgType01_"+idx_1).addClass("active");
		setCategorySearch(ctgryno,hrnk_ctgryno);	
	}
	 
	//카테고리클릭 -> 조회
	function setCategorySearch(ctgryno, hrnk_ctgryno){
		$('#ctgry_no').val(ctgryno);
		searchList();
	}
	
	function resetValue(){
		$(".active").removeClass();
		$('#ctgry_no').val('');
	}
	
	function searchList(){
		//특수문자제거
		fn_replaceSpecialChar('#search_keyword');
		
		if($('#search_type').val() == "content"){
			alert('알티베이스 버그로 인하여 내용검색 중지.');
			return;
		}
		
    	$.ajax({ 
            data: $('#baseForm').serialize(),
            dataType:'json', 
            type:'POST',
            url:"${contextPath}/portal/board/boardList.do", 
            success:function(arg){
            	var list = new Array();
            	
            	list = arg.list;
            	
            	total_cnt_onPage = arg.total_cnt;
            	
            	setPaginationVars();
            	
            	fn_drawList(list);
            	$('#total_cnt').html(arg.total_cnt);
            },
            error:function(request,status,error){
                alert("실패코드 : " + request.status+"\n메세지 : " + request.error);
            }
        });
    }
	
	//페이징 변수셋팅
    function setPaginationVars(){
		 //total_cnt_onPage = total_cnt;
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
        $('#start_idx').val(page);
        searchList();
		return false;
	});
</script>