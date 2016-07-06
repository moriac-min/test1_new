<%@ page language="java" contentType="text/html; charset=utf-8"
%><%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"
%><%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"
%><%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" 
%><%@ taglib prefix="m" uri="/WEB-INF/tlds/message.tld"
%><%@ page import="foodportal.common.util.Message"
%>
<c:set var="contextPath" scope="request">${pageContext.request.contextPath}</c:set>

<!-- <form name="boardDetailForm" id="boardDetailForm" onkeydown="return false;" onkeypress="return false;"> -->
<input type="hidden" id="bbs_no" name="bbs_no" value="${boardSetting.bbs_no}">               <!-- 게시판번호 -->
<input type="hidden" id="ntctxt_no" name="ntctxt_no" value="${boardDetail.ntctxt_no}">      <!-- 글번호 -->

<input type="hidden" id="file_path" name="file_path">               <!-- 파일경로 -->
<input type="hidden" id="physic_file_nm" name="physic_file_nm">     <!-- 물리파일명 -->
<input type="hidden" id="logic_file_nm" name="logic_file_nm">       <!-- 논리파일명 -->
<input type="hidden" id="file_type_cd" name="file_type_cd">         <!-- 확장자 -->

<section>
     <div id="header">
        <div class="board-head">
            <div class="lnb-viewer" id="nav-open-btn" href="#left-nav">Menu</div>
              <ol class="breadcrumb">
                  <li><a href="#">홈</a></li>
		          <li><a href="#">메뉴경로</a></li>
		          <li><a href="#">메뉴경로</a></li>
		          <li class="active">메뉴명</li>
              </ol>
              <h1>${boardSetting.menu_nm}</h1>
    	</div>
 	 </div>

 	 <c:if test="${boardSetting.bbs_type_cd == '06'}">
 	 <div class="view-container video-container">
     </c:if>
     <c:if test="${boardSetting.bbs_type_cd != '06'}">
     <div class="view-container">
     </c:if>
		<article>
			<div class="article-head">
          		<!-- <div class="category">음료/커피/차</div> -->
          		<h2>${boardDetail.titl}</h2>
          		<div class="meta">${boardDetail.last_updt_dtm} <span class="writer">${boardDetail.last_updtr_id}</span><span class="view">${boardDetail.inqry_cnt}</span></div>
      		</div>
      		<c:if test="${fileUploadList != null and fn:length(fileUploadList) > 0}">
       		<div class="attached-file">
           		<ul>
                	<c:forEach var="fileUploadList" items="${fileUploadList}">
                  	<li><a href="javascript:downloadFile('${fileUploadList.file_path}', '${fileUploadList.physic_file_nm}', '${fileUploadList.logic_file_nm}', '${fileUploadList.file_type_cd}')">${fileUploadList.logic_file_nm}</a> <span class="file-size">${fileUploadList.file_mg} KB</span></li>
               		</c:forEach>
           		</ul>
       		</div>
      		</c:if>
          
     	<!--=========== 실제 컨텐츠 페이지 ================-->
     	<jsp:include page="${boardSetting.bbs_templet_nm}"></jsp:include>
        <%--<jsp:include page="bbsType03_detail.jsp"></jsp:include> --%>
        <!-- ========================================= -->
        
        <c:if test="${boardSetting.bbs_type_cd == '06'}">
        <aside class="vertical">
           <ul class="share">
             <li><a href="javascript:print();" class="print">프린트</a></li>
             <li><a href="#" class="email">이메일</a></li>
             <li><a href="#" class="fb">페이스북</a></li>
             <li><a href="#" class="tw">트위터</a></li>
             <li><a href="#" class="url">URL보내기</a></li>
           </ul>
        </aside>
        </c:if>
       
        </article>
        <c:if test="${boardSetting.bbs_type_cd != '06'}">
        <jsp:include page="asideFrame.jsp"></jsp:include>
        </c:if>
     </div>
 </section>
<!-- </form> -->
  
<script type="text/javascript">

    /****************************************
     * Variable
    ****************************************/
    
    /****************************************
     * Init
    ****************************************/
    $(document).ready(function(){
        
    }); 
    
    /****************************************
     * Button Action
     ****************************************/
     
    /****************************************
     * Function
     ****************************************/
     function downloadFile(file_path, physic_file_nm, logic_file_nm, file_type_cd){
    	
    	 $('#file_path').val(file_path);
    	 $('#physic_file_nm').val(physic_file_nm);
    	 $('#logic_file_nm').val(logic_file_nm);
    	 $('#file_type_cd').val(file_type_cd);
    	 
    	 document.baseForm.action="${contextPath}/portal/board/downloadAttchdFile.do";
         document.baseForm.target="_self";
         document.baseForm.submit();
         
    } 
    
    function addLike(){
    	
    	$.ajax({ 
            data: {ntctxt_no : $('#ntctxt_no').val()
                    },
            dataType:'json', 
            type:'POST',
            url:"${contextPath}/portal/board/addLike.do", 
            success:function(cnt){
            	
                if(cnt == 0){
                	alert('${m:getMessage("msg.common.system.error")}');   //시스템에러
                }
                if(cnt == 1){
                    alert('${m:getMessage("msg.board.addLike")}');          //성공
                    $('#rtrvl_cnt').val(parseInt('${boardDetail.rtrvl_cnt}')+cnt);
                }
                if(cnt == 2){
                    alert('${m:getMessage("msg.board.addLike.dup")}');      //중복추천
                }
            },
            error:function(request,status,error){
                alert("실패코드1111 : " + request.status+"\n메세지 : " + request.error);
            }
        });
    }
    
    //상세페이지이동
    function viewDetail(ntctxt_no){
        
        $('#ntctxt_no').val(ntctxt_no);
        
        document.baseForm.action="${contextPath}/portal/board/boardDetail.do";
        document.baseForm.target="_self";
        document.baseForm.method="post";
        document.baseForm.submit();
    }
    
    //목록으로 이동
    function moveBoardList(){
    	document.baseForm.action="${contextPath}/portal/board/board.do";
        document.baseForm.target="_self";
        document.baseForm.method="post";
        document.baseForm.submit();
    }
</script>