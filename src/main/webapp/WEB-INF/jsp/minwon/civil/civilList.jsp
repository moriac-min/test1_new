<%@page language="java" contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<c:set var="contextPath" scope="request">${pageContext.request.contextPath}</c:set>

<section>
   <div id="header">
       <div class="board-head">
           <ol class="breadcrumb">
               <li><a href="#">홈</a></li>
               <li><a href="#">방문/화상상담예약</a></li>
               <li>상담예약</li>
           </ol>
           <h1>상담예약</h1>
       </div>
   </div>
   <div class="page-container"> 
       <!-- 페이지 내용 -->
       <article>
           <div class="emphasis">
               <ul>
               		<li>원활한 상담서비스 이용과 익명 사용자로 인한 피해방지를 위하여 <strong>공공 아이핀 인증을 하여야 상담예약이 가능</strong>합니다.</li>
               		<li>공공 아이핀 인증을 하신 후 상담신청 화면이 나오지 않을 경우 <strong>인터넷 옵션 > 보안 > 보안수준 최소로 설정</strong>하여 다시 해 보시기 바랍니다.</li>
               		<li>방문상담을 받고자 하는 날로부터 3~7일 이전에 예약을 신청해 주시기 바랍니다. <strong>화상상담은 수시 신청 가능</strong></li>
                   	<li>예약이 접수되면 예약자의 휴대폰으로 문자메세지가 전송이 됩니다. 반드시 예약사항을 확인하시고 방문하여 주시기 바랍니다.</li>
                  	<li>각 지방식약청에 방문상담을 원하시는 경우에는 해당 <strong>지방청 홈페이지 민원마당 “민원상담예약”을 이용</strong>해 주시기 바랍니다.</li>
                   	<li>예약사항에 대한 변경이 있는 경우 부서담당자와 연락하시기 바랍니다.</li>
                   	<li>예약완료된 건은 예약취소를 하실 수 없습니다.</li>
               </ul>
               <ul>
                   <li>공공아이핀(I-PIN)은 인터넷상의 개인식별번호를 의미하며, 대면확인이 어려운 인터넷에서 주민등록번호를 사용하지 않고도 본인임을 확인 할 수 있는 수단입니다.</li>
               </ul>
           </div>
           <div class="list-container">
               <div class="search-container">
                   <span class="total">Total: <strong>1283</strong> Articles</span>
                   <div class="search-wrap">
                       <form id="searchForm" name="searchForm" action="#" method="GET">
                           <fieldset>
                               <legend>검색</legend>
                               <input type="text" id="bbs-keyword" name="bbs-keyword" value="">
                               <a href="/" class="btn btn-default" role="button">검색</a> 
                               <label for="pageview">목록게시글수</label>
                               <select id="pageview" name="pageview" class="selecter_basic">                        	
                                   <option value="10">10개씩</option>
                                   <option value="20">20개씩</option>
                                   <option value="30">30개씩</option>
                                   <option value="40">40개씩</option>
                                   <option value="50">50개씩</option>
                               </select>
                               <a href="/" class="btn btn-default" role="button">보기</a>
                           </fieldset>
                       </form>
                   </div>
               </div>
               <table id="reservation">
                   <caption>
                   상담예약
                   </caption>
                   <colgroup>
                   <col width="10%">
                   <col width="35%">
                   <col width="15%">
                   <col width="10%">
                   <col width="10%">
                   <col width="10%">
                   </colgroup>
                     <thead>
                         <tr>
                             <th scope="col">번호</th>
                             <th scope="col">민원 사무명</th>
                             <th scope="col">처리기관</th>
                             <th scope="col">유형</th>
                             <th scope="col">본인확인</th>
                             <th scope="col">신청</th>
                         </tr>
                     </thead>
                     <tbody>
                         <tr>
                             <td scope="row" class="num">1</td>
                             <td><a href="">해당 민원사무명</a></td>
                             <td><a href="">처리기관</a></td>
                             <td>신고</td>
                             <td class="num"><span class="rsv1">필요</span></td>
                             <td>신청</td>
                         </tr>
                     </tbody>
                 </table>
                 <div class="board-footer">
					<div class="pagination"></div> 
                 	<a href="javascript:fnReservation();" class="btn btn-default btn-right">상담예약</a> 
                 </div>
             </div>
         </article>
     </div>
 </section>