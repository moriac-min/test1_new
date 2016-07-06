<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="m" uri="/WEB-INF/tlds/message.tld"%>
<%@ page import="foodportal.common.util.Message"%>


	<div class="gallery col-4" id="listFrame">
		<!-- <ul>
	    	<li class="class"><span class="new"></span>기능성<span class="hit">213</span></li><!-- 인기게시글 경우
	       	<a href="#">
		   		<li class="img-222x175" style="background:url(../../img/sample-222x175.png) no-repeat;"></li>
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
			content += "<li class='class'><span class='new'></span><span class='hit'>"+list[i].inqry_cnt+"</span></li>";
			content += "<a href='javascript:viewDetail("+list[i].ntctxt_no+");'>";
			content += "<li class='img-222x175' style='background:url(${contextPath}"+list[i].img_link_url+") no-repeat;'></li>";
			content += "<li class='title'>"+list[i].titl+"</li>";
			content += "</a>";
			content += "<li class='date'>"+list[i].last_updt_dtm+"</li>";
			content += "</ul>";
		}
		
		document.getElementById("listFrame").innerHTML = content;
	}
	
	</script>