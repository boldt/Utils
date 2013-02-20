package de.dennis_boldt.utils;

import java.nio.ByteBuffer;

/**
 * Utils for short
 *
 * @author Dennis Boldt
 *
 */
public class ShortUtil {

	/**
 	 * Converts a short value to an byte array
 	 *
	 * @param value
	 * @return
	 */
	public static byte[] toBytes(short value) {
		ByteBuffer b = ByteBuffer.allocate(2);
		b.putShort(value);
		return b.array();
	}


}
