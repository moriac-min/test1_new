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
                            <li><a href="#">일반민원</a></li>
                            <li>일반민원신청(국민신문고)</li>
                        </ol>
                        <h1>일반민원신청(국민신문고)</h1>
                    </div>
                </div>
                <div class="page-container">
                	<!-- 페이지 내용 -->
                    <article>
                    	<div class="emphasis">
                            <ul>
                                <li>사이버상담 서비스는 행정기관 민원서비스 통합에 따라 국민권익위원회에서 운영하는 국민신문고<a href="http://www.epeople.go.kr" target="_blank">(http://www.epeople.go.kr)</a>를 통해 서비스됩니다.</li>
                                <li>시스템(에러)문의 : 국민권익 위원회(1600-8172)</li>
                                <li>전화상담문의 : 종합상담센터(1577-1255)</li>
                            </ul>
                        </div>
                        <!-- 국민신문고-->
                        <div id="epeople"></div>
                        <script type="text/javascript">
                            document.getElementById('epeople').innerHTML = '<iframe title="일반상담" src="http://www.epeople.go.kr/jsp/user/frame/pc/cvreq/UPcCvreqForm.jsp?anc_code=1471000&channel=1471000&menu_code=PC018" id="mergerFrame" name="mergerFrame" scrolling="no" width="700"  height="100%" frameborder="0" marginwidth="0" marginheight="0" onload="javascript:AfterSubmitProcess()"></iframe>';
                        </script> 
                        <!-- 국민신문고 -->
                        <div class="board-footer" style="text-align:center;">
                            <a href="http://call.mfds.go.kr/old" target="_blank" class="btn btn-default">2011년 3월 이전자료</a>
							<a href="http://call.mfds.go.kr/kfda?cmd=CVF00L3" target="_blank" class="btn btn-default">2012년 9월 30일 이전자료</a>
                        </div>
                    </article>
                </div>
            </section>