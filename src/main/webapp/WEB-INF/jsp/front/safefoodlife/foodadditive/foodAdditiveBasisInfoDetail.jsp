<%@page import="java.util.ArrayList"%>
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
%><%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"
%><%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"
%><%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"
%>

<c:if test="${!(foodAdditiveBasisInfoVO.page_gubun eq '1' and foodAdditiveBasisInfoVO.procs_cl eq '4')}">
<div class="buttonwrapper boardList1Tab">
	<ul>
	<c:if test="${foodAdditiveBasisInfoVO.page_gubun ne '1' and foodAdditiveTotalSerial.com_serial > 0}">
		<li class=""><a class="squarebutton"  href="?page_gubun=1&procs_cl=${foodAdditiveBasisInfoVO.procs_cl}&keyfield=${foodAdditiveBasisInfoVO.keyfield}&key=${foodAdditiveBasisInfoVO.key}&page=${foodAdditiveBasisInfoVO.page}&adtv_cd=${foodAdditiveBasisInfoVO.adtv_cd}"><span>식품첨가물공전</span></a></li>
	</c:if>
	<c:if test="${foodAdditiveBasisInfoVO.page_gubun ne '2' and foodAdditiveTotalSerial.com_serial > 0}">
		<li class=""><a class="squarebutton" href="?page_gubun=2&procs_cl=${foodAdditiveBasisInfoVO.procs_cl}&keyfield=${foodAdditiveBasisInfoVO.keyfield}&key=${foodAdditiveBasisInfoVO.key}&page=${foodAdditiveBasisInfoVO.page}&adtv_cd=${foodAdditiveBasisInfoVO.adtv_cd}"><span>품목별기본정보</span></a></li>
	</c:if>
	<c:if test="${foodAdditiveBasisInfoVO.page_gubun ne '3' and foodAdditiveTotalSerial.jecfa_serial > 0}">
		<li class=""><a class="squarebutton" href="?page_gubun=3&procs_cl=${foodAdditiveBasisInfoVO.procs_cl}&keyfield=${foodAdditiveBasisInfoVO.keyfield}&key=${foodAdditiveBasisInfoVO.key}&page=${foodAdditiveBasisInfoVO.page}&adtv_cd=${foodAdditiveBasisInfoVO.adtv_cd}"><span>JECFA</span></a></li>
	</c:if>
	<c:if test="${foodAdditiveBasisInfoVO.page_gubun ne '4' and foodAdditiveTotalSerial.fcc_serial > 0}">
		<li class=""><a class="squarebutton" href="?page_gubun=4&procs_cl=${foodAdditiveBasisInfoVO.procs_cl}&keyfield=${foodAdditiveBasisInfoVO.keyfield}&key=${foodAdditiveBasisInfoVO.key}&page=${foodAdditiveBasisInfoVO.page}&adtv_cd=${foodAdditiveBasisInfoVO.adtv_cd}"><span>미국</span></a></li>
	</c:if>
	<c:if test="${foodAdditiveBasisInfoVO.page_gubun ne '5' and foodAdditiveTotalSerial.eu_serial > 0}">
		<li class=""><a class="squarebutton" href="?page_gubun=5&procs_cl=${foodAdditiveBasisInfoVO.procs_cl}&keyfield=${foodAdditiveBasisInfoVO.keyfield}&key=${foodAdditiveBasisInfoVO.key}&page=${foodAdditiveBasisInfoVO.page}&adtv_cd=${foodAdditiveBasisInfoVO.adtv_cd}"><span>EU</span></a></li>
	</c:if>
	<c:if test="${foodAdditiveBasisInfoVO.page_gubun ne '6' and foodAdditiveTotalSerial.codex_serial > 0}">
		<li class=""><a class="squarebutton" href="?page_gubun=6&procs_cl=${foodAdditiveBasisInfoVO.procs_cl}&keyfield=${foodAdditiveBasisInfoVO.keyfield}&key=${foodAdditiveBasisInfoVO.key}&page=${foodAdditiveBasisInfoVO.page}&adtv_cd=${foodAdditiveBasisInfoVO.adtv_cd}"><span>CODEX</span></a></li>
	</c:if>
	<c:if test="${foodAdditiveBasisInfoVO.page_gubun ne '7' and foodAdditiveTotalSerial.ja_serial > 0}">
		<li class=""><a class="squarebutton" href="?page_gubun=7&procs_cl=${foodAdditiveBasisInfoVO.procs_cl}&keyfield=${foodAdditiveBasisInfoVO.keyfield}&key=${foodAdditiveBasisInfoVO.key}&page=${foodAdditiveBasisInfoVO.page}&adtv_cd=${foodAdditiveBasisInfoVO.adtv_cd}"><span>일본공정서</span></a></li>
	</c:if>	
	</ul>
</div>
</c:if>

