package de.dennis_boldt.utils;

import java.net.InetAddress;

public class NetworkUtils {

	public static boolean isHostAlive(final InetAddress ip, int timeout) {
		try {
			return ip.isReachable(timeout);
		} catch (Exception e) {
			// e.printStackTrace();
			return false;
		}
	}

}
