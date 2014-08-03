package com.date.longtest;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;

public class DateTest {

	@Test
	public void testLongToDate() {
		
		java.util.Date dt = new Date();
		System.out.println(dt.toString());   //java.util.Date的含义
		long lSysTime1 = dt.getTime() / 1000;   //得到秒数，Date类型的getTime()返回毫秒数
		
		System.out.println("lSysTime1====="+lSysTime1);
		
		SimpleDateFormat sdf= new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
		//前面的lSysTime是秒数，先乘1000得到毫秒数，再转为java.util.Date类型
		java.util.Date dt2 = new Date(lSysTime1 * 1000);  
		String sDateTime = sdf.format(dt2);  //得到精确到秒的表示：08/31/2006 21:08:00
		System.out.println(sDateTime);
	}
	
	@Test
	public void testLongToDate2() {
		long a = 1406964109;
		SimpleDateFormat sdf= new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
		//前面的lSysTime是秒数，先乘1000得到毫秒数，再转为java.util.Date类型
		java.util.Date dt2 = new Date(a * 1000);  
		String sDateTime = sdf.format(dt2);  //得到精确到秒的表示：08/31/2006 21:08:00
		System.out.println(sDateTime);
	}
}
