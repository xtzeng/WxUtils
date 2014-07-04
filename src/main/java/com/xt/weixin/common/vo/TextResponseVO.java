package com.xt.weixin.common.vo;

/**
 * 文本类型
 * @author Administrator
 *
 */
public class TextResponseVO  implements WeixinVO{
	//开发者微信号
	private String ToUserName;	
	//发送方帐号（一个OpenID）
	private String FromUserName;
	// 消息创建时间 （整型）
	private long CreateTime;
	//text
	private String MsgType;	
	//文本消息内容
	private String Content;	
	
	
	
	
	
	public TextResponseVO(String toUserName, String fromUserName,
			long createTime, String msgType, String content) {
		super();
		ToUserName = toUserName;
		FromUserName = fromUserName;
		CreateTime = createTime;
		MsgType = msgType;
		Content = content;
	}
	
	public TextResponseVO() {
		
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
	public String getContent() {
		return Content;
	}
	public void setContent(String content) {
		Content = content;
	}
	
	@Override
	public String toString() {
		String str = "ToUserName:"+ToUserName+" "+"FromUserName:"+FromUserName+" "+"CreateTime:"+CreateTime+
				" "+"MsgType"+MsgType+" "+"Content"+Content;
		return str;
	}	 
}
