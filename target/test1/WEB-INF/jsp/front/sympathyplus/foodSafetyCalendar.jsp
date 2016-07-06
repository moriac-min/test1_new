<%@page language="java" contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<c:set var="contextPath" scope="request">${pageContext.request.contextPath}</c:set>

<section>
    <div id="header">
        <div class="board-head">
            <div class="lnb-viewer" id="nav-open-btn" href="#left-nav">Menu</div>
            <ol class="breadcrumb">
                <li id="menuTree"></li>
            </ol>
            <h1>식품안전 캘린더</h1>
        </div>
    </div>
    <div class="list-container">
        <div class="gallery col-7" id="listFrame">
        	
        </div>
    </div>
</section>
<script>
//카테고리 클릭
	
	function aaa(){
		$.ajax({ 
            data: {date_no : "201410"},
            dataType:'json', 
            type:'POST',
            url:"${contextPath}/portal/sympathyplus/foodSafetyCalendarList.do", 
            success:function(result){
            	
            	drawList(result);

            },
            error:function(request,status,error){
                alert("실패코드 : " + request.status+"\n메세지 : " + request.error);
            }
        });
	}
	
	function drawList(result){
	
		var list = new Array();
		list = result.schList;
		var calInfo = result.calInfo;
		var contents = "";
		var day = 1;			//요일
		var today = 1;			//화면에 표시될 일자
		var drawFlag = false;	//날짜 그리기 여부
		
		for(var i=1; i <= 50; i++){
			if(day > 7){
				day = 1;
			}
			contents+= "<ul>";
			contents+= "	<li>";
			contents+= "		<a class='openinfo fancybox.iframe' data-fancybox-group='iframe' href='javascript:fn_moveDetail();'><dl>";
			contents+=	"			<dt>";
			if(calInfo.month_day == day && today <= calInfo.month_lastday){
				drawFlag = true;
			}
			if(drawFlag == true){
				contents+= today;
				today++;
			}
			for(var j=0; j<list.length; j++){
				//내용들어갈곳
			}
			contents+= "			</dt>";
			contents+= "		</dl></a>";                           
			contents+= "	</li>";
			contents+= "</ul>";
			day++;
			if(today > calInfo.month_lastday){
				drawFlag = false;
			}
			if(today > calInfo.month_lastday && day > 7){
				break;
			}
		}

		document.getElementById("listFrame").innerHTML = contents;
	
	}
	aaa();
	
	//상세페이지팝업    
    function fn_moveDetail(){
    	var action  = '${contextPath}/popup/sympathyplus/foodSafetyCalendarDetail.do';
        
        $(".openinfo").fancybox({
        	maxWidth    : 830,
            maxHeight   : 740,
            minHeight   : 740,
            fitToView   : false,
            width       : '70%',
            height      : '80%',
            hMargin		:	'100px',
            autoSize    : false,
            closeClick  : false,
            openEffect  : 'fade',
            closeEffect : 'fade',
            tpl: {next : '', prev : ''},
        	//href        : '${contextPath}/popup/agriCrackdownDetail.do?aplc_seq='+aplc_seq
            href        : action
        });
    }
</script>