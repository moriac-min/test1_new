<%@ page language="java" contentType="text/html; charset=utf-8"
%><%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"
%><%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"
%><%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" 
%><%@ taglib prefix="m" uri="/WEB-INF/tlds/message.tld"
%><%@ page import="foodportal.common.util.Message"
%>
<c:set var="contextPath" scope="request">${pageContext.request.contextPath}</c:set>

 <aside>
 	<c:if test="${boardSetting.orgnl_view_use_yn == 'Y'}">
  	<div class="launch">
        <ul>
            <li><a href="${boardDetail.orgnl_url}">Reuters(US)</a></li>
        </ul>
    </div>
    </c:if>
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