package de.dennis_boldt.utils;

import org.junit.Assert;
import org.junit.Test;

public class RandomTest {

	@Test
	public void testGetRandomFromTo() {
		Assert.assertEquals(0, Random.getRandomFromTo(0,0));
		Assert.assertEquals(1, Random.getRandomFromTo(1,1));

		int rand1 = Random.getRandomFromTo(0,1);
		Assert.assertTrue(rand1 >= 0 && rand1 <= 1);

		int rand2 = Random.getRandomFromTo(1,2);
		Assert.assertTrue(rand2 >= 1 && rand2 <= 2);

		int rand3 = Random.getRandomFromTo(1,10);
		Assert.assertTrue(rand3 >= 1 && rand3 <= 10);
	}

	@Test
	public void testGetRandomInteger() {
		int rand = Random.getRandomInteger();
		Assert.assertTrue(rand <= Integer.MAX_VALUE && rand <= Integer.MAX_VALUE);
	}

	@Test
	public void testGetRandomPositiveInteger() {
		int rand = Random.getRandomPositiveInteger();
		Assert.assertTrue(rand  >= 0 && rand <= Integer.MAX_VALUE);
	}

	@Test
	public void testGetRandomBytes() {
		Assert.assertEquals(4, Random.getRandomBytes(4).length);
	}

	@Test
	public void testGetRandomHex() {
		String value = Random.getRandomHex(4);
		Assert.assertEquals(8, value.length());
	}

	// TODO: getRandomBigInteger
}
