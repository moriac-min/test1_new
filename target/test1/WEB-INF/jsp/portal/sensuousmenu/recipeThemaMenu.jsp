<%@page language="java" contentType="text/html; charset=utf-8"
%><%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"
%><%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"
%><%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"
%>
<c:set var="contextPath" scope="request">${pageContext.request.contextPath}</c:set>

<input type="hidden" id="gren_sche_seas_cd" name="gren_sche_seas_cd" value="${gren_sche_seas_cd }">				<!-- gren_sche_seas_cd -->
<input type="hidden" id="gren_sche_lifecyc_cd" name="gren_sche_lifecyc_cd" value="${gren_sche_lifecyc_cd }">				<!-- gren_sche_lifecyc_cd -->
<input type="hidden" id="gren_sche_week" name="gren_sche_week" value="${gren_sche_week }">				<!-- gren_sche_lifecyc_cd -->

<section class="weekly">
	<div id="header">
		<div class="board-head">
			<div class="lnb-viewer" id="nav-open-btn" href="#left-nav">Menu</div>
			<ol class="breadcrumb">
				<li><a href="#">홈</a></li>
				<li><a href="#">오감만족식단</a></li>
				<li><a href="#">테마식단</a></li>
				<li class="active">녹색식단</li>
			</ol>
			<h1>녹색식단 <a class="greendiet fancybox.iframe btn btn-danger btn-sm" href="/popup/aboutPopup.do?type=greenDiet">녹색식단 작성원칙은?</a></h1>
		</div>
	</div>
	<div class="list-container recipe">
		<ul id="tabs" class="tab-container tab-4">
			<li <c:if test="${gren_sche_seas_cd == 'RC_SEAS01' }">class="active"</c:if>>
				<a href="javascript:fn_goSubCate('seas','RC_SEAS01');" class="tab">봄</a>
			</li>
			<li <c:if test="${gren_sche_seas_cd == 'RC_SEAS02' }">class="active"</c:if>>
				<a href="javascript:fn_goSubCate('seas','RC_SEAS02');" class="tab">여름</a>
			</li>
			<li <c:if test="${gren_sche_seas_cd == 'RC_SEAS03' }">class="active"</c:if>>
				<a href="javascript:fn_goSubCate('seas','RC_SEAS03');" class="tab">가을</a>
			</li>
			<li <c:if test="${gren_sche_seas_cd == 'RC_SEAS04' }">class="active"</c:if>>
				<a href="javascript:fn_goSubCate('seas','RC_SEAS04');" class="tab">겨울</a>
			</li>
		</ul>
		<div class="cat-container">
			<ul class="category">
				<li><a <c:if test="${gren_sche_lifecyc_cd == 'RC_LIFE02' }">class="active"</c:if> href="javascript:fn_goSubCate('life','RC_LIFE02');">어린이</a></li>
				<li><a <c:if test="${gren_sche_lifecyc_cd == 'RC_LIFE03' }">class="active"</c:if> href="javascript:fn_goSubCate('life','RC_LIFE03');">청소년</a></li>
				<li><a <c:if test="${gren_sche_lifecyc_cd == 'RC_LIFE04' }">class="active"</c:if> href="javascript:fn_goSubCate('life','RC_LIFE04');">성인</a></li>
