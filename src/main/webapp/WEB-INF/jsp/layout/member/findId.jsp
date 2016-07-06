<%@page language="java" contentType="text/html; charset=utf-8"
%><%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"
%><%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"
%><%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"
%>

<link type="text/css" href="../../../css/bootstrap.min.css" rel="stylesheet">
<link type="text/css" href="../../../css/webfont.css" rel="stylesheet">
<link type="text/css" href="../../../css/jquery.selecter.css" rel="stylesheet">
<link type="text/css" href="../../../css/style_popup.css" rel="stylesheet">
<script type="text/javascript" src="../../../js/jquery.min.js"></script>
<script type="text/javascript" src="../../../js/jquery.selecter.min.js"></script>
<script>
$().ready(function() {
    setTimeout(function() {
        var heightOffset = window.outerHeight - window.innerHeight;
        var widthOffset = window.outerWidth - window.innerWidth;
        var height = document.getElementById("popup").clientHeight + heightOffset;
        var width = document.getElementById("popup").clientWidth + widthOffset;
        //window.resizeTo(width, height);
    }, 100);
    
    //아이디 찾기 클릭시
    $('#t1').click(function(){
    	$("#tab2").hide();
    	$("#tab2").empty();
    	$("#tab1").empty();
    	$('#t2').removeClass('active');
		$('#t1').addClass('active');
		$("#tab1").html($("#findIdStep1").html());
    	$("#tab1").show();
    });
    
    //비밀 번호 찾기 클릭시
    $('#t2').click(function(){
    	$("#tab1").hide();
    	$("#tab1").empty();
    	$("#tab2").empty();
		$('#t1').removeClass('active');
		$('#t2').addClass('active');
		$("#tab2").html($("#findPwdStep1").html());
    	$("#tab2").show();
    });
    
    $("#tab2").hide();
    $("#tab1").html($("#findIdStep1").html());

});

//인증 번호 받기
function getNumber(f,d){
	if(f == 'id'){	//id 찾기
		if(d == 'm'){	//휴대폰 인증

		}else{			//이메일 인증
			
		}
	}else{			//비밀번호 찾기
		if(d == 'm'){	//휴대폰 인증
			
		}else{			//이메일 인증
			
		}
	}
	
}

function idStep2(){
	//이름, 휴대폰(이메일) 인증 번호 받은후 아이디 있는지 없는지 리턴
	var returnVal = "";
	if(returnVal == ""){//성공시
		$("#tab1").empty();
    	$("#tab1").html($("#findIdStep2S").html());
	}else{				//실패시
		$("#tab1").empty();
    	$("#tab1").html($("#findIdStep2F").html());
	}
}

function pwdStep2(f){
	//아이디, 휴대폰(이메일) 인증 번호 받은후 비밀번호 재 설정
	var returnVal = "";
	if(f == ''){
		$("#tab2").empty();
		$("#tab2").html($("#findPwdStep2S").html());
	}else{
		$("#tab2").empty();
		$("#tab2").html($("#findPwdStep3").html());
	}
}

</script>

