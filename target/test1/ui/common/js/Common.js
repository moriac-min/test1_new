/**
 * @target 팝업, 세션, 공통 메시지 관련 함수
 */
var WebSquare_js = {}; // This is WebSquare JavaScript Marker. Do not remove this line.

//처리 상태 코드
var gva_com_ROW_STATUS_EDIT = "E";
var gva_com_ROW_STATUS_READ = "R";
var gva_com_STATUS_SUCCESS = "200";
var gva_com_STATUS_ERROR = "500";

//공통팝업관련& 메시지 import
imports("uiplugin.popup");

var WEBSQUARE_HOME = "/wq/websquare/websquare.jsp?w2xPath=";

/**
 * 설명 : 서버 오류시 발생.  openMsgPopup은 각화면에 wframe으로 include한 commonfrm.xml 선언
 * 오류유형 : HTTP오류 (404) 등등 
 */
function gfn_submitError(submissionObj, resultObj){
	$w.log("################## gfn_submitError ####################");
	var errMsgDoc = "<messageDoc>"+
					 "<messageTitle>"+resultObj.responseReasonPhrase+"</messageTitle>" +
					 "<messageCode>"+resultObj.responseStatusCode+"</messageCode>"+
					 "<message>"+resultObj.responseBody+"</message>"+
				 "</messageDoc>";
	//alert(errMsgDoc);
	gfn_openMsgPopup("button:close", errMsgDoc, null);
}

/**
 * 설명 : 서버오류시 발생
 * 오류유형 : 정상으로 상태코드는 오지만 서버오류(SQL EXCEPTION, JAVA EXCEPTION 처리)
 */
var GV_CALLBACK = "";
function gfn_commonCallBack(submissionObj,resultObj){
	$w.log("################## gfn_commonCallBack ####################");
	for(var tmpA in submissionObj){
		WebSquare.logger.printLog( JSON.stringify(tmpA) );
//		WebSquare.logger.printLog( submissionObj[tmpA] );
		WebSquare.logger.printLog( "====================" );
	}
	$w.log("@@@@@@@@@@ =="+ JSON.stringify(submissionObj) );
	if( submissionObj == null){
		return true;
	}else{
		return false;
	}
	$w.log('typeof==========='+typeof submissionObj);
}


/**
 * 설명 : 각화면에서 submit-error 이벤트에 기술해줘야 할 함수 
 */
function gfn_commonSubmitError(e){
	
	$w.log('############# gfn_commonSubmitError #############=='+JSON.stringify(e));
	
	if(e.responseText != null && e.responseText !=''){
		
		var errorInfo = e.responseText.split("%&*$$###");
		if(errorInfo.length > 2){
			var errorArray = [];
			
			//title
			if( errorInfo[0] != undefined && errorInfo[0] != ''){
				$w.log("###########[0] ===="+errorInfo[0]);
				errorArray.push(errorInfo[0]);
			}
			
			//message
			if( errorInfo[1] != undefined && errorInfo[1] != ''){
				$w.log("###########[1] ===="+errorInfo[1]);
				errorArray.push(errorInfo[1]);
			}
				
			//error-code
			if( errorInfo[2] != undefined && errorInfo[2] != ''){
				$w.log("###########[2] ===="+errorInfo[2]);
				errorCode = Number(errorInfo[2]);
				errorArray.push(errorInfo[2]);
			}
			
			var errMsgDoc = "<messageDoc>"+
							 "<messageTitle>"+errorInfo[0]+"</messageTitle>" +
							 "<messageCode>"+errorInfo[2]+"</messageCode>"+
							 "<message>"+errorInfo[1]+"</message>"+
						 "</messageDoc>";
			
			gfn_openMsgPopup("button:close", errMsgDoc, null);
		}
	}
}

/**
 * 설명 : submit 발생시 무조건 호출되는 함수
 * 개발자 호출불가
 */
function gfn_submit(submissionObj, resultObj){
	$w.log("################## gfn_submit ####################");
}


/**
 * 설명 : 공통 메시지 함수
 * 파라미터 : sysCd(시스템코드), msgCd(메세지코드), msgType(A:alert, AF:하단Footer메시지처리 , C:confirm), msgStr(메세지 입력)
 * 사용법 : gfn_Message(msgCd, msgType, msgStr);
 * 		    gfn_Message("A", "MSG0007",["조회"]);
 *          gfn_Message("C", "MSG0005",["종료"]);
 *          메세지내 문자열이 들어갈 곳은 {0}, {1} 로 순서대로 선언하여야 하며, 겹치는 숫자가 존재해서는 안된다.
 */
function gfn_Message(sysCd, msgCd, msgType, msgStr)
{
	var strMessage = "";
	var rtn = "";
	
	//시스템코드는 3자리 초과일 수 없으며, 값이 들어있어야한다.
	if(gfn_isEmpty(sysCd) || sysCd.length > 3)
	{
		alert("시스템코드를 입력하지 않았거나\n잘못 입력하셨습니다.");
		return;
	}
	
	//메세지코드는 4자리 숫자만 가능하며, 값이 들어있어야한다.
	if(gfn_isEmpty(msgCd) || msgCd.length != 4)
	{
		alert("메세지코드를 입력하지 않았거나\n잘못 입력하셨습니다.");
		return;
	}
	
	//메세지 표시타입 값 검증
	if(gfn_isEmpty(msgType))
	{
		alert("메세지 표시 타입이 정의되지 않았습니다.");
		return;
	}
	
	gdm_SystemMssg.set("sys_cd", sysCd);
	gdm_SystemMssg.set("mssg_cd", msgCd);
	
	gfn_callSystemMssgSubmission();
	
	strMessage = gdl_SystemMessage.getCellData( 0 , 'mssg_cn' );
	
	if (gfn_isEmpty(strMessage)){
		strMessage = "정의되지 않은 메세지 코드 입니다 : [" + sysCd + ":" + msgCd + "]";
	}
	
	var i = 0;
	var strSub = "";
	var sMsg = strMessage;
	var msgArr = sMsg.split("}");
	if (msgArr.length > 1)
	{
		for(i = 0; i<msgArr.length; i++)
		{
			var strArr = msgArr[i].split("{");
			strSub += strArr[0];
			if(strArr[1] != undefined || strArr[1] != null) strSub += msgStr[strArr[1]];
		}
			strMessage = strSub;
	}
	
	if (msgType == "C")
	{
		rtn = confirm(strMessage);
	}
	else if (msgType == "A")
	{
		alert(strMessage);
	}
	else if (msgType == "AF")
	{
		try
		{
			parent.txt_CommonFooterMssgCn.setLabel( strMessage );
		} catch (e)
		{
		} finally
		{
			alert(strMessage);
		}
	}
	else
	{
		alert(strMessage);
	}
	
	var rtnVal = rtn;
	return rtnVal;
}

/**
 * 설명 : 공통코드호출
 * 파라미터 : sysCd(시스템코드), cdArray(공통코드 코드목록), dlArray(공통코드를 담을 datalist목록)
 * 사용법 : gfn_callCommonCode(cdArray, dlArray);
 */
