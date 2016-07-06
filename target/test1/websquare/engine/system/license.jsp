<%@ page pageEncoding="UTF-8" contentType="text/html;charset=UTF-8" %>
<%@ page import="java.io.*" %>
<%@ page import="java.util.*" %>
<%@ page import="websquare.*" %>
<%@ page import="websquare.system.license.manager.WebSquareLicense.*" %>
<%@ page import="websquare.system.license.manager.*" %>
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>

<head>
	<title>WebSquare 2.0 License Infomation</title>
	<style type="text/css">
	    /*<![CDATA[*/
			body {
				font-family:맑은 고딕,verdana,dotum;
			}
			.center {
				text-align: center;
			}
			.center table {
				margin-left: auto;
				margin-right: auto;
				text-align: left;
			}
			h1 {
				font-size:20px;
				font-weight:bold;
			}
			#license_table td {
				color:#950000;
			}
			#license_table td, #license_table th {
				padding:5px;
				font-size:12px;
				border-bottom: dotted 1px #333;
			}
			#license_table {
				border-collapse:collapse;
				background:#EFF4FB url(/websquare/engine/system/image/teaser.gif) repeat-x;
				border:1px solid #686868;
			}
			.header {
				background:#333 url(/websquare/engine/system/image/llsh.gif) repeat-x;
				color:#fff;
				font-weight:bold;
				font-size:14px;
				height:30px;
				margin:0;
				padding:2px;
			}
			#license_table .header th {
				padding:0 0 0 5px;
			}
			#footer th {
				background:#333 url(/websquare/engine/system/image/llsh.gif) repeat-x;
				text-align:right;
				height:24px;
				padding-right:10px;
				color:#fff;
				font-size:10px;
				margin:0;
				padding:2px;
			}
		/*]]>*/
	</style>
