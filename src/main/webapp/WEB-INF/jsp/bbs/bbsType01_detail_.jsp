<%@ page language="java" contentType="text/html; charset=utf-8"
%><%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"
%><%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"
%><%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" 
%><%@ taglib prefix="m" uri="/WEB-INF/tlds/message.tld"
%><%@ page import="foodportal.common.util.Message"
%>
<c:set var="contextPath" scope="request">${pageContext.request.contextPath}</c:set>

<form name="boardDetailForm" id="boardDetailForm" onkeydown="return false;" onkeypress="return false;">
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
             <!-- 
             <p class="excerpt">국내에서 이미 유통된 식품 중 기준.규격에 부적합해 회수 및 판매중지된 제품을 공개합니다.<br>
                 소비자는 해당제품을 구입장소에 되돌려주시고 판매자는 해당식품 판매를 중지하시고 회수업체에 반품하시기 바랍니다.</p>
              -->    
         </div>
     </div>
     <div class="view-container">
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
             <div class="article-body">
                 <div class="post">
                     ${boardDetail.bdt}
                 </div>
                 <div class="caution">해당 정보를 무단으로 복제하거나 이용하는 경우 저작권법 등에 따라 법적책임을 질 수 있습니다.</div>
                 <div class="like"><a href="javascript:addLike();" class="btn btn-default btn-lg" role="button"><span class="icon-heart-empty">좋아요</span>  <span id="rtrvl_cnt">${boardDetail.rtrvl_cnt}</span></a></div>   
                 <!-- <div class="tag-wrap"><a href="#" class="tag">당뇨</a>, <a href="#" class="tag">당테크</a>, <a href="#" class="tag">당뇨병</a>, <a href="#" class="tag">성인병</a>, <a href="#" class="tag">혈당</a>, <a href="#" class="tag">40대</a></div> --> 
                 <div class="board-footer">
                     <a href="javascript:viewDetail('${boardDetail.pre_ntctxt_no}');" class="btn btn-default btn-left" role="button">이전글</a> 
                     <a href="javascript:viewDetail('${boardDetail.post_ntctxt_no}');" class="btn btn-default btn-left" role="button">다음글</a> 
                     <a href="javascript:moveBoardList();" class="btn btn-default btn-right" role="button">목록</a> 
                 </div>
                 <div class="related">
                     <h2>아래 게시글도 확인해 보세요!</h2>
                     <ul class="items">
                         <li>
                             <a href="#"><img src="../../img/sample-112x112.png" alt="">
                             <span>쌀밥은 웰빙식...누가 당뇨 원흉이라 하는가</span>
                             </a>
                         </li>
                         <li>
                             <a href="#"><img src="../../img/sample-112x112.png" alt="">
                             <span>쌀밥은 웰빙식...누가 당뇨 원흉이라 하는가</span>
                             </a>
                         </li>
                         <li>
                             <a href="#"><img src="../../img/sample-112x112.png" alt="">
                             <span>쌀밥은 웰빙식...누가 당뇨 원흉이라 하는가</span>
                             </a>
                         </li>
                         <li>
                             <a href="#"><img src="../../img/sample-112x112.png" alt="">
                             <span>쌀밥은 웰빙식...누가 당뇨 원흉이라 하는가</span>
                             </a>
                         </li>
                         <li>
                             <a href="#"><img src="../../img/sample-112x112.png" alt="">
                             <span>쌀밥은 웰빙식...누가 당뇨 원흉이라 하는가</span>
                             </a>
                         </li>
                     </ul>
                 </div>
             </div>
         </article>
         <aside>
         	<div class="launch">
                 <ul>
                     <li><a href="#">Reuters(US)</a></li>
                 </ul>
             </div>
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
                     <li>
                         <a href="#">어린이건강메뉴 – 한국식 오코노미야끼</a>
                         <span>2014.10.28</span>
                     </li> 
                     <li>
                         <a href="#">봄나물 바로알기 – 가득 봄 내음 물씬 나는 봄나물 예찬</a>
                         <span>2014.10.28</span>
                     </li> 
                     <li>
                         <a href="#">식중독균 이런 것들이 있어요</a>
                         <span>2014.10.28</span>
                     </li> 
                     <li>
                         <a href="#">여름철 음식관리법과 휴가지 음식관리요령</a>
                         <span>2014.10.28</span>
                     </li> 
                     <li>
                         <a href="#">무리한 다이어트의 역효과, 식사장애 </a>
                         <span>2014.10.28</span>
                     </li> 
                 </ul>
             </div>
             <div class="widget">
                 <h2 class="popular">인기게시글</h2>
                 <ul class="wt-list">
                     <li>
                         <a href="#">어린이건강메뉴 – 한국식 오코노미야끼</a>
                         <span>2014.10.28</span>
                     </li> 
                     <li>
                         <a href="#">봄나물 바로알기 – 가득 봄 내음 물씬 나는 봄나물 예찬</a>
                         <span>2014.10.28</span>
                     </li> 
                     <li>
                         <a href="#">식중독균 이런 것들이 있어요</a>
                         <span>2014.10.28</span>
                     </li> 
                     <li>
                         <a href="#">여름철 음식관리법과 휴가지 음식관리요령</a>
                         <span>2014.10.28</span>
                     </li> 
                     <li>
                         <a href="#">무리한 다이어트의 역효과, 식사장애 </a>
                         <span>2014.10.28</span>
                     </li> 
                 </ul>
             </div>
             <div class="widget">
                 <h2 class="reporter">공감리포터</h2>
                 <ul class="wt-thumbnail">
                     <li>
                         <img src="../../img/sample-77x77.png" alt="어린이건강메뉴 – 한국식 오코노미야끼"> 
                         <a href="#">어린이건강메뉴 – 한국식 오코노미야끼</a>
                         <span>2014.10.28</span>
                     </li> 
                     <li>
                         <img src="../../img/sample-77x77.png" alt="봄나물 바로알기 – 가득 봄 내음 물씬 나는 봄나물 예찬"> 
                         <a href="#">봄나물 바로알기 – 가득 봄 내음 물씬 나는 봄나물 예찬</a>
                         <span>2014.10.28</span>
                     </li> 
                     <li>
                         <img src="../../img/sample-77x77.png" alt="식중독균 이런 것들이 있어요"> 
                         <a href="#">식중독균 이런 것들이 있어요</a>
                         <span>2014.10.28</span>
                     </li> 
                 </ul>
             </div>
         </aside>
     </div>
 </section>
</form>

  
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
    	 
    	 document.boardDetailForm.action="${contextPath}/portal/board/downloadAttchdFile.do";
         document.boardDetailForm.target="_self";
         document.boardDetailForm.submit();
         
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
                alert("실패코드 : " + request.status+"\n메세지 : " + request.error);
            }
        });
    }
    
    //상세페이지이동
    function viewDetail(ntctxt_no){
        
        $('#ntctxt_no').val(ntctxt_no);
        
        document.boardDetailForm.action="${contextPath}/portal/board/boardDetail.do";
        document.boardDetailForm.target="_self";
        document.boardDetailForm.method="post";
        document.boardDetailForm.submit();
    }
    
    //목록으로 이동
    function moveBoardList(){
    	document.boardDetailForm.action="${contextPath}/portal/board/board.do";
        document.boardDetailForm.target="_self";
        document.boardDetailForm.method="post";
        document.boardDetailForm.submit();
    }
</script>