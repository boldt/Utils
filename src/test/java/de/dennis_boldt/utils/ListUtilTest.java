package de.dennis_boldt.utils;

import java.util.LinkedList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ListUtilTest {

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
	public void testImplode() {
		Assert.assertEquals("a,b,c", ListUtil.join(stringList, ","));
		Assert.assertEquals("1,2,3", ListUtil.join(intList, ","));
	}

	@Test
	public void testToArray() {
		Assert.assertArrayEquals(stringArray, ListUtil.toArray(stringList));
		Assert.assertArrayEquals(intArray, ListUtil.toArray(intList));
	}

}