<script type="text" id="findIdStep1">
			<h1>아이디 찾기</h1>
		        <div class="phone-dscr">
		            <h2>휴대폰으로 인증</h2>
		            <p>회원정보에 등록한 휴대폰 번호와 입력한 휴대폰 번호가 같아야 인증번호를 받을 수 있습니다.</p>
		        </div>
		        <div class="phone">
		            <fieldset>
		                <legend>휴대폰으로 인증</legend>
		                <table>
		                    <caption>
		                    휴대폰으로 인증을 위한 정보등록
		                    </caption>
		                    <colgroup>
		                    <col style="width:100px;">
		                    <col style="">
		                    </colgroup>
		                    <tbody>
		                        <tr>
		                            <th><label for="username">성명</label></th>
		                            <td><input type="text" id="username" name="username" value=""></td>
		                        </tr>
		                        <tr>
		                            <th><label for="phone">휴대폰</label></th>
		                            <td><input type="text" id="phone" name="phone" onfocus="if(this.value !='')this.value='';" onblur="if(this.value.length==0){this.value='숫자만 입력하세요.';}" value="숫자만 입력하세요."></td>
		                        </tr>
		                        <tr>
		                            <th><label for="phone-code">인증번호</label></th>
		                            <td><a href="#" class="btn btn-info" onclick="javascript:getNumber('id','m');">인증번호 받기</a>
		                                <input type="text" id="phone-code" name="phone-code" onfocus="if(this.value !='')this.value='';" onblur="if(this.value.length==0){this.value='인증번호 6자리 숫자 입력';}" value="인증번호 6자리 숫자 입력"></td>
		                        </tr>
		                    </tbody>
		                </table>
		            </fieldset>
		            <div class="help"> 인증번호가 오지 않나요 <a title="1588 번호가 스팸 문자로 등록되어 있는 것은 아닌지 확인해주세요. 스팸 문자로 등록되어 있지 않다면, 다시 한 번 ‘인증번호 받기’를 눌러주세요." class="tool-tip"><span title="more"><img src="../../../img/membership/icon-help.png" width="19" height="19" alt="확인"></span></a> </div>
		        </div>
		        <div class="email-dscr">
		            <h2>이메일로 인증</h2>
		            <p>회원정보에 등록한 이메일 주소와 입력한 이메일 주소가 같아야 인증번호를 받을 수 있습니다.</p>
		        </div>
		        <div class="email">
		            <fieldset>
		                <legend>이메일로 인증</legend>
		                <table>
		                    <caption>
		                    휴대폰으로 인증을 위한 정보등록
		                    </caption>
		                    <colgroup>
		                    <col style="width:100px;">
		                    <col style="">
		                    </colgroup>
		                    <tbody>
		                        <tr>
		                            <th><label for="username-2">성명</label></th>
		                            <td><input type="text" id="username-2" name="username-2" value=""></td>
		                        </tr>
		                        <tr>
		                            <th><label for="email">이메일</label></th>
		                            <td><input type="text" id="email" name="email" value=""></td>
		                        </tr>
		                        <tr>
		                            <th><label for="email-code">인증번호</label></th>
		                            <td><a href="#" class="btn btn-info" onclick="javascript:getNumber('id','e');">인증번호 받기</a>
		                                <input type="text" id="email-code" name="email-code"onfocus="if(this.value !='')this.value='';" onblur="if(this.value.length==0){this.value='인증번호 6자리 숫자 입력';}" value="인증번호 6자리 숫자 입력"></td>
		                        </tr>
		                    </tbody>
		                </table>
		            </fieldset>
		            <div class="help"> 인증번호가 오지 않나요 <a title="인증용으로 발송한 메일이 스팸 메일로 분류된 것은 아닌지 확인해 주세요. 스팸 메일함에도 메일이 없다면, 다시 한 번 ‘인증번호 받기’를 눌러주세요." class="tool-tip"><span title="more"><img src="../../../img/membership/icon-help.png" width="19" height="19" alt="확인"></span></a> </div>
		        </div>
		        <div class="footer"> <a href="#" class="btn btn-default btn-lg" onclick="javascript:idStep2();">다음</a> </div>
</script>