function gfn_callCommonCode(sysCd, cdArray, dlArray)
{
	//alert("gfn_callCommonCode Call sysCd :: " + sysCd);
	//alert("gfn_callCommonCode cdArray Length :: " + cdArray.length);
	//alert("gfn_callCommonCode dlArray Length :: " + dlArray.length);
	try
	{
		if(gfn_isEmpty(sysCd))
		{
			alert("[gfn_callCommonCode] Exception :: 시스템코드 값이 입력되지 않았습니다.");
			return;
		}
		if(cdArray.length != dlArray.length)
		{
			alert("[gfn_callCommonCode] Exception :: 공통코드와 코드를 담을 datalist의 수량이 일치하지 않습니다.");
			return;
		}
		var tempStr = "";
		for(var i = 0; i < cdArray.length; i++)
		{
			if(i != 0)
			{
				tempStr += ",";
			}
			tempStr += "'" + cdArray[i] + "'";
		}
		
		gdm_CommonCode.set("sys_cd",sysCd);
		gdm_CommonCode.set("cmmn_cd",tempStr);
		
		gfn_callCommonCodeSubmission();
		
		var rowCnt = gdl_CommonCodeData.getRowCount();
		
		if(rowCnt > 0)
		{
			for(var i = 0; i < dlArray.length; i++){
				eval(dlArray[i]).removeAll();
				var rowSetCnt = 0;
				for(var j = 0; j < rowCnt; j++){
					if(sysCd == gdl_CommonCodeData.getCellData(j,'sys_cd') && cdArray[i] == gdl_CommonCodeData.getCellData(j,'cmmn_cd')){
						eval(dlArray[i]).setRowArray(rowSetCnt ,gdl_CommonCodeData.getRowArray(j) );
						rowSetCnt++;
					}
				}
			}
		}
//		var v_CommonCodeMap = {"id" :"gdm_CommonCode" ,
//	            "type" : "dataMap" ,
//	            "option":{ "baseNode": "map", "style": ""},
//	            "columnInfo":[{"id":"sys_cd", "name":"시스템코드", "dataType":"text"},
//	                          {"id":"cmmn_cd", "name":"코드", "dataType":"text"}]
//	           };
		
//		var v_CommonCodeDataList = {"id" :"gdl_CommonCodeData" ,
//	            "type" : "dataList" ,
//	            "option":{ "baseNode": "list", "repeatNode": "map"},
//	            "columnInfo":[{"id":"sys_cd", "name":"시스템코드", "dataType":"text"},
//	                          {"id":"cmmn_cd", "name":"코드", "dataType":"text"},
//	                          {"id":"cmmn_cd_nm", "name":"코드명", "dataType":"text"},
//	                          {"id":"cmmn_eng_nm", "name":"코드영문명", "dataType":"text"},
//	                          {"id":"work_dvs_cd", "name":"업무구분코드", "dataType":"text"},
//	                          {"id":"fnprt_cd_lengt", "name":"세부코드길이", "dataType":"text"},
//	                          {"id":"user_dfn_clmn_nm_1", "name":"코드명", "dataType":"text"},
//	                          {"id":"user_dfn_clmn_nm_2", "name":"코드명", "dataType":"text"},
//	                          {"id":"user_dfn_clmn_nm_3", "name":"코드명", "dataType":"text"},
//	                          {"id":"user_dfn_clmn_nm_4", "name":"코드명", "dataType":"text"},
//	                          {"id":"user_dfn_clmn_nm_5", "name":"코드명", "dataType":"text"},
//	                          {"id":"user_dfn_clmn_nm_6", "name":"코드명", "dataType":"text"},
//	                          {"id":"user_dfn_clmn_nm_7", "name":"코드명", "dataType":"text"},
//	                          {"id":"user_dfn_clmn_nm_8", "name":"코드명", "dataType":"text"},
//	                          {"id":"user_dfn_clmn_nm_9", "name":"코드명", "dataType":"text"},
//	                          {"id":"user_dfn_clmn_nm_10", "name":"코드명", "dataType":"text"}]
//	           };
		
//		var v_submissionOption = {"id" :"gsub_CommonCodeData",
//	            "ref" : "data:json,{id:'gdm_CommonCode',key:'commonCodeVO'}",
//	            "target" : "data:json,[{'id':'gdl_CommonCodeData','key':'infoDataList'}]",
//	            "action" : "/adminfacillity/systemmngt/selectCommonCodeDetail.do",
//	            "method" : "post",
//	            "mediatype" : "application/json",
//	            "encoding" : "UTF-8",
//	            "instance" : "",
//	            "errorHandler" : "",
//	            "customHandler" : "",
//	            "mode" : "synchronous",
//	            "processMsg" : "",
//	            "submitHandler" : "",
//	            "submitDoneHandler" : function() {  },
//	            "submitErrorHandler" : function() {  }	            
//	           };
//		$w.data.create(v_CommonCodeMap);
//		$w.data.create(v_CommonCodeDataList);
//		$w.createSubmission(v_submissionOption);
	} catch(e)
	{
	}
}

/**
 * 설명 : datalistinit함수의 미구현으로 인하여 Datalist내부 내용을 강제로 비워주는 함수(DataMap에도 적용가능)
 * 파라미터 : dlObj(Datalist 또는 DataMap객체)
 * 사용법 : gfn_datalistClear(dlObj)
 * @param dlObj
 */
function gfn_datalistClear(dlObj){
	var jsonO = "[]";
	dlObj.setJSON( JSON.parse(jsonO) , false );
}

/**
 * 에러메시지
 * _wsMsg 에 등록된 메시지코드값을 출력한다. 사용자마다 같은 메시지를 다름을 방지.
 * 예)errorMessageDisplay(_error_msg["COM_PROC_OK"]);
 */
function gfn_errorMessageDisplay(msg, isView){
    if (typeof isView == "undefined" || isView == true) {
        alert(msg);
    }
}

/**
 * 에러메시지 Layer Popup 출력
 * 반드시 프레임에 /common/js/ws/commonFrame.xml (공통요소) 가 포함된 프레임을 가져야한다.
 */
function gfn_showErrorMessageDisplay(title, msg, object)
{
    if (typeof openFloatPopup == "undefined") {
        gfn_printLog("여기서 에러가 나오면 /common/js/ws/commonFrame.xml 를 include 안한것임. wframe안에 include 하세요.");
    }
    openFloatPopup("title:" + title + "; bodyMessage:" + msg + "; button:close", null, object);
}


/**
 * 메세지 팝업을 호출한다.
 * 
 * @param messageType : 팝업창 타입 (alert || confirm)
 * @param message : 메시지
 * @param closeCallbackFncName : 콜백 함수명
 * @param title : 팝업창 타이틀
 * @example gfn_com_showAlert("입력코드를 선택하세요");
 */
