
/**
 * @target 날짜 관련 공통 함수
 */
var WebSquare_js = {}; // This is WebSquare JavaScript Marker. Do not remove
// this line.

var gv_arrDay = new Array (0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31);
var gv_arrWeekStr = [ "일", "월", "화", "수", "목", "금", "토" ];

var gv_yearFormater = "-";  // 일자 포맷터
var gv_TimeFormater = ":";  // 시간 포맷터


/**
 * 오늘 날짜(년월일시분초)를 YYYYMMDDHH24MISS 포맷의 문자열로 반환한다.
 * 
 * @return YYYYMMDDHH24MISS
 */
function gfn_getDate() {

    var today = new Date();
    var year = today.getFullYear();
    var month = (today.getMonth() + 1);
    var day = today.getDate();
    var hour = today.getHours();
    var min = today.getMinutes();
    var second = today.getSeconds();
    var millisecond = today.getMilliseconds();

    if (parseInt(month) < 10)
        month = "0" + month;
    if (parseInt(day) < 10)
        day = "0" + day;
    if (parseInt(hour) < 10)
        hour = "0" + hour;
    if (parseInt(min) < 10)
        min = "0" + min;
    if (parseInt(second) < 10)
        second = "0" + second;
    if (parseInt(millisecond) < 10) {
        millisecond = "00" + millisecond;
    } else {
        if (parseInt(millisecond) < 100)
            millisecond = "0" + millisecond;
    }

    return String(year) + String(month) + String(day) + String(hour) + String(min) + String(second);
};

/**
 * 날짜형 문자열을 받아 flag값 기준으로 년월일이 구분된 날짜형 문자열 변수로 반환한다.
 * 
 * @param pdate : 날짜
 * @param flag : 구분자(/, .)
 * @return 날짜형 변수
 * @example dateUtil.makeDateFormat("20120719", "/") ==> 2012/07/19
 */
function gfn_makeDateFormat(pdate, flag) {
    var yy = "", mm = "", dd = "", yymmdd;
    var ar;
    if (pdate.indexOf(".") > -1) { // yyyy.mm.dd
        ar = pdate.split(".");
        yy = ar[0];
        mm = ar[1];
        dd = ar[2];
        if (mm < 10)
            mm = "0" + mm;
        if (dd < 10)
            dd = "0" + dd;
    } else if (pdate.indexOf("-") > -1) { // yyyy-mm-dd
        ar = pdate.split("-");
        yy = ar[0];
        mm = ar[1];
        dd = ar[2];
        if (mm < 10)
            mm = "0" + mm;
        if (dd < 10)
            dd = "0" + dd;
    } else if (pdate.length == 8) {
        yy = pdate.substr(0, 4);
        mm = pdate.substr(4, 2);
        dd = pdate.substr(6, 2);
    }
    var p = "/";
    if ((typeof flag != "undefined" && flag != "" && flag != null)) {
        p = flag;
    }

    yymmdd = yy + p + mm + p + dd;
    // yymmdd = new Date(yymmdd);

    return yymmdd;
};

/**
 * 특정일자에 날짜를 더한다.
 * 
 * @param arg : 더할 날짜
 * @return YYYYMMDD
 */
function gfn_addDay(pYmd, offset) {

    var yyyy = pYmd.substr(0, 4);
    var mm = eval(pYmd.substr(4, 2) + "- 1");
    var dd = pYmd.substr(6, 2);

    var dt3 = new Date(yyyy, mm, eval(dd + '+' + offset));

    yyyy = dt3.getFullYear();

    mm = (dt3.getMonth() + 1) < 10 ? "0" + (dt3.getMonth() + 1) : (dt3.getMonth() + 1);
    dd = dt3.getDate() < 10 ? "0" + dt3.getDate() : dt3.getDate();

    return "" + yyyy + "" + mm + "" + dd;
};

