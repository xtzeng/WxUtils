package com.xt.weixin.action;


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
	

	
	/**
	 * 分发微信发过来的请求
	 */
	public void weixinDispatch() {
		
		//根据信息对象的类型分发到不同的service去处理
		if (weixinModel instanceof TextResquestVO) {
			
			TextResquestVO textVO = (TextResquestVO)weixinModel;
			String content = textVO.getContent();
			if(StringUtils.equals(content, "baidu")){
				
				Object responseVO = textMsgService.handleTextMsg(textVO);
				write(XmlUtils.writeXml(responseVO));
				logger.debug("weixinModel is a type of TextRequ");
			}else if (StringUtils.equals(content, "layout")) {
				
				Object responseVO = textMsgService.handlePictureMessage(textVO);
				write(XmlUtils.writeXml(responseVO));
				logger.debug("【layout】");
			}else if(StringUtils.equals(content, "link")) {
				
				Object responseVO = textMsgService.handleLinkMessage(textVO);
				write(XmlUtils.writeXml(responseVO));
				logger.debug("【link】");
			}
			
			
		}else if( weixinModel instanceof EventRequestVO ){
			EventRequestVO eventVo = (EventRequestVO) weixinModel;
	
		
			logger.debug("weixinModel is a type of CLICK !  key ： " + eventVo.getEventKey());

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
