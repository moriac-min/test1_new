/**
 * @target XML 데이터 처리 관련 함수
 */
var WebSquare_js = {}; // This is WebSquare JavaScript Marker. Do not remove this line.

/**
 * XML Document 객체인지 여부를 검사한다.
 * 
 * @param <Object> Object
 * @returns
 */
function gfn_xml_isXmlCoc(data) {
    if (typeof data != 'object')
        return false;
    if ((typeof data.documentElement != 'undefined' && data.nodeType == 9) || (typeof data.documentElement == 'undefined' && data.nodeType == 1)) {
        return true;
    }
    return false;
};

/**
 * XML 객체를 문자열로 변환해서 반환한다.
 * 
 * @param paramXml : xml
 * @param node : xpaht
 * @return String
 * @example gfn_xml_getString( paramXml,"P_ENGG_NO" )
 */
function gfn_xml_getString(paramXml, node) {
    var retValue = "";
    try {
        retValue = WebSquare.xml.getString(paramXml, node);
    } catch (e) {
    }
    return retValue;
};

/* ==========================================================================================
 * 해당 프로젝트에서 새로 만든 메소드들을 정의한다.
 * ========================================================================================== */