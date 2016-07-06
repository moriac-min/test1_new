<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
%><%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"
%><%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"
%><%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"
%>

<%pageContext.setAttribute("crlf", "\r\n"); %>

<c:set var="contextPath" scope="request">${pageContext.request.contextPath}</c:set>

<c:if test="${foodAdditiveRvlvVO.page_gubun eq '1'}">
<div class="tab1 tab1_v2">
	<ul>
		<li<c:if test="${foodAdditiveRvlvVO.com_serial eq 1}"> class="on"</c:if>><span><a href="?<c:out value="page_gubun=1&com_serial=1" escapeXml="true"/>">제1. 총칙</a></span></li>
		<li<c:if test="${foodAdditiveRvlvVO.com_serial eq 2}"> class="on"</c:if>><span><a href="?<c:out value="page_gubun=1&com_serial=2" escapeXml="true"/>">제2. 제조<br/>기준</a></span></li>
		<li<c:if test="${foodAdditiveRvlvVO.com_serial eq 7}"> class="on"</c:if>><span><a href="?<c:out value="page_gubun=1&com_serial=7" escapeXml="true"/>">제3. 첨가물의<br /> 일반사용 기준</a></span></li>
		<li<c:if test="${empty foodAdditiveRvlvDetail}"> class="on"</c:if>><span><a href="?<c:out value="page_gubun=1&procs_cl=1" escapeXml="true"/>">제4. 품목별<br /> 규격 및 기준</a></span></li>
		<li<c:if test="${foodAdditiveRvlvVO.com_serial eq 9}"> class="on"</c:if>><span><a href="?<c:out value="page_gubun=1&com_serial=9" escapeXml="true"/>">제5. 일반<br />시험법</a></span></li>
		<li<c:if test="${foodAdditiveRvlvVO.com_serial eq 43}"> class="on"</c:if>><span><a href="?<c:out value="page_gubun=1&com_serial=43" escapeXml="true"/>">제6. 시약,시액,용량분석용<br /> 표준용액 및 표준용액</a></span></li>
		<li<c:if test="${foodAdditiveRvlvVO.com_serial eq 52}"> class="on"</c:if>><span><a href="?<c:out value="page_gubun=1&com_serial=52" escapeXml="true"/>">부록</a></span></li>
	</ul>
</div>
</c:if>

<h3>
<c:choose>
	<c:when test="${empty foodAdditiveRvlvDetail and foodAdditiveRvlvVO.page_gubun eq '1'}">
제4. 품목별 규격 및 기준
	</c:when>
	<c:when test="${foodAdditiveRvlvVO.page_gubun eq '2'}">
품목별 기본정보
	</c:when>
	<c:when test="${foodAdditiveRvlvVO.page_gubun eq '3'}">
JECFA
	</c:when>
	<c:when test="${foodAdditiveRvlvVO.page_gubun eq '4'}">
FCC 규격기준
	</c:when>
	<c:when test="${foodAdditiveRvlvVO.page_gubun eq '5'}">
EU
	</c:when>
	<c:when test="${foodAdditiveRvlvVO.page_gubun eq '6'}">
CODEX
	</c:when>
	<c:when test="${foodAdditiveRvlvVO.page_gubun eq '7'}">
일본공정서
	</c:when>

	<c:when test="${foodAdditiveRvlvVO.com_serial eq 1}">제1. 총칙</c:when>
	<c:when test="${foodAdditiveRvlvVO.com_serial eq 2}">제2. 제조
기준</c:when>
	<c:when test="${foodAdditiveRvlvVO.com_serial eq 7}">제3. 첨가물의
일반사용 기준</c:when>
	<c:when test="${foodAdditiveRvlvVO.com_serial eq 9}">제5. 일반
시험법</c:when>
	<c:when test="${foodAdditiveRvlvVO.com_serial eq 43}">제6. 시약,시액,용량분석용
표준용액 및 표준용액</c:when>
	<c:when test="${foodAdditiveRvlvVO.com_serial eq 52}">부록</c:when>
