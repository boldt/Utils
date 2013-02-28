package de.dennis_boldt.utils;

import java.nio.ByteBuffer;

/**
 * Utils for integer
 *
 * @author Dennis Boldt
 *
 */
public class IntegerUtil {

	/**
	 * Converts an int value to an byte array
	 *
	 * @param value
	 * @return
	 */
	public static byte[] toBytes(int value) {
		ByteBuffer b = ByteBuffer.allocate(4);
		b.putInt(value);
		return b.array();
	}

}
