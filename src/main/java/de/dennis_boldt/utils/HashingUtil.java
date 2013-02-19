package de.dennis_boldt.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class HashingUtil {

	/*
	 * SHA-1
	 */
	public static String sha1(final String s) {
    	return byteToHash(s.getBytes(), "SHA-1");
    }

    public static String sha1(final File f) {
    	return fileToHash(f, "SHA-1");
    }

    public static String sha1(final byte[] b) {
    	return byteToHash(b, "SHA-1");
    }

    public static String sha1(final ByteBuffer bb) {
    	return byteToHash(bb.array(), "SHA-1");
    }

    /*
     * MD5
     */
    public static String md5(final File f) {
    	return fileToHash(f, "MD5");
    }

    public static String md5(final String s) {
    	return byteToHash(s.getBytes(), "MD5");
    }

    public static String md5(final byte[] b) {
    	return byteToHash(b, "MD5");
    }

    public static String md5(final ByteBuffer bb) {
    	return byteToHash(bb.array(), "MD5");
    }

    /*
     * Helper
     */
    private static String byteToHash(final byte[] bytes, final String algorithm) {
		try {
			MessageDigest md = MessageDigest.getInstance(algorithm);
			return HexUtil.byteArrayToHexString(md.digest(bytes));
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			return null;
		}
    }

    private static String fileToHash(final File f, final String algorithm) {
		try {

			return byteToHash(FileUtil.toByteArray(f), algorithm);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return null;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}

}
