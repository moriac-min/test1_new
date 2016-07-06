<%@page language="java" contentType="text/html; charset=utf-8"
%><%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"
%><%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"
%><%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"
%>

<c:set var="contextPath" scope="request">${pageContext.request.contextPath}</c:set>
<input type="hidden" id="injry_esntl_no" name="injry_esntl_no">             <!-- 글번호 -->
<input type="hidden" id="start_idx" name="start_idx">             			<!-- start_idx -->

<section>
   <div id="header">
       <div class="board-head">
           <div class="lnb-viewer" id="nav-open-btn" href="#left-nav">Menu</div>
           <ol class="breadcrumb">
               <li><a href="#">홈</a></li>
               <li><a href="#">식품위해정보</a></li>
               <li class="active">회수&middot;판매중지</li>
           </ol>
           <h1>회수&middot;판매중지</h1>
           <p class="excerpt">국내에서 이미 유통된 식품 중 기준.규격에 부적합해 회수 및 판매중지된 제품을 공개합니다.<br>
               소비자는 해당제품을 구입장소에 되돌려주시고 판매자는 해당식품 판매를 중지하시고 회수업체에 반품하시기 바랍니다.</p>
       </div>
   </div>
   <div class="list-container">
       <div class="search-container">
           <span class="total">Total: <strong id="total_cnt">0</strong> Articles</span>
           <div class="search-wrap">
                   <fieldset>
                       <legend>검색</legend>
                       <label for="search_type">검색구분</label>
                       <select id="search_type" name="search_type" class="selecter_basic">                        	
                           <option value="">전체</option>
                           <option value="01">제품명</option>
                           <option value="02">영업자</option>
                           <option value="03">회수사유</option>
                       </select>
                       <input type="text" id="bbs-keyword" name="bbs-keyword" value="">
                       <a href="/" class="btn btn-default" role="button">검색</a> 
                       <label for="show_cnt">목록게시글수</label>
                       <select id="show_cnt" name="show_cnt" class="selecter_basic">                        	
                           <option value="10">10개씩</option>
                           <option value="20">20개씩</option>
                           <option value="30">30개씩</option>
                           <option value="40">40개씩</option>
                           <option value="50">50개씩</option>
                       </select>
<!--                        <a href="/" class="btn btn-default" role="button">보기</a> -->
                   </fieldset>
           </div>
       </div>
       <div class="gallery col-4" id="listFrame">
<!--        반복 -->
<!--            <ul> -->
<!--                <li class="issue"><span class="new"></span>세균수 초과</li> -->
<!--                <a class="recall fancybox.iframe" data-fancybox-group="iframe" href="suspensionDetail.jsp"> -->
<!--                <li class="img-222x175" style="background-image:url(../../../img/sample-222x175.png);"></li> -->
<!--                 <li class="product">송편</li> -->
<!--                 <li class="company">신라병가</li> -->
<!--                 </a> -->
<!--                 <li class="date">2014.10.28</li> -->
<!--             </ul> -->
<!--        반복 -->           
        </div>
        <div class="board-footer">
            <div class="pagination"></div>
        </div>
    </div>
</section>

<script type="text/javascript">

	/****************************************
	 * Variable
	****************************************/
	var total_cnt_onPage = 0;
	var show_cnt_onPage = 0;
	/****************************************
	 * Init
	****************************************/
	
	$(document).ready(function(){
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
	
	//페이징
	$(function() {
	    $('.pagination').pagination({
	        items: 0,
	        itemsOnPage: 10,
	        cssStyle: 'compact-theme'
	    });
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
	            url:"${contextPath}/portal/fooddanger/searchSuspensionList.do", 
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
	 
	 function fn_drawList(list){
	 
        var listLangth = list.length;
        var content = "";
        var fileList = null;
        
        for(var i=0; i<listLangth; i++){

        	var creDtm = list[i].cret_dtm;
	     	creDtm = creDtm.replace(/-/gi,"");
	     	creDtm = creDtm.substr(0,8);
	     	
	     	content += "<ul>";
	     	content += "<li class='issue'>";
	     	content += "<span class='new'></span>";
	     	content += list[i].caus_factor_cd_nm+"</li>";
	     	content += "<a class='recall fancybox.iframe' data-fancybox-group='iframe' onclick=\"javascript:fn_moveDetail('"+list[i].injry_esntl_no+"');\">";
	     	if(parseInt(creDtm) > parseInt(fn_getPlusMinusDate('',-4))){
	     		content += "<li class='img-222x175' style='background-image:url("+list[i].atchfl_seq+");'></li>";
	     	}else{
		     	content += "<li class='img-222x175' style='background-image:url(../../../img/sample-222x175.png);'></li>";//디폴트 이미지
	     	}  
	     	content += "<li class='product'>"+list[i].prdt_nm+"</li>";
	     	content += "<li class='company'>"+list[i].abbr_nm+"</li>";
	     	content += "  </a>";
	     	content += "<li class='date'>"+list[i].cret_dtm+"</li>";
	        content += "</ul>";
        }
        
        $('#listFrame').html(content);
    }
	 
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
        $('#start_idx').val(page);
        searchList();
        return false;
    });
    
    function fn_moveDetail(no){
    	
    	var action  = '${contextPath}/popup/suspensionDetail.do?search_keyword='+no;
        
        $(".openinfo").fancybox({
        	maxWidth    : 830,
            maxHeight   : 740,
            minHeight   : 740,
            fitToView   : false,
            width       : '70%',
            height      : '80%',
            autoSize    : false,
            closeClick  : false,
            openEffect  : 'fade',
            closeEffect : 'fade',
            href        : action
        });
        
    }
    
</script>