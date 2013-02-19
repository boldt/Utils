package de.dennis_boldt.utils;

import java.util.Arrays;
import java.util.List;

public class ArrayUtil {

	/**
	 * Concats two array
	 *
	 * @param first
	 * @param second
	 * @return
	 */
	public static <T> T[] concat(T[] first, T[] second) {
		// @see: http://stackoverflow.com/a/784842/605890
		T[] result = Arrays.copyOf(first, first.length + second.length);
		System.arraycopy(second, 0, result, first.length, second.length);
		return result;
	}

	/**
	 * Does:
	 * {"a", "b", "c"} -> "a,b,c" or
	 * {1, 2, 3} -> "1,2,3"
	 *
	 * @param array
	 * @param separator
	 * @return
	 */
	public static <T> String implode(T[] array, String separator) {
	    String out = "";
	    for(int i=0; i<array.length; i++) {
	        if(i!=0) { out += separator; }
	        out += array[i].toString();
	    }
	    return out;
	}

	/**
	 * Checks, if an element is in an array
	 *
	 * @param array
	 * @param needle
	 * @return
	 */
	public static <T> boolean contains(T[] array, T needle) {
	    for(int i=0;i<array.length;i++) {
	        if(array[i].equals(needle)) {
	            return true;
	        }
	    }
	    return false;
	}

	public static <T> List<T> toList(T[] array) {
		return Arrays.asList(array);
	}

}
