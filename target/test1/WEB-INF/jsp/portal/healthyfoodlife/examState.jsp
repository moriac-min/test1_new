<%@page language="java" contentType="text/html; charset=utf-8"
%><%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"
%><%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"
%><%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"
%><%@ taglib prefix="m" uri="/WEB-INF/tlds/message.tld"
%><%@ page import="foodportal.common.util.Message"

<table summary="">
  <caption></caption>
  <colgroup>
      <col style="width:60px;">      
      <col style="width:60px;">
      <col style="width:90px;">
      <col style="width:90px;">
      <col style="width:60px;">
  </colgroup>
  <thead>
      <tr>
          <th scope="col">번호</th>      
          <th scope="col">지정번호</th>
          <th scope="col">지정날짜</th>
          <th scope="col">기관명</th>
          <th scope="col">소재지</th>
      </tr>
  </thead>
  <tbody id="listFrame">
      
  </tbody>
</table>
   
<script>

function fn_drawList(list){
	var listLangth = list.length;
	var content = "";
	
	for(var i=0; i<listLangth; i++){
		content += "<tr>";
		content += "<td scope='row' class='num'>"+list[i].no+"</td>";
		if(list[i].ctgrynm != ''){
			content += "<td>"+list[i].ctgrynm+"</td>";	
		}
		content += "<td class='subject'><a href='javascript:viewDetail("+list[i].ntctxt_no+");'>"+list[i].titl+"</a></td>";
		content += "<td>"+list[i].last_updtr_id+"</td>";
		content += "<td class='num'>"+list[i].cret_dtm+"</td>";
		content += "<td class='num'>"+list[i].inqry_cnt+"</td>";
	}
	
	document.getElementById("listFrame").innerHTML = content;
}
</script>

