package de.dennis_boldt.utils;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;

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

	public static byte[] toArray(Object o) throws IOException {
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		ObjectOutput out = null;
		try {
		  out = new ObjectOutputStream(bos);
		  out.writeObject(o);
		  return bos.toByteArray();
		} finally {
		  out.close();
		  bos.close();
		}
	}

	public static Object toObject(byte[] bytes) throws IOException, ClassNotFoundException {
		ByteArrayInputStream bis = new ByteArrayInputStream(bytes);
		ObjectInput in = null;
		try {
		  in = new ObjectInputStream(bis);
		  return in.readObject();
		} finally {
		  bis.close();
		  in.close();
		}

	}

}
