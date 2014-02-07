package de.dennis_boldt.utils;

import java.io.File;
import java.io.InputStream;
import java.util.Properties;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.PropertyConfigurator;

public class LogUtils {

	/**
	 * Load the given log file and set the output of log4j.appender.Console
	 * to the given level
	 *
	 * @param file
	 * @param logLevel
	 */
	public static void init(File file, String logLevel) {
		Properties p = PropertiesUtil.load(file);
		if(p == null) {
			System.out.println("Could not load log4j properties from " + file);
			BasicConfigurator.configure();
		} else {
			init(p, logLevel);
		}
	}

	public static void init(InputStream is, String logLevel) {
		Properties p = PropertiesUtil.load(is);
		init(p, logLevel);
	}

	private static void init(Properties p, String logLevel) {
		if(logLevel != null) {
			// TODO: set all!
			String[] levels = {"DEBUG","INFO", "TRACE", "WARN", "ERROR"};
			if(ArrayUtil.contains(levels, logLevel)) {
				p.setProperty("log4j.appender.Console.Threshold", logLevel);
			} else {
				System.out.println("Log level " + logLevel + " not known!");
			}
		}
		PropertyConfigurator.configure(p);
	}

}
