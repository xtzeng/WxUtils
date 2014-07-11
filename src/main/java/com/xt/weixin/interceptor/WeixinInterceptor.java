package com.xt.weixin.interceptor;


import java.io.InputStream;
import java.io.PrintWriter;
import java.security.MessageDigest;
import java.util.Arrays;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.ServletActionContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;
import com.xt.weixin.action.WeixinAction;
import com.xt.weixin.common.vo.WeixinVO;
import com.xt.weixin.utils.WeixinUtils;
import com.xt.weixin.utils.XmlUtils;

public class WeixinInterceptor implements Interceptor{
	
	/**
	 */
	private static final long serialVersionUID = 1L;

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	private final String TOKEN = "token";
	
	@Override
	public void destroy() {
	}

	@Override
	public void init() {
	}

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {	
		if(!(invocation.getAction() instanceof WeixinAction)){
			return invocation.invoke();
		} 
		
		logger.debug("weixin拦截器【start】");
		
		ActionContext ctx = ActionContext.getContext();
		HttpServletRequest request = (HttpServletRequest)ctx.get(ServletActionContext.HTTP_REQUEST);
		WeixinAction weixinAction = (WeixinAction)invocation.getAction();
		//0 读取xml
		InputStream inputStream = request.getInputStream();
		String xml = IOUtils.toString(inputStream, "UTF-8");
		
		logger.debug("接受到的xml:\n" + xml);
		
		//1 token验证
		try{
			boolean validateResult = validateTencentToken(request);
			if(!validateResult){
				return Action.ERROR;
			}
		}catch(Throwable e){
			logger.info("拦截器验证错误",e);
			return Action.ERROR;
		}
		
		
		//2. 如果是初始化接入请求则直接返回echostr
		if(StringUtils.isBlank(xml)){
			logger.info("响应腾讯初始化接入【start】");
			HttpServletResponse response = ServletActionContext.getResponse();
			PrintWriter writer = response.getWriter();
			writer.print(request.getParameter("echostr"));
			logger.info("echostr: " + request.getParameter("echostr"));
			logger.info("响应腾讯初始化接入【end】");
			return null;
		}
		
		//2. xml对象化
		WeixinVO weixinModel = convertXml2RequestVO(xml);
        
        //设置weixinModel
        weixinAction.setWeixinModel(weixinModel);
        
		logger.debug("weixin拦截器【end】");
		return invocation.invoke();
	}

	private boolean validateTencentToken(HttpServletRequest request) {
		logger.debug("微信验证【start】");
		
		boolean result = false;
		//微信加密签名，signature结合了开发者填写的token参数和请求中的timestamp参数、nonce参数。
		String signature = request.getParameter("signature") == null ? "":request.getParameter("signature");
		logger.debug("signature:"+signature);
		
		//时间戳
		String timestamp = request.getParameter("timestamp") == null ? "":request.getParameter("timestamp");
		logger.debug("timestamp:"+timestamp);
		
		//随机数
		String nonce = request.getParameter("nonce") == null ? "":request.getParameter("nonce");
		logger.debug("nonce:"+nonce);
		
		//随机字符串
		String echostr = request.getParameter("echostr") == null ? "":request.getParameter("echostr");
		logger.debug("echostr:"+echostr);

		if(checkSignature(signature,timestamp,nonce, TOKEN)){
			logger.debug("验证通过！");
			result = true;
		}else{
			logger.debug("验证失败！");
		}
		
		logger.debug("微信验证[done]");
		return result;
	}

	/**
	 * 转换xml为RequestVO对象
	 * @param xml
	 * @return
	 */
	private WeixinVO convertXml2RequestVO(String xml) {
		WeixinVO weixinModel;
        
        //将xml文本转换成MsgTextObj对象
        Map<String, String> xmlParseResult= XmlUtils.readXml(xml); 

        logger.debug("解析出来的FromUserName:" + xmlParseResult.get("FromUserName"));
        //根据解析结果判断生成什么vo            
        if(StringUtils.equals(xmlParseResult.get("MsgType"), "text")){
        	logger.debug("解析文本信息");
        	weixinModel = WeixinUtils.generateTextMsgVO(xmlParseResult);
        	
        }else if(StringUtils.equals(xmlParseResult.get("MsgType"), "event")){
        	logger.debug("解析事件信息");
        	weixinModel = WeixinUtils.generateEventMsgVO(xmlParseResult);
        }else{
        	logger.debug("无法识别的信息类型");
        	weixinModel = WeixinUtils.generateEventMsgVO(xmlParseResult);
        }

        logger.debug("转换成的weixinModel:" + weixinModel);
		return weixinModel;
	}
	
	
	//微信接口验证  
    public boolean checkSignature(String signature, String timestamp, String nonce, String token){  
        String[] tmpArr={token,timestamp,nonce};  
        Arrays.sort(tmpArr);  
        String tmpStr=this.ArrayToString(tmpArr);  
        tmpStr=this.SHA1Encode(tmpStr);
        logger.debug("actual: " + tmpStr);
        if(tmpStr.equalsIgnoreCase(signature)){  
            return true;  
        }else{  
            return false;  
        }  
    }
    //数组转字符串  
    public String ArrayToString(String [] arr){  
        StringBuffer bf = new StringBuffer();  
        for(int i = 0; i < arr.length; i++){  
         bf.append(arr[i]);  
        }  
        return bf.toString();  
    }
    
  //sha1加密  
    public String SHA1Encode(String sourceString) {  
        String resultString = null;  
        try {  
           resultString = new String(sourceString);  
           MessageDigest md = MessageDigest.getInstance("SHA-1");  
           resultString = byte2hexString(md.digest(resultString.getBytes()));  
        } catch (Exception ex) {  
        }  
        return resultString;  
    }
    
    public final String byte2hexString(byte[] bytes) {  
        StringBuffer buf = new StringBuffer(bytes.length * 2);  
        for (int i = 0; i < bytes.length; i++) {  
            if (((int) bytes[i] & 0xff) < 0x10) {  
                buf.append("0");  
            }  
            buf.append(Long.toString((int) bytes[i] & 0xff, 16));  
        }  
        return buf.toString().toUpperCase();  
    }
    
	
	

}
