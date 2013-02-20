package de.dennis_boldt.utils;

import java.math.BigInteger;
import java.nio.ByteBuffer;

import de.dennis_boldt.helpers.SecureRandomNumber;

/**
 * @author Dennis Boldt
 */

public class RandomUtil {

	public static String getRandomHex(int bytes) {
		return HexUtil.byteArrayToHexString(getRandomBytes(bytes));
	}

	public static byte[] getRandomBytes(int bytes) {
		return SecureRandomNumber.getSecureRandom(bytes * 8);
	}

	public static BigInteger getRandomBigInteger(int bytes) {
		return new BigInteger(getRandomBytes(bytes));
	}

	public static int getRandomInteger() {
		ByteBuffer bb = ByteBuffer.wrap(getRandomBytes(4));
		bb.rewind();
		return bb.getInt();
	}

	public static int getRandomPositiveInteger() {
		ByteBuffer bb = ByteBuffer.wrap(getRandomBytes(4));
		bb.rewind();
		return Math.abs(bb.getInt());
	}

	/*
	 * @see: http://stackoverflow.com/q/363681/605890
	 */
	public static int getRandomFromTo(int from, int to) {
		java.util.Random r = new java.util.Random();
		return from + r.nextInt(to-from+1);
	}

}
