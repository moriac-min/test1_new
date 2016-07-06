<%@page language="java" contentType="text/html; charset=utf-8"
%><%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"
%><%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"
%><%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"
%>
<c:set var="contextPath" scope="request">${pageContext.request.contextPath}</c:set>

<input type="hidden" id="start_idx" name="start_idx">                <!-- start_idx -->
<input type="hidden" id="hrnk_cd" name="hrnk_cd" value="${hrnk_cd }">                <!-- hrnk_cd -->
<input type="hidden" id="cmmn_cd" name="cmmn_cd" value="${cmmn_cd }">                <!-- cmmn_cd -->
<input type="hidden" id="rcp_menu_no" name="rcp_menu_no" value="">                <!-- rcp_menu_no -->
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
             <h1>${titleMap.recipeVO.title_sec } 
             
             <c:if test="${cmmn_cd == 'RC_THEM01' }">
			 	<a class="greenmenu fancybox.iframe btn btn-danger btn-sm" href="/popup/aboutPopup.do?type=greenMenu">녹색메뉴개발원칙은?</a>
             </c:if>
             <c:if test="${cmmn_cd == 'RC_THEM02' }">
				 <a class="kidsmenu fancybox.iframe btn btn-danger btn-sm" href="/popup/aboutPopup.do?type=kidsMenu">어린이건강메뉴란?</a>
			 </c:if> 
             <c:if test="${cmmn_cd == 'RC_THEM03' }">
				 <a class="lowna fancybox.iframe btn btn-danger btn-sm" href="/popup/aboutPopup.do?type=lowna">어린이저염메뉴란?</a>
			 </c:if> 
             
             </h1>
         </div>
     </div>
     <c:if test="${cmmn_cd == 'RC_THEM02' or cmmn_cd == 'RC_THEM03'}">
     <input type="hidden" id="search_cate" name="search_cate" >
     <input type="hidden" id="search_life" name="search_life" >
     <div class="list-container recipe">
     	<c:if test="${cmmn_cd == 'RC_THEM02' }">
		<ul id="tabs" class="tab-container tab-3">
			<li class="active" id="life_1"><a href="javascript:fn_subMenu('life','RC_LIFE01');" class="tab">유아</a></li>
			<li id="life_2"><a href="javascript:fn_subMenu('life','RC_LIFE02');" class="tab">학동기</a></li>
			<li id="life_3"><a href="javascript:fn_subMenu('life','RC_LIFE03');" class="tab">창소년</a></li>
		</ul>
		</c:if>
		<div class="cat-container">
			<ul class="category">
				<li><a id="cate_a" class="active" href="javascript:fn_subMenu('cate','all');">전체</a></li>
				<li><a id="cate_1" href="javascript:fn_subMenu('cate','RC_CATE01');">주식</a></li>
				<li><a id="cate_2" href="javascript:fn_subMenu('cate','RC_CATE02');">부식</a></li>
				<li><a id="cate_3" href="javascript:fn_subMenu('cate','RC_CATE03');">후식</a></li>
				<li><a id="cate_4" href="javascript:fn_subMenu('cate','RC_CATE04');">간식</a></li>
			</ul>
		</div>
	 </div>
	 </c:if>
	 
	 <c:if test="${hrnk_cd == 'RC_MATE' }">
	 <div class="bs-callout bs-callout-danger">
	 	<p>
	 		<c:if test="${cmmn_cd == 'RC_MATE01' }">
		 	<img src="../../../img/sample-190x133.png" width="190" alt="곡류">
		 	곡류의 특징!<br>
			곡류는 담백한 맛과 탄수화물이 풍부하고 소화흡수도 잘 되어 혈당을 공급하고 필요한 에너지를 냅니다.
	 		</c:if>
	 		<c:if test="${cmmn_cd == 'RC_MATE02' }">
		 	<img src="../../../img/sample-190x133.png" width="190" alt="곡류">
		 	육류의 특징!<br>
			육류는 단백질이 풍부하고 무기질과 비타민이 많아 혈액단백질을 공급하고 몸의 근육 등을 만듭니다.
	 		</c:if>
	 		<c:if test="${cmmn_cd == 'RC_MATE03' }">
		 	<img src="../../../img/sample-190x133.png" width="190" alt="곡류">
		 	채소및버섯류의 특징!<br>
			채소 및 버섯류는 독특한 색깔과 맛이 있고 비타민과 무기질이 풍부하며 식이섬유도 많아서 몸의 기능을 조절하여 건강하게 합니다. 
	 		</c:if>
	 		<c:if test="${cmmn_cd == 'RC_MATE04' }">
		 	<img src="../../../img/sample-190x133.png" width="190" alt="곡류">
		 	두류및유제품의 특징!<br>
			채소 및 버섯류는 독특한 색깔과 맛이 있고 비타민과 무기질이 풍부하며 식이섬유도 많아서 몸의 기능을 조절하여 건강하게 합니다. 
	 		</c:if>
	 		<c:if test="${cmmn_cd == 'RC_MATE05' }">
		 	<img src="../../../img/sample-190x133.png" width="190" alt="곡류">
		 	해산물의 특징!<br>
			생선 및 어패류는 소화되기 쉬운 단백질과 무기질과 비타민이 많아 혈액 단백질을 공급하고 몸의 근육 등을 만듭니다.
	 		</c:if>
	 		<c:if test="${cmmn_cd == 'RC_MATE06' }">
		 	<img src="../../../img/sample-190x133.png" width="190" alt="곡류">
		 	과일류의 특징!<br>
			과일류는 예쁜 색깔, 향기와 단맛이 풍부하고 비타민 C 등과 섬유소가 많아 몸의 기능을 조절하여 건강하게 합니다.
	 		</c:if>
		</p>
	 </div>
	 </c:if>
	 
     <div class="highlight-wrapper col-3" id="topListFrame" style="border: 0px solid #fff; height: 100%; margin: 0px 0 0px; width: 100%;">
     </div>
     <div class="list-container">
         <div class="search-container">
             <span class="total">Total: <strong id="total_cnt">0</strong> Articles</span>
             <div class="search-wrap">
	              <fieldset>
	                  <legend>검색</legend>
	                  <c:if test="${cmmn_cd != 'RC_THEM02' and cmmn_cd != 'RC_THEM03'}">
	                  <label for="keycode">검색구분</label>
	                  <select id="search_cate" name="search_cate" class="selecter_basic">                        	
	                      <option value="all">전체</option>
	                      <option value="RC_CATE01">주식</option>
	                      <option value="RC_CATE02">부식</option>
	                      <option value="RC_CATE03">후식</option>
	                      <option value="RC_CATE04">간식</option>
	                  </select>
	                  </c:if>
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
		
		$(".greenmenu,.greendiet,.kidsmenu,.lowna").fancybox({
			maxWidth	: 655,
			maxHeight	: 770,
			minHeight	: 770,
			fitToView	: false,
			width		: '70%',
			height		: '80%',
			autoSize	: false,
			closeClick	: false,
			openEffect	: 'fade',
			closeEffect	: 'fade',
			tpl: {next : '', prev : ''}
		});
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
	            content += "	<a href=\"/portal/sensuousmenu/sensuousmenuView.do?rcp_menu_no="+list[i].rcp_menu_no+"&hrnk_cd=${hrnk_cd }&cmmn_cd=${cmmn_cd }\">";
	            content += "		<li class=\"img-222x222\" style=\"background-image:url("+list[i].rcp_menu_list_atch_file_nm+");\"></li>";
	            content += "		<li class=\"title\">"+list[i].rcp_menu_nm+"</li>";
	            content += "	</a>";
	            content += "	<li class=\"date\">"+list[i].last_updt_dtm+"</li>";
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
        	content += "	<a href=\"javascript:fn_goDetail('"+list[i].rcp_menu_no+"')\">";
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
	
	function fn_goDetail(rcp_menu_no){
		$('#rcp_menu_no').val(rcp_menu_no);
		document.baseForm.action="${contextPath}/portal/sensuousmenu/sensuousmenuView.do";
        document.baseForm.target="_self";
        document.baseForm.method="post";
        document.baseForm.submit();
	}
	
	function fn_subMenu(gubun, cd){
		
		if(gubun == "life"){
			$("#search_life").val(cd);
			$("#life_1").removeClass("active");
			$("#life_2").removeClass("active");
			$("#life_3").removeClass("active");
			if(cd == "RC_LIFE01"){
				$("#life_1").addClass("active");
			}else if(cd == "RC_LIFE02"){
				$("#life_2").addClass("active");
			}else if(cd == "RC_LIFE03"){
				$("#life_3").addClass("active");
			}
		}
		else if(gubun == "cate"){
			$("#search_cate").val(cd);
			$("#cate_a").removeClass("active");
			$("#cate_1").removeClass("active");
			$("#cate_2").removeClass("active");
			$("#cate_3").removeClass("active");
			$("#cate_4").removeClass("active");
			if(cd == "all"){
				$("#cate_a").addClass("active");
			}else if(cd == "RC_CATE01"){
				$("#cate_1").addClass("active");
			}else if(cd == "RC_CATE02"){
				$("#cate_2").addClass("active");
			}else if(cd == "RC_CATE03"){
				$("#cate_3").addClass("active");
			}else if(cd == "RC_CATE04"){
				$("#cate_4").addClass("active");
			}
		}
		searchList();
	}
    
</script>
