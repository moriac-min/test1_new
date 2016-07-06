/**
 * @target 문자열 처리 관련 공통 함수
 */
var WebSquare_js = {}; // This is WebSquare JavaScript Marker. Do not remove this line.

/**
 * Null 및 공란이면 True 아니면 False 반환한다.
 * 
 * @param str_val : 문자열
 * @return true/false
 */
function gfn_isEmpty(str_val) {
    //str_val = gfn_trim(str_val);

    if (str_val == null || str_val.length == 0)
        return true;
    else
        return false;
};

/**
 * 입력받은 str 의 왼쪽을 num만큼 chr로 채운다.
 * 
 * @param str : 원본 문자열
 * @param num : 채울 자리수
 * @param chr : 채울 문자
 * @example gfn_str_lpad("1", 3, "0")
 * @return
 */
function gfn_lPad(str, num, chr) {
    if (!str || !chr || str.length >= num) {
        return str;
    }

    var max = num - str.length;
    for ( var i = 0; i < max; i++) {
        str = chr + str;
    }

    return str;
};

/**
 * 문자열 중간 잘라서 반환한다.
 * 
 * @param source : 원본 문자열
 * @param start : 자를 문자열 시작 위치
 * @param length : 자를 문자열 길이
 * @return 잘라낸 문자열
 */
function gfn_mid(source, start, length) {
    if (start < 0 || length < 0)
        return "";

    var endLength = -1;
    var sourceLength = source.toString().length;
    if (start + length > sourceLength)
        endLength = sourceLength;
    else
        endLength = start + length;
    return source.toString().substring(start, endLength);
};

/**
 * 문자열의 앞 뒤 공백을 제거한다.
 * 
 * @param str : 원본 문자열
 * @returns 공백제거된 문자열
 */
function gfn_trim(str) {
	if(str == null){
		str = "";
		return str;
	} else {
		return str.replace(/^\s\s*/, "").replace(/\s\s*$/, "");
	}
};

/**
 * 문자열의 앞 공백을 제거한다.
 * 
 * @param str : 원본문자열
 * @returns 공백제거된 문자열
 */
function gfn_lTrim(str) {
    return str.replace(/^\s+/, "");
};

/**
 * 문자열의 뒤 공백을 제거한다.
 * 
 * @param str : 원본문자열
 * @returns 공뱁제거된 문자열
 */
function gfn_rTrim(str) {
    return str.replace(/\s+$/, "");
};

/**
 * locIndex 뒤의 문자열을 특정 문자로 마스킹 처리한다.
 * 
 * @param value : 원본 문자열
 * @param locIndex : locIndex 뒤의 문자열을 마스킹 처리
 * @param maskingChar : 마스킹 문자 (*)
 * @return 마스킹 처리된 문자열
 * @example gfn_str_maskRStr("082-123456-02-123", 6, "*");
 */
function gfn_maskRStr(value, locIndex, maskingChar) {
    var retValue = "";
    var idx = 0;
    for ( var i = 0; i < value.length; i++) {
        var oneChar = value.charAt(i);
        if (oneChar == "-") {
            retValue += oneChar;
        } else {
            idx++;
            retValue = (idx > locIndex) ? retValue + maskingChar : retValue + oneChar;
        }
    }
    return retValue;
};

/**
 * 우편번호의 "-"가 없는 경우 "-"를 추가하여 표시한다.
 * 
 * @param value : 우편번호
 * @return 123-456
 * @example gfn_str_maskPostFormat("123456");
 */
function gfn_maskPostFormat(value) {

    if (typeof value == "number") {
        value = value + "";
    }
    var pos = -1;

    // 1. test pos value
    pos = value.indexOf("-");
    if (pos > -1 && (pos != 3 || value.length <= 4)) {
        value = value.slice(0, pos) + value.slice(pos + 1, value.length);
    }
    // 2. add "-"
    pos = value.indexOf("-");
    if (pos == -1 && value.length >= 4) {
        value = value.slice(0, 3) + "-" + value.slice(3, value.length);
    }
    // 3. check max length
    if (value.length > 7) {
        value = value.slice(0, 7);
    }
    return value;
};

