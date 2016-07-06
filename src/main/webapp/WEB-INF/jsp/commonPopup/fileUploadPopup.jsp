<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="m" uri="/WEB-INF/tlds/message.tld"%>
<%@ page import="foodportal.common.util.Message"%>

<link type="text/css" href="${contextPath}/css/style_minwon.css" rel="stylesheet">

<script type="text/javascript" src="${contextPath}/js/jquery.js"></script>
<script type="text/javascript" src="${contextPath}/js/jquery.min.js"></script>
<script type="text/javascript" src="${contextPath}/js/jquery.form.min.js"></script>
<script type="text/javascript" src="${contextPath}/js/bootstrap/button.js"></script>

<!-- Size: 530 X 350 -->
    <div class="inner-head">
        <h1>파일첨부</h1>
    </div>
    <div class="inner-body"> 
        <!-- 실제 들어갈 페이지 -->
        <form id="uploadForm" method="post" enctype="multipart/form-data" action="/popup/commonPopup/processFileUpload.do">
            <div class="file-container">
                <input type="text" id="uploadFileView" name="uploadFileView" readonly>
                <div class="file-input">
                    <input type="button" value="파일찾기" class="btn file-button">
                    <input type="hidden" id="uploadSource" name="uploadSource" value="${uploadSource }" />
					<input type="hidden" id="fileExt" name="fileExt" value="${fileExt }" />
					<input type="hidden" id="filePath" name="filePath" value="${filePath }" />
					<input type="hidden" id="fileMaxSize" name="fileMaxSize" value="${fileMaxSize }" />
                    <input type="file" id="uploadFile" name="uploadFile" class="file-hidden">
                </div>
            </div>
            <div class="check">
                <button type="button" id="submitBtn" data-loading-text="업로드 중..." class="btn btn-primary btn-block">파일 업로드</button>
            </div>
            <div id="status">유효성 체크중입니다.</div>
        </form>
	</div>
 
<script type="text/javascript">
/***************************************************************************************
* 시스템명 	: 식품의약품안전처 통합식품안전망구축
* 업무명 		: 파일업로드
* 파일명 		: fileUploadPopup.jsp
* 작성자 		: 장영철
* 작성일 		: 2014.10.11
*
* 설  명		:  파일업로드
*------------------------------------------------------------------------------------
* 변경일	변경자		변경내역 
*------------------------------------------------------------------------------------
*  2014.10.11 장영철		최초 프로그램 작성         
* 
*------------------------------------------------------------------------------------
**************************************************************************************/
$(function() {
	$('#status').hide();
	
	$('#uploadFile').change(function(){
		$('#uploadFileView').val($(this).val().replace('C:\\fakepath\\', ''));
	});
	
	$('#submitBtn').click(function(){
		
		if(fileExt != '*'){
			var file = $('#uploadFile').val();
			var fileOriginalExt = file.substring(file.lastIndexOf('.')+1, file.length);
			var fileExt = $('#fileExt').val().split('&');
			var fileMaxSize = $('#fileMaxSize').val().split('&');
			var fileInfoIdx;
			var regex;
			
			$.each(fileExt, function(i, v){
				regex = new RegExp('^'+v+'$');
				if(regex.test( fileOriginalExt )){
					$('#fileMaxSize').val(fileMaxSize[i]);
					fileInfoIdx = i;
					return false;
				}
			});
			
			if(typeof fileInfoIdx == 'undefined'){
				alert('지원하지 않는 파일 형식입니다.');
				return;
			}
		}

		btn = $(this);
		$('#uploadForm').submit();
		
	});
	
	$('#uploadForm').ajaxForm({
		beforeSubmit: function(data, frm, opt){
			$('.btn.file-button').attr('disabled', true);
			$('#submitBtn').attr('disabled', true);
		},
		uploadProgress: function(event, position, total, percentComplete){
			btn.button('loading');
			
			if(percentComplete == '100'){
				$('#status').show();
			}
		},
		success: function(rstData){
			$('#status').hide();
			btn.button('reset');
			
			rstData = JSON.parse(rstData);
			 
			if(rstData.rtnCd == '1'){
				//logic_file_nm, physic_file_nm, file_path, file_mg, file_type_cd
				alert(rstData.rtnMessage);
				parent.fn_callbackfileUpload(rstData);
				
			}else{
				alert(rstData.rtnMessage);
				closePopup();
			}
		},
		error: function(){
			alert('파일업로드 중 에러가 발생하였습니다. \n\n 잠시 후 다시 시도하세요.');
			closePopup();
		}
	});
});

function closePopup(){
	try{
		parent.$.fancybox.close();
	}catch(e){
		self.close();
	}
}
</script>