<!-- 				<li><span class="disabled"></span></li> -->
			</ul>
		</div>
	</div>
	<h2>${themaVO.gren_sche_nm }</h2>
	<div class="list-container">
		<div class="util-container">
			<div class="fl" style="text-align:left;">
				<c:forEach var="themaWeek" items="${themaWeekList }">
				<a href="javascript:fn_goSubCate('week','${themaWeek.gren_sche_week }');" class="btn<c:if test="${themaWeek.gren_sche_week == gren_sche_week }"> btn-danger</c:if>">${themaWeek.gren_sche_week }주</a>
				</c:forEach>
			</div>
			<div class="fr">
				4인 가족 열량(어린이 1인 열량)
				<a class="market fancybox.iframe btn btn-default" href="${contextPath }/popup/aboutPopup.do?type=market&gren_sche_seas_cd=${gren_sche_seas_cd }&gren_sche_lifecyc_cd=${gren_sche_lifecyc_cd }&gren_sche_week=${gren_sche_week }">장보기</a>
				<a class="market fancybox.iframe print" href="greenmenu.html">프린트</a>
			</div>
		</div>
		<div class="calendar">
			<table>
				<caption>${themaVO.gren_sche_nm }</caption>
				<colgroup>
					<col style="width:;">
					<col style="width:185px;">
					<col style="width:185px;">
					<col style="width:185px;">
					<col style="width:185px;">
					<col style="width:185px;">
				</colgroup>
					<thead>
						<tr>
							<th scope="col">구분</th>
							<th scope="col">월</th>
							<th scope="col">화</th>
							<th scope="col">수</th>
							<th scope="col">목</th>
							<th scope="col">금</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<th scope="row" rowspan="2">아침</th>
							<td>
								<ul>
									<c:forEach items="${themaRecipeList }" var="themaRecipe">
										<c:if test="${themaRecipe.sche_kwrd_dt == 1 and themaRecipe.sche_kwrd_tm == 1 }">
											<c:if test="${themaRecipe.rcp_menu_knd == '1'}">
												<li class="dev">
													<span class="label">개발</span></span>
													<a class="recipe2 fancybox.iframe" href="${contextPath}/popup/sensuousmenuView.do?rcp_menu_no=${themaRecipe.rcp_menu_no}">${themaRecipe.rcp_menu_nm}</a>
												</li>
											</c:if>
											<c:if test="${themaRecipe.rcp_menu_knd == '2'}">
												<li class="gen">
													<span class="label">일반</span>
													<a class="recipe1 fancybox.iframe" href="${contextPath}/popup/sensuousmenuView.do?rcp_menu_no=${themaRecipe.rcp_menu_no}">${themaRecipe.rcp_menu_nm}</a>
												</li>
											</c:if>
											<c:if test="${themaRecipe.rcp_menu_knd == '3'}">
												<li>${themaRecipe.rcp_menu_nm}</li>
											</c:if>
										</c:if>
									</c:forEach>
								</ul>
							</td>
							<td>
								<ul>
									<c:forEach items="${themaRecipeList }" var="themaRecipe">
										<c:if test="${themaRecipe.sche_kwrd_dt == 2 and themaRecipe.sche_kwrd_tm == 1 }">
											<c:if test="${themaRecipe.rcp_menu_knd == '1'}">
												<li class="dev">
													<span class="label">개발</span></span>
													<a class="recipe2 fancybox.iframe" href="${contextPath}/popup/sensuousmenuView.do?rcp_menu_no=${themaRecipe.rcp_menu_no}">${themaRecipe.rcp_menu_nm}</a>
												</li>
											</c:if>
											<c:if test="${themaRecipe.rcp_menu_knd == '2'}">
												<li class="gen">
													<span class="label">일반</span>
													<a class="recipe1 fancybox.iframe" href="${contextPath}/popup/sensuousmenuView.do?rcp_menu_no=${themaRecipe.rcp_menu_no}">${themaRecipe.rcp_menu_nm}</a>
												</li>
											</c:if>
											<c:if test="${themaRecipe.rcp_menu_knd == '3'}">
												<li>${themaRecipe.rcp_menu_nm}</li>
											</c:if>
										</c:if>
									</c:forEach>
								</ul>
							</td>
							<td>
								<ul>
									<c:forEach items="${themaRecipeList }" var="themaRecipe">
										<c:if test="${themaRecipe.sche_kwrd_dt == 3 and themaRecipe.sche_kwrd_tm == 1 }">
											<c:if test="${themaRecipe.rcp_menu_knd == '1'}">
												<li class="dev">
													<span class="label">개발</span></span>
													<a class="recipe2 fancybox.iframe" href="${contextPath}/popup/sensuousmenuView.do?rcp_menu_no=${themaRecipe.rcp_menu_no}">${themaRecipe.rcp_menu_nm}</a>
												</li>
											</c:if>
											<c:if test="${themaRecipe.rcp_menu_knd == '2'}">
												<li class="gen">
													<span class="label">일반</span>
													<a class="recipe1 fancybox.iframe" href="${contextPath}/popup/sensuousmenuView.do?rcp_menu_no=${themaRecipe.rcp_menu_no}">${themaRecipe.rcp_menu_nm}</a>
												</li>
											</c:if>
											<c:if test="${themaRecipe.rcp_menu_knd == '3'}">
												<li>${themaRecipe.rcp_menu_nm}</li>
											</c:if>
										</c:if>
									</c:forEach>
								</ul>
							</td>
							<td>
								<ul>
									<c:forEach items="${themaRecipeList }" var="themaRecipe">
										<c:if test="${themaRecipe.sche_kwrd_dt == 4 and themaRecipe.sche_kwrd_tm == 1 }">
											<c:if test="${themaRecipe.rcp_menu_knd == '1'}">
												<li class="dev">
													<span class="label">개발</span></span>
													<a class="recipe2 fancybox.iframe" href="${contextPath}/popup/sensuousmenuView.do?rcp_menu_no=${themaRecipe.rcp_menu_no}">${themaRecipe.rcp_menu_nm}</a>
												</li>
											</c:if>
											<c:if test="${themaRecipe.rcp_menu_knd == '2'}">
												<li class="gen">
													<span class="label">일반</span>
													<a class="recipe1 fancybox.iframe" href="${contextPath}/popup/sensuousmenuView.do?rcp_menu_no=${themaRecipe.rcp_menu_no}">${themaRecipe.rcp_menu_nm}</a>
												</li>
											</c:if>
											<c:if test="${themaRecipe.rcp_menu_knd == '3'}">
												<li>${themaRecipe.rcp_menu_nm}</li>
											</c:if>
										</c:if>
									</c:forEach>
								</ul>
							</td>
							<td>
								<ul>
									<c:forEach items="${themaRecipeList }" var="themaRecipe">
										<c:if test="${themaRecipe.sche_kwrd_dt == 5 and themaRecipe.sche_kwrd_tm == 1 }">
											<c:if test="${themaRecipe.rcp_menu_knd == '1'}">
												<li class="dev">
													<span class="label">개발</span></span>
													<a class="recipe2 fancybox.iframe" href="${contextPath}/popup/sensuousmenuView.do?rcp_menu_no=${themaRecipe.rcp_menu_no}">${themaRecipe.rcp_menu_nm}</a>
												</li>
											</c:if>
											<c:if test="${themaRecipe.rcp_menu_knd == '2'}">
												<li class="gen">
													<span class="label">일반</span>
													<a class="recipe1 fancybox.iframe" href="${contextPath}/popup/sensuousmenuView.do?rcp_menu_no=${themaRecipe.rcp_menu_no}">${themaRecipe.rcp_menu_nm}</a>
												</li>
											</c:if>
											<c:if test="${themaRecipe.rcp_menu_knd == '3'}">
												<li>${themaRecipe.rcp_menu_nm}</li>
											</c:if>
										</c:if>
									</c:forEach>
								</ul>
							</td>
						</tr>
						<tr>
							<td class="cal">${themaVO.gren_sche_mon_brea_4mem_calm }(${themaVO.gren_sche_mon_brea_calm }) kcal</td>
							<td class="cal">${themaVO.gren_sche_tue_brea_4mem_calm }(${themaVO.gren_sche_tue_brea_calm }) kcal</td>
							<td class="cal">${themaVO.gren_sche_wed_brea_4mem_calm }(${themaVO.gren_sche_wed_brea_calm }) kcal</td>
							<td class="cal">${themaVO.gren_sche_thu_brea_4mem_calm }(${themaVO.gren_sche_thu_brea_calm }) kcal</td>
							<td class="cal">${themaVO.gren_sche_fri_brea_4mem_calm }(${themaVO.gren_sche_fri_brea_calm }) kcal</td>
						</tr>
						<tr>
						<tr>
							<th scope="row" rowspan="2">점심</th>
							<td>
								<ul>
									<c:forEach items="${themaRecipeList }" var="themaRecipe">
										<c:if test="${themaRecipe.sche_kwrd_dt == 1 and themaRecipe.sche_kwrd_tm == 2 }">
											<c:if test="${themaRecipe.rcp_menu_knd == '1'}">
												<li class="dev">
													<span class="label">개발</span></span>
													<a class="recipe2 fancybox.iframe" href="${contextPath}/popup/sensuousmenuView.do?rcp_menu_no=${themaRecipe.rcp_menu_no}">${themaRecipe.rcp_menu_nm}</a>
												</li>
											</c:if>
											<c:if test="${themaRecipe.rcp_menu_knd == '2'}">
												<li class="gen">
													<span class="label">일반</span>
													<a class="recipe1 fancybox.iframe" href="${contextPath}/popup/sensuousmenuView.do?rcp_menu_no=${themaRecipe.rcp_menu_no}">${themaRecipe.rcp_menu_nm}</a>
												</li>
											</c:if>
											<c:if test="${themaRecipe.rcp_menu_knd == '3'}">
												<li>${themaRecipe.rcp_menu_nm}</li>
											</c:if>
										</c:if>
									</c:forEach>
								</ul>
							</td>
							<td>
								<ul>
									<c:forEach items="${themaRecipeList }" var="themaRecipe">
										<c:if test="${themaRecipe.sche_kwrd_dt == 2 and themaRecipe.sche_kwrd_tm == 2 }">
											<c:if test="${themaRecipe.rcp_menu_knd == '1'}">
												<li class="dev">
													<span class="label">개발</span></span>
													<a class="recipe2 fancybox.iframe" href="${contextPath}/popup/sensuousmenuView.do?rcp_menu_no=${themaRecipe.rcp_menu_no}">${themaRecipe.rcp_menu_nm}</a>
												</li>
											</c:if>
											<c:if test="${themaRecipe.rcp_menu_knd == '2'}">
												<li class="gen">
													<span class="label">일반</span>
													<a class="recipe1 fancybox.iframe" href="${contextPath}/popup/sensuousmenuView.do?rcp_menu_no=${themaRecipe.rcp_menu_no}">${themaRecipe.rcp_menu_nm}</a>
												</li>
											</c:if>
											<c:if test="${themaRecipe.rcp_menu_knd == '3'}">
												<li>${themaRecipe.rcp_menu_nm}</li>
											</c:if>
										</c:if>
									</c:forEach>
								</ul>
							</td>
							<td>
								<ul>
									<c:forEach items="${themaRecipeList }" var="themaRecipe">
										<c:if test="${themaRecipe.sche_kwrd_dt == 3 and themaRecipe.sche_kwrd_tm == 2 }">
											<c:if test="${themaRecipe.rcp_menu_knd == '1'}">
												<li class="dev">
													<span class="label">개발</span></span>
													<a class="recipe2 fancybox.iframe" href="${contextPath}/popup/sensuousmenuView.do?rcp_menu_no=${themaRecipe.rcp_menu_no}">${themaRecipe.rcp_menu_nm}</a>
												</li>
											</c:if>
											<c:if test="${themaRecipe.rcp_menu_knd == '2'}">
												<li class="gen">
													<span class="label">일반</span>
													<a class="recipe1 fancybox.iframe" href="${contextPath}/popup/sensuousmenuView.do?rcp_menu_no=${themaRecipe.rcp_menu_no}">${themaRecipe.rcp_menu_nm}</a>
												</li>
											</c:if>
											<c:if test="${themaRecipe.rcp_menu_knd == '3'}">
												<li>${themaRecipe.rcp_menu_nm}</li>
											</c:if>
										</c:if>
									</c:forEach>
								</ul>
							</td>
							<td>
								<ul>
									<c:forEach items="${themaRecipeList }" var="themaRecipe">
										<c:if test="${themaRecipe.sche_kwrd_dt == 4 and themaRecipe.sche_kwrd_tm == 2 }">
											<c:if test="${themaRecipe.rcp_menu_knd == '1'}">
												<li class="dev">
													<span class="label">개발</span></span>
													<a class="recipe2 fancybox.iframe" href="${contextPath}/popup/sensuousmenuView.do?rcp_menu_no=${themaRecipe.rcp_menu_no}">${themaRecipe.rcp_menu_nm}</a>
												</li>
											</c:if>
											<c:if test="${themaRecipe.rcp_menu_knd == '2'}">
												<li class="gen">
													<span class="label">일반</span>
													<a class="recipe1 fancybox.iframe" href="${contextPath}/popup/sensuousmenuView.do?rcp_menu_no=${themaRecipe.rcp_menu_no}">${themaRecipe.rcp_menu_nm}</a>
												</li>
											</c:if>
											<c:if test="${themaRecipe.rcp_menu_knd == '3'}">
												<li>${themaRecipe.rcp_menu_nm}</li>
											</c:if>
										</c:if>
									</c:forEach>
								</ul>
							</td>
							<td>
								<ul>
									<c:forEach items="${themaRecipeList }" var="themaRecipe">
										<c:if test="${themaRecipe.sche_kwrd_dt == 5 and themaRecipe.sche_kwrd_tm == 2 }">
											<c:if test="${themaRecipe.rcp_menu_knd == '1'}">
												<li class="dev">
													<span class="label">개발</span></span>
													<a class="recipe2 fancybox.iframe" href="${contextPath}/popup/sensuousmenuView.do?rcp_menu_no=${themaRecipe.rcp_menu_no}">${themaRecipe.rcp_menu_nm}</a>
												</li>
											</c:if>
											<c:if test="${themaRecipe.rcp_menu_knd == '2'}">
												<li class="gen">
													<span class="label">일반</span>
													<a class="recipe1 fancybox.iframe" href="${contextPath}/popup/sensuousmenuView.do?rcp_menu_no=${themaRecipe.rcp_menu_no}">${themaRecipe.rcp_menu_nm}</a>
												</li>
											</c:if>
											<c:if test="${themaRecipe.rcp_menu_knd == '3'}">
												<li>${themaRecipe.rcp_menu_nm}</li>
											</c:if>
										</c:if>
									</c:forEach>
								</ul>
							</td>
						</tr>
						<tr>
							<td class="cal">${themaVO.gren_sche_mon_lunc_4mem_calm }(${themaVO.gren_sche_mon_lunc_calm }) kcal</td>
							<td class="cal">${themaVO.gren_sche_tue_lunc_4mem_calm }(${themaVO.gren_sche_tue_lunc_calm }) kcal</td>
							<td class="cal">${themaVO.gren_sche_wed_lunc_4mem_calm }(${themaVO.gren_sche_wed_lunc_calm }) kcal</td>
							<td class="cal">${themaVO.gren_sche_thu_lunc_4mem_calm }(${themaVO.gren_sche_thu_lunc_calm }) kcal</td>
							<td class="cal">${themaVO.gren_sche_fri_lunc_4mem_calm }(${themaVO.gren_sche_fri_lunc_calm }) kcal</td>
						</tr>
						<tr>
						<tr>
							<th scope="row" rowspan="2">저녁</th>
							<td>
								<ul>
									<c:forEach items="${themaRecipeList }" var="themaRecipe">
										<c:if test="${themaRecipe.sche_kwrd_dt == 1 and themaRecipe.sche_kwrd_tm == 3 }">
											<c:if test="${themaRecipe.rcp_menu_knd == '1'}">
												<li class="dev">
													<span class="label">개발</span></span>
													<a class="recipe2 fancybox.iframe" href="${contextPath}/popup/sensuousmenuView.do?rcp_menu_no=${themaRecipe.rcp_menu_no}">${themaRecipe.rcp_menu_nm}</a>
												</li>
											</c:if>
											<c:if test="${themaRecipe.rcp_menu_knd == '2'}">
												<li class="gen">
													<span class="label">일반</span>
													<a class="recipe1 fancybox.iframe" href="${contextPath}/popup/sensuousmenuView.do?rcp_menu_no=${themaRecipe.rcp_menu_no}">${themaRecipe.rcp_menu_nm}</a>
												</li>
											</c:if>
											<c:if test="${themaRecipe.rcp_menu_knd == '3'}">
												<li>${themaRecipe.rcp_menu_nm}</li>
											</c:if>
										</c:if>
									</c:forEach>
								</ul>
							</td>
							<td>
								<ul>
									<c:forEach items="${themaRecipeList }" var="themaRecipe">
										<c:if test="${themaRecipe.sche_kwrd_dt == 2 and themaRecipe.sche_kwrd_tm == 3 }">
											<c:if test="${themaRecipe.rcp_menu_knd == '1'}">
												<li class="dev">
													<span class="label">개발</span></span>
													<a class="recipe2 fancybox.iframe" href="${contextPath}/popup/sensuousmenuView.do?rcp_menu_no=${themaRecipe.rcp_menu_no}">${themaRecipe.rcp_menu_nm}</a>
												</li>
											</c:if>
											<c:if test="${themaRecipe.rcp_menu_knd == '2'}">
												<li class="gen">
													<span class="label">일반</span>
													<a class="recipe1 fancybox.iframe" href="${contextPath}/popup/sensuousmenuView.do?rcp_menu_no=${themaRecipe.rcp_menu_no}">${themaRecipe.rcp_menu_nm}</a>
												</li>
											</c:if>
											<c:if test="${themaRecipe.rcp_menu_knd == '3'}">
												<li>${themaRecipe.rcp_menu_nm}</li>
											</c:if>
										</c:if>
									</c:forEach>
								</ul>
							</td>
							<td>
								<ul>
									<c:forEach items="${themaRecipeList }" var="themaRecipe">
										<c:if test="${themaRecipe.sche_kwrd_dt == 3 and themaRecipe.sche_kwrd_tm == 3 }">
											<c:if test="${themaRecipe.rcp_menu_knd == '1'}">
												<li class="dev">
													<span class="label">개발</span></span>
													<a class="recipe2 fancybox.iframe" href="${contextPath}/popup/sensuousmenuView.do?rcp_menu_no=${themaRecipe.rcp_menu_no}">${themaRecipe.rcp_menu_nm}</a>
												</li>
											</c:if>
											<c:if test="${themaRecipe.rcp_menu_knd == '2'}">
												<li class="gen">
													<span class="label">일반</span>
													<a class="recipe1 fancybox.iframe" href="${contextPath}/popup/sensuousmenuView.do?rcp_menu_no=${themaRecipe.rcp_menu_no}">${themaRecipe.rcp_menu_nm}</a>
												</li>
											</c:if>
											<c:if test="${themaRecipe.rcp_menu_knd == '3'}">
												<li>${themaRecipe.rcp_menu_nm}</li>
											</c:if>
										</c:if>
									</c:forEach>
								</ul>
							</td>
							<td>
								<ul>
									<c:forEach items="${themaRecipeList }" var="themaRecipe">
										<c:if test="${themaRecipe.sche_kwrd_dt == 4 and themaRecipe.sche_kwrd_tm == 3 }">
											<c:if test="${themaRecipe.rcp_menu_knd == '1'}">
												<li class="dev">
													<span class="label">개발</span></span>
													<a class="recipe2 fancybox.iframe" href="${contextPath}/popup/sensuousmenuView.do?rcp_menu_no=${themaRecipe.rcp_menu_no}">${themaRecipe.rcp_menu_nm}</a>
												</li>
											</c:if>
											<c:if test="${themaRecipe.rcp_menu_knd == '2'}">
												<li class="gen">
													<span class="label">일반</span>
													<a class="recipe1 fancybox.iframe" href="${contextPath}/popup/sensuousmenuView.do?rcp_menu_no=${themaRecipe.rcp_menu_no}">${themaRecipe.rcp_menu_nm}</a>
												</li>
											</c:if>
											<c:if test="${themaRecipe.rcp_menu_knd == '3'}">
												<li>${themaRecipe.rcp_menu_nm}</li>
											</c:if>
										</c:if>
									</c:forEach>
								</ul>
							</td>
							<td>
								<ul>
									<c:forEach items="${themaRecipeList }" var="themaRecipe">
										<c:if test="${themaRecipe.sche_kwrd_dt == 5 and themaRecipe.sche_kwrd_tm == 3 }">
											<c:if test="${themaRecipe.rcp_menu_knd == '1'}">
												<li class="dev">
													<span class="label">개발</span></span>
													<a class="recipe2 fancybox.iframe" href="${contextPath}/popup/sensuousmenuView.do?rcp_menu_no=${themaRecipe.rcp_menu_no}">${themaRecipe.rcp_menu_nm}</a>
												</li>
											</c:if>
											<c:if test="${themaRecipe.rcp_menu_knd == '2'}">
												<li class="gen">
													<span class="label">일반</span>
													<a class="recipe1 fancybox.iframe" href="${contextPath}/popup/sensuousmenuView.do?rcp_menu_no=${themaRecipe.rcp_menu_no}">${themaRecipe.rcp_menu_nm}</a>
												</li>
											</c:if>
											<c:if test="${themaRecipe.rcp_menu_knd == '3'}">
												<li>${themaRecipe.rcp_menu_nm}</li>
											</c:if>
										</c:if>
									</c:forEach>
								</ul>
							</td>
						</tr>
						<tr>
							<td class="cal">${themaVO.gren_sche_mon_dinn_4mem_calm }(${themaVO.gren_sche_mon_dinn_calm }) kcal</td>
							<td class="cal">${themaVO.gren_sche_tue_dinn_4mem_calm }(${themaVO.gren_sche_tue_dinn_calm }) kcal</td>
							<td class="cal">${themaVO.gren_sche_wed_dinn_4mem_calm }(${themaVO.gren_sche_wed_dinn_calm }) kcal</td>
							<td class="cal">${themaVO.gren_sche_thu_dinn_4mem_calm }(${themaVO.gren_sche_thu_dinn_calm }) kcal</td>
							<td class="cal">${themaVO.gren_sche_fri_dinn_4mem_calm }(${themaVO.gren_sche_fri_dinn_calm }) kcal</td>
						</tr>
						<tr>
							<th scope="row" rowspan="2">간식</th>
							<td>
								<ul>
									<c:forEach items="${themaRecipeList }" var="themaRecipe">
										<c:if test="${themaRecipe.sche_kwrd_dt == 1 and themaRecipe.sche_kwrd_tm == 4 }">
											<c:if test="${themaRecipe.rcp_menu_knd == '1'}">
												<li class="dev">
													<span class="label">개발</span></span>
													<a class="recipe2 fancybox.iframe" href="${contextPath}/popup/sensuousmenuView.do?rcp_menu_no=${themaRecipe.rcp_menu_no}">${themaRecipe.rcp_menu_nm}</a>
												</li>
											</c:if>
											<c:if test="${themaRecipe.rcp_menu_knd == '2'}">
												<li class="gen">
													<span class="label">일반</span>
													<a class="recipe1 fancybox.iframe" href="${contextPath}/popup/sensuousmenuView.do?rcp_menu_no=${themaRecipe.rcp_menu_no}">${themaRecipe.rcp_menu_nm}</a>
												</li>
											</c:if>
											<c:if test="${themaRecipe.rcp_menu_knd == '3'}">
												<li>${themaRecipe.rcp_menu_nm}</li>
											</c:if>
										</c:if>
									</c:forEach>
								</ul>
							</td>
							<td>
								<ul>
									<c:forEach items="${themaRecipeList }" var="themaRecipe">
										<c:if test="${themaRecipe.sche_kwrd_dt == 2 and themaRecipe.sche_kwrd_tm == 4 }">
											<c:if test="${themaRecipe.rcp_menu_knd == '1'}">
												<li class="dev">
													<span class="label">개발</span></span>
													<a class="recipe2 fancybox.iframe" href="${contextPath}/popup/sensuousmenuView.do?rcp_menu_no=${themaRecipe.rcp_menu_no}">${themaRecipe.rcp_menu_nm}</a>
												</li>
											</c:if>
											<c:if test="${themaRecipe.rcp_menu_knd == '2'}">
												<li class="gen">
													<span class="label">일반</span>
													<a class="recipe1 fancybox.iframe" href="${contextPath}/popup/sensuousmenuView.do?rcp_menu_no=${themaRecipe.rcp_menu_no}">${themaRecipe.rcp_menu_nm}</a>
												</li>
											</c:if>
											<c:if test="${themaRecipe.rcp_menu_knd == '3'}">
												<li>${themaRecipe.rcp_menu_nm}</li>
											</c:if>
										</c:if>
									</c:forEach>
								</ul>
							</td>
							<td>
								<ul>
									<c:forEach items="${themaRecipeList }" var="themaRecipe">
										<c:if test="${themaRecipe.sche_kwrd_dt == 3 and themaRecipe.sche_kwrd_tm == 4 }">
											<c:if test="${themaRecipe.rcp_menu_knd == '1'}">
												<li class="dev">
													<span class="label">개발</span></span>
													<a class="recipe2 fancybox.iframe" href="${contextPath}/popup/sensuousmenuView.do?rcp_menu_no=${themaRecipe.rcp_menu_no}">${themaRecipe.rcp_menu_nm}</a>
												</li>
											</c:if>
											<c:if test="${themaRecipe.rcp_menu_knd == '2'}">
												<li class="gen">
													<span class="label">일반</span>
													<a class="recipe1 fancybox.iframe" href="${contextPath}/popup/sensuousmenuView.do?rcp_menu_no=${themaRecipe.rcp_menu_no}">${themaRecipe.rcp_menu_nm}</a>
												</li>
											</c:if>
											<c:if test="${themaRecipe.rcp_menu_knd == '3'}">
												<li>${themaRecipe.rcp_menu_nm}</li>
											</c:if>
										</c:if>
									</c:forEach>
								</ul>
							</td>
							<td>
								<ul>
									<c:forEach items="${themaRecipeList }" var="themaRecipe">
										<c:if test="${themaRecipe.sche_kwrd_dt == 4 and themaRecipe.sche_kwrd_tm == 4 }">
											<c:if test="${themaRecipe.rcp_menu_knd == '1'}">
												<li class="dev">
													<span class="label">개발</span></span>
													<a class="recipe2 fancybox.iframe" href="${contextPath}/popup/sensuousmenuView.do?rcp_menu_no=${themaRecipe.rcp_menu_no}">${themaRecipe.rcp_menu_nm}</a>
												</li>
											</c:if>
											<c:if test="${themaRecipe.rcp_menu_knd == '2'}">
												<li class="gen">
													<span class="label">일반</span>
													<a class="recipe1 fancybox.iframe" href="${contextPath}/popup/sensuousmenuView.do?rcp_menu_no=${themaRecipe.rcp_menu_no}">${themaRecipe.rcp_menu_nm}</a>
												</li>
											</c:if>
											<c:if test="${themaRecipe.rcp_menu_knd == '3'}">
												<li>${themaRecipe.rcp_menu_nm}</li>
											</c:if>
										</c:if>
									</c:forEach>
								</ul>
							</td>
							<td>
								<ul>
									<c:forEach items="${themaRecipeList }" var="themaRecipe">
										<c:if test="${themaRecipe.sche_kwrd_dt == 5 and themaRecipe.sche_kwrd_tm == 4 }">
											<c:if test="${themaRecipe.rcp_menu_knd == '1'}">
												<li class="dev">
													<span class="label">개발</span></span>
													<a class="recipe2 fancybox.iframe" href="${contextPath}/popup/sensuousmenuView.do?rcp_menu_no=${themaRecipe.rcp_menu_no}">${themaRecipe.rcp_menu_nm}</a>
												</li>
											</c:if>
											<c:if test="${themaRecipe.rcp_menu_knd == '2'}">
												<li class="gen">
													<span class="label">일반</span>
													<a class="recipe1 fancybox.iframe" href="${contextPath}/popup/sensuousmenuView.do?rcp_menu_no=${themaRecipe.rcp_menu_no}">${themaRecipe.rcp_menu_nm}</a>
												</li>
											</c:if>
											<c:if test="${themaRecipe.rcp_menu_knd == '3'}">
												<li>${themaRecipe.rcp_menu_nm}</li>
											</c:if>
										</c:if>
									</c:forEach>
								</ul>
							</td>
						</tr>
						<tr>
							<td class="cal">${themaVO.gren_sche_mon_snac_4mem_calm }(${themaVO.gren_sche_mon_snac_calm }) kcal</td>
							<td class="cal">${themaVO.gren_sche_tue_snac_4mem_calm }(${themaVO.gren_sche_tue_snac_calm }) kcal</td>
							<td class="cal">${themaVO.gren_sche_wed_snac_4mem_calm }(${themaVO.gren_sche_wed_snac_calm }) kcal</td>
							<td class="cal">${themaVO.gren_sche_thu_snac_4mem_calm }(${themaVO.gren_sche_thu_snac_calm }) kcal</td>
							<td class="cal">${themaVO.gren_sche_fri_snac_4mem_calm }(${themaVO.gren_sche_fri_snac_calm }) kcal</td>
						</tr>
					</tbody>
					<tfoot>
						<tr>
							<th scope="row">합계</th>
							<td class="cal">
							${themaVO.gren_sche_mon_brea_calm + themaVO.gren_sche_mon_lunc_calm + themaVO.gren_sche_mon_dinn_calm + themaVO.gren_sche_mon_snac_calm}
							(${themaVO.gren_sche_mon_brea_4mem_calm + themaVO.gren_sche_mon_lunc_4mem_calm + themaVO.gren_sche_mon_dinn_4mem_calm + themaVO.gren_sche_mon_snac_4mem_calm})
							&nbsp;kcal</td>
							<td class="cal">
							${themaVO.gren_sche_tue_brea_calm + themaVO.gren_sche_tue_lunc_calm + themaVO.gren_sche_tue_dinn_calm + themaVO.gren_sche_tue_snac_calm}
							(${themaVO.gren_sche_tue_brea_4mem_calm + themaVO.gren_sche_tue_lunc_4mem_calm + themaVO.gren_sche_tue_dinn_4mem_calm + themaVO.gren_sche_tue_snac_4mem_calm})
							&nbsp;kcal</td>
							<td class="cal">
							${themaVO.gren_sche_wed_brea_calm + themaVO.gren_sche_wed_lunc_calm + themaVO.gren_sche_wed_dinn_calm + themaVO.gren_sche_wed_snac_calm}
							(${themaVO.gren_sche_wed_brea_4mem_calm + themaVO.gren_sche_wed_lunc_4mem_calm + themaVO.gren_sche_wed_dinn_4mem_calm + themaVO.gren_sche_wed_snac_4mem_calm})
							&nbsp;kcal</td>
							<td class="cal">
							${themaVO.gren_sche_thu_brea_calm + themaVO.gren_sche_thu_lunc_calm + themaVO.gren_sche_thu_dinn_calm + themaVO.gren_sche_thu_snac_calm}
							(${themaVO.gren_sche_thu_brea_4mem_calm + themaVO.gren_sche_thu_lunc_4mem_calm + themaVO.gren_sche_thu_dinn_4mem_calm + themaVO.gren_sche_thu_snac_4mem_calm})
							&nbsp;kcal</td>
							<td class="cal">
							${themaVO.gren_sche_fri_brea_calm + themaVO.gren_sche_fri_lunc_calm + themaVO.gren_sche_fri_dinn_calm + themaVO.gren_sche_fri_snac_calm}
							(${themaVO.gren_sche_fri_brea_4mem_calm + themaVO.gren_sche_fri_lunc_4mem_calm + themaVO.gren_sche_fri_dinn_4mem_calm + themaVO.gren_sche_fri_snac_4mem_calm})
							&nbsp;kcal</td>
						</tr>
					</tfoot>
				</table>
			</div>
		</div>
	</section>
	
