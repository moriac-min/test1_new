<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="m" uri="/WEB-INF/tlds/message.tld"%>
<%@ page import="foodportal.common.util.Message"%>

			<section>
                <div id="header">
                    <div class="board-head">
                        <ol class="breadcrumb">
                            <li><a href="#">홈</a></li>
                            <li><a href="#">1399소비자신고</a></li>
                            <li><a href="#">소비자신고</a></li>
                            <li>소비자신고접수</li>
                        </ol>
                        <h1>소비자신고접수</h1>
                    </div>
                </div>
                <div class="page-container">
                	<!-- 페이지 내용 -->
                    <article>
                    	<div class="centerbox">
                        	<div class="emphasis">
                            </div>
                        </div>
                    </article>
                </div>
            </section>



<script id="complainFinished" type="text/html">
	<p>{complainTile} 정상적으로 접수되었습니다.<br>
	아래 문서번호와 비밀번호는 반드시 기억하셔서 신고 및 진행상황을 조회, 확인하시기 바랍니다.</p>
	<dl>
    	<dt>문서번호</dt>
        <dd>{doc_no}</dd>
        <dt>비밀번호</dt>
        <dd>{pswd}</dd>
        </dl>
	<a href="${contextPath}{complainLoginUrl}" class="btn btn-success btn-lg">확인</a>
</script>
<script type="text/javascript">
/***************************************************************************************
* 시스템명 	: 식품의약품안전처 통합식품안전망구축
* 업무명 		: 신고 완료 폼
* 파일명 		: complainFinished.jsp
* 작성자 		: 장영철
* 작성일 		: 2014.10.16
*
* 설  명		: 신고 완료 폼
*------------------------------------------------------------------------------------
* 변경일	변경자		변경내역 
*------------------------------------------------------------------------------------
*  2014.10.16 장영철		최초 프로그램 작성         
* 
*------------------------------------------------------------------------------------
**************************************************************************************/
$(function() {
	var data = {
		complainType: '${complainType}',
		complainTile: '',
		doc_no: '${doc_no }',
		pswd: '${pswd }',
		complainLoginUrl: ''
	};
	
	//신고형태에 따른 보여질 데이터 변경
	if(data.complainType == 'customer'){
		data.complainTile = '식품안전 소비자 신고가';
		data.complainLoginUrl = '/minwon/complain/customerNotifyLogin.do';
		$('.emphasis').html(innerHtmlMaker('#complainFinished', data));
	}else if(data.complainType == 'business'){
		data.complainTile = '업체이물 보고가';
		data.complainLoginUrl = '/minwon/complain/businessNotifyLogin.do';
		$('.emphasis').html(innerHtmlMaker('#complainFinished', data));
	}else{
		$('.emphasis').html('<p>'+'${m:getMessage("msg.common.system.error")}'+'</p>');
	}
	
});
</script>