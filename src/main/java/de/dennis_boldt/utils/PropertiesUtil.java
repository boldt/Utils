package de.dennis_boldt.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesUtil {

	/**
	 * Loads a given properties file
	 *
	 * @param file
	 * @return
	 */
	public static Properties load(File file) {
		try {
			if (file != null && file.exists()) {
				return load(new FileInputStream(file));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public static Properties load(InputStream is) {
		try {
			Properties prop = new Properties();
			prop.load(is);
			return prop;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
}
