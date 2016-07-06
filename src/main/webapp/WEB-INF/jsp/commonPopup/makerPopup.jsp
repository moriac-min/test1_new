<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<link type="text/css" href="${contextPath}/css/style_minwon.css" rel="stylesheet">    
    
    <div class="inner-head">
        <h1>제조원찾기</h1>
    </div>
    <div class="inner-body">
        <div id="vendor">
            <div class="emphasis">
                <p style="margin:0;">찾고 싶은 업소명, 주소, 업종 중 하나를 입력하세요<br>
                    예) (주)고려홍삼, 대원식당, 종로구, 일반음식점, 식품제조가공업</p>
            </div>
            <dl class="item">
                <dt>
                    <label for="vname">업소명</label>
                </dt>
                <dd>
                    <input type="text" value="" size="15" id="vname" name="vname" onfocus="this.style.imeMode='active';">
                </dd>
                <dt>
                    <label for="vaddress">주소</label>
                </dt>
                <dd>
                    <input type="text" value="" size="15" id="vaddress" name="vaddress">
                </dd>
                <dt>
                    <label for="vsale">업종</label>
                </dt>
                <dd>
                    <input type="text" value="" size="15" id="vsale" name="vsale">
                </dd>
                <dd> <a href="" class="btn btn-default btn-sm namecheck">검색</a> </dd>
            </dl>
            <div class="list-container">
                <table>
                    <caption>
                    업소 목록
                    </caption>
                    <colgroup>
                    <col width="5%">
                    <col width="18%">
                    <col width="18%">
                    <col width="10%">
                    <col width="10%">
                    <col>
                    </colgroup>
                    <thead>
                        <tr>
                            <th scope="col">번호</th>
                            <th scope="col">업종</th>
                            <th scope="col">업소명</th>
                            <th scope="col">대표자</th>
                            <th scope="col">허가번호</th>
                            <th scope="col">주소</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <td scope="row">301</td>
                            <td>집단급식소</td>
                            <td><a href="#" onclick="send('(주)농심', '051 3665604', '부산광역시 사상구 사상로455번길 46 (모라동)')">(주)<strong>농심</strong></a></td>
                            <td>박준</td>
                            <td>9</td>
                            <td class="tl">부산광역시 사상구 사상로455번길 46 (모라동)</td>
                        </tr>
                        <tr>
                            <td scope="row">300</td>
                            <td>건강기능식품유통전문판매업</td>
                            <td><a href="#" onclick="send('(주)농심', '8207243', '서울특별시 동작구 신대방동 370')">(주)<strong>농심</strong></a></td>
                            <td>이상윤</td>
                            <td>00016</td>
                            <td class="tl">서울특별시 동작구 신대방동 370</td>
                        </tr>
                        <tr>
                            <td scope="row">299</td>
                            <td>건강기능식품수입업</td>
                            <td><a href="#" onclick="send('(주)농심', '02 8207114', '서울특별시 동작구 여의대방로 112 (신대방동)')">(주)<strong>농심</strong></a></td>
                            <td>박준</td>
                            <td>2004-0390</td>
                            <td class="tl">서울특별시 동작구 여의대방로 112 (신대방동)</td>
                        </tr>
                        <tr>
                            <td scope="row">298</td>
                            <td>식품제조가공업</td>
                            <td><a href="#" onclick="send('(주)농심', '031 670 5512', '')">(주)<strong>농심</strong></a></td>
                            <td></td>
                            <td>1</td>
                            <td class="tl"></td>
                        </tr>
                        <tr>
                            <td scope="row">297</td>
                            <td>건강기능식품일반판매업</td>
                            <td><a href="#" onclick="send('(주)농심', '8207333', '서울특별시 동작구 신대방동 370')">(주)<strong>농심</strong></a></td>
                            <td>이상윤</td>
                            <td>00387</td>
                            <td class="tl">서울특별시 동작구 신대방동 370</td>
                        </tr>
                        <tr>
                            <td scope="row">296</td>
                            <td>집단급식소</td>
                            <td><a href="#" onclick="send('(주)농심', '02 8208865', '서울특별시 동작구 신대방동 370-1')">(주)<strong>농심</strong></a></td>
                            <td>박준</td>
                            <td>00044</td>
                            <td class="tl">서울특별시 동작구 신대방동 370-1</td>
                        </tr>
                        <tr>
                            <td scope="row">295</td>
                            <td>유통전문판매업</td>
                            <td><a href="#" onclick="send('(주)농심', '02 8207114', '서울특별시 동작구 신대방동 370-1')">(주)<strong>농심</strong></a></td>
                            <td>박준</td>
                            <td>00034</td>
                            <td class="tl">서울특별시 동작구 신대방동 370-1</td>
                        </tr>
                        <tr>
                            <td scope="row">294</td>
                            <td>유통전문판매업</td>
                            <td><a href="#" onclick="send('(주)농심', '031 4521211', '경기도 군포시 농심로 35 (당정동)')">(주)<strong>농심</strong></a></td>
                            <td>박준</td>
                            <td>2</td>
                            <td class="tl">경기도 군포시 농심로 35 (당정동)</td>
                        </tr>
                        <tr>
                            <td scope="row">293</td>
                            <td>식품제조가공업</td>
                            <td><a href="#" onclick="send('(주)농심', '031450 5513', '경기도 군포시 농심로 35 (당정동)')">(주)<strong>농심</strong></a></td>
                            <td>박준</td>
                            <td>1</td>
                            <td class="tl">경기도 군포시 농심로 35 (당정동)</td>
                        </tr>
                        <tr>
                            <td scope="row">292</td>
                            <td>식품소분업</td>
                            <td><a href="#" onclick="send('(주)농심', '031 4505511', '경기도 군포시 농심로 35 (당정동)')">(주)<strong>농심</strong></a></td>
                            <td>박준</td>
                            <td>7</td>
                            <td class="tl">경기도 군포시 농심로 35 (당정동)</td>
                        </tr>
                    </tbody>
                </table>
                <div class="board-footer">
                    <div class="pagination"></div>
                </div>
            </div>
        </div>
    </div>

