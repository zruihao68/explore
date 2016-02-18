package xyz.zrui.explore.common.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 用于读取Properties文件
 * @author zrui
 *
 */
public class ConfigHelper {
	private static Logger logger = LoggerFactory.getLogger(ConfigHelper.class);
	private static Properties properties = null;
	private static ConfigHelper instance = null;
	public static ConfigHelper getInstance() {
		if (null == instance) {
			instance = new ConfigHelper();
		}
		return instance;
	}
	private ConfigHelper() {
		load();
	}
	public void load() {
		InputStream is = null;
		try {
			properties = new Properties();
			ClassLoader loader = Thread.currentThread().getContextClassLoader();
			is = loader.getResource("config/config.properties").openStream();
			properties.load(is);
			is.close();
			is = null;
			logger.debug(properties.toString());
		} catch (Exception e) {
			logger.error("", e);
		} finally {
			try {
				if (null != is) {
					is.close();
					is = null;
				}
			} catch (IOException e) {
			}
		}
	}
	public static String getProperty(String key) {
		getInstance();
		return ((String) properties.get(key)).trim();
	}
	public String getProperty(String key, String defaultValue) {
		String value = getProperty(key);
		if (null == value) {
			return defaultValue;
		} else {
			return value;
		}
	}
}
