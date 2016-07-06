<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
%><%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"
%><%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"
%><%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"
%>


	<style>
		.wrapBannerScreen {position:absolute; top:0; left:512px; text-align:right; border:0px solid #8db0c5; width:320px;}
		.clsBannerScreen {position:absolute; top:0; left:0px; right:0; text-align:right; border:0px solid #8db0c5; width:310px;}
		.clsBannerScreen .images {position:absolute; top:0; right:0; display:table;; width:300px; height:235px;}
		.clsBannerScreen .images .img{width:300px; height:205px; line-height:205px; text-align:center; vertical-align:bottom;}
		.refs { text-align:left; height:20px; padding:10px 0 0; line-height:120%;}
		ul, li {list-style:none; margin:0; padding:0px; font-size:10pt; text-align:center;}
		.clsBannerButton { overflow:hidden; text-align:right; width:300px; cursor:pointer; border-bottom:0px solid #e1e1e1; color:#006b90;}
		.clsBannerButton li {width:25px; float:left; border-right:0px solid #e1e1e1; padding:0px; color:#006b90;}
		.clsBannerButton li.fir {border-left:0px solid #e1e1e1; color:#006b90;}
		.clsBannerButton li.labelOverClass {font-weight:bold; background-color:#e5eef9;}
		
	</style>
	
	<script type="text/javascript">
	$(document).ready(function () {
	    $('#search_form_query0').val("${foodMeterial.mtral_nm}");
	});

	function MM_openBrWindow(theURL,winName,features){ //v2.0
		window.open(theURL,winName,features);
	}
	
	//부위정보 레이어팝업
	function popPartInfoLayer(partnm, edible, codex, basis) {
		$("#td_partnm").empty();
		$("#td_edible").empty();
		$("#td_codex").empty();
		$("#td_basis").empty();
		
		if (codex == '1') {
			codex = '예';
		}
		else if (codex == '2') {
			codex = '아니오';
		}
		
		$("#td_partnm").append(partnm);
		$("#td_edible").append(edible);
		$("#td_codex").append(codex);
		$("#td_basis").append(basis);
		
		alert('부위:'+partnm+'\n식용여부:'+edible+'\n공전등재:'+codex+'\n식용근거:'+basis);
		
		/*
		$("#dialog_part").dialog({
			width:"auto",
			height:"auto",
			draggable:true
		});
		//*/
		return false;
	}
	
	//근거자료 레이어팝업
	function popResourceInfoLayer(title, type, detail, saveFile) {
		var innerHtml = "";
		var path = "/upload/dborigin/";
		
		$("#td_title").empty();
		$("#td_detail").empty();
		
		$("#td_title").append(title);
		
		if("text" == type) {
			$("#td_detail").append(detail);
		} 
		else if("file" == type) {
			innerHtml += "<a href='" + path + saveFile + "' onfocus='this.blur()'>" + detail + "</a>";
			$("#td_detail").append(innerHtml);
		} 
		else if("link" == type) {
			innerHtml += "<a href='" + detail + "' target='_blank' onfocus='this.blur()'>" + detail + "</a>";
			$("#td_detail").append(innerHtml);
		}
		
		$("#dialog_resource").dialog({
			width:"auto",
			height:"auto",
			position:"bottom",
			draggable:true
		}); 
		return false;
	}
	
	//image 리사이즈
	function resize(img) {
		
		var object = document.getElementById(img);

	    // 원본 이미지 사이즈 저장
	    var width = object.width;
	    var height = object.height;
	    
	    // 가로, 세로 최대 사이즈 설정
	    var maxWidth = 300;
	    var maxHeight = 205;
	    var resizeWidth;
	    var resizeHeight;
	    
	    // 이미지 비율 구하기
	    var basisRatio = maxHeight / maxWidth;
	    var imgRatio = height / width;

	    if (imgRatio > basisRatio) {
	    // height가 기준 비율보다 길다.
	        
	        if (height > maxHeight) {
	            resizeHeight = maxHeight;
	            resizeWidth = Math.round((width * resizeHeight) / height);
	        } else {
	            resizeWidth = width;
	            resizeHeight = height;
	        }
	        
	    } else if (imgRatio < basisRatio) {
	    // width가 기준 비율보다 길다.
	        
	        if (width > maxWidth) {
	            resizeWidth = maxWidth;
	            resizeHeight = Math.round((height * resizeWidth) / width);
	        } else {
	            resizeWidth = width;
	            resizeHeight = height;
	        }
	        
	    } else {
	        // 기준 비율과 동일한 경우
	        resizeWidth = width;
	        resizeHeight = height;
	    }
	    
	    // 리사이즈한 크기로 이미지 크기 다시 지정
	    object.width = resizeWidth;
	    object.height = resizeHeight;
	    
	   
	    
	}

	
	//이미지크게보기
	function popViewImage(idx, iSeq) {	
		var imgWindow = window.open("/origin/view_image.jsp?idx=" + idx + "&i_seq=" + iSeq, "imgWindow", "scrollbars=no,top=10,left=10,width=780,height=480");
		imgWindow.focus();
	} 
		
	//이미지슬라이드
	$(function() {
		//이미지가 한 개일때 롤링 없애기
		if(1 == 1) {	//###################################
			$("#image_list").jQBanner({							//롤링을 할 영역의 ID 값
				nWidth:300,										//영역의 width
				nHeight:250,									//영역의 height
				nCount:1,					//돌아갈 이미지 개수	//###################################
				isActType:"none",								//움직일 방향 (left, right, up, down)
				nOrderNo:1,										//초기 이미지
				isStartAct:"N",
				isStartDelay:"Y",
				nDelay:2000,									//롤링 시간 타임 (1000 = 1초)
				isBtnType:"li"									//라벨(버튼 타입)
			});
		} else {
			$("#image_list").jQBanner({							//롤링을 할 영역의 ID 값
				nWidth:300,										//영역의 width
				nHeight:250,									//영역의 height
				nCount:2,					//돌아갈 이미지 개수	//###################################
				isActType:"left",								//움직일 방향 (left, right, up, down)
				nOrderNo:1,										//초기 이미지
				isStartAct:"N",
				isStartDelay:"Y",
				nDelay:2000,									//롤링 시간 타임 (1000 = 1초)
				isBtnType:"li"									//라벨(버튼 타입)
			});
		}		
	});
	
	function resize_init()
	{
		var imgname='origin_img';
		
		for(var j=0;j<1;j++)	//###################################
		{	
			imgname='origin_img';
			
			imgname = imgname + String(j);
			resize(imgname);
			
		}
		
	}
	
	fnNDSLSearch = function() {
		var strSearch = encodeURIComponent($("#search_form_query0").val());
		
		window.open("http://www.ndsl.kr/brief.do?collectionType=1&vquery=FS:(" + strSearch + ")&equery=&dquery=FS:(" + strSearch + ")&cmd=&orgTxt=" + strSearch + "&hits=100&currpage=1&select_colid=-1&naviMoreCount=100&sortby=py&sortorder=descending&keys=&bexecute_flag=true&isHistorySave=true&kquery=");
		//window.open("http://www.ndsl.kr/brief.do?collectionType=1&vquery=FS:(감자)&equery=&dquery=FS:(감자)&cmd=&orgTxt=감자&hits=100&currpage=1&select_colid=-1&naviMoreCount=100&sortby=py&sortorder=descending&keys=&bexecute_flag=true&isHistorySave=true&kquery=");
	}
	</script>

<body onload="resize_init();">
<div id="wrapperAll">
	<!-- 부위정보 레이어 팝업 -->
	<div class="ui-dialog ui-widget ui-widget-content ui-corner-all ui-draggable ui-resizable" style="display:none;">
		<div class="ui-dialog-titlebar ui-widget-header ui-corner-all ui-helper-clearfix">
			<span id="ui-dialog-title-dialog" class="ui-dialog-title">부위별 상세정보</span>
			<a class="ui-dialog-titlebar-close ui-corner-all" href="#"><span class="ui-icon ui-icon-closethick">close</span></a>
		</div>
		<div style="height: auto; width: auto;" title="부위별 상세정보" class="ui-dialog-content ui-widget-content" id="dialog_part">
			<table id="partInfo" class="dialog_view" style="border:1px; width:400;">
				<colgroup> 
		            <col width="100" />
		            <col width="300" />
		        </colgroup>    
		        <tr>
		            <th>부위</th>
		            <td id="td_partnm"></td>
				</tr>
				<tr>            
		            <th>식용여부</th>
		            <td id="td_edible"></td>
				</tr>
				<tr>            
		            <th>공전등재</th>
		            <td id="td_codex"></td>
				</tr>
				<tr>	            
		            <th>식용근거</th>
		            <td id="td_basis"></td>
		        </tr>
			</table>
		</div>
	</div>
	<!-- 근거자료 레이어 팝업 -->
	<div class="ui-dialog ui-widget ui-widget-content ui-corner-all ui-draggable ui-resizable" style="display:none;">
		<div class="ui-dialog-titlebar ui-widget-header ui-corner-all ui-helper-clearfix">
			<span id="ui-dialog-title-dialog" class="ui-dialog-title">근거자료 상세정보</span>
			<a class="ui-dialog-titlebar-close ui-corner-all" href="#"><span class="ui-icon ui-icon-closethick">close</span></a>
		</div>
		<div style="height: auto; width: auto;" title="근거자료 상세정보" class="ui-dialog-content ui-widget-content" id="dialog_resource">
			<table id="resourceInfo" class="dialog_view" style="border:1px; width:400;">
				<colgroup> 
		            <col width="100" />
		            <col width="300" />
		        </colgroup>    
		        <tr>
		            <th>근거자료</th>
		            <td id="td_title"></td>
				</tr>
				<tr>            
		            <th>상세정보</th>
		            <td id="td_detail"></td>
				</tr>
			</table>
		</div>
	</div>

	<a name="skip_cnt" class="comment">본문 시작</a>
	<div class="search_result">
		<div class="detail_title">상세내역</div>
		<div class="rig">

	<!-- <a href="search_content_detail_eng.jsp?idx=${foodMeterial.indx}&query=${param.query}"><img src="image/btn/btn_eng.gif" title="영문용" alt="영문용" /></a> -->

		
			<a href="foodMeterialDB.do"><img src="image/btn/btn_searchhome.gif" title="검색초기화면" alt="검색초기화면" /></a>
			<img src="image/btn/btn_print.gif" title="프린트" alt="프린트" onclick="MM_openBrWindow('print_detail.jsp?idx=${foodMeterial.indx}','','scrollbars=yes,width=900,height=700')" style="cursor:pointer;"/>
		</div>
	</div>
	
	<div class="boa_view">
		<div class="boa_view2">
			<table summary="기본검색리스트 상세보기">
			<caption>기본검색리스트 상세보기</caption>
			<colgroup>
				<col width="70" />
				<col width="70" />
				<col width="355" />
			</colgroup>			
			<tbody>
				<tr>
					<th scope="col" colspan="2">원재료명</th>
					<td class="red_tine">${foodMeterial.mtral_nm}</td>
				</tr>
				<tr>
					<th scope="col" colspan="2">이명</th>
					<td>${foodMeterial.ncknm_nm}</td>
				</tr>
				<tr>
					<th scope="col" colspan="2">학명</th>
					<td>${foodMeterial.scnm_nm}</td>
				</tr>
				
				<c:if test="${foodMeterial.animal ne '미생물'}">
				<tr>
					<th scope="col" colspan="2">생약명</th>
					<td>${foodMeterial.medi_nm}</td>
				</tr>
				</c:if>
				
				<tr>
					<th scope="col" colspan="2">원재료 분류</th>
					<td>${foodMeterial.animal}
					<c:if test="${foodMeterial.animal_2 eq '수산물'}">(수산물)</c:if>
					</td>
				</tr>
				<tr title='부위를 클릭하면 상세 항목을 확인 할 수 있습니다.' alt='부위를 클릭하면 상세 항목을 확인 할 수 있습니다.'>
					<th scope="col" rowspan="4" style="text-align:center; padding-left:0px;">식용가능<br/>여부</th>
						<th scope="col" style="text-align:center; padding-left:0px;">가능</th>
						<td>
						<c:if test="${fn:length(foodMeterial.possibleList) > 0}">
                     		<c:forEach var="edible" items="${foodMeterial.possibleList}" varStatus="status">
	                     		<c:choose>
	                     			<c:when test="${foodMeterial.animal eq '미생물'}">
	                     				${edible.regn_nm}
	                     			</c:when>
	                     			<c:otherwise>
	                     				<a href="#" onclick="popPartInfoLayer('${edible.regn_nm}', '${empty edible.edible ? '정보없음' : edible.edible}', '${empty edible.cdx ? '정보없음' : edible.cdx}', '${empty edible.basis ? '정보없음' : edible.basis}'); return false;">${edible.regn_nm}</a>
	                     			</c:otherwise>
	                     		</c:choose>
		                     	<c:if test="${status.count < fn:length(foodMeterial.possibleList)}">&nbsp;/&nbsp;</c:if>
	                     	</c:forEach>
	                     </c:if>
						</td>
					</tr>
					<tr title='부위를 클릭하면 상세 항목을 확인 할 수 있습니다.' alt='부위를 클릭하면 상세 항목을 확인 할 수 있습니다.'>		
						<th scope="col" style="text-align:center; padding-left:0px;">제한적</th>
						<td>
						<c:if test="${fn:length(foodMeterial.limitList) > 0}">
                     		<c:forEach var="edible" items="${foodMeterial.limitList}" varStatus="status">
	                     		<c:choose>
	                     			<c:when test="${foodMeterial.animal eq '미생물'}">
	                     				${edible.regn_nm}
	                     			</c:when>
	                     			<c:otherwise>
	                     				<a href="#" onclick="popPartInfoLayer('${edible.regn_nm}', '${empty edible.edible ? '정보없음' : edible.edible}', '${empty edible.cdx ? '정보없음' : edible.cdx}', '${empty edible.basis ? '정보없음' : edible.basis}'); return false;">${edible.regn_nm}</a>
	                     			</c:otherwise>
	                     		</c:choose>
		                     	<c:if test="${status.count < fn:length(foodMeterial.limitList)}">&nbsp;/&nbsp;</c:if>
	                     	</c:forEach>
	                     </c:if>
						</td>
					</tr>
					<tr title='부위를 클릭하면 상세 항목을 확인 할 수 있습니다.' alt='부위를 클릭하면 상세 항목을 확인 할 수 있습니다.'>	
						<th scope="col" style="text-align:center; padding-left:0px;">불가능</th>
						<td>
						<c:if test="${fn:length(foodMeterial.impossibleList) > 0}">
                     		<c:forEach var="edible" items="${foodMeterial.impossibleList}" varStatus="status">
	                     		<c:choose>
	                     			<c:when test="${foodMeterial.animal eq '미생물'}">
	                     				${edible.regn_nm}
	                     			</c:when>
	                     			<c:otherwise>
	                     				<a href="#" onclick="popPartInfoLayer('${edible.regn_nm}', '${empty edible.edible ? '정보없음' : edible.edible}', '${empty edible.cdx ? '정보없음' : edible.cdx}', '${empty edible.basis ? '정보없음' : edible.basis}'); return false;">${edible.regn_nm}</a>
	                     			</c:otherwise>
	                     		</c:choose>
		                     	<c:if test="${status.count < fn:length(foodMeterial.impossibleList)}">&nbsp;/&nbsp;</c:if>
	                     	</c:forEach>
	                     </c:if>
						</td>
				</tr>
					<tr>
					  <th colspan="2" class="info" style="text-align:center; vertical-align:middle; padding-top:5px;" scope="col">※ <span class="info_f">해당부위</span>를 클릭하시면 부위별 상세정보를 확인 할 수 있습니다.</th>
			  </tr>

			 </tbody>
			</table>
		</div>
		
		<c:if test="${foodMeterial.animal eq '미생물'}">
  <table>
  <tr>
	<td height="20"></td>
  </tr>
  </table>
		</c:if>
		
		<div id="image_list" class="wrapBannerScreen">
			<div class="clsBannerScreen">
			<img src="/images/common/Noimg.gif" width="300" height="206"  border="0" />
			</div>
            <div class="pic_txt"><span class="green">클릭</span>하시면 원래 크기로 보실 수 있습니다.</div>
		</div>
		
	</div>
	
	<div class="boa_view1">	 
		<table summary="기본검색리스트 상세보기">
		<caption>기본검색리스트 상세보기</caption>
		<colgroup>
			<col width="140" />
			<col width="677" />
		</colgroup>			
		<tbody>
			<tr>
				<th scope="col">특성/분포</th>
				<td>${foodMeterial.chartr}</td>
			</tr>
			<tr>
				<th scope="col">주요성분(부위별)</th>
				<td>${foodMeterial.cmpn}</td>
			</tr>
			<tr>
				<th scope="col">안전성/독성</th>
				<td>${foodMeterial.toxcty}</td>
			</tr>
			<tr>
				<th scope="col">식용외 용도<br/>(이용부위)</th>
				<td>${foodMeterial.util}</td>
			</tr>
			
			<c:choose>
				<c:when test="${foodMeterial.animal eq '미생물'}">
			<tr>
				<th scope="col">식용용도</th>
				<td>${foodMeterial.edible_use}</td>
			</tr>		
			<tr>
				<th scope="col">기원</th>
				<td>${foodMeterial.genss}</td>
			</tr>		
				</c:when>
				<c:otherwise>
			<tr>
				<th scope="col">기타</th>
				<td>${foodMeterial.etc}</td>
			</tr>
			<tr>
				<th scope="col">근거자료</th>
				<td>

				</td>
			</tr>
				</c:otherwise>
			</c:choose>
			
			<tr>
				<th scope="col">최종수정일</th>
				<td>${foodMeterial.last_updt_dtm}</td>
			</tr>
			<tr>
				<th scope="col" Style="padding-left:13px;"><img src="images/srch/tit_ndsl_search.gif" /></th>
				<td>		
					<form name="searchWidgetForm" action="" style="margin-bottom:7px;">							
						<input id="search_form_query0" type="text" value="" size="30" onKeyPress="if(event.keyCode==13){fnNDSLSearch(); return false;}">
						<input type="button" id="strSearch" value="검색" onclick="fnNDSLSearch(); return false;"/>
					</form>
                    <span>※ NDSL(과학기술정보 서비스 플랫폼)의 검색 서비스를 이용하고 싶으신 분은 검색을 클릭하세요.</span>
				</td>
			</tr>
		 </tbody>
		</table>
	</div>

</div>
</body> 