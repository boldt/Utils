package de.dennis_boldt.utils;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class StreamUtil {

	/**
	 * Converts an InputStream to a String
	 *
	 * @see:
	 *       http://www.mkyong.com/java/how-to-convert-inputstream-to-string-in-java
	 * @param is
	 * @return
	 * @throws IOException
	 */
	public static String toString(InputStream is) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(is));
		StringBuilder sb = new StringBuilder();
		String line;
		while ((line = br.readLine()) != null) {
			sb.append(line);
		}
		br.close();
		return sb.toString();
	}

	/**
	 * Converts a String to an InputStream
	 *
	 * @see:
	 *       http://www.mkyong.com/java/how-to-convert-string-to-inputstream-in-java
	 * @param str
	 * @return
	 * @throws IOException
	 */
	public InputStream toInputStream(String str) throws IOException {
		InputStream is = new ByteArrayInputStream(str.getBytes());
		return is;
	}

}
