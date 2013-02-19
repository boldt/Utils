package de.dennis_boldt.utils;

import java.net.InetAddress;
import java.net.UnknownHostException;

import org.junit.Assert;
import org.junit.Test;

public class NetworkUtilsTest {

	@Test
	public void testIsHostAlive() {
		InetAddress address = null;
		try {
			address = InetAddress.getByName("127.0.0.1");
		} catch (UnknownHostException e) { }
		Assert.assertTrue(NetworkUtils.isHostAlive(address, 2500));
	}

	@Test
	public void testIsHostNotAlive() {
		InetAddress address = null;
		try {
			address = InetAddress.getByName("192.168.254.254");
		} catch (UnknownHostException e) { }
		Assert.assertFalse(NetworkUtils.isHostAlive(address, 2500));
	}

}
