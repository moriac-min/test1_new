/**
 * @target 유효성 검사를 위한 공통 함수
 */
var WebSquare_js = {}; // This is WebSquare JavaScript Marker. Do not remove this line.

// 유효성 검사 상태
var gva_val_isValidStatus = true;

/**
 * 유효성 검사 상태를 반환한다.
 * 
 * @return <boolean> 유효성 검사 상태
 */
function gfn_val_getValidStatus() {
    return gva_val_isValidStatus;
};

/**
 * 유효성 검사 상태를 설정한다.
 * 
 * @param value 유효성 검사 상태
 */
function gfn_val_setValidStatus(value) {
    gva_val_isValidStatus = value;
};

/**
 * 그룹안에 포함된 컴포넌트의 입력 값에 대한 유효성을 검사한다.
 * 
 * @param grpObj 그룹 컴포넌트 객체
 * @param dltObj 데이터 컬렉션 객체
 * @returns <Boolean> 유효성 검사 결과
 * @example if (gfn_val_validateGroup(grp_LoginInfo, dlt_Code) === false) { return; }
 * @description
 * 필수 입력, 입력 허용 문자, 입력 허용 불가 문자, 최대, 최소 입력 문자수 설정은 컴포넌트의 속성에서 설정한다. 
 * - mandatory : 필수 입력 항목 여부 
 * - allowChar : 입력 허용 문자 
 * - ignoreChar : 입력 허용 불가 문자 
 * - maxLength : 최대 입력 문자수 
 * - maxByteLength : 최대 입력 바이트수 
 * - minLength : 최소 입력 문자수 
 * - minByteLength : 최소 입력 바이트수
 */
function gfn_val_validateGroup(grpObj, dltObj) {
    if (gfn_val_checkModified(dltObj) === false) {
        return false;
    }

    gfn_val_setValidStatus(true);
    var objArr = WebSquare.util.getChildren(grpObj, {
        excludePlugin : "group trigger textbox output calendar image",
        recursive : true
    });
    
    try {
        for ( var i = 0; i < objArr.length; i++) {
            objArr[i].validate();
            if (gfn_val_getValidStatus() === true) {
                gfn_val_extendValidation(objArr[i]);
                if (gfn_val_getValidStatus() === false) {
                    return false;
                }
            } else {
                return false;
            }
        }
        return true;
    } catch(e) { 
    } finally {
        objArr = null;
    }
};

/**
 * 유효성 검사 실패시 출력할 메시지를 반환한다.
 * 
 * @param columnName 컴포넌트와 바인된 DataCollection 컬럼 명
 * @returns {String} 메시지
 */
function gfn_val_validateMsg() {

    var msg = "";
    var invalidType = this.getType(); // invalid 타입
    var invalidValue = this.getValue(); // invalid 타입별 설정값
    var callerObj = this.getCaller(); // validator를 호출한 컴포넌트
    var columnName = gfn_val_getColumnName(callerObj);

    switch (invalidType) {
    case "mandatory":
        msg = columnName + "은(는) 필수 입력 항목 입니다.";
        break;
    case "minLength":
        msg = columnName + "은(는) 최소 길이 " + invalidValue + "자리 이상으로 입력해야 합니다.";
        break;
    case "minByteLength":
        msg = columnName + "은(는) 최소 길이 " + invalidValue + "바이트 이상으로 입력해야 합니다.";
        break;
    }

    if (msg !== "") {
        gva_val_isValidStatus = false;
    }

    return msg;
};

/**
 * 추가적으로 확장한 사용자 정의 유효성 검사를 수행한다.
 * @param comObj 유효성 검증 대상 컴포넌트 객체
 * @description
 * 1. hangul
 *    - 한글 포함 여부 검사한다. 
 *    - false : 한글이 포함되면 안됨 
 *    - 컴포넌트에 'hangul'이라는 사용자 정의 속성을 추가한다.
 *    - ex. <xf:input id="ibx_AuthorityCd" mandatory="true" maxlength="5" minlength="5" hangul="false"></xf:input> 
 */
