
<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="m" uri="/WEB-INF/tlds/message.tld"%>
<%@ page import="foodportal.common.util.Message"%>

<c:set var="contextPath" scope="request">${pageContext.request.contextPath}</c:set>
      
<input type="hidden" id="bbs_no"		name="bbs_no" value="${boardSetting.bbs_no}">                   <!-- 게시판번호 -->
<input type="hidden" id="ntctxt_no"		name="ntctxt_no">                                               <!-- 글번호 -->
<input type="hidden" id="ctgry_no"		name="ctgry_no" value="${boardSetting.ctgry_no}">                <!-- 카테고리번호 -->
<input type="hidden" id="hrnk_ctgryno"	name="hrnk_ctgryno" value="${boardSetting.hrnk_ctgryno}">    	<!-- 상위카테고리번호 -->
<input type="hidden" id="keywrd"        name="keywrd">       <!-- 키워드 -->
<input type="hidden" id="start_idx"     name="start_idx" value="${boardSetting.start_idx}">                <!-- start_idx -->
<input type="hidden" id="nticmatr_yn"   name="nticmatr_yn" value="${boardSetting.nticmatr_yn}">            <!-- 공지사항 여부 -->
<input type="hidden" id="bbs_type_cd"   name="bbs_type_cd" value="${boardSetting.bbs_type_cd}">         <!-- 게시판타입코드 -->
<script>
if('${boardSetting.bbs_type_cd}' == '04'){
	document.baseForm.action="${contextPath}/portal/board/boardDetail.do";
    document.baseForm.target="_self";
    document.baseForm.method="post";
    document.baseForm.submit();
}
</script>
	<section>
      <div id="header">
          <div class="board-head">
              <div class="lnb-viewer" id="nav-open-btn" href="#left-nav">Menu</div>
              <ol class="breadcrumb">
              	  <li>aaaaaaa</li>
              </ol>
              <h1>${boardSetting.menu_nm}</h1>
              <!-- 
              <p class="excerpt">국내에서 이미 유통된 식품 중 기준.규격에 부적합해 회수 및 판매중지된 제품을 공개합니다.<br>
                  소비자는 해당제품을 구입장소에 되돌려주시고 판매자는 해당식품 판매를 중지하시고 회수업체에 반품하시기 바랍니다.</p>
               -->    
          </div>
      </div>
      <c:if test="${boardSetting.bbs_type_cd == '02'}">
                    <div class="highlight-wrapper theme-highlight">
                    <div id="highlight" class="nivoSlider"> <img src="../../../img/c1.png" alt="미국, 소매점 계산대 주변에 사탕류 제품 비치 반대" title="#caption-0"> <img src="../../../img/c2.png" alt="미국, 소매점 계산대 주변에 사탕류 제품 비치 반대" title="#caption-1"> <img src="../../../img/c3.png" alt="미국, 소매점 계산대 주변에 사탕류 제품 비치 반대" title="#caption-2"></div>
                    <div id="caption-0" class="nivo-html-caption"><span class="flag us">미국</span> <a href="#" class="subject">미국, 소매점 계산대 주변에 사탕류 제품 비치 반대</a> <span class="origin">Reuters(US)</span><p class="excerpt">나트륨의 과다 섭취는 고혈압, 뇌졸증, 심장질환 등의 주요 원인이 되며, 기타 질환(신장질환, 골다공증 등)의 발생 위험도 높이는 것으로 알려져 있습니다. 또한, 개인의 입맛은 쉽게 변화 되기 힘들고 장시간의 적응 기간이 필요합니다. </p> <span class="date">2014.10.28</span> </div>
                    <div id="caption-1" class="nivo-html-caption"> <span class="flag us">미국</span><a href="#" class="subject">2미국, 소매점 계산대 주변에 사탕류 제품 비치 반대 사탕류 제품 비치 반대</a> <span class="origin">Reuters(US)</span><p class="excerpt">나트륨의 과다 섭취는 고혈압, 뇌졸증, 심장질환 등의 주요 원인이 되며, 기타 질환(신장질환, 골다공증 등)의 발생 위험도 높이는 것으로 알려져 있습니다.</p><span class="date">2014.10.28</span> </div>
                    <div id="caption-2" class="nivo-html-caption"> <span class="flag us">미국</span><a href="#" class="subject">3미국, 소매점 계산대 주변에 사탕류 제품 비치 반대 사탕류 제품 비치 반대</a> <span class="origin">Reuters(US)</span><p class="excerpt">나트륨의 과다 섭취는 고혈압, 뇌졸증, 심장질환 등의 주요 원인이 되며, 기타 질환(신장질환, 골다공증 등)의 발생 위험도 높이는 것으로 알려져 있습니다. </p><span class="date">2014.10.28</span> </div>
                </div>
      </c:if>
      <div class="list-container">
      	  <c:if test="${boardSetting.bbs_type_cd == '02' || boardSetting.bbs_type_cd == '03'}">
      	  <ul id="tabs" class="tab-container tab-5" role="tablist">
              <li><a href="#tab1" class="tab latest" role="tab" data-toggle="tab">최신게시글</a></li>
              <li><a href="#tab2" class="tab populars" role="tab" data-toggle="tab">인기게시글</a></li>
              <li><a href="#tab3" class="tab recommend" role="tab" data-toggle="tab">추천게시글</a></li>
              <li><a href="#tab4" class="tab videos" role="tab" data-toggle="tab">동영상</a></li>
              <li><a href="#tab5" class="tab infographics" role="tab" data-toggle="tab">인포그래픽</a></li>
          </ul>
          </c:if>
          
          <!-- Tab panes -->
          <div class="tab-content">
          	<!-- tab1 -->
          	<!-- <div class="tab-pane" id="tab1"> -->
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
            	<c:if test="${boardSetting.ctgry_type_cd == 'CTG_TYPE01' || boardSetting.ctgry_type_cd == 'CTG_TYPE02'}">
                  <div class="cat-container">
                      <ul class="category">
                          <!-- 일반형 카테고리 -->
                      
                        <c:forEach var="ctgType01List" items="${ctgType01List}" varStatus="ctgType01Status">
                           <li><a id="div_ctgType01_${ctgType01Status.index}" href="javascript:showHCategory('${ctgType01Status.index}','','${boardSetting.ctgry_type_cd}','${ctgType01List.ctgry_no}','')">${ctgType01List.ctgrynm}</a></li>
                        </c:forEach>
                      </ul>     
                     
                      <!-- 계층형 하위 카테고리 -->
                      <c:if test="${boardSetting.ctgry_type_cd == 'CTG_TYPE02'}">
                        <ul class="keyword">
                          <c:forEach var="ctgType02List" items="${ctgType02List}" varStatus="ctgType02Status">
                              <div class="div_ctgType02" id="div_depth2${ctgType02Status.index}" style="display:none";>
	                              <c:forEach var="i" items="${ctgType02List}" varStatus="status">                             
	                                 <li><a id="a_ctgType02_${ctgType02Status.index}${status.index}" href="javascript:showHCategory('${ctgType02Status.index}','${ctgType02Status.index}${status.index}','${boardSetting.ctgry_type_cd}','${i.ctgry_no}','${i.hrnk_ctgryno}')">${i.ctgrynm}</a></li>
                                  </c:forEach>
                              </div>
                          </c:forEach>
                        </ul>
                      </c:if>
                      
                      <!-- 키워드 목록 -->
                      <c:if test="${boardSetting.kword_use_yn == 'Y'}">
                        <ul class="keyword">
                            <c:forEach var="keywordList" items="${keywordList}" varStatus="keywordListStatus">
                                <li><a id="a_keyword${keywordListStatus.index}" href="javascript:setKeywordSearch('${keywordListStatus.index}','${keywordList.meta_type_cd}')">${keywordList.cd_nm}</a></li>
                            </c:forEach>
                        </ul>
                      </c:if>
                  </div>
                </c:if>
                  
                  <jsp:include page="${boardSetting.bbs_templet_nm}"/>
                  
                  <div class="board-footer">
                       
                       <div class="pagination"></div>
                      
                   </div>
          </div>
      </div>
  </section>
