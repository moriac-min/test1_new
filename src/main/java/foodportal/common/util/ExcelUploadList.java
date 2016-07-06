package foodportal.common.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import foodportal.common.util.StringUtil;

/**
 * ExcelUploadList
 * @author 박재형
 * @since 2014.08.27
 * @version 1.0
 * @see
 *
 * <pre>
 *  Modification Information
 *  수정일      수정자   수정내용
 *  ---------- -------- ---------------------------
 *  2014.08.27 박재형 최초 생성
 * </pre>
 *
 * Copyright (C) 2014 by NDS., All right reserved.
 */
public final class ExcelUploadList {
	//공통 로직 파일업로드 부분.
	public static List fileupload(MultipartHttpServletRequest request, int sheetNum) throws Exception {
		List<HashMap> resultList = new ArrayList();
		File xlsPath = null;//사용될 파일
        File loadFile = null;//사용될 파일2
        MultipartFile[] files = null;
        FileInputStream file = null;
		//여러개의 파일을 받을 수 있게 ArrayList형식을 썼다.
        ArrayList<MultipartFile> l = new ArrayList<MultipartFile>();
        
        try {
            Iterator<String> fileNames = request.getFileNames();
            MultipartFile multiFile = null; 
            
            while (fileNames.hasNext()) {
                String tmpName = fileNames.next();
                List<MultipartFile> fileList = request.getFiles(tmpName);
                multiFile = request.getFile(tmpName);
                
                for (MultipartFile f : fileList){
                    if (!f.isEmpty()){
                        l.add(f);
                    }   //if
                }   //for
                
            }   //while
            
            //이름 및 확장자를 가져온다.
            String filename = multiFile.getOriginalFilename();
            String extension = filename.substring(filename.lastIndexOf(".") + 1, filename.length());
            
            files = l.toArray(new MultipartFile[l.size()]);
//            xlsPath = new File(request.getSession().getServletContext().getRealPath(path));
            
//            if(!xlsPath.isDirectory()){//만약 디렉토리가 아니라면,isDirectory()메소드를 통해 디렉토리인지 확인가능하며, 디렉토리일 경우 list(),listFiles()를 통해 하위 파일들을 획득가능합니다.
//                xlsPath.mkdirs();//만들고자 하는 디렉토리의 상위 디렉토리가 존재하지 않을 경우, 상위 디렉토리까지 생성
//            }
            
//            loadFile = new File(request.getSession().getServletContext().getRealPath(path+fileNm));//파일의 이름을 지정해주고,
            loadFile = File.createTempFile("tmpWork", null);
            files[0].transferTo(loadFile);//파일을 저장한다.
            file = new FileInputStream(loadFile);
            
            if("xls".equals(extension)){
            	resultList = xlsupload(file,loadFile, sheetNum);
//            }else if("csv".equals(extension)){
//            	resultList = csvupload(file,loadFile, sheetNum);
            }else if("xlsx".equals(extension)){
            	resultList = xlsxupload(file,loadFile, sheetNum);
            }
            
        } catch (Exception e) {
        } finally{
            loadFile.delete();
        }
        
		return resultList;
	}

