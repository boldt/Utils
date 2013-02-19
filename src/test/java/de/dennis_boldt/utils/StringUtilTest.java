package de.dennis_boldt.utils;


import org.junit.Assert;
import org.junit.Test;

public class StringUtilTest {

	@Test
	public void testImplode() {
		String[] array = new String[] {"a", "b", "c"};
		System.out.println(StringUtil.implode(array, ","));
		Assert.assertEquals("a,b,c", StringUtil.implode(array, ","));
	}

}
