package de.dennis_boldt.utils;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ArrayUtilTest {

	private String[] stringArray = null;
	private Integer[] intArray = null;

	@Before
	public void setUp() {
		stringArray = new String[] {"a", "b", "c"};
		intArray = new Integer[] {1, 2, 3};
	}

	@Test
	public void testConcat() {
		String[] result = new String[] {"a", "b", "c", "a", "b", "c"};
		Assert.assertArrayEquals(result, ArrayUtil.concat(stringArray, stringArray));
	}

	@Test
	public void testImplode() {
		Assert.assertEquals("a,b,c", ArrayUtil.implode(stringArray, ","));
		Assert.assertEquals("1,2,3", ArrayUtil.implode(intArray, ","));
	}

	@Test
	public void testInArray() {
		Assert.assertTrue(ArrayUtil.contains(stringArray, "a"));
		Assert.assertFalse(ArrayUtil.contains(stringArray, "d"));
		Assert.assertTrue(ArrayUtil.contains(intArray, new Integer(1)));
		Assert.assertFalse(ArrayUtil.contains(intArray, new Integer(4)));
	}

}