	//xlsx업로드
	public static List xlsxupload(FileInputStream file, File loadFile, int sheetNum) throws Exception {
		List<HashMap> list = new ArrayList();
		XSSFWorkbook xb = new XSSFWorkbook(file);
		XSSFSheet sheet;//시트선언
		sheet = xb.getSheetAt(sheetNum); // //1번째 시트를 가져오고.
		
		if(sheet != null){
            for (int i = 1; i <= sheet.getLastRowNum(); i++) { // 0부터 시트의 마지막 행의값만큼 반복(즉 전체의값)
                XSSFRow row = sheet.getRow(i); // row 가져오기
                if (row != null) {
                    HashMap rowMap = new HashMap();
                    for (int j = 0; j <= row.getLastCellNum(); j++) { // cell
                        XSSFCell cell = row.getCell(j); // cell 가져오기
                            if (cell != null) { 
                            	String value = null;
                                long lValue = 0;
                                switch (cell.getCellType()) { // cell 타입에 따른 데이타 저장
                                case XSSFCell.CELL_TYPE_FORMULA:
                                    value = cell.getCellFormula();//수식을 가져오므로 문제가 생긴다. 아래 수식을 사용하면 문제가 안 생긴다
                                    //value = Double.toString(cell.getNumericCellValue());
                                    break;
                                case XSSFCell.CELL_TYPE_NUMERIC:
                                	double d = cell.getNumericCellValue();
                                	if (HSSFDateUtil.isCellDateFormatted(cell)) {
                                	    // format in form of YYYYMMDD
                                	    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd", java.util.Locale.KOREA);
                                	    String cellText = formatter.format(HSSFDateUtil.getJavaDate(d));
                                	    value = cellText;
                                	} else {
                                	    // 숫자일때는 값을 double로 받아오기 때문에 11.0이나 1.2312431E7로 표시됩니다.
                                	    // 숫자일때는 포멧을 정해서 값을 받아오면 됩니다.
                                	   DecimalFormat df = new DecimalFormat("#");
                                	   value= df.format(cell.getNumericCellValue());
                                	}
                                    break;
                                case XSSFCell.CELL_TYPE_STRING:
                                    value = "" + cell.getStringCellValue();
                                    break;
                                case XSSFCell.CELL_TYPE_BLANK:
                                    value = " ";
                                    break;
                                case XSSFCell.CELL_TYPE_ERROR:
                                    value = "" + cell.getErrorCellValue();
                                    break;
                                default:
                                }
    //                            System.out.println("★ [ row:" + i + ", column:" + j + "]=" + value + "--" + cell.getCellType());
                                rowMap.put("col_"+j, value.trim());
                            }else{
                                rowMap.put("col_"+j, " ");
                            }
                            
    //                        rowMap.put("id", i);
    //                        rowMap.put("chk_"+j, "0");
                    }
                    //전체 헤더의 숫자
                    XSSFRow headerRow = sheet.getRow(0); // row 가져오기
                    rowMap.put("totRow",+headerRow.getLastCellNum());
                    
                  //첫번째 두번째 세번째 셀 체크 후 공백이면 리스트에 추가안함
                    if(!"".equals(rowMap.get("col_0").toString().trim()) || !"".equals(rowMap.get("col_1").toString().trim()) || !"".equals(rowMap.get("col_2").toString().trim())){
                        list.add(rowMap);
                    }
                }
            }
		}
        
        file.close();
	    if(loadFile.isFile()){ 
	    	loadFile.delete();    
	    }
	    System.out.println("xlsx업로드 숫자:"+list.size());
		return list;
	}

