<%@page language="java" contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<section>
    <div id="header">
        <div class="board-head">
            <div class="lnb-viewer" id="nav-open-btn" href="#left-nav">Menu</div>
            <ol class="breadcrumb">
                <li><a href="#">홈</a></li>
                <li><a href="#">이슈와 뉴스</a></li>
                <li><a href="#">식품안전뉴스</a></li>
                <li class="active">가공식품</li>
            </ol>
            <h1>지역별 특화거리</h1>
        </div>
    </div>
    <div class="list-container">
        <div class="cat-container">
            <ul class="category">
            	<li><a id="div_ctgType01_00" href="javascript:selectCategory('00','');">전체</a></li>
            	<c:forEach var="ctgType01List" items="${ctgType01List}" varStatus="ctgType01Status">
                  <li><a id="div_ctgType01_${ctgType01Status.index}" href="javascript:selectCategory('${ctgType01Status.index}','${ctgType01List.ctgry_no}');">${ctgType01List.ctgrynm}</a></li>
            	</c:forEach>
            </ul>
        </div>
        <div class="gallery col-2" id="listFrame">
        	<ul>
                <li class="product-name-kor"><span class="new"></span>비트레드</li>
                <li class="product-name-eng">BEET RED COLOR</li>
                <li class="product-info">
                	<dl>
                    	<dt>제품구분</dt>
                        <dd>식품첨가물</dd>
                    	<dt>품목명</dt>
                        <dd>비트레드</dd>
                    	<dt>제조국가</dt>
                        <dd>중국</dd>
                    	<dt>제조/수출회사</dt>
                        <dd>JIANGXI GUOYI BIO-TECH CO., LTD.</dd>
					</dl>                            
                </li>
                <li class="issue-info">
                	<dl>
                    	<dt>위반내역<br>(시험항목/기준/결과)</dt>
                        <dd class="issue">수은1.9ppm검출(규격:1.0ppm이하)</dd>
                    	<dt>처리기관</dt>
                        <dd>부산청(양산)</dd>
                    	<dt>부적합일자</dt>
                        <dd>2014.03.07</dd>
					</dl>                            
                </li>
            </ul>
        </div>
    </div>
</section>
<script>
//카테고리 클릭
function selectCategory(idx_1, ctgryno){
	$(".active").removeClass();
	$("#div_ctgType01_"+idx_1).addClass("active");
	
	//setCategorySearch(ctgryno,hrnk_ctgryno);
		
}
</script>