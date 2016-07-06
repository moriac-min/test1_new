<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="m" uri="/WEB-INF/tlds/message.tld"%>
<%@ page import="foodportal.common.util.Message"%>
<c:set var="contextPath" scope="request">${pageContext.request.contextPath}</c:set>
 
    <div class="gallery col-4" id="listFrame">
   	<!-- 
   	<ul>
     	<li class="class"><span class="new"></span>기능성</li>
        <a class="photo fancybox.iframe" data-fancybox-group="iframe" href="photo.html">
	     <li class="img-222x150" style="background:url(${contextPath}/img/sample-222x150.png) no-repeat;"></li>
	     <li class="title">한국제약협회 기업윤리헌장 선포식</li>
        </a>
     	<li class="date">2014.10.28</li>
    </ul>
     -->
   </div>
 
   
   
   
<script>
	
	function fn_drawList(list){
		var listLangth = list.length;
		var content = "";
		
		for(var i=0; i<listLangth; i++){
			content += "<ul>";
			content += "<li class='class'><span class='new'></span>"+list[i].ctgrynm+"</li>";
			content += "<a class='photo fancybox.iframe' data-fancybox-group='iframe' href='javascript:viewDetail("+list[i].ntctxt_no+");'>";
			content += "<li class='img-222x150' style='background:url(${contextPath}"+list[i].img_link_url+") no-repeat;'>";
			if('${boardSetting.bbs_type_cd}' == '06'){
				content += "<span class='video'></span>";
			}
			content += "</li>";
			content += "<li class='title'>"+list[i].titl+"</li>";
			content += "</a>";
			content += "<li class='date'>"+list[i].last_updt_dtm+"</li>";
			content += "</ul>";
		}
		
		document.getElementById("listFrame").innerHTML = content;
	}
	
</script>
   