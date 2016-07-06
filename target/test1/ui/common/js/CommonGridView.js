/**
 * GridView의 데이터를 엑셀 파일로 다운로드한다.
 * 
 * @param grdViewObj 엑셀 파일로 다운로드 받을 GridView 객체
 * @param options JSON형태로 저장된 그리드의 엑셀 다운로드 옵션
 * | options.fileName         : [defalut: excel.xls] 다운로드하려는 파일의 이름
 * | options.sheetName        : [defalut: sheet] excel의 sheet의 이름
 * | options.type             : [defalut: 0] type이 0인 경우 실제 데이터 1인 경우 눈에 보이는 데이터를  2이면 들어가 있는 data 그대로(filter무시 expression 타입의 셀은 나오지 않음)
 * | options.removeColumns    : [defalut: 없음] 다운로드시 excel에서 삭제하려는 열의 번호(여러 개일 경우 ,로 구분)
 * | options.removeHeaderRows : [defalut: 없음] 다운로드시 excel에서 삭제하려는 Header의 row index(여러 개일 경우 ,로 구분)
 * | options.foldColumns      : [defalut: 없음] 다운로드시 excel에서 fold하려는 열의 번호(여러 개일 경우 ,로 구분)
 * | options.startRowIndex    : [defalut: 0] excel파일에서 그리드의 데이터가 시작되는 행의 번호(헤더 포함)
 * | options.startColumnIndex : [defalut: 0] excel파일에서 그리드의 데이터가 시작되는 열의 번호(헤더 포함)
 * | options.headerColor      : [defalut: #33CCCC] excel파일에서 그리드의 header부분의 색
 * | options.bodyColor        : [defalut: #FFFFFF] excel파일에서 그리드의 body부분의 색
 * | options.subTotalColor    : [defalut: #CCFFCC] excel파일에서 그리드의 subtotal부분의 색
 * | options.footerColor      : [defalut: #008000] excel파일에서 그리드의 footer부분의 색
 * | options.showProcess      : [defalut: true] 다운로드 시 프로세스 창을 보여줄지 여부
 * | options.massStorage      : [defalut: true] 대용량 다운로드 여부 (default는 true 이 옵션을 true로 하고 showConfirm을 false로 한 경우에 IE에서 신뢰할만한 사이트를 체크하는 옵션이 뜬다.)
 * | options.showConfirm      : [defalut: false] 다운로드 확인창을 띄울지 여부(옵션을 킨 경우 advancedExcelDownload를 호출후 사용자가 window의 버튼을 한번더 클릭해야 한다. massStorage는 자동으로 true가 된다)
 * | options.dataProvider     : [defalut: 없음] 대량데이터 처리 및 사용자 데이터를 가공할 수 있는 Provider Package
 * | options.providerRequestXml   : [defalut: 없음] Provider 내부에서 사용할 XML 문자열
 * | options.userDataXml      : [defalut: 없음] 사용자가 서버모듈 개발 시 필요한 데이터를 전송 할 수 있는 변수
 * | options.bodyWordwrap     : [defalut: false] 다운로드시 바디의 줄 바꿈 기능
 * | options.useEuroLocale    : [defalut: false] 다운로드시 유로화 처리 기능(,와 .이 반대인 경우처리)
 * | options.useHeader        : [defalut: true] 다운로드시 Header를 출력 할지 여부( "true"인경우 출력, "false"인경우 미출력)
 * | options.useSubTotal      : [defalut: false] 다운로드시 SubTotal을 출력 할지 여부( "true"인경우 출력, "false"인경우 미출력)
 * | options.useFooter        : [defalut: true] 다운로드시 Footer를 출력 할지 여부( "true"인경우 출력, "false"인경우 미출력)
 * | options.separator        : [defalut: ,] 다운로드시 서버로 데이터 전송할때, 데이터를 구분짓는 구분자, default는 comma(,)
 * | options.subTotalScale    : [defalut: -1] 다운로드시 subTotal 평균계산시 소수점 자리수를 지정
 * | options.subTotalRoundingMode  : [defalut: 없음] 다운로드시 subTotal 평균계산시 Round를 지정 한다. ("CEILING","FLOOR","HALF_UP")
 * | options.useStyle         : [defalut: false] 다운로드시 css를 제외한, style을 excel에도 적용할 지 여부 (배경색,폰트)
 * | options.printSet JSON형태로 저장된 Excel Print관련 설정
 * | options.printSet.fitToPage : [defalut: false] 엑셀 프린터 출력시 쪽맞춤 사용 유무 
 * | options.printSet.landScape : [defalut: false] 엑셀 프린터 출력시 가로 방향 출력 유무
 * | options.printSet.fitWidth  : [defalut: 1] 엑셀 프린터 출력시 용지너비
 * | options.printSet.fitHeigth : [defalut: 1] 엑셀 프린터 출력시 용지높이
 * | options.printSet.scale   : [defalut: 100] 엑셀 프린터 출력시 확대/축소 배율, scale을 사용할 경우 fitToPage는 false로 설정 해야 한다.
 * 
 * @param infoArr 그리드에 대한 내용을 추가로 다른 셀에 표현하는 경우 사용하는 배열
 * | infoArr.rowIndex         : 내용을 표시할 행번호  
 * | infoArr.colIndex         : 내용을 표시할 열번호
 * | infoArr.rowSpan          : 병합할 행의 수 
 * | infoArr.colSpan          : 병합할 열의 수
 * | infoArr.text             : 표시할 내용
 * | infoArr.textAlign        : 표시할 내용의 정렬 방법 (left, center, right)
 * | infoArr.fontSize         : font size 설정 ( ex) "20px" )
 * | infoArr.color            : font color 설정 ( ex) "red" )
 * | infoArr.fontWeight       : font weight 설정 ( ex) "bold" )
 * | infoArr.drawBorder       : cell의 border 지정 ( ex) true )
 * 
 * @example
 * var options = {
 *     fileName:           "user.xls", 
 *     type:               "1", 
 *     removeColumns:      "", 
 *     foldColumns:        "", 
 *     startRowIndex:      3, 
 *     startColumnIndex:   0, 
 *     headerColor:        "#DBEEF3", 
 *     footerColor:        "#92CDDC", 
 *     showProcess:        true, 
 *     dataProvider:       "",
 *     useStyle:           true
 * }; 
 *
 * var infoArr = []; 
 * var infoObj = {
 *     rowIndex:   1, 
 *     colIndex:   0, 
 *     rowSpan:    1, 
 *     colSpan:    3, 
 *     text:       "그리드 다운로드 샘플", 
 *     textAlign:  "left" 
 * }; 
 * infoArr.push(infoObj);
 */
