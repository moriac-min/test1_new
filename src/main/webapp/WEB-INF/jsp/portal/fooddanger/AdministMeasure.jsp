<%@ page language="java" contentType="text/html; charset=utf-8"
%><%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"
%><%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"
%><%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" 
%><%@ taglib prefix="m" uri="/WEB-INF/tlds/message.tld"
%><%@ page import="foodportal.common.util.Message"
%>

<c:set var="contextPath" scope="request">${pageContext.request.contextPath}</c:set>

<input type="hidden" id="start_idx" name="start_idx">                <!-- start_idx -->
<input type="hidden" id="dspsdtls_seq" name="dspsdtls_seq">                     <!-- 처분내역_일련번호 -->
<input type="hidden" id="dspsobj_viltmatr_seq" name="dspsobj_viltmatr_seq">     <!-- 처분대상_위반사항_일련번호 -->
<input type="hidden" id="admstdsps_examoff_seq" name="admstdsps_examoff_seq">   <!-- 행정처분_양형_일련번호 -->

<section>
    <div id="header">
        <div class="board-head">
            <div class="lnb-viewer" id="nav-open-btn" href="#left-nav">Menu</div>
            <ol class="breadcrumb">
                <li><a href="#">홈</a></li>
                <li><a href="#">식품위해정보</a></li>
                <li class="active">행정처분</li>
            </ol>
            <h1>행정처분</h1>            
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
                        <label for="keycode">검색구분</label>
                        <select id="search_type" name="search_type" class="selecter_basic">                         
                            <option value="">전체</option>
                            <option value="01">업체명</option>
                            <option value="02">대표자명</option>
                            <option value="03">처분명</option>
                        </select>
                        <input type="text" id="search_keyword" name="search_keyword" value="" onkeyup="if(event.keyCode==13){javascript:searchList(); }">
                        <a href="javascript:searchList();" class="btn btn-default" role="button">검색</a> 
                        <label for="pageview">목록게시글수</label>
                        <select id="show_cnt" name="show_cnt" class="selecter_basic">                           
                            <option value="10">10개씩</option>
                            <option value="20">20개씩</option>
                            <option value="30">30개씩</option>
                            <option value="40">40개씩</option>
                            <option value="50">50개씩</option>
                        </select>
                        <!-- <a href="/" class="btn btn-default" role="button">보기</a> -->
                    </fieldset>
            </div>
        </div>
        <div class="gallery col-2" id="listFrame">
        <!-- 
            <ul>
                <a class="country_of_origin_labeling fancybox.iframe" data-fancybox-group="iframe" href="country_of_origin_labeling_farm_products.html">
                <li class="company-name-kor"><span class="new"></span>주)세이브존 아이앤씨 대전점 </li>
                <li class="product-name">돼지고기</li>
                <li class="issue-info-2">
                    <dl>
                        <dt>위반내용</dt>
                        <dd>원산지가 수입산으로 표시되어 있는 돼지족발을 판매 하면서 업체내 POP 가격표시판에는 국내산으로 표시해 원산지를 혼동하게 할 우려가 있는 표시를 함.</dd>
                        <dt>처분명</dt>
                        <dd>표시삭제 및 변경</dd>
                    </dl>                            
                </li>
                <li class="issue-date">
                    <dl>
                        <dt>처분일</dt>
                        <dd>2014.03.07</dd>
                    </dl>                            
                </li>
                </a>
            </ul>
             -->
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
		
		$('#start_idx').val("1");
				
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
	        //특수문자제거
	        fn_replaceSpecialChar('#search_keyword');
	        
	        $.ajax({ 
	            data: $('#baseForm').serialize(),
	            dataType:'json', 
	            type:'POST',
	            url:"${contextPath}/portal/fooddanger/searchAdministMeasureList.do", 
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
        	
            content += "<ul>";
            content += "  <a class='openinfo fancybox.iframe' data-fancybox-group='iframe' onclick=\"javascript:fn_moveDetail('"+list[i].dspsdtls_seq+"','"+list[i].dspsobj_viltmatr_seq+"','"+list[i].admstdsps_examoff_seq+"');\">";
            if(list[i].new_yn == 'Y'){
                content += "  <li class='company-name-kor'><span class='new'></span>"+list[i].bssh_nm+"</li>";
            }else{
            	content += "  <li class='company-name-kor'>"+list[i].bssh_nm+"</li>";
            }
            
            content += "  <li class='product-name'>"+list[i].prdtnm+"</li>";
            content += "  <li class='issue-info-2'>";
            content += "      <dl>";
            content += "          <dt>위반내용</dt>";
            content += "          <dd>"+list[i].viltcn+"</dd>";
            content += "          <dt>처분명</dt>";
            content += "          <dd>"+list[i].dsps_stdrcd_nm+"</dd>";
            content += "      </dl>";                            
            content += "    </li>";
            content += "    <li class='issue-date'>";
            content += "       <dl>";
            content += "          <dt>처분일</dt>";
            content += "          <dd>"+list[i].dsps_bgndt+"</dd>";
            content += "      </dl>";                            
            content += "    </li>";
            content += "  </a>";
            content += "</ul>";
        }
        
        $('#listFrame').html(content);
    }
	 
	//상세페이지팝업    
    function fn_moveDetail(dspsdtls_seq, dspsobj_viltmatr_seq, admstdsps_examoff_seq){
    	
    	var action  = '${contextPath}/popup/administMeasureDetail.do?dspsdtls_seq='+dspsdtls_seq+"&dspsobj_viltmatr_seq="+dspsobj_viltmatr_seq+"&admstdsps_examoff_seq="+admstdsps_examoff_seq;
        
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