function gfn_com_messagBox(messageType, message, closeCallbackFncName, title) {
    var messageVal = message || "";
    var messageTypeVal = messageType || "alert";
    var defaultTitle = null;
    
    if (messageTypeVal === "alert") {
        defaultTitle = "Alert";
    } else {
        defaultTitle = "Confirm";
    }
    
    closeCallbackFncName = closeCallbackFncName || "";
    
    var options = {
        title : title || defaultTitle,
        popupParam : {"message" : messageVal, "closeCallbackFncName" : closeCallbackFncName},
        modal : true,
        width : 340,
        height : 135
    };
    gfn_openPopup(messageTypeVal, "/common/xml/message_box.xml", options);
};

function gfn_com_confirm(message, closeCallbackFncName, title) {
    gfn_com_messagBox("confirm", message, closeCallbackFncName, title);
};

function gfn_alert(message, title) {
    gfn_com_messagBox("alert", message, title);
};

/**
 * 팝업창을 닫는다.
 * 
 * @param popupId 화면을 닫을 팝업 윈도우 아이디
 * @param callBackFnc 콜백 함수 이름 
 * @param rtnObj 반환할 객체 (JSON or XML)
 * @example gfn_closePopup(WebSquare.net.getParameter( "popupID" ), "setData", jsonObj);
 */
function gfn_closePopup(popupId, callBackFnc, rtnObj) {

    requires("uiplugin.popup");
    if (typeof callBackFnc != "undefined") {
        var func = window.scwin[callBackFnc];
        if(typeof func == "function") {
            if (typeof rtnObj != "undefined") {
                var rtnStr = gfn_serialize(rtnObj);
                func(rtnStr);
            } else {
                func();
            }
        }
    }
    WebSquare.util.closePopup(popupId);
};

/**
* 설명 : 레이어 팝업
* 파라미터	: id(Popup고유식별값), url(파일경로), options(팝업전반에 관한 설정값)
* 사용예  	: gfn_openLayerPopup("abc", "/ui/common/xxx.xml", options);
*/
function gfn_openLayerPopup(id, url, options) {
	var optionVals = options;
    var width = optionVals.width || "400";
    var height = optionVals.height || "400";
    var left = optionVals.left || -1;
    var top = optionVals.top || -1;
    
    if (left > 0) {
        left = left + (self.screenLeft || window.screenX);
    } else {
        left = Math.floor((document.body.clientWidth - width) / 2);
    }
    if (top > 0) {
        top = top + (self.screenTop || window.screenY);
    } else {
        top = Math.floor((document.body.clientHeight - height) / 2);
    }
    
    requires("uiplugin.popup");
    var options = {
        id : id,
        type : optionVals.type || "window",
        width : width + "px",
        height : height + "px",
        top : top, // useIframe이 true인 경우 브라우져를 기준 false인 경우 모니터를 기준으로 한다.
        left : left,
        popupName : optionVals.title || "", // useIframe : true시 popup 객체의 이름으로 popup 프레임의 표시줄에 나타납니다.
        modal : optionVals.modal || false, // modal을 이용해서 뒤 쪽 배경을 동작하지 않도록 만들기 위한 인자 입니다. false이면 뒤쪽의 컴퍼넌트가 사용 가능합니다.
        useIFrame : optionVals.useIFrame || false,// true : IFrame 을 사용하는 WebSquare popup / false: window.open 을 사용하는 popup
        style : "", // popup의 스타일을 지정합니다. 값이 있으면 left top width height는 적용되지 않습니다.
        resizable : optionVals.resizable || false,
        status : false,
        menubar : false,
        scrollbars : optionVals.scrollbar || false,
        title : optionVals.title || false,
        xml : JSON.stringify(optionVals.popupParam) || "", // popup에 넘길 xmlDocument의 string popup창에서 WebSquare.util.getPopupParam() api를 사용하여 가져올수 있습니다.
        srcData : "", // popup 객체의 type 이 window 일 때 Parent 에서 넘길 xpath
        destData : "" // popup 객체의 type 이 window 일 때 popup 에 설정할 xpath
    };

    try {
        WebSquare.util.openPopup(url, options);
    } catch(e) { 
    } finally {
        options = null;
    }
}

/**
 * 설명 : 팝업을 호출한다.
 * 파라미터 : id(Popup고유구분값), url(파일경로), options(Popup창 파라미터)
 * 사용법 : gfn_openPopup("abc", "/ui/common/xxx.xml", options);
 */
function gfn_openPopup(id, url, options) {
	var optionVals = options;
    var width = options.width || "400";
    var height = options.height || "400";

    var left = options.left || -1;
    var top = options.top || -1;
    
    if (left > 0) {
        left = left + (self.screenLeft || window.screenX);
    } else {
        left = Math.floor((document.body.clientWidth - width) / 2);
    }
    if (top > 0) {
        top = top + (self.screenTop || window.screenY);
    } else {
        top = Math.floor((document.body.clientHeight - height) / 2);
    }
    
    requires("uiplugin.popup");
    var options = {
        id : id,
        type : optionVals.type || "litewindow", // window, litewindow
        width : width + "px",
        height : height + "px",
        top : top, // useIframe이 true인 경우 브라우져를 기준 false인 경우 모니터를 기준으로 한다.
        left : left,
        popupName : optionVals.title || "", // useIframe : true시 popup 객체의 이름으로 popup 프레임의 표시줄에 나타납니다.
        modal : optionVals.modal || false, // modal을 이용해서 뒤 쪽 배경을 동작하지 않도록 만들기 위한 인자 입니다. false이면 뒤쪽의 컴퍼넌트가 사용 가능합니다.
        useIFrame : optionVals.useIFrame || false,// true : IFrame 을 사용하는 WebSquare popup / false: window.open 을 사용하는 popup
        style : "", // popup의 스타일을 지정합니다. 값이 있으면 left top width height는 적용되지 않습니다.
        resizable : optionVals.resizable || false,
        status : false,
        menubar : false,
        scrollbars : optionVals.scrollbar || false,
        title : optionVals.title || false,
        xml : gfn_serialize(optionVals.popupParam) || "", // popup에 넘길 xmlDocument의 string popup창에서 WebSquare.uiplugin.popup.getPopupParam() api를 사용하여 가져올수 있습니다.
        srcData : "", // popup 객체의 type 이 window 일 때 Parent 에서 넘길 xpath
        destData : "" // popup 객체의 type 이 window 일 때 popup 에 설정할 xpath
    };

    try {
        WebSquare.util.openPopup(gva_ajax_CONTEXT_PATH + url, options);
    } catch(e) { 
    } finally {
        options = null;
    }
};

/**
 * 설명 : 현재 화면이 팝업인지 아닌지 여부 판단
 * 파라미터 : 없음
 * 사용법 : gfn_isPopup();
 */
function gfn_isPopup(){
    try {
        if (typeof window.opener == "undefined") {
            return  false;
        } else if (window.opener.closed) {
            return  false;
        } else {
            return  true;
        }
    } catch (e) {
        return  false;
    }
};