/**
 * 주민등록번호에 "-"가 없는 경우 "-"를 추가한다.
 * 
 * @param value : 주민등록번호
 * @return 990101-2123456
 * @example gfn_str_maskSSNFormat("9901012123456");
 */
function gfn_maskSSNFormat(value) {

    if (typeof value == "number") {
        value = value + "";
    }
    var pos = -1;

    // 1. test pos value
    pos = value.indexOf("-");
    if (pos > -1 && (pos != 6 || value.length <= 7)) {
        value = value.slice(0, pos) + value.slice(pos + 1, value.length);
    }
    // 2. add "-"
    pos = value.indexOf("-");
    if (pos == -1 && value.length >= 7) {
        value = value.slice(0, 6) + "-" + value.slice(6, value.length);
    }
    // 3. check max length
    if (value.length > 14) {
        value = value.slice(0, 14);
    }
    return value;
};

/**
 * 주민등록번호에 "-"가 없는 경우 "-"를 추가하며 뒤에 6자리를 *로 처리한다.
 * 
 * @param value : 주민등록번호
 * @return 990101-2******
 * @example gfn_str_maskSSNFormat2("9901012123456");
 */
function gfn_maskSSNFormatMasking(value) {

    if (typeof value == "number") {
        value = value + "";
    }
    if (value.indexOf("-") >= 0) {
        var pos = value.indexOf("-");
        retValue = value.substring(0, pos) + value.substring(pos + 1);
    } else {
        retValue = value;
    }
    if (retValue.length > 7) {
        retValue = retValue.substring(0, 6) + "-" + retValue.substring(6, 7) + "*******".substring(0, retValue.length - 7);
    } else if (retValue.length > 6) {
        retValue = retValue.substring(0, 6) + "-" + retValue.substring(6);
    }
    return retValue;
};

/**
 * 사업자번호의 "-"가 없는 경우 "-"를 추가하여 표시한다.
 * 
 * @param value : 사업자번호
 * @return 123-45-67890
 * @example gfn_str_maskCorpFormat("1234567890");
 */
function gfn_maskCorpFormat(value) {

    var sum = 0;
    var aBizID = new Array(10);
    var checkID = new Array("1", "3", "7", "1", "3", "7", "1", "3", "5");

    for ( var i = 0; i < 10; i++) {
        aBizID[i] = str.substring(i, i + 1);
    }
    for ( var i = 0; i < 9; i++) {
        sum += aBizID[i] * checkID[i];
    }
    sum = sum + parseInt((aBizID[8] * 5) / 10);
    temp = sum % 10;
    temp1 = 0;

    if (temp != 0) {
        temp1 = 10 - temp;
    } else {
        temp1 = 0;
    }
    if (temp1 != aBizID[9]) {
        return false;
    }
    return true;
};

/**
 * 주민번호, 사업자번호 체크하여 포맷에 맞게 "-" 추가한다.
 * 
 * @param value : 사업자번호
 * @return 123-45-67890(사업자번호), 123456-1234567(주민등록번호)
 * @example gfn_str_maskSSNCorpFormat("1234567890");
 */
function gfn_maskSSNCorpFormat(value) {

    if (typeof value == "number") {
        value = value + "";
    }

    // 1. test pos value
    var pos = value.indexOf("-");
    var lastPos = value.lastIndexOf("-");
    if (lastPos == 6 && value.length <= 7) {
        value = value.slice(0, lastPos) + value.slice(lastPos + 1, value.length);
    }
    if (lastPos == 3 && value.length <= 4) {
        value = value.slice(0, lastPos) + value.slice(lastPos + 1, value.length);
    }
    // 2. add "-"
    pos = value.indexOf("-");
    if (pos == -1 && value.length >= 4) {
        value = value.slice(0, 3) + "-" + value.slice(3, value.length);
    }
    pos = value.indexOf("-");
    var lastPos = value.lastIndexOf("-");
    if (pos == 3 && value.length >= 7 && lastPos == pos) {
        value = value.slice(0, 6) + "-" + value.slice(6, value.length);
    }

    var sregExp = /-/g;

    // 3. check max length
    if (value.length > 12) {
        value = value.replace(sregExp, "");
        value = value.slice(0, 6) + "-" + value.slice(6, value.length);
    }
    if (value.length > 14) {
        value = value.slice(0, 14);
    }
    return value;
};

