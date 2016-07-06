/**
 * @target 서버와 통신(Ajax, Submission)을 위한 함수
 */
var WebSquare_js= {}; //This is WebSquare JavaScript Marker. Do not remove this line.

var gva_ajax_CONTEXT_PATH = "";
var gva_ajax_SERVICE_URL = "/servlet/serviceController?";

/**
 * Ajax 통신을 위한 기본 설정 값
 */
var gva_ajax_DEFAULT_OPTIONS_MODE = "asynchronous";
var gva_ajax_DEFAULT_OPTIONS_MEDIATYPE = "application/json";

/**
 * 서버와 Ajax 통신을 수행한다.
 * 
 * @param <Object:Y> 
 * | options JSON형태 객체 
 * | options.action      : ajax 요청주소
 * | options.mode        : asynchronous(default)/synchronous
 * | options.mediatype   : mediatype
 * | options.method      : get/post/put/delete
 * | options.processMsg  : 서비스 처리중에 보여줄 메시지 (ex. "요청하신 서비스를 처리중입니다"), 서비스 처리 시간이 긴 경우에는 메시지 필요.
 * | options.reqData     : 요청 데이터 (XML Object, XML String, JSON Object, JSON String)
 * | options.timeout     : ajax요청후 timeout 시간. 이시간이 초과해도 응답이 오지 않는 경우 error callback함수를 실행
 * | options.type        : xml/json. xml인 경우 success callback함수의 인자객체의 responseBody속성에 xml객체가 설정된고, json인 경우 자바스크립트 객체가 설정된다.나머지 경우는 text형식이 설정.
 * | options.beforeAjax  : 요청전에 실행되는 함수로 이 함수내에서 false를 return하면 ajax요청을 하지 않는다
 * | options.success     : 요청이 성공한 경우 실행되는 callback함수
 * | options.error       : 요청이 실패한 경우 실행되는 callback함수
 * | options.resData     : Response된 데이터를 세팅할 DataCollection(DataList, DataMap) 객체
 * | options.isShowMeg  : callback 함수가 지정되지 않은 경우에 서버에서 전달받은 메시지를 Alert 할 것인지 여부
 */
function gfn_ajax_getAjaxRequest(options) {
    var action = gva_ajax_CONTEXT_PATH + gva_ajax_SERVICE_URL + options.action;
    var mode = options.mode || gva_ajax_DEFAULT_OPTIONS_MODE;
    var mediatype = options.mediatype || gva_ajax_DEFAULT_OPTIONS_MEDIATYPE;
    var method = (options.method || "post").toLowerCase();
    var processMsg = options.processMsg || "";
    var requestHeader = options.requestHeader || {};
    var reqData = "";
    var successCallBack = options.success || "";
    var errorCallBack = options.error || "";
    var isShowMeg = true;
    
    if (typeof options.isShowMeg !== "undefined") {
        isShowMeg = options.isShowMeg;
    }
    
    if ((mediatype.indexOf("xml") >= 0) && ((typeof options.reqData) === "object")){
        reqData = WebSquare.xml.serialize(options.reqData);
    } else if ((mediatype.indexOf("json") >= 0) && ((typeof options.reqData) === "object")){
        reqData = JSON.stringify(options.reqData);
    } else {
        reqData = options.reqData;
    }
    var resBody = null;

    var ajaxOptions = {
        action        : action,
        mode          : mode,
        mediatype     : mediatype,
        method        : method,
        processMsg    : processMsg,
        requestData   : reqData,
        requestHeader : requestHeader,
        beforeAjax    : function(e) {
                        },
        success       : function(e) {
                            if (mediatype == "application/xml") {
                                if (typeof e.responseBody != "undefined") resBody = WebSquare.xml.parse(e.responseBody);
                                var resData = WebSquare.xml.findNode(resBody, "data");
                                if ((typeof options.resData !== "undefined") && (typeof resData !== "undefined")) {
                                    options.resData.setXML(resData);
                                }
                            } else if (mediatype == "application/json") {
                                resBody = e.responseJSON;
                                if ((typeof options.resData !== "undefined") && (typeof resBody.data !== "undefined")) {
                                    options.resData.setJSON(resBody.data);
                                }
                            } else {
                                resBody = e.responseText;
                            }

                            if(successCallBack !== "") {
                            	
                                var func = window.scwin[successCallBack];
                                if(typeof func === "function") {
                                    func(resBody, e);
                                }
                            } else {
                                if (resBody.code === gva_com_STATUS_ERROR) {
                                    gfn_alert(resBody.message);
                                } else if ((resBody.code === gva_com_STATUS_SUCCESS) && (isShowMeg === true)) {
                                    gfn_alert(resBody.message);
                                }
                            }
                        },
        error         : function(e) {
                            //공통에러처리
                            gfn_ajax_errorHandler(e);
                            
                            if(errorCallBack != "") {
                                var func = window.scwin[errorCallBack];
                                if(typeof func === "function") {
                                    func(resBody, e);
                                }
                            }
                        }
    };
    
    try {
        WebSquare.net.ajax(ajaxOptions);
        return resBody;
    } catch(e) { 
    } finally {
        AjaxCallptions = null;
        resBody = null;
    }
    
    if (top.clearTimeChecker == "function") top.clearTimeChecker();
};

/**
 * 서버 통신 과정에서 에러가 발생할 경우 에러 메시지를 출력한다.
 */
function gfn_ajax_errorHandler(e) {
    /* 공통에러 처리 필요. */
    var msg = e.responseBody;
    if (msg.indexOf("text/") >= 0) {
        msg = msg.replace("text/", "");
    }
    gfn_alert("서버통신 중 에러가 발생하였습니다 (" + msg + ")");
};

/* ==========================================================================================
 * 해당 프로젝트에서 새로 만든 메소드들을 정의한다.
 * ========================================================================================== */
