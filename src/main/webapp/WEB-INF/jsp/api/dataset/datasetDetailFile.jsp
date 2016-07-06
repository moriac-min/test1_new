<%@page language="java" contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<c:set var="contextPath" scope="request">${pageContext.request.contextPath}</c:set>

<input type="hidden" id="start_idx" name="start_idx">                               <!-- start_idx -->
<input type="hidden" id="svc_no" name="svc_no" value="${svc_no}">                   <!-- svc_no 서비스번호 -->
<input type="hidden" id="svc_type_cd" name="svc_type_cd" value="${svc_type_cd}">    <!-- svc_type_cd 서비스타입 --> 
<input type="hidden" id="filePath" name="filePath">               <!-- 파일경로 -->
<input type="hidden" id="fileName" name="fileName">     <!-- 물리파일명 -->
<input type="hidden" id="orgFileName" name="orgFileName">       <!-- 논리파일명 -->
                
<section>
    <div id="header">
        <div class="board-head">
            <ol class="breadcrumb">
                <li id="menuTree"></li>
            </ol>
            <h1>FILE</h1>
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
                            <li><a href="javascript:fn_moveTypePage('API_TYPE02'); " class="btn btn-default">CHART</a></li>
                        </c:if>    
                        <c:if test="${datasetVO.file_yn == 'Y'}">
                            <li><a href="javascript:fn_moveTypePage('API_TYPE03'); " class="btn btn-info">FILE</a></li>
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
                    </ul>   
                </div>
                <%-- 
                <h2>파일명세서를 제공합니다. 명세서를 다운로드 하세요</h2>
                <table>
                    <caption>
                    파일명세서 목록
                    </caption>
                    <colgroup>
                    <col width="">
                    <col width="10%">
                    <col width="10%">
                    <col width="10%">
                    <col width="10%">
                    <col width="10%">
                    </colgroup>
                    <thead>
                        <tr>
                            <th scope="col">파일명</th>
                            <th scope="col">파일크기</th>
                            <th scope="col">등록일</th>
                            <th scope="col">최종수정일</th>
                            <th scope="col">다운로드수</th>
                            <th scope="col">다운로드</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <td scope="row">식품행정코드북.xls</td>
                            <td class="num">800 KB</td>
                            <td class="num">2014.10.10</td>
                            <td class="num">2014.10.10</td>
                            <td class="num">25</td>
                            <td><a href="#" class="btn btn-default">다운로드</a></td>
                        </tr>
                    </tbody>
                </table>
                 --%>
                <h2>${datasetVO.svc_nm} 관련 파일을 제공합니다. 다운로드 하세요</h2>
                <table>
                    <caption>
                    식품행정처분 관련 파일 목록
                    </caption>
                    <colgroup>
                    <col width="">
                    <col width="10%">
                    <col width="10%">
                    </colgroup>
                    <thead>
                        <tr>
                            <th scope="col">파일명</th>
                            <th scope="col">크기</th>
                            <th scope="col">다운로드</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:if test="${fn:length(fileUploadList) > 0}">
                            <c:forEach var="fileUploadList" items="${fileUploadList}">
		                        <tr>
		                            <td scope="row">${fileUploadList.logic_file_nm}</td>
		                            <!-- 
		                            <td class="num">800 KB</td>
		                            <td class="num">2014.10.10</td>
		                            <td class="num">2014.10.10</td>
		                            -->
		                            <td class="num">${fileUploadList.file_mg} KB</td> 
		                            <td><a href="javascript:downloadFile('${fileUploadList.file_path}', '${fileUploadList.physic_file_nm}', '${fileUploadList.logic_file_nm}', '${fileUploadList.file_type_cd}');" class="btn btn-default">다운로드</a></td>
		                        </tr>
		                    </c:forEach>
		                </c:if>
                    </tbody>
                </table>
            </div>
        </article>
    </div>
</section>
<script type="text/javascript">

    /****************************************
     * Variable
    ****************************************/
    var svc_no = "";
    /****************************************
     * Init
    ****************************************/
    
    $(document).ready(function(){
        svc_no = '${svc_no}';
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
    
     function downloadFile(file_path, physic_file_nm, logic_file_nm, file_type_cd){
         
         $('#filePath').val(file_path);
         $('#fileName').val(physic_file_nm);
         $('#orgFileName').val(logic_file_nm);
         
         document.baseForm.action="${contextPath}/common/downloadAttchdFile.do";
         document.baseForm.target="_self";
         document.baseForm.submit();
         
    }
     
</script>