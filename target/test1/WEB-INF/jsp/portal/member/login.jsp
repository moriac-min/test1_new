<%@page language="java" contentType="text/html; charset=utf-8"
%><%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"
%><%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"
%><%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"
%>

<input type="text" id="inputId" maxlength="12">

<input type="text" id="inputPwd" maxlength="12">

<input type="button" id="login" value="로그인">

<input type="button" id="loginRe" value="공인 인증서 로그인">

<a href="/portal/member/popup/findId.do" class="btn btn-default btn-lg">아이디 찾기</a>
<a href="/portal/member/popup/findId.do" class="btn btn-default btn-lg">비밀번호 재설정</a>
<input type="button" id="beMember" value="회원가입">



<script type="text/javascript">

$(document).ready(function(){
	
	$("#login").click(function(){
		
		var user_id = fn_replaceSpecialChar("#inputId");
		var pwd = $("#inputPwd").val();
		var param = "user_id="+user_id+"&pwd="+pwd+"&search_type=loginIn";
		
		$.ajax({
			type: "post",
			url : "/portal/member/ajax/chkLogin.do?"+param,
			dataType : "json",
			success: function(data){
				if(data != ''){
					alert("접속을 환영합니다.");
					location.replace("/portal/main.do");
				}else{
					alert("아이디 혹은 비밀번호를 확인해 주세요.");
				}
			}
		});
	});
	
});


</script>