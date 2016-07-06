<%@page language="java" contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<c:set var="contextPath" scope="request">${pageContext.request.contextPath}</c:set>

<input type="hidden" id="start_idx" name="start_idx">                <!-- start_idx -->
<input type="hidden" id="svc_no" name="svc_no">             <!-- svc_no 서비스번호 --> 
<input type="hidden" id="svc_type_cd" name="svc_type_cd" value="${svc_type_cd}">    <!-- svc_type_cd 서비스타입 -->
<input type="hidden" id="cl_cd" name="cl_cd" value="${cl_cd}">    <!-- cl_cd 분류타입 -->
<input type="hidden" id="provd_instt" name="provd_instt" value="${provd_instt}">    <!-- svc_type_cd 서비스타입 -->

<section>
    <div id="header">
        <div class="board-head">
            <ol class="breadcrumb">
                <li id="menuTree"></li>
            </ol>
            <h1>서비스유형</h1>
        </div>
    </div>
    <div class="page-container"> 
        <!-- 페이지 내용 -->
        <article>
            <div class="list-container">
                <div class="search-form">
                    <fieldset>
                        <legend>검색</legend>
                        <ul>
                            <li>
                                <div class="select-container w160">
                                    <label for="search_svcTypeCode">서비스유형</label>
                                    <select id="search_svcTypeCode" name="search_svcTypeCode" class="selecter_basic">   
                                        <option value="">선택</option>
                                    <c:if test="${fn:length(svcTypeCodeList) > 0}">
                                        <c:forEach var="svcTypeCodeList" items="${svcTypeCodeList}">
                                            <option value="${svcTypeCodeList.cmmn_cd}">${svcTypeCodeList.cd_nm}</option>
                                        </c:forEach>
                                    </c:if>
                                    </select>
                                </div>
                            </li>
                            <li>
                                <div class="select-container w160">
                                    <label for="search_clCdCode">서비스분류</label>
                                    <select id="search_clCdCode" name="search_clCdCode" class="selecter_basic">                         
                                        <option value="">선택</option>
                                        <c:if test="${fn:length(clCdCodeList) > 0}">
                                         <c:forEach var="clCdCodeList" items="${clCdCodeList}">
                                             <option value="${clCdCodeList.cmmn_cd}">${clCdCodeList.cd_nm}</option>
                                         </c:forEach>
                                     </c:if>
                                    </select>
                                </div> 
                            </li>
                            <li>
                                <div class="select-container w160">
                                    <label for="search_provdInsttCode">제공기관</label>
                                    <select id="search_provdInsttCode" name="search_provdInsttCode" class="selecter_basic">                         
                                        <option value="">선택</option>
                                        
                                        <c:if test="${fn:length(provdInsttCodeList) > 0}">
                                            <c:forEach var="provdInsttCodeList" items="${provdInsttCodeList}">
                                                <option value="${provdInsttCodeList.cmmn_cd}">${provdInsttCodeList.cd_nm}</option>
                                            </c:forEach>
                                        </c:if>
                                    </select>
                                </div>
                            </li> 
                            <li>
                                <label for="search_keyword">서비스명</label>
                                <input type="text" id="search_keyword" name="search_keyword" value="">
                            </li>
                            <li><a href="javascript:searchList();" class="btn btn-default" role="button">검색</a> </li>
                        </ul>
                    </fieldset>
                </div>
                <div class="total-container">
                    <span class="total">Total: <strong id="total_cnt">0</strong></span>
                    <div class="list-wrap">
                        <fieldset>
                        <legend>페이지당 게시글 수</legend>
                            <ul>
                                <li>
                                    <div class="select-container w80">
                                        <label for="show_cnt">목록게시글수</label>
                                        <select id="show_cnt" name="show_cnt" class="selecter_basic">                           
                                            <option value="10">10개씩</option>
                                            <option value="20">20개씩</option>
                                            <option value="30">30개씩</option>
                                            <option value="40">40개씩</option>
                                            <option value="50">50개씩</option>
                                        </select>
                                    </div>
                                </li>
                                <!-- <li><a href="javascript:searchList();" class="btn btn-default" role="button">보기</a></li> -->
                            </ul>
                        </fieldset>
                    </div>
                </div>
                <table>
                    <caption>
                    데이터셋 목록
                    </caption>
                    <colgroup>
                    <col width="8%">
                    <col width="15%">
                    <col width="*">
                    <col width="17%">
                    <col width="17%">
                    </colgroup>
                    <thead>
                        <tr>
                            <th scope="col">번호</th>
                            <th scope="col">분류</th>
                            <th scope="col">서비스명</th>
                            <th scope="col">제공기관</th>
                            <th scope="col">서비스유형</th>
                        </tr>
                    </thead>
                    <tbody id="listFrame">
                    <!-- 
                        <tr>
                            <td scope="row" class="num">5863</td>
                            <td>기준규격</td>
                            <td class="tl"><a href="#">식품위해정보</a></td>
                            <td>식품의약품안전처</td>
                            <td>
                                <a href="#" class="label label-primary">S</a>
                                <a href="#" class="label label-info">C</a>
                                <a href="#" class="label label-success">F</a>
                                <a href="#" class="label label-warning">L</a>
                                <a href="#" class="label label-danger">O</a>
                            </td>
                        </tr>
                         -->
                    </tbody>
                </table>
                <div class="board-footer">
                    <div class="pagination"></div>
                </div>
            </div>
        </article>
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
        
        if('${svc_type_cd}' != ''){
	        $("#search_svcTypeCode").val('${svc_type_cd}');
        }
        if('${cl_cd}' != ''){
            $("#search_clCdCode").val('${cl_cd}');
        }
        if('${provd_instt}' != ''){
            $("#search_provdInsttCode").val('${provd_instt}');
        }
        
        searchList();
    }); 
    
    /****************************************
     * Button Action
     ****************************************/
    
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
                url:"${contextPath}/api/searchDatasetList.do", 
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
            
            content += "<tr>";
            content += "  <td scope='row' class='num'>"+list[i].no+"</td>";
            content += "  <td>"+list[i].cl_cd_nm+"</td>";
            content += "  <td class='tl'><a href='#'>"+list[i].svc_nm+"</a></td>";
            content += "  <td>"+list[i].provd_instt_nm+"</td>";
            content += "  <td>";
            if(list[i].sheet_yn == "Y"){
	            content += "    <a onclick=\"javascript:fn_moveDetail('API_TYPE01', '"+list[i].svc_no+"');\" class='label label-primary'>S</a>";
            }
            if(list[i].chart_yn == "Y"){
                content += "    <a onclick=\"javascript:fn_moveDetail('API_TYPE02', '"+list[i].svc_no+"');\" class='label label-info'>C</a>";
            }
            if(list[i].file_yn == "Y"){
                content += "    <a onclick=\"javascript:fn_moveDetail('API_TYPE03', '"+list[i].svc_no+"');\" class='label label-success'>F</a>";
            }