	//xls업로드
	public static List xlsupload(FileInputStream file, File loadFile, int sheetNum) throws Exception {
		
	    List<HashMap> list = new ArrayList();
		POIFSFileSystem fs = new POIFSFileSystem(file);//파일을 들인다.
		HSSFWorkbook hb = new HSSFWorkbook(fs);//xls방식의 파일을 읽어들인다.
	    HSSFSheet sheet;//시트선언
	    sheet = hb.getSheetAt(sheetNum); // //1번째 시트를 가져오고.

	    if(sheet != null){
            for (int i = 1; i <= sheet.getLastRowNum(); i++) { // 0부터 시트의 마지막 행의값만큼 반복(즉 전체의값)
                HSSFRow row = sheet.getRow(i); // row 가져오기
                
                if (row != null) {
                    HashMap rowMap = new HashMap();
                    
                    for (int j = 0; j <= row.getLastCellNum(); j++) { // cell
                        HSSFCell cell = row.getCell(j); // cell 가져오기
                        
                            if (cell != null) { 
                            	String value = null;
                                long lValue = 0;
                                switch (cell.getCellType()) { // cell 타입에 따른 데이타 저장
                                case HSSFCell.CELL_TYPE_FORMULA:
                                    value = cell.getCellFormula();//수식을 가져오므로 문제가 생긴다. 아래 수식을 사용하면 문제가 안 생긴다
                                    //value = Double.toString(cell.getNumericCellValue());
                                    break;
                                case HSSFCell.CELL_TYPE_NUMERIC:
                                	double d = cell.getNumericCellValue();
                                	if (HSSFDateUtil.isCellDateFormatted(cell)) {
                                	    // format in form of YYYYMMDD
                                	    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd", java.util.Locale.KOREA);
                                	    String cellText = formatter.format(HSSFDateUtil.getJavaDate(d));
                                	    value = cellText;
                                	} else {
                                	    // 숫자일때는 값을 double로 받아오기 때문에 11.0이나 1.2312431E7로 표시됩니다.
                                	    // 숫자일때는 포멧을 정해서 값을 받아오면 됩니다.
                                	   DecimalFormat df = new DecimalFormat("#");
                                	   value= df.format(cell.getNumericCellValue());
                                	}
                                    break;
                                case HSSFCell.CELL_TYPE_STRING:
                                    value = "" + cell.getStringCellValue();
                                    break;
                                case HSSFCell.CELL_TYPE_BLANK:
                                    value = " ";
                                    break;
                                case HSSFCell.CELL_TYPE_ERROR:
                                    value = "" + cell.getErrorCellValue();
                                    break;
                                default:
                                }
//                                System.out.println("★ [ row:" + i + ", column:" + j + "]=" + value + "--" + cell.getCellType());
                                rowMap.put("col_"+j, value.trim());
                            }else{
                            	rowMap.put("col_"+j, " ");
                            }
    //                        rowMap.put("id", i);
    //                        rowMap.put("chk_"+j, "0");
                    }
                    
                    
                    
                    //전체 헤더의 숫자
                    HSSFRow headerRow = sheet.getRow(0); // row 가져오기
                    rowMap.put("totRow",+headerRow.getLastCellNum());
                    //첫번째 두번째 세번째 셀 체크 후 공백이면 리스트에 추가안함
                    if(!"".equals(StringUtil.NVLToSpace(rowMap.get("col_0").toString()).trim()) || !"".equals(StringUtil.NVLToSpace(rowMap.get("col_1").toString()).trim()) || !"".equals(StringUtil.NVLToSpace(rowMap.get("col_2").toString()).trim())){
                        list.add(rowMap);
                    }
                }
            }
	    }
        
        file.close();
	    if(loadFile.isFile()){ 
	    	loadFile.delete();    
	    }
	    
	    System.out.println("xls업로드 숫자:"+list.size());
		return list;
	}

	
	//csv파일을 엑셀로 만들어주는 과정
	public static List csvupload(FileInputStream file, File loadFile, int sheetNum) throws Exception {
		List<HashMap> list = new ArrayList();
		BufferedReader br = new BufferedReader(new InputStreamReader(file, "EUC-KR"));
	    String line;
	    String[] rows;
	    line = null;
	    br.readLine();//처음줄은 생략한다.
	    int id = 0;
	    while((line = br.readLine()) != null) { 
	        line = line.replaceAll("\"","");
	        rows = line.split(","); 
	        System.out.println(rows);
	        HashMap rowMap = new HashMap();
	        for(int i=0;i<rows.length;i++){
	            if(!"".equals(rows[i].toString().trim())){
	                rowMap.put("col_"+i, rows[i].trim());
	            }else{
	                rowMap.put("col_"+i, " ");
	            }
                rowMap.put("chk_"+i, "0");
	        }
	        rowMap.put("id", id);
	        id++;
	        //첫번째 두번째 세번째 셀 체크 후 공백이면 리스트에 추가안함
            if(!"".equals(rowMap.get("col_0").toString().trim()) || !"".equals(rowMap.get("col_1").toString().trim()) || !"".equals(rowMap.get("col_2").toString().trim())){
                list.add(rowMap);
            }
	    }
	    file.close();
	    br.close();
	    if(loadFile.isFile()){ 
	    	loadFile.delete();    
	    }
	    System.out.println("csv업로드 숫자:"+list.size());
		return list;
	}
}
