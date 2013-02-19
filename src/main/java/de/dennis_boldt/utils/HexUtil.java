package de.dennis_boldt.utils;

/*
 * TODO: Cleanup
 * http://www.daniweb.com/software-development/java/code/216874/primitive-types-as-byte-arrays
 */
public class HexUtil {

	/**
	 * TODO: Improve
	 * http://stackoverflow.com/questions/9655181/convert-from-byte-array-to-hex-string-in-java
	 * http://stackoverflow.com/questions/332079/in-java-how-do-i-convert-a-byte-array-to-a-string-of-hex-digits-while-keeping-l
	 * http://stackoverflow.com/questions/332079/in-java-how-do-i-convert-a-byte-array-to-a-string-of-hex-digits-while-keeping-l/2197650#2197650
	 */
    public static String byteArrayToHexString(byte[] b) {
    	// 		   System.out.format("0x%x ", b);
        String result = "";
        for (int i = 0; i < b.length; i++) {
            result += Integer.toString((b[i] & 0xff) + 0x100, 16).substring(1);
        }
        return result;
    }

    /*
	private static final char HEX_DIGIT [] = {
        '0', '1', '2', '3', '4', '5', '6', '7',
        '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'
    };
	*/
    /**
     * Convert a byte array into its hex String
     * equivalent.
     * @param bytes
     * @return
     */
    /*
    public static String toHex ( byte [] bytes ) {

        if ( bytes == null ) {
            return null;
        }

        StringBuilder buffer = new StringBuilder(bytes.length*2);
        for ( byte thisByte : bytes ) {
            buffer.append(byteToHex(thisByte));
        }

        return buffer.toString();

    }
    */

    /**
     * Convert a single byte into its hex String
     * equivalent.
     * @param b
     * @return
     */
    /*
    private static String byteToHex ( byte b ) {
        char [] array = { HEX_DIGIT[(b >> 4) & 0x0f],
                            HEX_DIGIT[b & 0x0f] };
        return new String(array);
    }
    */

    /**
     * @see: http://stackoverflow.com/a/140861/605890
     */
    public static byte[] hexStringToByteArray(String s) {
        int len = s.length();
        byte[] data = new byte[len / 2];
        for (int i = 0; i < len; i += 2) {
            data[i / 2] = (byte) ((Character.digit(s.charAt(i), 16) << 4)
                                 + Character.digit(s.charAt(i+1), 16));
        }
        return data;
    }

    /*
    for (byte b : bytes) {
		   System.out.format("0x%x ", b);
		}
	*/

    public static void main(String[] args) {
    	byte[] bytes = {(byte) 0xff, (byte) 0xff};
    	System.out.println(HexUtil.hexStringToByteArray(HexUtil.byteArrayToHexString(bytes)));
	}

}
