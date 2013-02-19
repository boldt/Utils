package de.dennis_boldt.utils;

import org.junit.Assert;
import org.junit.Test;

public class ArrayUtilTest {

	@Test
	public void testConcat() {
		String[] a = new String[] {"a", "b", "c"};
		String[] b = new String[] {"d", "e", "f"};
		String[] c = new String[] {"a", "b", "c", "d", "e", "f"};
		Assert.assertArrayEquals(c, ArrayUtil.concat(a, b));
	}
}
