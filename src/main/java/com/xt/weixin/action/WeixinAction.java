package com.xt.weixin.action;

import java.sql.SQLException;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;



import com.opensymphony.xwork2.ActionContext;
import com.xt.weixin.action.base.BaseAction;
import com.xt.weixin.action.base.WeixinModelDriven;
import com.xt.weixin.common.vo.EventRequestVO;
import com.xt.weixin.common.vo.TextResquestVO;
import com.xt.weixin.common.vo.WeixinVO;
import com.xt.weixin.service.SubscriptionCountService;
import com.xt.weixin.service.TextMsgService;
import com.xt.weixin.utils.XmlUtils;

@Controller("weixinAction")
@Scope("prototype")
public class WeixinAction extends BaseAction implements WeixinModelDriven{
	private static final long serialVersionUID = 1L;
    public static final String Token = "token";   
	
    private String xml = "";
	private WeixinVO weixinModel;
	
	ActionContext ctx = ActionContext.getContext();
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Resource(name="textMsgService")
	private TextMsgService textMsgService;
	
//	@Resource(name="eventMsgService")
//	private EventMsgService eventMsgService;
	
//	@Resource(name="userService")
//	private UserService userService;
	
	@Resource(name="subscriptionCountService")
	private SubscriptionCountService subscriptionCountService;
	
	/**
	 * 分发腾讯发过来的请求
	 */
	public void weixinDispatch() {
		
		//根据信息对象的类型分发到不同的service去处理
		if (weixinModel instanceof TextResquestVO) {
			TextResquestVO textVO = (TextResquestVO)weixinModel;
			String content = textVO.getContent();
			if(StringUtils.equals(content, "系统")){
				//如果用户发的是文本信息，而且文本内容为系统，返回系统链接
				Object responseVO = textMsgService.handleTextMsg(textVO);
				write(XmlUtils.writeXml(responseVO));
				logger.debug("weixinModel is a type of TextRequ");
			}
		}else if( weixinModel instanceof EventRequestVO ){
			EventRequestVO eventVo = (EventRequestVO) weixinModel;
	
			if("CLICK".equals(eventVo.getEvent())&&"V1001_LOGIN".equals(eventVo.getEventKey())){
				Object responseVO = textMsgService.handleLoginTextMsg(eventVo);
				write(XmlUtils.writeXml(responseVO));
			}

			logger.debug("weixinModel is a type of CLICK !  key ： " + eventVo.getEventKey());

		}else{
			logger.debug("undefine type of weixinModel");
		}

	}
	


	public void dxjcDispatch() {
		
		if( weixinModel instanceof EventRequestVO ){
			EventRequestVO eventVo = (EventRequestVO) weixinModel;
	
		    if("CLICK".equals(eventVo.getEvent())&&"CONTACT".equals(eventVo.getEventKey())){
				
		    	
		    	Object responseVO = textMsgService.handleLoginTextContact(eventVo);
				write(XmlUtils.writeXml(responseVO));
			}else if("CLICK".equals(eventVo.getEvent())&&"UNHEARD".equals(eventVo.getEventKey())){
				
				//订阅号统计
				//微信返回页面显示
				Object responseVO = textMsgService.handlePictureTextUnheard(eventVo);
				write(XmlUtils.writeXml(responseVO));
			}else if("CLICK".equals(eventVo.getEvent())&&"PRIVILEGES".equals(eventVo.getEventKey())){
				
				//订阅号统计
				//微信返回页面显示
				Object responseVO = textMsgService.handlePictureTextPrivileges(eventVo);
				write(XmlUtils.writeXml(responseVO));
			}else if("CLICK".equals(eventVo.getEvent())&&"FISH".equals(eventVo.getEventKey())){
				
				//订阅号统计
				//微信返回页面显示
				Object responseVO = textMsgService.handlePictureTextFish(eventVo);
				write(XmlUtils.writeXml(responseVO));
			}else if("CLICK".equals(eventVo.getEvent())&&"STEP".equals(eventVo.getEventKey())){
				
				//订阅号统计
				//微信返回页面显示
				Object responseVO = textMsgService.handlePictureTextStep(eventVo);
				write(XmlUtils.writeXml(responseVO));
			}else if("CLICK".equals(eventVo.getEvent())&&"FEEDBACK".equals(eventVo.getEventKey())){
				
				//订阅号统计
				//微信返回页面显示
				Object responseVO = textMsgService.handlePictureTextFeedBack(eventVo);
				write(XmlUtils.writeXml(responseVO));
			}else if("CLICK".equals(eventVo.getEvent())&&"POPULARSTAR".equals(eventVo.getEventKey())){
				
				//订阅号统计
				//微信返回页面显示
				Object responseVO = textMsgService.handlePictureTextPopularStar(eventVo);
				write(XmlUtils.writeXml(responseVO));
			}

			logger.debug("weixinModel is a type of CLICK !  key ： " + eventVo.getEventKey());

		}else if( weixinModel instanceof TextResquestVO ){
			TextResquestVO textVO = (TextResquestVO)weixinModel;
			String content = textVO.getContent();
			if(StringUtils.equals(content, "陈奕迅")){
				Object responseVO = textMsgService.handlePictureTextPrivileges(textVO);
				write(XmlUtils.writeXml(responseVO));
			}else{
				Object responseVO = textMsgService.handlePictureTextPopularStar(textVO);
				write(XmlUtils.writeXml(responseVO));
			}
			
			
		}else{
			logger.debug("undefine type of weixinModel");
			
		}
		
		
	}
	
	
	@Override
	public void setWeixinModel(WeixinVO weixinModel) {
		this.weixinModel = weixinModel;
	}
	
	public String getXml() {
		return xml;
	}

	public void setXml(String xml) {
		this.xml = xml;
	}

}
