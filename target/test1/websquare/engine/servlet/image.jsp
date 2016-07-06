<%@ page contentType="charset=UTF-8" language="java" import="java.io.*,java.text.*,java.util.*,java.net.*"%><%!
	private static Hashtable cacheInfo = new Hashtable();
	private class CacheEntity {
		String name;
		String lastModified;
		String expires;
		String eTag;
	}
%><%
	String name = null;
	String hostUrl = null;
	String urlString = null;
	InputStream  is = null;
	OutputStream os = null;

	try {
		name = request.getParameter("url");
    	hostUrl = request.getParameter("hostUrl");
		String eTag = request.getHeader("If-None-Match");
		String ifModified = request.getHeader("If-Modified-Since");
		if( name != null && ifModified != null && eTag != null ) {
			try {
				CacheEntity cache = (CacheEntity)cacheInfo.get( name );
				if( cache != null && ifModified.equals( cache.lastModified ) ) {
					//System.out.println( "SEND 304 " + name + "  " + eTag + "  " + ifModified );
					response.setHeader("Expires", cache.expires );
					response.setHeader("Last-Modified",	cache.lastModified );
					response.setHeader("ETag", cache.eTag );
					response.setStatus(HttpServletResponse.SC_NOT_MODIFIED);
					return;
				}
			} catch( Exception pe ) {
				System.err.println("Header�� If-Modified-Since �׸��� Ȯ���ϴµ� �����߽��ϴ�. �� ������ �����ϼŵ� �˴ϴ�.");
				pe.printStackTrace();
			}
		}

		CacheEntity cache = new CacheEntity ();
		cache.name = name;
		SimpleDateFormat formatter = new SimpleDateFormat( "EEE, dd MMM yyyy HH:mm:ss z", Locale.US );
		formatter.setTimeZone(TimeZone.getTimeZone("GMT"));
		
		if(hostUrl == null) {
		    urlString = "http://" + request.getServerName() + ":" + request.getServerPort() + name;
	    } else {
	        urlString = "http://" + hostUrl + name;
	    }

//		�������� �������Ͽ��� �о�´�. �⺻���� ������ + 1�� - 1�Ϸ�{HTTP 1.1�� Never Expired) �����Ѵ�. (�� ���� �����Ǿ�� ������ ��û�� ������ �ʴ´�.)
		Calendar cal = Calendar.getInstance();
		cal.add( Calendar.YEAR, 1 );
		cache.expires = formatter.format( cal.getTime() );


		URL url = new URL(urlString);
		URLConnection conn = url.openConnection();
		
		is = conn.getInputStream();

		cache.eTag = conn.getHeaderField("ETag");
		cache.lastModified = formatter.format( new Date( conn.getLastModified() ) );

		response.setHeader("Expires", cache.expires );
		response.setHeader("ETag", cache.eTag );
		response.setHeader("Last-Modified",	cache.lastModified );		// �� ���� �����Ǿ� ������ �̹��������� ��� Local Cache��ȸ�� ���� �ʴ´�.

//		response.setHeader("Expires",	"Thu, 22 Jan 2009 00:00:00 GMT" );
//		response.setHeader("Last-Modified",	"Sun, 16 Dec 2007 11:56:02 GMT");		// �� ���� �����Ǿ� ������ �̹��������� ��� Local Cache��ȸ�� ���� �ʴ´�.
//		������ ������ ���������� üũ�� �� ����ϴ� ������ �����ϸ鼭 ������ ���� ����������. ������ ����Ǳ� ������ ����� �ʿ䰡 ����.
//		response.setHeader("ETag", "FFFFEDFFFF" );
//		���� ���� �������� ��������� �����´�. (Class���� �о���� �����̱� ������ ����� �Ұ�����)
//		if( entity.getBuildDate() != null ) {
//			response.setHeader("Last-Modified",	entity.getBuildDate());
//		}

		os = response.getOutputStream();

		response.setContentType(conn.getContentType());
//		if( name.endsWith(".gif") ) {
//			response.setContentType("image/gif");
//		} else if( name.endsWith(".jpg") ) {
//			response.setContentType("image/jpg");
//		} else if( name.endsWith(".png") ) {
//			response.setContentType("image/png");
//		} else {
//			response.setContentType("image/gif");
//		}
		
		int length = 0;
		byte buffer[] = new byte[2048];
		while ((length = is.read(buffer)) != -1) {
			os.write(buffer,0,length);
		}
		
		cacheInfo.put( name, cache );
	} catch (Exception e) {
		return;
	} finally {
		try {
			is.close();
		} catch( Exception e ) {}
		try {
			os.flush();
		} catch( Exception e ) {}
		try {
			os.close();
		} catch( Exception e ) {}
	}
%>