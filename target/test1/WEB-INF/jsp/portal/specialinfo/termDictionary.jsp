<%@page language="java" contentType="text/html; charset=utf-8"
%><%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"
%><%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"
%><%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"
%><%@ taglib prefix="m" uri="/WEB-INF/tlds/message.tld"
%><%@ page import="foodportal.common.util.Message"
%>

<link type="text/css" href="../../../css/bootstrap.min.css" rel="stylesheet">
<link type="text/css" href="../../../css/webfont.css" rel="stylesheet">
<link type="text/css" href="../../../css/jquery.mCustomScrollbar.css" rel="stylesheet">
<link type="text/css" href="../../../css/jquery.selecter.css" rel="stylesheet">
<link type="text/css" href="../../../css/style_page.css" rel="stylesheet">
<script type="text/javascript" src="../../../js/jquery.min.js"></script>
<script type="text/javascript" src="../../../js/bootstrap.min.js"></script>
<script type="text/javascript" src="../../../js/bootstrap/button.js"></script>
<script type="text/javascript" src="../../../js/jquery.cookie.min.js"></script>
<script type="text/javascript" src="../../../js/jquery.navgoco.min.js"></script>
<script type="text/javascript" src="../../../js/highlight.pack.js"></script>
<script type="text/javascript" src="../../../js/jquery.sidr.min.js"></script>
<script type="text/javascript" src="../../../js/jquery.selecter.min.js"></script>

<c:set var="contextPath" scope="request">${pageContext.request.contextPath}</c:set>
<input type="hidden" id="start_idx" value="1">                <!-- start_idx -->
<input type="hidden" id="total_cnt" value="0">                <!-- total_cnt -->
<input type="hidden" id="search_type" value="">               <!-- search_type -->
<input type="hidden" id="search_word" value="">               <!-- search_word -->

<section>
    <div id="header">
        <div class="board-head">
            <div class="lnb-viewer" id="nav-open-btn" href="#left-nav">Menu</div>
            <ol class="breadcrumb">
                <li><a href="${contextPath}/portal/main.do">홈</a></li>
                <li><a href="#">전문정보관</a></li>
                <li class="active">용어사전</li>
            </ol>
            <h1>용어사전</h1>
        </div>
    </div>
    <div class="page-container">
        <!-- 페이지 내용 -->
        <article>
        	<div class="glossary-search">
<!--                 <form id="searchForm" name="searchForm" action="#" method="post"> -->
                    <fieldset>
                        <legend>검색</legend>
                        <ul>
                            <li>
                                <div class="select-container w150">
                                    <select name="searchType" id="searchType">
                                        <option value="01">용어</option>
                                        <option value="02">연관어</option>
                                        <option value="03">내용</option>
                                        <option value="all">용어+연관어+내용</option>
                                    </select>
                                </div>
                            </li>
                            <li>
                                <input type="text" id="searchKeyword" name="glossary-keyword" value="" onkeyup="if(event.keyCode==13){$('#btnSearch').click();}">
                            </li>
                            <li><a href="#" class="btn btn-default" id="btnSearch" role="button">검색</a></li>
                        </ul>
                    </fieldset>