/**
 * 오늘 일자에 날짜를 던한다.
 * 
 * @param arg : 더할 날짜
 * @return YYYYMMDD
 */
function gfn_addToDay(arg) {

    var sz_ymd;
    if (arg == "")
        arg = 0;

    var date = new Date();
    date.setFullYear(date.getFullYear());// y년을 더함
    date.setMonth(date.getMonth());// m월을 더함
    date.setDate(date.getDate() + arg);// d일을 더함

    sz_ymd = "" + date.getFullYear();

    if (date.getMonth() < 9) {
        sz_ymd += "0" + (date.getMonth() + 1);
    } else {
        sz_ymd += (date.getMonth() + 1);
    }
    if (date.getDate() < 10) {
        sz_ymd += "0" + date.getDate();
    } else {
        sz_ymd += "" + date.getDate();
    }
    return sz_ymd;
};

/**
 * 일자에 월을 더해서 반환한다.
 * 
 * @param date : 일자
 * @param add : 추가할 개월 수
 * @description 1.임의의 년월일(yyyyMMdd)에 원하는 월 수만큼 가감(+/-)한 결과의 년월일에 해당하는 yyyyMMdd 문자열을 리턴한다 2.임의의 년월(yyyyMM)에 원하는 월 수만큼 가감(+/-)한 결과의 년월에 해당하는 yyyyMM 문자열을 리턴한다
 * @return 날짜 문자열(yyyyMMdd)
 */
function gfn_addMonth(date, add) {
    // var add = "-1";
    var rtnGb = "1"; // 8자리

    // 6자리 입력 시 01 을 추가하여 8자리 날자로 처리한다.
    if (date.length == 6) {
        date = date + "01";
        rtnGb = "2";
    }

    var yyyy = date.substring(0, 4);
    var mm = date.substring(4, 6);
    var dd = date.substring(6, 8);

    mm = (mm * 1) + (add * 1);

    var cDate = new Date(yyyy, mm - 1, dd);
    var cYear = cDate.getFullYear();
    var cMonth = cDate.getMonth() + 1;

    if ((cMonth + "").length < 2) {
        cMonth = "0" + cMonth;
    }

    var cDay = cDate.getDate();

    if ((cDay + "").length < 2) {
        cDay = "0" + cDay;
    }

    var ynDay = "";

    if (rtnGb == "1") {
        ynDay = cYear + "" + cMonth + "" + cDay;
    } else {
        ynDay = cYear + "" + cMonth;
    }
    return ynDay;
};

/**
 * 오늘날짜에서 년/월/일을 자유롭게 더하고 뺀 결과를 문자열로 반환한다.
 * 
 * @param year, month, day : 가감할년수, 가감할월수, 가감할일수
 * @return YYYYMMDD
 */
function gfn_calcToday(year, month, day) {
    var sz_ymd;
    if (year == "")
        year = 0;
    if (month == "")
        month = 0;
    if (day == "")
        day = 0;

    var date = new Date();
    date.setFullYear(date.getFullYear() + year);// y년을 더함
    date.setMonth(date.getMonth() + month);// m월을 더함
    date.setDate(date.getDate() + day);// d일을 더함

    sz_ymd = "" + date.getFullYear();

    if (date.getMonth() < 9) {
        sz_ymd += "0" + (date.getMonth() + 1);
    } else {
        sz_ymd += (date.getMonth() + 1);
    }
    if (date.getDate() < 10) {
        sz_ymd += "0" + date.getDate();
    } else {
        sz_ymd += "" + date.getDate();
    }
    return sz_ymd;
};

/**
 * 날짜를 받아서 요일로 변환한다.
 * 
 * @param v_date : 날짜(yyyyMMdd)
 * @return int
 */
