package com.propertiestest;

import org.junit.Test;

import com.xt.weixin.utils.PropertiesConfig;

public class PropertiesConfigTest {

	@Test
	public void testHello() {
		
		System.out.println(PropertiesConfig.getInstance().get("sys.url"));
	}
}