function gfn_val_extendValidation(comObj) {

    var isHangul =  comObj.getUserData("hangul");
    if ((typeof isHangul !== "undefined") && (isHangul === "false")) {
        if (gfn_isKoreanWord(comObj.getValue()) === true) {
            gva_val_isValidStatus = false;
            var columnName = gfn_val_getColumnName(comObj);
            comObj.focus();
            gfn_alert(columnName + "은(는) 한글을 입력해서는 안됩니다.");
            return;
        }
    }
}

/**
 * 특정 컴포넌트에 바인된 DataList나 DataMap의 컬럼 이름을 반환한다.
 * @param callerObj 컴포넌트
 */
function gfn_val_getColumnName(comObj) {

    try {
        if ((typeof comObj.getRef) === "function") {
            var ref = comObj.getRef();
            var refArray = ref.substring(5).split(".");
            var dataCollectionName = refArray[0];
            var columnId = refArray[1];
            if ((typeof refArray !== "undefined") && (refArray.length === 2)) {
                var dataCollection = WebSquare.util.getComponentById(dataCollectionName);
                var dataType = dataCollection.getObjectType().toLowerCase();
                if (dataType === "datamap") {
                    return dataCollection.getName(columnId);
                } else if (dataType === 'datalist') {
                    return dataCollection.getColumnName(columnId);
                }
            } else {
                return "";
            }
        }
    } catch(e) { 
    } finally {
        dataCollection = null;
    }
}

/**
 * GridView를 통해서 입력된 데이터에 대해서 유효성을 검증한다.
 * 
 * @param gridViewObj GridView 객체
 * @param valInfo 데이터 유효성 검증 옵션 JSON 객체 ([{id : [columnId], mandatory : [boolean], minlength = [number], hangul : [boolean], valFunc : [userFunc]}])
 * @returns <Boolean> 유효성검사 결과
 * @example 
 * var valInfo = [ {id : "grp_cd", mandatory : true, minlength : 5, hangul : false}, {id : "grp_nm", mandatory : true, hangul : true} ];
 * var modifiedData = $w.data.get("JSON", [{"id":"dlt_CodeGrp", "key" : "data", action : "modified"}]); 
 * if (gfn_validateGridView(grd_CodeGrp, valInfo)) {
 *     gfn_ajax_getAjaxRequest({action : "serviceId=CD0001&action=U", reqData : modifiedData, success : "scwin.saveCodeGrpCallback"}); 
 * }
 * @description
 * 입력 허용 문자, 입력 허용 불가 문자, 최대 입력 문자수 설정은 GridView의 Column의 속성에서 설정한다. 
 * - allowChar : 입력 허용 문자 
 * - ignoreChar : 입력 허용 불가 문자 
 * - maxLength : 최대 입력 문자수
 */
