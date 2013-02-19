package de.dennis_boldt.utils;

import org.apache.commons.lang.ArrayUtils;

public class ArrayUtil {

	public static <T> T[] concat(T[] A, T[] B) {
		// @see: http://stackoverflow.com/a/80559/605890
		@SuppressWarnings("unchecked")
		T[] concated = (T[]) ArrayUtils.addAll(A, B);
		return concated;
	}

}
