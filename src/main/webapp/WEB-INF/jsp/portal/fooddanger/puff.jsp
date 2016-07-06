<%@page language="java" contentType="text/html; charset=utf-8"
%><%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"
%><%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"
%><%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"
%><%@ taglib prefix="m" uri="/WEB-INF/tlds/message.tld"
%><%@ page import="foodportal.common.util.Message"
%>

<c:set var="contextPath" scope="request">${pageContext.request.contextPath}</c:set>
<input type="hidden" id="report_esntl_idntfc_no" name="report_esntl_idntfc_no">             <!-- 글번호 -->
<input type="hidden" id="start_idx" name="start_idx">             							<!-- start_idx -->

<section>
  <div id="header">
      <div class="board-head">
          <div class="lnb-viewer" id="nav-open-btn" href="#left-nav">Menu</div>
          <ol class="breadcrumb">
              <li><a href="#">홈</a></li>
              <li><a href="#">식품위해정보</a></li>
              <li class="active">허위 과대 광고</li>
          </ol>
          <h1>허위 과대 광고</h1>
          <p class="excerpt">건강기능식품제조업 중 행정처분을 받은 업체를 알려드립니다.<br>
              위반내용은 의약품 용도 원료의 사용, 과장된 표시, 허가사항 변경신고 미실시 등 입니다.</p>
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
                          <option value="01">제품</option>
                          <option value="02">업체</option>
                          <option value="03">제품+업체</option>
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
<!--                       <a href="/" class="btn btn-default" role="button">보기</a> -->
                  </fieldset>
          </div>
      </div>
      <div class="gallery col-2" id="listFrame">
<!--       반복 -->
<!--           <ul> -->
<!--               <a class="false_advertising fancybox.iframe" data-fancybox-group="iframe" href="administrative_measure.html"> -->
<!--               <li class="company-name-kor"><span class="new"></span>(주)더존피에이치씨</li> -->
<!--               <li class="product-name">건강기능식품전문제조업</li> -->
<!--               <li class="issue-info-2"> -->
<!--               	<dl> -->
<!--                   	<dt>위반내용</dt> -->
<!--                       <dd>건강기능식품에 관한 법률 제38조(다른 법률과의 관계), 식품위생법 제40조(건강진단) 위반 - 건강기능식품 제조 가공에 종사하는 종사자는 1년에 1회 이상 건강진단을 실시하여야 하나, 생산 공정 종사자 3명중 1명이 건강진단을 받지 않은 사실이 있음</dd> -->
<!--                   	<dt>처분명</dt> -->
<!--                       <dd>과태료부과</dd> -->
<!-- 				</dl>                             -->
<!--               </li> -->
<!--               <li class="issue-date"> -->
<!--               	<dl> -->
<!--                   	<dt>처분일</dt> -->
<!--                       <dd>2014.03.07</dd> -->
<!-- 				</dl>                             -->
<!--               </li> -->
<!--               </a> -->
<!--           </ul> -->
<!--       반복 -->  

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
	            url:"${contextPath}/portal/fooddanger/searchPuffList.do", 
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
        	var creDtm = list[i].admst_dsps_dt;
	     	creDtm = creDtm.replace(/-/gi,"");
	     	creDtm = creDtm.substr(0,8);
	     	
	     	content += "<ul>";
	     	content += "<a class='administrative_measure fancybox.iframe' data-fancybox-group='iframe' onclick=\"javascript:fn_moveDetail('"+list[i].report_esntl_idntfc_no+"');\">";
	     	content += "<li class='company-name-kor'>";
	     	if(parseInt(creDtm) > parseInt(fn_getPlusMinusDate('',-4))){
            	content +=  "<span class='new'></span>";
            }
	     	content += list[i].bssh_nm+"</li>";
	     	content += "<li class='product-name'>"+list[i].prdt_nm+"</li>";
	     	content += "<li class='issue-info-2'>";
	     	content += "      <dl>";
            content += "          <dt>위반내용</dt>";
            content += "          <dd>"+list[i].othbc_vilt_cn +"</dd>";
            content += "          <dt>처분명</dt>";
            content += "          <dd>"+list[i].dsps_stdr_cd_nm +"</dd>";
            content += "      </dl>";                            
            content += "    </li>";
            content += "    <li class='issue-date'>";
            content += "       <dl>";
            content += "          <dt>처분일</dt>";
            content += "          <dd>"+list[i].admst_dsps_dt+"</dd>";
            content += "      </dl>";                            
            content += "    </li>";
            content += "  </a>";
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
    
    function fn_moveDetail(report_no){
    	
    	var action  = '${contextPath}/popup/puffDetail.do?search_keyword='+report_no;
        
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