function gfn_validateGridView(gridViewObj, valInfo) {

    var result = {
        isValid : true,
        columnId : "",
        rowIdx : 0,
        msg : ""
    };

    var dataList = gfn_com_getGridViewDataList(gridViewObj);
    if (dataList === null) {
    	gfn_alert("Bind된 datalist 객체가 없습니다.");
        return false;
    }
    
    try {
        var modifiedIdx = dataList.getModifiedIndex();

        if (modifiedIdx.length === 0) {
            dataList.undoAll();
            dataList.removeRows(dataList.getInsertedIndex());
            gfn_alert("저장할 데이터가 없습니다.");
            return false;
        }
    
        var modifiedData = dataList.getModifiedJSON();
    
        for ( var dataIdx = 0; dataIdx < modifiedData.length; dataIdx++) {
            if ((result.isValid === false) || (modifiedData[dataIdx].rowStatus === "D")) {
                break;
            }
            for ( var valIdx = 0; valIdx < valInfo.length; valIdx++) {
                if (result.isValid === false) {
                    break;
                }
                if ((typeof valInfo[valIdx].id !== "undefined") && (typeof modifiedData[dataIdx][valInfo[valIdx].id] !== "undefined")) {
    
                    var value = modifiedData[dataIdx][valInfo[valIdx].id].trim();
    
                    if ((typeof valInfo[valIdx].mandatory !== "undefined") && (valInfo[valIdx].mandatory === true) && (value.length === 0)) {
                        setResult(result, valInfo[valIdx].id, modifiedIdx[dataIdx], dataList, gridViewObj, "은(는) 필수 입력 항목 입니다.");
                    } else if ((typeof valInfo[valIdx].minlength !== "undefined") && (valInfo[valIdx].minlength > 0) && (value.length < valInfo[valIdx].minlength)) {
                        setResult(result, valInfo[valIdx].id, modifiedIdx[dataIdx], dataList, gridViewObj,"은(는) 최소 길이 " + valInfo[valIdx].minlength + "자리 이상으로 입력해야 합니다.");
                    } else if ((typeof valInfo[valIdx].hangul !== "undefined") && (valInfo[valIdx].hangul === false) && (gfn_isKoreanWord(value) === true)) {
                        setResult(result, valInfo[valIdx].id, modifiedIdx[dataIdx], dataList, gridViewObj,"은(는) 한글을 입력해서는 안됩니다.");
                    } else if (typeof valInfo[valIdx].valFunc === "function") {
                        var resultMsg = valInfo[valIdx].valFunc(value);
                        if (resultMsg !== "") {
                            setResult(result, valInfo[valIdx].id, modifiedIdx[dataIdx], dataList, gridViewObj, resultMsg);
                        }
                    }
                }
            }
        }
    
        return result.isValid;
    
        function setResult(result, id, rowIdx, dataList, gridViewObj, msg) {
                var columnName = dataList.getColumnName(id);
                result.isValid = false;
                result.columnId = id;
                result.rowIdx = rowIdx;
                result.msg = columnName + msg;
                gfn_alert(result.msg);
                gridViewObj.setFocusedCell(rowIdx, id);
        }
    } catch(e) { 
    } finally {
        modifiedData = null;
        modifiedIdx = null;
        dataList = null;
        gridViewObj = null;
    }
}

/**
 * DataList 객체의 변경된 데이터가 있는지 검사한다.
 * @param dltObj
 * @returns {Boolean} 검사결과
 */
function gfn_val_checkModified(dltObj) {
    if (typeof dltObj !== "undefined") {
        var modifiedIndex = dltObj.getModifiedIndex();
        if (modifiedIndex.length === 0) {
            gfn_alert("변경된 데이터가 없습니다.");
            return false;
        } else {
            return true;
        }
    } else {
        return true;
    }
};

/**
 * 사업자번호 유효성을 검사한다.
 * 
 * @param str : 문자열
 * @return 올바른 번호가 아닌경우 false
 * @example function gfn_val_checkBizID("1102112345");
 */