<!--                 </form> -->
            </div>
            <div class="glossary">
                <div class="word-list">
                	<div class="keyword" id="keywordKoEn">가나다</div>
                	
	                    <ul id="wordList">
	
	                    </ul>
                    
                    <div class="page">
                    	<a style="cursor:pointer" class="prev" onclick="javascript:fn_goPage('prev');">이전 페이지</a>
                    	<a style="cursor:pointer" class="next" onclick="javascript:fn_goPage('next');">다음 페이지</a>
                    </div>
                </div>
                
                <div class="word-dscr" id="wordDetail">

                </div>
                
                <div class="word-index">
                	<div class="language" id="languageKoEn"><a style="cursor:pointer" id="languageKo" onclick="fn_toggleKoEn(this.id)">가</a></div><!--   한영 전환 처리 필요 -->
                    <div class="eng" id="toggleEng" style="display: none;">
                    	<ul>
                    		<li><a style="cursor:pointer" class="">A</a></li>
                    		<li><a style="cursor:pointer" class="">B</a></li>
                    		<li><a style="cursor:pointer" class="">C</a></li>
                    		<li><a style="cursor:pointer" class="">D</a></li>
                    		<li><a style="cursor:pointer" class="">E</a></li>
                    		<li><a style="cursor:pointer" class="">F</a></li>
                    		<li><a style="cursor:pointer" class="">G</a></li>
                    		<li><a style="cursor:pointer" class="">H</a></li>
                    		<li><a style="cursor:pointer" class="">I</a></li>
                    		<li><a style="cursor:pointer" class="">J</a></li>
                    		<li><a style="cursor:pointer" class="">K</a></li>
                    		<li><a style="cursor:pointer" class="">L</a></li>
                    		<li><a style="cursor:pointer" class="">M</a></li>
                    		<li><a style="cursor:pointer" class="">N</a></li>
                    		<li><a style="cursor:pointer" class="">O</a></li>
                    		<li><a style="cursor:pointer" class="">P</a></li>
                    		<li><a style="cursor:pointer" class="">Q</a></li>
                    		<li><a style="cursor:pointer" class="">R</a></li>
                    		<li><a style="cursor:pointer" class="">S</a></li>
                    		<li><a style="cursor:pointer" class="">T</a></li>
                    		<li><a style="cursor:pointer" class="">U</a></li>
                    		<li><a style="cursor:pointer" class="">V</a></li>
                    		<li><a style="cursor:pointer" class="">W</a></li>
                    		<li><a style="cursor:pointer" class="">X</a></li>
                    		<li><a style="cursor:pointer" class="">Y</a></li>
                    		<li><a style="cursor:pointer" class="">Z</a></li>
                    	</ul>
                    </div>
                    <div class="kor" id="toggleKor" style="">
                    	<ul>
                    		<li><a style="cursor:pointer" class="" id="ㄱ">가</a></li>
                    		<li><a style="cursor:pointer" class="" id="ㄴ">나</a></li>
                    		<li><a style="cursor:pointer" class="" id="ㄷ">다</a></li>
                    		<li><a style="cursor:pointer" class="" id="ㄹ">라</a></li>
                    		<li><a style="cursor:pointer" class="" id="ㅁ">마</a></li>
                    		<li><a style="cursor:pointer" class="" id="ㅂ">바</a></li>
                    		<li><a style="cursor:pointer" class="" id="ㅅ">사</a></li>
                    		<li><a style="cursor:pointer" class="" id="ㅇ">아</a></li>
                    		<li><a style="cursor:pointer" class="" id="ㅈ">자</a></li>
                    		<li><a style="cursor:pointer" class="" id="ㅊ">차</a></li>
                    		<li><a style="cursor:pointer" class="" id="ㅋ">카</a></li>
                    		<li><a style="cursor:pointer" class="" id="ㅌ">타</a></li>
                    		<li><a style="cursor:pointer" class="" id="ㅍ">파</a></li>
                    		<li><a style="cursor:pointer" class="" id="ㅎ">하</a></li>
                    	</ul>
                    </div>
                </div>
            </div>
        </article>
        <!-- ASIDE -->
        <aside>
            <ul class="share">
                <li><a href="javascript:print();" class="print">프린트</a></li>
                <li><a href="#" class="email">이메일</a></li>
                <li><a href="#" class="fb">페이스북</a></li>
                <li><a href="#" class="tw">트위터</a></li>
                <li><a href="#" class="url">URL보내기</a></li>
            </ul>
            <div class="widget">
                <h2 class="latest">최신게시글</h2>
                <ul class="wt-list">
                    <li> <a href="#">어린이건강메뉴 – 한국식 오코노미야끼</a> <span>2014.10.28</span> </li>
                    <li> <a href="#">봄나물 바로알기 – 가득 봄 내음 물씬 나는 봄나물 예찬</a> <span>2014.10.28</span> </li>
                    <li> <a href="#">식중독균 이런 것들이 있어요</a> <span>2014.10.28</span> </li>
                    <li> <a href="#">여름철 음식관리법과 휴가지 음식관리요령</a> <span>2014.10.28</span> </li>
                    <li> <a href="#">무리한 다이어트의 역효과, 식사장애 </a> <span>2014.10.28</span> </li>
                </ul>
            </div>
            <div class="widget">
                <h2 class="popular">인기게시글</h2>
                <ul class="wt-list">
                    <li> <a href="#">어린이건강메뉴 – 한국식 오코노미야끼</a> <span>2014.10.28</span> </li>
                    <li> <a href="#">봄나물 바로알기 – 가득 봄 내음 물씬 나는 봄나물 예찬</a> <span>2014.10.28</span> </li>
                    <li> <a href="#">식중독균 이런 것들이 있어요</a> <span>2014.10.28</span> </li>
                    <li> <a href="#">여름철 음식관리법과 휴가지 음식관리요령</a> <span>2014.10.28</span> </li>
                    <li> <a href="#">무리한 다이어트의 역효과, 식사장애 </a> <span>2014.10.28</span> </li>
                </ul>
            </div>
            <div class="widget">
                <h2 class="reporter">공감리포터</h2>
                <ul class="wt-thumbnail">
                    <li> <img src="../../../img/sample-77x77.png" alt="어린이건강메뉴 – 한국식 오코노미야끼"> <a href="#">어린이건강메뉴 – 한국식 오코노미야끼</a> <span>2014.10.28</span> </li>
                    <li> <img src="../../../img/sample-77x77.png" alt="봄나물 바로알기 – 가득 봄 내음 물씬 나는 봄나물 예찬"> <a href="#">봄나물 바로알기 – 가득 봄 내음 물씬 나는 봄나물 예찬</a> <span>2014.10.28</span> </li>
                    <li> <img src="../../../img/sample-77x77.png" alt="식중독균 이런 것들이 있어요"> <a href="#">식중독균 이런 것들이 있어요</a> <span>2014.10.28</span> </li>
                </ul>
            </div>
        </aside>
    </div>
