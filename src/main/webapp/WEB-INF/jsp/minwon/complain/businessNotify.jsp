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
                        <h1>업체이물보고접수</h1>
                    </div>
                </div>
                <div class="page-container">
                	<!-- 페이지 내용 -->
                    <article>
						<div class="bs-callout bs-callout-danger">
                        	<p>제조원, 판매원, 제품구입(판매)장소 중 1곳 이상은 반드시 기재하여야 조사가 진행되며, 나머지 업소정보를 모를 경우에는 반드시 공란(빈칸)으로 남겨두시기 바랍니다.<br>
                                ※ 모름, 미기재, 0, 점(.), 쉼표(,),O, 말줄임(...), 물음표(?) 등으로 기재 금지 </p>
                        </div>
                        <div class="emphasis">
                        	<ul style="padding-left:15px;margin-bottom:0;">
                            	<li>동 센터는 <strong>식품업체에서 이물발견 클레임에 대하여 보고</strong> 하는 곳 입니다. 소비자의 경우 "소비자신고" 메뉴를 통하여 신고하시기 바랍니다.</li>
                                <li>이물의 발견을 <strong>거짓으로 신고한 자</strong>는 <strong>1년 이하의 징역 또는 300만원 이하의 벌금</strong>에 처해질 수 있습니다.</li>
                            </ul>
                        </div>
                        
                            <fieldset>
                                <legend>문서정보입력양식</legend>
                                <table class="tableset">
                                    <caption>문서정보</caption>
                                    <colgroup>
                                        <col style="width:15%">
                                        <col style="width:35%">
                                        <col style="width:15%">
                                        <col style="width:35%">
                                    </colgroup>
                                    <tbody>
                                        <tr>
                                            <th>문서번호</th>
                                            <td>보고 XXXX-XXXXXXXXXX</td>
                                            <th class="required"><label for="dept_cd_nm" title="필수항목">담당기관</label></th>
                                            <td>
	                                            <input type="text" id="chrg_instt_cd_nm" name="chrg_instt_cd_nm" value="" size="18" title="담당기관" readonly>
	                                            <a href="${contextPath}/popup/commonPopup/selectOrgn.do" class="organization fancybox.iframe btn btn-success btn-sm">기관찾기</a>
											</td>
                                        </tr>
                                    </tbody>
                                </table>
                            </fieldset>
                            <h2>보고업체정보</h2>
                            <fieldset>
                                <legend>보고업체정보입력양식</legend>
                                <table class="tableset">
                                    <caption>보고업체정보</caption>
                                    <colgroup>
                                        <col style="width:15%">
                                        <col style="width:35%">
                                        <col style="width:15%">
                                        <col style="width:35%">
                                    </colgroup>
                                    <tbody>
                                        <tr>
                                            <th class="required"><label for="name" title="필수항목">업체명</label></th>
                                            <td colspan="3"><input type="text" size="24" name="entrps_nm" id="entrps_nm" title="업체명" onkeyup="SUchkLengthObj('500', this);"></td>
                                        </tr>
                                        <tr>
                                            <th><label for="codes1">업종</label></th>
                                            <td colspan="3">
                                            	<ul>
                                            		<c:forEach var="code" items="${indutyDvsCd}" varStatus="status">
                                            			<li><label><input type="radio" name="induty_dvs_cd" id="induty_dvs_cd_${status.index}" value="${code.fnprt_cd}" ${status.index eq '0' ? 'checked="checked"' : ''}> ${code.fnprt_cd_nm}</label></li>
													</c:forEach>
                                                </ul>
                                            </td>
                                        </tr>
                                        <tr>
                                            <th class="required"><label for="busc_mng" title="필수항목">담당자</label></th>
                                            <td><input name="charger_name" id="charger_name" type="text" value="" size="24" onkeyup="SUchkLengthObj('100', this);"></td>
                                            <th class="required"><label for="busc_tel2" title="필수항목">담당자 연락처</label></th>
                                            <td><input name="charger_telno" id="charger_telno" type="text" value="" size="24"></td>
                                        </tr>
                                        <tr>
                                            <th class="required"><label for="pass" title="필수항목">비밀번호</label></th>
                                            <td><input type="password" maxlength="32" size="24" name="pswd" id="pswd" title="비밀번호"></td>
                                            <th class="required"><label for="pass2" title="필수항목">비밀번호 확인</label></th>
                                            <td><input type="password" maxlength="32" size="24" name="pswd_confirm" id="pswd_confirm" title="비밀번호 확인"></td>
                                        </tr>
                                        <tr>
                                            <th class="required"><label for="inform-s" title="필수항목">진행사항 통보방식</label></th>
                                            <td colspan="3">
                                                <ul>
                                                	<c:forEach var="code" items="${dspthWayCd}" varStatus="status">
                                            			<li><label><input type="radio" name="dspth_way_cd" id="dspth_way_cd_${status.index}" value="${code.fnprt_cd}" ${status.index eq '0' ? 'checked="checked"' : ''}> ${code.fnprt_cd_nm}</label></li>
													</c:forEach>
                                                </ul>
                                            </td>
                                        </tr>
                                    </tbody>
                                </table>
                            </fieldset>
                            <h2>소비자인적사항</h2>
                            <fieldset>
                                <legend>소비자인적사항정보정보입력양식</legend>
                                <table class="tableset">
                                    <caption>소비자인적사항정보</caption>
                                    <colgroup>
                                        <col style="width:15%">
                                        <col style="width:35%">
                                        <col style="width:15%">
                                        <col style="width:35%">
                                    </colgroup>
                                    <tbody>
                                        <tr>
                                            <th class="required"><label for="busc_name" title="필수항목">성명</label></th>
                                            <td><input type="text" size="24" name="aplcnt_name" id="aplcnt_name" title="성명" onkeyup="SUchkLengthObj('500', this);"></td>
                                            <th><label for="busc_tel" title="필수항목">연락처</label></th>
                                            <td><input type="text" size="24" name="aplcnt_mbtpno" id="aplcnt_mbtpno" title="연락처"></td>
                                        </tr>
                                        <tr>
                                            <th class="required"><label for="busc_post" title="필수항목">소재지</label></th>
                                            <td colspan="3">
												<!--                                             
                                            	<input type="text" maxlength="7" size="5" name="aplcnt_zipno" id="aplcnt_zipno" title="우편번호" readonly>
                                            	<a href="#" onclick="zipsearch('frm','busc_post','busc_addr');return false;" target="_blank" title="새창으로 열기" class="btn btn-success btn-sm">우편번호찾기</a>
												<input type="text" maxlength="150" size="48" name="aplcnt_postaddr" id="aplcnt_postaddr" title="기본주소" style="margin-left:4px;" readonly="readonly">
                                                <input type="text" maxlength="100" size="62" name="aplcnt_dtl_addr" id="aplcnt_dtl_addr" title="상세주소" style="margin-top:5px;width:767px;" onkeyup="SUchkLengthObj('256', this);">
                                                 -->
                                                 <input type="text" maxlength="7" size="5" name="aplcnt_zipno" id="aplcnt_zipno" title="우편번호">
                                            	<a href="#" onclick="zipsearch('frm','busc_post','busc_addr');return false;" target="_blank" title="새창으로 열기" class="btn btn-success btn-sm">우편번호찾기</a>
												<input type="text" maxlength="150" size="48" name="aplcnt_postaddr" id="aplcnt_postaddr" title="기본주소" style="margin-left:4px;">
                                                <input type="text" maxlength="100" size="62" name="aplcnt_dtl_addr" id="aplcnt_dtl_addr" title="상세주소" style="margin-top:5px;width:767px;" onkeyup="SUchkLengthObj('256', this);">
                                            </td>
                                        </tr>
                                        <tr>
                                    </tbody>
                                </table>
                            </fieldset>
                            <h2>제품 및 업체 정보</h2>
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
                                            <th class="required"><label for="prdt_nm" title="필수항목">제품명</label></th>
                                            <td><input type="text" maxlength="100" size="24" name="prdt_nm" id="prdt_nm" title="제품명" onkeyup="SUchkLengthObj('500', this);"></td>
                                            <th><label for="prod_type">식품유형</label></th>
                                            <td><input type="text" name="food_type_cd_nm" id="food_type_cd_nm" size="16" readonly>
                                            <a href="${contextPath}/popup/commonPopup/selectFoodtype.do" class="foodtype fancybox.iframe btn btn-success btn-sm">식품유형찾기</a>
                                        </tr>
                                        <tr>
                                            <th class="required"><label for="prdt_distb_tmlmt" title="필수항목">유통기한</label></th>
                                            <td><input type="text" maxlength="50" size="24" name="prdt_distb_tmlmt" id="prdt_distb_tmlmt" title="유통기한" onkeyup="SUchkLengthObj('100', this);"></td>
                                            <th><label for="cstdy_stdr">보관기준</label></th>
                                            <td><input type="text" size="24" name="cstdy_stdr" id="cstdy_stdr" title="보관기준" onkeyup="SUchkLengthObj('200', this);"></td>
                                        </tr>
                                        <tr>
                                            <th><label for="prod_unit">포장단위</label></th>
                                            <td><input type="text" size="24" name="prdt_frmlc_unit" id="prdt_frmlc_unit" onkeyup="SUchkLengthObj('60', this);"></td>
                                            <th><label for="origin_name">수입식품여부</label></th>
                                            <td>
												<ul>
													<c:forEach var="code" items="${dICd}" varStatus="status">
														<li>
															<label>
																<input type="radio" name="orgnp_dvs_cd" id="orgnp_dvs_cd_${status.index }" value="${code.fnprt_cd}" ${code.fnprt_cd eq 'D' ? 'checked="checked"' : ''}> ${code.fnprt_cd_nm}
															</label>
															<c:if test="${code.fnprt_cd eq 'E'}">
																<input type="text" size="7" name="incm_natn_cd_nm" id="incm_natn_cd_nm" style="margin-left:10px;" readonly="readonly">
																<a id="origin" href="${contextPath}/popup/commonPopup/selectFoodBase.do" class="origin fancybox.iframe btn btn-success btn-sm">원산지</a>
															</c:if>
														</li>
													</c:forEach>
												</ul>
                                            </td>
                                        </tr>
                                    </tbody>
                                </table>
                            </fieldset>
                            <fieldset>
                                <legend>제품/업체정보입력양식</legend>
                                <table class="tableset" style="margin-top:20px;">
                                    <caption>제품/업체정보</caption>
                                    <colgroup>
                                        <col style="width:15%">
                                        <col style="width:35%">
                                        <col style="width:15%">
                                        <col style="width:35%">
                                    </colgroup>
                                    <tbody>
                                        <tr>
                                            <th class="required"><label for="prod_comp" title="필수항목" >제조원</label></th>
                                            <td>
	                                            <input type="text" name="makr_cd_nm" id="makr_cd_nm" size="17" readonly="readonly">
	                                            <a href="${contextPath}/popup/commonPopup/selectShop.do?allSearch=Y" class="maker fancybox.iframe btn btn-success btn-sm">제조원 찾기</a>
	                                        </td>
                                            <th><label for="prod_tel">제조원 연락처</label></th>
                                            <td><input type="text" size="24" name="makr_telno" id="makr_telno" title="제조원 연락처" readonly="readonly"></td>
                                        </tr>
                                        <tr>
                                            <th><label for="prod_post">제조원 소재지</label></th>
                                            <td colspan="3">
                                            	<!-- 
                                            	<input type="text" maxlength="7" size="5" name="prod_post" id="prod_post" title="우편번호" readonly>
                                            	<a href="zipcode.html" class="zipcode fancybox.iframe btn btn-success btn-sm">우편번호찾기</a> 
                                            	<input type="text" maxlength="150" size="48" name="prod_addr" id="prod_addr" title="제조원 기본주소" style="margin-left:4px;"><br>
                                                <input type="text" maxlength="100" size="62" name="makr_addr" id="makr_addr" title="제조원 주소" style="margin-top:5px;width:767px;">
                                                 -->
                                                 <input type="text" size="62" name="makr_addr" id="makr_addr" title="제조원 주소" style="margin-top:5px;width:767px;" readonly="readonly">
                                            </td>
                                        </tr>
                                        <tr>
                                            <th><label for="sale_comp">판매원</label></th>
                                            <td>
                                            	<input type="text" size="17" name="salpr_cd_nm" id="salpr_cd_nm" title="판매원" readonly="readonly">
                                            	<a href="${contextPath}/popup/commonPopup/selectVendor.do?allSearch=Y" class="vendor fancybox.iframe btn btn-success btn-sm">판매원 찾기</a>
                                            </td>
                                            <th><label for="sale_tel">판매원 연락처</label></th>
                                            <td><input type="text" size="24" name="salpr_telno " id="salpr_telno" title="판매원 연락처" readonly="readonly"></td>
                                        </tr>
                                        <tr>
                                            <th><label for="sale_post">판매원 소재지</label></th>
                                            <td colspan="3">
                                            	<!-- 
	                                            <input type="text" maxlength="7" size="5" name="sale_post" id="sale_post" title="우편번호" readonly>
	                                            <a href="zipcode.html" class="zipcode fancybox.iframe btn btn-success btn-sm">우편번호찾기</a>
												<input type="text" maxlength="150" size="48" name="sale_addr" id="sale_addr" title="판매원 기본주소" style="margin-left:4px;"><br>
                                                <input type="text" maxlength="100" size="62" name="sale_addr2" id="sale_addr2" title="판매원 상세주소" style="margin-top:5px;width:767px;">
                                                 -->
                                                 <input type="text" size="62" name="salpr_addr" id="salpr_addr" title="판매원 주소" style="margin-top:5px;width:767px;" readonly="readonly">
                                            </td>
                                        </tr>
                                    </tbody>
                                </table>
                            </fieldset>
                            <h2>소비자 불만사항 확인 내용</h2>
							<fieldset>
                                <legend>소비자 불만사항 확인 내용 입력양식</legend>
                                <table class="tableset">
                                    <caption>소비자 불만사항 확인 내용</caption>
                                    <colgroup>
                                        <col style="width:15%">
                                        <col style="width:35%">
                                        <col style="width:15%">
                                        <col style="width:35%">
                                    </colgroup>
                                    <tbody>
                                        <tr>
                                            <th class="required"><label for="prod_place" title="필수항목">제품구입장소</label></th>
                                            <td><input name="prdt_buy_plc" id="prdt_buy_plc" name="prdt_buy_plc" type="text" value="" size="24"></td>
                                            <th><label for="prod_buy_date">제품구입일</label></th>
                                            <td>
                                            	<div class="input-group date">
                                                    <input type="text" name="prdt_buy_dt" id="prdt_buy_dt" class="form-control" readonly size="8" value="">
                                                    <span class="input-group-addon"><i class="glyphicon glyphicon-th"></i></span></li>
                                                <div>
                                            </td>
                                        </tr>
                                        <tr>
                                            <th><label for="prod_open_date">제품개봉일</label></th>
                                            <td>
                                            	<div class="input-group date">
                                                    <input type="text" name="prdt_opn_dt" id="prdt_opn_dt" class="form-control" readonly size="8" value="">
                                                    <span class="input-group-addon"><i class="glyphicon glyphicon-th"></i></span></li>
                                                <div>
                                            </td>
                                            <th><label for="sub_find_date">이물발견일</label></th>
                                            <td>
                                            	<div class="input-group date">
                                                    <input type="text" name="sub_find_date" id="alnst_discov_dt" class="alnst_discov_dt" readonly size="8" value="">
                                                    <span class="input-group-addon"><i class="glyphicon glyphicon-th"></i></span></li>
                                                <div>
                                            </td>
                                        </tr>
                                        <tr>
                                            <th class="required"><label for="keep_flag1" title="필수항목">증거제품보관</label></th>
                                            <td colspan="3">
                                                <ul>
                                                	<c:forEach var="code" items="${keepFlagCd}" varStatus="status">
		                                               	<li><label><input type="checkbox" name="keep_flag_list" id="keep_flag_list_${status.index }" value="${code.fnprt_cd}" title="${code.fnprt_cd_nm}">${code.fnprt_cd_nm}</label></li>
													</c:forEach>
													<!-- 
                                                    <li><label><input type="checkbox" name="keep_flag" id="keep_flag1" value="A" title="현품"> 현품</label></li>
                                                    <li><label><input type="checkbox" name="keep_flag" id="keep_flag2" value="B" title="사진"> 사진</label></li>
                                                    <li><label><input type="checkbox" name="keep_flag" id="keep_flag3" value="C" title="이물"> 이물</label></li>
                                                    <li><label><input type="checkbox" name="keep_flag" id="keep_flag4" value="D" title="업체회수"> 업체회수</label></li>
                                                    <li><label><input type="checkbox" name="keep_flag" id="keep_flag5" value="E" title="기타"> 기타</label></li>
                                                     -->
                                                </ul>
                                            </td>
                                         </tr>
                                         <tr>
                                            <th><label for="aclass">이물종류</label></th>
                                            <td colspan="3">
                                            	<ul>
                                                    <li>
                                                    	<div class="select-container w130">
                                                            <select id="alnst_cd_hrnkCd" name="alnst_cd_hrnkCd" title="이물 1차 분류">
                                                                <option value="" selected="selected">1차분류선택</option>
																<c:forEach var="code" items="${alnstCd}" varStatus="status">
																	<option value="${code.lclas_cd}">${code.rm}</option>
																</c:forEach>
                                                            </select>
                                                        </div>
                                                    </li>
                                                    <li>
                                                        <div class="select-container w370">
                                                            <select id="alnst_cd" name="alnst_cd" title="이물 2차 분류">
                                                                <option value="" selected="selected">2차분류선택</option>
                                                            </select>
                                                        </div>
                                                    </li>
                                                    <li><input type="text" name="alnst_dett_etc" id="alnst_dett_etc" size="16" title="기타이물내용입력" onkeyup="SUchkLengthObj('300', this)"></li>
                                                    <li>* 동물성 이물 중 그 외, 식물성 이물 중 그 외, 광물성 이물 중 그 외, 기타 이물 중 그외 선택 시에는  해당 내용을 입력해주세요.</li>
                                                </ul>
                                            </td>
                                         </tr>
                                         <tr>
                                            <th><label for="comments">이물형태</label></th>
                                            <td colspan="3">
	                                            <textarea cols="55" rows="5" id="alnst_dispos" name="alnst_dispos" title="이물형태" onkeyup="SUchkLengthObj('2048', this)"></textarea>
	                                            <p>* 색상, 크기, 개수, 성상 등</p>
                                            </td>
                                         </tr>
                                         <tr>
                                            <th><label for="file" title="필수항목">이물자료첨부</label></th>
                                            <td colspan="3">
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
                                        <tr>
                                            <th class="required"><label for="alnst_discov_promn">이물발견경위</label></th>
                                            <td colspan="3">
                                            	<textarea cols="55" rows="5" id="alnst_discov_promn" name="alnst_discov_promn" title="이물발견경위"></textarea>
                                                <p>* 6하원칙에 따라 상세히 작성<br>
                                                    - 제품개봉 직후 발견, 개봉후 보관하면서 3개월간 섭취 중 발견<br>
                                                    - 조리하여 섭취 중 발견, 한입 먹던 중 입속에서 발견 등<br>
                                                    - 개봉하지 않은 유사제품 보관여부 등</p>
                                           </td>
                                        </tr>
                                        <tr>
                                            <th><label for="sub_keep">이물발견<br>제품보관환경</label></th>
                                            <td colspan="3">
                                            	<textarea cols="55" rows="5" id="alnst_prdt_cstdy_envrn" name="alnst_prdt_cstdy_envrn" title="이물발견 제품보관환경"></textarea>
                                            	<p>* 주변환경을 조사하여 소비자 부주의 등에 대한 조사 실시<br>
                                                    - 발견된 이물이 소비자 주변에서 쉽게 확인<br>
                                                    * 제품 보관온도 등 조사</p>
                                            </td>
                                        </tr>
                                        <tr>
                                            <th><label for="exam_rsn">보고자 의견</label></th>
                                            <td colspan="3">
                                            	<textarea cols="55" rows="5" id="examr_opnn" name="examr_opnn" title="보고자 의견"></textarea>
                                            	<p>* 이물 혼입 원인에 대한 조사결과 기록 : 소비자 부주의 등<br>
                                                    * 소비자 피해보상 요구사항 등 작성</p>
                                            </td>
                                        </tr>
                                        <tr>
                                            <th><label for="comp_date">클레임 접수일시</label></th>
                                            <td colspan="3">
                                            	<div class="input-group date">
                                                    <input type="text" name="sttemnt_dt" id="sttemnt_dt" class="form-control" readonly size="8" value="">
                                                    <span class="input-group-addon"><i class="glyphicon glyphicon-th"></i></span></li>
                                                <div>
                                            </td>
                                        </tr>
                                    </tbody>
                                </table>
                            </fieldset>
                            <div class="btn-container">
                                <button type="button" class="btn btn-default btn-lg" id="submitBtn">등록</button>
                                <button type="button" class="btn btn-danger btn-lg" id="cancelBtn">취소</button>
                            </div>
                            
                    </article>
                </div>
            </section>
            
            <input type="hidden" name="chrg_instt_cd" id="chrg_instt_cd" value="">					<!-- 부서 코드 -->
            <input type="hidden" name="food_type_cd" id="food_type_cd" value="">					<!-- 식품유형코드 -->
            <input type="hidden" name="incm_natn_cd" id="incm_natn_cd" value="" />				<!-- 수입국가코드 -->
            <input type="hidden" name="makr_cd" id="makr_cd" value="" />								<!-- 제조원코드 -->
            <input type="hidden" name="makr_reg_unreg_bssh_dvs_cd" id="makr_reg_unreg_bssh_dvs_cd" value="" /><!-- 제조사 등록 미등록 업소 구분 코드  -->
            <input type="hidden" name="salpr_cd" id="salpr_cd" value="" />								<!-- 판매원코드 -->
            <input type="hidden" name="salpr_reg_unreg_dvs_cd" id="salpr_reg_unreg_dvs_cd" value="" /><!-- 판매원_등록_미등록_구분_코드    -->
            
            <input type="hidden" name="file_yn" id="file_yn" value="">										<!-- 파일첨부 여부 -->
            <input type="hidden" name="physic_file_nm" id="physic_file_nm" value="">				<!-- 서버에 저장된 파일 이름 -->
            <input type="hidden" name="file_save_path" id="file_save_path" value="">				<!-- 파일 위치 -->
            <input type="hidden" name="file_extns" id="file_extns" value="">								<!-- 파일 유형 코드  -->
            <input type="hidden" name="file_mg_lengt" id="file_mg_lengt" value="">					<!-- 파일용량 -->


