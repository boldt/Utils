package de.dennis_boldt.utils;

/*
 * TODO:
 * http://www.daniweb.com/software-development/java/code/216874/primitive-types-as-byte-arrays
 */
/**
 * Utils for hex handling
 *
 * @author Dennis Boldt
 *
 */
public class HexUtil {

	/**
	 * Converts a byte Array to a hex String: String({0xAA,0xBB}) -> "AABB"
	 *
	 * @param b
	 * @return
	 */
    public static String toString(byte[] b) {
    	return toString(b, "", "");
    }

    /**
	 * Converts a byte Array to a hex String by prepending/appending.
	 * toString({0xAA,0xBB},"0x"," ") -> "0xAA 0xBB"
	 *
	 * @param b
	 * @return
	 */
    public static String toString(byte[] b, String prepending, String appending) {
    	// String.format("%05X", b)
    	String result = "";
    	for (int i = 0; i < b.length; i++) {
    		result += prepending + Integer.toString((b[i] & 0xff) + 0x100, 16).substring(1) + appending;
    	}
    	return result.trim().toLowerCase();
    }

    /**
     * Convert a single byte into its hex String
     * equivalent.
     *
     * @param b
     * @return
     */
    public static String toString ( byte b ) {
        char[] array = { HEX_DIGIT[(b >> 4) & 0x0f], HEX_DIGIT[b & 0x0f] };
        return new String(array);
    }

    /**
     * Converts a hext string to a byte array
     *
     * @see: http://stackoverflow.com/a/140861/605890
     *
     * @param s
     * @return
     */
    public static byte[] toArray(String s) {
        int len = s.length();
        byte[] data = new byte[len / 2];
        for (int i = 0; i < len; i += 2) {
            data[i / 2] = (byte) ((Character.digit(s.charAt(i), 16) << 4)
                                 + Character.digit(s.charAt(i+1), 16));
        }
        return data;
    }

    /*
     * Helper array
     */
    private static final char HEX_DIGIT [] = {
        '0', '1', '2', '3', '4', '5', '6', '7',
        '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'
    };

}
