package com.xt.weixin.api.http;

import org.junit.Test;


public class MenuUtilTest {

	@Test
	public void testGetAccessToken() {
		
		System.out.println(MenuUtil.getAccess_token());
	}
	
	
	@Test
	public void testDeletMenu() {
		System.out.println(MenuUtil.deleteMenu());
	}
}
