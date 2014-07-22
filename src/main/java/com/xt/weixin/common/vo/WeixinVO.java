package com.xt.weixin.common.vo;

public interface WeixinVO {
	
	//开发者微信号
	public String getFromUserName();
	
	//发送方帐号（一个OpenID）
	public String getToUserName();
}
