package de.dennis_boldt.utils;


public class SystemUtil {
	public static final String FILE_SEPARATOR = System.getProperty("file.separator");
	public static final String LINE_SEPARATOR = System.getProperty("line.separator");
	// Java7: System.lineSeparator()
	// The commons-lang library has a constant field available called SystemUtils.LINE_SEPARATOR
	// String.format("%n")
}
