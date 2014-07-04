package com.xt.weixin.service;

import java.util.Date;

import org.springframework.stereotype.Service;

import com.xt.weixin.common.vo.EventRequestVO;
import com.xt.weixin.common.vo.TextResponseVO;



@Service("eventMsgService")
public class EventMsgService {
	
	
	public TextResponseVO handleEventMsg(EventRequestVO eventRequestVO) {
		
//		TextResponseVO textResponseVO = 
	//		new TextResponseVO(eventRequestVO.getToUserName(), eventRequestVO.getFromUserName(), 
		//			new Date().getTime(), "text", "www.baidu.com");
		
		TextResponseVO textResponseVO = new TextResponseVO();
		String openId = eventRequestVO.getFromUserName();
		textResponseVO.setToUserName(eventRequestVO.getFromUserName());
		textResponseVO.setFromUserName(eventRequestVO.getToUserName());
		textResponseVO.setMsgType("text");
		textResponseVO.setContent("请点击这个链接输入手机验证：http://ydjr.feease.com/waiterReport.list.action?openId="+openId);
		textResponseVO.setCreateTime(new Date().getTime());
		
		return textResponseVO;
	}
}
