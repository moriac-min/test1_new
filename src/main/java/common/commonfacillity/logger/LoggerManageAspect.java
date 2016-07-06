package common.commonfacillity.logger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;

//@Aspect
public class LoggerManageAspect {
	protected final Logger log = LoggerFactory.getLogger(this.getClass());

	public Object logPrint(ProceedingJoinPoint joinPoint) throws Throwable {
		if (!"logInsertSysLog".equals(joinPoint.getSignature().getName())) {
			String gubun = "";
			if (joinPoint.getSignature().getDeclaringTypeName().indexOf("controller") > -1) {
				gubun = "Controller  \t:  ";
			} else if (joinPoint.getSignature().getDeclaringTypeName().indexOf("service") > -1) {
				gubun = "ServiceImpl  \t:  ";
			} else if (joinPoint.getSignature().getDeclaringTypeName().indexOf("dao") > -1) {
				gubun = "Dao  \t\t:  ";
			} else if (joinPoint.getSignature().getDeclaringTypeName().indexOf("mapper") > -1) {
				gubun = "Mapper  \t\t:  ";
			}

			log.debug(gubun + joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName() + "()");

			Object[] param = joinPoint.getArgs();
			for (int i = 0; i < param.length; i++) {
				if (param[i] instanceof ModelMap || param[i] instanceof Model)
					continue;

				/*
				 * if(i==0)
				 * LOG.debug("Param  \t\t:  "+param[i].getClass().toString());
				 */
			}
		}
		return joinPoint.proceed();
	}
}