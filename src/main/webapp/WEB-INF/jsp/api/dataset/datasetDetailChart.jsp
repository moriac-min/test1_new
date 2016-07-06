<%@page language="java" contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<c:set var="contextPath" scope="request">${pageContext.request.contextPath}</c:set>

<input type="hidden" id="start_idx" name="start_idx">                               <!-- start_idx -->
<input type="hidden" id="svc_no" name="svc_no" value="${svc_no}">                   <!-- svc_no 서비스번호 -->
<input type="hidden" id="svc_type_cd" name="svc_type_cd" value="${svc_type_cd}">    <!-- svc_type_cd 서비스타입 --> 

<script type="text/javascript" src="${contextPath}/js/charts/FusionCharts.js"></script>
<%-- 
<script type="text/javascript" src="${contextPath}/js/charts/FusionCharts.HC.Charts.js"></script>
<script type="text/javascript" src="${contextPath}/js/charts/FusionCharts.HC.js"></script>
<script type="text/javascript" src="${contextPath}/js/charts/FusionCharts.jqueryplugin.js"></script>
<script type="text/javascript" src="${contextPath}/js/charts/FusionChartsExportComponent.js"></script>
 --%>
<section>
    <div id="header">
        <div class="board-head">
            <ol class="breadcrumb">
                <li id="menuTree"></li>
            </ol>
            <h1>CHART</h1>
        </div>
    </div>
    <div class="page-container"> 
        <!-- 페이지 내용 -->
        <article>
            <div class="list-container">
                <div class="cat-container">
                    <ul class="dataset">
                        <c:if test="${datasetVO.sheet_yn == 'Y'}">
                            <li><a href="javascript:fn_moveTypePage('API_TYPE01'); " class="btn btn-default">SHEET</a></li>
                        </c:if>
                        <c:if test="${datasetVO.chart_yn == 'Y'}">
                            <li><a href="javascript:fn_moveTypePage('API_TYPE02'); " class="btn btn-success">CHART</a></li>
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
                <div id="chartDiv">
                
                </div>
            </div>
        </article>
    </div>
</section>
<script type="text/javascript">

    /****************************************
     * Variable
    ****************************************/
    var svc_no = "";
    var strXML = "";
    /****************************************
     * Init
    ****************************************/
    //차트
    var pageChart = new FusionCharts("${contextPath}/js/charts/Column3D.swf", "testChart", "900", "650", "0", "1");
    
    $(document).ready(function(){
        
        svc_no = '${svc_no}';
        
        strXML = "${chart}";
        pageChart.setDataXML(strXML);
        pageChart.render("chartDiv");
        
    }); 
    
     
    /****************************************
     * Button Action
     ****************************************/
    
    /****************************************
     * Function
     ****************************************/
     function fn_moveTypePage(svc_type_cd){
         
         $("#svc_type_cd").val(svc_type_cd);
         
         if(svc_type_cd == "API_TYPE01"){        //sheet
             document.baseForm.action="${contextPath}/api/sheetInfo.do";
         }else if(svc_type_cd == "API_TYPE02"){  //chart
        	 alert('chart 페이지 미완성');
             document.baseForm.action="${contextPath}/api/chartInfo.do";
         }else if(svc_type_cd == "API_TYPE03"){  //file
        	 document.baseForm.action="${contextPath}/api/fileInfo.do";
//          }else if(svc_type_cd == "API_TYPE04"){  //map
//              alert('준비중');
//              return;
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