<script type="text" id="findPwdStep1">

			<h1>비밀번호 찾기<</h1>
		        <div class="phone-dscr">
		            <h2>휴대폰으로 인증</h2>
		            <p>회원정보에 등록한 휴대폰 번호와 입력한 휴대폰 번호가 같아야 인증번호를 받을 수 있습니다.</p>
		        </div>
		        <div class="phone">
		            <fieldset>
		                <legend>휴대폰으로 인증</legend>
		                <table>
		                    <caption>
		                    휴대폰으로 인증을 위한 정보등록
		                    </caption>
		                    <colgroup>
		                    <col style="width:100px;">
		                    <col style="">
		                    </colgroup>
		                    <tbody>
		                        <tr>
		                            <th><label for="userid">아이디</label></th>
		                            <td><input type="text" id="userid" name="userid" value=""></td>
		                        </tr>
		                        <tr>
		                            <th><label for="username">성명</label></th>
		                            <td><input type="text" id="username" name="username" value=""></td>
		                        </tr>
		                        <tr>
		                            <th><label for="phone">휴대폰</label></th>
		                            <td><input type="text" id="phone" name="phone" onfocus="if(this.value !='')this.value='';" onblur="if(this.value.length==0){this.value='숫자만 입력하세요.';}" value="숫자만 입력하세요."></td>
		                        </tr>
		                        <tr>
		                            <th><label for="phone-code">인증번호</label></th>
		                            <td><a href="#" class="btn btn-info" onclick="javascript:getNumber('pwd','m');">인증번호 받기</a>
		                                <input type="text" id="phone-code" name="phone-code" onfocus="if(this.value !='')this.value='';" onblur="if(this.value.length==0){this.value='인증번호 6자리 숫자 입력';}" value="인증번호 6자리 숫자 입력"></td>
		                        </tr>
		                    </tbody>
		                </table>
		            </fieldset>
		            <div class="help"> 인증번호가 오지 않나요 <a title="1588 번호가 스팸 문자로 등록되어 있는 것은 아닌지 확인해주세요. 스팸 문자로 등록되어 있지 않다면, 다시 한 번 ‘인증번호 받기’를 눌러주세요." class="tool-tip"><span title="more"><img src="../../../img/membership/icon-help.png" width="19" height="19" alt="확인"></span></a> </div>
		        </div>
		        <div class="email-dscr">
		            <h2>이메일로 인증</h2>
		            <p>회원정보에 등록한 이메일 주소와 입력한 이메일 주소가 같아야 인증번호를 받을 수 있습니다.</p>
		        </div>
		        <div class="email">
		            <fieldset>
		                <legend>이메일로 인증</legend>
		                <table>
		                    <caption>
		                    휴대폰으로 인증을 위한 정보등록
		                    </caption>
		                    <colgroup>
		                    <col style="width:100px;">
		                    <col style="">
		                    </colgroup>
		                    <tbody>
		                        <tr>
		                            <th><label for="userid-2">아이디</label></th>
		                            <td><input type="text" id="userid-2" name="userid-2" value=""></td>
		                        </tr>
		                        <tr>
		                            <th><label for="username-2">성명</label></th>
		                            <td><input type="text" id="username-2" name="username-2" value=""></td>
		                        </tr>
		                        <tr>
		                            <th><label for="email">이메일</label></th>
		                            <td><input type="text" id="email" name="email" value=""></td>
		                        </tr>
		                        <tr>
		                            <th><label for="email-code">인증번호</label></th>
		                            <td><a href="#" class="btn btn-info" onclick="javascript:getNumber('pwd','e');">인증번호 받기</a>
		                                <input type="text" id="email-code" name="email-code"onfocus="if(this.value !='')this.value='';" onblur="if(this.value.length==0){this.value='인증번호 6자리 숫자 입력';}" value="인증번호 6자리 숫자 입력"></td>
		                        </tr>
		                    </tbody>
		                </table>
		            </fieldset>
		            <div class="help"> 인증번호가 오지 않나요 <a title="인증용으로 발송한 메일이 스팸 메일로 분류된 것은 아닌지 확인해 주세요. 스팸 메일함에도 메일이 없다면, 다시 한 번 ‘인증번호 받기’를 눌러주세요." class="tool-tip"><span title="more"><img src="../../../img/membership/icon-help.png" width="19" height="19" alt="확인"></span></a> </div>
		        </div>
		        <div class="footer"> <a href="#" class="btn btn-default btn-lg" onclick="javascript:pwdStep2('');">다음</a> </div>
</script>

