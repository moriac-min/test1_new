/**
 * @target
 */
var CommonSession_js= {}; //This is WebSquare JavaScript Marker. Do not remove this line.

/**
 * 세션의 정보를 조회한다.
 */
function gfn_getSessionInfo(value) {
    var option = {
        action : "serviceId=CM0001&action=IN",
        mode : "synchronous"
    };
    var result = gfn_ajax_getAjaxRequest(option);

    var obj = JSON.parse(result);
    return obj;
};

