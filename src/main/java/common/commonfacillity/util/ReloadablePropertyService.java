package common.commonfacillity.util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.Timer;
import java.util.TimerTask;
import java.util.Vector;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

import org.apache.commons.collections.ExtendedProperties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanDefinitionStoreException;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.MessageSource;
import org.springframework.context.ResourceLoaderAware;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.util.Assert;

import egovframework.rte.fdl.cmmn.exception.FdlException;
import egovframework.rte.fdl.property.EgovPropertyService;

/**
 * Reload Property Service. extFileName방식으로 지정된 properties만 인식
 * 
 * @author Han
 * 
 */
public class ReloadablePropertyService implements EgovPropertyService, ApplicationContextAware, InitializingBean, DisposableBean, ResourceLoaderAware {
	protected final Logger logger = LoggerFactory.getLogger(ReloadablePropertyService.class);
//	protected Logger logger = Logger.getLogger(ReloadablePropertyService.class);

	private ExtendedProperties egovProperties = null;
	private ResourceLoader resourceLoader = null;

	private MessageSource messageSource;

	@SuppressWarnings("unchecked")
	private Set extFileName;
	@SuppressWarnings("unchecked")
	private Map properties;

	private boolean running = false;
	private int interval = 1000; // default interval (ms)

	private final ReentrantReadWriteLock rwl = new ReentrantReadWriteLock();
	// private final Lock r = rwl.readLock();
	private final Lock w = rwl.writeLock();

	private Timer timer;
	private TimerTask task;

	public boolean getBoolean(String name) {
		return getConfiguration().getBoolean(name);
	}

	public boolean getBoolean(String name, boolean def) {
		return getConfiguration().getBoolean(name, def);
	}

	public double getDouble(String name) {
		return getConfiguration().getDouble(name);
	}

	public double getDouble(String name, double def) {
		return getConfiguration().getDouble(name, def);
	}

	public float getFloat(String name) {
		return getConfiguration().getFloat(name);
	}

	public float getFloat(String name, float def) {
		return getConfiguration().getFloat(name, def);
	}

	public int getInt(String name) {
		return getConfiguration().getInt(name);
	}

	public int getInt(String name, int def) {
		return getConfiguration().getInt(name, def);
	}

	@SuppressWarnings("unchecked")
	public Iterator getKeys() {
		return getConfiguration().getKeys();
	}

	@SuppressWarnings("unchecked")
	public Iterator getKeys(String prefix) {
		// getConfiguration().values();
		return getConfiguration().getKeys(prefix);
	}

	public long getLong(String name) {
		return getConfiguration().getLong(name);
	}

	public long getLong(String name, long def) {
		return getConfiguration().getLong(name, def);
	}

	public String getString(String name) {
		return getConfiguration().getString(name);
	}

	public String getString(String name, String def) {
		return getConfiguration().getString(name, def);
	}

	public String[] getStringArray(String name) {
		return getConfiguration().getStringArray(name);
	}

	@SuppressWarnings("unchecked")
	public Vector getVector(String name) {
		return getConfiguration().getVector(name);
	}

	@SuppressWarnings("unchecked")
	public Vector getVector(String name, Vector def) {
		return getConfiguration().getVector(name, def);
	}

	@SuppressWarnings("unchecked")
	public Collection getAllKeyValue() {
		return getConfiguration().values();
	}

	/**
	 * egovProperties 얻기.
	 * 
	 * @return Properties of requested Service.
	 */
	private ExtendedProperties getConfiguration() {
		return egovProperties;
	}

	/**
	 * 메시지 처리.
	 * 
	 * @param msgKey
	 * @param params
	 * @return
	 */
	protected String getMessage(String msgKey, String[] params) {
		return messageSource.getMessage(msgKey, params, Locale.getDefault());
	}

