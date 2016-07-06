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
                            <li>신고/진행상태확인</li>
                        </ol>
                        <h1>신고/진행상태확인</h1>
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
        
<script id="message" type="text/html">
	<p>{message}</p>
</script>    
<script id="substance" type="text/html">
	<dl>
		<dt><label for="login-id">문서번호</label></dt>
		<dd><input id="doc_no" type="text" name="doc_no" size="20"></dd>
		<dt><label for="login-pwd">비밀번호</label></dt>
		<dd><input id="pswd" type="password" name="pswd" size="20"></dd>
	</dl>
</script>
<script id="link" type="text/html">
	<a href="{url}" class="btn btn-success btn-lg" {aTagStyle}>{buttonNm}</a>
</script>
<script id="linkToMain" type="text/html">
	<a href="${contextPath}/minwon/main.do" class="btn btn-success btn-lg" style="width: 50%">처음으로 가기</a>
</script>

 <script type="text/javascript">
/***************************************************************************************
* 시스템명 	: 식품의약품안전처 통합식품안전망구축
* 업무명 		: 소비자 신고 로그인
* 파일명 		: customerNotify.jsp
* 작성자 		: 장영철
* 작성일 		: 2014.10.09
*
* 설  명		: 소비자 신고 로그인
*------------------------------------------------------------------------------------
* 변경일	변경자		변경내역 
*------------------------------------------------------------------------------------
*  2014.10.09 장영철		최초 프로그램 작성         
* 
*------------------------------------------------------------------------------------
**************************************************************************************/
var status = '${status}';

$(function() {
	var data = null;
	var strHtml = '';
	var url = '${contextPath}/minwon/main.do';

	if(status == null || status == ''){
		url = 'javascript:fn_chkCustomerNotifyDoc();';
		data = {message: '${m:getMessage("msg.complain.customer.login")}', url: url, aTagStyle: '', buttonNm: '확인'};
		strHtml += innerHtmlMaker('#message', data);
		strHtml += $('#substance').html();
		strHtml += innerHtmlMaker('#link', data);
	}else{
		message = (status == 'noData' ? '${m:getMessage("msg.complain.nodata")}' : '${m:getMessage("msg.complain.unlike.password")}');
		url = '${contextPath}/minwon/complain/customerNotifyLogin.do';
		data = {message: message, url: url, aTagStyle: 'style="width: 50%"', buttonNm: '다시 로그인 하기'};
		strHtml += innerHtmlMaker('#message', data);
		strHtml += innerHtmlMaker('#link', data);
		strHtml += $('#linkToMain').html();
	}
	$('.emphasis').html(strHtml);
});

//로그인 체크
var fn_chkCustomerNotifyDoc = function(){
	var doc_no = $('#doc_no').val();
	var pswd = $('#pswd').val();
	
	var form = $('<form/>', {method: 'post', action: '${contextPath}/minwon/complain/customerNotifyView.do'});
	form.append($('<input/>', {type: 'hidden', name: 'doc_no', value: doc_no}));
	form.append($('<input/>', {type: 'hidden', name: 'pswd', value: pswd}));
	$(document.body).append(form);
	
	form.submit();
};
 
 </script>