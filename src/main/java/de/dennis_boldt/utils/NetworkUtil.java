package de.dennis_boldt.utils;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.URL;

public class NetworkUtil {

	/**
	 * TODO
	 *
	 * @param ip
	 * @param timeout
	 * @return
	 */
	public static boolean isReachable(final InetAddress ip, int timeout) {
		try {
			return ip.isReachable(timeout);
		} catch (Exception e) {
			// e.printStackTrace();
			return false;
		}
	}

	/**
	 * TODO
	 *
	 * @see: https://github.com/itm/itm-utils/blob/master/src/main/java/de/uniluebeck/itm/tr/util/NetworkUtils.java
	 *
	 * @param url
	 * @return
	 */
	public static boolean isReachable(URL url) {
		try {
			Socket socket = new Socket(url.getHost(), url.getPort());
			boolean connected = socket.isConnected();
			socket.close();
			return connected;
		} catch (IOException e) {
			return false;
		}
	}

}
