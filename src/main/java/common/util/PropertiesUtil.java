package common.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesUtil {

	public static String getProperty(String key) {
		String value = null;
		//加载properties文件
		Properties p = new Properties();
		try {
			InputStream resourceAsStream = PropertiesUtil.class.getResourceAsStream("/resources/datasource.properties");
			p.load(resourceAsStream);
			value = p.getProperty(key);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return value;
	}
}
