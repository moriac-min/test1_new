<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="m" uri="/WEB-INF/tlds/message.tld"%>
<%@ page import="foodportal.common.util.Message"%>

			<section>
                <div id="header">
                    <div class="board-head">
                        <ol class="breadcrumb">
                            <li id="menuTree"></li>
                        </ol>
                        <h1>소비자신고접수</h1>
                    </div>
                </div>
                <div class="page-container">
                	<!-- 페이지 내용 -->
                    <article>
						<div class="bs-callout bs-callout-danger">
                        	<p>제조원, 판매원, 제품구입(판매)장소 중 1곳 이상은 반드시 기재하여야 조사가 진행되며, 나머지 업소정보를 모를 경우에는 반드시 공란(빈칸)으로 남겨두시기 바랍니다.<br>
                                ※ 모름, 미기재, 0, 점(.), 쉼표(,),O, 말줄임(...), 물음표(?) 등으로 기재 금지</p>
                        </div>
                        <div class="emphasis">
                        	<ul style="padding-left:15px;margin-bottom:0;">
                            	<li>동 신고센터는 <strong>소비자가 직접 신고</strong>하는 곳입니다.</li>
                                <li>동 신고 사이트는 <strong>부정·불량식품 신고 전용 사이트</strong>로 <strong>기타(의약품,마약류, 의료기기, 화장품) 민원은 처리(이첩 등)가 불가</strong>하여 종결처리 되오니 양지하시기 바랍니다.</li>
                                <li>참고로, <strong>기타(의약품, 마약류, 의료기기, 화장품) 민원</strong>은 <a href="http://www.epeople.go.kr" target="_blank" title="[새창]국민신문고"><strong>국민신문고(http://www.epeople.go.kr)</strong></a>에 직접 신고하여야 함을 알려드립니다.</li>
                                <li>이물의 발견을 <strong>거짓으로 신고한 자</strong>는 <strong>1년 이하의 징역 또는 300만원 이하의 벌금</strong>에 처해질 수 있습니다.</li>
                                <li>기타 민원 관련 사항은 <strong>종합상담센터(1577-1255)로 문의</strong>하시기 바랍니다.</li>
                            </ul>
                        </div>
                           <fieldset>
                               <legend>문서정보입력양식</legend>
                               <table class="tableset">
                                   <caption>문서정보</caption>
                                   <colgroup>
                                       <col style="width:15%">
                                       <col style="width:25%">
                                       <col style="width:15%">
                                       <col style="width:45%">
                                   </colgroup>
                                   <tbody>
                                       <tr>
                                           <th>문서번호</th>
                                           <td>신고 XXXX-XXXXXXXXXX</td>
                                           <th>담당기관</th>
                                           <td>식품의약품안전처 식품안전정책국 식품관리총괄과[식품]
                                           <input type="hidden" name="org_name" id="org_name" value="식품의약품안전처 식품안전정책국 식품관리총괄과[식품]">
                                           <input type="hidden" name="org_code" id="org_code" value="1001"></td>
                                       </tr>
                                   </tbody>
                               </table>
                           </fieldset>
                           <h2>신고자정보</h2>
                           <fieldset>
                               <legend>신고자정보입력양식</legend>
                               <table class="tableset">
                                   <caption>신고자정보</caption>
                                   <colgroup>
                                       <col style="width:15%">
                                       <col style="width:35%">
                                       <col style="width:15%">
                                       <col style="width:35%">
                                   </colgroup>
                                   <tbody>
                                       <tr>
                                           <th class="required"><label for="name" title="필수항목">성명</label></th>
                                           <td>
                                           	<!-- <input type="text" size="18" name="aplcnt_name" id="aplcnt_name" title="성명" readonly> -->
                                           	<input type="text" size="18" name="aplcnt_name" id="aplcnt_name" title="성명">
                                           	<a href="${contextPath}/popup/commonPopup/checkRealName.do" class="realname fancybox.iframe btn btn-success btn-sm">실명인증</a>
                                           </td>
                                           <th class="required"><label for="jumin1" title="필수항목">주민등록번호</label></th>
                                           <td>
                                           	<!-- <input type="text" maxlength="6" size="10" name="aplcnt_rsrno_1" id="aplcnt_rsrno_1" title="주민번호1" readonly> -->
                                           	<input type="text" maxlength="6" size="10" name="aplcnt_rsrno_1" id="aplcnt_rsrno_1" title="주민번호1">
											-
											<!-- <input type="password" maxlength="7" size="11" name="aplcnt_rsrno_2" id="aplcnt_rsrno_2" title="주민번호2" readonly> -->
											<input type="password" maxlength="7" size="11" name="aplcnt_rsrno_2" id="aplcnt_rsrno_2" title="주민번호2">
                                           </td>
                                       </tr>
                                       <tr>
                                           <th class="required"><label for="cons_post" title="필수항목">소재지</label></th>
                                           <td colspan="3">
                                           	<!-- <input type="text" size="5" name="aplcnt_zipno" id="aplcnt_zipno" title="우편번호" readonly> -->
                                           	<input type="text" size="5" name="aplcnt_zipno" id="aplcnt_zipno" title="우편번호">
                                           	<a href="#" target="_blank" title="새창으로 열기" class="btn btn-success btn-sm">우편번호찾기</a> 
                                           	<!-- <input type="text" size="48" name="aplcnt_postaddr" id="aplcnt_postaddr" title="우편주소" readonly> -->
                                           	<input type="text" size="48" name="aplcnt_postaddr" id="aplcnt_postaddr" title="우편주소">
                                           	<input type="text" size="62" name="aplcnt_dtl_addr" id="aplcnt_dtl_addr" title="상세주소" onkeyup="SUchkLengthObj('256', this)">
                                           </td>
                                       </tr>
                                       <tr>
                                           <th><label for="cons_email">이메일</label></th>
                                           <td><input type="text" size="24" name="aplcnt_email_addr" id="aplcnt_email_addr" title="이메일" onkeyup="SUchkLengthObj('128', this)"></td>
                                           <th class="required"><label for="cons_tel">휴대폰번호(연락처)</label></th>
                                           <td><input type="text" size="24" name="aplcnt_mbtpno" id="aplcnt_mbtpno" title="연락처"></td>
                                       </tr>
                                       <tr>
                                           <th class="required"><label for="pass" title="필수항목">비밀번호</label></th>
                                           <td><input type="password" size="24" name="pswd" id="pswd" title="비밀번호" maxlength="32" ></td>
                                           <th class="required"><label for="pass2" title="필수항목">비밀번호 확인</label></th>
                                           <td><input type="password" size="24" name="pswd_confirm" id="pswd_confirm" title="비밀번호 확인" maxlength="32" ></td>
                                       </tr>
                                       <tr>
                                           <th class="required"><label for="inform-s" title="필수항목">조사종결 통보방식</label></th>
                                           <td colspan="3">
                                               <ul>
                                              	<c:forEach var="code" items="${dspthWayCd}" varStatus="status">
                                              		<li><label><input type="radio" name="dspth_way_cd" id="dspth_way_cd_${status.index}" title="${code.fnprt_cd_nm}" value="${code.fnprt_cd}" ${status.index eq '0' ? 'checked="checked"' : ''}>${code.fnprt_cd_nm}</label></li>
												</c:forEach>
                                               </ul>
                                           </td>
                                       </tr>
                                       <tr>
                                           <th class="required"><label for="receipt1" title="필수항목">신고접수분류</label></th>
                                           <td colspan="3">
                                               <ul>
                                               <c:forEach var="code" items="${rcptDvsCd}" varStatus="status">
                                              		<li><label><input type="radio" name="rcpt_dvs_cd" id="rcpt_dvs_cd_${status.index}" title="${code.fnprt_cd_nm}" value="${code.fnprt_cd}" ${code.fnprt_cd eq 'B' ? 'checked="checked"' : ''}>${code.fnprt_cd_nm}</label></li>
												</c:forEach>
                                               </ul>
                                           </td>
                                       </tr>
                                   </tbody>
                               </table>
                           </fieldset>
                           <h2>신고내용</h2>
						<fieldset>
                               <legend>신고내용입력양식</legend>
                               <table class="tableset">
                                   <caption>신고내용</caption>
                                   <colgroup>
                                       <col style="width:15%">
                                       <col style="width:85%">
                                   </colgroup>
                                   <tbody>
                                       <tr>
                                           <th class="required"><label for="category1" title="필수항목">신고분류</label></th>
                                           <td>
                                               <ul>
                                               <c:forEach var="code" items="${viltClCd}" varStatus="status">
                                               	<c:choose>
                                               		<c:when test="${code.fnprt_cd eq '1'}">
                                               			<li><label><input type="radio" name="vilt_cl_cd" id="vilt_cl_cd_${status.index}" value="${code.fnprt_cd}" checked="checked">${code.fnprt_cd_nm}</label></li>
                                                		<li>
                                                			<label for="vilt_cl_dtl_cd" class="hidden">식품 하위분류선택</label>
                                                			<div class="select-container w100">
	                                                			<select id="vilt_cl_dtl_cd" name="vilt_cl_dtl_cd" class="selecter_basic" disabled="disabled">
	                                                			<c:forEach var="code" items="${viltClDtlCd}" varStatus="sub_status">
																	<option value="${code.fnprt_cd}">${code.fnprt_cd_nm}</option>
																</c:forEach>
																</select>
															</div>
														</li>
                                               		</c:when>
                                               		<c:otherwise>
                                               			<li><label><input type="radio" name="vilt_cl_cd" id="vilt_cl_cd_${status.index}" title="${code.fnprt_cd_nm}" value="${code.fnprt_cd}">${code.fnprt_cd_nm}</label></li>
                                               		</c:otherwise>
                                               	</c:choose>
											</c:forEach>
                                               </ul>
                                           </td>
                                       </tr>
                                       <tr>
                                           <th class="required"><label for="codes1" title="필수항목">신고종류</label></th>
                                           <td>
                                               <ul id="sltViltCnCd">
                                               </ul>
                                           </td>
                                       </tr>
                                       <!-- 이물발견 선택 시 -->
                                       <tr id="alnst">
                                           <th><label for="aclass">이물종류</label></th>
                                           <td>
												<ul>
                                                    <li>
                                                    	<div class="select-container w130">
                                                           	<select id="alnst_cd_hrnkCd" name="alnst_cd_hrnkCd" title="이물 1차분류" class="selecter_basic">
																<option value="" selected="selected">1차분류선택</option>
															<c:forEach var="code" items="${alnstCd}" varStatus="status">
																<option value="${code.lclas_cd}">${code.rm}</option>
															</c:forEach>
				                                            </select>
                                                        </div>
                                                    </li>
                                                    <li>
                                                        <div class="select-container w370">
                                                            <select id="alnst_cd" name="alnst_cd" title="이물 2차분류" class="selecter_basic">
			                                                   <option value="" selected="selected">2차분류선택</option>
			                                               </select>
                                                        </div>
                                                    </li>
                                                    <li><input type="text" size="16" name="alnst_dett_etc" id="alnst_dett_etc" title="기타이물내용입력" onkeyup="SUchkLengthObj('300', this)"></li>
                                                	<li>* 동물성 이물 중 그 외, 식물성 이물 중 그 외, 광물성 이물 중 그 외, 기타 이물 중 그외 선택 시에는  해당 내용을 입력해주세요.</li>
                                                </ul>
                                           </td>
                                       </tr>
                                       <tr id="keepFlag">
                                           <th class="required"><label for="keep_flag1" title="필수항목">증거제품보관</label></th>
                                           <td>
                                               <ul>
                                               <c:forEach var="code" items="${keepFlagCd}" varStatus="status">
                                               	<li><label><input type="checkbox" name="keep_flag_list" id="keep_flag_list_${status.index }" value="${code.fnprt_cd}" title="${code.fnprt_cd_nm}">${code.fnprt_cd_nm}</label></li>
											</c:forEach>
                                               </ul>
                                           </td>
                                        </tr>
                                        <!--- // ---->
                                        <tr>
                                           <th class="required"><label for="register_con" title="필수항목">내용</label></th>
                                           <td>
                                           	<textarea cols="65" rows="5" id="sttemnt_cn" name="sttemnt_cn" title="신고내용"></textarea><p>* 이물발견 경위 등을 자세히 작성해 주십시요.</p>
                                           </td>
                                       </tr>
                                        <tr>
                                           <th><label for="file">첨부파일</label></th>
                                           <td>
                                           <!-- 
												<ul>
													<li><label><input type="radio" name="data_type" id="data_img" value="I" title="이미지체크" checked="checked"> 이미지</label></li>
													<li><label><input type="radio" name="data_type" id="data_movie" value="V" title="동영상체크"> 동영상</label></li>
												</ul>
												 -->
                                               <input type="text" size="30" name="orgnt_file_nm" id="orgnt_file_nm" readonly="readonly">
                                               <a href="${contextPath}/popup/commonPopup/fileUpload.do?uploadSource=complain" class="fileUpload fancybox.iframe btn btn-success btn-sm">파일 업로드</a>
                                               <ul class="guide">
                                                   <li>사진, 동영상 등 신고 관련 자료를 첨부해주십시오.</li>
                                                   <li>사진 자료는 gif, jpg, bmp, png, zip 파일만 가능합니다.</li>
                                                   <li>동영상 자료는 avi, mpg, asf, wmv, k3g, mov 파일만 가능합니다.</li>
                                                   <li>사진자료는 10Mb / 동영상 자료는 50Mb 까지 가능 합니다. </li>
                                               </ul>
                                           </td>
                                       </tr>
                                   </tbody>
                               </table>
                           </fieldset>
                           <h2>제품 및 업체 정보</h2>
                           <div class="emphasis">
                               <h3>신고유형별 기재요령(주 입력란)</h3>
                               <ul style="padding-left:15px;margin-bottom:0;">
                                   <li>무허가(신고)영업 : 제품구입(판매)장소</li>
                                   <li>그 외 신고: 제조원(또는 판매원[현품에 표시되어 있는 업소를 말하며, 없는 경우 기재 생략]), 제품구입(판매)장소</li>
                               </ul>
                           </div>
                           <fieldset>
                               <legend>제품/업체정보입력양식</legend>
                               <table class="tableset">
                                   <caption>제품/업체정보</caption>
                                   <colgroup>
                                       <col style="width:15%">
                                       <col style="width:35%">
                                       <col style="width:15%">
                                       <col style="width:35%">
                                   </colgroup>
                                   <tbody>
                                       <tr>
                                           <th class="required"><label for="prod_name" title="필수항목" >제품명</label></th>
                                           <td colspan="3"><input type="text" size="62" name="prdt_nm" id="prdt_nm" title="제품명" onkeyup="SUchkLengthObj('500', this)"></td>
                                       </tr>
                                       <tr>
                                           <th><label for="prod_type">식품유형</label></th>
                                           <td>
                                           	<input type="text" name="food_type_cd_nm" id="food_type_cd_nm" size="16" readonly>
                                           	<a href="${contextPath}/popup/commonPopup/selectFoodtype.do" class="foodtype fancybox.iframe btn btn-success btn-sm">식품유형찾기</a>
                                           </td>
                                           <th><label for="haccp">HACCP적용품목여부</label></th>
                                           <td><label><input type="checkbox" name="haccp_applc_prdlst_tf" id="haccp_applc_prdlst_tf" title="HACCP 적용"> HACCP</label></td>
                                       </tr>
                                       <tr>
                                           <th><label for="prod_term">유통기한</label></th>
                                           <td><input type="text" size="24" name="prdt_distb_tmlmt" id="prdt_distb_tmlmt" title="유통기한" onkeyup="SUchkLengthObj('100', this)"></td>
                                           <th><label for="keep_st">보관기준</label></th>
                                           <td><input type="text" size="24" name="cstdy_stdr" id="cstdy_stdr" title="보관기준" onkeyup="SUchkLengthObj('200', this)"></td>
                                       </tr>
                                       <tr>
                                           <th><label for="prod_term">제조일자</label></th>
                                           <td><input type="text" size="24" name="prdt_mnf_dt" id="prdt_mnf_dt" title="제조일자" maxlength="8"></td>
                                           <th><label for="keep_st">품질유지기한</label></th>
                                           <td><input type="text" size="24" name="qlity_mntnc_tmlmt_dt" id="qlity_mntnc_tmlmt_dt" title="품질유지기한" maxlength="8"></td>
                                       </tr>
                                       <tr>
                                           <th><label for="prod_unit">포장단위</label></th>
                                           <td><input type="text" size="24" name="prdt_frmlc_unit" id="prdt_frmlc_unit" onkeyup="SUchkLengthObj('60', this)"></td>
                                           <th><label for="origin_name">수입식품여부</label></th>
                                           <td>
                                           	<ul>
                                          		<c:forEach var="code" items="${dICd}" varStatus="status">
                                          			<li>
                                          				<label>
                                          					<input type="radio" name="orgnp_dvs_cd" id="orgnp_dvs_cd_${status.index }" value="${code.fnprt_cd}" ${code.fnprt_cd eq 'D' ? 'checked="checked"' : ''}> ${code.fnprt_cd_nm}
                                          				</label>
                                          			<c:if test="${code.fnprt_cd eq 'E'}">
                                          				<a id="origin" href="${contextPath}/popup/commonPopup/selectFoodBase.do" class="origin fancybox.iframe btn btn-success btn-sm">원산지</a>
                                          				<input type="text" size="9" name="incm_natn_cd_nm" id="incm_natn_cd_nm" style="margin-left:5px;" readonly="readonly">
                                          			</c:if>
                                          			</li>
												</c:forEach>
                                               </ul>
                                           </td>
                                       </tr>
                                       <tr>
                                       		<th><label for="productPurchasePlaceCd">제품구입장소구분</label></th>
                                       		<td colspan="3">
                                       			<select id="productPurchasePlaceCd" name="productPurchasePlaceCd" class="selecter_basic">
												<c:forEach var="code" items="${productPurchasePlaceCd}" varStatus="sub_status">
													<option value="${code.fnprt_cd}">${code.fnprt_cd_nm}</option>
												</c:forEach>
												</select>
                                       		</td>
                                       </tr>
                                       <tr>
                                           <th><label for="sale_place">제품구입장소(주소지)</label></th>
                                           <td colspan="3"><textarea cols="55" rows="5" name="prdt_buy_plc" id="prdt_buy_plc"></textarea><p>* 소재지와 연락처를 알고 있는 경우 같이 기재해 주십시요.</p></td>
                                       </tr>
                                   </tbody>
                               </table>
                           </fieldset>
                           <div class="emphasis" style="margin:20px 0;">
                               <ul style="padding-left:15px;margin-bottom:0;">
                                   <li>동 판매원은 제품(현품) 표시에 있는 판매원에 한하며, 없는 경우 생략하시기 바랍니다. </li>
                               </ul>
                           </div>
                           <fieldset>
                               <legend>제품/업체정보입력양식</legend>
                               <table class="tableset">
                                   <caption>제품/업체정보</caption>
                                   <colgroup>
                                       <col style="width:15%">
                                       <col style="width:35%">
                                       <col style="width:15%">
                                       <col style="width:35%">
                                   </colgroup>
                                   <tbody>
                                       <tr>
                                           <th class="required"><label for="prod_comp" title="필수항목">제조원</label></th>
                                           <td>
                                           	<input type="text" name="makr_cd_nm" id="makr_cd_nm" size="16" readonly="readonly">
                                           	<a href="${contextPath}/popup/commonPopup/selectShop.do?allSearch=Y" class="maker fancybox.iframe btn btn-success btn-sm">제조원 찾기</a>
                                           </td>
                                           <th><label for="prod_tel">제조원 연락처</label></th>
                                           <td><input type="text" size="24" name="makr_telno" id="makr_telno" title="제조원 연락처" readonly="readonly"></td>
                                       </tr>
                                       <tr>
                                           <th><label for="prod_post">제조원 소재지</label></th>
                                           <td colspan="3">
                                           <!-- 
                                           	<input type="text" size="5" name="makr_zipno" id="makr_zipno" title="우편번호" readonly>
                                           	<a href="#" title="새창으로 열기" class="btn btn-success btn-sm">우편번호찾기</a>
											<input type="text"size="48" name="makr_postaddr" id="makr_postaddr" title="제조원 우편주소" style="margin-left:4px;" readonly>
											<input type="text"size="62" name="makr_dtladdr" id="makr_dtladdr" title="제조원 상세주소">
											 -->
											 <input type="text"size="62" name="makr_addr" id="makr_addr" title="제조원 주소">
										</td>
                                       </tr>
                                       <tr>
                                           <th><label for="prod_name">판매원</label></th>
                                           <td>
                                           	<input type="text" name="salpr_cd_nm" id="salpr_cd_nm" size="16" readonly="readonly">
                                           	<a href="${contextPath}/popup/commonPopup/selectVendor.do?allSearch=Y" class="vendor fancybox.iframe btn btn-success btn-sm">판매원 찾기</a>
                                           </td>
                                           <th><label for="sale_tel">판매원 연락처</label></th>
                                           <td><input type="text" size="24" name="salpr_telno " id="salpr_telno" title="판매원 연락처" readonly="readonly"></td>
                                       </tr>
                                       <tr>
                                           <th><label for="sale_post">판매원 소재지</label></th>
                                           <td colspan="3">
                                           <!-- 
                                           	<input type="text" size="5" name="salpr_zipno" id="salpr_zipno" title="우편번호" readonly>
                                           	<a href="#" title="새창으로 열기" class="btn btn-success btn-sm">우편번호찾기</a>
											<input type="text"size="48" name="salpr_postaddr" id="salpr_postaddr" title="판매원 우편주소" style="margin-left:4px;" readonly>
											<input type="text"size="62" name="salpr_dtladdr" id="salpr_dtladdr" title="판매원 상세주소">
											 -->
											 <input type="text"size="62" name="salpr_addr" id="salpr_addr" title="판매원 주소">
										</td>
                                       </tr>
                                   </tbody>
                               </table>
                           </fieldset>
                           <div class="btn-container">
                               <button type="button" class="btn btn-default btn-lg" id="saveBtn">등록</button>
                               <button type="button" class="btn btn-danger btn-lg" id="cancelBtn">취소</button>
                           </div>
                    </article>
                </div>
            </section>
            
            <input type="hidden" name="aplcnt_rsrno" id="aplcnt_rsrno" value="">									<!-- 주민등록번호 -->
            <input type="hidden" name="haccp_applc_prdlst_yn" id="haccp_applc_prdlst_yn" value="">		<!-- HACCP 적용 품목 여부 -->
            <input type="hidden" name="food_type_cd" id="food_type_cd" value="">								<!-- 식품유형코드 -->
            <input type="hidden" name="incm_natn_cd" id="incm_natn_cd" value="" />							<!-- 수입국가코드 -->
            <input type="hidden" name="makr_cd" id="makr_cd" value="" />											<!-- 제조원코드 -->
            <input type="hidden" name="makr_reg_unreg_bssh_dvs_cd" id="makr_reg_unreg_bssh_dvs_cd" value="" /><!-- 제조사 등록 미등록 업소 구분 코드  -->
            <input type="hidden" name="salpr_cd" id="salpr_cd" value="" />											<!-- 판매원코드 -->
            <input type="hidden" name="salpr_reg_unreg_dvs_cd" id="salpr_reg_unreg_dvs_cd" value="" /><!-- 판매원_등록_미등록_구분_코드    -->
            
            <input type="hidden" name="file_yn" id="file_yn" value="">													<!-- 파일첨부 여부 -->
            <input type="hidden" name="physic_file_nm" id="physic_file_nm" value="">							<!-- 서버에 저장된 파일 이름 -->
            <input type="hidden" name="file_save_path" id="file_save_path" value="">							<!-- 파일 위치 -->
            <input type="hidden" name="file_extns" id="file_extns" value="">											<!-- 파일 유형 코드  -->
            <input type="hidden" name="file_mg_lengt" id="file_mg_lengt" value="">								<!-- 파일용량 -->


<script id="viltCnCdList" type="text/html">
	<li>
		<label><input type="radio" name="vilt_cn_cd" id="vilt_cn_cd_{idx}" value="{code}" onclick="javascript:fn_ClickviltCnCd('{code}');" {checked}>{code_nm}</label>
		{code_etc_label}
		{code_etc_input}
	</li>
</script>

<script id="commonOptionList" type="text/html">
	<option value="{code}">{code_nm}</option>
</script>

 <script type="text/javascript">
/***************************************************************************************
* 시스템명 	: 식품의약품안전처 통합식품안전망구축
* 업무명 		: 소비자 신고
* 파일명 		: customerNotify.jsp
* 작성자 		: 장영철
* 작성일 		: 2014.09.30
*
* 설  명		:  소비자 신고
*------------------------------------------------------------------------------------
* 변경일	변경자		변경내역 
*------------------------------------------------------------------------------------
*  2014.09.30 장영철		최초 프로그램 작성         
* 
*------------------------------------------------------------------------------------
**************************************************************************************/

/**************************************************************************************
 * Variable
 **************************************************************************************/

/**************************************************************************************
 * Init & Event
 **************************************************************************************/
$(function() {
	//이물관련 정보 숨기기
	$('#alnst').hide();
	//증거제품보관 정보 숨기기
	$('#keepFlag').hide();
	//원산지 찾기 버튼 숨기기
	$('#origin').hide();
	//원산지 input box 숨기기
	$('#incm_natn_cd_nm').hide();
	
	//신고분류에 따른 신고종류를 가져온다.
	fn_searchConditionViltCnCd();
	//신고분류에 따른 신고종류를 활성/비활성화 한다.
	fn_activationViltClDtlCd();
	
	//신고분류 change 이벤트
	$('input:radio[name="vilt_cl_cd"]').change(function(){
		fn_searchConditionViltCnCd();
		fn_activationViltClDtlCd();
	});
	
	//신고분류 상세 change 이벤트
	$('#vilt_cl_dtl_cd').change(function(){
		fn_searchConditionViltCnCd();
	});
	
	//이물구분 상위코드 change 이벤트
	$('#alnst_cd_hrnkCd').change(function(){
		fn_selectAlnstCd($(this).val());
	});
	
	//저장버튼 클릭 이벤트
	$('#saveBtn').click(function(){
		fn_saveData();
	});
	
	//취소버튼 클릭 이벤트
	$('#cancelBtn').click(function(){
		location.href = '${contextPath}/minwon/complain/customerNotify.do';
	});
	
	//수입식품 여부 change 이벤트
	$('input:radio[name="orgnp_dvs_cd"]').change(function(){
		if($(this).val() == 'D'){
			$('#origin').hide();
			$('#incm_natn_cd_nm').hide();
			$('#incm_natn_cd').val('');
			$('#incm_natn_cd_nm').val('');
		}else{
			$('#origin').show();
			$('#incm_natn_cd_nm').show();
		}
	});
	
});

/**************************************************************************************
 * Function
 **************************************************************************************/
//신고분류에 따른 신고종류 검색 조건 설정
function fn_searchConditionViltCnCd(){
	var viltClCd = $('input[name=vilt_cl_cd]:checked').val();
	var viltClDtlCd = $('#vilt_cl_dtl_cd').val();
	
	if( viltClCd == '1' ){
		if(viltClDtlCd == '20'){
			fn_selectViltCnCd( 'user_dfn_clmn_2' );
		}else{
			fn_selectViltCnCd( 'user_dfn_clmn_1' );	
		}
	}else if( viltClCd == '2' ){
		fn_selectViltCnCd( 'user_dfn_clmn_3' );
	}else if( viltClCd == '3' ){
		fn_selectViltCnCd( 'user_dfn_clmn_4' );
	}else if( viltClCd == '4' ){
		fn_selectViltCnCd( 'user_dfn_clmn_5' );
	}
}

//신고분류에 따른 신고종류를 활성/비활성화 한다.
function fn_activationViltClDtlCd(){
	var viltClCd = $('input[name=vilt_cl_cd]:checked').val();
	
	if( viltClCd == '1' ){
		$('#vilt_cl_dtl_cd').attr('disabled', false);
	}else{
		$('#vilt_cl_dtl_cd').attr('disabled', true);
	}
}

//신고내용 선택시
function fn_ClickviltCnCd(selectCd){
	//이물 선택시
	if(selectCd == '105' || selectCd == '108'){
		$('#alnst').show();
		$('#keepFlag').show();
	}else{
		$('#alnst').hide();
		$('#keepFlag').hide();
	}
	
	//기타 선택시
	if(selectCd == '999'){
		$('#vilt_cn_prvns').attr('disabled', false);
	}else{
		$('#vilt_cn_prvns').attr('disabled', true);
	}
}

//저장
function fn_saveData(){
	
	if(!fn_validate()){
		return;
	}
	
	if(confirm('${m:getMessage("msg.common.save.confirm")}')){
		fn_saveCustomerNotify();
	}
	
}

/**************************************************************************************
 * Validation
 **************************************************************************************/
//유효성 체크
function fn_validate(){
	
	//신고자정보 > 이름
	if(fn_empty('#aplcnt_name','${m:getMessageIn("msg.common.valid.required", "이름") }') == false){	
		return false;	
	}
	
	//신고자정보 > 주민등록번호(실명인증이 붙으면 실명인증으로 유효성 체크를 변경)
	if(fn_empty('#aplcnt_rsrno_1','${m:getMessageIn("msg.common.valid.required", "주민등록번호") }') == false){	
		return false;	
	}
	if(fn_empty('#aplcnt_rsrno_2','${m:getMessageIn("msg.common.valid.required", "주민등록번호") }') == false){	
		return false;	
	}
	if(fn_num('#aplcnt_rsrno_1','${m:getMessageIn("msg.common.valid.numer", "주민등록번호") }') == false){	
		return false;	
	}
	if(fn_num('#aplcnt_rsrno_2','${m:getMessageIn("msg.common.valid.numer", "주민등록번호") }') == false){	
		return false;	
	}
	$('#aplcnt_rsrno').val($('#aplcnt_rsrno_1').val()+$('#aplcnt_rsrno_2').val());
	
	
	//신고자정보 > 소재지
	if(fn_empty('#aplcnt_zipno','${m:getMessageIn("msg.common.valid.required", "소재지") }') == false){	
		return false;	
	}
	if(fn_empty('#aplcnt_postaddr','${m:getMessageIn("msg.common.valid.required", "소재지") }') == false){	
		return false;	
	}
	if(fn_empty('#aplcnt_dtl_addr','${m:getMessageIn("msg.common.valid.required", "소재지") }') == false){	
		return false;	
	}
	
	//신고자정보 > 이메일
	fn_replaceSpace('#vilt_cn_prvns');		//trim
	if($('#aplcnt_email_addr').val() != '' && fn_email('#aplcnt_email_addr','${m:getMessage("msg.common.valid.email")}') == false){	
		return false;	
	}
	
	//신고자정보 > 휴대폰번호
	if(fn_empty('#aplcnt_mbtpno','${m:getMessageIn("msg.common.valid.required", "휴대폰번호") }') == false){	
		return false;	
	}
	if(fn_phonNumer('#aplcnt_mbtpno','${m:getMessage("msg.common.valid.phoneNumer")}') == false){	
		return false;	
	}
	
	//신고자정보 > 비밀번호
	if(fn_empty('#pswd','${m:getMessageIn("msg.common.valid.required", "비밀번호") }') == false){	
		return false;	
	}
	if(fn_empty('#pswd_confirm','${m:getMessageIn("msg.common.valid.required", "비밀번호 확인") }') == false){	
		return false;	
	}
	if($('#pswd').val() != $('#pswd_confirm').val()){
		alert('${m:getMessage("msg.common.valid.password")}');
		$('#pswd').focus();
		return false;
	}

	//신고내용 > 신고종류 > 기타일때
	fn_replaceSpecialChar('#vilt_cn_prvns');		//특수문자 제거
	if($('input[name=vilt_cn_cd]:checked').val() == '999' && fn_empty('#vilt_cn_prvns','${m:getMessageIn("msg.common.valid.required", "신고종류 - 기타") }') == false){
		return false;
	}
	
	//신고내용 > 이물 > 3차 상세
	fn_replace('#alnst_dett_etc');		//trim
	fn_replaceSpecialChar('#alnst_dett_etc');		//특수문자 제거	

	//신고내용 > 증거제품보관
	if($('input[name=vilt_cn_cd]:checked').val() == '105' || $('input[name=vilt_cn_cd]:checked').val() == '108'){
		var keep_flag_value = '';
		$('input[name=keep_flag_list]:checked').each(function(idx){
			keep_flag_value = $(this).val();
		});
		if(keep_flag_value == '' || keep_flag_value == 'undefined'){
			alert('${m:getMessageIn("msg.common.valid.required", "증거제품보관") }');
			$('#keep_flag_list_0').focus();
			return false;	
		}
	}
	
	//신고내용 > 내용
	fn_replaceSpecialChar('#sttemnt_cn');		//특수문자 제거	
	if(fn_empty('#sttemnt_cn','${m:getMessageIn("msg.common.valid.required", "내용") }') == false){	
		return false;	
	}
	
	//제품 및 업체 정보 > 제품명
	fn_replaceSpecialChar('#prdt_nm');		//특수문자 제거	
	if(fn_empty('#prdt_nm','${m:getMessageIn("msg.common.valid.required", "제품명") }') == false){	
		return false;	
	}
	
	//제품 및 업체 정보 > HACCP적용품목여부
	$('#haccp_applc_prdlst_yn').val($('input[name=haccp_applc_prdlst_tf]').is(':checked') ? 'Y' : 'N');
	
	//제품 및 업체 정보 > 유통기한
	fn_replace('#prdt_distb_tmlmt');		//trim
	fn_replaceSpecialChar('#prdt_distb_tmlmt');		//특수문자 제거
	
	//제품 및 업체 정보 > 보관기준
	fn_replace('#cstdy_stdr');		//trim
	fn_replaceSpecialChar('#cstdy_stdr');		//특수문자 제거
	
	//제품 및 업체 정보 > 제조일자
	if($('#prdt_mnf_dt').val() != '' && fn_num('#prdt_mnf_dt','${m:getMessageIn("msg.common.valid.numer", "제조일자") }') == false){	
		return false;	
	}
	
	//제품 및 업체 정보 > 품질유지기한
	if($('#qlity_mntnc_tmlmt_dt').val() != '' && fn_num('#qlity_mntnc_tmlmt_dt','${m:getMessageIn("msg.common.valid.numer", "품질유지기한") }') == false){	
		return false;	
	}
	
	//제품 및 업체 정보 > 포장단위
	fn_replace('#prdt_frmlc_unit');		//trim
	fn_replaceSpecialChar('#prdt_frmlc_unit');		//특수문자 제거
	
	//제품 및 업체 정보 > 제품구입장소(주소지)
	fn_replace('#prdt_buy_plc');		//trim
	fn_replaceSpecialChar('#prdt_buy_plc');		//특수문자 제거
	
	//제품 및 업체 정보 > 제조원
	if(fn_empty('#makr_cd','${m:getMessageIn("msg.common.valid.required", "제조원") }') == false){
		$('#makr_cd_nm').focus();
		return false;	
	}
	
	//제품 및 업체 정보 > 제조원 소제지 상세
	fn_replace('#makr_dtladdr');		//trim
	fn_replaceSpecialChar('#makr_dtladdr');		//특수문자 제거
	
	//제품 및 업체 정보 > 판매원 소제지 상세
	fn_replace('#salpr_dtladdr');		//trim
	fn_replaceSpecialChar('#salpr_dtladdr');		//특수문자 제거
	
	return true;
}

 /**************************************************************************************
  * Ajax
  **************************************************************************************/
//신고종류 코드를 가져온다.
function fn_selectViltCnCd(selectCd){
  	$.ajax({
  		data: {cmmn_cd: 'CP05', selectCd: selectCd},
  		dataType: 'json',
  		type: 'POST',
  		url: '${contextPath}/minwon/complain/selectCommonCode.do'
  	}).done(function(rstData){
  		var data;
  		var strHtml = '';
  		
  		$.each(rstData, function(idx) {
  			data = null;
  			data = {code: this['fnprt_cd'], code_nm: this['fnprt_cd_nm'], idx: idx};
  			
  			if(idx == 0){
  				data.checked = 'checked="checked"';
  			}else{
  				data.checked = '';
  			}
  			
  			if(this['fnprt_cd'] == '999'){
  				data.code_etc_label = '<label for="rsn" class="hidden">기타</label>';
  				data.code_etc_input = '<input type="text" size="55" name="vilt_cn_prvns" id="vilt_cn_prvns" disabled="disabled">';
  			}else{
  				data.code_etc_label = '';
  				data.code_etc_input = '';
  			}

  			strHtml += innerHtmlMaker('#viltCnCdList', data);
  		});
  		
  		$('#sltViltCnCd').html(strHtml);

  	}).fail(function(request ,status, error){
  		alert('${m:getMessage("msg.common.system.error")}');
  	});
}
 
//이물 종류 코드를 가져온다.
function fn_selectAlnstCd(selectCd){
 	$.ajax({
 		data: {lclas_cd: selectCd},
 		dataType: 'json',
 		type: 'POST',
 		url: '${contextPath}/minwon/complain/selectAlnstCd.do'
 	}).done(function(rstData){
 		var data;
 		var strHtml = '<option value="" selected="selected">2차분류선택</option>';
 		
 		$.each(rstData, function(idx) {
 			data = null;
 			data = {code: this['alnst_cd'], code_nm: this['rm']};

 			strHtml += innerHtmlMaker('#commonOptionList', data);
 		});
 		
 		$('#alnst_cd').html(strHtml);
 		$('#alnst_cd').selecter('update');
 		
 	}).fail(function(request ,status, error){
 		alert('${m:getMessage("msg.common.system.error")}');
 	});
}

//소비자 신고 저장
function fn_saveCustomerNotify(){
	$.ajax({
		data: $('#baseForm').serialize(),
		dataType: 'json',
		type: 'POST',
		url: '${contextPath}/minwon/complain/saveCustomerNotify.do'
	}).done(function(rstData){
		if(rstData.rtnCd == '1'){
			var form = $('<form/>', {method: 'post', action: '${contextPath}/minwon/complain/complainFinished.do'});
			form.append($('<input/>', {type: 'hidden', name: 'doc_no', value: rstData.doc_no}));
			form.append($('<input/>', {type: 'hidden', name: 'pswd', value: rstData.pswd}));
			form.append($('<input/>', {type: 'hidden', name: 'complainType', value: 'customer'}));
			$(document.body).append(form);
			
			form.submit();
			
		}else{
			alert('${m:getMessage("msg.common.system.error")}');
		}
		
	}).fail(function(request ,status, error){
		alert('${m:getMessage("msg.common.system.error")}');
	});
}

/**************************************************************************************
 * Callback
 **************************************************************************************/
 //식품 유형 팝업 콜백
function fn_callbackFoodType(value, name){
	$('#food_type_cd').val(value);
	$('#food_type_cd_nm').val(name);
	$.fancybox.close();
}

//원산지 찾기 팝업 콜백
function fn_callbackFoodBase(value, name){
	$('#incm_natn_cd').val(value);
	$('#incm_natn_cd_nm').val(name);
	$.fancybox.close();
}

//제조원 찾기 팝업 콜백
function fn_callbackShop(makrInfo){
	$('#makr_reg_unreg_bssh_dvs_cd').val(makrInfo.makr_reg_unreg_bssh_dvs_cd);
	$('#makr_cd').val(makrInfo.seq_no);
	$('#makr_cd_nm').val( nvl(makrInfo.bssh_nm) );
	$('#makr_telno').val( nvl(makrInfo.telno) );
	$('#makr_addr').val( nvl(makrInfo.addr) + ' ' + nvl(makrInfo.addr_dtl) );
	$.fancybox.close();
}

//판매원 찾기 팝업 콜백
function fn_callbackVendor(salprInfo){
	$('#salpr_reg_unreg_dvs_cd').val(salprInfo.makr_reg_unreg_bssh_dvs_cd);
	$('#salpr_cd').val(salprInfo.seq_no);
	$('#salpr_cd_nm').val( nvl(salprInfo.bssh_nm) );
	$('#salpr_telno').val( nvl(salprInfo.telno) );
	$('#salpr_addr').val( nvl(salprInfo.addr) + ' ' + nvl(salprInfo.addr_dtl) );
	$.fancybox.close();
}

//파일업로드 콜백
function fn_callbackfileUpload(fileInfo){
	$('#file_yn').val('Y');
	$('#orgnt_file_nm').val(fileInfo.logic_file_nm);
	$('#physic_file_nm').val(fileInfo.physic_file_nm);
	$('#file_save_path').val(fileInfo.file_path);
	$('#file_mg_lengt').val(fileInfo.file_mg);
	$('#file_extns').val(fileInfo.file_type_cd);
	$.fancybox.close();
}
</script>
