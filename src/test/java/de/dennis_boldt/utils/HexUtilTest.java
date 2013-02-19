package de.dennis_boldt.utils;

import org.junit.Assert;
import org.junit.Test;

public class HexUtilTest {

	byte[] bytes1 = {(byte) 0x00, (byte) 0x00};
	String str1 = "0000".toLowerCase();

	byte[] bytes2 = {(byte) 0xff, (byte) 0xff};
	String str2 = "FFFF".toLowerCase();

	@Test
	public void testByteArrayToHexString() {
		Assert.assertEquals(str1, HexUtil.byteArrayToHexString(bytes1).toLowerCase());
		Assert.assertEquals(str2, HexUtil.byteArrayToHexString(bytes2).toLowerCase());
	}

	@Test
	public void testHexStringToByteArray() {
		Assert.assertArrayEquals(bytes1, HexUtil.hexStringToByteArray(str1));
		Assert.assertArrayEquals(bytes2, HexUtil.hexStringToByteArray(str2));
	}

	@Test
	public void testDouble() {
		Assert.assertArrayEquals(bytes1, HexUtil.hexStringToByteArray(HexUtil.byteArrayToHexString(bytes1)));
		Assert.assertEquals(str1, HexUtil.byteArrayToHexString(HexUtil.hexStringToByteArray(str1)).toLowerCase());
		Assert.assertArrayEquals(bytes2, HexUtil.hexStringToByteArray(HexUtil.byteArrayToHexString(bytes2)));
		Assert.assertEquals(str2, HexUtil.byteArrayToHexString(HexUtil.hexStringToByteArray(str2)).toLowerCase());
	}

}