function gfn_getDayNum(v_date) {

    if (v_date.length < 0)
        return "";

    var v_year = v_date.substr(0, 4);
    var v_month = v_date.substr(4, 2);
    var v_day = v_date.substr(6, 2);

    var m = parseInt(v_month, 10) - 1;
    var d = parseInt(v_day, 10);

    var end = new Array(31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31);
    if ((v_year % 4 == 0 && v_year % 100 != 0) || v_year % 400 == 0) {
        end[1] = 29;
    }

    if (d < 1 || d > end[m]) {
        return "";
    }

    var newDate = new Date(v_year, v_month, v_day);

    return parseInt(String(newDate.getDay()));
};

/**
 * 두 개의 날짜를 비교한다.
 * 
 * @param fromDate : 시작일자
 * @param toDate : 종료일자
 * @description fromDate 가 toDate 보다 큰지 체크
 * @example gfn_compareDate( "20110204", "20110305" )
 * @return <String> 9 : 비교 조건부족, 0 : 오류, 1 : 정상
 */
function gfn_compareDate(fromDate, toDate) {
    var flag = "9";
    if (fromDate != "" && toDate != "") {
        if (fromDate > toDate)
            flag = "0";
        else
            flag = "1";
    }
    return flag;
};

/**
 * 두 날짜 사이의 차일을 리턴한다
 * 
 * @param fromdate : 시작날짜
 * @param todate : 종료날짜
 * @return 종료날짜에서 시작날짜의 차일
 * @example gfn_minusDates("20120102", "20121201")
 */
function gfn_minusDates(fromdate, todate) {

    var tmpFromDate = new Date(parseInt(Number(fromdate.substring(0, 4))), parseInt(Number(fromdate.substring(4, 6))) - 1, parseInt(Number(fromdate
            .substring(6))));
    var tmpNextDate = new Date(parseInt(Number(todate.substring(0, 4))), parseInt(Number(todate.substring(4, 6))) - 1, parseInt(Number(todate.substring(6))));
    var days = (tmpNextDate - tmpFromDate) / (3600 * 24 * 1000);

    return days;
};

/**
 * 입력받은 from월로부터 입력to월까지 개월 수를 반환한다.
 * 
 * @param fMonth : 시작월
 * @param tMonth : 종료월
 * @return <number> 개월 수
 * @example gfn_getMonthTerm( "201102", "201303" )
 */
function gfn_getMonthTerm(fMonth, tMonth) {
    var iMonth = 0; // 계산된 개월수
    var iYear = 0; // 계산된 년도
    var rMonth = 0; // 반환할 개월수

    if (parseInt(fMonth) <= parseInt(tMonth)) {
        iYear = parseInt(tMonth.substr(0, 4)) - parseInt(fMonth.substr(0, 4));
        iMonth = parseInt(tMonth.substr(4, 2), 10) - parseInt(fMonth.substr(4, 2), 10);
        rMonth = (12 * iYear) + iMonth + 1;
        return rMonth;
    } else {
        return 0;
    }
};

/**
 * 입력받은 fromQuarter로부터 입력toQuarter까지 Quarter수반환하기
 * 
 * @param fQuarter : 시작 Quarter
 * @param tQuerter : 종료 Quarter
 * @return 총 Quarter 수
 * @example gfn_getQuarterTerm( "20111", "20132" )
 */
function gfn_getQuarterTerm(fQuarter, tQuarter) {
    var iQuarter = 0; // 계산된 Quarter수
    var iYear = 0; // 계산된 년도
    var rQuarter = 0; // 반환할 Quarter수

    if (parseInt(fQuarter) <= parseInt(tQuarter)) {
        iYear = parseInt(tQuarter.substr(0, 4)) - parseInt(fQuarter.substr(0, 4));
        iQuarter = parseInt(tQuarter.substr(4, 1), 10) - parseInt(fQuarter.substr(4, 1), 10);
        rQuarter = (4 * iYear) + iQuarter + 1;
        return rQuarter;
    } else {
        return 0;
    }
};