<script type="text" id="findIdStep2S">
    <!-- 성공 -->
    <div class="find-dscr">
    	<h2>아이디 찾기 결과</h2>
        <p>입력하신 정보와 일치하는 아이디 입니다.</p>
    </div>
    <div class="result">
    	<span class="user-id"><span>food</span></span>
	</div>
    <div class="footer">
    	<a href="/portal/member/login.do" class="btn btn-default btn-lg">로그인</a>
    </div>
</script>

<script type="text" id="findIdStep2F">
<!-- 실패 -->
    <div class="find-dscr">
    	<h2>아이디 찾기 결과</h2>
        <p>입력하신 정보와 일치하는 아이디가 없습니다.<br>
            다시한번 정확한 정보를 입력하신 후 조회하시기 바랍니다.</p>
    </div>
    <div class="result">
    	<a href="#" class="btn btn-info btn-lg" onclick="document.getElementById('t1').click()">다시 찾기</a>
	</div>
</script>

<script type="text" id="findPwdStep2S">
<div class="pw-dscr">
            <h2>비밀번호 재설정</h2>
            <p>새로운 비밀번호를 입력해 주세요.</p>
        </div>
        <div class="passwd">
            <fieldset>
                <legend>비밀번호 재설정</legend>
                <table>
                    <caption>
                    휴대폰으로 인증을 위한 정보등록
                    </caption>
                    <colgroup>
                    <col style="width:140px;">
                    <col style="">
                    </colgroup>
                    <tbody>
                        <tr>
                            <th><label for="passwd">새 비밀번호</label></th>
                            <td class="required">
                            	<!-- normal상태 int_pass / 1단계 사용불가 int_pass_step1 / 2단계 위험 int_pass_step2 / 3단계 보통 int_pass_step3 / 4단계 안전 int_pass_step4 -->
                            	<input type="password" id="passwd" name="passwd" value="" class="int_pass">
                            	<div class="msg1 error" style="display:block">필수 정보입니다.</div><!-- 입력하지 않은 경우 -->
                            	<div class="msg1" style="display:none">6~16자 영문 대 소문자, 숫자, 특수문자를 사용하세요.</div><!-- 사용불가, 위험인 경우 -->
                            
                            </td>
                        </tr>
                        <tr>
                            <th><label for="re-password">새 비밀번호 확인</label></th>
                            <td class="required">
                            	<!-- normal상태 int_pass_check / 비밀번호 확인완료 int_pass_check2  -->
                            	<input type="password" id="re-password" name="re-password" value="" class="int_pass_check">
                                <div class="msg1 error" style="display:block">필수 정보입니다.</div><!-- 입력하지 않은 경우 -->
                            	<div class="msg1" style="display:none">비밀번호가 일치하지 않습니다.</div><!--일 치하지 않는 경우 -->
                            </td>
                        </tr>
                    </tbody>
                </table>
            </fieldset>
        </div>
        <div class="footer"> <a href="#" class="btn btn-default btn-lg" onclick="javascript:pwdStep2('s');">다음</a> </div>
</script>

<script type="text" id="findPwdStep3">
<!-- 성공 -->
    <div class="pw-dscr">
    	<h2>비밀번호 재설정 결과</h2>
        <p>비밀번호가 재설정 되었습니다.<br>
			비밀번호 분실에 유의해 주시기 바랍니다.</p>
    </div>
    <div class="pw-result">
    	비밀번호가 재설정 되었습니다.
	</div>
    <div class="footer">
    	<a href="/portal/member/login.do" class="btn btn-default btn-lg">로그인</a>
    </div>
</script>

<div id="popup">
    <form>
        <div class="tab-group"> <a href="#" class="tab active" id="t1">아이디 찾기</a> <a href="#" class="tab" id="t2">비밀번호 재설정</a> </div>
        	<!-- tab1 -->
        	<div id="tab1">
		        
			</div>    
			
			<!-- tab2 -->
            <div id="tab2" >
		      
            </div>
    </form>
</div>

