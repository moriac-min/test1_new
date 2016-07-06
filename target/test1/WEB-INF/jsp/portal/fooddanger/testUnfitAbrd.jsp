<%@page language="java" contentType="text/html; charset=utf-8"
%><%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"
%><%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"
%><%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"
%>

<c:set var="contextPath" scope="request">${pageContext.request.contextPath}</c:set>
<input type="hidden" id="report_no" name="report_no">             <!-- 글번호 -->
<input type="hidden" id="start_idx" name="start_idx">             <!-- start_idx -->

<section>
   <div id="header">
       <div class="board-head">
           <div class="lnb-viewer" id="nav-open-btn" href="#left-nav">Menu</div>
           <ol class="breadcrumb">
               <li><a href="#">홈</a></li>
               <li><a href="#">식품위해정보</a></li>
               <li class="active">검사부적합(국외)</li>
           </ol>
           <h1>검사부적합(국외)</h1>
           <p class="excerpt">아래 제품(제조원과 유통기한이 동일한 제품만 해당)은 검사결과 기준.규격부적합 판정을 받아<br>
                            수출국가로 반송되거나 폐기됩니다.</p>
       </div>
   </div>
   <div class="list-container">
       <div class="search-container">
           <span class="total">Total: <strong id="total_cnt">0</strong> Articles</span>
           <div class="search-wrap">
<!--            	<form id="searchForm" name="searchForm" action="#" method="GET"> -->
                   <fieldset>
                       <legend>검색</legend>
                       <label for="search_type">검색구분</label>
                       <select id="search_type" name="search_type" class="selecter_basic">                        	
                           <option value="">전체</option>
                           <option value="01">업체명</option>
                           <option value="02">업체소재지</option>
                           <option value="03">제품명</option>
                           <option value="04">유형별</option>
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
                    <div class="gallery col-2" id="listFrame">
                        
<!--                         <ul> -->
<!--                             <li class="product-name-kor"><span class="new"></span>비트레드</li> -->
<!--                             <li class="product-name-eng">BEET RED COLOR</li> -->
<!--                             <li class="product-info"> -->
<!--                             	<dl> -->
<!--                                 	<dt>제품구분</dt> -->
<!--                                     <dd>식품첨가물</dd> -->
<!--                                 	<dt>품목명</dt> -->
<!--                                     <dd>비트레드</dd> -->
<!--                                 	<dt>제조국가</dt> -->
<!--                                     <dd>중국</dd> -->
<!--                                 	<dt>제조/수출회사</dt> -->
<!--                                     <dd>JIANGXI GUOYI BIO-TECH CO., LTD.</dd> -->
<!-- 								</dl>                             -->
<!--                             </li> -->
<!--                             <li class="issue-info"> -->
<!--                             	<dl> -->
<!--                                 	<dt>위반내역<br> -->
<!-- 										(시험항목/기준/결과)</dt> -->
<!--                                     <dd class="issue">수은1.9ppm검출(규격:1.0ppm이하)</dd> -->
<!--                                 	<dt>처리기관</dt> -->
<!--                                     <dd>부산청(양산)</dd> -->
<!--                                 	<dt>부적합일자</dt> -->
<!--                                     <dd>2014.03.07</dd> -->
<!-- 								</dl>                             -->
<!--                             </li> -->
<!--                         </ul> -->
                        
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
	            url:"${contextPath}/portal/fooddanger/searchTestUnfitAbrdList.do", 
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

        	var creDtm = list[i].hmpgpblict_prcsdtm;
	     	creDtm = creDtm.replace(/-/gi,"");
	     	creDtm = creDtm.substr(0,8);
        	
	     	content += "<ul>";
	     	content += "<li class='product-name-kor'>";
	     	if(parseInt(creDtm) > parseInt(fn_getPlusMinusDate('',-4))){
            	content +=  "<span class='new'></span>";
            }
            content += list[i].prdtnm+"</li>";
            content += "<li class='product-name-eng'>"+list[i].prdtnm+"</li>";//영문명?
            content += "<li class='product-info'>";
            content += "<dl>";
            content += "<dt>제품구분</dt>";
            content += "<dd>"+list[i].tkawyspci_typenm+"</dd>";
            content += "<dt>품목명</dt>";
            content += "<dd>"+list[i].prdlst_cd_nm+"</dd>";
            content += "<dt>제조국가</dt>";
            content += "<dd>"+list[i].mnf_natncd_nm+"</dd>";	
            content += "<dt>제조/수출회사</dt>";
            content += "<dd>"+list[i].bsshnm+"</dd>";    	
            content += "</dl>";
            content += "</li>";
            content += "<li class='issue-info'>";       
            content += "<dl>";	                            
            content += "<dt>위반내역<br>";
            content += "(시험항목/기준/결과)</dt>";
            content += "<dd class='issue'>"+list[i].test_itmnm;
            if(list[i].stdr_stnd != ''){	//규격
	            content += list[i].stdr_stnd;
            }
            if(list[i].testanals_rsltnm != ''){	//결과
            	content += list[i].testanals_rsltnm;
            }
            content += "</dd>";
            content += "<dt>처리기관</dt>";
            content += "<dd>"+list[i].prsec_insttcd_nm+"</dd>";//검사기관
            content += "<dt>부적합일자</dt>";
            content += "<dd>"+list[i].hmpgpblict_prcsdtm+"</dd>";//보고일시
            content += "</dl>";
            content += "</li>";
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
    
</script>