/**
 * 설명 : Array Object 인지 확인한다.
 * 파라미터 : targetObj(Object)
 * 사용법 : gfn_isArrayObj(targetObj);
 */
function gfn_isArrayObj(targetObj) {
    if (typeof targetObj != 'undefined' && typeof targetObj == "object") {
        if (targetObj.constructor.name && targetObj.constructor.name.toLowerCase() == "array")
            return true;
        if (targetObj.constructor && targetObj.constructor === Array)
            return true;
    }
    return false;
};

/**
 * 설명 : 엔터키 입력 시 전달된 function을 호출한다.
 * 파라미터 : fncStr(function명)
 * 사용법 : gfn_fireObjectEnter("getSearchList()");
 */
function gfn_fireObjectEnter(fncStr) {
    if (window.event.keyCode == 13)
        eval(fncStr);
};

/**
 * 새창을 띄울때 해상도에 맞춰 최대크기로 창의 크기를 조정한다.
 */
function gfn_pageFullScreen() {
    top.window.moveTo(0, 0);
    if (document.all) {
        top.window.resizeTo(screen.availWidth, screen.availHeight);
    } else if (document.layer || document.getElementById) {
        if (top.window.outerHeight < screen.availHieght || top.window.outerWidth < screen.availWidth) {
            top.window.outerHeight = screen.availHieght;
            top.window.outerWidth = screen.availWidth;
        }
    }
};

/**
 * 새창을 띄울때 해상도에 맞춰 최대크기로 창의 크기를 조정한다. (기준 : 1280*960)
 */
function gfn_pageFullScreenFix() {
    // 1280*1024 기준으로 띄우기
    var sWidth = screen.availWidth;
    var sHeight = screen.availHeight;
    if (sWidth > 1280)
        sWidth = 1280;
    if (sHeight > 960)
        sHeight = 960;
    top.window.moveTo(0, 0);
    if (document.all) {
        top.window.resizeTo(sWidth, sHeight);
    } else if (document.layer || document.getElementById) {
        if (top.window.outerHeight < sHeight || top.window.outerWidth < sWidth) {
            top.window.outerHeight = sHeight;
            top.window.outerWidth = sWidth;
        }
    }
};

/**
 * 객체를 클리어한다.
 * 
 * @param object
 */
function gfn_clearObject(object) {
    for ( var key in object) {
        object[key] = null;
    }
    object = null;
};

/* ==========================================================================================
 * 해당 프로젝트에서 새로 만든 메소드들을 정의한다.
 * ========================================================================================== */
//로그찍기
function gfn_printLog(msg){
	$w.log(msg);
}

//화면이동시 sName에 대한 파라미터값 얻기 
function gfn_getParameter(sName){
	return $w.getParameter( sName );
//  return  WebSquare.net.getParameter(sName);
}

/**
 * 그룹 내의 입력형 Object의 값을 클리어한다.
 * 하위그룹의 컴포넌트도 초기화
 * ex) gfn_initGroup(group1)
 */
function gfn_initGroup()
{
    for (var i=0; i<arguments.length; i++) {
        var grpObj = arguments[i];
        var childArr = grpObj.getChildren();

        for (var nIndex in childArr) {
            var obj = childArr[nIndex];
            var pluginName = obj.getPluginName().toLowerCase();

            if (pluginName == "input") {
                if (typeof obj.defaultValue != "undefined" && obj.defaultValue != null) {
                    obj.setValue(obj.defaultValue);
                } else {
                    obj.setValue("");
                }
            } else if (pluginName == "inputcalendar" || pluginName == "calendar" || pluginName == "multiselect" ||
                       pluginName == "autocomplete"  || pluginName == "secret"   ||
                       pluginName == "textarea"      || pluginName == "checkbox") {
                obj.setValue("");
            } else if (pluginName == "selectbox") {
                if (obj.allOption + "" == "true") {
                    obj.setValue("all");
                } else {
                    obj.setValue("");
                }
            } else if (pluginName == "radio") {
                obj.reset();
            } else if (pluginName == "group") {
                gfn_initGroup(obj);
            } else if (pluginName == "editor") {
                obj.setHTML("");
//            } else if (pluginName == "grid") {
//                obj.initGrid();
            }
        }
    }
}

//window session 에 값 저장
function gfn_setWindowSession(key, value){
    var doc;
    if (typeof value == "object") {
        doc = WebSquare.xml.serialize(value);
    } else {
        doc = value;
    }
    WebSquare.session.setAttribute(key, doc);
}

// window session 값 불러오기
function gfn_getWindowSession(key){
   return  WebSquare.session.getAttribute(key);
}

//window session 값 삭제
function gfn_removeWindowSession(key){
    return  WebSquare.session.removeAttribute(key);
}

/**
 * 브라우져 종류확인
 */
function gfn_getBrowser(){
  var result;
  var typeUserAgent;

  typeUserAgent = navigator.userAgent;
  if (typeUserAgent.indexOf("MSIE") != -1) {           // Explorer
      result = "MSIE";
  } else if (typeUserAgent.indexOf("Chrome") != -1) {  // Chrome
      result = "Chrome";
  } else if (typeUserAgent.indexOf("Safari") != -1) {  // Safari
      if (typeUserAgent.indexOf("Mobile") != -1) {     // Mobile Safari
          result = "Unsupport";
      } else {
          result = "Safari";
      }
  } else if (typeUserAgent.indexOf("Opera") != -1) {   // Opera
      result = "Opera";
  } else if (typeUserAgent.indexOf ("Firefox") != -1) {
      if (typeUserAgent.indexOf ("Netscape") != -1) {  // Netscape 6
          result = "Unsupport";
      } else {                                           // Firefox
          result = "Firefox";
      }
  } else {
      result = "Unsupport";
  }
  curBrowser = result;

  return  result;
}

/**
 * 브라우져의 버전확인
 */
function gfn_getBrowserVersion()
{
  var rv = -1;
  var ua = navigator.userAgent;
  var re = null;

  if (curBrowser == null || curBrowser == "")  gfn_getBrowser();
  if (curBrowser == "MSIE") {
      re = new RegExp("MSIE ([0-9]{1,}[\.0-9]{0,})");
  } else {
      re = new RegExp(curBrowser+"/([0-9]{1,}[\.0-9]{0,})");
  }
  if (re.exec(ua) != null) {
      rv = parseFloat(RegExp.$1);
  }

  return  rv;
}

/**
 * Datalist 객체에서 특정 컬럼의 Null 및 빈문자열 여부 Check
 * 컬럼명을 기준으로 Null Check되었을 경우 alert가 발생한다. 
 * @param dlObj Datalist객체
 * @param validStr Datalist내 체크할 컬럼명과 컬럼ID조합 문자열배열
 * @param isAll true일 경우 변경되지 않은 행도 체크한다. 빈 값이거나 false가오면 변경된 행만 체크한다.
 * @param grdObj GridView Object가 존재할 경우 문제가 발생한 Cell로 포커스를 옮긴다.
 * @returns boolean
 * @example gfn_gridViewValidationCheck(grd_GridView1, ["컬럼명1=컬럼ID1","컬럼명2=컬럼ID2","컬럼명3=컬럼ID3]);
 */
