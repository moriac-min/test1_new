<%@ page language="java" contentType="text/html; charset=utf-8"
%><%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"
%><%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"
%><%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" 
%><%@ taglib prefix="m" uri="/WEB-INF/tlds/message.tld"
%><%@ page import="foodportal.common.util.Message"
%>
<c:set var="contextPath" scope="request">${pageContext.request.contextPath}</c:set>


 <div class="related">
     <h2>아래 게시글도 확인해 보세요!</h2>
     <ul class="items">
         <li>
             <a href="#"><img src="${contextPath}/img/sample-112x112.png" alt="">
             <span>쌀밥은 웰빙식...누가 당뇨 원흉이라 하는가</span>
             </a>
         </li>
         <li>
             <a href="#"><img src="${contextPath}/img/sample-112x112.png" alt="">
             <span>쌀밥은 웰빙식...누가 당뇨 원흉이라 하는가</span>
             </a>
         </li>
         <li>
             <a href="#"><img src="${contextPath}/img/sample-112x112.png" alt="">
             <span>쌀밥은 웰빙식...누가 당뇨 원흉이라 하는가</span>
             </a>
         </li>
         <li>
             <a href="#"><img src="${contextPath}/img/sample-112x112.png" alt="">
             <span>쌀밥은 웰빙식...누가 당뇨 원흉이라 하는가</span>
             </a>
         </li>
         <li>
             <a href="#"><img src="${contextPath}/img/sample-112x112.png" alt="">
             <span>쌀밥은 웰빙식...누가 당뇨 원흉이라 하는가</span>
             </a>
         </li>
     </ul>
 </div>
             