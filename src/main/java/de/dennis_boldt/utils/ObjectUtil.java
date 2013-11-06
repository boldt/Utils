package de.dennis_boldt.utils;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;

public class ObjectUtil {

	/**
	 * Converts an object to its byte representation
	 *
	 * @param o
	 * @return
	 * @throws IOException
	 */
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

	/**
	 * Converts a byte representation to its object
	 *
	 * @param o
	 * @return
	 * @throws IOException
	 */
	public static Object toObject(byte[] bytes) throws IOException,
			ClassNotFoundException {
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