/**
 * 날짜형식 체크한다. (yyyyMMdd)
 * 
 * @param str : 날짜
 * @return 정상이면 true, 그외는 false
 * @example gfn_getQuarterTerm("20120719")
 */
function gfn_isDate(str) {

    var year_data = "";
    var month_data = "";
    var date_data = "";
    var i;

    str = objString.prototype.replaceAll(str, "/", "");
    str = objString.prototype.replaceAll(str, "-", "");
    str = objString.prototype.replaceAll(str, ".", "");
    if (str.length != 8)
        return false;

    for (i = 0; i < 8; i++) {
        var c = str.charAt(i);
        if (c < '0' || c > '9') {
            return false;
        }
        if (i < 4)
            year_data += c;
        else if (i >= 4 && i < 6)
            month_data += c;
        else if (i >= 6)
            date_data += c;
    }

    var mnthst = month_data;
    var mnth = parseInt(mnthst, 10);
    var dy = parseInt(date_data, 10);

    if (mnth < 1 || mnth > 12 || dy < 1 || dy > 31) {
        return false;
    }

    if (mnth != 2) {
        if (mnth == 4 || mnth == 6 || mnth == 9 || mnth == 11) {
            if (dy > 30) {
                return false;
            }
        } else if (mnth == 1 || mnth == 3 || mnth == 5 || mnth == 7 || mnth == 8 || mnth == 10 || mnth == 12) {
            if (dy > 31) {
                return false;
            }
        }
    } else {
        var yr1 = parseInt(year_data);
        var maxdy;
        if ((yr1 % 400 == 0) || ((yr1 % 4 == 0) && (yr1 % 100 != 0))) {
            maxdy = 29;
        } else {
            maxdy = 28;
        }

        if (dy > maxdy) {
            return false;
        }
    }
    return true;
};

/* ==========================================================================================
 * 해당 프로젝트에서 새로 만든 메소드들을 정의한다.
 * ========================================================================================== */

/**
 * 문자를 Date 객체로 변환
 */
function gfn_stringToDateObject(tmStr){
    var sYear  = tmStr.substr( 0, 4);
    var sMonth = tmStr.substr( 4, 2) - 1;
    var sDay   = tmStr.substr( 6, 2);
    var sHour  = tmStr.substr( 8, 2);
    var sMin   = tmStr.substr(10, 2);
    return  new Date(sYear, sMonth, sDay, sHour, sMin);
}


/**
 * 현재날짜 (밀리세컨드단위)
 * return: yyyy-mm-dd hh:mm:ss.ffffff
 */
function gfn_getServerDateTime(){
    var objDate = new Date();
    var sDate = WebSquare.date.toTimestampString(objDate);
    return  sDate;
}

/**
 * 음력 구하기
 * ex) gfn_getLunar('20120307')  =>  20120215
 */
function gfn_getLunar(sInDate){
    return  WebSquare.date.toLunar(sInDate);
}

/**
 * 현재날짜 및 시간(밀리초 포함) 구하기
 * sFormat : 날짜 포맷 (기본값: YYYY/MM/DD hh:mm:ss)
 * 월(MM)은 반드시 대문자, mm(minute)는 소문자로 해야함
 * 밀리초는 n  으로 표시
 * ex1) gfn_getLocalDateTime("YYYY/MM/DD hh:mm:ss:n") => 2010/09/01 13:42:22:970
 * ex2) gfn_getLocalDateTime("YYYYMMDD")              => 20100901
 * ex3) gfn_getLocalDateTime("hh:mm:ss")              => 13:42:22
 */
