package de.dennis_boldt.utils;

import org.junit.Assert;
import org.junit.Test;

public class RandomTest {

	@Test
	public void testGetRandomFromTo() {
		Assert.assertEquals(0, RandomUtil.getRandomFromTo(0,0));
		Assert.assertEquals(1, RandomUtil.getRandomFromTo(1,1));

		int rand1 = RandomUtil.getRandomFromTo(0,1);
		Assert.assertTrue(rand1 >= 0 && rand1 <= 1);

		int rand2 = RandomUtil.getRandomFromTo(1,2);
		Assert.assertTrue(rand2 >= 1 && rand2 <= 2);

		int rand3 = RandomUtil.getRandomFromTo(1,10);
		Assert.assertTrue(rand3 >= 1 && rand3 <= 10);
	}

	@Test
	public void testGetRandomInteger() {
		int rand = RandomUtil.getRandomInteger();
		Assert.assertTrue(rand <= Integer.MAX_VALUE && rand <= Integer.MAX_VALUE);
	}

	@Test
	public void testGetRandomPositiveInteger() {
		int rand = RandomUtil.getRandomPositiveInteger();
		Assert.assertTrue(rand  >= 0 && rand <= Integer.MAX_VALUE);
	}

	@Test
	public void testGetRandomBytes() {
		Assert.assertEquals(4, RandomUtil.getRandomBytes(4).length);
	}

	@Test
	public void testGetRandomHex() {
		String value = RandomUtil.getRandomHex(4);
		Assert.assertEquals(8, value.length());
	}

	// TODO: getRandomBigInteger
}