/**
 * 전화번호의 "-"가 없는 경우 "-"를 추가하여 표시한다.
 * 
 * @param value : 전화번호
 * @return 02-2663-1234
 * @example gfn_str_maskTelFormat("0226631234");
 */
function gfn_maskTelFormat(value) {

    if (typeof value == "number") {
        value = value + "";
    }

    var delimeter1 = "-";
    var delimeter2 = "-";

    var firstDelimeterPos = 3;
    var maxLength = 11 + delimeter1.length + delimeter2.length;

    if (value.indexOf("02") == 0) {
        firstDelimeterPos -= 1;
        maxLength -= 1;
    }

    // limit max length
    if (value.length > maxLength) {
        value = value.substr(0, maxLength);
    }

    // remove delimeter
    var regExp = new RegExp("[0-9]*", 'g');
    var result = (value + "").match(regExp);
    value = result.join("");

    // 1st delimeter
    if (value.length > firstDelimeterPos) {
        value = value.substr(0, firstDelimeterPos) + delimeter1 + value.substr(firstDelimeterPos, value.length);
    }
    // 2nd delimeter
    if (value.length > firstDelimeterPos + delimeter1.length + 4) {
        value = value.substr(0, value.length - 4) + delimeter2 + value.substr(value.length - 4, value.length);
    }
    return value;
};

/**
 * 문자열의 Byte를 계산한다.
 * 
 * @param content : 텍스트
 * @param outObj : 총 Byte가 표시될 Object (생략가능)
 * @example gfn_str_getByteLength(obj.getValue()); gfn_str_getByteLength(obj.getValue(), obj1);
 */
function gfn_getByteLength(content, outObj) {
    var tmpStr;
    var temp = 0;
    var onechar;
    var tcount = 0;
    var obj = outObj;
    if(!gfn_isEmpty(content)){
    	tcount = $w.getStringByteSize( content );
    }
    
    if (typeof outObj != 'undefined' && outObj != null) {
    	obj.setValue(tcount);
    }
    
    return tcount;
//    tmpStr = new String(content);
//    temp = tmpStr.toString().length;
//    for ( var k = 0; k < temp; k++) {
//        onechar = tmpStr.toString().charAt(k);
//        if (escape(onechar) == '%0D') {
//        } else if (escape(onechar).length > 4) {
//            tcount += 2;
//        } else {
//            tcount++;
//        }
//    }
//    if (typeof outObj != 'undefined' && outObj != null) {
//        obj.setValue(tcount);
//    }
};

/**
 * 문자열의 replace 작업을 처리한다.
 * 
 * @param str : 원문
 * @param orgStr : 검색할 문자
 * @param repStr : 치환할 문자
 * @example gfn_str_replaceAll(obj.getValue(), "/", "");
 */
function gfn_replaceAll(str, orgStr, repStr) {
    return str.split(orgStr).join(repStr);
};

/**
 * 문자열 영단어 여부 체크
 * 
 * @description 입력받은 문자열이 모두 영단어이면 true, 아니면 false를 리턴한다
 * @param word : 문자열
 * @return 영단어이면 true, 아니면 false
 * @example gfn_str_isEnglish("abcdefg");
 */
function gfn_isEnglish(word) {

    var c;
    if (gfn_trim(word).length == 0) {
        return false;
    }

    for ( var i = 0; i < word.length; i++) {
        c = word.toLowerCase().charAt(i);
        if (c < 'a' || c > 'z') {
            if ((c == " ") || (c == ".") || (c == "-")) {
                continue;
            }

            return false;
        }
    }
    return true;
};

/**
 * 입력받은 문자열이 모두 영문 또는 숫자로 되어 있으면 true, 아니면 false를 리턴한다.
 * 
 * @param word : 문자열
 * @return 영문or숫자이면 true, 아니면 false
 * @example gfn_str_hasNumOrLetter("abc123de4fg");
 */
