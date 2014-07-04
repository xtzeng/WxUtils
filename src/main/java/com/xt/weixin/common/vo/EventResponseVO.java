package com.xt.weixin.common.vo;

public class EventResponseVO implements WeixinVO {

	// 开发者微信号 
    private String ToUserName; 
    // 发送方帐号（一个OpenID） 
    private String FromUserName; 
    // 消息创建时间 （整型） 
    private long CreateTime; 
    // 消息类型（text/image/location/link） 
    private String MsgType; 
    
    //
    private String event;
    

    
    
	public EventResponseVO(String toUserName, String fromUserName,
			long createTime, String msgType, String event) {
		super();
		ToUserName = toUserName;
		FromUserName = fromUserName;
		CreateTime = createTime;
		MsgType = msgType;
		this.event = event;
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

	public String getEvent() {
		return event;
	}

	public void setEvent(String event) {
		this.event = event;
	}

    
    
}
