<%@ page contentType="text/xml; charset=UTF-8" language="java" errorPage="" import="java.io.*,java.math.*,java.net.*,java.security.*,java.text.*,java.util.*,java.util.zip.*,javax.servlet.http.*,org.w3c.dom.*,websquare.i18n.*,websquare.logging.*,websquare.util.*"
%><%
HTTPContext frameworkContext = null;
try {
	frameworkContext = HTTPContext.getContext();
	frameworkContext.setWebInfo(request, response, null, null );
	
	String w2xPath = HttpUtil.getParameter( request, "w2xPath" );
	String result= Web2FileCache.getInstance().getXML(request);
	if ( w2xPath != null && !w2xPath.equals("") && result != null && !result.equals("") ) {		
		OutputStream os = null;
		try {
			byte[] bytes = result.getBytes("UTF-8");
			MessageDigest md = null;
			try {
				md = MessageDigest.getInstance("SHA");
				byte[] messageDigest = md.digest(bytes);
				BigInteger number = new BigInteger(1, messageDigest);
				StringBuffer sb = new StringBuffer('0');
				sb.append("\"");
				sb.append(number.toString(16));
				sb.append("\"");
				String ETAG = sb.toString();
				String previousETAG = request.getHeader("If-None-Match");

				if (previousETAG != null && ETAG != null) {
					if (ETAG.equals(previousETAG)) {
						response.setStatus(HttpServletResponse.SC_NOT_MODIFIED);
						return;
					}
				}
				response.setHeader("ETag", sb.toString() );
			} catch (Exception e) {
				e.printStackTrace();
			}

			boolean compressed = true;
			String ae = request.getHeader("Accept-Encoding");
			if (ae != null && ae.indexOf("gzip") != -1) { // 압축 가능 여부 판단
				compressed = true;
			}

			if (compressed) {
				ByteArrayOutputStream byteOut = new ByteArrayOutputStream();
				OutputStream zipOut = new GZIPOutputStream(byteOut);
				zipOut.write(bytes, 0, bytes.length);
				zipOut.flush();
				zipOut.close();
				byteOut.flush();
				bytes = byteOut.toByteArray();
				response.setHeader("Content-Encoding", "gzip");
			}
	
			SimpleDateFormat formatter = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss z", Locale.US);
			Calendar cal = Calendar.getInstance();
			cal.add(Calendar.YEAR, 1);
			cal.add(Calendar.DATE, -1);
			formatter.setTimeZone(TimeZone.getTimeZone("GMT"));
			String expires = formatter.format(cal.getTime());
			response.setHeader("Expires", expires);
			response.setHeader("Last-Modified", expires);
			response.setHeader("Cache-Control", "public, max-age=31449600");	// 31449600

			response.setContentLength(bytes.length);
			os = response.getOutputStream();
			os.write(bytes,0,bytes.length);
		} catch (Exception e) {
			throw e;
		} finally {
			try {
				os.flush();
			} catch( Exception e ) {}
			try {
				os.close();
			} catch( Exception e ) {}
		}
	} else {
		response.setStatus(HttpServletResponse.SC_NOT_FOUND);
		return;
	}
} catch (FileNotFoundException e1) {
	e1.printStackTrace();
} catch( Exception e) {
	e.printStackTrace();
} finally {
	frameworkContext.setWebInfo(null,null,null,null);
}
%>