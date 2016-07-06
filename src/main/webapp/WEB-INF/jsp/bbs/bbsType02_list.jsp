<%@ page language="java" contentType="text/html; charset=utf-8"
%><%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"
%><%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"
%><%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" 
%><%@ taglib prefix="m" uri="/WEB-INF/tlds/message.tld"
%><%@ page import="foodportal.common.util.Message"
%>



  <div class="gallery col-4" id="listFrame">
  </div>
 
 
 <script>
 function fn_drawList(list){
		var listLangth = list.length;
		var content = "";
		
		$("#listFrame").html("");
		
		for(var i=0; i<listLangth; i++){
			content += "<ul>";
			content += "<a href='javascript:viewDetail("+list[i].ntctxt_no+");'>";
			content += "<li class='class nation us'><span class='new'></span><span class='hit'>"+list[i].inqry_cnt+"</span></li>";
			content += "<li class='news-title'>"+list[i].titl+"</li>";
			content += "</a>";
			content += "<li class='origin'>Reuters(US)</li>";
			content += "<li class='date'>"+list[i].last_updtr_id+"</li>";
			content += "</ul>";
		}
		
		$("#listFrame").html(content);
	}

 
 $(window).on('load', function() {
		// Contents Slider
		$('#highlight').nivoSlider({
			effect: 'fade',
			slices:15,
			boxCols:8,
			boxRows:8,
			animSpeed:500,
			pauseTime:8000,
			directionNav:false,
			directionNavHide:false,
			pauseOnHover:true,
			controlNav:true,
			captionOpacity:1	
		});
	});

	
	</script>
	