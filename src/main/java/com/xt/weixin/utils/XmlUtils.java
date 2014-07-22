package com.xt.weixin.utils;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Iterator;  
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.dom4j.Document;  
import org.dom4j.DocumentException;  
import org.dom4j.Element;  
import org.dom4j.io.SAXReader;  
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

  
public class XmlUtils {  
    
	private static Logger logger = LoggerFactory.getLogger(XmlUtils.class);
	
    /**
     * 工具方法，将xml格式的inputStream转换成Object输出
     * @param input
     * @return
     */
    public static Map<String,String> readXml(String xml){
		Document doc = null;
		SAXReader reader = new SAXReader();
		Map<String,String> readXmlResult = new HashMap<String,String>();
		InputStream is = new ByteArrayInputStream(xml.getBytes());
		try{
			doc = reader.read(is);
			Element root = doc.getRootElement(); //得到根节点  
			for(Iterator i =root.elementIterator(); i.hasNext();){ //对xml进行遍历  
				Element el =(Element) i.next();  
				readXmlResult.put(el.getName(),el.getText());
			}
		}catch(Exception e){
			logger.error("解析xml错误！",e);
		}finally{
			try {
				is.close();
			} catch (IOException e) {
				logger.error("解析xml错误！",e);
			}
		}
    	return readXmlResult;
    }
    
    /**
     * 工具方法，将响应对象转化为xml字符串
     * @param responseVO
     * @return
     */
    public static String writeXml(Object responseVO){ 
    	
    	StringBuilder xml = new StringBuilder("<xml>");
    	Field[] field = responseVO.getClass().getDeclaredFields();     //获取实体类的所有属性，返回Field数组  
    	try{
    		for(int j=0 ; j<field.length ; j++){     //遍历所有属性    
    			String name = field[j].getName();    //获取属性的名字
    			xml.append("<").append(name).append(">"); 
    			if(List.class.getName().equals(field[j].getType().getName())){ //判断属性是不是List的集合 ,    field[j].getType() 该属性的 Class  
    				Method method = responseVO.getClass().getMethod("get" + StringUtils.capitalize(name)); // 获取某个属性的get方法的一个Method对象
    				List list = (List) method.invoke(responseVO); //通过上面获得的Method对象 ，【invoke调用】 调用getter方法获取属性值
    				if(list != null && !list.isEmpty()){
    					for(Object obj : list){  //  循环遍历  list 集合
    						xml.append("<").append(obj.getClass().getSimpleName()).append(">");
    						Field[] fs = obj.getClass().getDeclaredFields(); // 获取【集合里的对象】的所有属性，返回Field数组  
    						for(int k=0 ; k<fs.length ; k++){
    							String itemName = fs[k].getName();
    							if(!itemName.contains("this")){ // 如果是内部类  会包含一个 【 this@..】   的一个属性
	    							xml.append("<").append(itemName.toLowerCase()).append(">"); 
	    							Method itemMethod = obj.getClass().getMethod("get" + StringUtils.capitalize(itemName));
	    			    			String type = fs[k].getGenericType().toString();
	    			    			String itemValue = itemMethod.invoke(obj).toString();  
	    			    			if("class java.lang.String".equals(type)&&itemValue != null){   	 
	    			    				xml.append("<![CDATA[").append(itemValue).append("]]>");  
	    			    			}
	    			    			else{
	    			    				xml.append(itemValue);  
	    			    			}
	    							xml.append("</").append(itemName.toLowerCase()).append(">"); 
	    						}
    						}
    						xml.append("</").append(obj.getClass().getSimpleName()).append(">");
    					}
    				}
    			}else{
	    			String value = null; 
	    			Method method = responseVO.getClass().getMethod("get" + StringUtils.capitalize(name));
	    			String type = field[j].getGenericType().toString();    //获取属性的类型
	    			value = method.invoke(responseVO).toString();    //调用getter方法获取属性值
	    			if("class java.lang.String".equals(type)&&value != null){   //type是类类型，前面包含"class"，后面跟类名	 		
	    				xml.append("<![CDATA[").append(value).append("]]>");  
	    			}
	    			else{
	    				xml.append(value);  
	    			}
    			}
    			xml.append("</").append(name).append(">");
    		}
        }
        catch(Exception e){
        	logger.error("生成xml错误！",e);
        }
        xml.append("</xml>");
    	return xml.toString();
    }
    
}  