function gfn_validationCheck(dlObj, validStr, isAll, grdObj)
{
	var vColumnNmArr = new Array();
	var vColumnIdArr = new Array();
	var j = 0;
	if(dlObj.getRowCount() > 0)
	{
		for(var i = 0; i < validStr.length; i++)
		{
			var tmpArr = validStr[i].split("=");
//			alert("tmpArr[0]=" + tmpArr[0] + ", tmpArr[1]=" + tmpArr[1]);
			if(gfn_isEmpty(tmpArr[0]) || gfn_isEmpty(tmpArr[1]))
			{
				alert("체크할 Validation정보 값이 제대로 입력되지 않았습니다.");
				return false;
			}
			vColumnIdArr[j] = tmpArr[0];
			vColumnNmArr[j] = tmpArr[1];
			j++;
		}
		
		for(var i = 0; i < dlObj.getRowCount(); i++)
		{
			if(gfn_isEmpty(isAll) || !isAll)	//변경된 행만 체크
			{
				if(dlObj.getRowStatus(i) == "C" || dlObj.getRowStatus(i) == "U")
				{
					for(var k = 0; k < j; k++)
					{
						var tmpChkVal = dlObj.getCellData(i, vColumnIdArr[k]);
						if(gfn_isEmpty(tmpChkVal))
						{
							alert(vColumnNmArr[k] + "의 값이 입력되지 않았습니다.\n확인 후 다시 진행해주시기 바랍니다.");
							try {
								grdObj.setFocusedCell(i,vColumnIdArr[k],true);
							} catch (e) {
							}
							return false;
						}
					}
				}
			} else if (isAll)	//모든 행 체크
			{
				for(var k = 0; k < j; k++)
				{
					var tmpChkVal = dlObj.getCellData(i, vColumnIdArr[k]);
					if(gfn_isEmpty(tmpChkVal))
					{
						alert(vColumnNmArr[k] + "의 값이 입력되지 않았습니다.\n확인 후 다시 진행해주시기 바랍니다.");
						try {
							grdObj.setFocusedCell(i,vColumnIdArr[k],true);
						} catch (e) {
						}
						return false;
					}
				}
			}
		}
	}
	
	return true;
	
}

/**
 * @param submissionObj
 * @return
 */
