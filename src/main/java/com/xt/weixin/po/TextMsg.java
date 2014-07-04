package com.xt.weixin.po;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;



@Table(name="text_msg")
public class TextMsg  {

	@Id()
	@Column(name="id")
	private String id;
	
	@Column(name="type")
	private String type;
	
	@Column(name="title")
	private String title;
	
	@Column(name="description")
	private String description;
	
	@Column(name="pic_url")
	private String picUrl;
	
	@Column(name="url")
	private String url;
	
	@Column(name="seq")
	public String seq;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getPicUrl() {
		return picUrl;
	}
	public void setPicUrl(String picUrl) {
		this.picUrl = picUrl;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getSeq() {
		return seq;
	}
	public void setSeq(String seq) {
		this.seq = seq;
	}
	
	
}
