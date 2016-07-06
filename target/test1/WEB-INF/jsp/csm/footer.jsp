<%@page language="java" contentType="text/html; charset=utf-8"
%><%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"
%><%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"
%><%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"
%>


    <ul class="fmenu">
    	<li><a href="#">장애조치</a></li><li><a href="#">개인정보처리방침</a></li><li><a href="#">행정서비스헌장</a></li><li><a href="#">행정정보소재안내</a></li><li><a href="#">도로명주소안내</a></li><li><a href="#">원격지원</a></li><li><a href="#">뷰어프로그램</a></li>
    </ul>
    <div class="copyright">
    	<div class="logo_mfds">식품의약품안전처</div>
    	<div class="copy_add">
        	<span>363-700 충청북도 오송읍 오송생명2로 187 오송보건의료행정타운 식품의약품안전처</span>
			<span class="copy">Copyright © Ministry of Food and Drug Safety. All Rights Reserved.</span>
            <span>소비자신고(식품안전정보원): 국번없이 1399, 종합상담센터 : 1577-1255, 전자민원 시스템 문의 : T) 043-234-3100, F) 050-2604-7949</span>
        </div>
    </div>
    
<script>
	
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
		
		// 반응형 좌측메뉴 슬라이드
		$("#lnb").navgoco({
			caretHtml: '',
			accordion: true,
			openClass: 'open',
			save: true,
			cookie: {
				name: 'navgoco',
				expires: false,
				path: '/'
			},
			slide: {
				duration: 400,
				easing: 'swing'
			},
			// Add Active class to clicked menu item
			onClickAfter: function(e, submenu) {
				e.preventDefault();
				$('#lnb').find('li').removeClass('active');
				var li =  $(this).parent();
				var lis = li.parents('li');
				li.addClass('active');
				lis.addClass('active');
			},
		});
	});
</script>

    