function gfn_hasNumOrLetter(word) {

    var c;
    for ( var i = 0; i < word.length; i++) {
        c = word.toLowerCase().charAt(i);

        if ((c < 'a' || c > 'z') && (c < '0' || c > '9')) {
            return false;
        }

    }
    return true;
};

/**
 * 입력받은 문자열에 한글이 포함되어 있으면 true, 아니면 false를 리턴한다.
 * 
 * @param word : 문자열
 * @return 한글이면 true, 아니면 false
 * @example gfn_isKoreanWord("abcd무궁화");
 */
function gfn_isKoreanWord(word) {

    var c;
    for ( var i = 0; i < word.length; i++) {
        c = word.charAt(i);
        if (gfn_isKorean(c)) {
            return true;
        }
    }
    return false;
};

/**
 * 입력받은 문자열이 한글이면 true, 아니면 false를 리턴한다.
 * 
 * @param str : 문자열
 * @return 한글이 포함되어 있으면 true, 아니면 false
 * @example gfn_isKorean("무궁화꽃이");
 */
function gfn_isKorean(str) {

    if (str != null && str.length > 0) {
        var locale = 0;
        for ( var i = 0; i < str.length; i++) {
            locale = gfn_str_getLocale(str.charAt(i));
        }
        if ((locale & ~0x3) == 0) {
            return true;
        }
    }
    return false;
};

/**
 * 문자(char)의 유형을 리턴한다.
 * 
 * @param str : 문자
 * @return 한글음절(1), 한글자모(2), 숫자(4), 특수문자(8), 영문대(16), 영문소(32), 기타(48)
 * @example gfn_str_getLocale(str);
 */
function gfn_getLocale(str) {

    var locale = 0;
    if (str.length > 0) {
        var charCode = str.charCodeAt(0);

        if (charCode >= 0XAC00 && charCode <= 0XD7A3) { // 한글음절.[ 44032 ~ 55203 ]
            locale = 0X1; // 1
        } else if ((charCode >= 0X1100 && charCode <= 0X11F9) || (charCode >= 0X3131 && charCode <= 0X318E)) { // 한글자모.[ 4352 ~ 4601 ]
            locale = 0X2; // 2
        } else if (charCode >= 0X30 && charCode <= 0X39) { // 숫자.[ 48 ~ 57 ]
            locale = 0X4; // 4
        } else if ((charCode >= 0X20 && charCode <= 0X2F) || (charCode >= 0X3A && charCode <= 0X40) || (charCode >= 0X5B && charCode <= 0X60)
                || (charCode >= 0X7B && charCode <= 0X7E)) { // 특수문자
            locale = 0X8; // 8
        } else if (charCode >= 0X41 && charCode <= 0X5A) { // 영문 대.[ 65 ~ 90 ]
            locale = 0X10; // 16
        } else if (charCode >= 0X61 && charCode <= 0X7A) { // 영문 소.[ 97 ~ 122 ]
            locale = 0X20; // 32
        } else { // 기타
            locale = 0X30; // 48
        }
    }
    return locale;
};

/**
 * 특수 문자가 포함된 경우 true 아니면 false를 리턴한다.
 * 
 * @param word : 문자열
 * @return 특수 문자가 포함된 경우 true 아니면 false
 * @example gfn_checkSpecialChar("abcd##무궁화");
 */
