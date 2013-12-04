/**
 * Copyright (c) 2009 Mark S. Kolich
 * http://mark.kolich.com
 *
 * Permission is hereby granted, free of charge, to any person
 * obtaining a copy of this software and associated documentation
 * files (the "Software"), to deal in the Software without
 * restriction, including without limitation the rights to use,
 * copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the
 * Software is furnished to do so, subject to the following
 * conditions:
 *
 * The above copyright notice and this permission notice shall be
 * included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
 * EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES
 * OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 * NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT
 * HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY,
 * WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING
 * FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR
 * OTHER DEALINGS IN THE SOFTWARE.
*/

package de.dennis_boldt.helpers;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

/**
 * Source:
 * - http://mark.koli.ch/2009/05/howto-using-javas-securerandom-javasecuritysecurerandom.html
 * - http://docs.oracle.com/javase/7/docs/api/java/security/SecureRandom.html
 *
 * It is package private, so it is not accessible by other packages
 *
 * @author Mark S. Kolich
 */
public class SecureRandomNumber {

	/**
	 * Get the number of next random bits in this SecureRandom
	 * generators' sequence.
	 * @param size how many random bits you want
	 * @return
	 * @throws IllegalArgumentException if the arg isn't divisible by eight
	 */
	public static byte [] getSecureRandom ( int bits ) {

		System.out.println("getSecureRandom - start");

		// Make sure the number of bits we're asking for is at least
		// divisible by 8.
		if ( (bits % 8) != 0 ) {
			throw new IllegalArgumentException("Size is not divisible by 8!");
		}

		byte [] bytes = new byte[ bits / 8 ];

		SecureRandom sRandom = null;
		try {
			sRandom = SecureRandom.getInstance( "SHA1PRNG" );
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			return null;
		}

	    // Get the next 64 random bits. Forces SecureRandom
	    // to seed itself before returning the bytes.
	    sRandom.nextBytes(bytes);

		System.out.println("getSecureRandom - end");

	    return bytes;
	}
}
