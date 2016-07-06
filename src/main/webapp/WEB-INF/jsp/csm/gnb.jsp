<%@page language="java" contentType="text/html; charset=utf-8"
%><%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"
%><%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"
%><%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"
%><%@ taglib prefix="m" uri="/WEB-INF/tlds/message.tld"
%><%@ page import="foodportal.common.util.Message"
%>

<c:set var="contextPath" scope="request">${pageContext.request.contextPath}</c:set>

<meta charset="UTF-8">

<meta http-equiv="X-UA-Compatible" id="document_mode" content="IE=edge" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />


 <nav id="gnb" class="gnb">
        <ul id="top-nav">
            <li class="on"> <a href='/Pages/default.aspx' class="home">Home</a> </li>
            <li> <a href='#'>전자민원</a>
                <div class="sub-nav">
                    <div class="sub-nav-items row">
                        <div class="sub-nav-item">
                            <div class="sub-nav-item-header"><a href="/">식중독정보</a></div>
                        </div>
                    </div>
                </div>
            </li>
            <li> <a href='#'>일반민원</a>
                <div class="sub-nav">
                    <div class="sub-nav-items row">
                        <div class="sub-nav-item">
                            <div class="sub-nav-item-header"><a href="/">식중독정보</a></div>
                        </div>
                    </div>
                </div>
            </li>
            <li> <a href='#'>방문/화상상담예약</a>
                <div class="sub-nav">
                    <div class="sub-nav-items row">
                        <div class="sub-nav-item">
                            <div class="sub-nav-item-header"><a href="/">식중독정보</a></div>
                        </div>
                    </div>
                </div>
            </li>
            <li> <a href='#'>1399소비자신고</a>
                <div class="sub-nav">
                    <div class="sub-nav-items row">
                        <div class="sub-nav-item">
                            <div class="sub-nav-item-header"><a href="/">식중독정보</a></div>
                        </div>
                    </div>
                </div>
            </li>
            <li> <a href='#'>민원서식자료실</a>
                <div class="sub-nav">
                    <div class="sub-nav-items row">
                        <div class="sub-nav-item">
                            <div class="sub-nav-item-header"><a href="/">식중독정보</a></div>
                        </div>
                    </div>
                </div>
			</li>
            <li> <a href='#'>이용안내</a>
                <div class="sub-nav">
                    <div class="sub-nav-items row">
                        <div class="sub-nav-item">
                            <div class="sub-nav-item-header"><a href="/">식중독정보</a></div>
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
	
	menuGrp = '${menu_grp}';
	//menuGrp = $("#menu_grp").val();
	
	/* 
	if(menuGrp == null || menuGrp == ""){
		menuGrp = "MENU_GRP03";
	}
	 */
	//setLeftMenu(menuGrp); //식품위해정보
	
}); 

</script>