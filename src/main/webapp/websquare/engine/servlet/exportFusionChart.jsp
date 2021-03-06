<%@ page contentType="application/download;charset=UTF-8" import=
"java.io.*,
org.apache.batik.transcoder.image.JPEGTranscoder,
org.apache.batik.transcoder.image.PNGTranscoder,
org.apache.batik.transcoder.TranscoderInput,
org.apache.batik.transcoder.TranscoderOutput,
java.net.*,
java.awt.Color,
org.apache.fop.svg.PDFTranscoder,
java.lang.String,
javax.servlet.http.*,
websquare.util.*,
websquare.logging.util.*,
websquare.system.*,
websquare.*"%>
<%

    //  주의사항 batik svg 라이브러리로 jpg,png export시 jdk 1.7을 사용할 경우           
    //  chart svg의 text anti-aliasing이 깨져서 export되니 1.6 이나 1.5를 권장합니다.   
    //  batik 버그질라에 올라와 있으나 버그가 fixed되지 않았습니다.
    //  https://issues.apache.org/jira/browse/BATIK-1027

    String WEBSQUARE_HOME = System.getProperty("WEBSQUARE_HOME");
    long currentMillis = System.currentTimeMillis();
    java.util.Random rand = new java.util.Random(currentMillis);
    String path = WEBSQUARE_HOME+"/temp/";

    String svgStr = request.getParameter("xmlValue");
    svgStr = URLDecoder.decode(svgStr,"UTF-8");
    String[] str = svgStr.split("ExportType=");
    svgStr = str[0];
    //System.out.print(svgStr);

    String type_str = str[1];
    String[] typeArr = type_str.split("ExportFileName=");
    String type = typeArr[0];

    String fileName_str = typeArr[1];
    String fileName = fileName_str+"."+type;
    String tempFileName =  currentMillis + "_" + rand.nextInt(100);

    //System.out.print(svgStr);

    StringReader svgString = new StringReader(svgStr);
    String ext = "application/download";

    if(type.equals("jpg")){
        ext = "image/jpeg";
    } else if(type.equals("png")){
        ext = "image/png";
    } else if(type.equals("pdf")){
        ext = "application/pdf";
    }

    response.setContentType(ext);
    response.setHeader("Content-Disposition", "attachment;filename="+fileName+";");

    try{
        if(type.equals("jpg")|| type.equals("jpeg")){
            JPEGTranscoder jpg_t = new JPEGTranscoder();
            jpg_t.addTranscodingHint(JPEGTranscoder.KEY_QUALITY,new Float(.95));

            TranscoderInput input = new TranscoderInput(svgString);

            File temp = new File(path);
            if(!temp.exists()){
                temp.mkdirs();
            }

            OutputStream ostream = new FileOutputStream(path+tempFileName+".jpg");
            TranscoderOutput output = new TranscoderOutput(ostream);

            jpg_t.transcode(input, output);

            ostream.flush();
            ostream.close();

            try{
                ServletOutputStream sos = response.getOutputStream();
                String fiilePathAndName = path+tempFileName+".jpg";
                File file = new File(fiilePathAndName);
                byte[] data = new byte[1024];
                FileInputStream fis = new FileInputStream(file);
                int count = 0;

                while((count = fis.read(data)) != -1){
                    sos.write(data,0,count);
                    sos.flush();
                }
                if(fis != null) fis.close();
                if(sos != null) sos.close();

            }catch(Exception e){
                System.out.println("download error : " + e);
            }   
            out.clear();
            out = pageContext.pushBody();
        } else if (type.equals("png")){

            PNGTranscoder png_t = new PNGTranscoder();
            // Set the transcoding hints.
            png_t.addTranscodingHint(PNGTranscoder.KEY_BACKGROUND_COLOR, Color.WHITE);
            TranscoderInput input2 = new TranscoderInput(svgString);
            // Create the transcoder output.
            File temp = new File(path);
            if(!temp.exists()){
                temp.mkdirs();
            }

            OutputStream ostream2 = new FileOutputStream(path+tempFileName+".png");
            TranscoderOutput output2 = new TranscoderOutput(ostream2);
            // Save the image.
            png_t.transcode(input2, output2);
            ostream2.flush();
            ostream2.close();

            try{
                
                ServletOutputStream sos = response.getOutputStream();
                String fiilePathAndName = path+tempFileName+".png";
                File file = new File(fiilePathAndName);
                byte[] data = new byte[1024];
                FileInputStream fis = new FileInputStream(file);
                int count = 0;

                while((count = fis.read(data)) != -1){
                    sos.write(data,0,count);
                    sos.flush();
                }
                if(fis != null) fis.close();
                if(sos != null) sos.close();

            }catch(Exception e){
                System.out.println("download error : " + e);
            }
            out.clear();
            out = pageContext.pushBody();
        } else if (type.equals("pdf")){

            PDFTranscoder pdf_t = new PDFTranscoder();
            // Set the transcoding hints.
            TranscoderInput input3 = new TranscoderInput(svgString);
            // Create the transcoder output.
            File temp = new File(path);
            if(!temp.exists()){
                temp.mkdirs();
            }

            OutputStream ostream3 = new FileOutputStream(path+tempFileName+".pdf");
            TranscoderOutput output3 = new TranscoderOutput(ostream3);
            // Save the image.
            pdf_t.transcode(input3, output3);
            ostream3.flush();
            ostream3.close();

            try{
                ServletOutputStream sos = response.getOutputStream();
                String fiilePathAndName = path+tempFileName+".pdf";
                File file = new File(fiilePathAndName);
                byte[] data = new byte[1024];
                FileInputStream fis = new FileInputStream(file);
                int count = 0;

                while((count = fis.read(data)) != -1){
                    sos.write(data,0,count);
                    sos.flush();
                }
                if(fis != null) fis.close();
                if(sos != null) sos.close();

            }catch(Exception e){
                System.out.println("download error : " + e);
            }
            out.clear();
            out = pageContext.pushBody();
        }
    }catch(Exception e){
        e.printStackTrace();
    } finally {
    
        try {
            String deletePath = path + tempFileName + "." + type;
            //System.out.println(deletePath);
            File f = new File(deletePath);
            if( f.exists() ) {
                boolean ret = FileUtil.delete(f);
                if(! ret ) {
                    LogUtil.fine("[exportFusionChart.jsp]Couldn't delete file : " + deletePath);
                }
            }
        } catch (Exception ex) {
            LogUtil.exception("[exportFusionChart.jsp]delete fail!", ex);
        }
    } 
%>