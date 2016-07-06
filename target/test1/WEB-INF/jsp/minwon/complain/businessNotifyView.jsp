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
                            <li><a href="#">홈</a></li>
                            <li><a href="#">1399소비자신고</a></li>
                            <li><a href="#">업체이물보고</a></li>
                            <li>보고 및 진행상태 확인</li>
                        </ol>
                        <h1>보고 및 진행상태 확인</h1>
                    </div>
                </div>
                <div class="page-container">
                	<!-- 페이지 내용 -->
                    <article>
                        <table class="tableset">
                            <caption>문서정보</caption>
                            <colgroup>
                                <col style="width:15%">
                                <col style="width:20%">
                                <col style="width:15%">
                                <col style="width:50%">
                            </colgroup>
                            <tbody>
                                <tr>
                                    <th>문서번호</th>
                                    <td>${complainVO.doc_no}</td>
                                    <th>접수기관</th>
                                    <td>${chrgInsttCd.instt_nm}</td>
                                </tr>
                                <tr>
                                    <th>진행상태</th>
                                    <td>${not empty complainVO.now_stats_cd ? complainVO.now_stats_cd_nm : '접수완료'}</td>
                                    <th>담당기관/연락처</th>
                                    <td>${chrgInsttCd.instt_nm}${chrgInsttCd.tel_no}</td>
                                </tr>
                            </tbody>
                        </table>
                        
                        <c:forEach var="statusReply" items="${statusReplyList}" varStatus="status">
                        <table class="tableset" style="margin-top:5px;">
                            <caption>${statusReply.progess_num}번 결과</caption>
                            <colgroup>
                                <col style="width:15%">
                                <col style="width:85%">
                            </colgroup>
                            <tbody>
                                <tr>
                                    <th>${statusReply.progess_num}번 답변내용</th>
                                    <td>${statusReply.hist_cn}</td>
                                </tr>
                                <tr>
                                    <th>${statusReply.progess_num}번 답변일자</th>
                                    <td>${statusReply.reg_dtm}</td>
                                </tr>
                                <tr>
                                    <th>${statusReply.progess_num}번 담당기관(연락처)</th>
                                    <td>${statusReply.dept_cd} | TODO (식품의약품안전처 식품안전정책국 식품관리총괄과[식품] (043-719-2070,2056(이물),2069(허위과대광고)))</td>
                                </tr>
                            </tbody>
                        </table>
						</c:forEach>
                        
                        <h2>보고업체정보</h2>
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
                                    <th>업체명</th>
                                    <td colspan="3">${complainVO.entrps_nm}</td>
                                </tr>
                                <tr>
                                    <th>업종</th>
                                    <td colspan="3">${complainVO.induty_dvs_cd_nm}</td>
                                </tr>
                                <tr>
                                    <th>담당자</th>
                                    <td>${complainVO.charger_name}</td>
                                    <th>담당자 연락처</th>
                                    <td>${complainVO.charger_telno}</td>
                                </tr>
                                <tr>
                                    <th>비밀번호</th>
                                    <td>${complainVO.pswd}</td>
                                    <th>진행사항 통보방식</th>
                                    <td>${complainVO.dspth_way_cd_nm}</td>
                                </tr>
                            </tbody>
                        </table>
                        <h2>소비자인적사항</h2>
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
                                    <th>성명</th>
                                    <td>${complainVO.aplcnt_name}</td>
                                    <th>연락처</th>
                                    <td>${complainVO.aplcnt_mbtpno}</td>
                                </tr>
                                <tr>
                                    <th>소재지</th>
                                    <td colspan="3">
                                    	[${fn:substring(complainVO.aplcnt_zipno, 0, 3)}-${fn:substring(complainVO.aplcnt_zipno, 3, 6)}]${complainVO.aplcnt_postaddr} ${complainVO.aplcnt_dtl_addr}
									</td>
                                </tr>
                                <tr>
                            </tbody>
                        </table>
                        <h2>제품 및 업체 정보</h2>
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
                                    <th>제품명</th>
                                    <td>${complainVO.prdt_nm}</td>
                                    <th>식품유형</th>
                                    <td>${foodTypeCd.kor_nm }</td>
                                </tr>
                                <tr>
                                    <th>유통기한</th>
                                    <td>${complainVO.prdt_distb_tmlmt}</td>
                                    <th>보관기준</th>
                                    <td>${complainVO.cstdy_stdr}</td>
                                </tr>
                                <tr>
                                    <th>포장단위</th>
                                    <td>${complainVO.prdt_frmlc_unit}</td>
                                    <th>원산지</td>
                                    <td>
                                    	<c:choose>
	                                    	<c:when test="${complainVO.orgnp_dvs_cd eq 'D'}">
	                                    		국산
	                                    	</c:when>
	                                    	<c:when test="${complainVO.orgnp_dvs_cd eq 'E'}">
	                                    		[수입] ${complainVO.incm_natn_cd_nm}
	                                    	</c:when>
	                                    </c:choose>
                                    </td>
                                </tr>
                            </tbody>
                        </table>
                        <table class="tableset" style="margin-top:5px;">
                            <caption>제품/업체정보</caption>
                            <colgroup>
                                <col style="width:15%">
                                <col style="width:35%">
                                <col style="width:15%">
                                <col style="width:35%">
                            </colgroup>
                            <tbody>
                                <tr>
                                    <th>제조원</th>
                                    <td>${makerInfo.bssh_nm}</td>
                                    <th>제조원 연락처</th>
                                    <td>${makerInfo.telno}</td>
                                </tr>
                                <tr>
                                    <th>제조원 소재지</th>
                                    <td colspan="3">${makerInfo.addr} ${makerInfo.addr_dtl}</td>
                                </tr>
                                <tr>
                                    <th>판매원</th>
                                    <td>${salprInfo.bssh_nm}</td>
                                    <th>판매원 연락처</th>
                                    <td>${salprInfo.telno}</td>
                                </tr>
                                <tr>
                                    <th>판매원 소재지</th>
                                    <td colspan="3">${salprInfo.addr} ${salprInfo.addr_dtl}</td>
                                </tr>
                            </tbody>
                        </table>
                        <h2>소비자 불만사항 확인 내용</h2>
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
                                    <th>제품구입장소</th>
                                    <td>${complainVO.prdt_buy_plc}</td>
                                    <th>제품구입일</th>
                                    <td>
                                    	<c:if test="${not empty complainVO.prdt_buy_dt}">
                                    		${fn:substring(complainVO.prdt_buy_dt, 0, 4)}. ${fn:substring(complainVO.prdt_buy_dt, 4, 6)}. ${fn:substring(complainVO.prdt_buy_dt, 6, 8)}
                                    	</c:if>
                                    </td>
                                </tr>
                                <tr>
                                    <th>제품개봉일</th>
                                    <td>
                                    	<c:if test="${not empty complainVO.prdt_opn_dt}">
                                    		${fn:substring(complainVO.prdt_opn_dt, 0, 4)}. ${fn:substring(complainVO.prdt_opn_dt, 4, 6)}. ${fn:substring(complainVO.prdt_opn_dt, 6, 8)}
                                    	</c:if>
									</td>
                                    <th>이물발견일</th>
                                    <td>
                                    	<c:if test="${not empty complainVO.prdt_opn_dt}">
                                    		${fn:substring(complainVO.prdt_opn_dt, 0, 4)}. ${fn:substring(complainVO.prdt_opn_dt, 4, 6)}. ${fn:substring(complainVO.prdt_opn_dt, 6, 8)}
                                    	</c:if>
									</td>
                                </tr>
                                <tr>
                                    <th>증거제품보관</th>
                                    <td colspan="3">
                                    	<c:forEach var="evdcPrdtCstdy" items="${evdcPrdtCstdyList}" varStatus="status">
                                    		${status.index == 0 ? '' : ', ' }
                                    		${evdcPrdtCstdy.evdc_prdt_cstdy_dvs_cd_nm }
                                    	</c:forEach>
									</td>
                                 </tr>
                                 <tr>
                                    <th>이물종류</th>
                                    <td colspan="3">
                                    	<c:forEach var="code" items="${alnstCd}" varStatus="status">
	                                    	<c:if test="${complainVO.alnst_cd eq code.alnst_cd}">
	                                    		<c:forEach var="hcode" items="${alnstCd}" varStatus="status">
	                                    			<c:if test="${code.lclas_cd eq hcode.lclas_cd && hcode.dvs_cd eq '1'}">
	                                    				[${hcode.rm}]${code.rm}
	                                    				<c:if test="${not empty complainVO.alnst_dett_etc}">
	                                    					-  ${complainVO.alnst_dett_etc}
	                                    				</c:if>
	                                    			</c:if>
	                                    		</c:forEach>
	                                    	</c:if>
	                                    </c:forEach>
                                    </td>
                                 </tr>
                                 <tr>
                                    <th>이물형태</th>
                                    <td colspan="3">${complainVO.alnst_dispos}</td>
                                 </tr>
                                 <tr>
                                    <th>이물자료첨부</th>
                                    <td colspan="3">
                                    	<c:if test="${not empty atchfl }">
                                    		<a href="javascript:fn_downloadAttchdFile('${atchfl.file_save_path }', '${atchfl.physic_file_nm}', '${atchfl.orgnt_file_nm }');" target="_blank">${atchfl.orgnt_file_nm }</a><br>
                                    		<c:if test="${atchfl.file_knd_dvs_cd eq 'I'}">
                                    			<img src="${atchfl.file_save_path }/${atchfl.physic_file_nm}" alt="${atchfl.orgnt_file_nm }" style="margin-top:5px;margin-bottom:0;">
                                    		</c:if>
                                    	</c:if>
                                    </td>
                                </tr>
                                <tr>
                                    <th>이물발견경위</th>
                                    <td colspan="3">${complainVO.alnst_discov_promn}</td>
                                </tr>
                                <tr>
                                    <th>이물발견<br>제품보관환경</th>
                                    <td colspan="3">${complainVO.alnst_prdt_cstdy_envrn}</td>
                                </tr>
                                <tr>
                                    <th>보고자 의견</th>
                                    <td colspan="3">${complainVO.examr_opnn}</td>
                                </tr>
                                <tr>
                                    <th>클레임 접수일시</th>
                                    <td colspan="3">
                                    	<c:if test="${not empty complainVO.sttemnt_dt}">
                                    		${fn:substring(complainVO.sttemnt_dt, 0, 4)}. ${fn:substring(complainVO.sttemnt_dt, 4, 6)}. ${fn:substring(complainVO.sttemnt_dt, 6, 8)}
                                    	</c:if>
                                    </td>
                                </tr>
                            </tbody>
                        </table>
                    </article>
                </div>
            </section>
            
            
<script type="text/javascript">
/***************************************************************************************
* 시스템명 	: 식품의약품안전처 통합식품안전망구축
* 업무명 		: 업체이물신고 진행상황 확인
* 파일명 		: businessNotifyView.jsp
* 작성자 		: 장영철
* 작성일 		: 2014.10.16
*
* 설  명		:  업체이물신고 진행상황 확인
*------------------------------------------------------------------------------------
* 변경일	변경자		변경내역 
*------------------------------------------------------------------------------------
*  2014.10.16 장영철		최초 프로그램 작성         
* 
*------------------------------------------------------------------------------------
**************************************************************************************/
function fn_downloadAttchdFile(filePath, fileName, orgFileName){
	var url = '${contextPath}/common/downloadAttchdFile.do'
					+ '?filePath=' + filePath
					+ '&fileName=' + fileName
					+ '&orgFileName=' + orgFileName;
	location.href = url;
}
 </script>