function gfn_checkSpecialChar(str) {
    var m_Sp = /[$\\@\\\#%\^\&\*\(\)\[\]\+\_\{\}\`\~\=\|]/;
    var m_char;

    for ( var i = 1; i <= str.length; i++) {
        m_char = str.charAt((i) - 1);

        if (m_char.search(m_Sp) != -1) {
            return true;
        }
    }
    return false;
};

/**
 * 문자열을 입력 byte 만큼만 출력하고 말줄임 한다.
 * 
 * @param str : 문자열
 * @param limit : 가져올 byte길이
 * @return limit 길이 만큼만의 문자열에 말줄임 처리
 * @example var strResult = gfn_str_cutByteStr("abcdefghijklmn", 5);
 */
function gfn_wcutByteStr(str, limit) {

    var tmpStr = str;
    var byte_count = 0;
    var len = str.length;
    var dot = "";

    for ( var i = 0; i < len; i++) {
        byte_count += gfn_chrByte(str.charAt(i));
        if (byte_count == limit - 1) {
            if (gfn_chrByte(str.charAt(i + 1)) == 2) {
                tmpStr = str.substring(0, i + 1);
                dot = "...";
            } else {
                if (i + 2 != len)
                    dot = "...";
                tmpStr = str.substring(0, i + 2);
            }
            break;
        } else if (byte_count == limit) {
            if (i + 1 != len)
                dot = "...";
            tmpStr = str.substring(0, i + 1);
            break;
        }
    }
    return tmpStr + dot;
};

/**
 * 바이트 수를 반환한다.
 * @param chr 문자
 * @returns {Number}
 */
function gfn_chrByte(chr) {
//    if (escape(chr).length > 4)
//        return 2;
//    else
//        return 1;
    
    return $w.getStringByteSize( chr );
};

/**
 * 첫번째 문자를 대문자로 변환해서 반환한다.
 * @param str
 * @returns
 */
function gfn_firstUpperCase(str) {
    return str.substring(0, 1).toUpperCase() + str.substring(1);
};

/**
 * 첫번째 문자를 소문자로 변환해서 반환한다.
 * @param str
 * @returns
 */
function gfn_firstLowerCase(str) {
    return str.substring(0, 1).toLowerCase() + str.substring(1);
};

/**
 * XML, JSON Object 를 serialize/stringify 한다.
 * @param <Object> Object
 * @returns serialize/stringify String
 */
function gfn_serialize(object) {
    if (typeof object == 'string') {
        return object;
    } else if (gfn_json_isJSON(object)){
        return JSON.stringify(object);
    } else if (gfn_xml_isXmlCoc(object)) {
        return WebSquare.xml.serialize(object);
    } else {
        return object;
    }
};

/* ==========================================================================================
 * 해당 프로젝트에서 새로 만든 메소드들을 정의한다.
 * ========================================================================================== */

//문자치환 replace
if (typeof String.prototype.replaceAll == "undefined") {
    String.prototype.replaceAll = function(str1, str2) {
        var tmpStr = "";

        if (this.trim() != "" && str1 != str2) {
            tmpStr = this.trim();

            while (tmpStr.indexOf(str1) > -1) {
                tmpStr = tmpStr.replace(str1, str2);
            }
        }

        return  tmpStr;
    }
}

/**
 * 수치문자열인지 판단
 * word: 수치문자
 * perm: 마이너스(-), 콤마(,), 피리어드(.) 허용 여부
 * ex1) gfn_isNumeric("245")            => true
 * ex2) gfn_isNumeric("245.23")         => false
 * ex3) gfn_isNumeric("-245.23", true)  => true
 */
function gfn_isNumeric(word, perm){
    var c, bPerm = perm;

    if (word.length == 0)  return  false;
    if (typeof bPerm == "undefined")  bPerm = false;

    for (var i=0; i<word.length; i++) {
        c = word.charAt(i);
        if (c >= '0' && c <= '9') {
            ;
        } else if (c == '-' || c == ',' || c == '.') {
            if (!bPerm)  return  false;
        } else {
            return  false;
        }
    }

    return  true;
}

/** 
 * 주민등록번호 검사
 * regNo : 13자리 또는 '-' 포함 14자리 주민등록번호
 */
function gfn_isReg(regNo){
    var sReg = regNo.trim();
    var nSum = 0;
    var nChk = 2;

    sReg = gfn_strReplace(sReg, "-", "");

    if (!gfn_isNumeric(sReg)) {
        return  false;
    }
    if (gfn_getStringLen(sReg) != 13) {
        return  false;
    }

    for (var i=0; i<sReg.length-1; i++) {
        var c = sReg.charAt(i);

        nSum += (parseInt(c, 10) * nChk);
        nChk = (nChk == 9) ? 2 : (nChk + 1);
    }

    if (parseInt(sReg.substring(12, 13), 10) != ((11 - (nSum%11)) % 10)) {
        return  false;
    }

    return  true;
}

/**
 * 이메일주소검사
 */
function gfn_isMailStr(str){
    if (typeof str != "undefined" && str != "") {
        var format = /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;

        if (format.test(str)) {
            return  true;
        } else {
            return  false;
        }
    }
    return  true;
}


/**
 * 사업자 번호 검사
 */
function gfn_isBizNo(bizNo){
    var sum = 0;
    var arrBizNo = new Array(10);
    var arrChkNo = new Array(1, 3, 7, 1, 3, 7, 1, 3, 5);

    for (var i=0; i<10; i++) {
        arrBizNo[i] = parseInt(bizNo.substring(i, i+1), 10);
    }

    for (var i=0; i<9; i++) {
        sum += arrBizNo[i] * arrChkNo[i];
    }
    sum += parseInt((arrBizNo[8]*5) / 10, 10);

    var sidliy = sum % 10;
    var sidchk = 0;

    if (sidliy != 0) {
        sidchk = 10 - sidliy;
    } else {
        sidchk = 0;
    }
    if (sidchk != arrBizNo[9]) {
        return  false;
    }
    return  true;
}

/**
 * 법인등록번호 검사
 */
function gfn_isCorpID(str){
    var  checkID = new Array(1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2);
    var  sCorpNo = str;
    var  nV1 = 0;
    var  nV2 = 0;
    var  nV3 = 0;

    for (var i=0; i<12; i++) {
        nV1 = parseInt(sCorpNo.substring(i, i+1), 10) * checkID[i];

        if (nV1 >= 10) {
            nV2 += nV1 % 10;
        } else {
            nV2 += nV1;
        }
    }

    nV3 = nV2 % 10;
    if (nV3 > 0) {
        nV3 = 10 - nV3;
    } else {
        nV3 = 0;
    }
    if (sCorpNo.substring(12, 13) != nV3) {
        return  false;
    }

    return  true;
}

//문자열중 숫자만 반환
function gfn_getNumberOnly(num){
    var ret = '';
    for (var i=0; i<num.length; i++) {
        var c = num.charAt(i);
        if (c >= '0' && c <= '9')  ret += c;
    }
    return  ret;
}

/**
 * 전화번호 검사
 */
function gfn_isTelNo(no1, no2, no3)
{
    if (typeof no2 == "undefined" || no2 == null) {  // 전화번호가 1개
        var no = gfn_getNumberOnly(no1);

        if (!gfn_isNumeric(no1))  return  false;
        if (no.length == 0)  return  true;
        if (no.length < 9)  return  false;

        return  true;
    } else {
        var sTelNo1 = no1;
        var sTelNo2 = no2;
        var sTelNo3 = no3;

        if (sTelNo1.length == 0 && sTelNo2.length == 0 && sTelNo2.length == 0)  return  true;

        if (sTelNo1.length < 2) {
            return  false;
        } else if (sTelNo2.length < 3) {
            return  false;
        } else if (sTelNo3.length < 4) {
            return  false;
        }
        if (sTelNo1 == "011" || sTelNo1 == "010" || sTelNo1 == "016" || sTelNo1 == "017" || sTelNo1 == "018" || sTelNo1 == "019" ||
            sTelNo1 == "02"  || sTelNo1 == "031" || sTelNo1 == "032" || sTelNo1 == "033" ||
            sTelNo1 == "041" || sTelNo1 == "042" || sTelNo1 == "043" ||
            sTelNo1 == "051" || sTelNo1 == "052" || sTelNo1 == "053" || sTelNo1 == "054" || sTelNo1 == "055" ||
            sTelNo1 == "061" || sTelNo1 == "062" || sTelNo1 == "063" || sTelNo1 == "064" ||
            sTelNo1 == "070") {
            if (!gfn_isNumeric(sTelNo1)) {
                return  false;
            }
            if (!gfn_isNumeric(sTelNo2)) {
                return  false;
            }
            if (!gfn_isNumeric(sTelNo3)) {
                return  false;
            }
            return  true;
        } else {
            return  false;
        }
    }
}

/**
 * 전화번호에 '-'를 추가
 */
function gfn_maskTelNo(telNo)
{
    var no = gfn_getNumberOnly(telNo);
    var areaNo;
    var no2, no3;

    if (no.length < 9) {
        return  telNo;
    }
    if (!gfn_isTelNo(no)) {
        return  telNo;
    }

    if (no.charAt(0) == '0' && no.charAt(1) == '2') {
        areaNo = '02';
        if (no.length - areaNo.length > 7) {
            no2 = no.substr(2, 4);
            no3 = no.substr(6, 4);
        } else {
            no2 = no.substr(2, 3);
            no3 = no.substr(5, 4);
        }
    } else {
        areaNo = no.substr(0, 3);
        if (no.length - areaNo.length > 7) {
            no2 = no.substr(3, 4);
            no3 = no.substr(7, 4);
        } else {
            no2 = no.substr(3, 3);
            no3 = no.substr(6, 4);
        }
    }

    return (areaNo + '-' + no2 + '-' + no3);
}

/**
 * 문자열 왼쪽에 일정길이(maxLen) 만큼 '0'으로 채우기
 * str : 문자열
 * maxLen : 0 으로 채울 최대 길이
 * ex) gfn_fillZero("24", 4) => 0024
 */
function gfn_fillZero(str, maxLen)
{
    var len = str;
    var zero = "";

    if (typeof str == 'number')  len = '' + str;

    if (len.length < maxLen) {
        for (var i=len.length; i<maxLen; i++) {
            zero += "0";
        }
    }

    return  (zero + '' + str);
}

/**
 * 소수점 자리 수를 체크한다.
 * 
 * @param obj : Component id
 * @param decLen : 소수 이하 자리수
 * @return 컴포넌트에 데이터 값 리턴
 * @example gfn_chkeckDecimalFormat( in_Num, 2 ) <- 소수 2째 자리
 */
function gfn_chkeckDecimalFormat(obj, decLen) {

    var data = obj.getValue();

    if (data.length < 1) {
        return;
    }

    var decIdx = data.indexOf('.');

    if (decIdx > -1) {
        var dataIdx = data.length - 1;
        var len = dataIdx - decIdx;

        if (len > decLen) {
            gfn_alert("소수 " + decLen + "자리까지 입력 가능합니다.");
            obj.setValue(data.substring(0, dataIdx));
            obj.focus();
        }
    }
};

/**
 * 입력받은 문자열이 숫자이면 true 아니면 false를 리턴한다.
 * 
 * @param word : 문자열
 * @return 숫자이면 true, 그외는 false
 * @example gfn_num_isNumber("123456");
 */
function gfn_isNumber(word) {

    var c;
    for ( var i = 0; i < word.length; i++) {
        c = word.charAt(i);
        if ((c < '0' || c > '9') && c != ',') {
            return false;
        }
    }
    return true;
};

//수치문자열을 3자리 단위마다 콤마붙임
function gfn_setNumberComma(str){
    if (typeof str == "undefined" || str == null)  return  "";
    var ret = gfn_getNumberWithOutComma(str.trim());
    return  WebSquare.util.setNumber(str);
}

//수치문자열을 콤마제거후 반환
function gfn_getNumberWithOutComma(str){
    return  WebSquare.util.getNumber(str.trim());
}

// 콤마만들기
function gfn_makeComma(obj){
    var obj_value = '' + obj;
    var rxSplit = new RegExp('([0-9])([0-9][0-9][0-9][,.])');
    var arrNumber;

    obj_value = gfn_replaceAll(obj_value, ",", "");
    arrNumber = obj_value.split('.');
    arrNumber[0] += '.';
    do {
        arrNumber[0] = arrNumber[0].replace(rxSplit, '$1,$2');
    }
    while (rxSplit.test(arrNumber[0]));

    if (arrNumber.length > 1) {
        return  arrNumber.join('');
    } else {
        return  arrNumber[0].split('.')[0];
    }
}




