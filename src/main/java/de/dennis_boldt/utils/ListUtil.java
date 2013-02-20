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
		return ArrayUtil.join(ListUtil.toArray(list), separator);
	}

	public static <T> T[] toArray(List<T> list) {
		@SuppressWarnings("unchecked")
		T[] array = (T[]) list.toArray();
		return array;
	}

}
