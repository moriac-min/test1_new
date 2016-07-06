<%@page language="java" contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<input type="hidden" id="file_path" name="file_path">               <!-- 파일경로 -->
<input type="hidden" id="physic_file_nm" name="physic_file_nm">     <!-- 물리파일명 -->
<input type="hidden" id="logic_file_nm" name="logic_file_nm">       <!-- 논리파일명 -->
<input type="hidden" id="file_type_cd" name="file_type_cd">         <!-- 확장자 -->

<table summary="" class="panel-group" id="accordion">
    <caption></caption>
    <colgroup>
        <col style="width:60px;">
        <col style="width:845px;">
        <col style="width:90px;">
    </colgroup>
    <thead>
        <tr>
            <th scope="col">번호</th>
            <th scope="col">제목</th>
            <th scope="col">등록일</th>
        </tr>
    </thead>
    <tbody class="panel" id="listFrame">
    <!-- 
        <tr data-toggle="collapse" data-parent="#accordion" href="#a1">
            <td class="num">1234</td>
            <td class="subject q"><a href="#a1">[비타민] 식품원료란 무엇인가요?</a>
            </td>
            <td class="num">2014.10.10</td>
        </tr>
        <tr id="a1" class="panel-collapse collapse">
            <td class="blank"></td>
            <td colspan="2" class="tl a">
                <p>식품원료는 식품을 제조, 가공하는데 사용되는 원료를 말합니다. 현행 식품원료 관리는 크게 세 가지로 구분되어 관리되고 있습니다. 즉, 식품에 사용할 수 있는 원료, 식품에 제한적으로 사용할 수 있는 원료, 식품에 사용할 수 없는 원료로 관리됩니다. 또한, 식품공전 제1. 3. 식품원재료 분류에 의한 농·축·수산물원재료도 식품원료로 사용됩니다.</p>
                <div class="attached-file">
                    <ul>
                        <li><a href="#">20140623_2014 2th event_board_539 740.jpg</a> <span class="file-size">254 KB</span></li>
                        <li><a href="#">20140623_2014 2th event_board_539 740.jpg</a> <span class="file-size">254 KB</span></li>
                    </ul>
                </div>
            </td>
        </tr>
         -->
    </tbody>
</table>

<script>
	
function fn_drawList(list){
		var listLangth = list.length;
		var content = "";
		var fileList = null;
		
		for(var i=0; i<listLangth; i++){
			content += "<tr data-toggle='collapse' data-parent='#accordion' href='#a"+i+"'>";
			content += "  <td class='num'>"+list[i].no+"</td>";
			content += "  <td class='subject q'><a href='#a"+i+"'>"+list[i].titl+"</a></td>";
			content += "  <td class='num'>"+list[i].last_updt_dtm+"</td>";
			content += "</tr>";
			content += "<tr id='a"+i+"' class='panel-collapse collapse'>";
			content += "  <td class='blank'></td>";
			content += "  <td colspan='2' class='tl a'>";
			content += "    <p>"+list[i].bdt+"</p>";
			
			fileList = new Array();
			fileList = list[i].fileList;
			
			if(fileList != null){
				if(fileList.length > 0){
					content += "<div class='attached-file'>";
					content += "  <ul>";
					for(var j=0; j < fileList.length; j++){
						content += "<li><a href=javascript:downloadFile('"+fileList[j].file_path+"','"+fileList[j].physic_file_nm+"','"+fileList[j].logic_file_nm+"','"+fileList[j].file_type_cd+"');>"+fileList[j].logic_file_nm+"</a> <span class='file-size'>"+fileList[j].file_mg+" KB</span></li>";
					}
					content += "  </ul>";
					content += "</div>";
				}
			}
			
			content += "  </td>";
			content += "</tr>";
			
		}
		
		$('#listFrame').html(content);
	}
	
	function downloadFile(file_path, physic_file_nm, logic_file_nm, file_type_cd){
        
        $('#file_path').val(file_path);
        $('#physic_file_nm').val(physic_file_nm);
        $('#logic_file_nm').val(logic_file_nm);
        $('#file_type_cd').val(file_type_cd);
        
        document.baseForm.action="${contextPath}/portal/board/downloadAttchdFile.do";
        document.baseForm.target="_self";
        document.baseForm.submit();
        
   } 
	
</script>