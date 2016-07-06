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
     	<div class="util-container">
			<div class="yyyymm" id="yearMonth">2014.10</div>
			<a href="javascript:fn_MoveMonth('prev');" class="prev">이전달</a>
			<a href="javascript:fn_MoveMonth('next');" class="next">다음달</a>
        </div>
        <div class="event-calendar">
           	<table>
                <colgroup>
                	<col style="width:14.2857%;">
                	<col style="width:14.2857%;">
                	<col style="width:14.2857%;">
                	<col style="width:14.2857%;">
                	<col style="width:14.2857%;">
                	<col style="width:14.2857%;">
                	<col style="width:14.2857%;">
                </colgroup>
                <thead>
                	<tr>
					<th scope="col">일</th>
					<th scope="col">월</th>
					<th scope="col">화</th>
					<th scope="col">수</th>
					<th scope="col">목</th>
					<th scope="col">금</th>
					<th scope="col">토</th>
                 </tr>
                </thead>
                <tbody id="listFrame">
                 	
                 </tbody>
             </table>
    	</div>
    </div>
</section>
<script>
//카테고리 클릭
	var calInfo;
	var year='';
	var month='';
	
	function fn_MoveMonth(trans){
		
		if(trans == 'next'){
			if(month == '12'){
				year = (parseInt(year)+1).toString();
				month = '01';
			}else{
				month = (parseInt(month)+1).toString();	
			}
		}else{
			if(month == '01'){
				year = (parseInt(year)-1).toString();
				month = '12';
			}else{
				month = (parseInt(month)-1).toString();	
			}
		}
		if(month.length < 2){
			month = '0'+month;
		}
		fn_getCalendar();
	}
	
	function fn_getCalendar(){
		$.ajax({ 
            data: {date_no : year+month },
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
		calInfo = result.calInfo;
		var contents = "";
		var day = 1;			//요일
		var today = 1;			//화면에 표시될 일자
		var drawFlag = false;	//날짜 그리기 여부
		var date_no="";
		
		year = calInfo.year;
		month = calInfo.month;
		
		$("#yearMonth").html(calInfo.year+"."+calInfo.month);
		
		 
		for(var i=1; i <= 50; i++){
			if(day == 1 || day == 8){
				if(day == 8){
					day = 1;
					contents+="</tr>";
				}
				contents+="<tr>";
			}
			contents+=" 	<td><div class='day'>";
			if(calInfo.month_day == day && today <= calInfo.month_lastday){
				drawFlag = true;	
			}
			if(drawFlag == true){
				contents+= today;
				if(today < 10){
					date_no = year+month+'0'+today;
				}else{
					date_no = year+month+today;
				}
				today++;
			}
			contents+="</div>";
			for(var j=0; j<list.length; j++){
				//내용들어갈곳
				if(date_no == list[j].date_no){
					contents+="<ul>";
					contents+="	<li><a class='openinfo fancybox.iframe' href='javascript:fn_OpenDetailPop("+list[j].date_no+","+list[j].date_seq+");'>"+list[j].title+"</a></li>";
					contents+="	<li>"+list[j].begin_dt+" ~ "+list[j].end_dt+"</li>";
					contents+="</ul>";
				}
			}
			contents+="</td>";
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
	fn_getCalendar();
	
	//상세페이지팝업    
    function fn_OpenDetailPop(date_no, date_seq){
    	var action  = '${contextPath}/popup/sympathyplus/foodSafetyCalendarDetail.do?date_no='+date_no+'&date_seq='+date_seq;
        
        $(".openinfo").fancybox({
        	maxWidth    : 700,
            maxHeight   : 600,
            minHeight   : 600,
            fitToView   : false,
            width       : '70%',
            height      : '70%',
            hMargin		: 100,
            autoSize    : false,
            scrollBar	: false,
            closeClick  : false,
            openEffect  : 'fade',
            closeEffect : 'fade',
            tpl: {next : '', prev : ''},
        	//href        : '${contextPath}/popup/agriCrackdownDetail.do?aplc_seq='+aplc_seq
            href        : action
        });
    }
</script>