<%@page language="java" contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="m" uri="/WEB-INF/tlds/message.tld"%>
<%@ page import="foodportal.common.util.Message"%>

<c:set var="contextPath" scope="request">${pageContext.request.contextPath}</c:set>

 <nav id="gnb" class="gnb">
     <ul id="top-nav">
         <li class="on"> <a href='/api/main.do' class="home">Home</a> </li>
         <li> <a href='${gnbMap.MENU_GRP31}'>데이터셋</a>
             <div class="sub-nav">
                 <div class="sub-nav-items row">
                     <div class="sub-nav-item">
                         <div class="sub-nav-item-header"><a href="/">유형별</a></div>
                         <div class="sub-nav-item-header"><a href="/">분류별</a></div>
                         <div class="sub-nav-item-header"><a href="/">제공기관별</a></div>
                     </div>
                 </div>
             </div>
         </li>
         <li> <a href='${gnbMap.MENU_GRP32}'>인증키 발급 및 확인</a>
             <div class="sub-nav">
                 <div class="sub-nav-items row">
                     <div class="sub-nav-item">
                         <div class="sub-nav-item-header"><a href="/">인증키 발급 및 확인</a></div>
                         <div class="sub-nav-item-header"><a href="/">인증키 신청</a></div>
                     </div>
                 </div>
             </div>
         </li>
         <li> <a href='${gnbMap.MENU_GRP33}'>고객센터</a>
             <div class="sub-nav">
                 <div class="sub-nav-items row">
                     <div class="sub-nav-item">
                         <div class="sub-nav-item-header"><a href="/">공지사항</a></div>
                         <div class="sub-nav-item-header"><a href="/">자주 묻는 질문</a></div>
                         <div class="sub-nav-item-header"><a href="/">질의응답</a></div>
                     </div>
                 </div>
             </div>
         </li>
         <li> <a href='${gnbMap.MENU_GRP34}'>데이터활용서비스란?</a>
             <div class="sub-nav">
                 <div class="sub-nav-items row">
                     <div class="sub-nav-item">
                         <div class="sub-nav-item-header"><a href="/">데이터활용서비스 소개</a></div>
                         <div class="sub-nav-item-header"><a href="/">데이터활용서비스 이용방법</a></div>
                     </div>
                 </div>
             </div>
         </li>
     </ul>
     <div class="sub-nav-shadow"></div>
 </nav>
   
<script type="text/javascript">
var menuGrp = "";
$(document).ready(function(){
	
	// 상단메뉴고정 
    $(window).scroll(function(event){
        var y=$(this).scrollTop();
        if( y > 184 ){
            $("#gnb.gnb").addClass('gnb-fixed-top');
            $(".article-head .lnb-viewer").addClass('lnb-fixed-top');
        }
        else{
            $("#gnb.gnb").removeClass('gnb-fixed-top');
            $(".article-head .lnb-viewer").removeClass('lnb-fixed-top');
        }
    });
	menuTree = '${gnbMap.menuTree}';
}); 

</script>