<section>

	


	
	<c:set var="contextPath" scope="request">${pageContext.request.contextPath}</c:set>
	<input type="hidden" id="show_cnt" name="show_cnt"/>
	<input type="hidden" id="start_idx" name="start_idx">
			
			<fieldset>
				<legend>심사현황 검색</legend>
				<div class="searchBoxW">
			
					<div class="searchBox">
						<p class="searchImg"></p>
			
						<div class="searchCn">
							<dl class="searchCon">
			
								<dt><label for="inspect_tree_1">작 물 명</label></dt>
								<dd>
			
			
									<select name="inspect_tree_1" id="inspect_tree_1">
										<option value=''>----------선택---------</option>
									<%-- <%
										for(int i=0; i<inspect_tree_1_list.size(); i++){
											BdInspect tree1 = inspect_tree_1_list.get(i);
									%> --%>
						            	<option value='test1-1' selected=''>test1-1</option>
						            	<option value='test1-2' selected=''>test1-2</option>
						            	<option value='test1-3' selected=''>test1-3</option>
						            	<option value='test1-4' selected=''>test1-4</option>
						            	<%--<option value='<%=tree1.getInspect_1()%>'<%if(Utility.getNull(param.getInspect_tree_1()).equals(tree1.getInspect_1())){%> selected="selected"<%}%>><%=tree1.getInspect_1_name()%></option>
						             <%
										}
						            %> --%>
									</select>
								</dd>
								<dt><label for="title">제 품 명</label></dt>
								<dd><input type="text" class="inputText" title="검색" maxlength="100" size="30" name="title" id="title" value="" /></dd>
							</dl>
							<dl class="searchCon">
									<dt><label for="chracter">특 &nbsp;&nbsp;&nbsp;성</label></dt>
									<dd>
									<select name="chracter" id="chracter" style="width:400px;">
						            	<option value=''>----------선택---------</option>
									<%-- <%
										for(int j=0; j<chracter_list.size(); j++){
											BdInspect chracter = chracter_list.get(j);
									%> --%>
									<option value='test2-1' selected=''>test2-1</option>
									<option value='test2-2' selected=''>test2-2</option>
									<option value='test2-3' selected=''>test2-3</option>
									<option value='test2-4' selected=''>test2-4</option>
						            <%--	<option value='<%=chracter.getCategory_code()%>'<%if(Utility.getNull(param.getChracter()).equals(chracter.getCategory_code())){%> selected="selected"<%}%>><%=chracter.getName()%></option>
									 <%
										}
									%> --%>
									</select>
									</dd>
							</dl>
							<dl class="searchCon">
									<dt><label for="gene">삽입유전자</label></dt>
									<dd><select name="gene" id="gene">
						            	<option value=''>----------선택---------</option>
						          <%--   <%
										for(int k=0; k<gene_list.size(); k++){
											BdInspect gene = gene_list.get(k);
									%> --%>
									<option value='test3-1' selected=''>test3-1</option>  
									<option value='test3-2' selected=''>test3-2</option>  
									<option value='test3-3' selected=''>test3-3</option>  
									<option value='test3-4' selected=''>test3-4</option>  
						            	<%--<option value='<%=gene.getCategory_code()%>'<%if(Utility.getNull(param.getGene()).equals(gene.getCategory_code())){%> selected="selected"<%}%>><%=gene.getName()%></option>
									 <%
										}
									%> --%>
									</select>
									</dd>
							</dl>
								<dl class="searchCon">
			
									<dt><label  for="requester">신 청 자</label></dt>
									<dd><select name="requester" id="requester">
						            	<option value=''>----------선택---------</option>
						            <%-- <%
										for(int l=0; l<requester_list.size(); l++){
											BdInspect req_list = requester_list.get(l);
									%> --%>
									<option value='test4-1' selected=''>test4-1</option>
									<option value='test4-2' selected=''>test4-2</option>
									<option value='test4-3' selected=''>test4-3</option>
									<option value='test4-4' selected=''>test4-4</option>
									
						            <%-- 	<option value='<%=req_list.getCategory_code()%>'<%if(Utility.getNull(param.getRequester()).equals(req_list.getCategory_code())){%> selected="selected"<%}%>><%=req_list.getName()%></option>
									<%
										}
									%> --%>
									</select>
									</dd>
								</dl>
							</div>
			
						</div>
			
						<div class="btn_searchP">
							<a href="javascript:searchList();" class="btn btn-default" role="button">검색</a>
							<a href="${contextPath}/popup/commonPopup/fileUpload.do?uploadSource=complain" class="fileUpload fancybox.iframe btn btn-success btn-sm">파일 업로드</a>
							<span class="btn2"><input type="reset" alt="초기화" id="defaultSetBtn"  value="초기화" onclick="fn_Default();"/></span>
						</div>
				</div>
			</fieldset>
		
		<!-- 총 글수 및 페이지 정보 시작 -->
		<div class="boardListInfo">
			<span class="total">총 <em id="total_cnt"></em> 건</span>
			<span class="page">현재페이지 : <em id="current_idx"></em> </span>
		</div>
		<!-- 총 글수 및 페이지 정보 끝 -->
		
		
		<table class="boardList" summary="GMO(유전자 재조합) 심사현황을 위한 게시판">
		<colgroup>
			<col width="8%"/>
			<col width="10%"/>
			<col width="10%"/>
			<col width="10%"/>
			<col width="15%"/>
			<col width="13%"/>
			<col width="12%"/>
			<col width="10%"/>
			<col width="12%"/>
		</colgroup>
			<thead>
	        	<tr>
	        		<th class="first-child" scope="col">번호</th>
	        		<th scope="col">구분</th>
	        		<th scope="col">분류</th>
	        		<th scope="col">제품명</th>
	        		<th scope="col">특성</th>
	        		<th scope="col">삽입유전자</th>
	        		<th scope="col">신청자</th>
	        		<th scope="col">진행<br/>상황</th>
	        		<th class="last-child" scope="col">심사결과<br/>보고서</th>
	        	</tr>
	        </thead>
	         <tbody id="gmoList">         
	         
	         </tbody>
		</table>
		
		<div class="board-footer">
        	<div class="pagination"></div>
    	</div>

</section>

