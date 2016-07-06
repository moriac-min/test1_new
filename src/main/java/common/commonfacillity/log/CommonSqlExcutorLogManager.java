package common.commonfacillity.log;

import java.lang.reflect.Field;
import java.sql.Statement;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.apache.ibatis.cache.CacheKey;
import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.executor.statement.SimpleStatementHandler;
import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.ParameterMapping;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Plugin;
import org.apache.ibatis.plugin.Signature;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;

import common.commonfacillity.util.CommonSessionUtil;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StopWatch;

@Intercepts
(
		{
			@Signature(type=Executor.class, method="update", args={MappedStatement.class, Object.class})
			,@Signature(type=Executor.class, method="query", args={MappedStatement.class, Object.class, RowBounds.class, ResultHandler.class, CacheKey.class, BoundSql.class})
			,@Signature(type=Executor.class, method="query", args={MappedStatement.class, Object.class, RowBounds.class, ResultHandler.class})
		}
)
public class CommonSqlExcutorLogManager implements Interceptor{
	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Override
	public Object intercept(Invocation invocation) throws Throwable {
		StopWatch stopWatcher = new StopWatch();
		
		try{
			stopWatcher.start();
			
			Object[] args = invocation.getArgs();
			MappedStatement ms = (MappedStatement)args[0];
			Object param = (Object)args[1];
			BoundSql boundSql = ms.getBoundSql(param);
			
			log.debug("===========================================================");
			log.debug("CommonSqlExcutorLogManager Process : {}", invocation.getMethod().getName());
			log.debug("===========================================================");
			log.debug("CommonSqlExcutorLogManager id : {}", ms.getId());
			log.debug("===========================================================");
			log.debug("CommonSqlExcutorLogManager sql : {}", boundSql.getSql());
			log.debug("===========================================================");
			log.debug("CommonSqlExcutorLogManager param : {}", param);
			log.debug("===========================================================");
			
			return invocation.proceed();
		} catch(Throwable e){
			throw e;
		} finally{
			stopWatcher.stop();
			
			String processTime = Long.toString(stopWatcher.getTotalTimeMillis());
			
			log.debug("===========================================================");
			log.debug("CommonSqlExcutorLogManager processTime : {}", processTime);
			log.debug("===========================================================");
		}
		
	}
	
	@Override
	public Object plugin(Object target){
		return Plugin.wrap(target, this);
	}
	
	@Override
	public void setProperties(Properties properties){
		
	}
}
