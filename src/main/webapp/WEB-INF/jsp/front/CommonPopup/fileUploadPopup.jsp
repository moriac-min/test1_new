<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="m" uri="/WEB-INF/tlds/message.tld"%>
<%@ page import="foodportal.common.util.Message"%>

<script type="text/javascript" src="/js/jquery.js"></script>
<script type="text/javascript" src="/js/jquery.min.js"></script>
<script type="text/javascript" src="/js/jquery.form.min.js"></script>
<script type="text/javascript" src="/js/json2.js"></script>
<script type="text/javascript" src="/js/spin.min.js"></script>

<form id="uploadForm" method="post" enctype="multipart/form-data" action="${contextPath}/popup/CommonPopup/processFileUpload.do">
	<input name="uploadFile" id="uploadFile" type="file" />
	<input type="button" id="submitBtn" value="파일 업로드" />
	<!-- 
	<input type="submit" id="submitBtn" value="파일 업로드" />
	 -->
	<input type="hidden" id="uploadSource" name="uploadSource" value="${uploadSource }" />
	<input type="hidden" id="fileExt" name="fileExt" value="${fileExt }" />
	<input type="hidden" id="filePath" name="filePath" value="${filePath }" />
	<input type="hidden" id="fileMaxSize" name="fileMaxSize" value="${fileMaxSize }" />
</form>
 
<div id="percent">0%</div>
<div id="status"></div>
<div id="loading_bar"></div>
 
 
<script type="text/javascript">
var spinnerOption = {lines:6,length:10,width:15,radius:10,corners:1,rotate:0,direction:1,color:('#000000'),speed:1,trail:60,shadow:false,hwaccel:false,className:'spinner',zIndex:2e9,top:'50%',left:'50%'};

$(function() {
	$('#submitBtn').click(function(){
		if($('#uploadFile').val() == '' || typeof $('#uploadFile').val() == 'undefined'){
			return;	
		}
		
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
		
		if(!window.FileReader){
			 if(!confirm('구버전의 브라우저 입니다.\n 업로드에 오랜 시간이 걸릴 수도 있습니다.\n\n 계속 진행하시겠습니까?')){
				 return;
			 }
				 
		}else{
			var $file = $('#uploadFile')[0].files[0];
			var fileSize = $file.size;
			var fileMaxSize = $('#fileMaxSize').val();
			
			if(fileSize > fileMaxSize){
				var sizeUnit = ['', 'K', 'M', 'G', 'T'];
				var idx = 0;
				
				for(var i=1; i<fileMaxSize; i*=1000){
					fileMaxSize/=1000;
					idx++;
				}
				
				alert('업로드 용량은 '+fileMaxSize+sizeUnit[idx]+'byte까지 가능합니다.');
				return;
			}
		 }
		
		$('#uploadForm').submit();
		
	});
	
	$('#uploadForm').ajaxForm({
		beforeSubmit: function(data, frm, opt){
			
			$('#percent').html('0%');
			$('#status').html('');
			
			$('#uploadFile').attr('disabled', true);
			$('#submitBtn').attr('disabled', true);
			
			spinner = new Spinner(spinnerOption);
			spinner.spin(document.getElementById('loading_bar'));
		},
		uploadProgress: function(event, position, total, percentComplete){
			var percentVal = percentComplete + '%';
			 
			$('#percent').html(percentVal);
			 
			if(percentComplete == '100'){
				$('#status').html('파일 유효성 체크중');
			}
		},
		success: function(rstData){
			spinner.stop();
			rstData = JSON.parse(rstData);
			 
			if(rstData.rtnCd == '1'){
				//logic_file_nm, physic_file_nm, file_path, file_mg, file_type_cd
				alert(rstData.rtnMessage);
				parent.fn_callbackfileUpload(rstData);
				
			}else{
				alert(rstData.rtnMessage);
				parent.$.fancybox.close();
			}
			self.close();
		},
		error: function(){
			spinner.stop();
			alert('파일업로드 중 에러가 발생하였습니다. \n\n 잠시 후 다시 시도하세요.');
			parent.$.fancybox.close();
		}
	});
});
</script>