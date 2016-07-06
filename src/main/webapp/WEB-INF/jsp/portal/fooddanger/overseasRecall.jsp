<%@page language="java" contentType="text/html; charset=utf-8"
%><%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"
%><%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"
%><%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"
%>

<c:set var="contextPath" scope="request">${pageContext.request.contextPath}</c:set>
<input type="hidden" id="injry_esntl_no" name="injry_esntl_no">             <!-- 글번호 -->
<input type="hidden" id="start_idx" name="start_idx">                <!-- start_idx -->

    <section>
        <div id="header">
            <div class="board-head">
                <div class="lnb-viewer" id="nav-open-btn" href="#left-nav">Menu</div>
                <ol class="breadcrumb">
                    <li><a href="#">홈</a></li>
                    <li><a href="#">식품위해정보</a></li>
                    <li class="active">해외회수정보</li>
                </ol>
                <h1>해외회수정보</h1>
                <p class="excerpt">미국 FDA 등 해외 국가기관에서 회수 조치한 위해식품을 공개합니다.<br>
                    소비자는 인터넷 등에서 해당 제품을 구입하거나 이미 구입한 제품은 섭취하지 마시기 바랍니다.</p>
            </div>
        </div>
        <div class="list-container">
            <div class="search-container">
                <span class="total">Total: <strong id="total_cnt">0</strong> Articles</span>
                <div class="search-wrap">
<!--                 	<form id="searchForm" name="searchForm" action="#" method="GET"> -->
                        <fieldset>
                            <legend>검색</legend>
                            <label for="search_type">검색구분</label>
                            <select id="search_type" name="search_type" class="selecter_basic">                        	
                                <option value="">전체</option>
                                <option value="01">제목</option>
                                <option value="02">내용</option>
                                <option value="all">제목+내용</option>
                            </select>
                            <input type="text" id="search_keyword" name="search_keyword" value="">
                            <a href="javascript:searchList();" class="btn btn-default" role="button">검색</a> 
                            <label for="show_cnt">목록게시글수</label>
                            <select id="show_cnt" name="show_cnt" class="selecter_basic">                        	
                                <option value="10">10개씩</option>
                                <option value="20">20개씩</option>
                                <option value="30">30개씩</option>
                                <option value="40">40개씩</option>
                                <option value="50">50개씩</option>
                            </select>
<!--                             <a href="/" class="btn btn-default" role="button">보기</a> -->
                        </fieldset>
<!--                     </form> -->
                </div>
            </div>
            <table id="board">
                <caption>해외회수정보 테이블</caption>
                <colgroup>
                    <col style="width:60px;">
                    <col>
                    <col style="width:120px;">
                    <col style="width:90px;">
<%--                     <col style="width:60px;"> --%>
                </colgroup>
                <thead>
                    <tr>
                        <th scope="col">번호</th>
                        <th scope="col">제목</th>
                        <th scope="col">담당부서</th>
                        <th scope="col">등록일</th>
<!--                         <th scope="col">조회</th> -->
                    </tr>
                </thead>
                <tbody id="listFrame">
                	
                	 	<!-- <tr>
                             <td scope="row" class="num">1123</td>
                             <td class="subject n"><a href="recalls_overseas_view.html" class="ellipsis">미국 컨슈리포트(언론), 체중감량제품에서 처방약 성분 검출로 구매 경고</a></td>
                             <td>위해정보과</td>
                             <td class="num">2014.10.29</td>
                             <td class="num">3453</td>
                         </tr> -->
                	
                </tbody>
            </table>
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
            url:"${contextPath}/portal/fooddanger/searchOverseasRecallList.do", 
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
    
     for(var i=0; i<listLangth; i++){
     	var creDtm = list[i].occrnc_dtm;
     	creDtm = creDtm.replace(/-/gi,"");
     	creDtm = creDtm.substr(0,8);
     	
         content += "<tr>";
         content += "<td scope='row' class='num'>"+list[i].no+"</td>";
         content += "<td class='subject ";
         if( parseInt(creDtm) > parseInt(fn_getPlusMinusDate('',-4))){
         	content += "n";
         }
         content += "'><a href='${contextPath}/portal/fooddanger/overseasRecallDetail.do?search_keyword="+ list[i].injry_esntl_no +"' class='ellipsis'>"+list[i].titl+"</a></td>";
         content +=  "<td>"+list[i].abbr_nm+"</td>";
         content +=  "<td class='num'>"+list[i].cret_dtm+"</td>";
//          content +=  "<td class='num'>"+0+"</td>";
         content += "</tr>";
         
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
