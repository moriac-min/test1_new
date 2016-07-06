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
            <h1>OPEN API</h1>
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
                            <li><a href="javascript:fn_moveTypePage('API_TYPE03'); " class="btn btn-default">FILE</a></li>
                        </c:if>    
                        <!-- <li><a href="javascript:fn_moveTypePage('API_TYPE04'); " class="btn btn-default">MAP</a></li> -->
                        <c:if test="${datasetVO.link_yn == 'Y'}">
                            <li><a href="javascript:fn_moveTypePage('API_TYPE05'); " class="btn btn-default">LINK</a></li>
                        </c:if>
                        <c:if test="${datasetVO.openapi_yn == 'Y'}">    
                            <li><a href="javascript:fn_moveTypePage('API_TYPE06'); " class="btn btn-danger">Open API</a></li>
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
                <h2>Open API 개발명세 
                    <!-- <a href="#" class="label label-danger">Open API란?</a> -->
                    <a href="#" class="label label-default">Open API란?</a>  
                    <a href="#" class="label label-default">인증키신청</a> 
                    <!-- <a href="#" class="label label-default">명세서 다운로드</a> -->
                </h2>
                <div class="emphasis">
                    <ul>
                        <li>
                            <dl>
                                <dt>요청주소</dt>
                                <dd>http://openAPI.portal.go.kr/api/keyId/serviceId/dataType/startIdx/endIdx</dd>
                            </dl>
                        </li>
                        <li>
                            <dl>
                                <dt>예시</dt>
                                <dd>http://openAPI.portal.go.kr/api/sample/${datasetVO.svc_no}/xml/1/5</dd>
                            </dl>
                        </li>
                    </ul>
                </div>
                <table class="dataset">
                    <caption>
                    변수 목록
                    </caption>
                    <colgroup>
                    <col width="15%">
                    <col width="15%">
                    <col width="25%">
                    <col width="">
                    </colgroup>
                    <thead>
                        <tr>
                            <th scope="col">변수명</th>
                            <th scope="col">타입</th>
                            <th scope="col">변수설명</th>
                            <th scope="col">값설명</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <td scope="row">keyId</td>
                            <td>STRING(필수)</td>
                            <td class="tl">인증키</td>
                            <td class="num tl">OepnAPI 에서 발급된 인증키</td>
                        </tr>
                        <tr>
                            <td scope="row">serviceId</td>
                            <td>STRING(필수)</td>
                            <td class="tl">서비스명</td>
                            <td class="num tl">요청대상인 해당 서비스명</td>
                        </tr>
                        <tr>
                            <td scope="row">dataType</td>
                            <td>STRING(필수)</td>
                            <td class="tl">요청파일 타입</td>
                            <td class="num tl">xml : xml파일 , json : json파일</td>
                        </tr>
                        <tr>
                            <td scope="row">startIdx</td>
                            <td>STRING(필수)</td>
                            <td class="tl">요청시작위치</td>
                            <td class="num tl">정수입력</td>
                        </tr>
                        <tr>
                            <td scope="row">endIdx</td>
                            <td>STRING(필수)</td>
                            <td class="tl">요청종료위치</td>
                            <td class="num tl">정수입력</td>
                        </tr>
                    </tbody>
                </table>
                <!-- Nav tabs -->
                <ul class="nav nav-tabs" role="tablist" id="api-tab">
                  <li class="active"><a href="#view-item" role="tab" data-toggle="tab">출력항목</a></li>
                  <li><a href="#message" role="tab" data-toggle="tab">메시지 설명</a></li>
                </ul>
                <!-- Tab panes -->
                <div class="tab-content">
                    <div class="tab-pane fade in active" id="view-item">
                        <table class="dataset">
                            <caption>
                            변수 목록
                            </caption>
                            <colgroup>
                            <col width="25%">
                            <col width="">
                            </colgroup>
                            <thead>
                                <tr>
                                    <th scope="col">항목</th>
                                    <th scope="col">설명</th>
                                </tr>
                            </thead>
                            <tbody>
                                <!-- 
                                <tr>
                                    <td scope="row">POLL_IDX</td>
                                    <td class="tl">처분번호</td>
                                </tr>
                                 -->
                                <c:if test="${fn:length(dataItemList) > 0}">
                                    <c:forEach var="dataItemList" items="${dataItemList}">
                                        <tr>
		                                    <td scope="row">${dataItemList.itm_nm}</td>
		                                    <td class="tl">${dataItemList.itm_desc}</td>
		                                </tr>
                                    </c:forEach>
                                </c:if>
                            </tbody>
                        </table>
                    </div>
                    <div class="tab-pane fade" id="message">
                        <ul class="message">
                            <li>
                                <dl>
                                    <dt>INFO-000</dt>
                                    <dd>정상 처리되었습니다.</dd>
                                </dl>
                            </li>
                            <li>
                                <dl>
                                    <dt>ERROR-300</dt>
                                    <dd>필수 값이 누락되어 있습니다. 요청인자를 참고 하십시오.</dd>
                                </dl>
                            </li>
                            <li>
                                <dl>
                                    <dt>INFO-100</dt>
                                    <dd>인증키가 유효하지 않습니다. 인증키가 없는 경우,  홈페이지에서 인증키를 신청하십시오.</dd>
                                </dl>
                            </li>
                            <li>
                                <dl>
                                    <dt>ERROR-301</dt>
                                    <dd>파일타입 값이 누락 혹은 유효하지 않습니다. 요청인자 중 TYPE을 확인하십시오.</dd>
                                </dl>
                            </li>
                            <li>
                                <dl>
                                    <dt>ERROR-310</dt>
                                    <dd>해당하는 서비스를 찾을 수 없습니다. 요청인자 중 SERVICE를 확인하십시오.</dd>
                                </dl>
                            </li>
                            <li>
                                <dl>
                                    <dt>ERROR-331</dt>
                                    <dd>요청시작위치 값을 확인하십시오. 요청인자 중 START_INDEX를 확인하십시오.</dd>
                                </dl>
                            </li>
                            <li>
                                <dl>
                                    <dt>ERROR-332</dt>
                                    <dd>요청종료위치 값을 확인하십시오. 요청인자 중 END_INDEX를 확인하십시오.</dd>
                                </dl>
                            </li>
                            <li>
                                <dl>
                                    <dt>ERROR-334</dt>
                                    <dd>종료위치보다 시작위치가 더 큽니다. 요청시작조회건수는 정수를 입력하세요.</dd>
                                </dl>
                            </li>
                            <li>
                                <dl>
                                    <dt>ERROR-336</dt>
                                    <dd>데이터요청은 한번에 최대 1000건을 넘을 수 없습니다.</dd>
                                </dl>
                            </li>
                            <li>
                                <dl>
                                    <dt>ERROR-500</dt>
                                    <dd>서버오류입니다.</dd>
                                </dl>
                            </li>
                            <li>
                                <dl>
                                    <dt>ERROR-601</dt>
                                    <dd>SQL 문장 오류입니다.</dd>
                                </dl>
                            </li>
                            <li>
                                <dl>
                                    <dt>INFO-200</dt>
                                    <dd>해당하는 데이터가 없습니다.</dd>
                                </dl>
                            </li>
                        </ul>
                    </div>
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
    /****************************************
     * Init
    ****************************************/
    
    $(document).ready(function(){
        svc_no = '${svc_no}';
    }); 
    /* 
    $(function () {
        $(window).scroll(function () {
            if ($(this).scrollTop() > 100) {
                $('#back-top').fadeIn();
            } else {
                $('#back-top').fadeOut();
            }
        });
        // scroll body to 0px on click
        $('#back-top a').click(function () {
            $('body,html').stop(false, false).animate({
                scrollTop: 0
            }, 800);
            return false;
        });
    });
     */
    $(function(){
       
        // Tab
        $('#api-tab a:first').tab('show');
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