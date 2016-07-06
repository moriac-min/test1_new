<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="m" uri="/WEB-INF/tlds/message.tld"%>
<%@ page import="foodportal.common.util.Message"%>

<c:set var="contextPath" scope="request">${pageContext.request.contextPath}</c:set>
<link type="text/css" href="${contextPath}/css/style_minwon.css" rel="stylesheet">

<form id="popupForm" name="popupForm">
<input type="hidden" id="start_idx" name="start_idx">                <!-- start_idx -->
<input type="hidden" id="show_cnt" name="show_cnt" value="10">                <!-- show_cnt -->

    <div class="inner-head">
        <h1>기관찾기</h1>
    </div>
    <div class="inner-body">
        <div id="origin">
            <div class="emphasis">
                <p style="margin:0;">검색할 담당기관의 이름을 2자 이상 입력하십시오.<br>
                    예)서울, 강원, 위생, 보건 등</p>
            </div>
            <fieldset>
                <legend>기관검색</legend>
                <dl class="item">
                    <dt><label for="search_keyword">기관명</label></dt>
                    <dd><input type="text" name="search_keyword" id="search_keyword" value="" size="30" onkeyup="if(event.keyCode==13){javascript:searchList(); }"></dd>
                    <dd> <a href="javascript:searchList();" class="btn btn-default">검색</a></dd>
                </dl>
            </fieldset>
            <div class="list-container">
                <ul class="origin-list" id="listFrame">
                    <!-- 
                    <li><a href="#" onclick="send('대한민국', 'KR')">16 대한민국</a></li>
                    <li><a href="#" onclick="send('도미니카 공화국', 'DO')">15 도미니카 공화국</a></li>
                    <li><a href="#" onclick="send('마이너아우틀링합중국군도', 'UM')">14 마이너아우틀링합중국군도</a></li>
                    <li><a href="#" onclick="send('미국', 'US')">13 미국</a></li>
                    <li><a href="#" onclick="send('미국령 버진군도', 'VI')">12 미국령 버진군도</a></li>
                    <li><a href="#" onclick="send('영국', 'GB')">11 영국</a></li>
                    <li><a href="#" onclick="send('영국령 인도양', 'IO')">10 영국령 인도양</a></li>
                    <li><a href="#" onclick="send('영국령 캐이맨 군도', 'KY')">9 영국령 캐이맨 군도</a></li>
                    <li><a href="#" onclick="send('영국령버진군도', 'VG')">8 영국령버진군도</a></li>
                    <li><a href="#" onclick="send('중국', 'CN')">7 중국</a></li>
                     -->
                </ul>
                <div class="board-footer">
                    <div class="pagination"></div>
                </div>
            </div>
        </div>
    </div>
</form>

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
        
        $('#start_idx').val("1");
                
    }); 
    
    /****************************************
     * Button Action
     ****************************************/
    //페이징 변수셋팅
    function setPaginationVars(){
         //total_cnt_onPage = total_cnt;
         show_cnt_onPage = $('#show_cnt').val();
         
         $('.pagination').pagination("updateItems", total_cnt_onPage);
         $('.pagination').pagination("updateItemsOnPage", show_cnt_onPage);
         //$('.pagination').pagination('redraw');
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
    	   
    	   if($('#search_keyword').val() == null || $('#search_keyword').val() == ''){
    		  alert('${m:getMessage("msg.common.valid.searchWord") }') ;
    		  $('#search_keyword').focus();
    		  return false;
    	   }
    	   
    	   var lengthCheck = $('#search_keyword').val().length;
    	   
    	   if(lengthCheck < 2){
    		   alert('${m:getMessageIn("msg.common.valid.searchWordNo", "2") }') ;
               $('#search_keyword').focus();
               return false;
    	   }
    	   
           //특수문자제거
           fn_replaceSpecialChar('#search_keyword');
           
           $.ajax({ 
               data: $('#popupForm').serialize(),
               dataType:'json', 
               type:'POST',
               url:"${contextPath}/popup/commonPopup/searchOrgn.do", 
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
        
        for(var i=0; i<listLangth; i++){
	        /* 
            content += "<ul>";
            content += "  <li class='issue-info-2' ondblclick=\"javascript:setSelectedVal('"+list[i].instt_cd+"','"+list[i].instt_nm+"'); return false;\">";
            content += "    <dl>";
            content += "    <dt>"+list[i].no+"</dt>";
            content += "    <dd>"+list[i].instt_nm+"</dd>";
            content += "    </dl>";
            content += "  </li>";
            content += "</ul>";
             */
        	content += "<li><a href='#' onclick=\"javascript:setSelectedVal('"+list[i].instt_cd+"','"+list[i].instt_nm+"'); return false;\">"+list[i].no+" "+list[i].instt_nm+"</a></li>";
        }
        
        $('#listFrame').html(content);
    }
    
    function setSelectedVal(value, name){
    	parent.fn_callbackOrgn(value, name);
    }
</script>
