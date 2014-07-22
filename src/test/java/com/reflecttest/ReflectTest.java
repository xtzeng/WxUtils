package com.reflecttest;

import org.junit.Test;


public class ReflectTest {

	
	@Test
	public void testGetSimpleName() {
		
		Object object = new Miao(1, "喵喵", "男");
		
		String s = object.getClass().getSimpleName();
		System.out.println(s);
	}
	
	
	
}