function gfn_com_excelDownload(grdViewObj, options, infoArr) {
    grdViewObj.advancedExcelDownload(options, infoArr);
};

/**
 * GridView에 엑셀 파일 데이터 업로드한다.
 * 
 * @param grdViewObj 엑셀 파일의 데이터를 업로드할 GridView 객체
 * @param options JSON형태로 저장된 그리드의 엑셀 업로드 옵션
 * | options.type             : [defalut: 0] 1이면 엑셀 파일이 그리드의 보이는 결과로 만들어져있을때  0이면 엑셀 파일이 그리드의 실제 데이터로 구성되어있을때 
 * | options.sheetNo          : [defalut: 0] excel파일에서 그리드의 데이터가 있는 sheet번호
 * | options.startRowIndex    : [defalut: 0] excel파일에서 그리드의 데이터가 시작되는 행의 번호(헤더 포함)
 * | options.startColumnIndex : [defalut: 0] excel파일에서 그리드의 데이터가 시작되는 열의 번호
 * | options.headerExist      : [defalut: 0] excel파일에서 그리드의 데이터에 header가 있는지 여부(1이면 header 존재 0이면 없음)
 * | options.footerExist      : [defalut: 1] excel파일에서 그리드의 데이터에 footer가 있는지 여부(1이면 footer 존재 0이면 없음 기본값은 1 그리드에 footer가 없으면 적용되지 않음)
 * | options.append           : [defalut: 0] excel파일에서 가져온 데이터를 그리드에 append시킬지 여부(1이면 현재 그리드에 데이터를 추가로 넣어줌 0이면 현재 그리드의 데이터를 삭제하고 넣음)
 * | options.hidden           : [defalut: 0] 읽어들이려는 엑셀파일에 hidden column이 저장되어 있는지 여부를 설정하는 int형 숫자(0이면  엑셀파일에 hidden 데이터가 없으므로 그리드 hidden column에 빈 데이터를 삽입  1 : 엑셀파일에 hidden 데이터가 있으므로 엑셀 파일로부터 hidden 데이터를 삽입 ) 
 * | options.fillHidden       : [defalut: 0] Grid에 hiddenColumn에 빈 값을 넣을지를 결정하기 위한 int형 숫자(1이면 hidden Column에 빈 값을 저장하지 않음,0이면 hidden column이 저장되어있지 않은 Excel File이라 간주하고 hidden Column에 빈 값을 넣어줌)(hidden이 0인 경우에는 fillhidden은 영향을 끼치지 않음)    
 * | options.skipSpace        : [defalut: 0] 공백무시 여부(1이면 무시 0이면 포함)
 * | options.insertColumns    : radio, checkbox와 같은 컬럼을 엑셀에서 받아 오지 않고, 사용자 컬럼 설정 으로 업로드 ( 데이터 구조 : [ { columnIndex:1, columnValue:"1" } ] )    
 * | options.popupUrl         : 업로드시에 호출할 popup의 url
 * 
 * @example
 * var options = {};
 * options.headerExist ="1"; //헤더의 존재 여부 입니다.
 * options.startRowIndex = "3"; //excel파일에서 gird의 데이터가 시작되 row의 index입니다..(헤더 포함)
 * options.startColumnIndex = "0";  //excel파일에서 gird의 데이터가 시작되는 column의 index입니다.(헤더 포함)
 * options.sheetNo=0; //excel의 sheet번호입니다.
 * options.append ="0";  //append 여부입니다. 0이면 append하지 않고 새로 쓰고 1이면 그리드의 뒤쪽에 데이터를 추가로 붙여줍니다.
 * options.hidden ="1";  //1이면 그리드에서 엑셀 다운로드시에 hidden을 포함했다는 의미입니다. 즉 upload시에 그리드의 hidden Column에 값을 넣는다는 의미입니다.
 */
