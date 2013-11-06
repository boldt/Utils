package de.dennis_boldt.utils;

import java.io.File;
import java.net.URL;

/**
 *
 *
 * @author Dennis Boldt
 *
 */
public class JarUtil {

	/**
	 * http://stackoverflow.com/a/11007426/605890
	 *
	 * @param c
	 * @return
	 */
	public static boolean isJar() {
		URL path = JarUtil.class.getResource("JarUtil.class");
		return path.toString().startsWith("jar:");
	}

	/**
	 * Returns the name of the jar.
	 *
	 * @param o
	 * @return
	 */
	public static String getName(Object o) {
		String jarName = (new File(o.getClass().getProtectionDomain()
				  .getCodeSource()
				  .getLocation()
				  .getPath())).getName();
		return jarName;

	}


}
