package Config;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {
	private static Properties properties = new Properties();

	static {
		try {
			String path = System.getProperty("user.dir") + "/src/test/resources/config.properties";
			InputStream input = new FileInputStream(path);
//			if (input == null) {
//				throw new RuntimeException("config.properties not found in classpath");
//			}
			properties.load(input);

		} catch (Exception e) {
			throw new RuntimeException("Failed to load config.properties", e);
		}
	}

	public static String getProperty(String key) {
		return properties.getProperty(key);
	}
}
