package com.xt.weixin.common.vo;

public class LinkResponseVO  implements WeixinVO{

	// 开发者微信号 
    private String ToUserName; 
    // 发送方帐号（一个OpenID） 
    private String FromUserName; 
    // 消息创建时间 （整型） 
    private long CreateTime; 
    // 消息类型（text/image/location/link） 
    private String MsgType; 
	// 消息标题 
    private String Title; 
    // 消息描述 
    private String Description; 
    // 消息链接 
    private String Url;
    
    
    
	public LinkResponseVO(String toUserName, String fromUserName,
			long createTime, String msgType,  String title,
			String description, String url) {
		super();
		ToUserName = toUserName;
		FromUserName = fromUserName;
		CreateTime = createTime;
		MsgType = msgType;
		Title = title;
		Description = description;
		Url = url;
	}
	
	public LinkResponseVO() {
		
	}

	public String getToUserName() {
		return ToUserName;
	}
	public void setToUserName(String toUserName) {
		ToUserName = toUserName;
	}
	public String getFromUserName() {
		return FromUserName;
	}
	public void setFromUserName(String fromUserName) {
		FromUserName = fromUserName;
	}
	public long getCreateTime() {
		return CreateTime;
	}
	public void setCreateTime(long createTime) {
		CreateTime = createTime;
	}
	public String getMsgType() {
		return MsgType;
	}
	public void setMsgType(String msgType) {
		MsgType = msgType;
	}

	public String getTitle() {
		return Title;
	}
	public void setTitle(String title) {
		Title = title;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	public String getUrl() {
		return Url;
	}
	public void setUrl(String url) {
		Url = url;
	} 
    
    
    
}