function tit_CustomHandler( submissionObj ) {
	//alert("tit_CustomHandler");
	try {
		var submissionID = submissionObj.id;
		var eventObj = { "id" : submissionID };

		if( submissionObj.processMsg != "" ) {
			WebSquare.layer.addSubmissionMessage( submissionID, submissionObj.processMsg );
		}
		
		var ret = WebSquare.event.fireEvent(submissionObj, "xforms-submit", eventObj);		// xforms-submit-error event 
		if( typeof ret != "undefined" && ret == false ) {
			WebSquare.logger.printLog("xforms-submit even return is false. : " + submissionID);
			WebSquare.ModelUtil.setSubmissionEnd(submissionObj, "submission done" , null);
			WebSquare.layer.deleteSubmissionMessage( submissionID );
			return;
		}

		WebSquare.ModelUtil.doSubmitPreFunc( submissionObj );

		var obfuscator_http = WebSquare.core.getXMLHTTPObject();
		
		var url = WebSquare.core.getURL(submissionObj.action);
		var async = ( submissionObj.mode == "synchronous" ) ?  false : true;
		var ref = submissionObj.ref;
		var bind = submissionObj.bind;
		var target = submissionObj.target;
		var replace = submissionObj.replace;
		var instance = submissionObj.instance;
		var encoding = submissionObj.encoding;
		var mediatype = submissionObj.mediatype;

		var method =  submissionObj.method;
		var action =  submissionObj.action;

		var errorHandler = submissionObj.errorHandler;
		var requestData = submissionObj.requestData;

		var soapaction = submissionObj.soapaction;

		var instanceElement = null;
		if( instance != '' ) {
			var modelID = submissionObj.parentElement.getAttribute("id");
			if( modelID == null || modelID == '' ) {
				instanceElement = WebSquare.ModelUtil.getInstanceByID( instance );
			} else {
				instanceElement = WebSquare.ModelUtil.getInstanceByID( instance, modelID );
			}
		} else {
			instanceElement = WebSquare.xml.getElementsByTagName( submissionObj.parentElement, "data" )[0];
		}

		var e = null;
		if( typeof requestData != "undefined" && requestData != null ) {
			e = requestData;
		} else {
			if(ref == ""){
				e = instanceElement;
			} else {
				e = WebSquare.xml.createNode(instanceElement, ref);
			}
		}

		var xml = WebSquare.xml.serialize(e);
		//var xml = WebSquare.xml.indent(e);
		
		if(async) {
			obfuscator_http.onreadystatechange=function(){
				["WebSquare.ModelUtil.submissionHandler.onreadystatechange"];
				if(obfuscator_http.readyState!=4){
					return;
				}
				
				if((obfuscator_http["status"])&&((200 > obfuscator_http.status)||(300 <= obfuscator_http.status))){
					var errorEventObj = { "id" : submissionID,
								"errorType" : "resource-error",
								"resourceUri" : url,
								"responseHeaders" : WebSquare.ModelUtil.parseResponseHeader( obfuscator_http ),
								"responseStatusCode" : obfuscator_http["status"],
								"responseReasonPhrase" : obfuscator_http["statusText"],
								"requestBody" : WebSquare.xml.parse(xml),
								"responseBody" : "text/" + obfuscator_http.responseText };
					WebSquare.logger.printLog('submission error(E01). Status[' + obfuscator_http.status + '] ' + submissionID);
					
					WebSquare.ModelUtil.setSubmissionEnd(submissionObj, "submission error", errorEventObj);
					WebSquare.layer.deleteSubmissionMessage( submissionID );
					WebSquare.event.fireEvent(submissionObj, "xforms-submit-error", errorEventObj);		// xforms-submit-error event 
	
					if( WebSquare.logger.globalDebug1 || WebSquare.logger.getGlobalDebug() ) {
						var obj = new Object();
						var re = />[\s]*</g;	//Initialize pattern.
						obj["information"] =   "url          : " + url          +
											"\nasync        : " + async        +
											"\nref          : " + ref          +
											"\nbind         : " + bind         +
											"\ntarget       : " + target       +
											"\nreplace      : " + replace      +
											"\ninstance     : " + instance     +
											"\nencoding     : " + encoding     +
											"\nmediatype    : " + mediatype    +
											"\nmethod       : " + method       +
											"\naction       : " + action       +
											"\nerrorHandler : " + errorHandler +
											"\nsoapaction   : " + soapaction   +
											"\nstatus       : " + obfuscator_http["status"] +
											"\nstatus text  : " + obfuscator_http["statusText"] +
											"\nresponseHeaders : " + WebSquare.ModelUtil.parseResponseHeader( obfuscator_http );
						obj["result"] = obfuscator_http.responseText.replace( re ,">\n<");
						obj["input"] = xml.replace( re ,">\n<");
						WebSquare.logger.showDebugMsg( obj, 'xml', "Default Submission (Async Mode)" );
					}
	
					obfuscator_http = null;
					return;
				}
	
				var obfuscator_xmlDocument = WebSquare.xml.parse( obfuscator_http.responseText );
	
				if( errorHandler != ""  && eval( errorHandler + "( obfuscator_xmlDocument )" ) ) {
					var errorEventObj = { "id" : submissionID,
								"errorType" : "target-error",
								"resourceUri" : url,
								"responseHeaders" : WebSquare.ModelUtil.parseResponseHeader( obfuscator_http ),
								"responseStatusCode" : obfuscator_http["status"],
								"responseReasonPhrase" : obfuscator_http["statusText"],
								"requestBody" : WebSquare.xml.parse(xml),
								"responseBody" : obfuscator_xmlDocument };
					WebSquare.logger.printLog('submission error(E02). Status[' + obfuscator_http.status + '] ' + submissionID);
					
					WebSquare.ModelUtil.setSubmissionEnd(submissionObj, "submission error" , errorEventObj);
					WebSquare.layer.deleteSubmissionMessage( submissionID );
					WebSquare.event.fireEvent(submissionObj, "xforms-submit-error", errorEventObj);		// xforms-submit-error event 
	
					if( WebSquare.logger.globalDebug1 || WebSquare.logger.getGlobalDebug() ) {
						var obj = new Object();
						var re = />[\s]*</g;	//Initialize pattern.
						obj["information"] =   "url          : " + url          +
											"\nasync        : " + async        +
											"\nref          : " + ref          +
											"\nbind         : " + bind         +
											"\ntarget       : " + target       +
											"\nreplace      : " + replace      +
											"\ninstance     : " + instance     +
											"\nencoding     : " + encoding     +
											"\nmediatype    : " + mediatype    +
											"\nmethod       : " + method       +
											"\naction       : " + action       +
											"\nerrorHandler : " + errorHandler +
											"\nsoapaction   : " + soapaction   +
											"\nstatus       : " + obfuscator_http["status"] +
											"\nstatus text  : " + obfuscator_http["statusText"] +
											"\nresponseHeaders : " + WebSquare.ModelUtil.parseResponseHeader( obfuscator_http );
						obj["result"] = obfuscator_http.responseText.replace( re ,">\n<");
						obj["input"] = xml.replace( re ,">\n<");
						WebSquare.logger.showDebugMsg( obj, 'xml', "Default Submission (Async Mode)" );
					}
	
				} else {
					if( replace == "instance" ) {
						WebSquare.WebSquaredoc.models[0].rebuild(WebSquare.xml.parse(WebSquare.xml.serialize( obfuscator_xmlDocument )), target);
						WebSquare.WebSquaredoc.models[0].refresh();
					} else if( replace == "text" ) {
						WebSquare.WebSquaredoc.models[0].rebuild(WebSquare.xml.serialize( obfuscator_xmlDocument ), target);
						WebSquare.WebSquaredoc.models[0].refresh();
					} else if( replace == "none" ) {
					} else {		// replace == "all"
						while(document.body.hasChildNodes()){
							 document.body.removeChild(document.body.firstChild);
						}
						WebSquare.WebSquaredoc = null;
						WebSquare.WebSquaredoc=new WebSquare.WebSquareDocument(obfuscator_xmlDocument);
						WebSquare.WebSquaredoc.parsing();
					}
	
					var doneEventObj = { "id" : submissionID,
								"resourceUri" : url,
								"responseHeaders" : WebSquare.ModelUtil.parseResponseHeader( obfuscator_http ),
								"responseStatusCode" : obfuscator_http["status"],
								"responseReasonPhrase" : obfuscator_http["statusText"],
								"requestBody" : WebSquare.xml.parse(xml),
								"responseBody" : WebSquare.xml.parse( obfuscator_http.responseText) };
					WebSquare.logger.printLog('submission complete. Status[' + obfuscator_http.status + '] ' + submissionID);
	
					WebSquare.ModelUtil.setSubmissionEnd(submissionObj, "submission complete" , doneEventObj);
					WebSquare.layer.deleteSubmissionMessage( submissionID );
					WebSquare.event.fireEvent(submissionObj, "xforms-submit-done", doneEventObj);		// xforms-submit-error event 
	
	
					if( WebSquare.logger.globalDebug1 || WebSquare.logger.getGlobalDebug() ) {
						var obj = new Object();
						var re = />[\s]*</g;	//Initialize pattern.
						obj["information"] =   "url          : " + url          +
											"\nasync        : " + async        +
											"\nref          : " + ref          +
											"\nbind         : " + bind         +
											"\ntarget       : " + target       +
											"\nreplace      : " + replace      +
											"\ninstance     : " + instance     +
											"\nencoding     : " + encoding     +
											"\nmediatype    : " + mediatype    +
											"\nmethod       : " + method       +
											"\naction       : " + action       +
											"\nerrorHandler : " + errorHandler +
											"\nsoapaction   : " + soapaction   +
											"\nstatus       : " + obfuscator_http["status"] +
											"\nstatus text  : " + obfuscator_http["statusText"] +
											"\nresponseHeaders : " + WebSquare.ModelUtil.parseResponseHeader( obfuscator_http );
						obj["result"] = obfuscator_http.responseText.replace( re ,">\n<");
						obj["input"] = xml.replace( re ,">\n<");
						WebSquare.logger.showDebugMsg( obj, 'xml', "Default Submission (Async Mode)" );
					}
	
				}
				obfuscator_http = null;
			};
		}

		// soap submission
		var isSoap = false;
		if (typeof xml != "undefined") {
			if (xml.indexOf("http://schemas.xmlsoap.org/soap/envelope") > -1) {
				isSoap = true;
			}
		}

		WebSquare.logger.printLog( url );
		
		obfuscator_http.open(method, url, async);
		if (isSoap) {
			obfuscator_http.setRequestHeader("soapaction",'"' + soapaction + '"');
		}
		
		obfuscator_http.setRequestHeader("Content-Type", 'text/xml;charset=utf-8');
		// before request
		obfuscator_http.send('<?xml version="1.0" encoding="utf-8"?>'+"\n"+xml);
		if( !async ) {
			if((obfuscator_http["status"])&&((200 > obfuscator_http.status)||(300 <= obfuscator_http.status))){
				var errorEventObj = { "id" : submissionID,
							"errorType" : "resource-error",
							"resourceUri" : url,
							"responseHeaders" : WebSquare.ModelUtil.parseResponseHeader( obfuscator_http ),
							"responseStatusCode" : obfuscator_http["status"],
							"responseReasonPhrase" : obfuscator_http["statusText"],
							"requestBody" : WebSquare.xml.parse(xml),
							"responseBody" : "text/" + obfuscator_http.responseText };
				WebSquare.logger.printLog('submission error(E03). Status[' + obfuscator_http.status + '] ' + submissionID);
				
				WebSquare.ModelUtil.setSubmissionEnd(submissionObj, "submission error" , errorEventObj);
				WebSquare.layer.deleteSubmissionMessage( submissionID );
				
				var submitErrorHandler = WebSquare.core.getConfiguration("/WebSquare/submission/submitErrorHandler/@value");
				var submitErrorHandlerMode = WebSquare.core.getConfiguration("/WebSquare/submission/submitErrorHandler/@mode");
				if(submitErrorHandler) {
					var obfuscator_evt = errorEventObj;
					if(submitErrorHandlerMode == "only") {
						eval(submitErrorHandler+"(obfuscator_evt)");
					} else if(submitErrorHandlerMode == "after") {
						WebSquare.event.fireEvent(submissionObj, "xforms-submit-error", obfuscator_evt);		// xforms-submit-error event
						eval(submitErrorHandler+"(obfuscator_evt)");
					} else if(submitErrorHandlerMode == "before") {
						eval(submitErrorHandler+"(obfuscator_evt)");
						WebSquare.event.fireEvent(submissionObj, "xforms-submit-error", obfuscator_evt);		// xforms-submit-error event
					}
				} else {
					WebSquare.event.fireEvent(submissionObj, "xforms-submit-error", errorEventObj);		// xforms-submit-error event
				}
				if( WebSquare.logger.globalDebug1 || WebSquare.logger.getGlobalDebug() ) {
					var obj = new Object();
					var re = />[\s]*</g;	//Initialize pattern.
					obj["information"] =   "url          : " + url          +
										"\nasync        : " + async        +
										"\nref          : " + ref          +
										"\nbind         : " + bind         +
										"\ntarget       : " + target       +
										"\nreplace      : " + replace      +
										"\ninstance     : " + instance     +
										"\nencoding     : " + encoding     +
										"\nmediatype    : " + mediatype    +
										"\nmethod       : " + method       +
										"\naction       : " + action       +
										"\nerrorHandler : " + errorHandler +
										"\nsoapaction   : " + soapaction   +
										"\nstatus       : " + obfuscator_http["status"] +
										"\nstatus text  : " + obfuscator_http["statusText"] +
										"\nresponseHeaders : " + WebSquare.ModelUtil.parseResponseHeader( obfuscator_http );
					obj["result"] = obfuscator_http.responseText.replace( re ,">\n<");
					obj["input"] = xml.replace( re ,">\n<");
					WebSquare.logger.showDebugMsg( obj, 'xml', "Default Submission (Sync Mode)" );
				}

				obfuscator_http = null;
				return;
			}

			var obfuscator_xmlDocument = WebSquare.xml.parse( obfuscator_http.responseText);
			if( errorHandler != ""  && eval( errorHandler + "( obfuscator_xmlDocument )" ) ) {		// Error 
				var errorEventObj = { "id" : submissionID,
							"errorType" : "target-error",
							"resourceUri" : url,
							"responseHeaders" : WebSquare.ModelUtil.parseResponseHeader( obfuscator_http ),
							"responseStatusCode" : obfuscator_http["status"],
							"responseReasonPhrase" : obfuscator_http["statusText"],
							"requestBody" : WebSquare.xml.parse(xml),
							"responseBody" : obfuscator_xmlDocument };
				WebSquare.logger.printLog('submission error(E04). Status[' + obfuscator_http.status + '] ' + submissionID);
				
				WebSquare.ModelUtil.setSubmissionEnd(submissionObj, "submission error" , errorEventObj);
				WebSquare.layer.deleteSubmissionMessage( submissionID );
				WebSquare.event.fireEvent(submissionObj, "xforms-submit-error", errorEventObj);		// xforms-submit-error event

				if( WebSquare.logger.globalDebug1 || WebSquare.logger.getGlobalDebug() ) {
					var obj = new Object();
					var re = />[\s]*</g;	//Initialize pattern.
					obj["information"] =   "url          : " + url          +
										"\nasync        : " + async        +
										"\nref          : " + ref          +
										"\nbind         : " + bind         +
										"\ntarget       : " + target       +
										"\nreplace      : " + replace      +
										"\ninstance     : " + instance     +
										"\nencoding     : " + encoding     +
										"\nmediatype    : " + mediatype    +
										"\nmethod       : " + method       +
										"\naction       : " + action       +
										"\nerrorHandler : " + errorHandler +
										"\nsoapaction   : " + soapaction   +
										"\nstatus       : " + obfuscator_http["status"] +
										"\nstatus text  : " + obfuscator_http["statusText"] +
										"\nresponseHeaders : " + WebSquare.ModelUtil.parseResponseHeader( obfuscator_http );
					obj["result"] = obfuscator_http.responseText.replace( re ,">\n<");
					obj["input"] = xml.replace( re ,">\n<");
					WebSquare.logger.showDebugMsg( obj, 'xml', "Default Submission (Sync Mode)" );
				}

			} else {
				if( replace == "instance" ) {
					WebSquare.WebSquaredoc.models[0].rebuild(WebSquare.xml.parse(WebSquare.xml.serialize( obfuscator_xmlDocument )), target);
					WebSquare.WebSquaredoc.models[0].refresh();
				} else if( replace == "text" ) {
					WebSquare.WebSquaredoc.models[0].rebuild(WebSquare.xml.serialize( obfuscator_xmlDocument ), target);
					WebSquare.WebSquaredoc.models[0].refresh();
				} else if( replace == "none" ) {
				} else {		// replace == "all"
					while(document.body.hasChildNodes()){
						 document.body.removeChild(document.body.firstChild);
					}
					WebSquare.WebSquaredoc = null;
					WebSquare.WebSquaredoc=new WebSquare.WebSquareDocument(obfuscator_xmlDocument);
					WebSquare.WebSquaredoc.parsing();
				}

				var doneEventObj = { "id" : submissionID,
							"resourceUri" : url,
							"responseHeaders" : WebSquare.ModelUtil.parseResponseHeader( obfuscator_http ),
							"responseStatusCode" : obfuscator_http["status"],
							"responseReasonPhrase" : obfuscator_http["statusText"],
							"requestBody" : WebSquare.xml.parse(xml),
							"responseBody" : WebSquare.xml.parse( obfuscator_http.responseText) };
				WebSquare.logger.printLog('submission complete. Status[' + obfuscator_http.status + '] ' + submissionID);

				WebSquare.ModelUtil.setSubmissionEnd(submissionObj, "submission complete" , doneEventObj);
				WebSquare.layer.deleteSubmissionMessage( submissionID );
				WebSquare.event.fireEvent(submissionObj, "xforms-submit-done", doneEventObj);		// xforms-submit-done event 

				if( WebSquare.logger.globalDebug1 || WebSquare.logger.getGlobalDebug() ) {
					var obj = new Object();
					var re = />[\s]*</g;	//Initialize pattern.
					obj["information"] =   "url          : " + url          +
										"\nasync        : " + async        +
										"\nref          : " + ref          +
										"\nbind         : " + bind         +
										"\ntarget       : " + target       +
										"\nreplace      : " + replace      +
										"\ninstance     : " + instance     +
										"\nencoding     : " + encoding     +
										"\nmediatype    : " + mediatype    +
										"\nmethod       : " + method       +
										"\naction       : " + action       +
										"\nerrorHandler : " + errorHandler +
										"\nsoapaction   : " + soapaction   +
										"\nstatus       : " + obfuscator_http["status"] +
										"\nstatus text  : " + obfuscator_http["statusText"] +
										"\nresponseHeaders : " + WebSquare.ModelUtil.parseResponseHeader( obfuscator_http );
					obj["result"] = obfuscator_http.responseText.replace( re ,">\n<");
					obj["input"] = xml.replace( re ,">\n<");
					WebSquare.logger.showDebugMsg( obj, 'xml', "Default Submission (Sync Mode)" );
				}

			}
			obfuscator_http = null;
		}

	} catch(e){
		WebSquare.layer.hideProcessMessage();
	}
}