</c:choose>
</h3>












<div>
<c:choose>
	<c:when test="${empty mode and empty foodAdditiveRvlvDetail}">
	<jsp:include page="./foodAdditiveBasisInfo.jsp" />
	</c:when>
	<c:when test="${mode eq 'view'}">
	<jsp:include page="./foodAdditiveBasisInfoDetail.jsp" />
	</c:when>
	<c:otherwise>

		<c:choose>
			<c:when test="${foodAdditiveRvlvVO.com_serial eq 2}">
	<div class="tab1_2depth">
	<ul>
		<li<c:if test="${foodAdditiveRvlvVO.ordno eq 3}"> class="selected"</c:if>><a href="?<c:out value="page_gubun=1&com_serial=2&ordno=3" />">메틸알콜(지정취소 고시제2009-1호, 2009. 01. 02)</a></li>
		<li<c:if test="${foodAdditiveRvlvVO.ordno eq 4}"> class="selected"</c:if>><a href="?<c:out value="page_gubun=1&com_serial=2&ordno=4" />">아세톤(지정취소 고시제2009-1호, 2009. 01. 02)</a></li>
		<li<c:if test="${foodAdditiveRvlvVO.ordno eq 5}"> class="selected"</c:if>><a href="?<c:out value="page_gubun=1&com_serial=2&ordno=5" />">삼염화에틸렌</a></li>
		<li<c:if test="${foodAdditiveRvlvVO.ordno eq 6}"> class="selected"</c:if>><a href="?<c:out value="page_gubun=1&com_serial=2&ordno=6" />">염화메틸렌</a></li>
	</ul>
	</div>
			</c:when>
			<c:when test="${foodAdditiveRvlvVO.com_serial eq 9}">
	<div class="tab1_2depth">
	<ul>
	<li<c:if test="${foodAdditiveRvlvVO.ordno eq 9 }"> class="selected"</c:if>><a href="?<c:out value="page_gubun=1&com_serial=9&ordno=9" />">가스크로마토그라피        </a></li>
