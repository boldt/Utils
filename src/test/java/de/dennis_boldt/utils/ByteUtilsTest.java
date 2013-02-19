package de.dennis_boldt.utils;

import org.junit.Assert;
import org.junit.Test;

public class ByteUtilsTest {

	@Test
	public void testConcat1() {
		byte[] b1 = {1,2,3,4};
		byte[] b2 = {5,6};
		byte[] b3 = {1,2,3,4,5,6};
		Assert.assertArrayEquals(b3, ByteUtils.concat(b1, b2));
	}

	@Test
	public void testConcat2() {

		byte[] b1 = {};
		byte[] b2 = {};
		byte[] b3 = {};

		Assert.assertArrayEquals(b3, ByteUtils.concat(b1, b2));
	}

	@Test
	public void testConcat3() {

		byte[] b1 = {1,2,3,4};
		byte[] b2 = {};
		byte[] b3 = {1,2,3,4};

		Assert.assertArrayEquals(b3, ByteUtils.concat(b1, b2));
	}

	@Test
	public void testConcat4() {

		byte[] b1 = {};
		byte[] b2 = {1,2,3,4};
		byte[] b3 = {1,2,3,4};

		Assert.assertArrayEquals(b3, ByteUtils.concat(b1, b2));
	}
}
