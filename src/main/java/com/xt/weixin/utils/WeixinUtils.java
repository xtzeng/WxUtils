package com.xt.weixin.utils;

import java.util.Map;

import org.apache.commons.collections.MapUtils;

import com.xt.weixin.common.vo.EventRequestVO;
import com.xt.weixin.common.vo.TextResquestVO;



/**
 * 将xml解析出来的map对象转换为具体的 weixin VO 
 * @author Administrator
 *
 */
public class WeixinUtils {

	/**
	 * 转换为文本对象
	 * @param readXmlResult
	 * @return
	 */
	public static TextResquestVO generateTextMsgVO(Map<String,String> readXmlResult){
		TextResquestVO msgTextObj = new TextResquestVO();
		msgTextObj.setToUserName(readXmlResult.get("ToUserName"));
	    msgTextObj.setFromUserName(readXmlResult.get("FromUserName"));
	    msgTextObj.setCreateTime(Integer.parseInt(readXmlResult.get("CreateTime")));
	    msgTextObj.setMsgType(readXmlResult.get("MsgType"));
	    msgTextObj.setContent(readXmlResult.get("Content"));
	    msgTextObj.setMsgId(Long.parseLong(readXmlResult.get("MsgId")));
	    return msgTextObj;
	}
	
	
	public static EventRequestVO generateEventMsgVO(Map<String, String> readXmlResult) {
		EventRequestVO eventRequestVO = new EventRequestVO();
		eventRequestVO.setToUserName(MapUtils.getString(readXmlResult, "ToUserName"));
		eventRequestVO.setFromUserName(MapUtils.getString(readXmlResult, "FromUserName"));
		eventRequestVO.setCreateTime(MapUtils.getLongValue(readXmlResult, "CreateTime"));
		eventRequestVO.setMsgType(MapUtils.getString(readXmlResult, "MsgType"));
		
		eventRequestVO.setEvent(MapUtils.getString(readXmlResult, "Event"));
		eventRequestVO.setEventKey(MapUtils.getString(readXmlResult, "EventKey"));
		
		eventRequestVO.setTicket(MapUtils.getString(readXmlResult, "Ticket"));
		
		
		eventRequestVO.setLatitude(MapUtils.getString(readXmlResult, "Latitude"));
		eventRequestVO.setLongitude(MapUtils.getString(readXmlResult, "Longitude"));
		eventRequestVO.setPrecision(MapUtils.getString(readXmlResult, "Precision"));
		
		return eventRequestVO;
	}
	
	/**
	 * 交换发送方和接收方
	 * @param weixinModel
	 * @return
	 */
	public static Object changeLocation(Object weixinModel){
		if(weixinModel instanceof TextResquestVO){
			TextResquestVO textMsgVO = (TextResquestVO) weixinModel;
			String temp = null;
			temp = textMsgVO.getFromUserName();
			textMsgVO.setFromUserName(textMsgVO.getToUserName());
			textMsgVO.setToUserName(temp);	
			weixinModel = textMsgVO;
		}
		return weixinModel;
	}

}
