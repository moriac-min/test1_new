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
                            <li><a href="#">소비자신고</a></li>
                            <li>신고 및 진행상황 확인</li>
                        </ol>
                        <h1>신고 및 진행상황 확인</h1>
                    </div>
                </div>
                <div class="page-container">
                	<!-- 페이지 내용 -->
                    <article>
                    	<h2>진행상태 및 결과</h2>
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
                                    <td>${complainVO.doc_no }</td>
                                    <th>접수기관</th>
                                    <td>${complainVO.rcpt_instt_dvs_cd }</td>
                                </tr>
                                <tr>
                                    <th>진행상태</th>
                                    <td>
                                    	${not empty complainVO.now_stats_cd ? complainVO.now_stats_cd_nm : '접수완료'}
                                    </td>
                                    <th>담당기관/연락처</th>
                                    <td>${complainVO.rcpt_instt_dvs_cd } / ${complainVO.instt_telno }</td>
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
                                    <td>${statusReply.dept_cd} | 식품의약품안전처 식품안전정책국 식품관리총괄과[식품] (043-719-2070,2056(이물),2069(허위과대광고))</td>
                                </tr>
                            </tbody>
                        </table>
						</c:forEach>

                        <h2>신고자정보</h2>
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
                                    <th>성명</th>
                                    <td>${complainVO.aplcnt_name }</td>
                                    <th>주민등록번호</th>
                                    <td>${complainVO.aplcnt_rsrno }</td>
                                </tr>
                                <tr>
                                    <th>소재지</th>
                                    <td colspan="3">[${fn:substring(complainVO.aplcnt_zipno, 0, 3) }-${fn:substring(complainVO.aplcnt_zipno, 3, 6) }] ${complainVO.aplcnt_postaddr } ${complainVO.aplcnt_dtl_addr }</td>
                                </tr>
                                <tr>
                                    <th>이메일</th>
                                    <td>${complainVO.aplcnt_email_addr }</td>
                                    <th>휴대폰번호(연락처)</th>
                                    <td>${complainVO.aplcnt_mbtpno }</td>
                                </tr>
                            </tbody>
                        </table>
                        <h2>신고내용</h2>
                        <table class="tableset">
                            <caption>신고내용</caption>
                            <colgroup>
                                <col style="width:15%">
                                <col style="width:35%">
                                <col style="width:15%">
                                <col style="width:35%">
                            </colgroup>
                            <tbody>
                                <tr>
                                    <th>신고내용</th>
                                    <td>
                                    	${complainVO.vilt_cn_cd_nm }
                                    	<c:if test="${not empty complainVO.vilt_cn_prvns }">
                                    		(${complainVO.vilt_cn_prvns })
                                    	</c:if>
                                    </td>
                                </tr>
                                <c:if test="${not empty complainVO.alnst_cd }">
                                <tr>
                                    <th>이물종류</th>
                                    <td colspan="3">
                                    	<c:forEach var="code" items="${alnstCd}" varStatus="status">
	                                    	<c:if test="${complainVO.alnst_cd eq code.alnst_cd}">
	                                    		<c:forEach var="hcode" items="${alnstCd}" varStatus="status">
	                                    			<c:if test="${code.lclas_cd eq hcode.lclas_cd && hcode.dvs_cd eq '1'}">
	                                    				[${hcode.rm }]${code.rm }
	                                    				<c:if test="${not empty complainVO.alnst_dett_etc }">
	                                    					-  ${complainVO.alnst_dett_etc }
	                                    				</c:if>
	                                    			</c:if>
	                                    		</c:forEach>
	                                    	</c:if>
	                                    </c:forEach>
                                    </td>
                                </tr>
                                </c:if>
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
                                    <th>내용</th>
                                    <td colspan="3">${complainVO.sttemnt_cn }</td>
                                </tr>
                                <tr>
                                    <th>첨부파일</th>
                                    <td colspan="3">
                                    	<c:if test="${not empty atchfl }">
                                    		<a href="javascript:fn_downloadAttchdFile('${atchfl.file_save_path }', '${atchfl.physic_file_nm}', '${atchfl.orgnt_file_nm }');" target="_blank">${atchfl.orgnt_file_nm }</a><br>
                                    		<c:if test="${atchfl.file_knd_dvs_cd eq 'I'}">
                                    			<img src="${atchfl.file_save_path }/${atchfl.physic_file_nm}" alt="${atchfl.orgnt_file_nm }" style="margin-top:5px;margin-bottom:0;">
                                    		</c:if>
                                    	</c:if>
									</td>
                                </tr>
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
                                    <td colspan="3">${complainVO.prdt_nm }</td>
                                </tr>
                                <tr>
                                    <th>식품유형</th>
                                    <td>${foodTypeCd.kor_nm }</td>
                                    <th>HACCP적용품목여부</th>
                                    <td>
                                    	<c:if test="${not empty complainVO.haccp_applc_prdlst_yn }">
                                    		${complainVO.haccp_applc_prdlst_yn eq 'Y' ? '적용' : '미적용'}
                                    	</c:if>
                                    </td>
                                </tr>
                                <tr>
                                    <th>유통기한</th>
                                    <td>${complainVO.prdt_distb_tmlmt }</td>
                                    <th>보관기준</th>
                                    <td>${complainVO.cstdy_stdr }</td>
                                </tr>
                                <tr>
                                    <th>제조일자</th>
                                    <td>${complainVO.prdt_mnf_dt }</td>
                                    <th>품질유지기한</th>
                                    <td>${complainVO.qlity_mntnc_tmlmt_dt }</td>
                                </tr>
                                <tr>
                                    <th>포장단위</th>
                                    <td>${complainVO.prdt_frmlc_unit }</td>
                                    <th>수입식품여부</th>
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
                                <tr>
                                    <th>제품구입장소(주소지)</th>
                                    <td colspan="3">${complainVO.prdt_buy_plc}</td>
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
                                    <td>${makerInfo.bssh_nm }</td>
                                    <th>제조원 연락처</th>
                                    <td>${makerInfo.telno }</td>
                                </tr>
                                <tr>
                                    <th>제조원 소재지</th>
                                    <td colspan="3">${makerInfo.addr } ${makerInfo.addr_dtl }</td>
                                </tr>
                                <tr>
                                    <th>판매원</th>
                                    <td>${salprInfo.bssh_nm }</td>
                                    <th>판매원 연락처</th>
                                    <td>${salprInfo.telno }</td>
                                </tr>
                                <tr>
                                    <th>판매원 소재지</th>
                                    <td colspan="3">${salprInfo.addr } ${salprInfo.addr_dtl }</td>
                                </tr>
                            </tbody>
                        </table>
                    </article>
                </div>
            </section>
            
            
<script type="text/javascript">
/***************************************************************************************
* 시스템명 	: 식품의약품안전처 통합식품안전망구축
* 업무명 		: 소비자 신고 진행상황 확인
* 파일명 		: customerNotifyView.jsp
* 작성자 		: 장영철
* 작성일 		: 2014.10.09
*
* 설  명		:  소비자 신고 진행상황 확인
*------------------------------------------------------------------------------------
* 변경일	변경자		변경내역 
*------------------------------------------------------------------------------------
*  2014.10.09 장영철		최초 프로그램 작성         
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