function gfn_com_excelUpload(grdViewObj, options) {
    grdViewObj.advancedExcelUpload(options); //엑셀 업로드를 시작합니다.
};

/**
 * GridView와 바인딩된 DataList 객체를 반환한다.
 * @param gridViewObj
 * @returns {Boolean}
 */
function gfn_com_getGridViewDataList(gridViewObj) {
    var dataListId = gridViewObj.getDataList();

    if (dataListId !== "") {
        var dataList = WebSquare.util.getComponentById(dataListId);
        if ((typeof dataList === "undefined") || (dataList === null)) {
            $w.log("DataList(" + dataListId + ")를 찾을 수 없습니다.");
            return null;
        } else {
            return dataList;
        }
    } else {
        $w.log(grd_Code.getID() + "는 DataList가 세팅되어 있지 않습니다.");
        return null;
    } 
};

/**
 * GridView 업데이트 이전 상태로 RollBack한다.
 * @param gridViewObj GridView 객체
 * @param rowIndex RollBack 후에 포커스를 이동할 Row Index
 * @param rowCol RollBack 후에 포커스를 이동할 Column Index or Column Id
 * @param chkHeaderId RollBack 후에 GridView Header에 Uncheck할 CheckBox Id
 * @example gfn_com_rollbackGridView(grd_Code);
 *          gfn_com_rollbackGridView(grd_Code, 0, "grp_cd", "chkHeader");
 */
