package com.xt.weixin.common.vo;

import java.util.List;

/**
 * 图文类型
 * @author Forest
 *
 */
public class PictureTextResponseVO {
	
	private String ToUserName;
	private String FromUserName;
	private long CreateTime;
	private String MsgType;
	private int ArticleCount;
	private List<item> Articles;
	
	
	
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
	public int getArticleCount() {
		return ArticleCount;
	}
	public void setArticleCount(int articleCount) {
		ArticleCount = articleCount;
	}
	public List<item> getArticles() {
		return Articles;
	}
	public void setArticles(List<item> articles) {
		Articles = articles;
	}
	
	
	
	public class item{
		private String Title;
		private String Description;
		private String PicUrl;
		private String Url;
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
		public String getPicUrl() {
			return PicUrl;
		}
		public void setPicUrl(String picUrl) {
			PicUrl = picUrl;
		}
		public String getUrl() {
			return Url;
		}
		public void setUrl(String url) {
			Url = url;
		}
	}
	
}