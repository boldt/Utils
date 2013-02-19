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

	/**
 	 * Converts a short value value to an byte array
 	 *
	 * @param value
	 * @return
	 */
	public static byte[] toByteArray(short value) {
		ByteBuffer b = ByteBuffer.allocate(2);
		b.putShort(value);
		return b.array();
	}

	/**
	 * Converts an int value to an byte array
	 *
	 * @param value
	 * @return
	 */
	public static byte[] toByteArray(int value) {
		ByteBuffer b = ByteBuffer.allocate(4);
		b.putInt(value);
		return b.array();
	}

}
