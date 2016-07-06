
<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="m" uri="/WEB-INF/tlds/message.tld"%>
<%@ page import="foodportal.common.util.Message"%>

<c:set var="contextPath" scope="request">${pageContext.request.contextPath}</c:set>
<link type="text/css" href="${contextPath}/css/style_minwon.css" rel="stylesheet">
<form id="popupForm" name="popupForm">

<input type="hidden" id="allSearch" name="allSearch" value="${allSearch }">                <!-- 미등록업소 포함 플래그 -->
<input type="hidden" id="start_idx" name="start_idx">                <!-- start_idx -->
<input type="hidden" id="show_cnt" name="show_cnt" value="10">       <!-- show_cnt -->
<input type="hidden" id="sys_cd" name="sys_cd" value="ADM">           <!-- 행망 ADM -->
<input type="hidden" id="cmmn_cd" name="cmmn_cd" value="K18">         <!-- 1399 공통코드 -->

    <div class="inner-head">
        <h1>업소찾기</h1>
    </div>
    <div class="inner-body">
        <div id="vendor">
            <div class="emphasis">
                <p style="margin:0;">찾고 싶은 업소명, 주소, 업종 중 하나를 입력하세요<br>
                    예) (주)홍삼, 대원식당, 종로구, 일반음식점, 식품제조가공업</p>
            </div>
            <dl class="item">
                <dt>
                    <label for="vname">업소명</label>
                </dt>
                <dd>
                    <input type="text" value="" size="15" id="search_bssh_nm" name="search_bssh_nm" onfocus="this.style.imeMode='active';">
                </dd>
                <dt>
                    <label for="vaddress">주소</label>
                </dt>
                <dd>
                    <input type="text" value="" size="30" id="search_addr_dtl" name="search_addr_dtl">
                </dd>
                <dt>
                    <label for="vsale">업종</label>
                </dt>
                <dd>
                    <input type="text" value="" size="15" id="search_induty_cd_nm" name="search_induty_cd_nm">
                </dd>
                <dd> <a href="javascript:searchList();" class="btn btn-default btn-sm namecheck">검색</a> </dd>
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
                    <tbody  id="listFrame">
                            <!-- 
	                        <tr>
	                            <td scope="row">292</td>
	                            <td>식품소분업</td>
	                            <td><a href="#" onclick="send('(주)농심', '031 4505511', '경기도 군포시 농심로 35 (당정동)')">(주)<strong>농심</strong></a></td>
	                            <td>박준</td>
	                            <td>7</td>
	                            <td class="tl">경기도 군포시 농심로 35 (당정동)</td>
	                        </tr>
	                         -->
                    </tbody>
                </table>
                <div class="board-footer">
                    <div class="pagination"></div>
                </div>
            </div>
        </div>
    </div>
</form>

<script type="text/javascript">

    /****************************************
     * Variable
    ****************************************/
    var total_cnt_onPage = 0;
    var show_cnt_onPage = 0;
    /****************************************
     * Init
    ****************************************/
    
    $(document).ready(function(){
        
        $('#start_idx').val("1");
                
    }); 
    
    /****************************************
     * Button Action
     ****************************************/
    //페이징 변수셋팅
    function setPaginationVars(){
         //total_cnt_onPage = total_cnt;
         show_cnt_onPage = $('#show_cnt').val();
         
         $('.pagination').pagination("updateItems", total_cnt_onPage);
         $('.pagination').pagination("updateItemsOnPage", show_cnt_onPage);
         //$('.pagination').pagination('redraw');
         var pageNum = $('#start_idx').val();
         if(pageNum == null || pageNum == ''){
             pageNum = 1;
         }
         
         $('.pagination').pagination('drawPage', pageNum);
     }
     
    //페이징
    $(function() {
        $('.pagination').pagination({
            items: total_cnt_onPage,
            itemsOnPage: show_cnt_onPage,
            cssStyle: 'compact-theme'
        });
    });
    
    $('.pagination').click(function(){
        var page = $('.pagination').pagination('getCurrentPage');
        if($('#start_idx').val() != page){
            $('#start_idx').val(page);
            searchList();
        }
        return false;
    });
    
    /****************************************
     * Function
     ****************************************/
     function searchList(){
    	   
    	   if(($('#search_bssh_nm').val() == null || $('#search_bssh_nm').val() == '') 
    			   && ($('#search_addr_dtl').val() == null || $('#search_addr_dtl').val() == '')
    			   && ($('#search_induty_cd_nm').val() == null || $('#search_induty_cd_nm').val() == '')){
    		  alert('${m:getMessage("msg.common.valid.searchWord") }') ;
    		  return false;
    	   }
    	   
           //특수문자제거
           fn_replaceSpecialChar('#search_bssh_nm');
           fn_replaceSpecialChar('#search_addr_dtl');
           fn_replaceSpecialChar('#search_induty_cd_nm');
           
           $.ajax({ 
               data: $('#popupForm').serialize(),
               dataType:'json', 
               type:'POST',
               url:"${contextPath}/popup/commonPopup/searchShop.do", 
               success:function(arg){
                   
                   //total 개수
                   total_cnt_onPage = arg.total_cnt;
                   $('#total_cnt').text(total_cnt_onPage);
                   
                   //페이징 셋팅
                   setPaginationVars();
                   
                   list = new Array();
                   list = arg.list;
                   
                   fn_drawList(list);
               },
               error:function(request,status,error){
                   alert("실패코드 : " + request.status+"\n메세지 : " + request.error);
               }
           });
       }
     
    //목록 그리기
     function fn_drawList(list){
     
        var listLangth = list.length;
        var content = "";
        var paramObj = null;
        
        for(var i=0; i<listLangth; i++){
        	paramObj = {lcns_no: list[i].lcns_no, bssh_nm: list[i].bssh_nm, telno: list[i].telno, addr: list[i].addr, addr_dtl: list[i].addr_dtl, zipno: list[i].zipno};
        	if( $('allSearch').val() == 'Y'){
        		paramObj.seq_no = list[i].seq_no;
        		paramObj.makr_reg_unreg_bssh_dvs_cd = list[i].makr_reg_unreg_bssh_dvs_cd;
        	}

            content += "<tr>";
            content += "    <td scope='row'>"+nvl(list[i].no)+"</td>";
            content += "    <td>"+nvl(list[i].induty_cd_nm)+"</td>"; 
        	content += "    <td><a href='#' onclick=\"javascript:setSelectedVal('"+i+"'); return false;\"><strong>"+list[i].bssh_nm+"</strong></a></td>";
        	content += "    <td>"+nvl(list[i].prsdnt_nm)+"</td>"; 
        	content += "    <td>"+nvl(list[i].lcns_no)+"</td>";
        	content += "    <td class='tl'>"+nvl(list[i].addr)+" "+nvl(list[i].addr_dtl)+"</td>";
        	content += "</tr>";
        }
        
        $('#listFrame').html(content);
    }
    
    
    function setSelectedVal(idx){
    	parent.fn_callbackShop(list[idx]);
    }
</script>
