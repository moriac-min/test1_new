package common.commonfacillity.log;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.aspectj.lang.ProceedingJoinPoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StopWatch;

import common.commonfacillity.service.CommonFacillityService;
import common.commonfacillity.util.CommonSqlParser;
import common.commonfacillity.util.CommonStringUtil;
import common.commonfacillity.util.CommonUserVO;
import common.commonfacillity.util.CommonSessionUtil;

/**
 * @Class CommonLogManageAspect
 * @Description 시스템 로그 생성을 위한 ASPECT 클래스
 * @Modification Information
 * 
 * @author 김민규
 * @since 2012.07.18
 * @version
 * @see
 * 
 */
public class CommonLogManageAspect {

	@Autowired
	private CommonFacillityService commonFacillityService;
	
	@CommonLog Logger log;
	
//	protected final Logger log = LoggerFactory.getLogger(this.getClass());

	/**
	 * 시스템 로그정보를 생성한다. sevice Class의 insert로 시작되는 Method
	 * 
	 * @param ProceedingJoinPoint
	 * @return Object
	 * @throws Exception
	 */
	public Object logSave(ProceedingJoinPoint joinPoint) throws Throwable {
		return logInsertSysLog(joinPoint, "Save");

	}

	/**
	 * 시스템 로그정보를 생성한다. sevice Class의 update로 시작되는 Method
	 * 
	 * @param ProceedingJoinPoint
	 * @return Object
	 * @throws Exception
	 */
	public Object logSelect(ProceedingJoinPoint joinPoint) throws Throwable {
		return logInsertSysLog(joinPoint, "Select");

	}

	/**
	 * 실제 로그를 기록하는 메소드
	 * 
	 * @param joinPoint
	 * @param processSeCode
	 * @return
	 * @throws Throwable
	 */
	public Object logInsertSysLog(ProceedingJoinPoint joinPoint, String processSeCode) throws Throwable {
		StopWatch stopWatch = new StopWatch();
		
		try {
			stopWatch.start();

			Object retValue = joinPoint.proceed();

			return retValue;
		} catch (Throwable e) {
			throw e;
		} finally {
			stopWatch.stop();

			HashMap<String, String> map = new HashMap<String, String>();
			Map<String, Object> userMap = null;

			String className = joinPoint.getTarget().getClass().getName();
			String methodName = joinPoint.getSignature().getName();
			// String processSeCode = "R"; //조회
			String processTime = Long.toString(stopWatch.getTotalTimeMillis());
			// processTime = Double.toString(stopWatch.getTotalTimeSeconds());
			
			//IP저장
			String ip = null;
			
			boolean isLoopback = true;
			Enumeration<NetworkInterface> en;
			en = NetworkInterface.getNetworkInterfaces();
			
			while(en.hasMoreElements()){
				NetworkInterface ni = en.nextElement();
				if(ni.isLoopback()) continue;
				
				Enumeration<InetAddress> inetAddresses = ni.getInetAddresses();
				while(inetAddresses.hasMoreElements()){
					InetAddress ia = inetAddresses.nextElement();
					if(ia.getHostAddress() != null && ia.getHostAddress().indexOf(".") != -1){
						ip = ia.getHostAddress();
						System.out.println("ip = " + ip);
						isLoopback = false;
						break;
					}
				}
				if(!isLoopback) break;
			}
			System.out.println("Last ip = " + ip);
			
			// map.put("LOGID", ""); // 요청ID
			map.put("RQSTRIP", ""); // 요청자IP
			map.put("RQSTRID", ""); // 요청자ID
			map.put("MENUNM", ""); // 메뉴명
			map.put("SVCNM", ""); // 서비스명
			map.put("METHODNM", ""); // 메소드명
			map.put("PROCTM", ""); // 처리시간
			map.put("PROCQRY", ""); // 실행쿼리
			map.put("PROCTABLE", ""); // 실행테이블

			/*
			 * Boolean isAuthenticated =
			 * MfdsUserDetailsHelper.isAuthenticated();
			 * log.debug("isAuthenticated -----> " + isAuthenticated); if
			 * (isAuthenticated) { userMap = (HashMap<String, Object>)
			 * MfdsUserDetailsHelper.getAuthenticatedUser(); map.put("RQSTRID",
			 * (String) userMap.get("EMPNO")); map.put("RQSTRIP", (String)
			 * userMap.get("RQSTRIP")); map.put("PROCQRY", (String)
			 * userMap.get("PROCQRY").toString()); map.put("PROCTABLE", (String)
			 * userMap.get("PROCTABLE").toString()); map.put("REGEMPNO",
			 * (String) userMap.get("EMPNO")); map.put("MENUNM", (String)
			 * userMap.get("MENUID")); // 대상메뉴명 }
			 */

			CommonUserVO userDetail = null;
			try {
				userDetail = (CommonUserVO) CommonSessionUtil.getAttribute("USER_DETAILS");
			} catch (Exception e) {
			}
			log.debug("USER_DETAILS=" + userDetail);
			userDetail = userDetail == null ? new CommonUserVO() : userDetail;
			try {
				CommonSessionUtil.setAttribute("USER_DETAILS", userDetail);
			} catch (Exception e) {
			}
			// log.debug(userDetail);
			userMap = userDetail.getUserMap();

			try {

//				map.put("RQSTRIP", (String) userMap.get("RQSTRIP"));
				map.put("RQSTRIP", (String) ip);
				map.put("RQSTRID", (String) userMap.get("EMPNO"));
				map.put("MENUNM", (String) userMap.get("MENUID"));

				String originProcQuery = (String) userMap.get("PROCQRY");
				String procQuery = CommonStringUtil.cutBytes(originProcQuery, 4000);
				map.put("PROCQRY", procQuery);
				// map.put("PROCTABLE", (String)
				// userMap.get("PROCTABLE").toString());
				String originProcTable = CommonSqlParser.parseTable(originProcQuery);
				String procTable = CommonStringUtil.cutBytes(originProcTable, 200);
				map.put("PROCTABLE", procTable);

				map.put("SVCNM", className);
				map.put("METHODNM", methodName);
				// map.put("PROCESS_SE_CODE", processSeCode);
				map.put("PROCTM", processTime);

				// getQueryId(joinPoint);
				Object[] param = joinPoint.getArgs();
				log.debug("param.length === " + param.length);

				StringBuilder paramBuff = new StringBuilder();
				for (int i = 0; i < param.length; i++) {
					log.debug("param === " + param[i]);
					paramBuff.append("[").append(i).append("]").append(param[i]).append("\n");
				}
				map.put("PROCPARAM", CommonStringUtil.cutBytes(paramBuff.toString(), 4000)); // 4000
																							// byte까지만
																							// 잘라서
																							// 넣는다.

				userMap.put("PROCTABLE", new ArrayList<String>());
				userMap.put("PROCQRY", new ArrayList<String>());

				commonFacillityService.logInsertSysLog(map);
			} catch (Exception e) {
				log.warn("USER_DETAILS is null");
			}

		}

	}

}