<!-- </form> -->
  
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
		<%-- alert('<%=Message.getMessage("msg.common.valid.required", "하하하")%>'); 
		if(fn_empty('#search_keyword','${m:getMessageIn("msg.common.valid.required", "성명") }') == false){  
	        return; 
	    }
		--%>
			
		if('${boardSetting.search_type}' != ""){
	   		$('#search_type').val('${boardSetting.search_type}');
	    }
		if('${boardSetting.search_keyword}' != ""){
	        $('#search_keyword').val('${boardSetting.search_keyword}');
	    }
		if('${boardSetting.show_cnt}' != ""){
	        $('#show_cnt').val('${boardSetting.show_cnt}');
	    }
		
		//계층형이고 첫 진입화면이 아니라 조회로 인한 refresh 화면일 경우 하위카테고리를 숨기지 않는다.
		if('${boardSetting.ctgry_type_cd}' == 'CTG_TYPE02'){
			if('${boardSetting.ctgry_no}' != null && '${boardSetting.ctgry_no}' != '' ){
				
			}
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
		
		if(ctgType == 'CTG_TYPE01'){
			setCategorySearch(ctgryno,hrnk_ctgryno);
			return;
		}else{
			for(var i=0; i<${fn:length(ctgType01List)}; i++){
				$("#div_depth2"+i).hide();
	        }
			$("#div_depth2"+idx_1).show();
			$("#a_ctgType02_"+idx_2).addClass("active");
			if(idx_2 != ''){
				$('#keywrd').val('');
				setCategorySearch(ctgryno,hrnk_ctgryno);	
			}
		}
	}
	 
	//카테고리클릭 -> 조회
	function setCategorySearch(ctgryno, hrnk_ctgryno){
		$('#ctgry_no').val(ctgryno);
		$('#hrnk_ctgryno').val(hrnk_ctgryno);
		searchList();
	}
	
	//키워드 클릭 -> 조회
	function setKeywordSearch(idx, keyword){
		for(var i=0; i<${fn:length(keywordList)}; i++){
			$("#a_keyword"+i).removeClass();
        }
		$("#a_keyword"+idx).addClass("active");
		$('#keywrd').val(keyword);
		searchList();
	}
	
	function resetValue(){
		$(".active").removeClass();
		$('#ctgry_no').val('');
		$('#hrnk_ctgryno').val('');
		$('#keywrd').val('');
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
	
	//상세페이지이동
	function viewDetail(ntctxt_no){
		
		$('#ntctxt_no').val(ntctxt_no);
		
		document.baseForm.action="${contextPath}/portal/board/boardDetail.do";
        document.baseForm.target="_self";
        document.baseForm.method="post";
        document.baseForm.submit();
	}
	
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
	 
	 $(window).load(function(){
			$("#left-nav.left-nav").mCustomScrollbar({
				theme:"minimal-dark"
			});
		});
	 
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