<%@page language="java" contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<c:set var="contextPath" scope="request">${pageContext.request.contextPath}</c:set>

<input type="hidden" id="start_idx" name="start_idx">                               <!-- start_idx -->
<input type="hidden" id="svc_no" name="svc_no" value="${svc_no}">                   <!-- svc_no 서비스번호 -->
<input type="hidden" id="svc_type_cd" name="svc_type_cd" value="${svc_type_cd}">    <!-- svc_type_cd 서비스타입 --> 

<section>
    <div id="header">
        <div class="board-head">
            <ol class="breadcrumb">
                <li id="menuTree"></li>
            </ol>
            <h1>SHEET</h1>
        </div>
    </div>
    <div class="page-container"> 
        <!-- 페이지 내용 -->
        <article>
            <div class="list-container">
                <div class="cat-container">
                    <ul class="dataset">
                        <c:if test="${datasetVO.sheet_yn == 'Y'}">
                            <li><a href="javascript:fn_moveTypePage('API_TYPE01'); " class="btn btn-primary">SHEET</a></li>
                        </c:if>
                        <c:if test="${datasetVO.chart_yn == 'Y'}">
                            <li><a href="javascript:fn_moveTypePage('API_TYPE02'); " class="btn btn-default">CHART</a></li>
                        </c:if>    
                        <c:if test="${datasetVO.file_yn == 'Y'}">
                            <li><a href="javascript:fn_moveTypePage('API_TYPE03'); " class="btn btn-default">FILE</a></li>
                        </c:if>    
                        <!-- <li><a href="javascript:fn_moveTypePage('API_TYPE04'); " class="btn btn-default">MAP</a></li> -->
                        <c:if test="${datasetVO.link_yn == 'Y'}">
                            <li><a href="javascript:fn_moveTypePage('API_TYPE05'); " class="btn btn-default">LINK</a></li>
                        </c:if>
                        <c:if test="${datasetVO.openapi_yn == 'Y'}">    
                            <li><a href="javascript:fn_moveTypePage('API_TYPE06'); " class="btn btn-default">Open API</a></li>
                        </c:if>  
                        <!-- Active 상태 class 적용
                        <li><a href="#" class="btn btn-primary">SHEET</a></li>
                        <li><a href="#" class="btn btn-success">CHART</a></li>
                        <li><a href="#" class="btn btn-info">FILE</a></li>
                        <li><a href="#" class="btn btn-warning">LINK</a></li>
                        <li><a href="#" class="btn btn-danger">Open API</a></li>
                        -->
                        <!-- <li class="fr"><a href="#" class="btn btn-default">Excel Download</a></li> -->
                    </ul>   
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
                <table class="dataset">
                    <caption>
                    SHEET 목록
                    </caption>
                    <colgroup>
                    <col width="">
                    <col width="">
                    <col width="">
                    <col width="">
                    <col width="">
                    <col width="">
                    </colgroup>
                        <thead id="headFrame">
                           <!-- 
                            <tr>
                                <th scope="col">업체명</th>
                                <th scope="col">업체소재지</th>
                                <th scope="col">제품명</th>
                                <th scope="col">업종명</th>
                                <th scope="col">처분명</th>
                                <th scope="col">처분일</th>
                            </tr>
                             -->
                        </thead>
                        <tbody id="bodyFrame">
                           <!-- 
                            <tr>
                                <td scope="row">업체1</td>
                                <td>서울</td>
                                <td>제품명1</td>
                                <td>요식업</td>
                                <td>유통기한경과제품판매</td>
                                <td>2014.10.10</td>
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
    var svc_no = "";
    /****************************************
     * Init
    ****************************************/
    
    $(document).ready(function(){
        
        $('#start_idx').val("1");
        
        svc_no = '${svc_no}';
        
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
        
            $.ajax({ 
                data: $('#baseForm').serialize(),
                dataType:'json', 
                type:'POST',
                url:"${contextPath}/api/searchSheetInfo.do", 
                success:function(arg){
                    
                    //total 개수
                    total_cnt_onPage = arg.dataListTotalCnt;
                    $('#total_cnt').text(total_cnt_onPage);
                    
                    //페이징 셋팅
                    setPaginationVars();
                    
                    //header
                    var dataItemList = new Array();
                    dataItemList = arg.dataItemList;
                    
                    fn_drawHeadList(dataItemList);
                    
                    //body
                    var dataList = new Array();
                    dataList = arg.dataList;
                    var maxCol = arg.maxCol;
                    fn_drawBodyList(dataList, maxCol);
                },
                error:function(request,status,error){
                    alert("실패코드 : " + request.status+"\n메세지 : " + request.error);
                }
            });
        }
     
     //header 그리기
     function fn_drawHeadList(list){
     
        var content = "";
        
        content += "<tr>";
        
        for(var i=0; i<list.length; i++){
            content += "  <th scope='col'>"+list[i].itm_desc+"</th>";
        }
        
        content += "<tr>";
        
        $('#headFrame').html(content);
    }
    
    //body 그리기
    function fn_drawBodyList(dataList, maxCol){
     
        var content = "";
         
        var colId = "";
        for(var i=0; i<dataList.length; i++){
            content += "<tr>";
            
            for(var j=0; j<maxCol; j++){
                colId = "col_"+j;
                if(j == 0){
                    content += "  <td scope='row'>"+dataList[i][colId]+"</td>";
                }else{
                    content += "  <td>"+dataList[i][colId]+"</td>";
                }
            }
            
            content += "<tr>";
        }
        
        
        $('#bodyFrame').html(content);
    }
   
   function fn_moveTypePage(svc_type_cd){
	   
	   $("#svc_type_cd").val(svc_type_cd);
	   
	   if(svc_type_cd == "API_TYPE01"){        //sheet
		   document.baseForm.action="${contextPath}/api/sheetInfo.do";
	   }else if(svc_type_cd == "API_TYPE02"){  //chart
		   alert('chart 페이지 미완성');
           document.baseForm.action="${contextPath}/api/chartInfo.do";
	   }else if(svc_type_cd == "API_TYPE03"){  //file
		   document.baseForm.action="${contextPath}/api/fileInfo.do";
// 	   }else if(svc_type_cd == "API_TYPE04"){  //map
// 		   alert('준비중');
// 		   return;
	   }else if(svc_type_cd == "API_TYPE05"){  //link
		   document.baseForm.action="${contextPath}/api/linkInfo.do";
	   }else if(svc_type_cd == "API_TYPE06"){  //open api
		   document.baseForm.action="${contextPath}/api/openApiInfo.do";
	   }
	   
	   document.baseForm.target="_self";
       document.baseForm.method="post";
       document.baseForm.submit();
       
   }
</script>