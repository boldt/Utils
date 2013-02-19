package de.dennis_boldt.utils;

import org.apache.commons.lang.StringUtils;

public class StringUtil {

	/**
	 * PHP-like method to do {"a", "b", "c"} -> "a,b,c"
	 *
	 * @param array A string array
	 * @param separator The separator
	 * @return
	 */
	public static String implode(String[] array, String separator) {
		return StringUtils.join(array, separator);
	}

}