<table class="tableBasic1 mgbt20" summary="품목별 정보">
	<caption>품목별 정보</caption>
	<colgroup>
		<col width="25%" />
		<col />

	</colgroup>

	<tbody>
	<c:choose>
		<c:when test="${foodAdditiveBasisInfoVO.page_gubun eq '1'}">
			<!-- 식품첨가물공전 -->
			<c:choose>
				<c:when test="${foodAdditiveBasisInfoVO.procs_cl eq '4'}">
						<tr>
							<th scope="row" class="alignL pdL20">순번</th>
							<td class="alignL">${foodAdditiveBasisInfoDetail.manage_no}</td>
						</tr>
						<tr>
							<th scope="row" class="alignL pdL20">물질명</th>
							<td class="alignL">${foodAdditiveBasisInfoDetail.mttr_nm}</td>
						</tr>
						<tr>
							<th scope="row" class="alignL pdL20">CFR</th>
							<td class="alignL">${foodAdditiveBasisInfoDetail.cfr_no}</td>
						</tr>
						<tr>
							<th scope="row" class="alignL pdL20">JECFA NO.</th>
							<td class="alignL">${foodAdditiveBasisInfoDetail.jecfa_no}</td>
						</tr>
						<tr>
							<th scope="row" class="alignL pdL20">FEMA NO.</th>
							<td class="alignL">${foodAdditiveBasisInfoDetail.fema_no}</td>
						</tr>
						<tr>
							<th scope="row" colspan="2" class="alignL pdL20"><b>EU Register</b></th>
						</tr>
						<tr>
							<th scope="row" class="alignL pdL20">FL NO.</th>
							<td class="alignL">${foodAdditiveBasisInfoDetail.eu_fl_no}</td>
						</tr>
						<tr>
							<th scope="row" class="alignL pdL20">Chemical group</th>
							<td class="alignL">${foodAdditiveBasisInfoDetail.eu_chms_grp}</td>
						</tr>
						<tr>
							<th scope="row" class="alignL pdL20">이명</th>
							<td class="alignL">${foodAdditiveBasisInfoDetail.ncknm}</td>
						</tr>
				</c:when>
				<c:otherwise>
						<tr>
							<th scope="row" class="alignL pdL20">식품첨가물명</th>
							<td class="alignL">${foodAdditiveBasisInfoDetail.adtv_nm}</td>
						</tr>
						<tr>
							<th scope="row" class="alignL pdL20">식품첨가물영문명</th>
							<td class="alignL">${foodAdditiveBasisInfoDetail.adtv_eng_nm}</td>
						</tr>
			<c:if test="${not empty foodAdditiveBasisInfoDetail.ncknm}">
						<tr>
							<th scope="row" class="alignL pdL20">이명</th>
							<td class="alignL">${foodAdditiveBasisInfoDetail.ncknm}</td>
						</tr>
			</c:if>
			<c:if test="${not empty foodAdditiveBasisInfoDetail.stctr}">
						<tr>
							<th scope="row" class="alignL pdL20">구조식</th>
							<td class="alignL">
								<img src="/files/upload/fa/standard/structural_img/${foodAdditiveBasisInfoDetail.stctr}" alt="식품첨가물 화학식" />
							</td>
						</tr>
			</c:if>
			<c:if test="${not empty foodAdditiveBasisInfoDetail.chmsfod}">
						<tr>
							<th scope="row" class="alignL pdL20">화학식</th>
							<td class="alignL">${foodAdditiveBasisInfoDetail.chmsfod}</td>
						</tr>
			</c:if>
			<c:if test="${not empty foodAdditiveBasisInfoDetail.mcwgh}">
						<tr>
							<th scope="row" class="alignL pdL20">분자량</th>
							<td class="alignL">${foodAdditiveBasisInfoDetail.mcwgh}</td>
						</tr>
			</c:if>
			<c:if test="${not empty foodAdditiveBasisInfoDetail.dfn}">
						<tr>
							<th scope="row" class="alignL pdL20">정의</th>
							<td class="alignL">${foodAdditiveBasisInfoDetail.dfn}</td>
						</tr>
			</c:if>
			<c:if test="${not empty foodAdditiveBasisInfoDetail.cont}">
						<tr>
							<th scope="row" class="alignL pdL20">함량</th>
							<td class="alignL">${foodAdditiveBasisInfoDetail.cont}</td>
						</tr>
			</c:if>
						<tr>
							<th scope="row" class="alignL pdL20">성상</th>
							<td class="alignL">${foodAdditiveBasisInfoDetail.dispos_1}</td>
						</tr>
						<tr>
							<th scope="row" class="alignL pdL20">확인시험</th>
							<td class="alignL">${foodAdditiveBasisInfoDetail.dfn}</td>
						</tr>
						<tr>
							<th scope="row" class="alignL pdL20">순도시험</th>
							<td class="alignL">${foodAdditiveBasisInfoDetail.puredo_test}</td>
						</tr>
			<c:if test="${not empty foodAdditiveBasisInfoDetail.itm_cn_a_1}">
						<tr>
							<th scope="row" class="alignL pdL20">${foodAdditiveBasisInfoDetail.itm_nm_a}</th>
							<td class="alignL">${foodAdditiveBasisInfoDetail.itm_cn_a_1}</td>
						</tr>
			</c:if>
			<c:if test="${not empty foodAdditiveBasisInfoDetail.itm_cn_b_1}">
						<tr>
							<th scope="row" class="alignL pdL20">${foodAdditiveBasisInfoDetail.itm_nm_b}</th>
							<td class="alignL">${foodAdditiveBasisInfoDetail.itm_cn_b_1}</td>
						</tr>
			</c:if>
			<c:if test="${not empty foodAdditiveBasisInfoDetail.itm_cn_c_1}">
						<tr>
							<th scope="row" class="alignL pdL20">${foodAdditiveBasisInfoDetail.itm_nm_c}</th>
							<td class="alignL">${foodAdditiveBasisInfoDetail.itm_cn_c_1}</td>
						</tr>
			</c:if>
			<c:if test="${not empty foodAdditiveBasisInfoDetail.itm_cn_d_1}">
						<tr>
							<th scope="row" class="alignL pdL20">${foodAdditiveBasisInfoDetail.itm_nm_d}</th>
							<td class="alignL">${foodAdditiveBasisInfoDetail.itm_cn_d_1}</td>
						</tr>
			</c:if>
			<c:if test="${not empty foodAdditiveBasisInfoDetail.fdqntlaw1}">
						<tr>
							<th scope="row" class="alignL pdL20">정량법${foodAdditiveBasisInfoDetail.fdqntlaw_dvs}</th>
							<td class="alignL">${foodAdditiveBasisInfoDetail.fdqntlaw1}</td>
						</tr>
			</c:if>
			<c:if test="${not empty foodAdditiveBasisInfoDetail.itm_cn_k_1}">
						<tr>
							<th scope="row" class="alignL pdL20">${foodAdditiveBasisInfoDetail.itm_nm_k}</th>
							<td class="alignL">${foodAdditiveBasisInfoDetail.itm_cn_k_1}</td>
						</tr>
			</c:if>
			<c:if test="${not empty foodAdditiveBasisInfoDetail.itm_cn_l_1}">
						<tr>
							<th scope="row" class="alignL pdL20">${foodAdditiveBasisInfoDetail.itm_nm_l}</th>
							<td class="alignL">${foodAdditiveBasisInfoDetail.itm_cn_l_1}</td>
						</tr>
			</c:if>
			<c:if test="${not empty foodAdditiveBasisInfoDetail.use_stdr_1}">
						<tr>
							<th scope="row" class="alignL pdL20">${foodAdditiveBasisInfoDetail.use_stdr_itm_nm}</th>
							<td class="alignL">${foodAdditiveBasisInfoDetail.use_stdr_1}</td>
						</tr>
			</c:if>
				</c:otherwise>
			</c:choose>
		</c:when>
		<c:when test="${foodAdditiveBasisInfoVO.page_gubun eq '2'}">
			<!-- 품목별 기본정보 -->
						<tr>
							<th scope="row" class="alignL pdL20">식품첨가물명</th>
							<td class="alignL">${foodAdditiveBasisInfoDetail.adtv_nm}</td>
						</tr>
						<tr>
							<th scope="row" class="alignL pdL20">식품첨가물영문명</th>
							<td class="alignL">${foodAdditiveBasisInfoDetail.adtv_eng_nm}</td>
						</tr>
			<c:if test="${not empty foodAdditiveBasisInfoDetail.ncknm}">
						<tr>
							<th scope="row" class="alignL pdL20">이명</th>
							<td class="alignL">${foodAdditiveBasisInfoDetail.ncknm}</td>
						</tr>
			</c:if>
			<c:if test="${not empty foodAdditiveBasisInfoDetail.stctr}">
						<tr>
							<th scope="row" class="alignL pdL20">구조식</th>
							<td class="alignL">
								<img src="/files/upload/fa/standard/structural_img/${foodAdditiveBasisInfoDetail.stctr}" alt="식품첨가물 화학식" />
							</td>
						</tr>
			</c:if>
			<c:if test="${not empty foodAdditiveBasisInfoDetail.chmsfod}">
						<tr>
							<th scope="row" class="alignL pdL20">화학식</th>
							<td class="alignL">${foodAdditiveBasisInfoDetail.chmsfod}</td>
						</tr>
			</c:if>
			<c:if test="${not empty foodAdditiveBasisInfoDetail.mcwgh}">
						<tr>
							<th scope="row" class="alignL pdL20">분자량</th>
							<td class="alignL">${foodAdditiveBasisInfoDetail.mcwgh}</td>
						</tr>
			</c:if>
			<c:if test="${not empty foodAdditiveBasisInfoDetail.cfr_no}">
						<tr>
							<th scope="row" class="alignL pdL20">CFR번호</th>
							<td class="alignL">${foodAdditiveBasisInfoDetail.cfr_no}</td>
						</tr>
			</c:if>
						<tr>
							<th scope="row" class="alignL pdL20">EU번호</th>
							<td class="alignL">${foodAdditiveBasisInfoDetail.eu_no}</td>
						</tr>
						<tr>
							<th scope="row" class="alignL pdL20">CAS번호</th>
							<td class="alignL">${foodAdditiveBasisInfoDetail.cas_no}</td>
						</tr>
						<tr>
							<th scope="row" class="alignL pdL20">INS번호</th>
							<td class="alignL">${foodAdditiveBasisInfoDetail.ins_no}</td>
						</tr>
			<c:if test="${not empty foodAdditiveBasisInfoDetail.fema_no}">
						<tr>
							<th scope="row" class="alignL pdL20">FEMA번호</th>
							<td class="alignL">${foodAdditiveBasisInfoDetail.fema_no}</td>
						</tr>
			</c:if>
			<c:if test="${not empty foodAdditiveBasisInfoDetail.origin}">
						<tr>
							<th scope="row" class="alignL pdL20">유래</th>
							<td class="alignL">${foodAdditiveBasisInfoDetail.origin}</td>
						</tr>
			</c:if>
			<c:if test="${not empty foodAdditiveBasisInfoDetail.physic_chmcl_chartr}">
						<tr>
							<th scope="row" class="alignL pdL20">물리화학적특성</th>
							<td class="alignL">${foodAdditiveBasisInfoDetail.physic_chmcl_chartr}</td>
						</tr>
			</c:if>
			<c:if test="${not empty foodAdditiveBasisInfoDetail.mnf_mthd}">
						<tr>
							<th scope="row" class="alignL pdL20">제조방법</th>
							<td class="alignL">${foodAdditiveBasisInfoDetail.mnf_mthd}</td>
						</tr>
			</c:if>
						<tr>
							<th scope="row" class="alignL pdL20">주요용도</th>
							<td class="alignL">${foodAdditiveBasisInfoDetail.main_prpos}</td>
						</tr>
						<tr>
							<th scope="row" class="alignL pdL20">JECFA 평가</th>
							<td class="alignL">${foodAdditiveBasisInfoDetail.jecfa_evl}</td>
						</tr>
						<tr>
							<th scope="row" class="alignL pdL20">독성자료</th>
							<td class="alignL">${foodAdditiveBasisInfoDetail.toxcty_data}</td>
						</tr>
		</c:when>
		<c:when test="${foodAdditiveBasisInfoVO.page_gubun eq '3'}">
						<tr>
							<th scope="row" class="alignL pdL20">식품첨가물명</th>
							<td class="alignL">${foodAdditiveBasisInfoDetail.adtv_nm}</td>
						</tr>
						<tr>
							<th scope="row" class="alignL pdL20">식품첨가물영문명</th>
							<td class="alignL">${foodAdditiveBasisInfoDetail.adtv_eng_nm}</td>
						</tr>
						<tr>
							<th scope="row" class="alignL pdL20">이명</th>
							<td class="alignL">${foodAdditiveBasisInfoDetail.ncknm}</td>
						</tr>
			<c:if test="${not empty foodAdditiveBasisInfoDetail.dfn}">
						<tr>
							<th scope="row" class="alignL pdL20">정의</th>
							<td class="alignL">${foodAdditiveBasisInfoDetail.dfn}</td>
						</tr>
			</c:if>
			<c:if test="${not empty foodAdditiveBasisInfoDetail.cas_no}">
						<tr>
							<th scope="row" class="alignL pdL20">CAS Number</th>
							<td class="alignL">${foodAdditiveBasisInfoDetail.cas_no}</td>
						</tr>
			</c:if>
			<c:if test="${not empty foodAdditiveBasisInfoDetail.chmsfod}">
						<tr>
							<th scope="row" class="alignL pdL20">화학식</th>
							<td class="alignL">${foodAdditiveBasisInfoDetail.chmsfod}</td>
						</tr>
			</c:if>
			<c:if test="${not empty foodAdditiveBasisInfoDetail.stctr}">
						<tr>
							<th scope="row" class="alignL pdL20">구조식</th>
							<td class="alignL">
								<img src="/files/upload/fa/standard/structural_img/${foodAdditiveBasisInfoDetail.stctr}" alt="식품첨가물 화학식" />
							</td>
						</tr>
			</c:if>
			<c:if test="${not empty foodAdditiveBasisInfoDetail.mcwgh}">
						<tr>
							<th scope="row" class="alignL pdL20">분자량</th>
							<td class="alignL">${foodAdditiveBasisInfoDetail.mcwgh}</td>
						</tr>
			</c:if>
			<c:if test="${not empty foodAdditiveBasisInfoDetail.chmsnm}">
						<tr>
							<th scope="row" class="alignL pdL20">화학명</th>
							<td class="alignL">${foodAdditiveBasisInfoDetail.chmsnm}</td>
						</tr>
			</c:if>
			<c:if test="${not empty foodAdditiveBasisInfoDetail.cont}">
						<tr>
							<th scope="row" class="alignL pdL20">함량</th>
							<td class="alignL">${foodAdditiveBasisInfoDetail.cont}</td>
						</tr>
			</c:if>
						<tr>
							<th scope="row" colspan="2" class="alignL pdL20"><b>성상</b></th>
						</tr>
						<tr>
							<td scope="row" colspan="2" class="alignL pdL20">&nbsp;${foodAdditiveBasisInfoDetail.dispos_1}</td>
						</tr>
						<tr>
							<th scope="row" colspan="2" class="alignL pdL20"><b>용도</b></th>
						</tr>
						<tr>
							<td scope="row" colspan="2" class="alignL pdL20">&nbsp;${foodAdditiveBasisInfoDetail.prpos}</td>
						</tr>
						<tr>
							<th scope="row" colspan="2" class="alignL pdL20"><b>확인시험</b></th>
						</tr>
			<c:if test="${not empty foodAdditiveBasisInfoDetail.cnfm_test}">
						<tr>
							<td scope="row" colspan="2" class="alignL pdL20">&nbsp;${foodAdditiveBasisInfoDetail.cnfm_test}</td>
						</tr>
			</c:if>
						<tr>
							<th scope="row" colspan="2" class="alignL pdL20"><b>순도시험</b></th>
						</tr>
						<tr>
							<td scope="row" colspan="2" class="alignL pdL20">&nbsp;${foodAdditiveBasisInfoDetail.puredo_test}</td>
						</tr>
						<tr>
							<th scope="row" colspan="2" class="alignL pdL20"><b>정량법</b></th>
						</tr>
			<c:if test="${not empty foodAdditiveBasisInfoDetail.fdqntlaw_1}">
						<tr>
							<td scope="row" colspan="2" class="alignL pdL20">&nbsp;${foodAdditiveBasisInfoDetail.fdqntlaw_1}</td>
						</tr>
			</c:if>
		</c:when>
		<c:when test="${foodAdditiveBasisInfoVO.page_gubun eq '4'}">
						<tr>
							<th scope="row" class="alignL pdL20">식품첨가물명</th>
							<td class="alignL">${foodAdditiveBasisInfoDetail.adtv_nm}</td>
						</tr>
						<tr>
							<th scope="row" class="alignL pdL20">식품첨가물영문명</th>
							<td class="alignL">${foodAdditiveBasisInfoDetail.adtv_eng_nm}</td>
						</tr>
			<c:if test="${not empty foodAdditiveBasisInfoDetail.stctr}">
						<tr>
							<th scope="row" class="alignL pdL20">구조식</th>
							<td class="alignL">
								<img src="/files/upload/fa/standard/structural_img/${foodAdditiveBasisInfoDetail.stctr}" alt="식품첨가물 화학식" />
							</td>
						</tr>
			</c:if>
			<c:if test="${not empty foodAdditiveBasisInfoDetail.chmsfod}">
						<tr>
							<th scope="row" class="alignL pdL20">화학식</th>
							<td class="alignL">${foodAdditiveBasisInfoDetail.chmsfod}</td>
						</tr>
			</c:if>
			<c:if test="${not empty foodAdditiveBasisInfoDetail.mcwgh}">
						<tr>
							<th scope="row" class="alignL pdL20">분자량</th>
							<td class="alignL">${foodAdditiveBasisInfoDetail.mcwgh}</td>
						</tr>
			</c:if>
			<c:if test="${not empty foodAdditiveBasisInfoDetail.cas_no}">
						<tr>
							<th scope="row" class="alignL pdL20">CAS Number</th>
							<td class="alignL">${foodAdditiveBasisInfoDetail.cas_no}</td>
						</tr>
			</c:if>
			<c:if test="${not empty foodAdditiveBasisInfoDetail.ins_no}">
						<tr>
							<th scope="row" class="alignL pdL20">INS번호</th>
							<td class="alignL">${foodAdditiveBasisInfoDetail.ins_no}</td>
						</tr>
			</c:if>
			<c:if test="${not empty foodAdditiveBasisInfoDetail.ncknm}">
						<tr>
							<th scope="row" class="alignL pdL20">이명</th>
							<td class="alignL">${foodAdditiveBasisInfoDetail.ncknm}</td>
						</tr>
			</c:if>
						<tr>
							<th scope="row" colspan="2" class="alignL pdL20"><b>성상</b></th>
						</tr>
			<c:if test="${not empty foodAdditiveBasisInfoDetail.dispos_1}">
						<tr>
							<td scope="row" colspan="2" class="alignL pdL20">&nbsp;${foodAdditiveBasisInfoDetail.dispos_1}</td>
						</tr>
			</c:if>
						<tr>
							<th scope="row" colspan="2" class="alignL pdL20"><b>용도</b></th>
						</tr>
						<tr>
							<td scope="row" colspan="2" class="alignL pdL20">&nbsp;${foodAdditiveBasisInfoDetail.prpos}</td>
						</tr>
						<tr>
							<th scope="row" colspan="2" class="alignL pdL20"><b>REQUIREMENTS</b></th>
						</tr>
						<tr>
							<th scope="row" class="alignL pdL20">확인시험</th>
							<td class="alignL">${foodAdditiveBasisInfoDetail.cnfm_test}</td>
						</tr>
						<tr>
							<th scope="row" class="alignL pdL20">함량</th>
							<td class="alignL">${foodAdditiveBasisInfoDetail.cont}</td>
						</tr>
						<tr>
							<th scope="row" class="alignL pdL20">순도시험</th>
							<td class="alignL">${foodAdditiveBasisInfoDetail.puredo_test}</td>
						</tr>
						<tr>
							<th scope="row" colspan="2" class="alignL pdL20"><b>TESTS</b></th>
						</tr>
						<tr>
							<th scope="row" class="alignL pdL20">정량법</th>
							<td class="alignL">${foodAdditiveBasisInfoDetail.fdqntlaw_1}</td>
						</tr>
						<tr>
							<th scope="row" class="alignL pdL20">순도시험</th>
							<td class="alignL">${foodAdditiveBasisInfoDetail.puredo_test}</td>
						</tr>
						<tr>
							<th scope="row" colspan="2" class="alignL pdL20"><b>포장및저장</b></th>
						</tr>
						<tr>
							<td scope="row" colspan="2" class="alignL pdL20">&nbsp;${foodAdditiveBasisInfoDetail.frmlc_and_save_1}</td>
						</tr>
		</c:when>
		<c:when test="${foodAdditiveBasisInfoVO.page_gubun eq '5'}">
						<tr>
							<th scope="row" class="alignL pdL20">식품첨가물명</th>
							<td class="alignL">${foodAdditiveBasisInfoDetail.adtv_nm}</td>
						</tr>
						<tr>
							<th scope="row" class="alignL pdL20">식품첨가물영문명</th>
							<td class="alignL">${foodAdditiveBasisInfoDetail.adtv_eng_nm}</td>
						</tr>
			<c:if test="${not empty foodAdditiveBasisInfoDetail.ncknm}">
						<tr>
							<th scope="row" class="alignL pdL20">이명</th>
							<td class="alignL">${foodAdditiveBasisInfoDetail.ncknm}</td>
						</tr>
			</c:if>
						<tr>
							<th scope="row" colspan="2" class="alignL pdL20"><b>정의</b></th>
						</tr>
			<c:if test="${not empty foodAdditiveBasisInfoDetail.chmsnm}">
						<tr>
							<th scope="row" class="alignL pdL20">화학명</th>
							<td class="alignL">${foodAdditiveBasisInfoDetail.chmsnm}</td>
						</tr>
			</c:if>
			<c:if test="${not empty foodAdditiveBasisInfoDetail.eu_legacy_list}">
						<tr>
							<th scope="row" class="alignL pdL20">Einecs</th>
							<td class="alignL">${foodAdditiveBasisInfoDetail.eu_legacy_list}</td>
						</tr>
			</c:if>
			<c:if test="${not empty foodAdditiveBasisInfoDetail.chmsfod}">
						<tr>
							<th scope="row" class="alignL pdL20">화학식</th>
							<td class="alignL">${foodAdditiveBasisInfoDetail.chmsfod}</td>
						</tr>
			</c:if>
			<c:if test="${not empty foodAdditiveBasisInfoDetail.mcwgh}">
						<tr>
							<th scope="row" class="alignL pdL20">분자량</th>
							<td class="alignL">${foodAdditiveBasisInfoDetail.mcwgh}</td>
						</tr>
			</c:if>
			<c:if test="${not empty foodAdditiveBasisInfoDetail.cont}">
						<tr>
							<th scope="row" class="alignL pdL20">함량</th>
							<td class="alignL">${foodAdditiveBasisInfoDetail.cont}</td>
						</tr>
			</c:if>
			<c:if test="${not empty foodAdditiveBasisInfoDetail.dispos}">
						<tr>
							<th scope="row" class="alignL pdL20">성상</th>
							<td class="alignL">${foodAdditiveBasisInfoDetail.dispos}</td>
						</tr>
			</c:if>
			<c:if test="${not empty foodAdditiveBasisInfoDetail.cnfm_test}">
						<tr>
							<th scope="row" class="alignL pdL20">확인시험</th>
							<td class="alignL">${foodAdditiveBasisInfoDetail.cnfm_test}</td>
						</tr>
			</c:if>
			<c:if test="${not empty foodAdditiveBasisInfoDetail.puredo_test}">
						<tr>
							<th scope="row" class="alignL pdL20">순도시험</th>
							<td class="alignL">${foodAdditiveBasisInfoDetail.puredo_test}</td>
						</tr>
			</c:if>
						<tr>
							<th scope="row" colspan="2" class="alignL pdL20"><b>사용기준</b></th>
						</tr>
			<c:if test="${not empty foodAdditiveBasisInfoDetail.use_stdr}">
						<tr>
							<td scope="row" colspan="2" class="alignL pdL20">&nbsp;${foodAdditiveBasisInfoDetail.use_stdr}</td>
						</tr>
			</c:if>
		</c:when>
		<c:when test="${foodAdditiveBasisInfoVO.page_gubun eq '6'}">
						<tr>
							<th scope="row" class="alignL pdL20">식품첨가물명</th>
							<td class="alignL">${foodAdditiveBasisInfoDetail.adtv_nm}</td>
						</tr>
						<tr>
							<th scope="row" class="alignL pdL20">식품첨가물영문명</th>
							<td class="alignL">${foodAdditiveBasisInfoDetail.adtv_eng_nm}</td>
						</tr>
		</c:when>
		<c:when test="${foodAdditiveBasisInfoVO.page_gubun eq '7'}">
						<tr>
							<th scope="row" class="alignL pdL20">식품첨가물명</th>
							<td class="alignL">${foodAdditiveBasisInfoDetail.adtv_nm}</td>
						</tr>
						<tr>
							<th scope="row" class="alignL pdL20">식품첨가물영문명</th>
							<td class="alignL">${foodAdditiveBasisInfoDetail.adtv_eng_nm}</td>
						</tr>
			<c:if test="${not empty foodAdditiveBasisInfoDetail.stctr}">
						<tr>
							<th scope="row" class="alignL pdL20">구조식</th>
							<td class="alignL">
								<img src="/files/upload/fa/standard/structural_img/${foodAdditiveBasisInfoDetail.stctr}" alt="식품첨가물 화학식" />
							</td>
						</tr>
			</c:if>
			<c:if test="${not empty foodAdditiveBasisInfoDetail.chmsfod}">
						<tr>
							<th scope="row" class="alignL pdL20">화학식</th>
							<td class="alignL">${foodAdditiveBasisInfoDetail.chmsfod}</td>
						</tr>
			</c:if>
			<c:if test="${not empty foodAdditiveBasisInfoDetail.mcwgh}">
						<tr>
							<th scope="row" class="alignL pdL20">분자량</th>
							<td class="alignL">${foodAdditiveBasisInfoDetail.mcwgh}</td>
						</tr>
			</c:if>
			<c:if test="${not empty foodAdditiveBasisInfoDetail.cont}">
						<tr>
							<th scope="row" class="alignL pdL20">함량</th>
							<td class="alignL">${foodAdditiveBasisInfoDetail.cont}</td>
						</tr>
			</c:if>
			<c:if test="${not empty foodAdditiveBasisInfoDetail.dispos}">
						<tr>
							<th scope="row" class="alignL pdL20">성상</th>
							<td class="alignL">${foodAdditiveBasisInfoDetail.dispos}</td>
						</tr>
			</c:if>
			<c:if test="${not empty foodAdditiveBasisInfoDetail.cnfm_test}">
						<tr>
							<th scope="row" class="alignL pdL20">확인시험</th>
							<td class="alignL">${foodAdditiveBasisInfoDetail.cnfm_test}</td>
						</tr>
			</c:if>
			<c:if test="${not empty foodAdditiveBasisInfoDetail.puredo_test}">
						<tr>
							<th scope="row" class="alignL pdL20">순도시험</th>
							<td class="alignL">${foodAdditiveBasisInfoDetail.puredo_test}</td>
						</tr>
			</c:if>
			<c:if test="${not empty foodAdditiveBasisInfoDetail.dry_reductn}">
						<tr>
							<th scope="row" class="alignL pdL20">건조감량</th>
							<td class="alignL">${foodAdditiveBasisInfoDetail.dry_reductn}</td>
						</tr>
			</c:if>
			<c:if test="${not empty foodAdditiveBasisInfoDetail.ignit_remn_rate}">
						<tr>
							<th scope="row" class="alignL pdL20">강열잔류물</th>
							<td class="alignL">${foodAdditiveBasisInfoDetail.ignit_remn_rate}</td>
						</tr>
			</c:if>
						<tr>
							<th scope="row" class="alignL pdL20">정량법</th>
							<td class="alignL">${foodAdditiveBasisInfoDetail.fdqntlaw}</td>
						</tr>
			<c:if test="${not empty foodAdditiveBasisInfoDetail.itm_cn_a}">
						<tr>
							<th scope="row" class="alignL pdL20">${foodAdditiveBasisInfoDetail.itm_nm_a}</th>
							<td class="alignL">${foodAdditiveBasisInfoDetail.itm_cn_a}</td>
						</tr>
			</c:if>
			<c:if test="${not empty foodAdditiveBasisInfoDetail.itm_cn_b}">
						<tr>
							<th scope="row" class="alignL pdL20">${foodAdditiveBasisInfoDetail.itm_nm_b}</th>
							<td class="alignL">${foodAdditiveBasisInfoDetail.itm_cn_b}</td>
						</tr>
			</c:if>
			<c:if test="${not empty foodAdditiveBasisInfoDetail.itm_cn_c}">
						<tr>
							<th scope="row" class="alignL pdL20">${foodAdditiveBasisInfoDetail.itm_nm_c}</th>
							<td class="alignL">${foodAdditiveBasisInfoDetail.itm_cn_c}</td>
						</tr>
			</c:if>
			<c:if test="${not empty foodAdditiveBasisInfoDetail.itm_cn_d}">
						<tr>
							<th scope="row" class="alignL pdL20">${foodAdditiveBasisInfoDetail.itm_nm_d}</th>
							<td class="alignL">${foodAdditiveBasisInfoDetail.itm_cn_d}</td>
						</tr>
			</c:if>
			<c:if test="${not empty foodAdditiveBasisInfoDetail.itm_cn_e}">
						<tr>
							<th scope="row" class="alignL pdL20">${foodAdditiveBasisInfoDetail.itm_nm_e}</th>
							<td class="alignL">${foodAdditiveBasisInfoDetail.itm_cn_e}</td>
						</tr>
			</c:if>
			<c:if test="${not empty foodAdditiveBasisInfoDetail.itm_cn_f}">
						<tr>
							<th scope="row" class="alignL pdL20">${foodAdditiveBasisInfoDetail.itm_nm_f}</th>
							<td class="alignL">${foodAdditiveBasisInfoDetail.itm_cn_f}</td>
						</tr>
			</c:if>
			<c:if test="${not empty foodAdditiveBasisInfoDetail.itm_cn_g}">
						<tr>
							<th scope="row" class="alignL pdL20">${foodAdditiveBasisInfoDetail.itm_nm_g}</th>
							<td class="alignL">${foodAdditiveBasisInfoDetail.itm_cn_g}</td>
						</tr>
			</c:if>
			<c:if test="${not empty foodAdditiveBasisInfoDetail.itm_cn_h}">
						<tr>
							<th scope="row" class="alignL pdL20">${foodAdditiveBasisInfoDetail.itm_nm_h}</th>
							<td class="alignL">${foodAdditiveBasisInfoDetail.itm_cn_h}</td>
						</tr>
			</c:if>
			<c:if test="${not empty foodAdditiveBasisInfoDetail.itm_cn_i}">
						<tr>
							<th scope="row" class="alignL pdL20">${foodAdditiveBasisInfoDetail.itm_nm_i}</th>
							<td class="alignL">${foodAdditiveBasisInfoDetail.itm_cn_i}</td>
						</tr>
			</c:if>
			<c:if test="${not empty foodAdditiveBasisInfoDetail.itm_cn_j}">
						<tr>
							<th scope="row" class="alignL pdL20">${foodAdditiveBasisInfoDetail.itm_nm_j}</th>
							<td class="alignL">${foodAdditiveBasisInfoDetail.itm_cn_j}</td>
						</tr>
			</c:if>
			<c:if test="${not empty foodAdditiveBasisInfoDetail.use_stdr}">
						<tr>
							<th scope="row" class="alignL pdL20">사용기준</th>
							<td class="alignL">${foodAdditiveBasisInfoDetail.use_stdr}</td>
						</tr>
			</c:if>
		</c:when>
	</c:choose>
	</tbody>