/**
 * Error 및 Messagebox Handler시작
 */
var gv_gtop;
var gv_gleft;
var gv_gwidth;
var gv_gheight;
var gv_gtitle = "";        // Layer Popup 타이틀
var gv_bodyMessage = "";   // Layer Popup 본문 메시지
var gv_gParam = null;
var gv_callback = "";
var gv_arrButtonList;
var gv_focusObj;
var gv_isError = 0;

function gfn_openMsgPopup(sFeatures, doc , object) {
	gv_isError = 1;
    if (typeof sFeatures == "undefined" || sFeatures == null || sFeatures == "") {
        gfn_errorMessageDisplay('sFeatures 속성값이 비었습니다');
        return;
    }
    gfn_printLog("sFeatures: " + sFeatures);

    if (typeof doc != "undefined" && doc != null) {
        gv_gParam = doc;
    } else {
        gv_gParam = null;
        gfn_printLog("commonFrame.gv_gParam is null !!! ");
    }
    if (typeof object != "undefined" && object != null) {
        gv_focusObj = object;
    }
    
    var arrFeatures = sFeatures.split(";");
    for (var i=0; i<arrFeatures.length; i++) {
        var tmpArray = arrFeatures[i].split(":");
        if (tmpArray.length == 2) {
            var objNm  = tmpArray[0].trim().toLowerCase();
            var objVal = tmpArray[1].trim();

            if (objNm == "top") {
                gv_gtop = (objVal.length > 0 ? parseInt(objVal, 10) : 0);
            } else if (objNm == "left")  {
                gv_gleft = (objVal.length > 0 ? parseInt(objVal, 10) : 0);
            } else if (objNm == "width")  {
                gv_gwidth = (objVal.length > 0 ? parseInt(objVal, 10) : 0);
            } else if (objNm == "height")  {
                gv_gheight = (objVal.length > 0 ? parseInt(objVal, 10) : 0);
            } else if (objNm == "button")  {  // enabled 될 버튼 리스트
                gv_arrButtonList = objVal.split(",");
            } else if (objNm == "callback")  {
                gv_callback = objVal;
            }
        }
    }
    
	if (gv_arrButtonList != null && gv_arrButtonList.length > 0) {
        gfn_showButtonList();
    }
    
    gfn_viewFloatingPopup();
}

