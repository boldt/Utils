package de.dennis_boldt.utils;

import java.lang.reflect.Array;

public class ArrayUtil {

	public static <T> T[] concat(T[] A, T[] B) {
		int aLen = A.length;
		int bLen = B.length;

		@SuppressWarnings("unchecked")
		T[] C = (T[]) Array.newInstance(A.getClass().getComponentType(), aLen + bLen);
		System.arraycopy(A, 0, C, 0, aLen);
		System.arraycopy(B, 0, C, aLen, bLen);
		return C;
	}

}