function gfn_getLocalDateTime(sFormat){
    var i, j, nIndex = 0;;
    var str;
    var arrFormat = new Array(7);
    var arrIndex  = new Array(7);
    var arrSep    = new Array(7);
    var nSeq, bFlag;

    if (typeof sFormat == "undefined" || sFormat == null || sFormat == "") {
        sFormat = "YYYY" + gv_yearFormater + "MM" + gv_yearFormater + "DD hh" + gv_TimeFormater + "mm" + gv_TimeFormater + "ss";
    }
    str = sFormat;

    for (i=0; i<arrFormat.length; i++) {
        arrFormat[i] = "";
        arrIndex[i] = 0;
        arrSep[i] = "";
    }

    for (i=0; i<str.length; i++) {
        var c = str.charAt(i);

        bFlag = true;
        if (c == 'y' || c == 'Y') {
            nSeq = 0;
        } else if (c == 'M') {
            nSeq = 1;
        } else if (c == 'd' || c == 'D') {
            nSeq = 2;
        } else if (c == 'h' || c == 'H') {
            nSeq = 3;
        } else if (c == 'm') {
            nSeq = 4;
        } else if (c == 's' || c == 'S') {
            nSeq = 5;
        } else if (c == 'n' || c == 'N') {
            nSeq = 6;
        } else {
            bFlag = false;
        }

        if (bFlag) {
            arrFormat[nSeq] += c;
            if (arrIndex[nSeq] == 0) {
                nIndex++;
                arrIndex[nSeq] = nIndex;
            }
        } else {
            arrSep[nSeq] += c;
        }
    }

    var today = new Date();
    var yy = today.getYear();
    var tm = today.getMonth() + 1;
    var td = today.getDate();
    var h  = today.getHours();
    var m  = today.getMinutes();
    var s  = today.getSeconds();
    var ms = "" + today.getMilliseconds();

    var mm = gfn_fillZero(tm, 2);
    var dd = gfn_fillZero(td, 2);
    var hh = gfn_fillZero(h,  2);
    var mi = gfn_fillZero(m,  2);
    var ss = gfn_fillZero(s,  2);
    ms = gfn_fillZero(ms, 3);

    if (curBrowser == "") {
        gfn_getBrowser();
    }
    if (curBrowser != "MSIE") {
        yy += 1900;
    }

    str = "";
    for (i=0; i<arrFormat.length; i++) {
        for (j=0; j<arrFormat.length; j++) {
            if ((i+1) == arrIndex[j]) {

                var c = arrFormat[j].charAt(0);
                if (c == 'y' || c == 'Y') {
                    if (arrFormat[j].length == 4) {
                        str += yy;
                    } else {
                        str += yy.substring(2, 4);
                    }
                } else if (c == 'M') {
                    str += mm;
                } else if (c == 'd' || c == 'D') {
                    str += dd;
                } else if (c == 'h' || c == 'H') {
                    str += hh;
                } else if (c == 'm') {
                    str += mi;
                } else if (c == 's' || c == 'S') {
                    str += ss;
                } else if (c == 'n' || c == 'N') {
                    str += ms;
                }
                str += arrSep[j];
                break;
            }
        }
    }

    return  str;
}

/**
 * 현재날짜 구하기
 * isFormat : 년, 월, 일 사이의 구분자 표시 여부
 * ex1) gfn_getLocalDate(true) => 2010/09/01
 * ex2) gfn_getLocalDate()     => 20100901
 */
function gfn_getLocalDate(isFormat)
{
    var ret = "";
    var sFormat = "YYYYMMDD";

    if (typeof isFormat != "undefined" && isFormat == true) {
        sFormat = "YYYY" + gv_yearFormater + "MM" + gv_yearFormater + "DD";
    }
    ret = gfn_getLocalDateTime(sFormat);

    return  ret;
}

/**
 * 현재시간(밀리초) 구하기
 * isFormat : 시, 분, 초, 밀리초 사이의 구분자 표시 여부 (true, false)
 * mSec     : 밀리초 구하기 여부  (true, false)
 * ex1) gfn_getLocalTime(true, true) => 15:09:03:562
 * ex2) gfn_getLocalTime(true)       => 15:09:03
 * ex3) gfn_getLocalTime()           => 150903
 */
