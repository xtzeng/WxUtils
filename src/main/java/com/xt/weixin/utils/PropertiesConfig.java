package com.xt.weixin.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesConfig extends Properties{

	/**
	 */
	private static final long serialVersionUID = 1L;
	
	private static  PropertiesConfig instance; 
	
	public static PropertiesConfig getInstance () {  
		
		if(null != instance) {            
			return instance;        
		} else {           
			makeInstance();            
			return instance;        
		}   
	} 
	
	private static synchronized void makeInstance() {   
		 if(instance == null) {     
			 instance = new PropertiesConfig();      
			 }    
	} 
	
	/**
	 * constructor
	 */
	private PropertiesConfig() {
		
		InputStream is = getClass().getResourceAsStream("/global.properties");         
		try {            
			load(is);        
		} catch (IOException e) {           
			e.printStackTrace();         
		}  
	} 
}
