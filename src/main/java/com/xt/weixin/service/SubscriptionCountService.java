package com.xt.weixin.service;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.UUID;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.xt.weixin.dao.SubscriptionCountDao;
import com.xt.weixin.po.SubscriptionCount;



@Service("subscriptionCountService")
public class SubscriptionCountService {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Resource(name="subscriptionCountDao")
	private SubscriptionCountDao subscriptionCountDao;
	
	/**
	 * @author 订阅号模块统计
	 * @param subscriptionCount
	 * @throws SQLException
	 */
	public void doSubscriptionCount(SubscriptionCount subscriptionCount) throws SQLException {
		
		if (subscriptionCount!=null) {
			//logger.debug("纪录统计开始……模块是"+subscriptionCount.getName()+"编号是："+subscriptionCount.getId()+"用户编号是："+subscriptionCount.getOpenId());
			//subscriptionCountDao.insert(subscriptionCount);
			//logger.debug("成功纪录点击数据！------->"+subscriptionCount.getName());
		}else {
			throw new SQLException();
		}
	}
	/**  订阅号模块统计
	 * @author qiaoli.lin
	 * @param name
	 * @param parentName
	 * @param openId
	 * @throws SQLException
	 */
	public void doSubscriptionCount(String name,String parentName,String openId) throws SQLException {
		
		SubscriptionCount subscriptionCount = new SubscriptionCount();
		subscriptionCount.setId(UUID.randomUUID().toString().replaceAll("-", ""));
		subscriptionCount.setName(name);
		subscriptionCount.setParentName(parentName);
		subscriptionCount.setOpenId(openId);
		Date now = new Date();
		Timestamp clickTime = new Timestamp(now.getTime());
		subscriptionCount.setClickTime(clickTime);
        //subscriptionCountDao.insert(subscriptionCount);
		
	}
}
