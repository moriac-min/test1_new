<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<c:set var="contextPath" scope="request">${pageContext.request.contextPath}</c:set>
<link type="text/css" href="${contextPath}/css/style_minwon.css" rel="stylesheet">

<script type="text/javascript">
//alert("실명인증 서비스 장애로 실명인증이 안되는 경우가 발생하고 있습니다. \n현재 운영팀에서 복구중입니다. \n이용에 불편을드려 대단히 죄송합니다.");
function f_checkform(forms) {
	var ssn = forms.ssn.value;
	if( forms.sname.value == "" ) {
		alert(' 이름을 입력하세요');
		forms.sname.focus();
		return false;
	}
	if( forms.ssn.value == "" ) {
		alert(' 주민번호를 입력하세요');
		forms.ssn.focus();
		return false;
	}
	return true;
}
function loadfocus(){
	document.namecheckForm.sname.focus();
}
</script>
    <div class="inner-head">
        <h1>실명인증</h1>
    </div>
    <div class="inner-body">
        <div id="namecheck">
            <form action="/" method="post" name="namecheckForm" id="namecheckForm" onsubmit="return f_checkform(this);">
                <fieldset>
                    <legend>실명확인폼</legend>
                    <ul class="type">
                        <li> <label><input type="radio" checked="checked" value="1" name="jumin1" id="jumin1"> 주민등록번호</label> </li>
                        <li> <label><input type="radio" value="2" name="jumin1" id="jumin2"> 외국인번호</label> </li>
                    </ul>
                    <dl class="item">
                        <dt> <label for="sname">이름</label> </dt>
                        <dd> <input type="text" value="" size="15" id="sname" name="sname" onfocus="this.style.imeMode='active';"> </dd>
                        <dt> <label class="i_label" for="ssn">주민등록번호</label> </dt>
                        <dd> <input type="password" id="ssn" name="ssn" size="24" maxlength="13">
                            입력시 "-"를 제외</dd>
                    </dl>
                    <a href="" class="btn btn-default namecheck">실명인증</a>
                    <div class="emphasis">
                        <ul style="padding-left:15px;margin-bottom:0;">
                            <li>입력하신 이름과 주민번호는 본인확인기관을 통해 인증되며, <strong>별도로 저장되거나</strong> 다른용도로 사용되지 않습니다.</li>
                            <li><strong>『주민등록법』</strong>에 의해 타인의 주민등록번호를 부정 사용하는 자는 <strong>3년 이하의 징역 또는 1천만원이하</strong>의 벌금이 부과될 수 있습니다.<br>
                            관련법률 : 주민등록법 제37조(벌칙) 제10호</li>
                        </ul>
                    </div>
                </fieldset>
            </form>
        </div>
    </div>