<script language="JavaScript">

	/****************************************
	 * Variable
	****************************************/
	/****************************************
	 * Init
	****************************************/
	$(document).ready(function() {
		$(".greendiet,.lowna").fancybox({
			maxWidth	: 655,
			maxHeight	: 770,
			minHeight	: 770,
			fitToView	: false,
			width		: '70%',
			height		: '80%',
			autoSize	: false,
			closeClick	: false,
			openEffect	: 'fade',
			closeEffect	: 'fade'
		});
		$(".recipe1").fancybox({
			maxWidth	: 655,
			maxHeight	: 500,
			minHeight	: 500,
			fitToView	: false,
			width		: '70%',
			height		: '80%',
			autoSize	: false,
			closeClick	: false,
			openEffect	: 'fade',
			closeEffect	: 'fade'
		});
		$(".recipe2,.market,.greenmenu").fancybox({
			maxWidth	: 750,
			maxHeight	: 740,
			minHeight	: 740,
			fitToView	: false,
			width		: '70%',
			height		: '80%',
			autoSize	: false,
			closeClick	: false,
			openEffect	: 'fade',
			closeEffect	: 'fade'
		});
	});
	
	/****************************************
	 * Button Action
	 ****************************************/

	 /****************************************
	 * Function
	 ****************************************/
	//상세페이지팝업    
    function fn_moveDetail(rcp_menu_no){
		
    	var action  = '${contextPath}/popup/sensuousmenuView.do?rcp_menu_no='+rcp_menu_no;
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
            tpl: {next : '', prev : ''},
            href        : action
        });
        
    }
	
	function fn_goSubCate(nm, val){
		var id_nm = "";
		if(nm == "seas"){
			id_nm = "gren_sche_seas_cd";
		}else if(nm == "life"){
			id_nm = "gren_sche_lifecyc_cd";
		}else if(nm == "week"){
			id_nm = "gren_sche_week";
		}
		
		$('#'+id_nm).val(val);
		document.baseForm.action="${contextPath}/portal/sensuousmenu/themaMenu.do";
        document.baseForm.target="_self";
        document.baseForm.method="post";
        document.baseForm.submit();
	}
</script>
