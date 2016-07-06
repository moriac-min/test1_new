<%@page language="java" contentType="text/html; charset=utf-8"
%><%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"
%><%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"
%><%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"
%>
    <ul class="fmenu">
    	<li><a href="#">국가식품안전관리체계</a></li>
    	<li><a href="/portal/board/board.do?menu_grp=MENU_GRP08&menu_no=601">자주 묻는 질문</a></li>
    	<li><a href="/portal/board/board.do?menu_grp=MENU_GRP08&menu_no=605">개인정보처리방침</a></li>
    	<li><a href="/portal/board/board.do?menu_grp=MENU_GRP08&menu_no=641">이메일무단수집거부</a></li>
    	<li><a href="/portal/board/board.do?menu_grp=MENU_GRP08&menu_no=602">포털이용관련 질의응답</a></li>
    	<li><a href="http://www.mfds.go.kr/index.do?mid=659">아이디어제안</a></li>
    	<li><a href="/portal/board/board.do?menu_grp=MENU_GRP08&menu_no=607">식품안전UCC</a></li>
    	<li><a href="#">뉴스레터</a></li>
    	<li><a href="/portal/board/board.do?menu_grp=MENU_GRP08&menu_no=610">관련사이트</a></li>
    	<li><a href="/portal/board/board.do?menu_grp=MENU_GRP08&menu_no=600">공지사항</a></li>
    </ul>
    <div class="copyright">
    	<div class="logo_mfds">식품의약품안전처</div>
    	<div class="copy_add">
        	<span>363-700 충청북도 오송읍 오송생명2로 187 오송보건의료행정타운 식품의약품안전처</span>
			<span class="copy">Copyright © Ministry of Food and Drug Safety. All Rights Reserved.</span>
            <span>운영기관: 110-750 서울특별시 종로구 창경궁로 136, 5층(원남동,보령빌딩) 식품안전정보원  Tel. 1577-1803  E-mail: info@foodinfo.or.kr </span>
        </div>
    	<div class="logo_foodinfo">식품안전정보원</div>
    </div>
    
<script>
	$(document).ready(function() {
	    $('#nav-open-btn').sidr({
	      name: 'left-nav',
	      side: 'left' // By default
	    });
	});
	
	$(function(){
		$(window).load(function(){
			$("#left-nav.left-nav").mCustomScrollbar({
				theme:"minimal-dark"
			});
		});
		// selectbox
		$(document).ready(function() {
			$("select").selecter();
		});
		//pagination
	    $('#tab1 .pagination').pagination({
	        items: 100,
	        itemsOnPage: 10,
	        cssStyle: 'compact-theme'
	    });
	    $('#tab2 .pagination').pagination({
	        items: 250,
	        itemsOnPage: 10,
	        cssStyle: 'compact-theme'
	    });
		// Tab
		$('#tabs a:first').tab('show')
	});
	
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
	});
</script>

    