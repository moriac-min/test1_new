<%@page language="java" contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

	<section>
      <div id="header">
          <div class="board-head">
              <ol class="breadcrumb">
              		<li id="menuTree"></li>
                  <li><a href="#">홈</a></li>
                  <li><a href="#" onclick="bbb(); return false;">1399소비자신고</a></li>
                  
                  <li><a href="#" onclick="aaa(); return false;">업체이물신고접수</a></li>
              </ol>
              <h1>업체이물신고접수</h1>
          </div>
      </div>
      <div class="page-container">
      	<!-- 페이지 내용 -->
          <article>
			<iframe name="civilFrame" src="http://localhost/websquare/websquare.html?w2xPath=/ui/foodportal/admin/systemmngt/BoardMngt.xml" style="border:solid 0px gray;" width="100%;" height="700px;"></iframe>
          </article>
      </div>
      <script>
      
      function bbb(){
     	 
     	 civilFrame.document.getElementById('textbox9').innerHTML='사이트오분';
      }
         
      function aaa(){
     	 
     	 civilFrame.document.getElementById('textbox9').innerHTML='사이트십분';
      }

      
      </script>
  </section>