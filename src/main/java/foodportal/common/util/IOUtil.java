package foodportal.common.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;
import java.sql.Clob;
import java.sql.Date;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import foodportal.front.common.vo.UploadFileVO;

/**
 * IOUtil
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
public class IOUtil {
    private static final Logger logger = LoggerFactory.getLogger(IOUtil.class);
    
    private static final byte[] binaryBuffer = new byte[32 * 1024];
    private static Boolean bufferInUse = Boolean.FALSE;
    
    public static String foodportalProps = "";	//프로퍼티
    protected static final String BaseFilePath = "BaseFilePath";	//파일경로
    protected static final String RepsImgFilePath = "RepsImgFilePath";	//파일경로
	protected static final String imagePath = "imagePath";				//대표이미지 논리 파일경로

    public static void main(String[] args) throws IOException {
    	IOUtil util = new IOUtil();
    	//String basePath = getBaseFilePath();
    	//Map<String, Object> map = uploadFile("C:/tempUpload/upload/", "test(2014.09.28).txt");
    	System.out.println("=====>"+"test(2014.09.28).txt".substring("test(2014.09.28).txt".lastIndexOf(".")+1, "test(2014.09.28).txt".length()));
    	
    	System.out.println("==========111========>"+"test(2014.09.28).txt".split("\\.")[1].toString());
    }
    
    public IOUtil(){
    	String tmpPath = this.getClass().getResource("").getPath();
    	foodportalProps = tmpPath.substring(0, tmpPath.indexOf("/foodportal/"))+"/foodportal/conf/foodportal.properties";	//프로퍼티
    }
    
    /**
     * 입력, 출력간 복사. 성능 향상을 위해 정적인 버퍼를 사용한다. 메모리를 할당하는 작업은
     * 상당히 느리기 때문이다.
     * <pre>
     *    FileInputStream fis = new FileInputStream(inputFilePath);
     *    FileOutputStream fos = new FileOutputStream(outputFilePath);
     *    Util.copyStreamFast(fis, fos); // 파일 내용 복사
     * </pre>
     * @param in
     * @param out
     * @throws IOException 
     * @see {@link http://java.sun.com/docs/books/performance/1st_edition/html/JPIOPerformance.fm.html }
     */
    public static void copyStreamFast(InputStream in, OutputStream out) throws IOException {
        byte[] buffer = null;

        for (;;) {
            synchronized (bufferInUse) {
                if (bufferInUse.booleanValue()) {
                    if (buffer == null)
                        buffer = new byte[16 * 1024];
                } else {
                    buffer = binaryBuffer;
                    bufferInUse = Boolean.TRUE;
                }
            }

            int nRead = in.read(buffer);
            if (nRead < 0)
                break;
            out.write(buffer, 0, nRead);

            if (buffer == binaryBuffer)
                bufferInUse = Boolean.FALSE;
        }
    }

    /**
     * 파일 이동. 파일 f를 새로운 경로 newPath로 이동한다
     * @param f
     * @param newPath
     * @throws IOException 
     */
    public static boolean moveFile(File f, File newPath) {

        // 일단 이동 명령으로 이동
        if (f.renameTo(newPath))
            return true;

        // 위 명령으로 안된 경우 "파일 복사 후 삭제"로 이동
        FileInputStream in = null;
        FileOutputStream out = null;

        try {
            in = new FileInputStream(f);
            out = new FileOutputStream(newPath);

            copyStreamFast(in, out);
            f.delete();
            
            in.close();
            out.close();
            
            return true;

        } catch (IOException e) {
            logger.warn(f + " 파일을 " + newPath
                    + "(으)로 이동하는 중 오류 발생", e);
            if (f.exists())
                return false;
            else
                return true;
        }
    }
    
    /**
     * 파일업로드 시작 
     * @param UploadFileVO
     * @return
     * @throws Exception 
     */
    public Map<String, Object> startUploadSingleFile(UploadFileVO fileVo) throws Exception{
    	Map<String, Object> returnMap = new HashMap<String, Object>();
    	
    	if(fileVo == null){
    		returnMap.put("result", "failed");
    		return returnMap;
    	}
    	
    	String preFilePath = fileVo.getFile_path();
    	String preFile = fileVo.getPhysic_file_nm()+"."+fileVo.getFile_type_cd();
    	
    	try {
    		if(StringUtil.NVLToSpace(fileVo.getRprsnt_img_yn()).equals("Y")){
    			returnMap = uploadFile(preFilePath, preFile, "Y");
    		}else{
    			returnMap = uploadFile(preFilePath, preFile, "N");
    		}
		} catch (Exception e) {
		}
    			
    	return returnMap;
    }
    
    /**
     * 파일 이동. 파일 f를 새로운 경로 newPath로 이동한다
     * @param f
     * @param newPath
     * @throws IOException 
     */
    public static Map<String, Object> uploadFile(String preFilePath, String preFile, String RepsImgYn) {
    	
    	Map<String, Object> returnMap = new HashMap<String, Object>();
    	
    	long time = 0;
    	SimpleDateFormat dayTime = null;
    	SimpleDateFormat day = null;
    	String strNewFileName = null;
    	
    	boolean result = false;
    	
    	String postFilePath = "";	//저장될경로
		String postImgPath = "";	//저장될 대표이미지 논리 파일경로
    	
		try {
			postFilePath = getBaseFilePath(RepsImgYn);
		} catch (IOException e2) {
		}
    	
//		System.out.println("===preFilePath===>"+preFilePath);
//		System.out.println("===preFile===>"+preFile);
    	
    	File oldFile = null;
    	File newFile = null;
    	
    	
    	try {
    		oldFile = new File(preFilePath+"/"+preFile);
    		
//    		System.out.println("===oldFile.exists()===>"+oldFile.exists());
//    		System.out.println("===postFilePath===>"+postFilePath);
    		
    		if(!oldFile.exists() || "".equals(postFilePath.trim())){
    			returnMap.put("result", "failed");
    			return returnMap;
    		}
    		
    		time = System.currentTimeMillis();
			dayTime = new SimpleDateFormat("yyyyMMddhhmmss");
			strNewFileName = dayTime.format(new Date(time)).trim()+"_"+System.currentTimeMillis();
			
			
			day = new SimpleDateFormat("yyyyMMdd");
			
			postFilePath = postFilePath+day.format(new Date(time)).trim();	//저장폴더 ex) C:/foodPortal/upload/20140918 
			
			newFile = new File(postFilePath);
			
			if(!newFile.exists()){
				newFile.mkdirs();
			}
			
			String ext = preFile.substring(preFile.lastIndexOf(".")+1, preFile.length());
			newFile = new File(postFilePath+"/"+strNewFileName+"."+ext);
			
			// 일단 이동 명령으로 이동
			oldFile.renameTo(newFile);
			
			result = true;
			
		} catch (Exception e1) {
			result = false;
		}
    	
//    	System.out.println("==========222====="+result);
    	
    	if(!result){
	        // 위 명령으로 안된 경우 "파일 복사 후 삭제"로 이동
	        FileInputStream in = null;
	        FileOutputStream out = null;
	
	        try {
	            in = new FileInputStream(oldFile);
	            out = new FileOutputStream(newFile);
	
	            copyStreamFast(in, out);
	            
	            in.close();
	            out.close();
	            
	            result = true;
	
	        } catch (IOException e) {
	            logger.warn(oldFile + " 파일을 " + newFile
	                    + "(으)로 이동하는 중 오류 발생", e);
	            result = false;
	        }
    	}
    	
//    	System.out.println("====result===>"+result);
    	
    	if(result){
    		
    		//대표이미지업로드일경우
			if("Y".equals(RepsImgYn)){
				try {
					postImgPath = getProperty(imagePath)+day.format(new Date(time)).trim();
					postFilePath = postImgPath;
				} catch (IOException e) {
				}
			}

    		returnMap.put("result", "succeed");
			returnMap.put("realPath", postFilePath);
			returnMap.put("realName", newFile.getName());
	    	
			if(newFile.exists()){
				oldFile.delete();
			}
    	}else{
    		returnMap.put("result", "failed");
    	}
    	
        return returnMap;
    }
    
    private static final char[] charBuffer = new char[4096];

    /**
     * Clob 개체에서 문자열을 읽는다. JDBC 드라이버만 맞다면 Oracle 등 임의의
     * 데이터베이스에서 사용할 수 있다.
     * <pre>
     *    String sql = "select clob_col from my_table where pk=?";
     *    PreparedStatement ps = conn.prepareStatement(sql);
     *    ps.setObject(1, pk);
     *  
     *    ResultSet rs = ps.executeQuery();
     *    String clobContent = rs.next() ? Util.readClob(rs.getClob(1)) : "";
     *    
     *    rs.close();
     *    ps.close();
     *</pre>
     * @param clob
     * @return
     * @throws SQLException
     */
    public static String readClob(Clob clob) throws SQLException {
        int size = (int)clob.length();
        char[] buffer = new char[size];
        int read = 0;
        int offset = 0;
        Reader r = clob.getCharacterStream();

        try {
            for (;;) {
                read = r.read(buffer, offset, size - offset);
                if (read >= size - offset || read < 0)
                    break;
                offset += read;
            }

            r.close();

            return new String(buffer);

        } catch (IOException e) {
            throw new SQLException(e.getLocalizedMessage());
        }
    }

    /**
     * Clob 개체에 문자열을 쓴다. JDBC 드라이버만 맞다면 Oracle 등 임의의
     * 데이터베이스에서 사용할 수 있으며 내부적으로 성능 향상을 꾀했다.
     * <pre>
     *    String sql = "select clob_col from my_table where pk=?";
     *    PreparedStatement ps = conn.prepareStatement(sql);
     *    ps.setObject(1, pk);
     *  
     *    ResultSet rs = ps.executeQuery();
     *  
     *    if (rs.next())
     *        try {
     *            Util.writeClob(rs.getClob(1), clobContent);
     *        } catch (SQLException e) {
     *            e.printStacktrace();
     *        }
     *    }
     *    
     *    rs.close();
     *    ps.close();
     *</pre>
     * @param clob
     * @param s
     * @throws SQLException
     * @see {@link http://java.sun.com/docs/books/performance/1st_edition/html/JPIOPerformance.fm.html }
     */
    public static void writeClob(Clob clob, String s) throws SQLException {
        Writer w = clob.setCharacterStream(1);
        int idx = 0;

        try {
            for (;;) {
                synchronized (charBuffer) {
                    int nextIdx = idx + charBuffer.length < s.length() ? idx + charBuffer.length : s.length();
                    s.getChars(idx, nextIdx, charBuffer, 0);
                    w.write(charBuffer, 0, nextIdx - idx);

                    if (nextIdx >= s.length())
                        break;
                    idx = nextIdx;
                }
            }

            w.close();

        } catch (IOException e) {
            throw new SQLException(e.getLocalizedMessage());
        }
    }
    
    public static String getBaseFilePath(String RepsImgYn) throws IOException {
    	String str = "";
    	
		try {
			if("Y".equals(RepsImgYn)){
				str = getProperty(RepsImgFilePath);
			}else{
				str = getProperty(BaseFilePath);
			}
		} catch (Exception e) {
		} 
		
    	return str;
    }
    
    /**
	 * 프로퍼티를 가져온다
	 * @param prop
	 * @return
	 * @throws IOException
	 */
    public static String getProperty(String prop) throws IOException {
    	String returnStr = "";
    	
    	IOUtil  util = new IOUtil();
    	
		try {
			Properties props = readProperties(foodportalProps);
			returnStr = (props.getProperty(prop));
		} catch (Exception e) {
		} finally {
			if(util != null){
				util = null;
			}
		}
		
		return returnStr;
	}
	
	/**
	 * file parameter로 부터 프로퍼티를 읽어온다.
	 * @param file
	 * @return
	 * @throws IOException
	 */
    public synchronized static Properties readProperties(String file) throws IOException {
		Properties tempProperties = new Properties();
		
		try {
			FileInputStream in = new FileInputStream(file);
			tempProperties.load(in);
		} catch (Exception e) {
		}
		
		return tempProperties;
	}
	
}
