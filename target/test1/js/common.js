var contextPath = "";
var menuTree;

//코드 팝업
function fn_codeList(num){
	//window.open(contextPath+"/Pop/codePop.do?num="+num, "codePopup","top=100, left="+200+", width="+950+", height="+450+", toolbar=0, directories=0, status=0, menubar=0, scrollbars=0, resizable=0");
}

//주소 팝업(리턴 받을 우편번호ID, 주소ID)
function fn_juSoPopup(reZip, reAddr){
	//window.open(contextPath+"/sbmsPop/jusoPop.do?reZip="+reZip+"&reAddr="+reAddr, "juSoPopup", "top=100, left="+200+", width="+920+", height="+700+", toolbar=0, directories=0, status=0, menubar=0, scrollbars=0, resizable=0");
}

//공백일 경우
function fn_empty(id, content){
	fn_replaceSpace(id);
	if($(id).val() == "" || typeof($(id).val()) == "undefined"){//공백여부
		$(id).focus();
		alert(content);
		return false;
	}else{
		return true;
	}
}

//앞뒤공백제거
function fn_replaceSpace(id){
	if($(id).length > 0){
		$(id).val($(id).val().replace(/(^\s*)|(\s*$)/g,""));//앞뒤 공백제거
	}
}

//특수문자제거
function fn_replaceSpecialChar(id){
	if($(id).length > 0){
		$(id).val($(id).val().replace(/[~#$^&*\=+|:;?"<>']/gi,""));		//특수문자제거
		$(id).val($(id).val().replace("\\",""));						//원표시 삭제
		$(id).val($(id).val().replace("replace",""));					//replace
		$(id).val($(id).val().replace("iframe",""));					//iframe
		$(id).val($(id).val().replace("script",""));					//script
	}
}

//앞뒤공백, 특수문자 동시제거
function fn_replace(id){
	//try{
	if($(id).val() != null && $(id).val() != ""){
		$(id).val($(id).val().replace(/(^\s*)|(\s*$)/g,""));			//앞뒤 공백제거
		$(id).val($(id).val().replace(/[~#$^&*=+|:;?"<>']/gi,""));		//특수문자제거
		$(id).val($(id).val().replace("replace",""));					//replace
		$(id).val($(id).val().replace("\\",""));						//원표시 삭제
		$(id).val($(id).val().replace("iframe",""));					//iframe
		$(id).val($(id).val().replace("script",""));					//script
	}
	//}catch(Exception){
		
	//}
}


//달력 정규식 체크
function fn_calendar(id, content){
//	var reg = /^(19[0-9][0-9]|20[0-2][0-9]|203[0-7])(0[1-9]|1[0-2])(0[1-9]|[12][0-9]|3[01])$/;
	var minYear = '1900';		//최소년도
	var maxYear = '2100';		//최대년도
	
	if(!fn_isDate($(id).val(), minYear, maxYear)){
		$(id).focus();
		alert(content);
	    return false;
	}else{
		return true;	
	}
}

//날짜 유효성 체크
function fn_isDate(dateStr, minYear, maxYear) {
	var reg = /^([0-9]{8})$/;		//숫자 8자리 체크
	
	if(reg.test(dateStr) == false){
		return false;
	}
	
	var year = Number(dateStr.substr(0, 4));
	var month = Number(dateStr.substr(4, 2));
	var day = Number(dateStr.substr(6, 2));
	
	if(year < minYear || year > maxYear){
		return false;
	}
	
	if(month < 1 || month > 12){
		return false;
	}
	
	if(day < 1 || day > 31){
		return false;
	}
	
	if((month == 4 || month == 6 || month == 9 || month == 11) && day == 31){
		return false;
	}
	
	if(month == 2){
		var isLeap = (year % 4 == 0 && (year % 100 != 0 || year % 400 == 0));
		
		if(day > 29 || (day == 29 && !isLeap)){
			return false;
		}
	}
	
	return true;
}

//날짜 유효성 체크(주민등록번호 형식)
function fn_isDateSix(dateStr, minYear, maxYear) {
	var reg = /^([0-9]{6})$/;		//숫자 8자리 체크
	
	if(reg.test(dateStr) == false){
		return false;
	}
	
	var year = Number(dateStr.substr(0, 2));
	var month = Number(dateStr.substr(2, 2));
	var day = Number(dateStr.substr(4, 2));
	
	if(year < minYear || year > maxYear){
		return false;
	}
	
	if(month < 1 || month > 12){
		return false;
	}
	
	if(day < 1 || day > 31){
		return false;
	}
	
	if((month == 4 || month == 6 || month == 9 || month == 11) && day == 31){
		return false;
	}
	
	if(month == 2){
		var isLeap = (year % 4 == 0 && (year % 100 != 0 || year % 400 == 0));
		
		if(day > 29 || (day == 29 && !isLeap)){
			return false;
		}
	}
	
	return true;
}

//달력 정규식 체크(월)
function fn_calendar_yyyymm(id, content){
	var reg = /^[12][0-9]{3}(0[1-9]|1[0-2])$/;
	
	if(reg.test($(id).val()) == false) {
		$(id).focus();
		alert(content);
	    return false;
	}else{
		return true;	
	}
}


//한글로만(띄어쓰기 불가능)
function fn_hangl(id, content){
	var reg = /^[ㄱ-ㅎ|ㅏ-ㅣ|가-힣+]*$/;
	if(reg.test($(id).val()) == false) {
		$(id).focus();
		alert(content);
		return false;
	}else{
		return true;
	}
}

//한글로만(띄어쓰기 가능)
function fn_hanglSpace(id, content){
	var reg = /^[ㄱ-ㅎ|ㅏ-ㅣ|가-힣+]*$/;
	if(reg.test($(id).val().replace(/(\s*)/g,"")) == false) {
		$(id).focus();
		alert(content);
		return false;
	}else{
		return true;
	}
}

//한글제외(띄어쓰기 가능)
function fn_hanglNotSpace(id, content){
	var reg = /^[^(ㄱ-ㅎ|ㅏ-ㅣ|가-힣)+]*$/;
	if(reg.test($(id).val().replace(/(\s*)/g,"")) == false) {
		$(id).focus();
		alert(content);
		return false;
	}else{
		return true;
	}
}

//숫자로만
function fn_num(id, content){
	var reg = /^[0-9+]*$/;
	if(reg.test($(id).val()) == false) {
		$(id).focus();
		alert(content);
		return false;
	}else{
		return true;
	}
}

//금액만
function fn_cash(id, content){
	var reg = /^[1-9][0-9+]*$/;
	if(reg.test($(id).val()) == false) {
		$(id).focus();
		alert(content);
		return false;
	}else{
		return true;
	}
}

//금액만(0포함)
function fn_cash_zero(id, content){
	var reg = /^[0-9][0-9+]*$/;
	if(reg.test($(id).val()) == false) {
		$(id).focus();
		alert(content);
		return false;
	}else{
		return true;
	}
}

//퍼센트(소수점 두자리)
function fn_percent(id, content){
	var reg = /(^(100)(\.[0]{0,2})?$)|(^([0-9]{1,2})(\.[0-9]{0,2})?$)/;
	if(reg.test($(id).val()) == false) {
		$(id).focus();
		alert(content);
		return false;
	}else{
		return true;
	}
}

//이메일 정규식
function fn_email(id, content){
	var reg = /^([0-9a-zA-Z_-]+)@([0-9a-zA-Z_-]+)(\.[0-9a-zA-Z_-]+){1,2}$/;
	if(reg.test($(id).val()) == false) {
		$(id).focus();
		alert(content);
		return false;
	}else{
		return true;
	}
}

//전화번호&핸드폰 정규식
function fn_phonNumer(id, content){
	var reg = /^(01[016789]{1}|02|0[3-9]{1}[0-9]{1})-[0-9]{3,4}-[0-9]{4}$/;
	if(reg.test($(id).val()) == false) {
		$(id).focus();
		alert(content);
		return false;
	}else{
		return true;
	}
}

//우편번호
function fn_zipCode(id, content){
	var reg = /^[1-9][0-9]{2}-[0-9]{3}$/;
	if(reg.test($(id).val()) == false) {
		$(id).focus();
		alert(content);
		return false;
	}else{
		return true;
	}
}

//영어로만(뛰어쓰기 불가능)
function fn_eng(id, content){
	var reg = /^[A-Za-z+]*$/;
	if(reg.test($(id).val()) == false) {
		$(id).focus();
		alert(content);
		return false;
	}else{
		return true;
	}
}

//영어로만(뛰어쓰기 가능)
function fn_engSpace(id, content){
	var reg = /^[A-Za-z+]*$/;
	if(reg.test($(id).val().replace(/(\s*)/g,"")) == false) {
		$(id).focus();
		alert(content);
		return false;
	}else{
		return true;
	}
}

//영어와 숫자로만
function fn_engnum(id, content){
	var reg = /^[A-Za-z0-9+]*$/;
	if(reg.test($(id).val().replace(/(\s*)/g,"")) == false) {
		$(id).focus();
		alert(content);
		return false;
	}else{
		return true;
	}
	
}

//문자열 제한
//예제:onKeyUp=SUchkLengthObj('10', this) 10자이내로 name의 값을 가져와서 정의한다.  
function SUchkLengthObj(maxLen, obj, msg) {
	var str;
	var cntHan;
	
	if(obj == '[object HTMLInputElement]' || obj == '[object]' || '[object HTMLTextAreaElement]') {
		str = obj.value;
	} else {
		str = obj;
	}
	
	cntHan = (escape(str) + "%u").match(/%u/g).length - 1;  //문자열내 한글자의 길이

	// match : 해당하는 값을 포함하는 배열을 리턴
	// /g : 전역으로 찾기
	// +"%u" : match함수의 특성상 포함하지 않으면 null을 리턴하므로 "%u"를 더해주고 length-1을 한다

	if(maxLen < (str.length + cntHan)){

		if(msg != '' && typeof(msg) != 'undefined'){
			alert(msg);
		}else{
			alert("총 영문 "+ maxLen+"자, 한글 " + parseInt(maxLen/2) + "자 까지 보내실수 있습니다.");
		}
		

		// 입력한 값을 maxLen 길이로 자르기
		while(maxLen < str.length + cntHan){

			str = str.substring(0, str.length-1);
			cntHan = (escape(str)+"%u").match(/%u/g).length-1;
		}
		obj.value = str;
		obj.focus();
	}
}

function fn_ckeckSize(id, content){
	var size = 0;
	var str = $(id).val();
	
	for (var i = 0; i < str.length; i++) {
	    if (escape(str.charAt(i)).length == 6) {
	    	size++;
	    }
	    size++;
	}
	return size;
}


function MM_swapImage() { //v3.0
  var i,j=0,x,a=MM_swapImage.arguments; document.MM_sr=new Array; for(i=0;i<(a.length-2);i+=3)
   if ((x=MM_findObj(a[i]))!=null){document.MM_sr[j++]=x; if(!x.oSrc) x.oSrc=x.src; x.src=a[i+2];}
}

function MM_findObj(n, d) { //v4.01
  var p,i,x;  if(!d) d=document; if((p=n.indexOf("?"))>0&&parent.frames.length) {
    d=parent.frames[n.substring(p+1)].document; n=n.substring(0,p);}
  if(!(x=d[n])&&d.all) x=d.all[n]; for (i=0;!x&&i<d.forms.length;i++) x=d.forms[i][n];
  for(i=0;!x&&d.layers&&i<d.layers.length;i++) x=MM_findObj(n,d.layers[i].document);
  if(!x && d.getElementById) x=d.getElementById(n); return x;
}

function MM_swapImgRestore() { //v3.0
  var i,x,a=document.MM_sr;
  for(i=0;a&&i<a.length&&(x=a[i])&&x.oSrc;i++){
	  x.src=x.oSrc;
  }
}

function MM_preloadImages() { //v3.0
  var d=document; if(d.images){ if(!d.MM_p) d.MM_p=new Array();
    var i,j=d.MM_p.length,a=MM_preloadImages.arguments; for(i=0; i<a.length; i++)
    if (a[i].indexOf("#")!=0){ d.MM_p[j]=new Image; d.MM_p[j++].src=a[i];}}
}

//숫자를 3자리 단위로 콤마를 찍어준다.
function fn_comma(id, value) {
	//만약 값이 0 이라면 기존에 추가한 컬럼의 값을 합계로 더한다.
	if(null!=value){
		$(id).val(abcutil.addComma(value));
	}
}

//콤마 제거
function fn_replceComma(id, value) {
	if(null!=value){
		var reg = /^[0-9+]*$/;
		if(reg.test(String(value).replace(/,/g, '')) == true) {
			$(id).val(String(value).replace(/,/g, ''));
		}
	}
}


/**
 * 특정 날짜에서 이전,이후 날짜 구하기
 * @param baseDay : 오늘 날짜 '' 값, 특정일자 : YYYYMMDD 형식 날짜
 * @param dDay	  : +,- 일수
 * @return		  : YYYYMMDD 형식 날짜
 */
function fn_getPlusMinusDate(baseDay, dDay) {
	var date = "";
	if(baseDay != ''){
		date = new Date(baseDay);
	}else{
		date = new Date();
	}
    date.setDate(date.getDate()+dDay);
    var month = (date.getMonth()+1<10)?"0"+(date.getMonth()+1):date.getMonth()+1;
    var day = (date.getDate()<10)?"0"+date.getDate():date.getDate();
    var returnDay = date.getFullYear()+""+month+""+day;
    
    return returnDay;
}

/**
 * 기능 단추를 눌렀을 때 로딩 상태 표현
 * @param btn
 * @param disable
 */
function startLoading(btn, disable) {
	$(btn).append('<img src="/img/loadingSmall.gif" style="margin:-3px 0 0 4px"/>').css({cursor: 'wait'});
	
	if (disable)
		$(btn).attr('disabled', true);
	else {
		$(btn).unbind('click').attr('onclick', function() { return false; });
	}
}

/**
 * startLoading으로 처리한 상태 해제
 * @param btn
 */
function endLoading(btn) {
	$(btn).css({cursor:'', color:''}).attr('disabled', false).find('img').remove();
}

/**
 * 기능 단추를 눌렀을 때 화며 전체에 로딩 상태 표현
 */
function sLoading() {
	
	var d = document;
	
	var height = d.body.scrollHeight > d.documentElement.scrollHeight ? d.body.scrollHeight : d.documentElement.scrollHeight;
	//var width = d.body.scrollWidth > d.documentElement.scrollWidth ? d.body.scrollWidth : d.documentElement.scrollWidth;
	$('#divWait').css("height", height);
	$('#divWait').css("display", "block");
	
	var divWait = document.getElementById("divWait");
	$('#waitImg').css("margin-top", (divWait.offsetHeight/2 - 43*2));
//	$('#waitImg').css("padding-right", "20%");
	
}

/**
 * sLoading으로 처리한 상태 해제
 */
function sClose() {
	$('#divWait').css("display", "none");
}

/**
 * 로그인이 필요한 팝업창 열기
 * @param a
 * @param width
 * @param height
 * @returns {Boolean}
 */
function openMembershipLink(a, width, height) {
	var href = a.href;
	
	$.post('/portal/member/memberToken.do', function(data) {
		if (data == null)
			location.href = '로그인 페이지'; // TODO 로그인 페이지 주소로 수정!
		
		var prefix = href.indexOf('?') > 0 ? '&' : '?';
		var w = window.open(href + prefix + '_memberId=' + data.memberId + '&_token=' + data.token,
				'width=' + width + ',height=' + height + ',resizable=yes');
		if (w == null) {
			alert('팝업 차단을 해제하셔야 팝업 페이지를 열 수 있습니다.');
		}
	}, 'json');
	
	return false;
}

/**
 * 변수를 입력받아 정의되어 있지 않거나 null 이면 Html 공백문자를 리턴
 * @param val
 * @returns {String}
 */
function nvl(val){
	
	if(val == '' || val == 'undefined' || typeof val == 'undefined'){
		return '';
	}else{
		return val;
	}
}

/**
 * html ID와 data를 입력받아 해당 data에 맞게 html를 변경해준다.
 * @param id
 * @param data
 * @returns {String}
 */
function innerHtmlMaker(id, data){
 	var strReturn = $(id).html().replace(/\{(\w+)\}/g, function($0, $1) {
 		return String(data[$1]) || '';
 	});
 	
 	return strReturn;
}

/**
 * tag split
 */
function fn_tagSplit(string){
	
	var strspl = string.split(',');
	var rtnstr="";
	for(var i in strspl){
		if(i == 0){
			rtnstr += '<a href="#">'+strspl[i].trim()+'</a>'
		}else{
			rtnstr += ', <a href="#">'+strspl[i].trim()+'</a>'
		}
	}
	return rtnstr;
}
