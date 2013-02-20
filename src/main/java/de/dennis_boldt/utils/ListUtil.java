package de.dennis_boldt.utils;

import java.util.List;

/**
 * Utils for lists
 *
 * @author Dennis Boldt
 *
 */
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
	public static <T> String join(List<T> list, String separator) {
		return ArrayUtil.join(ListUtil.toArray(list), separator);
	}

	/**
	 * Converts a list to an array
	 *
	 * @param list a list
	 * @return the list as an array
	 */
	public static <T> T[] toArray(List<T> list) {
		@SuppressWarnings("unchecked")
		T[] array = (T[]) list.toArray();
		return array;
	}

}
