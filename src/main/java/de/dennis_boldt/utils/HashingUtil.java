package de.dennis_boldt.utils;

import java.io.File;
import java.nio.ByteBuffer;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import de.dennis_boldt.helpers.FileUtilException;

public class HashingUtil {

	/*
	 * SHA-1
	 */

	/**
     * Gets the SHA-1-hash
	 *
	 * @param string a string
	 * @return
	 */
	public static String sha1(final String string) {
    	return doDigestForByteArray(string.getBytes(), "SHA-1");
    }

	/**
     * Gets the SHA-1-hash
	 *
	 * @param file a file
	 * @return
	 */
    public static String sha1(final File file) {
    	return doDigestForFile(file, "SHA-1");
    }

    /**
     * Gets the SHA-1-hash
     *
     * @param byteArray a byte array
     * @return
     */
    public static String sha1(final byte[] byteArray) {
    	return doDigestForByteArray(byteArray, "SHA-1");
    }

    /**
     * Gets the SHA-1-hash
     *
     * @param byteBuffer a bytebuffer
     * @return
     */
    public static String sha1(final ByteBuffer byteBuffer) {
    	return doDigestForByteArray(byteBuffer.array(), "SHA-1");
    }

    /*
     * MD5
     */

    /**
     * Gets the MD5-hash
     *
	 * @param string a string
     * @return
     */
    public static String md5(final String string) {
    	return doDigestForByteArray(string.getBytes(), "MD5");
    }

    /**
     * Gets the MD5-hash
     *
	 * @param file a file
     * @return
     */
    public static String md5(final File file) {
    	return doDigestForFile(file, "MD5");
    }

    /**
     * Gets the MD5-hash
     *
     * @param byteArray a byte array
     * @return
     */
    public static String md5(final byte[] byteArray) {
    	return doDigestForByteArray(byteArray, "MD5");
    }

    /**
     * Gets the MD5-hash
     *
     * @param byteBuffer a bytebuffer
     * @return
     */
    public static String md5(final ByteBuffer byteBuffer) {
    	return doDigestForByteArray(byteBuffer.array(), "MD5");
    }

    /*
     * Helper
     */
    private static String doDigestForByteArray(final byte[] bytes, final String algorithm) {
		try {
			MessageDigest md = MessageDigest.getInstance(algorithm);
			byte[] hash = md.digest(bytes);
			return HexUtil.byteArrayToHexString(hash);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			return null;
		}
    }

    private static String doDigestForFile(final File f, final String algorithm) {
		try {
			return doDigestForByteArray(FileUtil.toByteArray(f), algorithm);
		} catch (FileUtilException e) {
			e.printStackTrace();
			return null;
		}
	}

}
