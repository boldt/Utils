package de.dennis_boldt.utils;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class PropertiesUtil {

	public static Properties load(File s) {
		try {
			if (s != null && s.exists())
			{
				FileInputStream input = new FileInputStream(s);
				Properties prop = new Properties();
				prop.load(input);
				return prop;
			}
		} catch (Exception e) { }
		return null;
	}


}