</section>


<script type="text" id="wordListText">
<li><a style="cursor:pointer" onclick="javascript:fn_getDetail(this.id);" id="{seq}">{word}</a></li>
</script>

<script type="text" id="wordListTextEn">
<li><a style="cursor:pointer" onclick="javascript:fn_getDetail(this.id);" id="{seq}">{foreign_lang}</a></li>
</script>

<script type="text" id="wordDetailEmpty">
<div class="no-data">선택된 용어가 없습니다.</div>
</script>

<script type="text" id="languageKoText">
<a style="cursor:pointer" id="languageKo" onclick="fn_toggleKoEn(this.id)">가</a>
</script>

<script type="text" id="languageEnText">
<a style="cursor:pointer" id="languageEn" onclick="fn_toggleKoEn(this.id)">A</a>
</script>

<script type="text" id="wordDetailText">
<h2>{word}
	<span>{foreign_lang}</span></h2>
<dl>
	<dt>연관어</dt>
    <dd>{keyword_all}</dd>
<dt>설명</dt>
   <dd>
   	{explain}
   </dd>
<dt>출처</dt>
   <dd>{source}</dd>
</dl>
</script>

<script type="text/javascript" >

$(document).ready(function(){
	
	fn_searchList();
	
	//검색 버튼 검색
	$("#btnSearch").click(function(){
		fn_replaceSpecialChar("#searchKeyword");
		$("#search_type").val($("#searchType").val());
		$("#search_word").val($("#search_word").val());
		fn_searchList();
	});
	
	//각 영어 알파벳 클릭시
	$("#toggleEng").on('click',function(e){
		if(e.target.nodeName == 'A'){
			var val = e.target.text;
			$("#search_type").val('headWordEn');
			$("#search_word").val(val);
			fn_searchList();
		}
	});
	
	//각 한글 알파벳 클릭시
	$("#toggleKor").on('click',function(e){
		if(e.target.nodeName == 'A'){
			var val = e.target.id;
			$("#search_type").val('headWordKo');
			$("#search_word").val(val);
			fn_searchList();
		}
	});
	
});

