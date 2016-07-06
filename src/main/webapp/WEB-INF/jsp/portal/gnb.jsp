<%@page language="java" contentType="text/html; charset=utf-8"
%><%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"
%><%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"
%><%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"
%><%@ taglib prefix="m" uri="/WEB-INF/tlds/message.tld"
%><%@ page import="foodportal.common.util.Message"
%>

<c:set var="contextPath" scope="request">${pageContext.request.contextPath}</c:set>

 <nav id="gnb" class="gnb">
       <ul id="top-nav">
           <li class="on"> <a href="/portal/main.do" class="home">Home</a> </li>
           
           <li> <a href="${gnbMap.MENU_GRP03}"><span class="icon-01">식품위해정보</span></a>
               <div class="sub-nav bg453">
                   <div class="sub-nav-items row">
                       <div class="col-md-4">
                           <div class="sub-nav-item">
                               <div class="sub-nav-item-header"><a href="/">회수&middot;판매중지</a></div>
                           </div>
                           <div class="sub-nav-item">
                               <div class="sub-nav-item-header"><a href="/">해외식품회수</a></div>
                           </div>
                           <div class="sub-nav-item">
                               <div class="sub-nav-item-header"><a href="/">검사부적합</a></div>
                               <ul class="sub-nav-item-menu">
                                   <li> <a href="/">국내</a> </li>
                                   <li> <a href="/">해외</a> </li>
                               </ul>
                           </div>
                           <div class="sub-nav-item">
                               <div class="sub-nav-item-header"><a href="/">행정처분</a></div>
                           </div>
                           <div class="sub-nav-item">
                               <div class="sub-nav-item-header"><a href="/">허위과대광고</a></div>
                           </div>
                           <div class="sub-nav-item">
                               <div class="sub-nav-item-header"><a href="/">원산지표시위반</a></div>
                               <ul class="sub-nav-item-menu">
                                   <li> <a href="/">농산물원산지표시위반</a> </li>
                                   <li> <a href="/">수산물원산지표시위반</a> </li>
                               </ul>
                           </div>
                       </div>
                       <div class="col-md-5">
                           <div class="sub-nav-item map">
                               <div class="sub-nav-item-header"><a href="/">위해정보공개현황</a></div>
                               <div class="sub-nav-item-map"></div>
                               <ul class="sub-nav-item-list">
                                   <li> 식품회수 <span class="badge">110</span> </li>
                                   <li> 검사부적합 <span class="badge">201</span> </li>
                                   <li> 행정처분 <span class="badge">200</span> </li>
                                   <li> 허위과대광고 <span class="badge">300</span> </li>
                                   <li> 표시위반 <span class="badge">130</span> </li>
                                   <li><a href="/" class="btn btn-default btn-sm">지역별 위해정보공개현황</a></li>
                               </ul>
                           </div>
                       </div>
                       <div class="col-md-3">
                           <div class="sub-nav-item">
                               <div class="sub-nav-item-header"><a href="/">식품분야 검사기관</a></div>
                               <ul class="sub-nav-item-list">
                                   <li> <a href="/">식품위생검사기관</a> </li>
                                   <li> <a href="/">축산물위생검사기관</a> </li>
                                   <li> <a href="/">국외검사기관</a> </li>
                               </ul>
                           </div>
                           <a href="/" class="btn btn-default">한국식품위생검사기관협회</a>
                       </div>
                   </div>
               </div>
           </li>
           <li> <a href="${gnbMap.MENU_GRP04}"><span class="icon-02">이슈와 뉴스</span></a>
               <div class="sub-nav bg543" >
                   <div class="sub-nav-items row">
                       <div class="col-md-5">
                           <div class="sub-nav-item">
                               <div class="sub-nav-item-header"><a href="/">이슈타임라인</a></div>
                               <ul class="sub-nav-item-menu">
                                   <li> <a href="/">핫이슈</a> </li>
                                   <li> <a href="/">식품안전</a> </li>
                                   <li> <a href="/">식품영양</a> </li>
                                   <li> <a href="/">농축수산</a> </li>
                               </ul>
                               <ul class="sub-nav-item-photo">
                                   <li> <a href="/"><span class="new">new</span><img src="../../img/sample-100x100.png" alt=""> <span>방사능</span></a> </li>
                                   <li> <a href="/"><img src="../../img/sample-100x100.png" alt=""> <span>조류인플루엔자</span></a> </li>
                                   <li> <a href="/"><img src="../../img/sample-100x100.png" alt=""> <span>GMO</span></a> </li>
                                   <li> <a href="/"><img src="../../img/sample-100x100.png" alt=""> <span>식중독</span></a> </li>
                               </ul>
                           </div>
                       </div>
                       <div class="col-md-4">
                           <div class="sub-nav-item">
                               <div class="sub-nav-item-header"><a href="/">식품안전뉴스</a></div>
                               <ul class="sub-nav-item-menu">
                                   <li> <a href="/">투데이뉴스</a> </li>
                                   <li> <a href="/">가공식품</a> </li>
                                   <li> <a href="/">건강기능식품</a> </li>
                                   <li> <a href="/">농축수산물</a> </li>
                                   <li> <a href="/">기타</a> </li>
                               </ul>
                           </div>
                           <div class="sub-nav-item">
                               <div class="sub-nav-item-header"><a href="/">식약처소식</a></div>
                               <ul class="sub-nav-item-menu">
                                   <li> <a href="/">정책소식</a> </li>
                                   <li> <a href="/">포토뉴스</a> </li>
                                   <li> <a href="/">보도자료</a> </li>
                                   <li> <a href="/">언론보도해명</a> </li>
                               </ul>
                           </div>
                           <div class="sub-nav-item">
                               <div class="sub-nav-item-header"><a href="/">생활뉴스</a></div>
                           </div>
                           <div class="sub-nav-item">
                               <div class="sub-nav-item-header"><a href="/">식중독지수</a></div>
                           </div>
                           </div-->
                       </div>
                       <div class="col-md-3 photo">
                           <div class="sub-nav-item center">
                               <ul class="sub-nav-item-photo photo">
                                   <li> <a href="/"><img src="../../img/sample-photo.png" alt=""> 
                                   <div class="photo-shadow"></div>
                                   <span>세계마약퇴치의 날 기념식</span></a> </li>
                               </ul>
                           </div>
                       </div>
                   </div>
               </div>
           </li>
           <li> <a href="${gnbMap.MENU_GRP01}"><span class="icon-03">안전한 식생활</span></a>
               <div class="sub-nav bg444">
                   <div class="sub-nav-items row">
                       <div class="col-md-4">
                           <div class="sub-nav-item">
                               <div class="sub-nav-item-header"><a href="/">식품안전지식</a></div>
                               <ul class="sub-nav-item-menu">
                                   <li> <a href="/">식품표시</a> </li>
                                   <li> <a href="/">식품첨가물</a> </li>
                                   <li> <a href="/">유해오염물질</a> </li>
                                   <li> <a href="/">보관저장</a> </li>
                                   <li> <a href="/">식품관련상식</a> </li>
                               </ul>
                           </div>
                           <div class="sub-nav-item">
                               <div class="sub-nav-item-header"><a href="/">식생활안전수칙</a></div>
                           </div>
                           <div class="sub-nav-item">
                               <div class="sub-nav-item-header"><a href="/">안전한 취급요령</a></div>
                               <ul class="sub-nav-item-menu">
                                   <li> <a href="/">품목별</a> </li>
                                   <li> <a href="/">대상별</a> </li>
                                   <li> <a href="/">계절별</a> </li>
                                   <li> <a href="/">기구&middot;용기포장</a> </li>
                               </ul>
                           </div>
                           <div class="sub-nav-item">
                               <div class="sub-nav-item-header"><a href="/">위기시 대응요령</a></div>
                           </div>
                       </div>
                       <div class="col-md-4">
                           <div class="sub-nav-item">
                               <div class="sub-nav-item-header"><a href="/">식품</a></div>
                               <ul class="sub-nav-item-menu">
                                   <li> <a href="/">식품공전</a> </li>
                                   <li> <a href="/">기준규격</a> </li>
                                   <li> <a href="/">위원회관리</a> </li>
                               </ul>
                           </div>
                           <div class="sub-nav-item">
                               <div class="sub-nav-item-header"><a href="/">식품원료</a></div>
                               <ul class="sub-nav-item-menu">
                                   <li> <a href="/">식품원료의 이해</a> </li>
                                   <li> <a href="/">식품원료의 관리</a> </li>
                                   <li> <a href="/">식품원료별기준</a> </li>
                                   <li> <a href="/">식품원료DB</a> </li>
                                   <li> <a href="/">생활속의 식품원료</a> </li>
                                   <li> <a href="/">식품원료 한시적 인정</a> </li>
                               </ul>
                           </div>
                           <div class="sub-nav-item">
                               <div class="sub-nav-item-header"><a href="/">식품첨가물</a></div>
                               <ul class="sub-nav-item-menu">
                                   <li> <a href="/">일반정보</a> </li>
                                   <li> <a href="/">기준규격정보</a> </li>
                               </ul>
                           </div>
                       </div>
                       <div class="col-md-4">
                           <div class="sub-nav-item">
                               <div class="sub-nav-item-header"><a href="/">기구 및 용기 포장</a></div>
                               <ul class="sub-nav-item-menu">
                                   <li> <a href="/">일반정보</a> </li>
                                   <li> <a href="/">기준규격정보</a> </li>
                               </ul>
                           </div>
                           <div class="sub-nav-item">
                               <div class="sub-nav-item-header"><a href="/">기구 등의 살균소독제</a></div>
                               <ul class="sub-nav-item-menu">
                                   <li> <a href="/">일반정보</a> </li>
                                   <li> <a href="/">기준규격정보</a> </li>
                               </ul>
                           </div>
                           <div class="sub-nav-item">
                               <div class="sub-nav-item-header"><a href="/">수입식품</a></div>
                               <ul class="sub-nav-item-menu">
                                   <li> <a href="/">수입관련 법령 및 제도</a> </li>
                                   <li> <a href="/">수입신고 및 검사절차</a> </li>
                                   <li> <a href="/">수입식품검사현황</a> </li>
                                   <li> <a href="/">수입식품통계</a> </li>
                                   <li> <a href="/">수입식품검사연보</a> </li>
                                   <li> <a href="/">수입식품확인</a> </li>
                                   <li> <a href="/">자주 묻는 질문</a> </li>
                               </ul>
                           </div>
                       </div>
                   </div>
               </div>
           </li>
           <li> <a href="${gnbMap.MENU_GRP02}"><span class="icon-04">건강한 식생활</span></a>
               <div class="sub-nav bg543">
                   <div class="sub-nav-items row">
                       <div class="col-md-5">
                           <div class="sub-nav-item">
                               <div class="sub-nav-item-header"><a href="/">식품과 영양</a></div>
                               <ul class="sub-nav-item-menu">
                                   <li> <a href="/">당</a> </li>
                                   <li> <a href="/">나트륨</a> </li>
                                   <li> <a href="/">지방</a> </li>
                                   <li> <a href="/">영양도서관</a> </li>
                                   <li> <a href="/">몸에 좋은 음식</a> </li>
                               </ul>
                           </div>
                           <div class="sub-nav-item">
                               <div class="sub-nav-item-header"><a href="/">생애주기별 식생활</a></div>
                               <ul class="sub-nav-item-menu">
                                   <li> <a href="/">임산부</a> </li>
                                   <li> <a href="/">영유아</a> </li>
                                   <li> <a href="/">어린이</a> </li>
                                   <li> <a href="/">청소년</a> </li>
                                   <li> <a href="/">성인</a> </li>
                                   <li> <a href="/">노인</a> </li>
                               </ul>
                           </div>
                           <div class="sub-nav-item">
                               <div class="sub-nav-item-header"><a href="/">생애주기별 영양관리</a></div>
                               <ul class="sub-nav-item-menu">
                                   <li> <a href="/">임산부</a> </li>
                                   <li> <a href="/">수유부</a> </li>
                                   <li> <a href="/">영유아</a> </li>
                                   <li> <a href="/">어린이</a> </li>
                                   <li> <a href="/">청소년</a> </li>
                                   <li> <a href="/">가임기여성</a> </li>
                                   <li> <a href="/">성인</a> </li>
                                   <li> <a href="/">노인</a> </li>
                               </ul>
                           </div>
                           <div class="sub-nav-item">
                               <div class="sub-nav-item-header"><a href="/">생애주기별 건강관리</a></div>
                               <ul class="sub-nav-item-menu">
                                   <li> <a href="/">임산부</a> </li>
                                   <li> <a href="/">어린이</a> </li>
                                   <li> <a href="/">청소년</a> </li>
                                   <li> <a href="/">성인</a> </li>
                                   <li> <a href="/">노인</a> </li>
                               </ul>
                           </div>
                       </div>
                       <div class="col-md-4">
                           <div class="sub-nav-item">
                               <div class="sub-nav-item-header"><a href="/">식품영양성분</a></div>
                               <ul class="sub-nav-item-menu">
                                   <li> <a href="/">식품영양성분DB소개</a> </li>
                                   <li> <a href="/">식품과 영양성분</a> </li>
                                   <li> <a href="/">식품영양성분DB</a> </li>
                                   <li> <a href="/">건강기능식품영양성분DB</a> </li>
                               </ul>
                           </div>
                           <div class="sub-nav-item">
                               <div class="sub-nav-item-header"><a href="/">식단영양평가</a></div>
                               <ul class="sub-nav-item-menu">
                                   <li> <a href="/">이용안내</a> </li>
                                   <li> <a href="/">나의 영양관리</a> </li>
                                   <li> <a href="/">나의 식단관리</a> </li>
                                   <li> <a href="/">나의 음식관리</a> </li>
                                   <li> <a href="/">나의 영양성분표</a> </li>
                                   <li> <a href="/">칼로리사전</a> </li>
                                   <li> <a href="/">운동칼로리계산기</a> </li>
                               </ul>
                           </div>
                           <div class="sub-nav-item">
                               <div class="sub-nav-item-header"><a href="/">건강기능식품</a></div>
                               <ul class="sub-nav-item-menu">
                                   <li> <a href="/">건강기능식품은?</a> </li>
                                   <li> <a href="/">안전정보</a> </li>
                                   <li> <a href="/">구배정보</a> </li>
                                   <li> <a href="/">기능별정보</a> </li>
                                   <li> <a href="/">원료별정보</a> </li>
                                   <li> <a href="/">인허가/GMP/표시광고</a> </li>
                                   <li> <a href="/">건강기능식품검색</a> </li>
                                   <li> <a href="/">영업자지원</a> </li>
                                   <li> <a href="/">입법예고/고시 등 행정예고</a> </li>
                               </ul>
                           </div>
                       </div>
                       <div class="col-md-3">
                           <div class="sub-nav-item">
                               <div class="sub-nav-item-header"><a href="/">GMO</a></div>
                               <ul class="sub-nav-item-menu">
                                   <li> <a href="/">GMO의 이해</a> </li>
                                   <li> <a href="/">GMO의 안전성</a> </li>
                                   <li> <a href="/">GMO 표시</a> </li>
                                   <li> <a href="/">GMO 현황자료</a> </li>
                                   <li> <a href="/">GMO 사이버교육</a> </li>
                               </ul>
                           </div>
                           <div class="sub-nav-item">
                               <div class="sub-nav-item-header"><a href="/">식중독정보</a></div>
                               <ul class="sub-nav-item-menu">
                                   <li> <a href="/">식중독예방</a> </li>
                                   <li> <a href="/">식중독통계</a> </li>
                                   <li> <a href="/">식중독조기경보</a> </li>
                               </ul>
                           </div>
                       </div>
                   </div>
               </div>
           </li>
           <li> <a href="${gnbMap.MENU_GRP05}"><span class="icon-05">오감만족 식단</span></a>
               <div class="sub-nav bg354">
                   <div class="sub-nav-items row">
                       <div class="col-md-3 none">
                           <div class="sub-nav-item recipe" style="background-image:url(../../img/common/sample-today-recipe.png)">
                               <a href="/">
                                   <div class="sub-nav-item-header">오늘의 레시피</div>
                                   <div class="sub-nav-item-recipe">시원하고 건강한 <strong>여름김치</strong></div>
                                   <div class="sub-nav-item-dscr">오이물김치는 아삭한 식감과 상큼한 맛이 좋아 입맛을 돋운다. 새콤하게 익은 것은 소면을 말아 차갑게 먹어도 별미다.</div>
                               </a>
                           </div>
                       </div>
                       <div class="col-md-5">
                           <div class="sub-nav-item">
                               <div class="sub-nav-item-header"><a href="/">생애주기별 메뉴</a></div>
                               <ul class="sub-nav-item-menu">
                                   <li> <a href="/">유아동</a> </li>
                                   <li> <a href="/">어린이</a> </li>
                                   <li> <a href="/">청소년</a> </li>
                                   <li> <a href="/">성인</a> </li>
                               </ul>
                           </div>
                           <div class="sub-nav-item">
                               <div class="sub-nav-item-header"><a href="/">재료별 메뉴</a></div>
                               <ul class="sub-nav-item-menu">
                                   <li> <a href="/">곡류</a> </li>
                                   <li> <a href="/">육류</a> </li>
                                   <li> <a href="/">채소/버섯류</a> </li>
                                   <li> <a href="/">두류/유제품</a> </li>
                                   <li> <a href="/">해산물</a> </li>
                                   <li> <a href="/">과일류</a> </li>
                               </ul>
                           </div>
                           <div class="sub-nav-item">
                               <div class="sub-nav-item-header"><a href="/">종류별 메뉴</a></div>
                               <ul class="sub-nav-item-menu">
                                   <li> <a href="/">국/찌개/탕</a> </li>
                                   <li> <a href="/">밥/면</a> </li>
                                   <li> <a href="/">밑반찬</a> </li>
                                   <li> <a href="/">양식/중식/일식</a> </li>
                                   <li> <a href="/">기타</a> </li>
                               </ul>
                           </div>
                           <div class="sub-nav-item">
                               <div class="sub-nav-item-header"><a href="/">계절별 메뉴</a></div>
                               <ul class="sub-nav-item-menu">
                                   <li> <a href="/">봄</a> </li>
                                   <li> <a href="/">여름</a> </li>
                                   <li> <a href="/">가을</a> </li>
                                   <li> <a href="/">겨울</a> </li>
                                   <li> <a href="/">제철재료정보</a> </li>
                               </ul>
                           </div>
                       </div>
                       <div class="col-md-4">
                           <div class="sub-nav-item">
                               <div class="sub-nav-item-header"><a href="/">테마식단</a></div>
                               <ul class="sub-nav-item-menu">
                                   <li> <a href="/">녹색메뉴</a> </li>
                                   <li> <a href="/">녹색식단</a> </li>
                                   <li> <a href="/">어린이건강메뉴</a> </li>
                                   <li> <a href="/">어린이저염메뉴</a> </li>
                               </ul>
                           </div>
                           <div class="sub-nav-item">
                               <div class="sub-nav-item-header"><a href="/">네티즌 레시피</a></div>
                               <ul class="sub-nav-item-menu">
                                   <li> <a href="/">도전!레시피 <span class="label label-primary">한겨울~ 몸을 녹이자!</span></a> </li>
                                   <li> <a href="/">나의 레시피</a> </li>
                               </ul>
                           </div>
                           <div class="sub-nav-item">
                               <div class="sub-nav-item-header"><a href="/">우리학교 급식식단</a></div>
                           </div>
                       </div>
                   </div>
               </div>
           </li>
           <li> <a href="${gnbMap.MENU_GRP06}"><span class="icon-06">전문정보관</span></a>
               <div class="sub-nav bg633">
                   <div class="sub-nav-items row">
                       <div class="col-md-6">
                           <div class="sub-nav-item">
                               <div class="sub-nav-item-header"><a href="/">식품안전정보맵</a></div>
                               <ul class="sub-nav-item-menu">
                                   <li> <a href="/">식품안전법령정보맵</a> </li>
                                   <li> <a href="/">식품안전기준&middot;규격맵</a> </li>
                                   <li> <a href="/">식품안전통계맵</a> </li>
                               </ul>
                           </div>
                           <div class="sub-nav-item">
                               <div class="sub-nav-item-header"><a href="/">식품행정업무안내</a></div>
                               <ul class="sub-nav-item-menu">
                                   <li> <a href="/">인허가</a> </li>
                                   <li> <a href="/">식품안전관리</a> </li>
                                   <li> <a href="/">수출입검사검약</a> </li>
                                   <li> <a href="/">시험분석</a> </li>
                               </ul>
                           </div>
                           <div class="sub-nav-item">
                               <div class="sub-nav-item-header"><a href="/">CODEX기준규격</a></div>
                               <ul class="sub-nav-item-menu">
                                   <li> <a href="/">CODEX소개</a> </li>
                                   <li> <a href="/">안정성평가</a> </li>
                                   <li> <a href="/">분과위원회활동모니터</a> </li>
                                   <li> <a href="/">CODEX규격 및 지침</a> </li>
                               </ul>
                           </div>
                           <div class="sub-nav-item">
                               <div class="sub-nav-item-header"><a href="/">간행물</a></div>
                           </div>
                           <div class="sub-nav-item">
                               <div class="sub-nav-item-header"><a href="/">업체제품검색</a></div>
                           </div>
                       </div>
                       <div class="col-md-3">
                           <div class="sub-nav-item">
                               <div class="sub-nav-item-header"><a href="/">전문DB관</a></div>
                           </div>
                           <div class="sub-nav-item">
                               <div class="sub-nav-item-header"><a href="/">수출지원정보</a></div>
                           </div>
                           <div class="sub-nav-item">
                               <div class="sub-nav-item-header"><a href="/">국가식품안전관리체계</a></div>
                           </div>
                           <div class="sub-nav-item">
                               <div class="sub-nav-item-header"><a href="/">정책&middot;홍보자료</a></div>
                           </div>
                           <div class="sub-nav-item">
                               <div class="sub-nav-item-header"><a href="/">교육자료</a></div>
                           </div>
                           <div class="sub-nav-item">
                               <div class="sub-nav-item-header"><a href="/">영상자료</a></div>
                           </div>
                           <div class="sub-nav-item">
                               <div class="sub-nav-item-header"><a href="/">용어사전</a></div>
                           </div>
                       </div>
                       <div class="col-md-3 none">
                           <div class="sub-nav-item fullimg" style="background-image:url(${contenxtPath}/img/common/sample-webzine.png); height:290px;">
                               <a href="/">[건강하고 행복한 소비자를 위한 열린마루] 2014 August, vol. 46</a>
                           </div>
                       </div>
                   </div>
               </div>
           </li>
           <li> <a href="${gnbMap.MENU_GRP07}"><span class="icon-07">공감더하기</span></a>
               <div class="sub-nav bg543">
                   <div class="sub-nav-items row">
                       <div class="col-md-5">
                           <div class="sub-nav-item">
                               <div class="sub-nav-item-header"><a href="/">식품안전포럼</a></div>
                           </div>
                           <div class="sub-nav-item">
                               <div class="sub-nav-item-header"><a href="/">식품안전리포터</a></div>
                               <ul class="sub-nav-item-menu">
                                   <li> <a href="/">생생리포트</a> </li>
                                   <li> <a href="/">행복한 나눔</a> </li>
                                   <li> <a href="/">정책돋보기</a> </li>
                                   <li> <a href="/">인터뷰</a> </li>
                                   <li> <a href="/">업체탐방</a> </li>
                               </ul>
                               <!--ul class="sub-nav-item-photo">
                                   <li> <a href="/"><span class="new">new</span><img src="../img/sample-100x100.png" alt=""> <span>방사능</span></a> </li>
                                   <li> <a href="/"><img src="../img/sample-100x100.png" alt=""> <span>조류인플루엔자</span></a> </li>
                                   <li> <a href="/"><img src="../img/sample-100x100.png" alt=""> <span>GMO</span></a> </li>
                                   <li> <a href="/"><img src="../img/sample-100x100.png" alt=""> <span>식중독</span></a> </li>
                               </ul-->
                               <ul class="sub-nav-item-photo banner">
                                   <li> <a href="/"><img src="${contextPath}/img/common/banner-reporter.png" alt="식품안전리포터 1기 모집- 생활속의 구체적인 식품안전 체험, 관련 정책 구상과 제안, 정책 개선점 등을 다루어 우리 삶에서 어떻게 반영되고 또 어떻게 해야  효율적으로 정책을 구현할 수 있는지를 국민 여러분과 함께 고민해보겠습니다. - 활동기간: 2015년 1월1일 부터 12월 31일까지"></a> </li>
                               </ul>
                           </div>
                       </div>
                       <div class="col-md-4">
                           <div class="sub-nav-item">
                               <div class="sub-nav-item-header"><a href="/">식품안전캘린더</a></div>
                           </div>
                           <div class="sub-nav-item">
                               <div class="sub-nav-item-header"><a href="/">인포그래픽</a></div>
                               <ul class="sub-nav-item-menu">
                                   <li> <a href="/">식품안전</a> </li>
                                   <li> <a href="/">식품영양</a> </li>
                                   <li> <a href="/">농축수산</a> </li>
                                   <li> <a href="/">기타</a> </li>
                               </ul>
                               <ul class="sub-nav-item-photo info">
                                   <li> <a href="/"><img src="${contextPath}/img/sample-info.png" alt=""> <span>60만 장병 급식, 어머니가 지킨다!</span></a> </li>
                               </ul>
                           </div>
                       </div>
                       <div class="col-md-3 none">
                           <div class="sub-nav-item fullimg" style="background-image:url(${contextPath}/img/sample-magazine.png)">
                               <a href="/">[매거진F] 식품 벌레·곰팡이 주의하세요! - 온도 오를수록 식품 벌레·곰팡이 ‘기승’</a>
                           </div>
                       </div>
                   </div>
               </div>
           </li>
       </ul>
       <div class="sub-nav-shadow"></div>
   </nav>
   
<script type="text/javascript">
var menuGrp = "";
$(document).ready(function(){
	
	// 상단메뉴고정 
    $(window).scroll(function(event){
        var y=$(this).scrollTop();
        if( y > 184 ){
            $("#gnb.gnb").addClass('gnb-fixed-top');
            $(".article-head .lnb-viewer").addClass('lnb-fixed-top');
        }
        else{
            $("#gnb.gnb").removeClass('gnb-fixed-top');
            $(".article-head .lnb-viewer").removeClass('lnb-fixed-top');
        }
    });
    menuTree = '${gnbMap.menuTree}';
}); 

</script>

