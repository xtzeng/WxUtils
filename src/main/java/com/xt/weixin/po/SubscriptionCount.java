package com.xt.weixin.po;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;


@Table(name="subscription_count")
public class SubscriptionCount {


	@Id()
	@Column(name="id")
	private String id;

	@Column(name="name")
	private String name;
	
	@Column(name="parent_name")
	private String parentName;
	
	@Column(name="open_id")
	private String openId;
	
	@Column(name="click_time")
	private Timestamp clickTime;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getParentName() {
		return parentName;
	}

	public void setParentName(String parentName) {
		this.parentName = parentName;
	}

	public String getOpenId() {
		return openId;
	}

	public void setOpenId(String openId) {
		this.openId = openId;
	}

	public Timestamp getClickTime() {
		return clickTime;
	}

	public void setClickTime(Timestamp clickTime) {
		this.clickTime = clickTime;
	}


	
}
