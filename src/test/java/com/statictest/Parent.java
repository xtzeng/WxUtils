package com.statictest;

class Parent{ 
	
	static String name = "hello"; 
	
	{ 
		System.out.println("parent block"); 
	} 
	static { 
		System.out.println("parent static block"); 
	} 
	
	public Parent(){ 
		System.out.println("parent constructor"); 
	} 
} 

