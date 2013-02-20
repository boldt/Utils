package de.dennis_boldt.utils;

import java.math.BigInteger;
import java.nio.ByteBuffer;

import de.dennis_boldt.helpers.SecureRandomNumber;

/**
 * Utils for random generation
 *
 * @author Dennis Boldt
 *
 */
public class RandomUtil {

	/**
	 * Get a hex-string for a given amount of bytes
	 *
	 * @param bytes
	 * @return
	 */
	public static String getRandomHex(int bytes) {
		return HexUtil.byteArrayToHexString(getRandomBytes(bytes));
	}

	/**
	 * Get a byte array for a given amount of bytes
	 *
	 * @param bytes
	 * @return
	 */
	public static byte[] getRandomBytes(int bytes) {
		return SecureRandomNumber.getSecureRandom(bytes * 8);
	}

	/**
	 * Get a BigInteger for a given amount of bytes
	 *
	 * @param bytes
	 * @return
	 */
	public static BigInteger getRandomBigInteger(int bytes) {
		return new BigInteger(getRandomBytes(bytes));
	}

	/**
	 * Get a Random integer value
	 *
	 * @param bytes
	 * @return
	 */
	public static int getRandomInteger() {
		ByteBuffer bb = ByteBuffer.wrap(getRandomBytes(4));
		bb.rewind();
		return bb.getInt();
	}

	/**
	 * Get a Random positiv integer value
	 *
	 * @param bytes
	 * @return
	 */
	public static int getRandomPositiveInteger() {
		ByteBuffer bb = ByteBuffer.wrap(getRandomBytes(4));
		bb.rewind();
		return Math.abs(bb.getInt());
	}

	/**
	 * Get a Random integer value i € [from, to]
	 *
	 * @see: http://stackoverflow.com/q/363681/605890
	 * @param from
	 * @param to
	 * @return value i, where i € [from, to]
	 */
	public static int getRandomFromTo(int from, int to) {
		java.util.Random r = new java.util.Random();
		return from + r.nextInt(to-from+1);
	}

}