</head>
<%
	final class LicenseInfo extends SimpleSymmetricWebSquareLicense {
		private String customerName;
		private String hostName;
		private String ip;
		private int productID;
		private int cpuNumber;
		public LicenseInfo(String encLicenseString) throws InvalidLicenseException {
			super(encLicenseString);
			try{
				getLicenseInfo(encLicenseString);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		private final void getLicenseInfo(String licenseString) throws InvalidLicenseException {
			try {
				String clearLicense = decipherLicense(licenseString);
				StringTokenizer tok = new StringTokenizer(clearLicense, ":");
				
				tok.nextToken();
				tok.nextToken();
				customerName = tok.nextToken();
				tok.nextToken();
				hostName = tok.nextToken();
				ip = tok.nextToken();
				productID = Integer.parseInt(tok.nextToken());
				tok.nextToken();
				cpuNumber = Integer.parseInt(tok.nextToken());
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		public String getHostName() {
			return hostName;
		}

		public String getIP() {
			return ip;
		}

		public int getProductID() {
			return productID;
		}

		public int getCpuNumber() {
			return cpuNumber;
		}
		
		public String getCustomerName() {
			return customerName;
		}
	}
	
	LicenseInfo license = null;
	boolean isValid = false;
	String installArea = null;
	String path = null;
	
	try {
		WebSquareConfig conf = WebSquareConfig.getInstance();
		String allowedIP_str = conf.getStringValue( "//licenseInfoView/allowedIP/@value", "127.0.0.1" );
		String allowedIPs[] = allowedIP_str.split(" ");
		String ip = request.getRemoteAddr();
		int idx;
		for(idx = 0; idx < allowedIPs.length; idx++) {
			String allowedIP = allowedIPs[idx];
			int asterisk = allowedIP.indexOf("*");
			if(asterisk >= 0) {
				allowedIP = allowedIP.substring(0, asterisk);
				if(ip.startsWith(allowedIP))
					break;
			}
			int dash = allowedIP.indexOf("-");
			if(dash > 0) {
				int dot = allowedIP.lastIndexOf(".");
				int from = Integer.parseInt(allowedIP.substring(dot + 1, dash));
				int to = Integer.parseInt(allowedIP.substring(dash + 1, allowedIP.length()));
				allowedIP = allowedIP.substring(0, dot + 1);
				int lastNum = Integer.parseInt(ip.substring(ip.lastIndexOf(".") + 1, ip.length()));
				allowedIP_str = "'" + lastNum + "'";
				if(ip.startsWith(allowedIP) && from <= lastNum && lastNum <= to)
					break;
			}
			if(ip.equals(allowedIP))
				break;
		}
		if(idx == allowedIPs.length)
			return;
		if (System.getProperty("WEBSQUARE_HOME") == null
				&& System.getProperty("osgi.install.area") != null) {
			System.setProperty(
				"WEBSQUARE_HOME", System.getProperty("osgi.install.area"));
		}
		
		installArea = System.getProperty("WEBSQUARE_HOME");
		path = installArea + File.separator	+ "license" + File.separator + "license";
		
		BufferedReader br = null;
		String strLicense = null; 
		try {
			br = new BufferedReader(new FileReader(path));
		
			char[] buffer = new char[256];
			while (true) {
				int readCount = br.read(buffer);
				if (readCount == -1) {
					break;
				}
				strLicense = new String(buffer, 0, readCount);
				break;
			}
		} finally {
			try {
				br.close();
			} catch (Exception ignored) {}
		}
		
		license = new LicenseInfo(strLicense);

		isValid = license.isValid();
	} catch(Exception e) {
		isValid = false;
	}
	
%>

<body>
	<div class="center">
		<table border="0" cellpadding="3" style="width:600px; height:50px;">
			<tr class="h">
				<td><a href="http://www.websquare.co.kr/"><img border="0" src="/websquare/engine/system/image/logo.png" alt="Websquare" /></a></td>
			</tr>
		</table>        
		<table id="license_table" style="width:600px;">                 
			<%if(isValid) {%>
				<tr class="header"><th colspan="2" >라이센스 정보</th></tr>         
				<tr>
					<th width="30%" style="width:30%">License ID</th>
					<td width="70%" style="width:70%"><%=isValid ? String.valueOf(license.getLicenseID()) : ""%></td>
				</tr>
				<tr>
					<th>고객 ID</th>
					<td><%=isValid ? String.valueOf(license.getCustomerID()) : ""%></td>
				</tr>
				<tr>
					<th>고객명</th>
					<td><%
						if(isValid) {
							String name = license.getCustomerName();
							if(name == "" || name == null || name.equals("null")) {
								out.println("<span style='font-style:italic;color:#444444;'>라이센스에 고객명이 등록되지 않았습니다.</span>");
							} else {
								out.println(name);
							}
						}
					%></td>
				</tr>
				<tr>
					<th>라이센스 종류</th>
					<td><%=isValid ? (license.getIsDemo().equals("true") ? new String("데모 라이센스") : new String("정식 라이센스")) : ""%></td>
				</tr>
				<tr>
					<th>Host Name</th>
					<td><%=isValid ? license.getHostName() : ""%></td>
				</tr>
				<tr>
					<th>IP 주소</th>
					<td><%=isValid ? license.getIP() : ""%></td>
				</tr>
				<tr>
					<th>제품 ID</th>
					<td><%=isValid ? String.valueOf(license.getProductID()) : ""%></td>
				</tr>
				<tr>
					<th>CPU</th>
					<td><%=isValid ? String.valueOf(license.getCpuNumber()) : ""%></td>
				</tr>
				<tr>
					<th>라이센스유효기간</th>
					<td><%
						if(isValid) {
							Date date = license.getExpiredDate();
							Calendar c = Calendar.getInstance();
							c.setTime(date);
							out.println(c.get(Calendar.YEAR) + "/" + (c.get(Calendar.MONTH) + 1) + "/" + c.get(Calendar.DAY_OF_MONTH));
						}
					%></td>
				</tr>
			<%}%>
			<tr class="header" >
				<th colspan="2">시스템정보</th>
			</tr>
			<tr>
				<th>WEBSQUARE_HOME</th>
				<td><%=installArea != null ? installArea : "WEBSQUARE_HOME이 정의되지 않았습니다."%></td>
			</tr>
			<tr>
				<th>라이센스 파일 경로</th>
				<td><%=path != null ? path : ""%></td>
			</tr>
			<tr>
				<th>Host Name</th>
				<td><%=SystemLicenseInfo.getHostname()%></td>
			</tr>
			<tr>
				<th>IP 주소</thd>
				<td><%
					String[] systemIPs = SystemLicenseInfo.getIPArray(); 
					for(int i = 0; i < systemIPs.length; i++) {
						String systemIP = systemIPs[i].replaceAll(":", "");
						if(i > 0)
							out.print(", ");
						out.print(systemIP);
					}
				%></td>
			</tr>
			<tr>
				<th>Remote IP</th>
				<td><%=request.getRemoteAddr()%></td>
			</tr>
			<tr>
				<th>CPU</th>
				<td><%=SystemLicenseInfo.getCpuNumber()%></td>
			</tr>
			<tr style="font-weight:bold;">
				<td colspan="2">
					<%=isValid ? "유효한 웹스퀘어 라이센스 키를 사용하고 있습니다." : "웹스퀘어 라이센스가 유효하지 않습니다."%>
				</td>
			</tr>
			<tr id="footer">
				<th colspan="2"><%
					Calendar presentDate = Calendar.getInstance();
					out.println(presentDate.get(Calendar.YEAR) + "/" + (presentDate.get(Calendar.MONTH) + 1) + "/" + presentDate.get(Calendar.DAY_OF_MONTH));
				%></th>
			</tr>                            
		</table>
	</div>
	
</body>

</html>