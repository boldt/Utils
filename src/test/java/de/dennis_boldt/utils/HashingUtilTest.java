package de.dennis_boldt.utils;

import org.junit.Assert;
import org.junit.Test;

public class HashingUtilTest {

	@Test
	public void testSha1() {
		byte[] b1 = {(byte)'a',(byte)'b',(byte)'c',(byte)'d'};
		Assert.assertEquals("81fe8bfe87576c3ecb22426f8e57847382917acf", HashingUtil.sha1(b1));

		// echo -n "dddd" | sha1sum
		byte[] b2 = {(byte)'d',(byte)'d',(byte)'d',(byte)'d'};
		Assert.assertEquals("01464e1616e3fdd5c60c0cc5516c1d1454cc4185", HashingUtil.sha1(b2));
	}

	@Test
	public void testMd5() {
		byte[] b1 = {(byte)'a',(byte)'b',(byte)'c',(byte)'d'};
		Assert.assertEquals("e2fc714c4727ee9395f324cd2e7f331f", HashingUtil.md5(b1));

		// echo -n "dddd" | sha1sum
		byte[] b2 = {(byte)'d',(byte)'d',(byte)'d',(byte)'d'};
		Assert.assertEquals("11ddbaf3386aea1f2974eee984542152", HashingUtil.md5(b2));
	}
}