//             if(list[i].map_yn == "Y"){
//                 content += "    <a onclick=\"javascript:fn_moveDetail('API_TYPE04', '"+list[i].svc_no+"');\" class='label label-default'>M</a>";
//             }
            if(list[i].link_yn == "Y"){
                content += "    <a onclick=\"javascript:fn_moveDetail('API_TYPE05', '"+list[i].svc_no+"');\" class='label label-warning'>L</a>";
            }
            if(list[i].openapi_yn == "Y"){
                content += "    <a onclick=\"javascript:fn_moveDetail('API_TYPE06', '"+list[i].svc_no+"');\" class='label label-danger'>O</a>";
            }
            content += "  <td>";
            content += "<tr>";
            
            
        }
        
        $('#listFrame').html(content);
    }
    
   //상세페이지    
   function fn_moveDetail(svc_type_cd, svc_no){
	   
	   $("#svc_no").val(svc_no);
	   $("#svc_type_cd").val(svc_type_cd);

	   if(svc_type_cd == "API_TYPE01"){
		   document.baseForm.action="${contextPath}/api/sheetInfo.do";
	   }else if(svc_type_cd == "API_TYPE02"){
		   alert('chart 페이지 미완성');
		   document.baseForm.action="${contextPath}/api/chartInfo.do";
	   }else if(svc_type_cd == "API_TYPE03"){
		   document.baseForm.action="${contextPath}/api/fileInfo.do";
// 	   }else if(svc_type_cd == "API_TYPE04"){
// 		   alert('map 페이지 준비중');
	   }else if(svc_type_cd == "API_TYPE05"){
		   document.baseForm.action="${contextPath}/api/linkInfo.do";
	   }else if(svc_type_cd == "API_TYPE06"){
		   document.baseForm.action="${contextPath}/api/openApiInfo.do";  
	   }
	   
	   document.baseForm.target="_self";
       document.baseForm.method="post";
       document.baseForm.submit();
       
   }
</script>