<script id="commonOptionList" type="text/html">
	<option value="{code}">{code_nm}</option>
</script>
<script type="text/javascript">
/***************************************************************************************
* 시스템명 	: 식품의약품안전처 통합식품안전망구축
* 업무명 		: 업체이물신고
* 파일명 		: businessNotify.jsp
* 작성자 		: 장영철
* 작성일 		: 2014.10.14
*
* 설  명		: 업체이물신고
*------------------------------------------------------------------------------------
* 변경일	변경자		변경내역 
*------------------------------------------------------------------------------------
*  2014.10.14 장영철		최초 프로그램 작성         
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
	//원산지 찾기 버튼 숨기기
	$('#origin').hide();
	//원산지 input box 숨기기
	$('#incm_natn_cd_nm').hide();
	
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
	
	//이물구분 상위코드 change 이벤트
	$('#alnst_cd_hrnkCd').change(function(){
		fn_selectAlnstCd($(this).val());
	});
	
	//저장버튼 클릭 이벤트
	$('#submitBtn').click(function(){
		fn_saveData();
	});
	
	//취소버튼 클릭 이벤트
	$('#cancelBtn').click(function(){
		location.href = '${contextPath}/minwon/complain/businessNotify.do';
	});
});
/**************************************************************************************
 * Function
 **************************************************************************************/