<li<c:if test="${foodAdditiveRvlvVO.ordno eq 10}"> class="selected"</c:if>><a href="?<c:out value="page_gubun=1&com_serial=9&ordno=10" />">강열잔류물시험법          </a></li>
<li<c:if test="${foodAdditiveRvlvVO.ordno eq 11}"> class="selected"</c:if>><a href="?<c:out value="page_gubun=1&com_serial=9&ordno=11" />">건조감량 및 강열감량시험법</a></li>
<li<c:if test="${foodAdditiveRvlvVO.ordno eq 12}"> class="selected"</c:if>><a href="?<c:out value="page_gubun=1&com_serial=9&ordno=12" />">굴절률측정법              </a></li>
<%--<li<c:if test="${foodAdditiveRvlvVO.ordno eq 13}"> class="selected"</c:if>><a href="?<c:out value="page_gubun=1&com_serial=9&ordno=13" />">납시험법(디티존법)        </a></li>--%>
<li<c:if test="${foodAdditiveRvlvVO.ordno eq 14}"> class="selected"</c:if>><a href="?<c:out value="page_gubun=1&com_serial=9&ordno=14" />">메톡실기정량법            </a></li>
<li<c:if test="${foodAdditiveRvlvVO.ordno eq 15}"> class="selected"</c:if>><a href="?<c:out value="page_gubun=1&com_serial=9&ordno=15" />">박층크로마토그라피        </a></li>
<li<c:if test="${foodAdditiveRvlvVO.ordno eq 16}"> class="selected"</c:if>><a href="?<c:out value="page_gubun=1&com_serial=9&ordno=16" />">발생가스측정법            </a></li>
<li<c:if test="${foodAdditiveRvlvVO.ordno eq 17}"> class="selected"</c:if>><a href="?<c:out value="page_gubun=1&com_serial=9&ordno=17" />">비소시험법                </a></li>
<li<c:if test="${foodAdditiveRvlvVO.ordno eq 18}"> class="selected"</c:if>><a href="?<c:out value="page_gubun=1&com_serial=9&ordno=18" />">비점 및 유분측정법        </a></li>
<li<c:if test="${foodAdditiveRvlvVO.ordno eq 19}"> class="selected"</c:if>><a href="?<c:out value="page_gubun=1&com_serial=9&ordno=19" />">비중측정법                </a></li>
<li<c:if test="${foodAdditiveRvlvVO.ordno eq 20}"> class="selected"</c:if>><a href="?<c:out value="page_gubun=1&com_serial=9&ordno=20" />">선광도측정법              </a></li>
<li<c:if test="${foodAdditiveRvlvVO.ordno eq 21}"> class="selected"</c:if>><a href="?<c:out value="page_gubun=1&com_serial=9&ordno=21" />">수분정량법(칼-피셔법)     </a></li>
<li<c:if test="${foodAdditiveRvlvVO.ordno eq 22}"> class="selected"</c:if>><a href="?<c:out value="page_gubun=1&com_serial=9&ordno=22" />">여지크로마토그라피        </a></li>
<li<c:if test="${foodAdditiveRvlvVO.ordno eq 23}"> class="selected"</c:if>><a href="?<c:out value="page_gubun=1&com_serial=9&ordno=23" />">연화점측정법              </a></li>
<li<c:if test="${foodAdditiveRvlvVO.ordno eq 24}"> class="selected"</c:if>><a href="?<c:out value="page_gubun=1&com_serial=9&ordno=24" />">염색반응시험법            </a></li>
<li<c:if test="${foodAdditiveRvlvVO.ordno eq 25}"> class="selected"</c:if>><a href="?<c:out value="page_gubun=1&com_serial=9&ordno=25" />">염화물 및 황산염시험법    </a></li>
<li<c:if test="${foodAdditiveRvlvVO.ordno eq 26}"> class="selected"</c:if>><a href="?<c:out value="page_gubun=1&com_serial=9&ordno=26" />">온도계                    </a></li>
<li<c:if test="${foodAdditiveRvlvVO.ordno eq 27}"> class="selected"</c:if>><a href="?<c:out value="page_gubun=1&com_serial=9&ordno=27" />">원자흡광광도법            </a></li>
<li<c:if test="${foodAdditiveRvlvVO.ordno eq 28}"> class="selected"</c:if>><a href="?<c:out value="page_gubun=1&com_serial=9&ordno=28" />">유도결합플라즈마발광광도법</a></li>
<li<c:if test="${foodAdditiveRvlvVO.ordno eq 29}"> class="selected"</c:if>><a href="?<c:out value="page_gubun=1&com_serial=9&ordno=29" />">수은시험법                </a></li>
<li<c:if test="${foodAdditiveRvlvVO.ordno eq 30}"> class="selected"</c:if>><a href="?<c:out value="page_gubun=1&com_serial=9&ordno=30" />">유기산알칼리염의 정량법   </a></li>
<li<c:if test="${foodAdditiveRvlvVO.ordno eq 31}"> class="selected"</c:if>><a href="?<c:out value="page_gubun=1&com_serial=9&ordno=31" />">융점측정법                </a></li>
<li<c:if test="${foodAdditiveRvlvVO.ordno eq 32}"> class="selected"</c:if>><a href="?<c:out value="page_gubun=1&com_serial=9&ordno=32" />">응고점측정법              </a></li>
<li<c:if test="${foodAdditiveRvlvVO.ordno eq 33}"> class="selected"</c:if>><a href="?<c:out value="page_gubun=1&com_serial=9&ordno=33" />">적외부흡수스펙트럼측정법  </a></li>
<li<c:if test="${foodAdditiveRvlvVO.ordno eq 34}"> class="selected"</c:if>><a href="?<c:out value="page_gubun=1&com_serial=9&ordno=34" />">점도측정법                </a></li>
<li<c:if test="${foodAdditiveRvlvVO.ordno eq 35}"> class="selected"</c:if>><a href="?<c:out value="page_gubun=1&com_serial=9&ordno=35" />">중금속시험법              </a></li>
<li<c:if test="${foodAdditiveRvlvVO.ordno eq 36}"> class="selected"</c:if>><a href="?<c:out value="page_gubun=1&com_serial=9&ordno=36" />">질소정량법                </a></li>
<li<c:if test="${foodAdditiveRvlvVO.ordno eq 37}"> class="selected"</c:if>><a href="?<c:out value="page_gubun=1&com_serial=9&ordno=37" />">pH측정법                  </a></li>
<li<c:if test="${foodAdditiveRvlvVO.ordno eq 38}"> class="selected"</c:if>><a href="?<c:out value="page_gubun=1&com_serial=9&ordno=38" />">확인시험법                </a></li>
<li<c:if test="${foodAdditiveRvlvVO.ordno eq 39}"> class="selected"</c:if>><a href="?<c:out value="page_gubun=1&com_serial=9&ordno=39" />">황산정색물시험법          </a></li>
<li<c:if test="${foodAdditiveRvlvVO.ordno eq 40}"> class="selected"</c:if>><a href="?<c:out value="page_gubun=1&com_serial=9&ordno=40" />">회분시험법                </a></li>
<li<c:if test="${foodAdditiveRvlvVO.ordno eq 41}"> class="selected"</c:if>><a href="?<c:out value="page_gubun=1&com_serial=9&ordno=41" />">흡광도측정법              </a></li>
<li<c:if test="${foodAdditiveRvlvVO.ordno eq 42}"> class="selected"</c:if>><a href="?<c:out value="page_gubun=1&com_serial=9&ordno=42" />">색소시험법                </a></li>
<li<c:if test="${foodAdditiveRvlvVO.ordno eq 43}"> class="selected"</c:if>><a href="?<c:out value="page_gubun=1&com_serial=9&ordno=43" />">색소레이크시험법          </a></li>
<li<c:if test="${foodAdditiveRvlvVO.ordno eq 44}"> class="selected"</c:if>><a href="?<c:out value="page_gubun=1&com_serial=9&ordno=44" />">착향료시험법              </a></li>
<li<c:if test="${foodAdditiveRvlvVO.ordno eq 45}"> class="selected"</c:if>><a href="?<c:out value="page_gubun=1&com_serial=9&ordno=45" />">유지류시험법              </a></li>
<li<c:if test="${foodAdditiveRvlvVO.ordno eq 46}"> class="selected"</c:if>><a href="?<c:out value="page_gubun=1&com_serial=9&ordno=46" />">살균소독력시험법          </a></li>
</ul>

	</div>
			</c:when>

			<c:when test="${foodAdditiveRvlvVO.com_serial eq 43}">
	<div class="tab1_2depth">
	<ul>
		<li<c:if test="${foodAdditiveRvlvVO.ordno eq 48}"> class="selected"</c:if>><a href="?<c:out value="page_gubun=1&com_serial=43&ordno=48" />">시약</a></li>
		<li<c:if test="${foodAdditiveRvlvVO.ordno eq 49}"> class="selected"</c:if>><a href="?<c:out value="page_gubun=1&com_serial=43&ordno=49" />">시액</a></li>
		<li<c:if test="${foodAdditiveRvlvVO.ordno eq 50}"> class="selected"</c:if>><a href="?<c:out value="page_gubun=1&com_serial=43&ordno=50" />">용량분석용 표준용액</a></li>
		<li<c:if test="${foodAdditiveRvlvVO.ordno eq 51}"> class="selected"</c:if>><a href="?<c:out value="page_gubun=1&com_serial=43&ordno=51" />">표준용액</a></li>
	</ul>
	</div>
			</c:when>
		</c:choose>



	<p style="clear:both">
		${fn:replace(foodAdditiveRvlvDetail.cn, crlf, "<br/>")}
	</p>
	</c:otherwise>
</c:choose>


</div>
