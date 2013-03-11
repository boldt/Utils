package de.dennis_boldt.utils;

/**
 * System specific utils
 *
 * @see: http://www.mindspring.com/~mgrand/java-system-properties.htm
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
	// The commons-lang library has a constant field available called
	// SystemUtils.LINE_SEPARATOR
	// String.format("%n")
	public static final String LINE_SEPARATOR = System.getProperty("line.separator");

	/**
	 * The directory in which java should create temporary files
	 */
	public static final String TEMPDIR = System.getProperty("java.io.tmpdir");


	/**
	 * The platform-dependent path separator (e.g., ":" on UNIX, "," for Windows)
	 */
	public static final String PATH_SEPARATOR = System.getProperty("path.separator");

	public static final class USER {

		/**
		 * The current working directory when the properties were initialized
		 */
		public static final String DIR = System.getProperty("user.dir");

		/**
		 * The home directory of the current user
		 */
		public static final String HOME = System.getProperty("user.home");

		/**
		 * The two-letter language code of the default locale
		 */
		public static final String LANGUAGE = System.getProperty("user.language");

		/**
		 * The username of the current user
		 */
		public static final String NAME = System.getProperty("user.name");

		/**
		 * The two-letter country code of the default locale
		 */
		public static final String REGION = System.getProperty("user.region");

		/**
		 * The default time zone
		 */
		public static final String TIMEZONE = System.getProperty("user.timezone");
	}

	/*
	 * The C programming language allows programs exiting or returning from the
	 * main function to signal success or failure by returning an integer, or
	 * returning the macros EXIT_SUCCESS and EXIT_FAILURE. On Unix-like systems
	 * these are evaluate to 0 and 1 respectively
	 *
	 * In Java, [...] a nonzero status code indicates abnormal termination
	 *
	 * @see: http://en.wikipedia.org/wiki/Exit_status
	 *
	 * The most common convention is simply 0 for success and 1 for failure
	 *
	 * @see: http://www.gnu.org/software/libc/manual/html_node/Exit-Status.html
	 * [...] by convention, a nonzero status code indicates abnormal termination.
	 * @see: http://docs.oracle.com/javase/6/docs/api/java/lang/System.html#exit%28int%29
	 *
	 */
	public static class EXIT_STATUS {
		public static int SUCCESS = 0;
		public static int FAILURE = 1;
	}
}
