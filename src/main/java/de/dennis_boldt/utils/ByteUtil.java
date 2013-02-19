package de.dennis_boldt.utils;

import java.nio.ByteBuffer;

public class ByteUtil {

	/**
	 * Concatenates two byte arrays
	 *
	 * @param byteArray1
	 * @param byteArray2
	 * @return
	 */
	public static byte[] concat(final byte[] byteArray1, final byte[] byteArray2) {
		ByteBuffer b = ByteBuffer.allocate(byteArray1.length + byteArray2.length);
		b.put(byteArray1);
		b.put(byteArray2);
		return b.array();
	}

}