</table>

	<!-- 게시물정보 시작 -->
<c:choose>
	<c:when test="${foodAdditiveBasisInfoVO.page_gubun eq '2'}">
		<h4 class="bul1">지정년월일 및 개정진행사항</h4>
		<table class="boardList mgbt20" summary="지정년월일 및 개정진행사항">
			<colgroup>
				<col />
				<col style="width:20%" />
				<col style="width:20%" />
				<col style="width:10%" />
			</colgroup>
			<thead>
				<tr>
					<th class="first-child" scope="col">지정년 및 개정진행상황</th>
	        		<th scope="col">고시번호</th>
	        		<th scope="col">고시일</th>
	        		<th class="last-child" scope="col" width="">파일</th>
	        	</tr>
			</thead>
	        <tbody>
	        <c:forEach var="history" items="${foodAdditiveBasisInfoReformHistoryList}" varStatus="status">
		        <tr>
		        	<td class="alignL">${history.reform_reason}</td>
		        	<td>${history.ntfc_no}</td>
		        	<td>${history.ntfc_dt}</td>
		        	<td><a href="download.do?addPath=/files/upload/fa/standard/pdf/gaejung/&fileName=${history.atch_file_nm}&fileNameOri=${history.atch_file_nm}">${history.atch_file_nm}</a></td>
		        </tr>
	        </c:forEach>
	        </tbody>
		</table>
	</c:when>
	<c:when test="${foodAdditiveBasisInfoVO.page_gubun eq '4'}">
		<h4 class="bul1">CFR 사용기준</h4>
		<table class="boardList mgbt20" summary="CFR 사용기준">
			<colgroup>
				<col style="width:20%" />
				<col />
				<col style="width:10%" />
			</colgroup>
			<thead>
				<tr>
					<th class="first-child" scope="col">CFR Code</th>
	        		<th scope="col">사용식품</th>
	        		<th class="last-child" scope="col">사용량</th>
	        	</tr>
			</thead>
	        <tbody>
	        <c:forEach var="cfrUseStandard" items="${cfrUseStandardList}" varStatus="status">
	        	<tr>
		        	<td>${cfrUseStandard.cfr_cd}</td>
		        	<td class="alignL">${cfrUseStandard.use_food}</td>
		        	<td>${cfrUseStandard.used}</td>
		        </tr>
	        </c:forEach>
	        </tbody>
		</table>
	</c:when>
	<c:when test="${foodAdditiveBasisInfoVO.page_gubun eq '6'}">
		<h4 class="bul1">사용기준</h4>
		<table class="boardList mgbt20" summary="사용기준">
			<colgroup>

				<col style="width:20%" />
				<col />
				<col style="width:40%" />


			</colgroup>
			<thead>
				<tr>
					<th class="first-child" scope="col">용도</th>
	        		<th scope="col">대상식품</th>
	        		<th class="last-child" scope="col">최대허용량</th>
	        	</tr>
			</thead>
	        <tbody>
	        <c:forEach var="codexUseStandard" items="${codexUseStandardList}" varStatus="status">
	        	<tr>
		        	<td>${codexUseStandard.prpos}</td>
		        	<td class="alignL">${codexUseStandard.obj_food}</td>
		        	<td class="alignL">${codexUseStandard.mxmm_perm_volum}</td>
		        </tr>
	        </c:forEach>
	        </tbody>
		</table>
	</c:when>
</c:choose>

	<div class="boardNavigation1">
  		<a href="foodAdditiveBasisInfo.do?page_gubun=${foodAdditiveBasisInfoVO.page_gubun}&procs_cl=${foodAdditiveBasisInfoVO.procs_cl}&page=${foodAdditiveBasisInfoVO.page}&keyfield=${foodAdditiveBasisInfoVO.keyfield}&key=${foodAdditiveBasisInfoVO.key}" class="btn"><span>목록</span></a>
  	</div>