/*
 * 버튼 보이기 (버튼은 무조건 2개 이하)
 */
function gfn_showButtonList() {
    var left = 104;

    for (var i=0; i<gv_arrButtonList.length; i++) {
        if (gv_arrButtonList[i] == "confirm") {
            trBtnConfirm.setPosition(left, 0);
            trBtnConfirm.show();
        } else if (gv_arrButtonList[i] == "cancel") {
            trBtnCancel.setPosition(left+52, 0);
            trBtnCancel.show();
        } else if (gv_arrButtonList[i] == "yes") {
            trBtnYes.setPosition(left, 0);
            trBtnYes.show();
        } else if (gv_arrButtonList[i] == "no") {
            trBtnNo.setPosition(left+52, 0);
            trBtnNo.show();
        } else if (gv_arrButtonList[i] == "delete") {
            trBtnDelete.setPosition(left, 0);
            trBtnDelete.show();
        } else if (gv_arrButtonList[i] == "close") {
            left = (gv_arrButtonList.length == 1) ? (left + 26) : (left + 52);
            trBtnClose.setPosition(left, 0);
            trBtnClose.show();
        }
        if ((i+1) >= 2)  break;  // 버튼은 2개이하
    }
}

function gfn_viewFloatingPopup() {
    var left = (gv_gleft >= 0) ? gv_gleft : -1;
    var top  = (gv_gtop >= 0) ? gv_gtop : -1;
    var gv_gwidth  = 420;
    var gv_gheight = 200;

    if (left < 0) {
        left = Math.floor((document.documentElement.clientWidth/2)-(gv_gwidth/2));
        if (parseInt(left) < 0)  left = 0;
    }
    if (top < 0) {
        top = Math.floor((document.documentElement.clientHeight/2)-(gv_gheight/2));
        if (parseInt(top) < 0)  top = 0;
    }

    floatingGroup.setStyle("top", "0");
    floatGrayGroup.setStyle("top", "0");

    floatPopup.setPosition(left, top);
    floatPopup.setSize(gv_gwidth, gv_gheight);

    floatPopup.show();
    floatingGroup.show();

    gfn_setErrorMessage();

    // esc key 이벤트를 걸기위함
    floatPopup.focus();
}

function gfn_setErrorMessage() {
    var baseMsg = "";
    var detailMsg = "";
    var doc;

    if (gv_gParam != null) {

        doc = WebSquare.xml.parse(gv_gParam);
        baseMsg   = WebSquare.xml.getValue(doc, "messageDoc/messageTitle");
        detailMsg = WebSquare.xml.getValue(doc, "messageDoc/message");
        detailMsg += "errorCode: " + WebSquare.xml.getValue(doc, "messageDoc/messageCode");
		
    } else {
        baseMsg = gv_gtitle;
        detailMsg = gv_bodyMessage;
    }
    txtErrLayerTitle.setLabel(baseMsg);
    txtErrLayerMsg.setValue(detailMsg.replaceAll("\\n", "\n"));
}

function gfn_floatPopupClose(e) {
    if (e == 27) {
        gfn_btnAction("close");
    }
}

/*
 * layer hide 처리후 callback 함수 호출
 */
function gfn_btnAction(action) {
    floatPopup.hide();
    floatingGroup.hide();

    if (gv_callback != null && gv_callback != "") {
        eval(gv_callback + "(action);");
    } else if (typeof gv_focusObj != "undefined" && gv_focusObj != null) {
        gv_focusObj.focus();
        gv_focusObj = null;
    }
}

//에러여부
function gfn_isErrorCheck(){
	if(gv_isError)
		return true;
	else
		return false;
}
/**
 * Error 및 Messagebox Handler종료
 */