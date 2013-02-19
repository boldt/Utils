package de.dennis_boldt.utils;

import java.util.List;

public class ListUtil {

	/**
	 * Does:
	 * {"a", "b", "c"} -> "a,b,c" or
	 * {1, 2, 3} -> "1,2,3"
	 *
	 * @param array
	 * @param separator
	 * @return
	 */
	public static <T> String implode(List<T> list, String separator) {
		return ArrayUtil.implode(ArrayUtil.toArray(list), separator);
	}

}
