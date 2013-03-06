package de.dennis_boldt.utils;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.URL;

/**
 * Utils for network
 *
 * @author Dennis Boldt
 *
 */
public class NetworkUtil {

	/**
	 * Checks, if an IP is reachable
	 *
	 * @param ip an IP address
	 * @param timeout a timeout in ms
	 * @return true, if reachable, false otherwise
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
	 * Checks, if an URL (IP+Port) is reachable
	 *
	 * @see: https://github.com/itm/itm-utils/blob/master/src/main/java/de/uniluebeck/itm/tr/util/NetworkUtils.java
	 * @param url a url
	 * @return true, if reachable, false otherwise
	 */
	public static boolean isReachable(URL url) {
		try {
			Socket socket = new Socket(url.getHost(), url.getPort());
			boolean connected = socket.isConnected();
			socket.close();
			return connected;
		} catch (IOException e) {
			System.out.println("Exception for: " + url.getHost() + ":" + url.getPort());
			e.printStackTrace();
			return false;
		}
	}

	// TODO:
	// http://singztechmusings.wordpress.com/2011/05/26/java-how-to-check-if-a-web-page-exists-and-is-available/
}
