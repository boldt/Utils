package de.dennis_boldt.utils;

import java.util.LinkedList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ArrayUtilTest {

	private List<String> stringList = null;
	private List<Integer> intList = null;

	private String[] stringArray = null;
	private Integer[] intArray = null;

	@Before
	public void setUp() {
		stringList = new LinkedList<String>();
		stringList.add("a");
		stringList.add("b");
		stringList.add("c");
		intList = new LinkedList<Integer>();
		intList.add(1);
		intList.add(2);
		intList.add(3);
		stringArray = new String[] {"a", "b", "c"};
		intArray = new Integer[] {1, 2, 3};
	}

	@Test
	public void testConcat() {
		String[] result = new String[] {"a", "b", "c", "a", "b", "c"};
		Assert.assertArrayEquals(result, ArrayUtil.concat(stringArray, stringArray));
	}

	@Test
	public void testConcat1() {
		byte[] b1 = {1,2,3,4};
		byte[] b2 = {5,6};
		byte[] b3 = {1,2,3,4,5,6};
		Assert.assertArrayEquals(b3, ArrayUtil.concat(b1, b2));
	}

	@Test
	public void testConcat2() {

		byte[] b1 = {};
		byte[] b2 = {};
		byte[] b3 = {};

		Assert.assertArrayEquals(b3, ArrayUtil.concat(b1, b2));
	}

	@Test
	public void testConcat3() {

		byte[] b1 = {1,2,3,4};
		byte[] b2 = {};
		byte[] b3 = {1,2,3,4};

		Assert.assertArrayEquals(b3, ArrayUtil.concat(b1, b2));
	}

	@Test
	public void testConcat4() {

		byte[] b1 = {};
		byte[] b2 = {1,2,3,4};
		byte[] b3 = {1,2,3,4};

		Assert.assertArrayEquals(b3, ArrayUtil.concat(b1, b2));
	}

	@Test
	public void testImplode() {
		Assert.assertEquals("a,b,c", ArrayUtil.join(stringArray, ","));
		Assert.assertEquals("1,2,3", ArrayUtil.join(intArray, ","));
	}

	@Test
	public void testInArray() {
		Assert.assertTrue(ArrayUtil.contains(stringArray, "a"));
		Assert.assertFalse(ArrayUtil.contains(stringArray, "d"));
		Assert.assertTrue(ArrayUtil.contains(intArray, new Integer(1)));
		Assert.assertFalse(ArrayUtil.contains(intArray, new Integer(4)));
	}

	@Test
	public void testToArray() {
		Assert.assertEquals(stringList, ArrayUtil.toList(stringArray));
		Assert.assertEquals(intList, ArrayUtil.toList(intArray));
	}


}