	/**
	 * resource 변경시 refresh.
	 */
	@SuppressWarnings("unchecked")
	public void refreshPropertyFiles() throws FdlException {

		String fileName = null;

		try {

			if (extFileName == null) {
				return;
			}

			Iterator it = extFileName.iterator();

			while (it != null && it.hasNext()) {
				// Get element
				Object element = it.next();
				String enc = null;

				if (element instanceof Map) {
					Map ele = (Map) element;
					enc = (String) ele.get("encoding");
					fileName = (String) ele.get("filename");
				} else {
					fileName = (String) element;
				}
				loadPropertyResources(fileName, enc);
			}

		} catch (Exception ex) {
			if (logger.isErrorEnabled()) {
				logger.error(getMessage("error.properties.refresh.files", new String[] { fileName }));
				logger.error(getMessage("error.properties.refresh.files.reason", new String[] {}));
			}
			throw new FdlException("error.properties.refresh.files", new String[] { fileName }, ex);

		}
	}

	/**
	 * Bean 초기화 함수로 최초 생성시 필요한 Property setting 처리.
	 * 
	 * @throws Exception
	 *             fail to initialize
	 */
	@SuppressWarnings("unchecked")
	public void afterPropertiesSet() throws Exception {
		try {

			egovProperties = new ExtendedProperties();

			// 외부파일이 정의되었을때
			if (extFileName != null) {
				refreshPropertyFiles();
			}

			// properties 속성이 없는 경우..
			if (properties == null || properties.entrySet() == null) {
				initTimer();

				return;
			}

			Iterator it = properties.entrySet().iterator();
			while (it.hasNext()) {

				Map.Entry entry = (Map.Entry) it.next();
				String key = (String) entry.getKey();
				String value = (String) entry.getValue();

				if (logger.isDebugEnabled()) {
					logger.debug(getMessage("debug.properties.property", new String[] { key, value }));
				}

				if (key == null || key.equals("")) {
					if (logger.isErrorEnabled())
						logger.error(getMessage("error.properties.check.essential", new String[] {}));
					throw new FdlException(messageSource, "error.properties.check.essential", null);
				}

				egovProperties.put(key, value);
			}

			initTimer();

		} catch (Exception ex) {
			if (ex instanceof FdlException)
				throw (FdlException) ex;
			else {
				if (logger.isErrorEnabled())
					logger.error(getMessage("error.properties.initialize.reason", new String[] {}));
				throw new FdlException(messageSource, "error.properties.initialize", ex);
			}
		}
	}

	/**
	 * extFileName을 지정할 때 Attribute로 정의.
	 * 
	 * @param extFileName
	 */
	@SuppressWarnings("unchecked")
	public void setExtFileName(Set extFileName) {
		this.extFileName = extFileName;
	}

	/**
	 * properties를 지정할 때 Attribute로 정의.
	 * 
	 * @param properties
	 */
	@SuppressWarnings("unchecked")
	public void setProperties(Map properties) {
		this.properties = properties;
	}

	/**
	 * 서비스 종료처리.
	 */
	public void destroy() throws Exception {
		egovProperties = null;

		timer.cancel();
	}

	/**
	 * 리소스 로더 세팅.
	 */
	public void setResourceLoader(ResourceLoader resourceLoader) {
		this.resourceLoader = resourceLoader;
	}

