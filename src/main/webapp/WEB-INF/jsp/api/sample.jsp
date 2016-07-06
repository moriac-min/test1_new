<%@page language="java" contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

	<section>
      <div id="header">
          <div class="board-head">
              <ol class="breadcrumb">
                  <li><a href="#">홈</a></li>
                  <li><a href="#">1399소비자신고</a></li>
                  <li><a href="#">업체이물신고</a></li>
                  <li>업체이물신고접수</li>
              </ol>
              <h1>업체이물신고접수</h1>
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
              <form name="frm" method="post" enctype="multipart/form-data" action="/cfscr/sales.do?mode=insert&amp;TOKENCOMPLAINSALE=15defbb2d1d9a7db1ddb9b42c302e8f" onsubmit="return doSave();">
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
                                  <th class="required"><label for="org_name" title="필수항목">담당기관</label></th>
                                  <td><input type="text" id="org_name" size="36" name="org_name" value="" title="담당기관" readonly><a href="/cfscr/common/orgsearch.do?action=organ&amp;fname=frm&amp;org_code=org_code&amp;org_name=org_name" onclick="orgsearch('frm','org_code','org_name');return false;" target="_blank" title="새창으로 열기" class="btn btn-success btn-sm">기관찾기</a></td>
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
                                  <td colspan="3"><input type="text" maxlength="100" size="47" name="name" id="name" title="업체명"></td>
                              </tr>
                              <tr>
                                  <th><label for="codes1">업종</label></th>
                                  <td colspan="3">
                                  	<ul>
                                          <li><label><input type="radio" value="D" name="busc_type" id="codes1" checked="checked"> 식품제조가공업</label></li>
                                          <li><label><input type="radio" value="E" name="busc_type" id="codes2"> 식품등수입판매업</label></li>
                                          <li><label><input type="radio" value="F" name="busc_type" id="codes3"> 유통전문판매업</label></li>
                                          <li><label><input type="radio" value="G" name="busc_type" id="codes4"> 식품소분업</label></li>
                                      </ul>
                                  </td>
                              </tr>
                              <tr>
                                  <th class="required"><label for="busc_mng" title="필수항목">담당자</label></th>
                                  <td><input name="busc_mng" id="busc_mng" type="text" value="" size="47" maxlength="20"></td>
                                  <th class="required"><label for="busc_tel2" title="필수항목">담당자 연락처</label></th>
                                  <td><input name="busc_tel2" id="busc_tel2" type="text" value="" size="47" maxlength="20"></td>
                              </tr>
                              <tr>
                                  <th class="required"><label for="pass" title="필수항목">비밀번호</label></th>
                                  <td><input type="password" maxlength="32" size="47" name="pass" id="pass" title="비밀번호"></td>
                                  <th class="required"><label for="pass2" title="필수항목">비밀번호 확인</label></th>
                                  <td><input type="password" maxlength="32" size="47" name="pass2" id="pass2" title="비밀번호 확인"></td>
                              </tr>
                              <tr>
                                  <th class="required"><label for="inform-s" title="필수항목">진행사항 통보방식</label></th>
                                  <td colspan="3">
                                      <ul>
                                          <li><label><input type="radio" name="inform" id="inform-s" title="휴대전화 문자메세지" value="S"> 휴대전화 문자메세지</label></li>
                                          <li><label><input type="radio" name="inform" id="inform-p" title="우편" value="P"> 우편</label></li>
                                          <li><label><input type="radio" name="inform" id="inform-h" title="홈페이지" value="H"> 홈페이지</label></li>
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
                                  <td><input type="text" maxlength="20" size="47" name="busc_name" id="busc_name" title="성명"></td>
                                  <th><label for="busc_tel" title="필수항목">연락처</label></th>
                                  <td colspan="3"><input type="text" maxlength="20" size="47" name="busc_tel" id="busc_tel" title="연락처"></td>
                              </tr>
                              <tr>
                                  <th class="required"><label for="busc_post" title="필수항목">소재지</label></th>
                                  <td colspan="3"><input type="text" maxlength="7" size="10" name="busc_post" id="busc_post" title="우편번호" readonly><a href="/cfscr/common/zipsearch.do?action=zipcode&amp;fname=frm&amp;post=busc_post&amp;addr=busc_addr" onclick="zipsearch('frm','busc_post','busc_addr');return false;" target="_blank" title="새창으로 열기" class="btn btn-success btn-sm">우편번호찾기</a> <input type="text" maxlength="150" size="94" name="busc_addr" id="busc_addr" title="상세주소" style="margin-left:4px;"></td>
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
                                  <th class="required"><label for="prod_name" title="필수항목">제품명</label></th>
                                  <td><input type="text" maxlength="100" size="47" name="prod_name" id="prod_name" title="제품명"></td>
                                  <th><label for="prod_type">식품유형</label></th>
                                  <td><input type="text" name="prod_type" id="prod_type" size="32" maxlength="50" readonly><a href="/cfscr/common/foodsearch.do?action=foodsearch&amp;fname=fm&amp;foodType=prod_type" onclick="foodsearch('fm','prod_type');return false;" target="_blank" title="새창으로 열기" class="btn btn-success btn-sm">식품유형찾기</a></td>
                              </tr>
                              <tr>
                                  <th class="required"><label for="prod_term" title="필수항목">유통기한</label></th>
                                  <td><input type="text" maxlength="50" size="47" name="prod_term" id="prod_term" title="유통기한"></td>
                                  <th><label for="keep_st">보관기준</label></th>
                                  <td><input type="text" maxlength="32" size="47" name="keep_st" id="keep_st" title="보관기준"></td>
                              </tr>
                              <tr>
                                  <th><label for="prod_unit">포장단위</label></th>
                                  <td><input type="text" maxlength="30" size="47" name="prod_unit" id="prod_unit"></td>
                                  <th><label for="origin_name">수입식품여부</label></th>
                                  <td>
                                  	<ul>
                                      	<li><label><input type="radio" onclick="jsOption(this.value)" value="D" name="orig_flag" id="domestic" checked="checked"> 국산</label></li>
                                      	<li><label><input type="radio" onclick="jsOption(this.value)" value="E" name="orig_flag" id="import"> 수입</label><input type="text" maxlength="150" size="20" name="origin_name" id="origin_name" readonly disabled="" style="margin-left:5px;"><a id="orig_select" href="/cfscr/common/originsearch.do?action=origin&amp;fname=fm&amp;cname=origin" onclick="originsearch('fm','origin'); return false;" target="_blank" title="새창으로 열기" class="btn btn-success btn-sm">원산지</a><input type="hidden" name="origin_no" id="origin_no" value=""></li>
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
                                  <td><input type="text" name="prod_comp" id="prod_comp" size="32" maxlength="100"><a href="/cfscr/jsp/common/compsearch2.jsp?action=compsearch&amp;fname=fm&amp;comp=prod_comp&amp;comp_tel=prod_tel&amp;comp_addr=prod_addr&amp;comp_code=prod_comp_code&amp;flag=P" onclick="compsearch('fm','prod_comp','prod_tel','prod_addr','p','prod_comp_code'); return false;" target="_blank" title="새창으로 열기" class="btn btn-success btn-sm">제조원 찾기</a></td>
                                  <th><label for="prod_tel">제조원 연락처</label></th>
                                  <td><input type="text" maxlength="32" size="47" name="prod_tel" id="prod_tel" title="제조원 연락처"></td>
                              </tr>
                              <tr>
                                  <th><label for="prod_post">제조원 소재지</label></th>
                                  <td colspan="3"><input type="text" maxlength="7" size="10" name="prod_post" id="prod_post" title="우편번호" readonly><a href="/cfscr/common/zipsearch.do?action=zipcode&amp;fname=fm&amp;post=prod_post&amp;addr=prod_addr" onclick="zipsearch('fm','prod_post','prod_addr');return false;" target="_blank" title="새창으로 열기" class="btn btn-success btn-sm">우편번호찾기</a> <input type="text" maxlength="150" size="94" name="prod_addr" id="prod_addr" title="제조원 상세주소" style="margin-left:4px;"></td>
                              </tr>
                              <tr>
                                  <th><label for="prod_name">판매원</label></th>
                                  <td><input type="text" maxlength="100" size="47" name="sale_comp" id="sale_comp" title="판매원"></td>
                                  <th><label for="sale_tel">판매원 연락처</label></th>
                                  <td><input type="text" maxlength="32" size="47" name="sale_tel " id="sale_tel" title="판매원 연락처"></td>
                              </tr>
                              <tr>
                                  <th><label for="sale_post">판매원 소재지</label></th>
                                  <td colspan="3"><input type="text" maxlength="7" size="10" name="sale_post" id="sale_post" title="우편번호" readonly><a href="/cfscr/common/zipsearch.do?action=zipcode&amp;fname=fm&amp;post=sale_post&amp;addr=sale_addr" onclick="zipsearch('fm','sale_post','sale_addr');return false;" target="_blank" title="새창으로 열기" class="btn btn-success btn-sm">우편번호찾기</a> <input type="text" maxlength="150" size="94" name="sale_addr" id="sale_addr" title="판매원 상세주소" style="margin-left:4px;"></td>
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
                                  <td><input name="prod_place" id="prod_place" type="text" value="" size="47" maxlength="20"></td>
                                  <th><label for="prod_buy_date">제품구입일</label></th>
                                  <td><input type="text" name="prod_buy_date" id="prod_buy_date" maxlength="8" size="32" value=""> 예) 20150427</td>
                              </tr>
                              <tr>
                                  <th><label for="prod_open_date">제품개봉일</label></th>
                                  <td><input type="text" name="prod_open_date" id="prod_open_date" maxlength="8" size="32" value=""> 예) 20150427</td>
                                  <th><label for="sub_find_date">이물발견일</label></th>
                                  <td><input type="text" name="sub_find_date" id="sub_find_date" maxlength="8" size="32" value=""> 예) 20150427</td>
                              </tr>
                              <tr>
                                  <th class="required"><label for="keep_flag1" title="필수항목">증거제품보관</label></th>
                                  <td colspan="3">
                                      <ul>
                                          <li><label><input type="checkbox" name="keep_flag" id="keep_flag1" value="A" title="현품"> 현품</label></li>
                                          <li><label><input type="checkbox" name="keep_flag" id="keep_flag2" value="B" title="사진"> 사진</label></li>
                                          <li><label><input type="checkbox" name="keep_flag" id="keep_flag3" value="C" title="이물"> 이물</label></li>
                                          <li><label><input type="checkbox" name="keep_flag" id="keep_flag4" value="D" title="업체회수"> 업체회수</label></li>
                                          <li><label><input type="checkbox" name="keep_flag" id="keep_flag5" value="E" title="기타"> 기타</label></li>
                                      </ul>
                                  </td>
                               </tr>
                               <tr>
                                  <th><label for="aclass">이물종류</label></th>
                                  <td colspan="3">
                                  	<select id="aclass" name="aclass" onchange="choiceBclass();" title="이물 1차분류" class="selecter_basic">
                                          <option value="" selected="selected">1차분류선택</option>
                                          <option value="001">[동물성 이물]</option>
                                          <option value="002">[식물성 이물]</option>
                                          <option value="003">[광물성 이물]</option>
                                          <option value="004">[기타 이물]</option>
                                      </select>
                                      <select id="sub_code" name="sub_code" title="이물 2차분류" class="selecter_basic">
                                          <option value="" selected="selected">2차분류선택</option>
                                          <option value="001009">곤충류(성충, 유충, 번데기, 알, 탈피각 또는 그 파편 등포함)</option>
                                          <option value="001001">파리, 바퀴벌레 등 위생해충(성충,유충, 알, 파편 등 포함)</option>
                                          <option value="001002">지렁이</option>
                                          <option value="001003">머리카락(동물의 털)</option>
                                          <option value="001004">기생충 및 그 알</option>
                                          <option value="001005">쥐 등 위생동물 사체 또는 그 배설물</option>
                                          <option value="001006">동물 뼛조각, 이빨</option>
                                          <option value="001007">어류 가시 또는 껍질</option>
                                          <option value="001008">동물성 이물 중 그 외</option>
                                          <option value="001010">개구리 </option>
                                      </select>
                                      <input type="text" name="sub_code_ext" id="sub_code_ext" size="40" maxlength="100" title="기타이물내용입력">
                                      <p>* 물성 이물 중 그 외, 식물성 이물 중 그 외, 광물성 이물 중 그 외, 기타 이물 중 그외 선택 시에는  해당 내용을 입력해주세요.</p>
                                  </td>
                               </tr>
                               <tr>
                                  <th><label for="comments">이물형태</label></th>
                                  <td colspan="3"><textarea cols="55" rows="5" id="comments" name="comments" title="이물형태"></textarea><p>* 색상, 크기, 개수, 성상 등</p></td>
                               </tr>
                               <tr>
                                  <th class="required"><label for="file" title="필수항목">이물자료첨부</label></th>
                                  <td colspan="3">
                                  	<ul>
                                          <li><label><input type="radio" checked="checked" name="data" id="data_img" title="이미지체크"> 이미지</label></li>
                                       	<li><label><input type="radio" name="data" id="data_movie" title="동영상체크"> 동영상</label></li>
                                      </ul>
                                      <input type="file" size="30" name="file" id="file">
                                      <ul class="guide">
                                          <li>사진, 동영상 등 신고 관련 자료를 첨부해주십시오.</li>
                                          <li>사진 자료는 gif, jpg, bmp, png, zip 파일만 가능합니다.</li>
                                          <li>동영상 자료는 avi, mpg, asf, wmv, k3g, mov 파일만 가능합니다.</li>
                                          <li>사진자료는 10Mb / 동영상 자료는 50Mb 까지 가능 합니다. </li>
                                      </ul>
                                  </td>
                              </tr>
                              <tr>
                                  <th><label for="sub_find_rsn">이물발견경위</label></th>
                                  <td colspan="3">
                                  	<textarea cols="55" rows="5" id="sub_find_rsn" name="sub_find_rsn" title="이물발견경위"></textarea>
                                      <p>* 6하원칙에 따라 상세히 작성<br>
                                          - 제품개봉 직후 발견, 개봉후 보관하면서 3개월간 섭취 중 발견<br>
                                          - 조리하여 섭취 중 발견, 한입 먹던 중 입속에서 발견 등<br>
                                          - 개봉하지 않은 유사제품 보관여부 등</p>
                                 </td>
                              </tr>
                              <tr>
                                  <th><label for="sub_keep">이물발견<br>제품보관환경</label></th>
                                  <td colspan="3">
                                  	<textarea cols="55" rows="5" id="sub_keep" name="sub_keep" title="이물발견 제품보관환경"></textarea>
                                  	<p>* 주변환경을 조사하여 소비자 부주의 등에 대한 조사 실시<br>
                                          - 발견된 이물이 소비자 주변에서 쉽게 확인<br>
                                          * 제품 보관온도 등 조사</p>
                                  </td>
                              </tr>
                              <tr>
                                  <th><label for="exam_rsn">보고자 의견</label></th>
                                  <td colspan="3">
                                  	<textarea cols="55" rows="5" id="exam_rsn" name="exam_rsn" title="보고자 의견"></textarea>
                                  	<p>* 이물 혼입 원인에 대한 조사결과 기록 : 소비자 부주의 등<br>
                                          * 소비자 피해보상 요구사항 등 작성</p>
                                  </td>
                              </tr>
                              <tr>
                                  <th><label for="comp_date">클레임 접수일시</label></th>
                                  <td colspan="3"><input type="text" name="comp_date" id="comp_date" maxlength="8" size="32" value=""> 예) 20150427</td>
                              </tr>
                          </tbody>
                      </table>
                  </fieldset>
                  <div class="btn-container">
                      <button type="submit" class="btn btn-default btn-lg" id="submitBtn">등록</button>
                      <button type="button" class="btn btn-danger btn-lg" id="cancelBtn" onclick="location.href='/cfscr/complain.do?top_navi=3'">취소</button>
                  </div>
              </form>
          </article>
      </div>
  </section>