function gfn_getLocalTime(isFormat, mSec)
{
    var ret = "";
    var sFormat = "hhmmss";

    if (typeof isFormat != "undefined" && isFormat == true) {
        sFormat = "hh" + gv_TimeFormater + "mm" + gv_TimeFormater + "ss";
    }
    if (typeof mSec != "undefined" && mSec == true) {
        if (isFormat)  sFormat += gv_TimeFormater;
        sFormat += "n";
    }
    ret = gfn_getLocalDateTime(sFormat);

    return  ret;
}

/**
 *  * 시간 계산 (eTime - Stime)
 */
function gfn_getTimeCompute(sTime, eTime){
    var stime = gfn_getNumberOnly(sTime);
    var etime = gfn_getNumberOnly(eTime);
    var sHour, sMin, sSec;
    var eHour, eMin, eSec;

    sHour = parseInt(stime.substring(0, 2), 10);
    sMin  = parseInt(stime.substring(2, 4), 10);
    sSec  = parseInt(stime.substring(4, 6), 10);
    eHour = parseInt(etime.substring(0, 2), 10);
    eMin  = parseInt(etime.substring(2, 4), 10);
    eSec  = parseInt(etime.substring(4, 6), 10);

    var sSecond = parseInt((sHour * 3600) + (sMin * 60) + sSec, 10);
    var eSecond = parseInt((eHour * 3600) + (eMin * 60) + eSec, 10);

    return  (eSecond - sSecond);
}

/**
 * 
 * 특정일자 기준 만 나이 계산한다.
 * 
 * @param idx : 구분( 1:기준일자+6개월, 2:기준일자)
 * @param sJumin : 주민번호
 * @param cDate : 기준일자(미 입력 시 현재일자)
 * @return 계산된 만 나이
 * @example gfn_getAge("1", "8801011234567") gfn_num_getAge("1", "8801011234567", "20121231")
 */
function gfn_getAge(idx, sJumin, cDate) {

    if ((typeof arguments[0] == "undefined" || arguments[0] == "")) {
        return 0;
    }
    if ((typeof arguments[1] == "undefined" || arguments[1] == "")) {
        return 0;
    }

    var CurrDt;
    var currentDate = gfn_com_getCurrentDate("yyyyMMdd"); // 서버 현재 시간

    // 기준일자 + 6개월
    if (idx == "1") {
        if (typeof arguments[2] == "undefined" || arguments[2] == "") {
            CurrDt = gfn_addMonth(currentDate, "6"); // 현재일자 + 6개월
        } else {
            CurrDt = gfn_addMonth(cDate, "6"); // 기준일자 + 6개월
        }

        // 기준일자
    } else if (idx == "2") {
        if (typeof arguments[2] == "undefined" || arguments[2] == "") {
            CurrDt = currentDate; // 현재일자
        } else {
            CurrDt = cDate; // 기준일자
        }

    } else {
        return 0;
    }

    var curr_yy = CurrDt.substring(0, 4);
    var curr_mm = CurrDt.substring(4, 6);
    var curr_dd = CurrDt.substring(6, 8);

    var birth_yy = sJumin.substring(0, 2);
    var birth_mm = sJumin.substring(2, 4);
    var birth_dd = sJumin.substring(4, 6);

    var birth_gbn = sJumin.substring(6, 7);
    if (birth_gbn == "3" || birth_gbn == "4") {
        birth_yy = "20" + birth_yy;
    } else {
        birth_yy = "19" + birth_yy;
    }

    var age = Number(curr_yy) - Number(birth_yy);
    if (Number(curr_mm) == Number(birth_mm)) {
        if (Number(curr_dd) < Number(birth_dd)) {
            age = Number(age) - Number(1);
        }
    } else if (Number(curr_mm) < Number(birth_mm)) {
        age = Number(age) - Number(1);

    }

    return age;
};