	/**
	 * ApplicationContext 세팅.
	 * 
	 * @param applicationContext
	 *            to be set by container
	 */
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.messageSource = (MessageSource) applicationContext.getBean("messageSource");
	}

	/**
	 * 파일위치정보를 가지고 resources 정보 추출.
	 * 
	 * @param location
	 *            파일위치
	 * @param encoding
	 *            Encoding 정보
	 * @throws Exception
	 */
	private void loadPropertyResources(String location, String encoding) throws Exception {

		if (resourceLoader instanceof ResourcePatternResolver) {
			try {
				Resource[] resources = ((ResourcePatternResolver) resourceLoader).getResources(location);

				loadPropertyLoop(resources, encoding);
			} catch (IOException ex) {
				throw new BeanDefinitionStoreException("Could not resolve Properties resource pattern [" + location + "]", ex);
			}
		} else {

			Resource resource = resourceLoader.getResource(location);
			loadPropertyRes(resource, encoding);
		}

	}

	/**
	 * 멀티로 지정된 경우 처리를 위해 LOOP 처리
	 * 
	 * @param resources
	 *            리소스정보
	 * @param encoding
	 *            인코딩정보
	 * @throws Exception
	 */
	private void loadPropertyLoop(Resource[] resources, String encoding) throws Exception {
		Assert.notNull(resources, "Resource array must not be null");
		for (int i = 0; i < resources.length; i++) {
			loadPropertyRes(resources[i], encoding);
		}
	}

	/**
	 * 파일 정보를 읽어서 egovProperties에 저장
	 * 
	 * @param resources
	 *            리소스정보
	 * @param encoding
	 *            인코딩정보
	 * @throws Exception
	 */
	private void loadPropertyRes(Resource resource, String encoding) throws Exception {
		if (logger.isDebugEnabled()) {
			logger.debug(getMessage("debug.properties.filename", new String[] { resource.getFilename(), encoding }));
		}
		ExtendedProperties egovProperty = new ExtendedProperties();
		egovProperty.load(resource.getInputStream(), encoding);
		egovProperties.combine(egovProperty);
	}

	/**
	 * checkInterval property.
	 * 
	 * @param ms
	 */
	public void setCheckInterval(int ms) {
		interval = ms;

		if (timer != null) {
			resetInterval();
		}
	}

	/**
	 * Reset interval.
	 */
	private void resetInterval() {
		if (running) {
			timer.cancel();
			running = false;
		}
		if (interval > 0) {
			timer.schedule(task, 0, interval);
			running = true;
		}
	}

	/**
	 * InitializingBean interface implementation.
	 */
	public void initTimer() throws FdlException { // because
		// EgovPropertyServiceImpl not
		// "throws Exception"

		// Timer 처리...
		task = new TimerTask() {
			@SuppressWarnings("unchecked")
			private Map map = new HashMap();

			public void run() {
				// logger.debug("Checking properties file modifiation...");
				if (isModified()) {
					try {
						reload();
					} catch (Exception ex) {
						logger.error("caught exception", ex);
					}
				}
			}

			@SuppressWarnings("unchecked")
			private boolean isModified() {
				String fileName = null;

				Iterator it = extFileName.iterator();

				while (it != null && it.hasNext()) {
					// Get element
					Object element = it.next();

					if (element instanceof Map) {
						fileName = (String) ((Map) element).get("filename");
					} else {
						fileName = (String) element;
					}

					if (check(fileName)) {
						return true;
					}
				}

				return false;
			}

			private boolean check(String location) {
				if (resourceLoader instanceof ResourcePatternResolver) {
					try {
						try {
							Resource[] resources = ((ResourcePatternResolver) resourceLoader).getResources(location);

							for (Resource item : resources) {
								if (findModifiedResource(item)) {
									return true;
								}
							}
						} catch (IllegalArgumentException ignore) {
							logger.warn(ignore.getMessage());
						}
					} catch (IOException ex) {
						throw new BeanDefinitionStoreException("Could not resolve Properties resource pattern [" + location + "]", ex);
					}
				} else {

					Resource resource = resourceLoader.getResource(location);

					return findModifiedResource(resource);
				}

				return false;
			}

			@SuppressWarnings("unchecked")
			private boolean findModifiedResource(Resource resource) {
				boolean retVal = false;
				List modifiedResources = new ArrayList();

				try {
					long modified = resource.lastModified();

					if (map.containsKey(resource)) {
						long lastModified = ((Long) map.get(resource)).longValue();

						if (lastModified != modified) {
							map.put(resource, new Long(modified));
							modifiedResources.add(resource.getDescription());
							retVal = true;
						}

					} else {
						map.put(resource, new Long(modified));
					}

				} catch (IOException ioe) {
					logger.error("caught exception", ioe);
				}

				if (retVal) {
					logger.info("Modified files : {}", modifiedResources);
				}

				return retVal;
			}
		};

		timer = new Timer(true);
		resetInterval();
	}

	public void reload() throws Exception {
		logger.info("Reloading properties.");

		/*
		 * WRITE LOCK.
		 */
		w.lock();
		try {
			refreshPropertyFiles();

		} finally {
			w.unlock();
		}
	}

}
