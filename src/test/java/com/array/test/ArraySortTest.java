package com.array.test;

import java.util.Arrays;

import org.junit.Test;

public class ArraySortTest {

	
	@Test
	public void testSort() {
		
		String []strArr = {"abc","124","ced"};
		
		for (int i = 0; i < strArr.length; i++) {
			System.out.println(strArr[i]);
		}
		
		System.out.println("--------------------");
		Arrays.sort(strArr);
		
		for (int i = 0; i < strArr.length; i++) {
			System.out.println(strArr[i]);
		}
	}
}