<script type="text/javascript">

	/****************************************
	 * Variable
	****************************************/
	var total_cnt_onPage = 0;
	var show_cnt_onPage = 0;

	/****************************************
	 * Init
	****************************************/
	
	$(document).ready(function(){
		if('${boardSetting.show_cnt}' != ""){
	        $('#show_cnt').val('${boardSetting.show_cnt}');
	    }
		if ($('#show_cnt').val() == ""){
			$('#show_cnt').val('10');
		}
		
		
		$('#start_idx').val("1");
		
		searchList();
	});
	
	/****************************************
	 * Button Action
	 ****************************************/
	
	
	
	 /****************************************
	 * Function
	 ****************************************/
	 function searchList(){
		//특수문자제거
		 fn_replaceSpecialChar('#title');
		
		var str = $('#baseForm').serialize();
		
		
		
		$.ajax({
			data : $('#baseForm').serialize(),
			dataType : 'json',
			type : 'POST',
			url : "${contextPath}/portal/healthyfoodlife/searchExamStateList.do",
			success : function(arg){
				
				//total 개수
				total_cnt_onPage = arg.total_cnt;
				$('#total_cnt').text(total_cnt_onPage);
				$('#current_idx').text($('#start_idx').val());
				
				//페이징 세팅
				setPaginationVars();
				
				var list = new Array();
				list = arg.list;
				
				fn_drawList(list);
				
			},
			error : function(request, status, error){
				alert("실패코드 : " + request.status + "\n메세지 : " + request.error);
			}
		});
	 }
	 
	 function fn_drawList(list){
		 
		 var listLength = list.length;
		 var content = "";
		 var fileList = null;
		 
		 for(var i = 0; i < listLength; i++){			
			 content += "<tr>";
			 content += "";
			 content += "<td id='sadfasdf'><a href=\"/portal/healthyfoodlife/examStateDetail.do?search_keyword="+list[i].report_esntl_idntfc_no+"\">"+list[i].no+"</a></td>";
			 content += "";
			 content += "<td>"+list[i].othbc_vilt_cn +"</td>";
			 content += "<td>"+list[i].dsps_stdr_cd_nm +"</td>";
			 content += "<td>"+list[i].bssh_nm+"</td>";
			 content += "<td>"+list[i].prdt_nm+"</td>";
			 content += "<td>"+list[i].admst_dsps_dt+"</td>";
			 content += "<td>"+list[i].bssh_nm+"</td>";
			 content += "<td></td>";
			 content += "<td></td>";			 
			 content += "</tr>";
		 }
		 
		 $('#gmoList').html(content);
		 
		
	 }
	 
	//페이징 변수셋팅
	    function setPaginationVars(){
	         show_cnt_onPage = $('#show_cnt').val();
	         
	         $('.pagination').pagination("updateItems", total_cnt_onPage);
	         $('.pagination').pagination("updateItemsOnPage", show_cnt_onPage);
	         var pageNum = $('#start_idx').val();
	         if(pageNum == null || pageNum == ''){
	             pageNum = 1;
	         }
	         
	         $('.pagination').pagination('drawPage', pageNum);
	     }
	
	    //페이징
		 $(function(){
			 $('.pagination').pagination({
			        items: total_cnt_onPage,
			        itemsOnPage: show_cnt_onPage,
			        cssStyle: 'compact-theme'
			  });
		 });
		
	    
	    $('.pagination').click(function(){
	        var page = $('.pagination').pagination('getCurrentPage');
	        if($('#start_idx').val() != page){
	            $('#start_idx').val(page);
	            searchList();
	        }
	        return false;
	    });
	    
	    function fn_moveDetail(report_no){
	    	alert("enter");
	    	var action  = '${contextPath}/popup/examStateDetail.do?search_keyword='+report_no;
	        
	        $(".openinfo").fancybox({
	        	maxWidth    : 830,
	            maxHeight   : 740,
	            minHeight   : 740,
	            fitToView   : false,
	            width       : '70%',
	            height      : '80%',
	            autoSize    : false,
	            closeClick  : false,
	            openEffect  : 'fade',
	            closeEffect : 'fade',
	            href        : action
	        });	        
	    }
	    
	    function fn_Default(){5
	   	 $('#gmoList').html("");
	    	arg = null;
	    	
	    	
	    }
	 
</script>