//조회
function fn_searchList(){
	var search_type = $("#search_type").val();
	var search_word = $("#search_word").val();
	var start_idx = $("#start_idx").val();
	var show_cnt = "20";				//20개씩 보이기
	var param = "?search_type="+search_type+"&search_word="+search_word+"&start_idx="+start_idx+"&show_cnt="+show_cnt;
	$.ajax({
		type	:"post",
		url		:"${contextPath}/portal/termdictionary/termAjaxList.do"+param,
		dataType:"json",
		success:function(data){
			if(data != ''){
				
				//total 개수
                $('#total_cnt').val(data.total_cnt);
				
				var list = new Array();
                list = data.list;
				
				fn_drawContent(list);
			}else{
				alert("조회된 내역이 없습니다.");
			}
		},
        error:function(request,status,error){
            alert("실패코드 : " + request.status+"\n메세지 : " + request.error);
        }
	});
}

//상세 조회
function fn_getDetail(val){
	
	$.ajax({
		type	:"post",
		url		:"${contextPath}/portal/termdictionary/termAjaxDetail.do?search_word="+val,
		dataType:"json",
		success:function(data){
			//상세 그리기
			var html = innerHtmlMaker("#wordDetailText",data.termDetail);
			$("#wordDetail").empty();
			$("#wordDetail").html(html);
		},
        error:function(request,status,error){
            alert("실패코드 : " + request.status+"\n메세지 : " + request.error);
        }
	});
	
	//wordList 선택 li 태그 클래스 활성화
	$("#wordList>li>a.active").removeClass("active");
	$("#"+val).addClass("active");
}

//조회한 내용 그리기
function fn_drawContent(data){
	var html = "";
	var flag = $("#search_type").val();
	
	if(flag == 'detail'){
		//상세 그리기 - 위치 변경
// 		html += innerHtmlMaker("#wordDetailText",data[0]);
// 		$("#wordDetail").empty();
// 		$("#wordDetail").html(html);
	}else{
		//목록 그리기
		var textId = "#wordListText";
		var koEn = $("#languageKoEn>a").attr("id");
		if(koEn == "languageEn"){
			textId = "#wordListTextEn";
		}
		$.each(data,function(i){
			html += innerHtmlMaker(textId,data[i]);
			if(i == 19){
				return false;
			}
		});
		$("#wordList").empty();
		$("#wordList").html(html);
		$("#wordDetail").html($("#wordDetailEmpty").html());
	}
}

//한영전환 클릭시
function fn_toggleKoEn(val){
	$("#toggleEng").css("display","none");
	$("#toggleKor").css("display","none");
	$("#keywordKoEn").text("");
	if(val == "languageEn"){
		$("#languageKoEn").empty();
		$("#languageKoEn").html($("#languageKoText").text());
		$("#toggleKor").css("display","block");
		$("#keywordKoEn").text("가나다");
		val = "koAll";
	}else if(val == "languageKo"){
		$("#languageKoEn").empty();
		$("#languageKoEn").html($("#languageEnText").text());
		$("#toggleEng").css("display","block");
		$("#keywordKoEn").text("ABC");
		val = "enAll";
	}
	$("#search_type").val(val);
	fn_searchList();
}

//페이지 이동
function fn_goPage(p){
	alert($("#total_cnt").val());
	if(p == "prev"){
		var start_idx = $("#start_idx").val();
		if(start_idx != '1'){
			$("#start_idx").val(parseInt(start_idx)-1);
			fn_searchList();
		}else{
			alert("처음 페이지입니다.");
		}
	}else{
		var start_idx = $("#start_idx").val();
		var total_cnt = $("#total_cnt").val();
		if(parseInt(total_cnt) > parseInt(start_idx)*20){
			$("#start_idx").val(parseInt(start_idx)+1);
			fn_searchList();
		}else{
			alert("마지막 페이지입니다.");
		}
	}
}

</script>