function gfn_com_rollbackGridView(gridViewObj, rowIndex, column, chkHeaderId) {
    try {
        if ((typeof gridViewObj === "object") && (typeof gridViewObj.getPluginName === "function") && (gridViewObj.getPluginName() === "gridView")) {
            var dltObj = gfn_com_getGridViewDataList(gridViewObj);
            if (dltObj === null) {
                return;
            }
            
            dltObj.removeRows(dltObj.getInsertedIndex());
            dltObj.removeRows(dltObj.getRowIndexByStatus("V"));
            dltObj.undoAll();
            
            if ((typeof rowIndex !== "undefined") && (typeof column !== "undefined")) {
                gridViewObj.setFocusedCell(rowIndex, column);
            }
            if (typeof chkHeaderId !== "undefined") {
                gridViewObj.setHeaderValue("chkHeader", "0");
            }
        }
    } catch(e) { 
    } finally {
        dltObj = null;
    }
};

/**
 * GridView의 행을 삭제한다.
 * @param gridViewObj
 * @description
 * - GridView의 행 삭제를 위한 checkBox 컬럼의 아이디를 "chk"로 하고 값은 1: checked, 0: unchecked로 설정해야 한다.
 */
function gfn_com_removeGridView(gridViewObj) {

    try {
        if ((typeof gridViewObj === "object") && (typeof gridViewObj.getPluginName === "function") && (gridViewObj.getPluginName() === "gridView")) {
            var dltObj = gfn_com_getGridViewDataList(gridViewObj);
            if (dltObj === null) {
                return;
            }
            
            var checkedIdxArr = dltObj.getMatchedIndex("chk", "1", true, 0, dltObj.getRowCount());
            if (checkedIdxArr.length > 0) {
                for (var i = 0; i < checkedIdxArr.length; i++) {
                    dltObj.deleteRow(checkedIdxArr[i]);
                }
            } else {
                dltObj.deleteRow(gridViewObj.getFocusedRowIndex());
            }
        }
    } catch(e) { 
    } finally {
        dltObj = null;
    }
};

/**
 * 공통 코드 DataList를 생성한다.
 */
gfn_com_createCodeDataList = function () {
    var option = {"id" :"dlt_Code" ,
                  "type" : "dataList" ,
                  "option":{ "baseNode": "list", "repeatNode": "map"},
                  "columnInfo":[{"id":"grp_cd", "name":"코드그룹", "dataType":"text"},
                                {"id":"com_cd", "name":"코드", "dataType":"text"},
                                {"id":"code_nm", "name":"코드명", "dataType":"text"}]
                 };

    $w.data.create(option);
    
    var codeJson = WebSquare.session.getAttribute("code");
    dlt_Code.setJSON(codeJson);
};

/**
 * 공통코드 LinkedDataList를 생성한다.
 */
gfn_com_createCodeLinkedDataList  = function (filterCond) {
    for ( var i = 0 ; i < filterCond.length ; i++) {
        var condVal = filterCond[i].substring(9);
        var option = {"id" :filterCond[i] ,
                      "type" : "linkedDataList" ,
                      "option" : { "valueAttribute" : "",
                                   "bind" : "dlt_Code", "filterCondition" : "grp_cd == '" + condVal + "'", "sortCondition": ""}
                     };
       $w.data.create(option);
    }
};

/**
 * 설명 : GridView Column Filter걸기
 * 파라미터 : gridViewObj(GridView Object), colIdx(필터를 걸 컬럼리스트), keyValues(필터값), confition(필터방식:'and','or')
 */
function gfn_GridFilter(gridViewObj, colIdx, keyValues, condition)
{
	
	try{
		if(colIdx.length != keyValues.length)
		{
			alert("컬럼리스트 갯수와 키값리스트 갯수가 맞지 않습니다.");
			return;
		}
		gridViewObj.removeColumnFilterAll();
		
		for(var i = 0; i < colIdx.length; i++){
			gridViewObj.setColumnFilter( {type:"row", colIndex:colIdx[i], key:keyValues[i], condition:condition});
		}
	} catch(e)
	{
	}
}