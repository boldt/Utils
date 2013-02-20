package de.dennis_boldt.utils;

/**
 * System specific utils
 *
 * @author Dennis Boldt
 *
 */
public class SystemUtil {

	/**
	 * The system dependent file separator
	 */
	public static final String FILE_SEPARATOR = System.getProperty("file.separator");

	/**
	 * The system dependent line separator
	 */
	// TODO: Java7: System.lineSeparator()
	// The commons-lang library has a constant field available called SystemUtils.LINE_SEPARATOR
	// String.format("%n")
	public static final String LINE_SEPARATOR = System.getProperty("line.separator");
}