function gfn_val_checkBizID(str) {

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
 * 법인등록번호 유효성을 검사한다.
 * 
 * @param str : 문자열
 * @return 올바른 번호가 아닌경우 false
 * @example function gfn_val_checkCorpID("110211234567");
 */
function gfn_val_checkCorpID(str) {

    var checkID = new Array(1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2);
    var sCorpNo = str;
    var lV1 = 0;
    var nV2 = 0;
    var nV3 = 0;

    for ( var i = 0; i < 12; i++) {
        lV1 = parseInt(sCorpNo.substring(i, i + 1)) * checkID[i];

        if (lV1 >= 10) {
            nV2 += lV1 % 10;
        } else {
            nV2 += lV1;
        }
    }
    nV3 = nV2 % 10;

    if (nV3 > 0) {
        nV3 = 10 - nV3;
    } else {
        nV3 = 0;
    }
    if (sCorpNo.substring(12, 13) != nV3) {
        return false;
    }
    return true;
};

/**
 * 내외국인 주민등록번호 유효성을 검사한다.
 * 
 * @param str : 문자열
 * @return 올바른 번호가 아닌경우 false
 * @example function gfn_val_checkPersonID("9701011234567");
 */
function gfn_val_checkPersonID(str) {

    var checkID = new Array(2, 3, 4, 5, 6, 7, 8, 9, 2, 3, 4, 5);
    var i = 0, sum = 0;
    var temp = 0;
    var yy = "";

    if (str.length != 13) {
        return false;
    }
    for (i = 0; i < 13; i++) {
        if (str.charAt(i) < '0' || str.charAt(i) > '9') {
            return false;
        }
    }

    // foreigner PersonID Pass
    if (str.substring(6, 13) == "5000000" || str.substring(6, 13) == "6000000" || str.substring(6, 13) == "7000000" || str.substring(6, 13) == "8000000") {
        return true;
    }
    for (i = 0; i < 12; i++) {
        sum += str.charAt(i) * checkID[i];
    }
    temp = sum - Math.floor(sum / 11) * 11;
    temp = 11 - temp;
    temp = temp - Math.floor(temp / 10) * 10;

    // 나이 (-) 체크
    if (str.charAt(6) == '1' || str.charAt(6) == '2' || str.charAt(6) == '5' || str.charAt(6) == '6') {
        yy = "19";
    } else {
        yy = "20";
    }
    if (parseInt(common_util.getCurrentDate('yyyy')) - parseInt(yy + str.substring(0, 2)) < 0) {
        return false;
    }

    // 외국인 주민번호 체크로직 추가
    if (str.charAt(6) != '5' && str.charAt(6) != '6' && str.charAt(6) != '7' && str.charAt(6) != '8') {
        if (temp == eval(str.charAt(12))) {
            return true;
        } else {
            return false;
        }
    } else {
        if ((temp + 2) % 10 == eval(str.charAt(12))) {
            return true;
        } else {
            return false;
        }
    }
    return false;
};

/**
 * 메일주소 체크한다.
 * 
 * @param str : 메일주소
 * @return 정상이면 true, 그외는 false
 * @example function gfn_val_isEmail("emailTest@email.com")
 */
function gfn_val_isEmail(str) {

    var i;
    var check = 0;
    var dot = 0;
    var before = "";
    var after = "";

    str = gfn_trim(str);

    if (str.length == 0)
        return false;
    for (i = 0; i < str.length; i++) {
        if (str.charAt(i) == '@') {
            check = check + 1;
        } else if (check == 0) {
            before = before + str.charAt(i);
        } else if (check == 1) {
            after = after + str.charAt(i);
        }
    }
    if (check >= 2 || check == 0) {
        return false;
    }
    for (i = 0; i < before.length; i++) {
        if (!((before.charAt(i) >= 'A' && before.charAt(i) <= 'z') || (before.charAt(i) >= '0' && before.charAt(i) <= '9') || (before.charAt(i) == '_')
                || (before.charAt(i) == '.') || (before.charAt(i) == '-'))) {
            return false;
        }
    }
    for (i = 0; i < after.length; i++) {
        if (!((after.charAt(i) >= 'A' && after.charAt(i) <= 'z') || (after.charAt(i) >= '0' && after.charAt(i) <= '9') || (after.charAt(i) == '_')
                || (after.charAt(i) == '.') || (after.charAt(i) == '-'))) {
            return false;
        }
    }
    for (i = 0; i < after.length; i++) {
        if (after.charAt(i) == '.') {
            dot = dot + 1;
        }
    }
    if (dot < 1) {
        return false;
    }
    var atidx = str.indexOf('@');
    var endchar = str.substring(atidx + 1);
    if (endchar == "" || endchar == "co.kr" || endchar == "or.kr" || endchar == "ac.kr" || endchar == "pe.kr" || endchar == "ne.kr" || endchar == "com"
            || endchar == "org" || endchar == "net" || endchar == "gov") {
        return false;
    } else {
        var compobj = endchar.substring(0, endchar.indexOf("."));
        var exeobj = endchar.substring(endchar.indexOf(".") + 1);
        if (((compobj == "hanmail" || compobj == "chollian") && exeobj != "net")) {
            return false;
        } else if ((compobj == "dreamwiz" || compobj == "freechal" || compobj == "hotmail" || compobj == "naver" || compobj == "chol") && exeobj != "com") {
            return false;
        }
    }

    return true;
};

/* ==========================================================================================
 * 해당 프로젝트에서 새로 만든 메소드들을 정의한다.
 * ========================================================================================== */