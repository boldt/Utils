package de.dennis_boldt.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class HashingUtil {

    public static String sha1(String s) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-1");
            return HexUtil.byteArrayToHexString(md.digest(s.getBytes()));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String md5(String s) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            return HexUtil.byteArrayToHexString(md.digest(s.getBytes()));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;
    }


}