//저장
function fn_saveData(){
	
	if(!fn_validate()){
		return;
	}
	
	if(confirm('${m:getMessage("msg.common.save.confirm")}')){
		fn_saveBusinessNotify();
	}
	
}
/**************************************************************************************
 * Validation
 **************************************************************************************/
//유효성 체크
 function fn_validate(){
 	
 	//담당기관
 	if(fn_empty('#chrg_instt_cd','${m:getMessageIn("msg.common.valid.required", "담당기관") }') == false){	
 		return false;	
 	}
 	
 	//보고업체정보 > 업체명
	fn_replaceSpecialChar('#entrps_nm');		//특수문자 제거
	if(fn_empty('#entrps_nm','${m:getMessageIn("msg.common.valid.required", "업체명") }') == false){	
 		return false;	
 	}
	
	//보고업체정보 > 담당자
	fn_replaceSpecialChar('#charger_name');		//특수문자 제거
	if(fn_empty('#charger_name','${m:getMessageIn("msg.common.valid.required", "담당자") }') == false){	
 		return false;	
 	}
	
	//보고업체정보 > 담당자 연락처
	if(fn_empty('#charger_telno','${m:getMessageIn("msg.common.valid.required", "담당자 연락처") }') == false){	
		return false;	
	}
	if(fn_phonNumer('#charger_telno','${m:getMessage("msg.common.valid.phoneNumer")}') == false){	
		return false;	
	}
	
	//보고업체정보 > 비밀번호
	if($('#pswd').val() != $('#pswd_confirm').val()){
		alert('${m:getMessage("msg.common.valid.password")}');
		$('#pswd').focus();
		return false;
	}
	
	//소비자인적사항 > 성명
	if(fn_empty('#aplcnt_name','${m:getMessageIn("msg.common.valid.required", "성명") }') == false){	
		return false;	
	}
	
	//소비자인적사항 > 연락처
	if($('#aplcnt_mbtpno').val() != '' && fn_phonNumer('#aplcnt_mbtpno','${m:getMessage("msg.common.valid.phoneNumer")}') == false){	
		return false;	
	}
	
	//소비자인적사항 > 소재지
	if(fn_empty('#aplcnt_zipno','${m:getMessageIn("msg.common.valid.required", "소재지") }') == false){	
		return false;	
	}
	if(fn_empty('#aplcnt_postaddr','${m:getMessageIn("msg.common.valid.required", "소재지") }') == false){	
		return false;	
	}
	if(fn_empty('#aplcnt_dtl_addr','${m:getMessageIn("msg.common.valid.required", "소재지") }') == false){	
		return false;	
	}
	
	//제품 및 업체 정보 > 제품명
	fn_replaceSpecialChar('#prdt_nm');		//특수문자 제거
	if(fn_empty('#prdt_nm','${m:getMessageIn("msg.common.valid.required", "제품명") }') == false){	
 		return false;	
 	}
	
	//제품 및 업체 정보 > 유통기한
	fn_replaceSpecialChar('#prdt_distb_tmlmt');		//특수문자 제거
	if(fn_empty('#prdt_distb_tmlmt','${m:getMessageIn("msg.common.valid.required", "유통기한") }') == false){	
 		return false;	
 	}
	
	//제품 및 업체 정보 > 보관기준
	fn_replaceSpecialChar('#cstdy_stdr');		//특수문자 제거
	
	//제품 및 업체 정보 > 포장단위
	fn_replaceSpecialChar('#prdt_frmlc_unit');		//특수문자 제거
	
	//제품 및 업체 정보 > 제조원
	if(fn_empty('#makr_cd','${m:getMessageIn("msg.common.valid.required", "제조원") }') == false){
		$('#makr_cd_nm').focus();
		return false;	
	}
	
	//소비자 불만사항 확인 내용 > 제품구입장소
	fn_replaceSpecialChar('#prdt_buy_plc');		//특수문자 제거
	if(fn_empty('#prdt_buy_plc','${m:getMessageIn("msg.common.valid.required", "제품구입장소") }') == false){	
 		return false;	
 	}
	
	//소비자 불만사항 확인 내용 > 증거제품보관
	var keep_flag_value = '';
	$('input[name=keep_flag_list]:checked').each(function(idx){
		keep_flag_value = $(this).val();
	});
	if(keep_flag_value == '' || keep_flag_value == 'undefined'){
		alert('${m:getMessageIn("msg.common.valid.required", "증거제품보관") }');
		$('#keep_flag_list_0').focus();
		return false;	
	}
	
	//소비자 불만사항 확인 내용 > 이물종류 > 3차 
	fn_replaceSpecialChar('#alnst_dett_etc');		//특수문자 제거
	
	//소비자 불만사항 확인 내용 > 이물형태
	fn_replaceSpecialChar('#alnst_dispos');		//특수문자 제거
	
	//소비자 불만사항 확인 내용 > 이물발견경위
	fn_replaceSpecialChar('#alnst_discov_promn');		//특수문자 제거
	if(fn_empty('#alnst_discov_promn','${m:getMessageIn("msg.common.valid.required", "이물발견경위") }') == false){	
 		return false;	
 	}
	
	//소비자 불만사항 확인 내용 > 이물발견 제품보관환경
	fn_replaceSpecialChar('#alnst_prdt_cstdy_envrn');		//특수문자 제거
	
	//소비자 불만사항 확인 내용 > 보고자 의견
	fn_replaceSpecialChar('#examr_opnn');		//특수문자 제거
	
 	return true;
 }
 /**************************************************************************************
  * Ajax
  **************************************************************************************/
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
function fn_saveBusinessNotify(){
	$.ajax({
		data: $('#baseForm').serialize(),
		dataType: 'json',
		type: 'POST',
		url: '${contextPath}/minwon/complain/saveBusinessNotify.do'
	}).done(function(rstData){
		if(rstData.rtnCd == '1'){
			var form = $('<form/>', {method: 'post', action: '${contextPath}/minwon/complain/complainFinished.do'});
			form.append($('<input/>', {type: 'hidden', name: 'doc_no', value: rstData.doc_no}));
			form.append($('<input/>', {type: 'hidden', name: 'pswd', value: rstData.pswd}));
			form.append($('<input/>', {type: 'hidden', name: 'complainType', value: 'business'}));
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
//기관 찾기 팝업 콜백
function fn_callbackOrgn(value, name){
	$('#chrg_instt_cd').val(value);
	$('#chrg_instt_cd_nm').val(name);
	$.fancybox.close();
}
 
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