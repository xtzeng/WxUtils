package com.xt.weixin.common.vo;

/**
 * 图片类型
 * @author Administrator
 *
 */
public class ImageMsgVO  implements WeixinVO{
	//开发者微信号
	private String ToUserName;	
	//发送方帐号（一个OpenID）
	private String FromUserName;
	// 消息创建时间 （整型）
	private Integer CreateTime;
	//image
	private String MsgType;	
	//图片链接
	private String PicUrl;	 
	//图片消息媒体id，可以调用多媒体文件下载接口拉取数据。
	private String MediaId;	 
	//消息id，64位整型
	private Long MsgId;
	
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

	public Integer getCreateTime() {
		return CreateTime;
	}

	public void setCreateTime(Integer createTime) {
		CreateTime = createTime;
	}

	public String getMsgType() {
		return MsgType;
	}

	public void setMsgType(String msgType) {
		MsgType = msgType;
	}

	public String getPicUrl() {
		return PicUrl;
	}

	public void setPicUrl(String picUrl) {
		PicUrl = picUrl;
	}

	public String getMediaId() {
		return MediaId;
	}

	public void setMediaId(String mediaId) {
		MediaId = mediaId;
	}

	public Long getMsgId() {
		return MsgId;
	}

	public void setMsgId(Long msgId) {
		MsgId = msgId;
	}

	@Override
	public String toString() {
		String str = "ToUserName:"+ToUserName+" "+"FromUserName:"+FromUserName+" "+"CreateTime:"+CreateTime+
				" "+"MsgType"+MsgType+" "+"PicUrl:"+PicUrl+" "+"MediaId:"+MediaId+" "+"MsgId"+MsgId;
		return str;
	}	 
}
